package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.ContexteParcoursCalcul;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

public class GestionAnomalies
{
  private static final int ETAT_EN_ANOMALIE = 1;
  private static final int ETAT_SANS_ANOMALIE = 0;
  private static final int ETAT_EN_ALERTE = 2;
  public static final Map LIB_ETAT = new HashMap();
  private static final int TAILLE_MAX_FORMAT_DATE = 10;
  
  static
  {
    LIB_ETAT.put(Integer.toString(1), "EN ANOMALIE");
    LIB_ETAT.put(Integer.toString(0), "SANS ANOMALIE");
    
    LIB_ETAT.put(Integer.toString(2), "EN ALERTE");
  }
  
  public static boolean ajouteAnomalie(Anomalie p_ano, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    boolean retour = false;
    if (p_ano.getDate() != null)
    {
      if (ContexteParcoursCalcul.estPersistant()) {
        try
        {
          boolean enregistrerNouvelleAnomalie = false;
          IndividuPbjcNcp individu = p_individu.getIndividuPbjcNcp();
          if (individu == null)
          {
            individu = new IndividuPbjcNcp();
            p_individu.setIndividuPbjcNcp(individu);
          }
          if ((individu.getDonneeAnomalieCalcul() == null) || (individu.getDonneeAnomalieCalcul().length() == 0)) {
            enregistrerNouvelleAnomalie = true;
          } else if ((individu.isAnomalieBloquant()) && (p_ano.estAnomalieBloquant()) && (Damj.parser(individu.getDonneeAnomalieCalcul()).estApres(p_ano.getDate()))) {
            enregistrerNouvelleAnomalie = true;
          } else if ((!individu.isAnomalieBloquant()) && (p_ano.estAnomalieBloquant())) {
            enregistrerNouvelleAnomalie = true;
          } else if ((!individu.isAnomalieBloquant()) && (!p_ano.estAnomalieBloquant()) && (Damj.parser(individu.getDonneeAnomalieCalcul()).estApres(p_ano.getDate()))) {
            enregistrerNouvelleAnomalie = true;
          }
          if (enregistrerNouvelleAnomalie)
          {
            if ("M02".equals(p_ano.getCode())) {
              p_individu.setDateBlocageIndemnisationConflitGAEC(p_ano.getDate());
            } else {
              p_individu.setDateBlocageIndemnisationConflitGAEC(null);
            }
            individu.setCodeAnomalieCalcul(p_ano.getCode());
            individu.setDonneeAnomalieCalcul(p_ano.getDate().toString().concat(p_ano.getDonnees()));
            if (p_ano.estAnomalieBloquant()) {
              individu.setEtatDerniereExecution(1);
            } else {
              individu.setEtatDerniereExecution(2);
            }
          }
        }
        catch (ParseException ex)
        {
          if (Log.isTraceActive(GestionAnomalies.class, Niveau.DEBUG)) {
            Log.ecritTrace(Niveau.DEBUG, GestionAnomalies.class, "ajouteAnomalie", ex);
          }
          retour = false;
        }
      }
    }
    else {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CAL_ABSENCE_DATE_ANOMALIE");
    }
    return retour;
  }
  
  public static void supprimeAnomalie(Damj p_dateDebutNettoyage, IndividuSpec p_individu)
    throws CoucheLogiqueException
  {
    if (ContexteParcoursCalcul.estPersistant())
    {
      if ((p_individu.getDateBlocageIndemnisationConflitGAEC() != null) && 
        (p_individu.getDateBlocageIndemnisationConflitGAEC().estApresOuCoincideAvec(p_dateDebutNettoyage.getDebutMois()))) {
        p_individu.setDateBlocageIndemnisationConflitGAEC(null);
      }
      IndividuPbjcNcp individu = p_individu.getIndividuPbjcNcp();
      if (individu != null) {
        if ((individu.getEtatDerniereExecution() == 1) || (individu.getEtatDerniereExecution() == 2)) {
          try
          {
            if (individu.isAnomalieBloquant())
            {
              Damj dateAno = Damj.parser(individu.getDonneeAnomalieCalcul().substring(0, 10));
              if (dateAno.estApresOuCoincideAvec(p_dateDebutNettoyage.getDebutMois()))
              {
                individu.setCodeAnomalieCalcul(null);
                individu.setDonneeAnomalieCalcul(null);
                individu.setEtatDerniereExecution(0);
              }
            }
            else
            {
              individu.setCodeAnomalieCalcul(null);
              individu.setDonneeAnomalieCalcul(null);
              individu.setEtatDerniereExecution(0);
            }
          }
          catch (ParseException ex)
          {
            if (Log.isTraceActive(GestionAnomalies.class, Niveau.DEBUG)) {
              Log.ecritTrace(Niveau.DEBUG, GestionAnomalies.class, "supprimeAnomalie", ex);
            }
          }
        }
      }
    }
  }
  
  private static void supprimeAnomalie(IndividuSpec p_individu)
  {
    IndividuPbjcNcp individu = p_individu.getIndividuPbjcNcp();
    individu.setDonneeAnomalieCalcul(null);
    individu.setCodeAnomalieCalcul(null);
    individu.setEtatDerniereExecution(0);
  }
  
  public static void nettoyerAnomalieSansDate(IndividuSpec p_individu)
  {
    IndividuPbjcNcp individu = p_individu.getIndividuPbjcNcp();
    if ((individu != null) && 
      (individu.getCodeAnomalieCalcul() != null) && (individu.getCodeAnomalieCalcul().equals("M01"))) {
      supprimeAnomalie(p_individu);
    }
  }
}

/* Location:
 * Qualified Name:     GestionAnomalies
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
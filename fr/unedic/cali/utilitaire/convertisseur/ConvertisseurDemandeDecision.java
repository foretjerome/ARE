package fr.unedic.cali.utilitaire.convertisseur;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurNeutre;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class ConvertisseurDemandeDecision
{
  public static Chronologie convertirDemandesEnDecisions(Chronologie p_demandes)
  {
    Chronologie chronologieRetour = new ChronologieDebuts();
    chronologieRetour.setComparateur(new ComparateurNeutre());
    if ((p_demandes != null) && (!p_demandes.estVide()) && ((p_demandes.premierElement() instanceof DemandeSpec))) {
      p_demandes.iterer();
    }
    while (p_demandes.encoreSuivant())
    {
      DemandeSpec demandeCourante = (DemandeSpec)p_demandes.elementSuivant();
      chronologieRetour.ajouter(convertirDemandeEnDecisions(demandeCourante));
      continue;
      
      chronologieRetour = p_demandes;
    }
    return chronologieRetour;
  }
  
  public static Chronologie convertirDemandeEnDecisions(DemandeSpec p_demande)
  {
    Chronologie chronologieRetour = new ChronologieDebuts();
    chronologieRetour.setComparateur(new ComparateurNeutre());
    if (p_demande != null)
    {
      List<?> dossiersExamen = p_demande.getListeDossiersExamen();
      if ((dossiersExamen != null) && (!dossiersExamen.isEmpty()) && (p_demande.estDecisionnee())) {
        for (int i = 0; i < dossiersExamen.size(); i++) {
          chronologieRetour.ajouter((Temporel)dossiersExamen.get(i));
        }
      }
    }
    return chronologieRetour;
  }
  
  public static Chronologie convertirDecisionsEnDemandes(Chronologie p_decisions)
  {
    Chronologie chronologieRetour = new ChronologieDebuts();
    chronologieRetour.setComparateur(new ComparateurNeutre());
    if ((p_decisions != null) && (!p_decisions.estVide()) && ((p_decisions.premierElement() instanceof DecisionSpec))) {
      p_decisions.iterer();
    }
    while (p_decisions.encoreSuivant())
    {
      DecisionSpec decisionCourante = (DecisionSpec)p_decisions.elementSuivant();
      chronologieRetour.ajouter(convertirDecisionEnDemande(decisionCourante));
      continue;
      
      chronologieRetour = p_decisions;
    }
    return chronologieRetour;
  }
  
  public static DemandeSpec convertirDecisionEnDemande(DecisionSpec p_decision)
  {
    DemandeSpec retour = null;
    if (p_decision != null) {
      retour = p_decision.getDemande();
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     ConvertisseurDemandeDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
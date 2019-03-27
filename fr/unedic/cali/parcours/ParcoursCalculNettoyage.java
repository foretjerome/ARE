package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionPersistance;
import fr.unedic.cali.calcul.outilsfonctionnels.GestionSuivi;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.GenerateurAIDEs;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.GenerateurPBJCs;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.GenerateurPrimes;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.persistance.util.ContextePersistance;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigrationCalcul;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Dom;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class ParcoursCalculNettoyage
  extends ParcoursCali
{
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    Dom dom = null;
    DomCalculNettoyage domCalculNettoyage = null;
    if (contexte == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT", "Le contexte ne doit pas être null", null);
    }
    dom = contexte.getDonnees();
    if (dom == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DOM", "Le Dom ne doit pas être null.", null);
    }
    if (!(dom instanceof DomCalculNettoyage)) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le type de Dom attendu est: DomCalculNettoyage", null);
    }
    domCalculNettoyage = (DomCalculNettoyage)dom;
    if (domCalculNettoyage.getDateDebutNettoyage() == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le DomCalculNettoyage doit contenir la date de debut de nettoyage", null);
    }
    if (domCalculNettoyage.getListeDemandes() == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le DomCalculNettoyage doit contenir une liste de demandes à nettoyer", null);
    }
  }
  
  public Resultat effectuerParcours(Contexte contexte)
    throws ApplicativeException
  {
    Resultat resultatRetourne = null;
    ContexteLocal contexteLocal = new ContexteLocal();
    try
    {
      ContexteParcoursCalcul contexteParcours = new ContexteParcoursCalcul();
      ContexteLocal.setContexte(contexteParcours, ContexteParcoursCalcul.class);
      contexteParcours.setModeTrace(contexte.isModeTrace());
      contexteParcours.setPersistant(ContextePersistance.isPersistant());
      resultatRetourne = super.effectuerParcours(contexte);
    }
    finally
    {
      contexteLocal.close();
    }
    return resultatRetourne;
  }
  
  public Resultat demarrer(Contexte contexte)
    throws CoucheLogiqueException
  {
    ResultatNettoyage retour = null;
    DomCalculNettoyage domCalculNettoyage = null;
    
    retour = new ResultatNettoyage();
    
    retour.setEtat(0);
    
    domCalculNettoyage = (DomCalculNettoyage)contexte.getDonnees();
    
    Damj dateDebutNettoyage = domCalculNettoyage.getDateDebutNettoyage();
    if (domCalculNettoyage.getContexteExecution() == 0)
    {
      dateDebutNettoyage = reajusterDateNettoyage(domCalculNettoyage.getIndividu(), domCalculNettoyage.getDateDebutNettoyage());
      
      OutilsMigrationCalcul.verificationEtCorrectionCalendrierAss(domCalculNettoyage.getIndividu());
      if (!GenerateurPBJCs.verifierCoherencePBJCs(dateDebutNettoyage, domCalculNettoyage.getIndividu())) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CAL_MISE_A_JOUR_PBJC_DROIT_NEUTRALISE", new Object[] { dateDebutNettoyage.toString() });
      }
    }
    GestionSuivi.nettoyerEnquetePbjcNcp(dateDebutNettoyage, domCalculNettoyage.getIndividu());
    
    GestionSuivi.nettoyerIndividuPbjcNcp(domCalculNettoyage.getIndividu(), dateDebutNettoyage);
    if (!domCalculNettoyage.getListeDemandes().isEmpty())
    {
      Iterator iterateurDemande = domCalculNettoyage.getListeDemandes().iterator();
      while (iterateurDemande.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iterateurDemande.next();
        if (demande.getListeDossiersExamen() != null)
        {
          Iterator iterateurDossierExamen = demande.getListeDossiersExamen().iterator();
          while (iterateurDossierExamen.hasNext())
          {
            DossierExamenSpec dossierExamen = (DossierExamenSpec)iterateurDossierExamen.next();
            if ((dossierExamen != null) && ((dossierExamen instanceof AttributionSpec)))
            {
              AttributionSpec attribution = (AttributionSpec)dossierExamen;
              if (!attribution.estMigreeEnSimplifiee())
              {
                GestionSuivi.nettoyerDroitPbjcNcp(attribution);
                
                GestionSuivi.nettoyerDispositifNcp(attribution);
                
                demande.setReexecutee(true);
              }
            }
          }
        }
      }
    }
    else
    {
      GestionSuivi.nettoyerDroitPbjcNcp(dateDebutNettoyage, domCalculNettoyage.getIndividu());
    }
    if ((domCalculNettoyage.getListeAttributionsInvalides() == null) || (domCalculNettoyage.getListeAttributionsInvalides().isEmpty()))
    {
      GenerateurPBJCs.nettoyerPBJCs(dateDebutNettoyage, domCalculNettoyage.getIndividu());
      GenerateurPrimes.nettoyerPrimesPBJCs(dateDebutNettoyage, domCalculNettoyage.getIndividu());
      GenerateurAIDEs.nettoyerAides(dateDebutNettoyage, domCalculNettoyage.getIndividu());
    }
    GestionPersistance.nettoyerExecutions(domCalculNettoyage.getListeDemandes());
    
    return retour;
  }
  
  private static Damj reajusterDateNettoyage(IndividuSpec individu, Damj dateNettoyage)
    throws CoucheLogiqueException
  {
    Damj dateReajustee = dateNettoyage;
    if (dateNettoyage != null) {
      dateReajustee = Damj.max(ParcoursCalculPilotage.determinerLendemainDjiMaxDroitNeutralise(individu, dateReajustee), dateReajustee);
    }
    dateReajustee = bornerDateNettoyageALaDateDeCalculAuPlusTot(individu, dateReajustee);
    
    return dateReajustee;
  }
  
  private static Damj bornerDateNettoyageALaDateDeCalculAuPlusTot(IndividuSpec individu, Damj dateNettoyage)
  {
    Iterator listeAttributions = individu.getListeAttributionsExecutables().iterator();
    while (listeAttributions.hasNext())
    {
      AttributionSpec a = (AttributionSpec)listeAttributions.next();
      if (a.estMigreeEnSimplifiee())
      {
        CalendrierExecutionCalculPeriodique cal = (CalendrierExecutionCalculPeriodique)a.getCalendrierExecutionCalcul();
        if ((cal != null) && (cal.getUTFigee() != null) && (dateNettoyage.estAvant(cal.getUTFigee().getDateFin().lendemain()))) {
          return cal.getUTFigee().getDateFin().lendemain();
        }
      }
    }
    return dateNettoyage;
  }
}

/* Location:
 * Qualified Name:     ParcoursCalculNettoyage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
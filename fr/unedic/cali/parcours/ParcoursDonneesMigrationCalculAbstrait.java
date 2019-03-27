package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.logique.exception.CoherenceException;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import java.util.Iterator;
import java.util.List;

public abstract class ParcoursDonneesMigrationCalculAbstrait
  extends ParcoursServiceAbstrait
{
  protected EtatAuDji getEtatAuDjiFigee(DemandeSpec p_demande)
    throws ApplicativeException
  {
    boolean trouve = false;
    Iterator itDossiersExamen = null;
    Object dossierExamen = null;
    AttributionSpec attribution = null;
    EtatAuDji etatAuDji = null;
    
    itDossiersExamen = p_demande.getListeDossiersExamen().iterator();
    while ((!trouve) && (itDossiersExamen.hasNext()))
    {
      dossierExamen = itDossiersExamen.next();
      if ((dossierExamen instanceof AttributionSpec))
      {
        attribution = (AttributionSpec)dossierExamen;
        etatAuDji = attribution.getCalendrierExecutionCalcul().getEtatAuDJI();
        if (etatAuDji.isEstFigee()) {
          trouve = true;
        }
      }
    }
    if (!trouve) {
      throw new CoherenceException("HG_PR_CALI_L_ERR_CONTEXTE", "Problème de lecture de l'état au DJI figée");
    }
    return etatAuDji;
  }
  
  protected UniteTraitement getUniteTraitementFigee(DemandeSpec p_demande)
    throws ApplicativeException
  {
    boolean trouve = false;
    Iterator itDossierExamens = null;Iterator itUniteTraitements = null;
    Object dossierExamen = null;
    AttributionSpec attribution = null;
    CalendrierExecutionCalculSpec calendrierCalcul = null;
    CalendrierExecutionCalculPeriodique calendrierCalculPeriodique = null;
    UniteTraitement uniteTraitement = null;
    
    itDossierExamens = p_demande.getListeDossiersExamen().iterator();
    while ((!trouve) && (itDossierExamens.hasNext()))
    {
      dossierExamen = itDossierExamens.next();
      if ((dossierExamen instanceof AttributionSpec))
      {
        attribution = (AttributionSpec)dossierExamen;
        calendrierCalcul = attribution.getCalendrierExecutionCalcul();
        if ((calendrierCalcul instanceof CalendrierExecutionCalculPeriodique))
        {
          calendrierCalculPeriodique = (CalendrierExecutionCalculPeriodique)calendrierCalcul;
          itUniteTraitements = calendrierCalculPeriodique.getListUniteTraitement().iterator();
          while ((!trouve) && (itUniteTraitements.hasNext()))
          {
            uniteTraitement = (UniteTraitement)itUniteTraitements.next();
            if (uniteTraitement.isEstFigee()) {
              trouve = true;
            }
          }
        }
      }
    }
    if (!trouve) {
      throw new CoherenceException("HG_PR_CALI_L_ERR_CONTEXTE", "Problème de lecture de l'unité de traitement figée");
    }
    return uniteTraitement;
  }
  
  public abstract Resultat demarrerParcours(Contexte paramContexte)
    throws ApplicativeException;
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursDonneesMigrationCalculAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
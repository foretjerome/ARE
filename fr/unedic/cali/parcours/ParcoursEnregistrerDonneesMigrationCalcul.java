package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.cre.CRModificationDonnee;
import fr.unedic.archi.logique.cre.CompteRenduEvtHandler;
import fr.unedic.archi.logique.cre.TypeModification;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.logique.exception.CoherenceException;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DureeIndemnisationAbstraite;
import fr.unedic.cali.dom.DureeRenouvellementAbstraite;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Resultat;
import java.math.BigDecimal;

public class ParcoursEnregistrerDonneesMigrationCalcul
  extends ParcoursDonneesMigrationCalculAbstrait
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    IndividuSpec individuCourant = getIndividu(p_contexte);
    if (individuCourant == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Individu absent du contexte");
    }
    String idDemande = getIdDemande(p_contexte);
    if (idDemande == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "Identifiant demande absente du contexte");
    }
    DemandeSpec demande = individuCourant.rechercherDemande(idDemande);
    if (demande == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Demande inexistante en base");
    }
    getDom(p_contexte).setDemande(demande);
  }
  
  private String getIdDemande(Contexte p_contexte)
  {
    return getDom(p_contexte).getIdDemande();
  }
  
  private DomEnregistrerDonneesMigrationCalcul getDom(Contexte p_contexte)
  {
    return (DomEnregistrerDonneesMigrationCalcul)p_contexte.getDonnees();
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    Resultat resultat = new Resultat();
    int reliquatIndemnisationAvant = 0;int reliquatIndemnisation = 0;
    int cumulMoisActiviteAvant = 0;int cumulMoisActivite = 0;
    int cumulHeuresActiviteAvant = 0;int cumulHeuresActivite = 0;
    
    resultat.setEtat(1);
    reliquatIndemnisation = getDom(contexte).getReliquatIndemnisation();
    cumulMoisActivite = getDom(contexte).getCumulMoisActiviteReduite();
    cumulHeuresActivite = getDom(contexte).getCumulHeuresActiviteReduite();
    
    DemandeSpec demande = getDom(contexte).getDemande();
    int numeroGamme = demande.getNumeroGamme();
    if (demande.estNeutraliseeCalcul())
    {
      EtatAuDji etatAuDji = getEtatAuDjiFigee(demande);
      
      Unite unite = etatAuDji.getReliquatDureeIndemnisation().getUnite();
      reliquatIndemnisationAvant = etatAuDji.getReliquatDureeIndemnisation().getValeurEntiere();
      etatAuDji.setReliquatDureeIndemnisation(new Quantite(reliquatIndemnisation, unite));
      if (numeroGamme == 1) {
        etatAuDji.setReliquatDureeIndemnisationAvecMaintien(new Quantite(reliquatIndemnisation, unite));
      }
      cumulMoisActiviteAvant = etatAuDji.getCumulMoisActiviteReduite();
      etatAuDji.setCumulMoisActiviteReduite(cumulMoisActivite);
      if (numeroGamme == 2) {
        etatAuDji.setCumulHeuresActiviteReduite(cumulHeuresActivite);
      }
    }
    else
    {
      UniteTraitement uniteTraitement = getUniteTraitementFigee(demande);
      
      reliquatIndemnisationAvant = enregistrerReliquatIndemnisationNonNeutraliseeCalcul(demande, uniteTraitement, reliquatIndemnisation);
      
      cumulMoisActiviteAvant = enregistrerCumulMoisActiviteNonNeutraliseeCalcul(demande, uniteTraitement, cumulMoisActivite);
      if (numeroGamme == 2) {
        cumulHeuresActiviteAvant = enregistrerCumulHeuresActiviteNonNeutraliseeCalcul(demande, uniteTraitement, cumulHeuresActivite);
      }
    }
    EvenementReexamen evtReexamen = new EvenementReexamen(getIndividu(contexte).getDdorkb(), "32");
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = FabriqueGestionnaireReexecution.getGestionnaire().executer(getIndividu(contexte), evtReexamen);
    
    OutilAjoutCremDalLiquidation.getInstance().ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), getIndividu(contexte));
    
    OutilFluxSigma.notifierSigma(getIndividu(contexte), resultatReexecution.getDemandesReliquidees(), false);
    
    genererCREM(contexte, reliquatIndemnisationAvant, reliquatIndemnisation, cumulMoisActiviteAvant, cumulMoisActivite, cumulHeuresActiviteAvant, cumulHeuresActivite);
    
    resultat.setEtat(0);
    
    return resultat;
  }
  
  private int enregistrerReliquatIndemnisationNonNeutraliseeCalcul(DemandeSpec p_demande, UniteTraitement p_uniteTraitement, int p_reliquatIndemnisation)
    throws ApplicativeException
  {
    int reliquatIndemnisationAvant = 0;
    ConstituantsIndemnisation constituantsIndemnisation = p_uniteTraitement.getConstituantsIndemnisationEnFinUT();
    DureeIndemnisationAbstraite dureeIndemnisation = null;
    DureeRenouvellementAbstraite dureeRenouvellement = null;
    Unite unite = null;
    Quantite quantiteCourante = null;
    switch (p_demande.getNumeroGamme())
    {
    case 1: 
      dureeIndemnisation = constituantsIndemnisation.getDureeIndemnisation();
      if (dureeIndemnisation.getQuantiteCourante() != null)
      {
        unite = dureeIndemnisation.getQuantiteCourante().getUnite();
        reliquatIndemnisationAvant = dureeIndemnisation.getQuantiteCourante().getValeurEntiere();
      }
      else
      {
        unite = Unite.getParCode("7");
      }
      quantiteCourante = new Quantite(p_reliquatIndemnisation, unite);
      dureeIndemnisation.setQuantiteCourante(quantiteCourante);
      break;
    case 2: 
      dureeRenouvellement = constituantsIndemnisation.getDureeRenouvellement();
      if (dureeRenouvellement.getQuantiteCourante() != null)
      {
        unite = dureeRenouvellement.getQuantiteCourante().getUnite();
        reliquatIndemnisationAvant = dureeRenouvellement.getQuantiteCourante().getValeurEntiere();
      }
      else
      {
        unite = Unite.getParCode("7");
      }
      quantiteCourante = new Quantite(p_reliquatIndemnisation, unite);
      dureeRenouvellement.setQuantiteCourante(quantiteCourante);
      break;
    default: 
      throw new CoherenceException("HG_PR_CALI_L_ERR_CONTEXTE", "Impossible de forcer post-migration pour un droit différent de la gamme ASU ou de la gamme SOL");
    }
    return reliquatIndemnisationAvant;
  }
  
  private int enregistrerCumulMoisActiviteNonNeutraliseeCalcul(DemandeSpec p_demande, UniteTraitement p_uniteTraitement, int p_cumulMoisActivite)
    throws ApplicativeException
  {
    int cumulMoisActiviteAvant = 0;
    ConstituantsCalculActiviteReduiteSpec constituantsActiviteReduite = null;
    int numeroGamme = p_demande.getNumeroGamme();
    if ((numeroGamme == 1) || (numeroGamme == 2))
    {
      constituantsActiviteReduite = p_uniteTraitement.getConstituantsCalculActiviteReduiteEnFinUT();
      cumulMoisActiviteAvant = constituantsActiviteReduite.getCumul();
      constituantsActiviteReduite.setCumul(p_cumulMoisActivite);
    }
    else
    {
      throw new CoherenceException("HG_PR_CALI_L_ERR_CONTEXTE", "Impossible de forcer post-migration pour un droit différent de la gamme ASU ou de la gamme SOL");
    }
    return cumulMoisActiviteAvant;
  }
  
  private int enregistrerCumulHeuresActiviteNonNeutraliseeCalcul(DemandeSpec p_demande, UniteTraitement p_uniteTraitement, int p_cumulHeuresActivite)
    throws ApplicativeException
  {
    int cumulHeuresActiviteAvant = 0;
    ConstituantsCalculActiviteReduiteSpec constituantsActiviteReduite = null;
    if (p_demande.getNumeroGamme() == 2)
    {
      constituantsActiviteReduite = p_uniteTraitement.getConstituantsCalculActiviteReduiteEnFinUT();
      cumulHeuresActiviteAvant = constituantsActiviteReduite.getCumulHeuresAR().intValue();
      constituantsActiviteReduite.setCumulHeuresAR(new BigDecimal(p_cumulHeuresActivite));
    }
    else
    {
      throw new CoherenceException("HG_PR_CALI_L_ERR_CONTEXTE", "Le forçage du cumul d'heure d'activité réduite est uniquemment possible pour la gamme solidarité");
    }
    return cumulHeuresActiviteAvant;
  }
  
  private void genererCREM(Contexte p_contexte, int p_reliquatIndemnisationAvant, int p_reliquatIndemnisationApres, int p_cumulMoisActiviteReduiteAvant, int p_cumulMoisActiviteReduiteApres, int p_cumulHeuresActiviteReduiteAvant, int p_cumulHeuresActiviteReduiteApres)
    throws fr.unedic.util.services.TechniqueException
  {
    ContexteService contexteService = getDom(p_contexte).getContexteService();
    String idIndividu = getIndividu(p_contexte).getIndividuId().getId();
    String idDemande = getIdDemande(p_contexte);
    if ((contexteService != null) && ("TP".equalsIgnoreCase(contexteService.getContexteEmission()))) {
      try
      {
        CRModificationDonnee crm1 = CompteRenduEvtHandler.creerCRModificationDonnee("Demandeur d Emploi", TypeModification.MODIFICATION, idIndividu);
        
        CRModificationDonnee crm2 = crm1.creerSousElement("Demande", TypeModification.MODIFICATION, idDemande);
        
        crm2.notifierModificationDonnee("Reliquat indemnisation", TypeModification.MODIFICATION, String.valueOf(p_reliquatIndemnisationAvant), String.valueOf(p_reliquatIndemnisationApres));
        
        crm2.notifierModificationDonnee("Cumul mois d activite reduite", TypeModification.MODIFICATION, String.valueOf(p_cumulMoisActiviteReduiteAvant), String.valueOf(p_cumulMoisActiviteReduiteApres));
        
        crm2.notifierModificationDonnee("Cumul heure d activite reduite", TypeModification.MODIFICATION, String.valueOf(p_cumulHeuresActiviteReduiteAvant), String.valueOf(p_cumulHeuresActiviteReduiteApres));
      }
      catch (fr.unedic.archi.commun.exception.TechniqueException e)
      {
        throw new fr.unedic.util.services.TechniqueException("HG_PR_CALI_L_INIT_COMPTE_RENDU", "Impossible d'initialiser le compte-rendu de suivi des modifications de l'individu", e);
      }
    }
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (p_individu != null) {
      p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
    }
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursEnregistrerDonneesMigrationCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
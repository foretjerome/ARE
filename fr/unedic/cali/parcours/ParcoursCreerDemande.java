package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitRbfAge08P01;
import fr.unedic.cali.dom.affectation.ProduitRbfMob07P01;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilCreationDemande;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.Collection;

public class ParcoursCreerDemande
  extends ParcoursServiceAbstrait
{
  private static final Damj DATE_MAX_CREATION_AFAF = new Damj(2014, 2, 20);
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    OutilTrace.tracerDebutParcours();
    
    ResultatCreerDemande resultat = new ResultatCreerDemande();
    resultat.setEtat(1);
    
    DomCreerDemande domCreerDemande = creationDemande(contexte);
    DemandeSpec demande = domCreerDemande.getDemandeSpec();
    IndividuSpec individu = domCreerDemande.getIndividu();
    
    ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(demande);
    
    OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
    outilAjoutCrem.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individu);
    
    notifierSigma(demande, resultatReexecution.getDemandesReliquidees(), individu);
    resultat.setEtat(0);
    resultat.setDomCreerDemande(domCreerDemande);
    
    OutilTrace.tracerFinParcours();
    return resultat;
  }
  
  protected DomCreerDemande creationDemande(Contexte contexte)
    throws ApplicativeException
  {
    DomCreerDemande domCreerDemande = (DomCreerDemande)contexte.getDonnees();
    String typeDemande = domCreerDemande.getTypeDemande();
    Damj dateDeDepot = domCreerDemande.getDateDepot();
    IndividuSpec individu = domCreerDemande.getIndividu();
    Damj dateDuJour = domCreerDemande.getContexteService().getDateTraitement();
    verifierPreCondition(typeDemande, dateDeDepot, dateDuJour);
    
    OutilFluxSigma.sauvegarderEtatDemandes(individu);
    
    DemandeSpec demande = OutilCreationDemande.creerDemande(typeDemande, dateDeDepot, individu, 0, domCreerDemande.getContexteService());
    domCreerDemande.setDemande(demande);
    individu.ajouterDemande(demande);
    return domCreerDemande;
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(DemandeSpec demande)
    throws ApplicativeException
  {
    return FabriqueGestionnaireReexecution.getGestionnaire().executerSurInstallationDemande(demande, new EvenementReexamen(demande.getDateRecherche(), "1"));
  }
  
  protected void notifierSigma(DemandeSpec demande, Collection<DemandeSpec> demandesNotifiees, IndividuSpec individu)
    throws ApplicativeException
  {
    if (!demandesNotifiees.contains(demande)) {
      demandesNotifiees.add(demande);
    }
    OutilFluxSigma.notifierSigma(individu, demandesNotifiees, false);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  private void dateDepotPosterieu(String typeDemande, Damj dateDeDepot, Damj dateDuJour)
    throws CoucheLogiqueException
  {
    if (("RBF_04".equals(typeDemande)) || ("RBF_03".equals(typeDemande)) || ("RBF_05".equals(typeDemande))) {
      if (dateDeDepot.estApres(dateDuJour)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_L_DEPOT_POSTERIEUR_DATE_JOUR");
      }
    }
  }
  
  private void creationAFAF(String typeDemande, Damj dateDeDepot)
    throws CoucheLogiqueException
  {
    if ((("RBF_01".equals(typeDemande)) || ("RBF_02".equals(typeDemande))) && (dateDeDepot.estApres(DATE_MAX_CREATION_AFAF))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_L_AIDES_NOUVELLES_MODALITE");
    }
  }
  
  private void ancienneModaliteeAide(String typeDemande, Damj dateDeDepot)
    throws CoucheLogiqueException
  {
    ProduitSpec produit = null;
    if ("RBF_04".equals(typeDemande)) {
      produit = ProduitRbfAge08P01.getInstance();
    }
    if ("RBF_03".endsWith(typeDemande)) {
      produit = ProduitRbfMob07P01.getInstance();
    }
    if ((produit != null) && (dateDeDepot.estAvant(produit.getPeriodeValidite().getDebut()))) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_L_AIDES_ANCIENNES_MODALITE");
    }
  }
  
  private void verifierPreCondition(String typeDemande, Damj dateDeDepot, Damj dateDuJour)
    throws CoucheLogiqueException
  {
    dateDepotPosterieu(typeDemande, dateDeDepot, dateDuJour);
    creationAFAF(typeDemande, dateDeDepot);
    ancienneModaliteeAide(typeDemande, dateDeDepot);
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursCreerDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
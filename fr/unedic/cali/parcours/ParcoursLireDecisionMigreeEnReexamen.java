package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.migration.FabriqueGrapheLiquidation;
import fr.unedic.cali.migration.GrapheLiquidationSpec;
import fr.unedic.cohabitation.sigma.migration.dom.DemandeMigreeAsuV1;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.Collection;

public class ParcoursLireDecisionMigreeEnReexamen
  extends ParcoursServiceAbstrait
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
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatLireDecisionMigreeEnReexamen resultat = new ResultatLireDecisionMigreeEnReexamen();
    
    DemandeSpec demande = getDom(p_contexte).getDemande();
    if ((!demande.estMigree()) || (!demande.estReexaminable()) || (!demande.estEnReExamen())) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "La demande ne correspond pas aux critères : seulement les demandes migrées en réexamen");
    }
    if (demande.getNumeroGamme() != 1) {
      throw new CoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DEMANDE_ASSURANCE", "La demande ne correspond pas aux critères : seulement les demandes d'Assurance migrées en réexamen et pas neutralisées");
    }
    ProduitSpec produit = demande.getDossierAffectation().getProduit();
    boolean classementAdministratif = demande.getClassementAdministratif() != null;
    int natureDecision = 0;
    if (!classementAdministratif)
    {
      DecisionSpec decision = (DecisionSpec)demande.getDossierAffectation().getDossierExamen();
      
      natureDecision = decision.getNatureDecision();
    }
    GrapheLiquidationSpec graphe = FabriqueGrapheLiquidation.creerGraphe(produit.getNom(), classementAdministratif, natureDecision);
    
    DemandeMigreeAsuV1 demandeMigreeAsuV1 = (DemandeMigreeAsuV1)graphe.lireDonnees(demande);
    
    resultat.setDemandeLue(demandeMigreeAsuV1);
    resultat.setEtat(0);
    
    return resultat;
  }
  
  private DomLireDecisionMigreeEnReexamen getDom(Contexte p_contexte)
  {
    return (DomLireDecisionMigreeEnReexamen)p_contexte.getDonnees();
  }
  
  private String getIdDemande(Contexte p_contexte)
  {
    return getDom(p_contexte).getIdDemande();
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (p_individu != null)
    {
      Collection typePeriodesGaec = new ArrayList();
      typePeriodesGaec.add("9");
      
      p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(1);
      p_individu.getDonneesChargementGaec().getAgregatGaec().setTypePeriodesGaec(typePeriodesGaec);
    }
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    AppelGaecReduit gaecReduit = p_individu.getDonneesChargementGaec().getAppelGaecReduit();
    
    controlerModeAppel(gaecReduit, 1);
    
    controlerTypePeriode(gaecReduit.getTypePeriodes(), "9");
  }
}

/* Location:
 * Qualified Name:     ParcoursLireDecisionMigreeEnReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
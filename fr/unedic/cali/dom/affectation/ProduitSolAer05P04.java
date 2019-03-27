package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.JustificationAppelGaecReduit;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.parcours.ResultatExecutionCalculSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public final class ProduitSolAer05P04
  extends ProduitAriAbstrait
  implements ProduitAriSpec, ProduitSolSpec
{
  private static final long serialVersionUID = 2211313140458128886L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.sol.aer05.p04.ProduitDelegue";
  private static final String LIB_COURT = "PTS";
  private static final String LIB_LONG = "PTS";
  private static final Damj DEBUT = new Damj(2015, 6, 1);
  private static final Damj FIN = new Damj(2017, 12, 31);
  private static ProduitSolAer05P04 instanceUnique = null;
  
  private ProduitSolAer05P04()
  {
    setLibelleCourt("PTS");
    setLibelleLong("PTS");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.sol.aer05.p04.ProduitDelegue"));
    
    setCode(69);
    setNomUnique("SOL_AER05_04");
  }
  
  public static ProduitSolAer05P04 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitSolAer05P04();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitSolAer05P04();
    }
    return instanceUnique;
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return getCode() == produit.getCode();
  }
  
  public boolean besoinDifferenceSystematique()
  {
    return true;
  }
  
  public boolean estActif(Damj date)
  {
    return false;
  }
  
  public void alimenterDonneesComplementairesDossierExamen(DossierExamenSpec examenDecisionne) {}
  
  public MontantBaseSpec calculerMontantAUneDate(AttributionSpec attribution, Damj calcul)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat constaterContexteExamen(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat constituerDateAttribution(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat constituerDateDebutIndemnisation(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat constituerDateFinIndemnisation(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat constituerDureeMaximale(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat constituerDureeReglementaire(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat constituerMontantBrut(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat constituerPremierJourIndemnisable(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat constituerRessources(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public void controlerContexteDonneesForceesPostLiquidation(Contexte contexte)
    throws ApplicativeException
  {}
  
  public Resultat creerGrapheDemandeAntecedent(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public Object creerObjectifExamen(int type)
  {
    return null;
  }
  
  public boolean determinerLancementObjectifReprise(Contexte contexte)
  {
    return false;
  }
  
  public int determinerNbJoursActiviteAcquisePourCourrierAss(IndividuSpec individu, AttributionSpec attributionasu)
    throws ApplicativeException
  {
    return 0;
  }
  
  public Resultat determinerOrdreObjectifs(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public boolean estAssDemandeExpresse(AttributionSpec attribution)
  {
    return false;
  }
  
  public JustificationAppelGaecReduit getDateDebutFenetrageAppelGaec(DemandeSpec demande)
  {
    return null;
  }
  
  public Damj getDjiTheoriqueAER(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public void initialiserDossierExamen(DossierAffectationSpec affecte) {}
  
  public void installerPrimes(DemandeSpec demande) {}
  
  public void miseAJourDossierExamen(DossierExamenSpec dossier, AttributionSpec attribution) {}
  
  public Damj recupererDJIParEpuisement(AttributionSpec attribution)
    throws ApplicativeException
  {
    return null;
  }
  
  public Quantite recupererMontantBrutJournalier(AttributionSpec attribution)
  {
    return null;
  }
  
  public int recupererNombreTrimestresRequis(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    return 0;
  }
  
  public Quantite recupererReliquat(AttributionSpec solidarite, Damj calcul)
    throws ApplicativeException
  {
    return null;
  }
  
  public ResultatExecutionCalculSpec retrouverDeterminationEtatDroit(AttributionSpec attribution, Damj etatDroit)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat traiterReliquat(ResultatExecutionCalculSpec executionCalcul, Damj etude)
    throws ApplicativeException
  {
    return null;
  }
  
  public void validerCapaParDefaut(Contexte contexte)
    throws ApplicativeException
  {}
  
  public Resultat verifierConditionActivite(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionAge(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionAgeDateAttributionTheorique(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionAptitudePhysique(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionAptitudePhysiqueDateAttributionTheorique(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionAutreProduit(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionChomageInvolontaire(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionCumulAutrePrestation(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionFaitGenerateur(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionNombreTrimestre(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionRechercheEmploi(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionRechercheEmploiDateAttributionTheorique(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionRessources(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public Resultat verifierConditionValiditeReliquat(Contexte contexte)
    throws ApplicativeException
  {
    return null;
  }
  
  public void verifierDepotTardifEtPrescription(Contexte contexte)
    throws ApplicativeException
  {}
  
  public void verifierPeriodesPourDeclencherAlertes(Contexte contexte)
    throws ApplicativeException
  {}
  
  public Resultat verifierConditionBeneficiaireAAH(Contexte contexte)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     ProduitSolAer05P04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
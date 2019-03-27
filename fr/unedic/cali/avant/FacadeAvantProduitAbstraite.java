package fr.unedic.cali.avant;

import fr.unedic.cali.calcul.TraitementUTAvant;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvant;
import fr.unedic.cali.calcul.dom.DureeConsommableAvant;
import fr.unedic.cali.calcul.dom.EvenementFinQuantiteDroit;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.UniteTraitementAvant;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodesPriseEnCompte;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePansMensuelEtSupra;
import fr.unedic.cali.parcours.ResultatAvant;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class FacadeAvantProduitAbstraite
  implements FacadeAvantProduitSpec
{
  public ResultatAvant executerAvant(AttributionSpec attribution, boolean estAvecPriseEnCompteEvenement, Damj dateEtude, boolean executionPersistante)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public ResultatAvant executerAvant(IndividuSpec individu, Damj dateAttribution, ProduitSpec produit, Collection delaisReport, Collection carences)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public ResultatAvant postTraitementResultatDeterminationEtatAvant(AttributionSpec attribution)
  {
    return null;
  }
  
  public void traitementPeriodesAlertantes(AttributionSpec attribution, ObjetChronoPeriode periode, PeriodeAnalyseSpec pa, ArretProduitAvecRaison arretProduitAvecRaison)
    throws CoucheLogiqueException
  {}
  
  public Collection<?> recupererCarrence(AttributionSpec attribution)
  {
    return null;
  }
  
  public Damj rechercherPremierJourAvant(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public ChronologiePeriodes recupererPeriodeGAEC(IndividuSpec individu, AttributionSpec attribution, Damj dateDebut, Damj dateFin)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public ArrayList mettreAJourCarrenceSurRevisionHorsPec(Collection pCarences, Damj pDernierJourAvant)
  {
    return null;
  }
  
  public QualificationPeriodes qualificationPeriodesPourAvant(ChronologiePeriodes chronologiePeriodes, AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public void mettreAJourCarencesSurResultatAvant(CalendrierExecutionAvant calendrierExecutionAvant, AttributionSpec attribution, Collection listeCarences) {}
  
  public Damj determinerPJIPoursuite(AttributionSpec attribution)
  {
    return null;
  }
  
  public int executerUtAvant(AttributionSpec attribution, CalendrierExecutionAvant calendrierAvant, Periode periodeUtAvant, ChronologiePeriodes chronologiePeriodes)
    throws CoucheLogiqueException
  {
    FacadeAvantProduitSpec facadeAvant = FacadeAvantProduitFactory.getInstance().getInstanceFacadeAvantProduit(attribution.getProduitExecution());
    return TraitementUTAvant.executerUtAvant(attribution, calendrierAvant, periodeUtAvant, chronologiePeriodes, facadeAvant);
  }
  
  public boolean estUnContexteDeChomageEnCoursDeSuspensionAvecRupture(AttributionSpec attribution, Damj dateEtude)
  {
    return false;
  }
  
  public boolean estUnContexteDeChomageEnCoursDeSuspension(AttributionSpec attribution)
  {
    return false;
  }
  
  public ResultatAvant construireResultatAvantPourChomageSansRupture(AttributionSpec attribution, Collection listeCarence)
  {
    return null;
  }
  
  public boolean estUnProduitGerantLaRefonte()
  {
    return false;
  }
  
  public boolean doitExecuterAvant(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    return true;
  }
  
  public Damj mettreAjourPjiSurPecESSI(AttributionSpec attribution, Damj finPec, Damj premierJourIndemnisable)
  {
    return null;
  }
  
  public void convertionCachets(ChronologiePeriodes chronologiePeriodes) {}
  
  public Damj determinerDateDepartAttribution(AttributionSpec attribution)
  {
    return null;
  }
  
  public ChronologiePeriodes traitementPeriodesSegmentantes(Periode periode, UniteTraitementAvant utAvant, ChronologiePeriodes periodesSegmentantes)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public void creerDureeIndemnisation(AttributionSpec attribution, CalendrierExecutionAvant calendrierAvant, UniteTraitementAvant utAvant) {}
  
  public ArretProduitAvecRaison traitementPeriodesInterruptivesDefinitives(PeriodesPriseEnCompte periodesPriseEnCompte, UniteTraitementAvant utAvant, AttributionSpec attribution, CalendrierExecutionAvant calendrierAvant)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public boolean traitementPeriodesSuspensivesPourDebutConsommationDelaiAttente(PeriodeAnalyseSpec pa, QualificationPeriodes qualificationPeriodes, Damj dateDebutConsommationDelaiAttente)
    throws CoucheLogiqueException
  {
    return false;
  }
  
  public Quantite simulerImputationEtImputerLaQuantite(Quantite quantiteAImputer, DureeConsommableAvant dureeConcommableAvant, UniteTraitementAvant utAvant, Damj dateDebutConsommation)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public void simulerImputationEtImputerLaQuantiteEtTerminerProduit(Quantite quantiteAImputer, PeriodeAnalyseSpec pa, DureeConsommableAvant dureeConcommableAvant, UniteTraitementAvant utAvant, Damj dateDebutConsommation, ArretProduitAvecRaison arretProduitAvecRaison, Damj dateAttribution)
    throws CoucheLogiqueException
  {}
  
  public boolean estUnCarenceGereeParLeProduit(DureeConsommableAvant dureeAvant)
  {
    return false;
  }
  
  public boolean estCarenceTerminantProduit(DureeConsommableAvant dureeAvant)
  {
    return dureeAvant.getTypeDureeConsommable() == 3;
  }
  
  public Quantite traitementActiviteReduiteSurUt(UniteTraitementAvant utAvant, ChronologiePeriodes chronoPeriodesAnalyse, Damj dateDebutConsoSurPa, AttributionSpec attribution, QualificationPeriodes qualificationPeriodes, DureeConsommableAvant dureeDelaiAttente)
    throws CoucheLogiqueException
  {
    return new QuantiteJour(BigDecimal.ZERO);
  }
  
  public boolean estUneCarenceSeConsommantApresDateAttribution(DureeConsommableAvant dureeAvant)
  {
    return false;
  }
  
  public boolean estUneCarenceSuspendueParSuspensif(DureeConsommableAvant dureeAvant)
  {
    return false;
  }
  
  public boolean doitTraiterLAR()
  {
    return false;
  }
  
  public EvenementFinQuantiteDroit creerEvtFinQteDroit(Damj dateFinQuantiteDroit, QuantiteDroitSpec quantiteDroitAImputer)
  {
    return null;
  }
  
  public void postTraitementQualification(UniteTraitementAvant utAvant, QualificationPeriodes qualificationPeriodes)
    throws CoucheLogiqueException
  {}
  
  public FiltreTemporel ajouterFiltrePeriodeSurUT()
  {
    return new FiltrePansMensuelEtSupra();
  }
}

/* Location:
 * Qualified Name:     FacadeAvantProduitAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
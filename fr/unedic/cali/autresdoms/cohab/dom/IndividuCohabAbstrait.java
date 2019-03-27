package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.dom.spec.IndividuCohabSpec;
import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodePensionInvaliditeChaineeSpec;
import fr.unedic.cali.autresdoms.cohab.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementActualisation;
import fr.unedic.cali.calcul.dom.periode.PeriodePension;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuChargementSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.PeriodeDroitAAH;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public abstract class IndividuCohabAbstrait
  implements IndividuCohabSpec, IndividuChargementSpec
{
  private static final String NOINDIVIDU = "COHAB";
  private IndividuIdSpec identifiant = null;
  private transient Damj dateNaissance = null;
  private transient Damj dateDeces = null;
  private transient Damj dernierJourAtteste = null;
  private transient boolean pensionCan = false;
  private transient Damj dateLiquidationRetraite = null;
  private transient Damj dateRetraiteAnticipe = null;
  private transient String motifRetraiteAnticipe = null;
  private transient Damj dateBlocageIndemnisation = null;
  private transient Collection donneesMoisActualisation = null;
  private transient Damj dateCentTrimestres = null;
  private transient String idDemandeSigmaTransfert = null;
  private transient boolean estBeneficiaireSapa;
  private transient boolean estBeneficiaireRsa;
  private transient boolean estExclusionIndividuelle;
  private transient boolean estAcompteNonSolde;
  private transient TrimestreRetraiteSpec trimestreRetraite = null;
  private transient Chronologie chronologiePecFusionneesFinCI = null;
  private transient Chronologie chronologiePecNonFusionneesFinCI = null;
  private transient Damj dateDispenseRechercheEmploi = null;
  private transient Collection demandes = null;
  private transient Collection demandesV1DAL = null;
  private transient Collection demandesV1RNV = null;
  private transient Damj datePeremptionTitreSejour = null;
  private transient String rsodDerniereOdSigmaNonMigree = null;
  private transient boolean estIndividuMigre;
  private transient String etatMigration;
  private transient Damj ddorkb;
  private transient Damj dateBlocageActualisation = null;
  protected transient ChronologiePeriodes chronoPeriodeEvtActualisation = new ChronologiePeriodes();
  protected transient ChronologiePeriodes chronoPensionsInvaliditeEtAvantagesVieillesse = new ChronologiePeriodes();
  protected transient ChronologiePeriodes chronoPensionsInvaliditeChainees = new ChronologiePeriodes();
  private transient Collection collectionDecisionsSuivi = null;
  private transient Hashtable ressourcesLieesADemande = new Hashtable();
  private transient Collection ressourcesDdte = null;
  private transient LireEnveloppeAidesResultat enveloppeAides = null;
  private transient boolean estCharge = false;
  private transient boolean estModifiable = false;
  private transient Damj djams = null;
  private transient boolean estAlerteAD;
  private Collection<PeriodeDroitAAH> listePeriodesDroitAAH = null;
  
  public IndividuCohabAbstrait() {}
  
  public IndividuCohabAbstrait(IndividuIdSpec individuIdSpec)
  {
    setIndividuId(individuIdSpec);
  }
  
  public IndividuIdSpec getIndividuId()
  {
    return identifiant;
  }
  
  public void setIndividuId(IndividuIdSpec pIdentifiant)
  {
    identifiant = pIdentifiant;
  }
  
  public Damj getDateNaissance()
  {
    return dateNaissance;
  }
  
  public void setDateNaissance(Damj pDateNaissance)
  {
    dateNaissance = pDateNaissance;
  }
  
  public Damj getDateDeces()
  {
    return dateDeces;
  }
  
  public void setDateDeces(Damj pDateDeces)
  {
    dateDeces = pDateDeces;
  }
  
  public Damj getDernierJourAtteste()
  {
    return dernierJourAtteste;
  }
  
  public void setDernierJourAtteste(Damj pDernierJourAtteste)
  {
    dernierJourAtteste = pDernierJourAtteste;
  }
  
  public boolean getPensionCan()
  {
    return pensionCan;
  }
  
  public void setPensionCan(boolean pPensionCan)
  {
    pensionCan = pPensionCan;
  }
  
  public Damj getDateLiquidationRetraite()
  {
    return dateLiquidationRetraite;
  }
  
  public void setDateLiquidationRetraite(Damj pDateLiquidationRetraite)
  {
    dateLiquidationRetraite = pDateLiquidationRetraite;
  }
  
  public Damj getDateBlocageIndemnisation()
  {
    return dateBlocageIndemnisation;
  }
  
  public void setDateBlocageIndemnisation(Damj pDateBlocageIndemnisation)
  {
    dateBlocageIndemnisation = pDateBlocageIndemnisation;
  }
  
  public Collection getListeDonneesMoisActualisation()
    throws CoucheLogiqueException
  {
    return donneesMoisActualisation;
  }
  
  public void setDonneesMoisActualisation(Collection pDonneesMoisActualisation)
  {
    donneesMoisActualisation = pDonneesMoisActualisation;
  }
  
  public Damj getDateCentTrimestres()
  {
    return dateCentTrimestres;
  }
  
  public Damj getDateDispenseRechercheEmploi()
  {
    Damj dateDispense = null;
    if (dateDispenseRechercheEmploi == null)
    {
      Chronologie chronologiePeriodesPEC = getChronologiePecFusionneesFinCI();
      Iterator iterateur = chronologiePeriodesPEC.iterer();
      while ((iterateur.hasNext()) && (dateDispense == null))
      {
        ObjetChronoPeriodePriseEnCharge objetChronoPeriodePriseEnCharge = (ObjetChronoPeriodePriseEnCharge)iterateur.next();
        
        dateDispense = objetChronoPeriodePriseEnCharge.getDateDispenseRechercheEmploi();
      }
    }
    dateDispense = dateDispenseRechercheEmploi;
    
    return dateDispense;
  }
  
  public void setDateCentTrimestres(Damj pDateCentTrimestres)
  {
    dateCentTrimestres = pDateCentTrimestres;
  }
  
  public void setDateDispenseRechercheEmploi(Damj pDateDispenseRechercheEmploi)
  {
    dateDispenseRechercheEmploi = pDateDispenseRechercheEmploi;
  }
  
  public String getIdDemandeSigmaBlocageTransfert()
    throws CoucheLogiqueException
  {
    return idDemandeSigmaTransfert;
  }
  
  public void setIdDemandeSigmaBlocageTransfert(String pIdDemandeSigma)
  {
    idDemandeSigmaTransfert = pIdDemandeSigma;
  }
  
  public boolean estBeneficiaireSapa()
  {
    return estBeneficiaireSapa;
  }
  
  public void setEstBeneficiaireSapa(boolean pEstBeneficiaireSapa)
  {
    estBeneficiaireSapa = pEstBeneficiaireSapa;
  }
  
  public boolean estExclusionIndividuelle()
  {
    return estExclusionIndividuelle;
  }
  
  public void setEstExclusionIndividuelle(boolean pEstExclusionIndividuelle)
  {
    estExclusionIndividuelle = pEstExclusionIndividuelle;
  }
  
  public boolean estAcompteNonSolde()
  {
    return estAcompteNonSolde;
  }
  
  public void setEstAcompteNonSolde(boolean pEstAcompteNonSolde)
  {
    estAcompteNonSolde = pEstAcompteNonSolde;
  }
  
  public String getRsodDerniereOdSigmaNonMigree()
  {
    return rsodDerniereOdSigmaNonMigree;
  }
  
  public void setRsodDerniereOdSigmaNonMigree(String pRsodDerniereOdSigmaNonMigree)
  {
    rsodDerniereOdSigmaNonMigree = pRsodDerniereOdSigmaNonMigree;
  }
  
  public TrimestreRetraiteSpec getTrimestreRetraite()
  {
    return trimestreRetraite;
  }
  
  public void setTrimestreRetraite(TrimestreRetraiteSpec pNombreTrimestreRetraite)
  {
    trimestreRetraite = pNombreTrimestreRetraite;
  }
  
  public Collection getDemandes()
  {
    return demandes;
  }
  
  public void setDemandes(Collection pDemandes)
  {
    demandes = pDemandes;
  }
  
  public Collection getDemandesV1DAL()
  {
    return demandesV1DAL;
  }
  
  public void setDemandesV1DAL(Collection pDemandesV1DAL)
  {
    demandesV1DAL = pDemandesV1DAL;
  }
  
  public Collection getDemandesV1RNV()
  {
    return demandesV1RNV;
  }
  
  public void setDemandesV1RNV(Collection pDemandesV1RNV)
  {
    demandesV1RNV = pDemandesV1RNV;
  }
  
  public ChronologiePeriodes getChronoPeriodeEvtActualisation()
  {
    return chronoPeriodeEvtActualisation;
  }
  
  public void setChronoPeriodeEvtActualisation(ChronologiePeriodes pChronoPeriodeEvtActualisation)
  {
    chronoPeriodeEvtActualisation = pChronoPeriodeEvtActualisation;
  }
  
  public Damj getDateBlocageActualisation()
    throws CoucheLogiqueException
  {
    return dateBlocageActualisation;
  }
  
  public void setDateBlocageActualisation(Damj pDateBlocageActualisation)
  {
    dateBlocageActualisation = pDateBlocageActualisation;
  }
  
  public ChronologiePeriodes getChronoPensionsInvaliditeEtAvantagesVieillesse()
  {
    return chronoPensionsInvaliditeEtAvantagesVieillesse;
  }
  
  public void setChronoPensionsInvaliditeEtAvantagesVieillesse(ChronologiePeriodes pChronoPensionsInvaliditeEtAvantagesVieillesse)
  {
    chronoPensionsInvaliditeEtAvantagesVieillesse = pChronoPensionsInvaliditeEtAvantagesVieillesse;
  }
  
  public ChronologiePeriodes getChronoPensionsInvaliditeChainees()
  {
    return chronoPensionsInvaliditeChainees;
  }
  
  public void setChronoPensionsInvaliditeChainees(ChronologiePeriodes pChronoPensionsInvaliditeChainees)
  {
    chronoPensionsInvaliditeChainees = pChronoPensionsInvaliditeChainees;
  }
  
  public Collection getDecisionsSuivi()
  {
    return collectionDecisionsSuivi;
  }
  
  public void setDecisionsSuivi(Collection collection)
  {
    collectionDecisionsSuivi = collection;
  }
  
  public void setRessourcesLieesADemande(String numeroDemande, Ressources ressources)
  {
    ressourcesLieesADemande.put(numeroDemande, ressources);
  }
  
  public Ressources getRessourcesLieesADemande(String numeroAllocataire, String numeroDemande, String typeSegment)
  {
    return (Ressources)ressourcesLieesADemande.get(numeroDemande);
  }
  
  public Collection getRessourcesDdte()
  {
    return ressourcesDdte;
  }
  
  public void setRessourcesDdte(Collection pRessourcesDdte)
  {
    ressourcesDdte = pRessourcesDdte;
  }
  
  public abstract FormulaireSpec getFormulaire(fr.unedic.cali.dom.DemandeSpec paramDemandeSpec);
  
  public LireEnveloppeAidesResultat getEnveloppeAides(CriteresCaliServiceEnveloppe criteres)
    throws CoucheLogiqueException
  {
    return enveloppeAides;
  }
  
  public void setEnveloppeAides(LireEnveloppeAidesResultat enveloppe)
  {
    enveloppeAides = enveloppe;
  }
  
  public DureeCalendaire getAgeALaDate(Damj date)
  {
    Damj dateNaissanceIndividu = getDateNaissance();
    if (date == null) {
      throw new IllegalArgumentException("Paramètre date null: calcul de l'âge de l'individu [" + getIndividuId() + "] impossible.");
    }
    if (dateNaissanceIndividu == null)
    {
      if (Log.isTraceActive(IndividuImplNonPersistant.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, IndividuImplNonPersistant.class, "getAgeALaDate", "Date de naissance non initialisée: calcul de l'âge de l'individu [" + getIndividuId() + "] impossible.");
      }
    }
    else if (date.estAvant(dateNaissanceIndividu))
    {
      if (Log.isTraceActive(IndividuImplNonPersistant.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, IndividuImplNonPersistant.class, "getAgeALaDate", "Date passée en paramètre antérieure à date de naissance: calcul de l'âge de l'individu [" + getIndividuId() + "] impossible.");
      }
    }
    else {
      return dateNaissanceIndividu.getAge(date);
    }
    return null;
  }
  
  public Chronologie getChronologiePecFusionneesFinCI()
  {
    return chronologiePecFusionneesFinCI;
  }
  
  public void setChronologiePecFusionneesFinCI(Chronologie pChronologiePecFusionneesFinCI)
  {
    chronologiePecFusionneesFinCI = pChronologiePecFusionneesFinCI;
  }
  
  public Chronologie getChronologiePecNonFusionneesFinCI()
  {
    return chronologiePecNonFusionneesFinCI;
  }
  
  public void setChronologiePecNonFusionneesFinCI(Chronologie pChronologiePecNonFusionneesFinCI)
  {
    chronologiePecNonFusionneesFinCI = pChronologiePecNonFusionneesFinCI;
  }
  
  public abstract IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException;
  
  public boolean estCharge()
  {
    return estCharge;
  }
  
  public void setEstCharge(boolean pEstCharge)
  {
    estCharge = pEstCharge;
  }
  
  public boolean estModifiable()
  {
    return estModifiable;
  }
  
  public void setEstModifiable(boolean modifiable)
  {
    estModifiable = modifiable;
  }
  
  public String getNomIndividu()
  {
    return "COHAB";
  }
  
  public boolean estIndividuMigre()
  {
    return estIndividuMigre;
  }
  
  public void setIndividuMigre(boolean pEstIndividuMigre)
  {
    estIndividuMigre = pEstIndividuMigre;
  }
  
  public String getEtatMigration()
  {
    return etatMigration;
  }
  
  public void setEtatMigration(String pEtatMigration)
  {
    etatMigration = pEtatMigration;
  }
  
  public Damj getDdorkb()
  {
    return ddorkb;
  }
  
  public void setDdorkb(Damj pDdorkb)
  {
    ddorkb = pDdorkb;
  }
  
  public boolean ajouterPeriodeEvtActualisation(PeriodeEvenementActualisation periode)
  {
    if (periode == null) {
      throw new IllegalArgumentException("Paramètre période d'évènement d'actualisation null: ajoût de période d'évènement d'actualisation sur l'individu [" + getIndividuId() + "] impossible.");
    }
    chronoPeriodeEvtActualisation.ajouter(periode);
    
    return false;
  }
  
  public boolean ajouterPensionsInvaliditeEtAvantagesVieillesse(PeriodePension periode)
  {
    if (periode == null) {
      throw new IllegalArgumentException("Paramètre période de pension d'invalidité ou d'avantage vieillesse null: ajoût de période de pension d'invalidité ou d'avantage vieillesse sur l'individu [" + getIndividuId() + "] impossible.");
    }
    chronoPensionsInvaliditeEtAvantagesVieillesse.ajouter(periode);
    
    return false;
  }
  
  public boolean ajouterPensionInvaliditeChainee(PeriodePensionInvaliditeChaineeSpec periode)
  {
    if (periode == null) {
      throw new IllegalArgumentException("Paramètre période de pension d'invalidité chainee null: ajoût de période de pension d'invalidité chainee sur l'individu [" + getIndividuId() + "] impossible.");
    }
    chronoPensionsInvaliditeChainees.ajouter(periode);
    
    return false;
  }
  
  public String toString()
  {
    StringBuilder chaineRetour = new StringBuilder();
    
    chaineRetour.append("Individu :" + getIndividuId() + "\n");
    chaineRetour.append("   date de naissance: " + getDateNaissance() + "\n");
    if (getTrimestreRetraite() != null) {
      chaineRetour.append("   Trimestre retraite: " + getTrimestreRetraite() + "\n");
    }
    if (getPensionCan()) {
      chaineRetour.append("  Titulaire pension Can : " + getPensionCan() + "\n");
    }
    if (getDateLiquidationRetraite() != null) {
      chaineRetour.append("   Date demande liquidation retraite : " + getDateLiquidationRetraite() + "\n");
    }
    return chaineRetour.toString();
  }
  
  public Collection getDemandesV1(String sType)
  {
    Collection listeDemandesCojac = null;
    if (sType.equals("DAL")) {
      listeDemandesCojac = getDemandesV1DAL();
    } else if (sType.equals("RNV")) {
      listeDemandesCojac = getDemandesV1RNV();
    }
    return listeDemandesCojac;
  }
  
  public fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec getUneDemandeV1(String idDemande)
  {
    fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec demandeV1 = null;
    
    Collection listeDemandesCojac = getDemandesV1DAL();
    if (listeDemandesCojac != null)
    {
      if (getDemandesV1RNV() != null) {
        listeDemandesCojac.addAll(getDemandesV1RNV());
      }
    }
    else {
      listeDemandesCojac = getDemandesV1RNV();
    }
    if (listeDemandesCojac != null)
    {
      Iterator iterDemandesCojac = listeDemandesCojac.iterator();
      while (iterDemandesCojac.hasNext())
      {
        fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec resultat = (fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec)iterDemandesCojac.next();
        if (resultat.getIdentifiantDemande().equals(idDemande)) {
          demandeV1 = resultat;
        }
      }
    }
    return demandeV1;
  }
  
  public Damj getDatePeremptionTitreSejour()
  {
    return datePeremptionTitreSejour;
  }
  
  public void setDatePeremptionTitreSejour(Damj pDatePeremptionTitreSejour)
  {
    datePeremptionTitreSejour = pDatePeremptionTitreSejour;
  }
  
  public Damj getDjams()
  {
    return djams;
  }
  
  public void setDjams(Damj pDjams)
  {
    djams = pDjams;
  }
  
  public boolean estAlerteAD()
  {
    return estAlerteAD;
  }
  
  public void setEstAlerteAD(boolean pEstAlerteAD)
  {
    estAlerteAD = pEstAlerteAD;
  }
  
  public boolean estBeneficiaireRsa()
  {
    return estBeneficiaireRsa;
  }
  
  public void setEstBeneficiaireRsa(boolean pEstBeneficiaireRsa)
  {
    estBeneficiaireRsa = pEstBeneficiaireRsa;
  }
  
  public Damj getDateRetraiteAnticipe()
  {
    return dateRetraiteAnticipe;
  }
  
  public void setDateRetraiteAnticipe(Damj dateRetraiteAnticipe)
  {
    this.dateRetraiteAnticipe = dateRetraiteAnticipe;
  }
  
  public String getMotifRetraiteAnticipe()
  {
    return motifRetraiteAnticipe;
  }
  
  public void setMotifRetraiteAnticipe(String motifRetraiteAnticipe)
  {
    this.motifRetraiteAnticipe = motifRetraiteAnticipe;
  }
  
  public Collection<PeriodeDroitAAH> getListePeriodesDroitAAH()
  {
    return listePeriodesDroitAAH;
  }
  
  public void setListePeriodesDroitAAH(Collection<PeriodeDroitAAH> listePeriodesDroitAAH)
  {
    this.listePeriodesDroitAAH = listePeriodesDroitAAH;
  }
}

/* Location:
 * Qualified Name:     IndividuCohabAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
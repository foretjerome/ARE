package fr.unedic.cali.autresdoms.cohab.dom.spec;

import fr.unedic.cali.autresdoms.cohab.dom.CriteresCaliServiceEnveloppe;
import fr.unedic.cali.autresdoms.cohab.dom.LireEnveloppeAidesResultat;
import fr.unedic.cali.autresdoms.cohab.dom.Ressources;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementActualisation;
import fr.unedic.cali.calcul.dom.periode.PeriodePension;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuDomaineSpec;
import fr.unedic.cali.dom.PeriodeDroitAAH;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import java.util.Collection;

public abstract interface IndividuCohabSpec
  extends IndividuDomaineSpec
{
  public abstract boolean ajouterPeriodeEvtActualisation(PeriodeEvenementActualisation paramPeriodeEvenementActualisation);
  
  public abstract boolean ajouterPensionsInvaliditeEtAvantagesVieillesse(PeriodePension paramPeriodePension);
  
  public abstract boolean ajouterPensionInvaliditeChainee(PeriodePensionInvaliditeChaineeSpec paramPeriodePensionInvaliditeChaineeSpec);
  
  public abstract DureeCalendaire getAgeALaDate(Damj paramDamj);
  
  public abstract Damj getDateNaissance();
  
  public abstract Damj getDateDeces();
  
  public abstract Damj getDateDispenseRechercheEmploi();
  
  public abstract Damj getDernierJourAtteste();
  
  public abstract Damj getDateLiquidationRetraite();
  
  public abstract Damj getDateRetraiteAnticipe();
  
  public abstract String getMotifRetraiteAnticipe();
  
  public abstract Damj getDateBlocageActualisation()
    throws CoucheLogiqueException;
  
  public abstract Collection getListeDonneesMoisActualisation()
    throws CoucheLogiqueException;
  
  public abstract String getIdDemandeSigmaBlocageTransfert()
    throws CoucheLogiqueException;
  
  public abstract Damj getDateBlocageIndemnisation();
  
  public abstract Damj getDateCentTrimestres();
  
  public abstract boolean getPensionCan();
  
  public abstract TrimestreRetraiteSpec getTrimestreRetraite();
  
  public abstract Chronologie getChronologiePecFusionneesFinCI();
  
  public abstract Chronologie getChronologiePecNonFusionneesFinCI();
  
  public abstract ChronologiePeriodes getChronoPeriodeEvtActualisation()
    throws CoucheLogiqueException;
  
  public abstract ChronologiePeriodes getChronoPensionsInvaliditeEtAvantagesVieillesse()
    throws CoucheLogiqueException;
  
  public abstract ChronologiePeriodes getChronoPensionsInvaliditeChainees()
    throws CoucheLogiqueException;
  
  public abstract void setChronoPeriodeEvtActualisation(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract void setChronoPensionsInvaliditeEtAvantagesVieillesse(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract void setChronoPensionsInvaliditeChainees(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract void setDateNaissance(Damj paramDamj);
  
  public abstract void setDateDeces(Damj paramDamj);
  
  public abstract void setDernierJourAtteste(Damj paramDamj);
  
  public abstract void setDateLiquidationRetraite(Damj paramDamj);
  
  public abstract void setDateRetraiteAnticipe(Damj paramDamj);
  
  public abstract void setMotifRetraiteAnticipe(String paramString);
  
  public abstract void setDateBlocageIndemnisation(Damj paramDamj);
  
  public abstract void setIdDemandeSigmaBlocageTransfert(String paramString);
  
  public abstract void setDateBlocageActualisation(Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract void setDateCentTrimestres(Damj paramDamj);
  
  public abstract void setDateDispenseRechercheEmploi(Damj paramDamj);
  
  public abstract void setPensionCan(boolean paramBoolean);
  
  public abstract void setTrimestreRetraite(TrimestreRetraiteSpec paramTrimestreRetraiteSpec);
  
  public abstract void setChronologiePecFusionneesFinCI(Chronologie paramChronologie);
  
  public abstract void setChronologiePecNonFusionneesFinCI(Chronologie paramChronologie);
  
  public abstract boolean estBeneficiaireSapa();
  
  public abstract void setEstBeneficiaireSapa(boolean paramBoolean);
  
  public abstract boolean estBeneficiaireRsa();
  
  public abstract void setEstBeneficiaireRsa(boolean paramBoolean);
  
  public abstract boolean estExclusionIndividuelle();
  
  public abstract void setEstExclusionIndividuelle(boolean paramBoolean);
  
  public abstract boolean estAcompteNonSolde();
  
  public abstract void setEstAcompteNonSolde(boolean paramBoolean);
  
  public abstract void setRessourcesLieesADemande(String paramString, Ressources paramRessources);
  
  public abstract Ressources getRessourcesLieesADemande(String paramString1, String paramString2, String paramString3);
  
  public abstract Collection getRessourcesDdte();
  
  public abstract void setRessourcesDdte(Collection paramCollection);
  
  public abstract LireEnveloppeAidesResultat getEnveloppeAides(CriteresCaliServiceEnveloppe paramCriteresCaliServiceEnveloppe)
    throws CoucheLogiqueException;
  
  public abstract void setEnveloppeAides(LireEnveloppeAidesResultat paramLireEnveloppeAidesResultat);
  
  public abstract FormulaireSpec getFormulaire(DemandeSpec paramDemandeSpec);
  
  public abstract Collection getDecisionsSuivi()
    throws CoucheLogiqueException;
  
  public abstract void setDecisionsSuivi(Collection paramCollection);
  
  public abstract String getRsodDerniereOdSigmaNonMigree();
  
  public abstract void setRsodDerniereOdSigmaNonMigree(String paramString);
  
  public abstract void setDonneesMoisActualisation(Collection paramCollection);
  
  public abstract boolean estIndividuMigre();
  
  public abstract void setIndividuMigre(boolean paramBoolean);
  
  public abstract String getEtatMigration();
  
  public abstract void setEtatMigration(String paramString);
  
  public abstract Damj getDdorkb();
  
  public abstract void setDdorkb(Damj paramDamj);
  
  public abstract Damj getDatePeremptionTitreSejour();
  
  public abstract void setDatePeremptionTitreSejour(Damj paramDamj);
  
  public abstract Damj getDjams();
  
  public abstract void setDjams(Damj paramDamj);
  
  public abstract boolean estAlerteAD();
  
  public abstract void setEstAlerteAD(boolean paramBoolean);
  
  public abstract Collection<PeriodeDroitAAH> getListePeriodesDroitAAH();
  
  public abstract void setListePeriodesDroitAAH(Collection<PeriodeDroitAAH> paramCollection);
}

/* Location:
 * Qualified Name:     IndividuCohabSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
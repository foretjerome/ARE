package fr.unedic.cali.dom;

import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.pe.cali.crem.outils.CacheCrem;
import fr.unedic.cali.autresdoms.cohab.dom.CriteresCaliServiceEnveloppe;
import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.cohab.dom.LireEnveloppeAidesResultat;
import fr.unedic.cali.autresdoms.cohab.dom.Ressources;
import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodePensionInvaliditeChaineeSpec;
import fr.unedic.cali.autresdoms.cohab.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.cali.autresdoms.d12i.dom.DemandeInstruction;
import fr.unedic.cali.autresdoms.d12i.dom.IndividuInstructionAbstrait;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.IndividuGaecAbstrait;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeGaec;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.autresdoms.ga.services.LA2K;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementActualisation;
import fr.unedic.cali.calcul.dom.periode.PeriodePension;
import fr.unedic.cali.calcul.outilsfonctionnels.DeterminerPopulationIndividu;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.FiltreDebutPbjcApresDate;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.pnds.CachePndsSpectacle;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.cali.migration.outilsfonctionnels.OutilsMigration;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateDeclenchementDemandeDecroissante;
import fr.unedic.cali.outilsfonctionnels.FusionPeriodeActiviteGaecCali;
import fr.unedic.cali.outilsfonctionnels.OutilAttribution;
import fr.unedic.cali.outilsfonctionnels.TraceTrackerEnModeEmission;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeActiviteAutreQueFormationNonAssimilable;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeIndemnisationCaf;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodePensionInvalidite;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.fabriques.FabriqueDeterminationPeriodeIndemnisation;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieDeterminationPeriodeIndemnisationSpec;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public abstract class IndividuAbstrait
  implements IndividuSpec
{
  protected IndividuCaliAbstrait individuCali;
  protected IndividuCohabAbstrait individuCohab;
  protected IndividuGaecAbstrait individuGA;
  protected IndividuInstructionAbstrait individuInstruction;
  protected DonneesChargementGaec donneesChargementGaec;
  private IndividuIdSpec identifiant;
  private boolean estDejaCree;
  private int contexteExecution = 0;
  private ContexteService contexteService;
  private Hashtable individuAccedes = new Hashtable();
  private List<TraceTrackerEnModeEmission> listeTraceTrackerEnModeEmission;
  private boolean effectuerMiseAJourPeriodesCaliVersGaec = true;
  private List<ObjetMetierCrem> listeCrem = new ArrayList();
  
  public IndividuAbstrait() {}
  
  public IndividuAbstrait(IndividuIdSpec id)
  {
    identifiant = id;
    identifiant.setIndividu(this);
  }
  
  public IndividuIdSpec getIndividuId()
  {
    return identifiant;
  }
  
  public void setIndividuId(IndividuIdSpec pIdentifiant)
  {
    if (pIdentifiant == null)
    {
      identifiant = null;
      individuGA.setIndividuId(null);
      individuCali.setIndividuId(null);
      individuCohab.setIndividuId(null);
    }
    else
    {
      IndividuIdSpec id = pIdentifiant;
      id.setIndividu(this);
      identifiant = id;
      individuGA.setIndividuId(id);
      individuCali.setIndividuId(id);
      individuCohab.setIndividuId(id);
    }
  }
  
  public void ajouterDemande(DemandeSpec demande)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.ajouterDemande(demande);
  }
  
  public void supprimerDemande(DemandeSpec demande)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.supprimerDemande(demande);
  }
  
  public ChronologieDebuts getChronoDemandes()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandes();
  }
  
  public ChronologieDebuts getChronoDemandesNonTriees()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandesNonTriees();
  }
  
  public Collection getDemandes()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDemandes();
  }
  
  public void setChronoDemandes(ChronologieDebuts chrono)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setChronoDemandes(chrono);
  }
  
  public void setChronoPeriodesCalcul(ChronologiePeriodesGaec chrono)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setChronoPeriodesCalcul(chrono);
  }
  
  public int getCodeTransfert()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getCodeTransfert();
  }
  
  public ChronologieDebuts getChronoDemandeAssurance()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandeAssurance();
  }
  
  public ChronologieDebuts getChronoDemandeFormation()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandeFormation();
  }
  
  public ChronologieDebuts getChronoDemandeSolidarite()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandeSolidarite();
  }
  
  public ChronologieDebuts getChronoDemandeRemboursementFrais()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandeRemboursementFrais();
  }
  
  public ChronologieDebuts getChronoDemandeIncitationReclassement()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandeIncitationReclassement();
  }
  
  public ChronologieDebuts getChronoDemandeAri()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandeAri();
  }
  
  public ChronologieDebuts getChronoDemandePreRetraite()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandePreRetraite();
  }
  
  public ChronologieDebuts getChronoDemandeDeces()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandeDeces();
  }
  
  public DemandeSpec rechercherDemande(String idDemande, String codeGamme)
  {
    verifierIndividuCharge(individuCali);
    
    DemandeSpec demande = individuCali.rechercherDemande(idDemande, codeGamme);
    if (demande != null) {
      demande.setDemandeur(this);
    }
    return demande;
  }
  
  public DemandeSpec rechercherDemande(String idDemande)
  {
    verifierIndividuCharge(individuCali);
    
    return individuCali.rechercherDemande(idDemande);
  }
  
  public void ajouterPeriodeActiviteSalariee(ActiviteSalarie periodeActivite)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.ajouterPeriodeActiviteSalariee(periodeActivite);
  }
  
  public void supprimerPeriodeActiviteSalariee(ActiviteSalarie periodeActivite)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.supprimerPeriodeActiviteSalariee(periodeActivite);
  }
  
  public Collection getListePeriodesActiviteSalariee()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getListePeriodesActiviteSalariee();
  }
  
  public void setListePeriodesActiviteSalariee(Collection listePeriodesActiviteSalariee)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setListePeriodesActiviteSalariee(listePeriodesActiviteSalariee);
  }
  
  public void remplacerCollectionActiviteSalarie(Collection collectionACopier)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.remplacerCollectionActiviteSalarie(collectionACopier);
  }
  
  public IndicateursGeneriques getIndicateursGeneriques()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getIndicateursGeneriques();
  }
  
  public Collection<LA2K> getListeLA2K()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getListeLA2K();
  }
  
  public boolean getIndicateurEnregistrerQualifPeriodes()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getIndicateurEnregistrerQualifPeriodes();
  }
  
  public void setIndicateurEnregistrerQualifPeriodes(boolean val)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setIndicateurEnregistrerQualifPeriodes(val);
  }
  
  public int getEstMigree()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getEstMigree();
  }
  
  public void setEstMigree(int estMigree)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setEstMigree(estMigree);
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnel()
  {
    ChronologiePeriodes chronoPeriodesGa = getChronoPeriodePasseProfessionnelSansFiltrageDNJ();
    
    FiltreTemporel filtre = new FiltrePeriodeActiviteAutreQueFormationNonAssimilable();
    chronoPeriodesGa = (ChronologiePeriodes)chronoPeriodesGa.copier(filtre);
    
    return chronoPeriodesGa;
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnelSansFiltrageDNJ()
  {
    verifierIndividuCharge(individuCali);
    verifierIndividuCharge(individuGA);
    
    ChronologiePeriodes chronoPeriodesGa = individuGA.getChronoPeriodePasseProfessionnel();
    
    effectuerMiseAJourQualificationPeriode();
    
    return chronoPeriodesGa;
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnelLiquidation()
  {
    verifierIndividuCharge(individuGA);
    
    ChronologiePeriodes chronoPeriodesGa = individuGA.getChronoPeriodePasseProfessionnelLiquidation();
    
    effectuerMiseAJourQualificationPeriode();
    
    return chronoPeriodesGa;
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnelPourLiquidationSansFiltrageDNJ()
  {
    verifierIndividuCharge(individuGA);
    
    ChronologiePeriodes chronoPeriodesGa = individuGA.getChronoPeriodePasseProfessionnelPourLiquidationSansFiltrageDNJ();
    
    effectuerMiseAJourQualificationPeriode();
    
    return chronoPeriodesGa;
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnelEcartees()
  {
    verifierIndividuCharge(individuGA);
    
    return individuGA.getChronoPeriodePasseProfessionnelEcartees();
  }
  
  public void setChronoPeriodePasseProfessionnelLiquidation(ChronologiePeriodes periodePasseProfessionnelleLiq)
  {
    verifierIndividuModifiable(individuCali);
    individuGA.setChronoPeriodePasseProfessionnelLiquidation(periodePasseProfessionnelleLiq);
  }
  
  public void setChronoPeriodePasseProfessionnelSansFiltrageDNJ(ChronologiePeriodes periodePasseProfessionnelle)
  {
    verifierIndividuModifiable(individuCali);
    individuGA.setChronoPeriodePasseProfessionnelSansFiltrageDNJ(periodePasseProfessionnelle);
  }
  
  public boolean ajouterPeriodePasseProfessionnel(PeriodeGaecSpec periode)
  {
    verifierIndividuModifiable(individuCali);
    return individuGA.ajouterPeriodePasseProfessionnel(periode);
  }
  
  public void enregistrerLA2K(IndividuSpec individu, Damj dateDebutExecution, ContexteService pContexteService, int pContexteExecution)
  {
    individuGA.enregistrerLA2K(individu, dateDebutExecution, pContexteService, pContexteExecution);
  }
  
  public Collection getActionsFormation()
  {
    return individuGA.getActionsFormation();
  }
  
  public Collection getActionsFormationRps()
  {
    return individuGA.getActionsFormationRps();
  }
  
  public Collection<PeriodeGaec> getActionFormationRpsRbf()
  {
    return individuGA.getActionFormationRpsRbf();
  }
  
  public Chronologie getChronologiePecFusionneesFinCI()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getChronologiePecFusionneesFinCI();
  }
  
  public Chronologie getChronologiePecNonFusionneesFinCI()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getChronologiePecNonFusionneesFinCI();
  }
  
  public void setChronologiePecFusionneesFinCI(Chronologie chronologiePecFusionneesFinCI)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setChronologiePecFusionneesFinCI(chronologiePecFusionneesFinCI);
  }
  
  public void setChronologiePecNonFusionneesFinCI(Chronologie chronologiePecNonFusionneesFinCI)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setChronologiePecNonFusionneesFinCI(chronologiePecNonFusionneesFinCI);
  }
  
  public Damj getDateLiquidationRetraite()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDateLiquidationRetraite();
  }
  
  public Damj getDateRetraiteAnticipe()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDateRetraiteAnticipe();
  }
  
  public String getMotifRetraiteAnticipe()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getMotifRetraiteAnticipe();
  }
  
  public void setDateLiquidationRetraite(Damj dateLiquidationRetraite)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDateLiquidationRetraite(dateLiquidationRetraite);
  }
  
  public void setDateRetraiteAnticipe(Damj dateRetraiteAnticipe)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDateRetraiteAnticipe(dateRetraiteAnticipe);
  }
  
  public void setMotifRetraiteAnticipe(String dateMotifRetraite)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setMotifRetraiteAnticipe(dateMotifRetraite);
  }
  
  public Damj getDateCentTrimestres()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDateCentTrimestres();
  }
  
  public Damj getDateDispenseRechercheEmploi()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDateDispenseRechercheEmploi();
  }
  
  public void setDateCentTrimestres(Damj dateCentTrimestres)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDateCentTrimestres(dateCentTrimestres);
  }
  
  public void setDateDispenseRechercheEmploi(Damj dateDispenseRechercheEmploi)
  {
    verifierIndividuCharge(individuCohab);
    individuCohab.setDateDispenseRechercheEmploi(dateDispenseRechercheEmploi);
  }
  
  public Damj getDateBlocageActualisation()
    throws CoucheLogiqueException
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDateBlocageActualisation();
  }
  
  public Collection getListeDonneesMoisActualisation()
    throws CoucheLogiqueException
  {
    return individuCohab.getListeDonneesMoisActualisation();
  }
  
  public void setDonneesMoisActualisation(Collection donneesMoisActualisation)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDonneesMoisActualisation(donneesMoisActualisation);
  }
  
  public void setDateBlocageActualisation(Damj dateBlocageActualisation)
    throws CoucheLogiqueException
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDateBlocageActualisation(dateBlocageActualisation);
  }
  
  public Damj getDateBlocageIndemnisation()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDateBlocageIndemnisation();
  }
  
  public void setDateBlocageIndemnisation(Damj dateBlocageIndemnisation)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDateBlocageIndemnisation(dateBlocageIndemnisation);
  }
  
  public Damj getDateBlocageIndemnisationConflitGAEC()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDateBlocageIndemnisationConflitGAEC();
  }
  
  public void setDateBlocageIndemnisationConflitGAEC(Damj dateBlocageIndemnisationConflitGAEC)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setDateBlocageIndemnisationConflitGAEC(dateBlocageIndemnisationConflitGAEC);
  }
  
  public Damj getDateExecutionDifferee()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDateExecutionDifferee();
  }
  
  public void setDateExecutionDifferee(Damj dateExecutionDifferee)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setDateExecutionDifferee(dateExecutionDifferee);
  }
  
  public String getIdDemandeSigmaBlocageTransfert()
    throws CoucheLogiqueException
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getIdDemandeSigmaBlocageTransfert();
  }
  
  public void setIdDemandeSigmaBlocageTransfert(String idDemandeSigma)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setIdDemandeSigmaBlocageTransfert(idDemandeSigma);
  }
  
  public boolean getPensionCan()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getPensionCan();
  }
  
  public void setPensionCan(boolean pensionCan)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setPensionCan(pensionCan);
  }
  
  public TrimestreRetraiteSpec getTrimestreRetraite()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getTrimestreRetraite();
  }
  
  public void setTrimestreRetraite(TrimestreRetraiteSpec nombreTrimestreRetraite)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setTrimestreRetraite(nombreTrimestreRetraite);
  }
  
  public DureeCalendaire getAgeALaDate(Damj date)
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getAgeALaDate(date);
  }
  
  public Damj getDateNaissance()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDateNaissance();
  }
  
  public Damj getDateDeces()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDateDeces();
  }
  
  public void setDateNaissance(Damj dateNaissance)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDateNaissance(dateNaissance);
  }
  
  public void setDateDeces(Damj dateDeces)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDateDeces(dateDeces);
  }
  
  public Damj getDernierJourAtteste()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDernierJourAtteste();
  }
  
  public void setDernierJourAtteste(Damj dernierJourAtteste)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDernierJourAtteste(dernierJourAtteste);
  }
  
  public boolean estAcompteNonSolde()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.estAcompteNonSolde();
  }
  
  public void setEstAcompteNonSolde(boolean estAcompteNonSolde)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setEstAcompteNonSolde(estAcompteNonSolde);
  }
  
  public boolean estBeneficiaireSapa()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.estBeneficiaireSapa();
  }
  
  public void setEstBeneficiaireSapa(boolean estBeneficiaireSapa)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setEstBeneficiaireSapa(estBeneficiaireSapa);
  }
  
  public boolean estBeneficiaireRsa()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.estBeneficiaireRsa();
  }
  
  public void setEstBeneficiaireRsa(boolean estBeneficiaireRsa)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setEstBeneficiaireRsa(estBeneficiaireRsa);
  }
  
  public boolean estExclusionIndividuelle()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.estExclusionIndividuelle();
  }
  
  public void setEstExclusionIndividuelle(boolean estExclusionIndividuelle)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setEstExclusionIndividuelle(estExclusionIndividuelle);
  }
  
  public String getRsodDerniereOdSigmaNonMigree()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getRsodDerniereOdSigmaNonMigree();
  }
  
  public void setRsodDerniereOdSigmaNonMigree(String rsodDerniereOdSigmaNonMigree)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setRsodDerniereOdSigmaNonMigree(rsodDerniereOdSigmaNonMigree);
  }
  
  public void setRessourcesLieesADemande(String numeroDemande, Ressources ressources)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setRessourcesLieesADemande(numeroDemande, ressources);
  }
  
  public Ressources getRessourcesLieesADemande(String numeroAllocataire, String numeroDemande, String typeSegment)
  {
    return individuCohab.getRessourcesLieesADemande(numeroAllocataire, numeroDemande, typeSegment);
  }
  
  public void setRessourcesDdte(Collection ressourcesDdte)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setRessourcesDdte(ressourcesDdte);
  }
  
  public Collection getRessourcesDdte()
  {
    return individuCohab.getRessourcesDdte();
  }
  
  public LireEnveloppeAidesResultat getEnveloppeAides(CriteresCaliServiceEnveloppe criteres)
    throws CoucheLogiqueException
  {
    return individuCohab.getEnveloppeAides(criteres);
  }
  
  public void setEnveloppeAides(LireEnveloppeAidesResultat enveloppe)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setEnveloppeAides(enveloppe);
  }
  
  public FormulaireSpec getFormulaire(DemandeSpec demande)
  {
    return individuCohab.getFormulaire(demande);
  }
  
  public ChronologiePeriodes getChronoPeriodeEvtActualisation()
    throws CoucheLogiqueException
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getChronoPeriodeEvtActualisation();
  }
  
  public void setChronoPeriodeEvtActualisation(ChronologiePeriodes chronologiePeriodes)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setChronoPeriodeEvtActualisation(chronologiePeriodes);
  }
  
  public ChronologiePeriodes getChronoPensionsInvaliditeEtAvantagesVieillesse()
    throws CoucheLogiqueException
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getChronoPensionsInvaliditeEtAvantagesVieillesse();
  }
  
  public void setChronoPensionsInvaliditeEtAvantagesVieillesse(ChronologiePeriodes chronologiePeriodes)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setChronoPensionsInvaliditeEtAvantagesVieillesse(chronologiePeriodes);
  }
  
  public ChronologiePeriodes getChronoPensionsInvaliditeChainees()
    throws CoucheLogiqueException
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getChronoPensionsInvaliditeChainees();
  }
  
  public void setChronoPensionsInvaliditeChainees(ChronologiePeriodes chronologiePeriodes)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setChronoPensionsInvaliditeChainees(chronologiePeriodes);
  }
  
  public boolean ajouterPeriodeEvtActualisation(PeriodeEvenementActualisation periode)
  {
    verifierIndividuModifiable(individuCohab);
    return individuCohab.ajouterPeriodeEvtActualisation(periode);
  }
  
  public boolean ajouterPensionsInvaliditeEtAvantagesVieillesse(PeriodePension periode)
  {
    verifierIndividuModifiable(individuCohab);
    return individuCohab.ajouterPensionsInvaliditeEtAvantagesVieillesse(periode);
  }
  
  public boolean ajouterPensionInvaliditeChainee(PeriodePensionInvaliditeChaineeSpec periode)
  {
    verifierIndividuModifiable(individuCohab);
    return individuCohab.ajouterPensionInvaliditeChainee(periode);
  }
  
  public Collection getDecisionsSuivi()
    throws CoucheLogiqueException
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDecisionsSuivi();
  }
  
  public void setDecisionsSuivi(Collection collection)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDecisionsSuivi(collection);
  }
  
  public Collection<PeriodeDroitAAH> getListePeriodesDroitAAH()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getListePeriodesDroitAAH();
  }
  
  public void setListePeriodesDroitAAH(Collection<PeriodeDroitAAH> listePeriodesDroitAAH)
  {
    verifierIndividuCharge(individuCohab);
    individuCohab.setListePeriodesDroitAAH(listePeriodesDroitAAH);
  }
  
  public Collection getDemandesV1(String type)
  {
    return individuCohab.getDemandesV1(type);
  }
  
  public fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec getUneDemandeV1(String idDemande)
  {
    return individuCohab.getUneDemandeV1(idDemande);
  }
  
  public PeriodeGaecSpec rechercherPeriodePasseProfessionnel(String identifiantPeriode)
  {
    Iterator iter;
    if (identifiantPeriode != null)
    {
      ChronologiePeriodes chronoPasseProfessionnelCourante = getChronoPeriodePasseProfessionnel();
      if ((chronoPasseProfessionnelCourante != null) && (!chronoPasseProfessionnelCourante.estVide())) {
        for (iter = chronoPasseProfessionnelCourante.iterer(); iter.hasNext();)
        {
          PeriodeGaecSpec periodePasseProfessionnelRecherchee = (PeriodeGaecSpec)iter.next();
          if (periodePasseProfessionnelRecherchee.getIdentifiant().equalsIgnoreCase(identifiantPeriode)) {
            return periodePasseProfessionnelRecherchee;
          }
        }
      }
    }
    return null;
  }
  
  public List getListeDemandesSigmaDecisionneesApresOuCoincide(DemandeSpec pDemande)
  {
    List listeDemandesApres = new ArrayList();
    
    int prioriteDemande = pDemande.getGamme().getPriorite();
    Damj dateDeclenchement = pDemande.getDateDeclenchementExamen();
    if (dateDeclenchement != null)
    {
      ChronologieDebuts listeDemandes = getChronoDemandes();
      Iterator iterateurDemandes = listeDemandes.iterer();
      while (iterateurDemandes.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
        if ((demande.getEvenementReferenceExamen().getTypeSegment().equals("LE1D")) && ((demande.estDecisionnee()) || (demande.getClassementAdministratif() != null)) && (demande.getDateDeclenchementExamen().estApresOuCoincideAvec(dateDeclenchement))) {
          listeDemandesApres.add(demande);
        }
      }
      listeDemandesApres.remove(pDemande);
      
      iterateurDemandes = listeDemandesApres.iterator();
      while (iterateurDemandes.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
        if ((demande.getDateDeclenchementExamen().equals(dateDeclenchement)) && (demande.getGamme().getPriorite() >= prioriteDemande)) {
          iterateurDemandes.remove();
        }
      }
    }
    return listeDemandesApres;
  }
  
  public DecisionSpec getDecisionAvant(DemandeSpec pDemande, FiltreTemporel filtreTemporel)
  {
    Chronologie chronologieDemandes = getChronoDemandes();
    
    FiltresTemporel filtresTemporel = new FiltresTemporel();
    if ((chronologieDemandes != null) && (filtreTemporel != null)) {
      filtresTemporel.ajouterFiltre(filtreTemporel);
    }
    if ((chronologieDemandes != null) && (pDemande != null)) {
      filtresTemporel.ajouterFiltre(new FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite(pDemande.getDateFinAbonnement(), pDemande));
    }
    if (chronologieDemandes != null)
    {
      chronologieDemandes.setComparateur(new ComparateurSurDateDeclenchementDemandeDecroissante());
      chronologieDemandes = chronologieDemandes.copier(filtresTemporel);
    }
    if (chronologieDemandes != null)
    {
      Iterator iterateurDemandes = chronologieDemandes.iterer();
      while (iterateurDemandes.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
        if ((demande.getListeDossiersExamen() != null) && (!demande.getListeDossiersExamen().isEmpty()) && (demande.estDecisionnee())) {
          return (DecisionSpec)demande.getListeDossiersExamen().get(0);
        }
      }
    }
    return null;
  }
  
  public List getListeAttributionsExecutablesAvant(Damj dateEffetMaximalePourAttributions)
  {
    List listeDecisions = new ArrayList();
    
    ChronologieDebuts listeDemandes = getChronoDemandes();
    if (listeDemandes != null)
    {
      Iterator iterateurDemandes = listeDemandes.iterer();
      while (iterateurDemandes.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
        
        Iterator iterateurDossiersExamen = demande.getListeDossiersExamen().iterator();
        while (iterateurDossiersExamen.hasNext())
        {
          DossierExamenSpec dossierExamenSpec = (DossierExamenSpec)iterateurDossiersExamen.next();
          if ((dossierExamenSpec instanceof AttributionSpec))
          {
            AttributionSpec attributionSpec = (AttributionSpec)dossierExamenSpec;
            if ((attributionSpec.getDateEffet() != null) && (attributionSpec.getDateEffet().estAvantOuCoincideAvec(dateEffetMaximalePourAttributions)) && (attributionSpec.estExecutable()))
            {
              listeDecisions.add(dossierExamenSpec);
              
              OutilAttribution.getInstance().traiterAttributionLiee(listeDecisions, dossierExamenSpec);
            }
          }
        }
      }
    }
    return listeDecisions;
  }
  
  public List getListeAttributionsExecutablesAvant(DecisionSpec pDecision)
  {
    Chronologie chrono = OutilRecherche.rechercherDecisionsPrecedentes(getChronoDemandes(), pDecision, new FiltreAttributionSurDecisions());
    
    return getListeAttributionsExecutablesAvant(chrono);
  }
  
  private List getListeAttributionsExecutablesAvant(Chronologie chrono)
  {
    List listeDecisions = new ArrayList();
    ListIterator it = chrono.iterer();
    while (it.hasNext())
    {
      AttributionSpec attribution = (AttributionSpec)it.next();
      if (attribution.estExecutable())
      {
        listeDecisions.add(attribution);
        OutilAttribution.getInstance().traiterAttributionLiee(listeDecisions, attribution);
      }
    }
    return listeDecisions;
  }
  
  public List getListeAttributionsExecutablesAvant(DemandeSpec pDecision)
  {
    Chronologie chrono = OutilRecherche.rechercherDecisionsPrecedentes(getChronoDemandes(), pDecision, new FiltreAttributionSurDecisions());
    
    return getListeAttributionsExecutablesAvant(chrono);
  }
  
  public List getListeAttributionsASUPendantPeriode(Periode periode)
    throws CoucheLogiqueException
  {
    return getListeAttributionsPourGammeChevauchantPeriode(periode, Damj.NUIT_DES_TEMPS, "ASU");
  }
  
  public List getListeAttributionsChevauchantPeriode(Periode periode, Damj dateExamen)
    throws CoucheLogiqueException
  {
    return getListeAttributionsPourGammeChevauchantPeriode(periode, dateExamen, null);
  }
  
  private List getListeAttributionsPourGammeChevauchantPeriode(Periode pPeriode, Damj dateExamen, String nomGamme)
    throws CoucheLogiqueException
  {
    List listeDecisions = new ArrayList();
    
    Collection listeDemandes = getDemandes();
    if (listeDemandes != null)
    {
      Iterator iterateurDemandes = listeDemandes.iterator();
      while (iterateurDemandes.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
        if ((demande.estDecisionnee()) && (!demande.estEnReExamen()) && ((nomGamme == null) || (nomGamme.equals(demande.getGamme().getNomUnique()))))
        {
          Iterator iterateurDossiersExamen = demande.getListeDossiersExamen().iterator();
          while (iterateurDossiersExamen.hasNext())
          {
            DossierExamenSpec dossierExamenSpec = (DossierExamenSpec)iterateurDossiersExamen.next();
            if ((dossierExamenSpec instanceof AttributionSpec))
            {
              AttributionSpec attribution = (AttributionSpec)dossierExamenSpec;
              if ((attribution.estValidee()) && ((attribution.getDateAttribution() == null) || ((attribution.getDateAttribution() != null) && (attribution.getDateAttribution().estAvantOuCoincideAvec(pPeriode.getFin())))))
              {
                CritereStrategie criteres = new CritereStrategie();
                criteres.setDatePivot(dateExamen);
                StrategieDeterminationPeriodeIndemnisationSpec strategie = (StrategieDeterminationPeriodeIndemnisationSpec)FabriqueDeterminationPeriodeIndemnisation.getInstance().getStrategie(criteres);
                
                Periode periode = strategie.recupererPeriodeIndemnisation(attribution);
                if (pPeriode.chevauche(periode))
                {
                  listeDecisions.add(dossierExamenSpec);
                  
                  OutilAttribution.getInstance().traiterAttributionLiee(listeDecisions, dossierExamenSpec);
                }
              }
            }
          }
        }
      }
    }
    if (listeDecisions.isEmpty()) {
      return null;
    }
    return listeDecisions;
  }
  
  public List getListeAttributionsASUCompetenceFinanciere()
  {
    List listeDecisions = new ArrayList();
    
    Periode periode = new Periode();
    
    Chronologie listeDemandesASU = getChronoDemandeAssurance();
    if (listeDemandesASU != null)
    {
      listeDemandesASU.iterer();
      while (listeDemandesASU.encoreSuivant())
      {
        DemandeSpec demande = (DemandeSpec)listeDemandesASU.elementSuivant();
        if ((demande.estDecisionnee()) && (!demande.estEnReExamen()) && (demande.getGamme().getNomUnique().equals("ASU")))
        {
          Iterator iterateurDossiersExamen = demande.getListeDossiersExamen().iterator();
          while (iterateurDossiersExamen.hasNext())
          {
            DossierExamenSpec dossierExamenSpec = (DossierExamenSpec)iterateurDossiersExamen.next();
            if ((dossierExamenSpec instanceof AttributionSpec))
            {
              AttributionSpec attribution = (AttributionSpec)dossierExamenSpec;
              
              periode.setDebut(attribution.getDateAttribution());
              periode.setFin(attribution.getDateAttribution());
              
              CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
              if ((calendrier != null) && (calendrier.getDernierJourIndemnisable() != null)) {
                periode.setFin(calendrier.getDernierJourIndemnisable());
              }
              ProduitSpec produitAttribution = attribution.getProduit();
              if (produitAttribution.estCompetenceFinanciereSecteurPublic(attribution))
              {
                listeDecisions.add(dossierExamenSpec);
                
                OutilAttribution.getInstance().traiterAttributionLiee(listeDecisions, dossierExamenSpec);
              }
            }
          }
        }
      }
    }
    return listeDecisions;
  }
  
  public List getListeDemandesSP()
  {
    List listeDecisions = new ArrayList();
    
    Chronologie listeDemandesASU = getChronoDemandeAssurance();
    if (listeDemandesASU != null)
    {
      listeDemandesASU.iterer();
      while (listeDemandesASU.encoreSuivant())
      {
        listeDemandesASU.iterer();
        while (listeDemandesASU.encoreSuivant())
        {
          DemandeSpec demande = (DemandeSpec)listeDemandesASU.elementSuivant();
          if ((demande != null) && (demande.getClassementAdministratif() != null) && (demande.getClassementAdministratif().getTypeClassement() != null) && (demande.getClassementAdministratif().getTypeClassement().equalsIgnoreCase("SP"))) {
            listeDecisions.add(demande);
          }
        }
      }
    }
    return listeDecisions;
  }
  
  public List getListeAttributionsExecutables()
  {
    return getListeAttributionsExecutablesAvant(Damj.FIN_DES_TEMPS);
  }
  
  public List getListeAttributionsNeutralisees()
  {
    List listeDecisions = new ArrayList();
    
    ChronologieDebuts listeDemandes = getChronoDemandes();
    if (listeDemandes != null)
    {
      Iterator iterateurDemandes = listeDemandes.iterer();
      while (iterateurDemandes.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
        
        Iterator iterateurDossiersExamen = demande.getListeDossiersExamen().iterator();
        while (iterateurDossiersExamen.hasNext())
        {
          DossierExamenSpec dossierExamenSpec = (DossierExamenSpec)iterateurDossiersExamen.next();
          if ((dossierExamenSpec instanceof AttributionSpec))
          {
            AttributionSpec attributionSpec = (AttributionSpec)dossierExamenSpec;
            if (attributionSpec.estNeutralise()) {
              listeDecisions.add(dossierExamenSpec);
            }
          }
        }
      }
    }
    return listeDecisions;
  }
  
  public List getListeAttributionsNonFigee()
  {
    List listeDecisions = new ArrayList();
    
    ChronologieDebuts listeDemandes = getChronoDemandes();
    if (listeDemandes != null)
    {
      Iterator iterateurDemandes = listeDemandes.iterer();
      while (iterateurDemandes.hasNext())
      {
        DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
        
        Iterator iterateurDossiersExamen = demande.getListeDossiersExamen().iterator();
        while (iterateurDossiersExamen.hasNext())
        {
          DossierExamenSpec dossierExamenSpec = (DossierExamenSpec)iterateurDossiersExamen.next();
          if (((dossierExamenSpec instanceof AttributionSpec)) && (!OutilsMigration.estFigee(demande))) {
            listeDecisions.add(dossierExamenSpec);
          }
        }
      }
    }
    return listeDecisions;
  }
  
  public String getNumeroAllocataire()
  {
    if (getIndividuId() != null) {
      return getIndividuId().toString();
    }
    return null;
  }
  
  private void verifierIndividuCharge(IndividuChargementSpec individu)
  {
    ajouterIndividuAccede(individu.getNomIndividu());
    if (!individu.estCharge()) {
      throw new UnsupportedOperationException("L'individu " + individu.getNomIndividu() + " n'a pas été chargé en début de service.");
    }
  }
  
  private void verifierIndividuModifiable(IndividuChargementSpec individu)
  {
    if ((individu != null) && (!individu.estModifiable())) {
      throw new UnsupportedOperationException("Il n'est pas permis de modifier l'individu " + individu.getNomIndividu() + " : Erreur de programmation.");
    }
  }
  
  public boolean estDejaCree()
  {
    return estDejaCree;
  }
  
  public void setEstDejaCree(boolean pEstDejaCree)
  {
    estDejaCree = pEstDejaCree;
  }
  
  public Hashtable getIndividuAccedes()
  {
    return individuAccedes;
  }
  
  public void ajouterIndividuAccede(String pIndividuAccede)
  {
    if (individuAccedes.get(pIndividuAccede) == null) {
      individuAccedes.put(pIndividuAccede, pIndividuAccede);
    }
  }
  
  public ContexteService getContexteService()
  {
    return contexteService;
  }
  
  public void setContexteService(ContexteService service)
  {
    contexteService = service;
  }
  
  public ChronologieDebuts getChronoDemandeMaintien()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoDemandeMaintien();
  }
  
  public boolean estIndividuMigre()
  {
    return individuCohab.estIndividuMigre();
  }
  
  public void setIndividuMigre(boolean estIndividuMigre)
  {
    individuCohab.setIndividuMigre(estIndividuMigre);
  }
  
  public String getEtatMigration()
  {
    return individuCohab.getEtatMigration();
  }
  
  public void setEtatMigration(String etatMigration)
  {
    individuCohab.setEtatMigration(etatMigration);
  }
  
  public Damj getDdorkb()
  {
    if (individuCohab.getDdorkb() == null) {
      return Damj.NUIT_DES_TEMPS;
    }
    return individuCohab.getDdorkb();
  }
  
  public void setDdorkb(Damj ddorkb)
  {
    individuCohab.setDdorkb(ddorkb);
  }
  
  public Collection getListeStatutDSM()
  {
    return individuCali.getListeStatutDSM();
  }
  
  public void setListeStatutDSM(Collection listeStatutDSM)
  {
    individuCali.setListeStatutDSM(listeStatutDSM);
  }
  
  public int determinerPopulationIndividu(Damj date)
  {
    return DeterminerPopulationIndividu.determinerPopulationIndividu(this, date);
  }
  
  public Damj getDatePeremptionTitreSejour()
  {
    return individuCohab.getDatePeremptionTitreSejour();
  }
  
  public void setDatePeremptionTitreSejour(Damj datePeremptionTitreSejour)
  {
    individuCohab.setDatePeremptionTitreSejour(datePeremptionTitreSejour);
  }
  
  public int getContexteExecution()
  {
    return contexteExecution;
  }
  
  public void setContexteExecution(int pContexteExecution)
  {
    contexteExecution = pContexteExecution;
  }
  
  public void ajouterStatistiqueExamenAuFilEau(StatistiqueExamenAuFilEau statistiqueExamenAuFilEau)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.ajouterStatistiqueExamenAuFilEau(statistiqueExamenAuFilEau);
  }
  
  public Collection getCollectionStatistiqueExamenAuFilEau()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getCollectionStatistiqueExamenAuFilEau();
  }
  
  public void supprimerStatistiqueExamenAuFilEau(StatistiqueExamenAuFilEau statistiqueExamenAuFilEau)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.supprimerStatistiqueExamenAuFilEau(statistiqueExamenAuFilEau);
  }
  
  public Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> getListePNDSIndividu()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getListePNDSIndividu();
  }
  
  public void setListePNDSIndividu(Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> listePnds)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setListePNDSIndividu(listePnds);
  }
  
  public List<TraceTrackerEnModeEmission> getListeTraceTrackerEnModeEmission()
  {
    if (listeTraceTrackerEnModeEmission == null) {
      listeTraceTrackerEnModeEmission = new ArrayList();
    }
    return listeTraceTrackerEnModeEmission;
  }
  
  public void ajouterTraceTrackerEnModeEmission(TraceTrackerEnModeEmission traceTrackerEnModeEmission)
  {
    getListeTraceTrackerEnModeEmission().add(traceTrackerEnModeEmission);
  }
  
  public void retirerTraceTrackerEnModeEmission(TraceTrackerEnModeEmission traceTrackerEnModeEmission)
  {
    getListeTraceTrackerEnModeEmission().remove(traceTrackerEnModeEmission);
  }
  
  public Chronologie getPeriodePensionInvalidite()
    throws CoucheLogiqueException
  {
    return getChronoPensionsInvaliditeEtAvantagesVieillesse().copier(new FiltrePeriodePensionInvalidite());
  }
  
  public Chronologie getPeriodeCLCA()
    throws CoucheLogiqueException
  {
    return getChronoPeriodePasseProfessionnelSansFiltrageDNJ().copier(new FiltrePeriodeIndemnisationCaf());
  }
  
  public Damj getDjams()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.getDjams();
  }
  
  public void setDjams(Damj djams)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setDjams(djams);
  }
  
  public DonneesChargementGaec getDonneesChargementGaec()
  {
    if (donneesChargementGaec == null) {
      donneesChargementGaec = new DonneesChargementGaec();
    }
    return donneesChargementGaec;
  }
  
  public void setDonneesChargementGaec(DonneesChargementGaec pDonneesChargementGaec)
  {
    donneesChargementGaec = pDonneesChargementGaec;
  }
  
  public String getCodeTransaction()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getCodeTransaction();
  }
  
  public void setCodeTransaction(String codeTransaction)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setCodeTransaction(codeTransaction);
  }
  
  public String getDomaineSrcFlux()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDomaineSrcFlux();
  }
  
  public void setDomaineSrcFlux(String domaineSrcFlux)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setDomaineSrcFlux(domaineSrcFlux);
  }
  
  public boolean isForcageAppelGaecTotal()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.isForcageAppelGaecTotal();
  }
  
  public void setForcageAppelGaecTotal(boolean forcageAppelGaecTotal)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setForcageAppelGaecTotal(forcageAppelGaecTotal);
  }
  
  public boolean isEstArretReexecution()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.isEstArretReexecution();
  }
  
  public void setEstArretReexecution(boolean estArretReexecution)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setEstArretReexecution(estArretReexecution);
  }
  
  public boolean estAlerteAD()
  {
    verifierIndividuCharge(individuCohab);
    return individuCohab.estAlerteAD();
  }
  
  public void setEstAlerteAD(boolean estAlerteAD)
  {
    verifierIndividuModifiable(individuCohab);
    individuCohab.setEstAlerteAD(estAlerteAD);
  }
  
  public List getListPreInscription()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getListPreInscription();
  }
  
  public void ajouterPreInscription(PreInscription preInscription)
  {
    verifierIndividuCharge(individuCali);
    individuCali.ajouterPreInscription(preInscription);
  }
  
  public void supprimerPreInscription(PreInscription preInscription)
  {
    verifierIndividuCharge(individuCali);
    individuCali.supprimerPreInscription(preInscription);
  }
  
  public int getAttributionsAfdFiliereCourte()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getAttributionsAfdFiliereCourte();
  }
  
  public int getAttributionsAfdFiliereIntermediaire()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getAttributionsAfdFiliereIntermediaire();
  }
  
  public int getAttributionsAfdFiliereLongue()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getAttributionsAfdFiliereLongue();
  }
  
  public void setAttributionsAfdFiliereCourte(int nombreAttributions)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setAttributionsAfdFiliereCourte(nombreAttributions);
  }
  
  public void setAttributionsAfdFiliereIntermediaire(int nombreAttributions)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setAttributionsAfdFiliereIntermediaire(nombreAttributions);
  }
  
  public void setAttributionsAfdFiliereLongue(int nombreAttributions)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setAttributionsAfdFiliereLongue(nombreAttributions);
  }
  
  public Damj getDernierJourIndemnisableAreSpe()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDernierJourIndemnisableAreSpe();
  }
  
  public void setDernierJourIndemnisableAreSpe(Damj dernierJourIndemnisableAreSpe)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setDernierJourIndemnisableAreSpe(dernierJourIndemnisableAreSpe);
  }
  
  public String getOrigineSaisieDernierJourIndemnisableAreSpe()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getOrigineSaisieDernierJourIndemnisableAreSpe();
  }
  
  public void setOrigineSaisieDernierJourIndemnisableAreSpe(String origineSaisieDernierJourIndemnisableAreSpe)
  {
    verifierIndividuModifiable(individuCali);
    individuCali.setOrigineSaisieDernierJourIndemnisableAreSpe(origineSaisieDernierJourIndemnisableAreSpe);
  }
  
  public void nettoyerPNDSSurActiviteSalariePourSpectacle()
  {
    ChronologiePeriodes chronoPassePro = getChronoPeriodePasseProfessionnelLiquidation();
    chronoPassePro.iterer();
    while (chronoPassePro.encoreSuivant())
    {
      PeriodeGaecSpec periodeTravail = (PeriodeGaecSpec)chronoPassePro.elementSuivant();
      if ((periodeTravail instanceof ActiviteSalarie))
      {
        ActiviteSalarie activiteSalarie = (ActiviteSalarie)periodeTravail;
        PeriodeActiviteSalarieCaliSpec activiteSalarieCali = activiteSalarie.getPeriodeActiviteSalarieCali();
        activiteSalarieCali.setPndsSpectacleCharge(false);
        activiteSalarieCali.setPndsSpectacle(null);
      }
    }
  }
  
  public ChronologiePeriodes getChronoPbjcs()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoPbjcs();
  }
  
  public ChronologiePeriodes getChronoPbjcsADate(Damj date)
  {
    FiltreDebutPbjcApresDate filtreDebutPbjcApresDateDate = new FiltreDebutPbjcApresDate(date);
    return (ChronologiePeriodes)getChronoPbjcs().copier(filtreDebutPbjcApresDateDate);
  }
  
  public void ajouterPbjc(PbjcNcp pbjc)
  {
    verifierIndividuCharge(individuCali);
    individuCali.getChronoPbjcs().ajouter(pbjc);
  }
  
  public void setChronoPbjc(ChronologiePeriodes chronoPbjc)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setChronoPbjc(chronoPbjc);
  }
  
  public Damj getDateDebutGenerationPbjcs()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDateDebutGenerationPbjcs();
  }
  
  public void setDateDebutGenerationPbjcs(Damj dateDebutGenerationPbcjcs)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setDateDebutGenerationPbjcs(dateDebutGenerationPbcjcs);
  }
  
  public List getListEnquetesPbjcNcp()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getListEnquetesPbjcNcp();
  }
  
  public void setListEnquetesPbjcNcp(List listEnquetesPbjcNcp)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setListEnquetesPbjcNcp(listEnquetesPbjcNcp);
  }
  
  public IndividuPbjcNcp getIndividuPbjcNcp()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getIndividuPbjcNcp();
  }
  
  public void setIndividuPbjcNcp(IndividuPbjcNcp individuPbjcNcp)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setIndividuPbjcNcp(individuPbjcNcp);
  }
  
  public List getListDroitsPbjcsNcp()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getListDroitsPbjcsNcp();
  }
  
  public void setListDroitsPbjcsNcp(List listDroitsPbjcsNcp)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setListDroitsPbjcsNcp(listDroitsPbjcsNcp);
  }
  
  public Damj getDateDebutGenerationDroits()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDateDebutGenerationDroits();
  }
  
  public void setDateDebutGenerationDroits(Damj dateDebutGenerationDroits)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setDateDebutGenerationDroits(dateDebutGenerationDroits);
  }
  
  public Collection getCollectionPrimes()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getCollectionPrimes();
  }
  
  public void setCollectionPrimes(Collection collectionPrimes)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setCollectionPrimes(collectionPrimes);
  }
  
  public Damj getDateDebutGenerationPrimes()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDateDebutGenerationPrimes();
  }
  
  public void setDateDebutGenerationPrimes(Damj dateDebutGenerationPrimes)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setDateDebutGenerationPrimes(dateDebutGenerationPrimes);
  }
  
  public Damj getDateDebutGenerationEnquete()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDateDebutGenerationEnquete();
  }
  
  public void setDateDebutGenerationEnquete(Damj dateDebutGenerationEnquete)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setDateDebutGenerationEnquete(dateDebutGenerationEnquete);
  }
  
  public ChronologiePeriodes getChronoAides()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoAides();
  }
  
  public ChronologiePeriodesGaec getChronoPeriodesCalcul()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getChronoPeriodesCalcul();
  }
  
  public void ajouterAide(AideNcp aide)
  {
    verifierIndividuCharge(individuCali);
    individuCali.getChronoAides().ajouter(aide);
  }
  
  public void setChronoAide(ChronologiePeriodes phronoAide)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setChronoAide(phronoAide);
  }
  
  public Damj getDateDebutGenerationAides()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getDateDebutGenerationAides();
  }
  
  public void setDateDebutGenerationAides(Damj date)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setDateDebutGenerationAides(date);
  }
  
  public DemandeInstruction getDemandeInstruction(String referenceExterne)
  {
    return individuInstruction.getDemandeInstruction(referenceExterne);
  }
  
  public void ajouterDonneesDAL(String refEx, DemandeInstruction donnees)
  {
    verifierIndividuCharge(individuInstruction);
    individuInstruction.ajouterDonneesDAL(refEx, donnees);
  }
  
  public void activerChronoPasseProPourLiquidationRevision()
  {
    verifierIndividuCharge(individuGA);
    individuGA.activerChronoPasseProPourLiquidationRevision();
  }
  
  public void desactiverChronoPasseProPourLiquidationRevision()
  {
    verifierIndividuCharge(individuGA);
    individuGA.desactiverChronoPasseProPourLiquidationRevision();
  }
  
  public void reactiverChronoPasseProPourLiquidationRevision()
  {
    verifierIndividuCharge(individuGA);
    individuGA.reactiverChronoPasseProPourLiquidationRevision();
  }
  
  public void activerExclusionChronoPasseProPourLiquidationFCTRevision()
  {
    verifierIndividuCharge(individuGA);
    individuGA.activerExclusionChronoPasseProPourLiquidationFCTRevision();
  }
  
  public void desactiverExclusionChronoPasseProPourLiquidationFCTRevision()
  {
    verifierIndividuCharge(individuGA);
    individuGA.desactiverExclusionChronoPasseProPourLiquidationFCTRevision();
  }
  
  public void reactiverExclusionChronoPasseProPourLiquidationFCTRevision()
  {
    verifierIndividuCharge(individuGA);
    individuGA.reactiverExclusionChronoPasseProPourLiquidationFCTRevision();
  }
  
  public void setChronoPeriodePasseProfessionnelLiquidationRevision(ChronologiePeriodes periodesPasseProfessionnel)
  {
    verifierIndividuCharge(individuGA);
    individuGA.setChronoPeriodePasseProfessionnelLiquidationRevision(periodesPasseProfessionnel);
  }
  
  public boolean estIndividuGaecCharge()
  {
    return (individuGA != null) && (individuGA.estCharge());
  }
  
  public void desactiverPNDS()
  {
    verifierIndividuCharge(individuCali);
    individuCali.desactiverPNDS();
  }
  
  public void activerPNDS()
  {
    verifierIndividuCharge(individuCali);
    individuCali.activerPNDS();
  }
  
  public boolean estPndsActive()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.estPndsActive();
  }
  
  private void effectuerMiseAJourQualificationPeriode()
  {
    if (effectuerMiseAJourPeriodesCaliVersGaec)
    {
      ChronologiePeriodes chronoPeriodesGa = individuGA.getChronoPeriodePasseProfessionnel();
      Collection listePeriodesCali = individuCali.getListePeriodesActiviteSalariee();
      FusionPeriodeActiviteGaecCali.miseAJourQualificationPeriode(chronoPeriodesGa, listePeriodesCali, this);
      effectuerMiseAJourPeriodesCaliVersGaec = false;
    }
  }
  
  public Collection<DispositifNcp> getCollectionDispositifNcp()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getCollectionDispositifNcp();
  }
  
  public void ajouterDispositifNcp(DispositifNcp dispositif)
  {
    verifierIndividuCharge(individuCali);
    individuCali.ajouterDispositifNcp(dispositif);
  }
  
  public void setCollectionDispositifNcp(Collection<DispositifNcp> collectionDispositifs)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setCollectionDispositifNcp(collectionDispositifs);
  }
  
  public Damj getdateDebutGenerationDispositif()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.getdateDebutGenerationDispositif();
  }
  
  public void setDateDebutGenerationDispositifNcp(Damj dateDebut)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setDateDebutGenerationDispositifNcp(dateDebut);
  }
  
  public boolean estDispositifAllonge()
  {
    verifierIndividuCharge(individuCali);
    boolean estAllonge = false;
    if (getCollectionDispositifNcp() != null)
    {
      Iterator<DispositifNcp> iter = getCollectionDispositifNcp().iterator();
      while (iter.hasNext())
      {
        DispositifNcp dispositif = (DispositifNcp)iter.next();
        if (dispositif.isEstModifie())
        {
          estAllonge = true;
          break;
        }
      }
    }
    return estAllonge;
  }
  
  public CachePndsSpectacle getCachePndsSpectacle()
  {
    return individuCali.getCachePndsSpectacle();
  }
  
  public void setEstDesactEFE(boolean desactEfe)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setEstDesactEFE(desactEfe);
  }
  
  public boolean isEstDesactEFE()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.isEstDesactEFE();
  }
  
  public void setEstNonExecutionReceptionFlux(boolean nonExecution)
  {
    verifierIndividuCharge(individuCali);
    individuCali.setEstNonExecutionReceptionFlux(nonExecution);
  }
  
  public boolean isEstNonExecutionReceptionFlux()
  {
    verifierIndividuCharge(individuCali);
    return individuCali.isEstNonExecutionReceptionFlux();
  }
  
  public List<ObjetMetierCrem> getListeCrem()
  {
    return listeCrem;
  }
  
  public CacheCrem getCacheCrem()
  {
    return individuCali.getCacheCrem();
  }
  
  public void setCacheCrem(CacheCrem cacheCrem)
  {
    individuCali.setCacheCrem(cacheCrem);
  }
}

/* Location:
 * Qualified Name:     IndividuAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
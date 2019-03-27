package fr.unedic.cali.parcours;

import fr.pe.cali.crem.outils.OutilAjoutCremDalLiquidation;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvantSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.EtatAuDernierJourAvant;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeDispositifSpec;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.MontantBaseAbstrait;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.outilsfonctionnels.OutilFluxSigma;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.outilsfonctionnels.reexecution.FabriqueGestionnaireReexecution;
import fr.unedic.cali.outilsfonctionnels.reexecution.GestionnaireReexecutionSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.UniteMonaitaire;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.Dom;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.UniteDuree;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

public class ParcoursEnregistrerCalendrierEtatAuDJI
  extends ParcoursServiceAbstrait
{
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCP_BATCH_MANDATEMENT_AUTO = "1";
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCP_BATCH_MANDATEMENT_MANU = "2";
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCP_TP = " ";
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatEnregistrerCalendrierEtatAuDJI retour = new ResultatEnregistrerCalendrierEtatAuDJI();
    OutilTrace.ecrireTrace(Niveau.INFO, new Object[] { "Test Service Enregistrer" });
    
    DomEnregistrerCalendrierEtatAuDJI domEnregistre = (DomEnregistrerCalendrierEtatAuDJI)contexte.getDonnees();
    
    IndividuSpec individu = recupererIndividu(contexte);
    
    AttributionSpec attribution = recupererAttribution(contexte, individu, domEnregistre);
    if ((attribution != null) && (aEteModifie(attribution, domEnregistre)))
    {
      ResultatGestionnaireReexecutionSpec resultatReexecution = reexecution(contexte);
      
      OutilAjoutCremDalLiquidation outilAjoutCrem = initialisationOutilAjouCREM();
      outilAjoutCrem.ajouterCREMDemandesReexecutes(resultatReexecution.getDemandesReliquidees(), individu);
      notifierSigma(individu, resultatReexecution);
    }
    retour.setEtat(0);
    return retour;
  }
  
  protected IndividuSpec recupererIndividu(Contexte contexte)
  {
    return getIndividu(contexte);
  }
  
  protected void notifierSigma(IndividuSpec individu, ResultatGestionnaireReexecutionSpec resultatReexecution)
    throws ApplicativeException
  {
    OutilFluxSigma.notifierSigma(individu, resultatReexecution.getDemandesReliquidees(), false);
  }
  
  protected ResultatGestionnaireReexecutionSpec reexecution(Contexte contexte)
    throws ApplicativeException
  {
    EvenementReexamen evtReexamen = new EvenementReexamen(Damj.NUIT_DES_TEMPS, "12");
    return FabriqueGestionnaireReexecution.getGestionnaire().executer(getIndividu(contexte), evtReexamen);
  }
  
  protected OutilAjoutCremDalLiquidation initialisationOutilAjouCREM()
  {
    return OutilAjoutCremDalLiquidation.getInstance();
  }
  
  protected boolean aEteModifie(AttributionSpec attribution, DomEnregistrerCalendrierEtatAuDJI domEnregistre)
  {
    CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
    CalendrierExecutionAvantSpec calendrierAvant = attribution.getCalendrierExecutionAvant();
    
    boolean aEteModifie = false;
    if (calendrierAvant != null)
    {
      aEteModifie = true;
      alimenterCalendrierAvantEtatAuDernierJourAvant(domEnregistre, calendrierAvant);
    }
    if (calendrier != null)
    {
      aEteModifie = true;
      alimenterCalendrierEtatAuDJI(domEnregistre, attribution);
    }
    return aEteModifie;
  }
  
  protected AttributionSpec recupererAttribution(Contexte contexte, IndividuSpec individu, DomEnregistrerCalendrierEtatAuDJI domEnregistre)
  {
    DemandeSpec demandeCourante = individu.rechercherDemande(((DomEnregistrerCalendrierEtatAuDJI)contexte.getDonnees()).getIdDemande());
    AttributionSpec attribution = (AttributionSpec)demandeCourante.getDossierAffectation().getDossierExamen();
    if ((domEnregistre.isEstAttributionPFMDemandee()) && (attribution != null) && (("SOL_CGE01_01".equals(attribution.getProduit().getNomUnique())) || ("SOL_CPA02_01".equals(attribution.getProduit().getNomUnique()))))
    {
      Collection listeAttributionLiees = attribution.getAttributionLiees();
      Iterator it = listeAttributionLiees.iterator();
      while (it.hasNext())
      {
        AttributionSpec attrib = (AttributionSpec)it.next();
        if ("INR_PFM01_01".equals(attrib.getProduit().getNomUnique()))
        {
          attribution = attrib;
          break;
        }
      }
    }
    return attribution;
  }
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    Dom dom = null;
    if (contexte == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT", "Le contexte ne doit pas être null", null);
    }
    dom = contexte.getDonnees();
    if (dom == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DOM", "Le Dom ne doit pas être null.", null);
    }
    if (!(dom instanceof DomEnregistrerCalendrierEtatAuDJI)) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le type de Dom attendu est: DomEnregistrerCalendrierEtatAuDJI", null);
    }
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null) {
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
  
  private void alimenterCalendrierEtatAuDJI(DomEnregistrerCalendrierEtatAuDJI domEnregistre, AttributionSpec attribution)
  {
    CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
    String produit = attribution.getProduit().getNomUnique();
    
    EtatAuDji etat = calendrier.getEtatAuDJI();
    if (domEnregistre.getReliquatReliquatDureeIndemnisation() != null) {
      etat.setReliquatDureeIndemnisation(new Quantite(domEnregistre.getReliquatReliquatDureeIndemnisation(), UniteDuree.JOUR));
    }
    if (domEnregistre.getCalendrierDJI() != null) {
      calendrier.setDernierJourIndemnisable(domEnregistre.getCalendrierDJI());
    }
    if (domEnregistre.getCalendrierDJISuivi() != null) {
      calendrier.setDernierJourIndemnisablePourSuivi(domEnregistre.getCalendrierDJISuivi());
    }
    if (domEnregistre.getCalendrierPJI() != null) {
      calendrier.setPremierJourIndemnisable(domEnregistre.getCalendrierPJI());
    }
    if (domEnregistre.getEtatAttribution() != null) {
      calendrier.setEtatAttribution(Integer.valueOf(domEnregistre.getEtatAttribution()).intValue());
    }
    if (("ASU_CVE13_01".equals(produit)) && (domEnregistre.getReliquatDureeFinancementAtp() != null)) {
      etat.setReliquatDureeFinancement(new Quantite(domEnregistre.getReliquatDureeFinancementAtp(), UniteDuree.JOUR));
    }
    if ((domEnregistre.isGammeSOLExiste()) && (domEnregistre.getActiviteReduiteCumulHeureActiviteReduite() != null)) {
      etat.setCumulHeuresActiviteReduite(domEnregistre.getActiviteReduiteCumulHeureActiviteReduite().intValue());
    }
    if ((domEnregistre.isGammeASUExiste()) && 
      (etat != null))
    {
      if (domEnregistre.getGammeASUNombreJoursAREF() != null) {
        etat.setNbJourAREF(domEnregistre.getGammeASUNombreJoursAREF().intValue());
      }
      if (domEnregistre.getGammeASUReliquatDureeIndemn() != null) {
        etat.setReliquatDureeIndemnisationAvecMaintien(new Quantite(domEnregistre.getGammeASUReliquatDureeIndemn(), UniteDuree.JOUR));
      }
      if (domEnregistre.getGammeASUReliquatDureeProlongation() != null) {
        etat.setReliquatDureeProlongation(new Quantite(domEnregistre.getGammeASUReliquatDureeProlongation(), UniteDuree.JOUR));
      }
      if ((domEnregistre.isGammeASUisEstNbMoisIndemniseAsu()) && (domEnregistre.getGammeASUNombreMoisIndemnisesASU() != null)) {
        etat.setNbMoisIndemniseAsu(domEnregistre.getGammeASUNombreMoisIndemnisesASU().intValue());
      }
    }
    if ("INR_PFM01_01".equals(produit))
    {
      if (domEnregistre.getActiviteReduiteCumulHeureActiviteReduite() != null) {
        etat.setCumulHeuresActiviteReduite(domEnregistre.getActiviteReduiteCumulHeureActiviteReduite().intValue());
      }
      if (domEnregistre.getNombreMoisInactivite() != null) {
        etat.setNbMoisInactivite(domEnregistre.getNombreMoisInactivite().intValue());
      }
    }
    if ((domEnregistre.isGammeAREExiste()) && (etat != null))
    {
      etat.setEstEnAttenteRenouvellement(domEnregistre.isGammeAREAttenteRenouvellement());
      if (domEnregistre.getGammeAREReliquatDureeRenouvellement() != null) {
        etat.setReliquatDureeRenouvellement(new Quantite(domEnregistre.getGammeAREReliquatDureeRenouvellement(), UniteDuree.JOUR));
      }
    }
    if ("SOL_CGE01_01".equals(produit))
    {
      if (etat.getPeriodeDispositifSpec() != null)
      {
        if (domEnregistre.getDispositifASSType() != null) {
          etat.getPeriodeDispositifSpec().setTypeDispositif(domEnregistre.getDispositifASSType());
        }
        if (domEnregistre.getDispositifASSDebut() != null) {
          etat.getPeriodeDispositifSpec().setDateDebut(domEnregistre.getDispositifASSDebut());
        }
        if (domEnregistre.getDispositifASSFin() != null) {
          etat.getPeriodeDispositifSpec().setDateFin(domEnregistre.getDispositifASSFin());
        }
      }
      if (domEnregistre.getNombreMoisInactivite() != null) {
        etat.setNbMoisInactivite(domEnregistre.getNombreMoisInactivite().intValue());
      }
    }
    if (("SOL_CPA02_01".equals(produit)) && (etat.getPeriodeDispositifSpec() != null))
    {
      if (domEnregistre.getDispositifASSType() != null) {
        etat.getPeriodeDispositifSpec().setTypeDispositif(domEnregistre.getDispositifASSType());
      }
      if (domEnregistre.getDispositifASSDebut() != null) {
        etat.getPeriodeDispositifSpec().setDateDebut(domEnregistre.getDispositifASSDebut());
      }
      if (domEnregistre.getDispositifASSFin() != null) {
        etat.getPeriodeDispositifSpec().setDateFin(domEnregistre.getDispositifASSFin());
      }
    }
    if (("INR_ADR03_02".equals(produit)) && (domEnregistre.getCapitalADRVerse() != null)) {
      etat.setCapitalADR(new QuantiteEuro(domEnregistre.getCapitalADRVerse()));
    }
    if (domEnregistre.isGammeASSCGEExiste()) {
      if (domEnregistre.getGammeASSCGENombreMoisInactivite() != null) {
        etat.setNbMoisInactivite(domEnregistre.getGammeASSCGENombreMoisInactivite().intValue());
      } else {
        etat.setNbMoisInactivite(0);
      }
    }
    if (domEnregistre.isGammeARCEExiste()) {
      etat.setCapitalVerse(domEnregistre.getGammeARCECapitalVerse());
    }
    if (etat != null)
    {
      if (domEnregistre.getActiviteReduiteCumulMoisActiviteReduite() != null) {
        etat.setCumulMoisActiviteReduite(domEnregistre.getActiviteReduiteCumulMoisActiviteReduite().intValue());
      } else {
        etat.setCumulMoisActiviteReduite(0);
      }
      if (domEnregistre.getActiviteReduiteCumulJoursActiviteReduite() != null) {
        etat.setCumulJoursAR(domEnregistre.getActiviteReduiteCumulJoursActiviteReduite().intValue());
      } else {
        etat.setCumulJoursAR(0);
      }
      MontantBaseAbstrait montant = etat.getMontant();
      etat.setEstFigee(domEnregistre.isEtatAuDJIDemandeFigee());
      if (montant != null)
      {
        montant.setJustificationCalculMontant(domEnregistre.getMontantJustification());
        if (domEnregistre.getMontantMontantBrut() != null) {
          montant.setMontantBrut(new Quantite(domEnregistre.getMontantMontantBrut(), UniteMonaitaire.EUROS));
        } else {
          montant.setMontantBrut(null);
        }
        if (domEnregistre.getMontantMontantCRC() != null) {
          montant.setCrc(new Quantite(domEnregistre.getMontantMontantCRC(), UniteMonaitaire.EUROS));
        } else {
          montant.setCrc(null);
        }
        montant.setAvecPrecompteCRC(domEnregistre.isMontantMontantPrecompteCRC());
      }
      etat.setMontant(montant);
      if (domEnregistre.getCumulJoursServis() != null) {
        etat.setCumulJoursIndemnise(domEnregistre.getCumulJoursServis().intValue());
      }
    }
  }
  
  private void alimenterCalendrierAvantEtatAuDernierJourAvant(DomEnregistrerCalendrierEtatAuDJI domEnregistre, CalendrierExecutionAvantSpec calendrierAvant)
  {
    if (domEnregistre.getPremierJourAvant() != null) {
      calendrierAvant.setPremierJourAvant(domEnregistre.getPremierJourAvant());
    }
    if (domEnregistre.getDernierJourAvant() != null) {
      calendrierAvant.setDernierJourAvant(domEnregistre.getDernierJourAvant());
    }
    EtatAuDernierJourAvant etatAuDernierJourAvant = calendrierAvant.getEtatAuDernierJourAvant();
    if (etatAuDernierJourAvant != null)
    {
      if (domEnregistre.getReliquatPMC() != null) {
        etatAuDernierJourAvant.setReliquatPMC(domEnregistre.getReliquatPMC());
      }
      if (domEnregistre.getReliquatICCP() != null) {
        etatAuDernierJourAvant.setReliquatICCP(domEnregistre.getReliquatICCP());
      }
      if (domEnregistre.getReliquatISLR() != null) {
        etatAuDernierJourAvant.setReliquatISLR(domEnregistre.getReliquatISLR());
      }
      if (domEnregistre.getReliquatDelaiAttente() != null) {
        etatAuDernierJourAvant.setReliquatDelaiAttente(domEnregistre.getReliquatDelaiAttente());
      }
      if (domEnregistre.getDureeInitialePMC() != null) {
        etatAuDernierJourAvant.setDureeInitialePMC(domEnregistre.getDureeInitialePMC());
      }
      if (domEnregistre.getDureeInitialeICCP() != null) {
        etatAuDernierJourAvant.setDureeInitialeICCP(domEnregistre.getDureeInitialeICCP());
      }
      if (domEnregistre.getDureeInitialeISLR() != null) {
        etatAuDernierJourAvant.setDureeInitialeISLR(domEnregistre.getDureeInitialeISLR());
      }
      if (domEnregistre.getReliquatDelaiAttente() != null) {
        etatAuDernierJourAvant.setDureeInitialeDelaiAttente(domEnregistre.getDureeInitialeDelaiAttente());
      }
      if ((domEnregistre.getDebutPeriodeApplicationPMC() != null) && (domEnregistre.getFinPeriodeApplicationPMC() != null)) {
        etatAuDernierJourAvant.setPeriodeApplicationPMC(new Periode(domEnregistre.getDebutPeriodeApplicationPMC(), domEnregistre.getFinPeriodeApplicationPMC()));
      }
      if ((domEnregistre.getDebutPeriodeApplicationICCP() != null) && (domEnregistre.getFinPeriodeApplicationICCP() != null)) {
        etatAuDernierJourAvant.setPeriodeApplicationICCP(new Periode(domEnregistre.getDebutPeriodeApplicationICCP(), domEnregistre.getFinPeriodeApplicationICCP()));
      }
      if ((domEnregistre.getDebutPeriodeApplicationISLR() != null) && (domEnregistre.getFinPeriodeApplicationISLR() != null)) {
        etatAuDernierJourAvant.setPeriodeApplicationISLR(new Periode(domEnregistre.getDebutPeriodeApplicationISLR(), domEnregistre.getFinPeriodeApplicationISLR()));
      }
      if ((domEnregistre.getDebutPeriodeApplicationDelai() != null) && (domEnregistre.getFinPeriodeApplicationDelai() != null)) {
        etatAuDernierJourAvant.setPeriodeApplicationDelaiAttente(new Periode(domEnregistre.getDebutPeriodeApplicationDelai(), domEnregistre.getFinPeriodeApplicationDelai()));
      }
      etatAuDernierJourAvant.setDelaiAttenteEntame(domEnregistre.isDelaiAttenteEntame());
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursEnregistrerCalendrierEtatAuDJI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
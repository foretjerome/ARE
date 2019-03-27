package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvant;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvantSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalcul;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.EtatAuDernierJourAvant;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculCREM;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeDispositifSpec;
import fr.unedic.cali.calcul.pbjc.cons.ConstantesPBJC;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.MontantBaseAbstrait;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import xcalia.lido.api.LiDOHelper;

public class ParcoursLireCalendrierEtatAuDJI
  extends ParcoursServiceAbstrait
{
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCBATCH_MANDATEMENT_AUTO = "1";
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCBATCH_MANDATEMENT_MANU = "2";
  public static final String CONTEXTE_EXECUTION_INDIVIDU_PBJC_NCTP = " ";
  public static final String SIMPLE_DATE_FORMAT_PATERN = "dd-MM-yyyy HH:mm:ss";
  public static final String VERSION = "{version}";
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatLireCalendrierEtatAuDJI retour = new ResultatLireCalendrierEtatAuDJI();
    
    IndividuSpec individu = getIndividu(contexte);
    
    DomLireCalendrierEtatAuDJI domLire = (DomLireCalendrierEtatAuDJI)contexte.getDonnees();
    
    DemandeSpec demandeCourante = individu.rechercherDemande(domLire.getIdDemande());
    
    AttributionSpec attribution = (AttributionSpec)demandeCourante.getDossierAffectation().getDossierExamen();
    if ((domLire.isEstAttributionPFMDemandee()) && (attribution != null) && (("SOL_CGE01_01".equals(attribution.getProduit().getNomUnique())) || ("SOL_CPA02_01".equals(attribution.getProduit().getNomUnique()))))
    {
      Collection<?> listeAttributionLiees = attribution.getAttributionLiees();
      Iterator<?> it = listeAttributionLiees.iterator();
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
    if (attribution != null)
    {
      alimenterCalendrierEtatAuDJI(retour, attribution);
      alimenterCalendrierEtatAuDernierJourAvant(retour, attribution);
    }
    retour.setMapEtatAttribution(CalendrierExecutionCalcul.LIB_ETAT_ATTRIBUTION);
    retour.setMapJustificationCalculMontant(ConstantesPBJC.LIB_JUSTIFICATION_MONTANT);
    retour.setMapJustificationCalculMontant(ConstantesPBJC.LIB_TYPE_DISPOSITIF);
    
    return retour;
  }
  
  private String getTSP(EtatAuDji tspVersion)
  {
    return new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format((Date)LiDOHelper.getSyntheticValue(tspVersion.getPC(), "{version}"));
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null) {
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
  
  private void alimenterCalendrierEtatAuDJI(ResultatLireCalendrierEtatAuDJI retour, AttributionSpec attribution)
  {
    CalendrierExecutionCalculSpec calendrier = attribution.getCalendrierExecutionCalcul();
    String gamme = attribution.getGamme().getNomUnique();
    String produit = attribution.getProduit().getNomUnique();
    if (calendrier != null)
    {
      retour.setCalendrierExiste(true);
      
      EtatAuDji etat = calendrier.getEtatAuDJI();
      
      retour.setDernierJourIndemnise(calendrier.getDernierJourIndemnisable());
      retour.setDernierJourIndemniseSuivi(calendrier.getDernierJourIndemnisablePourSuivi());
      retour.setPremierJourIndemnise(calendrier.getPremierJourIndemnisable());
      if ((calendrier instanceof CalendrierExecutionCalcul))
      {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String tsp = sdf.format((Date)LiDOHelper.getSyntheticValue(((CalendrierExecutionCalcul)calendrier).getPC(), "{version}"));
        retour.setTspCalendrier(tsp);
      }
      retour.setIdEtatAttribution(String.valueOf(calendrier.getEtatAttribution()));
      if (etat != null)
      {
        if ("SOL".equals(gamme))
        {
          retour.setCumulHeureActiviteReduite(new BigDecimal(etat.getCumulHeuresActiviteReduite()));
          retour.setEstGammeSOL(true);
        }
        if (etat.getReliquatDureeIndemnisation() != null) {
          retour.setReliquatReliquatDureeIndemnisation(etat.getReliquatDureeIndemnisation().getValeur());
        }
        if ("ASU".equals(gamme))
        {
          retour.setEstGammeASU(true);
          retour.setNombreJoursFormation(new BigDecimal(etat.getNbJourAREF()));
          if (etat.getReliquatDureeIndemnisationAvecMaintien() != null) {
            retour.setReliquatReliquatDureeIndemnisationASU(etat.getReliquatDureeIndemnisationAvecMaintien().getValeur());
          } else {
            retour.setReliquatReliquatDureeIndemnisationASU(BigDecimal.ZERO);
          }
          if (etat.getReliquatDureeProlongation() != null) {
            retour.setReliquatDureeProlongationARE(etat.getReliquatDureeProlongation().getValeur());
          } else {
            retour.setReliquatDureeProlongationARE(BigDecimal.ZERO);
          }
          if (etat.isEstNbMoisIndemniseAsu()) {
            retour.setNombreMoisIndemnisesASU(new BigDecimal(etat.getNbMoisIndemniseAsu()));
          }
          if (etat.getReliquatDureeFinancement() != null) {
            retour.setReliquatDureeFinancementAtp(etat.getReliquatDureeFinancement().getValeur());
          }
          if (calendrier.getDateEpuisementDuree() != null) {
            retour.setDateEpuisementDuree(calendrier.getDateEpuisementDuree());
          }
          if (calendrier.getDateFinDispositifCSP() != null) {
            retour.setDateFinDispositifCSP(calendrier.getDateFinDispositifCSP());
          }
          if (calendrier.getDateDrv() != null) {
            retour.setDateDRV(calendrier.getDateDrv());
          }
          if (etat.getReliquatDA() != null) {
            retour.setReliquatDA(new BigDecimal(etat.getReliquatDA().intValue()));
          }
          if (etat.getReliquatFCP() != null)
          {
            retour.setReliquatTotalFranchiseCP(new BigDecimal(etat.getReliquatFCP().intValue()));
            if (etat.getReliquatMaxFCP() != null) {
              retour.setReliquatTotalFranchiseCP(retour.getReliquatTotalFranchiseCP().add(new BigDecimal(etat.getReliquatMaxFCP().intValue())));
            }
          }
          if (etat.getReliquatFS() != null)
          {
            retour.setReliquatTotalFranchiseSalaire(new BigDecimal(etat.getReliquatFS().intValue()));
            if (etat.getReliquatMaxFS() != null) {
              retour.setReliquatTotalFranchiseSalaire(retour.getReliquatTotalFranchiseSalaire().add(new BigDecimal(etat.getReliquatMaxFS().intValue())));
            }
          }
          if (etat.getPeriodeDA() != null)
          {
            retour.setPeriodeDADebut(etat.getPeriodeDA().getDebut());
            retour.setPeriodeDAFin(etat.getPeriodeDA().getFin());
          }
        }
        if ("INR_PFM01_01".equals(produit))
        {
          retour.setEstGammeSOL(true);
          retour.setCumulHeureActiviteReduite(new BigDecimal(etat.getCumulHeuresActiviteReduite()));
          retour.setNombreMoisInactivite(new BigDecimal(etat.getNbMoisInactivite()));
        }
        if ("ASU_CGE01_02".equals(produit))
        {
          retour.setEstGammeARE(true);
          retour.setEstAttenteRenouvellement(etat.getEstEnAttenteRenouvellement());
          if (etat.getReliquatDureeRenouvellement() != null) {
            retour.setReliquatDureeRenouvellementARE(etat.getReliquatDureeRenouvellement().getValeur());
          } else {
            retour.setReliquatDureeRenouvellementARE(BigDecimal.ZERO);
          }
        }
        if ("SOL_CGE01_01".equals(produit))
        {
          retour.setEstProduitASS(true);
          retour.setNombreMoisInactivite(new BigDecimal(etat.getNbMoisInactivite()));
          retour.setEstDispositif(true);
          ObjetChronoPeriodeDispositifSpec periodeDispositif = etat.getPeriodeDispositifSpec();
          retour.setDateDebutDispositif(periodeDispositif.getDateDebut());
          retour.setDateFinDispostif(periodeDispositif.getDateFin());
          retour.setTypeDispositif(periodeDispositif.getTypeDispositif());
          SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
          String tsp = sdf.format((Date)LiDOHelper.getSyntheticValue(periodeDispositif.getObjetChronoPeriode().getPC(), "{version}"));
          retour.setTspDispositif(tsp);
        }
        if ("SOL_CPA02_01".equals(produit))
        {
          retour.setEstDispositif(true);
          ObjetChronoPeriodeDispositifSpec periodeDispositif = etat.getPeriodeDispositifSpec();
          retour.setDateDebutDispositif(periodeDispositif.getDateDebut());
          retour.setDateFinDispostif(periodeDispositif.getDateFin());
          retour.setTypeDispositif(periodeDispositif.getTypeDispositif());
          SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
          String tsp = sdf.format((Date)LiDOHelper.getSyntheticValue(periodeDispositif.getObjetChronoPeriode().getPC(), "{version}"));
          retour.setTspDispositif(tsp);
        }
        if ("INR_RCE04_01".equals(produit))
        {
          retour.setEstProduitARCe(true);
          retour.setCapitalVerseARCE(etat.getCapitalVerse());
        }
        if ("INR_ADR03_02".equals(produit))
        {
          retour.setEstProduitADR(true);
          retour.setCapitalADRVerse(etat.getCapitalADR().getValeur());
        }
        MontantBaseAbstrait montant = null;
        if (etat.getMontant() != null) {
          montant = etat.getMontant();
        }
        retour.setEstDemandeFigee(etat.isEstFigee());
        retour.setTspEtatAuDJI(getTSP(etat));
        retour.setCumulMoisActiviteReduite(new BigDecimal(etat.getCumulMoisActiviteReduite()));
        retour.setCumulJoursAR(new BigDecimal(etat.getCumulJoursAR()));
        if (montant != null)
        {
          retour.setMontantJustification(montant.getJustificationCalculMontant());
          if (montant.getMontantBrut() != null) {
            retour.setMontantBrut(montant.getMontantBrut().getValeur());
          }
          if (montant.getCrc() != null) {
            retour.setMontantCRC(montant.getCrc().getValeur());
          }
          retour.setMontantPrecompteCRC(montant.getAvecPrecompteCRC());
          SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
          String tsp = sdf.format((Date)LiDOHelper.getSyntheticValue(montant.getPC(), "{version}"));
          retour.setTspMontant(tsp);
        }
        if (etat.getCumulJoursIndemnise() != 0) {
          retour.setCumulJoursServis(new BigDecimal(etat.getCumulJoursIndemnise()));
        }
      }
    }
    else
    {
      retour.setCalendrierExiste(false);
    }
  }
  
  private void alimenterCalendrierEtatAuDernierJourAvant(ResultatLireCalendrierEtatAuDJI retour, AttributionSpec attribution)
  {
    CalendrierExecutionAvantSpec calendrierAvant = attribution.getCalendrierExecutionAvant();
    if (calendrierAvant == null)
    {
      retour.setCalendrierAvantExiste(false);
    }
    else
    {
      retour.setCalendrierAvantExiste(true);
      
      retour.setPremierJourAvant(calendrierAvant.getPremierJourAvant());
      retour.setDernierJourAvant(calendrierAvant.getDernierJourAvant());
      SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      String tsp = sdf.format((Date)LiDOHelper.getSyntheticValue(((CalendrierExecutionAvant)calendrierAvant).getPC(), "{version}"));
      retour.setCalendrierAvantTSP(tsp);
      
      EtatAuDernierJourAvant etatAuDernierJourAvant = calendrierAvant.getEtatAuDernierJourAvant();
      sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      tsp = sdf.format((Date)LiDOHelper.getSyntheticValue(etatAuDernierJourAvant.getPC(), "{version}"));
      retour.setEtatAuDernierAvantJourTSP(tsp);
      retour.setReliquatPMC(etatAuDernierJourAvant.getReliquatPMC());
      retour.setReliquatICCP(etatAuDernierJourAvant.getReliquatICCP());
      retour.setReliquatISLR(etatAuDernierJourAvant.getReliquatISLR());
      retour.setReliquatDelaiAttente(etatAuDernierJourAvant.getReliquatDelaiAttente());
      if (etatAuDernierJourAvant.isDelaiAttenteEntame()) {
        retour.setEstDelaiAttenteEntame("1");
      } else {
        retour.setEstDelaiAttenteEntame("0");
      }
      retour.setDureeInitialePMC(etatAuDernierJourAvant.getDureeInitialePMC());
      retour.setDureeInitialeICCP(etatAuDernierJourAvant.getDureeInitialeICCP());
      retour.setDureeInitialeISLR(etatAuDernierJourAvant.getDureeInitialeISLR());
      retour.setDureeInitialeDelaiAttente(etatAuDernierJourAvant.getDureeInitialeDelaiAttente());
      if (etatAuDernierJourAvant.getPeriodeApplicationPMC() != null)
      {
        retour.setDebutPeriodeApplicationPMC(etatAuDernierJourAvant.getPeriodeApplicationPMC().getDebut());
        retour.setFinPeriodeApplicationPMC(etatAuDernierJourAvant.getPeriodeApplicationPMC().getFin());
      }
      if (etatAuDernierJourAvant.getPeriodeApplicationICCP() != null)
      {
        retour.setDebutPeriodeApplicationICCP(etatAuDernierJourAvant.getPeriodeApplicationICCP().getDebut());
        retour.setFinPeriodeApplicationICCP(etatAuDernierJourAvant.getPeriodeApplicationICCP().getFin());
      }
      if (etatAuDernierJourAvant.getPeriodeApplicationISLR() != null)
      {
        retour.setDebutPeriodeApplicationISLR(etatAuDernierJourAvant.getPeriodeApplicationISLR().getDebut());
        retour.setFinPeriodeApplicationISLR(etatAuDernierJourAvant.getPeriodeApplicationISLR().getFin());
      }
      if (etatAuDernierJourAvant.getPeriodeApplicationDelaiAttente() != null)
      {
        retour.setDebutPeriodeApplicationDelai(etatAuDernierJourAvant.getPeriodeApplicationDelaiAttente().getDebut());
        retour.setFinPeriodeApplicationDelai(etatAuDernierJourAvant.getPeriodeApplicationDelaiAttente().getFin());
      }
      if (calendrierAvant.getDateDrv() != null) {
        retour.setDateDRVAvant(calendrierAvant.getDateDrv());
      }
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursLireCalendrierEtatAuDJI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
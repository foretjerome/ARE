package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.JustificationAppelGaecReduit;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeAsuSpec;
import fr.unedic.cali.dom.affectation.GammeFor;
import fr.unedic.cali.dom.affectation.GammeForSpec;
import fr.unedic.cali.dom.affectation.GammeInr;
import fr.unedic.cali.dom.affectation.GammeInrSpec;
import fr.unedic.cali.dom.affectation.GammeMnt;
import fr.unedic.cali.dom.affectation.GammeRbf;
import fr.unedic.cali.dom.affectation.GammeRbfSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitInrAdr03P02;
import fr.unedic.cali.dom.affectation.ProduitInrCes06P01;
import fr.unedic.cali.dom.affectation.ProduitInrRce04P01;
import fr.unedic.cali.dom.affectation.ProduitSolAer05P01;
import fr.unedic.cali.dom.affectation.ProduitSolCge01P01;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

public class ReductionAppelGaec
{
  private static final int NB_ANNEES_AFFICHEES_SUR_APPLET_LIQUIDATION = 5;
  private static final String MESSAGE_GAEC_NON_CHARGE = "L'individu GAEC n'a pas été chargé en début de service.";
  
  public static AppelGaecReduit reduireAppelGaec(Individu p_individu)
    throws ApplicativeException
  {
    AgregatGaec agregat = p_individu.getDonneesChargementGaec().getAgregatGaec();
    
    AppelGaecReduit gaecReduit = new AppelGaecReduit();
    
    p_individu.getDonneesChargementGaec().setAppelGaecReduit(gaecReduit);
    
    gaecReduit.setModeAppel(agregat.getModeAppel());
    if (gaecReduit.getModeAppel() == 1)
    {
      gaecReduit.setTypePeriodes(agregat.getTypePeriodesGaec());
      
      initialiserBornageFenetreAppel(p_individu);
      switch (agregat.getTypeService())
      {
      case 1: 
        gaecReduit.setDnj(false);
        gaecReduit.setPnd(false);
        break;
      case 2: 
        gaecReduit.setDnj(true);
        gaecReduit.setPnd(true);
        break;
      default: 
        gaecReduit.setDnj(true);
        gaecReduit.setPnd(true);
      }
    }
    gaecReduit.afficherTracesGaecReduit();
    return gaecReduit;
  }
  
  private static void initialiserBornageFenetreAppel(Individu p_individu)
    throws ApplicativeException
  {
    AgregatGaec parametres = p_individu.getDonneesChargementGaec().getAgregatGaec();
    
    AppelGaecReduit gaecReduit = p_individu.getDonneesChargementGaec().getAppelGaecReduit();
    
    gaecReduit.setDateDebutFenetreAppel(null);
    gaecReduit.setDateDebutFenetreAppelOptionnelle(null);
    gaecReduit.setDateFinFenetreAppel(null);
    if (gaecReduit.getModeAppel() == 1)
    {
      gaecReduit.setDateDebutFenetreAppel(new JustificationAppelGaecReduit(Damj.FIN_DES_TEMPS, "Sans valeur", null));
      
      gaecReduit.setDateDebutFenetreAppelOptionnelle(new JustificationAppelGaecReduit(Damj.FIN_DES_TEMPS, "Sans valeur", null));
      
      gaecReduit.setDateFinFenetreAppel(new JustificationAppelGaecReduit(Damj.NUIT_DES_TEMPS, "Sans valeur", null));
      switch (parametres.getTypeService())
      {
      case 1: 
        initBornageServiceEnLecture(p_individu);
        break;
      case 2: 
        initBornageServiceEnLiquidation(p_individu);
      }
      if ((gaecReduit.getDateDebutFenetreAppel().coincideAvec(Damj.FIN_DES_TEMPS)) || (gaecReduit.getDateDebutFenetreAppel().coincideAvec(Damj.NUIT_DES_TEMPS))) {
        gaecReduit.setDateDebutFenetreAppel(null);
      }
      if ((gaecReduit.getDateDebutFenetreAppelOptionnelle().coincideAvec(Damj.FIN_DES_TEMPS)) || (gaecReduit.getDateDebutFenetreAppelOptionnelle().coincideAvec(Damj.NUIT_DES_TEMPS))) {
        gaecReduit.setDateDebutFenetreAppelOptionnelle(null);
      }
      if ((gaecReduit.getDateFinFenetreAppel().coincideAvec(Damj.NUIT_DES_TEMPS)) || (gaecReduit.getDateFinFenetreAppel().coincideAvec(Damj.FIN_DES_TEMPS))) {
        gaecReduit.setDateFinFenetreAppel(null);
      }
    }
  }
  
  private static void initBornageServiceEnLecture(Individu p_individu)
    throws ApplicativeException
  {
    DonneesChargementGaec chargementGaec = p_individu.getDonneesChargementGaec();
    AgregatGaec agregat = chargementGaec.getAgregatGaec();
    AppelGaecReduit gaecReduit = chargementGaec.getAppelGaecReduit();
    
    String identifiantDemande = p_individu.getDonneesChargementGaec().getAgregatGaec().getIdDemande();
    Enumeration enumGammes;
    if (identifiantDemande != null)
    {
      DemandeSpec demande = p_individu.rechercherDemande(identifiantDemande);
      initBornageServiceEnLectureParGamme(demande, chargementGaec, false);
    }
    else
    {
      for (enumGammes = agregat.getEnumerationGammes(); enumGammes.hasMoreElements();)
      {
        GammeSpec gamme = (GammeSpec)enumGammes.nextElement();
        Collection idDemandes = agregat.getIdDemandesPourGamme(gamme);
        if (idDemandes != null)
        {
          boolean estGammeAvecMultiDemandes = idDemandes.size() > 1;
          Iterator iterIdDemandes = idDemandes.iterator();
          while (iterIdDemandes.hasNext())
          {
            DemandeSpec demande = p_individu.rechercherDemande((String)iterIdDemandes.next());
            initBornageServiceEnLectureParGamme(demande, chargementGaec, estGammeAvecMultiDemandes);
          }
        }
      }
    }
    for (Enumeration enumProduits = agregat.getEnumerationProduits(); enumProduits.hasMoreElements();)
    {
      ProduitSpec produit = (ProduitSpec)enumProduits.nextElement();
      Collection idDemandes = agregat.getIdDemandesPourProduit(produit);
      if (idDemandes != null)
      {
        Iterator iterIdDemandes = idDemandes.iterator();
        while (iterIdDemandes.hasNext())
        {
          String idDemande = (String)iterIdDemandes.next();
          DemandeSpec demande = p_individu.rechercherDemande(idDemande);
          initBornageServiceEnLectureParProduit(demande, produit, gaecReduit);
        }
      }
    }
  }
  
  private static void initBornageServiceEnLectureParGamme(DemandeSpec p_demande, DonneesChargementGaec p_chargementGaec, boolean p_estGammeAvecMultiDemandes)
    throws ApplicativeException
  {
    AppelGaecReduit gaecReduit = p_chargementGaec.getAppelGaecReduit();
    
    String nomService = p_chargementGaec.getAgregatGaec().getNomService();
    if ("fr.unedic.cali.service.ServiceDeterminerDateDebutExecution".equals(nomService)) {
      initBornageServiceDeterminerDateDebutExecution(p_demande, gaecReduit);
    }
    if ("fr.unedic.cali.service.ServiceAfficherAppletLiquidation".equals(nomService))
    {
      initBornageServiceAfficherAppletliquidation(p_demande, gaecReduit);
    }
    else
    {
      GammeSpec gamme = p_demande.getGamme();
      if ((gamme instanceof GammeAsuSpec)) {
        initBornageServiceEnLectureASU(p_demande, gaecReduit);
      } else if ((gamme instanceof GammeForSpec)) {
        initBornageServiceEnLectureFOR(p_demande, gaecReduit, p_estGammeAvecMultiDemandes);
      } else if ((gamme instanceof GammeInrSpec)) {
        initBornageServiceEnLectureINR(p_demande, gaecReduit, p_estGammeAvecMultiDemandes);
      } else if ((gamme instanceof GammeRbfSpec)) {
        initBornageServiceEnLectureRBF(p_demande, gaecReduit, p_estGammeAvecMultiDemandes);
      }
    }
  }
  
  private static void initBornageServiceEnLectureParProduit(DemandeSpec p_demande, ProduitSpec p_produit, AppelGaecReduit p_gaecReduit)
  {
    if ((p_produit instanceof ProduitInrAdr03P02)) {
      initBornageServiceEnLectureInrAdr03v02(p_demande, p_gaecReduit);
    } else if ((p_produit instanceof ProduitInrCes06P01)) {
      initBornageServiceEnLectureInrCes06v01(p_demande, p_gaecReduit);
    } else if ((p_produit instanceof ProduitInrRce04P01)) {
      initBornageServiceEnLectureInrRce04v01(p_demande, p_gaecReduit);
    }
  }
  
  private static void initBornageServiceDeterminerDateDebutExecution(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
  {
    Damj dateDebut = null;
    
    GammeSpec gamme = p_demande.getGamme();
    if ((gamme instanceof GammeRbfSpec))
    {
      dateDebut = GammeRbf.getInstance().getDateMinAttibutions(p_demande);
    }
    else
    {
      DossierAffectationSpec dossierAffectation = p_demande.getDossierAffectation();
      if (dossierAffectation != null)
      {
        DossierExamenSpec dossierExamen = dossierAffectation.getDossierExamen();
        if (dossierExamen != null) {
          dateDebut = dossierExamen.getDateAttribution();
        }
      }
    }
    if (dateDebut != null) {
      p_gaecReduit.compareEtSetDateDebutFenetreAppel(dateDebut, "Min des dates d'attribution", p_demande.getIdentifiant());
    }
  }
  
  private static void initBornageServiceAfficherAppletliquidation(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
    throws ApplicativeException
  {
    Damj dateDebut = getDateExamen(p_demande);
    if (dateDebut != null)
    {
      dateDebut = dateDebut.deplacerVersArriere(new DureeCalendaire(5));
      
      p_gaecReduit.compareEtSetDateDebutFenetreAppel(dateDebut, "Date d'examen -5 ans", p_demande.getIdentifiant());
    }
  }
  
  private static void initBornageServiceEnLectureASU(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
  {
    Damj dateDebut = getDateFaitGenerateurOdPrecedenteGammeAsu(p_demande);
    if (dateDebut == null) {
      p_gaecReduit.compareEtSetDateDebutFenetreAppel(Damj.NUIT_DES_TEMPS, "Sans valeur", null);
    } else {
      p_gaecReduit.compareEtSetDateDebutFenetreAppel(dateDebut, "Fgd OD précédente", p_demande.getIdentifiant());
    }
  }
  
  private static void initBornageServiceEnLectureFOR(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit, boolean p_estGammeAvecMultiDemandes)
  {
    String idActionFormation = GammeFor.getInstance().getIdActionFormationLiee(p_demande);
    if ((!p_estGammeAvecMultiDemandes) && (idActionFormation != null))
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActionFormation);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLectureINR(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit, boolean p_estGammeAvecMultiDemandes)
  {
    String idActiviteLiee = GammeInr.getInstance().getIdActiviteLiee(p_demande);
    if ((!p_estGammeAvecMultiDemandes) && (idActiviteLiee != null))
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActiviteLiee);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLectureRBF(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit, boolean p_estGammeAvecMultiDemandes)
  {
    String idActionFormation = GammeRbf.getInstance().getIdActionFormationLiee(p_demande);
    if ((!p_estGammeAvecMultiDemandes) && (idActionFormation != null))
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActionFormation);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLectureInrAdr03v02(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
  {
    String idActiviteLiee = GammeInr.getInstance().getIdActiviteLiee(p_demande);
    if (idActiviteLiee != null)
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActiviteLiee);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLectureInrCes06v01(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
  {
    String idActiviteLiee = GammeInr.getInstance().getIdActiviteLiee(p_demande);
    if (idActiviteLiee != null)
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActiviteLiee);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLectureInrRce04v01(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
  {
    String idActiviteLiee = GammeInr.getInstance().getIdActiviteLiee(p_demande);
    if (idActiviteLiee != null)
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActiviteLiee);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLiquidation(Individu p_individu)
    throws ApplicativeException
  {
    AgregatGaec agregat = p_individu.getDonneesChargementGaec().getAgregatGaec();
    AppelGaecReduit gaecReduit = p_individu.getDonneesChargementGaec().getAppelGaecReduit();
    
    String idDemande = agregat.getIdDemande();
    DemandeSpec demande = p_individu.rechercherDemande(idDemande);
    initBornageServiceEnLiquidationParGamme(demande, gaecReduit);
    
    ProduitSpec produit = agregat.getProduit(idDemande);
    if (produit != null) {
      initBornageServiceEnLiquidationParProduit(demande, produit, gaecReduit);
    }
  }
  
  private static void initBornageServiceEnLiquidationParGamme(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
    throws ApplicativeException
  {
    GammeSpec gamme = p_demande.getGamme();
    if ((gamme instanceof GammeForSpec)) {
      initBornageServiceEnLiquidationFOR(p_demande, p_gaecReduit);
    } else if ((gamme instanceof GammeMnt)) {
      initBornageServiceEnLiquidationMNT(p_demande, p_gaecReduit);
    } else if ((gamme instanceof GammeRbfSpec)) {
      initBornageServiceEnLiquidationRBF(p_demande, p_gaecReduit);
    }
  }
  
  private static void initBornageServiceEnLiquidationParProduit(DemandeSpec p_demande, ProduitSpec p_produit, AppelGaecReduit p_gaecReduit)
    throws ApplicativeException
  {
    if ((p_produit instanceof ProduitInrCes06P01)) {
      initBornageServiceEnLiquidationInrCes06v01(p_demande, p_gaecReduit);
    } else if ((p_produit instanceof ProduitInrRce04P01)) {
      initBornageServiceEnLiquidationInrRce04v01(p_demande, p_gaecReduit);
    } else if ((p_produit instanceof ProduitSolAer05P01)) {
      initBornageServiceEnLiquidationSolAer05v01(p_demande, p_gaecReduit);
    } else if ((p_produit instanceof ProduitSolCge01P01)) {
      initBornageServiceEnLiquidationSolCge01v01(p_demande, p_gaecReduit);
    }
  }
  
  private static void initBornageServiceEnLiquidationFOR(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
  {
    String idActionFormation = GammeFor.getInstance().getIdActionFormationLiee(p_demande);
    if (idActionFormation != null)
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActionFormation);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLiquidationMNT(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
    throws ApplicativeException
  {
    p_gaecReduit.compareEtSetDateFinFenetreAppel(getDateExamen(p_demande), "Date d'examen", p_demande.getIdentifiant());
  }
  
  private static void initBornageServiceEnLiquidationRBF(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
  {
    String idActionFormation = GammeRbf.getInstance().getIdActionFormationLiee(p_demande);
    if (idActionFormation != null)
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActionFormation);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLiquidationInrCes06v01(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
  {
    String idActiviteLiee = GammeInr.getInstance().getIdActiviteLiee(p_demande);
    if (idActiviteLiee != null)
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActiviteLiee);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLiquidationInrRce04v01(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
  {
    String idActiviteLiee = GammeInr.getInstance().getIdActiviteLiee(p_demande);
    if (idActiviteLiee != null)
    {
      p_gaecReduit.setIdentifiantPeriodeGaec(idActiviteLiee);
      p_gaecReduit.setAppelPeriodeUnique(true);
    }
  }
  
  private static void initBornageServiceEnLiquidationSolAer05v01(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
    throws ApplicativeException
  {
    JustificationAppelGaecReduit dateDebut = ProduitSolAer05P01.getInstance().getDateDebutFenetrageAppelGaec(p_demande);
    p_gaecReduit.compareEtSetDateDebutFenetreAppel(dateDebut);
    
    p_gaecReduit.compareEtSetDateFinFenetreAppel(getDateExamen(p_demande), "Date d'examen", p_demande.getIdentifiant());
  }
  
  private static void initBornageServiceEnLiquidationSolCge01v01(DemandeSpec p_demande, AppelGaecReduit p_gaecReduit)
    throws ApplicativeException
  {
    JustificationAppelGaecReduit dateDebut = ProduitSolCge01P01.getInstance().getDateDebutFenetrageAppelGaec(p_demande);
    p_gaecReduit.compareEtSetDateDebutFenetreAppel(dateDebut);
    
    p_gaecReduit.compareEtSetDateFinFenetreAppel(getDateExamen(p_demande), "Date d'examen", p_demande.getIdentifiant());
  }
  
  private static Damj getDateExamen(DemandeSpec p_demande)
    throws ApplicativeException
  {
    try
    {
      boolean estContexteFinASR = "ASU_17".equals(p_demande.getEvenementReferenceExamen().getTypeExamen());
      boolean estdemandeEnCoursLiquidation = p_demande.estDemandeLiquidee();
      if (estContexteFinASR) {
        p_demande.setDemandeLiquidee(false);
      }
      DemandeSpec copieDemande = (DemandeSpec)p_demande.copie();
      Damj dateExamen = OutilDeterminationDateExamen.getInstance().determinerDateExamen(copieDemande);
      if (estContexteFinASR) {
        p_demande.setDemandeLiquidee(estdemandeEnCoursLiquidation);
      }
      return dateExamen;
    }
    catch (UnsupportedOperationException ex)
    {
      if ("L'individu GAEC n'a pas été chargé en début de service.".equals(ex.getMessage())) {
        return null;
      }
      throw ex;
    }
  }
  
  private static Damj getDateFaitGenerateurOdPrecedenteGammeAsu(DemandeSpec p_demande)
  {
    Damj dateFgdPrecedent = null;
    try
    {
      dateFgdPrecedent = GammeAsu.getInstance().getDateFaitGenerateurOdPrecedente(p_demande);
    }
    catch (UnsupportedOperationException ex)
    {
      if (!"L'individu GAEC n'a pas été chargé en début de service.".equals(ex.getMessage())) {
        throw ex;
      }
    }
    return dateFgdPrecedent;
  }
}

/* Location:
 * Qualified Name:     ReductionAppelGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
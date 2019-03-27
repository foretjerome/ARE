package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.LigneAsuCSR04;
import fr.unedic.cali.dom.affectation.LigneAsuCge01;
import fr.unedic.cali.dom.affectation.LigneAsuCsa06;
import fr.unedic.cali.dom.affectation.LigneAsuFds12;
import fr.unedic.cali.dom.affectation.LigneAsuSpe02;
import fr.unedic.cali.dom.affectation.LigneAsuSsp07;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuCaa14P01;
import fr.unedic.cali.dom.affectation.ProduitAsuCaa14P02;
import fr.unedic.cali.dom.affectation.ProduitAsuCva10P01;
import fr.unedic.cali.dom.affectation.ProduitAsuCva10P02;
import fr.unedic.cali.dom.affectation.ProduitAsuCve13P01;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourProduit;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreOU;

public final class OutilDemande
{
  public static boolean estUneDemandeRFPE(DemandeSpec demande)
  {
    boolean estUneDemandeRFPE = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere.getTypeExamen().equals("FOR_03")) {
      estUneDemandeRFPE = true;
    }
    return estUneDemandeRFPE;
  }
  
  public static boolean estUneDemandeRBF(DemandeSpec demande)
  {
    boolean estUneDemandeRBF = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if ((ere.getTypeExamen().equals("RBF_01")) || (ere.getTypeExamen().equals("RBF_02")) || (ere.getTypeExamen().equals("RBF_04")) || (ere.getTypeExamen().equals("RBF_03"))) {
      estUneDemandeRBF = true;
    }
    return estUneDemandeRBF;
  }
  
  public static boolean estUneDemandeExpresse(DemandeSpec demande)
  {
    boolean estUneDemandeExpresse = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (("ASU_02".equals(ere.getTypeExamen())) || ("SOL_07".equals(ere.getTypeExamen()))) {
      estUneDemandeExpresse = true;
    }
    return estUneDemandeExpresse;
  }
  
  public static boolean estUneDemandeAsr(DemandeSpec demande)
  {
    boolean estUneDemandeAsr = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere.getTypeExamen().equals("ASU_16")) {
      estUneDemandeAsr = true;
    }
    return estUneDemandeAsr;
  }
  
  public static boolean estUneDemandeFinDroitAsr(DemandeSpec demande)
  {
    boolean estUneDemandeAsr = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere.getTypeExamen().equals("ASU_17")) {
      estUneDemandeAsr = true;
    }
    return estUneDemandeAsr;
  }
  
  public static boolean estUneDemandeDeRevision(DemandeSpec demande)
  {
    boolean retour = false;
    if (demande.getEvenementReferenceExamen().getTypeExamen().equals("ASU_07")) {
      retour = true;
    }
    return retour;
  }
  
  public static boolean estUneDemandeDeRevisionAdmission(DemandeSpec demande)
  {
    boolean retour = false;
    if (demande.getEvenementReferenceExamen().getTypeExamen().equals("ASU_28")) {
      retour = true;
    }
    return retour;
  }
  
  public static boolean estUneDemandeAre(DemandeSpec demande)
  {
    boolean retour = false;
    if (demande.getNumeroGamme() == 1)
    {
      DossierAffectationSpec dossierAffectation = demande.getDossierAffectation();
      ProduitSpec produit = dossierAffectation.getProduit();
      LigneSpec ligne = produit.getLigne();
      retour = estUneDemandeAre(ligne);
    }
    return retour;
  }
  
  public static boolean estUneDemandeAre(LigneSpec ligne)
  {
    return (LigneAsuCge01.getInstance().equals(ligne)) || (LigneAsuSpe02.getInstance().equals(ligne)) || (LigneAsuCsa06.getInstance().equals(ligne)) || (LigneAsuCSR04.getInstance().equals(ligne));
  }
  
  public static boolean estUneDemandeAps(DemandeSpec demande)
  {
    boolean retour = false;
    if (demande.getNumeroGamme() == 1)
    {
      DossierAffectationSpec dossierAffectation = demande.getDossierAffectation();
      ProduitSpec produit = dossierAffectation.getProduit();
      LigneSpec ligne = produit.getLigne();
      retour = LigneAsuSsp07.getInstance().getNomUnique().equals(ligne.getNomUnique());
    }
    return retour;
  }
  
  public static boolean estUneDemandeAtp(DemandeSpec demande)
  {
    boolean estUneDemandeAtp = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if ((ere.getTypeExamen().equals("ASU_18")) || (ere.getTypeExamen().equals("ASU_20"))) {
      estUneDemandeAtp = true;
    }
    return estUneDemandeAtp;
  }
  
  public static boolean estUneDemandeBasculeAsrAtp(DemandeSpec demande)
  {
    boolean estUneDemandeBascule = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere.getTypeExamen().equals("ASU_20")) {
      estUneDemandeBascule = true;
    }
    return estUneDemandeBascule;
  }
  
  public static boolean estUneDemandeFinancement(DemandeSpec demande)
  {
    boolean estUneDemandeBascule = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere.getTypeExamen().equals("ASU_21")) {
      estUneDemandeBascule = true;
    }
    return estUneDemandeBascule;
  }
  
  public static boolean estUneDemandeFinDroitAtp(DemandeSpec demande)
  {
    boolean estUneDemandeAtp = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere.getTypeExamen().equals("ASU_19")) {
      estUneDemandeAtp = true;
    }
    return estUneDemandeAtp;
  }
  
  public static boolean estUneDemandeAsp(DemandeSpec demande)
  {
    boolean estUneDemandeAsp = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere.getTypeExamen().equals("ASU_24")) {
      estUneDemandeAsp = true;
    }
    return estUneDemandeAsp;
  }
  
  public static boolean estUneDemandeFinDroitAsp(DemandeSpec demande)
  {
    boolean estUneDemandeAsp = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere.getTypeExamen().equals("ASU_25")) {
      estUneDemandeAsp = true;
    }
    return estUneDemandeAsp;
  }
  
  public static boolean estUneDemandeAssurance(DemandeSpec demande)
  {
    boolean estUneDemandeAssurance = false;
    GammeSpec gamme = demande.getGamme();
    if (GammeAsu.getInstance().getNomUnique().equals(gamme.getNomUnique())) {
      estUneDemandeAssurance = true;
    }
    return estUneDemandeAssurance;
  }
  
  public static FiltreCaliSpec getFiltreAttributionAsuParType(DemandeSpec demande)
  {
    FiltreET filtres = new FiltreET();
    if (demande != null)
    {
      if (estUneDemandeBasculeAsrAtp(demande))
      {
        filtres.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
      }
      else if (estUneDemandeAtp(demande))
      {
        filtres.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
        FiltreOU filtreDemandeAsr = new FiltreOU();
        filtreDemandeAsr.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCaa14P01.getInstance().getCode()));
        filtreDemandeAsr.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCva10P01.getInstance().getCode()));
        FiltreOU filtreDemandeAsp = new FiltreOU();
        filtreDemandeAsp.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCaa14P02.getInstance().getCode()));
        filtreDemandeAsp.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCva10P02.getInstance().getCode()));
        filtres.ajouterFiltre(new FiltreNegation(filtreDemandeAsp));
        filtres.ajouterFiltre(new FiltreNegation(filtreDemandeAsr));
      }
      else if (estUneDemandeDeRevision(demande))
      {
        filtres.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
      }
      else if ("FOR_02".equals(demande.getEvenementReferenceExamen().getTypeExamen()))
      {
        filtres.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
        FiltreOU filtreDemandeAsr = new FiltreOU();
        filtreDemandeAsr.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCaa14P01.getInstance().getCode()));
        filtreDemandeAsr.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCva10P01.getInstance().getCode()));
        FiltreOU filtreDemandeAsp = new FiltreOU();
        filtreDemandeAsp.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCaa14P02.getInstance().getCode()));
        filtreDemandeAsp.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCva10P02.getInstance().getCode()));
        filtres.ajouterFiltre(new FiltreNegation(filtreDemandeAsp));
        filtres.ajouterFiltre(new FiltreNegation(filtreDemandeAsr));
      }
      else if (estUneDemandeAsp(demande))
      {
        filtres.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
        filtres.ajouterFiltre(new FiltreNegation(new FiltreDecisionPourProduit(ProduitAsuCve13P01.getInstance().getCode())));
        FiltreOU filtreDemandeAsr = new FiltreOU();
        filtreDemandeAsr.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCaa14P01.getInstance().getCode()));
        filtreDemandeAsr.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCva10P01.getInstance().getCode()));
        filtres.ajouterFiltre(new FiltreNegation(filtreDemandeAsr));
      }
      else
      {
        filtres.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
        filtres.ajouterFiltre(new FiltreNegation(new FiltreDecisionPourProduit(ProduitAsuCve13P01.getInstance().getCode())));
        FiltreOU filtreDemandeAsr = new FiltreOU();
        filtreDemandeAsr.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCaa14P01.getInstance().getCode()));
        filtreDemandeAsr.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCva10P01.getInstance().getCode()));
        FiltreOU filtreDemandeAsp = new FiltreOU();
        filtreDemandeAsp.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCaa14P02.getInstance().getCode()));
        filtreDemandeAsp.ajouterFiltre(new FiltreDecisionPourProduit(ProduitAsuCva10P02.getInstance().getCode()));
        filtres.ajouterFiltre(new FiltreNegation(filtreDemandeAsp));
        filtres.ajouterFiltre(new FiltreNegation(filtreDemandeAsr));
      }
    }
    else {
      filtres.ajouterFiltre(new FiltreDemandePourNumeroGamme(1));
    }
    return filtres;
  }
  
  public static boolean estUneDemandeRPS(DemandeSpec demande)
  {
    boolean estUneDemandeRPS = false;
    EvenementReferenceExamenSpec ere = demande.getEvenementReferenceExamen();
    if (ere.getTypeExamen().equals("FOR_01")) {
      estUneDemandeRPS = true;
    }
    return estUneDemandeRPS;
  }
  
  public static boolean estUneDemandeAfd(DemandeSpec demande)
  {
    boolean retour = false;
    if (demande.getNumeroGamme() == 1)
    {
      DossierAffectationSpec dossierAffectation = demande.getDossierAffectation();
      ProduitSpec produit = dossierAffectation.getProduit();
      LigneSpec ligne = produit.getLigne();
      retour = LigneAsuFds12.getInstance().getNomUnique().equals(ligne.getNomUnique());
    }
    return retour;
  }
  
  public static boolean estUneDemandeFinDroit(DemandeSpec demande)
  {
    return (estUneDemandeFinDroitAsp(demande)) || (estUneDemandeFinDroitAsr(demande)) || (estUneDemandeFinDroitAtp(demande));
  }
  
  public static boolean estUneDemandeFinDroitDeReconversion(String typeExamen)
  {
    boolean estUneDemandeFinDeDroitDeReconversion = false;
    if ((typeExamen.equals("ASU_25")) || (typeExamen.equals("ASU_17")) || (typeExamen.equals("ASU_19"))) {
      estUneDemandeFinDeDroitDeReconversion = true;
    }
    return estUneDemandeFinDeDroitDeReconversion;
  }
  
  public static boolean estUneDemandeV2(DemandeSpec demande)
  {
    boolean estUneDemandeV2 = false;
    return estUneDemandeV2;
  }
  
  public static boolean estUneDemandeFinDroitCasGeneral(DemandeSpec demande)
  {
    return (demande != null) && (demande.getEvenementReferenceExamen() != null) && ("ASU_29".equals(demande.getEvenementReferenceExamen().getTypeExamen()));
  }
  
  public static boolean estUneDemandeAgepi(DemandeSpec demande)
  {
    return (demande != null) && (demande.getEvenementReferenceExamen() != null) && ("RBF_04".equals(demande.getEvenementReferenceExamen().getTypeExamen()));
  }
  
  public static boolean estDemandeAttenteDecision(DemandeSpec demande)
  {
    return (!demande.estDecisionnee()) && (demande.getClassementAdministratif() == null);
  }
}

/* Location:
 * Qualified Name:     OutilDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
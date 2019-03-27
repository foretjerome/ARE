package fr.unedic.cali.calcul.pbjc.dom.pc;

import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import javax.jdo.JDOFatalInternalException;
import javax.jdo.JDOUnsupportedOptionException;
import javax.jdo.JDOUserException;
import javax.jdo.PersistenceManager;
import javax.jdo.spi.JDOImplHelper;
import javax.jdo.spi.JDOPermission;
import javax.jdo.spi.PersistenceCapable;
import javax.jdo.spi.PersistenceCapable.ObjectIdFieldConsumer;
import javax.jdo.spi.PersistenceCapable.ObjectIdFieldSupplier;
import javax.jdo.spi.StateManager;
import xcalia.lido.internal.sm.CommonStateManager;

public class PbjcNcpPC
  implements DomPCSpec, PersistenceCapable
{
  private transient PbjcNcp m_pbjcNcpOM;
  protected Damj m_dateDebutPbjc;
  protected Damj m_dateFinPbjc;
  protected int m_refOdPjcPremierFaitGenerateur;
  protected int m_refOdPjcFaitGenerateurOrigine;
  protected int m_identifiantReprise;
  protected int m_refBaseCalculMontantBrut;
  protected String m_produit;
  protected String m_etatReglementaireOd;
  protected String m_etatAdministratifOd;
  protected int m_rangProlongation;
  protected String m_naturePBJC;
  protected String m_codeRadiationLendemainPeriode;
  protected int m_nbJoursImputes;
  protected int m_nbJoursDecalage;
  protected int m_cumulCourant;
  protected int m_reliquatDureeMax;
  protected int m_reliquatDureeReglementaire;
  protected String m_justificationCalculMontant;
  protected String m_regimeApplicable;
  protected String m_typeCarence;
  protected BigDecimal m_montantSalaireRevalorisePlafonne;
  protected BigDecimal m_montantSjc;
  protected BigDecimal m_coefficientTempsPartiel;
  protected BigDecimal m_montantRessourceMensuel;
  protected int m_rangActualisationRessources;
  protected int m_anneePerceptionRessources;
  protected int m_moisPerceptionRessources;
  protected BigDecimal m_coefAvantageVieillesse;
  protected BigDecimal m_montantCumuleRevaloriseAV;
  protected int m_idPlanFormation;
  protected String m_typeDePlan;
  protected int m_idStageFormation;
  protected String m_typeMesurePourLEmploi;
  protected String m_codeEtatPND;
  protected BigDecimal m_montantBaseJustificatifPND;
  protected int m_statutPaiement;
  protected BigDecimal m_montantPensionInvalidite;
  protected String m_interrupIndemParPensionInvalidite;
  protected boolean m_plafonnementFTHR;
  protected boolean m_priseEnChargeAERC;
  protected String m_codeMotifNonPaiement;
  protected Damj m_dateDebutInterrupRess;
  protected int m_nbMoisActiviteReduite;
  protected int m_cumulHeureActRed;
  protected int m_nbMoisPaiementProvis;
  protected String m_aleIndividu;
  protected int m_txSanction;
  protected boolean m_topApplicationCRC;
  protected boolean m_topPlafonnementDureeDroitParDate;
  protected int m_nbJoursAREF;
  protected String m_complementDeJustification0;
  protected String m_complementDeJustification1;
  protected String m_complementDeJustification2;
  protected String m_complementDeJustification3;
  protected String m_complementDeJustification4;
  protected String m_complementDeJustification5;
  protected String m_complementDeJustification6;
  protected String m_complementDeJustification7;
  protected String m_complementDeJustification8;
  protected String m_complementDeJustification9;
  protected String m_codeTypeMontant1;
  protected int m_complementTypeMontant1;
  protected BigDecimal m_assiette1;
  protected BigDecimal m_baseDeCalcul1;
  protected BigDecimal m_taux1;
  protected BigDecimal m_resultatCalcul1;
  protected String m_positionExoneration1;
  protected String m_codeTypeMontant2;
  protected int m_complementTypeMontant2;
  protected BigDecimal m_assiette2;
  protected BigDecimal m_baseDeCalcul2;
  protected BigDecimal m_taux2;
  protected BigDecimal m_resultatCalcul2;
  protected String m_positionExoneration2;
  protected String m_codeTypeMontant3;
  protected int m_complementTypeMontant3;
  protected BigDecimal m_assiette3;
  protected BigDecimal m_baseDeCalcul3;
  protected BigDecimal m_taux3;
  protected BigDecimal m_resultatCalcul3;
  protected String m_positionExoneration3;
  protected String m_codeTypeMontant4;
  protected int m_complementTypeMontant4;
  protected BigDecimal m_assiette4;
  protected BigDecimal m_baseDeCalcul4;
  protected BigDecimal m_taux4;
  protected BigDecimal m_resultatCalcul4;
  protected String m_positionExoneration4;
  protected String m_codeTypeMontant5;
  protected int m_complementTypeMontant5;
  protected BigDecimal m_assiette5;
  protected BigDecimal m_baseDeCalcul5;
  protected BigDecimal m_taux5;
  protected BigDecimal m_resultatCalcul5;
  protected String m_positionExoneration5;
  protected String m_codeTypeMontant6;
  protected int m_complementTypeMontant6;
  protected BigDecimal m_assiette6;
  protected BigDecimal m_baseDeCalcul6;
  protected BigDecimal m_taux6;
  protected BigDecimal m_resultatCalcul6;
  protected String m_positionExoneration6;
  protected String m_codeTypeMontant7;
  protected int m_complementTypeMontant7;
  protected BigDecimal m_assiette7;
  protected BigDecimal m_baseDeCalcul7;
  protected BigDecimal m_taux7;
  protected BigDecimal m_resultatCalcul7;
  protected String m_positionExoneration7;
  protected String m_situationParticuliere;
  private String m_categorie;
  private String m_typeDispositif;
  private String m_codePays;
  private String m_typePopulation1;
  private String m_sousTypePopulation1;
  private String m_statutPrestation1;
  private String m_typePopulation2;
  private String m_sousTypePopulation2;
  private String m_statutPrestation2;
  private String m_typePopulation3;
  private String m_sousTypePopulation3;
  private String m_statutPrestation3;
  private String m_typePopulation4;
  private String m_sousTypePopulation4;
  private String m_statutPrestation4;
  private String m_typePopulation5;
  private String m_sousTypePopulation5;
  private String m_statutPrestation5;
  protected boolean m_presencePnds;
  protected BigDecimal m_montantContMensuelEmploiRepris;
  protected BigDecimal m_excedentsRemunerationMois;
  protected int m_reliquatAllongementAREF;
  protected int m_cumulAllongementPlan;
  protected int m_nbJoursAllongementAREF;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_dateDebutPbjc", "m_dateFinPbjc", "m_refOdPjcPremierFaitGenerateur", "m_refOdPjcFaitGenerateurOrigine", "m_identifiantReprise", "m_refBaseCalculMontantBrut", "m_produit", "m_etatReglementaireOd", "m_etatAdministratifOd", "m_rangProlongation", "m_naturePBJC", "m_codeRadiationLendemainPeriode", "m_nbJoursImputes", "m_nbJoursDecalage", "m_cumulCourant", "m_reliquatDureeMax", "m_reliquatDureeReglementaire", "m_justificationCalculMontant", "m_regimeApplicable", "m_typeCarence", "m_montantSalaireRevalorisePlafonne", "m_montantSjc", "m_coefficientTempsPartiel", "m_montantRessourceMensuel", "m_rangActualisationRessources", "m_anneePerceptionRessources", "m_moisPerceptionRessources", "m_coefAvantageVieillesse", "m_montantCumuleRevaloriseAV", "m_idPlanFormation", "m_typeDePlan", "m_idStageFormation", "m_typeMesurePourLEmploi", "m_codeEtatPND", "m_montantBaseJustificatifPND", "m_statutPaiement", "m_montantPensionInvalidite", "m_interrupIndemParPensionInvalidite", "m_plafonnementFTHR", "m_priseEnChargeAERC", "m_codeMotifNonPaiement", "m_dateDebutInterrupRess", "m_nbMoisActiviteReduite", "m_cumulHeureActRed", "m_nbMoisPaiementProvis", "m_aleIndividu", "m_txSanction", "m_topApplicationCRC", "m_topPlafonnementDureeDroitParDate", "m_nbJoursAREF", "m_complementDeJustification0", "m_complementDeJustification1", "m_complementDeJustification2", "m_complementDeJustification3", "m_complementDeJustification4", "m_complementDeJustification5", "m_complementDeJustification6", "m_complementDeJustification7", "m_complementDeJustification8", "m_complementDeJustification9", "m_codeTypeMontant1", "m_complementTypeMontant1", "m_assiette1", "m_baseDeCalcul1", "m_taux1", "m_resultatCalcul1", "m_positionExoneration1", "m_codeTypeMontant2", "m_complementTypeMontant2", "m_assiette2", "m_baseDeCalcul2", "m_taux2", "m_resultatCalcul2", "m_positionExoneration2", "m_codeTypeMontant3", "m_complementTypeMontant3", "m_assiette3", "m_baseDeCalcul3", "m_taux3", "m_resultatCalcul3", "m_positionExoneration3", "m_codeTypeMontant4", "m_complementTypeMontant4", "m_assiette4", "m_baseDeCalcul4", "m_taux4", "m_resultatCalcul4", "m_positionExoneration4", "m_codeTypeMontant5", "m_complementTypeMontant5", "m_assiette5", "m_baseDeCalcul5", "m_taux5", "m_resultatCalcul5", "m_positionExoneration5", "m_codeTypeMontant6", "m_complementTypeMontant6", "m_assiette6", "m_baseDeCalcul6", "m_taux6", "m_resultatCalcul6", "m_positionExoneration6", "m_codeTypeMontant7", "m_complementTypeMontant7", "m_assiette7", "m_baseDeCalcul7", "m_taux7", "m_resultatCalcul7", "m_positionExoneration7", "m_situationParticuliere", "m_categorie", "m_typeDispositif", "m_codePays", "m_typePopulation1", "m_sousTypePopulation1", "m_statutPrestation1", "m_typePopulation2", "m_sousTypePopulation2", "m_statutPrestation2", "m_typePopulation3", "m_sousTypePopulation3", "m_statutPrestation3", "m_typePopulation4", "m_sousTypePopulation4", "m_statutPrestation4", "m_typePopulation5", "m_sousTypePopulation5", "m_statutPrestation5", "m_presencePnds", "m_montantContMensuelEmploiRepris", "m_excedentsRemunerationMois", "m_reliquatAllongementAREF", "m_cumulAllongementPlan", "m_nbJoursAllongementAREF" };
  private static Class[] jdoFieldTypes = { Damj.class, Damj.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, String.class, String.class, Integer.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, String.class, String.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, BigDecimal.class, BigDecimal.class, Integer.TYPE, String.class, Integer.TYPE, String.class, String.class, BigDecimal.class, Integer.TYPE, BigDecimal.class, String.class, Boolean.TYPE, Boolean.TYPE, String.class, Damj.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, String.class, Integer.TYPE, Boolean.TYPE, Boolean.TYPE, Integer.TYPE, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, String.class, String.class, Integer.TYPE, BigDecimal.class, BigDecimal.class, BigDecimal.class, BigDecimal.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class, Boolean.TYPE, BigDecimal.class, BigDecimal.class, Integer.TYPE, Integer.TYPE, Integer.TYPE };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public Object createOM()
  {
    if (m_pbjcNcpOM == null) {
      m_pbjcNcpOM = new PbjcNcp(this);
    }
    return m_pbjcNcpOM;
  }
  
  public Damj getDateDebutPbjc()
  {
    return jdoGetm_dateDebutPbjc(this);
  }
  
  public final void setDateDebutPbjc(Damj p_dateDebutPbjc)
  {
    jdoSetm_dateDebutPbjc(this, p_dateDebutPbjc);
  }
  
  public Damj getDateFinPbjc()
  {
    return jdoGetm_dateFinPbjc(this);
  }
  
  public final void setDateFinPbjc(Damj p_dateFinPbjc)
  {
    jdoSetm_dateFinPbjc(this, p_dateFinPbjc);
  }
  
  public int getRefOdPjcPremierFaitGenerateur()
  {
    return jdoGetm_refOdPjcPremierFaitGenerateur(this);
  }
  
  public final void setRefOdPjcPremierFaitGenerateur(int p_refOdPjcPremierFaitGenerateur)
  {
    jdoSetm_refOdPjcPremierFaitGenerateur(this, p_refOdPjcPremierFaitGenerateur);
  }
  
  public int getRefOdPjcFaitGenerateurOrigine()
  {
    return jdoGetm_refOdPjcFaitGenerateurOrigine(this);
  }
  
  public final void setRefOdPjcFaitGenerateurOrigine(int p_refOdPjcFaitGenerateurOrigine)
  {
    jdoSetm_refOdPjcFaitGenerateurOrigine(this, p_refOdPjcFaitGenerateurOrigine);
  }
  
  public int getIdentifiantReprise()
  {
    return jdoGetm_identifiantReprise(this);
  }
  
  public final void setIdentifiantReprise(int p_identifiantReprise)
  {
    jdoSetm_identifiantReprise(this, p_identifiantReprise);
  }
  
  public int getRefBaseCalculMontantBrut()
  {
    return jdoGetm_refBaseCalculMontantBrut(this);
  }
  
  public final void setRefBaseCalculMontantBrut(int p_refBaseCalculMontantBrut)
  {
    jdoSetm_refBaseCalculMontantBrut(this, p_refBaseCalculMontantBrut);
  }
  
  public String getProduit()
  {
    return jdoGetm_produit(this);
  }
  
  public final void setProduit(String p_produit)
  {
    jdoSetm_produit(this, p_produit);
  }
  
  public String getEtatReglementaireOd()
  {
    return jdoGetm_etatReglementaireOd(this);
  }
  
  public final void setEtatReglementaireOd(String p_etatReglementaireOd)
  {
    jdoSetm_etatReglementaireOd(this, p_etatReglementaireOd);
  }
  
  public String getEtatAdministratifOd()
  {
    return jdoGetm_etatAdministratifOd(this);
  }
  
  public final void setEtatAdministratifOd(String p_etatAdministratifOd)
  {
    jdoSetm_etatAdministratifOd(this, p_etatAdministratifOd);
  }
  
  public int getRangProlongation()
  {
    return jdoGetm_rangProlongation(this);
  }
  
  public final void setRangProlongation(int p_rangProlongation)
  {
    jdoSetm_rangProlongation(this, p_rangProlongation);
  }
  
  public String getNaturePBJC()
  {
    return jdoGetm_naturePBJC(this);
  }
  
  public final void setNaturePBJC(String p_naturePBJC)
  {
    jdoSetm_naturePBJC(this, p_naturePBJC);
  }
  
  public String getCodeRadiationLendemainPeriode()
  {
    return jdoGetm_codeRadiationLendemainPeriode(this);
  }
  
  public final void setCodeRadiationLendemainPeriode(String p_codeRadiationLendemainPeriode)
  {
    jdoSetm_codeRadiationLendemainPeriode(this, p_codeRadiationLendemainPeriode);
  }
  
  public int getNbJoursImputes()
  {
    return jdoGetm_nbJoursImputes(this);
  }
  
  public final void setNbJoursImputes(int p_nbJoursImputes)
  {
    jdoSetm_nbJoursImputes(this, p_nbJoursImputes);
  }
  
  public int getNbJoursDecalage()
  {
    return jdoGetm_nbJoursDecalage(this);
  }
  
  public final void setNbJoursDecalage(int p_nbJoursDecalage)
  {
    jdoSetm_nbJoursDecalage(this, p_nbJoursDecalage);
  }
  
  public int getCumulCourant()
  {
    return jdoGetm_cumulCourant(this);
  }
  
  public final void setCumulCourant(int p_cumulCourant)
  {
    jdoSetm_cumulCourant(this, p_cumulCourant);
  }
  
  public int getReliquatDureeMax()
  {
    return jdoGetm_reliquatDureeMax(this);
  }
  
  public final void setReliquatDureeMax(int p_reliquatDureeMax)
  {
    jdoSetm_reliquatDureeMax(this, p_reliquatDureeMax);
  }
  
  public int getReliquatDureeReglementaire()
  {
    return jdoGetm_reliquatDureeReglementaire(this);
  }
  
  public final void setReliquatDureeReglementaire(int p_reliquatDureeReglementaire)
  {
    jdoSetm_reliquatDureeReglementaire(this, p_reliquatDureeReglementaire);
  }
  
  public String getJustificationCalculMontant()
  {
    return jdoGetm_justificationCalculMontant(this);
  }
  
  public final void setJustificationCalculMontant(String p_justificationCalculMontant)
  {
    jdoSetm_justificationCalculMontant(this, p_justificationCalculMontant);
  }
  
  public String getRegimeApplicable()
  {
    return jdoGetm_regimeApplicable(this);
  }
  
  public final void setRegimeApplicable(String p_regimeApplicable)
  {
    jdoSetm_regimeApplicable(this, p_regimeApplicable);
  }
  
  public String getTypeCarence()
  {
    return jdoGetm_typeCarence(this);
  }
  
  public final void setTypeCarence(String p_typeCarence)
  {
    jdoSetm_typeCarence(this, p_typeCarence);
  }
  
  public BigDecimal getMontantSalaireRevalorisePlafonne()
  {
    return jdoGetm_montantSalaireRevalorisePlafonne(this);
  }
  
  public final void setMontantSalaireRevalorisePlafonne(BigDecimal p_montantSalaireRevalorisePlafonne)
  {
    jdoSetm_montantSalaireRevalorisePlafonne(this, p_montantSalaireRevalorisePlafonne);
  }
  
  public BigDecimal getMontantSjc()
  {
    return jdoGetm_montantSjc(this);
  }
  
  public final void setMontantSjc(BigDecimal p_montantSjc)
  {
    jdoSetm_montantSjc(this, p_montantSjc);
  }
  
  public BigDecimal getCoefficientTempsPartiel()
  {
    return jdoGetm_coefficientTempsPartiel(this);
  }
  
  public final void setCoefficientTempsPartiel(BigDecimal p_coefficientTempsPartiel)
  {
    jdoSetm_coefficientTempsPartiel(this, p_coefficientTempsPartiel);
  }
  
  public BigDecimal getMontantRessourceMensuel()
  {
    return jdoGetm_montantRessourceMensuel(this);
  }
  
  public final void setMontantRessourceMensuel(BigDecimal p_montantRessourceMensuel)
  {
    jdoSetm_montantRessourceMensuel(this, p_montantRessourceMensuel);
  }
  
  public int getRangActualisationRessources()
  {
    return jdoGetm_rangActualisationRessources(this);
  }
  
  public final void setRangActualisationRessources(int p_rangActualisationRessources)
  {
    jdoSetm_rangActualisationRessources(this, p_rangActualisationRessources);
  }
  
  public int getAnneePerceptionRessources()
  {
    return jdoGetm_anneePerceptionRessources(this);
  }
  
  public final void setAnneePerceptionRessources(int p_anneePerceptionRessources)
  {
    jdoSetm_anneePerceptionRessources(this, p_anneePerceptionRessources);
  }
  
  public int getMoisPerceptionRessources()
  {
    return jdoGetm_moisPerceptionRessources(this);
  }
  
  public final void setMoisPerceptionRessources(int p_moisPerceptionRessources)
  {
    jdoSetm_moisPerceptionRessources(this, p_moisPerceptionRessources);
  }
  
  public BigDecimal getCoefAvantageVieillesse()
  {
    return jdoGetm_coefAvantageVieillesse(this);
  }
  
  public final void setCoefAvantageVieillesse(BigDecimal p_coefAvantageVieillesse)
  {
    jdoSetm_coefAvantageVieillesse(this, p_coefAvantageVieillesse);
  }
  
  public BigDecimal getMontantCumuleRevaloriseAV()
  {
    return jdoGetm_montantCumuleRevaloriseAV(this);
  }
  
  public final void setMontantCumuleRevaloriseAV(BigDecimal p_montantCumuleRevaloriseAV)
  {
    jdoSetm_montantCumuleRevaloriseAV(this, p_montantCumuleRevaloriseAV);
  }
  
  public int getIdPlanFormation()
  {
    return jdoGetm_idPlanFormation(this);
  }
  
  public final void setIdPlanFormation(int p_idPlanFormation)
  {
    jdoSetm_idPlanFormation(this, p_idPlanFormation);
  }
  
  public String getTypeDePlan()
  {
    return jdoGetm_typeDePlan(this);
  }
  
  public final void setTypeDePlan(String p_typeDePlan)
  {
    jdoSetm_typeDePlan(this, p_typeDePlan);
  }
  
  public int getIdStageFormation()
  {
    return jdoGetm_idStageFormation(this);
  }
  
  public final void setIdStageFormation(int p_idStageFormation)
  {
    jdoSetm_idStageFormation(this, p_idStageFormation);
  }
  
  public String getTypeMesurePourLEmploi()
  {
    return jdoGetm_typeMesurePourLEmploi(this);
  }
  
  public final void setTypeMesurePourLEmploi(String p_typeMesurePourLEmploi)
  {
    jdoSetm_typeMesurePourLEmploi(this, p_typeMesurePourLEmploi);
  }
  
  public String getCodeEtatPND()
  {
    return jdoGetm_codeEtatPND(this);
  }
  
  public final void setCodeEtatPND(String p_codeEtatPND)
  {
    jdoSetm_codeEtatPND(this, p_codeEtatPND);
  }
  
  public BigDecimal getMontantBaseJustificatifPND()
  {
    return jdoGetm_montantBaseJustificatifPND(this);
  }
  
  public final void setMontantBaseJustificatifPND(BigDecimal p_montantBaseJustificatifPND)
  {
    jdoSetm_montantBaseJustificatifPND(this, p_montantBaseJustificatifPND);
  }
  
  public int getStatutPaiement()
  {
    return jdoGetm_statutPaiement(this);
  }
  
  public final void setStatutPaiement(int p_statutPaiement)
  {
    jdoSetm_statutPaiement(this, p_statutPaiement);
  }
  
  public BigDecimal getMontantPensionInvalidite()
  {
    return jdoGetm_montantPensionInvalidite(this);
  }
  
  public final void setMontantPensionInvalidite(BigDecimal p_montantPensionInvalidite)
  {
    jdoSetm_montantPensionInvalidite(this, p_montantPensionInvalidite);
  }
  
  public String getInterrupIndemParPensionInvalidite()
  {
    return jdoGetm_interrupIndemParPensionInvalidite(this);
  }
  
  public final void setInterrupIndemParPensionInvalidite(String p_interrupIndemParPensionInvalidite)
  {
    jdoSetm_interrupIndemParPensionInvalidite(this, p_interrupIndemParPensionInvalidite);
  }
  
  public boolean isPlafonnementFTHR()
  {
    return jdoGetm_plafonnementFTHR(this);
  }
  
  public final void setPlafonnementFTHR(boolean p_plafonnementFTHR)
  {
    jdoSetm_plafonnementFTHR(this, p_plafonnementFTHR);
  }
  
  public boolean isPriseEnChargeAERC()
  {
    return jdoGetm_priseEnChargeAERC(this);
  }
  
  public final void setPriseEnChargeAERC(boolean p_priseEnChargeAERC)
  {
    jdoSetm_priseEnChargeAERC(this, p_priseEnChargeAERC);
  }
  
  public String getCodeMotifNonPaiement()
  {
    return jdoGetm_codeMotifNonPaiement(this);
  }
  
  public final void setCodeMotifNonPaiement(String p_codeMotifNonPaiement)
  {
    jdoSetm_codeMotifNonPaiement(this, p_codeMotifNonPaiement);
  }
  
  public Damj getDateDebutInterrupRess()
  {
    return jdoGetm_dateDebutInterrupRess(this);
  }
  
  public final void setDateDebutInterrupRess(Damj p_dateDebutInterrupRess)
  {
    jdoSetm_dateDebutInterrupRess(this, p_dateDebutInterrupRess);
  }
  
  public int getNbMoisActiviteReduite()
  {
    return jdoGetm_nbMoisActiviteReduite(this);
  }
  
  public final void setNbMoisActiviteReduite(int p_nbMoisActiviteReduite)
  {
    jdoSetm_nbMoisActiviteReduite(this, p_nbMoisActiviteReduite);
  }
  
  public int getCumulHeureActRed()
  {
    return jdoGetm_cumulHeureActRed(this);
  }
  
  public final void setCumulHeureActRed(int p_cumulHeureActRed)
  {
    jdoSetm_cumulHeureActRed(this, p_cumulHeureActRed);
  }
  
  public int getNbMoisPaiementProvis()
  {
    return jdoGetm_nbMoisPaiementProvis(this);
  }
  
  public final void setNbMoisPaiementProvis(int p_nbMoisPaiementProvis)
  {
    jdoSetm_nbMoisPaiementProvis(this, p_nbMoisPaiementProvis);
  }
  
  public String getAleIndividu()
  {
    return jdoGetm_aleIndividu(this);
  }
  
  public final void setAleIndividu(String p_aleIndividu)
  {
    jdoSetm_aleIndividu(this, p_aleIndividu);
  }
  
  public int getTxSanction()
  {
    return jdoGetm_txSanction(this);
  }
  
  public final void setTxSanction(int p_txSanction)
  {
    jdoSetm_txSanction(this, p_txSanction);
  }
  
  public boolean isTopApplicationCRC()
  {
    return jdoGetm_topApplicationCRC(this);
  }
  
  public final void setTopApplicationCRC(boolean p_topApplicationCRC)
  {
    jdoSetm_topApplicationCRC(this, p_topApplicationCRC);
  }
  
  public boolean isTopPlafonnementDureeDroitParDate()
  {
    return jdoGetm_topPlafonnementDureeDroitParDate(this);
  }
  
  public final void setTopPlafonnementDureeDroitParDate(boolean p_topPlafonnementDureeDroitParDate)
  {
    jdoSetm_topPlafonnementDureeDroitParDate(this, p_topPlafonnementDureeDroitParDate);
  }
  
  public int getNbJoursAREF()
  {
    return jdoGetm_nbJoursAREF(this);
  }
  
  public final void setNbJoursAREF(int p_nbJoursAREF)
  {
    jdoSetm_nbJoursAREF(this, p_nbJoursAREF);
  }
  
  public String getComplementDeJustification0()
  {
    return jdoGetm_complementDeJustification0(this);
  }
  
  public final void setComplementDeJustification0(String p_complementDeJustification0)
  {
    jdoSetm_complementDeJustification0(this, p_complementDeJustification0);
  }
  
  public String getComplementDeJustification1()
  {
    return jdoGetm_complementDeJustification1(this);
  }
  
  public final void setComplementDeJustification1(String p_complementDeJustification1)
  {
    jdoSetm_complementDeJustification1(this, p_complementDeJustification1);
  }
  
  public String getComplementDeJustification2()
  {
    return jdoGetm_complementDeJustification2(this);
  }
  
  public final void setComplementDeJustification2(String p_complementDeJustification2)
  {
    jdoSetm_complementDeJustification2(this, p_complementDeJustification2);
  }
  
  public String getComplementDeJustification3()
  {
    return jdoGetm_complementDeJustification3(this);
  }
  
  public final void setComplementDeJustification3(String p_complementDeJustification3)
  {
    jdoSetm_complementDeJustification3(this, p_complementDeJustification3);
  }
  
  public String getComplementDeJustification4()
  {
    return jdoGetm_complementDeJustification4(this);
  }
  
  public final void setComplementDeJustification4(String p_complementDeJustification4)
  {
    jdoSetm_complementDeJustification4(this, p_complementDeJustification4);
  }
  
  public String getComplementDeJustification5()
  {
    return jdoGetm_complementDeJustification5(this);
  }
  
  public final void setComplementDeJustification5(String p_complementDeJustification5)
  {
    jdoSetm_complementDeJustification5(this, p_complementDeJustification5);
  }
  
  public String getComplementDeJustification6()
  {
    return jdoGetm_complementDeJustification6(this);
  }
  
  public final void setComplementDeJustification6(String p_complementDeJustification6)
  {
    jdoSetm_complementDeJustification6(this, p_complementDeJustification6);
  }
  
  public String getComplementDeJustification7()
  {
    return jdoGetm_complementDeJustification7(this);
  }
  
  public final void setComplementDeJustification7(String p_complementDeJustification7)
  {
    jdoSetm_complementDeJustification7(this, p_complementDeJustification7);
  }
  
  public String getComplementDeJustification8()
  {
    return jdoGetm_complementDeJustification8(this);
  }
  
  public final void setComplementDeJustification8(String p_complementDeJustification8)
  {
    jdoSetm_complementDeJustification8(this, p_complementDeJustification8);
  }
  
  public String getComplementDeJustification9()
  {
    return jdoGetm_complementDeJustification9(this);
  }
  
  public final void setComplementDeJustification9(String p_complementDeJustification9)
  {
    jdoSetm_complementDeJustification9(this, p_complementDeJustification9);
  }
  
  public String getCodeTypeMontant1()
  {
    return jdoGetm_codeTypeMontant1(this);
  }
  
  public final void setCodeTypeMontant1(String p_codeTypeMontant1)
  {
    jdoSetm_codeTypeMontant1(this, p_codeTypeMontant1);
  }
  
  public int getComplementTypeMontant1()
  {
    return jdoGetm_complementTypeMontant1(this);
  }
  
  public final void setComplementTypeMontant1(int p_complementTypeMontant1)
  {
    jdoSetm_complementTypeMontant1(this, p_complementTypeMontant1);
  }
  
  public BigDecimal getAssiette1()
  {
    return jdoGetm_assiette1(this);
  }
  
  public final void setAssiette1(BigDecimal p_assiette1)
  {
    jdoSetm_assiette1(this, p_assiette1);
  }
  
  public BigDecimal getBaseDeCalcul1()
  {
    return jdoGetm_baseDeCalcul1(this);
  }
  
  public final void setBaseDeCalcul1(BigDecimal p_baseDeCalcul1)
  {
    jdoSetm_baseDeCalcul1(this, p_baseDeCalcul1);
  }
  
  public BigDecimal getTaux1()
  {
    return jdoGetm_taux1(this);
  }
  
  public final void setTaux1(BigDecimal p_taux1)
  {
    jdoSetm_taux1(this, p_taux1);
  }
  
  public BigDecimal getResultatCalcul1()
  {
    return jdoGetm_resultatCalcul1(this);
  }
  
  public final void setResultatCalcul1(BigDecimal p_resultatCalcul1)
  {
    jdoSetm_resultatCalcul1(this, p_resultatCalcul1);
  }
  
  public String getPositionExoneration1()
  {
    return jdoGetm_positionExoneration1(this);
  }
  
  public final void setPositionExoneration1(String p_positionExoneration1)
  {
    jdoSetm_positionExoneration1(this, p_positionExoneration1);
  }
  
  public String getCodeTypeMontant2()
  {
    return jdoGetm_codeTypeMontant2(this);
  }
  
  public final void setCodeTypeMontant2(String p_codeTypeMontant2)
  {
    jdoSetm_codeTypeMontant2(this, p_codeTypeMontant2);
  }
  
  public int getComplementTypeMontant2()
  {
    return jdoGetm_complementTypeMontant2(this);
  }
  
  public final void setComplementTypeMontant2(int p_complementTypeMontant2)
  {
    jdoSetm_complementTypeMontant2(this, p_complementTypeMontant2);
  }
  
  public BigDecimal getAssiette2()
  {
    return jdoGetm_assiette2(this);
  }
  
  public final void setAssiette2(BigDecimal p_assiette2)
  {
    jdoSetm_assiette2(this, p_assiette2);
  }
  
  public BigDecimal getBaseDeCalcul2()
  {
    return jdoGetm_baseDeCalcul2(this);
  }
  
  public final void setBaseDeCalcul2(BigDecimal p_baseDeCalcul2)
  {
    jdoSetm_baseDeCalcul2(this, p_baseDeCalcul2);
  }
  
  public BigDecimal getTaux2()
  {
    return jdoGetm_taux2(this);
  }
  
  public final void setTaux2(BigDecimal p_taux2)
  {
    jdoSetm_taux2(this, p_taux2);
  }
  
  public BigDecimal getResultatCalcul2()
  {
    return jdoGetm_resultatCalcul2(this);
  }
  
  public final void setResultatCalcul2(BigDecimal p_resultatCalcul2)
  {
    jdoSetm_resultatCalcul2(this, p_resultatCalcul2);
  }
  
  public String getPositionExoneration2()
  {
    return jdoGetm_positionExoneration2(this);
  }
  
  public final void setPositionExoneration2(String p_positionExoneration2)
  {
    jdoSetm_positionExoneration2(this, p_positionExoneration2);
  }
  
  public String getCodeTypeMontant3()
  {
    return jdoGetm_codeTypeMontant3(this);
  }
  
  public final void setCodeTypeMontant3(String p_codeTypeMontant3)
  {
    jdoSetm_codeTypeMontant3(this, p_codeTypeMontant3);
  }
  
  public int getComplementTypeMontant3()
  {
    return jdoGetm_complementTypeMontant3(this);
  }
  
  public final void setComplementTypeMontant3(int p_complementTypeMontant3)
  {
    jdoSetm_complementTypeMontant3(this, p_complementTypeMontant3);
  }
  
  public BigDecimal getAssiette3()
  {
    return jdoGetm_assiette3(this);
  }
  
  public final void setAssiette3(BigDecimal p_assiette3)
  {
    jdoSetm_assiette3(this, p_assiette3);
  }
  
  public BigDecimal getBaseDeCalcul3()
  {
    return jdoGetm_baseDeCalcul3(this);
  }
  
  public final void setBaseDeCalcul3(BigDecimal p_baseDeCalcul3)
  {
    jdoSetm_baseDeCalcul3(this, p_baseDeCalcul3);
  }
  
  public BigDecimal getTaux3()
  {
    return jdoGetm_taux3(this);
  }
  
  public final void setTaux3(BigDecimal p_taux3)
  {
    jdoSetm_taux3(this, p_taux3);
  }
  
  public BigDecimal getResultatCalcul3()
  {
    return jdoGetm_resultatCalcul3(this);
  }
  
  public final void setResultatCalcul3(BigDecimal p_resultatCalcul3)
  {
    jdoSetm_resultatCalcul3(this, p_resultatCalcul3);
  }
  
  public String getPositionExoneration3()
  {
    return jdoGetm_positionExoneration3(this);
  }
  
  public final void setPositionExoneration3(String p_positionExoneration3)
  {
    jdoSetm_positionExoneration3(this, p_positionExoneration3);
  }
  
  public String getCodeTypeMontant4()
  {
    return jdoGetm_codeTypeMontant4(this);
  }
  
  public final void setCodeTypeMontant4(String p_codeTypeMontant4)
  {
    jdoSetm_codeTypeMontant4(this, p_codeTypeMontant4);
  }
  
  public int getComplementTypeMontant4()
  {
    return jdoGetm_complementTypeMontant4(this);
  }
  
  public final void setComplementTypeMontant4(int p_complementTypeMontant4)
  {
    jdoSetm_complementTypeMontant4(this, p_complementTypeMontant4);
  }
  
  public BigDecimal getAssiette4()
  {
    return jdoGetm_assiette4(this);
  }
  
  public final void setAssiette4(BigDecimal p_assiette4)
  {
    jdoSetm_assiette4(this, p_assiette4);
  }
  
  public BigDecimal getBaseDeCalcul4()
  {
    return jdoGetm_baseDeCalcul4(this);
  }
  
  public final void setBaseDeCalcul4(BigDecimal p_baseDeCalcul4)
  {
    jdoSetm_baseDeCalcul4(this, p_baseDeCalcul4);
  }
  
  public BigDecimal getTaux4()
  {
    return jdoGetm_taux4(this);
  }
  
  public final void setTaux4(BigDecimal p_taux4)
  {
    jdoSetm_taux4(this, p_taux4);
  }
  
  public BigDecimal getResultatCalcul4()
  {
    return jdoGetm_resultatCalcul4(this);
  }
  
  public final void setResultatCalcul4(BigDecimal p_resultatCalcul4)
  {
    jdoSetm_resultatCalcul4(this, p_resultatCalcul4);
  }
  
  public String getPositionExoneration4()
  {
    return jdoGetm_positionExoneration4(this);
  }
  
  public final void setPositionExoneration4(String p_positionExoneration4)
  {
    jdoSetm_positionExoneration4(this, p_positionExoneration4);
  }
  
  public String getCodeTypeMontant5()
  {
    return jdoGetm_codeTypeMontant5(this);
  }
  
  public final void setCodeTypeMontant5(String p_codeTypeMontant5)
  {
    jdoSetm_codeTypeMontant5(this, p_codeTypeMontant5);
  }
  
  public int getComplementTypeMontant5()
  {
    return jdoGetm_complementTypeMontant5(this);
  }
  
  public final void setComplementTypeMontant5(int p_complementTypeMontant5)
  {
    jdoSetm_complementTypeMontant5(this, p_complementTypeMontant5);
  }
  
  public BigDecimal getAssiette5()
  {
    return jdoGetm_assiette5(this);
  }
  
  public final void setAssiette5(BigDecimal p_assiette5)
  {
    jdoSetm_assiette5(this, p_assiette5);
  }
  
  public BigDecimal getBaseDeCalcul5()
  {
    return jdoGetm_baseDeCalcul5(this);
  }
  
  public final void setBaseDeCalcul5(BigDecimal p_baseDeCalcul5)
  {
    jdoSetm_baseDeCalcul5(this, p_baseDeCalcul5);
  }
  
  public BigDecimal getTaux5()
  {
    return jdoGetm_taux5(this);
  }
  
  public final void setTaux5(BigDecimal p_taux5)
  {
    jdoSetm_taux5(this, p_taux5);
  }
  
  public BigDecimal getResultatCalcul5()
  {
    return jdoGetm_resultatCalcul5(this);
  }
  
  public final void setResultatCalcul5(BigDecimal p_resultatCalcul5)
  {
    jdoSetm_resultatCalcul5(this, p_resultatCalcul5);
  }
  
  public String getPositionExoneration5()
  {
    return jdoGetm_positionExoneration5(this);
  }
  
  public final void setPositionExoneration5(String p_positionExoneration5)
  {
    jdoSetm_positionExoneration5(this, p_positionExoneration5);
  }
  
  public String getCodeTypeMontant6()
  {
    return jdoGetm_codeTypeMontant6(this);
  }
  
  public final void setCodeTypeMontant6(String p_codeTypeMontant6)
  {
    jdoSetm_codeTypeMontant6(this, p_codeTypeMontant6);
  }
  
  public int getComplementTypeMontant6()
  {
    return jdoGetm_complementTypeMontant6(this);
  }
  
  public final void setComplementTypeMontant6(int p_complementTypeMontant6)
  {
    jdoSetm_complementTypeMontant6(this, p_complementTypeMontant6);
  }
  
  public BigDecimal getAssiette6()
  {
    return jdoGetm_assiette6(this);
  }
  
  public final void setAssiette6(BigDecimal p_assiette6)
  {
    jdoSetm_assiette6(this, p_assiette6);
  }
  
  public BigDecimal getBaseDeCalcul6()
  {
    return jdoGetm_baseDeCalcul6(this);
  }
  
  public final void setBaseDeCalcul6(BigDecimal p_baseDeCalcul6)
  {
    jdoSetm_baseDeCalcul6(this, p_baseDeCalcul6);
  }
  
  public BigDecimal getTaux6()
  {
    return jdoGetm_taux6(this);
  }
  
  public final void setTaux6(BigDecimal p_taux6)
  {
    jdoSetm_taux6(this, p_taux6);
  }
  
  public BigDecimal getResultatCalcul6()
  {
    return jdoGetm_resultatCalcul6(this);
  }
  
  public final void setResultatCalcul6(BigDecimal p_resultatCalcul6)
  {
    jdoSetm_resultatCalcul6(this, p_resultatCalcul6);
  }
  
  public String getPositionExoneration6()
  {
    return jdoGetm_positionExoneration6(this);
  }
  
  public final void setPositionExoneration6(String p_positionExoneration6)
  {
    jdoSetm_positionExoneration6(this, p_positionExoneration6);
  }
  
  public String getCodeTypeMontant7()
  {
    return jdoGetm_codeTypeMontant7(this);
  }
  
  public final void setCodeTypeMontant7(String p_codeTypeMontant7)
  {
    jdoSetm_codeTypeMontant7(this, p_codeTypeMontant7);
  }
  
  public int getComplementTypeMontant7()
  {
    return jdoGetm_complementTypeMontant7(this);
  }
  
  public final void setComplementTypeMontant7(int p_complementTypeMontant7)
  {
    jdoSetm_complementTypeMontant7(this, p_complementTypeMontant7);
  }
  
  public BigDecimal getAssiette7()
  {
    return jdoGetm_assiette7(this);
  }
  
  public final void setAssiette7(BigDecimal p_assiette7)
  {
    jdoSetm_assiette7(this, p_assiette7);
  }
  
  public BigDecimal getBaseDeCalcul7()
  {
    return jdoGetm_baseDeCalcul7(this);
  }
  
  public final void setBaseDeCalcul7(BigDecimal p_baseDeCalcul7)
  {
    jdoSetm_baseDeCalcul7(this, p_baseDeCalcul7);
  }
  
  public BigDecimal getTaux7()
  {
    return jdoGetm_taux7(this);
  }
  
  public final void setTaux7(BigDecimal p_taux7)
  {
    jdoSetm_taux7(this, p_taux7);
  }
  
  public BigDecimal getResultatCalcul7()
  {
    return jdoGetm_resultatCalcul7(this);
  }
  
  public final void setResultatCalcul7(BigDecimal p_resultatCalcul7)
  {
    jdoSetm_resultatCalcul7(this, p_resultatCalcul7);
  }
  
  public String getPositionExoneration7()
  {
    return jdoGetm_positionExoneration7(this);
  }
  
  public final void setPositionExoneration7(String p_positionExoneration7)
  {
    jdoSetm_positionExoneration7(this, p_positionExoneration7);
  }
  
  public String getSituationParticuliere()
  {
    return jdoGetm_situationParticuliere(this);
  }
  
  public final void setSituationParticuliere(String p_situationParticuliere)
  {
    jdoSetm_situationParticuliere(this, p_situationParticuliere);
  }
  
  public String getCategorie()
  {
    return jdoGetm_categorie(this);
  }
  
  public final void setCategorie(String p_categorie)
  {
    jdoSetm_categorie(this, p_categorie);
  }
  
  public String getTypeDispositif()
  {
    return jdoGetm_typeDispositif(this);
  }
  
  public final void setTypeDispositif(String p_typeDispositif)
  {
    jdoSetm_typeDispositif(this, p_typeDispositif);
  }
  
  public String getCodePays()
  {
    return jdoGetm_codePays(this);
  }
  
  public final void setCodePays(String p_codePays)
  {
    jdoSetm_codePays(this, p_codePays);
  }
  
  public String getTypePopulation1()
  {
    return jdoGetm_typePopulation1(this);
  }
  
  public final void setTypePopulation1(String p_typePopulation1)
  {
    jdoSetm_typePopulation1(this, p_typePopulation1);
  }
  
  public String getSousTypePopulation1()
  {
    return jdoGetm_sousTypePopulation1(this);
  }
  
  public final void setSousTypePopulation1(String p_sousTypePopulation1)
  {
    jdoSetm_sousTypePopulation1(this, p_sousTypePopulation1);
  }
  
  public String getStatutPrestation1()
  {
    return jdoGetm_statutPrestation1(this);
  }
  
  public final void setStatutPrestation1(String p_statutPrestation1)
  {
    jdoSetm_statutPrestation1(this, p_statutPrestation1);
  }
  
  public String getTypePopulation2()
  {
    return jdoGetm_typePopulation2(this);
  }
  
  public final void setTypePopulation2(String p_typePopulation2)
  {
    jdoSetm_typePopulation2(this, p_typePopulation2);
  }
  
  public String getSousTypePopulation2()
  {
    return jdoGetm_sousTypePopulation2(this);
  }
  
  public final void setSousTypePopulation2(String p_sousTypePopulation2)
  {
    jdoSetm_sousTypePopulation2(this, p_sousTypePopulation2);
  }
  
  public String getStatutPrestation2()
  {
    return jdoGetm_statutPrestation2(this);
  }
  
  public final void setStatutPrestation2(String p_statutPrestation2)
  {
    jdoSetm_statutPrestation2(this, p_statutPrestation2);
  }
  
  public String getTypePopulation3()
  {
    return jdoGetm_typePopulation3(this);
  }
  
  public final void setTypePopulation3(String p_typePopulation3)
  {
    jdoSetm_typePopulation3(this, p_typePopulation3);
  }
  
  public String getSousTypePopulation3()
  {
    return jdoGetm_sousTypePopulation3(this);
  }
  
  public final void setSousTypePopulation3(String p_sousTypePopulation3)
  {
    jdoSetm_sousTypePopulation3(this, p_sousTypePopulation3);
  }
  
  public String getStatutPrestation3()
  {
    return jdoGetm_statutPrestation3(this);
  }
  
  public final void setStatutPrestation3(String p_statutPrestation3)
  {
    jdoSetm_statutPrestation3(this, p_statutPrestation3);
  }
  
  public String getTypePopulation4()
  {
    return jdoGetm_typePopulation4(this);
  }
  
  public final void setTypePopulation4(String p_typePopulation4)
  {
    jdoSetm_typePopulation4(this, p_typePopulation4);
  }
  
  public String getSousTypePopulation4()
  {
    return jdoGetm_sousTypePopulation4(this);
  }
  
  public final void setSousTypePopulation4(String p_sousTypePopulation4)
  {
    jdoSetm_sousTypePopulation4(this, p_sousTypePopulation4);
  }
  
  public String getStatutPrestation4()
  {
    return jdoGetm_statutPrestation4(this);
  }
  
  public final void setStatutPrestation4(String p_statutPrestation4)
  {
    jdoSetm_statutPrestation4(this, p_statutPrestation4);
  }
  
  public String getTypePopulation5()
  {
    return jdoGetm_typePopulation5(this);
  }
  
  public final void setTypePopulation5(String p_typePopulation5)
  {
    jdoSetm_typePopulation5(this, p_typePopulation5);
  }
  
  public String getSousTypePopulation5()
  {
    return jdoGetm_sousTypePopulation5(this);
  }
  
  public final void setSousTypePopulation5(String p_sousTypePopulation5)
  {
    jdoSetm_sousTypePopulation5(this, p_sousTypePopulation5);
  }
  
  public String getStatutPrestation5()
  {
    return jdoGetm_statutPrestation5(this);
  }
  
  public final void setStatutPrestation5(String p_statutPrestation5)
  {
    jdoSetm_statutPrestation5(this, p_statutPrestation5);
  }
  
  public boolean isPresencePnds()
  {
    return jdoGetm_presencePnds(this);
  }
  
  public final void setPresencePnds(boolean p_presencePnds)
  {
    jdoSetm_presencePnds(this, p_presencePnds);
  }
  
  public BigDecimal getMontantContMensuelEmploiRepris()
  {
    return jdoGetm_montantContMensuelEmploiRepris(this);
  }
  
  public final void setMontantContMensuelEmploiRepris(BigDecimal p_montantContMensuelEmploiRepris)
  {
    jdoSetm_montantContMensuelEmploiRepris(this, p_montantContMensuelEmploiRepris);
  }
  
  public BigDecimal getExcedentsRemunerationMois()
  {
    return jdoGetm_excedentsRemunerationMois(this);
  }
  
  public final void setExcedentsRemunerationMois(BigDecimal p_excedentsRemunerationMois)
  {
    jdoSetm_excedentsRemunerationMois(this, p_excedentsRemunerationMois);
  }
  
  public int getReliquatAllongementAREF()
  {
    return jdoGetm_reliquatAllongementAREF(this);
  }
  
  public final void setReliquatAllongementAREF(int p_reliquatAllongementAREF)
  {
    jdoSetm_reliquatAllongementAREF(this, p_reliquatAllongementAREF);
  }
  
  public int getCumulAllongementPlan()
  {
    return jdoGetm_cumulAllongementPlan(this);
  }
  
  public final void setCumulAllongementPlan(int p_cumulAllongementPlan)
  {
    jdoSetm_cumulAllongementPlan(this, p_cumulAllongementPlan);
  }
  
  public int getNbJoursAllongementAREF()
  {
    return jdoGetm_nbJoursAllongementAREF(this);
  }
  
  public final void setNbJoursAllongementAREF(int p_nbJoursAllongementAREF)
  {
    jdoSetm_nbJoursAllongementAREF(this, p_nbJoursAllongementAREF);
  }
  
  static
  {
    JDOImplHelper.registerClass(PbjcNcpPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new PbjcNcpPC());
  }
  
  protected static final Damj jdoGetm_dateDebutPbjc(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutPbjc;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_dateDebutPbjc;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 0, m_dateDebutPbjc);
    }
    return m_dateDebutPbjc;
  }
  
  protected static final Damj jdoGetm_dateFinPbjc(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinPbjc;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_dateFinPbjc;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 1, m_dateFinPbjc);
    }
    return m_dateFinPbjc;
  }
  
  protected static final int jdoGetm_refOdPjcPremierFaitGenerateur(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_refOdPjcPremierFaitGenerateur;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_refOdPjcPremierFaitGenerateur;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 2, m_refOdPjcPremierFaitGenerateur);
    }
    return m_refOdPjcPremierFaitGenerateur;
  }
  
  protected static final int jdoGetm_refOdPjcFaitGenerateurOrigine(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_refOdPjcFaitGenerateurOrigine;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_refOdPjcFaitGenerateurOrigine;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 3, m_refOdPjcFaitGenerateurOrigine);
    }
    return m_refOdPjcFaitGenerateurOrigine;
  }
  
  protected static final int jdoGetm_identifiantReprise(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantReprise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_identifiantReprise;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 4, m_identifiantReprise);
    }
    return m_identifiantReprise;
  }
  
  protected static final int jdoGetm_refBaseCalculMontantBrut(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_refBaseCalculMontantBrut;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_refBaseCalculMontantBrut;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 5, m_refBaseCalculMontantBrut);
    }
    return m_refBaseCalculMontantBrut;
  }
  
  protected static final String jdoGetm_produit(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_produit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_produit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 6, m_produit);
    }
    return m_produit;
  }
  
  protected static final String jdoGetm_etatReglementaireOd(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etatReglementaireOd;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_etatReglementaireOd;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 7, m_etatReglementaireOd);
    }
    return m_etatReglementaireOd;
  }
  
  protected static final String jdoGetm_etatAdministratifOd(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etatAdministratifOd;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_etatAdministratifOd;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_etatAdministratifOd);
    }
    return m_etatAdministratifOd;
  }
  
  protected static final int jdoGetm_rangProlongation(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_rangProlongation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_rangProlongation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 9, m_rangProlongation);
    }
    return m_rangProlongation;
  }
  
  protected static final String jdoGetm_naturePBJC(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_naturePBJC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_naturePBJC;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 10, m_naturePBJC);
    }
    return m_naturePBJC;
  }
  
  protected static final String jdoGetm_codeRadiationLendemainPeriode(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeRadiationLendemainPeriode;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_codeRadiationLendemainPeriode;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 11, m_codeRadiationLendemainPeriode);
    }
    return m_codeRadiationLendemainPeriode;
  }
  
  protected static final int jdoGetm_nbJoursImputes(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursImputes;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_nbJoursImputes;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 12, m_nbJoursImputes);
    }
    return m_nbJoursImputes;
  }
  
  protected static final int jdoGetm_nbJoursDecalage(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursDecalage;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_nbJoursDecalage;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 13, m_nbJoursDecalage);
    }
    return m_nbJoursDecalage;
  }
  
  protected static final int jdoGetm_cumulCourant(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulCourant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_cumulCourant;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 14, m_cumulCourant);
    }
    return m_cumulCourant;
  }
  
  protected static final int jdoGetm_reliquatDureeMax(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatDureeMax;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_reliquatDureeMax;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 15, m_reliquatDureeMax);
    }
    return m_reliquatDureeMax;
  }
  
  protected static final int jdoGetm_reliquatDureeReglementaire(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatDureeReglementaire;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_reliquatDureeReglementaire;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 16, m_reliquatDureeReglementaire);
    }
    return m_reliquatDureeReglementaire;
  }
  
  protected static final String jdoGetm_justificationCalculMontant(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_justificationCalculMontant;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_justificationCalculMontant;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 17, m_justificationCalculMontant);
    }
    return m_justificationCalculMontant;
  }
  
  protected static final String jdoGetm_regimeApplicable(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_regimeApplicable;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_regimeApplicable;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 18, m_regimeApplicable);
    }
    return m_regimeApplicable;
  }
  
  protected static final String jdoGetm_typeCarence(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeCarence;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_typeCarence;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 19, m_typeCarence);
    }
    return m_typeCarence;
  }
  
  protected static final BigDecimal jdoGetm_montantSalaireRevalorisePlafonne(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSalaireRevalorisePlafonne;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_montantSalaireRevalorisePlafonne;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 20, m_montantSalaireRevalorisePlafonne);
    }
    return m_montantSalaireRevalorisePlafonne;
  }
  
  protected static final BigDecimal jdoGetm_montantSjc(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantSjc;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 21)) {
        return m_montantSjc;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 21, m_montantSjc);
    }
    return m_montantSjc;
  }
  
  protected static final BigDecimal jdoGetm_coefficientTempsPartiel(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_coefficientTempsPartiel;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 22)) {
        return m_coefficientTempsPartiel;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 22, m_coefficientTempsPartiel);
    }
    return m_coefficientTempsPartiel;
  }
  
  protected static final BigDecimal jdoGetm_montantRessourceMensuel(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantRessourceMensuel;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 23)) {
        return m_montantRessourceMensuel;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 23, m_montantRessourceMensuel);
    }
    return m_montantRessourceMensuel;
  }
  
  protected static final int jdoGetm_rangActualisationRessources(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_rangActualisationRessources;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 24)) {
        return m_rangActualisationRessources;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 24, m_rangActualisationRessources);
    }
    return m_rangActualisationRessources;
  }
  
  protected static final int jdoGetm_anneePerceptionRessources(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_anneePerceptionRessources;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 25)) {
        return m_anneePerceptionRessources;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 25, m_anneePerceptionRessources);
    }
    return m_anneePerceptionRessources;
  }
  
  protected static final int jdoGetm_moisPerceptionRessources(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_moisPerceptionRessources;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 26)) {
        return m_moisPerceptionRessources;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 26, m_moisPerceptionRessources);
    }
    return m_moisPerceptionRessources;
  }
  
  protected static final BigDecimal jdoGetm_coefAvantageVieillesse(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_coefAvantageVieillesse;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 27)) {
        return m_coefAvantageVieillesse;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 27, m_coefAvantageVieillesse);
    }
    return m_coefAvantageVieillesse;
  }
  
  protected static final BigDecimal jdoGetm_montantCumuleRevaloriseAV(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantCumuleRevaloriseAV;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 28)) {
        return m_montantCumuleRevaloriseAV;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 28, m_montantCumuleRevaloriseAV);
    }
    return m_montantCumuleRevaloriseAV;
  }
  
  protected static final int jdoGetm_idPlanFormation(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idPlanFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 29)) {
        return m_idPlanFormation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 29, m_idPlanFormation);
    }
    return m_idPlanFormation;
  }
  
  protected static final String jdoGetm_typeDePlan(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeDePlan;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 30)) {
        return m_typeDePlan;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 30, m_typeDePlan);
    }
    return m_typeDePlan;
  }
  
  protected static final int jdoGetm_idStageFormation(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idStageFormation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 31)) {
        return m_idStageFormation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 31, m_idStageFormation);
    }
    return m_idStageFormation;
  }
  
  protected static final String jdoGetm_typeMesurePourLEmploi(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeMesurePourLEmploi;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 32)) {
        return m_typeMesurePourLEmploi;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 32, m_typeMesurePourLEmploi);
    }
    return m_typeMesurePourLEmploi;
  }
  
  protected static final String jdoGetm_codeEtatPND(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeEtatPND;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 33)) {
        return m_codeEtatPND;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 33, m_codeEtatPND);
    }
    return m_codeEtatPND;
  }
  
  protected static final BigDecimal jdoGetm_montantBaseJustificatifPND(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantBaseJustificatifPND;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 34)) {
        return m_montantBaseJustificatifPND;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 34, m_montantBaseJustificatifPND);
    }
    return m_montantBaseJustificatifPND;
  }
  
  protected static final int jdoGetm_statutPaiement(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPaiement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 35)) {
        return m_statutPaiement;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 35, m_statutPaiement);
    }
    return m_statutPaiement;
  }
  
  protected static final BigDecimal jdoGetm_montantPensionInvalidite(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantPensionInvalidite;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 36)) {
        return m_montantPensionInvalidite;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 36, m_montantPensionInvalidite);
    }
    return m_montantPensionInvalidite;
  }
  
  protected static final String jdoGetm_interrupIndemParPensionInvalidite(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_interrupIndemParPensionInvalidite;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 37)) {
        return m_interrupIndemParPensionInvalidite;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 37, m_interrupIndemParPensionInvalidite);
    }
    return m_interrupIndemParPensionInvalidite;
  }
  
  protected static final boolean jdoGetm_plafonnementFTHR(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_plafonnementFTHR;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 38)) {
        return m_plafonnementFTHR;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 38, m_plafonnementFTHR);
    }
    return m_plafonnementFTHR;
  }
  
  protected static final boolean jdoGetm_priseEnChargeAERC(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_priseEnChargeAERC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 39)) {
        return m_priseEnChargeAERC;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 39, m_priseEnChargeAERC);
    }
    return m_priseEnChargeAERC;
  }
  
  protected static final String jdoGetm_codeMotifNonPaiement(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeMotifNonPaiement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 40)) {
        return m_codeMotifNonPaiement;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 40, m_codeMotifNonPaiement);
    }
    return m_codeMotifNonPaiement;
  }
  
  protected static final Damj jdoGetm_dateDebutInterrupRess(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutInterrupRess;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 41)) {
        return m_dateDebutInterrupRess;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 41, m_dateDebutInterrupRess);
    }
    return m_dateDebutInterrupRess;
  }
  
  protected static final int jdoGetm_nbMoisActiviteReduite(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbMoisActiviteReduite;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 42)) {
        return m_nbMoisActiviteReduite;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 42, m_nbMoisActiviteReduite);
    }
    return m_nbMoisActiviteReduite;
  }
  
  protected static final int jdoGetm_cumulHeureActRed(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulHeureActRed;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 43)) {
        return m_cumulHeureActRed;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 43, m_cumulHeureActRed);
    }
    return m_cumulHeureActRed;
  }
  
  protected static final int jdoGetm_nbMoisPaiementProvis(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbMoisPaiementProvis;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 44)) {
        return m_nbMoisPaiementProvis;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 44, m_nbMoisPaiementProvis);
    }
    return m_nbMoisPaiementProvis;
  }
  
  protected static final String jdoGetm_aleIndividu(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_aleIndividu;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 45)) {
        return m_aleIndividu;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 45, m_aleIndividu);
    }
    return m_aleIndividu;
  }
  
  protected static final int jdoGetm_txSanction(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_txSanction;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 46)) {
        return m_txSanction;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 46, m_txSanction);
    }
    return m_txSanction;
  }
  
  protected static final boolean jdoGetm_topApplicationCRC(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topApplicationCRC;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 47)) {
        return m_topApplicationCRC;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 47, m_topApplicationCRC);
    }
    return m_topApplicationCRC;
  }
  
  protected static final boolean jdoGetm_topPlafonnementDureeDroitParDate(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topPlafonnementDureeDroitParDate;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 48)) {
        return m_topPlafonnementDureeDroitParDate;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 48, m_topPlafonnementDureeDroitParDate);
    }
    return m_topPlafonnementDureeDroitParDate;
  }
  
  protected static final int jdoGetm_nbJoursAREF(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursAREF;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 49)) {
        return m_nbJoursAREF;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 49, m_nbJoursAREF);
    }
    return m_nbJoursAREF;
  }
  
  protected static final String jdoGetm_complementDeJustification0(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification0;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 50)) {
        return m_complementDeJustification0;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 50, m_complementDeJustification0);
    }
    return m_complementDeJustification0;
  }
  
  protected static final String jdoGetm_complementDeJustification1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 51)) {
        return m_complementDeJustification1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 51, m_complementDeJustification1);
    }
    return m_complementDeJustification1;
  }
  
  protected static final String jdoGetm_complementDeJustification2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 52)) {
        return m_complementDeJustification2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 52, m_complementDeJustification2);
    }
    return m_complementDeJustification2;
  }
  
  protected static final String jdoGetm_complementDeJustification3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 53)) {
        return m_complementDeJustification3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 53, m_complementDeJustification3);
    }
    return m_complementDeJustification3;
  }
  
  protected static final String jdoGetm_complementDeJustification4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 54)) {
        return m_complementDeJustification4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 54, m_complementDeJustification4);
    }
    return m_complementDeJustification4;
  }
  
  protected static final String jdoGetm_complementDeJustification5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 55)) {
        return m_complementDeJustification5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 55, m_complementDeJustification5);
    }
    return m_complementDeJustification5;
  }
  
  protected static final String jdoGetm_complementDeJustification6(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification6;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 56)) {
        return m_complementDeJustification6;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 56, m_complementDeJustification6);
    }
    return m_complementDeJustification6;
  }
  
  protected static final String jdoGetm_complementDeJustification7(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification7;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 57)) {
        return m_complementDeJustification7;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 57, m_complementDeJustification7);
    }
    return m_complementDeJustification7;
  }
  
  protected static final String jdoGetm_complementDeJustification8(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification8;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 58)) {
        return m_complementDeJustification8;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 58, m_complementDeJustification8);
    }
    return m_complementDeJustification8;
  }
  
  protected static final String jdoGetm_complementDeJustification9(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementDeJustification9;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 59)) {
        return m_complementDeJustification9;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 59, m_complementDeJustification9);
    }
    return m_complementDeJustification9;
  }
  
  protected static final String jdoGetm_codeTypeMontant1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTypeMontant1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 60)) {
        return m_codeTypeMontant1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 60, m_codeTypeMontant1);
    }
    return m_codeTypeMontant1;
  }
  
  protected static final int jdoGetm_complementTypeMontant1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 61)) {
        return m_complementTypeMontant1;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 61, m_complementTypeMontant1);
    }
    return m_complementTypeMontant1;
  }
  
  protected static final BigDecimal jdoGetm_assiette1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_assiette1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 62)) {
        return m_assiette1;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 62, m_assiette1);
    }
    return m_assiette1;
  }
  
  protected static final BigDecimal jdoGetm_baseDeCalcul1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_baseDeCalcul1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 63)) {
        return m_baseDeCalcul1;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 63, m_baseDeCalcul1);
    }
    return m_baseDeCalcul1;
  }
  
  protected static final BigDecimal jdoGetm_taux1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_taux1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 64)) {
        return m_taux1;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 64, m_taux1);
    }
    return m_taux1;
  }
  
  protected static final BigDecimal jdoGetm_resultatCalcul1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_resultatCalcul1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 65)) {
        return m_resultatCalcul1;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 65, m_resultatCalcul1);
    }
    return m_resultatCalcul1;
  }
  
  protected static final String jdoGetm_positionExoneration1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_positionExoneration1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 66)) {
        return m_positionExoneration1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 66, m_positionExoneration1);
    }
    return m_positionExoneration1;
  }
  
  protected static final String jdoGetm_codeTypeMontant2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTypeMontant2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 67)) {
        return m_codeTypeMontant2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 67, m_codeTypeMontant2);
    }
    return m_codeTypeMontant2;
  }
  
  protected static final int jdoGetm_complementTypeMontant2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 68)) {
        return m_complementTypeMontant2;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 68, m_complementTypeMontant2);
    }
    return m_complementTypeMontant2;
  }
  
  protected static final BigDecimal jdoGetm_assiette2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_assiette2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 69)) {
        return m_assiette2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 69, m_assiette2);
    }
    return m_assiette2;
  }
  
  protected static final BigDecimal jdoGetm_baseDeCalcul2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_baseDeCalcul2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 70)) {
        return m_baseDeCalcul2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 70, m_baseDeCalcul2);
    }
    return m_baseDeCalcul2;
  }
  
  protected static final BigDecimal jdoGetm_taux2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_taux2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 71)) {
        return m_taux2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 71, m_taux2);
    }
    return m_taux2;
  }
  
  protected static final BigDecimal jdoGetm_resultatCalcul2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_resultatCalcul2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 72)) {
        return m_resultatCalcul2;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 72, m_resultatCalcul2);
    }
    return m_resultatCalcul2;
  }
  
  protected static final String jdoGetm_positionExoneration2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_positionExoneration2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 73)) {
        return m_positionExoneration2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 73, m_positionExoneration2);
    }
    return m_positionExoneration2;
  }
  
  protected static final String jdoGetm_codeTypeMontant3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTypeMontant3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 74)) {
        return m_codeTypeMontant3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 74, m_codeTypeMontant3);
    }
    return m_codeTypeMontant3;
  }
  
  protected static final int jdoGetm_complementTypeMontant3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 75)) {
        return m_complementTypeMontant3;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 75, m_complementTypeMontant3);
    }
    return m_complementTypeMontant3;
  }
  
  protected static final BigDecimal jdoGetm_assiette3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_assiette3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 76)) {
        return m_assiette3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 76, m_assiette3);
    }
    return m_assiette3;
  }
  
  protected static final BigDecimal jdoGetm_baseDeCalcul3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_baseDeCalcul3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 77)) {
        return m_baseDeCalcul3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 77, m_baseDeCalcul3);
    }
    return m_baseDeCalcul3;
  }
  
  protected static final BigDecimal jdoGetm_taux3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_taux3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 78)) {
        return m_taux3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 78, m_taux3);
    }
    return m_taux3;
  }
  
  protected static final BigDecimal jdoGetm_resultatCalcul3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_resultatCalcul3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 79)) {
        return m_resultatCalcul3;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 79, m_resultatCalcul3);
    }
    return m_resultatCalcul3;
  }
  
  protected static final String jdoGetm_positionExoneration3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_positionExoneration3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 80)) {
        return m_positionExoneration3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 80, m_positionExoneration3);
    }
    return m_positionExoneration3;
  }
  
  protected static final String jdoGetm_codeTypeMontant4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTypeMontant4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 81)) {
        return m_codeTypeMontant4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 81, m_codeTypeMontant4);
    }
    return m_codeTypeMontant4;
  }
  
  protected static final int jdoGetm_complementTypeMontant4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 82)) {
        return m_complementTypeMontant4;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 82, m_complementTypeMontant4);
    }
    return m_complementTypeMontant4;
  }
  
  protected static final BigDecimal jdoGetm_assiette4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_assiette4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 83)) {
        return m_assiette4;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 83, m_assiette4);
    }
    return m_assiette4;
  }
  
  protected static final BigDecimal jdoGetm_baseDeCalcul4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_baseDeCalcul4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 84)) {
        return m_baseDeCalcul4;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 84, m_baseDeCalcul4);
    }
    return m_baseDeCalcul4;
  }
  
  protected static final BigDecimal jdoGetm_taux4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_taux4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 85)) {
        return m_taux4;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 85, m_taux4);
    }
    return m_taux4;
  }
  
  protected static final BigDecimal jdoGetm_resultatCalcul4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_resultatCalcul4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 86)) {
        return m_resultatCalcul4;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 86, m_resultatCalcul4);
    }
    return m_resultatCalcul4;
  }
  
  protected static final String jdoGetm_positionExoneration4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_positionExoneration4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 87)) {
        return m_positionExoneration4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 87, m_positionExoneration4);
    }
    return m_positionExoneration4;
  }
  
  protected static final String jdoGetm_codeTypeMontant5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTypeMontant5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 88)) {
        return m_codeTypeMontant5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 88, m_codeTypeMontant5);
    }
    return m_codeTypeMontant5;
  }
  
  protected static final int jdoGetm_complementTypeMontant5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 89)) {
        return m_complementTypeMontant5;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 89, m_complementTypeMontant5);
    }
    return m_complementTypeMontant5;
  }
  
  protected static final BigDecimal jdoGetm_assiette5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_assiette5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 90)) {
        return m_assiette5;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 90, m_assiette5);
    }
    return m_assiette5;
  }
  
  protected static final BigDecimal jdoGetm_baseDeCalcul5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_baseDeCalcul5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 91)) {
        return m_baseDeCalcul5;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 91, m_baseDeCalcul5);
    }
    return m_baseDeCalcul5;
  }
  
  protected static final BigDecimal jdoGetm_taux5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_taux5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 92)) {
        return m_taux5;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 92, m_taux5);
    }
    return m_taux5;
  }
  
  protected static final BigDecimal jdoGetm_resultatCalcul5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_resultatCalcul5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 93)) {
        return m_resultatCalcul5;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 93, m_resultatCalcul5);
    }
    return m_resultatCalcul5;
  }
  
  protected static final String jdoGetm_positionExoneration5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_positionExoneration5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 94)) {
        return m_positionExoneration5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 94, m_positionExoneration5);
    }
    return m_positionExoneration5;
  }
  
  protected static final String jdoGetm_codeTypeMontant6(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTypeMontant6;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 95)) {
        return m_codeTypeMontant6;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 95, m_codeTypeMontant6);
    }
    return m_codeTypeMontant6;
  }
  
  protected static final int jdoGetm_complementTypeMontant6(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant6;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 96)) {
        return m_complementTypeMontant6;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 96, m_complementTypeMontant6);
    }
    return m_complementTypeMontant6;
  }
  
  protected static final BigDecimal jdoGetm_assiette6(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_assiette6;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 97)) {
        return m_assiette6;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 97, m_assiette6);
    }
    return m_assiette6;
  }
  
  protected static final BigDecimal jdoGetm_baseDeCalcul6(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_baseDeCalcul6;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 98)) {
        return m_baseDeCalcul6;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 98, m_baseDeCalcul6);
    }
    return m_baseDeCalcul6;
  }
  
  protected static final BigDecimal jdoGetm_taux6(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_taux6;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 99)) {
        return m_taux6;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 99, m_taux6);
    }
    return m_taux6;
  }
  
  protected static final BigDecimal jdoGetm_resultatCalcul6(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_resultatCalcul6;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 100)) {
        return m_resultatCalcul6;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 100, m_resultatCalcul6);
    }
    return m_resultatCalcul6;
  }
  
  protected static final String jdoGetm_positionExoneration6(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_positionExoneration6;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 101)) {
        return m_positionExoneration6;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 101, m_positionExoneration6);
    }
    return m_positionExoneration6;
  }
  
  protected static final String jdoGetm_codeTypeMontant7(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeTypeMontant7;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 102)) {
        return m_codeTypeMontant7;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 102, m_codeTypeMontant7);
    }
    return m_codeTypeMontant7;
  }
  
  protected static final int jdoGetm_complementTypeMontant7(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_complementTypeMontant7;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 103)) {
        return m_complementTypeMontant7;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 103, m_complementTypeMontant7);
    }
    return m_complementTypeMontant7;
  }
  
  protected static final BigDecimal jdoGetm_assiette7(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_assiette7;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 104)) {
        return m_assiette7;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 104, m_assiette7);
    }
    return m_assiette7;
  }
  
  protected static final BigDecimal jdoGetm_baseDeCalcul7(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_baseDeCalcul7;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 105)) {
        return m_baseDeCalcul7;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 105, m_baseDeCalcul7);
    }
    return m_baseDeCalcul7;
  }
  
  protected static final BigDecimal jdoGetm_taux7(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_taux7;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 106)) {
        return m_taux7;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 106, m_taux7);
    }
    return m_taux7;
  }
  
  protected static final BigDecimal jdoGetm_resultatCalcul7(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_resultatCalcul7;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 107)) {
        return m_resultatCalcul7;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 107, m_resultatCalcul7);
    }
    return m_resultatCalcul7;
  }
  
  protected static final String jdoGetm_positionExoneration7(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_positionExoneration7;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 108)) {
        return m_positionExoneration7;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 108, m_positionExoneration7);
    }
    return m_positionExoneration7;
  }
  
  protected static final String jdoGetm_situationParticuliere(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_situationParticuliere;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 109)) {
        return m_situationParticuliere;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 109, m_situationParticuliere);
    }
    return m_situationParticuliere;
  }
  
  private static final String jdoGetm_categorie(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_categorie;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 110)) {
        return m_categorie;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 110, m_categorie);
    }
    return m_categorie;
  }
  
  private static final String jdoGetm_typeDispositif(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeDispositif;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 111)) {
        return m_typeDispositif;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 111, m_typeDispositif);
    }
    return m_typeDispositif;
  }
  
  private static final String jdoGetm_codePays(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codePays;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 112)) {
        return m_codePays;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 112, m_codePays);
    }
    return m_codePays;
  }
  
  private static final String jdoGetm_typePopulation1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 113)) {
        return m_typePopulation1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 113, m_typePopulation1);
    }
    return m_typePopulation1;
  }
  
  private static final String jdoGetm_sousTypePopulation1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 114)) {
        return m_sousTypePopulation1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 114, m_sousTypePopulation1);
    }
    return m_sousTypePopulation1;
  }
  
  private static final String jdoGetm_statutPrestation1(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation1;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 115)) {
        return m_statutPrestation1;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 115, m_statutPrestation1);
    }
    return m_statutPrestation1;
  }
  
  private static final String jdoGetm_typePopulation2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 116)) {
        return m_typePopulation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 116, m_typePopulation2);
    }
    return m_typePopulation2;
  }
  
  private static final String jdoGetm_sousTypePopulation2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 117)) {
        return m_sousTypePopulation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 117, m_sousTypePopulation2);
    }
    return m_sousTypePopulation2;
  }
  
  private static final String jdoGetm_statutPrestation2(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 118)) {
        return m_statutPrestation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 118, m_statutPrestation2);
    }
    return m_statutPrestation2;
  }
  
  private static final String jdoGetm_typePopulation3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 119)) {
        return m_typePopulation3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 119, m_typePopulation3);
    }
    return m_typePopulation3;
  }
  
  private static final String jdoGetm_sousTypePopulation3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 120)) {
        return m_sousTypePopulation3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 120, m_sousTypePopulation3);
    }
    return m_sousTypePopulation3;
  }
  
  private static final String jdoGetm_statutPrestation3(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation3;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 121)) {
        return m_statutPrestation3;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 121, m_statutPrestation3);
    }
    return m_statutPrestation3;
  }
  
  private static final String jdoGetm_typePopulation4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 122)) {
        return m_typePopulation4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 122, m_typePopulation4);
    }
    return m_typePopulation4;
  }
  
  private static final String jdoGetm_sousTypePopulation4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 123)) {
        return m_sousTypePopulation4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 123, m_sousTypePopulation4);
    }
    return m_sousTypePopulation4;
  }
  
  private static final String jdoGetm_statutPrestation4(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation4;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 124)) {
        return m_statutPrestation4;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 124, m_statutPrestation4);
    }
    return m_statutPrestation4;
  }
  
  private static final String jdoGetm_typePopulation5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePopulation5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 125)) {
        return m_typePopulation5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 125, m_typePopulation5);
    }
    return m_typePopulation5;
  }
  
  private static final String jdoGetm_sousTypePopulation5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_sousTypePopulation5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 126)) {
        return m_sousTypePopulation5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 126, m_sousTypePopulation5);
    }
    return m_sousTypePopulation5;
  }
  
  private static final String jdoGetm_statutPrestation5(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_statutPrestation5;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 127)) {
        return m_statutPrestation5;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 127, m_statutPrestation5);
    }
    return m_statutPrestation5;
  }
  
  protected static final boolean jdoGetm_presencePnds(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_presencePnds;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 128)) {
        return m_presencePnds;
      }
      return sm.getBooleanField(pc, jdoInheritedFieldCount + 128, m_presencePnds);
    }
    return m_presencePnds;
  }
  
  protected static final BigDecimal jdoGetm_montantContMensuelEmploiRepris(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_montantContMensuelEmploiRepris;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 129)) {
        return m_montantContMensuelEmploiRepris;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 129, m_montantContMensuelEmploiRepris);
    }
    return m_montantContMensuelEmploiRepris;
  }
  
  protected static final BigDecimal jdoGetm_excedentsRemunerationMois(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_excedentsRemunerationMois;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 130)) {
        return m_excedentsRemunerationMois;
      }
      return (BigDecimal)sm.getObjectField(pc, jdoInheritedFieldCount + 130, m_excedentsRemunerationMois);
    }
    return m_excedentsRemunerationMois;
  }
  
  protected static final int jdoGetm_reliquatAllongementAREF(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_reliquatAllongementAREF;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 131)) {
        return m_reliquatAllongementAREF;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 131, m_reliquatAllongementAREF);
    }
    return m_reliquatAllongementAREF;
  }
  
  protected static final int jdoGetm_cumulAllongementPlan(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_cumulAllongementPlan;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 132)) {
        return m_cumulAllongementPlan;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 132, m_cumulAllongementPlan);
    }
    return m_cumulAllongementPlan;
  }
  
  protected static final int jdoGetm_nbJoursAllongementAREF(PbjcNcpPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursAllongementAREF;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 133)) {
        return m_nbJoursAllongementAREF;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 133, m_nbJoursAllongementAREF);
    }
    return m_nbJoursAllongementAREF;
  }
  
  protected static final void jdoSetm_dateDebutPbjc(PbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutPbjc = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 0, m_dateDebutPbjc, newValue);
    } else {
      m_dateDebutPbjc = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinPbjc(PbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinPbjc = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 1, m_dateFinPbjc, newValue);
    } else {
      m_dateFinPbjc = newValue;
    }
  }
  
  protected static final void jdoSetm_refOdPjcPremierFaitGenerateur(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_refOdPjcPremierFaitGenerateur = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 2, m_refOdPjcPremierFaitGenerateur, newValue);
    } else {
      m_refOdPjcPremierFaitGenerateur = newValue;
    }
  }
  
  protected static final void jdoSetm_refOdPjcFaitGenerateurOrigine(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_refOdPjcFaitGenerateurOrigine = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 3, m_refOdPjcFaitGenerateurOrigine, newValue);
    } else {
      m_refOdPjcFaitGenerateurOrigine = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantReprise(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantReprise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 4, m_identifiantReprise, newValue);
    } else {
      m_identifiantReprise = newValue;
    }
  }
  
  protected static final void jdoSetm_refBaseCalculMontantBrut(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_refBaseCalculMontantBrut = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 5, m_refBaseCalculMontantBrut, newValue);
    } else {
      m_refBaseCalculMontantBrut = newValue;
    }
  }
  
  protected static final void jdoSetm_produit(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_produit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 6, m_produit, newValue);
    } else {
      m_produit = newValue;
    }
  }
  
  protected static final void jdoSetm_etatReglementaireOd(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_etatReglementaireOd = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 7, m_etatReglementaireOd, newValue);
    } else {
      m_etatReglementaireOd = newValue;
    }
  }
  
  protected static final void jdoSetm_etatAdministratifOd(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_etatAdministratifOd = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_etatAdministratifOd, newValue);
    } else {
      m_etatAdministratifOd = newValue;
    }
  }
  
  protected static final void jdoSetm_rangProlongation(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_rangProlongation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 9, m_rangProlongation, newValue);
    } else {
      m_rangProlongation = newValue;
    }
  }
  
  protected static final void jdoSetm_naturePBJC(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_naturePBJC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 10, m_naturePBJC, newValue);
    } else {
      m_naturePBJC = newValue;
    }
  }
  
  protected static final void jdoSetm_codeRadiationLendemainPeriode(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeRadiationLendemainPeriode = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 11, m_codeRadiationLendemainPeriode, newValue);
    } else {
      m_codeRadiationLendemainPeriode = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursImputes(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursImputes = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 12, m_nbJoursImputes, newValue);
    } else {
      m_nbJoursImputes = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursDecalage(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursDecalage = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 13, m_nbJoursDecalage, newValue);
    } else {
      m_nbJoursDecalage = newValue;
    }
  }
  
  protected static final void jdoSetm_cumulCourant(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulCourant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 14, m_cumulCourant, newValue);
    } else {
      m_cumulCourant = newValue;
    }
  }
  
  protected static final void jdoSetm_reliquatDureeMax(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatDureeMax = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 15, m_reliquatDureeMax, newValue);
    } else {
      m_reliquatDureeMax = newValue;
    }
  }
  
  protected static final void jdoSetm_reliquatDureeReglementaire(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatDureeReglementaire = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 16, m_reliquatDureeReglementaire, newValue);
    } else {
      m_reliquatDureeReglementaire = newValue;
    }
  }
  
  protected static final void jdoSetm_justificationCalculMontant(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_justificationCalculMontant = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 17, m_justificationCalculMontant, newValue);
    } else {
      m_justificationCalculMontant = newValue;
    }
  }
  
  protected static final void jdoSetm_regimeApplicable(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_regimeApplicable = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 18, m_regimeApplicable, newValue);
    } else {
      m_regimeApplicable = newValue;
    }
  }
  
  protected static final void jdoSetm_typeCarence(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeCarence = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 19, m_typeCarence, newValue);
    } else {
      m_typeCarence = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSalaireRevalorisePlafonne(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSalaireRevalorisePlafonne = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 20, m_montantSalaireRevalorisePlafonne, newValue);
    } else {
      m_montantSalaireRevalorisePlafonne = newValue;
    }
  }
  
  protected static final void jdoSetm_montantSjc(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantSjc = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 21, m_montantSjc, newValue);
    } else {
      m_montantSjc = newValue;
    }
  }
  
  protected static final void jdoSetm_coefficientTempsPartiel(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_coefficientTempsPartiel = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 22, m_coefficientTempsPartiel, newValue);
    } else {
      m_coefficientTempsPartiel = newValue;
    }
  }
  
  protected static final void jdoSetm_montantRessourceMensuel(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantRessourceMensuel = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 23, m_montantRessourceMensuel, newValue);
    } else {
      m_montantRessourceMensuel = newValue;
    }
  }
  
  protected static final void jdoSetm_rangActualisationRessources(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_rangActualisationRessources = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 24, m_rangActualisationRessources, newValue);
    } else {
      m_rangActualisationRessources = newValue;
    }
  }
  
  protected static final void jdoSetm_anneePerceptionRessources(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_anneePerceptionRessources = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 25, m_anneePerceptionRessources, newValue);
    } else {
      m_anneePerceptionRessources = newValue;
    }
  }
  
  protected static final void jdoSetm_moisPerceptionRessources(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_moisPerceptionRessources = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 26, m_moisPerceptionRessources, newValue);
    } else {
      m_moisPerceptionRessources = newValue;
    }
  }
  
  protected static final void jdoSetm_coefAvantageVieillesse(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_coefAvantageVieillesse = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 27, m_coefAvantageVieillesse, newValue);
    } else {
      m_coefAvantageVieillesse = newValue;
    }
  }
  
  protected static final void jdoSetm_montantCumuleRevaloriseAV(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantCumuleRevaloriseAV = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 28, m_montantCumuleRevaloriseAV, newValue);
    } else {
      m_montantCumuleRevaloriseAV = newValue;
    }
  }
  
  protected static final void jdoSetm_idPlanFormation(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_idPlanFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 29, m_idPlanFormation, newValue);
    } else {
      m_idPlanFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_typeDePlan(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeDePlan = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 30, m_typeDePlan, newValue);
    } else {
      m_typeDePlan = newValue;
    }
  }
  
  protected static final void jdoSetm_idStageFormation(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_idStageFormation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 31, m_idStageFormation, newValue);
    } else {
      m_idStageFormation = newValue;
    }
  }
  
  protected static final void jdoSetm_typeMesurePourLEmploi(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeMesurePourLEmploi = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 32, m_typeMesurePourLEmploi, newValue);
    } else {
      m_typeMesurePourLEmploi = newValue;
    }
  }
  
  protected static final void jdoSetm_codeEtatPND(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeEtatPND = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 33, m_codeEtatPND, newValue);
    } else {
      m_codeEtatPND = newValue;
    }
  }
  
  protected static final void jdoSetm_montantBaseJustificatifPND(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantBaseJustificatifPND = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 34, m_montantBaseJustificatifPND, newValue);
    } else {
      m_montantBaseJustificatifPND = newValue;
    }
  }
  
  protected static final void jdoSetm_statutPaiement(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPaiement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 35, m_statutPaiement, newValue);
    } else {
      m_statutPaiement = newValue;
    }
  }
  
  protected static final void jdoSetm_montantPensionInvalidite(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantPensionInvalidite = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 36, m_montantPensionInvalidite, newValue);
    } else {
      m_montantPensionInvalidite = newValue;
    }
  }
  
  protected static final void jdoSetm_interrupIndemParPensionInvalidite(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_interrupIndemParPensionInvalidite = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 37, m_interrupIndemParPensionInvalidite, newValue);
    } else {
      m_interrupIndemParPensionInvalidite = newValue;
    }
  }
  
  protected static final void jdoSetm_plafonnementFTHR(PbjcNcpPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_plafonnementFTHR = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 38, m_plafonnementFTHR, newValue);
    } else {
      m_plafonnementFTHR = newValue;
    }
  }
  
  protected static final void jdoSetm_priseEnChargeAERC(PbjcNcpPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_priseEnChargeAERC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 39, m_priseEnChargeAERC, newValue);
    } else {
      m_priseEnChargeAERC = newValue;
    }
  }
  
  protected static final void jdoSetm_codeMotifNonPaiement(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeMotifNonPaiement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 40, m_codeMotifNonPaiement, newValue);
    } else {
      m_codeMotifNonPaiement = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutInterrupRess(PbjcNcpPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutInterrupRess = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 41, m_dateDebutInterrupRess, newValue);
    } else {
      m_dateDebutInterrupRess = newValue;
    }
  }
  
  protected static final void jdoSetm_nbMoisActiviteReduite(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbMoisActiviteReduite = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 42, m_nbMoisActiviteReduite, newValue);
    } else {
      m_nbMoisActiviteReduite = newValue;
    }
  }
  
  protected static final void jdoSetm_cumulHeureActRed(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulHeureActRed = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 43, m_cumulHeureActRed, newValue);
    } else {
      m_cumulHeureActRed = newValue;
    }
  }
  
  protected static final void jdoSetm_nbMoisPaiementProvis(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbMoisPaiementProvis = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 44, m_nbMoisPaiementProvis, newValue);
    } else {
      m_nbMoisPaiementProvis = newValue;
    }
  }
  
  protected static final void jdoSetm_aleIndividu(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_aleIndividu = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 45, m_aleIndividu, newValue);
    } else {
      m_aleIndividu = newValue;
    }
  }
  
  protected static final void jdoSetm_txSanction(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_txSanction = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 46, m_txSanction, newValue);
    } else {
      m_txSanction = newValue;
    }
  }
  
  protected static final void jdoSetm_topApplicationCRC(PbjcNcpPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_topApplicationCRC = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 47, m_topApplicationCRC, newValue);
    } else {
      m_topApplicationCRC = newValue;
    }
  }
  
  protected static final void jdoSetm_topPlafonnementDureeDroitParDate(PbjcNcpPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_topPlafonnementDureeDroitParDate = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 48, m_topPlafonnementDureeDroitParDate, newValue);
    } else {
      m_topPlafonnementDureeDroitParDate = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursAREF(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursAREF = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 49, m_nbJoursAREF, newValue);
    } else {
      m_nbJoursAREF = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification0(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification0 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 50, m_complementDeJustification0, newValue);
    } else {
      m_complementDeJustification0 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification1(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 51, m_complementDeJustification1, newValue);
    } else {
      m_complementDeJustification1 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification2(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 52, m_complementDeJustification2, newValue);
    } else {
      m_complementDeJustification2 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification3(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 53, m_complementDeJustification3, newValue);
    } else {
      m_complementDeJustification3 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification4(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 54, m_complementDeJustification4, newValue);
    } else {
      m_complementDeJustification4 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification5(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 55, m_complementDeJustification5, newValue);
    } else {
      m_complementDeJustification5 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification6(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification6 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 56, m_complementDeJustification6, newValue);
    } else {
      m_complementDeJustification6 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification7(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification7 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 57, m_complementDeJustification7, newValue);
    } else {
      m_complementDeJustification7 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification8(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification8 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 58, m_complementDeJustification8, newValue);
    } else {
      m_complementDeJustification8 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementDeJustification9(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementDeJustification9 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 59, m_complementDeJustification9, newValue);
    } else {
      m_complementDeJustification9 = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTypeMontant1(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTypeMontant1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 60, m_codeTypeMontant1, newValue);
    } else {
      m_codeTypeMontant1 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementTypeMontant1(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 61, m_complementTypeMontant1, newValue);
    } else {
      m_complementTypeMontant1 = newValue;
    }
  }
  
  protected static final void jdoSetm_assiette1(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_assiette1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 62, m_assiette1, newValue);
    } else {
      m_assiette1 = newValue;
    }
  }
  
  protected static final void jdoSetm_baseDeCalcul1(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_baseDeCalcul1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 63, m_baseDeCalcul1, newValue);
    } else {
      m_baseDeCalcul1 = newValue;
    }
  }
  
  protected static final void jdoSetm_taux1(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_taux1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 64, m_taux1, newValue);
    } else {
      m_taux1 = newValue;
    }
  }
  
  protected static final void jdoSetm_resultatCalcul1(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_resultatCalcul1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 65, m_resultatCalcul1, newValue);
    } else {
      m_resultatCalcul1 = newValue;
    }
  }
  
  protected static final void jdoSetm_positionExoneration1(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_positionExoneration1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 66, m_positionExoneration1, newValue);
    } else {
      m_positionExoneration1 = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTypeMontant2(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTypeMontant2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 67, m_codeTypeMontant2, newValue);
    } else {
      m_codeTypeMontant2 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementTypeMontant2(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 68, m_complementTypeMontant2, newValue);
    } else {
      m_complementTypeMontant2 = newValue;
    }
  }
  
  protected static final void jdoSetm_assiette2(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_assiette2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 69, m_assiette2, newValue);
    } else {
      m_assiette2 = newValue;
    }
  }
  
  protected static final void jdoSetm_baseDeCalcul2(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_baseDeCalcul2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 70, m_baseDeCalcul2, newValue);
    } else {
      m_baseDeCalcul2 = newValue;
    }
  }
  
  protected static final void jdoSetm_taux2(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_taux2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 71, m_taux2, newValue);
    } else {
      m_taux2 = newValue;
    }
  }
  
  protected static final void jdoSetm_resultatCalcul2(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_resultatCalcul2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 72, m_resultatCalcul2, newValue);
    } else {
      m_resultatCalcul2 = newValue;
    }
  }
  
  protected static final void jdoSetm_positionExoneration2(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_positionExoneration2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 73, m_positionExoneration2, newValue);
    } else {
      m_positionExoneration2 = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTypeMontant3(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTypeMontant3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 74, m_codeTypeMontant3, newValue);
    } else {
      m_codeTypeMontant3 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementTypeMontant3(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 75, m_complementTypeMontant3, newValue);
    } else {
      m_complementTypeMontant3 = newValue;
    }
  }
  
  protected static final void jdoSetm_assiette3(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_assiette3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 76, m_assiette3, newValue);
    } else {
      m_assiette3 = newValue;
    }
  }
  
  protected static final void jdoSetm_baseDeCalcul3(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_baseDeCalcul3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 77, m_baseDeCalcul3, newValue);
    } else {
      m_baseDeCalcul3 = newValue;
    }
  }
  
  protected static final void jdoSetm_taux3(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_taux3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 78, m_taux3, newValue);
    } else {
      m_taux3 = newValue;
    }
  }
  
  protected static final void jdoSetm_resultatCalcul3(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_resultatCalcul3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 79, m_resultatCalcul3, newValue);
    } else {
      m_resultatCalcul3 = newValue;
    }
  }
  
  protected static final void jdoSetm_positionExoneration3(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_positionExoneration3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 80, m_positionExoneration3, newValue);
    } else {
      m_positionExoneration3 = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTypeMontant4(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTypeMontant4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 81, m_codeTypeMontant4, newValue);
    } else {
      m_codeTypeMontant4 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementTypeMontant4(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 82, m_complementTypeMontant4, newValue);
    } else {
      m_complementTypeMontant4 = newValue;
    }
  }
  
  protected static final void jdoSetm_assiette4(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_assiette4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 83, m_assiette4, newValue);
    } else {
      m_assiette4 = newValue;
    }
  }
  
  protected static final void jdoSetm_baseDeCalcul4(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_baseDeCalcul4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 84, m_baseDeCalcul4, newValue);
    } else {
      m_baseDeCalcul4 = newValue;
    }
  }
  
  protected static final void jdoSetm_taux4(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_taux4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 85, m_taux4, newValue);
    } else {
      m_taux4 = newValue;
    }
  }
  
  protected static final void jdoSetm_resultatCalcul4(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_resultatCalcul4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 86, m_resultatCalcul4, newValue);
    } else {
      m_resultatCalcul4 = newValue;
    }
  }
  
  protected static final void jdoSetm_positionExoneration4(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_positionExoneration4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 87, m_positionExoneration4, newValue);
    } else {
      m_positionExoneration4 = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTypeMontant5(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTypeMontant5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 88, m_codeTypeMontant5, newValue);
    } else {
      m_codeTypeMontant5 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementTypeMontant5(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 89, m_complementTypeMontant5, newValue);
    } else {
      m_complementTypeMontant5 = newValue;
    }
  }
  
  protected static final void jdoSetm_assiette5(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_assiette5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 90, m_assiette5, newValue);
    } else {
      m_assiette5 = newValue;
    }
  }
  
  protected static final void jdoSetm_baseDeCalcul5(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_baseDeCalcul5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 91, m_baseDeCalcul5, newValue);
    } else {
      m_baseDeCalcul5 = newValue;
    }
  }
  
  protected static final void jdoSetm_taux5(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_taux5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 92, m_taux5, newValue);
    } else {
      m_taux5 = newValue;
    }
  }
  
  protected static final void jdoSetm_resultatCalcul5(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_resultatCalcul5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 93, m_resultatCalcul5, newValue);
    } else {
      m_resultatCalcul5 = newValue;
    }
  }
  
  protected static final void jdoSetm_positionExoneration5(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_positionExoneration5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 94, m_positionExoneration5, newValue);
    } else {
      m_positionExoneration5 = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTypeMontant6(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTypeMontant6 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 95, m_codeTypeMontant6, newValue);
    } else {
      m_codeTypeMontant6 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementTypeMontant6(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant6 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 96, m_complementTypeMontant6, newValue);
    } else {
      m_complementTypeMontant6 = newValue;
    }
  }
  
  protected static final void jdoSetm_assiette6(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_assiette6 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 97, m_assiette6, newValue);
    } else {
      m_assiette6 = newValue;
    }
  }
  
  protected static final void jdoSetm_baseDeCalcul6(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_baseDeCalcul6 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 98, m_baseDeCalcul6, newValue);
    } else {
      m_baseDeCalcul6 = newValue;
    }
  }
  
  protected static final void jdoSetm_taux6(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_taux6 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 99, m_taux6, newValue);
    } else {
      m_taux6 = newValue;
    }
  }
  
  protected static final void jdoSetm_resultatCalcul6(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_resultatCalcul6 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 100, m_resultatCalcul6, newValue);
    } else {
      m_resultatCalcul6 = newValue;
    }
  }
  
  protected static final void jdoSetm_positionExoneration6(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_positionExoneration6 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 101, m_positionExoneration6, newValue);
    } else {
      m_positionExoneration6 = newValue;
    }
  }
  
  protected static final void jdoSetm_codeTypeMontant7(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeTypeMontant7 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 102, m_codeTypeMontant7, newValue);
    } else {
      m_codeTypeMontant7 = newValue;
    }
  }
  
  protected static final void jdoSetm_complementTypeMontant7(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_complementTypeMontant7 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 103, m_complementTypeMontant7, newValue);
    } else {
      m_complementTypeMontant7 = newValue;
    }
  }
  
  protected static final void jdoSetm_assiette7(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_assiette7 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 104, m_assiette7, newValue);
    } else {
      m_assiette7 = newValue;
    }
  }
  
  protected static final void jdoSetm_baseDeCalcul7(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_baseDeCalcul7 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 105, m_baseDeCalcul7, newValue);
    } else {
      m_baseDeCalcul7 = newValue;
    }
  }
  
  protected static final void jdoSetm_taux7(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_taux7 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 106, m_taux7, newValue);
    } else {
      m_taux7 = newValue;
    }
  }
  
  protected static final void jdoSetm_resultatCalcul7(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_resultatCalcul7 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 107, m_resultatCalcul7, newValue);
    } else {
      m_resultatCalcul7 = newValue;
    }
  }
  
  protected static final void jdoSetm_positionExoneration7(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_positionExoneration7 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 108, m_positionExoneration7, newValue);
    } else {
      m_positionExoneration7 = newValue;
    }
  }
  
  protected static final void jdoSetm_situationParticuliere(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_situationParticuliere = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 109, m_situationParticuliere, newValue);
    } else {
      m_situationParticuliere = newValue;
    }
  }
  
  private static final void jdoSetm_categorie(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_categorie = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 110, m_categorie, newValue);
    } else {
      m_categorie = newValue;
    }
  }
  
  private static final void jdoSetm_typeDispositif(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeDispositif = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 111, m_typeDispositif, newValue);
    } else {
      m_typeDispositif = newValue;
    }
  }
  
  private static final void jdoSetm_codePays(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codePays = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 112, m_codePays, newValue);
    } else {
      m_codePays = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation1(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 113, m_typePopulation1, newValue);
    } else {
      m_typePopulation1 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation1(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 114, m_sousTypePopulation1, newValue);
    } else {
      m_sousTypePopulation1 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation1(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation1 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 115, m_statutPrestation1, newValue);
    } else {
      m_statutPrestation1 = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation2(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 116, m_typePopulation2, newValue);
    } else {
      m_typePopulation2 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation2(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 117, m_sousTypePopulation2, newValue);
    } else {
      m_sousTypePopulation2 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation2(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 118, m_statutPrestation2, newValue);
    } else {
      m_statutPrestation2 = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation3(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 119, m_typePopulation3, newValue);
    } else {
      m_typePopulation3 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation3(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 120, m_sousTypePopulation3, newValue);
    } else {
      m_sousTypePopulation3 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation3(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation3 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 121, m_statutPrestation3, newValue);
    } else {
      m_statutPrestation3 = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation4(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 122, m_typePopulation4, newValue);
    } else {
      m_typePopulation4 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation4(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 123, m_sousTypePopulation4, newValue);
    } else {
      m_sousTypePopulation4 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation4(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation4 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 124, m_statutPrestation4, newValue);
    } else {
      m_statutPrestation4 = newValue;
    }
  }
  
  private static final void jdoSetm_typePopulation5(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePopulation5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 125, m_typePopulation5, newValue);
    } else {
      m_typePopulation5 = newValue;
    }
  }
  
  private static final void jdoSetm_sousTypePopulation5(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_sousTypePopulation5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 126, m_sousTypePopulation5, newValue);
    } else {
      m_sousTypePopulation5 = newValue;
    }
  }
  
  private static final void jdoSetm_statutPrestation5(PbjcNcpPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_statutPrestation5 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 127, m_statutPrestation5, newValue);
    } else {
      m_statutPrestation5 = newValue;
    }
  }
  
  protected static final void jdoSetm_presencePnds(PbjcNcpPC pc, boolean newValue)
  {
    if (jdoFlags == 0)
    {
      m_presencePnds = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setBooleanField(pc, jdoInheritedFieldCount + 128, m_presencePnds, newValue);
    } else {
      m_presencePnds = newValue;
    }
  }
  
  protected static final void jdoSetm_montantContMensuelEmploiRepris(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_montantContMensuelEmploiRepris = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 129, m_montantContMensuelEmploiRepris, newValue);
    } else {
      m_montantContMensuelEmploiRepris = newValue;
    }
  }
  
  protected static final void jdoSetm_excedentsRemunerationMois(PbjcNcpPC pc, BigDecimal newValue)
  {
    if (jdoFlags == 0)
    {
      m_excedentsRemunerationMois = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 130, m_excedentsRemunerationMois, newValue);
    } else {
      m_excedentsRemunerationMois = newValue;
    }
  }
  
  protected static final void jdoSetm_reliquatAllongementAREF(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_reliquatAllongementAREF = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 131, m_reliquatAllongementAREF, newValue);
    } else {
      m_reliquatAllongementAREF = newValue;
    }
  }
  
  protected static final void jdoSetm_cumulAllongementPlan(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_cumulAllongementPlan = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 132, m_cumulAllongementPlan, newValue);
    } else {
      m_cumulAllongementPlan = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursAllongementAREF(PbjcNcpPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursAllongementAREF = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 133, m_nbJoursAllongementAREF, newValue);
    } else {
      m_nbJoursAllongementAREF = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutPbjc);
      break;
    case 1: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinPbjc);
      break;
    case 2: 
      jdoStateManager.providedIntField(this, fieldNumber, m_refOdPjcPremierFaitGenerateur);
      break;
    case 3: 
      jdoStateManager.providedIntField(this, fieldNumber, m_refOdPjcFaitGenerateurOrigine);
      break;
    case 4: 
      jdoStateManager.providedIntField(this, fieldNumber, m_identifiantReprise);
      break;
    case 5: 
      jdoStateManager.providedIntField(this, fieldNumber, m_refBaseCalculMontantBrut);
      break;
    case 6: 
      jdoStateManager.providedStringField(this, fieldNumber, m_produit);
      break;
    case 7: 
      jdoStateManager.providedStringField(this, fieldNumber, m_etatReglementaireOd);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_etatAdministratifOd);
      break;
    case 9: 
      jdoStateManager.providedIntField(this, fieldNumber, m_rangProlongation);
      break;
    case 10: 
      jdoStateManager.providedStringField(this, fieldNumber, m_naturePBJC);
      break;
    case 11: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeRadiationLendemainPeriode);
      break;
    case 12: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursImputes);
      break;
    case 13: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursDecalage);
      break;
    case 14: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulCourant);
      break;
    case 15: 
      jdoStateManager.providedIntField(this, fieldNumber, m_reliquatDureeMax);
      break;
    case 16: 
      jdoStateManager.providedIntField(this, fieldNumber, m_reliquatDureeReglementaire);
      break;
    case 17: 
      jdoStateManager.providedStringField(this, fieldNumber, m_justificationCalculMontant);
      break;
    case 18: 
      jdoStateManager.providedStringField(this, fieldNumber, m_regimeApplicable);
      break;
    case 19: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeCarence);
      break;
    case 20: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSalaireRevalorisePlafonne);
      break;
    case 21: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantSjc);
      break;
    case 22: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_coefficientTempsPartiel);
      break;
    case 23: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantRessourceMensuel);
      break;
    case 24: 
      jdoStateManager.providedIntField(this, fieldNumber, m_rangActualisationRessources);
      break;
    case 25: 
      jdoStateManager.providedIntField(this, fieldNumber, m_anneePerceptionRessources);
      break;
    case 26: 
      jdoStateManager.providedIntField(this, fieldNumber, m_moisPerceptionRessources);
      break;
    case 27: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_coefAvantageVieillesse);
      break;
    case 28: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantCumuleRevaloriseAV);
      break;
    case 29: 
      jdoStateManager.providedIntField(this, fieldNumber, m_idPlanFormation);
      break;
    case 30: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeDePlan);
      break;
    case 31: 
      jdoStateManager.providedIntField(this, fieldNumber, m_idStageFormation);
      break;
    case 32: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeMesurePourLEmploi);
      break;
    case 33: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeEtatPND);
      break;
    case 34: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantBaseJustificatifPND);
      break;
    case 35: 
      jdoStateManager.providedIntField(this, fieldNumber, m_statutPaiement);
      break;
    case 36: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantPensionInvalidite);
      break;
    case 37: 
      jdoStateManager.providedStringField(this, fieldNumber, m_interrupIndemParPensionInvalidite);
      break;
    case 38: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_plafonnementFTHR);
      break;
    case 39: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_priseEnChargeAERC);
      break;
    case 40: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeMotifNonPaiement);
      break;
    case 41: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutInterrupRess);
      break;
    case 42: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbMoisActiviteReduite);
      break;
    case 43: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulHeureActRed);
      break;
    case 44: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbMoisPaiementProvis);
      break;
    case 45: 
      jdoStateManager.providedStringField(this, fieldNumber, m_aleIndividu);
      break;
    case 46: 
      jdoStateManager.providedIntField(this, fieldNumber, m_txSanction);
      break;
    case 47: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_topApplicationCRC);
      break;
    case 48: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_topPlafonnementDureeDroitParDate);
      break;
    case 49: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursAREF);
      break;
    case 50: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification0);
      break;
    case 51: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification1);
      break;
    case 52: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification2);
      break;
    case 53: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification3);
      break;
    case 54: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification4);
      break;
    case 55: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification5);
      break;
    case 56: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification6);
      break;
    case 57: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification7);
      break;
    case 58: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification8);
      break;
    case 59: 
      jdoStateManager.providedStringField(this, fieldNumber, m_complementDeJustification9);
      break;
    case 60: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTypeMontant1);
      break;
    case 61: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant1);
      break;
    case 62: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_assiette1);
      break;
    case 63: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_baseDeCalcul1);
      break;
    case 64: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_taux1);
      break;
    case 65: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_resultatCalcul1);
      break;
    case 66: 
      jdoStateManager.providedStringField(this, fieldNumber, m_positionExoneration1);
      break;
    case 67: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTypeMontant2);
      break;
    case 68: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant2);
      break;
    case 69: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_assiette2);
      break;
    case 70: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_baseDeCalcul2);
      break;
    case 71: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_taux2);
      break;
    case 72: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_resultatCalcul2);
      break;
    case 73: 
      jdoStateManager.providedStringField(this, fieldNumber, m_positionExoneration2);
      break;
    case 74: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTypeMontant3);
      break;
    case 75: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant3);
      break;
    case 76: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_assiette3);
      break;
    case 77: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_baseDeCalcul3);
      break;
    case 78: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_taux3);
      break;
    case 79: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_resultatCalcul3);
      break;
    case 80: 
      jdoStateManager.providedStringField(this, fieldNumber, m_positionExoneration3);
      break;
    case 81: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTypeMontant4);
      break;
    case 82: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant4);
      break;
    case 83: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_assiette4);
      break;
    case 84: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_baseDeCalcul4);
      break;
    case 85: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_taux4);
      break;
    case 86: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_resultatCalcul4);
      break;
    case 87: 
      jdoStateManager.providedStringField(this, fieldNumber, m_positionExoneration4);
      break;
    case 88: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTypeMontant5);
      break;
    case 89: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant5);
      break;
    case 90: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_assiette5);
      break;
    case 91: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_baseDeCalcul5);
      break;
    case 92: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_taux5);
      break;
    case 93: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_resultatCalcul5);
      break;
    case 94: 
      jdoStateManager.providedStringField(this, fieldNumber, m_positionExoneration5);
      break;
    case 95: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTypeMontant6);
      break;
    case 96: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant6);
      break;
    case 97: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_assiette6);
      break;
    case 98: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_baseDeCalcul6);
      break;
    case 99: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_taux6);
      break;
    case 100: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_resultatCalcul6);
      break;
    case 101: 
      jdoStateManager.providedStringField(this, fieldNumber, m_positionExoneration6);
      break;
    case 102: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeTypeMontant7);
      break;
    case 103: 
      jdoStateManager.providedIntField(this, fieldNumber, m_complementTypeMontant7);
      break;
    case 104: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_assiette7);
      break;
    case 105: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_baseDeCalcul7);
      break;
    case 106: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_taux7);
      break;
    case 107: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_resultatCalcul7);
      break;
    case 108: 
      jdoStateManager.providedStringField(this, fieldNumber, m_positionExoneration7);
      break;
    case 109: 
      jdoStateManager.providedStringField(this, fieldNumber, m_situationParticuliere);
      break;
    case 110: 
      jdoStateManager.providedStringField(this, fieldNumber, m_categorie);
      break;
    case 111: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeDispositif);
      break;
    case 112: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codePays);
      break;
    case 113: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation1);
      break;
    case 114: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation1);
      break;
    case 115: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation1);
      break;
    case 116: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation2);
      break;
    case 117: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation2);
      break;
    case 118: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation2);
      break;
    case 119: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation3);
      break;
    case 120: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation3);
      break;
    case 121: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation3);
      break;
    case 122: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation4);
      break;
    case 123: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation4);
      break;
    case 124: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation4);
      break;
    case 125: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typePopulation5);
      break;
    case 126: 
      jdoStateManager.providedStringField(this, fieldNumber, m_sousTypePopulation5);
      break;
    case 127: 
      jdoStateManager.providedStringField(this, fieldNumber, m_statutPrestation5);
      break;
    case 128: 
      jdoStateManager.providedBooleanField(this, fieldNumber, m_presencePnds);
      break;
    case 129: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_montantContMensuelEmploiRepris);
      break;
    case 130: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_excedentsRemunerationMois);
      break;
    case 131: 
      jdoStateManager.providedIntField(this, fieldNumber, m_reliquatAllongementAREF);
      break;
    case 132: 
      jdoStateManager.providedIntField(this, fieldNumber, m_cumulAllongementPlan);
      break;
    case 133: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursAllongementAREF);
      break;
    default: 
      throw new JDOFatalInternalException("index of field is out of bound");
    }
  }
  
  public void jdoReplaceField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      m_dateDebutPbjc = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 1: 
      m_dateFinPbjc = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 2: 
      m_refOdPjcPremierFaitGenerateur = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 3: 
      m_refOdPjcFaitGenerateurOrigine = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 4: 
      m_identifiantReprise = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 5: 
      m_refBaseCalculMontantBrut = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 6: 
      m_produit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 7: 
      m_etatReglementaireOd = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 8: 
      m_etatAdministratifOd = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 9: 
      m_rangProlongation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 10: 
      m_naturePBJC = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 11: 
      m_codeRadiationLendemainPeriode = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 12: 
      m_nbJoursImputes = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 13: 
      m_nbJoursDecalage = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 14: 
      m_cumulCourant = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 15: 
      m_reliquatDureeMax = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 16: 
      m_reliquatDureeReglementaire = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 17: 
      m_justificationCalculMontant = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 18: 
      m_regimeApplicable = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 19: 
      m_typeCarence = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 20: 
      m_montantSalaireRevalorisePlafonne = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 21: 
      m_montantSjc = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 22: 
      m_coefficientTempsPartiel = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 23: 
      m_montantRessourceMensuel = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 24: 
      m_rangActualisationRessources = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 25: 
      m_anneePerceptionRessources = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 26: 
      m_moisPerceptionRessources = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 27: 
      m_coefAvantageVieillesse = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 28: 
      m_montantCumuleRevaloriseAV = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 29: 
      m_idPlanFormation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 30: 
      m_typeDePlan = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 31: 
      m_idStageFormation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 32: 
      m_typeMesurePourLEmploi = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 33: 
      m_codeEtatPND = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 34: 
      m_montantBaseJustificatifPND = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 35: 
      m_statutPaiement = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 36: 
      m_montantPensionInvalidite = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 37: 
      m_interrupIndemParPensionInvalidite = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 38: 
      m_plafonnementFTHR = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 39: 
      m_priseEnChargeAERC = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 40: 
      m_codeMotifNonPaiement = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 41: 
      m_dateDebutInterrupRess = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 42: 
      m_nbMoisActiviteReduite = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 43: 
      m_cumulHeureActRed = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 44: 
      m_nbMoisPaiementProvis = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 45: 
      m_aleIndividu = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 46: 
      m_txSanction = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 47: 
      m_topApplicationCRC = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 48: 
      m_topPlafonnementDureeDroitParDate = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 49: 
      m_nbJoursAREF = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 50: 
      m_complementDeJustification0 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 51: 
      m_complementDeJustification1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 52: 
      m_complementDeJustification2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 53: 
      m_complementDeJustification3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 54: 
      m_complementDeJustification4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 55: 
      m_complementDeJustification5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 56: 
      m_complementDeJustification6 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 57: 
      m_complementDeJustification7 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 58: 
      m_complementDeJustification8 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 59: 
      m_complementDeJustification9 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 60: 
      m_codeTypeMontant1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 61: 
      m_complementTypeMontant1 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 62: 
      m_assiette1 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 63: 
      m_baseDeCalcul1 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 64: 
      m_taux1 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 65: 
      m_resultatCalcul1 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 66: 
      m_positionExoneration1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 67: 
      m_codeTypeMontant2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 68: 
      m_complementTypeMontant2 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 69: 
      m_assiette2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 70: 
      m_baseDeCalcul2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 71: 
      m_taux2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 72: 
      m_resultatCalcul2 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 73: 
      m_positionExoneration2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 74: 
      m_codeTypeMontant3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 75: 
      m_complementTypeMontant3 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 76: 
      m_assiette3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 77: 
      m_baseDeCalcul3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 78: 
      m_taux3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 79: 
      m_resultatCalcul3 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 80: 
      m_positionExoneration3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 81: 
      m_codeTypeMontant4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 82: 
      m_complementTypeMontant4 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 83: 
      m_assiette4 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 84: 
      m_baseDeCalcul4 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 85: 
      m_taux4 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 86: 
      m_resultatCalcul4 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 87: 
      m_positionExoneration4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 88: 
      m_codeTypeMontant5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 89: 
      m_complementTypeMontant5 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 90: 
      m_assiette5 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 91: 
      m_baseDeCalcul5 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 92: 
      m_taux5 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 93: 
      m_resultatCalcul5 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 94: 
      m_positionExoneration5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 95: 
      m_codeTypeMontant6 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 96: 
      m_complementTypeMontant6 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 97: 
      m_assiette6 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 98: 
      m_baseDeCalcul6 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 99: 
      m_taux6 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 100: 
      m_resultatCalcul6 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 101: 
      m_positionExoneration6 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 102: 
      m_codeTypeMontant7 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 103: 
      m_complementTypeMontant7 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 104: 
      m_assiette7 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 105: 
      m_baseDeCalcul7 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 106: 
      m_taux7 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 107: 
      m_resultatCalcul7 = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 108: 
      m_positionExoneration7 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 109: 
      m_situationParticuliere = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 110: 
      m_categorie = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 111: 
      m_typeDispositif = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 112: 
      m_codePays = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 113: 
      m_typePopulation1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 114: 
      m_sousTypePopulation1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 115: 
      m_statutPrestation1 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 116: 
      m_typePopulation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 117: 
      m_sousTypePopulation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 118: 
      m_statutPrestation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 119: 
      m_typePopulation3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 120: 
      m_sousTypePopulation3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 121: 
      m_statutPrestation3 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 122: 
      m_typePopulation4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 123: 
      m_sousTypePopulation4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 124: 
      m_statutPrestation4 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 125: 
      m_typePopulation5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 126: 
      m_sousTypePopulation5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 127: 
      m_statutPrestation5 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 128: 
      m_presencePnds = jdoStateManager.replacingBooleanField(this, fieldNumber);
      break;
    case 129: 
      m_montantContMensuelEmploiRepris = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 130: 
      m_excedentsRemunerationMois = ((BigDecimal)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 131: 
      m_reliquatAllongementAREF = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 132: 
      m_cumulAllongementPlan = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 133: 
      m_nbJoursAllongementAREF = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    default: 
      throw new JDOFatalInternalException("index of field is out of bound");
    }
  }
  
  public void jdoProvideFields(int[] fieldNumbers)
  {
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int fieldNumber = fieldNumbers[i];
      jdoProvideField(fieldNumber);
    }
  }
  
  public void jdoReplaceFields(int[] fieldNumbers)
  {
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int fieldNumber = fieldNumbers[i];
      jdoReplaceField(fieldNumber);
    }
  }
  
  public synchronized void jdoReplaceStateManager(StateManager sm)
  {
    if (jdoStateManager != null)
    {
      jdoStateManager = jdoStateManager.replacingStateManager(this, sm);
    }
    else
    {
      SecurityManager securityManager = System.getSecurityManager();
      if (securityManager != null) {
        securityManager.checkPermission(JDOPermission.SET_STATE_MANAGER);
      }
      jdoStateManager = sm;
    }
  }
  
  public boolean jdoIsPersistent()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isPersistent(this);
    }
    return false;
  }
  
  public boolean jdoIsTransactional()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isTransactional(this);
    }
    return false;
  }
  
  public boolean jdoIsNew()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isNew(this);
    }
    return false;
  }
  
  public boolean jdoIsDirty()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isDirty(this);
    }
    return false;
  }
  
  public boolean jdoIsDeleted()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.isDeleted(this);
    }
    return false;
  }
  
  public void jdoMakeDirty(String fieldName)
  {
    if (jdoStateManager != null) {
      jdoStateManager.makeDirty(this, fieldName);
    }
  }
  
  public void jdoReplaceFlags()
  {
    if (jdoStateManager != null)
    {
      jdoFlags = jdoStateManager.replacingFlags(this);
      return;
      jdoFlags = 0;
    }
  }
  
  public boolean jdoIsDetached()
  {
    if (jdoStateManager != null) {
      return ((CommonStateManager)jdoStateManager).isDetached();
    }
    return false;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm)
  {
    PbjcNcpPC pc = new PbjcNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    PbjcNcpPC pc = new PbjcNcpPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 134;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof PbjcNcpPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    PbjcNcpPC other = (PbjcNcpPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_dateDebutPbjc = m_dateDebutPbjc;
        break;
      case 1: 
        m_dateFinPbjc = m_dateFinPbjc;
        break;
      case 2: 
        m_refOdPjcPremierFaitGenerateur = m_refOdPjcPremierFaitGenerateur;
        break;
      case 3: 
        m_refOdPjcFaitGenerateurOrigine = m_refOdPjcFaitGenerateurOrigine;
        break;
      case 4: 
        m_identifiantReprise = m_identifiantReprise;
        break;
      case 5: 
        m_refBaseCalculMontantBrut = m_refBaseCalculMontantBrut;
        break;
      case 6: 
        m_produit = m_produit;
        break;
      case 7: 
        m_etatReglementaireOd = m_etatReglementaireOd;
        break;
      case 8: 
        m_etatAdministratifOd = m_etatAdministratifOd;
        break;
      case 9: 
        m_rangProlongation = m_rangProlongation;
        break;
      case 10: 
        m_naturePBJC = m_naturePBJC;
        break;
      case 11: 
        m_codeRadiationLendemainPeriode = m_codeRadiationLendemainPeriode;
        break;
      case 12: 
        m_nbJoursImputes = m_nbJoursImputes;
        break;
      case 13: 
        m_nbJoursDecalage = m_nbJoursDecalage;
        break;
      case 14: 
        m_cumulCourant = m_cumulCourant;
        break;
      case 15: 
        m_reliquatDureeMax = m_reliquatDureeMax;
        break;
      case 16: 
        m_reliquatDureeReglementaire = m_reliquatDureeReglementaire;
        break;
      case 17: 
        m_justificationCalculMontant = m_justificationCalculMontant;
        break;
      case 18: 
        m_regimeApplicable = m_regimeApplicable;
        break;
      case 19: 
        m_typeCarence = m_typeCarence;
        break;
      case 20: 
        m_montantSalaireRevalorisePlafonne = m_montantSalaireRevalorisePlafonne;
        break;
      case 21: 
        m_montantSjc = m_montantSjc;
        break;
      case 22: 
        m_coefficientTempsPartiel = m_coefficientTempsPartiel;
        break;
      case 23: 
        m_montantRessourceMensuel = m_montantRessourceMensuel;
        break;
      case 24: 
        m_rangActualisationRessources = m_rangActualisationRessources;
        break;
      case 25: 
        m_anneePerceptionRessources = m_anneePerceptionRessources;
        break;
      case 26: 
        m_moisPerceptionRessources = m_moisPerceptionRessources;
        break;
      case 27: 
        m_coefAvantageVieillesse = m_coefAvantageVieillesse;
        break;
      case 28: 
        m_montantCumuleRevaloriseAV = m_montantCumuleRevaloriseAV;
        break;
      case 29: 
        m_idPlanFormation = m_idPlanFormation;
        break;
      case 30: 
        m_typeDePlan = m_typeDePlan;
        break;
      case 31: 
        m_idStageFormation = m_idStageFormation;
        break;
      case 32: 
        m_typeMesurePourLEmploi = m_typeMesurePourLEmploi;
        break;
      case 33: 
        m_codeEtatPND = m_codeEtatPND;
        break;
      case 34: 
        m_montantBaseJustificatifPND = m_montantBaseJustificatifPND;
        break;
      case 35: 
        m_statutPaiement = m_statutPaiement;
        break;
      case 36: 
        m_montantPensionInvalidite = m_montantPensionInvalidite;
        break;
      case 37: 
        m_interrupIndemParPensionInvalidite = m_interrupIndemParPensionInvalidite;
        break;
      case 38: 
        m_plafonnementFTHR = m_plafonnementFTHR;
        break;
      case 39: 
        m_priseEnChargeAERC = m_priseEnChargeAERC;
        break;
      case 40: 
        m_codeMotifNonPaiement = m_codeMotifNonPaiement;
        break;
      case 41: 
        m_dateDebutInterrupRess = m_dateDebutInterrupRess;
        break;
      case 42: 
        m_nbMoisActiviteReduite = m_nbMoisActiviteReduite;
        break;
      case 43: 
        m_cumulHeureActRed = m_cumulHeureActRed;
        break;
      case 44: 
        m_nbMoisPaiementProvis = m_nbMoisPaiementProvis;
        break;
      case 45: 
        m_aleIndividu = m_aleIndividu;
        break;
      case 46: 
        m_txSanction = m_txSanction;
        break;
      case 47: 
        m_topApplicationCRC = m_topApplicationCRC;
        break;
      case 48: 
        m_topPlafonnementDureeDroitParDate = m_topPlafonnementDureeDroitParDate;
        break;
      case 49: 
        m_nbJoursAREF = m_nbJoursAREF;
        break;
      case 50: 
        m_complementDeJustification0 = m_complementDeJustification0;
        break;
      case 51: 
        m_complementDeJustification1 = m_complementDeJustification1;
        break;
      case 52: 
        m_complementDeJustification2 = m_complementDeJustification2;
        break;
      case 53: 
        m_complementDeJustification3 = m_complementDeJustification3;
        break;
      case 54: 
        m_complementDeJustification4 = m_complementDeJustification4;
        break;
      case 55: 
        m_complementDeJustification5 = m_complementDeJustification5;
        break;
      case 56: 
        m_complementDeJustification6 = m_complementDeJustification6;
        break;
      case 57: 
        m_complementDeJustification7 = m_complementDeJustification7;
        break;
      case 58: 
        m_complementDeJustification8 = m_complementDeJustification8;
        break;
      case 59: 
        m_complementDeJustification9 = m_complementDeJustification9;
        break;
      case 60: 
        m_codeTypeMontant1 = m_codeTypeMontant1;
        break;
      case 61: 
        m_complementTypeMontant1 = m_complementTypeMontant1;
        break;
      case 62: 
        m_assiette1 = m_assiette1;
        break;
      case 63: 
        m_baseDeCalcul1 = m_baseDeCalcul1;
        break;
      case 64: 
        m_taux1 = m_taux1;
        break;
      case 65: 
        m_resultatCalcul1 = m_resultatCalcul1;
        break;
      case 66: 
        m_positionExoneration1 = m_positionExoneration1;
        break;
      case 67: 
        m_codeTypeMontant2 = m_codeTypeMontant2;
        break;
      case 68: 
        m_complementTypeMontant2 = m_complementTypeMontant2;
        break;
      case 69: 
        m_assiette2 = m_assiette2;
        break;
      case 70: 
        m_baseDeCalcul2 = m_baseDeCalcul2;
        break;
      case 71: 
        m_taux2 = m_taux2;
        break;
      case 72: 
        m_resultatCalcul2 = m_resultatCalcul2;
        break;
      case 73: 
        m_positionExoneration2 = m_positionExoneration2;
        break;
      case 74: 
        m_codeTypeMontant3 = m_codeTypeMontant3;
        break;
      case 75: 
        m_complementTypeMontant3 = m_complementTypeMontant3;
        break;
      case 76: 
        m_assiette3 = m_assiette3;
        break;
      case 77: 
        m_baseDeCalcul3 = m_baseDeCalcul3;
        break;
      case 78: 
        m_taux3 = m_taux3;
        break;
      case 79: 
        m_resultatCalcul3 = m_resultatCalcul3;
        break;
      case 80: 
        m_positionExoneration3 = m_positionExoneration3;
        break;
      case 81: 
        m_codeTypeMontant4 = m_codeTypeMontant4;
        break;
      case 82: 
        m_complementTypeMontant4 = m_complementTypeMontant4;
        break;
      case 83: 
        m_assiette4 = m_assiette4;
        break;
      case 84: 
        m_baseDeCalcul4 = m_baseDeCalcul4;
        break;
      case 85: 
        m_taux4 = m_taux4;
        break;
      case 86: 
        m_resultatCalcul4 = m_resultatCalcul4;
        break;
      case 87: 
        m_positionExoneration4 = m_positionExoneration4;
        break;
      case 88: 
        m_codeTypeMontant5 = m_codeTypeMontant5;
        break;
      case 89: 
        m_complementTypeMontant5 = m_complementTypeMontant5;
        break;
      case 90: 
        m_assiette5 = m_assiette5;
        break;
      case 91: 
        m_baseDeCalcul5 = m_baseDeCalcul5;
        break;
      case 92: 
        m_taux5 = m_taux5;
        break;
      case 93: 
        m_resultatCalcul5 = m_resultatCalcul5;
        break;
      case 94: 
        m_positionExoneration5 = m_positionExoneration5;
        break;
      case 95: 
        m_codeTypeMontant6 = m_codeTypeMontant6;
        break;
      case 96: 
        m_complementTypeMontant6 = m_complementTypeMontant6;
        break;
      case 97: 
        m_assiette6 = m_assiette6;
        break;
      case 98: 
        m_baseDeCalcul6 = m_baseDeCalcul6;
        break;
      case 99: 
        m_taux6 = m_taux6;
        break;
      case 100: 
        m_resultatCalcul6 = m_resultatCalcul6;
        break;
      case 101: 
        m_positionExoneration6 = m_positionExoneration6;
        break;
      case 102: 
        m_codeTypeMontant7 = m_codeTypeMontant7;
        break;
      case 103: 
        m_complementTypeMontant7 = m_complementTypeMontant7;
        break;
      case 104: 
        m_assiette7 = m_assiette7;
        break;
      case 105: 
        m_baseDeCalcul7 = m_baseDeCalcul7;
        break;
      case 106: 
        m_taux7 = m_taux7;
        break;
      case 107: 
        m_resultatCalcul7 = m_resultatCalcul7;
        break;
      case 108: 
        m_positionExoneration7 = m_positionExoneration7;
        break;
      case 109: 
        m_situationParticuliere = m_situationParticuliere;
        break;
      case 110: 
        m_categorie = m_categorie;
        break;
      case 111: 
        m_typeDispositif = m_typeDispositif;
        break;
      case 112: 
        m_codePays = m_codePays;
        break;
      case 113: 
        m_typePopulation1 = m_typePopulation1;
        break;
      case 114: 
        m_sousTypePopulation1 = m_sousTypePopulation1;
        break;
      case 115: 
        m_statutPrestation1 = m_statutPrestation1;
        break;
      case 116: 
        m_typePopulation2 = m_typePopulation2;
        break;
      case 117: 
        m_sousTypePopulation2 = m_sousTypePopulation2;
        break;
      case 118: 
        m_statutPrestation2 = m_statutPrestation2;
        break;
      case 119: 
        m_typePopulation3 = m_typePopulation3;
        break;
      case 120: 
        m_sousTypePopulation3 = m_sousTypePopulation3;
        break;
      case 121: 
        m_statutPrestation3 = m_statutPrestation3;
        break;
      case 122: 
        m_typePopulation4 = m_typePopulation4;
        break;
      case 123: 
        m_sousTypePopulation4 = m_sousTypePopulation4;
        break;
      case 124: 
        m_statutPrestation4 = m_statutPrestation4;
        break;
      case 125: 
        m_typePopulation5 = m_typePopulation5;
        break;
      case 126: 
        m_sousTypePopulation5 = m_sousTypePopulation5;
        break;
      case 127: 
        m_statutPrestation5 = m_statutPrestation5;
        break;
      case 128: 
        m_presencePnds = m_presencePnds;
        break;
      case 129: 
        m_montantContMensuelEmploiRepris = m_montantContMensuelEmploiRepris;
        break;
      case 130: 
        m_excedentsRemunerationMois = m_excedentsRemunerationMois;
        break;
      case 131: 
        m_reliquatAllongementAREF = m_reliquatAllongementAREF;
        break;
      case 132: 
        m_cumulAllongementPlan = m_cumulAllongementPlan;
        break;
      case 133: 
        m_nbJoursAllongementAREF = m_nbJoursAllongementAREF;
      }
    }
  }
  
  public void jdoCopyKeyFieldsToObjectId(Object object)
  {
    throw new JDOUnsupportedOptionException("Can't be used without Application Identity");
  }
  
  public void jdoCopyKeyFieldsToObjectId(PersistenceCapable.ObjectIdFieldSupplier supplier, Object object)
  {
    throw new JDOUnsupportedOptionException("Can't be used without Application Identity");
  }
  
  protected void jdoCopyKeyFieldsFromObjectId(Object object) {}
  
  public void jdoCopyKeyFieldsFromObjectId(PersistenceCapable.ObjectIdFieldConsumer consumer, Object object)
  {
    throw new JDOUnsupportedOptionException("Can't be used without Application Identity");
  }
  
  public Object jdoNewObjectIdInstance()
  {
    return null;
  }
  
  public Object jdoNewObjectIdInstance(Object str)
  {
    return null;
  }
  
  public Object jdoGetObjectId()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.getObjectId(this);
    }
    return null;
  }
  
  public PersistenceManager jdoGetPersistenceManager()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.getPersistenceManager(this);
    }
    return null;
  }
  
  private void jdoPreSerialize()
  {
    if (jdoStateManager != null) {
      jdoStateManager.preSerialize(this);
    }
  }
  
  private void writeObject(ObjectOutputStream out)
    throws IOException
  {
    jdoPreSerialize();
    out.defaultWriteObject();
  }
  
  public Object jdoGetTransactionalObjectId()
  {
    if (jdoStateManager != null) {
      return jdoStateManager.getTransactionalObjectId(this);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     PbjcNcpPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
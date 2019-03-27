package fr.unedic.cali.calcul.pbjc.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.pbjc.dom.pc.PbjcNcpPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeAbstraite;
import java.math.BigDecimal;

public abstract class PbjcNcpGen
  extends ObjetChronoPeriodeAbstraite
  implements DomGenSpec
{
  protected transient DomPCSpec m_pbjcNcpPC;
  private Damj m_dateDebutPbjc;
  private Damj m_dateFinPbjc;
  private String m_produit;
  private String m_etatReglementaireOd;
  private String m_etatAdministratifOd;
  private String m_naturePBJC;
  private String m_codeRadiationLendemainPeriode;
  private String m_justificationCalculMontant;
  private String m_regimeApplicable;
  private String m_typeCarence;
  private BigDecimal m_montantSalaireRevalorisePlafonne;
  private BigDecimal m_montantSjc;
  private BigDecimal m_coefficientTempsPartiel;
  private BigDecimal m_montantRessourceMensuel;
  private BigDecimal m_coefAvantageVieillesse;
  private BigDecimal m_montantCumuleRevaloriseAV;
  private String m_typeDePlan;
  private String m_typeMesurePourLEmploi;
  private String m_codeEtatPND;
  private BigDecimal m_montantBaseJustificatifPND;
  private BigDecimal m_montantPensionInvalidite;
  private String m_interrupIndemParPensionInvalidite;
  private String m_codeMotifNonPaiement;
  private Damj m_dateDebutInterrupRess;
  private String m_aleIndividu;
  private String m_complementDeJustification0;
  private String m_complementDeJustification1;
  private String m_complementDeJustification2;
  private String m_complementDeJustification3;
  private String m_complementDeJustification4;
  private String m_complementDeJustification5;
  private String m_complementDeJustification6;
  private String m_complementDeJustification7;
  private String m_complementDeJustification8;
  private String m_complementDeJustification9;
  private String m_codeTypeMontant1;
  private BigDecimal m_assiette1;
  private BigDecimal m_baseDeCalcul1;
  private BigDecimal m_taux1;
  private BigDecimal m_resultatCalcul1;
  private String m_positionExoneration1;
  private String m_codeTypeMontant2;
  private BigDecimal m_assiette2;
  private BigDecimal m_baseDeCalcul2;
  private BigDecimal m_taux2;
  private BigDecimal m_resultatCalcul2;
  private String m_positionExoneration2;
  private String m_codeTypeMontant3;
  private BigDecimal m_assiette3;
  private BigDecimal m_baseDeCalcul3;
  private BigDecimal m_taux3;
  private BigDecimal m_resultatCalcul3;
  private String m_positionExoneration3;
  private String m_codeTypeMontant4;
  private BigDecimal m_assiette4;
  private BigDecimal m_baseDeCalcul4;
  private BigDecimal m_taux4;
  private BigDecimal m_resultatCalcul4;
  private String m_positionExoneration4;
  private String m_codeTypeMontant5;
  private BigDecimal m_assiette5;
  private BigDecimal m_baseDeCalcul5;
  private BigDecimal m_taux5;
  private BigDecimal m_resultatCalcul5;
  private String m_positionExoneration5;
  private String m_codeTypeMontant6;
  private BigDecimal m_assiette6;
  private BigDecimal m_baseDeCalcul6;
  private BigDecimal m_taux6;
  private BigDecimal m_resultatCalcul6;
  private String m_positionExoneration6;
  private String m_codeTypeMontant7;
  private BigDecimal m_assiette7;
  private BigDecimal m_baseDeCalcul7;
  private BigDecimal m_taux7;
  private BigDecimal m_resultatCalcul7;
  private String m_positionExoneration7;
  private String m_situationParticuliere;
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
  private BigDecimal m_montantContMensuelEmploiRepris;
  private BigDecimal m_excedentsRemunerationMois;
  
  public PbjcNcpGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public PbjcNcpGen()
  {
    setPC(createPC());
  }
  
  public PbjcNcpGen(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new PbjcNcpPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_pbjcNcpPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_pbjcNcpPC)
  {
    m_pbjcNcpPC = p_pbjcNcpPC;
  }
  
  protected Damj rawGetDateDebutPbjc()
  {
    return ((PbjcNcpPC)getPC()).getDateDebutPbjc();
  }
  
  public Damj getDateDebutPbjc()
  {
    return ((PbjcNcpPC)getPC()).getDateDebutPbjc();
  }
  
  public void setDateDebutPbjc(Damj p_dateDebutPbjc)
  {
    if ((m_dateDebutPbjc == null) || (p_dateDebutPbjc == null))
    {
      m_dateDebutPbjc = p_dateDebutPbjc;
      ((PbjcNcpPC)getPC()).setDateDebutPbjc(p_dateDebutPbjc);
    }
    else if ((m_dateDebutPbjc != null) && (p_dateDebutPbjc != null) && (!p_dateDebutPbjc.equals(m_dateDebutPbjc)))
    {
      m_dateDebutPbjc = p_dateDebutPbjc;
      ((PbjcNcpPC)getPC()).setDateDebutPbjc(p_dateDebutPbjc);
    }
  }
  
  protected Damj rawGetDateFinPbjc()
  {
    return ((PbjcNcpPC)getPC()).getDateFinPbjc();
  }
  
  public Damj getDateFinPbjc()
  {
    return ((PbjcNcpPC)getPC()).getDateFinPbjc();
  }
  
  public void setDateFinPbjc(Damj p_dateFinPbjc)
  {
    if ((m_dateFinPbjc == null) || (p_dateFinPbjc == null))
    {
      m_dateFinPbjc = p_dateFinPbjc;
      ((PbjcNcpPC)getPC()).setDateFinPbjc(p_dateFinPbjc);
    }
    else if ((m_dateFinPbjc != null) && (p_dateFinPbjc != null) && (!p_dateFinPbjc.equals(m_dateFinPbjc)))
    {
      m_dateFinPbjc = p_dateFinPbjc;
      ((PbjcNcpPC)getPC()).setDateFinPbjc(p_dateFinPbjc);
    }
  }
  
  protected int rawGetRefOdPjcPremierFaitGenerateur()
  {
    return ((PbjcNcpPC)getPC()).getRefOdPjcPremierFaitGenerateur();
  }
  
  public int getRefOdPjcPremierFaitGenerateur()
  {
    return ((PbjcNcpPC)getPC()).getRefOdPjcPremierFaitGenerateur();
  }
  
  public void setRefOdPjcPremierFaitGenerateur(int p_refOdPjcPremierFaitGenerateur)
  {
    ((PbjcNcpPC)getPC()).setRefOdPjcPremierFaitGenerateur(p_refOdPjcPremierFaitGenerateur);
  }
  
  protected int rawGetRefOdPjcFaitGenerateurOrigine()
  {
    return ((PbjcNcpPC)getPC()).getRefOdPjcFaitGenerateurOrigine();
  }
  
  public int getRefOdPjcFaitGenerateurOrigine()
  {
    return ((PbjcNcpPC)getPC()).getRefOdPjcFaitGenerateurOrigine();
  }
  
  public void setRefOdPjcFaitGenerateurOrigine(int p_refOdPjcFaitGenerateurOrigine)
  {
    ((PbjcNcpPC)getPC()).setRefOdPjcFaitGenerateurOrigine(p_refOdPjcFaitGenerateurOrigine);
  }
  
  protected int rawGetIdentifiantReprise()
  {
    return ((PbjcNcpPC)getPC()).getIdentifiantReprise();
  }
  
  public int getIdentifiantReprise()
  {
    return ((PbjcNcpPC)getPC()).getIdentifiantReprise();
  }
  
  public void setIdentifiantReprise(int p_identifiantReprise)
  {
    ((PbjcNcpPC)getPC()).setIdentifiantReprise(p_identifiantReprise);
  }
  
  protected int rawGetRefBaseCalculMontantBrut()
  {
    return ((PbjcNcpPC)getPC()).getRefBaseCalculMontantBrut();
  }
  
  public int getRefBaseCalculMontantBrut()
  {
    return ((PbjcNcpPC)getPC()).getRefBaseCalculMontantBrut();
  }
  
  public void setRefBaseCalculMontantBrut(int p_refBaseCalculMontantBrut)
  {
    ((PbjcNcpPC)getPC()).setRefBaseCalculMontantBrut(p_refBaseCalculMontantBrut);
  }
  
  protected String rawGetProduit()
  {
    return ((PbjcNcpPC)getPC()).getProduit();
  }
  
  public String getProduit()
  {
    return ((PbjcNcpPC)getPC()).getProduit();
  }
  
  public void setProduit(String p_produit)
  {
    if ((m_produit == null) || (p_produit == null))
    {
      m_produit = p_produit;
      ((PbjcNcpPC)getPC()).setProduit(p_produit);
    }
    else if ((m_produit != null) && (p_produit != null) && (!p_produit.equals(m_produit)))
    {
      m_produit = p_produit;
      ((PbjcNcpPC)getPC()).setProduit(p_produit);
    }
  }
  
  protected String rawGetEtatReglementaireOd()
  {
    return ((PbjcNcpPC)getPC()).getEtatReglementaireOd();
  }
  
  public String getEtatReglementaireOd()
  {
    return ((PbjcNcpPC)getPC()).getEtatReglementaireOd();
  }
  
  public void setEtatReglementaireOd(String p_etatReglementaireOd)
  {
    if ((m_etatReglementaireOd == null) || (p_etatReglementaireOd == null))
    {
      m_etatReglementaireOd = p_etatReglementaireOd;
      ((PbjcNcpPC)getPC()).setEtatReglementaireOd(p_etatReglementaireOd);
    }
    else if ((m_etatReglementaireOd != null) && (p_etatReglementaireOd != null) && (!p_etatReglementaireOd.equals(m_etatReglementaireOd)))
    {
      m_etatReglementaireOd = p_etatReglementaireOd;
      ((PbjcNcpPC)getPC()).setEtatReglementaireOd(p_etatReglementaireOd);
    }
  }
  
  protected String rawGetEtatAdministratifOd()
  {
    return ((PbjcNcpPC)getPC()).getEtatAdministratifOd();
  }
  
  public String getEtatAdministratifOd()
  {
    return ((PbjcNcpPC)getPC()).getEtatAdministratifOd();
  }
  
  public void setEtatAdministratifOd(String p_etatAdministratifOd)
  {
    if ((m_etatAdministratifOd == null) || (p_etatAdministratifOd == null))
    {
      m_etatAdministratifOd = p_etatAdministratifOd;
      ((PbjcNcpPC)getPC()).setEtatAdministratifOd(p_etatAdministratifOd);
    }
    else if ((m_etatAdministratifOd != null) && (p_etatAdministratifOd != null) && (!p_etatAdministratifOd.equals(m_etatAdministratifOd)))
    {
      m_etatAdministratifOd = p_etatAdministratifOd;
      ((PbjcNcpPC)getPC()).setEtatAdministratifOd(p_etatAdministratifOd);
    }
  }
  
  protected int rawGetRangProlongation()
  {
    return ((PbjcNcpPC)getPC()).getRangProlongation();
  }
  
  public int getRangProlongation()
  {
    return ((PbjcNcpPC)getPC()).getRangProlongation();
  }
  
  public void setRangProlongation(int p_rangProlongation)
  {
    ((PbjcNcpPC)getPC()).setRangProlongation(p_rangProlongation);
  }
  
  protected String rawGetNaturePBJC()
  {
    return ((PbjcNcpPC)getPC()).getNaturePBJC();
  }
  
  public String getNaturePBJC()
  {
    return ((PbjcNcpPC)getPC()).getNaturePBJC();
  }
  
  public void setNaturePBJC(String p_naturePBJC)
  {
    if ((m_naturePBJC == null) || (p_naturePBJC == null))
    {
      m_naturePBJC = p_naturePBJC;
      ((PbjcNcpPC)getPC()).setNaturePBJC(p_naturePBJC);
    }
    else if ((m_naturePBJC != null) && (p_naturePBJC != null) && (!p_naturePBJC.equals(m_naturePBJC)))
    {
      m_naturePBJC = p_naturePBJC;
      ((PbjcNcpPC)getPC()).setNaturePBJC(p_naturePBJC);
    }
  }
  
  protected String rawGetCodeRadiationLendemainPeriode()
  {
    return ((PbjcNcpPC)getPC()).getCodeRadiationLendemainPeriode();
  }
  
  public String getCodeRadiationLendemainPeriode()
  {
    return ((PbjcNcpPC)getPC()).getCodeRadiationLendemainPeriode();
  }
  
  public void setCodeRadiationLendemainPeriode(String p_codeRadiationLendemainPeriode)
  {
    if ((m_codeRadiationLendemainPeriode == null) || (p_codeRadiationLendemainPeriode == null))
    {
      m_codeRadiationLendemainPeriode = p_codeRadiationLendemainPeriode;
      ((PbjcNcpPC)getPC()).setCodeRadiationLendemainPeriode(p_codeRadiationLendemainPeriode);
    }
    else if ((m_codeRadiationLendemainPeriode != null) && (p_codeRadiationLendemainPeriode != null) && (!p_codeRadiationLendemainPeriode.equals(m_codeRadiationLendemainPeriode)))
    {
      m_codeRadiationLendemainPeriode = p_codeRadiationLendemainPeriode;
      ((PbjcNcpPC)getPC()).setCodeRadiationLendemainPeriode(p_codeRadiationLendemainPeriode);
    }
  }
  
  protected int rawGetNbJoursImputes()
  {
    return ((PbjcNcpPC)getPC()).getNbJoursImputes();
  }
  
  public int getNbJoursImputes()
  {
    return ((PbjcNcpPC)getPC()).getNbJoursImputes();
  }
  
  public void setNbJoursImputes(int p_nbJoursImputes)
  {
    ((PbjcNcpPC)getPC()).setNbJoursImputes(p_nbJoursImputes);
  }
  
  protected int rawGetNbJoursDecalage()
  {
    return ((PbjcNcpPC)getPC()).getNbJoursDecalage();
  }
  
  public int getNbJoursDecalage()
  {
    return ((PbjcNcpPC)getPC()).getNbJoursDecalage();
  }
  
  public void setNbJoursDecalage(int p_nbJoursDecalage)
  {
    ((PbjcNcpPC)getPC()).setNbJoursDecalage(p_nbJoursDecalage);
  }
  
  protected int rawGetCumulCourant()
  {
    return ((PbjcNcpPC)getPC()).getCumulCourant();
  }
  
  public int getCumulCourant()
  {
    return ((PbjcNcpPC)getPC()).getCumulCourant();
  }
  
  public void setCumulCourant(int p_cumulCourant)
  {
    ((PbjcNcpPC)getPC()).setCumulCourant(p_cumulCourant);
  }
  
  protected int rawGetReliquatDureeMax()
  {
    return ((PbjcNcpPC)getPC()).getReliquatDureeMax();
  }
  
  public int getReliquatDureeMax()
  {
    return ((PbjcNcpPC)getPC()).getReliquatDureeMax();
  }
  
  public void setReliquatDureeMax(int p_reliquatDureeMax)
  {
    ((PbjcNcpPC)getPC()).setReliquatDureeMax(p_reliquatDureeMax);
  }
  
  protected int rawGetReliquatDureeReglementaire()
  {
    return ((PbjcNcpPC)getPC()).getReliquatDureeReglementaire();
  }
  
  public int getReliquatDureeReglementaire()
  {
    return ((PbjcNcpPC)getPC()).getReliquatDureeReglementaire();
  }
  
  public void setReliquatDureeReglementaire(int p_reliquatDureeReglementaire)
  {
    ((PbjcNcpPC)getPC()).setReliquatDureeReglementaire(p_reliquatDureeReglementaire);
  }
  
  protected String rawGetJustificationCalculMontant()
  {
    return ((PbjcNcpPC)getPC()).getJustificationCalculMontant();
  }
  
  public String getJustificationCalculMontant()
  {
    return ((PbjcNcpPC)getPC()).getJustificationCalculMontant();
  }
  
  public void setJustificationCalculMontant(String p_justificationCalculMontant)
  {
    if ((m_justificationCalculMontant == null) || (p_justificationCalculMontant == null))
    {
      m_justificationCalculMontant = p_justificationCalculMontant;
      ((PbjcNcpPC)getPC()).setJustificationCalculMontant(p_justificationCalculMontant);
    }
    else if ((m_justificationCalculMontant != null) && (p_justificationCalculMontant != null) && (!p_justificationCalculMontant.equals(m_justificationCalculMontant)))
    {
      m_justificationCalculMontant = p_justificationCalculMontant;
      ((PbjcNcpPC)getPC()).setJustificationCalculMontant(p_justificationCalculMontant);
    }
  }
  
  protected String rawGetRegimeApplicable()
  {
    return ((PbjcNcpPC)getPC()).getRegimeApplicable();
  }
  
  public String getRegimeApplicable()
  {
    return ((PbjcNcpPC)getPC()).getRegimeApplicable();
  }
  
  public void setRegimeApplicable(String p_regimeApplicable)
  {
    if ((m_regimeApplicable == null) || (p_regimeApplicable == null))
    {
      m_regimeApplicable = p_regimeApplicable;
      ((PbjcNcpPC)getPC()).setRegimeApplicable(p_regimeApplicable);
    }
    else if ((m_regimeApplicable != null) && (p_regimeApplicable != null) && (!p_regimeApplicable.equals(m_regimeApplicable)))
    {
      m_regimeApplicable = p_regimeApplicable;
      ((PbjcNcpPC)getPC()).setRegimeApplicable(p_regimeApplicable);
    }
  }
  
  protected String rawGetTypeCarence()
  {
    return ((PbjcNcpPC)getPC()).getTypeCarence();
  }
  
  public String getTypeCarence()
  {
    return ((PbjcNcpPC)getPC()).getTypeCarence();
  }
  
  public void setTypeCarence(String p_typeCarence)
  {
    if ((m_typeCarence == null) || (p_typeCarence == null))
    {
      m_typeCarence = p_typeCarence;
      ((PbjcNcpPC)getPC()).setTypeCarence(p_typeCarence);
    }
    else if ((m_typeCarence != null) && (p_typeCarence != null) && (!p_typeCarence.equals(m_typeCarence)))
    {
      m_typeCarence = p_typeCarence;
      ((PbjcNcpPC)getPC()).setTypeCarence(p_typeCarence);
    }
  }
  
  protected BigDecimal rawGetMontantSalaireRevalorisePlafonne()
  {
    return ((PbjcNcpPC)getPC()).getMontantSalaireRevalorisePlafonne();
  }
  
  public BigDecimal getMontantSalaireRevalorisePlafonne()
  {
    return ((PbjcNcpPC)getPC()).getMontantSalaireRevalorisePlafonne();
  }
  
  public void setMontantSalaireRevalorisePlafonne(BigDecimal p_montantSalaireRevalorisePlafonne)
  {
    if ((m_montantSalaireRevalorisePlafonne == null) || (p_montantSalaireRevalorisePlafonne == null))
    {
      m_montantSalaireRevalorisePlafonne = p_montantSalaireRevalorisePlafonne;
      ((PbjcNcpPC)getPC()).setMontantSalaireRevalorisePlafonne(p_montantSalaireRevalorisePlafonne);
    }
    else if ((m_montantSalaireRevalorisePlafonne != null) && (p_montantSalaireRevalorisePlafonne != null) && (!p_montantSalaireRevalorisePlafonne.equals(m_montantSalaireRevalorisePlafonne)))
    {
      m_montantSalaireRevalorisePlafonne = p_montantSalaireRevalorisePlafonne;
      ((PbjcNcpPC)getPC()).setMontantSalaireRevalorisePlafonne(p_montantSalaireRevalorisePlafonne);
    }
  }
  
  protected BigDecimal rawGetMontantSjc()
  {
    return ((PbjcNcpPC)getPC()).getMontantSjc();
  }
  
  public BigDecimal getMontantSjc()
  {
    return ((PbjcNcpPC)getPC()).getMontantSjc();
  }
  
  public void setMontantSjc(BigDecimal p_montantSjc)
  {
    if ((m_montantSjc == null) || (p_montantSjc == null))
    {
      m_montantSjc = p_montantSjc;
      ((PbjcNcpPC)getPC()).setMontantSjc(p_montantSjc);
    }
    else if ((m_montantSjc != null) && (p_montantSjc != null) && (!p_montantSjc.equals(m_montantSjc)))
    {
      m_montantSjc = p_montantSjc;
      ((PbjcNcpPC)getPC()).setMontantSjc(p_montantSjc);
    }
  }
  
  protected BigDecimal rawGetCoefficientTempsPartiel()
  {
    return ((PbjcNcpPC)getPC()).getCoefficientTempsPartiel();
  }
  
  public BigDecimal getCoefficientTempsPartiel()
  {
    return ((PbjcNcpPC)getPC()).getCoefficientTempsPartiel();
  }
  
  public void setCoefficientTempsPartiel(BigDecimal p_coefficientTempsPartiel)
  {
    if ((m_coefficientTempsPartiel == null) || (p_coefficientTempsPartiel == null))
    {
      m_coefficientTempsPartiel = p_coefficientTempsPartiel;
      ((PbjcNcpPC)getPC()).setCoefficientTempsPartiel(p_coefficientTempsPartiel);
    }
    else if ((m_coefficientTempsPartiel != null) && (p_coefficientTempsPartiel != null) && (!p_coefficientTempsPartiel.equals(m_coefficientTempsPartiel)))
    {
      m_coefficientTempsPartiel = p_coefficientTempsPartiel;
      ((PbjcNcpPC)getPC()).setCoefficientTempsPartiel(p_coefficientTempsPartiel);
    }
  }
  
  protected BigDecimal rawGetMontantRessourceMensuel()
  {
    return ((PbjcNcpPC)getPC()).getMontantRessourceMensuel();
  }
  
  public BigDecimal getMontantRessourceMensuel()
  {
    return ((PbjcNcpPC)getPC()).getMontantRessourceMensuel();
  }
  
  public void setMontantRessourceMensuel(BigDecimal p_montantRessourceMensuel)
  {
    if ((m_montantRessourceMensuel == null) || (p_montantRessourceMensuel == null))
    {
      m_montantRessourceMensuel = p_montantRessourceMensuel;
      ((PbjcNcpPC)getPC()).setMontantRessourceMensuel(p_montantRessourceMensuel);
    }
    else if ((m_montantRessourceMensuel != null) && (p_montantRessourceMensuel != null) && (!p_montantRessourceMensuel.equals(m_montantRessourceMensuel)))
    {
      m_montantRessourceMensuel = p_montantRessourceMensuel;
      ((PbjcNcpPC)getPC()).setMontantRessourceMensuel(p_montantRessourceMensuel);
    }
  }
  
  protected int rawGetRangActualisationRessources()
  {
    return ((PbjcNcpPC)getPC()).getRangActualisationRessources();
  }
  
  public int getRangActualisationRessources()
  {
    return ((PbjcNcpPC)getPC()).getRangActualisationRessources();
  }
  
  public void setRangActualisationRessources(int p_rangActualisationRessources)
  {
    ((PbjcNcpPC)getPC()).setRangActualisationRessources(p_rangActualisationRessources);
  }
  
  protected int rawGetAnneePerceptionRessources()
  {
    return ((PbjcNcpPC)getPC()).getAnneePerceptionRessources();
  }
  
  public int getAnneePerceptionRessources()
  {
    return ((PbjcNcpPC)getPC()).getAnneePerceptionRessources();
  }
  
  public void setAnneePerceptionRessources(int p_anneePerceptionRessources)
  {
    ((PbjcNcpPC)getPC()).setAnneePerceptionRessources(p_anneePerceptionRessources);
  }
  
  protected int rawGetMoisPerceptionRessources()
  {
    return ((PbjcNcpPC)getPC()).getMoisPerceptionRessources();
  }
  
  public int getMoisPerceptionRessources()
  {
    return ((PbjcNcpPC)getPC()).getMoisPerceptionRessources();
  }
  
  public void setMoisPerceptionRessources(int p_moisPerceptionRessources)
  {
    ((PbjcNcpPC)getPC()).setMoisPerceptionRessources(p_moisPerceptionRessources);
  }
  
  protected BigDecimal rawGetCoefAvantageVieillesse()
  {
    return ((PbjcNcpPC)getPC()).getCoefAvantageVieillesse();
  }
  
  public BigDecimal getCoefAvantageVieillesse()
  {
    return ((PbjcNcpPC)getPC()).getCoefAvantageVieillesse();
  }
  
  public void setCoefAvantageVieillesse(BigDecimal p_coefAvantageVieillesse)
  {
    if ((m_coefAvantageVieillesse == null) || (p_coefAvantageVieillesse == null))
    {
      m_coefAvantageVieillesse = p_coefAvantageVieillesse;
      ((PbjcNcpPC)getPC()).setCoefAvantageVieillesse(p_coefAvantageVieillesse);
    }
    else if ((m_coefAvantageVieillesse != null) && (p_coefAvantageVieillesse != null) && (!p_coefAvantageVieillesse.equals(m_coefAvantageVieillesse)))
    {
      m_coefAvantageVieillesse = p_coefAvantageVieillesse;
      ((PbjcNcpPC)getPC()).setCoefAvantageVieillesse(p_coefAvantageVieillesse);
    }
  }
  
  protected BigDecimal rawGetMontantCumuleRevaloriseAV()
  {
    return ((PbjcNcpPC)getPC()).getMontantCumuleRevaloriseAV();
  }
  
  public BigDecimal getMontantCumuleRevaloriseAV()
  {
    return ((PbjcNcpPC)getPC()).getMontantCumuleRevaloriseAV();
  }
  
  public void setMontantCumuleRevaloriseAV(BigDecimal p_montantCumuleRevaloriseAV)
  {
    if ((m_montantCumuleRevaloriseAV == null) || (p_montantCumuleRevaloriseAV == null))
    {
      m_montantCumuleRevaloriseAV = p_montantCumuleRevaloriseAV;
      ((PbjcNcpPC)getPC()).setMontantCumuleRevaloriseAV(p_montantCumuleRevaloriseAV);
    }
    else if ((m_montantCumuleRevaloriseAV != null) && (p_montantCumuleRevaloriseAV != null) && (!p_montantCumuleRevaloriseAV.equals(m_montantCumuleRevaloriseAV)))
    {
      m_montantCumuleRevaloriseAV = p_montantCumuleRevaloriseAV;
      ((PbjcNcpPC)getPC()).setMontantCumuleRevaloriseAV(p_montantCumuleRevaloriseAV);
    }
  }
  
  protected int rawGetIdPlanFormation()
  {
    return ((PbjcNcpPC)getPC()).getIdPlanFormation();
  }
  
  public int getIdPlanFormation()
  {
    return ((PbjcNcpPC)getPC()).getIdPlanFormation();
  }
  
  public void setIdPlanFormation(int p_idPlanFormation)
  {
    ((PbjcNcpPC)getPC()).setIdPlanFormation(p_idPlanFormation);
  }
  
  protected String rawGetTypeDePlan()
  {
    return ((PbjcNcpPC)getPC()).getTypeDePlan();
  }
  
  public String getTypeDePlan()
  {
    return ((PbjcNcpPC)getPC()).getTypeDePlan();
  }
  
  public void setTypeDePlan(String p_typeDePlan)
  {
    if ((m_typeDePlan == null) || (p_typeDePlan == null))
    {
      m_typeDePlan = p_typeDePlan;
      ((PbjcNcpPC)getPC()).setTypeDePlan(p_typeDePlan);
    }
    else if ((m_typeDePlan != null) && (p_typeDePlan != null) && (!p_typeDePlan.equals(m_typeDePlan)))
    {
      m_typeDePlan = p_typeDePlan;
      ((PbjcNcpPC)getPC()).setTypeDePlan(p_typeDePlan);
    }
  }
  
  protected int rawGetIdStageFormation()
  {
    return ((PbjcNcpPC)getPC()).getIdStageFormation();
  }
  
  public int getIdStageFormation()
  {
    return ((PbjcNcpPC)getPC()).getIdStageFormation();
  }
  
  public void setIdStageFormation(int p_idStageFormation)
  {
    ((PbjcNcpPC)getPC()).setIdStageFormation(p_idStageFormation);
  }
  
  protected String rawGetTypeMesurePourLEmploi()
  {
    return ((PbjcNcpPC)getPC()).getTypeMesurePourLEmploi();
  }
  
  public String getTypeMesurePourLEmploi()
  {
    return ((PbjcNcpPC)getPC()).getTypeMesurePourLEmploi();
  }
  
  public void setTypeMesurePourLEmploi(String p_typeMesurePourLEmploi)
  {
    if ((m_typeMesurePourLEmploi == null) || (p_typeMesurePourLEmploi == null))
    {
      m_typeMesurePourLEmploi = p_typeMesurePourLEmploi;
      ((PbjcNcpPC)getPC()).setTypeMesurePourLEmploi(p_typeMesurePourLEmploi);
    }
    else if ((m_typeMesurePourLEmploi != null) && (p_typeMesurePourLEmploi != null) && (!p_typeMesurePourLEmploi.equals(m_typeMesurePourLEmploi)))
    {
      m_typeMesurePourLEmploi = p_typeMesurePourLEmploi;
      ((PbjcNcpPC)getPC()).setTypeMesurePourLEmploi(p_typeMesurePourLEmploi);
    }
  }
  
  protected String rawGetCodeEtatPND()
  {
    return ((PbjcNcpPC)getPC()).getCodeEtatPND();
  }
  
  public String getCodeEtatPND()
  {
    return ((PbjcNcpPC)getPC()).getCodeEtatPND();
  }
  
  public void setCodeEtatPND(String p_codeEtatPND)
  {
    if ((m_codeEtatPND == null) || (p_codeEtatPND == null))
    {
      m_codeEtatPND = p_codeEtatPND;
      ((PbjcNcpPC)getPC()).setCodeEtatPND(p_codeEtatPND);
    }
    else if ((m_codeEtatPND != null) && (p_codeEtatPND != null) && (!p_codeEtatPND.equals(m_codeEtatPND)))
    {
      m_codeEtatPND = p_codeEtatPND;
      ((PbjcNcpPC)getPC()).setCodeEtatPND(p_codeEtatPND);
    }
  }
  
  protected BigDecimal rawGetMontantBaseJustificatifPND()
  {
    return ((PbjcNcpPC)getPC()).getMontantBaseJustificatifPND();
  }
  
  public BigDecimal getMontantBaseJustificatifPND()
  {
    return ((PbjcNcpPC)getPC()).getMontantBaseJustificatifPND();
  }
  
  public void setMontantBaseJustificatifPND(BigDecimal p_montantBaseJustificatifPND)
  {
    if ((m_montantBaseJustificatifPND == null) || (p_montantBaseJustificatifPND == null))
    {
      m_montantBaseJustificatifPND = p_montantBaseJustificatifPND;
      ((PbjcNcpPC)getPC()).setMontantBaseJustificatifPND(p_montantBaseJustificatifPND);
    }
    else if ((m_montantBaseJustificatifPND != null) && (p_montantBaseJustificatifPND != null) && (!p_montantBaseJustificatifPND.equals(m_montantBaseJustificatifPND)))
    {
      m_montantBaseJustificatifPND = p_montantBaseJustificatifPND;
      ((PbjcNcpPC)getPC()).setMontantBaseJustificatifPND(p_montantBaseJustificatifPND);
    }
  }
  
  protected int rawGetStatutPaiement()
  {
    return ((PbjcNcpPC)getPC()).getStatutPaiement();
  }
  
  public int getStatutPaiement()
  {
    return ((PbjcNcpPC)getPC()).getStatutPaiement();
  }
  
  public void setStatutPaiement(int p_statutPaiement)
  {
    ((PbjcNcpPC)getPC()).setStatutPaiement(p_statutPaiement);
  }
  
  protected BigDecimal rawGetMontantPensionInvalidite()
  {
    return ((PbjcNcpPC)getPC()).getMontantPensionInvalidite();
  }
  
  public BigDecimal getMontantPensionInvalidite()
  {
    return ((PbjcNcpPC)getPC()).getMontantPensionInvalidite();
  }
  
  public void setMontantPensionInvalidite(BigDecimal p_montantPensionInvalidite)
  {
    if ((m_montantPensionInvalidite == null) || (p_montantPensionInvalidite == null))
    {
      m_montantPensionInvalidite = p_montantPensionInvalidite;
      ((PbjcNcpPC)getPC()).setMontantPensionInvalidite(p_montantPensionInvalidite);
    }
    else if ((m_montantPensionInvalidite != null) && (p_montantPensionInvalidite != null) && (!p_montantPensionInvalidite.equals(m_montantPensionInvalidite)))
    {
      m_montantPensionInvalidite = p_montantPensionInvalidite;
      ((PbjcNcpPC)getPC()).setMontantPensionInvalidite(p_montantPensionInvalidite);
    }
  }
  
  protected String rawGetInterrupIndemParPensionInvalidite()
  {
    return ((PbjcNcpPC)getPC()).getInterrupIndemParPensionInvalidite();
  }
  
  public String getInterrupIndemParPensionInvalidite()
  {
    return ((PbjcNcpPC)getPC()).getInterrupIndemParPensionInvalidite();
  }
  
  public void setInterrupIndemParPensionInvalidite(String p_interrupIndemParPensionInvalidite)
  {
    if ((m_interrupIndemParPensionInvalidite == null) || (p_interrupIndemParPensionInvalidite == null))
    {
      m_interrupIndemParPensionInvalidite = p_interrupIndemParPensionInvalidite;
      ((PbjcNcpPC)getPC()).setInterrupIndemParPensionInvalidite(p_interrupIndemParPensionInvalidite);
    }
    else if ((m_interrupIndemParPensionInvalidite != null) && (p_interrupIndemParPensionInvalidite != null) && (!p_interrupIndemParPensionInvalidite.equals(m_interrupIndemParPensionInvalidite)))
    {
      m_interrupIndemParPensionInvalidite = p_interrupIndemParPensionInvalidite;
      ((PbjcNcpPC)getPC()).setInterrupIndemParPensionInvalidite(p_interrupIndemParPensionInvalidite);
    }
  }
  
  protected boolean rawIsPlafonnementFTHR()
  {
    return ((PbjcNcpPC)getPC()).isPlafonnementFTHR();
  }
  
  public boolean isPlafonnementFTHR()
  {
    return ((PbjcNcpPC)getPC()).isPlafonnementFTHR();
  }
  
  public void setPlafonnementFTHR(boolean p_plafonnementFTHR)
  {
    ((PbjcNcpPC)getPC()).setPlafonnementFTHR(p_plafonnementFTHR);
  }
  
  protected boolean rawIsPriseEnChargeAERC()
  {
    return ((PbjcNcpPC)getPC()).isPriseEnChargeAERC();
  }
  
  public boolean isPriseEnChargeAERC()
  {
    return ((PbjcNcpPC)getPC()).isPriseEnChargeAERC();
  }
  
  public void setPriseEnChargeAERC(boolean p_priseEnChargeAERC)
  {
    ((PbjcNcpPC)getPC()).setPriseEnChargeAERC(p_priseEnChargeAERC);
  }
  
  protected String rawGetCodeMotifNonPaiement()
  {
    return ((PbjcNcpPC)getPC()).getCodeMotifNonPaiement();
  }
  
  public String getCodeMotifNonPaiement()
  {
    return ((PbjcNcpPC)getPC()).getCodeMotifNonPaiement();
  }
  
  public void setCodeMotifNonPaiement(String p_codeMotifNonPaiement)
  {
    if ((m_codeMotifNonPaiement == null) || (p_codeMotifNonPaiement == null))
    {
      m_codeMotifNonPaiement = p_codeMotifNonPaiement;
      ((PbjcNcpPC)getPC()).setCodeMotifNonPaiement(p_codeMotifNonPaiement);
    }
    else if ((m_codeMotifNonPaiement != null) && (p_codeMotifNonPaiement != null) && (!p_codeMotifNonPaiement.equals(m_codeMotifNonPaiement)))
    {
      m_codeMotifNonPaiement = p_codeMotifNonPaiement;
      ((PbjcNcpPC)getPC()).setCodeMotifNonPaiement(p_codeMotifNonPaiement);
    }
  }
  
  protected Damj rawGetDateDebutInterrupRess()
  {
    return ((PbjcNcpPC)getPC()).getDateDebutInterrupRess();
  }
  
  public Damj getDateDebutInterrupRess()
  {
    return ((PbjcNcpPC)getPC()).getDateDebutInterrupRess();
  }
  
  public void setDateDebutInterrupRess(Damj p_dateDebutInterrupRess)
  {
    if ((m_dateDebutInterrupRess == null) || (p_dateDebutInterrupRess == null))
    {
      m_dateDebutInterrupRess = p_dateDebutInterrupRess;
      ((PbjcNcpPC)getPC()).setDateDebutInterrupRess(p_dateDebutInterrupRess);
    }
    else if ((m_dateDebutInterrupRess != null) && (p_dateDebutInterrupRess != null) && (!p_dateDebutInterrupRess.equals(m_dateDebutInterrupRess)))
    {
      m_dateDebutInterrupRess = p_dateDebutInterrupRess;
      ((PbjcNcpPC)getPC()).setDateDebutInterrupRess(p_dateDebutInterrupRess);
    }
  }
  
  protected int rawGetNbMoisActiviteReduite()
  {
    return ((PbjcNcpPC)getPC()).getNbMoisActiviteReduite();
  }
  
  public int getNbMoisActiviteReduite()
  {
    return ((PbjcNcpPC)getPC()).getNbMoisActiviteReduite();
  }
  
  public void setNbMoisActiviteReduite(int p_nbMoisActiviteReduite)
  {
    ((PbjcNcpPC)getPC()).setNbMoisActiviteReduite(p_nbMoisActiviteReduite);
  }
  
  protected int rawGetCumulHeureActRed()
  {
    return ((PbjcNcpPC)getPC()).getCumulHeureActRed();
  }
  
  public int getCumulHeureActRed()
  {
    return ((PbjcNcpPC)getPC()).getCumulHeureActRed();
  }
  
  public void setCumulHeureActRed(int p_cumulHeureActRed)
  {
    ((PbjcNcpPC)getPC()).setCumulHeureActRed(p_cumulHeureActRed);
  }
  
  protected int rawGetNbMoisPaiementProvis()
  {
    return ((PbjcNcpPC)getPC()).getNbMoisPaiementProvis();
  }
  
  public int getNbMoisPaiementProvis()
  {
    return ((PbjcNcpPC)getPC()).getNbMoisPaiementProvis();
  }
  
  public void setNbMoisPaiementProvis(int p_nbMoisPaiementProvis)
  {
    ((PbjcNcpPC)getPC()).setNbMoisPaiementProvis(p_nbMoisPaiementProvis);
  }
  
  protected String rawGetAleIndividu()
  {
    return ((PbjcNcpPC)getPC()).getAleIndividu();
  }
  
  public String getAleIndividu()
  {
    return ((PbjcNcpPC)getPC()).getAleIndividu();
  }
  
  public void setAleIndividu(String p_aleIndividu)
  {
    if ((m_aleIndividu == null) || (p_aleIndividu == null))
    {
      m_aleIndividu = p_aleIndividu;
      ((PbjcNcpPC)getPC()).setAleIndividu(p_aleIndividu);
    }
    else if ((m_aleIndividu != null) && (p_aleIndividu != null) && (!p_aleIndividu.equals(m_aleIndividu)))
    {
      m_aleIndividu = p_aleIndividu;
      ((PbjcNcpPC)getPC()).setAleIndividu(p_aleIndividu);
    }
  }
  
  protected int rawGetTxSanction()
  {
    return ((PbjcNcpPC)getPC()).getTxSanction();
  }
  
  public int getTxSanction()
  {
    return ((PbjcNcpPC)getPC()).getTxSanction();
  }
  
  public void setTxSanction(int p_txSanction)
  {
    ((PbjcNcpPC)getPC()).setTxSanction(p_txSanction);
  }
  
  protected boolean rawIsTopApplicationCRC()
  {
    return ((PbjcNcpPC)getPC()).isTopApplicationCRC();
  }
  
  public boolean isTopApplicationCRC()
  {
    return ((PbjcNcpPC)getPC()).isTopApplicationCRC();
  }
  
  public void setTopApplicationCRC(boolean p_topApplicationCRC)
  {
    ((PbjcNcpPC)getPC()).setTopApplicationCRC(p_topApplicationCRC);
  }
  
  protected boolean rawIsTopPlafonnementDureeDroitParDate()
  {
    return ((PbjcNcpPC)getPC()).isTopPlafonnementDureeDroitParDate();
  }
  
  public boolean isTopPlafonnementDureeDroitParDate()
  {
    return ((PbjcNcpPC)getPC()).isTopPlafonnementDureeDroitParDate();
  }
  
  public void setTopPlafonnementDureeDroitParDate(boolean p_topPlafonnementDureeDroitParDate)
  {
    ((PbjcNcpPC)getPC()).setTopPlafonnementDureeDroitParDate(p_topPlafonnementDureeDroitParDate);
  }
  
  protected int rawGetNbJoursAREF()
  {
    return ((PbjcNcpPC)getPC()).getNbJoursAREF();
  }
  
  public int getNbJoursAREF()
  {
    return ((PbjcNcpPC)getPC()).getNbJoursAREF();
  }
  
  public void setNbJoursAREF(int p_nbJoursAREF)
  {
    ((PbjcNcpPC)getPC()).setNbJoursAREF(p_nbJoursAREF);
  }
  
  protected String rawGetComplementDeJustification0()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification0();
  }
  
  public String getComplementDeJustification0()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification0();
  }
  
  public void setComplementDeJustification0(String p_complementDeJustification0)
  {
    if ((m_complementDeJustification0 == null) || (p_complementDeJustification0 == null))
    {
      m_complementDeJustification0 = p_complementDeJustification0;
      ((PbjcNcpPC)getPC()).setComplementDeJustification0(p_complementDeJustification0);
    }
    else if ((m_complementDeJustification0 != null) && (p_complementDeJustification0 != null) && (!p_complementDeJustification0.equals(m_complementDeJustification0)))
    {
      m_complementDeJustification0 = p_complementDeJustification0;
      ((PbjcNcpPC)getPC()).setComplementDeJustification0(p_complementDeJustification0);
    }
  }
  
  protected String rawGetComplementDeJustification1()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification1();
  }
  
  public String getComplementDeJustification1()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification1();
  }
  
  public void setComplementDeJustification1(String p_complementDeJustification1)
  {
    if ((m_complementDeJustification1 == null) || (p_complementDeJustification1 == null))
    {
      m_complementDeJustification1 = p_complementDeJustification1;
      ((PbjcNcpPC)getPC()).setComplementDeJustification1(p_complementDeJustification1);
    }
    else if ((m_complementDeJustification1 != null) && (p_complementDeJustification1 != null) && (!p_complementDeJustification1.equals(m_complementDeJustification1)))
    {
      m_complementDeJustification1 = p_complementDeJustification1;
      ((PbjcNcpPC)getPC()).setComplementDeJustification1(p_complementDeJustification1);
    }
  }
  
  protected String rawGetComplementDeJustification2()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification2();
  }
  
  public String getComplementDeJustification2()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification2();
  }
  
  public void setComplementDeJustification2(String p_complementDeJustification2)
  {
    if ((m_complementDeJustification2 == null) || (p_complementDeJustification2 == null))
    {
      m_complementDeJustification2 = p_complementDeJustification2;
      ((PbjcNcpPC)getPC()).setComplementDeJustification2(p_complementDeJustification2);
    }
    else if ((m_complementDeJustification2 != null) && (p_complementDeJustification2 != null) && (!p_complementDeJustification2.equals(m_complementDeJustification2)))
    {
      m_complementDeJustification2 = p_complementDeJustification2;
      ((PbjcNcpPC)getPC()).setComplementDeJustification2(p_complementDeJustification2);
    }
  }
  
  protected String rawGetComplementDeJustification3()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification3();
  }
  
  public String getComplementDeJustification3()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification3();
  }
  
  public void setComplementDeJustification3(String p_complementDeJustification3)
  {
    if ((m_complementDeJustification3 == null) || (p_complementDeJustification3 == null))
    {
      m_complementDeJustification3 = p_complementDeJustification3;
      ((PbjcNcpPC)getPC()).setComplementDeJustification3(p_complementDeJustification3);
    }
    else if ((m_complementDeJustification3 != null) && (p_complementDeJustification3 != null) && (!p_complementDeJustification3.equals(m_complementDeJustification3)))
    {
      m_complementDeJustification3 = p_complementDeJustification3;
      ((PbjcNcpPC)getPC()).setComplementDeJustification3(p_complementDeJustification3);
    }
  }
  
  protected String rawGetComplementDeJustification4()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification4();
  }
  
  public String getComplementDeJustification4()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification4();
  }
  
  public void setComplementDeJustification4(String p_complementDeJustification4)
  {
    if ((m_complementDeJustification4 == null) || (p_complementDeJustification4 == null))
    {
      m_complementDeJustification4 = p_complementDeJustification4;
      ((PbjcNcpPC)getPC()).setComplementDeJustification4(p_complementDeJustification4);
    }
    else if ((m_complementDeJustification4 != null) && (p_complementDeJustification4 != null) && (!p_complementDeJustification4.equals(m_complementDeJustification4)))
    {
      m_complementDeJustification4 = p_complementDeJustification4;
      ((PbjcNcpPC)getPC()).setComplementDeJustification4(p_complementDeJustification4);
    }
  }
  
  protected String rawGetComplementDeJustification5()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification5();
  }
  
  public String getComplementDeJustification5()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification5();
  }
  
  public void setComplementDeJustification5(String p_complementDeJustification5)
  {
    if ((m_complementDeJustification5 == null) || (p_complementDeJustification5 == null))
    {
      m_complementDeJustification5 = p_complementDeJustification5;
      ((PbjcNcpPC)getPC()).setComplementDeJustification5(p_complementDeJustification5);
    }
    else if ((m_complementDeJustification5 != null) && (p_complementDeJustification5 != null) && (!p_complementDeJustification5.equals(m_complementDeJustification5)))
    {
      m_complementDeJustification5 = p_complementDeJustification5;
      ((PbjcNcpPC)getPC()).setComplementDeJustification5(p_complementDeJustification5);
    }
  }
  
  protected String rawGetComplementDeJustification6()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification6();
  }
  
  public String getComplementDeJustification6()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification6();
  }
  
  public void setComplementDeJustification6(String p_complementDeJustification6)
  {
    if ((m_complementDeJustification6 == null) || (p_complementDeJustification6 == null))
    {
      m_complementDeJustification6 = p_complementDeJustification6;
      ((PbjcNcpPC)getPC()).setComplementDeJustification6(p_complementDeJustification6);
    }
    else if ((m_complementDeJustification6 != null) && (p_complementDeJustification6 != null) && (!p_complementDeJustification6.equals(m_complementDeJustification6)))
    {
      m_complementDeJustification6 = p_complementDeJustification6;
      ((PbjcNcpPC)getPC()).setComplementDeJustification6(p_complementDeJustification6);
    }
  }
  
  protected String rawGetComplementDeJustification7()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification7();
  }
  
  public String getComplementDeJustification7()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification7();
  }
  
  public void setComplementDeJustification7(String p_complementDeJustification7)
  {
    if ((m_complementDeJustification7 == null) || (p_complementDeJustification7 == null))
    {
      m_complementDeJustification7 = p_complementDeJustification7;
      ((PbjcNcpPC)getPC()).setComplementDeJustification7(p_complementDeJustification7);
    }
    else if ((m_complementDeJustification7 != null) && (p_complementDeJustification7 != null) && (!p_complementDeJustification7.equals(m_complementDeJustification7)))
    {
      m_complementDeJustification7 = p_complementDeJustification7;
      ((PbjcNcpPC)getPC()).setComplementDeJustification7(p_complementDeJustification7);
    }
  }
  
  protected String rawGetComplementDeJustification8()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification8();
  }
  
  public String getComplementDeJustification8()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification8();
  }
  
  public void setComplementDeJustification8(String p_complementDeJustification8)
  {
    if ((m_complementDeJustification8 == null) || (p_complementDeJustification8 == null))
    {
      m_complementDeJustification8 = p_complementDeJustification8;
      ((PbjcNcpPC)getPC()).setComplementDeJustification8(p_complementDeJustification8);
    }
    else if ((m_complementDeJustification8 != null) && (p_complementDeJustification8 != null) && (!p_complementDeJustification8.equals(m_complementDeJustification8)))
    {
      m_complementDeJustification8 = p_complementDeJustification8;
      ((PbjcNcpPC)getPC()).setComplementDeJustification8(p_complementDeJustification8);
    }
  }
  
  protected String rawGetComplementDeJustification9()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification9();
  }
  
  public String getComplementDeJustification9()
  {
    return ((PbjcNcpPC)getPC()).getComplementDeJustification9();
  }
  
  public void setComplementDeJustification9(String p_complementDeJustification9)
  {
    if ((m_complementDeJustification9 == null) || (p_complementDeJustification9 == null))
    {
      m_complementDeJustification9 = p_complementDeJustification9;
      ((PbjcNcpPC)getPC()).setComplementDeJustification9(p_complementDeJustification9);
    }
    else if ((m_complementDeJustification9 != null) && (p_complementDeJustification9 != null) && (!p_complementDeJustification9.equals(m_complementDeJustification9)))
    {
      m_complementDeJustification9 = p_complementDeJustification9;
      ((PbjcNcpPC)getPC()).setComplementDeJustification9(p_complementDeJustification9);
    }
  }
  
  protected String rawGetCodeTypeMontant1()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant1();
  }
  
  public String getCodeTypeMontant1()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant1();
  }
  
  public void setCodeTypeMontant1(String p_codeTypeMontant1)
  {
    if ((m_codeTypeMontant1 == null) || (p_codeTypeMontant1 == null))
    {
      m_codeTypeMontant1 = p_codeTypeMontant1;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant1(p_codeTypeMontant1);
    }
    else if ((m_codeTypeMontant1 != null) && (p_codeTypeMontant1 != null) && (!p_codeTypeMontant1.equals(m_codeTypeMontant1)))
    {
      m_codeTypeMontant1 = p_codeTypeMontant1;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant1(p_codeTypeMontant1);
    }
  }
  
  protected int rawGetComplementTypeMontant1()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant1();
  }
  
  public int getComplementTypeMontant1()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant1();
  }
  
  public void setComplementTypeMontant1(int p_complementTypeMontant1)
  {
    ((PbjcNcpPC)getPC()).setComplementTypeMontant1(p_complementTypeMontant1);
  }
  
  protected BigDecimal rawGetAssiette1()
  {
    return ((PbjcNcpPC)getPC()).getAssiette1();
  }
  
  public BigDecimal getAssiette1()
  {
    return ((PbjcNcpPC)getPC()).getAssiette1();
  }
  
  public void setAssiette1(BigDecimal p_assiette1)
  {
    if ((m_assiette1 == null) || (p_assiette1 == null))
    {
      m_assiette1 = p_assiette1;
      ((PbjcNcpPC)getPC()).setAssiette1(p_assiette1);
    }
    else if ((m_assiette1 != null) && (p_assiette1 != null) && (!p_assiette1.equals(m_assiette1)))
    {
      m_assiette1 = p_assiette1;
      ((PbjcNcpPC)getPC()).setAssiette1(p_assiette1);
    }
  }
  
  protected BigDecimal rawGetBaseDeCalcul1()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul1();
  }
  
  public BigDecimal getBaseDeCalcul1()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul1();
  }
  
  public void setBaseDeCalcul1(BigDecimal p_baseDeCalcul1)
  {
    if ((m_baseDeCalcul1 == null) || (p_baseDeCalcul1 == null))
    {
      m_baseDeCalcul1 = p_baseDeCalcul1;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul1(p_baseDeCalcul1);
    }
    else if ((m_baseDeCalcul1 != null) && (p_baseDeCalcul1 != null) && (!p_baseDeCalcul1.equals(m_baseDeCalcul1)))
    {
      m_baseDeCalcul1 = p_baseDeCalcul1;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul1(p_baseDeCalcul1);
    }
  }
  
  protected BigDecimal rawGetTaux1()
  {
    return ((PbjcNcpPC)getPC()).getTaux1();
  }
  
  public BigDecimal getTaux1()
  {
    return ((PbjcNcpPC)getPC()).getTaux1();
  }
  
  public void setTaux1(BigDecimal p_taux1)
  {
    if ((m_taux1 == null) || (p_taux1 == null))
    {
      m_taux1 = p_taux1;
      ((PbjcNcpPC)getPC()).setTaux1(p_taux1);
    }
    else if ((m_taux1 != null) && (p_taux1 != null) && (!p_taux1.equals(m_taux1)))
    {
      m_taux1 = p_taux1;
      ((PbjcNcpPC)getPC()).setTaux1(p_taux1);
    }
  }
  
  protected BigDecimal rawGetResultatCalcul1()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul1();
  }
  
  public BigDecimal getResultatCalcul1()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul1();
  }
  
  public void setResultatCalcul1(BigDecimal p_resultatCalcul1)
  {
    if ((m_resultatCalcul1 == null) || (p_resultatCalcul1 == null))
    {
      m_resultatCalcul1 = p_resultatCalcul1;
      ((PbjcNcpPC)getPC()).setResultatCalcul1(p_resultatCalcul1);
    }
    else if ((m_resultatCalcul1 != null) && (p_resultatCalcul1 != null) && (!p_resultatCalcul1.equals(m_resultatCalcul1)))
    {
      m_resultatCalcul1 = p_resultatCalcul1;
      ((PbjcNcpPC)getPC()).setResultatCalcul1(p_resultatCalcul1);
    }
  }
  
  protected String rawGetPositionExoneration1()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration1();
  }
  
  public String getPositionExoneration1()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration1();
  }
  
  public void setPositionExoneration1(String p_positionExoneration1)
  {
    if ((m_positionExoneration1 == null) || (p_positionExoneration1 == null))
    {
      m_positionExoneration1 = p_positionExoneration1;
      ((PbjcNcpPC)getPC()).setPositionExoneration1(p_positionExoneration1);
    }
    else if ((m_positionExoneration1 != null) && (p_positionExoneration1 != null) && (!p_positionExoneration1.equals(m_positionExoneration1)))
    {
      m_positionExoneration1 = p_positionExoneration1;
      ((PbjcNcpPC)getPC()).setPositionExoneration1(p_positionExoneration1);
    }
  }
  
  protected String rawGetCodeTypeMontant2()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant2();
  }
  
  public String getCodeTypeMontant2()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant2();
  }
  
  public void setCodeTypeMontant2(String p_codeTypeMontant2)
  {
    if ((m_codeTypeMontant2 == null) || (p_codeTypeMontant2 == null))
    {
      m_codeTypeMontant2 = p_codeTypeMontant2;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant2(p_codeTypeMontant2);
    }
    else if ((m_codeTypeMontant2 != null) && (p_codeTypeMontant2 != null) && (!p_codeTypeMontant2.equals(m_codeTypeMontant2)))
    {
      m_codeTypeMontant2 = p_codeTypeMontant2;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant2(p_codeTypeMontant2);
    }
  }
  
  protected int rawGetComplementTypeMontant2()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant2();
  }
  
  public int getComplementTypeMontant2()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant2();
  }
  
  public void setComplementTypeMontant2(int p_complementTypeMontant2)
  {
    ((PbjcNcpPC)getPC()).setComplementTypeMontant2(p_complementTypeMontant2);
  }
  
  protected BigDecimal rawGetAssiette2()
  {
    return ((PbjcNcpPC)getPC()).getAssiette2();
  }
  
  public BigDecimal getAssiette2()
  {
    return ((PbjcNcpPC)getPC()).getAssiette2();
  }
  
  public void setAssiette2(BigDecimal p_assiette2)
  {
    if ((m_assiette2 == null) || (p_assiette2 == null))
    {
      m_assiette2 = p_assiette2;
      ((PbjcNcpPC)getPC()).setAssiette2(p_assiette2);
    }
    else if ((m_assiette2 != null) && (p_assiette2 != null) && (!p_assiette2.equals(m_assiette2)))
    {
      m_assiette2 = p_assiette2;
      ((PbjcNcpPC)getPC()).setAssiette2(p_assiette2);
    }
  }
  
  protected BigDecimal rawGetBaseDeCalcul2()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul2();
  }
  
  public BigDecimal getBaseDeCalcul2()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul2();
  }
  
  public void setBaseDeCalcul2(BigDecimal p_baseDeCalcul2)
  {
    if ((m_baseDeCalcul2 == null) || (p_baseDeCalcul2 == null))
    {
      m_baseDeCalcul2 = p_baseDeCalcul2;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul2(p_baseDeCalcul2);
    }
    else if ((m_baseDeCalcul2 != null) && (p_baseDeCalcul2 != null) && (!p_baseDeCalcul2.equals(m_baseDeCalcul2)))
    {
      m_baseDeCalcul2 = p_baseDeCalcul2;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul2(p_baseDeCalcul2);
    }
  }
  
  protected BigDecimal rawGetTaux2()
  {
    return ((PbjcNcpPC)getPC()).getTaux2();
  }
  
  public BigDecimal getTaux2()
  {
    return ((PbjcNcpPC)getPC()).getTaux2();
  }
  
  public void setTaux2(BigDecimal p_taux2)
  {
    if ((m_taux2 == null) || (p_taux2 == null))
    {
      m_taux2 = p_taux2;
      ((PbjcNcpPC)getPC()).setTaux2(p_taux2);
    }
    else if ((m_taux2 != null) && (p_taux2 != null) && (!p_taux2.equals(m_taux2)))
    {
      m_taux2 = p_taux2;
      ((PbjcNcpPC)getPC()).setTaux2(p_taux2);
    }
  }
  
  protected BigDecimal rawGetResultatCalcul2()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul2();
  }
  
  public BigDecimal getResultatCalcul2()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul2();
  }
  
  public void setResultatCalcul2(BigDecimal p_resultatCalcul2)
  {
    if ((m_resultatCalcul2 == null) || (p_resultatCalcul2 == null))
    {
      m_resultatCalcul2 = p_resultatCalcul2;
      ((PbjcNcpPC)getPC()).setResultatCalcul2(p_resultatCalcul2);
    }
    else if ((m_resultatCalcul2 != null) && (p_resultatCalcul2 != null) && (!p_resultatCalcul2.equals(m_resultatCalcul2)))
    {
      m_resultatCalcul2 = p_resultatCalcul2;
      ((PbjcNcpPC)getPC()).setResultatCalcul2(p_resultatCalcul2);
    }
  }
  
  protected String rawGetPositionExoneration2()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration2();
  }
  
  public String getPositionExoneration2()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration2();
  }
  
  public void setPositionExoneration2(String p_positionExoneration2)
  {
    if ((m_positionExoneration2 == null) || (p_positionExoneration2 == null))
    {
      m_positionExoneration2 = p_positionExoneration2;
      ((PbjcNcpPC)getPC()).setPositionExoneration2(p_positionExoneration2);
    }
    else if ((m_positionExoneration2 != null) && (p_positionExoneration2 != null) && (!p_positionExoneration2.equals(m_positionExoneration2)))
    {
      m_positionExoneration2 = p_positionExoneration2;
      ((PbjcNcpPC)getPC()).setPositionExoneration2(p_positionExoneration2);
    }
  }
  
  protected String rawGetCodeTypeMontant3()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant3();
  }
  
  public String getCodeTypeMontant3()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant3();
  }
  
  public void setCodeTypeMontant3(String p_codeTypeMontant3)
  {
    if ((m_codeTypeMontant3 == null) || (p_codeTypeMontant3 == null))
    {
      m_codeTypeMontant3 = p_codeTypeMontant3;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant3(p_codeTypeMontant3);
    }
    else if ((m_codeTypeMontant3 != null) && (p_codeTypeMontant3 != null) && (!p_codeTypeMontant3.equals(m_codeTypeMontant3)))
    {
      m_codeTypeMontant3 = p_codeTypeMontant3;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant3(p_codeTypeMontant3);
    }
  }
  
  protected int rawGetComplementTypeMontant3()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant3();
  }
  
  public int getComplementTypeMontant3()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant3();
  }
  
  public void setComplementTypeMontant3(int p_complementTypeMontant3)
  {
    ((PbjcNcpPC)getPC()).setComplementTypeMontant3(p_complementTypeMontant3);
  }
  
  protected BigDecimal rawGetAssiette3()
  {
    return ((PbjcNcpPC)getPC()).getAssiette3();
  }
  
  public BigDecimal getAssiette3()
  {
    return ((PbjcNcpPC)getPC()).getAssiette3();
  }
  
  public void setAssiette3(BigDecimal p_assiette3)
  {
    if ((m_assiette3 == null) || (p_assiette3 == null))
    {
      m_assiette3 = p_assiette3;
      ((PbjcNcpPC)getPC()).setAssiette3(p_assiette3);
    }
    else if ((m_assiette3 != null) && (p_assiette3 != null) && (!p_assiette3.equals(m_assiette3)))
    {
      m_assiette3 = p_assiette3;
      ((PbjcNcpPC)getPC()).setAssiette3(p_assiette3);
    }
  }
  
  protected BigDecimal rawGetBaseDeCalcul3()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul3();
  }
  
  public BigDecimal getBaseDeCalcul3()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul3();
  }
  
  public void setBaseDeCalcul3(BigDecimal p_baseDeCalcul3)
  {
    if ((m_baseDeCalcul3 == null) || (p_baseDeCalcul3 == null))
    {
      m_baseDeCalcul3 = p_baseDeCalcul3;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul3(p_baseDeCalcul3);
    }
    else if ((m_baseDeCalcul3 != null) && (p_baseDeCalcul3 != null) && (!p_baseDeCalcul3.equals(m_baseDeCalcul3)))
    {
      m_baseDeCalcul3 = p_baseDeCalcul3;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul3(p_baseDeCalcul3);
    }
  }
  
  protected BigDecimal rawGetTaux3()
  {
    return ((PbjcNcpPC)getPC()).getTaux3();
  }
  
  public BigDecimal getTaux3()
  {
    return ((PbjcNcpPC)getPC()).getTaux3();
  }
  
  public void setTaux3(BigDecimal p_taux3)
  {
    if ((m_taux3 == null) || (p_taux3 == null))
    {
      m_taux3 = p_taux3;
      ((PbjcNcpPC)getPC()).setTaux3(p_taux3);
    }
    else if ((m_taux3 != null) && (p_taux3 != null) && (!p_taux3.equals(m_taux3)))
    {
      m_taux3 = p_taux3;
      ((PbjcNcpPC)getPC()).setTaux3(p_taux3);
    }
  }
  
  protected BigDecimal rawGetResultatCalcul3()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul3();
  }
  
  public BigDecimal getResultatCalcul3()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul3();
  }
  
  public void setResultatCalcul3(BigDecimal p_resultatCalcul3)
  {
    if ((m_resultatCalcul3 == null) || (p_resultatCalcul3 == null))
    {
      m_resultatCalcul3 = p_resultatCalcul3;
      ((PbjcNcpPC)getPC()).setResultatCalcul3(p_resultatCalcul3);
    }
    else if ((m_resultatCalcul3 != null) && (p_resultatCalcul3 != null) && (!p_resultatCalcul3.equals(m_resultatCalcul3)))
    {
      m_resultatCalcul3 = p_resultatCalcul3;
      ((PbjcNcpPC)getPC()).setResultatCalcul3(p_resultatCalcul3);
    }
  }
  
  protected String rawGetPositionExoneration3()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration3();
  }
  
  public String getPositionExoneration3()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration3();
  }
  
  public void setPositionExoneration3(String p_positionExoneration3)
  {
    if ((m_positionExoneration3 == null) || (p_positionExoneration3 == null))
    {
      m_positionExoneration3 = p_positionExoneration3;
      ((PbjcNcpPC)getPC()).setPositionExoneration3(p_positionExoneration3);
    }
    else if ((m_positionExoneration3 != null) && (p_positionExoneration3 != null) && (!p_positionExoneration3.equals(m_positionExoneration3)))
    {
      m_positionExoneration3 = p_positionExoneration3;
      ((PbjcNcpPC)getPC()).setPositionExoneration3(p_positionExoneration3);
    }
  }
  
  protected String rawGetCodeTypeMontant4()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant4();
  }
  
  public String getCodeTypeMontant4()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant4();
  }
  
  public void setCodeTypeMontant4(String p_codeTypeMontant4)
  {
    if ((m_codeTypeMontant4 == null) || (p_codeTypeMontant4 == null))
    {
      m_codeTypeMontant4 = p_codeTypeMontant4;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant4(p_codeTypeMontant4);
    }
    else if ((m_codeTypeMontant4 != null) && (p_codeTypeMontant4 != null) && (!p_codeTypeMontant4.equals(m_codeTypeMontant4)))
    {
      m_codeTypeMontant4 = p_codeTypeMontant4;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant4(p_codeTypeMontant4);
    }
  }
  
  protected int rawGetComplementTypeMontant4()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant4();
  }
  
  public int getComplementTypeMontant4()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant4();
  }
  
  public void setComplementTypeMontant4(int p_complementTypeMontant4)
  {
    ((PbjcNcpPC)getPC()).setComplementTypeMontant4(p_complementTypeMontant4);
  }
  
  protected BigDecimal rawGetAssiette4()
  {
    return ((PbjcNcpPC)getPC()).getAssiette4();
  }
  
  public BigDecimal getAssiette4()
  {
    return ((PbjcNcpPC)getPC()).getAssiette4();
  }
  
  public void setAssiette4(BigDecimal p_assiette4)
  {
    if ((m_assiette4 == null) || (p_assiette4 == null))
    {
      m_assiette4 = p_assiette4;
      ((PbjcNcpPC)getPC()).setAssiette4(p_assiette4);
    }
    else if ((m_assiette4 != null) && (p_assiette4 != null) && (!p_assiette4.equals(m_assiette4)))
    {
      m_assiette4 = p_assiette4;
      ((PbjcNcpPC)getPC()).setAssiette4(p_assiette4);
    }
  }
  
  protected BigDecimal rawGetBaseDeCalcul4()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul4();
  }
  
  public BigDecimal getBaseDeCalcul4()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul4();
  }
  
  public void setBaseDeCalcul4(BigDecimal p_baseDeCalcul4)
  {
    if ((m_baseDeCalcul4 == null) || (p_baseDeCalcul4 == null))
    {
      m_baseDeCalcul4 = p_baseDeCalcul4;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul4(p_baseDeCalcul4);
    }
    else if ((m_baseDeCalcul4 != null) && (p_baseDeCalcul4 != null) && (!p_baseDeCalcul4.equals(m_baseDeCalcul4)))
    {
      m_baseDeCalcul4 = p_baseDeCalcul4;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul4(p_baseDeCalcul4);
    }
  }
  
  protected BigDecimal rawGetTaux4()
  {
    return ((PbjcNcpPC)getPC()).getTaux4();
  }
  
  public BigDecimal getTaux4()
  {
    return ((PbjcNcpPC)getPC()).getTaux4();
  }
  
  public void setTaux4(BigDecimal p_taux4)
  {
    if ((m_taux4 == null) || (p_taux4 == null))
    {
      m_taux4 = p_taux4;
      ((PbjcNcpPC)getPC()).setTaux4(p_taux4);
    }
    else if ((m_taux4 != null) && (p_taux4 != null) && (!p_taux4.equals(m_taux4)))
    {
      m_taux4 = p_taux4;
      ((PbjcNcpPC)getPC()).setTaux4(p_taux4);
    }
  }
  
  protected BigDecimal rawGetResultatCalcul4()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul4();
  }
  
  public BigDecimal getResultatCalcul4()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul4();
  }
  
  public void setResultatCalcul4(BigDecimal p_resultatCalcul4)
  {
    if ((m_resultatCalcul4 == null) || (p_resultatCalcul4 == null))
    {
      m_resultatCalcul4 = p_resultatCalcul4;
      ((PbjcNcpPC)getPC()).setResultatCalcul4(p_resultatCalcul4);
    }
    else if ((m_resultatCalcul4 != null) && (p_resultatCalcul4 != null) && (!p_resultatCalcul4.equals(m_resultatCalcul4)))
    {
      m_resultatCalcul4 = p_resultatCalcul4;
      ((PbjcNcpPC)getPC()).setResultatCalcul4(p_resultatCalcul4);
    }
  }
  
  protected String rawGetPositionExoneration4()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration4();
  }
  
  public String getPositionExoneration4()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration4();
  }
  
  public void setPositionExoneration4(String p_positionExoneration4)
  {
    if ((m_positionExoneration4 == null) || (p_positionExoneration4 == null))
    {
      m_positionExoneration4 = p_positionExoneration4;
      ((PbjcNcpPC)getPC()).setPositionExoneration4(p_positionExoneration4);
    }
    else if ((m_positionExoneration4 != null) && (p_positionExoneration4 != null) && (!p_positionExoneration4.equals(m_positionExoneration4)))
    {
      m_positionExoneration4 = p_positionExoneration4;
      ((PbjcNcpPC)getPC()).setPositionExoneration4(p_positionExoneration4);
    }
  }
  
  protected String rawGetCodeTypeMontant5()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant5();
  }
  
  public String getCodeTypeMontant5()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant5();
  }
  
  public void setCodeTypeMontant5(String p_codeTypeMontant5)
  {
    if ((m_codeTypeMontant5 == null) || (p_codeTypeMontant5 == null))
    {
      m_codeTypeMontant5 = p_codeTypeMontant5;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant5(p_codeTypeMontant5);
    }
    else if ((m_codeTypeMontant5 != null) && (p_codeTypeMontant5 != null) && (!p_codeTypeMontant5.equals(m_codeTypeMontant5)))
    {
      m_codeTypeMontant5 = p_codeTypeMontant5;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant5(p_codeTypeMontant5);
    }
  }
  
  protected int rawGetComplementTypeMontant5()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant5();
  }
  
  public int getComplementTypeMontant5()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant5();
  }
  
  public void setComplementTypeMontant5(int p_complementTypeMontant5)
  {
    ((PbjcNcpPC)getPC()).setComplementTypeMontant5(p_complementTypeMontant5);
  }
  
  protected BigDecimal rawGetAssiette5()
  {
    return ((PbjcNcpPC)getPC()).getAssiette5();
  }
  
  public BigDecimal getAssiette5()
  {
    return ((PbjcNcpPC)getPC()).getAssiette5();
  }
  
  public void setAssiette5(BigDecimal p_assiette5)
  {
    if ((m_assiette5 == null) || (p_assiette5 == null))
    {
      m_assiette5 = p_assiette5;
      ((PbjcNcpPC)getPC()).setAssiette5(p_assiette5);
    }
    else if ((m_assiette5 != null) && (p_assiette5 != null) && (!p_assiette5.equals(m_assiette5)))
    {
      m_assiette5 = p_assiette5;
      ((PbjcNcpPC)getPC()).setAssiette5(p_assiette5);
    }
  }
  
  protected BigDecimal rawGetBaseDeCalcul5()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul5();
  }
  
  public BigDecimal getBaseDeCalcul5()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul5();
  }
  
  public void setBaseDeCalcul5(BigDecimal p_baseDeCalcul5)
  {
    if ((m_baseDeCalcul5 == null) || (p_baseDeCalcul5 == null))
    {
      m_baseDeCalcul5 = p_baseDeCalcul5;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul5(p_baseDeCalcul5);
    }
    else if ((m_baseDeCalcul5 != null) && (p_baseDeCalcul5 != null) && (!p_baseDeCalcul5.equals(m_baseDeCalcul5)))
    {
      m_baseDeCalcul5 = p_baseDeCalcul5;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul5(p_baseDeCalcul5);
    }
  }
  
  protected BigDecimal rawGetTaux5()
  {
    return ((PbjcNcpPC)getPC()).getTaux5();
  }
  
  public BigDecimal getTaux5()
  {
    return ((PbjcNcpPC)getPC()).getTaux5();
  }
  
  public void setTaux5(BigDecimal p_taux5)
  {
    if ((m_taux5 == null) || (p_taux5 == null))
    {
      m_taux5 = p_taux5;
      ((PbjcNcpPC)getPC()).setTaux5(p_taux5);
    }
    else if ((m_taux5 != null) && (p_taux5 != null) && (!p_taux5.equals(m_taux5)))
    {
      m_taux5 = p_taux5;
      ((PbjcNcpPC)getPC()).setTaux5(p_taux5);
    }
  }
  
  protected BigDecimal rawGetResultatCalcul5()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul5();
  }
  
  public BigDecimal getResultatCalcul5()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul5();
  }
  
  public void setResultatCalcul5(BigDecimal p_resultatCalcul5)
  {
    if ((m_resultatCalcul5 == null) || (p_resultatCalcul5 == null))
    {
      m_resultatCalcul5 = p_resultatCalcul5;
      ((PbjcNcpPC)getPC()).setResultatCalcul5(p_resultatCalcul5);
    }
    else if ((m_resultatCalcul5 != null) && (p_resultatCalcul5 != null) && (!p_resultatCalcul5.equals(m_resultatCalcul5)))
    {
      m_resultatCalcul5 = p_resultatCalcul5;
      ((PbjcNcpPC)getPC()).setResultatCalcul5(p_resultatCalcul5);
    }
  }
  
  protected String rawGetPositionExoneration5()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration5();
  }
  
  public String getPositionExoneration5()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration5();
  }
  
  public void setPositionExoneration5(String p_positionExoneration5)
  {
    if ((m_positionExoneration5 == null) || (p_positionExoneration5 == null))
    {
      m_positionExoneration5 = p_positionExoneration5;
      ((PbjcNcpPC)getPC()).setPositionExoneration5(p_positionExoneration5);
    }
    else if ((m_positionExoneration5 != null) && (p_positionExoneration5 != null) && (!p_positionExoneration5.equals(m_positionExoneration5)))
    {
      m_positionExoneration5 = p_positionExoneration5;
      ((PbjcNcpPC)getPC()).setPositionExoneration5(p_positionExoneration5);
    }
  }
  
  protected String rawGetCodeTypeMontant6()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant6();
  }
  
  public String getCodeTypeMontant6()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant6();
  }
  
  public void setCodeTypeMontant6(String p_codeTypeMontant6)
  {
    if ((m_codeTypeMontant6 == null) || (p_codeTypeMontant6 == null))
    {
      m_codeTypeMontant6 = p_codeTypeMontant6;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant6(p_codeTypeMontant6);
    }
    else if ((m_codeTypeMontant6 != null) && (p_codeTypeMontant6 != null) && (!p_codeTypeMontant6.equals(m_codeTypeMontant6)))
    {
      m_codeTypeMontant6 = p_codeTypeMontant6;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant6(p_codeTypeMontant6);
    }
  }
  
  protected int rawGetComplementTypeMontant6()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant6();
  }
  
  public int getComplementTypeMontant6()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant6();
  }
  
  public void setComplementTypeMontant6(int p_complementTypeMontant6)
  {
    ((PbjcNcpPC)getPC()).setComplementTypeMontant6(p_complementTypeMontant6);
  }
  
  protected BigDecimal rawGetAssiette6()
  {
    return ((PbjcNcpPC)getPC()).getAssiette6();
  }
  
  public BigDecimal getAssiette6()
  {
    return ((PbjcNcpPC)getPC()).getAssiette6();
  }
  
  public void setAssiette6(BigDecimal p_assiette6)
  {
    if ((m_assiette6 == null) || (p_assiette6 == null))
    {
      m_assiette6 = p_assiette6;
      ((PbjcNcpPC)getPC()).setAssiette6(p_assiette6);
    }
    else if ((m_assiette6 != null) && (p_assiette6 != null) && (!p_assiette6.equals(m_assiette6)))
    {
      m_assiette6 = p_assiette6;
      ((PbjcNcpPC)getPC()).setAssiette6(p_assiette6);
    }
  }
  
  protected BigDecimal rawGetBaseDeCalcul6()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul6();
  }
  
  public BigDecimal getBaseDeCalcul6()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul6();
  }
  
  public void setBaseDeCalcul6(BigDecimal p_baseDeCalcul6)
  {
    if ((m_baseDeCalcul6 == null) || (p_baseDeCalcul6 == null))
    {
      m_baseDeCalcul6 = p_baseDeCalcul6;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul6(p_baseDeCalcul6);
    }
    else if ((m_baseDeCalcul6 != null) && (p_baseDeCalcul6 != null) && (!p_baseDeCalcul6.equals(m_baseDeCalcul6)))
    {
      m_baseDeCalcul6 = p_baseDeCalcul6;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul6(p_baseDeCalcul6);
    }
  }
  
  protected BigDecimal rawGetTaux6()
  {
    return ((PbjcNcpPC)getPC()).getTaux6();
  }
  
  public BigDecimal getTaux6()
  {
    return ((PbjcNcpPC)getPC()).getTaux6();
  }
  
  public void setTaux6(BigDecimal p_taux6)
  {
    if ((m_taux6 == null) || (p_taux6 == null))
    {
      m_taux6 = p_taux6;
      ((PbjcNcpPC)getPC()).setTaux6(p_taux6);
    }
    else if ((m_taux6 != null) && (p_taux6 != null) && (!p_taux6.equals(m_taux6)))
    {
      m_taux6 = p_taux6;
      ((PbjcNcpPC)getPC()).setTaux6(p_taux6);
    }
  }
  
  protected BigDecimal rawGetResultatCalcul6()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul6();
  }
  
  public BigDecimal getResultatCalcul6()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul6();
  }
  
  public void setResultatCalcul6(BigDecimal p_resultatCalcul6)
  {
    if ((m_resultatCalcul6 == null) || (p_resultatCalcul6 == null))
    {
      m_resultatCalcul6 = p_resultatCalcul6;
      ((PbjcNcpPC)getPC()).setResultatCalcul6(p_resultatCalcul6);
    }
    else if ((m_resultatCalcul6 != null) && (p_resultatCalcul6 != null) && (!p_resultatCalcul6.equals(m_resultatCalcul6)))
    {
      m_resultatCalcul6 = p_resultatCalcul6;
      ((PbjcNcpPC)getPC()).setResultatCalcul6(p_resultatCalcul6);
    }
  }
  
  protected String rawGetPositionExoneration6()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration6();
  }
  
  public String getPositionExoneration6()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration6();
  }
  
  public void setPositionExoneration6(String p_positionExoneration6)
  {
    if ((m_positionExoneration6 == null) || (p_positionExoneration6 == null))
    {
      m_positionExoneration6 = p_positionExoneration6;
      ((PbjcNcpPC)getPC()).setPositionExoneration6(p_positionExoneration6);
    }
    else if ((m_positionExoneration6 != null) && (p_positionExoneration6 != null) && (!p_positionExoneration6.equals(m_positionExoneration6)))
    {
      m_positionExoneration6 = p_positionExoneration6;
      ((PbjcNcpPC)getPC()).setPositionExoneration6(p_positionExoneration6);
    }
  }
  
  protected String rawGetCodeTypeMontant7()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant7();
  }
  
  public String getCodeTypeMontant7()
  {
    return ((PbjcNcpPC)getPC()).getCodeTypeMontant7();
  }
  
  public void setCodeTypeMontant7(String p_codeTypeMontant7)
  {
    if ((m_codeTypeMontant7 == null) || (p_codeTypeMontant7 == null))
    {
      m_codeTypeMontant7 = p_codeTypeMontant7;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant7(p_codeTypeMontant7);
    }
    else if ((m_codeTypeMontant7 != null) && (p_codeTypeMontant7 != null) && (!p_codeTypeMontant7.equals(m_codeTypeMontant7)))
    {
      m_codeTypeMontant7 = p_codeTypeMontant7;
      ((PbjcNcpPC)getPC()).setCodeTypeMontant7(p_codeTypeMontant7);
    }
  }
  
  protected int rawGetComplementTypeMontant7()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant7();
  }
  
  public int getComplementTypeMontant7()
  {
    return ((PbjcNcpPC)getPC()).getComplementTypeMontant7();
  }
  
  public void setComplementTypeMontant7(int p_complementTypeMontant7)
  {
    ((PbjcNcpPC)getPC()).setComplementTypeMontant7(p_complementTypeMontant7);
  }
  
  protected BigDecimal rawGetAssiette7()
  {
    return ((PbjcNcpPC)getPC()).getAssiette7();
  }
  
  public BigDecimal getAssiette7()
  {
    return ((PbjcNcpPC)getPC()).getAssiette7();
  }
  
  public void setAssiette7(BigDecimal p_assiette7)
  {
    if ((m_assiette7 == null) || (p_assiette7 == null))
    {
      m_assiette7 = p_assiette7;
      ((PbjcNcpPC)getPC()).setAssiette7(p_assiette7);
    }
    else if ((m_assiette7 != null) && (p_assiette7 != null) && (!p_assiette7.equals(m_assiette7)))
    {
      m_assiette7 = p_assiette7;
      ((PbjcNcpPC)getPC()).setAssiette7(p_assiette7);
    }
  }
  
  protected BigDecimal rawGetBaseDeCalcul7()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul7();
  }
  
  public BigDecimal getBaseDeCalcul7()
  {
    return ((PbjcNcpPC)getPC()).getBaseDeCalcul7();
  }
  
  public void setBaseDeCalcul7(BigDecimal p_baseDeCalcul7)
  {
    if ((m_baseDeCalcul7 == null) || (p_baseDeCalcul7 == null))
    {
      m_baseDeCalcul7 = p_baseDeCalcul7;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul7(p_baseDeCalcul7);
    }
    else if ((m_baseDeCalcul7 != null) && (p_baseDeCalcul7 != null) && (!p_baseDeCalcul7.equals(m_baseDeCalcul7)))
    {
      m_baseDeCalcul7 = p_baseDeCalcul7;
      ((PbjcNcpPC)getPC()).setBaseDeCalcul7(p_baseDeCalcul7);
    }
  }
  
  protected BigDecimal rawGetTaux7()
  {
    return ((PbjcNcpPC)getPC()).getTaux7();
  }
  
  public BigDecimal getTaux7()
  {
    return ((PbjcNcpPC)getPC()).getTaux7();
  }
  
  public void setTaux7(BigDecimal p_taux7)
  {
    if ((m_taux7 == null) || (p_taux7 == null))
    {
      m_taux7 = p_taux7;
      ((PbjcNcpPC)getPC()).setTaux7(p_taux7);
    }
    else if ((m_taux7 != null) && (p_taux7 != null) && (!p_taux7.equals(m_taux7)))
    {
      m_taux7 = p_taux7;
      ((PbjcNcpPC)getPC()).setTaux7(p_taux7);
    }
  }
  
  protected BigDecimal rawGetResultatCalcul7()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul7();
  }
  
  public BigDecimal getResultatCalcul7()
  {
    return ((PbjcNcpPC)getPC()).getResultatCalcul7();
  }
  
  public void setResultatCalcul7(BigDecimal p_resultatCalcul7)
  {
    if ((m_resultatCalcul7 == null) || (p_resultatCalcul7 == null))
    {
      m_resultatCalcul7 = p_resultatCalcul7;
      ((PbjcNcpPC)getPC()).setResultatCalcul7(p_resultatCalcul7);
    }
    else if ((m_resultatCalcul7 != null) && (p_resultatCalcul7 != null) && (!p_resultatCalcul7.equals(m_resultatCalcul7)))
    {
      m_resultatCalcul7 = p_resultatCalcul7;
      ((PbjcNcpPC)getPC()).setResultatCalcul7(p_resultatCalcul7);
    }
  }
  
  protected String rawGetPositionExoneration7()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration7();
  }
  
  public String getPositionExoneration7()
  {
    return ((PbjcNcpPC)getPC()).getPositionExoneration7();
  }
  
  public void setPositionExoneration7(String p_positionExoneration7)
  {
    if ((m_positionExoneration7 == null) || (p_positionExoneration7 == null))
    {
      m_positionExoneration7 = p_positionExoneration7;
      ((PbjcNcpPC)getPC()).setPositionExoneration7(p_positionExoneration7);
    }
    else if ((m_positionExoneration7 != null) && (p_positionExoneration7 != null) && (!p_positionExoneration7.equals(m_positionExoneration7)))
    {
      m_positionExoneration7 = p_positionExoneration7;
      ((PbjcNcpPC)getPC()).setPositionExoneration7(p_positionExoneration7);
    }
  }
  
  protected String rawGetSituationParticuliere()
  {
    return ((PbjcNcpPC)getPC()).getSituationParticuliere();
  }
  
  public String getSituationParticuliere()
  {
    return ((PbjcNcpPC)getPC()).getSituationParticuliere();
  }
  
  public void setSituationParticuliere(String p_situationParticuliere)
  {
    if ((m_situationParticuliere == null) || (p_situationParticuliere == null))
    {
      m_situationParticuliere = p_situationParticuliere;
      ((PbjcNcpPC)getPC()).setSituationParticuliere(p_situationParticuliere);
    }
    else if ((m_situationParticuliere != null) && (p_situationParticuliere != null) && (!p_situationParticuliere.equals(m_situationParticuliere)))
    {
      m_situationParticuliere = p_situationParticuliere;
      ((PbjcNcpPC)getPC()).setSituationParticuliere(p_situationParticuliere);
    }
  }
  
  protected String rawGetCategorie()
  {
    return ((PbjcNcpPC)getPC()).getCategorie();
  }
  
  public String getCategorie()
  {
    return ((PbjcNcpPC)getPC()).getCategorie();
  }
  
  public void setCategorie(String p_categorie)
  {
    if ((m_categorie == null) || (p_categorie == null))
    {
      m_categorie = p_categorie;
      ((PbjcNcpPC)getPC()).setCategorie(p_categorie);
    }
    else if ((m_categorie != null) && (p_categorie != null) && (!p_categorie.equals(m_categorie)))
    {
      m_categorie = p_categorie;
      ((PbjcNcpPC)getPC()).setCategorie(p_categorie);
    }
  }
  
  protected String rawGetTypeDispositif()
  {
    return ((PbjcNcpPC)getPC()).getTypeDispositif();
  }
  
  public String getTypeDispositif()
  {
    return ((PbjcNcpPC)getPC()).getTypeDispositif();
  }
  
  public void setTypeDispositif(String p_typeDispositif)
  {
    if ((m_typeDispositif == null) || (p_typeDispositif == null))
    {
      m_typeDispositif = p_typeDispositif;
      ((PbjcNcpPC)getPC()).setTypeDispositif(p_typeDispositif);
    }
    else if ((m_typeDispositif != null) && (p_typeDispositif != null) && (!p_typeDispositif.equals(m_typeDispositif)))
    {
      m_typeDispositif = p_typeDispositif;
      ((PbjcNcpPC)getPC()).setTypeDispositif(p_typeDispositif);
    }
  }
  
  protected String rawGetCodePays()
  {
    return ((PbjcNcpPC)getPC()).getCodePays();
  }
  
  public String getCodePays()
  {
    return ((PbjcNcpPC)getPC()).getCodePays();
  }
  
  public void setCodePays(String p_codePays)
  {
    if ((m_codePays == null) || (p_codePays == null))
    {
      m_codePays = p_codePays;
      ((PbjcNcpPC)getPC()).setCodePays(p_codePays);
    }
    else if ((m_codePays != null) && (p_codePays != null) && (!p_codePays.equals(m_codePays)))
    {
      m_codePays = p_codePays;
      ((PbjcNcpPC)getPC()).setCodePays(p_codePays);
    }
  }
  
  protected String rawGetTypePopulation1()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation1();
  }
  
  public String getTypePopulation1()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation1();
  }
  
  public void setTypePopulation1(String p_typePopulation1)
  {
    if ((m_typePopulation1 == null) || (p_typePopulation1 == null))
    {
      m_typePopulation1 = p_typePopulation1;
      ((PbjcNcpPC)getPC()).setTypePopulation1(p_typePopulation1);
    }
    else if ((m_typePopulation1 != null) && (p_typePopulation1 != null) && (!p_typePopulation1.equals(m_typePopulation1)))
    {
      m_typePopulation1 = p_typePopulation1;
      ((PbjcNcpPC)getPC()).setTypePopulation1(p_typePopulation1);
    }
  }
  
  protected String rawGetSousTypePopulation1()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation1();
  }
  
  public String getSousTypePopulation1()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation1();
  }
  
  public void setSousTypePopulation1(String p_sousTypePopulation1)
  {
    if ((m_sousTypePopulation1 == null) || (p_sousTypePopulation1 == null))
    {
      m_sousTypePopulation1 = p_sousTypePopulation1;
      ((PbjcNcpPC)getPC()).setSousTypePopulation1(p_sousTypePopulation1);
    }
    else if ((m_sousTypePopulation1 != null) && (p_sousTypePopulation1 != null) && (!p_sousTypePopulation1.equals(m_sousTypePopulation1)))
    {
      m_sousTypePopulation1 = p_sousTypePopulation1;
      ((PbjcNcpPC)getPC()).setSousTypePopulation1(p_sousTypePopulation1);
    }
  }
  
  protected String rawGetStatutPrestation1()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation1();
  }
  
  public String getStatutPrestation1()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation1();
  }
  
  public void setStatutPrestation1(String p_statutPrestation1)
  {
    if ((m_statutPrestation1 == null) || (p_statutPrestation1 == null))
    {
      m_statutPrestation1 = p_statutPrestation1;
      ((PbjcNcpPC)getPC()).setStatutPrestation1(p_statutPrestation1);
    }
    else if ((m_statutPrestation1 != null) && (p_statutPrestation1 != null) && (!p_statutPrestation1.equals(m_statutPrestation1)))
    {
      m_statutPrestation1 = p_statutPrestation1;
      ((PbjcNcpPC)getPC()).setStatutPrestation1(p_statutPrestation1);
    }
  }
  
  protected String rawGetTypePopulation2()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation2();
  }
  
  public String getTypePopulation2()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation2();
  }
  
  public void setTypePopulation2(String p_typePopulation2)
  {
    if ((m_typePopulation2 == null) || (p_typePopulation2 == null))
    {
      m_typePopulation2 = p_typePopulation2;
      ((PbjcNcpPC)getPC()).setTypePopulation2(p_typePopulation2);
    }
    else if ((m_typePopulation2 != null) && (p_typePopulation2 != null) && (!p_typePopulation2.equals(m_typePopulation2)))
    {
      m_typePopulation2 = p_typePopulation2;
      ((PbjcNcpPC)getPC()).setTypePopulation2(p_typePopulation2);
    }
  }
  
  protected String rawGetSousTypePopulation2()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation2();
  }
  
  public String getSousTypePopulation2()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation2();
  }
  
  public void setSousTypePopulation2(String p_sousTypePopulation2)
  {
    if ((m_sousTypePopulation2 == null) || (p_sousTypePopulation2 == null))
    {
      m_sousTypePopulation2 = p_sousTypePopulation2;
      ((PbjcNcpPC)getPC()).setSousTypePopulation2(p_sousTypePopulation2);
    }
    else if ((m_sousTypePopulation2 != null) && (p_sousTypePopulation2 != null) && (!p_sousTypePopulation2.equals(m_sousTypePopulation2)))
    {
      m_sousTypePopulation2 = p_sousTypePopulation2;
      ((PbjcNcpPC)getPC()).setSousTypePopulation2(p_sousTypePopulation2);
    }
  }
  
  protected String rawGetStatutPrestation2()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation2();
  }
  
  public String getStatutPrestation2()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation2();
  }
  
  public void setStatutPrestation2(String p_statutPrestation2)
  {
    if ((m_statutPrestation2 == null) || (p_statutPrestation2 == null))
    {
      m_statutPrestation2 = p_statutPrestation2;
      ((PbjcNcpPC)getPC()).setStatutPrestation2(p_statutPrestation2);
    }
    else if ((m_statutPrestation2 != null) && (p_statutPrestation2 != null) && (!p_statutPrestation2.equals(m_statutPrestation2)))
    {
      m_statutPrestation2 = p_statutPrestation2;
      ((PbjcNcpPC)getPC()).setStatutPrestation2(p_statutPrestation2);
    }
  }
  
  protected String rawGetTypePopulation3()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation3();
  }
  
  public String getTypePopulation3()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation3();
  }
  
  public void setTypePopulation3(String p_typePopulation3)
  {
    if ((m_typePopulation3 == null) || (p_typePopulation3 == null))
    {
      m_typePopulation3 = p_typePopulation3;
      ((PbjcNcpPC)getPC()).setTypePopulation3(p_typePopulation3);
    }
    else if ((m_typePopulation3 != null) && (p_typePopulation3 != null) && (!p_typePopulation3.equals(m_typePopulation3)))
    {
      m_typePopulation3 = p_typePopulation3;
      ((PbjcNcpPC)getPC()).setTypePopulation3(p_typePopulation3);
    }
  }
  
  protected String rawGetSousTypePopulation3()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation3();
  }
  
  public String getSousTypePopulation3()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation3();
  }
  
  public void setSousTypePopulation3(String p_sousTypePopulation3)
  {
    if ((m_sousTypePopulation3 == null) || (p_sousTypePopulation3 == null))
    {
      m_sousTypePopulation3 = p_sousTypePopulation3;
      ((PbjcNcpPC)getPC()).setSousTypePopulation3(p_sousTypePopulation3);
    }
    else if ((m_sousTypePopulation3 != null) && (p_sousTypePopulation3 != null) && (!p_sousTypePopulation3.equals(m_sousTypePopulation3)))
    {
      m_sousTypePopulation3 = p_sousTypePopulation3;
      ((PbjcNcpPC)getPC()).setSousTypePopulation3(p_sousTypePopulation3);
    }
  }
  
  protected String rawGetStatutPrestation3()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation3();
  }
  
  public String getStatutPrestation3()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation3();
  }
  
  public void setStatutPrestation3(String p_statutPrestation3)
  {
    if ((m_statutPrestation3 == null) || (p_statutPrestation3 == null))
    {
      m_statutPrestation3 = p_statutPrestation3;
      ((PbjcNcpPC)getPC()).setStatutPrestation3(p_statutPrestation3);
    }
    else if ((m_statutPrestation3 != null) && (p_statutPrestation3 != null) && (!p_statutPrestation3.equals(m_statutPrestation3)))
    {
      m_statutPrestation3 = p_statutPrestation3;
      ((PbjcNcpPC)getPC()).setStatutPrestation3(p_statutPrestation3);
    }
  }
  
  protected String rawGetTypePopulation4()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation4();
  }
  
  public String getTypePopulation4()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation4();
  }
  
  public void setTypePopulation4(String p_typePopulation4)
  {
    if ((m_typePopulation4 == null) || (p_typePopulation4 == null))
    {
      m_typePopulation4 = p_typePopulation4;
      ((PbjcNcpPC)getPC()).setTypePopulation4(p_typePopulation4);
    }
    else if ((m_typePopulation4 != null) && (p_typePopulation4 != null) && (!p_typePopulation4.equals(m_typePopulation4)))
    {
      m_typePopulation4 = p_typePopulation4;
      ((PbjcNcpPC)getPC()).setTypePopulation4(p_typePopulation4);
    }
  }
  
  protected String rawGetSousTypePopulation4()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation4();
  }
  
  public String getSousTypePopulation4()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation4();
  }
  
  public void setSousTypePopulation4(String p_sousTypePopulation4)
  {
    if ((m_sousTypePopulation4 == null) || (p_sousTypePopulation4 == null))
    {
      m_sousTypePopulation4 = p_sousTypePopulation4;
      ((PbjcNcpPC)getPC()).setSousTypePopulation4(p_sousTypePopulation4);
    }
    else if ((m_sousTypePopulation4 != null) && (p_sousTypePopulation4 != null) && (!p_sousTypePopulation4.equals(m_sousTypePopulation4)))
    {
      m_sousTypePopulation4 = p_sousTypePopulation4;
      ((PbjcNcpPC)getPC()).setSousTypePopulation4(p_sousTypePopulation4);
    }
  }
  
  protected String rawGetStatutPrestation4()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation4();
  }
  
  public String getStatutPrestation4()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation4();
  }
  
  public void setStatutPrestation4(String p_statutPrestation4)
  {
    if ((m_statutPrestation4 == null) || (p_statutPrestation4 == null))
    {
      m_statutPrestation4 = p_statutPrestation4;
      ((PbjcNcpPC)getPC()).setStatutPrestation4(p_statutPrestation4);
    }
    else if ((m_statutPrestation4 != null) && (p_statutPrestation4 != null) && (!p_statutPrestation4.equals(m_statutPrestation4)))
    {
      m_statutPrestation4 = p_statutPrestation4;
      ((PbjcNcpPC)getPC()).setStatutPrestation4(p_statutPrestation4);
    }
  }
  
  protected String rawGetTypePopulation5()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation5();
  }
  
  public String getTypePopulation5()
  {
    return ((PbjcNcpPC)getPC()).getTypePopulation5();
  }
  
  public void setTypePopulation5(String p_typePopulation5)
  {
    if ((m_typePopulation5 == null) || (p_typePopulation5 == null))
    {
      m_typePopulation5 = p_typePopulation5;
      ((PbjcNcpPC)getPC()).setTypePopulation5(p_typePopulation5);
    }
    else if ((m_typePopulation5 != null) && (p_typePopulation5 != null) && (!p_typePopulation5.equals(m_typePopulation5)))
    {
      m_typePopulation5 = p_typePopulation5;
      ((PbjcNcpPC)getPC()).setTypePopulation5(p_typePopulation5);
    }
  }
  
  protected String rawGetSousTypePopulation5()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation5();
  }
  
  public String getSousTypePopulation5()
  {
    return ((PbjcNcpPC)getPC()).getSousTypePopulation5();
  }
  
  public void setSousTypePopulation5(String p_sousTypePopulation5)
  {
    if ((m_sousTypePopulation5 == null) || (p_sousTypePopulation5 == null))
    {
      m_sousTypePopulation5 = p_sousTypePopulation5;
      ((PbjcNcpPC)getPC()).setSousTypePopulation5(p_sousTypePopulation5);
    }
    else if ((m_sousTypePopulation5 != null) && (p_sousTypePopulation5 != null) && (!p_sousTypePopulation5.equals(m_sousTypePopulation5)))
    {
      m_sousTypePopulation5 = p_sousTypePopulation5;
      ((PbjcNcpPC)getPC()).setSousTypePopulation5(p_sousTypePopulation5);
    }
  }
  
  protected String rawGetStatutPrestation5()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation5();
  }
  
  public String getStatutPrestation5()
  {
    return ((PbjcNcpPC)getPC()).getStatutPrestation5();
  }
  
  public void setStatutPrestation5(String p_statutPrestation5)
  {
    if ((m_statutPrestation5 == null) || (p_statutPrestation5 == null))
    {
      m_statutPrestation5 = p_statutPrestation5;
      ((PbjcNcpPC)getPC()).setStatutPrestation5(p_statutPrestation5);
    }
    else if ((m_statutPrestation5 != null) && (p_statutPrestation5 != null) && (!p_statutPrestation5.equals(m_statutPrestation5)))
    {
      m_statutPrestation5 = p_statutPrestation5;
      ((PbjcNcpPC)getPC()).setStatutPrestation5(p_statutPrestation5);
    }
  }
  
  protected boolean rawIsPresencePnds()
  {
    return ((PbjcNcpPC)getPC()).isPresencePnds();
  }
  
  public boolean isPresencePnds()
  {
    return ((PbjcNcpPC)getPC()).isPresencePnds();
  }
  
  public void setPresencePnds(boolean p_presencePnds)
  {
    ((PbjcNcpPC)getPC()).setPresencePnds(p_presencePnds);
  }
  
  protected BigDecimal rawGetMontantContMensuelEmploiRepris()
  {
    return ((PbjcNcpPC)getPC()).getMontantContMensuelEmploiRepris();
  }
  
  public BigDecimal getMontantContMensuelEmploiRepris()
  {
    return ((PbjcNcpPC)getPC()).getMontantContMensuelEmploiRepris();
  }
  
  public void setMontantContMensuelEmploiRepris(BigDecimal p_montantContMensuelEmploiRepris)
  {
    if ((m_montantContMensuelEmploiRepris == null) || (p_montantContMensuelEmploiRepris == null))
    {
      m_montantContMensuelEmploiRepris = p_montantContMensuelEmploiRepris;
      ((PbjcNcpPC)getPC()).setMontantContMensuelEmploiRepris(p_montantContMensuelEmploiRepris);
    }
    else if ((m_montantContMensuelEmploiRepris != null) && (p_montantContMensuelEmploiRepris != null) && (!p_montantContMensuelEmploiRepris.equals(m_montantContMensuelEmploiRepris)))
    {
      m_montantContMensuelEmploiRepris = p_montantContMensuelEmploiRepris;
      ((PbjcNcpPC)getPC()).setMontantContMensuelEmploiRepris(p_montantContMensuelEmploiRepris);
    }
  }
  
  protected BigDecimal rawGetExcedentsRemunerationMois()
  {
    return ((PbjcNcpPC)getPC()).getExcedentsRemunerationMois();
  }
  
  public BigDecimal getExcedentsRemunerationMois()
  {
    return ((PbjcNcpPC)getPC()).getExcedentsRemunerationMois();
  }
  
  public void setExcedentsRemunerationMois(BigDecimal p_excedentsRemunerationMois)
  {
    if ((m_excedentsRemunerationMois == null) || (p_excedentsRemunerationMois == null))
    {
      m_excedentsRemunerationMois = p_excedentsRemunerationMois;
      ((PbjcNcpPC)getPC()).setExcedentsRemunerationMois(p_excedentsRemunerationMois);
    }
    else if ((m_excedentsRemunerationMois != null) && (p_excedentsRemunerationMois != null) && (!p_excedentsRemunerationMois.equals(m_excedentsRemunerationMois)))
    {
      m_excedentsRemunerationMois = p_excedentsRemunerationMois;
      ((PbjcNcpPC)getPC()).setExcedentsRemunerationMois(p_excedentsRemunerationMois);
    }
  }
  
  protected int rawGetReliquatAllongementAREF()
  {
    return ((PbjcNcpPC)getPC()).getReliquatAllongementAREF();
  }
  
  public int getReliquatAllongementAREF()
  {
    return ((PbjcNcpPC)getPC()).getReliquatAllongementAREF();
  }
  
  public void setReliquatAllongementAREF(int p_reliquatAllongementAREF)
  {
    ((PbjcNcpPC)getPC()).setReliquatAllongementAREF(p_reliquatAllongementAREF);
  }
  
  protected int rawGetCumulAllongementPlan()
  {
    return ((PbjcNcpPC)getPC()).getCumulAllongementPlan();
  }
  
  public int getCumulAllongementPlan()
  {
    return ((PbjcNcpPC)getPC()).getCumulAllongementPlan();
  }
  
  public void setCumulAllongementPlan(int p_cumulAllongementPlan)
  {
    ((PbjcNcpPC)getPC()).setCumulAllongementPlan(p_cumulAllongementPlan);
  }
  
  protected int rawGetNbJoursAllongementAREF()
  {
    return ((PbjcNcpPC)getPC()).getNbJoursAllongementAREF();
  }
  
  public int getNbJoursAllongementAREF()
  {
    return ((PbjcNcpPC)getPC()).getNbJoursAllongementAREF();
  }
  
  public void setNbJoursAllongementAREF(int p_nbJoursAllongementAREF)
  {
    ((PbjcNcpPC)getPC()).setNbJoursAllongementAREF(p_nbJoursAllongementAREF);
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     PbjcNcpGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
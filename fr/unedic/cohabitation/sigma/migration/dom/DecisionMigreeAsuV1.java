package fr.unedic.cohabitation.sigma.migration.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import org.apache.commons.lang.builder.EqualsBuilder;

public class DecisionMigreeAsuV1
  extends DecisionMigreeV1
{
  private String m_article3;
  private String m_reglementApplicable;
  private String m_idPeriodeFgd;
  private BigDecimal m_codeRejet;
  private BigDecimal m_montantBrut;
  private BigDecimal m_qteAffiliation1;
  private String m_uniteAffiliation1;
  private BigDecimal m_qteAffiliation2;
  private String m_uniteAffiliation2;
  private String m_idPeriodeValidation;
  private BigDecimal m_dureeRenouvellement;
  private BigDecimal m_capitalOdPrecedente;
  private BigDecimal m_capitalOdCourante;
  private BigDecimal m_capitalPrecedentSP;
  private BigDecimal m_competenceAdministrative;
  private BigDecimal m_competenceFinanciere;
  private String m_typeCaractereSaisonnier;
  private boolean m_estApprenti;
  private BigDecimal m_cumulMoisActiviteReduite;
  private String m_numeroConventionGestionEmployeur;
  private BigDecimal m_nbJoursActiviteCourrierAss;
  private BigDecimal m_dureeTheoriqueDroitCourant;
  private BigDecimal m_dureeEffectiveDroitCourant;
  private Damj m_dateDebutPrcSjrInitialDroitCourant;
  private Damj m_dateFinPrcSjrInitialDroitCourant;
  private BigDecimal m_montantSjrInitialDroitCourant;
  private BigDecimal m_diviseurSjrInitialCourant;
  private BigDecimal m_montantSjrrpDroitCourant;
  private BigDecimal m_montantSjcInitialDroitCourant;
  private Damj m_dateSjcInitialDroitCourant;
  private BigDecimal m_coefCaractereSaisonnierDroitCourant;
  private BigDecimal m_coefTempsPartielDroitCourant;
  private BigDecimal m_dureeTheoriqueDroitRetenu;
  private BigDecimal m_dureeEffectiveDroitRetenu;
  private Damj m_dateFinPrcSjrInitialDroitRetenu;
  private BigDecimal m_montantSjrInitialDroitRetenu;
  private BigDecimal m_montantBrutDroitPrecedent;
  private boolean m_montantRetenuEstLePrecedent;
  private boolean m_capitalRetenuEstLePrecendent;
  private Damj m_debutCarenceICCP;
  private Damj m_finCarenceICCP;
  private BigDecimal m_nbJoursCarenceICCP;
  private Damj m_debutCarenceISLR;
  private Damj m_finCarenceISLR;
  private BigDecimal m_nbJoursCarenceISLR;
  private BigDecimal m_montantIslr;
  private Damj m_debutCarencePMC;
  private Damj m_finCarencePMC;
  private BigDecimal m_nbJoursCarencePMC;
  private Damj m_debutDiffere;
  private Damj m_finDiffere;
  private BigDecimal m_nbJoursDiffere;
  private Damj m_dateFgd;
  private Damj m_dateValidationProduit;
  private BigDecimal m_dureeEffectiveDroitPrecedent;
  private Damj m_dateFinPrcSjrInitialDroitPrecedent;
  private BigDecimal m_montantSjrInitialDroitPrecedent;
  private BigDecimal m_coefCaractereSaisonnierDroitPrecedent;
  private BigDecimal m_coefTempsPartielDroitPrecedent;
  private BigDecimal m_capitalOdRetenu;
  private BigDecimal m_montantBrutRetenu;
  private BigDecimal m_coefCaractereSaisonnierDroitRetenu;
  private BigDecimal m_coefTempsPartielDroitRetenu;
  private int m_rangAllongement;
  private BigDecimal m_montantSRInitial;
  private BigDecimal m_montantSRInitialPlafonne;
  private Damj m_dateDebutDiffereStandard;
  private Damj m_dateFinDiffereStandard;
  private BigDecimal m_nbJoursDiffereStandard;
  private BigDecimal m_montantSRDiffereStandard;
  private BigDecimal m_nbHeuresTravailleesEtendu;
  private BigDecimal m_nbHeuresTravailleesPlafonne;
  private BigDecimal m_montantSalaireJournalierMoyenInitial;
  private Chronologie m_chronologiePeriodesFCT;
  private boolean m_afficherPeriodesFCT;
  
  public String getArticle3()
  {
    return m_article3;
  }
  
  public void setArticle3(String p_article3)
  {
    m_article3 = p_article3;
  }
  
  public int getTypeCaractereSaisonnier()
  {
    if (m_typeCaractereSaisonnier != null) {
      return Integer.parseInt(m_typeCaractereSaisonnier);
    }
    return -1;
  }
  
  public void setTypeCaractereSaisonnier(String p_typeCaractereSaisonnier)
  {
    m_typeCaractereSaisonnier = p_typeCaractereSaisonnier;
  }
  
  public Damj getDebutCarenceICCP()
  {
    return m_debutCarenceICCP;
  }
  
  public void setDebutCarenceICCP(Damj p_debutCarenceICCP)
  {
    m_debutCarenceICCP = p_debutCarenceICCP;
  }
  
  public Damj getDebutCarenceISLR()
  {
    return m_debutCarenceISLR;
  }
  
  public Damj getFinCarenceICCP()
  {
    return m_finCarenceICCP;
  }
  
  public void setFinCarenceICCP(Damj p_finCarenceICCP)
  {
    m_finCarenceICCP = p_finCarenceICCP;
  }
  
  public int getNbJoursCarenceICCP()
  {
    if (m_nbJoursCarenceICCP != null) {
      return m_nbJoursCarenceICCP.intValue();
    }
    return -1;
  }
  
  public void setNbJoursCarenceICCP(BigDecimal p_nbJoursCarenceICCP)
  {
    m_nbJoursCarenceICCP = p_nbJoursCarenceICCP;
  }
  
  public void setDebutCarenceISLR(Damj p_debutCarenceISLR)
  {
    m_debutCarenceISLR = p_debutCarenceISLR;
  }
  
  public Damj getFinCarenceISLR()
  {
    return m_finCarenceISLR;
  }
  
  public void setFinCarenceISLR(Damj p_finCarenceISLR)
  {
    m_finCarenceISLR = p_finCarenceISLR;
  }
  
  public int getNbJoursCarenceISLR()
  {
    if (m_nbJoursCarenceISLR != null) {
      return m_nbJoursCarenceISLR.intValue();
    }
    return -1;
  }
  
  public void setNbJoursCarenceISLR(BigDecimal p_nbJoursCarenceISLR)
  {
    m_nbJoursCarenceISLR = p_nbJoursCarenceISLR;
  }
  
  public Damj getDebutCarencePMC()
  {
    return m_debutCarencePMC;
  }
  
  public void setDebutCarencePMC(Damj p_debutCarencePMC)
  {
    m_debutCarencePMC = p_debutCarencePMC;
  }
  
  public Damj getFinCarencePMC()
  {
    return m_finCarencePMC;
  }
  
  public void setFinCarencePMC(Damj p_finCarencePMC)
  {
    m_finCarencePMC = p_finCarencePMC;
  }
  
  public int getNbJoursCarencePMC()
  {
    if (m_nbJoursCarencePMC != null) {
      return m_nbJoursCarencePMC.intValue();
    }
    return -1;
  }
  
  public void setNbJoursCarencePMC(BigDecimal p_nbJoursCarencePMC)
  {
    m_nbJoursCarencePMC = p_nbJoursCarencePMC;
  }
  
  public Damj getDebutDiffere()
  {
    return m_debutDiffere;
  }
  
  public void setDebutDiffere(Damj p_debutDiffere)
  {
    m_debutDiffere = p_debutDiffere;
  }
  
  public Damj getFinDiffere()
  {
    return m_finDiffere;
  }
  
  public void setFinDiffere(Damj p_finDiffere)
  {
    m_finDiffere = p_finDiffere;
  }
  
  public int getNbJoursDiffere()
  {
    if (m_nbJoursDiffere != null) {
      return m_nbJoursDiffere.intValue();
    }
    return -1;
  }
  
  public void setNbJoursDiffere(BigDecimal p_nbJoursDiffere)
  {
    m_nbJoursDiffere = p_nbJoursDiffere;
  }
  
  public String getReglementApplicable()
  {
    return m_reglementApplicable;
  }
  
  public void setReglementApplicable(String p_reglementApplicable)
  {
    m_reglementApplicable = p_reglementApplicable;
  }
  
  public int getCodeRejet()
  {
    if (m_codeRejet != null) {
      return m_codeRejet.intValue();
    }
    return -1;
  }
  
  public void setCodeRejet(BigDecimal p_codeRejet)
  {
    m_codeRejet = p_codeRejet;
  }
  
  public boolean isEstApprenti()
  {
    return m_estApprenti;
  }
  
  public void setEstApprenti(boolean p_estApprenti)
  {
    m_estApprenti = p_estApprenti;
  }
  
  public QuantiteEuro getCapitalOdCourante()
  {
    if (m_capitalOdCourante != null) {
      return new QuantiteEuro(m_capitalOdCourante);
    }
    return null;
  }
  
  public void setCapitalOdCourante(BigDecimal p_capitalOdCourante)
  {
    m_capitalOdCourante = p_capitalOdCourante;
  }
  
  public QuantiteEuro getCapitalOdPrecedente()
  {
    if (m_capitalOdPrecedente != null) {
      return new QuantiteEuro(m_capitalOdPrecedente);
    }
    return null;
  }
  
  public void setCapitalOdPrecedente(BigDecimal p_capitalOdPrecedente)
  {
    m_capitalOdPrecedente = p_capitalOdPrecedente;
  }
  
  public QuantiteEuro getCapitalPrecedentSP()
  {
    if (m_capitalPrecedentSP != null) {
      return new QuantiteEuro(m_capitalPrecedentSP);
    }
    return null;
  }
  
  public void setCapitalPrecedentSP(BigDecimal p_capitalPrecedentSP)
  {
    m_capitalPrecedentSP = p_capitalPrecedentSP;
  }
  
  public BigDecimal getCoefCaractereSaisonnierDroitCourant()
  {
    return m_coefCaractereSaisonnierDroitCourant;
  }
  
  public void setCoefCaractereSaisonnierDroitCourant(BigDecimal p_coefCaractereSaisonnierDroitCourant)
  {
    m_coefCaractereSaisonnierDroitCourant = p_coefCaractereSaisonnierDroitCourant;
  }
  
  public BigDecimal getCoefTempsPartielDroitCourant()
  {
    return m_coefTempsPartielDroitCourant;
  }
  
  public void setCoefTempsPartielDroitCourant(BigDecimal p_coefTempsPartielDroitCourant)
  {
    m_coefTempsPartielDroitCourant = p_coefTempsPartielDroitCourant;
  }
  
  public BigDecimal getCompetenceAdministrative()
  {
    return m_competenceAdministrative;
  }
  
  public void setCompetenceAdministrative(BigDecimal p_competenceAdministrative)
  {
    m_competenceAdministrative = p_competenceAdministrative;
  }
  
  public BigDecimal getCompetenceFinanciere()
  {
    return m_competenceFinanciere;
  }
  
  public void setCompetenceFinanciere(BigDecimal p_competenceFinanciere)
  {
    m_competenceFinanciere = p_competenceFinanciere;
  }
  
  public BigDecimal getCumulMoisActiviteReduite()
  {
    return m_cumulMoisActiviteReduite;
  }
  
  public void setCumulMoisActiviteReduite(BigDecimal p_cumulMoisActiviteReduite)
  {
    m_cumulMoisActiviteReduite = p_cumulMoisActiviteReduite;
  }
  
  public Damj getDateDebutPrcSjrInitialDroitCourant()
  {
    return m_dateDebutPrcSjrInitialDroitCourant;
  }
  
  public void setDateDebutPrcSjrInitialDroitCourant(Damj p_dateDebutPrcSjrInitialDroitCourant)
  {
    m_dateDebutPrcSjrInitialDroitCourant = p_dateDebutPrcSjrInitialDroitCourant;
  }
  
  public Damj getDateFinPrcSjrInitialDroitCourant()
  {
    return m_dateFinPrcSjrInitialDroitCourant;
  }
  
  public void setDateFinPrcSjrInitialDroitCourant(Damj p_dateFinPrcSjrInitialDroitCourant)
  {
    m_dateFinPrcSjrInitialDroitCourant = p_dateFinPrcSjrInitialDroitCourant;
  }
  
  public Damj getDateFinPrcSjrInitialDroitRetenu()
  {
    return m_dateFinPrcSjrInitialDroitRetenu;
  }
  
  public void setDateFinPrcSjrInitialDroitRetenu(Damj p_dateFinPrcSjrInitialDroitRetenu)
  {
    m_dateFinPrcSjrInitialDroitRetenu = p_dateFinPrcSjrInitialDroitRetenu;
  }
  
  public Damj getDateSjcInitialDroitCourant()
  {
    return m_dateSjcInitialDroitCourant;
  }
  
  public void setDateSjcInitialDroitCourant(Damj p_dateSjcInitialDroitCourant)
  {
    m_dateSjcInitialDroitCourant = p_dateSjcInitialDroitCourant;
  }
  
  public BigDecimal getDiviseurSjrInitialCourant()
  {
    return m_diviseurSjrInitialCourant;
  }
  
  public void setDiviseurSjrInitialCourant(BigDecimal p_diviseurSjrInitialCourant)
  {
    m_diviseurSjrInitialCourant = p_diviseurSjrInitialCourant;
  }
  
  public Quantite getDureeEffectiveDroitCourant()
  {
    if (m_dureeEffectiveDroitCourant != null) {
      return new QuantiteJour(m_dureeEffectiveDroitCourant);
    }
    return null;
  }
  
  public void setDureeEffectiveDroitCourant(BigDecimal p_dureeEffectiveDroitCourant)
  {
    m_dureeEffectiveDroitCourant = p_dureeEffectiveDroitCourant;
  }
  
  public Quantite getDureeEffectiveDroitRetenu()
  {
    if (m_dureeEffectiveDroitRetenu != null) {
      return new QuantiteJour(m_dureeEffectiveDroitRetenu);
    }
    return null;
  }
  
  public void setDureeEffectiveDroitRetenu(BigDecimal p_dureeEffectiveDroitRetenu)
  {
    m_dureeEffectiveDroitRetenu = p_dureeEffectiveDroitRetenu;
  }
  
  public Quantite getDureeRenouvellement()
  {
    if (m_dureeRenouvellement != null) {
      return new QuantiteJour(m_dureeRenouvellement);
    }
    return null;
  }
  
  public void setDureeRenouvellement(BigDecimal p_dureeRenouvellement)
  {
    m_dureeRenouvellement = p_dureeRenouvellement;
  }
  
  public Quantite getDureeTheoriqueDroitCourant()
  {
    if (m_dureeTheoriqueDroitCourant != null) {
      return new QuantiteJour(m_dureeTheoriqueDroitCourant);
    }
    return null;
  }
  
  public void setDureeTheoriqueDroitCourant(BigDecimal p_dureeTheoriqueDroitCourant)
  {
    m_dureeTheoriqueDroitCourant = p_dureeTheoriqueDroitCourant;
  }
  
  public Quantite getDureeTheoriqueDroitRetenu()
  {
    if (m_dureeTheoriqueDroitRetenu != null) {
      return new QuantiteJour(m_dureeTheoriqueDroitRetenu);
    }
    return null;
  }
  
  public void setDureeTheoriqueDroitRetenu(BigDecimal p_dureeTheoriqueDroitRetenu)
  {
    m_dureeTheoriqueDroitRetenu = p_dureeTheoriqueDroitRetenu;
  }
  
  public String getIdPeriodeFgd()
  {
    return m_idPeriodeFgd;
  }
  
  public void setIdPeriodeFgd(String p_idPeriodeFgd)
  {
    m_idPeriodeFgd = p_idPeriodeFgd;
  }
  
  public String getIdPeriodeValidation()
  {
    return m_idPeriodeValidation;
  }
  
  public void setIdPeriodeValidation(String p_idPeriodeValidation)
  {
    m_idPeriodeValidation = p_idPeriodeValidation;
  }
  
  public QuantiteEuro getMontantBrut()
  {
    if (m_montantBrut != null) {
      return new QuantiteEuro(m_montantBrut);
    }
    return null;
  }
  
  public void setMontantBrut(BigDecimal p_montantBrut)
  {
    m_montantBrut = p_montantBrut;
  }
  
  public QuantiteEuro getMontantIslr()
  {
    if (m_montantIslr != null) {
      return new QuantiteEuro(m_montantIslr);
    }
    return null;
  }
  
  public void setMontantIslr(BigDecimal p_montantIslr)
  {
    m_montantIslr = p_montantIslr;
  }
  
  public QuantiteEuro getMontantSjcInitialDroitCourant()
  {
    if (m_montantSjcInitialDroitCourant != null) {
      return new QuantiteEuro(m_montantSjcInitialDroitCourant);
    }
    return null;
  }
  
  public void setMontantSjcInitialDroitCourant(BigDecimal p_montantSjcInitialDroitCourant)
  {
    m_montantSjcInitialDroitCourant = p_montantSjcInitialDroitCourant;
  }
  
  public QuantiteEuro getMontantSjrInitialDroitCourant()
  {
    if (m_montantSjrInitialDroitCourant != null) {
      return new QuantiteEuro(m_montantSjrInitialDroitCourant);
    }
    return null;
  }
  
  public void setMontantSjrInitialDroitCourant(BigDecimal p_montantSjrInitialDroitCourant)
  {
    m_montantSjrInitialDroitCourant = p_montantSjrInitialDroitCourant;
  }
  
  public QuantiteEuro getMontantSjrInitialDroitRetenu()
  {
    if (m_montantSjrInitialDroitRetenu != null) {
      return new QuantiteEuro(m_montantSjrInitialDroitRetenu);
    }
    return null;
  }
  
  public void setMontantSjrInitialDroitRetenu(BigDecimal p_montantSjrInitialDroitRetenu)
  {
    m_montantSjrInitialDroitRetenu = p_montantSjrInitialDroitRetenu;
  }
  
  public BigDecimal getMontantSjrrpDroitCourant()
  {
    return m_montantSjrrpDroitCourant;
  }
  
  public void setMontantSjrrpDroitCourant(BigDecimal p_montantSjrrpDroitCourant)
  {
    m_montantSjrrpDroitCourant = p_montantSjrrpDroitCourant;
  }
  
  public String getNumeroConventionGestionEmployeur()
  {
    return m_numeroConventionGestionEmployeur;
  }
  
  public void setNumeroConventionGestionEmployeur(String p_numeroConventionGestionEmployeur)
  {
    m_numeroConventionGestionEmployeur = p_numeroConventionGestionEmployeur;
  }
  
  public BigDecimal getQteAffiliation1()
  {
    return m_qteAffiliation1;
  }
  
  public void setQteAffiliation1(BigDecimal p_qteAffiliation1)
  {
    m_qteAffiliation1 = p_qteAffiliation1;
  }
  
  public BigDecimal getQteAffiliation2()
  {
    return m_qteAffiliation2;
  }
  
  public void setQteAffiliation2(BigDecimal p_qteAffiliation2)
  {
    m_qteAffiliation2 = p_qteAffiliation2;
  }
  
  public String getUniteAffiliation1()
  {
    return m_uniteAffiliation1;
  }
  
  public void setUniteAffiliation1(String p_uniteAffiliation1)
  {
    m_uniteAffiliation1 = p_uniteAffiliation1;
  }
  
  public String getUniteAffiliation2()
  {
    return m_uniteAffiliation2;
  }
  
  public void setUniteAffiliation2(String p_uniteAffiliation2)
  {
    m_uniteAffiliation2 = p_uniteAffiliation2;
  }
  
  public Damj getDateFgd()
  {
    return m_dateFgd;
  }
  
  public void setDateFgd(Damj p_dateFgd)
  {
    m_dateFgd = p_dateFgd;
  }
  
  public Damj getDateValidationProduit()
  {
    return m_dateValidationProduit;
  }
  
  public void setDateValidationProduit(Damj p_dateValidationProduit)
  {
    m_dateValidationProduit = p_dateValidationProduit;
  }
  
  public boolean isCapitalRetenuEstLePrecendent()
  {
    return m_capitalRetenuEstLePrecendent;
  }
  
  public void setCapitalRetenuEstLePrecendent(boolean p_capitalRetenuEstLePrecendent)
  {
    m_capitalRetenuEstLePrecendent = p_capitalRetenuEstLePrecendent;
  }
  
  public QuantiteEuro getMontantBrutDroitPrecedent()
  {
    if (m_montantBrutDroitPrecedent != null) {
      return new QuantiteEuro(m_montantBrutDroitPrecedent);
    }
    return null;
  }
  
  public void setMontantBrutDroitPrecedent(BigDecimal p_montantBrutDroitPrecedent)
  {
    m_montantBrutDroitPrecedent = p_montantBrutDroitPrecedent;
  }
  
  public boolean isMontantRetenuEstLePrecedent()
  {
    return m_montantRetenuEstLePrecedent;
  }
  
  public void setMontantRetenuEstLePrecedent(boolean p_montantRetenuEstLePrecedent)
  {
    m_montantRetenuEstLePrecedent = p_montantRetenuEstLePrecedent;
  }
  
  public QuantiteEuro getCapitalOdRetenu()
  {
    if (m_capitalOdRetenu != null) {
      return new QuantiteEuro(m_capitalOdRetenu);
    }
    return null;
  }
  
  public void setCapitalOdRetenu(BigDecimal p_capitalOdRetenu)
  {
    m_capitalOdRetenu = p_capitalOdRetenu;
  }
  
  public BigDecimal getCoefCaractereSaisonnierDroitPrecedent()
  {
    return m_coefCaractereSaisonnierDroitPrecedent;
  }
  
  public void setCoefCaractereSaisonnierDroitPrecedent(BigDecimal p_coefCaractereSaisonnierDroitPrecedent)
  {
    m_coefCaractereSaisonnierDroitPrecedent = p_coefCaractereSaisonnierDroitPrecedent;
  }
  
  public BigDecimal getCoefCaractereSaisonnierDroitRetenu()
  {
    return m_coefCaractereSaisonnierDroitRetenu;
  }
  
  public void setCoefCaractereSaisonnierDroitRetenu(BigDecimal p_coefCaractereSaisonnierDroitRetenu)
  {
    m_coefCaractereSaisonnierDroitRetenu = p_coefCaractereSaisonnierDroitRetenu;
  }
  
  public BigDecimal getCoefTempsPartielDroitPrecedent()
  {
    return m_coefTempsPartielDroitPrecedent;
  }
  
  public void setCoefTempsPartielDroitPrecedent(BigDecimal p_coefTempsPartielDroitPrecedent)
  {
    m_coefTempsPartielDroitPrecedent = p_coefTempsPartielDroitPrecedent;
  }
  
  public BigDecimal getCoefTempsPartielDroitRetenu()
  {
    return m_coefTempsPartielDroitRetenu;
  }
  
  public void setCoefTempsPartielDroitRetenu(BigDecimal p_coefTempsPartielDroitRetenu)
  {
    m_coefTempsPartielDroitRetenu = p_coefTempsPartielDroitRetenu;
  }
  
  public Damj getDateFinPrcSjrInitialDroitPrecedent()
  {
    return m_dateFinPrcSjrInitialDroitPrecedent;
  }
  
  public void setDateFinPrcSjrInitialDroitPrecedent(Damj p_dateFinPrcSjrInitialDroitPrecedent)
  {
    m_dateFinPrcSjrInitialDroitPrecedent = p_dateFinPrcSjrInitialDroitPrecedent;
  }
  
  public BigDecimal getDureeEffectiveDroitPrecedent()
  {
    return m_dureeEffectiveDroitPrecedent;
  }
  
  public void setDureeEffectiveDroitPrecedent(BigDecimal p_dureeEffectiveDroitPrecedent)
  {
    m_dureeEffectiveDroitPrecedent = p_dureeEffectiveDroitPrecedent;
  }
  
  public QuantiteEuro getMontantBrutRetenu()
  {
    if (m_montantBrutRetenu != null) {
      return new QuantiteEuro(m_montantBrutRetenu);
    }
    return null;
  }
  
  public void setMontantBrutRetenu(BigDecimal p_montantBrutRetenu)
  {
    m_montantBrutRetenu = p_montantBrutRetenu;
  }
  
  public QuantiteEuro getMontantSjrInitialDroitPrecedent()
  {
    if (m_montantSjrInitialDroitPrecedent != null) {
      return new QuantiteEuro(m_montantSjrInitialDroitPrecedent);
    }
    return null;
  }
  
  public void setMontantSjrInitialDroitPrecedent(BigDecimal p_montantSjrInitialDroitPrecedent)
  {
    m_montantSjrInitialDroitPrecedent = p_montantSjrInitialDroitPrecedent;
  }
  
  public int getNbJoursActiviteCourrierAss()
  {
    if (m_nbJoursActiviteCourrierAss != null) {
      return m_nbJoursActiviteCourrierAss.intValue();
    }
    return -1;
  }
  
  public void setNbJoursActiviteCourrierAss(BigDecimal p_nbJoursActiviteCourrierAss)
  {
    m_nbJoursActiviteCourrierAss = p_nbJoursActiviteCourrierAss;
  }
  
  public boolean equals(Object p_arg0)
  {
    boolean isEqual = false;
    if ((p_arg0 instanceof DecisionMigreeAsuV1))
    {
      DecisionMigreeAsuV1 decisionV1 = (DecisionMigreeAsuV1)p_arg0;
      EqualsBuilder eqb1 = new EqualsBuilder();
      eqb1.append(getArticle3(), decisionV1.getArticle3()).append(getReglementApplicable(), decisionV1.getReglementApplicable()).append(getIdPeriodeFgd(), decisionV1.getIdPeriodeFgd()).append(getCodeRejet(), decisionV1.getCodeRejet()).append(getMontantBrut(), decisionV1.getMontantBrut()).append(getQteAffiliation1(), decisionV1.getQteAffiliation1()).append(getUniteAffiliation1(), decisionV1.getUniteAffiliation1()).append(getQteAffiliation2(), decisionV1.getQteAffiliation2()).append(getUniteAffiliation2(), decisionV1.getUniteAffiliation2());
      
      EqualsBuilder eqb2 = new EqualsBuilder();
      eqb2.append(getIdPeriodeValidation(), decisionV1.getIdPeriodeValidation()).append(getDureeRenouvellement(), decisionV1.getDureeRenouvellement()).append(getCapitalOdPrecedente(), decisionV1.getCapitalOdPrecedente()).append(getCapitalOdCourante(), decisionV1.getCapitalOdCourante()).append(getCapitalPrecedentSP(), decisionV1.getCapitalPrecedentSP());
      
      EqualsBuilder eqb3 = new EqualsBuilder();
      eqb3.append(getCompetenceAdministrative(), decisionV1.getCompetenceAdministrative()).append(getCompetenceFinanciere(), decisionV1.getCompetenceFinanciere()).append(getTypeCaractereSaisonnier(), decisionV1.getTypeCaractereSaisonnier()).append(isEstApprenti(), decisionV1.isEstApprenti()).append(getCumulMoisActiviteReduite(), decisionV1.getCumulMoisActiviteReduite()).append(getNumeroConventionGestionEmployeur(), decisionV1.getNumeroConventionGestionEmployeur());
      
      EqualsBuilder eqb4 = new EqualsBuilder();
      eqb4.append(getDureeTheoriqueDroitCourant(), decisionV1.getDureeTheoriqueDroitCourant()).append(getDureeEffectiveDroitCourant(), decisionV1.getDureeEffectiveDroitCourant()).append(getDateDebutPrcSjrInitialDroitCourant(), decisionV1.getDateDebutPrcSjrInitialDroitCourant()).append(getDateFinPrcSjrInitialDroitCourant(), decisionV1.getDateFinPrcSjrInitialDroitCourant()).append(getMontantSjrInitialDroitCourant(), decisionV1.getMontantSjrInitialDroitCourant()).append(getDiviseurSjrInitialCourant(), decisionV1.getDiviseurSjrInitialCourant()).append(getMontantSjrrpDroitCourant(), decisionV1.getMontantSjrrpDroitCourant()).append(getDateSjcInitialDroitCourant(), decisionV1.getDateSjcInitialDroitCourant()).append(getCoefCaractereSaisonnierDroitCourant(), decisionV1.getCoefCaractereSaisonnierDroitCourant()).append(getCoefTempsPartielDroitCourant(), decisionV1.getCoefTempsPartielDroitCourant());
      
      EqualsBuilder eqb5 = new EqualsBuilder();
      eqb5.append(getDureeTheoriqueDroitRetenu(), decisionV1.getDureeTheoriqueDroitRetenu()).append(getDureeEffectiveDroitRetenu(), decisionV1.getDureeEffectiveDroitRetenu()).append(getDateFinPrcSjrInitialDroitRetenu(), decisionV1.getDateFinPrcSjrInitialDroitRetenu()).append(getMontantSjrInitialDroitRetenu(), decisionV1.getMontantSjrInitialDroitRetenu()).append(getMontantBrutDroitPrecedent(), decisionV1.getMontantBrutDroitPrecedent()).append(isMontantRetenuEstLePrecedent(), decisionV1.isMontantRetenuEstLePrecedent()).append(isCapitalRetenuEstLePrecendent(), decisionV1.isCapitalRetenuEstLePrecendent());
      
      EqualsBuilder eqb6 = new EqualsBuilder();
      eqb6.append(getDebutCarenceICCP(), decisionV1.getDebutCarenceICCP()).append(getFinCarenceICCP(), decisionV1.getFinCarenceICCP()).append(getNbJoursCarenceICCP() == -1 ? 0 : getNbJoursCarenceICCP(), decisionV1.getNbJoursCarenceICCP() == -1 ? 0 : decisionV1.getNbJoursCarenceICCP()).append(getDebutCarenceISLR(), decisionV1.getDebutCarenceISLR()).append(getFinCarenceISLR(), decisionV1.getFinCarenceISLR()).append(getNbJoursCarenceISLR() == -1 ? 0 : getNbJoursCarenceISLR(), decisionV1.getNbJoursCarenceISLR() == -1 ? 0 : decisionV1.getNbJoursCarenceISLR()).append(getDebutCarencePMC(), decisionV1.getDebutCarencePMC()).append(getFinCarencePMC(), decisionV1.getFinCarencePMC()).append(getNbJoursCarencePMC() == -1 ? 0 : getNbJoursCarencePMC(), decisionV1.getNbJoursCarencePMC() == -1 ? 0 : decisionV1.getNbJoursCarencePMC()).append(getDebutDiffere(), decisionV1.getDebutDiffere()).append(getFinDiffere(), decisionV1.getFinDiffere()).append(getNbJoursDiffere() == -1 ? 0 : getNbJoursDiffere(), decisionV1.getNbJoursDiffere() == -1 ? 0 : decisionV1.getNbJoursDiffere()).isEquals();
      
      EqualsBuilder eqb7 = new EqualsBuilder();
      eqb7.append(getRangAllongement() == -1 ? 0 : getRangAllongement(), decisionV1.getRangAllongement() == -1 ? 0 : decisionV1.getRangAllongement()).append(getMontantSRInitial(), decisionV1.getMontantSRInitial()).append(getMontantSRInitialPlafonne(), decisionV1.getMontantSRInitialPlafonne()).append(getDateDebutDiffereStandard(), decisionV1.getDateDebutDiffereStandard()).append(getDateFinDiffereStandard(), decisionV1.getDateFinDiffereStandard()).append(getNbJoursDiffereStandard(), decisionV1.getNbJoursDiffereStandard()).append(getMontantSRDiffereStandard(), decisionV1.getMontantSRDiffereStandard()).append(getNbHeuresTravailleesEtendu(), decisionV1.getNbHeuresTravailleesEtendu()).append(getNbHeuresTravailleesPlafonne(), decisionV1.getNbHeuresTravailleesPlafonne());
      
      isEqual = (super.equals(p_arg0)) && (eqb1.isEquals()) && (eqb2.isEquals()) && (eqb3.isEquals()) && (eqb4.isEquals()) && (eqb5.isEquals()) && (eqb6.isEquals()) && (eqb7.isEquals());
    }
    return isEqual;
  }
  
  public Damj getDateDebutDiffereStandard()
  {
    return m_dateDebutDiffereStandard;
  }
  
  public void setDateDebutDiffereStandard(Damj p_dateDebutDiffereStandard)
  {
    m_dateDebutDiffereStandard = p_dateDebutDiffereStandard;
  }
  
  public Damj getDateFinDiffereStandard()
  {
    return m_dateFinDiffereStandard;
  }
  
  public void setDateFinDiffereStandard(Damj p_dateFinDiffereStandard)
  {
    m_dateFinDiffereStandard = p_dateFinDiffereStandard;
  }
  
  public BigDecimal getMontantSRDiffereStandard()
  {
    return m_montantSRDiffereStandard;
  }
  
  public void setMontantSRDiffereStandard(BigDecimal p_montantSRDiffereStandard)
  {
    m_montantSRDiffereStandard = p_montantSRDiffereStandard;
  }
  
  public BigDecimal getMontantSRInitial()
  {
    return m_montantSRInitial;
  }
  
  public void setMontantSRInitial(BigDecimal p_montantSRInitial)
  {
    m_montantSRInitial = p_montantSRInitial;
  }
  
  public BigDecimal getMontantSRInitialPlafonne()
  {
    return m_montantSRInitialPlafonne;
  }
  
  public void setMontantSRInitialPlafonne(BigDecimal p_montantSRInitialPlafonne)
  {
    m_montantSRInitialPlafonne = p_montantSRInitialPlafonne;
  }
  
  public BigDecimal getNbHeuresTravailleesEtendu()
  {
    return m_nbHeuresTravailleesEtendu;
  }
  
  public void setNbHeuresTravailleesEtendu(BigDecimal p_nbHeuresTravailleesEtendu)
  {
    m_nbHeuresTravailleesEtendu = p_nbHeuresTravailleesEtendu;
  }
  
  public BigDecimal getNbHeuresTravailleesPlafonne()
  {
    return m_nbHeuresTravailleesPlafonne;
  }
  
  public void setNbHeuresTravailleesPlafonne(BigDecimal p_nbHeuresTravailleesPlafonne)
  {
    m_nbHeuresTravailleesPlafonne = p_nbHeuresTravailleesPlafonne;
  }
  
  public BigDecimal getNbJoursDiffereStandard()
  {
    return m_nbJoursDiffereStandard;
  }
  
  public void setNbJoursDiffereStandard(BigDecimal p_nbJoursDiffereStandard)
  {
    m_nbJoursDiffereStandard = p_nbJoursDiffereStandard;
  }
  
  public int getRangAllongement()
  {
    return m_rangAllongement;
  }
  
  public void setRangAllongement(int p_rangAllongement)
  {
    m_rangAllongement = p_rangAllongement;
  }
  
  public BigDecimal getMontantSalaireJournalierMoyenInitial()
  {
    return m_montantSalaireJournalierMoyenInitial;
  }
  
  public void setMontantSalaireJournalierMoyenInitial(BigDecimal p_montantSalaireJournalierMoyenInitial)
  {
    m_montantSalaireJournalierMoyenInitial = p_montantSalaireJournalierMoyenInitial;
  }
  
  public Chronologie getChronologiePeriodesFCT()
  {
    return m_chronologiePeriodesFCT;
  }
  
  public void setChronologiePeriodesFCT(Chronologie p_chronologiePeriodesFCT)
  {
    m_chronologiePeriodesFCT = p_chronologiePeriodesFCT;
  }
  
  public boolean isAfficherPeriodesFCT()
  {
    return m_afficherPeriodesFCT;
  }
  
  public void setAfficherPeriodesFCT(boolean p_afficherPeriodesFCT)
  {
    m_afficherPeriodesFCT = p_afficherPeriodesFCT;
  }
}

/* Location:
 * Qualified Name:     DecisionMigreeAsuV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.echange.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.echange.pc.DecisionPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class DecisionGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_decisionPC;
  private String m_identifiantEvenement;
  private String m_codeSegment;
  private String m_referenceExterneDemande;
  private String m_gamme;
  private String m_ligne;
  private String m_classementAdministratif;
  private String m_produit;
  private String m_competenceAdministrative;
  private BigDecimal m_montantAllocationJournalierBrutCourrier;
  private BigDecimal m_montantAllocationJournalierNetCourrier;
  private BigDecimal m_montantCrcCourrier;
  private BigDecimal m_montantPensionInvaliditeAreCourrier;
  private BigDecimal m_montantArePourAerComplementCourrier;
  private BigDecimal m_montantForfaitaireMensuelRpsCourrier;
  private BigDecimal m_fraisFthrAvant;
  private BigDecimal m_fraisFpoAvant;
  private BigDecimal m_fraisFthrApres;
  private BigDecimal m_fraisFpoApres;
  private String m_libelleEmployeur;
  private Damj m_dateTraitement;
  private BigDecimal m_montantSJC;
  private BigDecimal m_montantSJCMax;
  private BigDecimal m_montantAllocation;
  private BigDecimal m_montantAllocationUn;
  private BigDecimal m_montantAllocationDeux;
  private String m_typeAide;
  private String m_typeExamen;
  private String m_situationParticuliere;
  private String m_codeSousProduit;
  private Damj m_dateBanalisee;
  private BigDecimal m_montantSJRSuiteRevision;
  private String m_codeTypeAction = "  ";
  private String m_codeTypeAttente;
  private Damj m_dateFCT;
  private String m_typeExamenCreationDemande;
  private BigDecimal m_contributionNonPropositionCTP;
  private BigDecimal m_montantPreavisCR;
  private BigDecimal m_montantFormationD;
  private BigDecimal m_nombreHeureUn;
  private BigDecimal m_nombreHeureDeux;
  private BigDecimal m_plafondMensuelRessourcesAss;
  private BigDecimal m_nbEmploisSalariesRetenus;
  private BigDecimal m_montantBrutTranche2;
  private BigDecimal m_montantCrcTranche2;
  private BigDecimal m_montantBrutTranche3;
  private BigDecimal m_montantCrcTranche3;
  private String m_validationDAPE;
  private String m_typeActionReclassementAvant;
  private String m_typeActionReclassementApres;
  private BigDecimal m_montantForfaitUnitaireRepas;
  private BigDecimal m_montantForfaitUnitaireHebergement;
  private BigDecimal m_montantIndiceKilometrique;
  private Damj m_dateDepotAide;
  private Damj m_dateRetourJustificatif;
  private BigDecimal m_nombreEnfantsTotal;
  private String m_numeroConventionGestion;
  private String m_codeAffectation;
  private BigDecimal m_montantBonAvant;
  private BigDecimal m_montantBonAvantDerogatoire;
  private String m_typeBonAvant;
  private String m_typeBonAvantDerogatoire;
  private BigDecimal m_montantBonApres;
  private BigDecimal m_montantBonApresDerogatoire;
  private String m_typeBonApres;
  private String m_typebonApresDerogatoire;
  private BigDecimal m_dureePostPrime;
  private String m_indicateurPremiereDemandePostPrime;
  private String m_indicateurDiminutionMontantCSP;
  private String m_indicateurAllongementDureeCSP;
  private Damj m_dateDepartDelai121j;
  private Damj m_dateDebutDernierDelaiAttente;
  private Damj m_dateIDE;
  private Damj m_dateFaitGenerateurDroitPrecedent;
  private String m_reglementApplicableDroit;
  private String m_attenteBlocageLiquidationAutoRepriseAss;
  private String m_attenteNationaliteAValider;
  private BigDecimal m_nombreJoursFranchiseCP;
  private BigDecimal m_nombreJoursFranchiseSalaire;
  private BigDecimal m_baseCalculFranchiseCP;
  private BigDecimal m_baseCalculFranchiseSalaire;
  private BigDecimal m_identifiantPeriodeIncoherenceSalaireNPDE;
  private BigDecimal m_nombreMoisPreavis;
  private String m_codeSousProduitRejet;
  private BigDecimal m_identifiantPeriodeIncoherenceRessortissant;
  private BigDecimal m_coefficientReducteurSJR;
  private BigDecimal m_plancherCoefReducteur;
  private String m_topPresenceDiffereARCE;
  private BigDecimal m_diviseurIslr;
  private Damj m_dateFinPeriodeSuspensive;
  
  public DecisionGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public DecisionGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new DecisionPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_decisionPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_decisionPC)
  {
    m_decisionPC = p_decisionPC;
  }
  
  protected String rawGetIdentifiantEvenement()
  {
    return ((DecisionPC)getPC()).getIdentifiantEvenement();
  }
  
  public String getIdentifiantEvenement()
  {
    return ((DecisionPC)getPC()).getIdentifiantEvenement();
  }
  
  public void setIdentifiantEvenement(String p_identifiantEvenement)
  {
    if ((m_identifiantEvenement == null) || (p_identifiantEvenement == null))
    {
      m_identifiantEvenement = p_identifiantEvenement;
      ((DecisionPC)getPC()).setIdentifiantEvenement(p_identifiantEvenement);
    }
    else if ((m_identifiantEvenement != null) && (p_identifiantEvenement != null) && (!p_identifiantEvenement.equals(m_identifiantEvenement)))
    {
      m_identifiantEvenement = p_identifiantEvenement;
      ((DecisionPC)getPC()).setIdentifiantEvenement(p_identifiantEvenement);
    }
  }
  
  protected int rawGetEtatDemande()
  {
    return ((DecisionPC)getPC()).getEtatDemande();
  }
  
  public int getEtatDemande()
  {
    return ((DecisionPC)getPC()).getEtatDemande();
  }
  
  public void setEtatDemande(int p_etatDemande)
  {
    ((DecisionPC)getPC()).setEtatDemande(p_etatDemande);
  }
  
  protected String rawGetCodeSegment()
  {
    return ((DecisionPC)getPC()).getCodeSegment();
  }
  
  public String getCodeSegment()
  {
    return ((DecisionPC)getPC()).getCodeSegment();
  }
  
  public void setCodeSegment(String p_codeSegment)
  {
    if ((m_codeSegment == null) || (p_codeSegment == null))
    {
      m_codeSegment = p_codeSegment;
      ((DecisionPC)getPC()).setCodeSegment(p_codeSegment);
    }
    else if ((m_codeSegment != null) && (p_codeSegment != null) && (!p_codeSegment.equals(m_codeSegment)))
    {
      m_codeSegment = p_codeSegment;
      ((DecisionPC)getPC()).setCodeSegment(p_codeSegment);
    }
  }
  
  protected String rawGetReferenceExterneDemande()
  {
    return ((DecisionPC)getPC()).getReferenceExterneDemande();
  }
  
  public String getReferenceExterneDemande()
  {
    return ((DecisionPC)getPC()).getReferenceExterneDemande();
  }
  
  public void setReferenceExterneDemande(String p_referenceExterneDemande)
  {
    if ((m_referenceExterneDemande == null) || (p_referenceExterneDemande == null))
    {
      m_referenceExterneDemande = p_referenceExterneDemande;
      ((DecisionPC)getPC()).setReferenceExterneDemande(p_referenceExterneDemande);
    }
    else if ((m_referenceExterneDemande != null) && (p_referenceExterneDemande != null) && (!p_referenceExterneDemande.equals(m_referenceExterneDemande)))
    {
      m_referenceExterneDemande = p_referenceExterneDemande;
      ((DecisionPC)getPC()).setReferenceExterneDemande(p_referenceExterneDemande);
    }
  }
  
  protected String rawGetGamme()
  {
    return ((DecisionPC)getPC()).getGamme();
  }
  
  public String getGamme()
  {
    return ((DecisionPC)getPC()).getGamme();
  }
  
  public void setGamme(String p_gamme)
  {
    if ((m_gamme == null) || (p_gamme == null))
    {
      m_gamme = p_gamme;
      ((DecisionPC)getPC()).setGamme(p_gamme);
    }
    else if ((m_gamme != null) && (p_gamme != null) && (!p_gamme.equals(m_gamme)))
    {
      m_gamme = p_gamme;
      ((DecisionPC)getPC()).setGamme(p_gamme);
    }
  }
  
  protected String rawGetLigne()
  {
    return ((DecisionPC)getPC()).getLigne();
  }
  
  public String getLigne()
  {
    return ((DecisionPC)getPC()).getLigne();
  }
  
  public void setLigne(String p_ligne)
  {
    if ((m_ligne == null) || (p_ligne == null))
    {
      m_ligne = p_ligne;
      ((DecisionPC)getPC()).setLigne(p_ligne);
    }
    else if ((m_ligne != null) && (p_ligne != null) && (!p_ligne.equals(m_ligne)))
    {
      m_ligne = p_ligne;
      ((DecisionPC)getPC()).setLigne(p_ligne);
    }
  }
  
  protected int rawGetTypeEchecExamen()
  {
    return ((DecisionPC)getPC()).getTypeEchecExamen();
  }
  
  public int getTypeEchecExamen()
  {
    return ((DecisionPC)getPC()).getTypeEchecExamen();
  }
  
  public void setTypeEchecExamen(int p_typeEchecExamen)
  {
    ((DecisionPC)getPC()).setTypeEchecExamen(p_typeEchecExamen);
  }
  
  protected int rawGetMotifEchec()
  {
    return ((DecisionPC)getPC()).getMotifEchec();
  }
  
  public int getMotifEchec()
  {
    return ((DecisionPC)getPC()).getMotifEchec();
  }
  
  public void setMotifEchec(int p_motifEchec)
  {
    ((DecisionPC)getPC()).setMotifEchec(p_motifEchec);
  }
  
  protected String rawGetClassementAdministratif()
  {
    return ((DecisionPC)getPC()).getClassementAdministratif();
  }
  
  public String getClassementAdministratif()
  {
    return ((DecisionPC)getPC()).getClassementAdministratif();
  }
  
  public void setClassementAdministratif(String p_classementAdministratif)
  {
    if ((m_classementAdministratif == null) || (p_classementAdministratif == null))
    {
      m_classementAdministratif = p_classementAdministratif;
      ((DecisionPC)getPC()).setClassementAdministratif(p_classementAdministratif);
    }
    else if ((m_classementAdministratif != null) && (p_classementAdministratif != null) && (!p_classementAdministratif.equals(m_classementAdministratif)))
    {
      m_classementAdministratif = p_classementAdministratif;
      ((DecisionPC)getPC()).setClassementAdministratif(p_classementAdministratif);
    }
  }
  
  protected int rawGetMotifReexamenPrincipal()
  {
    return ((DecisionPC)getPC()).getMotifReexamenPrincipal();
  }
  
  public int getMotifReexamenPrincipal()
  {
    return ((DecisionPC)getPC()).getMotifReexamenPrincipal();
  }
  
  public void setMotifReexamenPrincipal(int p_motifReexamenPrincipal)
  {
    ((DecisionPC)getPC()).setMotifReexamenPrincipal(p_motifReexamenPrincipal);
  }
  
  protected int rawGetIdentifiantOd()
  {
    return ((DecisionPC)getPC()).getIdentifiantOd();
  }
  
  public int getIdentifiantOd()
  {
    return ((DecisionPC)getPC()).getIdentifiantOd();
  }
  
  public void setIdentifiantOd(int p_identifiantOd)
  {
    ((DecisionPC)getPC()).setIdentifiantOd(p_identifiantOd);
  }
  
  protected int rawGetIdentifiantReprise()
  {
    return ((DecisionPC)getPC()).getIdentifiantReprise();
  }
  
  public int getIdentifiantReprise()
  {
    return ((DecisionPC)getPC()).getIdentifiantReprise();
  }
  
  public void setIdentifiantReprise(int p_identifiantReprise)
  {
    ((DecisionPC)getPC()).setIdentifiantReprise(p_identifiantReprise);
  }
  
  protected String rawGetProduit()
  {
    return ((DecisionPC)getPC()).getProduit();
  }
  
  public String getProduit()
  {
    return ((DecisionPC)getPC()).getProduit();
  }
  
  public void setProduit(String p_produit)
  {
    if ((m_produit == null) || (p_produit == null))
    {
      m_produit = p_produit;
      ((DecisionPC)getPC()).setProduit(p_produit);
    }
    else if ((m_produit != null) && (p_produit != null) && (!p_produit.equals(m_produit)))
    {
      m_produit = p_produit;
      ((DecisionPC)getPC()).setProduit(p_produit);
    }
  }
  
  protected int rawGetNatureDecision()
  {
    return ((DecisionPC)getPC()).getNatureDecision();
  }
  
  public int getNatureDecision()
  {
    return ((DecisionPC)getPC()).getNatureDecision();
  }
  
  public void setNatureDecision(int p_natureDecision)
  {
    ((DecisionPC)getPC()).setNatureDecision(p_natureDecision);
  }
  
  protected int rawGetOrigineDecision()
  {
    return ((DecisionPC)getPC()).getOrigineDecision();
  }
  
  public int getOrigineDecision()
  {
    return ((DecisionPC)getPC()).getOrigineDecision();
  }
  
  public void setOrigineDecision(int p_origineDecision)
  {
    ((DecisionPC)getPC()).setOrigineDecision(p_origineDecision);
  }
  
  protected int rawGetTopContribSupplementaire()
  {
    return ((DecisionPC)getPC()).getTopContribSupplementaire();
  }
  
  public int getTopContribSupplementaire()
  {
    return ((DecisionPC)getPC()).getTopContribSupplementaire();
  }
  
  public void setTopContribSupplementaire(int p_topContribSupplementaire)
  {
    ((DecisionPC)getPC()).setTopContribSupplementaire(p_topContribSupplementaire);
  }
  
  protected int rawGetTopContribSpecifique()
  {
    return ((DecisionPC)getPC()).getTopContribSpecifique();
  }
  
  public int getTopContribSpecifique()
  {
    return ((DecisionPC)getPC()).getTopContribSpecifique();
  }
  
  public void setTopContribSpecifique(int p_topContribSpecifique)
  {
    ((DecisionPC)getPC()).setTopContribSpecifique(p_topContribSpecifique);
  }
  
  protected int rawGetTopEchecDemandeExpresseEnCoursIndemnisation()
  {
    return ((DecisionPC)getPC()).getTopEchecDemandeExpresseEnCoursIndemnisation();
  }
  
  public int getTopEchecDemandeExpresseEnCoursIndemnisation()
  {
    return ((DecisionPC)getPC()).getTopEchecDemandeExpresseEnCoursIndemnisation();
  }
  
  public void setTopEchecDemandeExpresseEnCoursIndemnisation(int p_topEchecDemandeExpresseEnCoursIndemnisation)
  {
    ((DecisionPC)getPC()).setTopEchecDemandeExpresseEnCoursIndemnisation(p_topEchecDemandeExpresseEnCoursIndemnisation);
  }
  
  protected int rawGetTopRejetASUReliquatASS()
  {
    return ((DecisionPC)getPC()).getTopRejetASUReliquatASS();
  }
  
  public int getTopRejetASUReliquatASS()
  {
    return ((DecisionPC)getPC()).getTopRejetASUReliquatASS();
  }
  
  public void setTopRejetASUReliquatASS(int p_topRejetASUReliquatASS)
  {
    ((DecisionPC)getPC()).setTopRejetASUReliquatASS(p_topRejetASUReliquatASS);
  }
  
  protected int rawGetTopRejetASUCpaASS()
  {
    return ((DecisionPC)getPC()).getTopRejetASUCpaASS();
  }
  
  public int getTopRejetASUCpaASS()
  {
    return ((DecisionPC)getPC()).getTopRejetASUCpaASS();
  }
  
  public void setTopRejetASUCpaASS(int p_topRejetASUCpaASS)
  {
    ((DecisionPC)getPC()).setTopRejetASUCpaASS(p_topRejetASUCpaASS);
  }
  
  protected int rawGetTopDroitOptionAss()
  {
    return ((DecisionPC)getPC()).getTopDroitOptionAss();
  }
  
  public int getTopDroitOptionAss()
  {
    return ((DecisionPC)getPC()).getTopDroitOptionAss();
  }
  
  public void setTopDroitOptionAss(int p_topDroitOptionAss)
  {
    ((DecisionPC)getPC()).setTopDroitOptionAss(p_topDroitOptionAss);
  }
  
  protected String rawGetCompetenceAdministrative()
  {
    return ((DecisionPC)getPC()).getCompetenceAdministrative();
  }
  
  public String getCompetenceAdministrative()
  {
    return ((DecisionPC)getPC()).getCompetenceAdministrative();
  }
  
  public void setCompetenceAdministrative(String p_competenceAdministrative)
  {
    if ((m_competenceAdministrative == null) || (p_competenceAdministrative == null))
    {
      m_competenceAdministrative = p_competenceAdministrative;
      ((DecisionPC)getPC()).setCompetenceAdministrative(p_competenceAdministrative);
    }
    else if ((m_competenceAdministrative != null) && (p_competenceAdministrative != null) && (!p_competenceAdministrative.equals(m_competenceAdministrative)))
    {
      m_competenceAdministrative = p_competenceAdministrative;
      ((DecisionPC)getPC()).setCompetenceAdministrative(p_competenceAdministrative);
    }
  }
  
  protected int rawGetIndicateurNotificationCourrier()
  {
    return ((DecisionPC)getPC()).getIndicateurNotificationCourrier();
  }
  
  public int getIndicateurNotificationCourrier()
  {
    return ((DecisionPC)getPC()).getIndicateurNotificationCourrier();
  }
  
  public void setIndicateurNotificationCourrier(int p_indicateurNotificationCourrier)
  {
    ((DecisionPC)getPC()).setIndicateurNotificationCourrier(p_indicateurNotificationCourrier);
  }
  
  protected BigDecimal rawGetMontantAllocationJournalierBrutCourrier()
  {
    return ((DecisionPC)getPC()).getMontantAllocationJournalierBrutCourrier();
  }
  
  public BigDecimal getMontantAllocationJournalierBrutCourrier()
  {
    return ((DecisionPC)getPC()).getMontantAllocationJournalierBrutCourrier();
  }
  
  public void setMontantAllocationJournalierBrutCourrier(BigDecimal p_montantAllocationJournalierBrutCourrier)
  {
    if ((m_montantAllocationJournalierBrutCourrier == null) || (p_montantAllocationJournalierBrutCourrier == null))
    {
      m_montantAllocationJournalierBrutCourrier = p_montantAllocationJournalierBrutCourrier;
      ((DecisionPC)getPC()).setMontantAllocationJournalierBrutCourrier(p_montantAllocationJournalierBrutCourrier);
    }
    else if ((m_montantAllocationJournalierBrutCourrier != null) && (p_montantAllocationJournalierBrutCourrier != null) && (!p_montantAllocationJournalierBrutCourrier.equals(m_montantAllocationJournalierBrutCourrier)))
    {
      m_montantAllocationJournalierBrutCourrier = p_montantAllocationJournalierBrutCourrier;
      ((DecisionPC)getPC()).setMontantAllocationJournalierBrutCourrier(p_montantAllocationJournalierBrutCourrier);
    }
  }
  
  protected BigDecimal rawGetMontantAllocationJournalierNetCourrier()
  {
    return ((DecisionPC)getPC()).getMontantAllocationJournalierNetCourrier();
  }
  
  public BigDecimal getMontantAllocationJournalierNetCourrier()
  {
    return ((DecisionPC)getPC()).getMontantAllocationJournalierNetCourrier();
  }
  
  public void setMontantAllocationJournalierNetCourrier(BigDecimal p_montantAllocationJournalierNetCourrier)
  {
    if ((m_montantAllocationJournalierNetCourrier == null) || (p_montantAllocationJournalierNetCourrier == null))
    {
      m_montantAllocationJournalierNetCourrier = p_montantAllocationJournalierNetCourrier;
      ((DecisionPC)getPC()).setMontantAllocationJournalierNetCourrier(p_montantAllocationJournalierNetCourrier);
    }
    else if ((m_montantAllocationJournalierNetCourrier != null) && (p_montantAllocationJournalierNetCourrier != null) && (!p_montantAllocationJournalierNetCourrier.equals(m_montantAllocationJournalierNetCourrier)))
    {
      m_montantAllocationJournalierNetCourrier = p_montantAllocationJournalierNetCourrier;
      ((DecisionPC)getPC()).setMontantAllocationJournalierNetCourrier(p_montantAllocationJournalierNetCourrier);
    }
  }
  
  protected BigDecimal rawGetMontantCrcCourrier()
  {
    return ((DecisionPC)getPC()).getMontantCrcCourrier();
  }
  
  public BigDecimal getMontantCrcCourrier()
  {
    return ((DecisionPC)getPC()).getMontantCrcCourrier();
  }
  
  public void setMontantCrcCourrier(BigDecimal p_montantCrcCourrier)
  {
    if ((m_montantCrcCourrier == null) || (p_montantCrcCourrier == null))
    {
      m_montantCrcCourrier = p_montantCrcCourrier;
      ((DecisionPC)getPC()).setMontantCrcCourrier(p_montantCrcCourrier);
    }
    else if ((m_montantCrcCourrier != null) && (p_montantCrcCourrier != null) && (!p_montantCrcCourrier.equals(m_montantCrcCourrier)))
    {
      m_montantCrcCourrier = p_montantCrcCourrier;
      ((DecisionPC)getPC()).setMontantCrcCourrier(p_montantCrcCourrier);
    }
  }
  
  protected int rawGetDureeTheoriqueDroitServiCourrier()
  {
    return ((DecisionPC)getPC()).getDureeTheoriqueDroitServiCourrier();
  }
  
  public int getDureeTheoriqueDroitServiCourrier()
  {
    return ((DecisionPC)getPC()).getDureeTheoriqueDroitServiCourrier();
  }
  
  public void setDureeTheoriqueDroitServiCourrier(int p_dureeTheoriqueDroitServiCourrier)
  {
    ((DecisionPC)getPC()).setDureeTheoriqueDroitServiCourrier(p_dureeTheoriqueDroitServiCourrier);
  }
  
  protected int rawGetDureeRenouvellementAreCourrier()
  {
    return ((DecisionPC)getPC()).getDureeRenouvellementAreCourrier();
  }
  
  public int getDureeRenouvellementAreCourrier()
  {
    return ((DecisionPC)getPC()).getDureeRenouvellementAreCourrier();
  }
  
  public void setDureeRenouvellementAreCourrier(int p_dureeRenouvellementAreCourrier)
  {
    ((DecisionPC)getPC()).setDureeRenouvellementAreCourrier(p_dureeRenouvellementAreCourrier);
  }
  
  protected BigDecimal rawGetMontantPensionInvaliditeAreCourrier()
  {
    return ((DecisionPC)getPC()).getMontantPensionInvaliditeAreCourrier();
  }
  
  public BigDecimal getMontantPensionInvaliditeAreCourrier()
  {
    return ((DecisionPC)getPC()).getMontantPensionInvaliditeAreCourrier();
  }
  
  public void setMontantPensionInvaliditeAreCourrier(BigDecimal p_montantPensionInvaliditeAreCourrier)
  {
    if ((m_montantPensionInvaliditeAreCourrier == null) || (p_montantPensionInvaliditeAreCourrier == null))
    {
      m_montantPensionInvaliditeAreCourrier = p_montantPensionInvaliditeAreCourrier;
      ((DecisionPC)getPC()).setMontantPensionInvaliditeAreCourrier(p_montantPensionInvaliditeAreCourrier);
    }
    else if ((m_montantPensionInvaliditeAreCourrier != null) && (p_montantPensionInvaliditeAreCourrier != null) && (!p_montantPensionInvaliditeAreCourrier.equals(m_montantPensionInvaliditeAreCourrier)))
    {
      m_montantPensionInvaliditeAreCourrier = p_montantPensionInvaliditeAreCourrier;
      ((DecisionPC)getPC()).setMontantPensionInvaliditeAreCourrier(p_montantPensionInvaliditeAreCourrier);
    }
  }
  
  protected BigDecimal rawGetMontantArePourAerComplementCourrier()
  {
    return ((DecisionPC)getPC()).getMontantArePourAerComplementCourrier();
  }
  
  public BigDecimal getMontantArePourAerComplementCourrier()
  {
    return ((DecisionPC)getPC()).getMontantArePourAerComplementCourrier();
  }
  
  public void setMontantArePourAerComplementCourrier(BigDecimal p_montantArePourAerComplementCourrier)
  {
    if ((m_montantArePourAerComplementCourrier == null) || (p_montantArePourAerComplementCourrier == null))
    {
      m_montantArePourAerComplementCourrier = p_montantArePourAerComplementCourrier;
      ((DecisionPC)getPC()).setMontantArePourAerComplementCourrier(p_montantArePourAerComplementCourrier);
    }
    else if ((m_montantArePourAerComplementCourrier != null) && (p_montantArePourAerComplementCourrier != null) && (!p_montantArePourAerComplementCourrier.equals(m_montantArePourAerComplementCourrier)))
    {
      m_montantArePourAerComplementCourrier = p_montantArePourAerComplementCourrier;
      ((DecisionPC)getPC()).setMontantArePourAerComplementCourrier(p_montantArePourAerComplementCourrier);
    }
  }
  
  protected BigDecimal rawGetMontantForfaitaireMensuelRpsCourrier()
  {
    return ((DecisionPC)getPC()).getMontantForfaitaireMensuelRpsCourrier();
  }
  
  public BigDecimal getMontantForfaitaireMensuelRpsCourrier()
  {
    return ((DecisionPC)getPC()).getMontantForfaitaireMensuelRpsCourrier();
  }
  
  public void setMontantForfaitaireMensuelRpsCourrier(BigDecimal p_montantForfaitaireMensuelRpsCourrier)
  {
    if ((m_montantForfaitaireMensuelRpsCourrier == null) || (p_montantForfaitaireMensuelRpsCourrier == null))
    {
      m_montantForfaitaireMensuelRpsCourrier = p_montantForfaitaireMensuelRpsCourrier;
      ((DecisionPC)getPC()).setMontantForfaitaireMensuelRpsCourrier(p_montantForfaitaireMensuelRpsCourrier);
    }
    else if ((m_montantForfaitaireMensuelRpsCourrier != null) && (p_montantForfaitaireMensuelRpsCourrier != null) && (!p_montantForfaitaireMensuelRpsCourrier.equals(m_montantForfaitaireMensuelRpsCourrier)))
    {
      m_montantForfaitaireMensuelRpsCourrier = p_montantForfaitaireMensuelRpsCourrier;
      ((DecisionPC)getPC()).setMontantForfaitaireMensuelRpsCourrier(p_montantForfaitaireMensuelRpsCourrier);
    }
  }
  
  protected int rawGetIdentifiantActionFormation()
  {
    return ((DecisionPC)getPC()).getIdentifiantActionFormation();
  }
  
  public int getIdentifiantActionFormation()
  {
    return ((DecisionPC)getPC()).getIdentifiantActionFormation();
  }
  
  public void setIdentifiantActionFormation(int p_identifiantActionFormation)
  {
    ((DecisionPC)getPC()).setIdentifiantActionFormation(p_identifiantActionFormation);
  }
  
  protected BigDecimal rawGetFraisFthrAvant()
  {
    return ((DecisionPC)getPC()).getFraisFthrAvant();
  }
  
  public BigDecimal getFraisFthrAvant()
  {
    return ((DecisionPC)getPC()).getFraisFthrAvant();
  }
  
  public void setFraisFthrAvant(BigDecimal p_fraisFthrAvant)
  {
    if ((m_fraisFthrAvant == null) || (p_fraisFthrAvant == null))
    {
      m_fraisFthrAvant = p_fraisFthrAvant;
      ((DecisionPC)getPC()).setFraisFthrAvant(p_fraisFthrAvant);
    }
    else if ((m_fraisFthrAvant != null) && (p_fraisFthrAvant != null) && (!p_fraisFthrAvant.equals(m_fraisFthrAvant)))
    {
      m_fraisFthrAvant = p_fraisFthrAvant;
      ((DecisionPC)getPC()).setFraisFthrAvant(p_fraisFthrAvant);
    }
  }
  
  protected BigDecimal rawGetFraisFpoAvant()
  {
    return ((DecisionPC)getPC()).getFraisFpoAvant();
  }
  
  public BigDecimal getFraisFpoAvant()
  {
    return ((DecisionPC)getPC()).getFraisFpoAvant();
  }
  
  public void setFraisFpoAvant(BigDecimal p_fraisFpoAvant)
  {
    if ((m_fraisFpoAvant == null) || (p_fraisFpoAvant == null))
    {
      m_fraisFpoAvant = p_fraisFpoAvant;
      ((DecisionPC)getPC()).setFraisFpoAvant(p_fraisFpoAvant);
    }
    else if ((m_fraisFpoAvant != null) && (p_fraisFpoAvant != null) && (!p_fraisFpoAvant.equals(m_fraisFpoAvant)))
    {
      m_fraisFpoAvant = p_fraisFpoAvant;
      ((DecisionPC)getPC()).setFraisFpoAvant(p_fraisFpoAvant);
    }
  }
  
  protected BigDecimal rawGetFraisFthrApres()
  {
    return ((DecisionPC)getPC()).getFraisFthrApres();
  }
  
  public BigDecimal getFraisFthrApres()
  {
    return ((DecisionPC)getPC()).getFraisFthrApres();
  }
  
  public void setFraisFthrApres(BigDecimal p_fraisFthrApres)
  {
    if ((m_fraisFthrApres == null) || (p_fraisFthrApres == null))
    {
      m_fraisFthrApres = p_fraisFthrApres;
      ((DecisionPC)getPC()).setFraisFthrApres(p_fraisFthrApres);
    }
    else if ((m_fraisFthrApres != null) && (p_fraisFthrApres != null) && (!p_fraisFthrApres.equals(m_fraisFthrApres)))
    {
      m_fraisFthrApres = p_fraisFthrApres;
      ((DecisionPC)getPC()).setFraisFthrApres(p_fraisFthrApres);
    }
  }
  
  protected BigDecimal rawGetFraisFpoApres()
  {
    return ((DecisionPC)getPC()).getFraisFpoApres();
  }
  
  public BigDecimal getFraisFpoApres()
  {
    return ((DecisionPC)getPC()).getFraisFpoApres();
  }
  
  public void setFraisFpoApres(BigDecimal p_fraisFpoApres)
  {
    if ((m_fraisFpoApres == null) || (p_fraisFpoApres == null))
    {
      m_fraisFpoApres = p_fraisFpoApres;
      ((DecisionPC)getPC()).setFraisFpoApres(p_fraisFpoApres);
    }
    else if ((m_fraisFpoApres != null) && (p_fraisFpoApres != null) && (!p_fraisFpoApres.equals(m_fraisFpoApres)))
    {
      m_fraisFpoApres = p_fraisFpoApres;
      ((DecisionPC)getPC()).setFraisFpoApres(p_fraisFpoApres);
    }
  }
  
  protected int rawGetExerciceAvant()
  {
    return ((DecisionPC)getPC()).getExerciceAvant();
  }
  
  public int getExerciceAvant()
  {
    return ((DecisionPC)getPC()).getExerciceAvant();
  }
  
  public void setExerciceAvant(int p_exerciceAvant)
  {
    ((DecisionPC)getPC()).setExerciceAvant(p_exerciceAvant);
  }
  
  protected int rawGetExerciceApres()
  {
    return ((DecisionPC)getPC()).getExerciceApres();
  }
  
  public int getExerciceApres()
  {
    return ((DecisionPC)getPC()).getExerciceApres();
  }
  
  public void setExerciceApres(int p_exerciceApres)
  {
    ((DecisionPC)getPC()).setExerciceApres(p_exerciceApres);
  }
  
  protected int rawGetStatutAvant()
  {
    return ((DecisionPC)getPC()).getStatutAvant();
  }
  
  public int getStatutAvant()
  {
    return ((DecisionPC)getPC()).getStatutAvant();
  }
  
  public void setStatutAvant(int p_statutAvant)
  {
    ((DecisionPC)getPC()).setStatutAvant(p_statutAvant);
  }
  
  protected int rawGetStatutApres()
  {
    return ((DecisionPC)getPC()).getStatutApres();
  }
  
  public int getStatutApres()
  {
    return ((DecisionPC)getPC()).getStatutApres();
  }
  
  public void setStatutApres(int p_statutApres)
  {
    ((DecisionPC)getPC()).setStatutApres(p_statutApres);
  }
  
  protected int rawGetTopAffDerogatoire()
  {
    return ((DecisionPC)getPC()).getTopAffDerogatoire();
  }
  
  public int getTopAffDerogatoire()
  {
    return ((DecisionPC)getPC()).getTopAffDerogatoire();
  }
  
  public void setTopAffDerogatoire(int p_topAffDerogatoire)
  {
    ((DecisionPC)getPC()).setTopAffDerogatoire(p_topAffDerogatoire);
  }
  
  protected String rawGetLibelleEmployeur()
  {
    return ((DecisionPC)getPC()).getLibelleEmployeur();
  }
  
  public String getLibelleEmployeur()
  {
    return ((DecisionPC)getPC()).getLibelleEmployeur();
  }
  
  public void setLibelleEmployeur(String p_libelleEmployeur)
  {
    if ((m_libelleEmployeur == null) || (p_libelleEmployeur == null))
    {
      m_libelleEmployeur = p_libelleEmployeur;
      ((DecisionPC)getPC()).setLibelleEmployeur(p_libelleEmployeur);
    }
    else if ((m_libelleEmployeur != null) && (p_libelleEmployeur != null) && (!p_libelleEmployeur.equals(m_libelleEmployeur)))
    {
      m_libelleEmployeur = p_libelleEmployeur;
      ((DecisionPC)getPC()).setLibelleEmployeur(p_libelleEmployeur);
    }
  }
  
  protected int rawGetMotifRejet()
  {
    return ((DecisionPC)getPC()).getMotifRejet();
  }
  
  public int getMotifRejet()
  {
    return ((DecisionPC)getPC()).getMotifRejet();
  }
  
  public void setMotifRejet(int p_motifRejet)
  {
    ((DecisionPC)getPC()).setMotifRejet(p_motifRejet);
  }
  
  protected Damj rawGetDateTraitement()
  {
    return ((DecisionPC)getPC()).getDateTraitement();
  }
  
  public Damj getDateTraitement()
  {
    return ((DecisionPC)getPC()).getDateTraitement();
  }
  
  public void setDateTraitement(Damj p_dateTraitement)
  {
    if ((m_dateTraitement == null) || (p_dateTraitement == null))
    {
      m_dateTraitement = p_dateTraitement;
      ((DecisionPC)getPC()).setDateTraitement(p_dateTraitement);
    }
    else if ((m_dateTraitement != null) && (p_dateTraitement != null) && (!p_dateTraitement.equals(m_dateTraitement)))
    {
      m_dateTraitement = p_dateTraitement;
      ((DecisionPC)getPC()).setDateTraitement(p_dateTraitement);
    }
  }
  
  protected BigDecimal rawGetMontantSJC()
  {
    return ((DecisionPC)getPC()).getMontantSJC();
  }
  
  public BigDecimal getMontantSJC()
  {
    return ((DecisionPC)getPC()).getMontantSJC();
  }
  
  public void setMontantSJC(BigDecimal p_montantSJC)
  {
    if ((m_montantSJC == null) || (p_montantSJC == null))
    {
      m_montantSJC = p_montantSJC;
      ((DecisionPC)getPC()).setMontantSJC(p_montantSJC);
    }
    else if ((m_montantSJC != null) && (p_montantSJC != null) && (!p_montantSJC.equals(m_montantSJC)))
    {
      m_montantSJC = p_montantSJC;
      ((DecisionPC)getPC()).setMontantSJC(p_montantSJC);
    }
  }
  
  protected BigDecimal rawGetMontantSJCMax()
  {
    return ((DecisionPC)getPC()).getMontantSJCMax();
  }
  
  public BigDecimal getMontantSJCMax()
  {
    return ((DecisionPC)getPC()).getMontantSJCMax();
  }
  
  public void setMontantSJCMax(BigDecimal p_montantSJCMax)
  {
    if ((m_montantSJCMax == null) || (p_montantSJCMax == null))
    {
      m_montantSJCMax = p_montantSJCMax;
      ((DecisionPC)getPC()).setMontantSJCMax(p_montantSJCMax);
    }
    else if ((m_montantSJCMax != null) && (p_montantSJCMax != null) && (!p_montantSJCMax.equals(m_montantSJCMax)))
    {
      m_montantSJCMax = p_montantSJCMax;
      ((DecisionPC)getPC()).setMontantSJCMax(p_montantSJCMax);
    }
  }
  
  protected BigDecimal rawGetMontantAllocation()
  {
    return ((DecisionPC)getPC()).getMontantAllocation();
  }
  
  public BigDecimal getMontantAllocation()
  {
    return ((DecisionPC)getPC()).getMontantAllocation();
  }
  
  public void setMontantAllocation(BigDecimal p_montantAllocation)
  {
    if ((m_montantAllocation == null) || (p_montantAllocation == null))
    {
      m_montantAllocation = p_montantAllocation;
      ((DecisionPC)getPC()).setMontantAllocation(p_montantAllocation);
    }
    else if ((m_montantAllocation != null) && (p_montantAllocation != null) && (!p_montantAllocation.equals(m_montantAllocation)))
    {
      m_montantAllocation = p_montantAllocation;
      ((DecisionPC)getPC()).setMontantAllocation(p_montantAllocation);
    }
  }
  
  protected BigDecimal rawGetMontantAllocationUn()
  {
    return ((DecisionPC)getPC()).getMontantAllocationUn();
  }
  
  public BigDecimal getMontantAllocationUn()
  {
    return ((DecisionPC)getPC()).getMontantAllocationUn();
  }
  
  public void setMontantAllocationUn(BigDecimal p_montantAllocationUn)
  {
    if ((m_montantAllocationUn == null) || (p_montantAllocationUn == null))
    {
      m_montantAllocationUn = p_montantAllocationUn;
      ((DecisionPC)getPC()).setMontantAllocationUn(p_montantAllocationUn);
    }
    else if ((m_montantAllocationUn != null) && (p_montantAllocationUn != null) && (!p_montantAllocationUn.equals(m_montantAllocationUn)))
    {
      m_montantAllocationUn = p_montantAllocationUn;
      ((DecisionPC)getPC()).setMontantAllocationUn(p_montantAllocationUn);
    }
  }
  
  protected BigDecimal rawGetMontantAllocationDeux()
  {
    return ((DecisionPC)getPC()).getMontantAllocationDeux();
  }
  
  public BigDecimal getMontantAllocationDeux()
  {
    return ((DecisionPC)getPC()).getMontantAllocationDeux();
  }
  
  public void setMontantAllocationDeux(BigDecimal p_montantAllocationDeux)
  {
    if ((m_montantAllocationDeux == null) || (p_montantAllocationDeux == null))
    {
      m_montantAllocationDeux = p_montantAllocationDeux;
      ((DecisionPC)getPC()).setMontantAllocationDeux(p_montantAllocationDeux);
    }
    else if ((m_montantAllocationDeux != null) && (p_montantAllocationDeux != null) && (!p_montantAllocationDeux.equals(m_montantAllocationDeux)))
    {
      m_montantAllocationDeux = p_montantAllocationDeux;
      ((DecisionPC)getPC()).setMontantAllocationDeux(p_montantAllocationDeux);
    }
  }
  
  protected int rawGetTopCaisseInconnue()
  {
    return ((DecisionPC)getPC()).getTopCaisseInconnue();
  }
  
  public int getTopCaisseInconnue()
  {
    return ((DecisionPC)getPC()).getTopCaisseInconnue();
  }
  
  public void setTopCaisseInconnue(int p_topCaisseInconnue)
  {
    ((DecisionPC)getPC()).setTopCaisseInconnue(p_topCaisseInconnue);
  }
  
  protected int rawGetDureeImputationAideSurDroit()
  {
    return ((DecisionPC)getPC()).getDureeImputationAideSurDroit();
  }
  
  public int getDureeImputationAideSurDroit()
  {
    return ((DecisionPC)getPC()).getDureeImputationAideSurDroit();
  }
  
  public void setDureeImputationAideSurDroit(int p_dureeImputationAideSurDroit)
  {
    ((DecisionPC)getPC()).setDureeImputationAideSurDroit(p_dureeImputationAideSurDroit);
  }
  
  protected String rawGetTypeAide()
  {
    return ((DecisionPC)getPC()).getTypeAide();
  }
  
  public String getTypeAide()
  {
    return ((DecisionPC)getPC()).getTypeAide();
  }
  
  public void setTypeAide(String p_typeAide)
  {
    if ((m_typeAide == null) || (p_typeAide == null))
    {
      m_typeAide = p_typeAide;
      ((DecisionPC)getPC()).setTypeAide(p_typeAide);
    }
    else if ((m_typeAide != null) && (p_typeAide != null) && (!p_typeAide.equals(m_typeAide)))
    {
      m_typeAide = p_typeAide;
      ((DecisionPC)getPC()).setTypeAide(p_typeAide);
    }
  }
  
  protected int rawGetTopIndividuStable()
  {
    return ((DecisionPC)getPC()).getTopIndividuStable();
  }
  
  public int getTopIndividuStable()
  {
    return ((DecisionPC)getPC()).getTopIndividuStable();
  }
  
  public void setTopIndividuStable(int p_topIndividuStable)
  {
    ((DecisionPC)getPC()).setTopIndividuStable(p_topIndividuStable);
  }
  
  protected String rawGetTypeExamen()
  {
    return ((DecisionPC)getPC()).getTypeExamen();
  }
  
  public String getTypeExamen()
  {
    return ((DecisionPC)getPC()).getTypeExamen();
  }
  
  public void setTypeExamen(String p_typeExamen)
  {
    if ((m_typeExamen == null) || (p_typeExamen == null))
    {
      m_typeExamen = p_typeExamen;
      ((DecisionPC)getPC()).setTypeExamen(p_typeExamen);
    }
    else if ((m_typeExamen != null) && (p_typeExamen != null) && (!p_typeExamen.equals(m_typeExamen)))
    {
      m_typeExamen = p_typeExamen;
      ((DecisionPC)getPC()).setTypeExamen(p_typeExamen);
    }
  }
  
  protected String rawGetSituationParticuliere()
  {
    return ((DecisionPC)getPC()).getSituationParticuliere();
  }
  
  public String getSituationParticuliere()
  {
    return ((DecisionPC)getPC()).getSituationParticuliere();
  }
  
  public void setSituationParticuliere(String p_situationParticuliere)
  {
    if ((m_situationParticuliere == null) || (p_situationParticuliere == null))
    {
      m_situationParticuliere = p_situationParticuliere;
      ((DecisionPC)getPC()).setSituationParticuliere(p_situationParticuliere);
    }
    else if ((m_situationParticuliere != null) && (p_situationParticuliere != null) && (!p_situationParticuliere.equals(m_situationParticuliere)))
    {
      m_situationParticuliere = p_situationParticuliere;
      ((DecisionPC)getPC()).setSituationParticuliere(p_situationParticuliere);
    }
  }
  
  protected boolean rawIsInvestigationFraude()
  {
    return ((DecisionPC)getPC()).isInvestigationFraude();
  }
  
  public boolean isInvestigationFraude()
  {
    return ((DecisionPC)getPC()).isInvestigationFraude();
  }
  
  public void setInvestigationFraude(boolean p_investigationFraude)
  {
    ((DecisionPC)getPC()).setInvestigationFraude(p_investigationFraude);
  }
  
  protected String rawGetCodeSousProduit()
  {
    return ((DecisionPC)getPC()).getCodeSousProduit();
  }
  
  public String getCodeSousProduit()
  {
    return ((DecisionPC)getPC()).getCodeSousProduit();
  }
  
  public void setCodeSousProduit(String p_codeSousProduit)
  {
    if ((m_codeSousProduit == null) || (p_codeSousProduit == null))
    {
      m_codeSousProduit = p_codeSousProduit;
      ((DecisionPC)getPC()).setCodeSousProduit(p_codeSousProduit);
    }
    else if ((m_codeSousProduit != null) && (p_codeSousProduit != null) && (!p_codeSousProduit.equals(m_codeSousProduit)))
    {
      m_codeSousProduit = p_codeSousProduit;
      ((DecisionPC)getPC()).setCodeSousProduit(p_codeSousProduit);
    }
  }
  
  protected Damj rawGetDateBanalisee()
  {
    return ((DecisionPC)getPC()).getDateBanalisee();
  }
  
  public Damj getDateBanalisee()
  {
    return ((DecisionPC)getPC()).getDateBanalisee();
  }
  
  public void setDateBanalisee(Damj p_dateBanalisee)
  {
    if ((m_dateBanalisee == null) || (p_dateBanalisee == null))
    {
      m_dateBanalisee = p_dateBanalisee;
      ((DecisionPC)getPC()).setDateBanalisee(p_dateBanalisee);
    }
    else if ((m_dateBanalisee != null) && (p_dateBanalisee != null) && (!p_dateBanalisee.equals(m_dateBanalisee)))
    {
      m_dateBanalisee = p_dateBanalisee;
      ((DecisionPC)getPC()).setDateBanalisee(p_dateBanalisee);
    }
  }
  
  protected BigDecimal rawGetMontantSJRSuiteRevision()
  {
    return ((DecisionPC)getPC()).getMontantSJRSuiteRevision();
  }
  
  public BigDecimal getMontantSJRSuiteRevision()
  {
    return ((DecisionPC)getPC()).getMontantSJRSuiteRevision();
  }
  
  public void setMontantSJRSuiteRevision(BigDecimal p_montantSJRSuiteRevision)
  {
    if ((m_montantSJRSuiteRevision == null) || (p_montantSJRSuiteRevision == null))
    {
      m_montantSJRSuiteRevision = p_montantSJRSuiteRevision;
      ((DecisionPC)getPC()).setMontantSJRSuiteRevision(p_montantSJRSuiteRevision);
    }
    else if ((m_montantSJRSuiteRevision != null) && (p_montantSJRSuiteRevision != null) && (!p_montantSJRSuiteRevision.equals(m_montantSJRSuiteRevision)))
    {
      m_montantSJRSuiteRevision = p_montantSJRSuiteRevision;
      ((DecisionPC)getPC()).setMontantSJRSuiteRevision(p_montantSJRSuiteRevision);
    }
  }
  
  protected int rawGetAuMoinsUneActiviteConservee()
  {
    return ((DecisionPC)getPC()).getAuMoinsUneActiviteConservee();
  }
  
  public int getAuMoinsUneActiviteConservee()
  {
    return ((DecisionPC)getPC()).getAuMoinsUneActiviteConservee();
  }
  
  public void setAuMoinsUneActiviteConservee(int p_auMoinsUneActiviteConservee)
  {
    ((DecisionPC)getPC()).setAuMoinsUneActiviteConservee(p_auMoinsUneActiviteConservee);
  }
  
  protected String rawGetCodeTypeAction()
  {
    return ((DecisionPC)getPC()).getCodeTypeAction();
  }
  
  public String getCodeTypeAction()
  {
    return ((DecisionPC)getPC()).getCodeTypeAction();
  }
  
  public void setCodeTypeAction(String p_codeTypeAction)
  {
    if ((m_codeTypeAction == null) || (p_codeTypeAction == null))
    {
      m_codeTypeAction = p_codeTypeAction;
      ((DecisionPC)getPC()).setCodeTypeAction(p_codeTypeAction);
    }
    else if ((m_codeTypeAction != null) && (p_codeTypeAction != null) && (!p_codeTypeAction.equals(m_codeTypeAction)))
    {
      m_codeTypeAction = p_codeTypeAction;
      ((DecisionPC)getPC()).setCodeTypeAction(p_codeTypeAction);
    }
  }
  
  protected int rawGetCreationDALSuiteRejet()
  {
    return ((DecisionPC)getPC()).getCreationDALSuiteRejet();
  }
  
  public int getCreationDALSuiteRejet()
  {
    return ((DecisionPC)getPC()).getCreationDALSuiteRejet();
  }
  
  public void setCreationDALSuiteRejet(int p_creationDALSuiteRejet)
  {
    ((DecisionPC)getPC()).setCreationDALSuiteRejet(p_creationDALSuiteRejet);
  }
  
  protected String rawGetCodeTypeAttente()
  {
    return ((DecisionPC)getPC()).getCodeTypeAttente();
  }
  
  public String getCodeTypeAttente()
  {
    return ((DecisionPC)getPC()).getCodeTypeAttente();
  }
  
  public void setCodeTypeAttente(String p_codeTypeAttente)
  {
    if ((m_codeTypeAttente == null) || (p_codeTypeAttente == null))
    {
      m_codeTypeAttente = p_codeTypeAttente;
      ((DecisionPC)getPC()).setCodeTypeAttente(p_codeTypeAttente);
    }
    else if ((m_codeTypeAttente != null) && (p_codeTypeAttente != null) && (!p_codeTypeAttente.equals(m_codeTypeAttente)))
    {
      m_codeTypeAttente = p_codeTypeAttente;
      ((DecisionPC)getPC()).setCodeTypeAttente(p_codeTypeAttente);
    }
  }
  
  protected Damj rawGetDateFCT()
  {
    return ((DecisionPC)getPC()).getDateFCT();
  }
  
  public Damj getDateFCT()
  {
    return ((DecisionPC)getPC()).getDateFCT();
  }
  
  public void setDateFCT(Damj p_dateFCT)
  {
    if ((m_dateFCT == null) || (p_dateFCT == null))
    {
      m_dateFCT = p_dateFCT;
      ((DecisionPC)getPC()).setDateFCT(p_dateFCT);
    }
    else if ((m_dateFCT != null) && (p_dateFCT != null) && (!p_dateFCT.equals(m_dateFCT)))
    {
      m_dateFCT = p_dateFCT;
      ((DecisionPC)getPC()).setDateFCT(p_dateFCT);
    }
  }
  
  protected String rawGetTypeExamenCreationDemande()
  {
    return ((DecisionPC)getPC()).getTypeExamenCreationDemande();
  }
  
  public String getTypeExamenCreationDemande()
  {
    return ((DecisionPC)getPC()).getTypeExamenCreationDemande();
  }
  
  public void setTypeExamenCreationDemande(String p_typeExamenCreationDemande)
  {
    if ((m_typeExamenCreationDemande == null) || (p_typeExamenCreationDemande == null))
    {
      m_typeExamenCreationDemande = p_typeExamenCreationDemande;
      ((DecisionPC)getPC()).setTypeExamenCreationDemande(p_typeExamenCreationDemande);
    }
    else if ((m_typeExamenCreationDemande != null) && (p_typeExamenCreationDemande != null) && (!p_typeExamenCreationDemande.equals(m_typeExamenCreationDemande)))
    {
      m_typeExamenCreationDemande = p_typeExamenCreationDemande;
      ((DecisionPC)getPC()).setTypeExamenCreationDemande(p_typeExamenCreationDemande);
    }
  }
  
  protected BigDecimal rawGetContributionNonPropositionCTP()
  {
    return ((DecisionPC)getPC()).getContributionNonPropositionCTP();
  }
  
  public BigDecimal getContributionNonPropositionCTP()
  {
    return ((DecisionPC)getPC()).getContributionNonPropositionCTP();
  }
  
  public void setContributionNonPropositionCTP(BigDecimal p_contributionNonPropositionCTP)
  {
    if ((m_contributionNonPropositionCTP == null) || (p_contributionNonPropositionCTP == null))
    {
      m_contributionNonPropositionCTP = p_contributionNonPropositionCTP;
      ((DecisionPC)getPC()).setContributionNonPropositionCTP(p_contributionNonPropositionCTP);
    }
    else if ((m_contributionNonPropositionCTP != null) && (p_contributionNonPropositionCTP != null) && (!p_contributionNonPropositionCTP.equals(m_contributionNonPropositionCTP)))
    {
      m_contributionNonPropositionCTP = p_contributionNonPropositionCTP;
      ((DecisionPC)getPC()).setContributionNonPropositionCTP(p_contributionNonPropositionCTP);
    }
  }
  
  protected int rawGetEstContribPreavis()
  {
    return ((DecisionPC)getPC()).getEstContribPreavis();
  }
  
  public int getEstContribPreavis()
  {
    return ((DecisionPC)getPC()).getEstContribPreavis();
  }
  
  public void setEstContribPreavis(int p_estContribPreavis)
  {
    ((DecisionPC)getPC()).setEstContribPreavis(p_estContribPreavis);
  }
  
  protected int rawGetEstContribDif()
  {
    return ((DecisionPC)getPC()).getEstContribDif();
  }
  
  public int getEstContribDif()
  {
    return ((DecisionPC)getPC()).getEstContribDif();
  }
  
  public void setEstContribDif(int p_estContribDif)
  {
    ((DecisionPC)getPC()).setEstContribDif(p_estContribDif);
  }
  
  protected BigDecimal rawGetMontantPreavisCR()
  {
    return ((DecisionPC)getPC()).getMontantPreavisCR();
  }
  
  public BigDecimal getMontantPreavisCR()
  {
    return ((DecisionPC)getPC()).getMontantPreavisCR();
  }
  
  public void setMontantPreavisCR(BigDecimal p_montantPreavisCR)
  {
    if ((m_montantPreavisCR == null) || (p_montantPreavisCR == null))
    {
      m_montantPreavisCR = p_montantPreavisCR;
      ((DecisionPC)getPC()).setMontantPreavisCR(p_montantPreavisCR);
    }
    else if ((m_montantPreavisCR != null) && (p_montantPreavisCR != null) && (!p_montantPreavisCR.equals(m_montantPreavisCR)))
    {
      m_montantPreavisCR = p_montantPreavisCR;
      ((DecisionPC)getPC()).setMontantPreavisCR(p_montantPreavisCR);
    }
  }
  
  protected BigDecimal rawGetMontantFormationD()
  {
    return ((DecisionPC)getPC()).getMontantFormationD();
  }
  
  public BigDecimal getMontantFormationD()
  {
    return ((DecisionPC)getPC()).getMontantFormationD();
  }
  
  public void setMontantFormationD(BigDecimal p_montantFormationD)
  {
    if ((m_montantFormationD == null) || (p_montantFormationD == null))
    {
      m_montantFormationD = p_montantFormationD;
      ((DecisionPC)getPC()).setMontantFormationD(p_montantFormationD);
    }
    else if ((m_montantFormationD != null) && (p_montantFormationD != null) && (!p_montantFormationD.equals(m_montantFormationD)))
    {
      m_montantFormationD = p_montantFormationD;
      ((DecisionPC)getPC()).setMontantFormationD(p_montantFormationD);
    }
  }
  
  protected BigDecimal rawGetNombreHeureUn()
  {
    return ((DecisionPC)getPC()).getNombreHeureUn();
  }
  
  public BigDecimal getNombreHeureUn()
  {
    return ((DecisionPC)getPC()).getNombreHeureUn();
  }
  
  public void setNombreHeureUn(BigDecimal p_nombreHeureUn)
  {
    if ((m_nombreHeureUn == null) || (p_nombreHeureUn == null))
    {
      m_nombreHeureUn = p_nombreHeureUn;
      ((DecisionPC)getPC()).setNombreHeureUn(p_nombreHeureUn);
    }
    else if ((m_nombreHeureUn != null) && (p_nombreHeureUn != null) && (!p_nombreHeureUn.equals(m_nombreHeureUn)))
    {
      m_nombreHeureUn = p_nombreHeureUn;
      ((DecisionPC)getPC()).setNombreHeureUn(p_nombreHeureUn);
    }
  }
  
  protected BigDecimal rawGetNombreHeureDeux()
  {
    return ((DecisionPC)getPC()).getNombreHeureDeux();
  }
  
  public BigDecimal getNombreHeureDeux()
  {
    return ((DecisionPC)getPC()).getNombreHeureDeux();
  }
  
  public void setNombreHeureDeux(BigDecimal p_nombreHeureDeux)
  {
    if ((m_nombreHeureDeux == null) || (p_nombreHeureDeux == null))
    {
      m_nombreHeureDeux = p_nombreHeureDeux;
      ((DecisionPC)getPC()).setNombreHeureDeux(p_nombreHeureDeux);
    }
    else if ((m_nombreHeureDeux != null) && (p_nombreHeureDeux != null) && (!p_nombreHeureDeux.equals(m_nombreHeureDeux)))
    {
      m_nombreHeureDeux = p_nombreHeureDeux;
      ((DecisionPC)getPC()).setNombreHeureDeux(p_nombreHeureDeux);
    }
  }
  
  protected int rawGetTopAppelContributions()
  {
    return ((DecisionPC)getPC()).getTopAppelContributions();
  }
  
  public int getTopAppelContributions()
  {
    return ((DecisionPC)getPC()).getTopAppelContributions();
  }
  
  public void setTopAppelContributions(int p_topAppelContributions)
  {
    ((DecisionPC)getPC()).setTopAppelContributions(p_topAppelContributions);
  }
  
  protected BigDecimal rawGetPlafondMensuelRessourcesAss()
  {
    return ((DecisionPC)getPC()).getPlafondMensuelRessourcesAss();
  }
  
  public BigDecimal getPlafondMensuelRessourcesAss()
  {
    return ((DecisionPC)getPC()).getPlafondMensuelRessourcesAss();
  }
  
  public void setPlafondMensuelRessourcesAss(BigDecimal p_plafondMensuelRessourcesAss)
  {
    if ((m_plafondMensuelRessourcesAss == null) || (p_plafondMensuelRessourcesAss == null))
    {
      m_plafondMensuelRessourcesAss = p_plafondMensuelRessourcesAss;
      ((DecisionPC)getPC()).setPlafondMensuelRessourcesAss(p_plafondMensuelRessourcesAss);
    }
    else if ((m_plafondMensuelRessourcesAss != null) && (p_plafondMensuelRessourcesAss != null) && (!p_plafondMensuelRessourcesAss.equals(m_plafondMensuelRessourcesAss)))
    {
      m_plafondMensuelRessourcesAss = p_plafondMensuelRessourcesAss;
      ((DecisionPC)getPC()).setPlafondMensuelRessourcesAss(p_plafondMensuelRessourcesAss);
    }
  }
  
  protected BigDecimal rawGetNbEmploisSalariesRetenus()
  {
    return ((DecisionPC)getPC()).getNbEmploisSalariesRetenus();
  }
  
  public BigDecimal getNbEmploisSalariesRetenus()
  {
    return ((DecisionPC)getPC()).getNbEmploisSalariesRetenus();
  }
  
  public void setNbEmploisSalariesRetenus(BigDecimal p_nbEmploisSalariesRetenus)
  {
    if ((m_nbEmploisSalariesRetenus == null) || (p_nbEmploisSalariesRetenus == null))
    {
      m_nbEmploisSalariesRetenus = p_nbEmploisSalariesRetenus;
      ((DecisionPC)getPC()).setNbEmploisSalariesRetenus(p_nbEmploisSalariesRetenus);
    }
    else if ((m_nbEmploisSalariesRetenus != null) && (p_nbEmploisSalariesRetenus != null) && (!p_nbEmploisSalariesRetenus.equals(m_nbEmploisSalariesRetenus)))
    {
      m_nbEmploisSalariesRetenus = p_nbEmploisSalariesRetenus;
      ((DecisionPC)getPC()).setNbEmploisSalariesRetenus(p_nbEmploisSalariesRetenus);
    }
  }
  
  protected BigDecimal rawGetMontantBrutTranche2()
  {
    return ((DecisionPC)getPC()).getMontantBrutTranche2();
  }
  
  public BigDecimal getMontantBrutTranche2()
  {
    return ((DecisionPC)getPC()).getMontantBrutTranche2();
  }
  
  public void setMontantBrutTranche2(BigDecimal p_montantBrutTranche2)
  {
    if ((m_montantBrutTranche2 == null) || (p_montantBrutTranche2 == null))
    {
      m_montantBrutTranche2 = p_montantBrutTranche2;
      ((DecisionPC)getPC()).setMontantBrutTranche2(p_montantBrutTranche2);
    }
    else if ((m_montantBrutTranche2 != null) && (p_montantBrutTranche2 != null) && (!p_montantBrutTranche2.equals(m_montantBrutTranche2)))
    {
      m_montantBrutTranche2 = p_montantBrutTranche2;
      ((DecisionPC)getPC()).setMontantBrutTranche2(p_montantBrutTranche2);
    }
  }
  
  protected BigDecimal rawGetMontantCrcTranche2()
  {
    return ((DecisionPC)getPC()).getMontantCrcTranche2();
  }
  
  public BigDecimal getMontantCrcTranche2()
  {
    return ((DecisionPC)getPC()).getMontantCrcTranche2();
  }
  
  public void setMontantCrcTranche2(BigDecimal p_montantCrcTranche2)
  {
    if ((m_montantCrcTranche2 == null) || (p_montantCrcTranche2 == null))
    {
      m_montantCrcTranche2 = p_montantCrcTranche2;
      ((DecisionPC)getPC()).setMontantCrcTranche2(p_montantCrcTranche2);
    }
    else if ((m_montantCrcTranche2 != null) && (p_montantCrcTranche2 != null) && (!p_montantCrcTranche2.equals(m_montantCrcTranche2)))
    {
      m_montantCrcTranche2 = p_montantCrcTranche2;
      ((DecisionPC)getPC()).setMontantCrcTranche2(p_montantCrcTranche2);
    }
  }
  
  protected int rawGetDureeTranche2()
  {
    return ((DecisionPC)getPC()).getDureeTranche2();
  }
  
  public int getDureeTranche2()
  {
    return ((DecisionPC)getPC()).getDureeTranche2();
  }
  
  public void setDureeTranche2(int p_dureeTranche2)
  {
    ((DecisionPC)getPC()).setDureeTranche2(p_dureeTranche2);
  }
  
  protected BigDecimal rawGetMontantBrutTranche3()
  {
    return ((DecisionPC)getPC()).getMontantBrutTranche3();
  }
  
  public BigDecimal getMontantBrutTranche3()
  {
    return ((DecisionPC)getPC()).getMontantBrutTranche3();
  }
  
  public void setMontantBrutTranche3(BigDecimal p_montantBrutTranche3)
  {
    if ((m_montantBrutTranche3 == null) || (p_montantBrutTranche3 == null))
    {
      m_montantBrutTranche3 = p_montantBrutTranche3;
      ((DecisionPC)getPC()).setMontantBrutTranche3(p_montantBrutTranche3);
    }
    else if ((m_montantBrutTranche3 != null) && (p_montantBrutTranche3 != null) && (!p_montantBrutTranche3.equals(m_montantBrutTranche3)))
    {
      m_montantBrutTranche3 = p_montantBrutTranche3;
      ((DecisionPC)getPC()).setMontantBrutTranche3(p_montantBrutTranche3);
    }
  }
  
  protected BigDecimal rawGetMontantCrcTranche3()
  {
    return ((DecisionPC)getPC()).getMontantCrcTranche3();
  }
  
  public BigDecimal getMontantCrcTranche3()
  {
    return ((DecisionPC)getPC()).getMontantCrcTranche3();
  }
  
  public void setMontantCrcTranche3(BigDecimal p_montantCrcTranche3)
  {
    if ((m_montantCrcTranche3 == null) || (p_montantCrcTranche3 == null))
    {
      m_montantCrcTranche3 = p_montantCrcTranche3;
      ((DecisionPC)getPC()).setMontantCrcTranche3(p_montantCrcTranche3);
    }
    else if ((m_montantCrcTranche3 != null) && (p_montantCrcTranche3 != null) && (!p_montantCrcTranche3.equals(m_montantCrcTranche3)))
    {
      m_montantCrcTranche3 = p_montantCrcTranche3;
      ((DecisionPC)getPC()).setMontantCrcTranche3(p_montantCrcTranche3);
    }
  }
  
  protected int rawGetDureeTranche3()
  {
    return ((DecisionPC)getPC()).getDureeTranche3();
  }
  
  public int getDureeTranche3()
  {
    return ((DecisionPC)getPC()).getDureeTranche3();
  }
  
  public void setDureeTranche3(int p_dureeTranche3)
  {
    ((DecisionPC)getPC()).setDureeTranche3(p_dureeTranche3);
  }
  
  protected String rawGetValidationDAPE()
  {
    return ((DecisionPC)getPC()).getValidationDAPE();
  }
  
  public String getValidationDAPE()
  {
    return ((DecisionPC)getPC()).getValidationDAPE();
  }
  
  public void setValidationDAPE(String p_validationDAPE)
  {
    if ((m_validationDAPE == null) || (p_validationDAPE == null))
    {
      m_validationDAPE = p_validationDAPE;
      ((DecisionPC)getPC()).setValidationDAPE(p_validationDAPE);
    }
    else if ((m_validationDAPE != null) && (p_validationDAPE != null) && (!p_validationDAPE.equals(m_validationDAPE)))
    {
      m_validationDAPE = p_validationDAPE;
      ((DecisionPC)getPC()).setValidationDAPE(p_validationDAPE);
    }
  }
  
  protected String rawGetTypeActionReclassementAvant()
  {
    return ((DecisionPC)getPC()).getTypeActionReclassementAvant();
  }
  
  public String getTypeActionReclassementAvant()
  {
    return ((DecisionPC)getPC()).getTypeActionReclassementAvant();
  }
  
  public void setTypeActionReclassementAvant(String p_typeActionReclassementAvant)
  {
    if ((m_typeActionReclassementAvant == null) || (p_typeActionReclassementAvant == null))
    {
      m_typeActionReclassementAvant = p_typeActionReclassementAvant;
      ((DecisionPC)getPC()).setTypeActionReclassementAvant(p_typeActionReclassementAvant);
    }
    else if ((m_typeActionReclassementAvant != null) && (p_typeActionReclassementAvant != null) && (!p_typeActionReclassementAvant.equals(m_typeActionReclassementAvant)))
    {
      m_typeActionReclassementAvant = p_typeActionReclassementAvant;
      ((DecisionPC)getPC()).setTypeActionReclassementAvant(p_typeActionReclassementAvant);
    }
  }
  
  protected String rawGetTypeActionReclassementApres()
  {
    return ((DecisionPC)getPC()).getTypeActionReclassementApres();
  }
  
  public String getTypeActionReclassementApres()
  {
    return ((DecisionPC)getPC()).getTypeActionReclassementApres();
  }
  
  public void setTypeActionReclassementApres(String p_typeActionReclassementApres)
  {
    if ((m_typeActionReclassementApres == null) || (p_typeActionReclassementApres == null))
    {
      m_typeActionReclassementApres = p_typeActionReclassementApres;
      ((DecisionPC)getPC()).setTypeActionReclassementApres(p_typeActionReclassementApres);
    }
    else if ((m_typeActionReclassementApres != null) && (p_typeActionReclassementApres != null) && (!p_typeActionReclassementApres.equals(m_typeActionReclassementApres)))
    {
      m_typeActionReclassementApres = p_typeActionReclassementApres;
      ((DecisionPC)getPC()).setTypeActionReclassementApres(p_typeActionReclassementApres);
    }
  }
  
  protected int rawGetEstDerogatoire()
  {
    return ((DecisionPC)getPC()).getEstDerogatoire();
  }
  
  public int getEstDerogatoire()
  {
    return ((DecisionPC)getPC()).getEstDerogatoire();
  }
  
  public void setEstDerogatoire(int p_estDerogatoire)
  {
    ((DecisionPC)getPC()).setEstDerogatoire(p_estDerogatoire);
  }
  
  protected BigDecimal rawGetMontantForfaitUnitaireRepas()
  {
    return ((DecisionPC)getPC()).getMontantForfaitUnitaireRepas();
  }
  
  public BigDecimal getMontantForfaitUnitaireRepas()
  {
    return ((DecisionPC)getPC()).getMontantForfaitUnitaireRepas();
  }
  
  public void setMontantForfaitUnitaireRepas(BigDecimal p_montantForfaitUnitaireRepas)
  {
    if ((m_montantForfaitUnitaireRepas == null) || (p_montantForfaitUnitaireRepas == null))
    {
      m_montantForfaitUnitaireRepas = p_montantForfaitUnitaireRepas;
      ((DecisionPC)getPC()).setMontantForfaitUnitaireRepas(p_montantForfaitUnitaireRepas);
    }
    else if ((m_montantForfaitUnitaireRepas != null) && (p_montantForfaitUnitaireRepas != null) && (!p_montantForfaitUnitaireRepas.equals(m_montantForfaitUnitaireRepas)))
    {
      m_montantForfaitUnitaireRepas = p_montantForfaitUnitaireRepas;
      ((DecisionPC)getPC()).setMontantForfaitUnitaireRepas(p_montantForfaitUnitaireRepas);
    }
  }
  
  protected BigDecimal rawGetMontantForfaitUnitaireHebergement()
  {
    return ((DecisionPC)getPC()).getMontantForfaitUnitaireHebergement();
  }
  
  public BigDecimal getMontantForfaitUnitaireHebergement()
  {
    return ((DecisionPC)getPC()).getMontantForfaitUnitaireHebergement();
  }
  
  public void setMontantForfaitUnitaireHebergement(BigDecimal p_montantForfaitUnitaireHebergement)
  {
    if ((m_montantForfaitUnitaireHebergement == null) || (p_montantForfaitUnitaireHebergement == null))
    {
      m_montantForfaitUnitaireHebergement = p_montantForfaitUnitaireHebergement;
      ((DecisionPC)getPC()).setMontantForfaitUnitaireHebergement(p_montantForfaitUnitaireHebergement);
    }
    else if ((m_montantForfaitUnitaireHebergement != null) && (p_montantForfaitUnitaireHebergement != null) && (!p_montantForfaitUnitaireHebergement.equals(m_montantForfaitUnitaireHebergement)))
    {
      m_montantForfaitUnitaireHebergement = p_montantForfaitUnitaireHebergement;
      ((DecisionPC)getPC()).setMontantForfaitUnitaireHebergement(p_montantForfaitUnitaireHebergement);
    }
  }
  
  protected BigDecimal rawGetMontantIndiceKilometrique()
  {
    return ((DecisionPC)getPC()).getMontantIndiceKilometrique();
  }
  
  public BigDecimal getMontantIndiceKilometrique()
  {
    return ((DecisionPC)getPC()).getMontantIndiceKilometrique();
  }
  
  public void setMontantIndiceKilometrique(BigDecimal p_montantIndiceKilometrique)
  {
    if ((m_montantIndiceKilometrique == null) || (p_montantIndiceKilometrique == null))
    {
      m_montantIndiceKilometrique = p_montantIndiceKilometrique;
      ((DecisionPC)getPC()).setMontantIndiceKilometrique(p_montantIndiceKilometrique);
    }
    else if ((m_montantIndiceKilometrique != null) && (p_montantIndiceKilometrique != null) && (!p_montantIndiceKilometrique.equals(m_montantIndiceKilometrique)))
    {
      m_montantIndiceKilometrique = p_montantIndiceKilometrique;
      ((DecisionPC)getPC()).setMontantIndiceKilometrique(p_montantIndiceKilometrique);
    }
  }
  
  protected Damj rawGetDateDepotAide()
  {
    return ((DecisionPC)getPC()).getDateDepotAide();
  }
  
  public Damj getDateDepotAide()
  {
    return ((DecisionPC)getPC()).getDateDepotAide();
  }
  
  public void setDateDepotAide(Damj p_dateDepotAide)
  {
    if ((m_dateDepotAide == null) || (p_dateDepotAide == null))
    {
      m_dateDepotAide = p_dateDepotAide;
      ((DecisionPC)getPC()).setDateDepotAide(p_dateDepotAide);
    }
    else if ((m_dateDepotAide != null) && (p_dateDepotAide != null) && (!p_dateDepotAide.equals(m_dateDepotAide)))
    {
      m_dateDepotAide = p_dateDepotAide;
      ((DecisionPC)getPC()).setDateDepotAide(p_dateDepotAide);
    }
  }
  
  protected int rawGetAttenteValidationDAPE()
  {
    return ((DecisionPC)getPC()).getAttenteValidationDAPE();
  }
  
  public int getAttenteValidationDAPE()
  {
    return ((DecisionPC)getPC()).getAttenteValidationDAPE();
  }
  
  public void setAttenteValidationDAPE(int p_attenteValidationDAPE)
  {
    ((DecisionPC)getPC()).setAttenteValidationDAPE(p_attenteValidationDAPE);
  }
  
  protected int rawGetAttenteRetourJustificatif()
  {
    return ((DecisionPC)getPC()).getAttenteRetourJustificatif();
  }
  
  public int getAttenteRetourJustificatif()
  {
    return ((DecisionPC)getPC()).getAttenteRetourJustificatif();
  }
  
  public void setAttenteRetourJustificatif(int p_attenteRetourJustificatif)
  {
    ((DecisionPC)getPC()).setAttenteRetourJustificatif(p_attenteRetourJustificatif);
  }
  
  protected Damj rawGetDateRetourJustificatif()
  {
    return ((DecisionPC)getPC()).getDateRetourJustificatif();
  }
  
  public Damj getDateRetourJustificatif()
  {
    return ((DecisionPC)getPC()).getDateRetourJustificatif();
  }
  
  public void setDateRetourJustificatif(Damj p_dateRetourJustificatif)
  {
    if ((m_dateRetourJustificatif == null) || (p_dateRetourJustificatif == null))
    {
      m_dateRetourJustificatif = p_dateRetourJustificatif;
      ((DecisionPC)getPC()).setDateRetourJustificatif(p_dateRetourJustificatif);
    }
    else if ((m_dateRetourJustificatif != null) && (p_dateRetourJustificatif != null) && (!p_dateRetourJustificatif.equals(m_dateRetourJustificatif)))
    {
      m_dateRetourJustificatif = p_dateRetourJustificatif;
      ((DecisionPC)getPC()).setDateRetourJustificatif(p_dateRetourJustificatif);
    }
  }
  
  protected BigDecimal rawGetNombreEnfantsTotal()
  {
    return ((DecisionPC)getPC()).getNombreEnfantsTotal();
  }
  
  public BigDecimal getNombreEnfantsTotal()
  {
    return ((DecisionPC)getPC()).getNombreEnfantsTotal();
  }
  
  public void setNombreEnfantsTotal(BigDecimal p_nombreEnfantsTotal)
  {
    if ((m_nombreEnfantsTotal == null) || (p_nombreEnfantsTotal == null))
    {
      m_nombreEnfantsTotal = p_nombreEnfantsTotal;
      ((DecisionPC)getPC()).setNombreEnfantsTotal(p_nombreEnfantsTotal);
    }
    else if ((m_nombreEnfantsTotal != null) && (p_nombreEnfantsTotal != null) && (!p_nombreEnfantsTotal.equals(m_nombreEnfantsTotal)))
    {
      m_nombreEnfantsTotal = p_nombreEnfantsTotal;
      ((DecisionPC)getPC()).setNombreEnfantsTotal(p_nombreEnfantsTotal);
    }
  }
  
  protected String rawGetNumeroConventionGestion()
  {
    return ((DecisionPC)getPC()).getNumeroConventionGestion();
  }
  
  public String getNumeroConventionGestion()
  {
    return ((DecisionPC)getPC()).getNumeroConventionGestion();
  }
  
  public void setNumeroConventionGestion(String p_numeroConventionGestion)
  {
    if ((m_numeroConventionGestion == null) || (p_numeroConventionGestion == null))
    {
      m_numeroConventionGestion = p_numeroConventionGestion;
      ((DecisionPC)getPC()).setNumeroConventionGestion(p_numeroConventionGestion);
    }
    else if ((m_numeroConventionGestion != null) && (p_numeroConventionGestion != null) && (!p_numeroConventionGestion.equals(m_numeroConventionGestion)))
    {
      m_numeroConventionGestion = p_numeroConventionGestion;
      ((DecisionPC)getPC()).setNumeroConventionGestion(p_numeroConventionGestion);
    }
  }
  
  protected String rawGetCodeAffectation()
  {
    return ((DecisionPC)getPC()).getCodeAffectation();
  }
  
  public String getCodeAffectation()
  {
    return ((DecisionPC)getPC()).getCodeAffectation();
  }
  
  public void setCodeAffectation(String p_codeAffectation)
  {
    if ((m_codeAffectation == null) || (p_codeAffectation == null))
    {
      m_codeAffectation = p_codeAffectation;
      ((DecisionPC)getPC()).setCodeAffectation(p_codeAffectation);
    }
    else if ((m_codeAffectation != null) && (p_codeAffectation != null) && (!p_codeAffectation.equals(m_codeAffectation)))
    {
      m_codeAffectation = p_codeAffectation;
      ((DecisionPC)getPC()).setCodeAffectation(p_codeAffectation);
    }
  }
  
  protected BigDecimal rawGetMontantBonAvant()
  {
    return ((DecisionPC)getPC()).getMontantBonAvant();
  }
  
  public BigDecimal getMontantBonAvant()
  {
    return ((DecisionPC)getPC()).getMontantBonAvant();
  }
  
  public void setMontantBonAvant(BigDecimal p_montantBonAvant)
  {
    if ((m_montantBonAvant == null) || (p_montantBonAvant == null))
    {
      m_montantBonAvant = p_montantBonAvant;
      ((DecisionPC)getPC()).setMontantBonAvant(p_montantBonAvant);
    }
    else if ((m_montantBonAvant != null) && (p_montantBonAvant != null) && (!p_montantBonAvant.equals(m_montantBonAvant)))
    {
      m_montantBonAvant = p_montantBonAvant;
      ((DecisionPC)getPC()).setMontantBonAvant(p_montantBonAvant);
    }
  }
  
  protected BigDecimal rawGetMontantBonAvantDerogatoire()
  {
    return ((DecisionPC)getPC()).getMontantBonAvantDerogatoire();
  }
  
  public BigDecimal getMontantBonAvantDerogatoire()
  {
    return ((DecisionPC)getPC()).getMontantBonAvantDerogatoire();
  }
  
  public void setMontantBonAvantDerogatoire(BigDecimal p_montantBonAvantDerogatoire)
  {
    if ((m_montantBonAvantDerogatoire == null) || (p_montantBonAvantDerogatoire == null))
    {
      m_montantBonAvantDerogatoire = p_montantBonAvantDerogatoire;
      ((DecisionPC)getPC()).setMontantBonAvantDerogatoire(p_montantBonAvantDerogatoire);
    }
    else if ((m_montantBonAvantDerogatoire != null) && (p_montantBonAvantDerogatoire != null) && (!p_montantBonAvantDerogatoire.equals(m_montantBonAvantDerogatoire)))
    {
      m_montantBonAvantDerogatoire = p_montantBonAvantDerogatoire;
      ((DecisionPC)getPC()).setMontantBonAvantDerogatoire(p_montantBonAvantDerogatoire);
    }
  }
  
  protected String rawGetTypeBonAvant()
  {
    return ((DecisionPC)getPC()).getTypeBonAvant();
  }
  
  public String getTypeBonAvant()
  {
    return ((DecisionPC)getPC()).getTypeBonAvant();
  }
  
  public void setTypeBonAvant(String p_typeBonAvant)
  {
    if ((m_typeBonAvant == null) || (p_typeBonAvant == null))
    {
      m_typeBonAvant = p_typeBonAvant;
      ((DecisionPC)getPC()).setTypeBonAvant(p_typeBonAvant);
    }
    else if ((m_typeBonAvant != null) && (p_typeBonAvant != null) && (!p_typeBonAvant.equals(m_typeBonAvant)))
    {
      m_typeBonAvant = p_typeBonAvant;
      ((DecisionPC)getPC()).setTypeBonAvant(p_typeBonAvant);
    }
  }
  
  protected String rawGetTypeBonAvantDerogatoire()
  {
    return ((DecisionPC)getPC()).getTypeBonAvantDerogatoire();
  }
  
  public String getTypeBonAvantDerogatoire()
  {
    return ((DecisionPC)getPC()).getTypeBonAvantDerogatoire();
  }
  
  public void setTypeBonAvantDerogatoire(String p_typeBonAvantDerogatoire)
  {
    if ((m_typeBonAvantDerogatoire == null) || (p_typeBonAvantDerogatoire == null))
    {
      m_typeBonAvantDerogatoire = p_typeBonAvantDerogatoire;
      ((DecisionPC)getPC()).setTypeBonAvantDerogatoire(p_typeBonAvantDerogatoire);
    }
    else if ((m_typeBonAvantDerogatoire != null) && (p_typeBonAvantDerogatoire != null) && (!p_typeBonAvantDerogatoire.equals(m_typeBonAvantDerogatoire)))
    {
      m_typeBonAvantDerogatoire = p_typeBonAvantDerogatoire;
      ((DecisionPC)getPC()).setTypeBonAvantDerogatoire(p_typeBonAvantDerogatoire);
    }
  }
  
  protected BigDecimal rawGetMontantBonApres()
  {
    return ((DecisionPC)getPC()).getMontantBonApres();
  }
  
  public BigDecimal getMontantBonApres()
  {
    return ((DecisionPC)getPC()).getMontantBonApres();
  }
  
  public void setMontantBonApres(BigDecimal p_montantBonApres)
  {
    if ((m_montantBonApres == null) || (p_montantBonApres == null))
    {
      m_montantBonApres = p_montantBonApres;
      ((DecisionPC)getPC()).setMontantBonApres(p_montantBonApres);
    }
    else if ((m_montantBonApres != null) && (p_montantBonApres != null) && (!p_montantBonApres.equals(m_montantBonApres)))
    {
      m_montantBonApres = p_montantBonApres;
      ((DecisionPC)getPC()).setMontantBonApres(p_montantBonApres);
    }
  }
  
  protected BigDecimal rawGetMontantBonApresDerogatoire()
  {
    return ((DecisionPC)getPC()).getMontantBonApresDerogatoire();
  }
  
  public BigDecimal getMontantBonApresDerogatoire()
  {
    return ((DecisionPC)getPC()).getMontantBonApresDerogatoire();
  }
  
  public void setMontantBonApresDerogatoire(BigDecimal p_montantBonApresDerogatoire)
  {
    if ((m_montantBonApresDerogatoire == null) || (p_montantBonApresDerogatoire == null))
    {
      m_montantBonApresDerogatoire = p_montantBonApresDerogatoire;
      ((DecisionPC)getPC()).setMontantBonApresDerogatoire(p_montantBonApresDerogatoire);
    }
    else if ((m_montantBonApresDerogatoire != null) && (p_montantBonApresDerogatoire != null) && (!p_montantBonApresDerogatoire.equals(m_montantBonApresDerogatoire)))
    {
      m_montantBonApresDerogatoire = p_montantBonApresDerogatoire;
      ((DecisionPC)getPC()).setMontantBonApresDerogatoire(p_montantBonApresDerogatoire);
    }
  }
  
  protected String rawGetTypeBonApres()
  {
    return ((DecisionPC)getPC()).getTypeBonApres();
  }
  
  public String getTypeBonApres()
  {
    return ((DecisionPC)getPC()).getTypeBonApres();
  }
  
  public void setTypeBonApres(String p_typeBonApres)
  {
    if ((m_typeBonApres == null) || (p_typeBonApres == null))
    {
      m_typeBonApres = p_typeBonApres;
      ((DecisionPC)getPC()).setTypeBonApres(p_typeBonApres);
    }
    else if ((m_typeBonApres != null) && (p_typeBonApres != null) && (!p_typeBonApres.equals(m_typeBonApres)))
    {
      m_typeBonApres = p_typeBonApres;
      ((DecisionPC)getPC()).setTypeBonApres(p_typeBonApres);
    }
  }
  
  protected String rawGetTypebonApresDerogatoire()
  {
    return ((DecisionPC)getPC()).getTypeBonApresDerogatoire();
  }
  
  public String getTypebonApresDerogatoire()
  {
    return ((DecisionPC)getPC()).getTypeBonApresDerogatoire();
  }
  
  public void setTypebonApresDerogatoire(String p_typebonApresDerogatoire)
  {
    if ((m_typebonApresDerogatoire == null) || (p_typebonApresDerogatoire == null))
    {
      m_typebonApresDerogatoire = p_typebonApresDerogatoire;
      ((DecisionPC)getPC()).setTypeBonApresDerogatoire(p_typebonApresDerogatoire);
    }
    else if ((m_typebonApresDerogatoire != null) && (p_typebonApresDerogatoire != null) && (!p_typebonApresDerogatoire.equals(m_typebonApresDerogatoire)))
    {
      m_typebonApresDerogatoire = p_typebonApresDerogatoire;
      ((DecisionPC)getPC()).setTypeBonApresDerogatoire(p_typebonApresDerogatoire);
    }
  }
  
  protected int rawGetObjectifLiquidation()
  {
    return ((DecisionPC)getPC()).getObjectifLiquidation();
  }
  
  public int getObjectifLiquidation()
  {
    return ((DecisionPC)getPC()).getObjectifLiquidation();
  }
  
  public void setObjectifLiquidation(int p_objectifLiquidation)
  {
    ((DecisionPC)getPC()).setObjectifLiquidation(p_objectifLiquidation);
  }
  
  protected BigDecimal rawGetDureePostPrime()
  {
    return ((DecisionPC)getPC()).getDureePostPrime();
  }
  
  public BigDecimal getDureePostPrime()
  {
    return ((DecisionPC)getPC()).getDureePostPrime();
  }
  
  public void setDureePostPrime(BigDecimal p_dureePostPrime)
  {
    if ((m_dureePostPrime == null) || (p_dureePostPrime == null))
    {
      m_dureePostPrime = p_dureePostPrime;
      ((DecisionPC)getPC()).setDureePostPrime(p_dureePostPrime);
    }
    else if ((m_dureePostPrime != null) && (p_dureePostPrime != null) && (!p_dureePostPrime.equals(m_dureePostPrime)))
    {
      m_dureePostPrime = p_dureePostPrime;
      ((DecisionPC)getPC()).setDureePostPrime(p_dureePostPrime);
    }
  }
  
  protected String rawGetIndicateurPremiereDemandePostPrime()
  {
    return ((DecisionPC)getPC()).getIndicateurPremiereDemandePostPrime();
  }
  
  public String getIndicateurPremiereDemandePostPrime()
  {
    return ((DecisionPC)getPC()).getIndicateurPremiereDemandePostPrime();
  }
  
  public void setIndicateurPremiereDemandePostPrime(String p_indicateurPremiereDemandePostPrime)
  {
    if ((m_indicateurPremiereDemandePostPrime == null) || (p_indicateurPremiereDemandePostPrime == null))
    {
      m_indicateurPremiereDemandePostPrime = p_indicateurPremiereDemandePostPrime;
      ((DecisionPC)getPC()).setIndicateurPremiereDemandePostPrime(p_indicateurPremiereDemandePostPrime);
    }
    else if ((m_indicateurPremiereDemandePostPrime != null) && (p_indicateurPremiereDemandePostPrime != null) && (!p_indicateurPremiereDemandePostPrime.equals(m_indicateurPremiereDemandePostPrime)))
    {
      m_indicateurPremiereDemandePostPrime = p_indicateurPremiereDemandePostPrime;
      ((DecisionPC)getPC()).setIndicateurPremiereDemandePostPrime(p_indicateurPremiereDemandePostPrime);
    }
  }
  
  protected String rawGetIndicateurDiminutionMontantCSP()
  {
    return ((DecisionPC)getPC()).getIndicateurDiminutionMontantCSP();
  }
  
  public String getIndicateurDiminutionMontantCSP()
  {
    return ((DecisionPC)getPC()).getIndicateurDiminutionMontantCSP();
  }
  
  public void setIndicateurDiminutionMontantCSP(String p_indicateurDiminutionMontantCSP)
  {
    if ((m_indicateurDiminutionMontantCSP == null) || (p_indicateurDiminutionMontantCSP == null))
    {
      m_indicateurDiminutionMontantCSP = p_indicateurDiminutionMontantCSP;
      ((DecisionPC)getPC()).setIndicateurDiminutionMontantCSP(p_indicateurDiminutionMontantCSP);
    }
    else if ((m_indicateurDiminutionMontantCSP != null) && (p_indicateurDiminutionMontantCSP != null) && (!p_indicateurDiminutionMontantCSP.equals(m_indicateurDiminutionMontantCSP)))
    {
      m_indicateurDiminutionMontantCSP = p_indicateurDiminutionMontantCSP;
      ((DecisionPC)getPC()).setIndicateurDiminutionMontantCSP(p_indicateurDiminutionMontantCSP);
    }
  }
  
  protected String rawGetIndicateurAllongementDureeCSP()
  {
    return ((DecisionPC)getPC()).getIndicateurAllongementDureeCSP();
  }
  
  public String getIndicateurAllongementDureeCSP()
  {
    return ((DecisionPC)getPC()).getIndicateurAllongementDureeCSP();
  }
  
  public void setIndicateurAllongementDureeCSP(String p_indicateurAllongementDureeCSP)
  {
    if ((m_indicateurAllongementDureeCSP == null) || (p_indicateurAllongementDureeCSP == null))
    {
      m_indicateurAllongementDureeCSP = p_indicateurAllongementDureeCSP;
      ((DecisionPC)getPC()).setIndicateurAllongementDureeCSP(p_indicateurAllongementDureeCSP);
    }
    else if ((m_indicateurAllongementDureeCSP != null) && (p_indicateurAllongementDureeCSP != null) && (!p_indicateurAllongementDureeCSP.equals(m_indicateurAllongementDureeCSP)))
    {
      m_indicateurAllongementDureeCSP = p_indicateurAllongementDureeCSP;
      ((DecisionPC)getPC()).setIndicateurAllongementDureeCSP(p_indicateurAllongementDureeCSP);
    }
  }
  
  protected Damj rawGetDateDepartDelai121j()
  {
    return ((DecisionPC)getPC()).getDateDepartDelai121j();
  }
  
  public Damj getDateDepartDelai121j()
  {
    return ((DecisionPC)getPC()).getDateDepartDelai121j();
  }
  
  public void setDateDepartDelai121j(Damj p_dateDepartDelai121j)
  {
    if ((m_dateDepartDelai121j == null) || (p_dateDepartDelai121j == null))
    {
      m_dateDepartDelai121j = p_dateDepartDelai121j;
      ((DecisionPC)getPC()).setDateDepartDelai121j(p_dateDepartDelai121j);
    }
    else if ((m_dateDepartDelai121j != null) && (p_dateDepartDelai121j != null) && (!p_dateDepartDelai121j.equals(m_dateDepartDelai121j)))
    {
      m_dateDepartDelai121j = p_dateDepartDelai121j;
      ((DecisionPC)getPC()).setDateDepartDelai121j(p_dateDepartDelai121j);
    }
  }
  
  protected Damj rawGetDateDebutDernierDelaiAttente()
  {
    return ((DecisionPC)getPC()).getDateDebutDernierDelaiAttente();
  }
  
  public Damj getDateDebutDernierDelaiAttente()
  {
    return ((DecisionPC)getPC()).getDateDebutDernierDelaiAttente();
  }
  
  public void setDateDebutDernierDelaiAttente(Damj p_dateDebutDernierDelaiAttente)
  {
    if ((m_dateDebutDernierDelaiAttente == null) || (p_dateDebutDernierDelaiAttente == null))
    {
      m_dateDebutDernierDelaiAttente = p_dateDebutDernierDelaiAttente;
      ((DecisionPC)getPC()).setDateDebutDernierDelaiAttente(p_dateDebutDernierDelaiAttente);
    }
    else if ((m_dateDebutDernierDelaiAttente != null) && (p_dateDebutDernierDelaiAttente != null) && (!p_dateDebutDernierDelaiAttente.equals(m_dateDebutDernierDelaiAttente)))
    {
      m_dateDebutDernierDelaiAttente = p_dateDebutDernierDelaiAttente;
      ((DecisionPC)getPC()).setDateDebutDernierDelaiAttente(p_dateDebutDernierDelaiAttente);
    }
  }
  
  protected Damj rawGetDateIDE()
  {
    return ((DecisionPC)getPC()).getDateIDE();
  }
  
  public Damj getDateIDE()
  {
    return ((DecisionPC)getPC()).getDateIDE();
  }
  
  public void setDateIDE(Damj p_dateIDE)
  {
    if ((m_dateIDE == null) || (p_dateIDE == null))
    {
      m_dateIDE = p_dateIDE;
      ((DecisionPC)getPC()).setDateIDE(p_dateIDE);
    }
    else if ((m_dateIDE != null) && (p_dateIDE != null) && (!p_dateIDE.equals(m_dateIDE)))
    {
      m_dateIDE = p_dateIDE;
      ((DecisionPC)getPC()).setDateIDE(p_dateIDE);
    }
  }
  
  protected Damj rawGetDateFaitGenerateurDroitPrecedent()
  {
    return ((DecisionPC)getPC()).getDateFaitGenerateurDroitPrecedent();
  }
  
  public Damj getDateFaitGenerateurDroitPrecedent()
  {
    return ((DecisionPC)getPC()).getDateFaitGenerateurDroitPrecedent();
  }
  
  public void setDateFaitGenerateurDroitPrecedent(Damj p_dateFaitGenerateurDroitPrecedent)
  {
    if ((m_dateFaitGenerateurDroitPrecedent == null) || (p_dateFaitGenerateurDroitPrecedent == null))
    {
      m_dateFaitGenerateurDroitPrecedent = p_dateFaitGenerateurDroitPrecedent;
      ((DecisionPC)getPC()).setDateFaitGenerateurDroitPrecedent(p_dateFaitGenerateurDroitPrecedent);
    }
    else if ((m_dateFaitGenerateurDroitPrecedent != null) && (p_dateFaitGenerateurDroitPrecedent != null) && (!p_dateFaitGenerateurDroitPrecedent.equals(m_dateFaitGenerateurDroitPrecedent)))
    {
      m_dateFaitGenerateurDroitPrecedent = p_dateFaitGenerateurDroitPrecedent;
      ((DecisionPC)getPC()).setDateFaitGenerateurDroitPrecedent(p_dateFaitGenerateurDroitPrecedent);
    }
  }
  
  protected String rawGetReglementApplicableDroit()
  {
    return ((DecisionPC)getPC()).getReglementApplicableDroit();
  }
  
  public String getReglementApplicableDroit()
  {
    return ((DecisionPC)getPC()).getReglementApplicableDroit();
  }
  
  public void setReglementApplicableDroit(String p_reglementApplicableDroit)
  {
    if ((m_reglementApplicableDroit == null) || (p_reglementApplicableDroit == null))
    {
      m_reglementApplicableDroit = p_reglementApplicableDroit;
      ((DecisionPC)getPC()).setReglementApplicableDroit(p_reglementApplicableDroit);
    }
    else if ((m_reglementApplicableDroit != null) && (p_reglementApplicableDroit != null) && (!p_reglementApplicableDroit.equals(m_reglementApplicableDroit)))
    {
      m_reglementApplicableDroit = p_reglementApplicableDroit;
      ((DecisionPC)getPC()).setReglementApplicableDroit(p_reglementApplicableDroit);
    }
  }
  
  protected int rawGetDureeActiviteEmployeursRAC()
  {
    return ((DecisionPC)getPC()).getDureeActiviteEmployeursRAC();
  }
  
  public int getDureeActiviteEmployeursRAC()
  {
    return ((DecisionPC)getPC()).getDureeActiviteEmployeursRAC();
  }
  
  public void setDureeActiviteEmployeursRAC(int p_dureeActiviteEmployeursRAC)
  {
    ((DecisionPC)getPC()).setDureeActiviteEmployeursRAC(p_dureeActiviteEmployeursRAC);
  }
  
  protected int rawGetCoeffTPAppliqueRAC()
  {
    return ((DecisionPC)getPC()).getCoeffTPAppliqueRAC();
  }
  
  public int getCoeffTPAppliqueRAC()
  {
    return ((DecisionPC)getPC()).getCoeffTPAppliqueRAC();
  }
  
  public void setCoeffTPAppliqueRAC(int p_coeffTPAppliqueRAC)
  {
    ((DecisionPC)getPC()).setCoeffTPAppliqueRAC(p_coeffTPAppliqueRAC);
  }
  
  protected int rawGetDureeActiviteEmployeursSP()
  {
    return ((DecisionPC)getPC()).getDureeActiviteEmployeursSP();
  }
  
  public int getDureeActiviteEmployeursSP()
  {
    return ((DecisionPC)getPC()).getDureeActiviteEmployeursSP();
  }
  
  public void setDureeActiviteEmployeursSP(int p_dureeActiviteEmployeursSP)
  {
    ((DecisionPC)getPC()).setDureeActiviteEmployeursSP(p_dureeActiviteEmployeursSP);
  }
  
  protected int rawGetCoeffTPAppliqueSP()
  {
    return ((DecisionPC)getPC()).getCoeffTPAppliqueSP();
  }
  
  public int getCoeffTPAppliqueSP()
  {
    return ((DecisionPC)getPC()).getCoeffTPAppliqueSP();
  }
  
  public void setCoeffTPAppliqueSP(int p_coeffTPAppliqueSP)
  {
    ((DecisionPC)getPC()).setCoeffTPAppliqueSP(p_coeffTPAppliqueSP);
  }
  
  protected int rawGetTopDemandeASSSuiteDecheance()
  {
    return ((DecisionPC)getPC()).getTopDemandeASSSuiteDecheance();
  }
  
  public int getTopDemandeASSSuiteDecheance()
  {
    return ((DecisionPC)getPC()).getTopDemandeASSSuiteDecheance();
  }
  
  public void setTopDemandeASSSuiteDecheance(int p_topDemandeASSSuiteDecheance)
  {
    ((DecisionPC)getPC()).setTopDemandeASSSuiteDecheance(p_topDemandeASSSuiteDecheance);
  }
  
  protected String rawGetAttenteBlocageLiquidationAutoRepriseAss()
  {
    return ((DecisionPC)getPC()).getAttenteBlocageLiquidationAutoRepriseAss();
  }
  
  public String getAttenteBlocageLiquidationAutoRepriseAss()
  {
    return ((DecisionPC)getPC()).getAttenteBlocageLiquidationAutoRepriseAss();
  }
  
  public void setAttenteBlocageLiquidationAutoRepriseAss(String p_attenteBlocageLiquidationAutoRepriseAss)
  {
    if ((m_attenteBlocageLiquidationAutoRepriseAss == null) || (p_attenteBlocageLiquidationAutoRepriseAss == null))
    {
      m_attenteBlocageLiquidationAutoRepriseAss = p_attenteBlocageLiquidationAutoRepriseAss;
      ((DecisionPC)getPC()).setAttenteBlocageLiquidationAutoRepriseAss(p_attenteBlocageLiquidationAutoRepriseAss);
    }
    else if ((m_attenteBlocageLiquidationAutoRepriseAss != null) && (p_attenteBlocageLiquidationAutoRepriseAss != null) && (!p_attenteBlocageLiquidationAutoRepriseAss.equals(m_attenteBlocageLiquidationAutoRepriseAss)))
    {
      m_attenteBlocageLiquidationAutoRepriseAss = p_attenteBlocageLiquidationAutoRepriseAss;
      ((DecisionPC)getPC()).setAttenteBlocageLiquidationAutoRepriseAss(p_attenteBlocageLiquidationAutoRepriseAss);
    }
  }
  
  protected String rawGetAttenteNationaliteAValider()
  {
    return ((DecisionPC)getPC()).getAttenteNationaliteAValider();
  }
  
  public String getAttenteNationaliteAValider()
  {
    return ((DecisionPC)getPC()).getAttenteNationaliteAValider();
  }
  
  public void setAttenteNationaliteAValider(String p_attenteNationaliteAValider)
  {
    if ((m_attenteNationaliteAValider == null) || (p_attenteNationaliteAValider == null))
    {
      m_attenteNationaliteAValider = p_attenteNationaliteAValider;
      ((DecisionPC)getPC()).setAttenteNationaliteAValider(p_attenteNationaliteAValider);
    }
    else if ((m_attenteNationaliteAValider != null) && (p_attenteNationaliteAValider != null) && (!p_attenteNationaliteAValider.equals(m_attenteNationaliteAValider)))
    {
      m_attenteNationaliteAValider = p_attenteNationaliteAValider;
      ((DecisionPC)getPC()).setAttenteNationaliteAValider(p_attenteNationaliteAValider);
    }
  }
  
  protected int rawGetTopDetectionClauseRattrapage()
  {
    return ((DecisionPC)getPC()).getTopDetectionClauseRattrapage();
  }
  
  public int getTopDetectionClauseRattrapage()
  {
    return ((DecisionPC)getPC()).getTopDetectionClauseRattrapage();
  }
  
  public void setTopDetectionClauseRattrapage(int p_topDetectionClauseRattrapage)
  {
    ((DecisionPC)getPC()).setTopDetectionClauseRattrapage(p_topDetectionClauseRattrapage);
  }
  
  protected int rawGetTopSpectacle2016avantMepSI4()
  {
    return ((DecisionPC)getPC()).getTopSpectacle2016avantMepSI4();
  }
  
  public int getTopSpectacle2016avantMepSI4()
  {
    return ((DecisionPC)getPC()).getTopSpectacle2016avantMepSI4();
  }
  
  public void setTopSpectacle2016avantMepSI4(int p_topSpectacle2016avantMepSI4)
  {
    ((DecisionPC)getPC()).setTopSpectacle2016avantMepSI4(p_topSpectacle2016avantMepSI4);
  }
  
  protected int rawGetTopAreSpectacleEnCoursClauseRattrapage()
  {
    return ((DecisionPC)getPC()).getTopAreSpectacleEnCoursClauseRattrapage();
  }
  
  public int getTopAreSpectacleEnCoursClauseRattrapage()
  {
    return ((DecisionPC)getPC()).getTopAreSpectacleEnCoursClauseRattrapage();
  }
  
  public void setTopAreSpectacleEnCoursClauseRattrapage(int p_topAreSpectacleEnCoursClauseRattrapage)
  {
    ((DecisionPC)getPC()).setTopAreSpectacleEnCoursClauseRattrapage(p_topAreSpectacleEnCoursClauseRattrapage);
  }
  
  protected BigDecimal rawGetNombreJoursFranchiseCP()
  {
    return ((DecisionPC)getPC()).getNombreJoursFranchiseCP();
  }
  
  public BigDecimal getNombreJoursFranchiseCP()
  {
    return ((DecisionPC)getPC()).getNombreJoursFranchiseCP();
  }
  
  public void setNombreJoursFranchiseCP(BigDecimal p_nombreJoursFranchiseCP)
  {
    if ((m_nombreJoursFranchiseCP == null) || (p_nombreJoursFranchiseCP == null))
    {
      m_nombreJoursFranchiseCP = p_nombreJoursFranchiseCP;
      ((DecisionPC)getPC()).setNombreJoursFranchiseCP(p_nombreJoursFranchiseCP);
    }
    else if ((m_nombreJoursFranchiseCP != null) && (p_nombreJoursFranchiseCP != null) && (!p_nombreJoursFranchiseCP.equals(m_nombreJoursFranchiseCP)))
    {
      m_nombreJoursFranchiseCP = p_nombreJoursFranchiseCP;
      ((DecisionPC)getPC()).setNombreJoursFranchiseCP(p_nombreJoursFranchiseCP);
    }
  }
  
  protected BigDecimal rawGetNombreJoursFranchiseSalaire()
  {
    return ((DecisionPC)getPC()).getNombreJoursFranchiseSalaire();
  }
  
  public BigDecimal getNombreJoursFranchiseSalaire()
  {
    return ((DecisionPC)getPC()).getNombreJoursFranchiseSalaire();
  }
  
  public void setNombreJoursFranchiseSalaire(BigDecimal p_nombreJoursFranchiseSalaire)
  {
    if ((m_nombreJoursFranchiseSalaire == null) || (p_nombreJoursFranchiseSalaire == null))
    {
      m_nombreJoursFranchiseSalaire = p_nombreJoursFranchiseSalaire;
      ((DecisionPC)getPC()).setNombreJoursFranchiseSalaire(p_nombreJoursFranchiseSalaire);
    }
    else if ((m_nombreJoursFranchiseSalaire != null) && (p_nombreJoursFranchiseSalaire != null) && (!p_nombreJoursFranchiseSalaire.equals(m_nombreJoursFranchiseSalaire)))
    {
      m_nombreJoursFranchiseSalaire = p_nombreJoursFranchiseSalaire;
      ((DecisionPC)getPC()).setNombreJoursFranchiseSalaire(p_nombreJoursFranchiseSalaire);
    }
  }
  
  protected int rawGetFranchiseCpMensuelle()
  {
    return ((DecisionPC)getPC()).getFranchiseCpMensuelle();
  }
  
  public int getFranchiseCpMensuelle()
  {
    return ((DecisionPC)getPC()).getFranchiseCpMensuelle();
  }
  
  public void setFranchiseCpMensuelle(int p_franchiseCpMensuelle)
  {
    ((DecisionPC)getPC()).setFranchiseCpMensuelle(p_franchiseCpMensuelle);
  }
  
  protected int rawGetFranchiseSalaireMensuelle()
  {
    return ((DecisionPC)getPC()).getFranchiseSalaireMensuelle();
  }
  
  public int getFranchiseSalaireMensuelle()
  {
    return ((DecisionPC)getPC()).getFranchiseSalaireMensuelle();
  }
  
  public void setFranchiseSalaireMensuelle(int p_franchiseSalaireMensuelle)
  {
    ((DecisionPC)getPC()).setFranchiseSalaireMensuelle(p_franchiseSalaireMensuelle);
  }
  
  protected BigDecimal rawGetBaseCalculFranchiseCP()
  {
    return ((DecisionPC)getPC()).getBaseCalculFranchiseCP();
  }
  
  public BigDecimal getBaseCalculFranchiseCP()
  {
    return ((DecisionPC)getPC()).getBaseCalculFranchiseCP();
  }
  
  public void setBaseCalculFranchiseCP(BigDecimal p_baseCalculFranchiseCP)
  {
    if ((m_baseCalculFranchiseCP == null) || (p_baseCalculFranchiseCP == null))
    {
      m_baseCalculFranchiseCP = p_baseCalculFranchiseCP;
      ((DecisionPC)getPC()).setBaseCalculFranchiseCP(p_baseCalculFranchiseCP);
    }
    else if ((m_baseCalculFranchiseCP != null) && (p_baseCalculFranchiseCP != null) && (!p_baseCalculFranchiseCP.equals(m_baseCalculFranchiseCP)))
    {
      m_baseCalculFranchiseCP = p_baseCalculFranchiseCP;
      ((DecisionPC)getPC()).setBaseCalculFranchiseCP(p_baseCalculFranchiseCP);
    }
  }
  
  protected BigDecimal rawGetBaseCalculFranchiseSalaire()
  {
    return ((DecisionPC)getPC()).getBaseCalculFranchiseSalaire();
  }
  
  public BigDecimal getBaseCalculFranchiseSalaire()
  {
    return ((DecisionPC)getPC()).getBaseCalculFranchiseSalaire();
  }
  
  public void setBaseCalculFranchiseSalaire(BigDecimal p_baseCalculFranchiseSalaire)
  {
    if ((m_baseCalculFranchiseSalaire == null) || (p_baseCalculFranchiseSalaire == null))
    {
      m_baseCalculFranchiseSalaire = p_baseCalculFranchiseSalaire;
      ((DecisionPC)getPC()).setBaseCalculFranchiseSalaire(p_baseCalculFranchiseSalaire);
    }
    else if ((m_baseCalculFranchiseSalaire != null) && (p_baseCalculFranchiseSalaire != null) && (!p_baseCalculFranchiseSalaire.equals(m_baseCalculFranchiseSalaire)))
    {
      m_baseCalculFranchiseSalaire = p_baseCalculFranchiseSalaire;
      ((DecisionPC)getPC()).setBaseCalculFranchiseSalaire(p_baseCalculFranchiseSalaire);
    }
  }
  
  protected int rawGetAttenteIncoherenceSalaireNPDE()
  {
    return ((DecisionPC)getPC()).getAttenteIncoherenceSalaireNPDE();
  }
  
  public int getAttenteIncoherenceSalaireNPDE()
  {
    return ((DecisionPC)getPC()).getAttenteIncoherenceSalaireNPDE();
  }
  
  public void setAttenteIncoherenceSalaireNPDE(int p_attenteIncoherenceSalaireNPDE)
  {
    ((DecisionPC)getPC()).setAttenteIncoherenceSalaireNPDE(p_attenteIncoherenceSalaireNPDE);
  }
  
  protected BigDecimal rawGetIdentifiantPeriodeIncoherenceSalaireNPDE()
  {
    return ((DecisionPC)getPC()).getIdentifiantPeriodeIncoherenceSalaireNPDE();
  }
  
  public BigDecimal getIdentifiantPeriodeIncoherenceSalaireNPDE()
  {
    return ((DecisionPC)getPC()).getIdentifiantPeriodeIncoherenceSalaireNPDE();
  }
  
  public void setIdentifiantPeriodeIncoherenceSalaireNPDE(BigDecimal p_identifiantPeriodeIncoherenceSalaireNPDE)
  {
    if ((m_identifiantPeriodeIncoherenceSalaireNPDE == null) || (p_identifiantPeriodeIncoherenceSalaireNPDE == null))
    {
      m_identifiantPeriodeIncoherenceSalaireNPDE = p_identifiantPeriodeIncoherenceSalaireNPDE;
      ((DecisionPC)getPC()).setIdentifiantPeriodeIncoherenceSalaireNPDE(p_identifiantPeriodeIncoherenceSalaireNPDE);
    }
    else if ((m_identifiantPeriodeIncoherenceSalaireNPDE != null) && (p_identifiantPeriodeIncoherenceSalaireNPDE != null) && (!p_identifiantPeriodeIncoherenceSalaireNPDE.equals(m_identifiantPeriodeIncoherenceSalaireNPDE)))
    {
      m_identifiantPeriodeIncoherenceSalaireNPDE = p_identifiantPeriodeIncoherenceSalaireNPDE;
      ((DecisionPC)getPC()).setIdentifiantPeriodeIncoherenceSalaireNPDE(p_identifiantPeriodeIncoherenceSalaireNPDE);
    }
  }
  
  protected int rawGetEstPresencePNDS()
  {
    return ((DecisionPC)getPC()).getEstPresencePNDS();
  }
  
  public int getEstPresencePNDS()
  {
    return ((DecisionPC)getPC()).getEstPresencePNDS();
  }
  
  public void setEstPresencePNDS(int p_estPresencePNDS)
  {
    ((DecisionPC)getPC()).setEstPresencePNDS(p_estPresencePNDS);
  }
  
  protected boolean rawIsPresenceDerniersSalaires()
  {
    return ((DecisionPC)getPC()).isPresenceDerniersSalaires();
  }
  
  public boolean isPresenceDerniersSalaires()
  {
    return ((DecisionPC)getPC()).isPresenceDerniersSalaires();
  }
  
  public void setPresenceDerniersSalaires(boolean p_presenceDerniersSalaires)
  {
    ((DecisionPC)getPC()).setPresenceDerniersSalaires(p_presenceDerniersSalaires);
  }
  
  protected BigDecimal rawGetNombreMoisPreavis()
  {
    return ((DecisionPC)getPC()).getNombreMoisPreavis();
  }
  
  public BigDecimal getNombreMoisPreavis()
  {
    return ((DecisionPC)getPC()).getNombreMoisPreavis();
  }
  
  public void setNombreMoisPreavis(BigDecimal p_nombreMoisPreavis)
  {
    if ((m_nombreMoisPreavis == null) || (p_nombreMoisPreavis == null))
    {
      m_nombreMoisPreavis = p_nombreMoisPreavis;
      ((DecisionPC)getPC()).setNombreMoisPreavis(p_nombreMoisPreavis);
    }
    else if ((m_nombreMoisPreavis != null) && (p_nombreMoisPreavis != null) && (!p_nombreMoisPreavis.equals(m_nombreMoisPreavis)))
    {
      m_nombreMoisPreavis = p_nombreMoisPreavis;
      ((DecisionPC)getPC()).setNombreMoisPreavis(p_nombreMoisPreavis);
    }
  }
  
  protected String rawGetCodeSousProduitRejet()
  {
    return ((DecisionPC)getPC()).getCodeSousProduitRejet();
  }
  
  public String getCodeSousProduitRejet()
  {
    return ((DecisionPC)getPC()).getCodeSousProduitRejet();
  }
  
  public void setCodeSousProduitRejet(String p_codeSousProduitRejet)
  {
    if ((m_codeSousProduitRejet == null) || (p_codeSousProduitRejet == null))
    {
      m_codeSousProduitRejet = p_codeSousProduitRejet;
      ((DecisionPC)getPC()).setCodeSousProduitRejet(p_codeSousProduitRejet);
    }
    else if ((m_codeSousProduitRejet != null) && (p_codeSousProduitRejet != null) && (!p_codeSousProduitRejet.equals(m_codeSousProduitRejet)))
    {
      m_codeSousProduitRejet = p_codeSousProduitRejet;
      ((DecisionPC)getPC()).setCodeSousProduitRejet(p_codeSousProduitRejet);
    }
  }
  
  protected BigDecimal rawGetIdentifiantPeriodeIncoherenceRessortissant()
  {
    return ((DecisionPC)getPC()).getIdentifiantPeriodeIncoherenceRessortissant();
  }
  
  public BigDecimal getIdentifiantPeriodeIncoherenceRessortissant()
  {
    return ((DecisionPC)getPC()).getIdentifiantPeriodeIncoherenceRessortissant();
  }
  
  public void setIdentifiantPeriodeIncoherenceRessortissant(BigDecimal p_identifiantPeriodeIncoherenceRessortissant)
  {
    if ((m_identifiantPeriodeIncoherenceRessortissant == null) || (p_identifiantPeriodeIncoherenceRessortissant == null))
    {
      m_identifiantPeriodeIncoherenceRessortissant = p_identifiantPeriodeIncoherenceRessortissant;
      ((DecisionPC)getPC()).setIdentifiantPeriodeIncoherenceRessortissant(p_identifiantPeriodeIncoherenceRessortissant);
    }
    else if ((m_identifiantPeriodeIncoherenceRessortissant != null) && (p_identifiantPeriodeIncoherenceRessortissant != null) && (!p_identifiantPeriodeIncoherenceRessortissant.equals(m_identifiantPeriodeIncoherenceRessortissant)))
    {
      m_identifiantPeriodeIncoherenceRessortissant = p_identifiantPeriodeIncoherenceRessortissant;
      ((DecisionPC)getPC()).setIdentifiantPeriodeIncoherenceRessortissant(p_identifiantPeriodeIncoherenceRessortissant);
    }
  }
  
  protected int rawGetDureeAllongementArefPossible()
  {
    return ((DecisionPC)getPC()).getDureeAllongementArefPossible();
  }
  
  public int getDureeAllongementArefPossible()
  {
    return ((DecisionPC)getPC()).getDureeAllongementArefPossible();
  }
  
  public void setDureeAllongementArefPossible(int p_dureeAllongementArefPossible)
  {
    ((DecisionPC)getPC()).setDureeAllongementArefPossible(p_dureeAllongementArefPossible);
  }
  
  protected int rawGetDureeAllongementArefRealisee()
  {
    return ((DecisionPC)getPC()).getDureeAllongementArefRealisee();
  }
  
  public int getDureeAllongementArefRealisee()
  {
    return ((DecisionPC)getPC()).getDureeAllongementArefRealisee();
  }
  
  public void setDureeAllongementArefRealisee(int p_dureeAllongementArefRealisee)
  {
    ((DecisionPC)getPC()).setDureeAllongementArefRealisee(p_dureeAllongementArefRealisee);
  }
  
  protected BigDecimal rawGetCoefficientReducteurSJR()
  {
    return ((DecisionPC)getPC()).getCoefficientReducteurSJR();
  }
  
  public BigDecimal getCoefficientReducteurSJR()
  {
    return ((DecisionPC)getPC()).getCoefficientReducteurSJR();
  }
  
  public void setCoefficientReducteurSJR(BigDecimal p_coefficientReducteurSJR)
  {
    if ((m_coefficientReducteurSJR == null) || (p_coefficientReducteurSJR == null))
    {
      m_coefficientReducteurSJR = p_coefficientReducteurSJR;
      ((DecisionPC)getPC()).setCoefficientReducteurSJR(p_coefficientReducteurSJR);
    }
    else if ((m_coefficientReducteurSJR != null) && (p_coefficientReducteurSJR != null) && (!p_coefficientReducteurSJR.equals(m_coefficientReducteurSJR)))
    {
      m_coefficientReducteurSJR = p_coefficientReducteurSJR;
      ((DecisionPC)getPC()).setCoefficientReducteurSJR(p_coefficientReducteurSJR);
    }
  }
  
  protected BigDecimal rawGetPlancherCoefReducteur()
  {
    return ((DecisionPC)getPC()).getPlancherCoefReducteur();
  }
  
  public BigDecimal getPlancherCoefReducteur()
  {
    return ((DecisionPC)getPC()).getPlancherCoefReducteur();
  }
  
  public void setPlancherCoefReducteur(BigDecimal p_plancherCoefReducteur)
  {
    if ((m_plancherCoefReducteur == null) || (p_plancherCoefReducteur == null))
    {
      m_plancherCoefReducteur = p_plancherCoefReducteur;
      ((DecisionPC)getPC()).setPlancherCoefReducteur(p_plancherCoefReducteur);
    }
    else if ((m_plancherCoefReducteur != null) && (p_plancherCoefReducteur != null) && (!p_plancherCoefReducteur.equals(m_plancherCoefReducteur)))
    {
      m_plancherCoefReducteur = p_plancherCoefReducteur;
      ((DecisionPC)getPC()).setPlancherCoefReducteur(p_plancherCoefReducteur);
    }
  }
  
  protected String rawGetTopPresenceDiffereARCE()
  {
    return ((DecisionPC)getPC()).getTopPresenceDiffereARCE();
  }
  
  public String getTopPresenceDiffereARCE()
  {
    return ((DecisionPC)getPC()).getTopPresenceDiffereARCE();
  }
  
  public void setTopPresenceDiffereARCE(String p_topPresenceDiffereARCE)
  {
    if ((m_topPresenceDiffereARCE == null) || (p_topPresenceDiffereARCE == null))
    {
      m_topPresenceDiffereARCE = p_topPresenceDiffereARCE;
      ((DecisionPC)getPC()).setTopPresenceDiffereARCE(p_topPresenceDiffereARCE);
    }
    else if ((m_topPresenceDiffereARCE != null) && (p_topPresenceDiffereARCE != null) && (!p_topPresenceDiffereARCE.equals(m_topPresenceDiffereARCE)))
    {
      m_topPresenceDiffereARCE = p_topPresenceDiffereARCE;
      ((DecisionPC)getPC()).setTopPresenceDiffereARCE(p_topPresenceDiffereARCE);
    }
  }
  
  protected BigDecimal rawGetDiviseurIslr()
  {
    return ((DecisionPC)getPC()).getDiviseurIslr();
  }
  
  public BigDecimal getDiviseurIslr()
  {
    return ((DecisionPC)getPC()).getDiviseurIslr();
  }
  
  public void setDiviseurIslr(BigDecimal p_diviseurIslr)
  {
    if ((m_diviseurIslr == null) || (p_diviseurIslr == null))
    {
      m_diviseurIslr = p_diviseurIslr;
      ((DecisionPC)getPC()).setDiviseurIslr(p_diviseurIslr);
    }
    else if ((m_diviseurIslr != null) && (p_diviseurIslr != null) && (!p_diviseurIslr.equals(m_diviseurIslr)))
    {
      m_diviseurIslr = p_diviseurIslr;
      ((DecisionPC)getPC()).setDiviseurIslr(p_diviseurIslr);
    }
  }
  
  protected Damj rawGetDateFinPeriodeSuspensive()
  {
    return ((DecisionPC)getPC()).getDateFinPeriodeSuspensive();
  }
  
  public Damj getDateFinPeriodeSuspensive()
  {
    return ((DecisionPC)getPC()).getDateFinPeriodeSuspensive();
  }
  
  public void setDateFinPeriodeSuspensive(Damj p_dateFinPeriodeSuspensive)
  {
    if ((m_dateFinPeriodeSuspensive == null) || (p_dateFinPeriodeSuspensive == null))
    {
      m_dateFinPeriodeSuspensive = p_dateFinPeriodeSuspensive;
      ((DecisionPC)getPC()).setDateFinPeriodeSuspensive(p_dateFinPeriodeSuspensive);
    }
    else if ((m_dateFinPeriodeSuspensive != null) && (p_dateFinPeriodeSuspensive != null) && (!p_dateFinPeriodeSuspensive.equals(m_dateFinPeriodeSuspensive)))
    {
      m_dateFinPeriodeSuspensive = p_dateFinPeriodeSuspensive;
      ((DecisionPC)getPC()).setDateFinPeriodeSuspensive(p_dateFinPeriodeSuspensive);
    }
  }
  
  protected int rawGetNaturePeriodeSuspensive()
  {
    return ((DecisionPC)getPC()).getNaturePeriodeSuspensive();
  }
  
  public int getNaturePeriodeSuspensive()
  {
    return ((DecisionPC)getPC()).getNaturePeriodeSuspensive();
  }
  
  public void setNaturePeriodeSuspensive(int p_naturePeriodeSuspensive)
  {
    ((DecisionPC)getPC()).setNaturePeriodeSuspensive(p_naturePeriodeSuspensive);
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     DecisionGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
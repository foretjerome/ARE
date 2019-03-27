package fr.unedic.cali.dom.pivot.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pivot.pc.DecisionPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class DecisionGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_decisionPC;
  private String m_referenceExterneDemande;
  private String m_identifiantDemandeCali;
  private String m_classementAdministratif;
  private Damj m_datePriseDecision;
  private Damj m_dateEffetDecision;
  private Damj m_dateExamen;
  private Damj m_dateFctFG;
  private String m_origineDecision;
  private String m_codeValidation;
  private String m_codeReexamen;
  private String m_oldTypeExamen;
  private String m_typeExamen;
  private Damj m_dateValidationDecision;
  private String m_codeProduit;
  private String m_uniteAffiliation;
  private String m_uniteAffiliation2;
  private String m_competenceAdministrative;
  private String m_topLiquidationEnEtat;
  private Damj m_dateFctRetenue;
  private Damj m_dateFinPmc = null;
  private String m_situationParticuliere;
  private String m_codeSousProduit;
  private Damj m_dateDebutPra;
  private Damj m_dateFinPra;
  private String m_uniteAffiliationRequise;
  private String m_uniteAffiliationRequise2;
  private Damj m_dateFinDecheance;
  private String m_etablissementFinanceur;
  private String m_idExterneEmployeurSp;
  private Damj m_dateDebutEvenement;
  private Damj m_dateFinEvenement;
  private String m_etatPndsPourCalculAffiliation;
  private String m_modeTraitementDemandeNPDE;
  private String m_codeSousProduitRejet;
  
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
  
  protected String rawGetIdentifiantDemandeCali()
  {
    return ((DecisionPC)getPC()).getIdentifiantDemandeCali();
  }
  
  public String getIdentifiantDemandeCali()
  {
    return ((DecisionPC)getPC()).getIdentifiantDemandeCali();
  }
  
  public void setIdentifiantDemandeCali(String p_identifiantDemandeCali)
  {
    if ((m_identifiantDemandeCali == null) || (p_identifiantDemandeCali == null))
    {
      m_identifiantDemandeCali = p_identifiantDemandeCali;
      ((DecisionPC)getPC()).setIdentifiantDemandeCali(p_identifiantDemandeCali);
    }
    else if ((m_identifiantDemandeCali != null) && (p_identifiantDemandeCali != null) && (!p_identifiantDemandeCali.equals(m_identifiantDemandeCali)))
    {
      m_identifiantDemandeCali = p_identifiantDemandeCali;
      ((DecisionPC)getPC()).setIdentifiantDemandeCali(p_identifiantDemandeCali);
    }
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
  
  protected Damj rawGetDatePriseDecision()
  {
    return ((DecisionPC)getPC()).getDatePriseDecision();
  }
  
  public Damj getDatePriseDecision()
  {
    return ((DecisionPC)getPC()).getDatePriseDecision();
  }
  
  public void setDatePriseDecision(Damj p_datePriseDecision)
  {
    if ((m_datePriseDecision == null) || (p_datePriseDecision == null))
    {
      m_datePriseDecision = p_datePriseDecision;
      ((DecisionPC)getPC()).setDatePriseDecision(p_datePriseDecision);
    }
    else if ((m_datePriseDecision != null) && (p_datePriseDecision != null) && (!p_datePriseDecision.equals(m_datePriseDecision)))
    {
      m_datePriseDecision = p_datePriseDecision;
      ((DecisionPC)getPC()).setDatePriseDecision(p_datePriseDecision);
    }
  }
  
  protected Damj rawGetDateEffetDecision()
  {
    return ((DecisionPC)getPC()).getDateEffetDecision();
  }
  
  public Damj getDateEffetDecision()
  {
    return ((DecisionPC)getPC()).getDateEffetDecision();
  }
  
  public void setDateEffetDecision(Damj p_dateEffetDecision)
  {
    if ((m_dateEffetDecision == null) || (p_dateEffetDecision == null))
    {
      m_dateEffetDecision = p_dateEffetDecision;
      ((DecisionPC)getPC()).setDateEffetDecision(p_dateEffetDecision);
    }
    else if ((m_dateEffetDecision != null) && (p_dateEffetDecision != null) && (!p_dateEffetDecision.equals(m_dateEffetDecision)))
    {
      m_dateEffetDecision = p_dateEffetDecision;
      ((DecisionPC)getPC()).setDateEffetDecision(p_dateEffetDecision);
    }
  }
  
  protected Damj rawGetDateExamen()
  {
    return ((DecisionPC)getPC()).getDateExamen();
  }
  
  public Damj getDateExamen()
  {
    return ((DecisionPC)getPC()).getDateExamen();
  }
  
  public void setDateExamen(Damj p_dateExamen)
  {
    if ((m_dateExamen == null) || (p_dateExamen == null))
    {
      m_dateExamen = p_dateExamen;
      ((DecisionPC)getPC()).setDateExamen(p_dateExamen);
    }
    else if ((m_dateExamen != null) && (p_dateExamen != null) && (!p_dateExamen.equals(m_dateExamen)))
    {
      m_dateExamen = p_dateExamen;
      ((DecisionPC)getPC()).setDateExamen(p_dateExamen);
    }
  }
  
  protected Damj rawGetDateFctFG()
  {
    return ((DecisionPC)getPC()).getDateFctFG();
  }
  
  public Damj getDateFctFG()
  {
    return ((DecisionPC)getPC()).getDateFctFG();
  }
  
  public void setDateFctFG(Damj p_dateFctFG)
  {
    if ((m_dateFctFG == null) || (p_dateFctFG == null))
    {
      m_dateFctFG = p_dateFctFG;
      ((DecisionPC)getPC()).setDateFctFG(p_dateFctFG);
    }
    else if ((m_dateFctFG != null) && (p_dateFctFG != null) && (!p_dateFctFG.equals(m_dateFctFG)))
    {
      m_dateFctFG = p_dateFctFG;
      ((DecisionPC)getPC()).setDateFctFG(p_dateFctFG);
    }
  }
  
  protected String rawGetOrigineDecision()
  {
    return ((DecisionPC)getPC()).getOrigineDecision();
  }
  
  public String getOrigineDecision()
  {
    return ((DecisionPC)getPC()).getOrigineDecision();
  }
  
  public void setOrigineDecision(String p_origineDecision)
  {
    if ((m_origineDecision == null) || (p_origineDecision == null))
    {
      m_origineDecision = p_origineDecision;
      ((DecisionPC)getPC()).setOrigineDecision(p_origineDecision);
    }
    else if ((m_origineDecision != null) && (p_origineDecision != null) && (!p_origineDecision.equals(m_origineDecision)))
    {
      m_origineDecision = p_origineDecision;
      ((DecisionPC)getPC()).setOrigineDecision(p_origineDecision);
    }
  }
  
  protected String rawGetCodeValidation()
  {
    return ((DecisionPC)getPC()).getCodeValidation();
  }
  
  public String getCodeValidation()
  {
    return ((DecisionPC)getPC()).getCodeValidation();
  }
  
  public void setCodeValidation(String p_codeValidation)
  {
    if ((m_codeValidation == null) || (p_codeValidation == null))
    {
      m_codeValidation = p_codeValidation;
      ((DecisionPC)getPC()).setCodeValidation(p_codeValidation);
    }
    else if ((m_codeValidation != null) && (p_codeValidation != null) && (!p_codeValidation.equals(m_codeValidation)))
    {
      m_codeValidation = p_codeValidation;
      ((DecisionPC)getPC()).setCodeValidation(p_codeValidation);
    }
  }
  
  protected String rawGetCodeReexamen()
  {
    return ((DecisionPC)getPC()).getCodeReexamen();
  }
  
  public String getCodeReexamen()
  {
    return ((DecisionPC)getPC()).getCodeReexamen();
  }
  
  public void setCodeReexamen(String p_codeReexamen)
  {
    if ((m_codeReexamen == null) || (p_codeReexamen == null))
    {
      m_codeReexamen = p_codeReexamen;
      ((DecisionPC)getPC()).setCodeReexamen(p_codeReexamen);
    }
    else if ((m_codeReexamen != null) && (p_codeReexamen != null) && (!p_codeReexamen.equals(m_codeReexamen)))
    {
      m_codeReexamen = p_codeReexamen;
      ((DecisionPC)getPC()).setCodeReexamen(p_codeReexamen);
    }
  }
  
  protected String rawGetOldTypeExamen()
  {
    return ((DecisionPC)getPC()).getOldTypeExamen();
  }
  
  public String getOldTypeExamen()
  {
    return ((DecisionPC)getPC()).getOldTypeExamen();
  }
  
  public void setOldTypeExamen(String p_oldTypeExamen)
  {
    if ((m_oldTypeExamen == null) || (p_oldTypeExamen == null))
    {
      m_oldTypeExamen = p_oldTypeExamen;
      ((DecisionPC)getPC()).setOldTypeExamen(p_oldTypeExamen);
    }
    else if ((m_oldTypeExamen != null) && (p_oldTypeExamen != null) && (!p_oldTypeExamen.equals(m_oldTypeExamen)))
    {
      m_oldTypeExamen = p_oldTypeExamen;
      ((DecisionPC)getPC()).setOldTypeExamen(p_oldTypeExamen);
    }
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
  
  protected Damj rawGetDateValidationDecision()
  {
    return ((DecisionPC)getPC()).getDateValidationDecision();
  }
  
  public Damj getDateValidationDecision()
  {
    return ((DecisionPC)getPC()).getDateValidationDecision();
  }
  
  public void setDateValidationDecision(Damj p_dateValidationDecision)
  {
    if ((m_dateValidationDecision == null) || (p_dateValidationDecision == null))
    {
      m_dateValidationDecision = p_dateValidationDecision;
      ((DecisionPC)getPC()).setDateValidationDecision(p_dateValidationDecision);
    }
    else if ((m_dateValidationDecision != null) && (p_dateValidationDecision != null) && (!p_dateValidationDecision.equals(m_dateValidationDecision)))
    {
      m_dateValidationDecision = p_dateValidationDecision;
      ((DecisionPC)getPC()).setDateValidationDecision(p_dateValidationDecision);
    }
  }
  
  protected String rawGetCodeProduit()
  {
    return ((DecisionPC)getPC()).getCodeProduit();
  }
  
  public String getCodeProduit()
  {
    return ((DecisionPC)getPC()).getCodeProduit();
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    if ((m_codeProduit == null) || (p_codeProduit == null))
    {
      m_codeProduit = p_codeProduit;
      ((DecisionPC)getPC()).setCodeProduit(p_codeProduit);
    }
    else if ((m_codeProduit != null) && (p_codeProduit != null) && (!p_codeProduit.equals(m_codeProduit)))
    {
      m_codeProduit = p_codeProduit;
      ((DecisionPC)getPC()).setCodeProduit(p_codeProduit);
    }
  }
  
  protected String rawGetUniteAffiliation()
  {
    return ((DecisionPC)getPC()).getUniteAffiliation();
  }
  
  public String getUniteAffiliation()
  {
    return ((DecisionPC)getPC()).getUniteAffiliation();
  }
  
  public void setUniteAffiliation(String p_uniteAffiliation)
  {
    if ((m_uniteAffiliation == null) || (p_uniteAffiliation == null))
    {
      m_uniteAffiliation = p_uniteAffiliation;
      ((DecisionPC)getPC()).setUniteAffiliation(p_uniteAffiliation);
    }
    else if ((m_uniteAffiliation != null) && (p_uniteAffiliation != null) && (!p_uniteAffiliation.equals(m_uniteAffiliation)))
    {
      m_uniteAffiliation = p_uniteAffiliation;
      ((DecisionPC)getPC()).setUniteAffiliation(p_uniteAffiliation);
    }
  }
  
  protected int rawGetValeurQuantiteAffiliation()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAffiliation();
  }
  
  public int getValeurQuantiteAffiliation()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAffiliation();
  }
  
  public void setValeurQuantiteAffiliation(int p_valeurQuantiteAffiliation)
  {
    ((DecisionPC)getPC()).setValeurQuantiteAffiliation(p_valeurQuantiteAffiliation);
  }
  
  protected String rawGetUniteAffiliation2()
  {
    return ((DecisionPC)getPC()).getUniteAffiliation2();
  }
  
  public String getUniteAffiliation2()
  {
    return ((DecisionPC)getPC()).getUniteAffiliation2();
  }
  
  public void setUniteAffiliation2(String p_uniteAffiliation2)
  {
    if ((m_uniteAffiliation2 == null) || (p_uniteAffiliation2 == null))
    {
      m_uniteAffiliation2 = p_uniteAffiliation2;
      ((DecisionPC)getPC()).setUniteAffiliation2(p_uniteAffiliation2);
    }
    else if ((m_uniteAffiliation2 != null) && (p_uniteAffiliation2 != null) && (!p_uniteAffiliation2.equals(m_uniteAffiliation2)))
    {
      m_uniteAffiliation2 = p_uniteAffiliation2;
      ((DecisionPC)getPC()).setUniteAffiliation2(p_uniteAffiliation2);
    }
  }
  
  protected int rawGetValeurQuantiteAffiliation2()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAffiliation2();
  }
  
  public int getValeurQuantiteAffiliation2()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAffiliation2();
  }
  
  public void setValeurQuantiteAffiliation2(int p_valeurQuantiteAffiliation2)
  {
    ((DecisionPC)getPC()).setValeurQuantiteAffiliation2(p_valeurQuantiteAffiliation2);
  }
  
  protected int rawGetNbJoursAppartenance()
  {
    return ((DecisionPC)getPC()).getNbJoursAppartenance();
  }
  
  public int getNbJoursAppartenance()
  {
    return ((DecisionPC)getPC()).getNbJoursAppartenance();
  }
  
  public void setNbJoursAppartenance(int p_nbJoursAppartenance)
  {
    ((DecisionPC)getPC()).setNbJoursAppartenance(p_nbJoursAppartenance);
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
  
  protected String rawGetTopLiquidationEnEtat()
  {
    return ((DecisionPC)getPC()).getTopLiquidationEnEtat();
  }
  
  public String getTopLiquidationEnEtat()
  {
    return ((DecisionPC)getPC()).getTopLiquidationEnEtat();
  }
  
  public void setTopLiquidationEnEtat(String p_topLiquidationEnEtat)
  {
    if ((m_topLiquidationEnEtat == null) || (p_topLiquidationEnEtat == null))
    {
      m_topLiquidationEnEtat = p_topLiquidationEnEtat;
      ((DecisionPC)getPC()).setTopLiquidationEnEtat(p_topLiquidationEnEtat);
    }
    else if ((m_topLiquidationEnEtat != null) && (p_topLiquidationEnEtat != null) && (!p_topLiquidationEnEtat.equals(m_topLiquidationEnEtat)))
    {
      m_topLiquidationEnEtat = p_topLiquidationEnEtat;
      ((DecisionPC)getPC()).setTopLiquidationEnEtat(p_topLiquidationEnEtat);
    }
  }
  
  protected Damj rawGetDateFctRetenue()
  {
    return ((DecisionPC)getPC()).getDateFctRetenue();
  }
  
  public Damj getDateFctRetenue()
  {
    return ((DecisionPC)getPC()).getDateFctRetenue();
  }
  
  public void setDateFctRetenue(Damj p_dateFctRetenue)
  {
    if ((m_dateFctRetenue == null) || (p_dateFctRetenue == null))
    {
      m_dateFctRetenue = p_dateFctRetenue;
      ((DecisionPC)getPC()).setDateFctRetenue(p_dateFctRetenue);
    }
    else if ((m_dateFctRetenue != null) && (p_dateFctRetenue != null) && (!p_dateFctRetenue.equals(m_dateFctRetenue)))
    {
      m_dateFctRetenue = p_dateFctRetenue;
      ((DecisionPC)getPC()).setDateFctRetenue(p_dateFctRetenue);
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
  
  protected Damj rawGetDateFinPmc()
  {
    return ((DecisionPC)getPC()).getDateFinPmc();
  }
  
  public Damj getDateFinPmc()
  {
    return ((DecisionPC)getPC()).getDateFinPmc();
  }
  
  public void setDateFinPmc(Damj p_dateFinPmc)
  {
    if ((m_dateFinPmc == null) || (p_dateFinPmc == null))
    {
      m_dateFinPmc = p_dateFinPmc;
      ((DecisionPC)getPC()).setDateFinPmc(p_dateFinPmc);
    }
    else if ((m_dateFinPmc != null) && (p_dateFinPmc != null) && (!p_dateFinPmc.equals(m_dateFinPmc)))
    {
      m_dateFinPmc = p_dateFinPmc;
      ((DecisionPC)getPC()).setDateFinPmc(p_dateFinPmc);
    }
  }
  
  protected int rawGetTypePmc()
  {
    return ((DecisionPC)getPC()).getTypePmc();
  }
  
  public int getTypePmc()
  {
    return ((DecisionPC)getPC()).getTypePmc();
  }
  
  public void setTypePmc(int p_typePmc)
  {
    ((DecisionPC)getPC()).setTypePmc(p_typePmc);
  }
  
  protected int rawGetValeurQuantiteAssimilation()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAssimilation();
  }
  
  public int getValeurQuantiteAssimilation()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAssimilation();
  }
  
  public void setValeurQuantiteAssimilation(int p_valeurQuantiteAssimilation)
  {
    ((DecisionPC)getPC()).setValeurQuantiteAssimilation(p_valeurQuantiteAssimilation);
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
  
  protected int rawGetNbHFormationProfessionnelleAssimiliees()
  {
    return ((DecisionPC)getPC()).getNbHFormationProfessionnelleAssimiliees();
  }
  
  public int getNbHFormationProfessionnelleAssimiliees()
  {
    return ((DecisionPC)getPC()).getNbHFormationProfessionnelleAssimiliees();
  }
  
  public void setNbHFormationProfessionnelleAssimiliees(int p_nbHFormationProfessionnelleAssimiliees)
  {
    ((DecisionPC)getPC()).setNbHFormationProfessionnelleAssimiliees(p_nbHFormationProfessionnelleAssimiliees);
  }
  
  protected int rawGetNbHEnseignementDispenseesAssimilees()
  {
    return ((DecisionPC)getPC()).getNbHEnseignementDispenseesAssimilees();
  }
  
  public int getNbHEnseignementDispenseesAssimilees()
  {
    return ((DecisionPC)getPC()).getNbHEnseignementDispenseesAssimilees();
  }
  
  public void setNbHEnseignementDispenseesAssimilees(int p_nbHEnseignementDispenseesAssimilees)
  {
    ((DecisionPC)getPC()).setNbHEnseignementDispenseesAssimilees(p_nbHEnseignementDispenseesAssimilees);
  }
  
  protected int rawGetNbHMaladieAssimilees()
  {
    return ((DecisionPC)getPC()).getNbHMaladieAssimilees();
  }
  
  public int getNbHMaladieAssimilees()
  {
    return ((DecisionPC)getPC()).getNbHMaladieAssimilees();
  }
  
  public void setNbHMaladieAssimilees(int p_nbHMaladieAssimilees)
  {
    ((DecisionPC)getPC()).setNbHMaladieAssimilees(p_nbHMaladieAssimilees);
  }
  
  protected int rawGetNbHMaterniteAssimilees()
  {
    return ((DecisionPC)getPC()).getNbHMaterniteAssimilees();
  }
  
  public int getNbHMaterniteAssimilees()
  {
    return ((DecisionPC)getPC()).getNbHMaterniteAssimilees();
  }
  
  public void setNbHMaterniteAssimilees(int p_nbHMaterniteAssimilees)
  {
    ((DecisionPC)getPC()).setNbHMaterniteAssimilees(p_nbHMaterniteAssimilees);
  }
  
  protected int rawGetNbHTravailHorsA8A10()
  {
    return ((DecisionPC)getPC()).getNbHTravailHorsA8A10();
  }
  
  public int getNbHTravailHorsA8A10()
  {
    return ((DecisionPC)getPC()).getNbHTravailHorsA8A10();
  }
  
  public void setNbHTravailHorsA8A10(int p_nbHTravailHorsA8A10)
  {
    ((DecisionPC)getPC()).setNbHTravailHorsA8A10(p_nbHTravailHorsA8A10);
  }
  
  protected Damj rawGetDateDebutPra()
  {
    return ((DecisionPC)getPC()).getDateDebutPra();
  }
  
  public Damj getDateDebutPra()
  {
    return ((DecisionPC)getPC()).getDateDebutPra();
  }
  
  public void setDateDebutPra(Damj p_dateDebutPra)
  {
    if ((m_dateDebutPra == null) || (p_dateDebutPra == null))
    {
      m_dateDebutPra = p_dateDebutPra;
      ((DecisionPC)getPC()).setDateDebutPra(p_dateDebutPra);
    }
    else if ((m_dateDebutPra != null) && (p_dateDebutPra != null) && (!p_dateDebutPra.equals(m_dateDebutPra)))
    {
      m_dateDebutPra = p_dateDebutPra;
      ((DecisionPC)getPC()).setDateDebutPra(p_dateDebutPra);
    }
  }
  
  protected Damj rawGetDateFinPra()
  {
    return ((DecisionPC)getPC()).getDateFinPra();
  }
  
  public Damj getDateFinPra()
  {
    return ((DecisionPC)getPC()).getDateFinPra();
  }
  
  public void setDateFinPra(Damj p_dateFinPra)
  {
    if ((m_dateFinPra == null) || (p_dateFinPra == null))
    {
      m_dateFinPra = p_dateFinPra;
      ((DecisionPC)getPC()).setDateFinPra(p_dateFinPra);
    }
    else if ((m_dateFinPra != null) && (p_dateFinPra != null) && (!p_dateFinPra.equals(m_dateFinPra)))
    {
      m_dateFinPra = p_dateFinPra;
      ((DecisionPC)getPC()).setDateFinPra(p_dateFinPra);
    }
  }
  
  protected int rawGetValeurQuantiteAffiliationRequise()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAffiliationRequise();
  }
  
  public int getValeurQuantiteAffiliationRequise()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAffiliationRequise();
  }
  
  public void setValeurQuantiteAffiliationRequise(int p_valeurQuantiteAffiliationRequise)
  {
    ((DecisionPC)getPC()).setValeurQuantiteAffiliationRequise(p_valeurQuantiteAffiliationRequise);
  }
  
  protected String rawGetUniteAffiliationRequise()
  {
    return ((DecisionPC)getPC()).getUniteAffiliationRequise();
  }
  
  public String getUniteAffiliationRequise()
  {
    return ((DecisionPC)getPC()).getUniteAffiliationRequise();
  }
  
  public void setUniteAffiliationRequise(String p_uniteAffiliationRequise)
  {
    if ((m_uniteAffiliationRequise == null) || (p_uniteAffiliationRequise == null))
    {
      m_uniteAffiliationRequise = p_uniteAffiliationRequise;
      ((DecisionPC)getPC()).setUniteAffiliationRequise(p_uniteAffiliationRequise);
    }
    else if ((m_uniteAffiliationRequise != null) && (p_uniteAffiliationRequise != null) && (!p_uniteAffiliationRequise.equals(m_uniteAffiliationRequise)))
    {
      m_uniteAffiliationRequise = p_uniteAffiliationRequise;
      ((DecisionPC)getPC()).setUniteAffiliationRequise(p_uniteAffiliationRequise);
    }
  }
  
  protected int rawGetValeurQuantiteAffiliationRequise2()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAffiliationRequise2();
  }
  
  public int getValeurQuantiteAffiliationRequise2()
  {
    return ((DecisionPC)getPC()).getValeurQuantiteAffiliationRequise2();
  }
  
  public void setValeurQuantiteAffiliationRequise2(int p_valeurQuantiteAffiliationRequise2)
  {
    ((DecisionPC)getPC()).setValeurQuantiteAffiliationRequise2(p_valeurQuantiteAffiliationRequise2);
  }
  
  protected String rawGetUniteAffiliationRequise2()
  {
    return ((DecisionPC)getPC()).getUniteAffiliationRequise2();
  }
  
  public String getUniteAffiliationRequise2()
  {
    return ((DecisionPC)getPC()).getUniteAffiliationRequise2();
  }
  
  public void setUniteAffiliationRequise2(String p_uniteAffiliationRequise2)
  {
    if ((m_uniteAffiliationRequise2 == null) || (p_uniteAffiliationRequise2 == null))
    {
      m_uniteAffiliationRequise2 = p_uniteAffiliationRequise2;
      ((DecisionPC)getPC()).setUniteAffiliationRequise2(p_uniteAffiliationRequise2);
    }
    else if ((m_uniteAffiliationRequise2 != null) && (p_uniteAffiliationRequise2 != null) && (!p_uniteAffiliationRequise2.equals(m_uniteAffiliationRequise2)))
    {
      m_uniteAffiliationRequise2 = p_uniteAffiliationRequise2;
      ((DecisionPC)getPC()).setUniteAffiliationRequise2(p_uniteAffiliationRequise2);
    }
  }
  
  protected int rawGetPeriodeTheoriqueRechercheAffiliation()
  {
    return ((DecisionPC)getPC()).getPeriodeTheoriqueRechercheAffiliation();
  }
  
  public int getPeriodeTheoriqueRechercheAffiliation()
  {
    return ((DecisionPC)getPC()).getPeriodeTheoriqueRechercheAffiliation();
  }
  
  public void setPeriodeTheoriqueRechercheAffiliation(int p_periodeTheoriqueRechercheAffiliation)
  {
    ((DecisionPC)getPC()).setPeriodeTheoriqueRechercheAffiliation(p_periodeTheoriqueRechercheAffiliation);
  }
  
  protected Damj rawGetDateFinDecheance()
  {
    return ((DecisionPC)getPC()).getDateFinDecheance();
  }
  
  public Damj getDateFinDecheance()
  {
    return ((DecisionPC)getPC()).getDateFinDecheance();
  }
  
  public void setDateFinDecheance(Damj p_dateFinDecheance)
  {
    if ((m_dateFinDecheance == null) || (p_dateFinDecheance == null))
    {
      m_dateFinDecheance = p_dateFinDecheance;
      ((DecisionPC)getPC()).setDateFinDecheance(p_dateFinDecheance);
    }
    else if ((m_dateFinDecheance != null) && (p_dateFinDecheance != null) && (!p_dateFinDecheance.equals(m_dateFinDecheance)))
    {
      m_dateFinDecheance = p_dateFinDecheance;
      ((DecisionPC)getPC()).setDateFinDecheance(p_dateFinDecheance);
    }
  }
  
  protected String rawGetEtablissementFinanceur()
  {
    return ((DecisionPC)getPC()).getEtablissementFinanceur();
  }
  
  public String getEtablissementFinanceur()
  {
    return ((DecisionPC)getPC()).getEtablissementFinanceur();
  }
  
  public void setEtablissementFinanceur(String p_etablissementFinanceur)
  {
    if ((m_etablissementFinanceur == null) || (p_etablissementFinanceur == null))
    {
      m_etablissementFinanceur = p_etablissementFinanceur;
      ((DecisionPC)getPC()).setEtablissementFinanceur(p_etablissementFinanceur);
    }
    else if ((m_etablissementFinanceur != null) && (p_etablissementFinanceur != null) && (!p_etablissementFinanceur.equals(m_etablissementFinanceur)))
    {
      m_etablissementFinanceur = p_etablissementFinanceur;
      ((DecisionPC)getPC()).setEtablissementFinanceur(p_etablissementFinanceur);
    }
  }
  
  protected String rawGetIdExterneEmployeurSp()
  {
    return ((DecisionPC)getPC()).getIdExterneEmployeurSp();
  }
  
  public String getIdExterneEmployeurSp()
  {
    return ((DecisionPC)getPC()).getIdExterneEmployeurSp();
  }
  
  public void setIdExterneEmployeurSp(String p_idExterneEmployeurSp)
  {
    if ((m_idExterneEmployeurSp == null) || (p_idExterneEmployeurSp == null))
    {
      m_idExterneEmployeurSp = p_idExterneEmployeurSp;
      ((DecisionPC)getPC()).setIdExterneEmployeurSp(p_idExterneEmployeurSp);
    }
    else if ((m_idExterneEmployeurSp != null) && (p_idExterneEmployeurSp != null) && (!p_idExterneEmployeurSp.equals(m_idExterneEmployeurSp)))
    {
      m_idExterneEmployeurSp = p_idExterneEmployeurSp;
      ((DecisionPC)getPC()).setIdExterneEmployeurSp(p_idExterneEmployeurSp);
    }
  }
  
  protected Damj rawGetDateDebutEvenement()
  {
    return ((DecisionPC)getPC()).getDateDebutEvenement();
  }
  
  public Damj getDateDebutEvenement()
  {
    return ((DecisionPC)getPC()).getDateDebutEvenement();
  }
  
  public void setDateDebutEvenement(Damj p_dateDebutEvenement)
  {
    if ((m_dateDebutEvenement == null) || (p_dateDebutEvenement == null))
    {
      m_dateDebutEvenement = p_dateDebutEvenement;
      ((DecisionPC)getPC()).setDateDebutEvenement(p_dateDebutEvenement);
    }
    else if ((m_dateDebutEvenement != null) && (p_dateDebutEvenement != null) && (!p_dateDebutEvenement.equals(m_dateDebutEvenement)))
    {
      m_dateDebutEvenement = p_dateDebutEvenement;
      ((DecisionPC)getPC()).setDateDebutEvenement(p_dateDebutEvenement);
    }
  }
  
  protected Damj rawGetDateFinEvenement()
  {
    return ((DecisionPC)getPC()).getDateFinEvenement();
  }
  
  public Damj getDateFinEvenement()
  {
    return ((DecisionPC)getPC()).getDateFinEvenement();
  }
  
  public void setDateFinEvenement(Damj p_dateFinEvenement)
  {
    if ((m_dateFinEvenement == null) || (p_dateFinEvenement == null))
    {
      m_dateFinEvenement = p_dateFinEvenement;
      ((DecisionPC)getPC()).setDateFinEvenement(p_dateFinEvenement);
    }
    else if ((m_dateFinEvenement != null) && (p_dateFinEvenement != null) && (!p_dateFinEvenement.equals(m_dateFinEvenement)))
    {
      m_dateFinEvenement = p_dateFinEvenement;
      ((DecisionPC)getPC()).setDateFinEvenement(p_dateFinEvenement);
    }
  }
  
  protected int rawGetNbJoursAffiImputes()
  {
    return ((DecisionPC)getPC()).getNbJoursAffiImputes();
  }
  
  public int getNbJoursAffiImputes()
  {
    return ((DecisionPC)getPC()).getNbJoursAffiImputes();
  }
  
  public void setNbJoursAffiImputes(int p_nbJoursAffiImputes)
  {
    ((DecisionPC)getPC()).setNbJoursAffiImputes(p_nbJoursAffiImputes);
  }
  
  protected String rawGetEtatPndsPourCalculAffiliation()
  {
    return ((DecisionPC)getPC()).getEtatPndsPourCalculAffiliation();
  }
  
  public String getEtatPndsPourCalculAffiliation()
  {
    return ((DecisionPC)getPC()).getEtatPndsPourCalculAffiliation();
  }
  
  public void setEtatPndsPourCalculAffiliation(String p_etatPndsPourCalculAffiliation)
  {
    if ((m_etatPndsPourCalculAffiliation == null) || (p_etatPndsPourCalculAffiliation == null))
    {
      m_etatPndsPourCalculAffiliation = p_etatPndsPourCalculAffiliation;
      ((DecisionPC)getPC()).setEtatPndsPourCalculAffiliation(p_etatPndsPourCalculAffiliation);
    }
    else if ((m_etatPndsPourCalculAffiliation != null) && (p_etatPndsPourCalculAffiliation != null) && (!p_etatPndsPourCalculAffiliation.equals(m_etatPndsPourCalculAffiliation)))
    {
      m_etatPndsPourCalculAffiliation = p_etatPndsPourCalculAffiliation;
      ((DecisionPC)getPC()).setEtatPndsPourCalculAffiliation(p_etatPndsPourCalculAffiliation);
    }
  }
  
  protected String rawGetModeTraitementDemandeNPDE()
  {
    return ((DecisionPC)getPC()).getModeTraitementDemandeNPDE();
  }
  
  public String getModeTraitementDemandeNPDE()
  {
    return ((DecisionPC)getPC()).getModeTraitementDemandeNPDE();
  }
  
  public void setModeTraitementDemandeNPDE(String p_modeTraitementDemandeNPDE)
  {
    if ((m_modeTraitementDemandeNPDE == null) || (p_modeTraitementDemandeNPDE == null))
    {
      m_modeTraitementDemandeNPDE = p_modeTraitementDemandeNPDE;
      ((DecisionPC)getPC()).setModeTraitementDemandeNPDE(p_modeTraitementDemandeNPDE);
    }
    else if ((m_modeTraitementDemandeNPDE != null) && (p_modeTraitementDemandeNPDE != null) && (!p_modeTraitementDemandeNPDE.equals(m_modeTraitementDemandeNPDE)))
    {
      m_modeTraitementDemandeNPDE = p_modeTraitementDemandeNPDE;
      ((DecisionPC)getPC()).setModeTraitementDemandeNPDE(p_modeTraitementDemandeNPDE);
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
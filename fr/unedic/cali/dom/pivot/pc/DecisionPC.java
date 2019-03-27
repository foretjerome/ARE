package fr.unedic.cali.dom.pivot.pc;

import fr.unedic.cali.dom.pivot.Decision;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.Damj;
import java.io.IOException;
import java.io.ObjectOutputStream;
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

public class DecisionPC
  implements DomPCSpec, PersistenceCapable
{
  private transient Decision m_decisionOM;
  protected String m_referenceExterneDemande;
  protected String m_identifiantDemandeCali;
  protected String m_classementAdministratif;
  protected int m_natureDecision;
  protected Damj m_datePriseDecision;
  protected Damj m_dateEffetDecision;
  protected Damj m_dateExamen;
  protected Damj m_dateFctFG;
  protected String m_origineDecision;
  protected String m_codeValidation;
  protected String m_codeReexamen;
  protected String m_oldTypeExamen;
  protected String m_typeExamen;
  protected Damj m_dateValidationDecision;
  protected String m_codeProduit;
  protected String m_uniteAffiliation;
  protected int m_valeurQuantiteAffiliation;
  protected String m_uniteAffiliation2;
  protected int m_valeurQuantiteAffiliation2;
  protected int m_nbJoursAppartenance;
  protected String m_competenceAdministrative;
  protected String m_topLiquidationEnEtat;
  protected Damj m_dateFctRetenue;
  protected int m_motifRejet;
  protected Damj m_dateFinPmc;
  protected int m_typePmc;
  protected int m_valeurQuantiteAssimilation;
  protected String m_situationParticuliere;
  protected String m_codeSousProduit;
  protected int m_nbHFormationProfessionnelleAssimiliees;
  protected int m_nbHEnseignementDispenseesAssimilees;
  protected int m_nbHMaladieAssimilees;
  protected int m_nbHMaterniteAssimilees;
  protected int m_nbHTravailHorsA8A10;
  protected Damj m_dateDebutPra;
  protected Damj m_dateFinPra;
  protected int m_valeurQuantiteAffiliationRequise;
  protected String m_uniteAffiliationRequise;
  protected int m_valeurQuantiteAffiliationRequise2;
  protected String m_uniteAffiliationRequise2;
  protected int m_periodeTheoriqueRechercheAffiliation;
  protected Damj m_dateFinDecheance;
  private String m_etablissementFinanceur;
  private String m_idExterneEmployeurSp;
  protected int m_nbJoursAffiImputes;
  protected Damj m_dateDebutEvenement;
  protected Damj m_dateFinEvenement;
  protected String m_etatPndsPourCalculAffiliation;
  protected String m_modeTraitementDemandeNPDE;
  public String m_codeSousProduitRejet;
  protected transient byte jdoFlags;
  protected transient StateManager jdoStateManager;
  private static int jdoInheritedFieldCount = 0;
  private static String[] jdoFieldNames = { "m_referenceExterneDemande", "m_identifiantDemandeCali", "m_classementAdministratif", "m_natureDecision", "m_datePriseDecision", "m_dateEffetDecision", "m_dateExamen", "m_dateFctFG", "m_origineDecision", "m_codeValidation", "m_codeReexamen", "m_oldTypeExamen", "m_typeExamen", "m_dateValidationDecision", "m_codeProduit", "m_uniteAffiliation", "m_valeurQuantiteAffiliation", "m_uniteAffiliation2", "m_valeurQuantiteAffiliation2", "m_nbJoursAppartenance", "m_competenceAdministrative", "m_topLiquidationEnEtat", "m_dateFctRetenue", "m_motifRejet", "m_dateFinPmc", "m_typePmc", "m_valeurQuantiteAssimilation", "m_situationParticuliere", "m_codeSousProduit", "m_nbHFormationProfessionnelleAssimiliees", "m_nbHEnseignementDispenseesAssimilees", "m_nbHMaladieAssimilees", "m_nbHMaterniteAssimilees", "m_nbHTravailHorsA8A10", "m_dateDebutPra", "m_dateFinPra", "m_valeurQuantiteAffiliationRequise", "m_uniteAffiliationRequise", "m_valeurQuantiteAffiliationRequise2", "m_uniteAffiliationRequise2", "m_periodeTheoriqueRechercheAffiliation", "m_dateFinDecheance", "m_etablissementFinanceur", "m_idExterneEmployeurSp", "m_nbJoursAffiImputes", "m_dateDebutEvenement", "m_dateFinEvenement", "m_etatPndsPourCalculAffiliation", "m_modeTraitementDemandeNPDE", "m_codeSousProduitRejet" };
  private static Class[] jdoFieldTypes = { String.class, String.class, String.class, Integer.TYPE, Damj.class, Damj.class, Damj.class, Damj.class, String.class, String.class, String.class, String.class, String.class, Damj.class, String.class, String.class, Integer.TYPE, String.class, Integer.TYPE, Integer.TYPE, String.class, String.class, Damj.class, Integer.TYPE, Damj.class, Integer.TYPE, Integer.TYPE, String.class, String.class, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Damj.class, Damj.class, Integer.TYPE, String.class, Integer.TYPE, String.class, Integer.TYPE, Damj.class, String.class, String.class, Integer.TYPE, Damj.class, Damj.class, String.class, String.class, String.class };
  private static byte[] jdoFieldFlags = { (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE), (byte)(PersistenceCapable.CHECK_READ + PersistenceCapable.CHECK_WRITE) };
  private static Class jdoPersistenceCapableSuperclass = null;
  
  public DecisionPC()
  {
    jdoSetm_dateFinPmc(this, null);
    jdoSetm_typePmc(this, 0);
    jdoSetm_valeurQuantiteAssimilation(this, 0);
    
    jdoSetm_nbHFormationProfessionnelleAssimiliees(this, 0);
    jdoSetm_nbHEnseignementDispenseesAssimilees(this, 0);
    jdoSetm_nbHMaladieAssimilees(this, 0);
    jdoSetm_nbHMaterniteAssimilees(this, 0);
    jdoSetm_nbHTravailHorsA8A10(this, 0);
  }
  
  public Object createOM()
  {
    if (m_decisionOM == null) {
      m_decisionOM = new Decision(this);
    }
    return m_decisionOM;
  }
  
  public String getReferenceExterneDemande()
  {
    return jdoGetm_referenceExterneDemande(this);
  }
  
  public final void setReferenceExterneDemande(String p_referenceExterneDemande)
  {
    jdoSetm_referenceExterneDemande(this, p_referenceExterneDemande);
  }
  
  public String getIdentifiantDemandeCali()
  {
    return jdoGetm_identifiantDemandeCali(this);
  }
  
  public final void setIdentifiantDemandeCali(String p_identifiantDemandeCali)
  {
    jdoSetm_identifiantDemandeCali(this, p_identifiantDemandeCali);
  }
  
  public String getClassementAdministratif()
  {
    return jdoGetm_classementAdministratif(this);
  }
  
  public final void setClassementAdministratif(String p_classementAdministratif)
  {
    jdoSetm_classementAdministratif(this, p_classementAdministratif);
  }
  
  public int getNatureDecision()
  {
    return jdoGetm_natureDecision(this);
  }
  
  public final void setNatureDecision(int p_natureDecision)
  {
    jdoSetm_natureDecision(this, p_natureDecision);
  }
  
  public Damj getDatePriseDecision()
  {
    return jdoGetm_datePriseDecision(this);
  }
  
  public final void setDatePriseDecision(Damj p_datePriseDecision)
  {
    jdoSetm_datePriseDecision(this, p_datePriseDecision);
  }
  
  public Damj getDateEffetDecision()
  {
    return jdoGetm_dateEffetDecision(this);
  }
  
  public final void setDateEffetDecision(Damj p_dateEffetDecision)
  {
    jdoSetm_dateEffetDecision(this, p_dateEffetDecision);
  }
  
  public Damj getDateExamen()
  {
    return jdoGetm_dateExamen(this);
  }
  
  public final void setDateExamen(Damj p_dateExamen)
  {
    jdoSetm_dateExamen(this, p_dateExamen);
  }
  
  public Damj getDateFctFG()
  {
    return jdoGetm_dateFctFG(this);
  }
  
  public final void setDateFctFG(Damj p_dateFctFG)
  {
    jdoSetm_dateFctFG(this, p_dateFctFG);
  }
  
  public String getOrigineDecision()
  {
    return jdoGetm_origineDecision(this);
  }
  
  public final void setOrigineDecision(String p_origineDecision)
  {
    jdoSetm_origineDecision(this, p_origineDecision);
  }
  
  public String getCodeValidation()
  {
    return jdoGetm_codeValidation(this);
  }
  
  public final void setCodeValidation(String p_codeValidation)
  {
    jdoSetm_codeValidation(this, p_codeValidation);
  }
  
  public String getCodeReexamen()
  {
    return jdoGetm_codeReexamen(this);
  }
  
  public final void setCodeReexamen(String p_codeReexamen)
  {
    jdoSetm_codeReexamen(this, p_codeReexamen);
  }
  
  public String getOldTypeExamen()
  {
    return jdoGetm_oldTypeExamen(this);
  }
  
  public final void setOldTypeExamen(String p_oldTypeExamen)
  {
    jdoSetm_oldTypeExamen(this, p_oldTypeExamen);
  }
  
  public String getTypeExamen()
  {
    return jdoGetm_typeExamen(this);
  }
  
  public final void setTypeExamen(String p_typeExamen)
  {
    jdoSetm_typeExamen(this, p_typeExamen);
  }
  
  public Damj getDateValidationDecision()
  {
    return jdoGetm_dateValidationDecision(this);
  }
  
  public final void setDateValidationDecision(Damj p_dateValidationDecision)
  {
    jdoSetm_dateValidationDecision(this, p_dateValidationDecision);
  }
  
  public String getCodeProduit()
  {
    return jdoGetm_codeProduit(this);
  }
  
  public final void setCodeProduit(String p_codeProduit)
  {
    jdoSetm_codeProduit(this, p_codeProduit);
  }
  
  public String getUniteAffiliation()
  {
    return jdoGetm_uniteAffiliation(this);
  }
  
  public final void setUniteAffiliation(String p_uniteAffiliation)
  {
    jdoSetm_uniteAffiliation(this, p_uniteAffiliation);
  }
  
  public int getValeurQuantiteAffiliation()
  {
    return jdoGetm_valeurQuantiteAffiliation(this);
  }
  
  public final void setValeurQuantiteAffiliation(int p_valeurQuantiteAffiliation)
  {
    jdoSetm_valeurQuantiteAffiliation(this, p_valeurQuantiteAffiliation);
  }
  
  public String getUniteAffiliation2()
  {
    return jdoGetm_uniteAffiliation2(this);
  }
  
  public final void setUniteAffiliation2(String p_uniteAffiliation2)
  {
    jdoSetm_uniteAffiliation2(this, p_uniteAffiliation2);
  }
  
  public int getValeurQuantiteAffiliation2()
  {
    return jdoGetm_valeurQuantiteAffiliation2(this);
  }
  
  public final void setValeurQuantiteAffiliation2(int p_valeurQuantiteAffiliation2)
  {
    jdoSetm_valeurQuantiteAffiliation2(this, p_valeurQuantiteAffiliation2);
  }
  
  public int getNbJoursAppartenance()
  {
    return jdoGetm_nbJoursAppartenance(this);
  }
  
  public final void setNbJoursAppartenance(int p_nbJoursAppartenance)
  {
    jdoSetm_nbJoursAppartenance(this, p_nbJoursAppartenance);
  }
  
  public String getCompetenceAdministrative()
  {
    return jdoGetm_competenceAdministrative(this);
  }
  
  public final void setCompetenceAdministrative(String p_competenceAdministrative)
  {
    jdoSetm_competenceAdministrative(this, p_competenceAdministrative);
  }
  
  public String getTopLiquidationEnEtat()
  {
    return jdoGetm_topLiquidationEnEtat(this);
  }
  
  public final void setTopLiquidationEnEtat(String p_topLiquidationEnEtat)
  {
    jdoSetm_topLiquidationEnEtat(this, p_topLiquidationEnEtat);
  }
  
  public Damj getDateFctRetenue()
  {
    return jdoGetm_dateFctRetenue(this);
  }
  
  public final void setDateFctRetenue(Damj p_dateFctRetenue)
  {
    jdoSetm_dateFctRetenue(this, p_dateFctRetenue);
  }
  
  public int getMotifRejet()
  {
    return jdoGetm_motifRejet(this);
  }
  
  public final void setMotifRejet(int p_motifRejet)
  {
    jdoSetm_motifRejet(this, p_motifRejet);
  }
  
  public Damj getDateFinPmc()
  {
    return jdoGetm_dateFinPmc(this);
  }
  
  public final void setDateFinPmc(Damj p_dateFinPmc)
  {
    jdoSetm_dateFinPmc(this, p_dateFinPmc);
  }
  
  public int getTypePmc()
  {
    return jdoGetm_typePmc(this);
  }
  
  public final void setTypePmc(int p_typePmc)
  {
    jdoSetm_typePmc(this, p_typePmc);
  }
  
  public int getValeurQuantiteAssimilation()
  {
    return jdoGetm_valeurQuantiteAssimilation(this);
  }
  
  public final void setValeurQuantiteAssimilation(int p_valeurQuantiteAssimilation)
  {
    jdoSetm_valeurQuantiteAssimilation(this, p_valeurQuantiteAssimilation);
  }
  
  public String getSituationParticuliere()
  {
    return jdoGetm_situationParticuliere(this);
  }
  
  public final void setSituationParticuliere(String p_situationParticuliere)
  {
    jdoSetm_situationParticuliere(this, p_situationParticuliere);
  }
  
  public String getCodeSousProduit()
  {
    return jdoGetm_codeSousProduit(this);
  }
  
  public final void setCodeSousProduit(String p_codeSousProduit)
  {
    jdoSetm_codeSousProduit(this, p_codeSousProduit);
  }
  
  public int getNbHFormationProfessionnelleAssimiliees()
  {
    return jdoGetm_nbHFormationProfessionnelleAssimiliees(this);
  }
  
  public final void setNbHFormationProfessionnelleAssimiliees(int p_nbHFormationProfessionnelleAssimiliees)
  {
    jdoSetm_nbHFormationProfessionnelleAssimiliees(this, p_nbHFormationProfessionnelleAssimiliees);
  }
  
  public int getNbHEnseignementDispenseesAssimilees()
  {
    return jdoGetm_nbHEnseignementDispenseesAssimilees(this);
  }
  
  public final void setNbHEnseignementDispenseesAssimilees(int p_nbHEnseignementDispenseesAssimilees)
  {
    jdoSetm_nbHEnseignementDispenseesAssimilees(this, p_nbHEnseignementDispenseesAssimilees);
  }
  
  public int getNbHMaladieAssimilees()
  {
    return jdoGetm_nbHMaladieAssimilees(this);
  }
  
  public final void setNbHMaladieAssimilees(int p_nbHMaladieAssimilees)
  {
    jdoSetm_nbHMaladieAssimilees(this, p_nbHMaladieAssimilees);
  }
  
  public int getNbHMaterniteAssimilees()
  {
    return jdoGetm_nbHMaterniteAssimilees(this);
  }
  
  public final void setNbHMaterniteAssimilees(int p_nbHMaterniteAssimilees)
  {
    jdoSetm_nbHMaterniteAssimilees(this, p_nbHMaterniteAssimilees);
  }
  
  public int getNbHTravailHorsA8A10()
  {
    return jdoGetm_nbHTravailHorsA8A10(this);
  }
  
  public final void setNbHTravailHorsA8A10(int p_nbHTravailHorsA8A10)
  {
    jdoSetm_nbHTravailHorsA8A10(this, p_nbHTravailHorsA8A10);
  }
  
  public Damj getDateDebutPra()
  {
    return jdoGetm_dateDebutPra(this);
  }
  
  public final void setDateDebutPra(Damj p_dateDebutPra)
  {
    jdoSetm_dateDebutPra(this, p_dateDebutPra);
  }
  
  public Damj getDateFinPra()
  {
    return jdoGetm_dateFinPra(this);
  }
  
  public final void setDateFinPra(Damj p_dateFinPra)
  {
    jdoSetm_dateFinPra(this, p_dateFinPra);
  }
  
  public int getValeurQuantiteAffiliationRequise()
  {
    return jdoGetm_valeurQuantiteAffiliationRequise(this);
  }
  
  public final void setValeurQuantiteAffiliationRequise(int p_valeurQuantiteAffiliationRequise)
  {
    jdoSetm_valeurQuantiteAffiliationRequise(this, p_valeurQuantiteAffiliationRequise);
  }
  
  public String getUniteAffiliationRequise()
  {
    return jdoGetm_uniteAffiliationRequise(this);
  }
  
  public final void setUniteAffiliationRequise(String p_uniteAffiliationRequise)
  {
    jdoSetm_uniteAffiliationRequise(this, p_uniteAffiliationRequise);
  }
  
  public int getValeurQuantiteAffiliationRequise2()
  {
    return jdoGetm_valeurQuantiteAffiliationRequise2(this);
  }
  
  public final void setValeurQuantiteAffiliationRequise2(int p_valeurQuantiteAffiliationRequise2)
  {
    jdoSetm_valeurQuantiteAffiliationRequise2(this, p_valeurQuantiteAffiliationRequise2);
  }
  
  public String getUniteAffiliationRequise2()
  {
    return jdoGetm_uniteAffiliationRequise2(this);
  }
  
  public final void setUniteAffiliationRequise2(String p_uniteAffiliationRequise2)
  {
    jdoSetm_uniteAffiliationRequise2(this, p_uniteAffiliationRequise2);
  }
  
  public int getPeriodeTheoriqueRechercheAffiliation()
  {
    return jdoGetm_periodeTheoriqueRechercheAffiliation(this);
  }
  
  public final void setPeriodeTheoriqueRechercheAffiliation(int p_periodeTheoriqueRechercheAffiliation)
  {
    jdoSetm_periodeTheoriqueRechercheAffiliation(this, p_periodeTheoriqueRechercheAffiliation);
  }
  
  public Damj getDateFinDecheance()
  {
    return jdoGetm_dateFinDecheance(this);
  }
  
  public final void setDateFinDecheance(Damj p_dateFinDecheance)
  {
    jdoSetm_dateFinDecheance(this, p_dateFinDecheance);
  }
  
  public String getEtablissementFinanceur()
  {
    return jdoGetm_etablissementFinanceur(this);
  }
  
  public final void setEtablissementFinanceur(String p_etablissementFinanceur)
  {
    jdoSetm_etablissementFinanceur(this, p_etablissementFinanceur);
  }
  
  public String getIdExterneEmployeurSp()
  {
    return jdoGetm_idExterneEmployeurSp(this);
  }
  
  public final void setIdExterneEmployeurSp(String p_idExterneEmployeurSp)
  {
    jdoSetm_idExterneEmployeurSp(this, p_idExterneEmployeurSp);
  }
  
  public int getNbJoursAffiImputes()
  {
    return jdoGetm_nbJoursAffiImputes(this);
  }
  
  public final void setNbJoursAffiImputes(int p_nbJoursAffiImputes)
  {
    jdoSetm_nbJoursAffiImputes(this, p_nbJoursAffiImputes);
  }
  
  public Damj getDateDebutEvenement()
  {
    return jdoGetm_dateDebutEvenement(this);
  }
  
  public final void setDateDebutEvenement(Damj p_dateDebutEvenement)
  {
    jdoSetm_dateDebutEvenement(this, p_dateDebutEvenement);
  }
  
  public Damj getDateFinEvenement()
  {
    return jdoGetm_dateFinEvenement(this);
  }
  
  public final void setDateFinEvenement(Damj p_dateFinEvenement)
  {
    jdoSetm_dateFinEvenement(this, p_dateFinEvenement);
  }
  
  public String getEtatPndsPourCalculAffiliation()
  {
    return jdoGetm_etatPndsPourCalculAffiliation(this);
  }
  
  public final void setEtatPndsPourCalculAffiliation(String p_etatPndsPourCalculAffiliation)
  {
    jdoSetm_etatPndsPourCalculAffiliation(this, p_etatPndsPourCalculAffiliation);
  }
  
  public String getModeTraitementDemandeNPDE()
  {
    return jdoGetm_modeTraitementDemandeNPDE(this);
  }
  
  public final void setModeTraitementDemandeNPDE(String p_modeTraitementDemandeNPDE)
  {
    jdoSetm_modeTraitementDemandeNPDE(this, p_modeTraitementDemandeNPDE);
  }
  
  public String getCodeSousProduitRejet()
  {
    return jdoGetm_codeSousProduitRejet(this);
  }
  
  public final void setCodeSousProduitRejet(String p_codeSousProduitRejet)
  {
    jdoSetm_codeSousProduitRejet(this, p_codeSousProduitRejet);
  }
  
  static
  {
    JDOImplHelper.registerClass(DecisionPC.class, jdoFieldNames, jdoFieldTypes, jdoFieldFlags, jdoPersistenceCapableSuperclass, new DecisionPC());
  }
  
  protected static final String jdoGetm_referenceExterneDemande(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_referenceExterneDemande;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 0)) {
        return m_referenceExterneDemande;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 0, m_referenceExterneDemande);
    }
    return m_referenceExterneDemande;
  }
  
  protected static final String jdoGetm_identifiantDemandeCali(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_identifiantDemandeCali;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 1)) {
        return m_identifiantDemandeCali;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 1, m_identifiantDemandeCali);
    }
    return m_identifiantDemandeCali;
  }
  
  protected static final String jdoGetm_classementAdministratif(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_classementAdministratif;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 2)) {
        return m_classementAdministratif;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 2, m_classementAdministratif);
    }
    return m_classementAdministratif;
  }
  
  protected static final int jdoGetm_natureDecision(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_natureDecision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 3)) {
        return m_natureDecision;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 3, m_natureDecision);
    }
    return m_natureDecision;
  }
  
  protected static final Damj jdoGetm_datePriseDecision(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_datePriseDecision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 4)) {
        return m_datePriseDecision;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 4, m_datePriseDecision);
    }
    return m_datePriseDecision;
  }
  
  protected static final Damj jdoGetm_dateEffetDecision(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateEffetDecision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 5)) {
        return m_dateEffetDecision;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 5, m_dateEffetDecision);
    }
    return m_dateEffetDecision;
  }
  
  protected static final Damj jdoGetm_dateExamen(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateExamen;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 6)) {
        return m_dateExamen;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 6, m_dateExamen);
    }
    return m_dateExamen;
  }
  
  protected static final Damj jdoGetm_dateFctFG(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFctFG;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 7)) {
        return m_dateFctFG;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 7, m_dateFctFG);
    }
    return m_dateFctFG;
  }
  
  protected static final String jdoGetm_origineDecision(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_origineDecision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 8)) {
        return m_origineDecision;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 8, m_origineDecision);
    }
    return m_origineDecision;
  }
  
  protected static final String jdoGetm_codeValidation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeValidation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 9)) {
        return m_codeValidation;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 9, m_codeValidation);
    }
    return m_codeValidation;
  }
  
  protected static final String jdoGetm_codeReexamen(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeReexamen;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 10)) {
        return m_codeReexamen;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 10, m_codeReexamen);
    }
    return m_codeReexamen;
  }
  
  protected static final String jdoGetm_oldTypeExamen(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_oldTypeExamen;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 11)) {
        return m_oldTypeExamen;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 11, m_oldTypeExamen);
    }
    return m_oldTypeExamen;
  }
  
  protected static final String jdoGetm_typeExamen(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typeExamen;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 12)) {
        return m_typeExamen;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 12, m_typeExamen);
    }
    return m_typeExamen;
  }
  
  protected static final Damj jdoGetm_dateValidationDecision(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateValidationDecision;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 13)) {
        return m_dateValidationDecision;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 13, m_dateValidationDecision);
    }
    return m_dateValidationDecision;
  }
  
  protected static final String jdoGetm_codeProduit(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 14)) {
        return m_codeProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 14, m_codeProduit);
    }
    return m_codeProduit;
  }
  
  protected static final String jdoGetm_uniteAffiliation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_uniteAffiliation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 15)) {
        return m_uniteAffiliation;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 15, m_uniteAffiliation);
    }
    return m_uniteAffiliation;
  }
  
  protected static final int jdoGetm_valeurQuantiteAffiliation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_valeurQuantiteAffiliation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 16)) {
        return m_valeurQuantiteAffiliation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 16, m_valeurQuantiteAffiliation);
    }
    return m_valeurQuantiteAffiliation;
  }
  
  protected static final String jdoGetm_uniteAffiliation2(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_uniteAffiliation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 17)) {
        return m_uniteAffiliation2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 17, m_uniteAffiliation2);
    }
    return m_uniteAffiliation2;
  }
  
  protected static final int jdoGetm_valeurQuantiteAffiliation2(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_valeurQuantiteAffiliation2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 18)) {
        return m_valeurQuantiteAffiliation2;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 18, m_valeurQuantiteAffiliation2);
    }
    return m_valeurQuantiteAffiliation2;
  }
  
  protected static final int jdoGetm_nbJoursAppartenance(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursAppartenance;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 19)) {
        return m_nbJoursAppartenance;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 19, m_nbJoursAppartenance);
    }
    return m_nbJoursAppartenance;
  }
  
  protected static final String jdoGetm_competenceAdministrative(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_competenceAdministrative;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 20)) {
        return m_competenceAdministrative;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 20, m_competenceAdministrative);
    }
    return m_competenceAdministrative;
  }
  
  protected static final String jdoGetm_topLiquidationEnEtat(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_topLiquidationEnEtat;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 21)) {
        return m_topLiquidationEnEtat;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 21, m_topLiquidationEnEtat);
    }
    return m_topLiquidationEnEtat;
  }
  
  protected static final Damj jdoGetm_dateFctRetenue(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFctRetenue;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 22)) {
        return m_dateFctRetenue;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 22, m_dateFctRetenue);
    }
    return m_dateFctRetenue;
  }
  
  protected static final int jdoGetm_motifRejet(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_motifRejet;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 23)) {
        return m_motifRejet;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 23, m_motifRejet);
    }
    return m_motifRejet;
  }
  
  protected static final Damj jdoGetm_dateFinPmc(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinPmc;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 24)) {
        return m_dateFinPmc;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 24, m_dateFinPmc);
    }
    return m_dateFinPmc;
  }
  
  protected static final int jdoGetm_typePmc(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_typePmc;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 25)) {
        return m_typePmc;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 25, m_typePmc);
    }
    return m_typePmc;
  }
  
  protected static final int jdoGetm_valeurQuantiteAssimilation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_valeurQuantiteAssimilation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 26)) {
        return m_valeurQuantiteAssimilation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 26, m_valeurQuantiteAssimilation);
    }
    return m_valeurQuantiteAssimilation;
  }
  
  protected static final String jdoGetm_situationParticuliere(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_situationParticuliere;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 27)) {
        return m_situationParticuliere;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 27, m_situationParticuliere);
    }
    return m_situationParticuliere;
  }
  
  protected static final String jdoGetm_codeSousProduit(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduit;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 28)) {
        return m_codeSousProduit;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 28, m_codeSousProduit);
    }
    return m_codeSousProduit;
  }
  
  protected static final int jdoGetm_nbHFormationProfessionnelleAssimiliees(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbHFormationProfessionnelleAssimiliees;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 29)) {
        return m_nbHFormationProfessionnelleAssimiliees;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 29, m_nbHFormationProfessionnelleAssimiliees);
    }
    return m_nbHFormationProfessionnelleAssimiliees;
  }
  
  protected static final int jdoGetm_nbHEnseignementDispenseesAssimilees(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbHEnseignementDispenseesAssimilees;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 30)) {
        return m_nbHEnseignementDispenseesAssimilees;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 30, m_nbHEnseignementDispenseesAssimilees);
    }
    return m_nbHEnseignementDispenseesAssimilees;
  }
  
  protected static final int jdoGetm_nbHMaladieAssimilees(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbHMaladieAssimilees;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 31)) {
        return m_nbHMaladieAssimilees;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 31, m_nbHMaladieAssimilees);
    }
    return m_nbHMaladieAssimilees;
  }
  
  protected static final int jdoGetm_nbHMaterniteAssimilees(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbHMaterniteAssimilees;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 32)) {
        return m_nbHMaterniteAssimilees;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 32, m_nbHMaterniteAssimilees);
    }
    return m_nbHMaterniteAssimilees;
  }
  
  protected static final int jdoGetm_nbHTravailHorsA8A10(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbHTravailHorsA8A10;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 33)) {
        return m_nbHTravailHorsA8A10;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 33, m_nbHTravailHorsA8A10);
    }
    return m_nbHTravailHorsA8A10;
  }
  
  protected static final Damj jdoGetm_dateDebutPra(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutPra;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 34)) {
        return m_dateDebutPra;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 34, m_dateDebutPra);
    }
    return m_dateDebutPra;
  }
  
  protected static final Damj jdoGetm_dateFinPra(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinPra;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 35)) {
        return m_dateFinPra;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 35, m_dateFinPra);
    }
    return m_dateFinPra;
  }
  
  protected static final int jdoGetm_valeurQuantiteAffiliationRequise(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_valeurQuantiteAffiliationRequise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 36)) {
        return m_valeurQuantiteAffiliationRequise;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 36, m_valeurQuantiteAffiliationRequise);
    }
    return m_valeurQuantiteAffiliationRequise;
  }
  
  protected static final String jdoGetm_uniteAffiliationRequise(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_uniteAffiliationRequise;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 37)) {
        return m_uniteAffiliationRequise;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 37, m_uniteAffiliationRequise);
    }
    return m_uniteAffiliationRequise;
  }
  
  protected static final int jdoGetm_valeurQuantiteAffiliationRequise2(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_valeurQuantiteAffiliationRequise2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 38)) {
        return m_valeurQuantiteAffiliationRequise2;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 38, m_valeurQuantiteAffiliationRequise2);
    }
    return m_valeurQuantiteAffiliationRequise2;
  }
  
  protected static final String jdoGetm_uniteAffiliationRequise2(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_uniteAffiliationRequise2;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 39)) {
        return m_uniteAffiliationRequise2;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 39, m_uniteAffiliationRequise2);
    }
    return m_uniteAffiliationRequise2;
  }
  
  protected static final int jdoGetm_periodeTheoriqueRechercheAffiliation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_periodeTheoriqueRechercheAffiliation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 40)) {
        return m_periodeTheoriqueRechercheAffiliation;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 40, m_periodeTheoriqueRechercheAffiliation);
    }
    return m_periodeTheoriqueRechercheAffiliation;
  }
  
  protected static final Damj jdoGetm_dateFinDecheance(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinDecheance;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 41)) {
        return m_dateFinDecheance;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 41, m_dateFinDecheance);
    }
    return m_dateFinDecheance;
  }
  
  private static final String jdoGetm_etablissementFinanceur(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etablissementFinanceur;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 42)) {
        return m_etablissementFinanceur;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 42, m_etablissementFinanceur);
    }
    return m_etablissementFinanceur;
  }
  
  private static final String jdoGetm_idExterneEmployeurSp(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_idExterneEmployeurSp;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 43)) {
        return m_idExterneEmployeurSp;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 43, m_idExterneEmployeurSp);
    }
    return m_idExterneEmployeurSp;
  }
  
  protected static final int jdoGetm_nbJoursAffiImputes(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_nbJoursAffiImputes;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 44)) {
        return m_nbJoursAffiImputes;
      }
      return sm.getIntField(pc, jdoInheritedFieldCount + 44, m_nbJoursAffiImputes);
    }
    return m_nbJoursAffiImputes;
  }
  
  protected static final Damj jdoGetm_dateDebutEvenement(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateDebutEvenement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 45)) {
        return m_dateDebutEvenement;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 45, m_dateDebutEvenement);
    }
    return m_dateDebutEvenement;
  }
  
  protected static final Damj jdoGetm_dateFinEvenement(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_dateFinEvenement;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 46)) {
        return m_dateFinEvenement;
      }
      return (Damj)sm.getObjectField(pc, jdoInheritedFieldCount + 46, m_dateFinEvenement);
    }
    return m_dateFinEvenement;
  }
  
  protected static final String jdoGetm_etatPndsPourCalculAffiliation(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_etatPndsPourCalculAffiliation;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 47)) {
        return m_etatPndsPourCalculAffiliation;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 47, m_etatPndsPourCalculAffiliation);
    }
    return m_etatPndsPourCalculAffiliation;
  }
  
  protected static final String jdoGetm_modeTraitementDemandeNPDE(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_modeTraitementDemandeNPDE;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 48)) {
        return m_modeTraitementDemandeNPDE;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 48, m_modeTraitementDemandeNPDE);
    }
    return m_modeTraitementDemandeNPDE;
  }
  
  public static final String jdoGetm_codeSousProduitRejet(DecisionPC pc)
  {
    if (jdoFlags <= 0) {
      return m_codeSousProduitRejet;
    }
    StateManager sm = jdoStateManager;
    if (sm != null)
    {
      if (sm.isLoaded(pc, jdoInheritedFieldCount + 49)) {
        return m_codeSousProduitRejet;
      }
      return (String)sm.getStringField(pc, jdoInheritedFieldCount + 49, m_codeSousProduitRejet);
    }
    return m_codeSousProduitRejet;
  }
  
  protected static final void jdoSetm_referenceExterneDemande(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_referenceExterneDemande = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 0, m_referenceExterneDemande, newValue);
    } else {
      m_referenceExterneDemande = newValue;
    }
  }
  
  protected static final void jdoSetm_identifiantDemandeCali(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_identifiantDemandeCali = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 1, m_identifiantDemandeCali, newValue);
    } else {
      m_identifiantDemandeCali = newValue;
    }
  }
  
  protected static final void jdoSetm_classementAdministratif(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_classementAdministratif = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 2, m_classementAdministratif, newValue);
    } else {
      m_classementAdministratif = newValue;
    }
  }
  
  protected static final void jdoSetm_natureDecision(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_natureDecision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 3, m_natureDecision, newValue);
    } else {
      m_natureDecision = newValue;
    }
  }
  
  protected static final void jdoSetm_datePriseDecision(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_datePriseDecision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 4, m_datePriseDecision, newValue);
    } else {
      m_datePriseDecision = newValue;
    }
  }
  
  protected static final void jdoSetm_dateEffetDecision(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateEffetDecision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 5, m_dateEffetDecision, newValue);
    } else {
      m_dateEffetDecision = newValue;
    }
  }
  
  protected static final void jdoSetm_dateExamen(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateExamen = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 6, m_dateExamen, newValue);
    } else {
      m_dateExamen = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFctFG(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFctFG = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 7, m_dateFctFG, newValue);
    } else {
      m_dateFctFG = newValue;
    }
  }
  
  protected static final void jdoSetm_origineDecision(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_origineDecision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 8, m_origineDecision, newValue);
    } else {
      m_origineDecision = newValue;
    }
  }
  
  protected static final void jdoSetm_codeValidation(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeValidation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 9, m_codeValidation, newValue);
    } else {
      m_codeValidation = newValue;
    }
  }
  
  protected static final void jdoSetm_codeReexamen(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeReexamen = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 10, m_codeReexamen, newValue);
    } else {
      m_codeReexamen = newValue;
    }
  }
  
  protected static final void jdoSetm_oldTypeExamen(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_oldTypeExamen = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 11, m_oldTypeExamen, newValue);
    } else {
      m_oldTypeExamen = newValue;
    }
  }
  
  protected static final void jdoSetm_typeExamen(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_typeExamen = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 12, m_typeExamen, newValue);
    } else {
      m_typeExamen = newValue;
    }
  }
  
  protected static final void jdoSetm_dateValidationDecision(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateValidationDecision = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 13, m_dateValidationDecision, newValue);
    } else {
      m_dateValidationDecision = newValue;
    }
  }
  
  protected static final void jdoSetm_codeProduit(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 14, m_codeProduit, newValue);
    } else {
      m_codeProduit = newValue;
    }
  }
  
  protected static final void jdoSetm_uniteAffiliation(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_uniteAffiliation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 15, m_uniteAffiliation, newValue);
    } else {
      m_uniteAffiliation = newValue;
    }
  }
  
  protected static final void jdoSetm_valeurQuantiteAffiliation(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_valeurQuantiteAffiliation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 16, m_valeurQuantiteAffiliation, newValue);
    } else {
      m_valeurQuantiteAffiliation = newValue;
    }
  }
  
  protected static final void jdoSetm_uniteAffiliation2(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_uniteAffiliation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 17, m_uniteAffiliation2, newValue);
    } else {
      m_uniteAffiliation2 = newValue;
    }
  }
  
  protected static final void jdoSetm_valeurQuantiteAffiliation2(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_valeurQuantiteAffiliation2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 18, m_valeurQuantiteAffiliation2, newValue);
    } else {
      m_valeurQuantiteAffiliation2 = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursAppartenance(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursAppartenance = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 19, m_nbJoursAppartenance, newValue);
    } else {
      m_nbJoursAppartenance = newValue;
    }
  }
  
  protected static final void jdoSetm_competenceAdministrative(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_competenceAdministrative = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 20, m_competenceAdministrative, newValue);
    } else {
      m_competenceAdministrative = newValue;
    }
  }
  
  protected static final void jdoSetm_topLiquidationEnEtat(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_topLiquidationEnEtat = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 21, m_topLiquidationEnEtat, newValue);
    } else {
      m_topLiquidationEnEtat = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFctRetenue(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFctRetenue = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 22, m_dateFctRetenue, newValue);
    } else {
      m_dateFctRetenue = newValue;
    }
  }
  
  protected static final void jdoSetm_motifRejet(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_motifRejet = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 23, m_motifRejet, newValue);
    } else {
      m_motifRejet = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinPmc(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinPmc = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 24, m_dateFinPmc, newValue);
    } else {
      m_dateFinPmc = newValue;
    }
  }
  
  protected static final void jdoSetm_typePmc(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_typePmc = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 25, m_typePmc, newValue);
    } else {
      m_typePmc = newValue;
    }
  }
  
  protected static final void jdoSetm_valeurQuantiteAssimilation(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_valeurQuantiteAssimilation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 26, m_valeurQuantiteAssimilation, newValue);
    } else {
      m_valeurQuantiteAssimilation = newValue;
    }
  }
  
  protected static final void jdoSetm_situationParticuliere(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_situationParticuliere = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 27, m_situationParticuliere, newValue);
    } else {
      m_situationParticuliere = newValue;
    }
  }
  
  protected static final void jdoSetm_codeSousProduit(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduit = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 28, m_codeSousProduit, newValue);
    } else {
      m_codeSousProduit = newValue;
    }
  }
  
  protected static final void jdoSetm_nbHFormationProfessionnelleAssimiliees(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbHFormationProfessionnelleAssimiliees = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 29, m_nbHFormationProfessionnelleAssimiliees, newValue);
    } else {
      m_nbHFormationProfessionnelleAssimiliees = newValue;
    }
  }
  
  protected static final void jdoSetm_nbHEnseignementDispenseesAssimilees(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbHEnseignementDispenseesAssimilees = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 30, m_nbHEnseignementDispenseesAssimilees, newValue);
    } else {
      m_nbHEnseignementDispenseesAssimilees = newValue;
    }
  }
  
  protected static final void jdoSetm_nbHMaladieAssimilees(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbHMaladieAssimilees = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 31, m_nbHMaladieAssimilees, newValue);
    } else {
      m_nbHMaladieAssimilees = newValue;
    }
  }
  
  protected static final void jdoSetm_nbHMaterniteAssimilees(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbHMaterniteAssimilees = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 32, m_nbHMaterniteAssimilees, newValue);
    } else {
      m_nbHMaterniteAssimilees = newValue;
    }
  }
  
  protected static final void jdoSetm_nbHTravailHorsA8A10(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbHTravailHorsA8A10 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 33, m_nbHTravailHorsA8A10, newValue);
    } else {
      m_nbHTravailHorsA8A10 = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutPra(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutPra = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 34, m_dateDebutPra, newValue);
    } else {
      m_dateDebutPra = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinPra(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinPra = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 35, m_dateFinPra, newValue);
    } else {
      m_dateFinPra = newValue;
    }
  }
  
  protected static final void jdoSetm_valeurQuantiteAffiliationRequise(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_valeurQuantiteAffiliationRequise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 36, m_valeurQuantiteAffiliationRequise, newValue);
    } else {
      m_valeurQuantiteAffiliationRequise = newValue;
    }
  }
  
  protected static final void jdoSetm_uniteAffiliationRequise(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_uniteAffiliationRequise = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 37, m_uniteAffiliationRequise, newValue);
    } else {
      m_uniteAffiliationRequise = newValue;
    }
  }
  
  protected static final void jdoSetm_valeurQuantiteAffiliationRequise2(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_valeurQuantiteAffiliationRequise2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 38, m_valeurQuantiteAffiliationRequise2, newValue);
    } else {
      m_valeurQuantiteAffiliationRequise2 = newValue;
    }
  }
  
  protected static final void jdoSetm_uniteAffiliationRequise2(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_uniteAffiliationRequise2 = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 39, m_uniteAffiliationRequise2, newValue);
    } else {
      m_uniteAffiliationRequise2 = newValue;
    }
  }
  
  protected static final void jdoSetm_periodeTheoriqueRechercheAffiliation(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_periodeTheoriqueRechercheAffiliation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 40, m_periodeTheoriqueRechercheAffiliation, newValue);
    } else {
      m_periodeTheoriqueRechercheAffiliation = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinDecheance(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinDecheance = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 41, m_dateFinDecheance, newValue);
    } else {
      m_dateFinDecheance = newValue;
    }
  }
  
  private static final void jdoSetm_etablissementFinanceur(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_etablissementFinanceur = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 42, m_etablissementFinanceur, newValue);
    } else {
      m_etablissementFinanceur = newValue;
    }
  }
  
  private static final void jdoSetm_idExterneEmployeurSp(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_idExterneEmployeurSp = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 43, m_idExterneEmployeurSp, newValue);
    } else {
      m_idExterneEmployeurSp = newValue;
    }
  }
  
  protected static final void jdoSetm_nbJoursAffiImputes(DecisionPC pc, int newValue)
  {
    if (jdoFlags == 0)
    {
      m_nbJoursAffiImputes = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setIntField(pc, jdoInheritedFieldCount + 44, m_nbJoursAffiImputes, newValue);
    } else {
      m_nbJoursAffiImputes = newValue;
    }
  }
  
  protected static final void jdoSetm_dateDebutEvenement(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateDebutEvenement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 45, m_dateDebutEvenement, newValue);
    } else {
      m_dateDebutEvenement = newValue;
    }
  }
  
  protected static final void jdoSetm_dateFinEvenement(DecisionPC pc, Damj newValue)
  {
    if (jdoFlags == 0)
    {
      m_dateFinEvenement = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setObjectField(pc, jdoInheritedFieldCount + 46, m_dateFinEvenement, newValue);
    } else {
      m_dateFinEvenement = newValue;
    }
  }
  
  protected static final void jdoSetm_etatPndsPourCalculAffiliation(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_etatPndsPourCalculAffiliation = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 47, m_etatPndsPourCalculAffiliation, newValue);
    } else {
      m_etatPndsPourCalculAffiliation = newValue;
    }
  }
  
  protected static final void jdoSetm_modeTraitementDemandeNPDE(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_modeTraitementDemandeNPDE = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 48, m_modeTraitementDemandeNPDE, newValue);
    } else {
      m_modeTraitementDemandeNPDE = newValue;
    }
  }
  
  public static final void jdoSetm_codeSousProduitRejet(DecisionPC pc, String newValue)
  {
    if (jdoFlags == 0)
    {
      m_codeSousProduitRejet = newValue;
      return;
    }
    StateManager sm = jdoStateManager;
    if (sm != null) {
      sm.setStringField(pc, jdoInheritedFieldCount + 49, m_codeSousProduitRejet, newValue);
    } else {
      m_codeSousProduitRejet = newValue;
    }
  }
  
  public void jdoProvideField(int fieldNumber)
  {
    int relativeField = fieldNumber - jdoInheritedFieldCount;
    switch (relativeField)
    {
    case 0: 
      jdoStateManager.providedStringField(this, fieldNumber, m_referenceExterneDemande);
      break;
    case 1: 
      jdoStateManager.providedStringField(this, fieldNumber, m_identifiantDemandeCali);
      break;
    case 2: 
      jdoStateManager.providedStringField(this, fieldNumber, m_classementAdministratif);
      break;
    case 3: 
      jdoStateManager.providedIntField(this, fieldNumber, m_natureDecision);
      break;
    case 4: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_datePriseDecision);
      break;
    case 5: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateEffetDecision);
      break;
    case 6: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateExamen);
      break;
    case 7: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFctFG);
      break;
    case 8: 
      jdoStateManager.providedStringField(this, fieldNumber, m_origineDecision);
      break;
    case 9: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeValidation);
      break;
    case 10: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeReexamen);
      break;
    case 11: 
      jdoStateManager.providedStringField(this, fieldNumber, m_oldTypeExamen);
      break;
    case 12: 
      jdoStateManager.providedStringField(this, fieldNumber, m_typeExamen);
      break;
    case 13: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateValidationDecision);
      break;
    case 14: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeProduit);
      break;
    case 15: 
      jdoStateManager.providedStringField(this, fieldNumber, m_uniteAffiliation);
      break;
    case 16: 
      jdoStateManager.providedIntField(this, fieldNumber, m_valeurQuantiteAffiliation);
      break;
    case 17: 
      jdoStateManager.providedStringField(this, fieldNumber, m_uniteAffiliation2);
      break;
    case 18: 
      jdoStateManager.providedIntField(this, fieldNumber, m_valeurQuantiteAffiliation2);
      break;
    case 19: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursAppartenance);
      break;
    case 20: 
      jdoStateManager.providedStringField(this, fieldNumber, m_competenceAdministrative);
      break;
    case 21: 
      jdoStateManager.providedStringField(this, fieldNumber, m_topLiquidationEnEtat);
      break;
    case 22: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFctRetenue);
      break;
    case 23: 
      jdoStateManager.providedIntField(this, fieldNumber, m_motifRejet);
      break;
    case 24: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinPmc);
      break;
    case 25: 
      jdoStateManager.providedIntField(this, fieldNumber, m_typePmc);
      break;
    case 26: 
      jdoStateManager.providedIntField(this, fieldNumber, m_valeurQuantiteAssimilation);
      break;
    case 27: 
      jdoStateManager.providedStringField(this, fieldNumber, m_situationParticuliere);
      break;
    case 28: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduit);
      break;
    case 29: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbHFormationProfessionnelleAssimiliees);
      break;
    case 30: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbHEnseignementDispenseesAssimilees);
      break;
    case 31: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbHMaladieAssimilees);
      break;
    case 32: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbHMaterniteAssimilees);
      break;
    case 33: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbHTravailHorsA8A10);
      break;
    case 34: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutPra);
      break;
    case 35: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinPra);
      break;
    case 36: 
      jdoStateManager.providedIntField(this, fieldNumber, m_valeurQuantiteAffiliationRequise);
      break;
    case 37: 
      jdoStateManager.providedStringField(this, fieldNumber, m_uniteAffiliationRequise);
      break;
    case 38: 
      jdoStateManager.providedIntField(this, fieldNumber, m_valeurQuantiteAffiliationRequise2);
      break;
    case 39: 
      jdoStateManager.providedStringField(this, fieldNumber, m_uniteAffiliationRequise2);
      break;
    case 40: 
      jdoStateManager.providedIntField(this, fieldNumber, m_periodeTheoriqueRechercheAffiliation);
      break;
    case 41: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinDecheance);
      break;
    case 42: 
      jdoStateManager.providedStringField(this, fieldNumber, m_etablissementFinanceur);
      break;
    case 43: 
      jdoStateManager.providedStringField(this, fieldNumber, m_idExterneEmployeurSp);
      break;
    case 44: 
      jdoStateManager.providedIntField(this, fieldNumber, m_nbJoursAffiImputes);
      break;
    case 45: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateDebutEvenement);
      break;
    case 46: 
      jdoStateManager.providedObjectField(this, fieldNumber, m_dateFinEvenement);
      break;
    case 47: 
      jdoStateManager.providedStringField(this, fieldNumber, m_etatPndsPourCalculAffiliation);
      break;
    case 48: 
      jdoStateManager.providedStringField(this, fieldNumber, m_modeTraitementDemandeNPDE);
      break;
    case 49: 
      jdoStateManager.providedStringField(this, fieldNumber, m_codeSousProduitRejet);
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
      m_referenceExterneDemande = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 1: 
      m_identifiantDemandeCali = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 2: 
      m_classementAdministratif = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 3: 
      m_natureDecision = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 4: 
      m_datePriseDecision = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 5: 
      m_dateEffetDecision = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 6: 
      m_dateExamen = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 7: 
      m_dateFctFG = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 8: 
      m_origineDecision = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 9: 
      m_codeValidation = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 10: 
      m_codeReexamen = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 11: 
      m_oldTypeExamen = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 12: 
      m_typeExamen = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 13: 
      m_dateValidationDecision = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 14: 
      m_codeProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 15: 
      m_uniteAffiliation = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 16: 
      m_valeurQuantiteAffiliation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 17: 
      m_uniteAffiliation2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 18: 
      m_valeurQuantiteAffiliation2 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 19: 
      m_nbJoursAppartenance = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 20: 
      m_competenceAdministrative = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 21: 
      m_topLiquidationEnEtat = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 22: 
      m_dateFctRetenue = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 23: 
      m_motifRejet = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 24: 
      m_dateFinPmc = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 25: 
      m_typePmc = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 26: 
      m_valeurQuantiteAssimilation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 27: 
      m_situationParticuliere = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 28: 
      m_codeSousProduit = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 29: 
      m_nbHFormationProfessionnelleAssimiliees = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 30: 
      m_nbHEnseignementDispenseesAssimilees = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 31: 
      m_nbHMaladieAssimilees = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 32: 
      m_nbHMaterniteAssimilees = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 33: 
      m_nbHTravailHorsA8A10 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 34: 
      m_dateDebutPra = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 35: 
      m_dateFinPra = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 36: 
      m_valeurQuantiteAffiliationRequise = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 37: 
      m_uniteAffiliationRequise = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 38: 
      m_valeurQuantiteAffiliationRequise2 = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 39: 
      m_uniteAffiliationRequise2 = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 40: 
      m_periodeTheoriqueRechercheAffiliation = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 41: 
      m_dateFinDecheance = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 42: 
      m_etablissementFinanceur = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 43: 
      m_idExterneEmployeurSp = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 44: 
      m_nbJoursAffiImputes = jdoStateManager.replacingIntField(this, fieldNumber);
      break;
    case 45: 
      m_dateDebutEvenement = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 46: 
      m_dateFinEvenement = ((Damj)jdoStateManager.replacingObjectField(this, fieldNumber));
      break;
    case 47: 
      m_etatPndsPourCalculAffiliation = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 48: 
      m_modeTraitementDemandeNPDE = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
      break;
    case 49: 
      m_codeSousProduitRejet = ((String)jdoStateManager.replacingStringField(this, fieldNumber));
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
    DecisionPC pc = new DecisionPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    return pc;
  }
  
  public PersistenceCapable jdoNewInstance(StateManager sm, Object oid)
  {
    DecisionPC pc = new DecisionPC();
    jdoStateManager = sm;
    jdoFlags = PersistenceCapable.LOAD_REQUIRED;
    pc.jdoCopyKeyFieldsFromObjectId(oid);
    return pc;
  }
  
  public static int jdoGetManagedFieldCount()
  {
    return jdoInheritedFieldCount + 50;
  }
  
  public void jdoCopyFields(Object pc, int[] fieldNumbers)
  {
    if (!(pc instanceof DecisionPC)) {
      throw new JDOFatalInternalException("Can't copy fields from a different class");
    }
    DecisionPC other = (DecisionPC)pc;
    if (jdoStateManager != jdoStateManager) {
      throw new JDOUserException("Source object should have the same StateManager");
    }
    for (int i = 0; i < fieldNumbers.length; i++)
    {
      int relativeField = fieldNumbers[i] - jdoInheritedFieldCount;
      switch (relativeField)
      {
      case 0: 
        m_referenceExterneDemande = m_referenceExterneDemande;
        break;
      case 1: 
        m_identifiantDemandeCali = m_identifiantDemandeCali;
        break;
      case 2: 
        m_classementAdministratif = m_classementAdministratif;
        break;
      case 3: 
        m_natureDecision = m_natureDecision;
        break;
      case 4: 
        m_datePriseDecision = m_datePriseDecision;
        break;
      case 5: 
        m_dateEffetDecision = m_dateEffetDecision;
        break;
      case 6: 
        m_dateExamen = m_dateExamen;
        break;
      case 7: 
        m_dateFctFG = m_dateFctFG;
        break;
      case 8: 
        m_origineDecision = m_origineDecision;
        break;
      case 9: 
        m_codeValidation = m_codeValidation;
        break;
      case 10: 
        m_codeReexamen = m_codeReexamen;
        break;
      case 11: 
        m_oldTypeExamen = m_oldTypeExamen;
        break;
      case 12: 
        m_typeExamen = m_typeExamen;
        break;
      case 13: 
        m_dateValidationDecision = m_dateValidationDecision;
        break;
      case 14: 
        m_codeProduit = m_codeProduit;
        break;
      case 15: 
        m_uniteAffiliation = m_uniteAffiliation;
        break;
      case 16: 
        m_valeurQuantiteAffiliation = m_valeurQuantiteAffiliation;
        break;
      case 17: 
        m_uniteAffiliation2 = m_uniteAffiliation2;
        break;
      case 18: 
        m_valeurQuantiteAffiliation2 = m_valeurQuantiteAffiliation2;
        break;
      case 19: 
        m_nbJoursAppartenance = m_nbJoursAppartenance;
        break;
      case 20: 
        m_competenceAdministrative = m_competenceAdministrative;
        break;
      case 21: 
        m_topLiquidationEnEtat = m_topLiquidationEnEtat;
        break;
      case 22: 
        m_dateFctRetenue = m_dateFctRetenue;
        break;
      case 23: 
        m_motifRejet = m_motifRejet;
        break;
      case 24: 
        m_dateFinPmc = m_dateFinPmc;
        break;
      case 25: 
        m_typePmc = m_typePmc;
        break;
      case 26: 
        m_valeurQuantiteAssimilation = m_valeurQuantiteAssimilation;
        break;
      case 27: 
        m_situationParticuliere = m_situationParticuliere;
        break;
      case 28: 
        m_codeSousProduit = m_codeSousProduit;
        break;
      case 29: 
        m_nbHFormationProfessionnelleAssimiliees = m_nbHFormationProfessionnelleAssimiliees;
        break;
      case 30: 
        m_nbHEnseignementDispenseesAssimilees = m_nbHEnseignementDispenseesAssimilees;
        break;
      case 31: 
        m_nbHMaladieAssimilees = m_nbHMaladieAssimilees;
        break;
      case 32: 
        m_nbHMaterniteAssimilees = m_nbHMaterniteAssimilees;
        break;
      case 33: 
        m_nbHTravailHorsA8A10 = m_nbHTravailHorsA8A10;
        break;
      case 34: 
        m_dateDebutPra = m_dateDebutPra;
        break;
      case 35: 
        m_dateFinPra = m_dateFinPra;
        break;
      case 36: 
        m_valeurQuantiteAffiliationRequise = m_valeurQuantiteAffiliationRequise;
        break;
      case 37: 
        m_uniteAffiliationRequise = m_uniteAffiliationRequise;
        break;
      case 38: 
        m_valeurQuantiteAffiliationRequise2 = m_valeurQuantiteAffiliationRequise2;
        break;
      case 39: 
        m_uniteAffiliationRequise2 = m_uniteAffiliationRequise2;
        break;
      case 40: 
        m_periodeTheoriqueRechercheAffiliation = m_periodeTheoriqueRechercheAffiliation;
        break;
      case 41: 
        m_dateFinDecheance = m_dateFinDecheance;
        break;
      case 42: 
        m_etablissementFinanceur = m_etablissementFinanceur;
        break;
      case 43: 
        m_idExterneEmployeurSp = m_idExterneEmployeurSp;
        break;
      case 44: 
        m_nbJoursAffiImputes = m_nbJoursAffiImputes;
        break;
      case 45: 
        m_dateDebutEvenement = m_dateDebutEvenement;
        break;
      case 46: 
        m_dateFinEvenement = m_dateFinEvenement;
        break;
      case 47: 
        m_etatPndsPourCalculAffiliation = m_etatPndsPourCalculAffiliation;
        break;
      case 48: 
        m_modeTraitementDemandeNPDE = m_modeTraitementDemandeNPDE;
        break;
      case 49: 
        m_codeSousProduitRejet = m_codeSousProduitRejet;
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
 * Qualified Name:     DecisionPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
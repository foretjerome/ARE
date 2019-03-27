package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.DomCali;
import fr.unedic.cali.parcours.DomCaliOptimise;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class DomMigration
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu = null;
  public static final int TYPE_VALIDATION_ANNULATION = 0;
  public static final int TYPE_VALIDATION_VALIDATION = 1;
  public static final String TYPE_CONTEXTE_MIGRATION_DECLENCHEMENT_MK02 = "M";
  public static final String TYPE_CONTEXTE_MIGRATION_A_LA_DEMANDE_EN_COURS_INDEMNISATION = "E";
  public static final String TYPE_CONTEXTE_MIGRATION_A_LA_DEMANDE_RADIE = "R";
  public static final String TYPE_CONTEXTE_MIGRATION_A_LA_DEMANDE_NON_INDEMNISABLE = "D";
  public static final String AUTORISATION_MIGRATION_STANDARD = "";
  public static final String AUTORISATION_MIGRATION_SIMPLIFIEE_DROITS_ANTERIEURS = "I";
  public static final String AUTORISATION_MIGRATION_SIMPLIFIEE_TOUT_DROIT = "E";
  public static final String AUTORISATION_MIGRATION_SIMPLIFIEE_FORCAGE = "F";
  private BigDecimal m_csas;
  private BigDecimal m_rsod;
  private BigDecimal m_rsrp;
  private String m_rsin;
  private String m_contexteMigration;
  private String m_autorisationTypeMigration;
  private BigDecimal m_rsia;
  private Collection m_listeDemandesAMigrer = new ArrayList();
  private Collection m_listeCalendrierExecutionAMigrer = new ArrayList();
  private ContexteService m_contexteService;
  private int m_typeValidation;
  private int m_attributionAfdFiliereCourte;
  private int m_attributionAfdFiliereIntermediaire;
  private int m_attributionAfdFiliereLongue;
  private Damj m_djiDernierDroitAreSpectacle;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public BigDecimal getCsas()
  {
    return m_csas;
  }
  
  public void setCsas(BigDecimal p_csas)
  {
    m_csas = p_csas;
  }
  
  public BigDecimal getRsia()
  {
    return m_rsia;
  }
  
  public void setRsia(BigDecimal p_rsia)
  {
    m_rsia = p_rsia;
  }
  
  public String getRsin()
  {
    return m_rsin;
  }
  
  public void setRsin(String p_rsin)
  {
    m_rsin = p_rsin;
  }
  
  public BigDecimal getRsod()
  {
    return m_rsod;
  }
  
  public void setRsod(BigDecimal p_rsod)
  {
    m_rsod = p_rsod;
  }
  
  public BigDecimal getRsrp()
  {
    return m_rsrp;
  }
  
  public void setRsrp(BigDecimal p_rsrp)
  {
    m_rsrp = p_rsrp;
  }
  
  public int getTypeValidation()
  {
    return m_typeValidation;
  }
  
  public void setTypeValidation(int p_typeValidation)
  {
    m_typeValidation = p_typeValidation;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public Collection getListeCalendrierExecutionAMigrer()
  {
    return m_listeCalendrierExecutionAMigrer;
  }
  
  public void setListeCalendrierExecutionAMigrer(Collection p_listeCalendrierExecutionAMigrer)
  {
    m_listeCalendrierExecutionAMigrer = p_listeCalendrierExecutionAMigrer;
  }
  
  public Collection getListeDemandesAMigrer()
  {
    return m_listeDemandesAMigrer;
  }
  
  public void setListeDemandesAMigrer(Collection p_listeDemandesAMigrer)
  {
    m_listeDemandesAMigrer = p_listeDemandesAMigrer;
  }
  
  public String getContexteMigration()
  {
    return m_contexteMigration;
  }
  
  public void setContexteMigration(String p_contexteMigration)
  {
    m_contexteMigration = p_contexteMigration;
  }
  
  public String getAutorisationTypeMigration()
  {
    return m_autorisationTypeMigration;
  }
  
  public void setAutorisationTypeMigration(String p_autorisationTypeMigration)
  {
    m_autorisationTypeMigration = p_autorisationTypeMigration;
  }
  
  public int getAttributionAfdFiliereCourte()
  {
    return m_attributionAfdFiliereCourte;
  }
  
  public void setAttributionAfdFiliereCourte(int p_attributionAfdFiliereCourte)
  {
    m_attributionAfdFiliereCourte = p_attributionAfdFiliereCourte;
  }
  
  public int getAttributionAfdFiliereIntermediaire()
  {
    return m_attributionAfdFiliereIntermediaire;
  }
  
  public void setAttributionAfdFiliereIntermediaire(int p_attributionAfdFiliereIntermediaire)
  {
    m_attributionAfdFiliereIntermediaire = p_attributionAfdFiliereIntermediaire;
  }
  
  public int getAttributionAfdFiliereLongue()
  {
    return m_attributionAfdFiliereLongue;
  }
  
  public void setAttributionAfdFiliereLongue(int p_attributionAfdFiliereLongue)
  {
    m_attributionAfdFiliereLongue = p_attributionAfdFiliereLongue;
  }
  
  public Damj getDjiDernierDroitAreSpectacle()
  {
    return m_djiDernierDroitAreSpectacle;
  }
  
  public void setDjiDernierDroitAreSpectacle(Damj p_djiDernierDroitAreSpectacle)
  {
    m_djiDernierDroitAreSpectacle = p_djiDernierDroitAreSpectacle;
  }
}

/* Location:
 * Qualified Name:     DomMigration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
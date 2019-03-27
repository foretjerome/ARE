package fr.unedic.cali.dom;

import fr.unedic.cali.dom.spec.ConventionGestionSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class ConventionGestion
  implements ConventionGestionSpec
{
  private String m_numeroConventionGestion;
  private String m_codeAffectation;
  private String m_applicationAides;
  private boolean m_estAideArce;
  private boolean m_estAideAdr;
  private boolean m_estAideCongeNonPaye;
  private boolean m_estAideFinDroit;
  private boolean m_estAideAllocationDeces;
  private String m_signataire;
  private BigDecimal m_tauxFraisGestion;
  private boolean m_estPrecompteCRC;
  private Damj m_debutValidite;
  private Damj m_finValidite;
  private String m_libelleAffectation;
  private boolean m_estIdExterneObligatoire;
  
  public ConventionGestion(String p_numeroConventionGestion, String p_codeAffectation, boolean p_estAideArce, boolean p_estAideAdr, boolean p_estAideCongeNonPaye, boolean p_estAideFinDroit, boolean p_estAideAllocationDeces, String p_signataire, boolean p_estPrecompteCRC, Damj p_debutValidite, Damj p_finValidite, String p_libelleAffecation, boolean p_estIdExterneObligatoire)
  {
    m_numeroConventionGestion = p_numeroConventionGestion;
    m_codeAffectation = p_codeAffectation;
    m_estAideArce = p_estAideArce;
    m_estAideAdr = p_estAideAdr;
    m_estAideCongeNonPaye = p_estAideCongeNonPaye;
    m_estAideFinDroit = p_estAideFinDroit;
    m_estAideAllocationDeces = p_estAideAllocationDeces;
    m_signataire = p_signataire;
    m_estPrecompteCRC = p_estPrecompteCRC;
    m_debutValidite = p_debutValidite;
    m_finValidite = p_finValidite;
    m_libelleAffectation = p_libelleAffecation;
    m_estIdExterneObligatoire = p_estIdExterneObligatoire;
  }
  
  public String getApplicationAides()
  {
    return m_applicationAides;
  }
  
  public void setApplicationAides(String p_applicationAides)
  {
    m_applicationAides = p_applicationAides;
  }
  
  public String getCodeAffectation()
  {
    return m_codeAffectation;
  }
  
  public void setCodeAffectation(String p_codeAffectation)
  {
    m_codeAffectation = p_codeAffectation;
  }
  
  public boolean estPrecompteCRC()
  {
    return m_estPrecompteCRC;
  }
  
  public void setEstPrecompteCRC(boolean p_estPrecompteCRC)
  {
    m_estPrecompteCRC = p_estPrecompteCRC;
  }
  
  public String getSignataire()
  {
    return m_signataire;
  }
  
  public void setSignataire(String p_signataire)
  {
    m_signataire = p_signataire;
  }
  
  public BigDecimal getTauxFraisGestion()
  {
    return m_tauxFraisGestion;
  }
  
  public void setTauxFraisGestion(BigDecimal p_tauxFraisGestion)
  {
    m_tauxFraisGestion = p_tauxFraisGestion;
  }
  
  public String getNumeroConventionGestion()
  {
    return m_numeroConventionGestion;
  }
  
  public void setNumeroConventionGestion(String p_numeroConventionGestion)
  {
    m_numeroConventionGestion = p_numeroConventionGestion;
  }
  
  public Damj getDebutValidite()
  {
    return m_debutValidite;
  }
  
  public void setDebutValidite(Damj p_debutValidite)
  {
    m_debutValidite = p_debutValidite;
  }
  
  public Damj getFinValidite()
  {
    return m_finValidite;
  }
  
  public void setFinValidite(Damj p_finValidite)
  {
    m_finValidite = p_finValidite;
  }
  
  public String getLibelleAffectation()
  {
    return m_libelleAffectation;
  }
  
  public void setLibelleAffectation(String p_libelleAffectation)
  {
    m_libelleAffectation = p_libelleAffectation;
  }
  
  public boolean isEstAideAdr()
  {
    return m_estAideAdr;
  }
  
  public void setEstAideAdr(boolean p_estAideAdr)
  {
    m_estAideAdr = p_estAideAdr;
  }
  
  public boolean isEstAideAllocationDeces()
  {
    return m_estAideAllocationDeces;
  }
  
  public void setEstAideAllocationDeces(boolean p_estAideAllocationDeces)
  {
    m_estAideAllocationDeces = p_estAideAllocationDeces;
  }
  
  public boolean isEstAideArce()
  {
    return m_estAideArce;
  }
  
  public void setEstAideArce(boolean p_estAideArce)
  {
    m_estAideArce = p_estAideArce;
  }
  
  public boolean isEstAideCongeNonPaye()
  {
    return m_estAideCongeNonPaye;
  }
  
  public void setEstAideCongeNonPaye(boolean p_estAideCongeNonPaye)
  {
    m_estAideCongeNonPaye = p_estAideCongeNonPaye;
  }
  
  public boolean isEstAideFinDroit()
  {
    return m_estAideFinDroit;
  }
  
  public void setEstAideFinDroit(boolean p_estAideFinDroit)
  {
    m_estAideFinDroit = p_estAideFinDroit;
  }
  
  public boolean estIdExterneObligatoire()
  {
    return m_estIdExterneObligatoire;
  }
  
  public void setEstIdExterneObligatoire(boolean p_estIdExterneObligatoire)
  {
    m_estIdExterneObligatoire = p_estIdExterneObligatoire;
  }
}

/* Location:
 * Qualified Name:     ConventionGestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
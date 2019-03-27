package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.List;

public class DomLireDemandesListe
{
  private String m_cxass;
  private BigDecimal m_fonctRappId;
  private String m_codePopulation;
  private BigDecimal m_cxalaf;
  private BigDecimal m_demandeId;
  private boolean m_estDecis;
  private boolean m_estImpacte;
  private String m_etatReexamen;
  private boolean m_estReexecute;
  private Damj m_dateAttrib;
  private BigDecimal m_codeProduit;
  private String m_typeDecis;
  private String m_typeDemande;
  private BigDecimal m_deltaPji;
  private BigDecimal m_deltaDji;
  private List m_listeEltComp;
  private boolean m_estMigree;
  private boolean m_estNeutralisee;
  private boolean m_estfigee;
  
  public List getListeEltComp()
  {
    return m_listeEltComp;
  }
  
  public void setListeEltComp(List p_listeEltComp)
  {
    m_listeEltComp = p_listeEltComp;
  }
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
  public BigDecimal getCodeProduit()
  {
    return m_codeProduit;
  }
  
  public void setCodeProduit(BigDecimal p_codeProduit)
  {
    m_codeProduit = p_codeProduit;
  }
  
  public BigDecimal getCxalaf()
  {
    return m_cxalaf;
  }
  
  public void setCxalaf(BigDecimal p_cxalaf)
  {
    m_cxalaf = p_cxalaf;
  }
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public Damj getDateAttrib()
  {
    return m_dateAttrib;
  }
  
  public void setDateAttrib(Damj p_dateAttrib)
  {
    m_dateAttrib = p_dateAttrib;
  }
  
  public BigDecimal getDeltaDji()
  {
    return m_deltaDji;
  }
  
  public void setDeltaDji(BigDecimal p_deltaDji)
  {
    m_deltaDji = p_deltaDji;
  }
  
  public BigDecimal getDeltaPji()
  {
    return m_deltaPji;
  }
  
  public void setDeltaPji(BigDecimal p_deltaPji)
  {
    m_deltaPji = p_deltaPji;
  }
  
  public BigDecimal getDemandeId()
  {
    return m_demandeId;
  }
  
  public void setDemandeId(BigDecimal p_demandeId)
  {
    m_demandeId = p_demandeId;
  }
  
  public boolean isEstDecis()
  {
    return m_estDecis;
  }
  
  public void setEstDecis(boolean p_estDecis)
  {
    m_estDecis = p_estDecis;
  }
  
  public boolean isEstImpacte()
  {
    return m_estImpacte;
  }
  
  public void setEstImpacte(boolean p_estImpacte)
  {
    m_estImpacte = p_estImpacte;
  }
  
  public boolean isEstReexecute()
  {
    return m_estReexecute;
  }
  
  public void setEstReexecute(boolean p_estReexecute)
  {
    m_estReexecute = p_estReexecute;
  }
  
  public String getEtatReexamen()
  {
    return m_etatReexamen;
  }
  
  public void setEtatReexamen(String p_etatReexamen)
  {
    m_etatReexamen = p_etatReexamen;
  }
  
  public BigDecimal getFonctRappId()
  {
    return m_fonctRappId;
  }
  
  public void setFonctRappId(BigDecimal p_fonctRappId)
  {
    m_fonctRappId = p_fonctRappId;
  }
  
  public String getTypeDecis()
  {
    return m_typeDecis;
  }
  
  public void setTypeDecis(String p_typeDecis)
  {
    m_typeDecis = p_typeDecis;
  }
  
  public String getTypeDemande()
  {
    return m_typeDemande;
  }
  
  public void setTypeDemande(String p_typeDemande)
  {
    m_typeDemande = p_typeDemande;
  }
  
  public boolean getEstMigree()
  {
    return m_estMigree;
  }
  
  public void setEstMigree(boolean p_estMigree)
  {
    m_estMigree = p_estMigree;
  }
  
  public boolean getEstNeutralisee()
  {
    return m_estNeutralisee;
  }
  
  public void setEstNeutralisee(boolean p_estNeutralisee)
  {
    m_estNeutralisee = p_estNeutralisee;
  }
  
  public boolean getEstFigee()
  {
    return m_estfigee;
  }
  
  public void setEstFigee(boolean p_estFigee)
  {
    m_estfigee = p_estFigee;
  }
}

/* Location:
 * Qualified Name:     DomLireDemandesListe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.dossiersLourds;

import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.util.services.Dom;

public class DomDossiersLourdsTesterServices
  implements Dom
{
  private AgregatGaec m_agregatGaec = null;
  private AppelGaecReduit m_appelGaecReduit = null;
  private boolean m_estDebrayage = false;
  private String m_messageErreur = null;
  
  public AgregatGaec getAgregatGaec()
  {
    return m_agregatGaec;
  }
  
  public void setAgregatGaec(AgregatGaec p_agregatGaec)
  {
    m_agregatGaec = p_agregatGaec;
  }
  
  public AppelGaecReduit getAppelGaecReduit()
  {
    return m_appelGaecReduit;
  }
  
  public void setAppelGaecReduit(AppelGaecReduit p_appelGaecReduit)
  {
    m_appelGaecReduit = p_appelGaecReduit;
  }
  
  public boolean isEstDebrayage()
  {
    return m_estDebrayage;
  }
  
  public void setEstDebrayage(boolean p_estDebrayage)
  {
    m_estDebrayage = p_estDebrayage;
  }
  
  public String getMessageErreur()
  {
    return m_messageErreur;
  }
  
  public void setMessageErreur(String p_messageErreur)
  {
    m_messageErreur = p_messageErreur;
  }
}

/* Location:
 * Qualified Name:     DomDossiersLourdsTesterServices
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
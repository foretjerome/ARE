package fr.unedic.cali.parcours;

public class DomLiquidationDemandeDude
  extends DomLiquidationDemande
  implements DomCali
{
  private String m_idDemandeV1 = null;
  
  public void copie(DomLiquidationDemandeDude p_src)
  {
    super.copie(p_src);
    setIdDemandeV1(p_src.getIdDemandeV1());
  }
  
  public String getIdDemandeV1()
  {
    return m_idDemandeV1;
  }
  
  public void setIdDemandeV1(String p_idDemandeV1)
  {
    m_idDemandeV1 = p_idDemandeV1;
  }
}

/* Location:
 * Qualified Name:     DomLiquidationDemandeDude
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
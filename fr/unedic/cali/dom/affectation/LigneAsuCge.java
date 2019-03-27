package fr.unedic.cali.dom.affectation;

public class LigneAsuCge
  extends LigneAbstrait
  implements FacadeLiquidationLigneAsuSpec
{
  private static final long serialVersionUID = 1L;
  private transient LigneAsuDelegueSpec m_ligneDelegue;
  
  public static String getLibelleCasGeneral()
  {
    return "Cas Général";
  }
  
  public LigneAsuDelegueSpec getLigneDelegue()
  {
    return m_ligneDelegue;
  }
  
  public void setLigneDelegue(LigneAsuDelegueSpec p_ligneDelegue)
  {
    m_ligneDelegue = p_ligneDelegue;
  }
  
  protected LigneAsuDelegueSpec creerLigneDelegue(String p_classeLigne)
  {
    LigneAsuDelegueSpec ligneDelegue = null;
    try
    {
      ligneDelegue = (LigneAsuDelegueSpec)Class.forName(p_classeLigne).newInstance();
    }
    catch (Exception e) {}
    return ligneDelegue;
  }
}

/* Location:
 * Qualified Name:     LigneAsuCge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
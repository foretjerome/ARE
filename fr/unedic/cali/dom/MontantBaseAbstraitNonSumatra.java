package fr.unedic.cali.dom;

import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.Quantite;

public abstract class MontantBaseAbstraitNonSumatra
  extends MontantBaseAbstrait
{
  private Quantite m_montantBrut;
  private Quantite m_crc;
  private boolean m_estAvecPrecompte;
  private MontantBaseAbstraitNonSumatraPC m_pc;
  
  public MontantBaseAbstraitNonSumatra() {}
  
  public MontantBaseAbstraitNonSumatra(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  protected DomPCSpec createPC()
  {
    m_pc = new MontantBaseAbstraitNonSumatraPC(this);
    return m_pc;
  }
  
  public DomPCSpec getPC()
  {
    return m_pc;
  }
  
  public Quantite getCrc()
  {
    return m_crc;
  }
  
  public Quantite getMontantBrut()
  {
    return m_montantBrut;
  }
  
  public boolean isEstAvecPrecompte()
  {
    return m_estAvecPrecompte;
  }
  
  public void setCrc(Quantite p_crc)
  {
    m_crc = p_crc;
  }
  
  public void setEstAvecPrecompte(boolean p_estAvecPrecompte)
  {
    m_estAvecPrecompte = p_estAvecPrecompte;
  }
  
  public void setMontantBrut(Quantite p_montantBrut)
  {
    m_montantBrut = p_montantBrut;
  }
}

/* Location:
 * Qualified Name:     MontantBaseAbstraitNonSumatra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
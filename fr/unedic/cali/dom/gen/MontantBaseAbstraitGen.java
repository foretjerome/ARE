package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pc.MontantBaseAbstraitPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;

public abstract class MontantBaseAbstraitGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_montantBaseAbstraitPC;
  private Quantite m_montantBrut;
  private Quantite m_crc;
  
  public MontantBaseAbstraitGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public MontantBaseAbstraitGen()
  {
    setPC(createPC());
  }
  
  protected abstract DomPCSpec createPC();
  
  public DomPCSpec getPC()
  {
    return m_montantBaseAbstraitPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_montantBaseAbstraitPC)
  {
    m_montantBaseAbstraitPC = p_montantBaseAbstraitPC;
  }
  
  protected Quantite rawGetMontantBrut()
  {
    return ((MontantBaseAbstraitPC)getPC()).getMontantBrut();
  }
  
  public Quantite getMontantBrut()
  {
    return ((MontantBaseAbstraitPC)getPC()).getMontantBrut();
  }
  
  public void setMontantBrut(Quantite p_montantBrut)
  {
    if ((m_montantBrut == null) || (p_montantBrut == null))
    {
      m_montantBrut = p_montantBrut;
      ((MontantBaseAbstraitPC)getPC()).setMontantBrut(p_montantBrut);
    }
    else if ((m_montantBrut != null) && (p_montantBrut != null) && (!p_montantBrut.equals(m_montantBrut)))
    {
      m_montantBrut = p_montantBrut;
      ((MontantBaseAbstraitPC)getPC()).setMontantBrut(p_montantBrut);
    }
  }
  
  protected Quantite rawGetCrc()
  {
    return ((MontantBaseAbstraitPC)getPC()).getCrc();
  }
  
  public Quantite getCrc()
  {
    return ((MontantBaseAbstraitPC)getPC()).getCrc();
  }
  
  public void setCrc(Quantite p_crc)
  {
    if ((m_crc == null) || (p_crc == null))
    {
      m_crc = p_crc;
      ((MontantBaseAbstraitPC)getPC()).setCrc(p_crc);
    }
    else if ((m_crc != null) && (p_crc != null) && (!p_crc.equals(m_crc)))
    {
      m_crc = p_crc;
      ((MontantBaseAbstraitPC)getPC()).setCrc(p_crc);
    }
  }
  
  protected boolean rawIsEstAvecPrecompte()
  {
    return ((MontantBaseAbstraitPC)getPC()).isEstAvecPrecompte();
  }
  
  public boolean isEstAvecPrecompte()
  {
    return ((MontantBaseAbstraitPC)getPC()).isEstAvecPrecompte();
  }
  
  public void setEstAvecPrecompte(boolean p_estAvecPrecompte)
  {
    ((MontantBaseAbstraitPC)getPC()).setEstAvecPrecompte(p_estAvecPrecompte);
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     MontantBaseAbstraitGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
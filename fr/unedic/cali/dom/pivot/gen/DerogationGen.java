package fr.unedic.cali.dom.pivot.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pivot.pc.DerogationPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class DerogationGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_derogationPC;
  private String m_typeDerogation;
  private String m_natureDerogation;
  
  public DerogationGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public DerogationGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new DerogationPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_derogationPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_derogationPC)
  {
    m_derogationPC = p_derogationPC;
  }
  
  protected String rawGetTypeDerogation()
  {
    return ((DerogationPC)getPC()).getTypeDerogation();
  }
  
  public String getTypeDerogation()
  {
    return ((DerogationPC)getPC()).getTypeDerogation();
  }
  
  public void setTypeDerogation(String p_typeDerogation)
  {
    if ((m_typeDerogation == null) || (p_typeDerogation == null))
    {
      m_typeDerogation = p_typeDerogation;
      ((DerogationPC)getPC()).setTypeDerogation(p_typeDerogation);
    }
    else if ((m_typeDerogation != null) && (p_typeDerogation != null) && (!p_typeDerogation.equals(m_typeDerogation)))
    {
      m_typeDerogation = p_typeDerogation;
      ((DerogationPC)getPC()).setTypeDerogation(p_typeDerogation);
    }
  }
  
  protected String rawGetNatureDerogation()
  {
    return ((DerogationPC)getPC()).getNatureDerogation();
  }
  
  public String getNatureDerogation()
  {
    return ((DerogationPC)getPC()).getNatureDerogation();
  }
  
  public void setNatureDerogation(String p_natureDerogation)
  {
    if ((m_natureDerogation == null) || (p_natureDerogation == null))
    {
      m_natureDerogation = p_natureDerogation;
      ((DerogationPC)getPC()).setNatureDerogation(p_natureDerogation);
    }
    else if ((m_natureDerogation != null) && (p_natureDerogation != null) && (!p_natureDerogation.equals(m_natureDerogation)))
    {
      m_natureDerogation = p_natureDerogation;
      ((DerogationPC)getPC()).setNatureDerogation(p_natureDerogation);
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
 * Qualified Name:     DerogationGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
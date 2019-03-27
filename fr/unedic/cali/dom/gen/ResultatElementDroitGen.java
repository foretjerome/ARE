package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pc.ResultatElementDroitPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class ResultatElementDroitGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_resultatElementDroitPC;
  
  public ResultatElementDroitGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public ResultatElementDroitGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new ResultatElementDroitPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_resultatElementDroitPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_resultatElementDroitPC)
  {
    m_resultatElementDroitPC = p_resultatElementDroitPC;
  }
  
  protected int rawGetCodeMotifEchec()
  {
    return ((ResultatElementDroitPC)getPC()).getCodeMotifEchec();
  }
  
  public int getCodeMotifEchec()
  {
    return ((ResultatElementDroitPC)getPC()).getCodeMotifEchec();
  }
  
  public void setCodeMotifEchec(int p_codeMotifEchec)
  {
    ((ResultatElementDroitPC)getPC()).setCodeMotifEchec(p_codeMotifEchec);
  }
  
  protected int rawGetEtat()
  {
    return ((ResultatElementDroitPC)getPC()).getEtat();
  }
  
  public int getEtat()
  {
    return ((ResultatElementDroitPC)getPC()).getEtat();
  }
  
  public void setEtat(int p_etat)
  {
    ((ResultatElementDroitPC)getPC()).setEtat(p_etat);
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     ResultatElementDroitGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
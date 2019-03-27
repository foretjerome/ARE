package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.pc.ClassementSansSuitePC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class ClassementSansSuiteGen
  extends ClassementAdministratif
  implements DomGenSpec
{
  private String m_motif;
  
  public ClassementSansSuiteGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public ClassementSansSuiteGen() {}
  
  protected DomPCSpec createPC()
  {
    return new ClassementSansSuitePC();
  }
  
  protected String rawGetMotif()
  {
    return ((ClassementSansSuitePC)getPC()).getMotif();
  }
  
  public String getMotif()
  {
    return ((ClassementSansSuitePC)getPC()).getMotif();
  }
  
  public void setMotif(String p_motif)
  {
    if ((m_motif == null) || (p_motif == null))
    {
      m_motif = p_motif;
      ((ClassementSansSuitePC)getPC()).setMotif(p_motif);
    }
    else if ((m_motif != null) && (p_motif != null) && (!p_motif.equals(m_motif)))
    {
      m_motif = p_motif;
      ((ClassementSansSuitePC)getPC()).setMotif(p_motif);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     ClassementSansSuiteGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
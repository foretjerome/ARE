package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.pc.ClassementCompetenceSecteurPublicPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class ClassementCompetenceSecteurPublicGen
  extends ClassementAdministratif
  implements DomGenSpec
{
  private String m_employeurCompetent;
  
  public ClassementCompetenceSecteurPublicGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public ClassementCompetenceSecteurPublicGen() {}
  
  protected DomPCSpec createPC()
  {
    return new ClassementCompetenceSecteurPublicPC();
  }
  
  protected int rawGetMotifNotification()
  {
    return ((ClassementCompetenceSecteurPublicPC)getPC()).getMotifNotification();
  }
  
  public int getMotifNotification()
  {
    return ((ClassementCompetenceSecteurPublicPC)getPC()).getMotifNotification();
  }
  
  public void setMotifNotification(int p_motifNotification)
  {
    ((ClassementCompetenceSecteurPublicPC)getPC()).setMotifNotification(p_motifNotification);
  }
  
  protected String rawGetEmployeurCompetent()
  {
    return ((ClassementCompetenceSecteurPublicPC)getPC()).getEmployeurCompetent();
  }
  
  public String getEmployeurCompetent()
  {
    return ((ClassementCompetenceSecteurPublicPC)getPC()).getEmployeurCompetent();
  }
  
  public void setEmployeurCompetent(String p_employeurCompetent)
  {
    if ((m_employeurCompetent == null) || (p_employeurCompetent == null))
    {
      m_employeurCompetent = p_employeurCompetent;
      ((ClassementCompetenceSecteurPublicPC)getPC()).setEmployeurCompetent(p_employeurCompetent);
    }
    else if ((m_employeurCompetent != null) && (p_employeurCompetent != null) && (!p_employeurCompetent.equals(m_employeurCompetent)))
    {
      m_employeurCompetent = p_employeurCompetent;
      ((ClassementCompetenceSecteurPublicPC)getPC()).setEmployeurCompetent(p_employeurCompetent);
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
 * Qualified Name:     ClassementCompetenceSecteurPublicGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
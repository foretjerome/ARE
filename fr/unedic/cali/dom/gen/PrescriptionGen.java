package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.pc.PrescriptionPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class PrescriptionGen
  extends ClassementAdministratif
  implements DomGenSpec
{
  private String m_motifRejetPrescription = "";
  
  public PrescriptionGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public PrescriptionGen() {}
  
  protected DomPCSpec createPC()
  {
    return new PrescriptionPC();
  }
  
  protected boolean rawIsValidite()
  {
    return ((PrescriptionPC)getPC()).isValidite();
  }
  
  public boolean isValidite()
  {
    return ((PrescriptionPC)getPC()).isValidite();
  }
  
  public void setValidite(boolean p_validite)
  {
    ((PrescriptionPC)getPC()).setValidite(p_validite);
  }
  
  protected String rawGetMotifRejetPrescription()
  {
    return ((PrescriptionPC)getPC()).getMotifRejetPrescription();
  }
  
  public String getMotifRejetPrescription()
  {
    return ((PrescriptionPC)getPC()).getMotifRejetPrescription();
  }
  
  public void setMotifRejetPrescription(String p_motifRejetPrescription)
  {
    if ((m_motifRejetPrescription == null) || (p_motifRejetPrescription == null))
    {
      m_motifRejetPrescription = p_motifRejetPrescription;
      ((PrescriptionPC)getPC()).setMotifRejetPrescription(p_motifRejetPrescription);
    }
    else if ((m_motifRejetPrescription != null) && (p_motifRejetPrescription != null) && (!p_motifRejetPrescription.equals(m_motifRejetPrescription)))
    {
      m_motifRejetPrescription = p_motifRejetPrescription;
      ((PrescriptionPC)getPC()).setMotifRejetPrescription(p_motifRejetPrescription);
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
 * Qualified Name:     PrescriptionGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.PrescriptionGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class Prescription
  extends PrescriptionGen
{
  private static final long serialVersionUID = 2189735736831094121L;
  
  public Prescription() {}
  
  public Prescription(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getTypeClassement()
  {
    return "PS";
  }
  
  public boolean isValidite()
  {
    return estClassementValide();
  }
  
  public ObjetMetierSpec copie()
  {
    Prescription copie = new Prescription();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
    ((Prescription)p_copie).setMotifRejetPrescription(getMotifRejetPrescription());
    ((Prescription)p_copie).setValidite(isValidite());
  }
  
  public boolean estClassementValide()
  {
    return super.isValidite();
  }
  
  public void marquerGraphePersistant() {}
}

/* Location:
 * Qualified Name:     Prescription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
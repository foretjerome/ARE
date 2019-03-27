package fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.EnveloppeAidesSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.enveloppe.dom.spec.StructureOutEnveloppeSpec;

public class StructureOutEnveloppe
  implements StructureOutEnveloppeSpec
{
  private EnveloppeAidesSpec enveloppeAides;
  
  public EnveloppeAidesSpec getEnveloppeAides()
  {
    return enveloppeAides;
  }
  
  public void setEnveloppeAides(EnveloppeAidesSpec p_enveloppeAides)
  {
    enveloppeAides = p_enveloppeAides;
  }
}

/* Location:
 * Qualified Name:     StructureOutEnveloppe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
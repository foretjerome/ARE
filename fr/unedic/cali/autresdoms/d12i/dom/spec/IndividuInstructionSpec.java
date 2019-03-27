package fr.unedic.cali.autresdoms.d12i.dom.spec;

import fr.unedic.cali.autresdoms.d12i.dom.DemandeInstruction;
import fr.unedic.cali.dom.IndividuDomaineSpec;

public abstract interface IndividuInstructionSpec
  extends IndividuDomaineSpec
{
  public abstract DemandeInstruction getDemandeInstruction(String paramString);
}

/* Location:
 * Qualified Name:     IndividuInstructionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
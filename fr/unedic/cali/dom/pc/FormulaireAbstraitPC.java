package fr.unedic.cali.dom.pc;

import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.temps.ObjetChronoEvenementDebutPC;

public abstract class FormulaireAbstraitPC
  extends ObjetChronoEvenementDebutPC
  implements DomPCSpec
{
  protected String m_motifEnvoi;
  
  public abstract Object createOM();
  
  public String getMotifEnvoi()
  {
    return m_motifEnvoi;
  }
  
  public final void setMotifEnvoi(String p_motifEnvoi)
  {
    m_motifEnvoi = p_motifEnvoi;
  }
}

/* Location:
 * Qualified Name:     FormulaireAbstraitPC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
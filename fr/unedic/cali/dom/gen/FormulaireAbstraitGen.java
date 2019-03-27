package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pc.FormulaireAbstraitPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.ObjetChronoEvenementDebutCREM;

public abstract class FormulaireAbstraitGen
  extends ObjetChronoEvenementDebutCREM
  implements DomGenSpec
{
  private String m_motifEnvoi;
  
  public FormulaireAbstraitGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public FormulaireAbstraitGen() {}
  
  protected abstract DomPCSpec createPC();
  
  protected String rawGetMotifEnvoi()
  {
    return ((FormulaireAbstraitPC)getPC()).getMotifEnvoi();
  }
  
  public String getMotifEnvoi()
  {
    return ((FormulaireAbstraitPC)getPC()).getMotifEnvoi();
  }
  
  public void setMotifEnvoi(String p_motifEnvoi)
  {
    if ((m_motifEnvoi == null) || (p_motifEnvoi == null))
    {
      m_motifEnvoi = p_motifEnvoi;
      ((FormulaireAbstraitPC)getPC()).setMotifEnvoi(p_motifEnvoi);
    }
    else if ((m_motifEnvoi != null) && (p_motifEnvoi != null) && (!p_motifEnvoi.equals(m_motifEnvoi)))
    {
      m_motifEnvoi = p_motifEnvoi;
      ((FormulaireAbstraitPC)getPC()).setMotifEnvoi(p_motifEnvoi);
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
 * Qualified Name:     FormulaireAbstraitGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
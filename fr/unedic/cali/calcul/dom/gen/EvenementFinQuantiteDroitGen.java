package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.pc.EvenementFinQuantiteDroitPC;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebutCREM;

public abstract class EvenementFinQuantiteDroitGen
  extends ObjetChronoEvenementDebutCREM
  implements DomGenSpec
{
  private QuantiteDroitSpec m_quantiteDroit;
  private String m_typeQuantiteDroit;
  
  public EvenementFinQuantiteDroitGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public EvenementFinQuantiteDroitGen() {}
  
  public EvenementFinQuantiteDroitGen(Damj p_date)
  {
    super(p_date);
  }
  
  protected abstract DomPCSpec createPC();
  
  public QuantiteDroitSpec getQuantiteDroit()
  {
    if (m_quantiteDroit == null)
    {
      DomPCSpec quantiteDroitPC = ((EvenementFinQuantiteDroitPC)getPC()).getQuantiteDroit();
      if (quantiteDroitPC != null) {
        m_quantiteDroit = ((QuantiteDroitSpec)quantiteDroitPC.createOM());
      }
    }
    return m_quantiteDroit;
  }
  
  public void setQuantiteDroit(QuantiteDroitSpec p_quantiteDroit)
  {
    if (p_quantiteDroit == null)
    {
      ((EvenementFinQuantiteDroitPC)getPC()).setQuantiteDroit(null);
      m_quantiteDroit = p_quantiteDroit;
    }
    else if (!p_quantiteDroit.equals(m_quantiteDroit))
    {
      ((EvenementFinQuantiteDroitPC)getPC()).setQuantiteDroit(((DomGenSpec)p_quantiteDroit).getPC());
      m_quantiteDroit = p_quantiteDroit;
    }
  }
  
  protected String rawGetTypeQuantiteDroit()
  {
    return ((EvenementFinQuantiteDroitPC)getPC()).getTypeQuantiteDroit();
  }
  
  public String getTypeQuantiteDroit()
  {
    return ((EvenementFinQuantiteDroitPC)getPC()).getTypeQuantiteDroit();
  }
  
  public void setTypeQuantiteDroit(String p_typeQuantiteDroit)
  {
    if ((m_typeQuantiteDroit == null) || (p_typeQuantiteDroit == null))
    {
      m_typeQuantiteDroit = p_typeQuantiteDroit;
      ((EvenementFinQuantiteDroitPC)getPC()).setTypeQuantiteDroit(p_typeQuantiteDroit);
    }
    else if ((m_typeQuantiteDroit != null) && (p_typeQuantiteDroit != null) && (!p_typeQuantiteDroit.equals(m_typeQuantiteDroit)))
    {
      m_typeQuantiteDroit = p_typeQuantiteDroit;
      ((EvenementFinQuantiteDroitPC)getPC()).setTypeQuantiteDroit(p_typeQuantiteDroit);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
    
    Object quantiteDroit = getQuantiteDroit();
    if ((quantiteDroit != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(quantiteDroit))) {
      DomManager.supprimer(getQuantiteDroit(), p_contexteSuppression);
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     EvenementFinQuantiteDroitGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
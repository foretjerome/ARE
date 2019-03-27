package fr.unedic.cali.dom;

import fr.unedic.util.ObjetMetierSpec;
import org.apache.commons.lang.builder.EqualsBuilder;

public class ElementComparaisonReexamen
  implements ObjetMetierSpec
{
  private String m_libelleElement = null;
  private Object m_valeurAvantReexamen = null;
  private Object m_valeurApresReexamen = null;
  
  public ElementComparaisonReexamen() {}
  
  public ElementComparaisonReexamen(String p_libelle, Object p_valeurAvant, Object p_valeurApres)
  {
    setLibelleElement(p_libelle);
    setValeurAvantReexamen(p_valeurAvant);
    setValeurApresReexamen(p_valeurApres);
  }
  
  public String getLibelleElement()
  {
    return m_libelleElement;
  }
  
  public void setLibelleElement(String p_libelleElement)
  {
    m_libelleElement = p_libelleElement;
  }
  
  public Object getValeurApresReexamen()
  {
    return m_valeurApresReexamen;
  }
  
  public void setValeurApresReexamen(Object p_valeurApresReexamen)
  {
    m_valeurApresReexamen = p_valeurApresReexamen;
  }
  
  public Object getValeurAvantReexamen()
  {
    return m_valeurAvantReexamen;
  }
  
  public void setValeurAvantReexamen(Object p_valeurAvantReexamen)
  {
    m_valeurAvantReexamen = p_valeurAvantReexamen;
  }
  
  public ObjetMetierSpec copie()
  {
    ElementComparaisonReexamen copie = new ElementComparaisonReexamen();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ElementComparaisonReexamen copie = (ElementComparaisonReexamen)p_copie;
    
    copie.setLibelleElement(getLibelleElement());
    copie.setValeurAvantReexamen(getValeurAvantReexamen());
    copie.setValeurApresReexamen(getValeurApresReexamen());
  }
  
  public boolean estIdentiqueA(Object p_arg0)
  {
    if (!(p_arg0 instanceof ElementComparaisonReexamen)) {
      return false;
    }
    ElementComparaisonReexamen element = (ElementComparaisonReexamen)p_arg0;
    
    EqualsBuilder eqb = new EqualsBuilder();
    
    return eqb.append(getLibelleElement(), element.getLibelleElement()).append(getValeurAvantReexamen(), element.getValeurAvantReexamen()).append(getValeurApresReexamen(), element.getValeurApresReexamen()).isEquals();
  }
}

/* Location:
 * Qualified Name:     ElementComparaisonReexamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
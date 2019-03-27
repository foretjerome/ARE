package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.cre.TypeModification;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class ElementComparaisonCREM
{
  private String m_libelleElement = null;
  private String m_valeurAvantCREM = null;
  private String m_valeurApresCREM = null;
  private TypeModification m_typeModification = TypeModification.SANS_MODIFICATION;
  public static final String VALEUR_VIDE = "";
  
  public ElementComparaisonCREM() {}
  
  public ElementComparaisonCREM(String p_libelle, String p_valeurAvant, String p_valeurApres)
  {
    setLibelleElement(p_libelle);
    m_valeurAvantCREM = p_valeurAvant;
    m_valeurApresCREM = p_valeurApres;
    
    determinerTypeModification();
  }
  
  public void determinerTypeModification()
  {
    if (getValeurAvantCREM().equalsIgnoreCase(""))
    {
      if (getValeurApresCREM().equalsIgnoreCase("")) {
        m_typeModification = TypeModification.SANS_MODIFICATION;
      } else {
        m_typeModification = TypeModification.CREATION;
      }
    }
    else if (getValeurApresCREM().equalsIgnoreCase("")) {
      m_typeModification = TypeModification.SUPPRESSION;
    } else if (getValeurAvantCREM().equalsIgnoreCase(getValeurApresCREM())) {
      m_typeModification = TypeModification.SANS_MODIFICATION;
    } else {
      m_typeModification = TypeModification.MODIFICATION;
    }
  }
  
  public String getLibelleElement()
  {
    return m_libelleElement;
  }
  
  public void setLibelleElement(String p_libelleElement)
  {
    m_libelleElement = p_libelleElement;
  }
  
  public String toString()
  {
    return new String("ElementComparaisonCREM : [" + getValeurAvantCREM() + ":" + getValeurApresCREM() + "] => " + getTypeModification().getValeur());
  }
  
  public boolean equals(Object p_arg0)
  {
    if (!(p_arg0 instanceof ElementComparaisonCREM)) {
      return false;
    }
    ElementComparaisonCREM element = (ElementComparaisonCREM)p_arg0;
    
    EqualsBuilder eqb = new EqualsBuilder();
    
    return eqb.append(getLibelleElement(), element.getLibelleElement()).append(getValeurAvantCREM(), element.getValeurAvantCREM()).append(getValeurApresCREM(), element.getValeurApresCREM()).isEquals();
  }
  
  public int hashCode()
  {
    HashCodeBuilder hcb = new HashCodeBuilder();
    
    return hcb.append(getLibelleElement()).append(getValeurAvantCREM()).append(getValeurApresCREM()).toHashCode();
  }
  
  public String getValeurApresCREM()
  {
    return m_valeurApresCREM;
  }
  
  public void setValeurApresCREM(String p_valeurApresCREM)
  {
    m_valeurApresCREM = p_valeurApresCREM;
    determinerTypeModification();
  }
  
  public String getValeurAvantCREM()
  {
    return m_valeurAvantCREM;
  }
  
  public void setValeurAvantCREM(String p_valeurAvantCREM)
  {
    m_valeurAvantCREM = p_valeurAvantCREM;
    determinerTypeModification();
  }
  
  public TypeModification getTypeModification()
  {
    return m_typeModification;
  }
  
  public void setTypeModification(TypeModification p_typeModification)
  {
    m_typeModification = p_typeModification;
    determinerTypeModification();
  }
}

/* Location:
 * Qualified Name:     ElementComparaisonCREM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
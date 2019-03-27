package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.conteneurs.spec.DonneesResultatDeterminationSjrSpec;
import fr.unedic.cali.util.OutilDomToString;
import java.math.BigDecimal;
import java.util.Hashtable;

public abstract class DonneesResultatDeterminationSjrAbstrait
  implements DonneesResultatDeterminationSjrSpec
{
  private BigDecimal m_sjri;
  private BigDecimal m_plafondSjr;
  private Hashtable m_listeAlertesNonBloquantes;
  
  public Hashtable getListeAlertesNonBloquantes()
  {
    if (m_listeAlertesNonBloquantes == null) {
      m_listeAlertesNonBloquantes = new Hashtable();
    }
    return m_listeAlertesNonBloquantes;
  }
  
  public void setListeAlertesNonBloquantes(Hashtable p_listeAlertesNonBloquantes)
  {
    m_listeAlertesNonBloquantes = p_listeAlertesNonBloquantes;
  }
  
  public BigDecimal getPlafondSjr()
  {
    return m_plafondSjr;
  }
  
  public void setPlafondSjr(BigDecimal p_plafondSjr)
  {
    m_plafondSjr = p_plafondSjr;
  }
  
  public BigDecimal getSjri()
  {
    return m_sjri;
  }
  
  public void setSjri(BigDecimal p_sjri)
  {
    m_sjri = p_sjri;
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
}

/* Location:
 * Qualified Name:     DonneesResultatDeterminationSjrAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
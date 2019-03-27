package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.conteneurs.spec.DonneesResultatDeterminationSjcSpec;
import fr.unedic.cali.util.OutilDomToString;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;

public class DonneesResultatDeterminationSjc
  implements DonneesResultatDeterminationSjcSpec
{
  private BigDecimal m_sjci;
  private ArrayList m_listeSjrActiviteConservee;
  private Hashtable m_listeDonneesResultatDeterminationSjr;
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
  
  public Hashtable getListeDonneesResultatDeterminationSjr()
  {
    if (m_listeDonneesResultatDeterminationSjr == null) {
      m_listeDonneesResultatDeterminationSjr = new Hashtable();
    }
    return m_listeDonneesResultatDeterminationSjr;
  }
  
  public void setListeDonneesResultatDeterminationSjr(Hashtable p_listeDonneesResultatDeterminationSjr)
  {
    m_listeDonneesResultatDeterminationSjr = p_listeDonneesResultatDeterminationSjr;
  }
  
  public ArrayList getListeSjrActiviteConservee()
  {
    if (m_listeSjrActiviteConservee == null) {
      m_listeSjrActiviteConservee = new ArrayList();
    }
    return m_listeSjrActiviteConservee;
  }
  
  public void setListeSjrActiviteConservee(ArrayList p_listeSjrActiviteConservee)
  {
    m_listeSjrActiviteConservee = p_listeSjrActiviteConservee;
  }
  
  public BigDecimal getSjci()
  {
    return m_sjci;
  }
  
  public void setSjci(BigDecimal p_sjci)
  {
    m_sjci = p_sjci;
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
}

/* Location:
 * Qualified Name:     DonneesResultatDeterminationSjc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
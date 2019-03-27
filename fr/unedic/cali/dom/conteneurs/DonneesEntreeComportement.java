package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeComportementSpec;
import fr.unedic.cali.fabriques.FabriqueOutilFonctionnelSpec;
import fr.unedic.cali.util.OutilDomToString;

public class DonneesEntreeComportement
  implements DonneesEntreeComportementSpec
{
  private int m_typeTraitementAppelant = 0;
  private FabriqueOutilFonctionnelSpec m_fabriqueOutilFonctionnel = null;
  private boolean m_justifierSjr = false;
  private boolean m_retournerResultatSimplifieSjr = false;
  private boolean m_appliquerPlafondSrPrc = false;
  
  public int getTypeTraitementAppelant()
  {
    return m_typeTraitementAppelant;
  }
  
  public void setTypeTraitementAppelant(int p_typeTraitementAppelant)
  {
    m_typeTraitementAppelant = p_typeTraitementAppelant;
  }
  
  public FabriqueOutilFonctionnelSpec getFabriqueOutilFonctionnel()
  {
    return m_fabriqueOutilFonctionnel;
  }
  
  public void setFabriqueOutilFonctionnel(FabriqueOutilFonctionnelSpec p_fabriqueOutilFonctionnel)
  {
    m_fabriqueOutilFonctionnel = p_fabriqueOutilFonctionnel;
  }
  
  public boolean isJustifierSjr()
  {
    return m_justifierSjr;
  }
  
  public void setJustifierSjr(boolean p_justifierSjr)
  {
    m_justifierSjr = p_justifierSjr;
  }
  
  public boolean isRetournerResultatSimplifieSjr()
  {
    return m_retournerResultatSimplifieSjr;
  }
  
  public void setRetournerResultatSimplifieSjr(boolean p_retournerResultatSimplifieSjr)
  {
    m_retournerResultatSimplifieSjr = p_retournerResultatSimplifieSjr;
  }
  
  public boolean isAppliquerPlafondSrPrc()
  {
    return m_appliquerPlafondSrPrc;
  }
  
  public void setAppliquerPlafondSrPrc(boolean p_appliquerPlafondSrPrc)
  {
    m_appliquerPlafondSrPrc = p_appliquerPlafondSrPrc;
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeComportement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
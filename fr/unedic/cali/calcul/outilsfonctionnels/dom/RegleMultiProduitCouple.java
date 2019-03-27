package fr.unedic.cali.calcul.outilsfonctionnels.dom;

public class RegleMultiProduitCouple
  implements RegleMultiProduitCoupleSpec
{
  int m_typeRegle = 0;
  String m_nomPremier = null;
  int m_typePremier = 0;
  String m_nomDeuxieme = null;
  int m_typeDeuxieme = 0;
  
  public RegleMultiProduitCouple(int p_typeRegle, String p_nomPremier, int p_typePremier, String p_nomDeuxieme, int p_typeDeuxieme)
  {
    m_typeRegle = p_typeRegle;
    m_nomPremier = p_nomPremier;
    m_typePremier = p_typePremier;
    m_nomDeuxieme = p_nomDeuxieme;
    m_typeDeuxieme = p_typeDeuxieme;
  }
  
  public String getNomPremier()
  {
    return m_nomPremier;
  }
  
  public String getNomDeuxieme()
  {
    return m_nomDeuxieme;
  }
  
  public int getTypePremier()
  {
    return m_typePremier;
  }
  
  public int getTypeDeuxieme()
  {
    return m_typeDeuxieme;
  }
  
  public int getTypeRegle()
  {
    return m_typeRegle;
  }
}

/* Location:
 * Qualified Name:     RegleMultiProduitCouple
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
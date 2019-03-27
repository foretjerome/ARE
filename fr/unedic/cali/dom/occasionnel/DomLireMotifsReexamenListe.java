package fr.unedic.cali.dom.occasionnel;

import java.math.BigDecimal;

public class DomLireMotifsReexamenListe
{
  private String m_produit;
  private BigDecimal m_motifReexamen;
  private BigDecimal m_nombre;
  
  public BigDecimal getMotifReexamen()
  {
    return m_motifReexamen;
  }
  
  public void setMotifReexamen(BigDecimal p_motifReexamen)
  {
    m_motifReexamen = p_motifReexamen;
  }
  
  public BigDecimal getNombre()
  {
    return m_nombre;
  }
  
  public void setNombre(BigDecimal p_nombre)
  {
    m_nombre = p_nombre;
  }
  
  public String getProduit()
  {
    return m_produit;
  }
  
  public void setProduit(String p_produit)
  {
    m_produit = p_produit;
  }
}

/* Location:
 * Qualified Name:     DomLireMotifsReexamenListe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
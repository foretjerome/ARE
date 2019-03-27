package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.affectation.ProduitSpec;

public class CriteresStrategiePlafonnementAffiliation
  extends CritereStrategie
{
  private ProduitSpec m_produit;
  
  public ProduitSpec getProduit()
  {
    return m_produit;
  }
  
  public void setProduit(ProduitSpec p_produit)
  {
    m_produit = p_produit;
  }
}

/* Location:
 * Qualified Name:     CriteresStrategiePlafonnementAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
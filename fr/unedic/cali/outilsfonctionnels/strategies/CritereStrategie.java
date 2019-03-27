package fr.unedic.cali.outilsfonctionnels.strategies;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.Damj;

public class CritereStrategie
{
  private Damj datePivot = null;
  private Damj datePivotComplementaire = null;
  private DemandeSpec demande = null;
  private boolean produitSpectacle = false;
  private ProduitSpec produit;
  
  public Damj getDatePivot()
  {
    return datePivot;
  }
  
  public void setDatePivot(Damj datePivot)
  {
    this.datePivot = datePivot;
  }
  
  public Damj getDatePivotComplementaire()
  {
    return datePivotComplementaire;
  }
  
  public void setDatePivotComplementaire(Damj datePivotComplementaire)
  {
    this.datePivotComplementaire = datePivotComplementaire;
  }
  
  public DemandeSpec getDemande()
  {
    return demande;
  }
  
  public void setDemande(DemandeSpec demande)
  {
    this.demande = demande;
  }
  
  public boolean isProduitSpectacle()
  {
    return produitSpectacle;
  }
  
  public void setProduitSpectacle(boolean produitSpectacle)
  {
    this.produitSpectacle = produitSpectacle;
  }
  
  public ProduitSpec getProduit()
  {
    return produit;
  }
  
  public void setProduit(ProduitSpec produit)
  {
    this.produit = produit;
  }
}

/* Location:
 * Qualified Name:     CritereStrategie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
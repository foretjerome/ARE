package fr.unedic.cali.parcours;

import fr.unedic.util.Quantite;

public abstract interface ResultatMigrationCalculProduitSpec
{
  public abstract Quantite getReliquatDureeIndemnisation();
  
  public abstract void setReliquatDureeIndemnisation(Quantite paramQuantite);
  
  public abstract int getCumulMoisActiviteReduite();
  
  public abstract void setCumulMoisActiviteReduite(int paramInt);
  
  public abstract int getCumulHeureActiviteReduite();
  
  public abstract void setCumulHeureActiviteReduite(int paramInt);
  
  public abstract Quantite getMontantJourBrutDJI();
  
  public abstract void setMontantJourBrutDJI(Quantite paramQuantite);
}

/* Location:
 * Qualified Name:     ResultatMigrationCalculProduitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
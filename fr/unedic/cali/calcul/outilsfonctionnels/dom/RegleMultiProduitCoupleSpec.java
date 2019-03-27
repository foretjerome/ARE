package fr.unedic.cali.calcul.outilsfonctionnels.dom;

public abstract interface RegleMultiProduitCoupleSpec
  extends RegleMultiProduitSpec
{
  public static final int TYPE_GAMME = 1;
  public static final int TYPE_LIGNE = 2;
  public static final int TYPE_PRODUIT = 3;
  
  public abstract String getNomPremier();
  
  public abstract int getTypePremier();
  
  public abstract String getNomDeuxieme();
  
  public abstract int getTypeDeuxieme();
}

/* Location:
 * Qualified Name:     RegleMultiProduitCoupleSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
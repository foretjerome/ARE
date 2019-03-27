package fr.unedic.cali.dom.conteneurs.spec;

import fr.unedic.cali.fabriques.FabriqueOutilFonctionnelSpec;

public abstract interface DonneesEntreeComportementSpec
{
  public static final int TYPE_TRAITEMENT_AUCUN = 0;
  public static final int TYPE_TRAITEMENT_DETERMINATION_SJR = 1;
  public static final int TYPE_TRAITEMENT_DETERMINATION_SJC = 2;
  
  public abstract int getTypeTraitementAppelant();
  
  public abstract void setTypeTraitementAppelant(int paramInt);
  
  public abstract FabriqueOutilFonctionnelSpec getFabriqueOutilFonctionnel();
  
  public abstract void setFabriqueOutilFonctionnel(FabriqueOutilFonctionnelSpec paramFabriqueOutilFonctionnelSpec);
  
  public abstract boolean isJustifierSjr();
  
  public abstract void setJustifierSjr(boolean paramBoolean);
  
  public abstract boolean isRetournerResultatSimplifieSjr();
  
  public abstract void setRetournerResultatSimplifieSjr(boolean paramBoolean);
  
  public abstract boolean isAppliquerPlafondSrPrc();
  
  public abstract void setAppliquerPlafondSrPrc(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     DonneesEntreeComportementSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
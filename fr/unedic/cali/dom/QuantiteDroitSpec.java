package fr.unedic.cali.dom;

import fr.unedic.util.Quantite;

public abstract interface QuantiteDroitSpec
  extends ObjetPersistantSpec
{
  public abstract void activer();
  
  public abstract void inactiver();
  
  public abstract boolean estType(Class paramClass);
  
  public abstract EtatQuantiteDroit getEtatQuantiteDroit();
  
  public abstract int getEtat();
  
  public abstract Quantite getQuantiteCourante();
  
  public abstract Quantite getQuantiteInitial();
  
  public abstract void setEtat(int paramInt);
  
  public abstract void setQuantiteCourante(Quantite paramQuantite);
  
  public abstract void setQuantiteInitial(Quantite paramQuantite);
  
  public abstract void epuiser();
  
  public abstract boolean estStrictementType(Class paramClass);
  
  public abstract void imputer(Quantite paramQuantite);
  
  public abstract ImputationSpec simulerImputer(Quantite paramQuantite);
}

/* Location:
 * Qualified Name:     QuantiteDroitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
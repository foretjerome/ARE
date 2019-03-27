package fr.unedic.cali.dom;

public abstract interface ElementDroitSpec
  extends ObjetPersistantSpec
{
  public abstract boolean estSatisfait();
  
  public abstract void setEtatSatisfait(boolean paramBoolean);
  
  public abstract int getCodeMotifEchec();
  
  public abstract void setCodeMotifEchec(int paramInt);
}

/* Location:
 * Qualified Name:     ElementDroitSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom;

public abstract interface RevisionSpec
  extends AttributionSpec
{
  public static final int TYPE_REVISION_AVANT_ARE14 = 1;
  public static final int TYPE_REVISION_APRES_ARE14 = 2;
  
  public abstract int getType();
  
  public abstract boolean porteUnRejetDv();
}

/* Location:
 * Qualified Name:     RevisionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
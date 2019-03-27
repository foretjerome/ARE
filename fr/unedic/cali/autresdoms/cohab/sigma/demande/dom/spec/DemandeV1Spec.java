package fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec;

public abstract interface DemandeV1Spec
  extends DemandeSpec
{
  public static final int LONGUEUR_IDENTIFIANT_PEC = 4;
  public static final int LONGUEUR_RANG = 3;
  
  public abstract String getReferenceExterne();
  
  public abstract void setReferenceExterne(String paramString);
}

/* Location:
 * Qualified Name:     DemandeV1Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
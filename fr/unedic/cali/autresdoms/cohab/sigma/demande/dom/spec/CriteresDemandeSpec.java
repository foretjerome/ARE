package fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;

public abstract interface CriteresDemandeSpec
  extends CriteresSpec
{
  public static final String TYPE_DAL = "DAL";
  public static final String TYPE_RENOUVELLEMENT = "RNV";
  public static final String TYPE_DAL_SEGMENT = "LE1D";
  public static final String TYPE_RENOUVELLEMENT_SEGMENT = "LK1B";
  
  public abstract String getNumeroAllocataire();
  
  public abstract String getIdentifiantDemande();
  
  public abstract String getTypeDemande();
  
  public abstract String getIdentifiantRecherche();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract void setIdentifiantDemande(String paramString);
  
  public abstract void setTypeDemande(String paramString);
  
  public abstract void setIdentifiantRecherche(String paramString);
}

/* Location:
 * Qualified Name:     CriteresDemandeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
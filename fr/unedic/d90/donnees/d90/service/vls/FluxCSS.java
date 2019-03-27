package fr.unedic.d90.donnees.d90.service.vls;

public abstract class FluxCSS
{
  public static FluxCSS getInstance()
  {
    return new _FluxCSSImpl();
  }
  
  public abstract boolean isEnErreur();
  
  public abstract String getIdentifiant();
  
  public abstract void setIdentifiant(String paramString);
  
  public abstract String getCodeEtat();
  
  public abstract void setCodeEtat(String paramString);
  
  public abstract String getReferenceFormulaire();
  
  public abstract void setReferenceFormulaire(String paramString);
  
  public abstract String getCodeErreurReferenceFormulaire();
  
  public abstract void setCodeErreurReferenceFormulaire(String paramString);
  
  public abstract String getMotif();
  
  public abstract void setMotif(String paramString);
  
  public abstract String getCodeErreurMotif();
  
  public abstract void setCodeErreurMotif(String paramString);
}

/* Location:
 * Qualified Name:     FluxCSS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
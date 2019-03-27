package fr.pe.cali.parametrestechniques.dom;

public abstract class ParametreTechnique
{
  private String code;
  private String valeur;
  private String libelle;
  
  protected ParametreTechnique() {}
  
  protected ParametreTechnique(String code, String valeur)
  {
    this.code = code;
    this.valeur = valeur;
  }
  
  public abstract String getType();
  
  public String getCode()
  {
    return code;
  }
  
  public void setCode(String code)
  {
    this.code = code;
  }
  
  public String getValeur()
  {
    return valeur;
  }
  
  public void setValeur(String valeur)
  {
    this.valeur = valeur;
  }
  
  public String getLibelle()
  {
    return libelle;
  }
  
  public void setLibelle(String libelle)
  {
    this.libelle = libelle;
  }
}

/* Location:
 * Qualified Name:     ParametreTechnique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
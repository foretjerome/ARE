package fr.pe.cali.parametrestechniques.dom;

public class TopDebrayage
  extends ParametreTechnique
{
  private static final String VALEUR_ACTIF = "OUI";
  
  protected TopDebrayage() {}
  
  public TopDebrayage(String code, String valeur)
  {
    super(code, valeur);
  }
  
  public String getType()
  {
    return "TOP_DEBRAYAGE";
  }
  
  public boolean isTopDebrayageActif(String code)
  {
    return (getCode().equals(code)) && ("OUI".equals(getValeur()));
  }
}

/* Location:
 * Qualified Name:     TopDebrayage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.parametrestechniques.dom;

public class TopDeploiement
  extends ParametreTechnique
{
  private static final String VALEUR_ACTIF = "OUI";
  
  protected TopDeploiement() {}
  
  public TopDeploiement(String code, String valeur)
  {
    super(code, valeur);
  }
  
  public String getType()
  {
    return "TOP_DEPLOIEMENT";
  }
  
  public boolean isTopDeploiementActif(String code)
  {
    return (getCode().equals(code)) && ("OUI".equals(getValeur()));
  }
}

/* Location:
 * Qualified Name:     TopDeploiement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.parametrestechniques.outils;

import fr.pe.cali.parametrestechniques.dom.ParametreTechnique;
import fr.pe.cali.parametrestechniques.dom.TopDeploiement;
import java.util.List;

public final class OutilGestionTopDeploiement
  extends OutilGestionParametreTechnique
{
  private static OutilGestionTopDeploiement instance = null;
  
  public static OutilGestionTopDeploiement getInstance()
  {
    if (instance == null) {
      instance = new OutilGestionTopDeploiement();
    }
    return instance;
  }
  
  public boolean isTopDeploiementActif(List<ParametreTechnique> parametres, String codeRecherche)
  {
    return isParametreActif(parametres, codeRecherche);
  }
  
  protected String getTypeParametreGere()
  {
    return "TOP_DEPLOIEMENT";
  }
  
  protected boolean isParametreActif(ParametreTechnique parametre, String codeRecherche)
  {
    return ((TopDeploiement)parametre).isTopDeploiementActif(codeRecherche);
  }
}

/* Location:
 * Qualified Name:     OutilGestionTopDeploiement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
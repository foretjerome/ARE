package fr.pe.cali.parametrestechniques.outils;

import fr.pe.cali.parametrestechniques.dom.ParametreTechnique;
import fr.pe.cali.parametrestechniques.dom.TopDebrayage;
import java.util.List;

public final class OutilGestionTopDebrayage
  extends OutilGestionParametreTechnique
{
  private static OutilGestionTopDebrayage instance = null;
  
  public static OutilGestionTopDebrayage getInstance()
  {
    if (instance == null) {
      instance = new OutilGestionTopDebrayage();
    }
    return instance;
  }
  
  public boolean isTopDebrayageActif(List<ParametreTechnique> parametres, String codeRecherche)
  {
    return isParametreActif(parametres, codeRecherche);
  }
  
  protected String getTypeParametreGere()
  {
    return "TOP_DEBRAYAGE";
  }
  
  protected boolean isParametreActif(ParametreTechnique parametre, String codeRecherche)
  {
    return ((TopDebrayage)parametre).isTopDebrayageActif(codeRecherche);
  }
}

/* Location:
 * Qualified Name:     OutilGestionTopDebrayage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
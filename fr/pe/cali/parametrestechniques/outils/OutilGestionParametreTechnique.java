package fr.pe.cali.parametrestechniques.outils;

import fr.pe.cali.parametrestechniques.dom.ParametreTechnique;
import java.util.List;

public abstract class OutilGestionParametreTechnique
{
  protected boolean isParametreActif(List<ParametreTechnique> parametres, String codeParametre)
  {
    boolean actif = false;
    if (parametres != null) {
      for (ParametreTechnique parametre : parametres) {
        if ((parametre.getType().equals(getTypeParametreGere())) && (isParametreActif(parametre, codeParametre)))
        {
          actif = true;
          break;
        }
      }
    }
    return actif;
  }
  
  protected abstract String getTypeParametreGere();
  
  protected abstract boolean isParametreActif(ParametreTechnique paramParametreTechnique, String paramString);
}

/* Location:
 * Qualified Name:     OutilGestionParametreTechnique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
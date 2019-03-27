package fr.pe.cali.parametrestechniques.constantes;

import java.util.ArrayList;
import java.util.List;

public final class ConstantesTopDeploiement
{
  private static List<String> listeTopDeploiementConnu;
  private static final String TOP_DEPLOIEMENT_TEST = "topDeploiementTest";
  public static final String TOP_DEPLOIEMENT_BPM_16SI2 = "TOP_DEPLOIEMENT_BPM_16SI2";
  
  public static synchronized boolean estTopDeploiementGere(String codeTopDeploiement)
  {
    if (listeTopDeploiementConnu == null) {
      initialiserInstance();
    }
    return listeTopDeploiementConnu.contains(codeTopDeploiement);
  }
  
  private static void initialiserInstance()
  {
    listeTopDeploiementConnu = new ArrayList();
    listeTopDeploiementConnu.add("topDeploiementTest");
    listeTopDeploiementConnu.add("TOP_DEPLOIEMENT_BPM_16SI2");
  }
}

/* Location:
 * Qualified Name:     ConstantesTopDeploiement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
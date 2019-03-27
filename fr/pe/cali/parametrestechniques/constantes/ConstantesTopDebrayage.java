package fr.pe.cali.parametrestechniques.constantes;

import java.util.ArrayList;
import java.util.List;

public final class ConstantesTopDebrayage
{
  private static List<String> listeTopDebrayageConnu;
  private static final String TOP_DEBRAYAGE_TEST = "topDebrayageTest";
  public static final String TOP_DEBRAYAGE_PHEBUS = "TOP_DEBRAYAGE_PHEBUS";
  
  public static synchronized boolean estTopDebrayageGere(String codeTopDebrayage)
  {
    if (listeTopDebrayageConnu == null) {
      initialiserInstance();
    }
    return listeTopDebrayageConnu.contains(codeTopDebrayage);
  }
  
  private static void initialiserInstance()
  {
    listeTopDebrayageConnu = new ArrayList();
    listeTopDebrayageConnu.add("topDebrayageTest");
    listeTopDebrayageConnu.add("TOP_DEBRAYAGE_PHEBUS");
  }
}

/* Location:
 * Qualified Name:     ConstantesTopDebrayage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
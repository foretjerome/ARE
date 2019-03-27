package fr.unedic.cali.dom;

import fr.unedic.cali.outilsfonctionnels.ConstantesEnumeration;
import fr.unedic.util.services.OutilFonctionnel;

public class MotifExamen
  extends ConstantesEnumeration
  implements OutilFonctionnel
{
  private static final MotifExamen MOTIF_EXAMEN = new MotifExamen();
  public static final int MOTIF_CLCA = 1;
  public static final String LIB_MOTIF_CLCA = "Fin de CLCA";
  public static final int MOTIF_PI = 2;
  public static final String LIB_MOTIF_PI = "Fin de Pension d'invalidité";
  
  public static MotifExamen getInstance()
  {
    return MOTIF_EXAMEN;
  }
  
  protected void initialiserEnumeration()
  {
    ajouterElement(1, "Fin de CLCA");
    ajouterElement(2, "Fin de Pension d'invalidité");
  }
}

/* Location:
 * Qualified Name:     MotifExamen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.utilitaire.outils;

import java.util.StringTokenizer;

public final class OutilBouchon
{
  public static final String COMPORT_CREAT_DEM_ASSO = "creerDemandeAssociee";
  
  public static boolean appliqueComportement(String commentaire, String comportement)
  {
    boolean retour = false;
    if ((comportement != null) && (commentaire != null))
    {
      StringTokenizer st = new StringTokenizer(commentaire, ";");
      while (st.hasMoreTokens())
      {
        String element = st.nextToken();
        if (comportement.equals(element))
        {
          retour = true;
          break;
        }
      }
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     OutilBouchon
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
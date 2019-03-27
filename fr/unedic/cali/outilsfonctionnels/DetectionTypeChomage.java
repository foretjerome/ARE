package fr.unedic.cali.outilsfonctionnels;

import java.util.ArrayList;
import java.util.List;

public final class DetectionTypeChomage
{
  private static List<Integer> listeMotifChomageNonLegitime = null;
  private static List<Integer> listeMotifEconomique = null;
  
  private static synchronized void initialiserListeMotifChomageNonLegitime()
  {
    if (listeMotifChomageNonLegitime == null)
    {
      listeMotifChomageNonLegitime = new ArrayList();
      listeMotifChomageNonLegitime.add(Integer.valueOf(19));
      listeMotifChomageNonLegitime.add(Integer.valueOf(16));
      listeMotifChomageNonLegitime.add(Integer.valueOf(14));
      listeMotifChomageNonLegitime.add(Integer.valueOf(40));
      listeMotifChomageNonLegitime.add(Integer.valueOf(18));
    }
  }
  
  private static boolean estMotifChomageNonLegitime(int motif)
  {
    initialiserListeMotifChomageNonLegitime();
    return listeMotifChomageNonLegitime.contains(Integer.valueOf(motif));
  }
  
  private static synchronized void initialiserListeMotifEconomique()
  {
    if (listeMotifEconomique == null)
    {
      listeMotifEconomique = new ArrayList();
      listeMotifEconomique.add(Integer.valueOf(6));
      listeMotifEconomique.add(Integer.valueOf(1));
      listeMotifEconomique.add(Integer.valueOf(3));
      listeMotifEconomique.add(Integer.valueOf(33));
      listeMotifEconomique.add(Integer.valueOf(2));
      listeMotifEconomique.add(Integer.valueOf(44));
      listeMotifEconomique.add(Integer.valueOf(45));
    }
  }
  
  private static boolean estMotifEconomique(int motif)
  {
    initialiserListeMotifEconomique();
    return listeMotifEconomique.contains(Integer.valueOf(motif));
  }
  
  public static boolean estChomageLegitime(int motif, int contexteDemission)
  {
    boolean retour = true;
    if ((estMotifChomageNonLegitime(motif)) && (contexteDemission == 0)) {
      retour = false;
    }
    return retour;
  }
  
  public static boolean estChomageEconomique(int motif)
  {
    return estMotifEconomique(motif);
  }
}

/* Location:
 * Qualified Name:     DetectionTypeChomage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
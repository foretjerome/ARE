package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.Metier;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import java.util.HashSet;
import java.util.Set;

public class ValidationAnnexe10Convention2016
  extends ValidationAnnexe10
{
  private static Set<Integer> metiersCas1 = new HashSet();
  
  static
  {
    metiersCas1.add(Integer.valueOf(546));
    metiersCas1.add(Integer.valueOf(1688));
    metiersCas1.add(Integer.valueOf(1689));
    metiersCas1.add(Integer.valueOf(1709));
    metiersCas1.add(Integer.valueOf(547));
    metiersCas1.add(Integer.valueOf(553));
    metiersCas1.add(Integer.valueOf(1471));
    
    metiersCas1.add(Integer.valueOf(1472));
  }
  
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return (validerArtiste(periode)) || (validerRealisateur(periode));
  }
  
  protected boolean validerArtiste(PeriodeActiviteSalarie periode)
  {
    return super.validerPeriode(periode);
  }
  
  public boolean validerRealisateur(PeriodeActiviteSalarie periode)
  {
    return (testTypeContratTravail(periode)) && (testCategorieEmploiParticulierRealisateur(periode)) && (testEmploiRealisateur(periode)) && (testOriginePeriode(periode)) && (testPohf(periode));
  }
  
  private boolean testCategorieEmploiParticulierRealisateur(PeriodeActiviteSalarie periode)
  {
    return periode.getCategorieEmploiParticulier() == 43;
  }
  
  private boolean testEmploiRealisateur(PeriodeActiviteSalarie periode)
  {
    return validerMetier(periode, metiersCas1);
  }
  
  private boolean validerMetier(PeriodeActiviteSalarie periode, Set<Integer> listeMetier)
  {
    return listeMetier.contains(Integer.valueOf(periode.getMetier().getCodeEmploi()));
  }
  
  protected static String toUpperCaseNotNull(String chaine)
  {
    if (chaine == null) {
      return "";
    }
    return chaine.toUpperCase();
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe10Convention2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
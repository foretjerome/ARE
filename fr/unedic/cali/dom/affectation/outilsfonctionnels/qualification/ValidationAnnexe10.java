package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification;

import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.Metier;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import java.util.Collection;
import org.apache.commons.lang.StringUtils;

public class ValidationAnnexe10
  implements ValidationReglementSpec
{
  public boolean validerPeriode(PeriodeActiviteSalarie periode)
  {
    return (testTypeContratTravail(periode)) && (testCategorieEmploiParticulier(periode)) && (testEmploi(periode)) && (((testOriginePeriode(periode)) && (testPohf(periode))) || (validerCifCDD(periode)) || (validerOrigineGuso(periode)));
  }
  
  private boolean validerOrigineGuso(PeriodeActiviteSalarie periode)
  {
    boolean numeroGusoSurAffilEmployeurOK = StringUtils.isNotEmpty(periode.getEntreprise().getNumeroGuso());
    return (testOrigineGuso(periode)) && (numeroGusoSurAffilEmployeurOK);
  }
  
  private boolean validerCifCDD(PeriodeActiviteSalarie periode)
  {
    return (testOrigineAA13OuAE(periode)) && (periode.getContratTypeParticulier() == 8);
  }
  
  protected boolean testOriginePeriode(PeriodeActiviteSalarie periode)
  {
    Collection<?> origines = periode.getCollectionOrigineInformationPAS();
    if ((origines.contains(Integer.valueOf(10))) && (testCategorieEmploiParticulier(periode))) {
      return true;
    }
    return testOrigineAEMOuAA13(periode);
  }
  
  private boolean testOrigineAEMOuAA13(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(71))) {
      return true;
    }
    return testOrigineAEM(periode);
  }
  
  private boolean testOrigineAA13OuAE(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(1))) {
      return true;
    }
    return testOrigineAA13(periode);
  }
  
  private boolean testOrigineAA13(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(71))) {
      return true;
    }
    return false;
  }
  
  private boolean testOrigineAEM(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    return origines.contains(Integer.valueOf(4));
  }
  
  private boolean testOrigineGuso(PeriodeActiviteSalarie periode)
  {
    Collection<Integer> origines = periode.getCollectionOrigineInformationPAS();
    return origines.contains(Integer.valueOf(5));
  }
  
  private boolean testCategorieEmploiParticulier(PeriodeActiviteSalarie periode)
  {
    return periode.getCategorieEmploiParticulier() == 21;
  }
  
  protected boolean testTypeContratTravail(PeriodeActiviteSalarie periode)
  {
    return periode.getContratTravail().getNature() == 2;
  }
  
  protected boolean testPohf(PeriodeActiviteSalarie periode)
  {
    int pohf = periode.getContratTravail().getPohf();
    switch (pohf)
    {
    case 0: 
    case 1: 
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      return true;
    }
    return false;
  }
  
  private boolean testEmploi(PeriodeActiviteSalarie periode)
  {
    return periode.getMetier().getCodeEmploi() != 34;
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexe10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
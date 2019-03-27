package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.List;

public class FiltreCategorieEmploiParticulier
  implements FiltreTemporel
{
  private List listeCategorieEmploiParticulier;
  
  public FiltreCategorieEmploiParticulier(List plisteCategorieEmploiParticulier)
  {
    listeCategorieEmploiParticulier = plisteCategorieEmploiParticulier;
  }
  
  public FiltreCategorieEmploiParticulier()
  {
    listeCategorieEmploiParticulier = new ArrayList();
  }
  
  public boolean accepter(Temporel temporel)
  {
    PeriodeActiviteSalarie pas = trouverPeriodeActiviteSalarie(temporel);
    if (pas != null) {
      return listeCategorieEmploiParticulier.contains(Integer.valueOf(pas.getCategorieEmploiParticulier()));
    }
    return false;
  }
  
  private PeriodeActiviteSalarie trouverPeriodeActiviteSalarie(Temporel temporel)
  {
    if (temporel.estType(ActiviteSalarie.class)) {
      return ((ActiviteSalarie)temporel).getPeriodeActiviteSalarieGaec();
    }
    if (temporel.estType(PeriodeActiviteSalarie.class)) {
      return (PeriodeActiviteSalarie)temporel;
    }
    return null;
  }
  
  public void ajouterCategorieEmploi(int categorie)
  {
    listeCategorieEmploiParticulier.add(Integer.valueOf(categorie));
  }
}

/* Location:
 * Qualified Name:     FiltreCategorieEmploiParticulier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
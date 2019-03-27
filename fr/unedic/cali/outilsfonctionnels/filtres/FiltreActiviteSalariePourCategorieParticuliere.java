package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalariePourCategorieParticuliere
  extends FiltreActiviteSalarie
{
  private static final long serialVersionUID = 1L;
  private int m_categorieParticuliere;
  
  public FiltreActiviteSalariePourCategorieParticuliere(int p_categorie)
  {
    m_categorieParticuliere = p_categorie;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (super.accepter(p_temporel))
    {
      ActiviteSalarie activite = (ActiviteSalarie)p_temporel;
      return activite.getCategorieEmploiParticulier() == m_categorieParticuliere;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalariePourCategorieParticuliere
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
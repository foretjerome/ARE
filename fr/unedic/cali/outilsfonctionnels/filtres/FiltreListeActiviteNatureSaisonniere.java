package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;

public class FiltreListeActiviteNatureSaisonniere
  implements FiltreTemporel
{
  private ArrayList m_listeCodesSecteurs = new ArrayList();
  
  public FiltreListeActiviteNatureSaisonniere(ArrayList p_listeCodesSecteurs)
  {
    m_listeCodesSecteurs = p_listeCodesSecteurs;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    boolean periodeRetenue = false;
    if (p_temporel.estType(ActiviteSalarie.class))
    {
      ActiviteSalarie periodeCourante = (ActiviteSalarie)p_temporel;
      if (m_listeCodesSecteurs.contains(Integer.valueOf(periodeCourante.getSecteurActivite()))) {
        periodeRetenue = true;
      }
    }
    return periodeRetenue;
  }
}

/* Location:
 * Qualified Name:     FiltreListeActiviteNatureSaisonniere
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
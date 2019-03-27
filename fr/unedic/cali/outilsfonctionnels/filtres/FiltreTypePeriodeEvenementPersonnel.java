package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.List;

public class FiltreTypePeriodeEvenementPersonnel
  implements FiltreTemporel
{
  private List<Integer> listeTypeEvenementPersonnel;
  
  public FiltreTypePeriodeEvenementPersonnel(List<Integer> listeTypeEvenementPersonnel)
  {
    this.listeTypeEvenementPersonnel = listeTypeEvenementPersonnel;
  }
  
  public FiltreTypePeriodeEvenementPersonnel()
  {
    listeTypeEvenementPersonnel = new ArrayList();
  }
  
  public void ajouterTypeEvenementPersonnel(int natureEvenementPersonnel)
  {
    listeTypeEvenementPersonnel.add(Integer.valueOf(natureEvenementPersonnel));
  }
  
  public boolean accepter(Temporel temporel)
  {
    if (temporel.estType(PeriodeEvenementPersonnel.class))
    {
      PeriodeEvenementPersonnel evenementPersonnel = (PeriodeEvenementPersonnel)temporel;
      return listeTypeEvenementPersonnel.contains(Integer.valueOf(evenementPersonnel.getTypePep()));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreTypePeriodeEvenementPersonnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
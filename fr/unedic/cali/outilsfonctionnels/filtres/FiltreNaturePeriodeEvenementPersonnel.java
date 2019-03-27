package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.List;

public class FiltreNaturePeriodeEvenementPersonnel
  implements FiltreTemporel
{
  private List listeNatureEvenementPersonnel;
  
  public FiltreNaturePeriodeEvenementPersonnel(List plisteNatureEvenementPersonnel)
  {
    listeNatureEvenementPersonnel = plisteNatureEvenementPersonnel;
  }
  
  public FiltreNaturePeriodeEvenementPersonnel()
  {
    listeNatureEvenementPersonnel = new ArrayList();
  }
  
  public void ajouterNatureEvenementPersonnel(int natureEvenementPersonnel)
  {
    listeNatureEvenementPersonnel.add(Integer.valueOf(natureEvenementPersonnel));
  }
  
  public boolean accepter(Temporel temporel)
  {
    if (temporel.estType(IncidentSpec.class))
    {
      IncidentSpec evenementPersonnel = (IncidentSpec)temporel;
      return listeNatureEvenementPersonnel.contains(Integer.valueOf(evenementPersonnel.getNature()));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreNaturePeriodeEvenementPersonnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
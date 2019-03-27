package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.List;

public class FiltreNatureEvementPersonnel
  implements FiltreTemporel
{
  private List listeEvenementPersonnel;
  
  public FiltreNatureEvementPersonnel(List listeEvenementPersonnel)
  {
    this.listeEvenementPersonnel = listeEvenementPersonnel;
  }
  
  public FiltreNatureEvementPersonnel()
  {
    listeEvenementPersonnel = new ArrayList();
  }
  
  public void ajouterNatureEvenementPersonnel(int natureEvenementPersonnel)
  {
    listeEvenementPersonnel.add(Integer.valueOf(natureEvenementPersonnel));
  }
  
  public boolean accepter(Temporel temporel)
  {
    if (temporel.estType(IncidentSpec.class))
    {
      IncidentSpec evenementPersonnel = (IncidentSpec)temporel;
      return listeEvenementPersonnel.contains(Integer.valueOf(evenementPersonnel.getNature()));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreNatureEvementPersonnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreActiviteSalariePaysDansUnionEuropeenneOuEEE
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private static final long serialVersionUID = 5797687091432552927L;
  
  public FiltreActiviteSalariePaysDansUnionEuropeenneOuEEE() {}
  
  public FiltreActiviteSalariePaysDansUnionEuropeenneOuEEE(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(ActiviteSalarie.class)) && (super.getFiltreValorise(estPaysDansUnionEuropeenneOuEEE((ActiviteSalarie)p_temporel)));
  }
  
  private boolean estPaysDansUnionEuropeenneOuEEE(ActiviteSalarie p_activiteSalarie)
  {
    int paysContratTravail = p_activiteSalarie.getContrat().getPays();
    switch (paysContratTravail)
    {
    case 14: 
    case 18: 
    case 21: 
    case 28: 
    case 31: 
    case 44: 
      return false;
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     FiltreActiviteSalariePaysDansUnionEuropeenneOuEEE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
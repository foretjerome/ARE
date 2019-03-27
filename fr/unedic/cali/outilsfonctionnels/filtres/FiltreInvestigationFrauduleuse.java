package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.List;

public class FiltreInvestigationFrauduleuse
  implements FiltreTemporel
{
  private static final long serialVersionUID = -2644399719284954969L;
  private List listeStatusInvestivationFrauduleuse;
  
  public FiltreInvestigationFrauduleuse()
  {
    listeStatusInvestivationFrauduleuse = new ArrayList();
  }
  
  public boolean accepter(Temporel temporel)
  {
    if ((temporel instanceof ActiviteSalarie))
    {
      ActiviteSalarie activiteSalarie = (ActiviteSalarie)temporel;
      if ((activiteSalarie.getContrat() != null) && (listeStatusInvestivationFrauduleuse.contains(Integer.valueOf(activiteSalarie.getContrat().getInvestigationFrauduleuse())))) {
        return true;
      }
    }
    return false;
  }
  
  public void ajouterStatusInvestigationFrauduleuse(int statusIF)
  {
    listeStatusInvestivationFrauduleuse.add(Integer.valueOf(statusIF));
  }
}

/* Location:
 * Qualified Name:     FiltreInvestigationFrauduleuse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
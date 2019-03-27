package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.outilsfonctionnels.OutilActiviteSalarie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.List;

public class FiltrePeriodeNonExecutePourMotif
  implements FiltreTemporel
{
  private List listeMotifsNonExecution;
  
  public FiltrePeriodeNonExecutePourMotif(List listeMotifsNonExecution)
  {
    this.listeMotifsNonExecution = listeMotifsNonExecution;
  }
  
  public FiltrePeriodeNonExecutePourMotif()
  {
    listeMotifsNonExecution = new ArrayList();
  }
  
  public void ajouterMotifNonExecution(int motif)
  {
    listeMotifsNonExecution.add(Integer.valueOf(motif));
  }
  
  public boolean accepter(Temporel temporel)
  {
    if (temporel.estType(ActiviteSalarie.class))
    {
      ActiviteSalarie activite = (ActiviteSalarie)temporel;
      
      Damj premierJourNonExecution = OutilActiviteSalarie.getInstance().determinerPremierJourNonExecutionActivite(activite);
      Damj dernierJourNonExecution = OutilActiviteSalarie.getInstance().determinerDernierJourNonExecutionActivite(activite);
      if ((premierJourNonExecution != null) && (dernierJourNonExecution != null) && (dernierJourNonExecution.estApres(premierJourNonExecution)))
      {
        Integer codeMotifFin = Integer.valueOf(activite.getCodeMotifFin());
        return listeMotifsNonExecution.contains(codeMotifFin);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeNonExecutePourMotif
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
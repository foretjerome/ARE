package fr.unedic.cali.parcours.lecturebasepivot;

import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.util.services.Resultat;
import java.util.List;

public class ResultatLireBasePivot
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  private List<DemandePivot> listeDemandes;
  
  public List<DemandePivot> getListeDemandes()
  {
    return listeDemandes;
  }
  
  public void setListeDemandes(List<DemandePivot> listeDemandes)
  {
    this.listeDemandes = listeDemandes;
  }
}

/* Location:
 * Qualified Name:     ResultatLireBasePivot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
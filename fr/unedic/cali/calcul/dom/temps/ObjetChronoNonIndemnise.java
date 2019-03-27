package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoNonIndemnise
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1748167430687999062L;
  private String type;
  
  public ObjetChronoNonIndemnise() {}
  
  public ObjetChronoNonIndemnise(Damj dateDebut, Damj dateFin, String type)
  {
    super(dateDebut, dateFin);
    this.type = type;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoNonIndemnise copie = new ObjetChronoNonIndemnise();
    copieElements(copie);
    copie.setType(getType());
    return copie;
  }
  
  public String getType()
  {
    return type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoNonIndemnise
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
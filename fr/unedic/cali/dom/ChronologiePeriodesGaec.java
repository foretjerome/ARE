package fr.unedic.cali.dom;

import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;

public class ChronologiePeriodesGaec
{
  private ChronologiePeriodes chronologie;
  private Damj debut;
  private Damj fin;
  
  public ChronologiePeriodesGaec()
  {
    chronologie = new ChronologiePeriodes();
  }
  
  public ChronologiePeriodesGaec(ChronologiePeriodes chronologie, Damj debut, Damj fin)
  {
    this.chronologie = chronologie;
    this.debut = debut;
    this.fin = fin;
  }
  
  public ChronologiePeriodes getChronologie()
  {
    return chronologie;
  }
  
  public void setChronologie(ChronologiePeriodes chronologie)
  {
    this.chronologie = chronologie;
  }
  
  public Damj getDebut()
  {
    return debut;
  }
  
  public void setDebut(Damj debut)
  {
    this.debut = debut;
  }
  
  public Damj getFin()
  {
    return fin;
  }
  
  public void setFin(Damj fin)
  {
    this.fin = fin;
  }
}

/* Location:
 * Qualified Name:     ChronologiePeriodesGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
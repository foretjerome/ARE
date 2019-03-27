package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;

public class ResultatComSidListerAides
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  private Chronologie m_chronoDemandesAides = null;
  
  public Chronologie getChronoDemandesAides()
  {
    return m_chronoDemandesAides;
  }
  
  public void setChronoDemandesAides(Chronologie p_chronoDemandesAides)
  {
    m_chronoDemandesAides = p_chronoDemandesAides;
  }
}

/* Location:
 * Qualified Name:     ResultatComSidListerAides
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
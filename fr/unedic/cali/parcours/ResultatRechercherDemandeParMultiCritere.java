package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologieDebuts;

public class ResultatRechercherDemandeParMultiCritere
  extends Resultat
{
  private ChronologieDebuts m_chronoDemandes = null;
  
  public ChronologieDebuts getChronoDemandes()
  {
    return m_chronoDemandes;
  }
  
  public void setChronoDemandes(ChronologieDebuts p_chronoDemandePrestation)
  {
    m_chronoDemandes = p_chronoDemandePrestation;
  }
}

/* Location:
 * Qualified Name:     ResultatRechercherDemandeParMultiCritere
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
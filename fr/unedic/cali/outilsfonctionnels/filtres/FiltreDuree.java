package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.util.temps.CalculDelais;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;

public class FiltreDuree
  implements FiltreTemporel
{
  private DureeCalendaire m_duree;
  private boolean m_garderDureesPlusGrandes;
  
  public FiltreDuree(DureeCalendaire p_duree, boolean p_garderDureesPlusGrandes)
  {
    m_duree = p_duree;
    m_garderDureesPlusGrandes = p_garderDureesPlusGrandes;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel != null)
    {
      Damj dateDebutDelais = CalculDelais.determinerDelaiCalendaire(p_temporel.getDateFin(), m_duree).getDebut().lendemain();
      if (m_garderDureesPlusGrandes) {
        return p_temporel.getDateDebut().estAvantOuCoincideAvec(dateDebutDelais);
      }
      return p_temporel.getDateDebut().estApres(dateDebutDelais);
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDuree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
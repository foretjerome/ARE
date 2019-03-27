package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;

public class FiltreNaturePeriodeEvenementPersonnelAvecIntensite
  extends FiltreNaturePeriodeEvenementPersonnel
{
  private BigDecimal m_intensite = null;
  
  public void ajouterIntensite(BigDecimal p_intensite)
  {
    m_intensite = p_intensite;
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    IncidentSpec evenementPersonnel = null;
    if (p_temporel.estType(IncidentSpec.class)) {
      evenementPersonnel = (IncidentSpec)p_temporel;
    } else {
      return false;
    }
    return (super.accepter(p_temporel)) && (m_intensite.compareTo(evenementPersonnel.getIntensite()) == 0);
  }
}

/* Location:
 * Qualified Name:     FiltreNaturePeriodeEvenementPersonnelAvecIntensite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
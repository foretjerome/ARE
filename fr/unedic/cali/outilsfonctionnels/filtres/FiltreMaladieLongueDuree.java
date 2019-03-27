package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnelIndemnisable;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Temporel;

public class FiltreMaladieLongueDuree
  extends FiltreDuree
{
  private static final long serialVersionUID = 1L;
  public static final DureeCalendaire DUREE_MIN_MALADIE_LONGUE_DUREE = new DureeCalendaire(0, 3, 0);
  
  public FiltreMaladieLongueDuree()
  {
    super(DUREE_MIN_MALADIE_LONGUE_DUREE, true);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(PeriodeEvenementPersonnelIndemnisable.class))
    {
      PeriodeEvenementPersonnelIndemnisable periode = (PeriodeEvenementPersonnelIndemnisable)p_temporel;
      if (verifierTypePep(periode)) {
        if (verifierNaturePep(periode)) {
          return super.accepter(p_temporel);
        }
      }
    }
    return false;
  }
  
  private boolean verifierTypePep(PeriodeEvenementPersonnelIndemnisable p_pep)
  {
    return p_pep.getTypePep() == 2;
  }
  
  private boolean verifierNaturePep(PeriodeEvenementPersonnelIndemnisable p_pep)
  {
    return (p_pep.getNature() != 25) && (p_pep.getNature() != 26) && (p_pep.getNature() != 23);
  }
}

/* Location:
 * Qualified Name:     FiltreMaladieLongueDuree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
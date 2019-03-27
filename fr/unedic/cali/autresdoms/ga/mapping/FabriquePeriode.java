package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

class FabriquePeriode
{
  static Periode creer(Damj p_dateDebut, Damj p_dateFin)
  {
    Damj debut = p_dateDebut == null ? Damj.NUIT_DES_TEMPS : p_dateDebut;
    Damj fin = p_dateFin == null ? Damj.FIN_DES_TEMPS : p_dateFin;
    return new Periode(debut, fin);
  }
}

/* Location:
 * Qualified Name:     FabriquePeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
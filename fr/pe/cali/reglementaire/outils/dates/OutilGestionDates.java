package fr.pe.cali.reglementaire.outils.dates;

import fr.unedic.util.temps.Damj;

public final class OutilGestionDates
{
  public static Damj gererVingtNeufFevrier(Damj dateAVerifier)
  {
    Damj resultat = dateAVerifier;
    if ((dateAVerifier.getMois() == 2) && (dateAVerifier.getJour() == 29)) {
      resultat = dateAVerifier.lendemain();
    }
    return resultat;
  }
}

/* Location:
 * Qualified Name:     OutilGestionDates
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
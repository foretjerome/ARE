package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;

public class OutilGestionDate
  implements OutilFonctionnel
{
  private static OutilGestionDate instance;
  private static final int DOUZE_MOIS = 12;
  private static final int FEVRIER = 2;
  private static final int VINGT_NEUF = 29;
  
  public static OutilGestionDate getInstance()
  {
    if (instance == null) {
      instance = new OutilGestionDate();
    }
    return instance;
  }
  
  public Damj calculerDecalage12moisVersArriere(Damj dateCalculDateLimite)
  {
    Damj datelimite = null;
    if ((dateCalculDateLimite.getMois() == 2) && (dateCalculDateLimite.getJour() == 29)) {
      datelimite = dateCalculDateLimite.deplacerVersArriere(new DureeCalendaire(0, 12)).lendemain();
    } else {
      datelimite = dateCalculDateLimite.deplacerVersArriere(new DureeCalendaire(0, 12));
    }
    return datelimite;
  }
  
  public Damj calculerDecalage12moisVersAvant(Damj dateCalculDateLimite)
  {
    Damj datelimite = null;
    if ((dateCalculDateLimite.getMois() == 2) && (dateCalculDateLimite.getJour() == 29)) {
      datelimite = dateCalculDateLimite.deplacerVersAvant(new DureeCalendaire(0, 12));
    } else {
      datelimite = dateCalculDateLimite.deplacerVersAvant(new DureeCalendaire(0, 12)).veille();
    }
    return datelimite;
  }
}

/* Location:
 * Qualified Name:     OutilGestionDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
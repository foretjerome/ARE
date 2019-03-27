package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class OutilActiviteSalarie
  implements OutilFonctionnel
{
  private static OutilActiviteSalarie instance;
  public static final int TAILLE_ID_LIDO = 17;
  
  public static OutilActiviteSalarie getInstance()
  {
    if (instance == null) {
      instance = new OutilActiviteSalarie();
    }
    return instance;
  }
  
  public Damj determinerPremierJourNonExecutionActivite(ActiviteSalarie activite)
  {
    if (activite.getContrat().getDateRuptureContratTravail() != null) {
      return activite.getContrat().getDateRuptureContratTravail().lendemain();
    }
    return null;
  }
  
  public Damj determinerDernierJourNonExecutionActivite(ActiviteSalarie activite)
  {
    return activite.getContrat().getDateInitialeFCD();
  }
  
  public Periode determinerPeriodeNonExecution(ActiviteSalarie activite)
  {
    Damj premierJourNonExecution = determinerPremierJourNonExecutionActivite(activite);
    Damj dernierJourNonExecution = determinerDernierJourNonExecutionActivite(activite);
    if ((premierJourNonExecution != null) && (dernierJourNonExecution != null)) {
      return new Periode(premierJourNonExecution, dernierJourNonExecution);
    }
    return null;
  }
  
  public boolean estAeMotifRupturePap(ActiviteSalarie activite)
  {
    return (48 == Integer.parseInt(activite.getMotifFin())) || (49 == Integer.parseInt(activite.getMotifFin()));
  }
  
  public boolean estAeCSPouPAP(TravailSpec activite)
  {
    boolean estAECSP = false;
    boolean estAEPAP = false;
    if ((activite instanceof ActiviteSalarie))
    {
      ActiviteSalarie activiteSalariee = (ActiviteSalarie)activite;
      estAECSP = (44 == Integer.parseInt(activiteSalariee.getMotifFin())) || (45 == Integer.parseInt(activiteSalariee.getMotifFin()));
      
      estAEPAP = estAeMotifRupturePap((ActiviteSalarie)activite);
    }
    return (estAECSP) || (estAEPAP);
  }
  
  public boolean estAeAvecCaisseProfessionnelDuBatiment(ActiviteSalarie activite)
  {
    return "1".equals(activite.getPeriodeActiviteSalarieGaec().getCodeCaisseProfessionnelle());
  }
  
  public static String formaterIdentifiantPeriodeGaec(String chaineACompleter, int tailleTotale)
  {
    StringBuilder sb = new StringBuilder();
    if (chaineACompleter.indexOf('-') != -1) {
      sb.append(chaineACompleter.substring(0, chaineACompleter.indexOf('-')));
    } else {
      sb.append(chaineACompleter);
    }
    while (sb.length() < tailleTotale) {
      sb.insert(0, "0");
    }
    return sb.toString();
  }
}

/* Location:
 * Qualified Name:     OutilActiviteSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
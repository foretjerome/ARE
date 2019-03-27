package fr.pe.cali.reglementaire.parametres.retraite;

import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.parametres.InfoRetraite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ParametresRetraite
{
  protected static final int QUATRE = 4;
  protected static final int SEPT = 7;
  protected static final int NEUF = 9;
  protected static final int SOIXANTE = 60;
  protected static final int SOIXANTE_UN = 61;
  protected static final int SOIXANTE_DEUX = 62;
  protected static final int SOIXANTE_CINQ = 65;
  protected static final int SOIXANTE_SIX = 66;
  protected static final int SOIXANTE_SEPT = 67;
  protected static final int CENT_CINQUANTE = 150;
  protected static final int CENT_CINQUANTE_UN = 151;
  protected static final int CENT_CINQUANTE_DEUX = 152;
  protected static final int CENT_CINQUANTE_TROIS = 153;
  protected static final int CENT_CINQUANTE_QUATRE = 154;
  protected static final int CENT_CINQUANTE_CINQ = 155;
  protected static final int CENT_CINQUANTE_SIX = 156;
  protected static final int CENT_CINQUANTE_SEPT = 157;
  protected static final int CENT_CINQUANTE_HUIT = 158;
  protected static final int CENT_CINQUANTE_NEUF = 159;
  protected static final int CENT_SOIXANTE = 160;
  protected static final int CENT_SOIXANTE_UN = 161;
  protected static final int CENT_SOIXANTE_DEUX = 162;
  protected static final int CENT_SOIXANTE_TROIS = 163;
  protected static final int CENT_SOIXANTE_QUATRE = 164;
  protected static final int CENT_SOIXANTE_CINQ = 165;
  protected static final int CENT_SOIXANTE_SIX = 166;
  private static ParametresRetraite instance;
  private static Map<Periode, InfoRetraite> parametresRetraite = new HashMap();
  
  public static synchronized ParametresRetraite getInstance()
  {
    if (instance == null) {
      instance = new ParametresRetraite();
    }
    return instance;
  }
  
  static
  {
    parametresRetraite.put(new Periode(Damj.NUIT_DES_TEMPS, new Damj(1933, 12, 31)), new InfoRetraite(150, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1934, 1, 1), new Damj(1934, 12, 31)), new InfoRetraite(151, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1935, 1, 1), new Damj(1935, 12, 31)), new InfoRetraite(152, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1936, 1, 1), new Damj(1936, 12, 31)), new InfoRetraite(153, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1937, 1, 1), new Damj(1937, 12, 31)), new InfoRetraite(154, 160, 154, new DureeCalendaire(60), new DureeCalendaire(65), new Damj(2002, 12, 1), null, null));
    
    parametresRetraite.put(new Periode(new Damj(1938, 1, 1), new Damj(1938, 12, 31)), new InfoRetraite(155, 160, 155, new DureeCalendaire(60), new DureeCalendaire(65), new Damj(2002, 12, 1), null, null));
    
    parametresRetraite.put(new Periode(new Damj(1939, 1, 1), new Damj(1939, 12, 31)), new InfoRetraite(156, 160, 156, new DureeCalendaire(60), new DureeCalendaire(65), new Damj(2002, 12, 1), null, null));
    
    parametresRetraite.put(new Periode(new Damj(1940, 1, 1), new Damj(1940, 12, 31)), new InfoRetraite(157, 160, 157, new DureeCalendaire(60), new DureeCalendaire(65), new Damj(2002, 12, 1), null, null));
    
    parametresRetraite.put(new Periode(new Damj(1941, 1, 1), new Damj(1941, 12, 31)), new InfoRetraite(158, 160, 158, new DureeCalendaire(60), new DureeCalendaire(65), new Damj(2002, 12, 1), null, null));
    
    parametresRetraite.put(new Periode(new Damj(1942, 1, 1), new Damj(1942, 12, 31)), new InfoRetraite(159, 160, 159, new DureeCalendaire(60), new DureeCalendaire(65), new Damj(2002, 12, 31), null, null));
    
    parametresRetraite.put(new Periode(new Damj(1943, 1, 1), new Damj(1948, 12, 31)), new InfoRetraite(160, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1949, 1, 1), new Damj(1949, 12, 31)), new InfoRetraite(161, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1950, 1, 1), new Damj(1950, 12, 31)), new InfoRetraite(162, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1951, 1, 1), new Damj(1951, 6, 30)), new InfoRetraite(163, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1951, 7, 1), new Damj(1951, 12, 31)), new InfoRetraite(163, 0, 0, new DureeCalendaire(60, 4), new DureeCalendaire(65, 4), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1952, 1, 1), new Damj(1952, 12, 31)), new InfoRetraite(164, 0, 0, new DureeCalendaire(60, 9), new DureeCalendaire(65, 9), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1953, 1, 1), new Damj(1953, 12, 31)), new InfoRetraite(165, 0, 0, new DureeCalendaire(61, 2), new DureeCalendaire(66, 2), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1954, 1, 1), new Damj(1954, 12, 31)), new InfoRetraite(165, 0, 0, new DureeCalendaire(61, 7), new DureeCalendaire(66, 7), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1955, 1, 1), new Damj(1955, 12, 31)), new InfoRetraite(166, 0, 0, new DureeCalendaire(62), new DureeCalendaire(67), null, null, null));
    
    parametresRetraite.put(new Periode(new Damj(1956, 1, 1), Damj.FIN_DES_TEMPS), new InfoRetraite(166, 0, 0, new DureeCalendaire(62), new DureeCalendaire(67), null, null, null));
  }
  
  public DureeCalendaire getAgeMinDepartRetraite(Damj dateNaissanceIndividu)
    throws CoucheLogiqueException
  {
    InfoRetraite infoRetraite = trouverInfoRetraite(dateNaissanceIndividu);
    return infoRetraite.getAgeMinDepart();
  }
  
  public DureeCalendaire getAgeMaxDepartRetraite(Damj dateNaissanceIndividu)
    throws CoucheLogiqueException
  {
    InfoRetraite infoRetraite = trouverInfoRetraite(dateNaissanceIndividu);
    return infoRetraite.getAgeMaxDepart();
  }
  
  public InfoRetraite trouverInfoRetraite(Damj dateNaissanceIndividu)
    throws CoucheLogiqueException
  {
    if (dateNaissanceIndividu == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_DATE_NAISSANCE_NON_RENSEIGNEE");
    }
    for (Map.Entry<Periode, InfoRetraite> entry : parametresRetraite.entrySet()) {
      if (((Periode)entry.getKey()).contient(dateNaissanceIndividu)) {
        return (InfoRetraite)entry.getValue();
      }
    }
    GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_PARAMETRE_RETRAITE_NON_TROUVE");
    return null;
  }
  
  public static Map<Periode, InfoRetraite> getParametresRetraite()
  {
    return parametresRetraite;
  }
  
  public static void setParametresRetraite(Map<Periode, InfoRetraite> parametresRetraite)
  {
    parametresRetraite = parametresRetraite;
  }
}

/* Location:
 * Qualified Name:     ParametresRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
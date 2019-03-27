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

public class ParametresRetraiteMayotte
  extends ParametresRetraite
{
  private static ParametresRetraiteMayotte instance;
  protected static final int HUIT = 8;
  protected static final int CENT_QUATRE = 104;
  protected static final int CENT_HUIT = 108;
  protected static final int CENT_DOUZE = 112;
  protected static final int CENT_SEIZE = 116;
  protected static final int CENT_VINGT = 120;
  protected static final int CENT_VINGT_QUATRE = 124;
  protected static final int CENT_VINGT_HUIT = 128;
  protected static final int CENT_TRENTE_DEUX = 132;
  protected static final int CENT_TRENT_SIX = 136;
  private static Map<Periode, InfoRetraite> parametresRetraiteMayotte = new HashMap();
  
  public static synchronized ParametresRetraiteMayotte getInstance()
  {
    if (instance == null) {
      instance = new ParametresRetraiteMayotte();
    }
    return instance;
  }
  
  static
  {
    parametresRetraiteMayotte.put(new Periode(Damj.NUIT_DES_TEMPS, new Damj(1953, 12, 31)), new InfoRetraite(104, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraiteMayotte.put(new Periode(new Damj(1954, 1, 1), new Damj(1954, 12, 31)), new InfoRetraite(108, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraiteMayotte.put(new Periode(new Damj(1955, 1, 1), new Damj(1955, 12, 31)), new InfoRetraite(112, 0, 0, new DureeCalendaire(60), new DureeCalendaire(65), null, null, null));
    
    parametresRetraiteMayotte.put(new Periode(new Damj(1956, 1, 1), new Damj(1956, 12, 31)), new InfoRetraite(116, 0, 0, new DureeCalendaire(60, 4), new DureeCalendaire(65, 4), null, null, null));
    
    parametresRetraiteMayotte.put(new Periode(new Damj(1957, 1, 1), new Damj(1957, 12, 31)), new InfoRetraite(120, 0, 0, new DureeCalendaire(60, 8), new DureeCalendaire(65, 8), null, null, null));
    
    parametresRetraiteMayotte.put(new Periode(new Damj(1958, 1, 1), new Damj(1958, 12, 31)), new InfoRetraite(124, 0, 0, new DureeCalendaire(61), new DureeCalendaire(66), null, null, null));
    
    parametresRetraiteMayotte.put(new Periode(new Damj(1959, 1, 1), new Damj(1959, 12, 31)), new InfoRetraite(128, 0, 0, new DureeCalendaire(61, 4), new DureeCalendaire(66, 4), null, null, null));
    
    parametresRetraiteMayotte.put(new Periode(new Damj(1960, 1, 1), new Damj(1960, 12, 31)), new InfoRetraite(132, 0, 0, new DureeCalendaire(61, 8), new DureeCalendaire(66, 8), null, null, null));
    
    parametresRetraiteMayotte.put(new Periode(new Damj(1961, 1, 1), Damj.FIN_DES_TEMPS), new InfoRetraite(136, 0, 0, new DureeCalendaire(62), new DureeCalendaire(67), null, null, null));
  }
  
  public InfoRetraite trouverInfoRetraite(Damj dateNaissanceIndividu)
    throws CoucheLogiqueException
  {
    if (dateNaissanceIndividu == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_DATE_NAISSANCE_NON_RENSEIGNEE");
    }
    for (Map.Entry<Periode, InfoRetraite> entry : parametresRetraiteMayotte.entrySet()) {
      if (dateNaissanceIndividu.estContenueDans((Periode)entry.getKey())) {
        return (InfoRetraite)entry.getValue();
      }
    }
    GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_PARAMETRE_RETRAITE_NON_TROUVE");
    return null;
  }
}

/* Location:
 * Qualified Name:     ParametresRetraiteMayotte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
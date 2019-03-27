package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.util.UniteAffiliation;
import java.util.HashMap;
import java.util.Map;

public class ConvertisseurUniteAppletLiquidation
{
  public static final String NOM_JOUR = "j";
  public static final String NOM_JOUR_SUSPENSION = "js";
  public static final String NOM_CACHE_GROUPE = "cg";
  public static final String NOM_CACHE_ISOLE = "ci";
  public static final String NOM_VACATION = "v";
  public static final String NOM_EMBARQUEMENT_ADMINISTRATIF = "je";
  public static final String NOM_JOUR_CONTRIBUTION = "jc";
  public static final String NOM_HEURE_TRAVAIL = "h";
  public static final String NOM_JOURS_TRAVAILLES = "jt";
  private static Map<UniteAffiliation, String> libelleUniteApplet = new HashMap();
  
  static
  {
    libelleUniteApplet.put(UniteAffiliation.JOUR, "j");
    libelleUniteApplet.put(UniteAffiliation.JOUR_SUSPENSION, "js");
    libelleUniteApplet.put(UniteAffiliation.CACHET_GROUPE, "cg");
    libelleUniteApplet.put(UniteAffiliation.CACHET_ISOLE, "ci");
    libelleUniteApplet.put(UniteAffiliation.VACATION, "v");
    libelleUniteApplet.put(UniteAffiliation.EMBARQUEMENT_ADMINISTRATIF, "je");
    libelleUniteApplet.put(UniteAffiliation.JOUR_CONTRIBUTION, "jc");
    libelleUniteApplet.put(UniteAffiliation.HEURE_TRAVAIL, "h");
    libelleUniteApplet.put(UniteAffiliation.JOUR_TRAVAILLE, "jt");
  }
  
  public static String getUniteApplet(UniteAffiliation uniteAffiliation)
  {
    return (String)libelleUniteApplet.get(uniteAffiliation);
  }
}

/* Location:
 * Qualified Name:     ConvertisseurUniteAppletLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
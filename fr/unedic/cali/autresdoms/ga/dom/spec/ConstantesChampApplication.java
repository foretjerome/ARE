package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.archi.commun.util.HashMap;
import java.math.BigDecimal;

public abstract class ConstantesChampApplication
{
  public static final int CHAMP_APPLICATION_INDETERMINE = 0;
  public static final int NON_MANDATAIRE = 1;
  public static final String LIB_NON_MANDATAIRE = "L351-4 Non Mandataire";
  public static final int MANDATAIRE_HORS_CHAMP = 2;
  public static final String LIB_MANDATAIRE = "L351-4 Mandataire";
  public static final int L351_12_AUTO_ASSURANCE = 3;
  public static final String LIB_L351_12 = "L351-12 Auto-assurance";
  public static final int CONVENTION_GESTION = 4;
  public static final String LIB_CONVENTION_GESTION = "L351-12 Conv.de gestion";
  public static final int COLLEC_AFFILIEE = 5;
  public static final String LIB_COLLEC_AFFILIEE = "L351-12 Affiliés";
  public static final int FONCTIONNAIRE = 8;
  public static final String LIB_FONCTIONNAIRE = "Fonctionnaire";
  public static final int L351_12_ADHESION_CONTRAT_AVENIR = 9;
  public static final String LIB_L351_12_ADHESION_CONTRAT_AVENIR = "L351-12 Adhésion Contrat d'Avenir";
  public static final int ADHESION_REVOCABLE = 13;
  public static final String LIB_ADHESION_REVOCABLE = "Adhésion révocable";
  public static final int ADHESION_IRREVOCABLE = 14;
  public static final String LIB_ADHESION_IRREVOCABLE = "Adhésion irrévocable";
  public static final String COMPETENCE_EMPLOYEUR_RAC = "1";
  public static final String COMPETENCE_EMPLOYEUR_SP = "2";
  public static final String COMPETENCE_EMPLOYEUR_HORS_RAC = "3";
  public static final int NON_MANDATAIRE_MAYOTTE = 10;
  public static final int L351_12_AUTO_ASSURANCE_MAYOTTE = 11;
  public static final int CONVENTION_GESTION_MAYOTTE = 12;
  private static HashMap s_libelleChampApplication = new HashMap();
  private static HashMap s_libelleCompetenceEmployeur = new HashMap();
  
  static
  {
    s_libelleChampApplication.put(new BigDecimal(1), "L351-4 Non Mandataire");
    s_libelleChampApplication.put(new BigDecimal(2), "L351-4 Mandataire");
    s_libelleChampApplication.put(new BigDecimal(3), "L351-12 Auto-assurance");
    s_libelleChampApplication.put(new BigDecimal(4), "L351-12 Conv.de gestion");
    s_libelleChampApplication.put(new BigDecimal(5), "L351-12 Affiliés");
    s_libelleChampApplication.put(new BigDecimal(8), "Fonctionnaire");
    s_libelleChampApplication.put(new BigDecimal(9), "L351-12 Adhésion Contrat d'Avenir");
    s_libelleChampApplication.put(new BigDecimal(13), "Adhésion révocable");
    s_libelleChampApplication.put(new BigDecimal(14), "Adhésion irrévocable");
    
    s_libelleCompetenceEmployeur.put(new BigDecimal(1), "1");
    s_libelleCompetenceEmployeur.put(new BigDecimal(2), "3");
    s_libelleCompetenceEmployeur.put(new BigDecimal(3), "2");
    s_libelleCompetenceEmployeur.put(new BigDecimal(4), "1");
    s_libelleCompetenceEmployeur.put(new BigDecimal(5), "1");
    
    s_libelleCompetenceEmployeur.put(new BigDecimal(8), "3");
    
    s_libelleCompetenceEmployeur.put(new BigDecimal(9), "1");
  }
  
  public static String getLibelleChampApplication(BigDecimal p_codeChampApplication)
  {
    return (String)s_libelleChampApplication.get(p_codeChampApplication);
  }
  
  public static String getCompetenceEmployeur(BigDecimal p_codeChampApplication)
  {
    return (String)s_libelleCompetenceEmployeur.get(p_codeChampApplication);
  }
}

/* Location:
 * Qualified Name:     ConstantesChampApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
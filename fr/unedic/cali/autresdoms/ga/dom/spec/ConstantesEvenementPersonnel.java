package fr.unedic.cali.autresdoms.ga.dom.spec;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class ConstantesEvenementPersonnel
{
  public static final int NATURE_ALLOCATION_CLCA = 1;
  public static final int NATURE_ALLOCATION_APP = 2;
  public static final int CATEGORIE_INTERNE = 1;
  public static final int CATEGORIE_LIABLE = 2;
  public static final int CATEGORIE_NON_LIABLE = 3;
  public static final int NATURE_CHOMAGE_PARTIEL = 4;
  public static final String LIB_NATURE_CHOMAGE_PARTIEL = "Chômage partiele";
  public static final int NATURE_CONGE_CONVERSION = 5;
  public static final String LIB_NATURE_CONGE_CONVERSION = "Congé de conversion";
  public static final int NATURE_CONGE_RECLASSEMENT = 6;
  public static final String LIB_NATURE_CONGE_RECLASSEMENT = "Congé de reclassement";
  public static final int NATURE_CONGE_ENSEIGNEMENT_RECHERCHE = 7;
  public static final String LIB_NATURE_CONGE_ENSEIGNEMENT_RECHERCHE = "Congé d'enseignement et de recherche";
  public static final int NATURE_CONGE_FORMATION_JEUNE = 8;
  public static final String LIB_NATURE_CONGE_FORMATION_JEUNE = "Congé de formation pour jeunes";
  public static final int NATURE_CONGE_SOLIDARITE_FAMILILALE = 9;
  public static final String LIB_NATURE_CONGE_SOLIDARITE_FAMILILALE = "Congé de solidarité familiale";
  public static final int NATURE_CONGE_CREATION_ENTREPRISE = 10;
  public static final String LIB_NATURE_CONGE_CREATION_ENTREPRISE = "Congé pour création d'entreprise";
  public static final int NATURE_CONGE_SABBATIQUE = 11;
  public static final String LIB_NATURE_CONGE_SABBATIQUE = "Congé sabbatique";
  public static final int NATURE_CONGE_SOLIDARITE_INTERNATIONALE = 12;
  public static final String LIB_NATURE_CONGE_SOLIDARITE_INTERNATIONALE = "Congé de solidarité internationale";
  public static final int NATURE_CONGE_SANS_SOLDE = 55;
  public static final String LIB_NATURE_CONGE_SANS_SOLDE = "Congé sans solde";
  public static final int NATURE_CONGE_NON_REMUNERE_INITIATIVE_AGENT_NON_TITULAIRE_STAGE = 58;
  public static final String LIB_NATURE_CONGE_NON_REMUNERE_INITIATIVE_AGENT_NON_TITULAIRE_STAGE = "Congé non rémunéré initiative agent non tit/stag";
  public static final int NATURE_CONGE_NON_REMUNERE_INITIATIVE_EMPLOYEUR_PUBLIC = 59;
  public static final String LIB_NATURE_CONGE_NON_REMUNERE_INITIATIVE_EMPLOYEUR_PUBLIC = "Congé non rémunéré initiative employeur public";
  public static final int NATURE_MALADIE_NON_PROFESSIONNELLE = 21;
  public static final String LIB_NATURE_MALADIE_NON_PROFESSIONNELLE = "Maladie non professionnelle";
  public static final int NATURE_MALADIE_PROFESSIONNELLE = 22;
  public static final String LIB_NATURE_MALADIE_PROFESSIONNELLE = "Maladie professionnelle";
  public static final int NATURE_ACCIDENT_TRAVAIL = 23;
  public static final String LIB_NATURE_ACCIDENT_TRAVAIL = "Accident du travail";
  public static final int NATURE_TEMPS_PARTIEL_THERAPEUTIQUE = 24;
  public static final String LIB_NATURE_TEMPS_PARTIEL_THERAPEUTIQUE = "Temps partiel thérapeutique";
  public static final int NATURE_CONGE_MATERNITE = 25;
  public static final String LIB_NATURE_CONGE_MATERNITE = "Congé maternité";
  public static final int NATURE_CONGE_ADOPTION = 26;
  public static final String LIB_NATURE_CONGE_ADOPTION = "Congé d'adoption";
  public static final int NATURE_CONGE_POST_NATAL = 27;
  public static final String LIB_NATURE_CONGE_POST_NATAL = "Congé post-natal";
  public static final int NATURE_CONGE_PATERNITE = 28;
  public static final String LIB_NATURE_CONGE_PATERNITE = "Congé paternité";
  public static final int NATURE_CONGE_INDIVIDUEL_FORMATION = 31;
  public static final String LIB_NATURE_CONGE_INDIVIDUEL_FORMATION = "Congé individuel de formation";
  public static final int NATURE_CONGE_PARENTAL_EDUCATION = 32;
  public static final String LIB_NATURE_CONGE_PARENTAL_EDUCATION = "Congé parental d'éducation";
  public static final int NATURE_CONGE_PRESENCE_PARENTALE = 33;
  public static final String LIB_NATURE_CONGE_PRESENCE_PARENTALE = "Congé de présence parentale";
  public static final int NATURE_MANDAT_PARLEMENTAIRE = 34;
  public static final String LIB_NATURE_MANDAT_PARLEMENTAIRE = "Congé pour mandat parlementaire";
  public static final int NATURE_MANDAT_SOCIAL = 35;
  public static final String LIB_NATURE_MANDAT_SOCIAL = "Congé pour mandat social";
  public static final int NATURE_SERVICE_NATIONAL = 36;
  public static final String LIB_NATURE_SERVICE_NATIONAL = "Service national";
  public static final int NATURE_RAPPEL_DRAPEAUX = 37;
  public static final String LIB_NATURE_RAPPEL_DRAPEAUX = "Rappel sous les drapeaux";
  public static final int NATURE_INCARCERATION = 38;
  public static final String LIB_NATURE_INCARCERATION = "Incarcération";
  public static final int NATURE_VOLONTARIAT_CIVIL = 39;
  public static final String LIB_NATURE_VOLONTARIAT_CIVIL = "Volontariat civil";
  public static final int NATURE_PEP_AUTRE_VOLONTARIAT_ASSOCIATIF = 43;
  public static final String LIB_NATURE_VOLONTARIAT_ASSOCIATIF = "Volontariat associatif";
  public static final int NATURE_DISPONIBILITE = 40;
  public static final String LIB_NATURE_DISPONIBILITE = "Disponibilité";
  public static final int NATURE_CHOMAGE = 41;
  public static final String LIB_NATURE_CHOMAGE = "Chômage";
  public static final int NATURE_INACTIVITE = 42;
  public static final String LIB_NATURE_INACTIVITE = "Inactivité";
  public static final int NATURE_PEP_AUTRE_VOLONTARIAT_SOLIDARITE_INTERNATIONALE = 44;
  public static final String LIB_NATURE_VOLONTARIAT_SOLIDARITE_INTERNATIONALE = "Volontariat de solidarité internationale";
  public static final int NATURE_PEP_VOLONTARIAT_INTERNATIONAL_ADMINISTRATION_ENTREPRISE = 45;
  public static final String LIB_PEP_VOLONTARIAT_INTERNATIONAL_ADMINISTRATION_ENTREPRISE = "Volontariat international en administration ou en entreprise";
  public static final int NATURE_PEP_SERVICE_VOLONTAIRE_EUROPEEN = 46;
  public static final String LIB_PEP_SERVICE_VOLONTAIRE_EUROPEEN = "Service volontaire européen";
  public static final int NATURE_PEP_ENGAGEMENT_SERVICE_CIVIQUE = 47;
  public static final String LIB_PEP_ENGAGEMENT_SERVICE_CIVIQUE = "Engagement de service civique";
  public static final int NATURE_PEP_VOLONTARIAT_SERVICE_CIVIQUE = 48;
  public static final String LIB_PEP_VOLONTARIAT_SERVICE_CIVIQUE = "Volontariat de service civique";
  public static final int NATURE_DISPO_NON_REMUNEREE_INITIATIVE_AGENT_TITULAIRE = 56;
  public static final String LIB_DISPO_NON_REMUNEREE_INITIATIVE_AGENT_TITULAIRE = "Dispo non rémunérée initiative agent titulaire";
  public static final int NATURE_DISPO_NON_REMUNEREE_INITIATIVE_EMPLOYEUR_SP = 57;
  public static final String LIB_DISPO_NON_REMUNEREE_INITIATIVE_EMPLOYEUR_SP = "Dispo non rémunérée initiative employeur public";
  public static final int NATURE_MOBILITE_VOLONTAIRE_SECURISEE = 49;
  public static final int NATURE_CHOMAGE_SANS_RCT = 14;
  public static final int STATUT_NON_PRECISE = 1;
  public static final int STATUT_INITIAL = 2;
  public static final int STATUT_PROLONGE = 3;
  public static final int STATUT_INITIAL_PROLONGE = 4;
  public static final int RENOUVELLEMENT_1 = 1;
  public static final int RENOUVELLEMENT_2 = 2;
  public static final int RENOUVELLEMENT_3 = 3;
  public static final int RENOUVELLEMENT_4 = 4;
  public static final int RENOUVELLEMENT_5 = 5;
  public static final int ORGANISME_AUTRE = 1;
  public static final int ORGANISME_CPAM = 2;
  public static final int ORGANISME_MSA = 3;
  private static HashMap<BigDecimal, String> libelleNaturePEP = new HashMap();
  
  static
  {
    libelleNaturePEP.put(new BigDecimal(4), "Chômage partiele");
    libelleNaturePEP.put(new BigDecimal(5), "Congé de conversion");
    libelleNaturePEP.put(new BigDecimal(6), "Congé de reclassement");
    libelleNaturePEP.put(new BigDecimal(7), "Congé d'enseignement et de recherche");
    libelleNaturePEP.put(new BigDecimal(8), "Congé de formation pour jeunes");
    libelleNaturePEP.put(new BigDecimal(5), "Congé de conversion");
    libelleNaturePEP.put(new BigDecimal(9), "Congé de solidarité familiale");
    libelleNaturePEP.put(new BigDecimal(10), "Congé pour création d'entreprise");
    libelleNaturePEP.put(new BigDecimal(11), "Congé sabbatique");
    libelleNaturePEP.put(new BigDecimal(12), "Congé de solidarité internationale");
    libelleNaturePEP.put(new BigDecimal(21), "Maladie non professionnelle");
    libelleNaturePEP.put(new BigDecimal(22), "Maladie professionnelle");
    libelleNaturePEP.put(new BigDecimal(23), "Accident du travail");
    libelleNaturePEP.put(new BigDecimal(24), "Temps partiel thérapeutique");
    libelleNaturePEP.put(new BigDecimal(25), "Congé maternité");
    libelleNaturePEP.put(new BigDecimal(26), "Congé d'adoption");
    libelleNaturePEP.put(new BigDecimal(27), "Congé post-natal");
    libelleNaturePEP.put(new BigDecimal(28), "Congé paternité");
    libelleNaturePEP.put(new BigDecimal(31), "Congé individuel de formation");
    libelleNaturePEP.put(new BigDecimal(32), "Congé parental d'éducation");
    libelleNaturePEP.put(new BigDecimal(33), "Congé de présence parentale");
    libelleNaturePEP.put(new BigDecimal(55), "Congé sans solde");
    libelleNaturePEP.put(new BigDecimal(34), "Congé pour mandat parlementaire");
    libelleNaturePEP.put(new BigDecimal(35), "Congé pour mandat social");
    libelleNaturePEP.put(new BigDecimal(36), "Service national");
    libelleNaturePEP.put(new BigDecimal(37), "Rappel sous les drapeaux");
    libelleNaturePEP.put(new BigDecimal(38), "Incarcération");
    libelleNaturePEP.put(new BigDecimal(39), "Volontariat civil");
    libelleNaturePEP.put(new BigDecimal(40), "Disponibilité");
    libelleNaturePEP.put(new BigDecimal(41), "Chômage");
    libelleNaturePEP.put(new BigDecimal(42), "Inactivité");
    libelleNaturePEP.put(new BigDecimal(43), "Volontariat associatif");
    libelleNaturePEP.put(new BigDecimal(44), "Volontariat de solidarité internationale");
    libelleNaturePEP.put(new BigDecimal(45), "Volontariat international en administration ou en entreprise");
    libelleNaturePEP.put(new BigDecimal(56), "Dispo non rémunérée initiative agent titulaire");
    libelleNaturePEP.put(new BigDecimal(57), "Dispo non rémunérée initiative employeur public");
    libelleNaturePEP.put(new BigDecimal(58), "Congé non rémunéré initiative agent non tit/stag");
    libelleNaturePEP.put(new BigDecimal(59), "Congé non rémunéré initiative employeur public");
  }
  
  public static String getNaturePEP(BigDecimal code)
  {
    return (String)libelleNaturePEP.get(code);
  }
}

/* Location:
 * Qualified Name:     ConstantesEvenementPersonnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.autresdoms.ga.dom.spec;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class ConstantesRupture
{
  public static final int INDETERMINE = 50;
  public static final String LIB_INDETERMINE = "Motif indéterminé";
  public static final int LIC_REDRESSEMENT_OU_LIQUID_JUDICIAIRE = 2;
  public static final String LIB_LIC_REDRESSEMENT_OU_LIQUID_JUDICIAIRE = "Licenciement suite à redressement judiciaire";
  public static final int LIC_FERMETURE_ETABLISSEMENT = 3;
  public static final String LIB_LIC_FERMETURE_ETABLISSEMENT = "Licenciement suite à fermeture définitive de l'établissement";
  public static final int LIC_FIN_CHANTIER = 4;
  public static final String LIB_LIC_FIN_CHANTIER = "Licenciement pour fin de chantier";
  public static final int LIC_AUTRE_MOTIF = 5;
  public static final String LIB_LIC_AUTRE_MOTIF = "Licenciement pour autre motif";
  public static final int AUTRE_RUPTURE_MOTIF_ECO = 6;
  public static final String LIB_AUTRE_RUPTURE_MOTIF_ECO = "Autre rupture pour motif économique (Art. L/321-1 Alinéa 2 du CT)";
  public static final int FIN_CDD = 7;
  public static final String LIB_FIN_CDD = "Fin de contrat à durée déterminée";
  public static final int FIN_MISSION_INTERIM = 8;
  public static final String LIB_FIN_MISSION_INTERIM = "Fin de mission d'intérim";
  public static final int FIN_CONTRAT_APPRENTISSAGE = 9;
  public static final String LIB_FIN_CONTRAT_APPRENTISSAGE = "Fin de contrat d'apprentissage";
  public static final int RESILIATION_JUDICIAIRE = 10;
  public static final String LIB_RESILIATION_JUDICIAIRE = "Résiliation judiciaire du contrat";
  public static final int FORCE_MAJEURE_FAIT_DU_PRINCE = 11;
  public static final String LIB_FORCE_MAJEURE_FAIT_DU_PRINCE = "Rupture pour force majeure ou fait du prince";
  public static final int COMMUN_ACCORD_CDD_OU_CONTRAT_APPRENTISSAGE = 12;
  public static final String LIB_MOTIF_RUPTURE_COMMUN_ACCORD_CDD_OU_CONTRAT_APPRENTISSAGE = "Rupture d'un commun accord d'un CDD ou d'un contrat d'apprentissage";
  public static final int FIN_PERIODE_ESSAI_INITIATIVE_EMPLOYEUR = 13;
  public static final String LIB_FIN_PERIODE_ESSAI_INITIATIVE_EMPLOYEUR = "Fin de période d'essai à l'initiative de l'employeur";
  public static final int FIN_PERIODE_ESSAI_INITIATIVE_SALARIE = 14;
  public static final String LIB_FIN_PERIODE_ESSAI_INITIATIVE_SALARIE = "Fin de période d'essai à l'initiative du salarié";
  public static final int ANTICIPEE_CDD_INITIATIVE_EMPLOYEUR = 15;
  public static final String LIB_ANTICIPEE_CDD_INITIATIVE_EMPLOYEUR = "Rupture anticipée d'un CDD ou d'un contrat d'apprentissage à l'initiative de l'employeur";
  public static final int ANTICIPEE_CDD_INITIATIVE_SALARIE = 16;
  public static final String LIB_ANTICIPEE_CDD_INITIATIVE_SALARIE = "Rupture anticipée d'un CDD ou d'un contrat d'apprentissage à l'initiative du salarié";
  public static final int MISE_RETRAIRE_INITIATIVE_EMPLOYEUR = 17;
  public static final String LIB_MISE_RETRAIRE_INITIATIVE_EMPLOYEUR = "Mise à la retraite par l'employeur";
  public static final int DEPART_RETRAITE_INITIATIVE_SALARIE = 18;
  public static final String LIB_DEPART_RETRAITE_INITIATIVE_SALARIE = "Départ à la retraite à l'initiative de l'employé";
  public static final int DEMISSION = 19;
  public static final String LIB_DEMISSION_NON_LEGITIME = "Démission";
  public static final int FIN_MANDAT = 21;
  public static final String LIB_FIN_MANDAT = "Fin de mandat";
  public static final int LIC_FAUTE_GRAVE = 22;
  public static final String LIB_LIC_FAUTE_GRAVE = "Licenciement pour faute grave";
  public static final int LIC_FAUTE_LOURDE = 23;
  public static final String LIB_LIC_FAUTE_LOURDE = "Licenciement pour faute lourde";
  public static final int LIC_FORCE_MAJEURE = 24;
  public static final String LIB_LIC_FORCE_MAJEURE = "Licenciement pour force majeure";
  public static final int LIC_CONV_FNE = 25;
  public static final String LIB_LIC_CONV_FNE = "Licenciement convention FNE";
  public static final int LIC_INAPT_PHYSIQUE_PRO = 26;
  public static final String LIB_LIC_INAPT_PHYSIQUE_PRO = "Licenciement pour inaptitude physique d'origine professionnelle";
  public static final int LIC_ARE_CONVERSION = 27;
  public static final String LIB_LIC_ARE_CONVERSION = "Licenciement ARE conversion";
  public static final int LIC_CONV_CATS = 28;
  public static final String LIB_LIC_CONV_CATS = "Licenciement convention CATS";
  public static final int LIC_PRE_RETRAITE_MI_TEMPS = 30;
  public static final String LIB_LIC_PRE_RETRAITE_MI_TEMPS = "Licenciement préretraite mi-temps";
  public static final int LIC_PRE_RETRAITE_PROGRESS = 31;
  public static final String LIB_LIC_PRE_RETRAITE_PROGRESS = "Licenciement PRP";
  public static final int LIQ_JUDICIAIRE = 33;
  public static final String LIB_LIQ_JUDICIAIRE = "Licenciement suite à liquidation judiciaire";
  public static final int LIC_INAPT_PHYSIQUE_NON_PRO = 20;
  public static final String LIB_INAPT_PHYSIQUE_NON_PRO = "Licenciement pour inaptitude physique d'origine non professionnelle";
  public static final int MOBILITE_VOLONTAIRE = 97;
  public static final String LIB_MOBILITE_VOLONTAIRE = "Entrée en Période de Mobilité Volontaire Sécurisée";
  public static final int CHOMAGE_TOTAL_SANS_RCT = 99;
  public static final String LIB_CHOMAGE_TOTAL_SANS_RCT = "Chômage total sans rupture";
  public static final int LIC_MOTIF_ECO = 1;
  public static final String LIB_MOTIF_ECO = "Licenciement pour motif économique";
  public static final int RUPTURE_CNE_INITIATIVE_EMPLOYEUR = 39;
  public static final String LIB_RUPTURE_CNE_INITIATIVE_EMPLOYEUR = "Rupture CNE à l'initiative de l'employeur";
  public static final int RUPTURE_CNE_INITIATIVE_SALARIE = 40;
  public static final String LIB_RUPTURE_CNE_INITIATIVE_SALARIE = "Rupture CNE à l'initiative du salarié";
  public static final int RUPTURE_CONVENTIONNELLE_CONTRAT_TRAVAIL = 41;
  public static final String LIB_RUPTURE_CONVENTIONNELLE_CONTRAT_TRAVAIL = "Rupture conventionnelle du contrat de travail à durée indéterminée";
  public static final int RUPTURE_LIC_FERMETURE_ETABLISSEMENT = 3;
  public static final String LIB_RUPTURE_LIC_FERMETURE_ETABLISSEMENT = "Rupture pour fermeture définitive de l'établissement";
  public static final int RUPTURE_ANTICIPEE_FERMETURE_ETABLISSEMENT = 38;
  public static final String LIB_RUPTURE_ANTICIPEE_FERMETURE_ETABLISSEMENT = "Rupture anticipée suite à la fermeture définitive d'un établissement";
  public static final int RUPTURE_ANTICIPEE_ARRET_TOURNAGE = 35;
  public static final String LIB_RUPTURE_ANTICIPEE_ARRET_TOURNAGE = "Rupture pour arrêt anticipé du tournage";
  public static final int RUPTURE_ENTREE_CRP = 42;
  public static final String LIB_RUPTURE_ENTREE_CRP = "Rupture pour entrée en CRP";
  public static final int RUPTURE_ENTREE_CTP = 43;
  public static final String LIB_RUPTURE_ENTREE_CTP = "Rupture pour entrée en CTP";
  public static final int RUPTURE_ENTREE_CSP = 44;
  public static final String LIB_RUPTURE_ENTREE_CSP = "Rupture pour entrée en CSP";
  public static final int RUPTURE_ENTREE_CSP_VOLONTAIRE = 45;
  public static final int RUPTURE_ENTREE_PAP = 48;
  public static final String LIB_RUPTURE_ENTREE_PAP = "Rupture pour entrée en PAP";
  public static final int RUPTURE_ENTREE_PAP_VOLONTAIRE = 49;
  public static final int RUPTURE_MOTIF_SPECIFIQUE = 47;
  public static final int RUPTURE_ANTICIPEE_CDD_INAPT_PHYSIQUE_CONSTATEE = 46;
  public static final String LIB_RUPTURE_ANTICIPEE_CDD_INAPT_PHYSIQUE_CONSTATEE = "Rupture anticipée d'un CDD pour inaptitude physique";
  public static final int CONTEXTE_DEMISSION_INDETERMINE = 0;
  public static final int CONTEXTE_DEMISSION_SUIVRE_PARENTS = 1;
  public static final int CONTEXTE_DEMISSION_SUIVRE_CONJOINT = 2;
  public static final int CONTEXTE_DEMISSION_MARIAGE_PACS = 3;
  public static final int CONTEXTE_DEMISSION_NOUVEL_EMPLOI_CES_CAE_CIE_CA_CI_RMA = 4;
  public static final int CONTEXTE_DEMISSION_RELIQUAT_RETRAITE = 5;
  public static final int CONTEXTE_DEMISSION_NON_PAIEMENT_SALAIRES = 6;
  public static final int CONTEXTE_DEMISSION_ACTE_DELICTUEUX = 7;
  public static final int CONTEXTE_DEMISSION_CDI_FIN_PERIODE_ESSAI = 8;
  public static final int CONTEXTE_DEMISSION_CONTRAT_COUPLE = 9;
  public static final int CONTEXTE_DEMISSION_ARRET_PERIODIQUE_CLAUSE_CONSCIENCE_INDEMNITES = 10;
  public static final int CONTEXTE_DEMISSION_VOLONTARIAT_INTERNATIONAL = 11;
  public static final int CONTEXTE_DEMISSION_CREATION_ENTREPRISE = 12;
  public static final int CONTEXTE_DEMISSION_VIOLENCE_CONJUGALE = 13;
  public static final int CONTEXTE_DEMISSION_FIN_PERIODE_ESSAI_INF_91J = 14;
  public static final int CONTEXTE_DEMISSION_SUIVRE_CURATEUR_TUTEUR_MAIN_JUSTICE = 15;
  private static HashMap<BigDecimal, String> libelleMotifRuptureFCT = new HashMap();
  
  static
  {
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(50L), "Motif indéterminé");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(2L), "Licenciement suite à redressement judiciaire");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(3L), "Licenciement suite à fermeture définitive de l'établissement");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(4L), "Licenciement pour fin de chantier");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(5L), "Licenciement pour autre motif");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(7L), "Fin de contrat à durée déterminée");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(8L), "Fin de mission d'intérim");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(9L), "Fin de contrat d'apprentissage");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(10L), "Résiliation judiciaire du contrat");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(11L), "Rupture pour force majeure ou fait du prince");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(12L), "Rupture d'un commun accord d'un CDD ou d'un contrat d'apprentissage");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(13L), "Fin de période d'essai à l'initiative de l'employeur");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(14L), "Fin de période d'essai à l'initiative du salarié");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(15L), "Rupture anticipée d'un CDD ou d'un contrat d'apprentissage à l'initiative de l'employeur");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(16L), "Rupture anticipée d'un CDD ou d'un contrat d'apprentissage à l'initiative du salarié");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(17L), "Mise à la retraite par l'employeur");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(18L), "Départ à la retraite à l'initiative de l'employé");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(19L), "Démission");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(21L), "Fin de mandat");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(22L), "Licenciement pour faute grave");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(23L), "Licenciement pour faute lourde");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(24L), "Licenciement pour force majeure");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(25L), "Licenciement convention FNE");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(26L), "Licenciement pour inaptitude physique d'origine professionnelle");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(27L), "Licenciement ARE conversion");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(28L), "Licenciement convention CATS");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(30L), "Licenciement préretraite mi-temps");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(31L), "Licenciement PRP");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(33L), "Licenciement suite à liquidation judiciaire");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(20L), "Licenciement pour inaptitude physique d'origine non professionnelle");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(1L), "Licenciement pour motif économique");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(39L), "Rupture CNE à l'initiative de l'employeur");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(40L), "Rupture CNE à l'initiative du salarié");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(99L), "Chômage total sans rupture");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(35L), "Rupture pour arrêt anticipé du tournage");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(3L), "Rupture pour fermeture définitive de l'établissement");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(41L), "Rupture conventionnelle du contrat de travail à durée indéterminée");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(42L), "Rupture pour entrée en CRP");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(43L), "Rupture pour entrée en CTP");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(44L), "Rupture pour entrée en CSP");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(45L), "Rupture pour entrée en CSP");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(38L), "Rupture anticipée suite à la fermeture définitive d'un établissement");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(46L), "Rupture anticipée d'un CDD pour inaptitude physique");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(48L), "Rupture pour entrée en PAP");
    libelleMotifRuptureFCT.put(BigDecimal.valueOf(49L), "Rupture pour entrée en PAP");
  }
  
  public static String getLibelleMotifRputureFCT(BigDecimal codeMotif)
  {
    return (String)libelleMotifRuptureFCT.get(codeMotif);
  }
}

/* Location:
 * Qualified Name:     ConstantesRupture
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
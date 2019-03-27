package fr.unedic.cali.autresdoms.ga.dom.spec;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class ConstantesPANS
{
  public static final boolean PANS_ATTESTE = true;
  public static final int PANS_TYPE_REVENU_FORFAIT = 1;
  public static final int PANS_TYPE_REVENU_FORFAIT_PERSO = 2;
  public static final int PANS_TYPE_REVENU_MONTANT_AJUSTE = 3;
  public static final int PANS_TYPE_REVENU_MONTANT_ANNUALISE = 4;
  public static final int PANS_ETAT_PROFESSIONNEL = 1;
  public static final String LIB_PANS_ETAT_PROFESSIONNEL = "Professionnelle";
  public static final int PANS_ETAT_NON_PROFESSIONNEL = 2;
  public static final String LIB_PANS_ETAT_NON_PROFESSIONNEL = "Non Professionnelle";
  public static final int PANS_MOTIF_FIN_RAISON_ECONOMIQUE = 1;
  public static final String LIB_PANS_MOTIF_FIN_RAISON_ECONOMIQUE = "Raison économique";
  public static final int PANS_MOTIF_FIN_FORCE_MAJEURE = 2;
  public static final String LIB_PANS_MOTIF_FIN_FORCE_MAJEURE = "Force majeure";
  public static final int PANS_MOTIF_FIN_VENTE_ENTREPRISE = 3;
  public static final String LIB_PANS_MOTIF_FIN_VENTE_ENTREPRISE = "Vente de l'entreprise";
  public static final int PANS_MOTIF_FIN_RADIATION = 4;
  public static final String LIB_PANS_MOTIF_FIN_RADIATION = "Radiation de l'ordre professionnel";
  public static final int PANS_MOTIF_FIN_AUTRES = 5;
  public static final String LIB_PANS_MOTIF_FIN_AUTRES = "Autres";
  public static final int PANS_NATURE_SERVICE_CONJOINT = 1;
  public static final String LIB_PANS_NATURE_SERVICE_CONJOINT = "Activité exercée au service d'un conjoint";
  public static final int PANS_NATURE_ARTISANT = 2;
  public static final String LIB_PANS_NATURE_ARTISANT = "Artisan";
  public static final int PANS_NATURE_BENEVOLAT = 3;
  public static final String LIB_PANS_NATURE_BENEVOLAT = "Bénévolat";
  public static final int PANS_NATURE_COMMERCANT = 4;
  public static final String LIB_PANS_NATURE_COMMERCANT = "Commerçant";
  public static final int PANS_NATURE_DIRIGEANT = 5;
  public static final String LIB_PANS_NATURE_DIRIGEANT = "Dirigeant";
  public static final int PANS_NATURE_ENTREPRENEUR = 6;
  public static final String LIB_PANS_NATURE_ENTREPRENEUR = "Entrepreneur";
  public static final int PANS_NATURE_GERANT_EGALITAIRE = 7;
  public static final String LIB_PANS_NATURE_GERANT_EGALITAIRE = "Gérant égalitaire";
  public static final int PANS_NATURE_GERANT_MINORITAIRE = 8;
  public static final String LIB_PANS_NATURE_GERANT_MINORITAIRE = "Gérant minoritaire";
  public static final int PANS_NATURE_MANDAT_ELECTIF = 9;
  public static final String LIB_PANS_NATURE_MANDAT_ELECTIF = "Mandat électif";
  public static final int PANS_NATURE_MANDAT_SOCIAL = 10;
  public static final String LIB_PANS_NATURE_MANDAT_SOCIAL = "Mandat social";
  public static final int PANS_NATURE_MANDAT_SYNDICAL = 11;
  public static final String LIB_PANS_NATURE_MANDAT_SYNDICAL = "Mandat syndical";
  public static final int PANS_NATURE_PDG = 12;
  public static final String LIB_PANS_NATURE_PDG = "PDG";
  public static final int PANS_NATURE_PROFESSION_AGRICOLE = 13;
  public static final String LIB_PANS_NATURE_PROFESSION_AGRICOLE = "Profession agricole";
  public static final int PANS_NATURE_PROFESSION_LIBERALE = 14;
  public static final String LIB_PANS_NATURE_PROFESSION_LIBERALE = "Profession libérale";
  public static final int PANS_NATURE_TRAVAIL_INTERET_GENERAL = 15;
  public static final String LIB_PANS_NATURE_TRAVAIL_INTERET_GENERAL = "Trav. Intérêt généraux";
  public static final int PANS_EMPLOI_ARTISAN = 2;
  public static final String LIB_PANS_EMPLOI_ARTISAN = "Artisan";
  public static final int PANS_EMPLOI_ACTIVITE_BENEVOLE = 3;
  public static final String LIB_PANS_EMPLOI_ACTIVITE_BENEVOLE = "Activité bénévole";
  public static final int PANS_EMPLOI_COMMERCANT = 4;
  public static final String LIB_PANS_EMPLOI_COMMERCANT = "Commerçant";
  public static final int PANS_EMPLOI_DIRIGEANT_SOCIETE = 5;
  public static final String LIB_PANS_EMPLOI_DIRIGEANT_SOCIETE = "Dirigeant de société";
  public static final int PANS_EMPLOI_ENTREPRENEUR_INDIVIDUEL = 6;
  public static final String LIB_PANS_EMPLOI_ENTREPRENEUR_INDIVIDUEL = "Entrepreneur individuel";
  public static final int PANS_EMPLOI_GERANT_EGALITAIRE = 7;
  public static final String LIB_PANS_EMPLOI_GERANT_EGALITAIRE = "Gérant égalitaire";
  public static final int PANS_EMPLOI_GERANT_MAJORITAIRE = 26;
  public static final String LIB_PANS_EMPLOI_GERANT_MAJORITAIRE = "Gérant majoritaire";
  public static final int PANS_EMPLOI_MANDATAIRE_SOCIAL = 10;
  public static final String LIB_PANS_EMPLOI_MANDATAIRE_SOCIAL = "Mandataire social";
  public static final int PANS_EMPLOI_MANDAT_SYNDICAL = 11;
  public static final String LIB_PANS_EMPLOI_MANDAT_SYNDICAL = "Mandat syndical";
  public static final int PANS_EMPLOI_PROFESSION_AGRICOLE = 13;
  public static final String LIB_PANS_EMPLOI_PROFESSION_AGRICOLE = "Profession agricole";
  public static final int PANS_EMPLOI_PROFESSION_LIBERALE = 14;
  public static final String LIB_PANS_EMPLOI_PROFESSION_LIBERALE = "Profession libérale";
  public static final int PANS_EMPLOI_AGENT_COMMERCIAL = 17;
  public static final String LIB_PANS_EMPLOI_AGENT_COMMERCIAL = "Agent commercial";
  public static final int PANS_EMPLOI_AUTO_ENTREPRENEUR = 18;
  public static final String LIB_PANS_EMPLOI_AUTO_ENTREPRENEUR = "Auto-entrepreneur";
  public static final int PANS_EMPLOI_COMMERCANT_AMBULANT = 19;
  public static final String LIB_PANS_EMPLOI_COMMERCANT_AMBULANT = "Commerçant ambulant";
  public static final int PANS_EMPLOI_CONJOINT_ASSOCIE = 20;
  public static final String LIB_PANS_EMPLOI_CONJOINT_ASSOCIE = "Conjoint associé";
  public static final int PANS_EMPLOI_CONJOINT_CO_EXPLOITANT = 21;
  public static final String LIB_PANS_EMPLOI_CONJOINT_CO_EXPLOITANT = "Conjoint co-exploitant";
  public static final int PANS_EMPLOI_CONJOINT_COLLABORATEUR = 22;
  public static final String LIB_PANS_EMPLOI_CONJOINT_COLLABORATEUR = "Conjoint collaborateur";
  public static final int PANS_EMPLOI_COTISANT_SOLIDARITE = 23;
  public static final String LIB_PANS_EMPLOI_COTISANT_SOLIDARITE = "Cotisant de solidarité";
  public static final int PANS_EMPLOI_DIRIGEANT_ASSOCIATION = 24;
  public static final String LIB_PANS_EMPLOI_DIRIGEANT_ASSOCIATION = "Dirigeant d'association";
  public static final int PANS_EMPLOI_GERANT_ASSOCIE_UNIQUE = 25;
  public static final String LIB_PANS_EMPLOI_GERANT_ASSOCIE_UNIQUE = "Gérant associé unique";
  public static final int PANS_EMPLOI_GERANT_MINORITAIRE = 8;
  public static final String LIB_PANS_EMPLOI_GERANT_MINORITAIRE = "Gérant minoritaire";
  public static final int PANS_EMPLOI_MANDAT_REPRESENTATION_NATIONALE = 27;
  public static final String LIB_PANS_EMPLOI_MANDAT_REPRESENTATION_NATIONALE = "Mandat de représentation nationale";
  public static final int PANS_EMPLOI_MANDAT_REPRESENTATION_PROFESSIONNELLE = 28;
  public static final String LIB_PANS_EMPLOI_MANDAT_REPRESENTATION_PROFESSIONNELLE = "Mandat de représentation professionnelle";
  public static final int PANS_EMPLOI_MANDAT_REPRESENTATION_TERRITORIALE = 29;
  public static final String LIB_PANS_EMPLOI_MANDAT_REPRESENTATION_TERRITORIALE = "Mandat de représentation territoriale";
  public static final int PANS_EMPLOI_VENDEUR_DOMICILE_INDEPENDANT = 30;
  public static final String LIB_PANS_EMPLOI_VENDEUR_DOMICILE_INDEPENDANT = "Vendeur à domicile indépendant";
  public static final int PANS_EMPLOI_PORTAGE_SALARIAL = 31;
  public static final String LIB_PANS_EMPLOI_PORTAGE_SALARIAL = "Portage salarial";
  public static final int PANS_EMPLOI_ACTIVITE_ETRANGER = 32;
  public static final String LIB_PANS_EMPLOI_ACTIVITE_ETRANGER = "Activité exercée à l'étranger";
  public static final int PANS_NATURE_ARTISTE_NON_SALARIE = 16;
  public static final String LIB_PANS_NATURE_ARTISTE_NON_SALARIE = "Artistes non salariés";
  public static final int PANS_NATURE_AVOCAT_COMMIS_OFFICE = 17;
  public static final String LIB_PANS_NATURE_AVOCAT_COMMIS_OFFICE = "Avocat commis d'office";
  public static final int PANS_NATURE_CONCESSION_LICENCE_BREVET = 18;
  public static final String LIB_PANS_NATURE_CONCESSION_LICENCE_BREVET = "Concession de licence de brevet";
  public static final int PANS_NATURE_DROITS_AUTEUR = 19;
  public static final String LIB_PANS_NATURE_DROITS_AUTEUR = "Droits d'auteurs";
  public static final int PANS_NATURE_REDACTEUR_ARTICLE = 20;
  public static final String LIB_PANS_NATURE_REDACTEUR_ARTICLE = "Rédacteur d'articles";
  public static final int ORIGINE_EXTRAIT_K_BIS = 75;
  public static final int ORIGINE_CONTRAT_ENGAGEMENT = 76;
  public static final int ORIGINE_INSCRIPTION_REGISTRE_COMMERCE = 77;
  public static final int ORIGINE_INSCRIPTION_AGRICULTURE = 78;
  public static final int ORIGINE_INSCRIPTION_ORDRE_PROF = 79;
  public static final int ORIGINE_RELEVE_URSSAF = 80;
  public static final int ORIGINE_JUSTIFICATIF_REVENU_IMPOSABLE = 81;
  public static final int ORIGINE_FACTURE = 82;
  public static final int ORIGINE_HONORAIRE = 83;
  public static final int STATUS_DDTE_ABSCENCE_INFO = 0;
  public static final String LIB_STATUS_DDTE_ABSCENCE_INFO = "Abscence informations";
  public static final int STATUS_DDTE_ACCORD = 2;
  public static final String LIB_STATUS_DDTE_ACCORD = "Accord DDTE";
  public static final int STATUS_DDTE_REFUS = 1;
  public static final String LIB_STATUS_DDTE_REFUS = "Refus DDTE";
  public static final int ACTIVITE_ENTREPRISE_CREATION_OU_REPRISE = 0;
  public static final String LIB_ACTIVITE_ENTREPRISE_CREATION_OU_REPRISE = "Création ou reprise d'entreprise";
  public static final int ACTIVITE_ENTREPRISE_CREATION = 1;
  public static final String LIB_ACTIVITE_ENTREPRISE_CREATION = "Création d'entreprise";
  public static final int ACTIVITE_ENTREPRISE_REPRISE = 2;
  public static final String LIB_ACTIVITE_ENTREPRISE_REPRISE = "Reprise d'entreprise";
  private static HashMap s_libelleEtat = new HashMap();
  private static HashMap s_libelleNature = new HashMap();
  private static HashMap s_libelleEmploi = new HashMap();
  private static HashMap s_libelleMotifRupture = new HashMap();
  
  static
  {
    s_libelleEtat.put(new BigDecimal(1), "Professionnelle");
    s_libelleEtat.put(new BigDecimal(2), "Non Professionnelle");
    
    s_libelleMotifRupture.put(new BigDecimal(1), "Raison économique");
    s_libelleMotifRupture.put(new BigDecimal(2), "Force majeure");
    s_libelleMotifRupture.put(new BigDecimal(3), "Vente de l'entreprise");
    s_libelleMotifRupture.put(new BigDecimal(4), "Radiation de l'ordre professionnel");
    s_libelleMotifRupture.put(new BigDecimal(5), "Autres");
    
    s_libelleNature.put(new BigDecimal(1), "Activité exercée au service d'un conjoint");
    s_libelleNature.put(new BigDecimal(2), "Artisan");
    s_libelleNature.put(new BigDecimal(3), "Bénévolat");
    s_libelleNature.put(new BigDecimal(4), "Commerçant");
    s_libelleNature.put(new BigDecimal(5), "Dirigeant");
    s_libelleNature.put(new BigDecimal(6), "Entrepreneur");
    s_libelleNature.put(new BigDecimal(7), "Gérant égalitaire");
    s_libelleNature.put(new BigDecimal(8), "Gérant minoritaire");
    s_libelleNature.put(new BigDecimal(9), "Mandat électif");
    s_libelleNature.put(new BigDecimal(10), "Mandat social");
    s_libelleNature.put(new BigDecimal(11), "Mandat syndical");
    s_libelleNature.put(new BigDecimal(12), "PDG");
    s_libelleNature.put(new BigDecimal(13), "Profession agricole");
    s_libelleNature.put(new BigDecimal(14), "Profession libérale");
    s_libelleNature.put(new BigDecimal(15), "Trav. Intérêt généraux");
    s_libelleNature.put(new BigDecimal(16), "Artistes non salariés");
    s_libelleNature.put(new BigDecimal(17), "Avocat commis d'office");
    s_libelleNature.put(new BigDecimal(18), "Concession de licence de brevet");
    s_libelleNature.put(new BigDecimal(19), "Droits d'auteurs");
    s_libelleNature.put(new BigDecimal(20), "Rédacteur d'articles");
    
    s_libelleEmploi.put(new BigDecimal(2), "Artisan");
    s_libelleEmploi.put(new BigDecimal(3), "Activité bénévole");
    s_libelleEmploi.put(new BigDecimal(4), "Commerçant");
    s_libelleEmploi.put(new BigDecimal(5), "Dirigeant de société");
    s_libelleEmploi.put(new BigDecimal(6), "Entrepreneur individuel");
    s_libelleEmploi.put(new BigDecimal(7), "Gérant égalitaire");
    s_libelleEmploi.put(new BigDecimal(26), "Gérant majoritaire");
    s_libelleEmploi.put(new BigDecimal(10), "Mandataire social");
    s_libelleEmploi.put(new BigDecimal(11), "Mandat syndical");
    s_libelleEmploi.put(new BigDecimal(13), "Profession agricole");
    s_libelleEmploi.put(new BigDecimal(14), "Profession libérale");
    s_libelleEmploi.put(new BigDecimal(17), "Agent commercial");
    s_libelleEmploi.put(new BigDecimal(18), "Auto-entrepreneur");
    s_libelleEmploi.put(new BigDecimal(19), "Commerçant ambulant");
    s_libelleEmploi.put(new BigDecimal(20), "Conjoint associé");
    s_libelleEmploi.put(new BigDecimal(21), "Conjoint co-exploitant");
    s_libelleEmploi.put(new BigDecimal(22), "Conjoint collaborateur");
    s_libelleEmploi.put(new BigDecimal(23), "Cotisant de solidarité");
    s_libelleEmploi.put(new BigDecimal(24), "Dirigeant d'association");
    s_libelleEmploi.put(new BigDecimal(25), "Gérant associé unique");
    s_libelleEmploi.put(new BigDecimal(8), "Gérant minoritaire");
    s_libelleEmploi.put(new BigDecimal(27), "Mandat de représentation nationale");
    s_libelleEmploi.put(new BigDecimal(28), "Mandat de représentation professionnelle");
    s_libelleEmploi.put(new BigDecimal(29), "Mandat de représentation territoriale");
    s_libelleEmploi.put(new BigDecimal(30), "Vendeur à domicile indépendant");
    s_libelleEmploi.put(new BigDecimal(31), "Portage salarial");
    s_libelleEmploi.put(new BigDecimal(32), "Activité exercée à l'étranger");
  }
  
  public static String getEtatPANS(BigDecimal p_codeEtat)
  {
    return (String)s_libelleEtat.get(p_codeEtat);
  }
  
  public static String getMotifFinPANS(BigDecimal p_codeMotif)
  {
    return (String)s_libelleMotifRupture.get(p_codeMotif);
  }
  
  public static String getNaturePANS(BigDecimal p_codeNature)
  {
    return (String)s_libelleNature.get(p_codeNature);
  }
  
  public static String getEmploiPANS(BigDecimal p_codeEmploi)
  {
    return (String)s_libelleEmploi.get(p_codeEmploi);
  }
}

/* Location:
 * Qualified Name:     ConstantesPANS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
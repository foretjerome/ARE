package fr.unedic.cali.dom;

public abstract interface ComparateurDecisionSpec
{
  public static final String LIB_ELEMENT_REGLEMENT = "Réglement Applicable";
  public static final String LIB_ELEMENT_SJR = "Sjr";
  public static final String LIB_ELEMENT_SJC = "Sjc";
  public static final String LIB_ELEMENT_COEFFICIENT_SAISONNIER = "Coefficient Saisonnier";
  public static final String LIB_ELEMENT_COEFFICIENT_TPS_PARTIEL = "Coefficient Temps Partiel";
  public static final String LIB_ELEMENT_TOP_ALSACE_MOSELLE = "Top Alsace/Moselle";
  public static final String LIB_ELEMENT_CAISSE_SECU = "Caisse spéciale de sécurité sociale";
  public static final String LIB_ELEMENT_COMPETENCE_ADMINISTRATIVE = "Compétence administrative";
  public static final String LIB_ELEMENT_ATTRIB_PREC_REPRISE = "Attribution précédente";
  public static final String LIB_ELEMENT_NOMBRE_HEURE_TRAVAILLEE_ETENDU = "NHTE";
  public static final String LIB_ELEMENT_NOMBRE_HEURE_TRAVAILLEE_PLAFONNE = "NHTP";
  public static final String LIB_ELEMENT_NOMBRE_HEURE_TRAVAILLEE_MAJORE = "NHTM";
  public static final String LIB_ELEMENT_SALAIRE_REFERENCE = "Salaire de référence initial plafonné";
  public static final String LIB_ELEMENT_QUANTITE_AFFILIATION = "Quantité d'affiliation";
  public static final String LIB_ELEMENT_DEPART_DELAI_121_JOURS = "Date début délai de 121 j";
  public static final String LIB_ELEMENT_DUREE_POST_PRIME = "Durée restant en CSP DC";
  public static final String LIB_ELEMENT_DATE_FIN_DISPOSITIF = "Date fin du dispositif";
  public static final String LIB_ELEMENT_DUREE_ALLONGEMENT = "Durée d'allongement potentiel";
  public static final String LIB_ELEMENT_DECISION_FTHR = "Nature de la décision Fthr";
  public static final String LIB_ELEMENT_DECISION_FP = "Nature de la décision FP";
  public static final String LIB_ELEMENT_FRAIS_ENGAGES = "Total des frais engagés";
  public static final String LIB_ELEMENT_PLAFOND_DEROGATOIRE = "Dépassement plafond";
  public static final String LIB_ELEMENT_MONTANT_PRISE_EN_CHARGE = "Montant prise en charge";
  public static final String LIB_ELEMENT_MONTANT_GLOBAL_PLAFONNE = "Montant global plafonné";
  public static final String LIB_ELEMENT_PLAFOND_APPLICABLE = "Plafond applicable";
  public static final String LIB_ELEMENT_PLAFOND_DEROGATOIRE_APPLICABLE = "Plafond dérogatoire applicable";
  public static final String LIB_ELEMENT_DEBUT_ACTION_RECLASEMENT = "Date début de l'action de reclassement";
  public static final String LIB_ELEMENT_FIN_ACTION_RECLASSEMENT = "Date fin de l'action de reclassement";
  public static final String LIB_ELEMENT_DATE_LIMITE = "Date limite indemnisation";
  public static final String LIB_DECISION_RBF_DECISION_ATTRIBUTION_NON_EFFECTIVE = "Attribution Prévisionnelle";
  public static final int DECISION_RBF_ATTRIBUTION_NON_EFFECTIVE = 1;
  public static final String LIB_DECISION_RBF_DECISION_ATTRIBUTION_EFFECTIVE = "Attribution Effective";
  public static final int DECISION_RBF_ATTRIBUTION_EFFECTIVE = 2;
  public static final String LIB_DECISION_RBF_DECISION_REFUS = "Refus";
  public static final int DECISION_RBF_REFUS = 3;
  public static final String LIB_DECISION_RBF_NON_DECISIONNEE = "Aucun produit demandé";
  public static final int DECISION_RBF_NON_DECISIONNEE = 0;
  public static final String LIB_ELEMENT_DJI = "Dji";
  public static final String LIB_ELEMENT_DUREE = "Durée";
  public static final String LIB_ELEMENT_DUREE_FORMATION = "Durée de la formation";
  public static final int DECISION_ACCRE_ATTRIBUTION = 10;
  public static final String LIB_DECISION_ACCRE_ATTRIBUTION = "Admission";
  public static final String LIB_ELEMENT_MONTANT_JOURNALIER_BRUT = "Montant Journalier Brut";
  public static final String LIB_ELEMENT_DATE_FIN_INDEMNISATION = "Date de fin d'indemnisation";
  public static final int DECISION_ARCE_ATTRIBUTION = 10;
  public static final String LIB_DECISION_ARCE_ATTRIBUTION = "Admission";
  public static final String LIB_ELEMENT_MONTANT_CAPITAL_GLOBAL = "Capital global Arce";
  public static final String LIB_ELEMENT_MONTANT_CAPITAL_GLOBAL_ADR = "Capital global ADR";
  public static final String LIB_ELEMENT_MONTANT_CAPITAL_GLOBAL_PAR = "Capital global Prime";
  public static final int DECISION_ADR_ATTRIBUTION = 10;
  public static final int DECISION_ADR_REJET = 16;
  public static final String LIB_NOMBRE_REVISIONS = "Nombre de révisions du droit";
  public static final String LIB_DATE_REVISION = "Date de la Revision";
  public static final String LIB_DATE_ATTRIBUTION = "Date de l'attribution";
  public static final String LIB_MONTANT_REVISION = "Montant de la Revision";
  public static final String LIB_MONTANT_ATTRIBUTION = "Montant de l'attribution";
  public static final String LIB_ELEMENT_DECISION_ADR = "Nature de la décision";
  public static final String LIB_ELEMENT_DATE_PREMIER_VERSEMENT = "Date du premier versement";
  public static final String LIB_ELEMENT_PRODUIT = "Produit Proposé";
  public static final String LIB_ELEMENT_DUREE_EFFECTIVE = "Durée Effective";
  public static final String LIB_ELEMENT_MOTIFS_REJET = "Motifs de rejet";
  public static final String LIB_ELEMENT_DATE_ATTRIBUTION = "Date Attribution";
  public static final String LIB_ELEMENT_DECISION = "Libellé Décision";
  public static final String LIB_ELEMENT_MONTANT_BRUT = "Montant brut";
  public static final String LIB_ELEMENT_MONTANT_BRUT_IT = "Montant brut IT";
  public static final String LIB_ELEMENT_MONTANT_BRUT_IH = "Montant brut IH";
  public static final String LIB_ELEMENT_PJI = "Pji";
  public static final String LIB_DECISION_ADMISSION = "Admission";
  public static final String LIB_DECISION_REJET = "Rejet";
  public static final String LIB_SANS_OBJET = "Sans Objet";
  public static final String LIB_ELEMENT_SYSTEMATIQUE = "Date // Heure de liquidation";
  public static final String LIB_ELEMENT_TYPE_AIDE = "Type d'aide";
  public static final String ERR_LIB_EXCEPTION_SUR_LIQUIDATION = "Exception couche logique sur demande";
  public static final String ERR_LIB_ALERTES_NON_BLOQUANTE_AVEC_MISE_REEXAMEN = "Alerte non bloquante avec mise en réexamen";
  public static final String ERR_LIB_DONNEES_FORCEES_AVEC_MISE_REEXAMEN = "Données forçées avec mise en réexamen";
  public static final String ERR_LIB_REMISE_EN_CAUSE_AUTO = "Remise en cause automatique de la décision";
}

/* Location:
 * Qualified Name:     ComparateurDecisionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
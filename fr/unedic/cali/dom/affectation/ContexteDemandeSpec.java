package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;

public abstract interface ContexteDemandeSpec
{
  public static final int REGROUPEMENT_CONTEXTE_ASP = 1;
  public static final int REGROUPEMENT_CONTEXTE_PMVS = 2;
  public static final int REGROUPEMENT_CONTEXTE_ADH_VOL = 3;
  public static final int REGROUPEMENT_EN_CRS_SUSP = 4;
  public static final int REGROUPEMENT_CONTEXTE_FIN_ASP = 5;
  public static final int REGROUPEMENT_CONTEXTE_ASP_PAP_SUR_PRODUIT_CGE = 6;
  public static final int REGROUPEMENT_CONTEXTE_TYPE_PRODUIT_CSP_PAP = 7;
  public static final int REGROUPEMENT_CONTEXTE_CLAUSE_RATTRAPAGE = 8;
  public static final int REGROUPEMENT_CONTEXTE_TYPE_PRODUIT_CSP_PAP_DC = 9;
  public static final int REGROUPEMENT_CONTEXTE_TYPE_PRODUIT_PAP = 10;
  public static final int REGROUPEMENT_CONTEXTE_DISPONIBILITE = 11;
  public static final String TYPE_CONTEXTE_AUCUN = "AUCUN";
  public static final String TYPE_CONTEXTE_FIN_ATP_BASCULE = "FINATPBASC";
  public static final String TYPE_CONTEXTE_FIN_ATP = "FINATP";
  public static final String TYPE_CONTEXTE_ATP_BASCULE = "BASCULEATP";
  public static final String TYPE_CONTEXTE_IDE_ATP = "IDEATP";
  public static final String TYPE_CONTEXTE_FINANCEMENT_ATP = "FINANCATP";
  public static final String TYPE_CONTEXTE_FINANCEMENT_ATP_BASCULE = "FINANCATPB";
  public static final String TYPE_CONTEXTE_CHOMAGE_EN_COURS_SUSPENSION = "CSRSUSP";
  public static final String TYPE_CONTEXTE_RUPTURE_CONTRAT_EN_COURS_SUSPENSION = "RUPCTRSUSP";
  public static final String TYPE_CONTEXTE_SUITE_CSR = "SUITECSR";
  public static final String TYPE_CONTEXTE_IDE_ASP = "IDEASP";
  public static final String TYPE_CONTEXTE_FIN_ASP = "FINASP";
  public static final String TYPE_CONTEXTE_ASP_PAP_ADH_VOLO_DONNANT_ARE = "ADHVOLARE";
  public static final String TYPE_CONTEXTE_FIN_ASP_ADH_VOLO_DONNANT_ARE = "FINASPVOL";
  public static final String TYPE_CONTEXTE_ASP_PAP_ADH_VOLO_NON_FG_ARE = "ASPVOLSARE";
  public static final String TYPE_CONTEXTE_FIN_ASP_ADH_VOLO_NON_FG_ARE = "FINASPVOLC";
  public static final String TYPE_CONTEXTE_AFAF_RFPE_MAYOTTE = "MAYOTTE";
  public static final String TYPE_CONTEXTE_ARE_SOUS_JACENT_POUR_ASP = "ARESJASPDC";
  public static final String TYPE_CONTEXTE_SOL_CGE_MAYOTTE = "SOLMAYOTTE";
  public static final String TYPE_CONTEXTE_ASS_CPA_MAYOTTE = "CPAMAYOTTE";
  public static final String TYPE_SOUS_CONTEXTE_ASS_CPA_EXAMEN_EN_COURS_INSCRIPTION = "CPAINSCRIP";
  public static final String TYPE_CONTEXTE_ARE_MAYOTTE = "AREMAYOTTE";
  public static final String TYPE_CONTEXTE_SOL_ATTENTE_RS = "SOLATTRS";
  public static final String TYPE_CONTEXTE_SOL_SECOURS_RS = "SOLSECOURS";
  public static final String TYPE_CONTEXTE_EXAMEN_IPR = "EXAMENIPR";
  public static final String TYPE_SOUS_CONTEXTE_SIMULATION_CONDITION = "SIMUCAP";
  public static final String TYPE_CONTEXTE_EN_COURS_PMVS = "CRSPMVS";
  public static final String TYPE_CONTEXTE_EN_COURS_PMVS_RECONDUIT = "CRSPMVSREC";
  public static final String TYPE_CONTEXTE_SUITE_PMVS = "SUITEPMVS";
  public static final String TYPE_CONTEXTE_BON_SNCF_SEUL = "SNCFSEUL";
  public static final String TYPE_CONTEXTE_RECHARGEMENT = "RECHARGE";
  public static final String TYPE_CONTEXTE_ARE_SOUS_JACENT_POUR_REVISION = "ARESJREV";
  public static final String TYPE_CONTEXTE_REVISION_AUTOMATIQUE = "REVAUTO";
  public static final String TYPE_CONTEXTE_DV_FIL_EAU = "DVFILEAU";
  public static final String TYPE_CONTEXTE_ACTIV_GEST_RELIQ_IMPUT = "ACTIMPREL";
  public static final String TYPE_CONTEXTE_ARE_ENTREE_CSP_PAP = "AREENTRCSP";
  public static final String TYPE_CONTEXTE_ARE_EN_COURS_CSP_PAP = "ARECOURCSP";
  public static final String TYPE_CONTEXTE_SORTIE_DISPOSITIF_CSP_ARE = "POSTCSPARE";
  public static final String TYPE_CONTEXTE_SORTIE_DISPOSITIF_CSP_DC = "POSTCSPDC";
  public static final String TYPE_CONTEXTE_PREMIERE_DDE_SORTIE_CSP_PAP = "PREPOSTCSP";
  public static final String TYPE_CONTEXTE_SORTIE_DISPOSITIF_PAP_ARE = "POSTPAPARE";
  public static final String TYPE_CONTEXTE_SORTIE_DISPOSITIF_PAP_DC = "POSTPAPDC";
  public static final String TYPE_CONTEXTE_ANTECEDENT_SECTEUR_PUBLIC_AUTOMATIQUE = "ANTSPAUTOM";
  public static final String TYPE_CONTEXTE_DEMANDE_CSP_SUR_AE_REVISEE = "CSPAEREV";
  public static final String TYPE_CONTEXTE_ASP_ARE_SUR_ARE = "ASPARE";
  public static final String TYPE_CONTEXTE_ASP_DC_SUR_ARE = "ASPDC";
  public static final String TYPE_CONTEXTE_PAP_ARE_SUR_ARE = "PAPARE";
  public static final String TYPE_CONTEXTE_PAP_DC_SUR_ARE = "PAPDC";
  public static final String TYPE_CONTEXTE_ASP_SOUS_JACENT = "ASPSJACENT";
  public static final String TYPE_CONTEXTE_PAP_PARLEMENTAIRE = "PAPPARLEM";
  public static final String TYPE_CONTEXTE_RETOUR_CSP_SUITE_PRIME = "ASPPOSTPRI";
  public static final String TYPE_CONTEXTE_ENTREE_CLAUSE_RATTRAPAGE = "ENTREECRA";
  public static final String TYPE_CONTEXTE_EN_COURS_CLAUSE_RATTRAPAGE = "ENCOURSCRA";
  public static final String TYPE_CONTEXTE_SORTIE_CLAUSE_RATTRAPAGE = "SORTIECRA";
  public static final String TYPE_CONTEXTE_EN_COURS_DISPONIBILITE = "COURSDISPO";
  public static final String TYPE_CONTEXTE_SORTIE_DISPONIBILITE = "POSTDISPO";
  public static final String TYPE_CONTEXTE_APS_DROIT_COMMUN = "APSDC";
  public static final String TYPE_CONTEXTE_APS_SUITE_FIN_CRA = "APSPOSTCRA";
  public static final String TYPE_CONTEXTE_AFD_DROIT_COMMUN = "AFDDC";
  public static final String TYPE_CONTEXTE_AFD_SUITE_FIN_CRA = "AFDPOSTCRA";
  
  public abstract String getTypeContexteDemande();
  
  public abstract String getSousTypeContexteDemande();
  
  public abstract Damj getDateDebutJustifContexte();
  
  public abstract Damj getDateFinJustifContexte();
}

/* Location:
 * Qualified Name:     ContexteDemandeSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
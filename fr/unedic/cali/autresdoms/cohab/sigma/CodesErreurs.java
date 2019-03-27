package fr.unedic.cali.autresdoms.cohab.sigma;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.services.CoucheLogiqueException;

public class CodesErreurs
{
  public static final String ERR_GENERIQUE = "PR_COJAC_L_GENERIQUE";
  public static final String ERR_APPLIC_SERVICE_V1 = "PR_COJAC_L_APPLIC_SERVICE_V1";
  public static final String ERR_APPLIC_SERVICE_V1_REENTRANCE = "PR_COJAC_L_APPLIC_SERVICE_V1_REENTRANCE";
  public static final String ERR_CONTEXTE_ABSENCE_TYPE_DEMANDE = "PR_COJAC_L_CONTEXTE_TYPE_DEMANDE";
  public static final String ERR_CONTEXTE_ABSENCE_CXASS = "PR_COJAC_L_CONTEXTE_CXASS";
  public static final String ERR_CONTEXTE_ABSENCE_ALIAS_NCP = "PR_COJAC_L_CONTEXTE_ALIAS_NCP";
  public static final String ERR_CONTEXTE_ABSENCE_CXALA = "PR_COJAC_L_CONTEXTE_CXALA";
  public static final String ERR_CONTEXTE_ABSENCE_CXIN = "PR_COJAC_L_CONTEXTE_CXIN";
  public static final String ERR_CONTEXTE_CONFLIT_ID_DEMANDE = "PR_COJAC_L_CONTEXTE_CONFLIT_ID_DEMANDE";
  public static final String ERR_CONTEXTE_RECH_POSTERIEUR_RNV = "PR_COJAC_L_CONTEXTE_RECH_POSTERIEUR_RNV";
  public static final String ERR_CONTEXTE_ABSENCE_ID_FORMATION = "PR_COJAC_L_CONTEXTE_ID_FORMATION";
  public static final String ERR_CONTEXTE_CONFLIT_EXERCICES = "PR_COJAC_L_CONTEXTE_CONFLIT_EXERCICES";
  public static final String ERR_CONTEXTE_EXERCICE_APRES = "PR_COJAC_L_CONTEXTE_EXERCICE_APRES";
  public static final String ERR_CONTEXTE_CONFLIT_NATURE_CLASSEMENT = "PR_COJAC_L_CONTEXTE_CONFLIT_NATURE_CLASSEMENT";
  public static final String ERR_CONTEXTE_NUMERO_CONVENTION = "PR_COJAC_L_CONTEXTE_NUMERO_DE_CONVENTION";
  public static final String ERR_CONTEXTE_CONFLIT_DATE_RCH_ID_FORMATION = "PR_COJAC_L_CONTEXTE_DATE_RCH_ID_FORMATION";
  public static final String ERR_CONTEXTE_ABSENCE_ID_DEMANDE = "PR_COJAC_L_CONTEXTE_ID_DEMANDE";
  public static final String ERR_CONTEXTE_ABSENCE_TYPE_SEGMENT = "PR_COJAC_L_CONTEXTE_TYPE_SEGMENT";
  public static final String ERR_CONTEXTE_BRANCHEMENT_IMPOSSIBLE_PI = "PR_COJAC_L_CONTEXTE_BRANCHEMENT_IMPOSSIBLE_PI";
  public static final String ERR_CONTEXTE_AUCUN_IDENTIFIANT = "PR_COJAC_L_AUCUN_IDENTIFIANT";
  public static final String ERR_CONTEXTE_CXASS_CXIN_INDISOCIABLES = "PR_COJAC_L_CXASS_CXIN_INDISOCIABLES";
  public static final String ERR_CONTEXTE_CXALA_CXALAK_ENSEMBLE = "PR_COJAC_L_CXALA_CXALAK_ENSEMBLE";
  public static final String ERR_SA98LD_ABSENCE_OCCURENCE = "PR_COJAC_L_SA98LD_ABSENCE_OCCURENCE";
  public static final String ERR_SA98LD_ABSENCE_PEC = "PR_COJAC_L_SA98LD_ABSENCE_PEC";
  public static final String ERR_SA98LD_FORMAT_PEC = "PR_COJAC_L_SA98LD_FORMAT_PEC";
  public static final String ERR_SA98LD_ABSENCE_DATE_PREINSCRIPTION = "PR_COJAC_L_SA98LD_ABSENCE_DATE_PREINSCRIPTION";
  public static final String LIB_GENERIQUE = "Erreur lors de l'accès à l'OF Cojac";
  public static final String LIB_APPLIC_SERVICE_V1 = "Erreur lors du traitement du service V1";
  public static final String LIB_APPLIC_SERVICE_V1_REENTRANCE = "Nombre maximum d'appel en réentrance atteint";
  public static final String LIB_CONTEXTE_ABSENCE_TYPE_DEMANDE = "Contexte incomplet : Absence du Type de la Demande";
  public static final String LIB_CONTEXTE_ABSENCE_CXALA = "Contexte incomplet : Absence du Numéro Allocataire";
  public static final String LIB_CONTEXTE_ABSENCE_CXIN = "Contexte incomplet : Absence de l'identifiant SIGMA";
  public static final String LIB_CONTEXTE_ABSENCE_ALIAS_NCP = "Contexte incomplet : Absence de l'Alias NCP";
  public static final String LIB_CONTEXTE_ABSENCE_CXASS = "Contexte incomplet : Absence du Code Assedic";
  public static final String LIB_CONTEXTE_CONFLIT_ID_DEMANDE = "Contexte en erreur : Identifiant Demande et Identifiant Recherche ne peuvent pas être saisis simultanément";
  public static final String LIB_CONTEXTE_RECH_POSTERIEUR_RNV = "Contexte en erreur : Recherche des demandes postérieures autorisés seulement pour les DALs";
  public static final String LIB_CONTEXTE_ABSENCE_ID_FORMATION = "Contexte incomplet : Absence de l'identifiant de Formation";
  public static final String LIB_CONTEXTE_CONFLIT_EXERCICES = "Contexte en erreur : l'exercice après doit être supérieur à l'exercice avant";
  public static final String LIB_CONTEXTE_EXERCICE_APRES = "Contexte en erreur : Exercie après manquant ou < 1900";
  public static final String LIB_CONTEXTE_CONFLIT_NATURE_CLASSEMENT = "Contexte en erreur : Nature de decision de liquidation et Classement administratif ne peuvent pas être renseignés simultanément.";
  public static final String LIB_CONTEXTE_NUMERO_CONVENTION = "Contexte en erreur : Numéro de convention non conforme";
  public static final String LIB_CONTEXTE_CONFLIT_DATE_RCH_ID_FORMATION = "Contexte en erreur : Date de Recherche et Identifiant de Formation ne peuvent pas être renseignés simultanément";
  public static final String LIB_CONTEXTE_ABSENCE_ID_DEMANDE = "Contexte incomplet : Absence de l'identifiant de demande";
  public static final String LIB_CONTEXTE_ABSENCE_TYPE_SEGMENT = "Contexte incomplet : Absence du type de segment";
  public static final String LIB_CONTEXTE_BRANCHEMENT_IMPOSSIBLE_PI = "Contexte en erreur : Impossible de brancher une pension d'invalidité révisée";
  public static final String LIB_CONTEXTE_AUCUN_IDENTIFIANT = "Aucun identifiant n'est mentionné";
  public static final String LIB_CONTEXTE_CXASS_CXIN_INDISOCIABLES = "Le code Assedic et l'identifiant Sigma doivent être renseignés simultanément ou pas du tout";
  public static final String LIB_CONTEXTE_CXALA_CXALAK_ENSEMBLE = "Les identifiants BNI et NCP ne peuvent être renseignés simultanément";
  public static final String LIB_SA98LD_ABSENCE_OCCURENCE = "Le code de l’occurrence retour du SA98 est null";
  public static final String LIB_SA98LD_ABSENCE_PEC = "Impossible de déterminer les informations relatives à la PEC. CSPEC de l’occurrence est null ";
  public static final String LIB_SA98LD_FORMAT_PEC = "Impossible de déterminer les informations relatives à la PEC. CSPEC n’est pas formaté correctement";
  public static final String LIB_SA98LD_ABSENCE_DATE_PREINSCRIPTION = "Impossible de déterminer la date de préinscirption. DSINS null";
  
  public static CoucheLogiqueException getErreurServiceV1(ApplicativeException p_errV1, String p_serviceV1, String p_infos)
  {
    try
    {
      String libelle = null;
      
      String libelleErrV1 = null;
      if (p_errV1.getLibelle() != null) {
        libelleErrV1 = p_errV1.getLibelle().trim();
      }
      if ((libelleErrV1 != null) && (libelleErrV1.startsWith("AB:")))
      {
        int pos = libelleErrV1.indexOf(' ');
        if (pos > 0) {
          libelleErrV1 = libelleErrV1.substring(0, pos);
        }
      }
      libelle = "Erreur lors du traitement du service V1";
      if (p_serviceV1 != null) {
        libelle = libelle + " " + p_serviceV1;
      }
      libelle = libelle + " (" + p_errV1.getCode();
      if (libelleErrV1 != null) {
        libelle = libelle + " " + libelleErrV1;
      }
      if (p_infos != null) {
        libelle = libelle + " - " + p_infos;
      }
      libelle = libelle + ")";
      
      return new CoucheLogiqueException("PR_COJAC_L_APPLIC_SERVICE_V1", libelle, p_errV1);
    }
    catch (Exception e) {}
    return new CoucheLogiqueException("PR_COJAC_L_APPLIC_SERVICE_V1", "Erreur lors du traitement du service V1 " + p_serviceV1, p_errV1);
  }
  
  public static CoucheLogiqueException getErreurServiceV1(ApplicativeException p_errV1, String p_serviceV1)
  {
    return getErreurServiceV1(p_errV1, p_serviceV1, null);
  }
}

/* Location:
 * Qualified Name:     CodesErreurs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
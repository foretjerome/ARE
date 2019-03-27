package fr.unedic.cali.autresdoms.d90.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec;
import fr.unedic.cali.dom.ComparateurDecisionSpec;
import fr.unedic.cali.dom.NaturesDecisions;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;

public class OutilVisualisation
{
  private static final int CODE_PAR_DEFAUT = -1;
  public static final String CODE_MODE_DEGRADE = "D";
  public static final String CODE_MODE_NORMAL = "N";
  public static final String CODE_MODE_LISTE = "L";
  public static final String CODE_MODE_OCCASIONNAL_GAEC = "G";
  public static final String CODE_MODE_LOURD = "O";
  public static final String CODE_MODE_LOURD_SANS_TRACKER = "S";
  public static final String CODE_MODE_NORMAL_SANS_TRACKER = "T";
  public static final String LIBELE_MODE_DEGRADE = "Simulation";
  public static final String LIBELE_MODE_NORMAL = "Mise à jour";
  public static final String LIBELE_MODE_LISTE = "Liste";
  public static final String LIBELE_MODE_OCCASIONNAL_GAEC = "Occasionnel GAEC";
  public static final String LIBELE_MODE_LOURD = "Lourd";
  public static final String LIBELE_MODE_LOURD_SANS_TRACKER = "Lourd sans tracker";
  public static final String LIBELE_MODE_NORMAL_SANS_TRACKER = "Normal sans tracker";
  public static final String LIBELE_INDETERMINE = "Indéterminé";
  public static final String LIBELLE_ETAT_REEXAMEN_MIS_EN_REEXAMEN = "Mis en réexamen";
  public static final String LIBELLE_ETAT_REEXAMEN_RECONDUIT_AVEC_ECART = "Reconduit avec écart";
  public static final String LIBELLE_ETAT_REEXAMEN_RECONDUIT_SANS_ECART = "Reconduit sans écart";
  public static final String LIBELLE_ETAT_REEXAMEN_SANS_OBJET = "Sans objet";
  public static final String LIBELLE_RECONDUCTION_DECISION_MIGREES = "Reconduction des décisions migrées";
  public static final String LIBELLE_REEXAMINER_DECISION_MIGREES = "Réexamen des décisions migrées";
  public static final String LIBELLE_REMISE_EN_CAUSE_DECISION_MIGREES = "Remise en cause des décisions migrées";
  public static final String LIBELLE_MANDATEMENT_AUTO = "Auto";
  public static final String LIBELLE_MANDATEMENT_MANUEL = "Manuel";
  public static final String LIBELLE_CREATION_REEXECUTION = "Réexecution";
  public static final String LIBELLE_CREATION_SELECTION = "Séléction";
  public static final String LIBELLE_HORS_GAMME = "Hors Gamme";
  public static final String LIBELLE_GAMME_ASU = "ASU";
  public static final String LIBELLE_GAMME_SOL = "SOL";
  public static final String LIBELLE_GAMME_RBF = "RBF";
  public static final String LIBELLE_GAMME_FOR = "FOR";
  public static final String LIBELLE_GAMME_ASU_PROD_MNT = "ASU_PROD_MNT";
  public static final String LIBELLE_GAMME_INR = "INR";
  public static final String CODE_DELTA_MT_TRANCHE_INF_NEG_500 = "1";
  public static final String CODE_DELTA_MT_TRANCHE_ENTRE_NEG_500_ET_NEG_100 = "2";
  public static final String CODE_DELTA_MT_TRANCHE_ENTRE_NEG_100_ET_NEG_50 = "3";
  public static final String CODE_DELTA_MT_TRANCHE_ENTRE_NEG_50_ET_0 = "4";
  public static final String CODE_DELTA_MT_TRANCHE_ENTRE_0_ET_50 = "5";
  public static final String CODE_DELTA_MT_TRANCHE_ENTRE_50_ET_100 = "6";
  public static final String CODE_DELTA_MT_TRANCHE_ENTRE_100_ET_500 = "7";
  public static final String CODE_DELTA_MT_TRANCHE_SUP_500 = "8";
  public static final BigDecimal CONSTANTE_DELTA_MT_TRANCHE_NEG_500 = new BigDecimal("-500");
  public static final BigDecimal CONSTANTE_DELTA_MT_TRANCHE_NEG_100 = new BigDecimal("-100");
  public static final BigDecimal CONSTANTE_DELTA_MT_TRANCHE_NEG_50 = new BigDecimal("-50");
  public static final BigDecimal CONSTANTE_DELTA_MT_TRANCHE_0 = new BigDecimal("0");
  public static final BigDecimal CONSTANTE_DELTA_MT_TRANCHE_50 = new BigDecimal("50");
  public static final BigDecimal CONSTANTE_DELTA_MT_TRANCHE_100 = new BigDecimal("100");
  public static final BigDecimal CONSTANTE_DELTA_MT_TRANCHE_500 = new BigDecimal("500");
  
  public static int getCodeElementDroitAExclure(String p_libelleElement)
  {
    if (p_libelleElement != null) {
      return p_libelleElement.hashCode();
    }
    return -1;
  }
  
  public static String getLibelleElement(int p_codeElement)
  {
    if (p_codeElement != -1) {
      try
      {
        Field[] listeAttributs = Class.forName(ComparateurDecisionSpec.class.getName()).getDeclaredFields();
        int taille = listeAttributs.length;
        for (int i = 0; i < taille; i++)
        {
          Field attribut = listeAttributs[i];
          String valeurChamp = attribut.get(ComparateurDecisionSpec.class).toString();
          if (valeurChamp.hashCode() == p_codeElement) {
            return valeurChamp;
          }
        }
        return null;
      }
      catch (Exception ex)
      {
        return null;
      }
    }
    return null;
  }
  
  public static int getCodeGamme(String p_libelleGamme)
  {
    return Parametres.getCodeGamme(p_libelleGamme);
  }
  
  public static String getCodeModeOccasionnel(String p_modeOccasionnel)
  {
    if ((StringUtils.equalsIgnoreCase(p_modeOccasionnel, "Degrade")) || (StringUtils.equalsIgnoreCase(p_modeOccasionnel, "SansTracker")) || (StringUtils.equalsIgnoreCase(p_modeOccasionnel, "SimuSansTracker"))) {
      return "D";
    }
    if (StringUtils.equalsIgnoreCase(p_modeOccasionnel, "List")) {
      return "L";
    }
    if ((StringUtils.equalsIgnoreCase(p_modeOccasionnel, "Normal")) || (StringUtils.equalsIgnoreCase(p_modeOccasionnel, "NormalAvecTracker"))) {
      return "N";
    }
    if (StringUtils.equalsIgnoreCase(p_modeOccasionnel, "NormalSansTracker")) {
      return "T";
    }
    if (StringUtils.equalsIgnoreCase(p_modeOccasionnel, "GAEC")) {
      return "G";
    }
    if (StringUtils.equalsIgnoreCase(p_modeOccasionnel, "Lourd")) {
      return "O";
    }
    if (StringUtils.equalsIgnoreCase(p_modeOccasionnel, "LourdSansTracker")) {
      return "S";
    }
    return "";
  }
  
  public static String getLibelleModeOccasionnel(String p_codeModeOccasionnel)
  {
    if (StringUtils.equalsIgnoreCase(p_codeModeOccasionnel, "D")) {
      return "Simulation";
    }
    if (StringUtils.equalsIgnoreCase(p_codeModeOccasionnel, "L")) {
      return "Liste";
    }
    if (StringUtils.equalsIgnoreCase(p_codeModeOccasionnel, "N")) {
      return "Mise à jour";
    }
    if (StringUtils.equalsIgnoreCase(p_codeModeOccasionnel, "O")) {
      return "Lourd";
    }
    if (StringUtils.equalsIgnoreCase(p_codeModeOccasionnel, "T")) {
      return "Normal sans tracker";
    }
    if (StringUtils.equalsIgnoreCase(p_codeModeOccasionnel, "G")) {
      return "Occasionnel GAEC";
    }
    if (StringUtils.equalsIgnoreCase(p_codeModeOccasionnel, "S")) {
      return "Lourd sans tracker";
    }
    return "Indéterminé";
  }
  
  public static String getLibelleEtatReexamen(String p_codeEtatReexam)
  {
    if (StringUtils.equalsIgnoreCase(p_codeEtatReexam, "R")) {
      return "Mis en réexamen";
    }
    if (StringUtils.equalsIgnoreCase(p_codeEtatReexam, "E")) {
      return "Reconduit avec écart";
    }
    if (StringUtils.equalsIgnoreCase(p_codeEtatReexam, "V")) {
      return "Reconduit sans écart";
    }
    if (StringUtils.equalsIgnoreCase(p_codeEtatReexam, "O")) {
      return "Sans objet";
    }
    return "";
  }
  
  public static String getLibelleCourtProduit(int p_codeProduit)
  {
    String libelleCourt = "";
    
    ProduitSpec produit = Parametres.getProduit(p_codeProduit);
    if (produit != null) {
      libelleCourt = produit.getLibelleCourt();
    }
    return libelleCourt;
  }
  
  public static final String getLibelleReexamenDecMig(String p_codeReexamenDecMig)
  {
    if (p_codeReexamenDecMig.equalsIgnoreCase("D")) {
      return "Reconduction des décisions migrées";
    }
    if (p_codeReexamenDecMig.equalsIgnoreCase("R")) {
      return "Réexamen des décisions migrées";
    }
    if (p_codeReexamenDecMig.equalsIgnoreCase("C")) {
      return "Remise en cause des décisions migrées";
    }
    return "";
  }
  
  public static final String getLibelleTypeMandatement(String p_codeTypeMandatement)
  {
    if (p_codeTypeMandatement.equalsIgnoreCase("1")) {
      return "Auto";
    }
    if (p_codeTypeMandatement.equalsIgnoreCase("2")) {
      return "Manuel";
    }
    return "";
  }
  
  public static final String getLibelleModeCreation(String p_codeModeCreation)
  {
    if (p_codeModeCreation.equalsIgnoreCase("R")) {
      return "Réexecution";
    }
    if (p_codeModeCreation.equalsIgnoreCase("S")) {
      return "Séléction";
    }
    return "";
  }
  
  public static final String getLibelleTypeDemande(String p_codeTypeDemande)
  {
    try
    {
      Field[] listeAttributs = Class.forName(DemandeSpec.class.getName()).getDeclaredFields();
      int taille = listeAttributs.length;
      for (int i = 0; i < taille; i++)
      {
        Field attribut = listeAttributs[i];
        String valeurChamp = attribut.get(DemandeSpec.class).toString();
        if (valeurChamp.equals(p_codeTypeDemande)) {
          return attribut.getName();
        }
      }
      return null;
    }
    catch (Exception ex) {}
    return null;
  }
  
  public static final String getLibelleTypeDecision(int p_codeTypeDecis)
  {
    Object libelle = NaturesDecisions.s_libelleObjectifDecision.get(new BigDecimal(p_codeTypeDecis));
    if (libelle == null) {
      return "";
    }
    return (String)libelle;
  }
  
  public static final String getTrancheDeltaMontant(BigDecimal p_deltaMontant)
  {
    String codeRetour = "";
    if (p_deltaMontant != null) {
      if (p_deltaMontant.compareTo(CONSTANTE_DELTA_MT_TRANCHE_NEG_500) < 0) {
        codeRetour = "1";
      } else if (p_deltaMontant.compareTo(CONSTANTE_DELTA_MT_TRANCHE_NEG_100) < 0) {
        codeRetour = "2";
      } else if (p_deltaMontant.compareTo(CONSTANTE_DELTA_MT_TRANCHE_NEG_50) < 0) {
        codeRetour = "3";
      } else if (p_deltaMontant.compareTo(CONSTANTE_DELTA_MT_TRANCHE_0) < 0) {
        codeRetour = "4";
      } else if (p_deltaMontant.compareTo(CONSTANTE_DELTA_MT_TRANCHE_0) > 0) {
        codeRetour = "5";
      } else if (p_deltaMontant.compareTo(CONSTANTE_DELTA_MT_TRANCHE_50) > 0) {
        codeRetour = "6";
      } else if (p_deltaMontant.compareTo(CONSTANTE_DELTA_MT_TRANCHE_100) > 0) {
        codeRetour = "7";
      } else if (p_deltaMontant.compareTo(CONSTANTE_DELTA_MT_TRANCHE_500) > 0) {
        codeRetour = "8";
      }
    }
    return codeRetour;
  }
}

/* Location:
 * Qualified Name:     OutilVisualisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
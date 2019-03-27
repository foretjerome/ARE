package fr.unedic.cali.occasionnel;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.util.persistance.dao.ConnexionDB;
import fr.unedic.util.services.Indicateur;
import fr.unedic.util.services.ResultatService;
import fr.unedic.util.services.batch.ContexteOccasionnel;
import fr.unedic.util.services.batch.TBOccasionnelAbstrait;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Hashtable;

public class TBCategorieEmploi
  extends TBOccasionnelAbstrait
{
  private static final int POSITION_1 = 1;
  private static final int POSITION_2 = 2;
  private static final int POSITION_3 = 3;
  private static final int POSITION_4 = 4;
  private static final int POSITION_5 = 5;
  private static final int POSITION_6 = 6;
  private static final int POSITION_7 = 7;
  private static final int POSITION_8 = 8;
  public static final int TAILLE_ID_LIDO = 17;
  private static final String NOM_COLONNE_ASSEDIC = "CXASS";
  private static final String NOM_COLONNE_CXALA = "CXALAF";
  private static final String NOM_TABLE_CALI_INDIVIDUS = "P1200A_INDIVIDU";
  private static final String REQ_LECTURE_TABLE_LIQUIDATION = "SELECT %ID, %ID_PERIODE_GAEC FROM %TABLE_LIQUIDATION WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND %CATEGORIE_EMPLOI IS NULL";
  private static final String REQ_LECTURE_TABLE_GAEC_METIER = "SELECT %CATEGORIE_EMPLOI FROM %TABLE_GAEC_METIER WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND %ID_PERIODE_GAEC=?";
  private static final String REQ_LECTURE_TABLE_GAEC_PERIODE_ACTIVITE = "SELECT %POPULATION_HORS_FRANCE FROM %TABLE_GAEC_PERIODE_ACTIVITE WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND %ID_PERIODE_GAEC=?";
  private static final String REQ_MAJ_TABLE_LIQUIDATION = "UPDATE %TABLE_LIQUIDATION SET %CATEGORIE_EMPLOI=?, %POPULATION_HORS_FRANCE=? WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND %ID=?";
  private static final String NOM_TABLE_LIQUIDATION = "P1210K_01VLPDT";
  private static final String NOM_COLONNE_ID_TABLE_LIQUIDATION = "VAL_PDT_ID";
  private static final String NOM_COLONNE_ID_PERIODE_GAEC_TABLE_LIQUIDATION = "ID_PERIODE_VAL_PDT";
  private static final String NOM_COLONNE_CATEGORIE_EMPLOI_TABLE_LIQUIDATION = "CATEMPL";
  private static final String NOM_COLONNE_POPULATION_HORS_FRANCE_TABLE_LIQUIDATION = "POHF";
  private static final String NOM_TABLE_GAEC_METIER = "P1111A_METIER";
  private static final String NOM_COLONNE_ID_PERIODE_TABLE_GAEC_METIER = "FK_PER_ACTIVITE_ID";
  private static final String NOM_COLONNE_CATEGORIE_EMPLOI_TABLE_GAEC_METIER = "CAT_EMPLOI_PART";
  private static final String NOM_TABLE_GAEC_PERIODE_ACTIVITE = "P1110C_PERIODE_ACT";
  private static final String NOM_COLONNE_ID_PERIODE_TABLE_GAEC_PERIODE_ACTIVITE = "PER_ACTIVITE_ID";
  private static final String NOM_COLONNE_POPULATION_HORS_FRANCE_TABLE_GAEC_PERIODE_ACTIVITE = "ACT_HORS_FRANCE";
  private static final String REQ_REDRESSEMENT_P1200A_INDIVIDU = "UPDATE P1200A_INDIVIDU SET CODE_TRANSFERT='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CODE_TRANSFERT IS NULL";
  private static final String REQ_REDRESSEMENT_P1210D_01DNFOR = "UPDATE P1210D_01DNFOR SET CD_ACTCONS_REMPLIE=0, SJR_SP_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CD_ACTCONS_REMPLIE IS NULL AND SJR_SP_E IS NULL";
  private static final String REQ_REDRESSEMENT_P1210A_01DEMANDE = "UPDATE P1210A_01DEMANDE SET EST_NEUTRAL_LIQ=0, EST_NEUTRAL_CAL=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND EST_NEUTRAL_LIQ IS NULL AND EST_NEUTRAL_CAL IS NULL";
  private static final String REQ_REDRESSEMENT_P1220A_02DEMANDE = "UPDATE P1220A_02DEMANDE SET EST_NEUTRAL_LIQ=0, EST_NEUTRAL_CAL=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND EST_NEUTRAL_LIQ IS NULL AND EST_NEUTRAL_CAL IS NULL";
  private static final String REQ_REDRESSEMENT_P1260A_06DEMANDE = "UPDATE P1260A_06DEMANDE SET EST_NEUTRAL_LIQ=0, EST_NEUTRAL_CAL=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND EST_NEUTRAL_LIQ IS NULL AND EST_NEUTRAL_CAL IS NULL";
  private static final String REQ_REDRESSEMENT_P1280A_08DEMANDE = "UPDATE P1280A_08DEMANDE SET EST_NEUTRAL_LIQ=0, EST_NEUTRAL_CAL=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND EST_NEUTRAL_LIQ IS NULL AND EST_NEUTRAL_CAL IS NULL";
  private static final String REQ_REDRESSEMENT_P1212O_010102CPADM = "UPDATE P1212O_010102CPADM SET DUR_ACT_S_PV_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND DUR_ACT_S_PV_CACAE IS NULL";
  private static final String REQ_REDRESSEMENT_P1217O_010103CPADM = "UPDATE P1217O_010103CPADM SET DUR_ACT_S_PV_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND DUR_ACT_S_PV_CACAE IS NULL";
  private static final String REQ_REDRESSEMENT_P1211Z_010102DOSEX_REG_FIN_PART_CACAE = "UPDATE P1211Z_010102DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL";
  private static final String REQ_REDRESSEMENT_P1216Z_010103DOSEX_REG_FIN_PART_CACAE = "UPDATE P1216Z_010103DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL";
  private static final String REQ_REDRESSEMENT_P1261A_060101DOSEX = "UPDATE P1261A_060101DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL";
  private static final String REQ_REDRESSEMENT_P1262A_060201DOSEX = "UPDATE P1262A_060201DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL";
  private static final String REQ_REDRESSEMENT_P1263A_060301DOSEX = "UPDATE P1263A_060301DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL";
  private static final String REQ_REDRESSEMENT_P1264A_060401DOSEX = "UPDATE P1264A_060401DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL";
  private static final String REQ_REDRESSEMENT_P1281A_080301DOSEX = "UPDATE P1281A_080301DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL";
  private static final String REQ_REDRESSEMENT_P1212K_010102PRC = "UPDATE P1212K_010102PRC SET CONTRATS_TYPE_PART=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CONTRATS_TYPE_PART IS NULL";
  private static final String REQ_REDRESSEMENT_P1217K_010103PRC = "UPDATE P1217K_010103PRC SET CONTRATS_TYPE_PART=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CONTRATS_TYPE_PART IS NULL";
  private static final String REQ_REDRESSEMENT_P1211Z_010102DOSEX_TOP_RENONCEMENT = "UPDATE P1211Z_010102DOSEX SET TOP_RENONCEMENT=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND TOP_RENONCEMENT IS NULL";
  private static final String REQ_REDRESSEMENT_P1216Z_010103DOSEX_TOP_RENONCEMENT = "UPDATE P1216Z_010103DOSEX SET TOP_RENONCEMENT=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND TOP_RENONCEMENT IS NULL";
  private static final String REQ_REDRESSEMENT_P1212R_010102CTCOS = "UPDATE P1212R_010102CTCOS SET NBJ_ACT_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND NBJ_ACT_E IS NULL";
  private static final String REQ_REDRESSEMENT_P1214R_010201CTCOS = "UPDATE P1214R_010201CTCOS SET NBJ_ACT_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND NBJ_ACT_E IS NULL";
  private static final String REQ_REDRESSEMENT_P1217R_010103CTCOS = "UPDATE P1217R_010103CTCOS SET NBJ_ACT_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND NBJ_ACT_E IS NULL";
  private static final String REQ_REDRESSEMENT_P1212L_010102CTPR = "UPDATE P1212L_010102CTPR SET CAP_PREC_E='0', DUR_PREC_E='0', MNT_PREC_E='0', SJRRP_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CAP_PREC_E IS NULL AND DUR_PREC_E IS NULL AND MNT_PREC_E IS NULL AND SJRRP_E IS NULL";
  private static final String REQ_REDRESSEMENT_P1217L_010103CTPR = "UPDATE P1217L_010103CTPR SET MONTANT_RETENU=1, CAPITAL_RETENU=1, CAP_PREC_E='0', DUR_PREC_E='0', MNT_PREC_E='0', SJRRP_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND MONTANT_RETENU IS NULL AND CAPITAL_RETENU IS NULL AND CAP_PREC_E IS NULL AND DUR_PREC_E IS NULL AND MNT_PREC_E IS NULL AND SJRRP_E IS NULL";
  private static final String NOM_TABLE_LIQUIDATION_RBF_1 = "P1261A_060101DOSEX";
  private static final String NOM_TABLE_LIQUIDATION_RBF_2 = "P1262A_060201DOSEX";
  private static final String NOM_TABLE_LIQUIDATION_RBF_3 = "P1263A_060301DOSEX";
  private static final String NOM_TABLE_LIQUIDATION_RBF_4 = "P1264A_060401DOSEX";
  private static final String REQ_REDRESSEMENT_RBF_LECTURE = "SELECT c.DOSS_EXAMEN_ID, a.ANNEE_AFFECTATION FROM P1260A_06DEMANDE a, P1260B_06DOSAF b, %TABLE_LIQUIDATION_RBF c WHERE c.%ASSEDIC=? AND c.%ID_INDIVIDU=? AND c.ANNEE_AFFECTATION IS NULL AND c.DOSS_AFFECT_ID = b.DOSS_AFFECT_ID AND b.FK_DDE_RBF_ID = a.DDE_RBF_ID";
  private static final String REQ_REDRESSEMENT_RBF_MAJ = "UPDATE %TABLE_LIQUIDATION_RBF SET ANNEE_AFFECTATION=? WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND DOSS_EXAMEN_ID=?";
  private static final String REQ_REDRESSEMENT_SIGNE_PLUS_P1210B_01DOSSAFF = "UPDATE P1210B_01DOSSAFF SET JUSTIFICATION=translate(JUSTIFICATION,'0',' ') WHERE %ASSEDIC=? AND %ID_INDIVIDU=?";
  private static final String REQ_REDRESSEMENT_SIGNE_PLUS_P1210D_01DNFOR = "UPDATE P1210D_01DNFOR SET CAT_INVALIDITE=translate(CAT_INVALIDITE,'0',' ') WHERE %ASSEDIC=? AND %ID_INDIVIDU=?";
  private static final String REQ_REDRESSEMENT_SIGNE_PLUS_P1210M_01REPRACTIV = "UPDATE P1210M_01REPRACTIV SET INDEX=translate(INDEX,'0',' ') WHERE %ASSEDIC=? AND %ID_INDIVIDU=?";
  private static final String REQ_REDRESSEMENT_P1200S_UTFORCEE = "UPDATE P1200S_UTFORCEE SET COM_PARITAIRE='0', IS_COM_PARITAIRE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND COM_PARITAIRE IS NULL AND IS_COM_PARITAIRE IS NULL";
  private static final String REQ_REDRESSEMENT_P1200Z_PBJCNCP = "UPDATE P1200Z_PBJCNCP SET FSPLFN=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND FSPLFN IS NULL";
  private static final String REQ_REDRESSEMENT_QTE_DROIT_P1200T_LCIQT = "DELETE FROM P1200T_LCIQT WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND QT_ID NOT IN ((SELECT QTDRT_ID FROM P1212V_010102DUIND WHERE %ASSEDIC=? AND %ID_INDIVIDU=?) UNION (SELECT QTDRT_ID FROM P1212W_010102DUREN WHERE %ASSEDIC=? AND %ID_INDIVIDU=?) UNION (SELECT QTDRT_ID FROM P1217V_010103DUIND WHERE %ASSEDIC=? AND %ID_INDIVIDU=?))";
  private static final String NOM_INDICATEUR_COMPTEUR_CXALA = "D12_90AO1_COMPTEUR_CXALA_REDRESSES";
  
  public TBCategorieEmploi()
  {
    super("P1200A_INDIVIDU");
  }
  
  protected String getNomColonne(int p_colonne)
  {
    String nomColonne = "";
    switch (p_colonne)
    {
    case 1: 
      nomColonne = "CXASS";
      break;
    case 2: 
    case 3: 
      nomColonne = "CXALAF";
      break;
    }
    return nomColonne;
  }
  
  protected ResultatService traiterEnregistrement(ContexteOccasionnel p_contexte, String p_cxala)
    throws TechniqueException
  {
    ResultatService resultatServiceRetourne = new ResultatService();
    resultatServiceRetourne.setEtat(1);
    
    Hashtable hashtableIdentifiants = recupererIdentifiants(p_contexte, p_cxala);
    
    String idEnregistrement = null;
    String idPeriodeValidationProduitCourant = null;
    String idPeriodeGaec = null;
    String valeurCategorieEmploiParticulier = null;
    String valeurPopulationHorsFrance = null;
    for (Enumeration enumeration = hashtableIdentifiants.keys(); enumeration.hasMoreElements();)
    {
      idEnregistrement = (String)enumeration.nextElement();
      idPeriodeValidationProduitCourant = (String)hashtableIdentifiants.get(idEnregistrement);
      if (idPeriodeValidationProduitCourant != null)
      {
        idPeriodeGaec = formaterIdentifiantPeriodeGaec(idPeriodeValidationProduitCourant, 17);
        
        valeurCategorieEmploiParticulier = recupererCategorieEmploiGaec(p_contexte, p_cxala, idPeriodeGaec);
        if (valeurCategorieEmploiParticulier != null) {
          valeurCategorieEmploiParticulier = valeurCategorieEmploiParticulier.substring(1);
        }
        valeurPopulationHorsFrance = recupererPopulationHorsFrance(p_contexte, p_cxala, idPeriodeGaec);
        if ((valeurCategorieEmploiParticulier != null) && (valeurPopulationHorsFrance != null))
        {
          if (Log.isTraceActive(TBCategorieEmploi.class, Niveau.INFO)) {
            Log.ecritTrace(Niveau.INFO, TBCategorieEmploi.class, "traiterEnregistrement", "CXALA: " + p_cxala + " - Redressement catégorie emploi particulier...");
          }
          mettreAJourTableLiquidation(p_contexte, p_cxala, idEnregistrement, valeurCategorieEmploiParticulier, valeurPopulationHorsFrance);
        }
      }
    }
    redresserDonneesCali(p_contexte, p_cxala);
    
    Indicateur indicateurCourant = new Indicateur("D12_90AO1_COMPTEUR_CXALA_REDRESSES", 1);
    resultatServiceRetourne.ajouterIndicateur(indicateurCourant);
    
    resultatServiceRetourne.setEtat(0);
    
    return resultatServiceRetourne;
  }
  
  private Hashtable recupererIdentifiants(ContexteOccasionnel p_contexte, String p_cxala)
    throws TechniqueException
  {
    Hashtable hashtableIdentifiants = new Hashtable();
    
    String requete = "SELECT %ID, %ID_PERIODE_GAEC FROM %TABLE_LIQUIDATION WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND %CATEGORIE_EMPLOI IS NULL";
    requete = requete.replaceFirst("%TABLE_LIQUIDATION", "P1210K_01VLPDT");
    requete = requete.replaceFirst("%ASSEDIC", "CXASS");
    requete = requete.replaceFirst("%ID_INDIVIDU", "CXALAF");
    requete = requete.replaceFirst("%ID", "VAL_PDT_ID");
    requete = requete.replaceFirst("%ID_PERIODE_GAEC", "ID_PERIODE_VAL_PDT");
    requete = requete.replaceFirst("%CATEGORIE_EMPLOI", "CATEMPL");
    
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      pstmt.setString(1, p_contexte.getCodeAssedic());
      pstmt.setString(2, p_cxala);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        hashtableIdentifiants.put(rs.getString(1), rs.getString(2));
      }
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(rs, pstmt, connection);
    }
    return hashtableIdentifiants;
  }
  
  private String formaterIdentifiantPeriodeGaec(String p_chaineACompleter, int p_tailleTotale)
  {
    StringBuffer sb = new StringBuffer();
    if (p_chaineACompleter.indexOf("-") != -1) {
      sb.append(p_chaineACompleter.substring(0, p_chaineACompleter.indexOf("-")));
    } else {
      sb.append(p_chaineACompleter.trim());
    }
    while (sb.length() < p_tailleTotale) {
      sb.insert(0, "0");
    }
    return sb.toString();
  }
  
  private String recupererCategorieEmploiGaec(ContexteOccasionnel p_contexte, String p_cxala, String p_idPeriodeGaec)
    throws TechniqueException
  {
    String categorieEmploiParticuliere = null;
    
    String requete = "SELECT %CATEGORIE_EMPLOI FROM %TABLE_GAEC_METIER WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND %ID_PERIODE_GAEC=?";
    requete = requete.replaceFirst("%TABLE_GAEC_METIER", "P1111A_METIER");
    requete = requete.replaceFirst("%CATEGORIE_EMPLOI", "CAT_EMPLOI_PART");
    requete = requete.replaceFirst("%ASSEDIC", "CXASS");
    requete = requete.replaceFirst("%ID_INDIVIDU", "CXALAF");
    requete = requete.replaceFirst("%ID_PERIODE_GAEC", "FK_PER_ACTIVITE_ID");
    
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      pstmt.setString(1, p_contexte.getCodeAssedic());
      pstmt.setString(2, p_cxala);
      pstmt.setString(3, p_idPeriodeGaec);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        categorieEmploiParticuliere = rs.getString(1);
      }
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(rs, pstmt, connection);
    }
    return categorieEmploiParticuliere;
  }
  
  private String recupererPopulationHorsFrance(ContexteOccasionnel p_contexte, String p_cxala, String p_idPeriodeGaec)
    throws TechniqueException
  {
    String populationHorsFrance = null;
    
    String requete = "SELECT %POPULATION_HORS_FRANCE FROM %TABLE_GAEC_PERIODE_ACTIVITE WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND %ID_PERIODE_GAEC=?";
    requete = requete.replaceFirst("%TABLE_GAEC_PERIODE_ACTIVITE", "P1110C_PERIODE_ACT");
    requete = requete.replaceFirst("%POPULATION_HORS_FRANCE", "ACT_HORS_FRANCE");
    requete = requete.replaceFirst("%ASSEDIC", "CXASS");
    requete = requete.replaceFirst("%ID_INDIVIDU", "CXALAF");
    requete = requete.replaceFirst("%ID_PERIODE_GAEC", "PER_ACTIVITE_ID");
    
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      pstmt.setString(1, p_contexte.getCodeAssedic());
      pstmt.setString(2, p_cxala);
      pstmt.setString(3, p_idPeriodeGaec);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        populationHorsFrance = rs.getString(1);
      }
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(rs, pstmt, connection);
    }
    return populationHorsFrance;
  }
  
  private void mettreAJourTableLiquidation(ContexteOccasionnel p_contexte, String p_cxala, String p_id, String p_categorieEmploiParticulier, String p_populationHorsFrance)
    throws TechniqueException
  {
    String requete = "UPDATE %TABLE_LIQUIDATION SET %CATEGORIE_EMPLOI=?, %POPULATION_HORS_FRANCE=? WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND %ID=?";
    requete = requete.replaceFirst("%TABLE_LIQUIDATION", "P1210K_01VLPDT");
    requete = requete.replaceFirst("%CATEGORIE_EMPLOI", "CATEMPL");
    requete = requete.replaceFirst("%POPULATION_HORS_FRANCE", "POHF");
    requete = requete.replaceFirst("%ASSEDIC", "CXASS");
    requete = requete.replaceFirst("%ID_INDIVIDU", "CXALAF");
    requete = requete.replaceFirst("%ID", "VAL_PDT_ID");
    
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      pstmt.setString(1, p_categorieEmploiParticulier);
      pstmt.setString(2, p_populationHorsFrance);
      pstmt.setString(3, p_contexte.getCodeAssedic());
      pstmt.setString(4, p_cxala);
      pstmt.setString(5, p_id);
      pstmt.executeUpdate();
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(rs, pstmt, connection);
    }
  }
  
  private void redresserDonneesCali(ContexteOccasionnel p_contexte, String p_cxala)
    throws TechniqueException
  {
    if (Log.isTraceActive(TBCategorieEmploi.class, Niveau.INFO)) {
      Log.ecritTrace(Niveau.INFO, TBCategorieEmploi.class, "redresserDonneesCali", "CXALA: " + p_cxala + " - Redressement tables CALI...");
    }
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1200A_INDIVIDU SET CODE_TRANSFERT='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CODE_TRANSFERT IS NULL");
    
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1210D_01DNFOR SET CD_ACTCONS_REMPLIE=0, SJR_SP_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CD_ACTCONS_REMPLIE IS NULL AND SJR_SP_E IS NULL");
    
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1210A_01DEMANDE SET EST_NEUTRAL_LIQ=0, EST_NEUTRAL_CAL=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND EST_NEUTRAL_LIQ IS NULL AND EST_NEUTRAL_CAL IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1220A_02DEMANDE SET EST_NEUTRAL_LIQ=0, EST_NEUTRAL_CAL=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND EST_NEUTRAL_LIQ IS NULL AND EST_NEUTRAL_CAL IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1260A_06DEMANDE SET EST_NEUTRAL_LIQ=0, EST_NEUTRAL_CAL=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND EST_NEUTRAL_LIQ IS NULL AND EST_NEUTRAL_CAL IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1280A_08DEMANDE SET EST_NEUTRAL_LIQ=0, EST_NEUTRAL_CAL=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND EST_NEUTRAL_LIQ IS NULL AND EST_NEUTRAL_CAL IS NULL");
    
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1212O_010102CPADM SET DUR_ACT_S_PV_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND DUR_ACT_S_PV_CACAE IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1217O_010103CPADM SET DUR_ACT_S_PV_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND DUR_ACT_S_PV_CACAE IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1211Z_010102DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1216Z_010103DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1261A_060101DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1262A_060201DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1263A_060301DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1264A_060401DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1281A_080301DOSEX SET REG_FIN_PART_CACAE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND REG_FIN_PART_CACAE IS NULL");
    
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1212K_010102PRC SET CONTRATS_TYPE_PART=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CONTRATS_TYPE_PART IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1217K_010103PRC SET CONTRATS_TYPE_PART=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CONTRATS_TYPE_PART IS NULL");
    
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1211Z_010102DOSEX SET TOP_RENONCEMENT=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND TOP_RENONCEMENT IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1216Z_010103DOSEX SET TOP_RENONCEMENT=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND TOP_RENONCEMENT IS NULL");
    
    redresserTableLiquidationRbf(p_contexte, p_cxala, "P1261A_060101DOSEX");
    redresserTableLiquidationRbf(p_contexte, p_cxala, "P1262A_060201DOSEX");
    redresserTableLiquidationRbf(p_contexte, p_cxala, "P1263A_060301DOSEX");
    redresserTableLiquidationRbf(p_contexte, p_cxala, "P1264A_060401DOSEX");
    
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1212R_010102CTCOS SET NBJ_ACT_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND NBJ_ACT_E IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1214R_010201CTCOS SET NBJ_ACT_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND NBJ_ACT_E IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1217R_010103CTCOS SET NBJ_ACT_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND NBJ_ACT_E IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1212L_010102CTPR SET CAP_PREC_E='0', DUR_PREC_E='0', MNT_PREC_E='0', SJRRP_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND CAP_PREC_E IS NULL AND DUR_PREC_E IS NULL AND MNT_PREC_E IS NULL AND SJRRP_E IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1217L_010103CTPR SET MONTANT_RETENU=1, CAPITAL_RETENU=1, CAP_PREC_E='0', DUR_PREC_E='0', MNT_PREC_E='0', SJRRP_E='0' WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND MONTANT_RETENU IS NULL AND CAPITAL_RETENU IS NULL AND CAP_PREC_E IS NULL AND DUR_PREC_E IS NULL AND MNT_PREC_E IS NULL AND SJRRP_E IS NULL");
    
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1210B_01DOSSAFF SET JUSTIFICATION=translate(JUSTIFICATION,'0',' ') WHERE %ASSEDIC=? AND %ID_INDIVIDU=?");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1210D_01DNFOR SET CAT_INVALIDITE=translate(CAT_INVALIDITE,'0',' ') WHERE %ASSEDIC=? AND %ID_INDIVIDU=?");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1210M_01REPRACTIV SET INDEX=translate(INDEX,'0',' ') WHERE %ASSEDIC=? AND %ID_INDIVIDU=?");
    
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1200S_UTFORCEE SET COM_PARITAIRE='0', IS_COM_PARITAIRE=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND COM_PARITAIRE IS NULL AND IS_COM_PARITAIRE IS NULL");
    redresserTableCali(p_contexte, p_cxala, "UPDATE P1200Z_PBJCNCP SET FSPLFN=0 WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND FSPLFN IS NULL");
    redresserTableCalculParSuppressionLiensPerdusQteDroit(p_contexte, p_cxala, "DELETE FROM P1200T_LCIQT WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND QT_ID NOT IN ((SELECT QTDRT_ID FROM P1212V_010102DUIND WHERE %ASSEDIC=? AND %ID_INDIVIDU=?) UNION (SELECT QTDRT_ID FROM P1212W_010102DUREN WHERE %ASSEDIC=? AND %ID_INDIVIDU=?) UNION (SELECT QTDRT_ID FROM P1217V_010103DUIND WHERE %ASSEDIC=? AND %ID_INDIVIDU=?))");
  }
  
  private void redresserTableCali(ContexteOccasionnel p_contexte, String p_cxala, String p_requete)
    throws TechniqueException
  {
    String requete = p_requete;
    requete = requete.replaceFirst("%ASSEDIC", "CXASS");
    requete = requete.replaceFirst("%ID_INDIVIDU", "CXALAF");
    
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      pstmt.setString(1, p_contexte.getCodeAssedic());
      pstmt.setString(2, p_cxala);
      pstmt.executeUpdate();
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(rs, pstmt, connection);
    }
  }
  
  private void redresserTableCalculParSuppressionLiensPerdusQteDroit(ContexteOccasionnel p_contexte, String p_cxala, String p_requete)
    throws TechniqueException
  {
    String requete = p_requete;
    requete = requete.replaceAll("%ASSEDIC", "CXASS");
    requete = requete.replaceAll("%ID_INDIVIDU", "CXALAF");
    
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      pstmt.setString(1, p_contexte.getCodeAssedic());
      pstmt.setString(2, p_cxala);
      pstmt.setString(3, p_contexte.getCodeAssedic());
      pstmt.setString(4, p_cxala);
      pstmt.setString(5, p_contexte.getCodeAssedic());
      pstmt.setString(6, p_cxala);
      pstmt.setString(7, p_contexte.getCodeAssedic());
      pstmt.setString(8, p_cxala);
      pstmt.execute();
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(rs, pstmt, connection);
    }
  }
  
  private void redresserTableLiquidationRbf(ContexteOccasionnel p_contexte, String p_cxala, String p_nomTableRbf)
    throws TechniqueException
  {
    Hashtable hashtableIdDossierAnneeAffectation = recupererDonneesPourRedressementTableRbf(p_contexte, p_cxala, p_nomTableRbf);
    
    String idDossierExamen = null;
    String anneeAffectation = null;
    for (Enumeration enumeration = hashtableIdDossierAnneeAffectation.keys(); enumeration.hasMoreElements();)
    {
      idDossierExamen = (String)enumeration.nextElement();
      anneeAffectation = (String)hashtableIdDossierAnneeAffectation.get(idDossierExamen);
      if (anneeAffectation != null) {
        mettreAJourTableLiquidationRbf(p_contexte, p_cxala, p_nomTableRbf, idDossierExamen, anneeAffectation);
      }
    }
  }
  
  private Hashtable recupererDonneesPourRedressementTableRbf(ContexteOccasionnel p_contexte, String p_cxala, String p_nomTableRbf)
    throws TechniqueException
  {
    Hashtable hashtableIdDossierAnneeAffectation = new Hashtable();
    
    String requete = "SELECT c.DOSS_EXAMEN_ID, a.ANNEE_AFFECTATION FROM P1260A_06DEMANDE a, P1260B_06DOSAF b, %TABLE_LIQUIDATION_RBF c WHERE c.%ASSEDIC=? AND c.%ID_INDIVIDU=? AND c.ANNEE_AFFECTATION IS NULL AND c.DOSS_AFFECT_ID = b.DOSS_AFFECT_ID AND b.FK_DDE_RBF_ID = a.DDE_RBF_ID";
    requete = requete.replaceFirst("%TABLE_LIQUIDATION_RBF", p_nomTableRbf);
    requete = requete.replaceFirst("%ASSEDIC", "CXASS");
    requete = requete.replaceFirst("%ID_INDIVIDU", "CXALAF");
    
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      pstmt.setString(1, p_contexte.getCodeAssedic());
      pstmt.setString(2, p_cxala);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        hashtableIdDossierAnneeAffectation.put(rs.getString(1), rs.getString(2));
      }
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(rs, pstmt, connection);
    }
    return hashtableIdDossierAnneeAffectation;
  }
  
  private void mettreAJourTableLiquidationRbf(ContexteOccasionnel p_contexte, String p_cxala, String p_nomTableRbf, String p_idDossierExamen, String p_anneeAffectation)
    throws TechniqueException
  {
    String requete = "UPDATE %TABLE_LIQUIDATION_RBF SET ANNEE_AFFECTATION=? WHERE %ASSEDIC=? AND %ID_INDIVIDU=? AND DOSS_EXAMEN_ID=?";
    requete = requete.replaceFirst("%TABLE_LIQUIDATION_RBF", p_nomTableRbf);
    requete = requete.replaceFirst("%ASSEDIC", "CXASS");
    requete = requete.replaceFirst("%ID_INDIVIDU", "CXALAF");
    
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      pstmt.setInt(1, Integer.parseInt(p_anneeAffectation));
      pstmt.setString(2, p_contexte.getCodeAssedic());
      pstmt.setString(3, p_cxala);
      pstmt.setString(4, p_idDossierExamen);
      pstmt.executeUpdate();
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(rs, pstmt, connection);
    }
  }
}

/* Location:
 * Qualified Name:     TBCategorieEmploi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.crem.persistance;

import fr.pe.cali.crem.dom.MetaDonneeCrem;
import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.pe.cali.crem.dom.spec.IDonneesFonctionnellesCrem;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.outilsfonctionnels.AccesBase;
import fr.unedic.util.services.ApplicativeRuntimeException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OutilPersistanceObjetMetierCrem
{
  private static final String REQUETE = "INSERT INTO P1299O_CREMOUT (CXASS, ID_OM, TYPE_OM, DATE_CREM, CODE_EM, TYPE_OPERATION, STATUT_EMISSION, DATE_EMISSION, DATE_RECEPTION, STATUT_TRT, DATE_TRT, TYPE_GENERATION, META_NAME1, META_VALUE1, META_NAME2, META_VALUE2, META_NAME3, META_VALUE3, META_NAME4, META_VALUE4, META_NAME5, META_VALUE5, OM_XML, OM_VERSION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  private static OutilPersistanceObjetMetierCrem instance;
  
  public void persisterObjetMetierCrem(ObjetMetierCrem objetMetierCrem)
  {
    Connection connection = null;
    try
    {
      connection = AccesBase.getConnection(null);
      insererElement(objetMetierCrem, connection); return;
    }
    catch (TechniqueException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_ALIMENTATION_BASE_CREM", "Erreur lors de l'alimentation en base CREM");
    }
    finally
    {
      try
      {
        AccesBase.closeConnexion(connection);
      }
      catch (TechniqueException ex)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_ALIMENTATION_BASE_CREM", "Erreur lors de l'alimentation en base CREM");
      }
    }
  }
  
  private void insererElement(ObjetMetierCrem objetMetierCrem, Connection connection)
    throws TechniqueException
  {
    PreparedStatement statement = null;
    try
    {
      statement = connection.prepareStatement("INSERT INTO P1299O_CREMOUT (CXASS, ID_OM, TYPE_OM, DATE_CREM, CODE_EM, TYPE_OPERATION, STATUT_EMISSION, DATE_EMISSION, DATE_RECEPTION, STATUT_TRT, DATE_TRT, TYPE_GENERATION, META_NAME1, META_VALUE1, META_NAME2, META_VALUE2, META_NAME3, META_VALUE3, META_NAME4, META_VALUE4, META_NAME5, META_VALUE5, OM_XML, OM_VERSION) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
      preparerStatement(objetMetierCrem, statement);
      statement.execute();
    }
    catch (SQLException ex)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_ALIMENTATION_BASE_CREM", "Erreur lors de l'alimentation en base CREM");
    }
    finally
    {
      if (statement != null) {
        AccesBase.closeStatement(statement);
      }
    }
  }
  
  private void preparerStatement(ObjetMetierCrem objetMetierCrem, PreparedStatement statement)
    throws SQLException
  {
    int indexCXASS = 1;
    int indexIdOM = 2;
    int indexTypeOM = 3;
    int indexDateCrem = 4;
    int indexCodeEM = 5;
    int indexTypeOperation = 6;
    int indexStatutEmission = 7;
    int indexDateEmission = 8;
    int indexDateReception = 9;
    int indexStatutTrt = 10;
    int indexDateTrt = 11;
    int indexTypeGeneration = 12;
    int indexMetaName1 = 13;
    int indexMetaValue1 = 14;
    int indexMetaName2 = 15;
    int indexMetaValue2 = 16;
    int indexMetaName3 = 17;
    int indexMetaValue3 = 18;
    int indexMetaName4 = 19;
    int indexMetaValue4 = 20;
    int indexMetaName5 = 21;
    int indexMetaValue5 = 22;
    int indexOMXml = 23;
    int indexOMVersion = 24;
    
    statement.setString(1, objetMetierCrem.getCxass());
    statement.setString(2, objetMetierCrem.getIdentifiant());
    statement.setString(3, objetMetierCrem.getType());
    statement.setTimestamp(4, objetMetierCrem.getDateCreation());
    statement.setString(5, objetMetierCrem.getCodeEvenementMetier());
    statement.setString(6, objetMetierCrem.getTypeOperation());
    statement.setString(7, objetMetierCrem.getStatutEmission());
    statement.setTimestamp(8, objetMetierCrem.getDateDerniereEmission());
    statement.setTimestamp(9, objetMetierCrem.getDateReception());
    statement.setString(10, objetMetierCrem.getStatutTraitement());
    statement.setTimestamp(11, objetMetierCrem.getDateTraitement());
    statement.setString(12, objetMetierCrem.getTypeGeneration());
    preparerStatementPourMetaDonnee(objetMetierCrem.getPremiereMetaDonnee(), 13, 14, statement);
    preparerStatementPourMetaDonnee(objetMetierCrem.getDeuxiemeMetaDonnee(), 15, 16, statement);
    preparerStatementPourMetaDonnee(objetMetierCrem.getTroisiemeMetaDonnee(), 17, 18, statement);
    preparerStatementPourMetaDonnee(objetMetierCrem.getQuatriemeMetaDonnee(), 19, 20, statement);
    preparerStatementPourMetaDonnee(objetMetierCrem.getCinquiemeMetaDonnee(), 21, 22, statement);
    if (objetMetierCrem.getDonneesFonctionnelles() != null) {
      statement.setString(23, objetMetierCrem.getDonneesFonctionnelles().genererXML());
    } else {
      statement.setString(23, null);
    }
    statement.setString(24, objetMetierCrem.getVersionObjetMetier());
  }
  
  private void preparerStatementPourMetaDonnee(MetaDonneeCrem metaDonnee, int indexNom, int indexValue, PreparedStatement statement)
    throws SQLException
  {
    if (metaDonnee != null)
    {
      statement.setString(indexNom, metaDonnee.getNom());
      statement.setString(indexValue, metaDonnee.getValeur());
    }
    else
    {
      statement.setString(indexNom, null);
      statement.setString(indexValue, null);
    }
  }
  
  public static OutilPersistanceObjetMetierCrem getInstance()
  {
    if (instance == null) {
      instance = new OutilPersistanceObjetMetierCrem();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     OutilPersistanceObjetMetierCrem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.parametres.dateapplication.persistance;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.outilsfonctionnels.AccesBase;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.temps.Damj;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class OutilChargementDateApplication
{
  private static OutilChargementDateApplication instance;
  private static final String REQUETE = "SELECT CODE_DATE_APPLI, DATE_APPLICATION FROM P1299Q_DATE_APPLI";
  private static final int INDEX_PARAM_CODE = 1;
  private static final int INDEX_PARAM_VALUE = 2;
  
  public static synchronized OutilChargementDateApplication getInstance()
  {
    if (instance == null) {
      instance = new OutilChargementDateApplication();
    }
    return instance;
  }
  
  public Map<String, Damj> chargerDatesApplication()
  {
    Connection connection = ouvrirConnexion();
    Map<String, Damj> gestionnaireDateApplication;
    try
    {
      gestionnaireDateApplication = lireBase(connection);
    }
    finally
    {
      fermerConnexion(connection);
    }
    return gestionnaireDateApplication;
  }
  
  private Map<String, Damj> lireBase(Connection connection)
  {
    Map<String, Damj> resultat = new HashMap();
    PreparedStatement statement = null;
    ResultSet set = null;
    try
    {
      statement = connection.prepareStatement("SELECT CODE_DATE_APPLI, DATE_APPLICATION FROM P1299Q_DATE_APPLI");
      set = statement.executeQuery();
      while (set.next()) {
        enrichirMap(set, resultat);
      }
    }
    catch (SQLException ex)
    {
      leverExceptionRuntime(ex);
    }
    finally
    {
      fermerResultSetEtStatement(set, statement);
    }
    return resultat;
  }
  
  private void fermerResultSetEtStatement(ResultSet set, PreparedStatement statement)
  {
    Throwable exception = null;
    if (set != null) {
      try
      {
        set.close();
      }
      catch (SQLException ex)
      {
        exception = ex;
      }
    }
    if (statement != null) {
      try
      {
        AccesBase.closeStatement(statement);
      }
      catch (TechniqueException ex)
      {
        exception = ex;
      }
    }
    if (exception != null) {
      leverExceptionRuntime(exception);
    }
  }
  
  private void enrichirMap(ResultSet set, Map<String, Damj> resultat)
    throws SQLException
  {
    String code = set.getString(1).trim();
    Damj valeur = Damj.dateVersDamj(set.getDate(2));
    resultat.put(code, valeur);
  }
  
  private void leverExceptionRuntime(Throwable ex)
  {
    throw new ApplicativeRuntimeException("HG_LECTURE_DATE_APPLICATION_BD", "Erreur lors de la lecture des dates d'applications en base", ex);
  }
  
  private Connection ouvrirConnexion()
  {
    Connection connection = null;
    try
    {
      connection = AccesBase.getConnection(null);
    }
    catch (TechniqueException ex)
    {
      leverExceptionRuntime(ex);
    }
    return connection;
  }
  
  private void fermerConnexion(Connection connection)
  {
    try
    {
      if (connection != null) {
        AccesBase.closeConnexion(connection);
      }
    }
    catch (TechniqueException ex)
    {
      leverExceptionRuntime(ex);
    }
  }
}

/* Location:
 * Qualified Name:     OutilChargementDateApplication
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
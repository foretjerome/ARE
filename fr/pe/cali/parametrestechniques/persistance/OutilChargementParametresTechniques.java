package fr.pe.cali.parametrestechniques.persistance;

import fr.pe.cali.parametrestechniques.constantes.ConstantesTopDebrayage;
import fr.pe.cali.parametrestechniques.constantes.ConstantesTopDeploiement;
import fr.pe.cali.parametrestechniques.dom.ParametreTechnique;
import fr.pe.cali.parametrestechniques.dom.TopDebrayage;
import fr.pe.cali.parametrestechniques.dom.TopDeploiement;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.outilsfonctionnels.AccesBase;
import fr.unedic.util.services.ApplicativeRuntimeException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public final class OutilChargementParametresTechniques
{
  private static OutilChargementParametresTechniques instance;
  private static final String REQUETE = "SELECT PARAM_CODE, PARAM_LIB, PARAM_VALUE FROM P1299P_PARAMETRAGE WHERE PART_TERRITOIRE IN (? , '000')";
  private static final int INDEX_CODE_TERRITOIRE = 1;
  private static final int INDEX_PARAM_CODE = 1;
  private static final int INDEX_PARAM_LIB = 2;
  private static final int INDEX_PARAM_VALUE = 3;
  
  public static OutilChargementParametresTechniques getInstance()
  {
    if (instance == null) {
      instance = new OutilChargementParametresTechniques();
    }
    return instance;
  }
  
  public List<ParametreTechnique> chargerParametresTechnique(String codeTerritoire)
  {
    List<ParametreTechnique> resultat = null;
    Connection connection = ouvrirConnexion();
    try
    {
      resultat = lireParametres(connection, codeTerritoire);
    }
    finally
    {
      fermerConnexion(connection);
    }
    return resultat;
  }
  
  private List<ParametreTechnique> lireParametres(Connection connection, String codeTerritoire)
  {
    List<ParametreTechnique> resultat = new ArrayList();
    PreparedStatement statement = null;
    ResultSet set = null;
    try
    {
      statement = connection.prepareStatement("SELECT PARAM_CODE, PARAM_LIB, PARAM_VALUE FROM P1299P_PARAMETRAGE WHERE PART_TERRITOIRE IN (? , '000')");
      statement.setString(1, codeTerritoire);
      set = statement.executeQuery();
      boolean setIsOpen = set.next();
      while (setIsOpen)
      {
        ParametreTechnique parametre = creerParametreTechnique(set);
        if (parametre != null) {
          resultat.add(parametre);
        }
        setIsOpen = set.next();
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
  
  private ParametreTechnique creerParametreTechnique(ResultSet set)
    throws SQLException
  {
    String paramCode = set.getString(1).trim();
    String paramValue = set.getString(3).trim();
    String paramLib = set.getString(2).trim();
    ParametreTechnique parametre = null;
    if (ConstantesTopDeploiement.estTopDeploiementGere(paramCode))
    {
      parametre = new TopDeploiement(paramCode, paramValue);
      parametre.setLibelle(paramLib);
    }
    else if (ConstantesTopDebrayage.estTopDebrayageGere(paramCode))
    {
      parametre = new TopDebrayage(paramCode, paramValue);
      parametre.setLibelle(paramLib);
    }
    return parametre;
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
  
  private void leverExceptionRuntime(Throwable ex)
  {
    throw new ApplicativeRuntimeException("HG_PR_CALI_L_ERR_LECTURE_PARAMETRIQUE_TECHNIQUE", "Erreur lors de la lecture des paramètres techniques", ex);
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
}

/* Location:
 * Qualified Name:     OutilChargementParametresTechniques
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
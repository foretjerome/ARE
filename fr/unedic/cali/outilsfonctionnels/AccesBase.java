package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.util.persistance.dao.ConnexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.apache.commons.lang.StringUtils;

public class AccesBase
{
  protected static final String ERR_SQL = "ERR_SQL";
  protected static final String FACTORY_TRANSACTIONNEL = "NCPConnectionFactory";
  protected static final String FACTORY_NON_TRANSACTIONNEL = "NCPConnectionLocalFactory";
  protected static final int CODE_SQL_ERREUR_DOUBLON = -803;
  
  public static Connection getConnection(String modeOccasionnel)
    throws TechniqueException
  {
    return ConnexionDB.openConnection(definirFactoryAUtiliser(modeOccasionnel));
  }
  
  protected static String definirFactoryAUtiliser(String modeOccasionnel)
  {
    if ((modeOccasionnel == null) || (StringUtils.equals("Normal", modeOccasionnel)) || (StringUtils.equals("NormalAvecTracker", modeOccasionnel)) || (StringUtils.equals("NormalSansTracker", modeOccasionnel))) {
      return "NCPConnectionFactory";
    }
    return "NCPConnectionLocalFactory";
  }
  
  public static void closeStatement(PreparedStatement statement)
    throws TechniqueException
  {
    ConnexionDB.closeAll(null, statement, null);
  }
  
  public static void closeConnexion(Connection connection)
    throws TechniqueException
  {
    ConnexionDB.closeAll(null, null, connection);
  }
  
  public static void closeConnexionStatement(Connection connection, PreparedStatement statement)
    throws TechniqueException
  {
    ConnexionDB.closeAll(null, statement, connection);
  }
  
  protected static void traiterExceptionSQL(SQLException exception)
    throws TechniqueException
  {
    if (exception.getErrorCode() != 64733) {
      throw new TechniqueException("ERR_SQL", exception.getMessage(), exception);
    }
  }
}

/* Location:
 * Qualified Name:     AccesBase
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
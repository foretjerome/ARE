package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.parcours.DomCali;
import fr.unedic.cali.parcours.DomSelectionFine;
import fr.unedic.util.persistance.dao.DBUtil;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BaseSelectionFine
  extends AccesBase
{
  public static final String NOM_TABLE_SELECTION_FINE = "P1297G_SEL_OCCAS";
  protected static final String COLONNES_TABLE_SELECTION_FINE = "CXASS,CXALAF,LIB_POPULATION,TSP,DATE_REEXECUTION,EST_A_REEXECUTER";
  protected static final String NOM_COL_TABLE_SELECTION_FINE = "(CXASS,CXALAF,LIB_POPULATION,TSP,DATE_REEXECUTION,EST_A_REEXECUTER)";
  protected static final String NOM_COL_EST_A_REEXECUTER = "EST_A_REEXECUTER";
  protected static final String NOM_COL_CXASS = "CXASS";
  protected static final String NOM_COL_CXALAF = "CXALAF";
  protected static final String NOM_COL_LIB_POPULATION = "LIB_POPULATION";
  protected static final String NOM_COL_TSP = "TSP";
  protected static final String NOM_COL_DATE_REEXECUTION = "DATE_REEXECUTION";
  
  public static void ecrireBaseSelectionFine(DomCali p_domSelectionFine, RedressementSpec p_redressement)
    throws TechniqueException
  {
    Connection connection = null;
    try
    {
      connection = getConnection(p_redressement.getModeRedressement());
      ecrireIndividu(p_domSelectionFine, connection);
    }
    finally
    {
      closeConnexion(connection);
    }
  }
  
  private static void ecrireIndividu(DomCali p_domSelectionFine, Connection p_connection)
    throws TechniqueException
  {
    DomSelectionFine domSelectionFine = (DomSelectionFine)p_domSelectionFine;
    StringBuffer requete = new StringBuffer();
    
    requete.append("INSERT INTO ");
    requete.append("P1297G_SEL_OCCAS").append(" ");
    requete.append("(CXASS,CXALAF,LIB_POPULATION,TSP,DATE_REEXECUTION,EST_A_REEXECUTER)").append(" ");
    requete.append("VALUES (?,?,?,CURRENT TIMESTAMP,?,?)");
    
    PreparedStatement statement = null;
    int idxCXASS = 1;
    int idxCXALAF = 2;
    int idxLIBPOPULATION = 3;
    int idxDATEREEXECUTION = 4;
    int idxESTAREEXECUTER = 5;
    String cxass = domSelectionFine.getContexteService().getSrcCodeAssedic();
    BigDecimal cxalaf = domSelectionFine.getContexteService().getCxala();
    String libellePopulation = domSelectionFine.getPopulation().getLibelle();
    try
    {
      statement = p_connection.prepareStatement(requete.toString());
      statement.setString(1, cxass);
      statement.setBigDecimal(2, cxalaf);
      statement.setString(3, libellePopulation);
      statement.setDate(4, DBUtil.dateVersSqlDate(Damj.damjVersDate(domSelectionFine.getDateReexecution())));
      statement.setString(5, evaluerBooleanValue(domSelectionFine.isEstAReexecuter()));
      
      statement.execute();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
      reecrireIndividu(p_domSelectionFine, p_connection);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static void reecrireIndividu(DomCali p_domSelectionFine, Connection p_connection)
    throws TechniqueException
  {
    DomSelectionFine domSelectionFine = (DomSelectionFine)p_domSelectionFine;
    StringBuffer requete = new StringBuffer();
    
    requete.append("UPDATE  ");
    requete.append("P1297G_SEL_OCCAS").append(" ");
    requete.append("SET ").append("EST_A_REEXECUTER").append(" = ?, ");
    requete.append("TSP = CURRENT TIMESTAMP, ");
    requete.append("DATE_REEXECUTION").append(" = ? ");
    requete.append("WHERE CXASS = ? AND CXALAF = ? AND LIB_POPULATION = ?");
    
    PreparedStatement statement = null;
    int idxCXASS = 3;
    int idxCXALAF = 4;
    int idxLIBPOPULATION = 5;
    int idxDATEREEXECUTION = 2;
    int idxESTAREEXECUTER = 1;
    String cxass = domSelectionFine.getContexteService().getSrcCodeAssedic();
    BigDecimal cxalaf = domSelectionFine.getContexteService().getCxala();
    String libellePopulation = domSelectionFine.getPopulation().getLibelle();
    try
    {
      statement = p_connection.prepareStatement(requete.toString());
      statement.setString(3, cxass);
      statement.setBigDecimal(4, cxalaf);
      statement.setString(5, libellePopulation);
      statement.setDate(2, DBUtil.dateVersSqlDate(Damj.damjVersDate(domSelectionFine.getDateReexecution())));
      statement.setString(1, evaluerBooleanValue(domSelectionFine.isEstAReexecuter()));
      
      statement.execute();
    }
    catch (SQLException e)
    {
      traiterExceptionSQL(e);
    }
    finally
    {
      closeStatement(statement);
    }
  }
  
  private static String evaluerBooleanValue(boolean p_valeur)
  {
    String vrai = "1";
    String faux = "0";
    if (p_valeur) {
      return vrai;
    }
    return faux;
  }
}

/* Location:
 * Qualified Name:     BaseSelectionFine
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.occasionnel;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.persistance.dao.ConnexionDB;
import fr.unedic.util.services.ResultatService;
import fr.unedic.util.services.batch.ContexteOccasionnel;
import fr.unedic.util.services.batch.IdTraitement;
import fr.unedic.util.services.batch.ListeIdTraitements;
import fr.unedic.util.services.batch.RequeteTraitements;
import fr.unedic.util.services.batch.TBOccasionnelAbstrait;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TBSelectionTestProduction
  extends TBOccasionnelAbstrait
{
  private static final String NOM_TABLE_LIQUIDATION = "P1200X_TEST_PROD";
  private static final String NOM_COLONNE_ASSEDIC = "CXASS";
  private static final String NOM_COLONNE_CXALA = "CXALAF";
  private static final String NOM_COLONNE_ID_TABLE_LIQUIDATION = "TEST_PROD_ID";
  private static final String NOM_COLONNE_DATE_JOUR = "DATE_JOUR";
  private static final String REQ_LECTURE_TEST_PROD = "SELECT %ID FROM %TABLE WHERE %DATE_JOUR<? AND %ASSEDIC=? AND ?<=%ID AND %ID<=? ORDER BY %ID";
  private static final String REQ_DELETE_TEST_PROD = "DELETE FROM %TABLE WHERE %ASSEDIC=? AND %ID=?";
  private static final int NB_JOURS = 7;
  
  public TBSelectionTestProduction()
  {
    super("P1200X_TEST_PROD");
  }
  
  protected ResultatService traiterEnregistrement(ContexteOccasionnel p_contexte, String p_id)
    throws TechniqueException
  {
    ResultatService resultatServiceRetourne = new ResultatService();
    resultatServiceRetourne.setEtat(1);
    
    String colonneID = getNomColonne(3);
    String colonneAssedic = getNomColonne(1);
    String requete = "DELETE FROM %TABLE WHERE %ASSEDIC=? AND %ID=?";
    
    requete = requete.replaceFirst("%TABLE", m_nomTable);
    requete = requete.replaceFirst("%ID", colonneID);
    requete = requete.replaceFirst("%ASSEDIC", colonneAssedic);
    
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    
    PreparedStatement pstmt = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      pstmt.setString(1, p_contexte.getCodeAssedic());
      pstmt.setString(2, p_id);
      pstmt.executeUpdate();
    }
    catch (SQLException e)
    {
      throw new TechniqueException("ERR_SQL", e.getMessage(), e);
    }
    finally
    {
      ConnexionDB.closeAll(null, pstmt, connection);
    }
    resultatServiceRetourne.setEtat(0);
    
    return resultatServiceRetourne;
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
      nomColonne = "CXALAF";
      break;
    case 3: 
      nomColonne = "TEST_PROD_ID";
      break;
    }
    return nomColonne;
  }
  
  public ListeIdTraitements getListeIdTraitements(ContexteOccasionnel p_contexte)
    throws ApplicativeException, TechniqueException
  {
    String colonneAssedic = getNomColonne(1);
    String colonneID = getNomColonne(3);
    
    RequeteTraitements requete = new RequeteTraitements(m_nomTable, colonneAssedic, colonneID);
    requete.setTailleGroupe(p_contexte.getTailleGroupe());
    ListeIdTraitements listeIdTraitements = requete.determinerListe(p_contexte.getNomConnectionFactory(), p_contexte.getCodeAssedic());
    return listeIdTraitements;
  }
  
  public ResultatService executer(ContexteOccasionnel p_contexte)
    throws TechniqueException, ApplicativeException
  {
    return super.executer(p_contexte);
  }
  
  protected List lireEnregistrements(ContexteOccasionnel p_contexte)
    throws TechniqueException
  {
    List listeIDs = new ArrayList();
    
    IdTraitement idTraitement = p_contexte.getIdTraitement();
    String colonneAssedic = getNomColonne(1);
    String colonneID = getNomColonne(3);
    
    String requete = "SELECT %ID FROM %TABLE WHERE %DATE_JOUR<? AND %ASSEDIC=? AND ?<=%ID AND %ID<=? ORDER BY %ID";
    requete = requete.replaceFirst("%TABLE", m_nomTable);
    requete = requete.replaceAll("%ID", colonneID);
    requete = requete.replaceFirst("%ASSEDIC", colonneAssedic);
    requete = requete.replaceFirst("%DATE_JOUR", "DATE_JOUR");
    Connection connection = ConnexionDB.openConnection(p_contexte.getNomConnectionFactory());
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    try
    {
      pstmt = connection.prepareStatement(requete);
      int i = 1;
      
      Damj dateSuppression = p_contexte.getDateTraitement().deplacerVersArriere(new DureeCalendaire(0, 0, 7));
      pstmt.setDate(i++, new java.sql.Date(Damj.damjVersDate(dateSuppression).getTime()));
      
      pstmt.setString(i++, p_contexte.getCodeAssedic());
      pstmt.setLong(i++, idTraitement.getIdInf());
      pstmt.setLong(i++, idTraitement.getIdSup());
      rs = pstmt.executeQuery();
      while (rs.next()) {
        listeIDs.add(rs.getString(1));
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
    return listeIDs;
  }
}

/* Location:
 * Qualified Name:     TBSelectionTestProduction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
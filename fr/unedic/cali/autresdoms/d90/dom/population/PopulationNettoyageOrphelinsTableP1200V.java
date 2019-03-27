package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationTraitementDB2;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationNettoyageOrphelinsTableP1200V
  extends PopulationAbstraite
{
  private static final int IDENTIFIANT_POPULATION = "10SI3CALI_NettoyageOrphelinsTableP1200V".hashCode();
  private static final int PRIORITE = 760;
  private static final String REQUETE = "DELETE FROM P1200V_DECAL_DUREE DD WHERE DD.CXASS = ? AND DD.CXALAF = ? AND DD.DECAL_DUREE_ID IN ( SELECT DISTINCT DD2.DECAL_DUREE_ID FROM P1200V_DECAL_DUREE DD2 LEFT OUTER JOIN P1200U_DECALAGE D ON DD2.CXASS = D.CXASS AND DD2.CXALAF = D.CXALAF AND DD2.DECAL_DUREE_ID = D.DECAL_DUREE_ID WHERE (D.DECAL_DUREE_ID IS NULL OR DD2.QT_COURANTE_V IS NULL) AND DD2.CXASS = ? AND DD2.CXALAF = ?)";
  private static final int CODE_POLE_EMPLOI_1 = 1;
  private static final int CODE_CXALAF_1 = 2;
  private static final int CODE_POLE_EMPLOI_2 = 3;
  private static final int CODE_CXALAF_2 = 4;
  
  public PopulationNettoyageOrphelinsTableP1200V()
  {
    setId(IDENTIFIANT_POPULATION);
    setTopSelection(" ");
    setPriorite(760);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("10SI3CALI_NettoyageOrphelinsTableP1200V");
    setNumeroDSMS("");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return null;
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return null;
  }
  
  public String getRequete()
  {
    return "DELETE FROM P1200V_DECAL_DUREE DD WHERE DD.CXASS = ? AND DD.CXALAF = ? AND DD.DECAL_DUREE_ID IN ( SELECT DISTINCT DD2.DECAL_DUREE_ID FROM P1200V_DECAL_DUREE DD2 LEFT OUTER JOIN P1200U_DECALAGE D ON DD2.CXASS = D.CXASS AND DD2.CXALAF = D.CXALAF AND DD2.DECAL_DUREE_ID = D.DECAL_DUREE_ID WHERE (D.DECAL_DUREE_ID IS NULL OR DD2.QT_COURANTE_V IS NULL) AND DD2.CXASS = ? AND DD2.CXALAF = ?)";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setBigDecimal(2, contexteService.getCxala());
    statement.setString(3, codeAssedic);
    statement.setBigDecimal(4, contexteService.getCxala());
  }
  
  public void chargerIndividu(Individu individu)
    throws ApplicativeException, TechniqueException
  {}
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationTraitementDB2();
  }
}

/* Location:
 * Qualified Name:     PopulationNettoyageOrphelinsTableP1200V
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
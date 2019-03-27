package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.InfoReexecution;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationStatutPPetForcageIndus;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationStatutPPetForcageDecalageUT
  extends PopulationAbstraite
{
  public static final String IDENTIFIANT_POPULATION = "IN0496933 Neutra. indu par forcage PP Travail";
  private static final int PRIORITE = 755;
  private static final int COLONNE_CXALAF = 2;
  private static final int COLONNE_DATE_REEXECUTION = 3;
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int CODE_ASSEDIC_2 = 4;
  private static final int ID_INF_2 = 5;
  private static final int ID_SUP_2 = 6;
  private static final String REQUETE = "SELECT A.CXASS, A.CXALAF, MIN(DDPJB) FROM P1200Z_PBJCNCP A WHERE PSIPK > 0 AND A.CXASS = ? AND A.CXALAF >= ? AND A.CXALAF <= ? AND DFPJB <= '2013-05-31' AND CDSTK = 5 AND CPROD <> 'ASU_SPE02_03' AND (A.CXASS, A.CXALAF, MONTH(a.DDPJB), year(a.ddpjb)) NOT IN (SELECT cxass, cxalaf, month(periode_d), year(periode_d) from p1200s_utforcee where is_statut = 1 and statut = '5' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? and month(periode_d)=month(a.ddpjb) and year(periode_d)=year(a.ddpjb)) group by A.CXASS, A.CXALAF  WITH UR;";
  
  public PopulationStatutPPetForcageDecalageUT()
  {
    setId("IN0496933 Neutra. indu par forcage PP Travail".hashCode());
    setNumeroDSMS("SO");
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("IN0496933 Neutra. indu par forcage PP Travail");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(2));
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return new Damj(Damj.dateVersDamj(rs.getDate(3)));
  }
  
  public String getRequete()
  {
    return "SELECT A.CXASS, A.CXALAF, MIN(DDPJB) FROM P1200Z_PBJCNCP A WHERE PSIPK > 0 AND A.CXASS = ? AND A.CXALAF >= ? AND A.CXALAF <= ? AND DFPJB <= '2013-05-31' AND CDSTK = 5 AND CPROD <> 'ASU_SPE02_03' AND (A.CXASS, A.CXALAF, MONTH(a.DDPJB), year(a.ddpjb)) NOT IN (SELECT cxass, cxalaf, month(periode_d), year(periode_d) from p1200s_utforcee where is_statut = 1 and statut = '5' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? and month(periode_d)=month(a.ddpjb) and year(periode_d)=year(a.ddpjb)) group by A.CXASS, A.CXALAF  WITH UR;";
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
    statement.setString(4, codeAssedic);
    statement.setString(5, idInf);
    statement.setString(6, idSup);
  }
  
  public void chargerIndividu(Individu individu)
    throws ApplicativeException, TechniqueException
  {
    individu.chargerIndividuCohab();
    individu.chargerIndividuCali();
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    return new ParcoursPopulationStatutPPetForcageIndus();
  }
  
  public InfoReexecution estUnIndividuReexecutable(IndividuSpec individu, Damj dateReexecutionSelection)
    throws ApplicativeException
  {
    InfoReexecution infos = new InfoReexecution();
    infos.setExecutable(true);
    if (dateReexecutionSelection != null) {
      infos.setDateExecution(dateReexecutionSelection);
    } else {
      infos.setDateExecution(PopulationSpec.DATE_LIMITE_NON_REEXECUTION);
    }
    return infos;
  }
}

/* Location:
 * Qualified Name:     PopulationStatutPPetForcageDecalageUT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
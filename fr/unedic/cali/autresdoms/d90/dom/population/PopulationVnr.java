package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.InfoReexecution;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementVnrBatch;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.ContexteExecutionVnr;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationVnr
  extends PopulationAbstraite
{
  public static final String LIBELLE = "POP_CALI_Population_Vnr";
  private static final String REQUETE = "SELECT CXALAF FROM P1200A_INDIVIDU WHERE CXASS = ? AND CXALAF >= ? AND CXALAF <= ? ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String LISTE_INDIVIDUS_REEXAMEN = "";
  private static final String LISTE_INDIVIDUS_DELTA_MONTANT_BRUT = "";
  private static final String LISTE_INDIVIDUS_ERREUR = "";
  
  public PopulationVnr()
  {
    super("POP_CALI_Population_Vnr");
    setComportement(new ComportementVnrBatch());
  }
  
  protected PopulationVnr(String libelle)
  {
    super(libelle);
    setComportement(new ComportementVnrBatch());
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(1));
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return PopulationSpec.DATE_LIMITE_NON_REEXECUTION_VNR;
  }
  
  public String getRequete()
  {
    String requete = "SELECT CXALAF FROM P1200A_INDIVIDU WHERE CXASS = ? AND CXALAF >= ? AND CXALAF <= ? ";
    if ((estChaineNonVide("")) || (estChaineNonVide("")) || (estChaineNonVide("")))
    {
      StringBuilder requeteBuffer = new StringBuilder("SELECT CXALAF FROM P1200A_INDIVIDU WHERE CXASS = ? AND CXALAF >= ? AND CXALAF <= ? ");
      requeteBuffer.append("AND CXALAF NOT IN (");
      
      boolean cxalafAjoute = false;
      cxalafAjoute = exclureCxalaf("", cxalafAjoute, requeteBuffer);
      cxalafAjoute = exclureCxalaf("", cxalafAjoute, requeteBuffer);
      exclureCxalaf("", cxalafAjoute, requeteBuffer);
      
      requeteBuffer.append(")");
      requete = requeteBuffer.toString();
    }
    return requete;
  }
  
  public InfoReexecution estUnIndividuReexecutable(IndividuSpec individu, Damj dateReexecutionSelection)
    throws ApplicativeException
  {
    InfoReexecution infos = new InfoReexecution();
    infos.setExecutable(true);
    infos.setDateExecution(dateReexecutionSelection);
    return infos;
  }
  
  private boolean estChaineNonVide(String chaine)
  {
    return !"".equals(chaine);
  }
  
  private boolean exclureCxalaf(String listeCxala, boolean isCxalafAjoute, StringBuilder requete)
  {
    boolean cxalafAjoute = isCxalafAjoute;
    if (estChaineNonVide(listeCxala))
    {
      if (isCxalafAjoute) {
        requete.append(", ");
      }
      requete.append(listeCxala);
      cxalafAjoute = true;
    }
    return cxalafAjoute;
  }
  
  public void preparerStatement(PreparedStatement statement, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
    throws SQLException
  {
    statement.setString(1, codeAssedic);
    statement.setString(2, idInf);
    statement.setString(3, idSup);
  }
  
  public ParcoursPopulationSpec getParcours()
  {
    ContexteExecutionVnr.getContexte().setActif(true);
    return new ParcoursPopulationReexecution();
  }
}

/* Location:
 * Qualified Name:     PopulationVnr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
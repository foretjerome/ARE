package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PopulationVnrADateDuJour
  extends PopulationVnr
{
  private static final String LIBELLE = "POP_CALI_Population_Vnr_A_Date_Du_Jour";
  private static final String REQUETE = "SELECT CXALAF FROM P1200A_INDIVIDU WHERE CXASS = ? AND CXALAF >= ? AND CXALAF <= ? ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final int ANNEE_EVENEMENT = 2012;
  private static final int MOIS_EVENEMENT = 4;
  private static final int JOUR_EVENEMENT = 6;
  private static final String LISTE_INDIVIDUS_REEXAMEN = "";
  private static final String LISTE_INDIVIDUS_DELTA_MONTANT_BRUT = "";
  private static final String LISTE_INDIVIDUS_ERREUR = "";
  
  public PopulationVnrADateDuJour()
  {
    super("POP_CALI_Population_Vnr_A_Date_Du_Jour");
  }
  
  public Long getCxalaf(ResultSet rs)
    throws SQLException
  {
    return Long.valueOf(rs.getLong(1));
  }
  
  public Damj getDateReexecution(ResultSet rs, Individu individu)
    throws SQLException
  {
    return new Damj(2012, 4, 6);
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
  
  public void chargerIndividu(Individu individu)
    throws ApplicativeException, TechniqueException
  {
    individu.chargerIndividuCohab();
    individu.chargerIndividuCali();
  }
}

/* Location:
 * Qualified Name:     PopulationVnrADateDuJour
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
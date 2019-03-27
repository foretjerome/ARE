package fr.unedic.cali.autresdoms.d90.dom.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.contexte.ContexteDeploiement;
import fr.unedic.archi.logique.contexte.fournisseur._ContexteFournisseur;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.logique.persistance.GestionnairePersistance;
import fr.unedic.archi.util.db.ConnectionFactory;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.dom.IndividuPopulationImpl;
import fr.unedic.cali.autresdoms.d90.dom.IndividuSelection;
import fr.unedic.cali.autresdoms.d90.dom.InfoReexecution;
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementVnrBatchCinqCles;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuId;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.persistance.util.ContextePersistance;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.population.ParcoursPopulationReexecution;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.List;

public class PopulationBatchCinqCles
  extends PopulationAbstraite
{
  private static final String LIBELLE = "POP_CALI_Pop_Cinq_cles";
  private static final int IDENTIFIANT_POPULATION = "POP_CALI_Pop_Cinq_cles".hashCode();
  private static final int PRIORITE = 755;
  private static final String REQUETE = "SELECT CXALAF FROM P1200A_INDIVIDU WHERE CXASS = ? AND CXALAF >= ? AND CXALAF <= ? ";
  private static final int CODE_ASSEDIC = 1;
  private static final int ID_INF = 2;
  private static final int ID_SUP = 3;
  private static final String LISTE_INDIVIDUS_REEXAMEN = "";
  private static final String LISTE_INDIVIDUS_DELTA_MONTANT_BRUT = "";
  private static final String LISTE_INDIVIDUS_ERREUR = "";
  
  public PopulationBatchCinqCles()
  {
    setId(IDENTIFIANT_POPULATION);
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle("POP_CALI_Pop_Cinq_cles");
    setNumeroDSMS("000000");
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
    setComportement(new ComportementVnrBatchCinqCles());
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
  
  private boolean estChaineNonVide(String chaine)
  {
    return !"".equals(chaine);
  }
  
  public InfoReexecution estUnIndividuReexecutable(IndividuSpec individu, Damj dateReexecutionSelection)
    throws ApplicativeException
  {
    InfoReexecution infos = new InfoReexecution();
    infos.setExecutable(true);
    infos.setDateExecution(dateReexecutionSelection);
    return infos;
  }
  
  private boolean exclureCxalaf(String listeCxala, boolean isCxalafAjoute, StringBuilder requete)
  {
    boolean cxalafAjoute = isCxalafAjoute;
    if (!"".equals(listeCxala))
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
    return new ParcoursPopulationReexecution();
  }
  
  public void getCollectionIndividus(List<IndividuSelection> collectionIndividus, String codeAssedic, String idInf, String idSup, ContexteService contexteService)
  {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    try
    {
      String requete = getRequete();
      
      ContexteDeploiement contexteDeploiement = _ContexteFournisseur.getContexteDeploiement();
      
      ConnectionFactory connectionFactory = contexteDeploiement.getConnectionFactory("NCPConnectionFactory");
      connection = connectionFactory.getConnection();
      
      statement = connection.prepareStatement(requete);
      preparerStatement(statement, codeAssedic, idInf, idSup, contexteService);
      
      rs = statement.executeQuery();
      
      GestionnairePersistance gp = ContextePersistance.getGestionnairePersistance();
      gp.setValeurPartitionnement("numassedic", codeAssedic);
      while (rs.next())
      {
        Long cxalaf = getCxalaf(rs);
        
        gp.setValeurPartitionnement("numalloc", cxalaf);
        
        Individu individu = (Individu)Individu.getIndividu(true, new IndividuId(cxalaf));
        
        contexteService.setCxala(BigDecimal.valueOf(cxalaf.longValue()));
        if (verifierAppartenance(individu)) {
          ajouter(individu, getDateReexecution(rs, individu), collectionIndividus, codeAssedic);
        }
      }
    }
    catch (ApplicativeException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
    catch (TechniqueException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
    catch (SQLException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
    finally
    {
      fermerConnexion(connection, statement, rs);
    }
  }
  
  private void fermerConnexion(Connection connection, PreparedStatement statement, ResultSet rs)
  {
    try
    {
      if (rs != null) {
        rs.close();
      }
      if (statement != null) {
        statement.close();
      }
      if (connection != null) {
        connection.close();
      }
    }
    catch (SQLException e)
    {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_D90", "Problème lors de l'appel de service de CALI vers D90", e);
    }
  }
  
  public void ajouter(Individu individu, Damj dateReexecution, List<IndividuSelection> individus, String codeAssedic)
    throws CoucheLogiqueException
  {
    IndividuSelection individuSelection = new IndividuSelection();
    IndividuPopulationImpl individuPopulation;
    try
    {
      individuPopulation = AppelServicesCojac.lireAliasNCP(individu.getNumeroAllocataire(), codeAssedic);
    }
    catch (ApplicativeRuntimeException ex)
    {
      individuPopulation = null;
      loguerErreurAjouterIndividu(individu, codeAssedic, ex);
    }
    if ((isNumeroAllocatairePresent(individuPopulation)) && (isCodeAssedicConforme(individuPopulation, codeAssedic)) && ("O".equalsIgnoreCase(individuPopulation.getTopReferent())))
    {
      individuSelection.setIdentifiantBNI(new BigDecimal(individu.getNumeroAllocataire()));
      individuSelection.setIdentifiantSigma(individuPopulation.getNumeroAllocataireRsin());
      individuSelection.setCodeAssedic(new DecimalFormat("000").format(Integer.parseInt(individuPopulation.getCodeAssedic())));
      individuSelection.setCodeAntenne(individuPopulation.getCodeAntenne());
      individuSelection.setDateReexecution(dateReexecution);
      individuSelection.setPopulation(this);
      
      IndividuSelection individuDansListe = trouverIndividuDansLaListe(individus, individuSelection);
      if (individuDansListe == null)
      {
        for (int i = 0; i < 5; i++)
        {
          individus.add(individuSelection);
          individuSelection.getCollectionPopulations().add(this);
        }
      }
      else
      {
        individuDansListe.getCollectionPopulations().add(this);
        individuDansListe.setDateReexecution(Damj.min(individuDansListe.getDateReexecution(), dateReexecution));
      }
      setNombreIndividusSelectionnes(getNombreIndividusSelectionnes() + 1);
    }
    else
    {
      loguerErreurRecuperationIndividu(individu, codeAssedic);
    }
  }
  
  private void loguerErreurAjouterIndividu(Individu individu, String codeAssedic, ApplicativeRuntimeException ex)
  {
    String nomMethode = "ajouter";
    if (Log.isTraceActive(PopulationAbstraite.class, Niveau.ERROR))
    {
      Log.ecritTrace(Niveau.ERROR, PopulationAbstraite.class, nomMethode, "Appel BNI : Problème récupération IndividuPopulation sur le DE : " + individu.getNumeroAllocataire() + ", Pôle Emploi : " + codeAssedic);
      
      Log.ecritTrace(Niveau.ERROR, PopulationAbstraite.class, nomMethode, ex.getMessage());
    }
  }
  
  private boolean isNumeroAllocatairePresent(IndividuPopulationImpl individuPopulation)
  {
    return (individuPopulation != null) && (individuPopulation.getNumeroAllocataireRsin() != null) && (!"".equals(individuPopulation.getNumeroAllocataireRsin()));
  }
  
  private void loguerErreurRecuperationIndividu(Individu individu, String codeAssedic)
  {
    if (Log.isTraceActive(PopulationAbstraite.class, Niveau.ERROR)) {
      Log.ecritTrace(Niveau.ERROR, PopulationAbstraite.class, "ajouter", "Appel BNI : Problème récupération IndividuPopulation sur le DE : " + individu.getNumeroAllocataire() + ", Pôle emploi : " + codeAssedic);
    }
  }
  
  private IndividuSelection trouverIndividuDansLaListe(Collection<IndividuSelection> collIndividus, IndividuSelection individuSelection)
  {
    if ((collIndividus != null) && (!collIndividus.isEmpty())) {
      for (IndividuSelection individuCourant : collIndividus) {
        if (individuCourant.estIdentiqueA(individuSelection)) {
          return individuCourant;
        }
      }
    }
    return null;
  }
  
  private boolean isCodeAssedicConforme(IndividuPopulationImpl individuPopulation, String codeAssedic)
  {
    return (individuPopulation.getCodeAssedic() != null) && (!"".equals(individuPopulation.getCodeAssedic())) && (individuPopulation.getCodeAssedic().equals(codeAssedic));
  }
}

/* Location:
 * Qualified Name:     PopulationBatchCinqCles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
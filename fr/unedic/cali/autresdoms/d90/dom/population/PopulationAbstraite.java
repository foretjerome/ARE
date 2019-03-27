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
import fr.unedic.cali.autresdoms.d90.dom.comportement.ComportementBatchDefaut;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuId;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.persistance.util.ContextePersistance;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.Contexte;
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
import java.util.Iterator;
import java.util.List;
import org.apache.commons.lang.StringUtils;

public abstract class PopulationAbstraite
  implements PopulationSpec
{
  public static final int PRIORITE_DEFAUT = 0;
  private static final int PRIORITE_HABITUEL_OCCASIONNEL = 755;
  public static final String REQUETE_SELECTION_PLAGE_DE = "SELECT DISTINCT CXALAF FROM P1200A_INDIVIDU WHERE CXASS = ? ORDER BY CXALAF";
  private int id;
  private String topSelection;
  private int priorite;
  private int nombreIndividusSelectionnes;
  private String codeConsequenceSelection;
  private String libelle;
  private String numeroDSMS;
  private String consequenceFinanciereRecalcul;
  private String maxCodeConsequenceSelection;
  private ComportementSpec comportement;
  
  protected PopulationAbstraite() {}
  
  protected PopulationAbstraite(String libellePopulation)
  {
    setId(libellePopulation.hashCode());
    setTopSelection(" ");
    setPriorite(755);
    setNombreIndividusSelectionnes(0);
    setCodeConsequenceSelection(" ");
    setLibelle(libellePopulation);
    setConsequenceFinanciereRecalcul(" ");
    setMaxCodeConsequenceSelection(" ");
  }
  
  public int getId()
  {
    return id;
  }
  
  public boolean equals(Object elementComparaison)
  {
    if ((elementComparaison instanceof PopulationAbstraite))
    {
      PopulationAbstraite pop = (PopulationAbstraite)elementComparaison;
      return (id == pop.getId()) && (StringUtils.equals(topSelection, pop.getTopSelection())) && (priorite == pop.getPriorite()) && (nombreIndividusSelectionnes == pop.getNombreIndividusSelectionnes()) && (StringUtils.equals(codeConsequenceSelection, pop.getCodeConsequenceSelection())) && (StringUtils.equals(libelle, pop.getLibelle())) && (StringUtils.equals(numeroDSMS, pop.getNumeroDSMS())) && (StringUtils.equals(consequenceFinanciereRecalcul, pop.getConsequenceFinanciereRecalcul())) && (StringUtils.equals(maxCodeConsequenceSelection, pop.getMaxCodeConsequenceSelection()));
    }
    return false;
  }
  
  public int hashCode()
  {
    int prime = 31;
    int result = 1;
    result = 31 * result + id;
    result = 31 * result + priorite;
    result = 31 * result + nombreIndividusSelectionnes;
    result = 31 * result + (libelle == null ? 0 : libelle.hashCode());
    result = 31 * result + (topSelection == null ? 0 : topSelection.hashCode());
    result = 31 * result + (codeConsequenceSelection == null ? 0 : codeConsequenceSelection.hashCode());
    result = 31 * result + (numeroDSMS == null ? 0 : numeroDSMS.hashCode());
    result = 31 * result + (consequenceFinanciereRecalcul == null ? 0 : consequenceFinanciereRecalcul.hashCode());
    result = 31 * result + (maxCodeConsequenceSelection == null ? 0 : maxCodeConsequenceSelection.hashCode());
    return result;
  }
  
  public InfoReexecution estUnIndividuReexecutable(IndividuSpec individu, Damj dateReexecutionSelection)
    throws ApplicativeException
  {
    InfoReexecution infos = new InfoReexecution();
    infos.setExecutable(true);
    if (dateReexecutionSelection != null) {
      infos.setDateExecution(Damj.max(dateReexecutionSelection, PopulationSpec.DATE_LIMITE_NON_REEXECUTION));
    } else {
      infos.setDateExecution(PopulationSpec.DATE_LIMITE_NON_REEXECUTION);
    }
    return infos;
  }
  
  public InfoReexecution estAReexecuter(Contexte contexte)
    throws ApplicativeException
  {
    InfoReexecution infos = new InfoReexecution();
    infos.setExecutable(true);
    infos.setDateExecution(PopulationSpec.DATE_LIMITE_NON_REEXECUTION);
    return infos;
  }
  
  protected boolean estUneDemandeReliquidable(DemandeSpec demande)
  {
    boolean estReexecutable = true;
    if (demande.estMigree()) {
      estReexecutable = false;
    } else if (demande.getClassementAdministratif() != null) {
      estReexecutable = false;
    } else if ((demande.getDateExamen() == null) || (demande.getDateExamen().estAvant(DATE_LIMITE_NON_REEXECUTION))) {
      estReexecutable = false;
    } else if (!demande.estDecisionnee()) {
      estReexecutable = false;
    }
    return estReexecutable;
  }
  
  public ComportementSpec getComportement()
  {
    if (comportement == null) {
      comportement = new ComportementBatchDefaut();
    }
    return comportement;
  }
  
  protected void setComportement(ComportementSpec comportementSpec)
  {
    comportement = comportementSpec;
  }
  
  protected void setId(int id)
  {
    this.id = Math.abs(id);
  }
  
  public String getTopSelection()
  {
    return topSelection;
  }
  
  protected void setTopSelection(String topSelection)
  {
    this.topSelection = topSelection;
  }
  
  public int getPriorite()
  {
    return priorite;
  }
  
  protected void setPriorite(int priorite)
  {
    this.priorite = priorite;
  }
  
  public int getNombreIndividusSelectionnes()
  {
    return nombreIndividusSelectionnes;
  }
  
  protected void setNombreIndividusSelectionnes(int nombreIndividusSelectionnes)
  {
    this.nombreIndividusSelectionnes = nombreIndividusSelectionnes;
  }
  
  public String getCodeConsequenceSelection()
  {
    return codeConsequenceSelection;
  }
  
  protected void setCodeConsequenceSelection(String codeConsequenceSelection)
  {
    this.codeConsequenceSelection = codeConsequenceSelection;
  }
  
  public String getLibelle()
  {
    return libelle;
  }
  
  protected void setLibelle(String libelle)
  {
    this.libelle = libelle;
  }
  
  public String getNumeroDSMS()
  {
    return numeroDSMS;
  }
  
  protected void setNumeroDSMS(String numeroDSMS)
  {
    this.numeroDSMS = numeroDSMS;
  }
  
  public String getConsequenceFinanciereRecalcul()
  {
    return consequenceFinanciereRecalcul;
  }
  
  protected void setConsequenceFinanciereRecalcul(String consequenceFinanciereRecalcul)
  {
    this.consequenceFinanciereRecalcul = consequenceFinanciereRecalcul;
  }
  
  public String getMaxCodeConsequenceSelection()
  {
    return maxCodeConsequenceSelection;
  }
  
  protected void setMaxCodeConsequenceSelection(String maxCodeConsequenceSelection)
  {
    this.maxCodeConsequenceSelection = maxCodeConsequenceSelection;
  }
  
  public boolean estRequetable()
  {
    return true;
  }
  
  public boolean verifierAppartenance(Individu individu)
  {
    return true;
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
      logErreurAjouterIndividu(individu, codeAssedic, ex);
    }
    if ((estNumeroAllocatairePresent(individuPopulation)) && (estCodeAssedicConforme(individuPopulation, codeAssedic)) && (individuPopulation.getTopReferent().equalsIgnoreCase("O")))
    {
      individuSelection.setIdentifiantBNI(new BigDecimal(individu.getNumeroAllocataire()));
      individuSelection.setIdentifiantSigma(individuPopulation.getNumeroAllocataireRsin());
      individuSelection.setCodeAssedic(new DecimalFormat("000").format(Integer.parseInt(individuPopulation.getCodeAssedic())));
      individuSelection.setCodeAntenne(individuPopulation.getCodeAntenne());
      individuSelection.setDateReexecution(dateReexecution);
      individuSelection.setPopulation(this);
      
      IndividuSelection individuDansListe = trouverIndividuDansListe(individus, individuSelection);
      if (individuDansListe == null)
      {
        individus.add(individuSelection);
        individuSelection.getCollectionPopulations().add(this);
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
      logErreurRecuperationIndividu(individu, codeAssedic);
    }
  }
  
  private boolean estNumeroAllocatairePresent(IndividuPopulationImpl individuPopulation)
  {
    return (individuPopulation != null) && (individuPopulation.getNumeroAllocataireRsin() != null) && (!individuPopulation.getNumeroAllocataireRsin().equals(""));
  }
  
  private boolean estCodeAssedicConforme(IndividuPopulationImpl individuPopulation, String codeAssedic)
  {
    return (individuPopulation.getCodeAssedic() != null) && (!individuPopulation.getCodeAssedic().equals("")) && (individuPopulation.getCodeAssedic().equals(codeAssedic));
  }
  
  private void logErreurRecuperationIndividu(Individu individu, String codeAssedic)
  {
    if (Log.isTraceActive(PopulationAbstraite.class, Niveau.ERROR)) {
      Log.ecritTrace(Niveau.ERROR, PopulationAbstraite.class, "ajouter", "Appel BNI : Problème récupération IndividuPopulation sur le DE : " + individu.getNumeroAllocataire() + ", Pôle emploi : " + codeAssedic);
    }
  }
  
  private void logErreurAjouterIndividu(Individu individu, String codeAssedic, ApplicativeRuntimeException ex)
  {
    if (Log.isTraceActive(PopulationAbstraite.class, Niveau.ERROR))
    {
      Log.ecritTrace(Niveau.ERROR, PopulationAbstraite.class, "ajouter", "Appel BNI : Problème récupération IndividuPopulation sur le DE : " + individu.getNumeroAllocataire() + ", Pôle Emploi : " + codeAssedic);
      
      Log.ecritTrace(Niveau.ERROR, PopulationAbstraite.class, "ajouter", ex.getMessage());
    }
  }
  
  private IndividuSelection trouverIndividuDansListe(Collection<IndividuSelection> collIndividus, IndividuSelection individuSelection)
  {
    Iterator<IndividuSelection> it;
    if ((collIndividus != null) && (!collIndividus.isEmpty())) {
      for (it = collIndividus.iterator(); it.hasNext();)
      {
        IndividuSelection individuCourant = (IndividuSelection)it.next();
        if (individuCourant.estIdentiqueA(individuSelection)) {
          return individuCourant;
        }
      }
    }
    return null;
  }
  
  protected boolean contient(Collection<IndividuSelection> collIndividus, IndividuSelection individuSelection)
  {
    for (Iterator<IndividuSelection> it = collIndividus.iterator(); it.hasNext();) {
      if (((IndividuSelection)it.next()).estIdentiqueA(individuSelection)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean estIdentiqueA(PopulationAbstraite pop)
  {
    return pop != null;
  }
  
  public abstract Damj getDateReexecution(ResultSet paramResultSet, Individu paramIndividu)
    throws SQLException;
  
  public abstract String getRequete();
  
  public abstract void preparerStatement(PreparedStatement paramPreparedStatement, String paramString1, String paramString2, String paramString3, ContexteService paramContexteService)
    throws SQLException;
  
  public abstract Long getCxalaf(ResultSet paramResultSet)
    throws SQLException;
  
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
      boolean rsIsOpen = true;
      
      GestionnairePersistance gp = ContextePersistance.getGestionnairePersistance();
      gp.setValeurPartitionnement("numassedic", codeAssedic);
      while (rsIsOpen)
      {
        rsIsOpen = rs.next();
        if (rsIsOpen)
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
      closeConnection(connection, statement, rs);
    }
  }
  
  private void closeConnection(Connection connection, PreparedStatement statement, ResultSet rs)
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
  
  public String getRequeteSelectionPlageDe()
  {
    return "SELECT DISTINCT CXALAF FROM P1200A_INDIVIDU WHERE CXASS = ? ORDER BY CXALAF";
  }
  
  public boolean isEstAffichableIhmVisu()
  {
    return true;
  }
  
  public void chargerIndividu(Individu individu)
    throws ApplicativeException, TechniqueException
  {
    individu.chargerIndividuCohab();
    individu.chargerIndividuCali();
  }
}

/* Location:
 * Qualified Name:     PopulationAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
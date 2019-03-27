package fr.unedic.cali.parcours.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.contexte.ContexteDeploiement;
import fr.unedic.archi.logique.contexte.fournisseur._ContexteFournisseur;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.db.ConnectionFactory;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.CriteresTrancheDeVie;
import fr.unedic.cali.autresdoms.cohab.sigma.tranchedevie.dom.spec.InfoTrancheDeVieSpec;
import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.autresdoms.d90.dom.population.PopulationAbstraite;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.ResultatReexecutionManager;
import fr.unedic.cali.outilsfonctionnels.AppelServicesCojac;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.cali.parcours.ResultatVisualisationReexecution;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParcoursPopulationTraitementDB2
  extends ParcoursPopulationAbstraite
  implements ParcoursPopulationSpec
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatVisualisationReexecution resultatVisualisation = new ResultatVisualisationReexecution();
    
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    DomTraitementOccasionnel domTraitementOccasionnel = (DomTraitementOccasionnel)p_contexte.getDonnees();
    
    resultatVisualisation.setRedressementSpec(domTraitementOccasionnel.getRedressement());
    
    Damj dateReexecution = domTraitementOccasionnel.getDate();
    PopulationAbstraite population = (PopulationAbstraite)domTraitementOccasionnel.getPopulation();
    ComportementSpec comportement = definirComportement(population);
    alimenterResultatVisualisation(resultatVisualisation, new ResultatReexecutionManager(), domTraitementOccasionnel, comportement, dateReexecution);
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet rs = null;
    try
    {
      String requete = population.getRequete();
      
      ContexteDeploiement contexteDeploiement = _ContexteFournisseur.getContexteDeploiement();
      
      ConnectionFactory connectionFactory = contexteDeploiement.getConnectionFactory("NCPConnectionFactory");
      connection = connectionFactory.getConnection();
      
      statement = connection.prepareStatement(requete);
      population.preparerStatement(statement, domTraitementOccasionnel.getRedressement().getCodeAssedic(), "", "", domTraitementOccasionnel.getContexteService());
      
      statement.executeUpdate();
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
      resultatReexecutionCali.setEtat(0);
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
    resultatReexecutionCali.setFailure(false);
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursPopulationTraitementDB2 ********\n");
    }
    ecrireEnBaseVisu(resultatVisualisation, comportement);
    
    return resultatReexecutionCali;
  }
  
  private void alimenterResultatVisualisation(ResultatVisualisationReexecution p_resultatVisualisation, ResultatReexecutionManager p_resultatReexecutionManager, DomTraitementOccasionnel p_domReexecutionCali, ComportementSpec p_comportement, Damj p_dateReexecution)
    throws CoucheLogiqueException
  {
    if (p_comportement.isEcrireEnBaseVisu())
    {
      p_resultatVisualisation.setIndividu(p_resultatReexecutionManager.getIndividu());
      Individu individu = p_resultatVisualisation.getIndividu();
      if (individu != null)
      {
        individu.setRsin(p_domReexecutionCali.getContexteService().getRsin());
        individu.setCxala(p_domReexecutionCali.getContexteService().getCxala().toString());
        individu.setCxass(p_domReexecutionCali.getRedressement().getCodeAssedic());
        individu.setModeCreation("R");
        individu.setPopulation(p_domReexecutionCali.getPopulation());
        individu.setDateReexecution(p_dateReexecution);
        if (estIndividuCharge(p_domReexecutionCali.getIndividu()))
        {
          CriteresTrancheDeVie critere = new CriteresTrancheDeVie();
          critere.setCodeAssedic(individu.getCxass());
          critere.setIdentifiantNCP(individu.getCxala());
          try
          {
            individu.setAntenne(AppelServicesCojac.lectureTrancheDeVie(critere).getCodeAntenne());
          }
          catch (TechniqueException tE)
          {
            throw new ApplicativeRuntimeException("HG_PR_CALI_L_APPEL_CALI_GDP", "Problème lors de l'appel de service de CALI vers GDP", tE);
          }
        }
        else
        {
          individu.setAntenne("");
        }
      }
    }
  }
  
  private boolean estIndividuCharge(IndividuSpec p_individu)
  {
    boolean retour = true;
    try
    {
      p_individu.getCodeTransfert();
    }
    catch (UnsupportedOperationException ex)
    {
      retour = false;
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationTraitementDB2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
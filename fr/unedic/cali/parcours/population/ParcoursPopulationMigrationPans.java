package fr.unedic.cali.parcours.population;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.RedressementSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilPopulation;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.occasionnel.DomLireIndividusListe;
import fr.unedic.cali.outilsfonctionnels.LireBaseVisu;
import fr.unedic.cali.outilsfonctionnels.OutilComparaisonIndividuVisu;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologieDebuts;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class ParcoursPopulationMigrationPans
  extends ParcoursPopulationAbstraite
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    String etatIndividu = null;
    Individu individuVisuApresMigrationPans = null;
    ResultatComparaison resultat = null;
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)p_contexte.getDonnees();
    IndividuSpec individu = domReexecutionCali.getIndividu();
    if (estPresenceReexamen(individu)) {
      etatIndividu = "R";
    } else {
      try
      {
        resultatReexecutionCali = effectuerReexecution(p_contexte);
        individuVisuApresMigrationPans = resultatReexecutionCali.getIndividuVisu();
        
        DomLireIndividusListe individuVisuAvantMigrationPans = recupererIndividuVisuAvantMigration(p_contexte);
        resultat = OutilComparaisonIndividuVisu.comparerReexecution(individuVisuAvantMigrationPans, individuVisuApresMigrationPans);
        
        etatIndividu = OutilComparaisonIndividuVisu.determinerEtatIndividu(resultat);
      }
      catch (ApplicativeException ex)
      {
        etatIndividu = "K";
      }
      catch (TechniqueException ex)
      {
        etatIndividu = "K";
      }
    }
    Individu individuVisuComparaison = new Individu();
    if ((resultat != null) && (resultat.getDemandeVisu() != null)) {
      individuVisuComparaison.ajouterDemande(resultat.getDemandeVisu());
    }
    OutilComparaisonIndividuVisu.inscrireIndividuDansPopulationDefinitive(p_contexte, individuVisuComparaison, individuVisuApresMigrationPans, etatIndividu, "11SI1_GAEC_MIGRATION_PANS_3");
    
    resultatReexecutionCali.setEtat(0);
    return resultatReexecutionCali;
  }
  
  private ResultatReexecutionCali effectuerReexecution(Contexte p_contexte)
    throws ApplicativeException
  {
    ParcoursPopulationReexecution parcours = new ParcoursPopulationReexecution();
    ResultatReexecutionCali resultat = (ResultatReexecutionCali)parcours.demarrer(p_contexte);
    return resultat;
  }
  
  private DomLireIndividusListe recupererIndividuVisuAvantMigration(Contexte p_contexte)
    throws TechniqueException, CoucheLogiqueException
  {
    DomLireIndividusListe individu = null;
    
    DomTraitementOccasionnel domTraitementOccasionnel = (DomTraitementOccasionnel)p_contexte.getDonnees();
    
    List individus = LireBaseVisu.chargerIndividus(domTraitementOccasionnel.getRedressement().getCodeAssedic(), new BigDecimal(domTraitementOccasionnel.getRedressement().getIdentifiantRapport()), getIdentifiantPopulation("11SI1_GAEC_MIGRATION_PANS_1"), domTraitementOccasionnel.getContexteService().getRsin(), false, false, false, false, false, false, null, 1, 2, domTraitementOccasionnel.getRedressement().getModeRedressement());
    if (!individus.isEmpty()) {
      individu = (DomLireIndividusListe)individus.get(0);
    } else {
      throw new CoucheLogiqueException("CALI_INDIVIDU_POP_1_ASBENT", "Impossible de retrouver l'individu visu de la population 11SI1_GAEC_MIGRATION_PANS_1");
    }
    return individu;
  }
  
  private String getIdentifiantPopulation(String p_libellePopulation)
    throws CoucheLogiqueException
  {
    return Integer.toString(Math.abs(OutilPopulation.getPopulation(p_libellePopulation).getId()));
  }
  
  private boolean estPresenceReexamen(IndividuSpec p_individu)
  {
    ChronologieDebuts demandes = p_individu.getChronoDemandes();
    Iterator it = demandes.iterer();
    while (it.hasNext())
    {
      DemandeSpec demandecourante = (DemandeSpec)it.next();
      if (demandecourante.estEnReExamen()) {
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationMigrationPans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
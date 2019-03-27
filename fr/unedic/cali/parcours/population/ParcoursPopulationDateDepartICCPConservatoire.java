package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.outilsfonctionnels.GestionIndicateurs;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import java.util.ArrayList;

public class ParcoursPopulationDateDepartICCPConservatoire
  extends ParcoursPopulationReexecution
{
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)contexte.getDonnees();
    IndividuSpec individu = domReexecutionCali.getIndividu();
    Chronologie demandesAsu = individu.getChronoDemandeAssurance();
    
    GammeAsu gameAsu = GammeAsu.getInstance();
    demandesAsu.iterer();
    while (demandesAsu.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)demandesAsu.elementSuivant();
      if (demande.estDecisionnee())
      {
        CriteresTraitementPopulation criteres = new CriteresTraitementPopulation();
        criteres.setIndividu(getIndividu(contexte));
        criteres.setNomPopulation("15SI3CALI_ICCP_CONSERVATOIRE");
        ArrayList<DemandeSpec> parametres = new ArrayList();
        parametres.add(demande);
        criteres.setParametres(parametres);
        
        gameAsu.effectuerTraitementOccasionnel(criteres);
      }
    }
    super.demarrer(contexte);
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    resultatReexecutionCali.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(individu, null));
    
    return resultatReexecutionCali;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationDateDepartICCPConservatoire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
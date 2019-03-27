package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ParcoursPopulationActionFormationLiee
  extends ParcoursPopulationAbstraite
  implements ParcoursPopulationSpec
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)p_contexte.getDonnees();
    IndividuSpec individu = domReexecutionCali.getIndividu();
    
    CriteresTraitementPopulation criteres = new CriteresTraitementPopulation();
    criteres.setIndividu(individu);
    criteres.setNomPopulation(domReexecutionCali.getPopulation().getLibelle());
    
    Iterator iterateurDemandes = individu.getDemandes().iterator();
    while (iterateurDemandes.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterateurDemandes.next();
      
      criteres.getParametres().clear();
      criteres.getParametres().add(demande);
      demande.getGamme().effectuerTraitementOccasionnel(criteres);
    }
    IndicateursGeneriques listeIndicateurs = new IndicateursGeneriques();
    resultatReexecutionCali.setIndicateursGeneriques(listeIndicateurs);
    
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    return resultatReexecutionCali;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationActionFormationLiee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
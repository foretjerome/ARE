package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitSolSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesAer;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreNegation;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreOD;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;

public class ParcoursPopulationPFM
  extends ParcoursPopulationAbstraite
  implements ParcoursPopulationSpec
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)p_contexte.getDonnees();
    
    IndividuSpec individu = domReexecutionCali.getIndividu();
    
    Chronologie chronoDemandesSol = individu.getChronoDemandeSolidarite();
    
    Chronologie chronoDemandeSolOD = chronoDemandesSol.copier(new FiltreOD());
    
    Chronologie chronoDemandeASSOD = chronoDemandeSolOD.copier(new FiltreNegation(new FiltreDemandesAer()));
    
    chronoDemandeASSOD.iterer();
    while (chronoDemandeASSOD.encoreSuivant())
    {
      DemandeSpec demandeCourante = (DemandeSpec)chronoDemandeASSOD.elementSuivant();
      DossierExamenSpec dossEx = demandeCourante.getDossierAffectation().getDossierExamen();
      if ((dossEx instanceof DecisionSpec))
      {
        DecisionSpec decision = (DecisionSpec)dossEx;
        if (decision.getDossierAffecte() != null)
        {
          DossierAffectationSpec dossierAffectation = decision.getDossierAffecte();
          if (dossierAffectation.getProduit() != null)
          {
            ProduitSolSpec produitSol = (ProduitSolSpec)dossierAffectation.getProduit();
            produitSol.installerPrimes(demandeCourante);
          }
        }
      }
    }
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    return resultatReexecutionCali;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationPFM
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P04;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.outilsfonctionnels.GestionIndicateurs;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import java.util.ArrayList;

public class ParcoursPopulationPreavisLegalFinancement
  extends ParcoursPopulationAbstraite
{
  public Resultat demarrer(Contexte contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultat = new ResultatReexecutionCali();
    
    Chronologie demandesAsu = getIndividu(contexte).getChronoDemandeAssurance();
    demandesAsu.iterer();
    while (demandesAsu.encoreSuivant())
    {
      DemandeSpec demande = (DemandeSpec)demandesAsu.elementSuivant();
      if ((OutilDemande.estUneDemandeAtp(demande)) && (demande.estDecisionnee()))
      {
        CriteresTraitementPopulation criteres = new CriteresTraitementPopulation();
        criteres.setIndividu(getIndividu(contexte));
        criteres.setNomPopulation("11SI1CALI_PREAVIS_LEGAL_FINANCEMENT");
        ArrayList parametres = new ArrayList();
        parametres.add(demande);
        criteres.setParametres(parametres);
        ProduitAsuCge01P04.getInstance().effectuerTraitementOccasionnel(criteres);
      }
    }
    resultat.setEtat(0);
    resultat.setFailure(false);
    resultat.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(getIndividu(contexte), null));
    return resultat;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationPreavisLegalFinancement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
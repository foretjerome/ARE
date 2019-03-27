package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.services.AppelServicesGaec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.GestionIndicateurs;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ParcoursPopulationAbonnnementGaec
  extends ParcoursPopulationAbstraite
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    
    DomTraitementOccasionnel domTraitementOccasionnel = (DomTraitementOccasionnel)p_contexte.getDonnees();
    IndividuSpec individu = domTraitementOccasionnel.getIndividu();
    
    effectuerTraitement(p_contexte);
    
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    resultatReexecutionCali.setIndicateursGeneriques(GestionIndicateurs.creerIndicateurs(individu, null));
    return resultatReexecutionCali;
  }
  
  private void effectuerTraitement(Contexte p_contexte)
    throws ApplicativeException
  {
    AppelServicesGaec.enregistrerAbonnementGaec(p_contexte);
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationAbonnnementGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
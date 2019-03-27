package fr.unedic.cali.parcours.population;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateAttributionEtPrioriteDemande;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.cali.parcours.ResultatReexecutionCali;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParcoursPopulationMigreeNumeroConventionGestion
  extends ParcoursPopulationAbstraite
  implements ParcoursPopulationSpec
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatReexecutionCali resultatReexecutionCali = new ResultatReexecutionCali();
    
    DomTraitementOccasionnel domReexecutionCali = (DomTraitementOccasionnel)p_contexte.getDonnees();
    
    IndividuSpec individu = domReexecutionCali.getIndividu();
    
    List attributionsASU = individu.getListeAttributionsASUPendantPeriode(new Periode(Damj.NUIT_DES_TEMPS, Damj.FIN_DES_TEMPS));
    
    List demandesASU = new ArrayList();
    if (attributionsASU != null)
    {
      Iterator it = attributionsASU.iterator();
      AttributionSpec attribution = null;
      while (it.hasNext())
      {
        attribution = (AttributionSpec)it.next();
        
        demandesASU.add(attribution.getDemande());
      }
      ChronologieDebuts chronoDemandesAsu = new ChronologieDebuts();
      chronoDemandesAsu.setComparateur(new ComparateurSurDateAttributionEtPrioriteDemande());
      chronoDemandesAsu.ajouter(demandesASU);
      
      it = chronoDemandesAsu.iterer();
      DemandeSpec demande = null;
      AttributionSpec attributionSpec = null;
      while (it.hasNext())
      {
        demande = (DemandeSpec)it.next();
        attributionSpec = (AttributionSpec)demande.getDossierAffectation().getDossierExamen();
        
        ((ProduitAsuSpec)attributionSpec.getProduit()).installerCompetenceConventionGestion(attributionSpec);
      }
    }
    IndicateursGeneriques listeIndicateurs = new IndicateursGeneriques();
    resultatReexecutionCali.setIndicateursGeneriques(listeIndicateurs);
    
    resultatReexecutionCali.setEtat(0);
    resultatReexecutionCali.setFailure(false);
    return resultatReexecutionCali;
  }
}

/* Location:
 * Qualified Name:     ParcoursPopulationMigreeNumeroConventionGestion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
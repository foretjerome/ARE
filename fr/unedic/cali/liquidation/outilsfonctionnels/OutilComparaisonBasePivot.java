package fr.unedic.cali.liquidation.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.Demande;
import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.cali.parcours.ResultatVisualisationReexecution;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class OutilComparaisonBasePivot
{
  public static Map getCopieDemandesPivots(Collection p_listeDemandes)
  {
    Map copieDemandes = new HashMap();
    Iterator iterDemandes = p_listeDemandes.iterator();
    while (iterDemandes.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterDemandes.next();
      if (demande.getDemandePivot() != null) {
        copieDemandes.put(demande.getIdentifiant(), demande.getDemandePivot().copie());
      }
    }
    return copieDemandes;
  }
  
  public static void comparerDemandes(Map p_demandesAvantTraitement, Collection p_demandesApresTraitement, ResultatVisualisationReexecution p_resultatVisualisationReexecution)
    throws ApplicativeException
  {
    Iterator iterDemandesImpactees = p_demandesApresTraitement.iterator();
    while (iterDemandesImpactees.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterDemandesImpactees.next();
      Demande demandeVisu = p_resultatVisualisationReexecution.getIndividu().getDemande(demande.getIdentifiant());
      if ((demandeVisu != null) && (demande.getDemandePivot() != null) && (!demandeVisu.getEtatReexamen().equals("R")))
      {
        DemandePivot demandePivotApresTraitement = demande.getDemandePivot();
        DemandePivot demandePivotAvantTraitement = (DemandePivot)p_demandesAvantTraitement.get(demande.getIdentifiant());
        if (demandePivotAvantTraitement != null)
        {
          Collection listeEcartsBases = demandePivotAvantTraitement.comparer(demandePivotApresTraitement);
          
          demandeVisu.setListeEcartsBases(listeEcartsBases);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     OutilComparaisonBasePivot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
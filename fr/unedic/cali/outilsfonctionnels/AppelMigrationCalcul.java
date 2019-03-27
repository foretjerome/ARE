package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.DomCalculPilotage;
import fr.unedic.cali.parcours.ParcoursCalculPilotageMigration;
import fr.unedic.cali.parcours.ResultatPilotage;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppelMigrationCalcul
{
  public static Resultat effectuerCalcul(IndividuSpec p_individu, List p_listeAttributions, Damj p_dateDebutExecution, Damj p_dateArretExecution, boolean p_estPersistant)
    throws ApplicativeException
  {
    ResultatPilotage resultatPilotage = null;
    if (!p_listeAttributions.isEmpty())
    {
      AppelAvant.executerAvant(p_listeAttributions, p_dateDebutExecution);
      if (!p_listeAttributions.isEmpty())
      {
        Contexte contexteCalcul = null;
        DomCalculPilotage domCalcul = null;
        Parcours parcoursCalcul = null;
        
        domCalcul = new DomCalculPilotage();
        domCalcul.setIndividu(p_individu);
        domCalcul.setDateDebutExecution(p_dateDebutExecution);
        domCalcul.setExecutionPersistante(p_estPersistant);
        domCalcul.setDateArretExecution(p_dateArretExecution);
        domCalcul.setContexteService(p_individu.getContexteService());
        domCalcul.setListeAttributions(filtrerListeAttributions(p_listeAttributions));
        contexteCalcul = new Contexte();
        contexteCalcul.setDonnees(domCalcul);
        parcoursCalcul = new ParcoursCalculPilotageMigration();
        resultatPilotage = (ResultatPilotage)parcoursCalcul.effectuerParcours(contexteCalcul);
      }
    }
    return resultatPilotage;
  }
  
  private static List filtrerListeAttributions(List p_listeAttributions)
  {
    AttributionSpec attribution = null;
    
    List listeAttribution = new ArrayList();
    
    Iterator it = p_listeAttributions.iterator();
    while (it.hasNext())
    {
      attribution = (AttributionSpec)it.next();
      if (!listeAttribution.contains(attribution)) {
        listeAttribution.add(attribution);
      }
    }
    return listeAttribution;
  }
}

/* Location:
 * Qualified Name:     AppelMigrationCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
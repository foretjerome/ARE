package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.ComportementExamenFilEau;
import fr.unedic.cali.dom.ComportementExamenFilEauSpec;
import java.util.HashMap;
import java.util.Map;

public class OutilComportementExamenFilEau
{
  private static Map s_listeComportements = new HashMap();
  private static boolean s_estListeInitialisee = false;
  
  private static void inscrireElements()
  {
    ComportementExamenFilEauSpec comportementAuto = getInstanceComportement(ComportementExamenFilEauSpec.ID_COMPORTEMENT_EFE_AUTO);
    comportementAuto.setLibelleComportement("Comportement examen au fil de l'eau automatique");
    comportementAuto.setCalculAffiliationSimplifieeActif(true);
    comportementAuto.setModeSimulationActif(false);
    comportementAuto.setNombreMaximumFctATraiter(10);
    inscrireElement(comportementAuto);
    
    ComportementExamenFilEauSpec comportementManuel = getInstanceComportement(ComportementExamenFilEauSpec.ID_COMPORTEMENT_EFE_MANUEL);
    comportementManuel.setLibelleComportement("Comportement examen au fil de l'eau manuel");
    comportementManuel.setCalculAffiliationSimplifieeActif(false);
    comportementManuel.setModeSimulationActif(true);
    comportementManuel.setNombreMaximumFctATraiter(1);
    inscrireElement(comportementManuel);
  }
  
  private static ComportementExamenFilEauSpec getInstanceComportement(Integer p_identifiantComportement)
  {
    return new ComportementExamenFilEau(p_identifiantComportement);
  }
  
  private static void inscrireElement(ComportementExamenFilEauSpec p_comportement)
  {
    if (p_comportement != null) {
      s_listeComportements.put(p_comportement.getIdentifiantComportement(), p_comportement);
    }
  }
  
  private static ComportementExamenFilEauSpec getComportement(Integer p_idComportement)
  {
    ComportementExamenFilEauSpec comportement = null;
    if (p_idComportement != null)
    {
      if (!s_estListeInitialisee)
      {
        inscrireElements();
        s_estListeInitialisee = true;
      }
      comportement = (ComportementExamenFilEauSpec)s_listeComportements.get(p_idComportement);
    }
    return comportement;
  }
  
  public static ComportementExamenFilEauSpec getComportementAutomatique()
  {
    return getComportement(ComportementExamenFilEauSpec.ID_COMPORTEMENT_EFE_AUTO);
  }
  
  public static ComportementExamenFilEauSpec getComportementManuel()
  {
    return getComportement(ComportementExamenFilEauSpec.ID_COMPORTEMENT_EFE_MANUEL);
  }
}

/* Location:
 * Qualified Name:     OutilComportementExamenFilEau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
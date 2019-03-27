package fr.pe.cali.crem.outils;

import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.temps.Chronologie;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CacheCrem
{
  private Map<String, ObjetMetierCrem> cremDalLiquidation = new HashMap();
  private Map<String, ObjetMetierCrem> cremDecisionLiquidation = new HashMap();
  
  public void sauvegarderCremDalLiquidation(Chronologie chronoDemandes)
    throws ApplicativeException
  {
    Iterator<?> iterer = chronoDemandes.iterer();
    while (iterer.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterer.next();
      OutilGenerationObjetMetierDalLiquidation outilGeneration = getOutilGenerationDal();
      ObjetMetierCrem crem = outilGeneration.genererObjetMetier(demande, demande.getDemandeur().getContexteService(), false);
      if (crem != null) {
        getCremDalLiquidation().put(crem.getIdentifiant(), crem);
      }
    }
  }
  
  public void sauvegarderCremDecisionLiquidation(Chronologie chronoDemandes)
    throws ApplicativeException
  {
    Iterator<?> iterer = chronoDemandes.iterer();
    while (iterer.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)iterer.next();
      OutilGenerationObjetMetierDecisionLiquidation outilGeneration = getOutilGenerationDecision();
      ObjetMetierCrem crem = outilGeneration.genererObjetMetier(demande, demande.getDemandeur().getContexteService(), false);
      if (crem != null) {
        getCremDecisionLiquidation().put(crem.getIdentifiant(), crem);
      }
    }
  }
  
  public ObjetMetierCrem recupererCremDal(String idObjetMetier)
  {
    return (ObjetMetierCrem)getCremDalLiquidation().get(idObjetMetier);
  }
  
  public ObjetMetierCrem recupererCremDecision(String idObjetMetier)
  {
    return (ObjetMetierCrem)getCremDecisionLiquidation().get(idObjetMetier);
  }
  
  protected OutilGenerationObjetMetierDecisionLiquidation getOutilGenerationDecision()
  {
    return OutilGenerationObjetMetierDecisionLiquidation.getInstance();
  }
  
  protected OutilGenerationObjetMetierDalLiquidation getOutilGenerationDal()
  {
    return OutilGenerationObjetMetierDalLiquidation.getInstance();
  }
  
  private Map<String, ObjetMetierCrem> getCremDalLiquidation()
  {
    return cremDalLiquidation;
  }
  
  private Map<String, ObjetMetierCrem> getCremDecisionLiquidation()
  {
    return cremDecisionLiquidation;
  }
}

/* Location:
 * Qualified Name:     CacheCrem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
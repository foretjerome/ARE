package fr.unedic.cali.parcours;

import fr.unedic.cali.avant.FacadeAvantProduitFactory;
import fr.unedic.cali.avant.FacadeAvantProduitSpec;
import fr.unedic.cali.calcul.TraitementAvant;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Dom;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public abstract class ParcoursAvantPilotage
  extends ParcoursCali
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    Dom dom = null;
    if (p_contexte == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE_ABSENT", "Le contexte ne doit pas être null", null);
    }
    dom = p_contexte.getDonnees();
    if (dom == null) {
      throw new ContexteException("HG_PR_CALI_L_CONTEXTE_ABSENCE_DOM", "Le Dom ne doit pas être null.", null);
    }
    if (!(dom instanceof DomAvantPilotage)) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CONTEXTE", "Le type de Dom attendu est: DomAvantPilotage", null);
    }
  }
  
  public final Resultat demarrer(Contexte p_contexte)
    throws CoucheLogiqueException
  {
    ResultatAvant retour = null;
    DomAvantPilotage domAvantPilotage = null;
    FacadeAvantProduitSpec facadeAvantProduitSpec = null;
    
    domAvantPilotage = (DomAvantPilotage)p_contexte.getDonnees();
    try
    {
      facadeAvantProduitSpec = FacadeAvantProduitFactory.getInstance().getInstanceFacadeAvantProduit(domAvantPilotage.getProduit());
    }
    catch (CoucheLogiqueException e)
    {
      AttributionSpec attribution = domAvantPilotage.getAttributionAEtudier();
      Damj dateAttribution = null;
      if (attribution != null) {
        dateAttribution = attribution.getDateAttribution();
      } else {
        dateAttribution = domAvantPilotage.getDateAttribution();
      }
      retour = new ResultatAvant(dateAttribution, null, false);
      retour.setEtat(0);
    }
    if (facadeAvantProduitSpec != null)
    {
      AttributionSpec attribution = domAvantPilotage.getAttributionAEtudier();
      if (attribution == null) {
        retour = facadeAvantProduitSpec.executerAvant(domAvantPilotage.getIndividu(), domAvantPilotage.getDateAttribution(), domAvantPilotage.getProduit(), domAvantPilotage.getDelaisReport(), domAvantPilotage.getCarences());
      } else if (facadeAvantProduitSpec.estUnProduitGerantLaRefonte()) {
        retour = TraitementAvant.executerAvant(domAvantPilotage.getAttributionAEtudier(), domAvantPilotage.isAvecPriseEnCompteEvenement(), domAvantPilotage.getDateArretExecution(), domAvantPilotage.isExecutionPersistante());
      } else {
        retour = facadeAvantProduitSpec.executerAvant(domAvantPilotage.getAttributionAEtudier(), domAvantPilotage.isAvecPriseEnCompteEvenement(), domAvantPilotage.getDateArretExecution(), domAvantPilotage.isExecutionPersistante());
      }
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     ParcoursAvantPilotage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
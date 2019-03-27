package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.calcul.FacadeCalculProduitFactory;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.PoursuiteSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class OutilGestionPoursuite
{
  public static OutilGestionPoursuite getInstance()
  {
    return new OutilGestionPoursuite();
  }
  
  public Damj recupererPremierJourExecutableNcp(AttributionSpec p_attribution)
    throws CoucheLogiqueException
  {
    FacadeCalculProduitSpec facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(p_attribution.getProduitExecution());
    
    return facadeCalculProduit.recupererPremierJourExecutableNcp(p_attribution);
  }
  
  public Damj recupererDateAttributionOuPjpSiPoursuite(AttributionSpec p_attribution)
  {
    if ((p_attribution instanceof PoursuiteSpec)) {
      return ((PoursuiteSpec)p_attribution).getPjp();
    }
    return p_attribution.getDateAttribution();
  }
}

/* Location:
 * Qualified Name:     OutilGestionPoursuite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.pnds;

import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;

public class CachePndsSpectacle
{
  private List<ElementCachePndsSpectacle> cache = new ArrayList();
  
  public void ajouterQuantiteRemunerationActiviteDeclaree(Periode moisCivil, QuantiteEuro quantiteRemuneration)
  {
    recupererElement(moisCivil).setQuantiteRemunerationsActivitesDeclarees(quantiteRemuneration);
  }
  
  public QuantiteEuro recupererQuantiteRemunerationActiviteDeclaree(Periode moisCivil)
  {
    return recupererElement(moisCivil).getQuantiteRemunerationsActivitesDeclarees();
  }
  
  public void ajouterQuantiteRemunerationJustifiee(Periode moisCivil, QuantiteEuro quantiteRemuneration)
  {
    recupererElement(moisCivil).setQuantiteRemunerationsJustifiees(quantiteRemuneration);
  }
  
  public QuantiteEuro recupererQuantiteRemunerationJustifiee(Periode moisCivil)
  {
    return recupererElement(moisCivil).getQuantiteRemunerationsJustifiees();
  }
  
  private ElementCachePndsSpectacle recupererElement(Periode moisCivil)
  {
    ElementCachePndsSpectacle elementARetourner = null;
    for (ElementCachePndsSpectacle elementCourant : cache) {
      if (elementCourant.estIdentique(moisCivil))
      {
        elementARetourner = elementCourant;
        break;
      }
    }
    if (elementARetourner == null)
    {
      elementARetourner = new ElementCachePndsSpectacle(moisCivil);
      cache.add(elementARetourner);
    }
    return elementARetourner;
  }
}

/* Location:
 * Qualified Name:     CachePndsSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
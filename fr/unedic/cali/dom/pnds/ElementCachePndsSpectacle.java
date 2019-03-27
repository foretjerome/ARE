package fr.unedic.cali.dom.pnds;

import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Periode;

class ElementCachePndsSpectacle
{
  private Periode moisCivil = null;
  private QuantiteEuro quantiteRemunerationsActivitesDeclarees = null;
  private QuantiteEuro quantiteRemunerationsJustifiees = null;
  
  public ElementCachePndsSpectacle(Periode moisCivil)
  {
    this.moisCivil = new Periode(moisCivil.getDebut(), moisCivil.getFin());
  }
  
  public QuantiteEuro getQuantiteRemunerationsActivitesDeclarees()
  {
    return quantiteRemunerationsActivitesDeclarees;
  }
  
  public void setQuantiteRemunerationsActivitesDeclarees(QuantiteEuro quantiteRemunerationsActivitesDeclarees)
  {
    this.quantiteRemunerationsActivitesDeclarees = quantiteRemunerationsActivitesDeclarees;
  }
  
  public QuantiteEuro getQuantiteRemunerationsJustifiees()
  {
    return quantiteRemunerationsJustifiees;
  }
  
  public void setQuantiteRemunerationsJustifiees(QuantiteEuro quantiteRemunerationsJustifiees)
  {
    this.quantiteRemunerationsJustifiees = quantiteRemunerationsJustifiees;
  }
  
  public boolean estIdentique(Periode periode)
  {
    return moisCivil.compareTo(periode) == 0;
  }
}

/* Location:
 * Qualified Name:     ElementCachePndsSpectacle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.autresdoms.d12i.dom;

import fr.unedic.cali.autresdoms.d12i.spec.DonneesDALSpec;
import fr.unedic.util.temps.Damj;

public class DonneesDAL
  implements DonneesDALSpec
{
  private int categorie = 0;
  private boolean finDeDroit = false;
  private boolean estBrouillon = false;
  private String refusPropositionFNE = " ";
  private String topPropositionCSP = "N";
  private Boolean topPropositionPAP = Boolean.valueOf(false);
  private Damj dernierJourAtteste;
  
  public boolean estTopFinDeDroit()
  {
    return finDeDroit;
  }
  
  public void setTopFinDeDroit(boolean finDeDroit)
  {
    this.finDeDroit = finDeDroit;
  }
  
  public int getCategorieParticuliere()
  {
    return categorie;
  }
  
  public void setCategorieParticuliere(int categorie)
  {
    this.categorie = categorie;
  }
  
  public boolean estBrouillon()
  {
    return estBrouillon;
  }
  
  public void setBrouillon(boolean estBrouillon)
  {
    this.estBrouillon = estBrouillon;
  }
  
  public String getRefusPropositionFNE()
  {
    return refusPropositionFNE;
  }
  
  public void setRefusPropositionFNE(String refusPropositionFNE)
  {
    this.refusPropositionFNE = refusPropositionFNE;
  }
  
  public String getTopPropositionCSP()
  {
    return topPropositionCSP;
  }
  
  public void setTopPropositionCSP(String topPropositionCSP)
  {
    this.topPropositionCSP = topPropositionCSP;
  }
  
  public Boolean estTopPropositionPAP()
  {
    return topPropositionPAP;
  }
  
  public void setTopPropositionPAP(Boolean topPropositionPAP)
  {
    this.topPropositionPAP = topPropositionPAP;
  }
  
  public Damj getDernierJourAtteste()
  {
    return dernierJourAtteste;
  }
  
  public void setDernierJourAtteste(Damj dernierJourAtteste)
  {
    this.dernierJourAtteste = dernierJourAtteste;
  }
}

/* Location:
 * Qualified Name:     DonneesDAL
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.autresdoms.dmc.dom.aides.web;

import java.util.List;

public class DomReceptionFluxWebMob
  extends DomReceptionFluxWebAbstrait
{
  private List<PeriodeAideMobilite> periodesAide;
  private String gareAllerDepart;
  private String gareAllerArrivee;
  private String regionGareDepart;
  private String regionGareArrivee;
  
  public List<PeriodeAideMobilite> getPeriodesAide()
  {
    return periodesAide;
  }
  
  public void setPeriodesAide(List<PeriodeAideMobilite> periodesAide)
  {
    this.periodesAide = periodesAide;
  }
  
  public String getGareAllerDepart()
  {
    return gareAllerDepart;
  }
  
  public void setGareAllerDepart(String allerGareDepart)
  {
    gareAllerDepart = allerGareDepart;
  }
  
  public String getGareAllerArrivee()
  {
    return gareAllerArrivee;
  }
  
  public void setGareAllerArrivee(String allerGareArrivee)
  {
    gareAllerArrivee = allerGareArrivee;
  }
  
  public String getRegionGareDepart()
  {
    return regionGareDepart;
  }
  
  public void setRegionGareDepart(String regionGareDepart)
  {
    this.regionGareDepart = regionGareDepart;
  }
  
  public String getRegionGareArrivee()
  {
    return regionGareArrivee;
  }
  
  public void setRegionGareArrivee(String regionGareArrivee)
  {
    this.regionGareArrivee = regionGareArrivee;
  }
}

/* Location:
 * Qualified Name:     DomReceptionFluxWebMob
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
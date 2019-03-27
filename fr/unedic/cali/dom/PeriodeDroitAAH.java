package fr.unedic.cali.dom;

import fr.unedic.util.temps.Periode;

public class PeriodeDroitAAH
{
  private Periode periodeDroit;
  private String typeDebut;
  private String typeFin;
  
  public PeriodeDroitAAH(Periode periodeDroitAAh, String typeDebut, String typeFin)
  {
    periodeDroit = periodeDroitAAh;
    this.typeDebut = typeDebut;
    this.typeFin = typeFin;
  }
  
  public PeriodeDroitAAH(Periode periodeDroit)
  {
    this.periodeDroit = periodeDroit;
  }
  
  public Periode getPeriodeDroit()
  {
    return periodeDroit;
  }
  
  public void setPeriodeDroit(Periode periodeDroit)
  {
    this.periodeDroit = periodeDroit;
  }
  
  public String getTypeDebut()
  {
    return typeDebut;
  }
  
  public void setTypeDebut(String typedebut)
  {
    typeDebut = typedebut;
  }
  
  public String getTypeFin()
  {
    return typeFin;
  }
  
  public void setTypeFin(String typefin)
  {
    typeFin = typefin;
  }
}

/* Location:
 * Qualified Name:     PeriodeDroitAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
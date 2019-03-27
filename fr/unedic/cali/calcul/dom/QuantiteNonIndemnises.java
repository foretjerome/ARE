package fr.unedic.cali.calcul.dom;

import fr.unedic.util.temps.Damj;

public class QuantiteNonIndemnises
{
  private Damj dateDebut;
  private int quantiteFranchiseCP;
  private int quantiteFranchiseS;
  private int quantiteDA;
  private int quantiteReportCP;
  private int quantiteReportS;
  private boolean daTraiteEnDebutUT;
  
  public void setDateDebut(Damj dateDebut)
  {
    this.dateDebut = dateDebut;
  }
  
  public Damj getDateDebut()
  {
    return dateDebut;
  }
  
  public int getQuantiteFranchiseCP()
  {
    return quantiteFranchiseCP;
  }
  
  public void setQuantiteFranchiseCP(int quantiteFranchiseCP)
  {
    this.quantiteFranchiseCP = quantiteFranchiseCP;
  }
  
  public int getQuantiteFranchiseSalaire()
  {
    return quantiteFranchiseS;
  }
  
  public void setQuantiteFranchiseSalaire(int quantiteFranchiseS)
  {
    this.quantiteFranchiseS = quantiteFranchiseS;
  }
  
  public int getQuantiteDelaiAttente()
  {
    return quantiteDA;
  }
  
  public void setQuantiteDelaiAttente(int quantiteDA)
  {
    this.quantiteDA = quantiteDA;
  }
  
  public int getQuantiteReportCP()
  {
    return quantiteReportCP;
  }
  
  public void setQuantiteReportCP(int quantiteReportCP)
  {
    this.quantiteReportCP = quantiteReportCP;
  }
  
  public int getQuantiteReportSalaire()
  {
    return quantiteReportS;
  }
  
  public void setQuantiteReportSalaire(int quantiteReportS)
  {
    this.quantiteReportS = quantiteReportS;
  }
  
  public boolean isDaTraiteEnDebutUT()
  {
    return daTraiteEnDebutUT;
  }
  
  public void setDaTraiteEnDebutUT(boolean daTraiteEnDebutUT)
  {
    this.daTraiteEnDebutUT = daTraiteEnDebutUT;
  }
}

/* Location:
 * Qualified Name:     QuantiteNonIndemnises
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
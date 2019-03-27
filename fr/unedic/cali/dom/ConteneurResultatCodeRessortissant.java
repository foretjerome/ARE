package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public class ConteneurResultatCodeRessortissant
{
  private String codeRessortissant;
  private String codeRetour;
  private Damj dateVerification;
  
  public ConteneurResultatCodeRessortissant(String codeRessortissant, Damj dateVerification, String codeRetour)
  {
    this.codeRessortissant = codeRessortissant;
    this.dateVerification = dateVerification;
    this.codeRetour = codeRetour;
  }
  
  public void setDateVerification(Damj dateVerification)
  {
    this.dateVerification = dateVerification;
  }
  
  public Damj getDateVerification()
  {
    return dateVerification;
  }
  
  public void setCodeRessortissant(String codeRessortissant)
  {
    this.codeRessortissant = codeRessortissant;
  }
  
  public String getCodeRessortissant()
  {
    return codeRessortissant;
  }
  
  public void setCodeRetour(String codeRetour)
  {
    this.codeRetour = codeRetour;
  }
  
  public String getCodeRetour()
  {
    return codeRetour;
  }
}

/* Location:
 * Qualified Name:     ConteneurResultatCodeRessortissant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
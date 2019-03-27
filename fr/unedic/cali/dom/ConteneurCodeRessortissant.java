package fr.unedic.cali.dom;

public class ConteneurCodeRessortissant
{
  private String identifiantNational;
  private String codeTraitement;
  private static final String CODE_TRAITEMENT_PAR_DEFAUT = "NATI";
  
  public String getIdentifiantNational()
  {
    return identifiantNational;
  }
  
  public void setIdentifiantNational(String identifiantNational)
  {
    this.identifiantNational = identifiantNational;
  }
  
  public String getCodeTraitement()
  {
    return codeTraitement;
  }
  
  public void setCodeTraitement(String codeTraitement)
  {
    this.codeTraitement = codeTraitement;
  }
  
  public ConteneurCodeRessortissant(String identifiantNational, String codeTraitement)
  {
    this.identifiantNational = identifiantNational;
    this.codeTraitement = codeTraitement;
  }
  
  public ConteneurCodeRessortissant(String identifiantNational)
  {
    this.identifiantNational = identifiantNational;
    codeTraitement = "NATI";
  }
}

/* Location:
 * Qualified Name:     ConteneurCodeRessortissant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
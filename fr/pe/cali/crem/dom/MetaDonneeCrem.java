package fr.pe.cali.crem.dom;

public class MetaDonneeCrem
{
  private String nom;
  private String valeur;
  
  public MetaDonneeCrem(String nom, String valeur)
  {
    this.nom = nom;
    this.valeur = valeur;
  }
  
  public String getNom()
  {
    return nom;
  }
  
  public void setNom(String nom)
  {
    this.nom = nom;
  }
  
  public String getValeur()
  {
    return valeur;
  }
  
  public void setValeur(String valeur)
  {
    this.valeur = valeur;
  }
}

/* Location:
 * Qualified Name:     MetaDonneeCrem
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
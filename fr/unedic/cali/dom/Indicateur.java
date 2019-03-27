package fr.unedic.cali.dom;

public class Indicateur
{
  private String m_nom;
  private int m_valeur;
  
  public Indicateur(String p_nom, int p_valeur)
  {
    setNom(p_nom);
    setValeur(p_valeur);
  }
  
  public String getNom()
  {
    return m_nom;
  }
  
  public void setNom(String p_nom)
  {
    m_nom = p_nom;
  }
  
  public int getValeur()
  {
    return m_valeur;
  }
  
  public void setValeur(int p_valeur)
  {
    m_valeur = p_valeur;
  }
  
  public void incremente()
  {
    setValeur(getValeur() + 1);
  }
  
  public void decremente()
  {
    if (getValeur() != 0) {
      setValeur(getValeur() - 1);
    }
  }
}

/* Location:
 * Qualified Name:     Indicateur
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
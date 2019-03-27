package fr.unedic.cali.dom;

public class EtatQuantiteDroitActive
  extends EtatQuantiteDroit
{
  public Object accepteVisiteur(VisiteurQuantiteDroit p_visiteur)
  {
    return p_visiteur.visiter(this);
  }
  
  public int getEtat()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     EtatQuantiteDroitActive
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
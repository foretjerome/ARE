package fr.unedic.cali.dom;

public class EtatQuantiteDroitInactive
  extends EtatQuantiteDroit
{
  public Object accepteVisiteur(VisiteurQuantiteDroit p_visiteur)
  {
    return p_visiteur.visiter(this);
  }
  
  public int getEtat()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     EtatQuantiteDroitInactive
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
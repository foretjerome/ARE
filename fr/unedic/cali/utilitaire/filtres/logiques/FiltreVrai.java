package fr.unedic.cali.utilitaire.filtres.logiques;

import fr.unedic.util.temps.Temporel;

public class FiltreVrai
  extends FiltreLogiqueAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    return true;
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreVrai
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
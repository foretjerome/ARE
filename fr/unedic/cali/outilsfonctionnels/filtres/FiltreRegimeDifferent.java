package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.util.temps.Temporel;

public class FiltreRegimeDifferent
  extends FiltreMemeRegime
{
  public boolean accepter(Temporel p_temporel)
  {
    return !super.accepter(p_temporel);
  }
  
  public FiltreRegimeDifferent(String p_nomReglement, DecorReglementaire p_decor)
  {
    super(p_nomReglement, p_decor);
  }
}

/* Location:
 * Qualified Name:     FiltreRegimeDifferent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
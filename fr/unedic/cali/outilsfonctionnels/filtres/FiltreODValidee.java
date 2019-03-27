package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.OdSpec;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreODValidee
  extends FiltreOD
{
  public boolean accepter(Temporel p_temporel)
  {
    return (super.accepter(p_temporel)) && (((OdSpec)((DemandeSpec)p_temporel).getListeDossiersExamen().get(0)).estValidee()) && (!((DemandeSpec)p_temporel).estEnReExamen());
  }
}

/* Location:
 * Qualified Name:     FiltreODValidee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
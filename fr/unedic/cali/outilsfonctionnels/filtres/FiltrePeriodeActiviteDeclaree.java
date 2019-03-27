package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeActiviteDeclaree
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  public FiltrePeriodeActiviteDeclaree(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public FiltrePeriodeActiviteDeclaree() {}
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise(p_temporel.estType(DeclareTravail.class));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeActiviteDeclaree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
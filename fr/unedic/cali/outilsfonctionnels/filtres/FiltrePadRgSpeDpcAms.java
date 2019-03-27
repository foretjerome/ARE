package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePadRgSpeDpcAms
  extends FiltrePeriodesComplementaires
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1476849465787751927L;
  
  public FiltrePadRgSpeDpcAms(boolean p_filtreComplementaire)
  {
    super(p_filtreComplementaire);
  }
  
  public FiltrePadRgSpeDpcAms() {}
  
  public boolean accepter(Temporel p_temporel)
  {
    return super.getFiltreValorise((((DeclareTravail)p_temporel).estJustifie()) && (((DeclareTravail)p_temporel).getStatutDSMTravail() == 2) && ((((DeclareTravail)p_temporel).getOrigineInfo().equalsIgnoreCase(Integer.toString(61))) || (((DeclareTravail)p_temporel).getOrigineInfo().equalsIgnoreCase(Integer.toString(62))) || (((DeclareTravail)p_temporel).getOrigineInfo().equalsIgnoreCase(Integer.toString(69))) || (((DeclareTravail)p_temporel).getOrigineInfo().equalsIgnoreCase(Integer.toString(27)))));
  }
}

/* Location:
 * Qualified Name:     FiltrePadRgSpeDpcAms
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
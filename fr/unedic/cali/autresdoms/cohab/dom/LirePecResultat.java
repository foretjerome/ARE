package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.NonConformiteException;

public class LirePecResultat
{
  ChronologiePeriodes m_chronoPeriodesPriseEnCharge;
  
  public LirePecResultat()
  {
    m_chronoPeriodesPriseEnCharge = new ChronologiePeriodes();
  }
  
  public ChronologiePeriodes getChronoPeriodesPriseEnCharge()
  {
    return m_chronoPeriodesPriseEnCharge;
  }
  
  public void ajouterPeriodePriseEnCharge(ObjetChronoPeriodePriseEnCharge p_periode)
  {
    try
    {
      m_chronoPeriodesPriseEnCharge.ajouter(p_periode);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(LirePecResultat.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, LirePecResultat.class, "ajouterPeriodePriseEnCharge", e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     LirePecResultat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
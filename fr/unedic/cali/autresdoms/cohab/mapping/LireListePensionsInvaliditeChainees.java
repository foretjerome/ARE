package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.NonConformiteException;

public class LireListePensionsInvaliditeChainees
{
  private ChronologiePeriodes m_chronoPensionsInvaliditeChainees;
  
  public LireListePensionsInvaliditeChainees()
  {
    m_chronoPensionsInvaliditeChainees = new ChronologiePeriodes();
  }
  
  public ChronologiePeriodes getChronoPensionsInvalidite()
  {
    if (m_chronoPensionsInvaliditeChainees == null) {
      m_chronoPensionsInvaliditeChainees = new ChronologiePeriodes();
    }
    return m_chronoPensionsInvaliditeChainees;
  }
  
  public void setChronoPensionsInvalidite(ChronologiePeriodes p_chronoPensionsInvalidite)
  {
    m_chronoPensionsInvaliditeChainees = p_chronoPensionsInvalidite;
  }
  
  public void ajouterPeriodePensionsInvalidite(ObjetChronoPeriodeCalcul p_periode)
  {
    try
    {
      m_chronoPensionsInvaliditeChainees.ajouter(p_periode);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(LireListePensionsInvaliditeEtAvantagesVieillesse.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, LireListePensionsInvaliditeEtAvantagesVieillesse.class, "ajouterPensionsInvalidite", e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     LireListePensionsInvaliditeChainees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
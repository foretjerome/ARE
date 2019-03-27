package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.NonConformiteException;

public class LireListePensionsInvaliditeEtAvantagesVieillesse
{
  private ChronologiePeriodes m_chronoPensionsInvalidite;
  private ChronologiePeriodes m_chronoAvantagesVieillesse;
  
  public LireListePensionsInvaliditeEtAvantagesVieillesse()
  {
    m_chronoPensionsInvalidite = new ChronologiePeriodes();
    m_chronoAvantagesVieillesse = new ChronologiePeriodes();
  }
  
  public ChronologiePeriodes getChronoPensionsInvalidite()
  {
    if (m_chronoPensionsInvalidite == null) {
      m_chronoPensionsInvalidite = new ChronologiePeriodes();
    }
    return m_chronoPensionsInvalidite;
  }
  
  public ChronologiePeriodes getChronoAvantagesVieillesse()
  {
    if (m_chronoAvantagesVieillesse == null) {
      m_chronoAvantagesVieillesse = new ChronologiePeriodes();
    }
    return m_chronoAvantagesVieillesse;
  }
  
  public void setChronoPensionsInvalidite(ChronologiePeriodes p_chronoPensionsInvalidite)
  {
    m_chronoPensionsInvalidite = p_chronoPensionsInvalidite;
  }
  
  public void setChronoAvantagesVieillesse(ChronologiePeriodes p_chronoAvantagesVieillesse)
  {
    m_chronoAvantagesVieillesse = p_chronoAvantagesVieillesse;
  }
  
  public void ajouterPeriodePensionsInvalidite(ObjetChronoPeriodeCalcul p_periode)
  {
    try
    {
      m_chronoPensionsInvalidite.ajouter(p_periode);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(LireListePensionsInvaliditeEtAvantagesVieillesse.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, LireListePensionsInvaliditeEtAvantagesVieillesse.class, "ajouterPensionsInvalidite", e);
      }
    }
  }
  
  public void ajouterPeriodeAvantagesVieillesse(ObjetChronoPeriodeCalcul p_periode)
  {
    try
    {
      m_chronoAvantagesVieillesse.ajouter(p_periode);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(LireListePensionsInvaliditeEtAvantagesVieillesse.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, LireListePensionsInvaliditeEtAvantagesVieillesse.class, "ajouterAvantagesVieillesse", e);
      }
    }
  }
}

/* Location:
 * Qualified Name:     LireListePensionsInvaliditeEtAvantagesVieillesse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
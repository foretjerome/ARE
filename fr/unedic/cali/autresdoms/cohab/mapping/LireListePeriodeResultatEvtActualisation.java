package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.NonConformiteException;
import java.util.ArrayList;
import java.util.Collection;

public class LireListePeriodeResultatEvtActualisation
{
  private ChronologiePeriodes m_chronoPeriodesEvtActualisation;
  private transient Collection m_donneesMoisActualisation;
  private Damj m_dateBlocageActualisation;
  
  public LireListePeriodeResultatEvtActualisation()
  {
    m_chronoPeriodesEvtActualisation = new ChronologiePeriodes();
    m_donneesMoisActualisation = new ArrayList();
  }
  
  public ChronologiePeriodes getChronoPeriodesEvtActualisation()
  {
    if (m_chronoPeriodesEvtActualisation == null) {
      m_chronoPeriodesEvtActualisation = new ChronologiePeriodes();
    }
    return m_chronoPeriodesEvtActualisation;
  }
  
  public void setChronoPeriodesEvtActualisation(ChronologiePeriodes p_chronoPeriodesEvtActualisation)
  {
    m_chronoPeriodesEvtActualisation = p_chronoPeriodesEvtActualisation;
  }
  
  public void ajouterPeriodeEvtActualisation(ObjetChronoPeriodeCalcul p_periode)
  {
    try
    {
      m_chronoPeriodesEvtActualisation.ajouter(p_periode);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(LireListePeriodeResultatEvtActualisation.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, LireListePeriodeResultatEvtActualisation.class, "ajouterPeriodeEvtActualisation", e);
      }
    }
  }
  
  public Damj getDateBlocageActualisation()
  {
    return m_dateBlocageActualisation;
  }
  
  public void setDateBlocageActualisation(Damj p_dateBlocageActualisation)
  {
    m_dateBlocageActualisation = p_dateBlocageActualisation;
  }
  
  public Collection getDonneesMoisActualisation()
  {
    return m_donneesMoisActualisation;
  }
  
  public void setDonneesMoisActualisation(Collection p_donneesMoisActualisation)
  {
    m_donneesMoisActualisation = p_donneesMoisActualisation;
  }
}

/* Location:
 * Qualified Name:     LireListePeriodeResultatEvtActualisation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
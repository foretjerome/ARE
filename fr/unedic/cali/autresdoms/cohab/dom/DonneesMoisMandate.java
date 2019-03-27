package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.spec.DonneesEvtActuSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;

public class DonneesMoisMandate
  extends ObjetChronoPeriode
{
  private String m_topMandatement = null;
  private String m_topCoherenceTravailA8A10 = null;
  
  private DonneesMoisMandate() {}
  
  public DonneesMoisMandate(DonneesEvtActuSpec p_donneesEvtActu)
  {
    super(new Periode(new Damj(p_donneesEvtActu.getAnnee(), p_donneesEvtActu.getMois(), 1), new Damj(p_donneesEvtActu.getAnnee(), p_donneesEvtActu.getMois(), 1).getFinMois()));
    
    setTopMandatement(p_donneesEvtActu.getTopMandatement());
    setTopCoherenceTravailA8A10(p_donneesEvtActu.getTopCoherenceTravailA8A10());
  }
  
  public String getTopMandatement()
  {
    return m_topMandatement;
  }
  
  public void setTopMandatement(String p_topMandatement)
  {
    m_topMandatement = p_topMandatement;
  }
  
  public String getTopCoherenceTravailA8A10()
  {
    return m_topCoherenceTravailA8A10;
  }
  
  public void setTopCoherenceTravailA8A10(String p_topCoherenceTravailA8A10)
  {
    m_topCoherenceTravailA8A10 = p_topCoherenceTravailA8A10;
  }
  
  public ObjetMetierSpec copie()
  {
    DonneesMoisMandate copie = new DonneesMoisMandate();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    DonneesMoisMandate copie = (DonneesMoisMandate)p_copie;
    m_topMandatement = getTopMandatement();
    super.copieElements(copie);
  }
}

/* Location:
 * Qualified Name:     DonneesMoisMandate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
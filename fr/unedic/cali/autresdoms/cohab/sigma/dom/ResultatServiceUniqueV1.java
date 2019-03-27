package fr.unedic.cali.autresdoms.cohab.sigma.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.BlocageActu;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.Individu;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.PeriodePriseEnCharge;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.PeriodePriseEnChargeOut;
import java.util.ArrayList;
import java.util.Collection;

public class ResultatServiceUniqueV1
{
  private Collection m_listePeriodesPecV1 = new ArrayList();
  private Collection m_listePeriodesPecV2 = new ArrayList();
  private Collection m_listeAbsencePointage = new ArrayList();
  private BlocageActu m_blocageActu;
  private Individu m_individu;
  
  public void ajouterPecV1(PeriodePriseEnChargeOut p_pec)
  {
    if (m_listePeriodesPecV1 == null) {
      m_listePeriodesPecV1 = new ArrayList();
    }
    m_listePeriodesPecV1.add(p_pec);
  }
  
  public Collection getListePeriodesPecV1()
  {
    return m_listePeriodesPecV1;
  }
  
  public void ajouterPecV2(PeriodePriseEnCharge p_pec)
  {
    if (m_listePeriodesPecV2 == null) {
      m_listePeriodesPecV2 = new ArrayList();
    }
    m_listePeriodesPecV2.add(p_pec);
  }
  
  public Collection getListePeriodesPecV2()
  {
    return m_listePeriodesPecV2;
  }
  
  public void setListePeriodesPecV1(Collection p_listePeriodesPecV1)
  {
    m_listePeriodesPecV1 = p_listePeriodesPecV1;
  }
  
  public void setListePeriodesPecV2(Collection p_listePeriodesPecV2)
  {
    m_listePeriodesPecV2 = p_listePeriodesPecV2;
  }
  
  public BlocageActu getBlocageActu()
  {
    return m_blocageActu;
  }
  
  public void setBlocageActu(BlocageActu p_blocageActu)
  {
    m_blocageActu = p_blocageActu;
  }
  
  public Individu getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(Individu p_individu)
  {
    m_individu = p_individu;
  }
  
  public Collection getListeAbsencePointage()
  {
    return m_listeAbsencePointage;
  }
  
  public void setListeAbsencePointage(Collection p_listeAbsencePointage)
  {
    m_listeAbsencePointage = p_listeAbsencePointage;
  }
}

/* Location:
 * Qualified Name:     ResultatServiceUniqueV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
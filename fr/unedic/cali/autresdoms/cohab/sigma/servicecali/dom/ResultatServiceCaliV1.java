package fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.ResultatServiceUniqueV1;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.PensionSpec;
import fr.unedic.cali.dom.PeriodeDroitAAH;
import java.util.ArrayList;
import java.util.Collection;

public class ResultatServiceCaliV1
  extends ResultatServiceUniqueV1
{
  private Collection m_listeDecisions = new ArrayList();
  private PensionSpec m_pension;
  private Collection m_listeDemandesDAL = new ArrayList();
  private Collection m_listeDemandesRNV = new ArrayList();
  private Collection m_listeRessourcesV1 = new ArrayList();
  private Collection<PeriodeDroitAAH> listePeriodesAAH = new ArrayList();
  
  public Collection getListeDecisions()
  {
    return m_listeDecisions;
  }
  
  public void setListeDecisions(Collection p_listeDecisions)
  {
    m_listeDecisions = p_listeDecisions;
  }
  
  public PensionSpec getPension()
  {
    return m_pension;
  }
  
  public void setPension(PensionSpec p_pension)
  {
    m_pension = p_pension;
  }
  
  public Collection getListeDemandesDAL()
  {
    return m_listeDemandesDAL;
  }
  
  public void setListeDemandesDAL(Collection p_listeDemandesDAL)
  {
    m_listeDemandesDAL = p_listeDemandesDAL;
  }
  
  public Collection getListeDemandesRNV()
  {
    return m_listeDemandesRNV;
  }
  
  public void setListeDemandesRNV(Collection p_listeDemandesRNV)
  {
    m_listeDemandesRNV = p_listeDemandesRNV;
  }
  
  public Collection getListeRessourcesV1()
  {
    return m_listeRessourcesV1;
  }
  
  public void setListeRessourcesV1(Collection p_ressourcesV1)
  {
    m_listeRessourcesV1 = p_ressourcesV1;
  }
  
  public Collection<PeriodeDroitAAH> getListePeriodeAAH()
  {
    return listePeriodesAAH;
  }
  
  public void setListePeriodeAAH(Collection<PeriodeDroitAAH> periodeAAH)
  {
    listePeriodesAAH = periodeAAH;
  }
}

/* Location:
 * Qualified Name:     ResultatServiceCaliV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
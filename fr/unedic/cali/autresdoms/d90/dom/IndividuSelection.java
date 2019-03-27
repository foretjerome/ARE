package fr.unedic.cali.autresdoms.d90.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.PopulationSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class IndividuSelection
{
  private BigDecimal m_identifiantBNI;
  private String m_codeAssedic;
  private String m_identifiantSigma;
  private String m_codeAntenne;
  private Collection m_collectionPopulations;
  private Damj m_dateReexecution;
  private PopulationSpec m_population;
  
  public PopulationSpec getPopulation()
  {
    return m_population;
  }
  
  public void setPopulation(PopulationSpec p_population)
  {
    m_population = p_population;
  }
  
  public IndividuSelection()
  {
    m_collectionPopulations = new ArrayList();
  }
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
  
  public String getCodeAssedic()
  {
    return m_codeAssedic;
  }
  
  public void setCodeAssedic(String p_codeAssedic)
  {
    m_codeAssedic = p_codeAssedic;
  }
  
  public Collection getCollectionPopulations()
  {
    return m_collectionPopulations;
  }
  
  public void setCollectionPopulations(Collection p_collectionPopulations)
  {
    m_collectionPopulations = p_collectionPopulations;
  }
  
  public Damj getDateReexecution()
  {
    return m_dateReexecution;
  }
  
  public void setDateReexecution(Damj p_dateReexecution)
  {
    m_dateReexecution = p_dateReexecution;
  }
  
  public BigDecimal getIdentifiantBNI()
  {
    return m_identifiantBNI;
  }
  
  public void setIdentifiantBNI(BigDecimal p_identifiantBNI)
  {
    m_identifiantBNI = p_identifiantBNI;
  }
  
  public String getIdentifiantSigma()
  {
    return m_identifiantSigma;
  }
  
  public void setIdentifiantSigma(String p_identifiantSigma)
  {
    m_identifiantSigma = p_identifiantSigma;
  }
  
  public boolean estIdentiqueA(IndividuSelection p_individu)
  {
    if ((p_individu == null) || (getIdentifiantBNI() == null) || (p_individu.getIdentifiantBNI() == null)) {
      return false;
    }
    return getIdentifiantBNI().compareTo(p_individu.getIdentifiantBNI()) == 0;
  }
}

/* Location:
 * Qualified Name:     IndividuSelection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
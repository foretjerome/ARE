package fr.unedic.cali.occasionnel.outilsfonctionnels;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;

public class CriteresExecutionPopulation
{
  IndividuSpec m_individu;
  DemandeSpec m_demande;
  String m_nomPopulation;
  Contexte m_contexte;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public String getNomPopulation()
  {
    return m_nomPopulation;
  }
  
  public void setNomPopulation(String p_nomPopulation)
  {
    m_nomPopulation = p_nomPopulation;
  }
  
  public DemandeSpec getDemande()
  {
    return m_demande;
  }
  
  public void setDemande(DemandeSpec p_demande)
  {
    m_demande = p_demande;
  }
  
  public Contexte getContexte()
  {
    return m_contexte;
  }
  
  public void setContexte(Contexte p_contexte)
  {
    m_contexte = p_contexte;
  }
}

/* Location:
 * Qualified Name:     CriteresExecutionPopulation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
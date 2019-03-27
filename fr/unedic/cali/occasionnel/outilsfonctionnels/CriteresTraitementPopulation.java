package fr.unedic.cali.occasionnel.outilsfonctionnels;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import java.util.ArrayList;

public class CriteresTraitementPopulation
{
  String m_nomPopulation;
  IndividuSpec m_individu;
  ArrayList m_parametres;
  Contexte m_contexte;
  
  public CriteresTraitementPopulation()
  {
    m_parametres = new ArrayList();
  }
  
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
  
  public ArrayList getParametres()
  {
    return m_parametres;
  }
  
  public void setParametres(ArrayList p_parametres)
  {
    m_parametres = p_parametres;
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
 * Qualified Name:     CriteresTraitementPopulation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
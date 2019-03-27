package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.Erreur;
import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ResultatClassement
  extends Resultat
{
  private Contexte m_contexte = null;
  private Erreur m_erreurTraitement;
  private IndicateursGeneriques m_indicateursGeneriques;
  
  public ResultatClassement()
  {
    super(0);
  }
  
  public Contexte getContexte()
  {
    return m_contexte;
  }
  
  public void setContexte(Contexte p_contexte)
  {
    m_contexte = p_contexte;
  }
  
  public Erreur getErreurTraitement()
  {
    return m_erreurTraitement;
  }
  
  public void setErreurTraitement(Erreur p_erreurTraitement)
  {
    m_erreurTraitement = p_erreurTraitement;
  }
  
  public IndicateursGeneriques getIndicateursGeneriques()
  {
    return m_indicateursGeneriques;
  }
  
  public void setIndicateursGeneriques(IndicateursGeneriques p_indicateursGeneriques)
  {
    m_indicateursGeneriques = p_indicateursGeneriques;
  }
}

/* Location:
 * Qualified Name:     ResultatClassement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.ContexteLocal;
import fr.unedic.util.services.ContexteParcours;
import fr.unedic.util.services.ContexteSpec;

public class ContexteParcoursCali
  extends ContexteParcours
{
  private Individu m_individu;
  
  public void affecteIndividu(Individu p_individuCourant)
  {
    m_individu = p_individuCourant;
  }
  
  public static Individu getIndividuCourant()
  {
    ContexteParcoursCali contexte = (ContexteParcoursCali)getContexte();
    return m_individu;
  }
  
  public static ContexteSpec getContexte()
  {
    ContexteParcoursCali contexte = (ContexteParcoursCali)ContexteLocal.getContexte(ContexteParcoursCali.class);
    if (contexte == null)
    {
      contexte = new ContexteParcoursCali();
      ContexteLocal.setContexte(contexte, ContexteParcoursCali.class);
    }
    return contexte;
  }
  
  public void close()
  {
    m_individu = null;
  }
}

/* Location:
 * Qualified Name:     ContexteParcoursCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
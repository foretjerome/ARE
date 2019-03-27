package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.cali.dom.occasionnel.DomEnregistrerNationalOccasionnel;
import fr.unedic.util.services.Resultat;

public class ResultatEnregistrerNationalOccasionnel
  extends Resultat
{
  private static final long serialVersionUID = 7613773066470727032L;
  private DomEnregistrerNationalOccasionnel m_dom = null;
  
  public DomEnregistrerNationalOccasionnel getDomEnregistrerNationalOccasionnel()
  {
    return m_dom;
  }
  
  public void setDomEnregistrerNationalOccasionnel(DomEnregistrerNationalOccasionnel p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatEnregistrerNationalOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
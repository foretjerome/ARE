package fr.unedic.cali.parcours.occasionnel;

import fr.unedic.cali.dom.occasionnel.DomEnregistrerIndividusOccasionnel;
import fr.unedic.util.services.Resultat;

public class ResultatEnregistrerIndividusOccasionnel
  extends Resultat
{
  private static final long serialVersionUID = -6121966558225260186L;
  private DomEnregistrerIndividusOccasionnel m_dom = null;
  
  public DomEnregistrerIndividusOccasionnel getDomEnregistrerIndividusOccasionnel()
  {
    return m_dom;
  }
  
  public void setDomEnregistrerIndividusOccasionnel(DomEnregistrerIndividusOccasionnel p_dom)
  {
    m_dom = p_dom;
  }
}

/* Location:
 * Qualified Name:     ResultatEnregistrerIndividusOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
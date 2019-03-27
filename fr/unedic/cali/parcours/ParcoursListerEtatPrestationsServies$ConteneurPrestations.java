package fr.unedic.cali.parcours;

import java.util.List;

class ParcoursListerEtatPrestationsServies$ConteneurPrestations
{
  private List m_listePrestations;
  private DomListerEtatPrestationsServies m_domCourant;
  
  public ParcoursListerEtatPrestationsServies$ConteneurPrestations(ParcoursListerEtatPrestationsServies paramParcoursListerEtatPrestationsServies) {}
  
  public ParcoursListerEtatPrestationsServies$ConteneurPrestations(ParcoursListerEtatPrestationsServies paramParcoursListerEtatPrestationsServies, List list, DomListerEtatPrestationsServies dom)
  {
    m_listePrestations = list;
    m_domCourant = dom;
  }
  
  public DomListerEtatPrestationsServies getDomCourant()
  {
    return m_domCourant;
  }
  
  public void setDomCourant(DomListerEtatPrestationsServies domCourant)
  {
    m_domCourant = domCourant;
  }
  
  public List getListePrestations()
  {
    return m_listePrestations;
  }
  
  public void setListePrestations(List listePrestations)
  {
    m_listePrestations = listePrestations;
  }
}

/* Location:
 * Qualified Name:     ParcoursListerEtatPrestationsServies.ConteneurPrestations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;

public class ResultatCreerDemande
  extends Resultat
{
  DomCreerDemande m_domCreerDemande = null;
  
  public DomCreerDemande getDomCreerDemande()
  {
    return m_domCreerDemande;
  }
  
  public void setDomCreerDemande(DomCreerDemande p_domCreerDemande)
  {
    m_domCreerDemande = p_domCreerDemande;
  }
}

/* Location:
 * Qualified Name:     ResultatCreerDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
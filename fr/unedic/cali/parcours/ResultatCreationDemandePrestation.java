package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.services.Resultat;

public class ResultatCreationDemandePrestation
  extends Resultat
{
  private DemandeSpec m_demande;
  
  public DemandeSpec getDemande()
  {
    return m_demande;
  }
  
  public void setDemande(DemandeSpec p_spec)
  {
    m_demande = p_spec;
  }
}

/* Location:
 * Qualified Name:     ResultatCreationDemandePrestation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.services.Resultat;

public class ResultatInstallerDroitOptionAss
  extends Resultat
{
  protected DemandeSpec m_demande = null;
  
  public ResultatInstallerDroitOptionAss() {}
  
  public ResultatInstallerDroitOptionAss(int p_etat)
  {
    super(p_etat);
  }
  
  public DemandeSpec getDemande()
  {
    return m_demande;
  }
  
  public void setDemande(DemandeSpec p_demande)
  {
    m_demande = p_demande;
  }
}

/* Location:
 * Qualified Name:     ResultatInstallerDroitOptionAss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
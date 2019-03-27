package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.Collection;

public class ResultatAlimenterSyntheseDE
  extends Resultat
{
  protected Collection m_listeIdentifiantDemande;
  
  public ResultatAlimenterSyntheseDE() {}
  
  public ResultatAlimenterSyntheseDE(int p_etat)
  {
    super(p_etat);
  }
  
  public Collection getListeIdentifiantDemande()
  {
    return m_listeIdentifiantDemande;
  }
  
  public void setListeIdentifiantDemande(Collection p_listeIdentifiantDemande)
  {
    m_listeIdentifiantDemande = p_listeIdentifiantDemande;
  }
}

/* Location:
 * Qualified Name:     ResultatAlimenterSyntheseDE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
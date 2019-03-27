package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.services.Resultat;

public class ResultatReceptionFluxWeb
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  DemandeSpec demande = null;
  
  public DemandeSpec getDemande()
  {
    return demande;
  }
  
  public void setDemande(DemandeSpec demande)
  {
    this.demande = demande;
  }
}

/* Location:
 * Qualified Name:     ResultatReceptionFluxWeb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
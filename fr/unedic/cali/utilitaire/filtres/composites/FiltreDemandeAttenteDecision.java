package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.OutilDemande;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeAttenteDecision
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public int getTypeElementManipule()
  {
    return -1;
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    return OutilDemande.estDemandeAttenteDecision((DemandeSpec)temporel);
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeAttenteDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.RenouvellementSpec;
import fr.unedic.cali.dom.affectation.ProduitDecCge01P01;
import fr.unedic.cali.dom.affectation.ProduitForAff03P01;
import fr.unedic.cali.dom.affectation.ProduitForAff03P03;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesPortantAttributionPourSigma
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    DossierAffectationSpec dossier = null;
    boolean accepte = true;
    try
    {
      dossier = ((DemandeSpec)p_temporel).getDossierAffectation();
      if (dossier != null) {
        accepte = (!(dossier.getProduit() instanceof RenouvellementSpec)) && (!(dossier.getProduit() instanceof ProduitForAff03P01)) && (!(dossier.getProduit() instanceof ProduitForAff03P03)) && (!(dossier.getProduit() instanceof ProduitDecCge01P01));
      } else {
        accepte = false;
      }
    }
    catch (UnsupportedOperationException e)
    {
      accepte = false;
    }
    catch (ClassCastException e)
    {
      accepte = false;
    }
    return accepte;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandesPortantAttributionPourSigma
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
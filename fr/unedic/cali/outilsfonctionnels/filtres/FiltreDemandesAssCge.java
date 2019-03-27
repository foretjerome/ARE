package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.GammeSol;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSolCge01P01;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesAssCge
  implements FiltreTemporel
{
  private static final long serialVersionUID = -4465165866819840460L;
  
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      if ((demande.getGamme().getNomUnique() == GammeSol.getInstance().getNomUnique()) && (demande.getDossierAffectation().getProduit() != null) && (demande.getDossierAffectation().getProduit().getCode() == ProduitSolCge01P01.getInstance().getCode())) {
        return true;
      }
    }
    catch (ClassCastException e)
    {
      if (Log.isTraceActive(FiltreDemandesAssCge.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, FiltreDemandesAssCge.class, "accepter", e);
      }
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandesAssCge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
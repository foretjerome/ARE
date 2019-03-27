package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.affectation.ProduitSolAta06P01;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreAttributionATA
  extends FiltreAttribution
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    if ((p_temporel.estType(DemandeSpec.class)) && (super.accepter(p_temporel)))
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      if (!demande.getListeDossiersExamen().isEmpty())
      {
        DossierExamenSpec dossierExamen = (DossierExamenSpec)demande.getListeDossiersExamen().get(0);
        return dossierExamen.getDossierAffecte().getProduit() instanceof ProduitSolAta06P01;
      }
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreAttributionATA
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
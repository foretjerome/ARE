package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.AntecedentSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreAntecedent
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    if (p_temporel.estType(DemandeSpec.class))
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      List listeDossiersExamen = demande.getListeDossiersExamen();
      if ((demande.getListeDossiersExamen() != null) && (!demande.getListeDossiersExamen().isEmpty()))
      {
        DossierExamenSpec dossierExamen = (DossierExamenSpec)listeDossiersExamen.get(0);
        return dossierExamen.estType(AntecedentSpec.class);
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreAntecedent
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
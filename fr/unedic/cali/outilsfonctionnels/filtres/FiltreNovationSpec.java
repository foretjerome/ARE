package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.NovationSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreNovationSpec
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel temporel)
  {
    try
    {
      List<DossierExamenSpec> listeDossierExamen = ((DemandeSpec)temporel).getListeDossiersExamen();
      DossierExamenSpec dossierExamen = null;
      if (!listeDossierExamen.isEmpty()) {
        dossierExamen = (DossierExamenSpec)listeDossierExamen.get(0);
      }
      if ((dossierExamen instanceof NovationSpec)) {
        return true;
      }
    }
    catch (ClassCastException e)
    {
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreNovationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
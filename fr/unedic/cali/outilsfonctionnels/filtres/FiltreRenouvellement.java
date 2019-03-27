package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.RenouvellementSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreRenouvellement
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      List listDossierExamen = ((DemandeSpec)p_temporel).getListeDossiersExamen();
      return (listDossierExamen != null) && (!listDossierExamen.isEmpty()) && ((listDossierExamen.get(0) instanceof RenouvellementSpec));
    }
    catch (ClassCastException e) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreRenouvellement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
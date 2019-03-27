package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.RejetSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreRejet
  implements FiltreTemporel
{
  private RejetSpec m_dernierRejet;
  
  public boolean accepter(Temporel p_temporel)
  {
    List listDossierExamen = ((DemandeSpec)p_temporel).getListeDossiersExamen();
    if ((listDossierExamen != null) && (!listDossierExamen.isEmpty()) && ((listDossierExamen.get(0) instanceof RejetSpec)))
    {
      m_dernierRejet = ((RejetSpec)listDossierExamen.get(0));
      return true;
    }
    m_dernierRejet = null;
    return false;
  }
  
  protected RejetSpec getDernierRejet()
  {
    return m_dernierRejet;
  }
}

/* Location:
 * Qualified Name:     FiltreRejet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
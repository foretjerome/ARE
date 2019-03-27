package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltreRevision
  implements FiltreTemporel
{
  private static final long serialVersionUID = -5084877276571672447L;
  
  public boolean accepter(Temporel p_temporel)
  {
    try
    {
      DemandeSpec demande = (DemandeSpec)p_temporel;
      return "ASU_07".equals(demande.getEvenementReferenceExamen().getTypeExamen());
    }
    catch (ClassCastException e) {}
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltreRevision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
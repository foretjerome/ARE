package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.Pans;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePansCalcul
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel p_temporel)
  {
    return (p_temporel.estType(Pans.class)) && (p_temporel.getDateDebut().estApresOuCoincideAvec(recupererDatePivot()));
  }
  
  private Damj recupererDatePivot()
  {
    try
    {
      return GestionnaireDateApplication.getInstance().recupererDateApplication("Prise en compte des ANS mensuel et supra M");
    }
    catch (CoucheLogiqueException e) {}
    return null;
  }
}

/* Location:
 * Qualified Name:     FiltrePansCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
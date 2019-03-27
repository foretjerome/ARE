package fr.unedic.cali.calcul.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PansMensuel;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravail;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePeriodeTravailCalculPANSMensuel
  implements FiltreTemporel
{
  public boolean accepter(Temporel p_temporel)
  {
    return ((p_temporel instanceof PeriodeTravail)) && ((p_temporel instanceof PansMensuel));
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeTravailCalculPANSMensuel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
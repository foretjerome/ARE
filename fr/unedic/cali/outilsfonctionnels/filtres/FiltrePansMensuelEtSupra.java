package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.calcul.dom.periode.PansMensuel;
import fr.unedic.cali.calcul.dom.periode.PansMensuelNonRemuneree;
import fr.unedic.cali.calcul.dom.periode.PansSupraMensuel;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;

public class FiltrePansMensuelEtSupra
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepter(Temporel temporel)
  {
    return (!temporel.estType(PansMensuel.class)) && (!temporel.estType(PansSupraMensuel.class)) && (!temporel.estType(PansMensuelNonRemuneree.class));
  }
}

/* Location:
 * Qualified Name:     FiltrePansMensuelEtSupra
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
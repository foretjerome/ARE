package fr.unedic.cali.fabriques.outilsfonctionnels;

import fr.unedic.cali.fabriques.outilsfonctionnels.spec.ElementStrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class ElementStrategieDate
  implements ElementStrategieSpec
{
  private String dateApplication;
  private StrategieSpec strategieAvant;
  private StrategieSpec strategieApres;
  
  public ElementStrategieDate(String dateApplication, StrategieSpec strategieAvant, StrategieSpec strategieApres)
  {
    this.dateApplication = dateApplication;
    this.strategieAvant = strategieAvant;
    this.strategieApres = strategieApres;
  }
  
  public boolean estEligible(Damj dateAppel)
  {
    return true;
  }
  
  public StrategieSpec recupererStrategie(Damj dateAppel)
    throws CoucheLogiqueException
  {
    StrategieSpec strategieARetourner = null;
    if (dateAppel.estApresOuCoincideAvec(GestionnaireDateApplication.getInstance().recupererDateApplication(dateApplication))) {
      strategieARetourner = strategieApres;
    } else {
      strategieARetourner = strategieAvant;
    }
    return strategieARetourner;
  }
}

/* Location:
 * Qualified Name:     ElementStrategieDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
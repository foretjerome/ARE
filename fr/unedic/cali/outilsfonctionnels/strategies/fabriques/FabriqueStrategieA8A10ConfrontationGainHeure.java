package fr.unedic.cali.outilsfonctionnels.strategies.fabriques;

import fr.unedic.cali.fabriques.FabriqueStrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieA8A10ConfrontationGainHeureApres;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieA8A10ConfrontationGainHeureAvant;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieA8A10ConfrontationGainHeureSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieA8A10ConfrontationGainHeure
  implements FabriqueStrategieSpec
{
  private static FabriqueStrategieA8A10ConfrontationGainHeure instance = null;
  
  public static synchronized FabriqueStrategieA8A10ConfrontationGainHeure getInstance()
  {
    if (instance == null) {
      instance = new FabriqueStrategieA8A10ConfrontationGainHeure();
    }
    return instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieA8A10ConfrontationGainHeureSpec strategie = null;
    
    Damj datePivot = critereStrategie.getDatePivot();
    
    Damj dateStrategie = GestionnaireDateApplication.getInstance().recupererDateApplication("Date d'application du SM9 IN0965163");
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieA8A10ConfrontationGainHeure : la date pivot est nulle.");
    }
    if (datePivot.estApresOuCoincideAvec(dateStrategie)) {
      strategie = new StrategieA8A10ConfrontationGainHeureApres();
    } else {
      strategie = new StrategieA8A10ConfrontationGainHeureAvant();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieA8A10ConfrontationGainHeure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
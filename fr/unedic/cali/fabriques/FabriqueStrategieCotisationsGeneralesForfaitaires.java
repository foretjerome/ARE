package fr.unedic.cali.fabriques;

import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieCotisationsGeneralesForfaitairesApres;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieCotisationsGeneralesForfaitairesAvant;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieCotisationsGeneralesForfaitairesSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieCotisationsGeneralesForfaitaires
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_PRISE_EN_COMPTE_CGF_09SI2 = new Damj(2009, 7, 1);
  private static FabriqueStrategieCotisationsGeneralesForfaitaires s_instance = new FabriqueStrategieCotisationsGeneralesForfaitaires();
  
  public static FabriqueStrategieCotisationsGeneralesForfaitaires getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
  {
    StrategieCotisationsGeneralesForfaitairesSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieCotisationsGeneralesForfaitaires : la date pivot de modification des ressources est null.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_PRISE_EN_COMPTE_CGF_09SI2)) {
      strategie = new StrategieCotisationsGeneralesForfaitairesApres();
    } else {
      strategie = new StrategieCotisationsGeneralesForfaitairesAvant();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieCotisationsGeneralesForfaitaires
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
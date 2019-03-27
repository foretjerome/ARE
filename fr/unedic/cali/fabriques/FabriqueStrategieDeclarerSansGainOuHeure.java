package fr.unedic.cali.fabriques;

import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieConfrontationGainDeclareJustifie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeclarerSansGainOuHeureApresMEP13SI2;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeclarerSansGainOuHeureAvantMEP13SI2;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeclarerSansGainOuHeureSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieDeclarerSansGainOuHeure
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_PIVOT = new Damj(2013, 7, 1);
  private static FabriqueStrategieDeclarerSansGainOuHeure s_instance = new FabriqueStrategieDeclarerSansGainOuHeure();
  
  public static FabriqueStrategieDeclarerSansGainOuHeure getInstance()
  {
    return s_instance;
  }
  
  public StrategieSpec getStrategie(CritereStrategie critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieDeclarerSansGainOuHeureSpec strategie = null;
    if (critereStrategie.getDatePivot() == null) {
      throw new UnsupportedOperationException("StrategieDeclarerSansGainOuHeureSpec : la date pivot du critère stratégie est null.");
    }
    if ((critereStrategie.getDatePivot().estApres(GestionnaireDateApplication.getInstance().recupererDateApplication("Determination du statut UT en RG"))) && ("ASU".equals(critereStrategie.getProduit().getLigne().getGamme().getNomUnique()))) {
      strategie = new StrategieConfrontationGainDeclareJustifie();
    } else if (critereStrategie.getDatePivot().estApres(DATE_PIVOT)) {
      strategie = new StrategieDeclarerSansGainOuHeureApresMEP13SI2();
    } else {
      strategie = new StrategieDeclarerSansGainOuHeureAvantMEP13SI2();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieDeclarerSansGainOuHeure
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
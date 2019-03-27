package fr.unedic.cali.liquidation.pnds.outilsfonctionnels;

import fr.unedic.cali.liquidation.pnds.StrategieDeterminationPNDSSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStrategieDeterminationPNDS
{
  public static final Damj DATE_MEP_09SI2 = new Damj(2009, 6, 22);
  
  public static StrategieDeterminationPNDSSpec determinerStrategieDeterminationPNDS(CritereStrategie criteres)
    throws CoucheLogiqueException
  {
    Damj dateExamen = criteres.getDatePivot();
    if (dateExamen == null) {
      throw new UnsupportedOperationException("FabriqueStrategieDeterminationPNDS : la date pivot de détermination des PNDS est null.");
    }
    StrategieDeterminationPNDSSpec strategie;
    StrategieDeterminationPNDSSpec strategie;
    if (dateExamen.estApresOuCoincideAvec(GestionnaireDateApplication.getInstance().recupererDateApplication("Réactivation de la détermination des PNDS")))
    {
      strategie = new StrategieDeterminationPNDSApresMEP17SI1();
    }
    else
    {
      StrategieDeterminationPNDSSpec strategie;
      if (dateExamen.estApres(GestionnaireDateApplication.DATE_FIN_SANCTION_PNDS))
      {
        strategie = new StrategieDeterminationPNDSDesactives();
      }
      else
      {
        StrategieDeterminationPNDSSpec strategie;
        if (dateExamen.estApres(DATE_MEP_09SI2)) {
          strategie = new StrategieDeterminationPNDSApresMEP09SI2();
        } else {
          strategie = new StrategieDeterminationPNDSAvantMEP09SI2();
        }
      }
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStrategieDeterminationPNDS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
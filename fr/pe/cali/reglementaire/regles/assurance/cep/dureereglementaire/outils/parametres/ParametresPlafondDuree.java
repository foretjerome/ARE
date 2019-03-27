package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.parametres;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParametresPlafondDuree
{
  private static final BigDecimal PLAFOND_AVANT_53_ANS = new BigDecimal(730);
  private static final BigDecimal PLAFOND_53_ET_54_ANS = new BigDecimal(913);
  private static final BigDecimal PLAFOND_APRES_55_ANS = new BigDecimal(1095);
  private static final int AGE_53 = 53;
  private static final int AGE_55 = 55;
  private static final int TRANCHE_AVANT_53_ANS = 1;
  private static final int TRANCHE_53_ET_54_ANS = 2;
  private static final int TRANCHE_APRES_55_ANS = 3;
  private Map<Integer, BigDecimal> parametres = new HashMap();
  private static ParametresPlafondDuree instance = new ParametresPlafondDuree();
  
  private ParametresPlafondDuree()
  {
    parametres.put(Integer.valueOf(1), PLAFOND_AVANT_53_ANS);
    parametres.put(Integer.valueOf(2), PLAFOND_53_ET_54_ANS);
    parametres.put(Integer.valueOf(3), PLAFOND_APRES_55_ANS);
  }
  
  public static ParametresPlafondDuree getInstance()
  {
    return instance;
  }
  
  public BigDecimal getPlafondPourAge(int ageDE)
  {
    return (BigDecimal)parametres.get(Integer.valueOf(recupererTrancheAge(ageDE)));
  }
  
  protected int recupererTrancheAge(int ageDE)
  {
    int tranche;
    int tranche;
    if (ageDE < 53)
    {
      tranche = 1;
    }
    else
    {
      int tranche;
      if (ageDE >= 55) {
        tranche = 3;
      } else {
        tranche = 2;
      }
    }
    return tranche;
  }
}

/* Location:
 * Qualified Name:     ParametresPlafondDuree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
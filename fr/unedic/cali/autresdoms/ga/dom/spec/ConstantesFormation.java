package fr.unedic.cali.autresdoms.ga.dom.spec;

import java.math.BigDecimal;
import java.util.HashMap;

public abstract class ConstantesFormation
{
  public static final int TYPE_LIVRE_IX = 1;
  public static final String LIB_LIVRE_IX = "Livre IX";
  public static final int TYPE_HORS_LIVRE_IX = 2;
  public static final String LIB_HORS_LIVRE_IX = "Hors Livre IX";
  public static final int ORIGINE_REMUNERATION_NON_REMUNERE = 5;
  public static final String LIB_ORIGINE_REMUNERATION_NON_REMUNERE = "Non rémunérée";
  public static final int ORIGINE_REMUNERATION_CNASEA = 1;
  public static final String LIB_ORIGINE_REMUNERATION_CNASEA = "Cnasea";
  public static final int ORIGINE_REMUNERATION_CONSEIL_GENERAL = 2;
  public static final String LIB_ORIGINE_REMUNERATION_CONSEIL_GENERAL = "Conseil général";
  public static final int ORIGINE_REMUNERATION_ECOLE = 3;
  public static final String LIB_ORIGINE_REMUNERATION_ECOLE = "Ecole";
  public static final int ORIGINE_REMUNERATION_ENTREPRISE = 4;
  public static final String LIB_ORIGINE_REMUNERATION_ENTREPRISE = "Entreprise";
  public static final int ORIGINE_REMUNERATION_AFPA = 6;
  public static final String LIB_ORIGINE_REMUNERATION_AFPA = "Afpa";
  public static final int ORIGINE_REMUNERATION_ASSEDIC = 7;
  public static final String LIB_ORIGINE_REMUNERATION_ASSEDIC = "Pôle emploi";
  private static HashMap s_libelleRemuneration = new HashMap();
  
  static
  {
    s_libelleRemuneration.put(new BigDecimal(5), "Non rémunérée");
    s_libelleRemuneration.put(new BigDecimal(1), "Cnasea");
    s_libelleRemuneration.put(new BigDecimal(2), "Conseil général");
    s_libelleRemuneration.put(new BigDecimal(3), "Ecole");
    s_libelleRemuneration.put(new BigDecimal(4), "Entreprise");
    s_libelleRemuneration.put(new BigDecimal(6), "Afpa");
    s_libelleRemuneration.put(new BigDecimal(7), "Pôle emploi");
  }
  
  public static String getOrigineRemuneration(BigDecimal p_code)
  {
    return (String)s_libelleRemuneration.get(p_code);
  }
}

/* Location:
 * Qualified Name:     ConstantesFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
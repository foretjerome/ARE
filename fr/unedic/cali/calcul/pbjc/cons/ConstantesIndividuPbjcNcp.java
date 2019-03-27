package fr.unedic.cali.calcul.pbjc.cons;

import java.util.HashMap;
import java.util.Map;

public class ConstantesIndividuPbjcNcp
{
  public static final String JUSTIFICATION_RETRAITE_TRIMESTRES_ASSEDIC = "A";
  public static final String JUSTIFICATION_RETRAITE_IMPOSEE_ASSEDIC = "I";
  public static final String JUSTIFICATION_RETRAITE_TRIMESTRES_CNAVTS = "C";
  public static final String JUSTIFICATION_RETRAITE_65_ANS = "L";
  public static final String JUSTIFICATION_RETRAITE_60_ANS = "X";
  public static final String JUSTIFICATION_RETRAITE_TRIMESTRES_NON_CONNUS = "Y";
  public static final Map LIB_JUSTIFICATION_RETRAITE = new HashMap();
  
  static
  {
    LIB_JUSTIFICATION_RETRAITE.put("A", "TRIMESTRES ASSEDIC");
    LIB_JUSTIFICATION_RETRAITE.put("I", "IMPOSEE ASSEDIC");
    LIB_JUSTIFICATION_RETRAITE.put("C", "TRIMESTRES CNAVTS");
    LIB_JUSTIFICATION_RETRAITE.put("L", "65 ANS");
    LIB_JUSTIFICATION_RETRAITE.put("X", "60 ANS");
    LIB_JUSTIFICATION_RETRAITE.put("Y", "TRIMESTRES NON CONNUS");
  }
}

/* Location:
 * Qualified Name:     ConstantesIndividuPbjcNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
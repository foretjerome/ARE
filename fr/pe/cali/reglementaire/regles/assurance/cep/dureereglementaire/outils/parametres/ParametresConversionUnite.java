package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.parametres;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParametresConversionUnite
{
  private Map<String, BigDecimal> parametres = new HashMap();
  private static ParametresConversionUnite instance = new ParametresConversionUnite();
  
  private ParametresConversionUnite()
  {
    parametres.put("23", BigDecimal.valueOf(1.4D));
    parametres.put("18", BigDecimal.valueOf(0.2D));
    parametres.put("16", BigDecimal.ONE);
    parametres.put("15", BigDecimal.valueOf(1.43D));
  }
  
  public BigDecimal getCoefficientPourUnite(String unite)
  {
    return (BigDecimal)parametres.get(unite);
  }
  
  public static ParametresConversionUnite getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ParametresConversionUnite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
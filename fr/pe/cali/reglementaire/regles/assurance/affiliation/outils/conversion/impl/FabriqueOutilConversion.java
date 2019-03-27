package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.conversion.spec.IOutilConversionPma;
import java.util.HashMap;
import java.util.Map;

class FabriqueOutilConversion
{
  private static Map<String, IOutilConversionPma> outils = new HashMap();
  private static FabriqueOutilConversion instance = new FabriqueOutilConversion();
  
  private FabriqueOutilConversion()
  {
    outils.put("RG", new OutilConversionRegimeGeneral());
    outils.put("RGP", new OutilConversionRegimeGeneral());
    outils.put("RG5", new OutilConversionRegimeGeneral());
    outils.put("A1", new OutilConversionRegimeGeneral());
    outils.put("A2a", new OutilConversionAnnexe2A());
    outils.put("A2b", new OutilConversionAnnexe2B());
    outils.put("A3", new OutilConversionAnnexe3());
    outils.put("A5", new OutilConversionAnnexe5());
    outils.put("A8", new OutilConversionAnnexe8et10());
    outils.put("A9A", new OutilConversionRegimeGeneral());
    outils.put("A9B", new OutilConversionRegimeGeneral());
    outils.put("A10", new OutilConversionAnnexe8et10());
  }
  
  public static FabriqueOutilConversion getInstance()
  {
    return instance;
  }
  
  public IOutilConversionPma recupererOutilConversion(String nomReglement)
  {
    return (IOutilConversionPma)outils.get(nomReglement);
  }
}

/* Location:
 * Qualified Name:     FabriqueOutilConversion
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
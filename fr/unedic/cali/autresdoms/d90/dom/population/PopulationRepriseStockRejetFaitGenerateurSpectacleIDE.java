package fr.unedic.cali.autresdoms.d90.dom.population;

public class PopulationRepriseStockRejetFaitGenerateurSpectacleIDE
  extends PopulationRepriseStockAvecUneDateEtRequeteSimpleAbstraite
{
  private static final String LIBELLE = "INC0336375 Rejet FGD Spectacle IDE";
  private static final String REQUETE = "SELECT CXALAF, MIN(DIEXA) FROM P1299C_DECISION WHERE CPROD IN ('ASU_SPE02_05', 'ASU_SPE02_06') AND CDEXA1 = '5'  AND CMRJN = 41 AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXALAF WITH UR;";
  
  public PopulationRepriseStockRejetFaitGenerateurSpectacleIDE()
  {
    super("INC0336375 Rejet FGD Spectacle IDE", "SELECT CXALAF, MIN(DIEXA) FROM P1299C_DECISION WHERE CPROD IN ('ASU_SPE02_05', 'ASU_SPE02_06') AND CDEXA1 = '5'  AND CMRJN = 41 AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXALAF WITH UR;");
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockRejetFaitGenerateurSpectacleIDE
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
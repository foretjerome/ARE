package fr.unedic.cali.autresdoms.d90.dom.population;

public class PopulationRepriseStockINC0406843
  extends PopulationRepriseStockAvecUneDateEtRequeteSimpleAbstraite
{
  private static final String LIBELLE = "INC0406843 code produit SPE17";
  private static final String REQUETE = "SELECT CXALAF, MIN(DDPJB) FROM P1200Z_PBJCNCP WHERE CPROD = 'ASU_SPE02_06' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXALAF WITH UR;";
  
  public PopulationRepriseStockINC0406843()
  {
    super("INC0406843 code produit SPE17", "SELECT CXALAF, MIN(DDPJB) FROM P1200Z_PBJCNCP WHERE CPROD = 'ASU_SPE02_06' AND CXASS = ? AND CXALAF >= ? AND CXALAF <= ? GROUP BY CXALAF WITH UR;");
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockINC0406843
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
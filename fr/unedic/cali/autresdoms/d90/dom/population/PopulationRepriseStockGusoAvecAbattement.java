package fr.unedic.cali.autresdoms.d90.dom.population;

public class PopulationRepriseStockGusoAvecAbattement
  extends PopulationRepriseStockAvecUneDateEtRequeteSimpleAbstraite
{
  private static final String LIBELLE = "INC0336153 - Guso avec abattement";
  private static final String REQUETE = "SELECT S.CXALAF, MIN(S.PERIODE_D) FROM P1111H_SALAIRE S INNER JOIN P1110G_ORIGINE O ON O.CXASS = S.CXASS AND O.CXALAF = S.CXALAF AND O.FK_PER_ACTIVITE_ID = S.FK_PER_ACTIVITE_ID WHERE S.ABATTEMENT IS NOT NULL AND S.ABATTEMENT > 0 AND O.CODE IN( '005', '006') AND ((S.DATE_PAIEMENT IS NOT NULL AND S.DATE_PAIEMENT >= '2017-07-01') OR (S.DATE_PAIEMENT IS NULL AND S.PERIODE_F >= '2017-07-01')) AND S.CXASS = ? AND S.CXALAF >= ? AND S.CXALAF <= ? GROUP BY S.CXASS, S.CXALAF WITH UR; ";
  
  public PopulationRepriseStockGusoAvecAbattement()
  {
    super("INC0336153 - Guso avec abattement", "SELECT S.CXALAF, MIN(S.PERIODE_D) FROM P1111H_SALAIRE S INNER JOIN P1110G_ORIGINE O ON O.CXASS = S.CXASS AND O.CXALAF = S.CXALAF AND O.FK_PER_ACTIVITE_ID = S.FK_PER_ACTIVITE_ID WHERE S.ABATTEMENT IS NOT NULL AND S.ABATTEMENT > 0 AND O.CODE IN( '005', '006') AND ((S.DATE_PAIEMENT IS NOT NULL AND S.DATE_PAIEMENT >= '2017-07-01') OR (S.DATE_PAIEMENT IS NULL AND S.PERIODE_F >= '2017-07-01')) AND S.CXASS = ? AND S.CXALAF >= ? AND S.CXALAF <= ? GROUP BY S.CXASS, S.CXALAF WITH UR; ");
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockGusoAvecAbattement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
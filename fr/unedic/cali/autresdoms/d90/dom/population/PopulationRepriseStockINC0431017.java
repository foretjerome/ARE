package fr.unedic.cali.autresdoms.d90.dom.population;

public class PopulationRepriseStockINC0431017
  extends PopulationRepriseStockAvecUneDateEtRequeteSimpleAbstraite
{
  private static final String LIBELLE = "INC0431017 dernier sinistre";
  private static final String REQUETE = "select decision.cxalaf, min(decision.diexa) from P1210R_01DEMANDE demande inner join P1299A_demande demandeP on demande.cxass = demandeP.cxass and demande.cxalaf = demandeP.cxalaf and demande.dde_pivot_id = demandeP.cxnum inner join P1299C_DECISION decision on decision.cxass = demandeP.cxass and decision.cxalaf = demandeP.cxalaf and decision.cxnum = demandeP.cxnumb WHERE DEMANDE.DTE_DEPOT_ORIG > '2017-12-31' AND DEMANDE.TYPE_CLASS_ERE = '0389' AND decision.CXASS = ? AND decision.CXALAF >= ? AND decision.CXALAF <= ? GROUP BY decision.CXALAF WITH UR;";
  
  public PopulationRepriseStockINC0431017()
  {
    super("INC0431017 dernier sinistre", "select decision.cxalaf, min(decision.diexa) from P1210R_01DEMANDE demande inner join P1299A_demande demandeP on demande.cxass = demandeP.cxass and demande.cxalaf = demandeP.cxalaf and demande.dde_pivot_id = demandeP.cxnum inner join P1299C_DECISION decision on decision.cxass = demandeP.cxass and decision.cxalaf = demandeP.cxalaf and decision.cxnum = demandeP.cxnumb WHERE DEMANDE.DTE_DEPOT_ORIG > '2017-12-31' AND DEMANDE.TYPE_CLASS_ERE = '0389' AND decision.CXASS = ? AND decision.CXALAF >= ? AND decision.CXALAF <= ? GROUP BY decision.CXALAF WITH UR;");
  }
}

/* Location:
 * Qualified Name:     PopulationRepriseStockINC0431017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
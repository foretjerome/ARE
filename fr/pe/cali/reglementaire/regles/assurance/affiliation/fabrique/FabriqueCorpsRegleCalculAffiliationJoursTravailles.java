package fr.pe.cali.reglementaire.regles.assurance.affiliation.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilCalculAffiliationJoursTravailles;

public class FabriqueCorpsRegleCalculAffiliationJoursTravailles
  extends FabriqueCorpsRegle
{
  private static FabriqueCorpsRegleCalculAffiliationJoursTravailles instance = new FabriqueCorpsRegleCalculAffiliationJoursTravailles();
  
  private FabriqueCorpsRegleCalculAffiliationJoursTravailles()
  {
    setNomCorpsRegle("CalculAffiliationJoursTravailles");
  }
  
  public static FabriqueCorpsRegleCalculAffiliationJoursTravailles getInstance()
  {
    return instance;
  }
  
  public IOutilCalculAffiliationJoursTravailles recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilCalculAffiliationJoursTravailles)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsRegleCalculAffiliationJoursTravailles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
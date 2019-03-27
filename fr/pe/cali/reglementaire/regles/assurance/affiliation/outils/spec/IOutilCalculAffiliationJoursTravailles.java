package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.DonneesEntreeCalculAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.ResultatCalculAffiliationJoursTravailles;

public abstract interface IOutilCalculAffiliationJoursTravailles
  extends IOutilCorpsRegle
{
  public abstract ResultatCalculAffiliationJoursTravailles calculer(DonneesEntreeCalculAffiliationJoursTravailles paramDonneesEntreeCalculAffiliationJoursTravailles);
}

/* Location:
 * Qualified Name:     IOutilCalculAffiliationJoursTravailles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
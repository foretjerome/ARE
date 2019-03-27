package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;

public abstract interface IOutilPeriodeNonAssimilable
  extends IOutilCorpsRegle
{
  public abstract boolean estAssimilable(IncidentSpec paramIncidentSpec, IOutilFonctionnelAffiliationJoursTravailles paramIOutilFonctionnelAffiliationJoursTravailles);
}

/* Location:
 * Qualified Name:     IOutilPeriodeNonAssimilable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
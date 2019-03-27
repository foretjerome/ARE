package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilFonctionnel;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.dom.ResultatCalculAffiliationJoursTravailles;
import fr.unedic.cali.dom.affectation.ContexteDemandeSpec;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;
import java.util.Map;

public abstract interface IOutilFonctionnelAffiliationJoursTravailles
  extends IOutilFonctionnel
{
  public abstract Map<Integer, Chronologie> determinerChronologieActivitesParticipantes(Chronologie paramChronologie, ResultatCalculAffiliationJoursTravailles paramResultatCalculAffiliationJoursTravailles, List<ContexteDemandeSpec> paramList, Periode paramPeriode, Damj paramDamj);
  
  public abstract ChronologiePeriodes recupererPeriodesHorsChamp();
}

/* Location:
 * Qualified Name:     IOutilFonctionnelAffiliationJoursTravailles
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
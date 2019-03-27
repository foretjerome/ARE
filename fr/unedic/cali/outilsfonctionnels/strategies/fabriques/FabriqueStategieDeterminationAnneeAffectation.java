package fr.unedic.cali.outilsfonctionnels.strategies.fabriques;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.fabriques.FabriqueStrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationAnneeAffectationAfafApres;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationAnneeAffectationApres;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieDeterminationAnneeAffectationAvant;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieSpec;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieDeterminationAnneeAffectationSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class FabriqueStategieDeterminationAnneeAffectation
  implements FabriqueStrategieSpec
{
  public static final Damj DATE_PIVOT = new Damj(2011, 12, 1);
  
  public StrategieSpec getStrategie(CritereStrategie p_critereStrategie)
    throws CoucheLogiqueException
  {
    StrategieDeterminationAnneeAffectationSpec strategie = null;
    
    Damj datePivot = p_critereStrategie.getDatePivot();
    DemandeSpec demande = p_critereStrategie.getDemande();
    if (datePivot == null) {
      throw new UnsupportedOperationException("FabriqueStrategieDeterminationAnneeAffectationSpec : la date pivot année affectation spectacle est nulle.");
    }
    if (datePivot.estApresOuCoincideAvec(DATE_PIVOT))
    {
      if ((demande != null) && ("FOR_03".equals(demande.getEvenementReferenceExamen().getTypeExamen()))) {
        strategie = new StrategieDeterminationAnneeAffectationApres();
      } else {
        strategie = new StrategieDeterminationAnneeAffectationAfafApres();
      }
    }
    else {
      strategie = new StrategieDeterminationAnneeAffectationAvant();
    }
    return strategie;
  }
}

/* Location:
 * Qualified Name:     FabriqueStategieDeterminationAnneeAffectation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
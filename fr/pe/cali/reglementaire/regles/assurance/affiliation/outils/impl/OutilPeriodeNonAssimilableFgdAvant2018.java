package fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilFonctionnelAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.outils.spec.IOutilPeriodeNonAssimilable;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Periode;

public class OutilPeriodeNonAssimilableFgdAvant2018
  implements IOutilPeriodeNonAssimilable
{
  private static final String NOM_OUTIL = "OutilPeriodeAssimilableFgdAvant2018";
  
  public boolean estAssimilable(IncidentSpec incident, IOutilFonctionnelAffiliationJoursTravailles outilFonctionnel)
  {
    boolean estAssimilable;
    boolean estAssimilable;
    if (incident.getNature() == 14)
    {
      estAssimilable = false;
    }
    else
    {
      boolean estAssimilable;
      if ((incident.getNature() == 10) || (incident.getNature() == 11) || (incident.getNature() == 49))
      {
        estAssimilable = true;
      }
      else
      {
        ChronologiePeriodes chronologiePeriodesHorsChamp = outilFonctionnel.recupererPeriodesHorsChamp();
        boolean incidentPendantActiviteHorsChamp = incident.getPeriode().inter(chronologiePeriodesHorsChamp) == incident.getPeriode().getDuree();
        
        estAssimilable = !incidentPendantActiviteHorsChamp;
      }
    }
    return estAssimilable;
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return true;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilPeriodeNonAssimilableFgdAvant2018();
  }
  
  public String getNomOutil()
  {
    return "OutilPeriodeAssimilableFgdAvant2018";
  }
}

/* Location:
 * Qualified Name:     OutilPeriodeNonAssimilableFgdAvant2018
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
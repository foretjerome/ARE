package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class OutilConstitutionDelaisReportsAfd2017
  extends OutilConstitutionDelaisReportsFps2017
{
  public static OutilConstitutionDelaisReportsAfd2017 getInstance()
  {
    return new OutilConstitutionDelaisReportsAfd2017();
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConstitutionDelaisReportsAfd2017();
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return true;
  }
  
  public int calculerReliquatFranchise(int reliquatDroitPrecedent, Periode periodeApplication, Damj dateAttribution)
  {
    int reliquatARetourner = 0;
    if (periodeApplication != null)
    {
      int reliquat = reliquatDroitPrecedent - dateAttribution.veille().joursEntre(periodeApplication.getFin());
      if (reliquat > 0) {
        reliquatARetourner = reliquat;
      }
    }
    return reliquatARetourner;
  }
}

/* Location:
 * Qualified Name:     OutilConstitutionDelaisReportsAfd2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
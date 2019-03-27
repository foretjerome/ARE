package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.DonneesEntreesDelaisReportsSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.ResultatDelaisReportsSpectacle;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class OutilConstitutionDelaisReportsFps2017
  extends OutilConstitutionDelaisReportsSpectacle2016
{
  public static OutilConstitutionDelaisReportsFps2017 getInstance()
  {
    return new OutilConstitutionDelaisReportsFps2017();
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConstitutionDelaisReportsFps2017();
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return true;
  }
  
  public ResultatDelaisReportsSpectacle estDiffereApplicable(DonneesEntreesDelaisReportsSpectacle donneesEntree)
  {
    ResultatDelaisReportsSpectacle retour = new ResultatDelaisReportsSpectacle();
    retour.setAppliquerDiffere(false);
    retour.setDelaiAttentePrecedent(null);
    retour.setNombreJoursDelaiAttente(0);
    return retour;
  }
  
  public int calculerReliquatCarenceDiffere7Jours(int reliquatDiffere, Periode periodeApplication, Damj dateAttribution)
  {
    return 0;
  }
  
  protected Periode determinerPeriodeCalculFranchiseCp(Periode pra, Damj dateDernierFgd)
  {
    Periode resultat = new Periode(pra.getDebut(), pra.getFin());
    if ((dateDernierFgd != null) && (dateDernierFgd.estApres(pra.getDebut()))) {
      resultat.setDebut(dateDernierFgd.lendemain());
    }
    return resultat;
  }
}

/* Location:
 * Qualified Name:     OutilConstitutionDelaisReportsFps2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p07;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementCalculAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementPeriodesSuspenduesNonAssimilablesAvant2018;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.changements.ChangementConstitutionDureeReglementaireConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.changements.ChangementReglementApplicableConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.changements.ChangementCorpsRegleDiviseur;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public final class ChangementConvention2017
  extends Changement
{
  private static final String NOM = "Convention Are 2017";
  private static ChangementConvention2017 instance = new ChangementConvention2017();
  
  private ChangementConvention2017()
  {
    try
    {
      Damj debutChangement = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de durée réglementaire 2017");
      Damj finChangement = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de debut du 2eme changement convention 2017").veille();
      setLibelle("Convention Are 2017");
      setPeriodeApplication(new Periode(debutChangement, finChangement));
      initialiserCollectionChangementsCorpsRegle();
      ajouterChangementCorpsRegle("ConstitutionDureeReglementaire", ChangementConstitutionDureeReglementaireConvention2017.getInstance());
      ajouterChangementCorpsRegle("CalculAffiliationJoursTravailles", ChangementCalculAffiliationJoursTravailles.getInstance());
      ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementConvention2017.getInstance());
      ajouterChangementCorpsRegle("ConstitutionReglementApplicable", ChangementReglementApplicableConvention2017.getInstance());
      ajouterChangementCorpsRegle("ConstitutionSjrCalculDiviseur", ChangementCorpsRegleDiviseur.getInstance());
      ajouterChangementCorpsRegle("PeriodeSuspendueNonAssimilable", ChangementPeriodesSuspenduesNonAssimilablesAvant2018.getInstance());
    }
    catch (CoucheLogiqueException e)
    {
      throw new ApplicativeRuntimeException(e.getCode(), e);
    }
  }
  
  public static ChangementConvention2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p07;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementCalculAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementPeriodesSuspenduesNonAssimilablesApres2018;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.changements.ChangementConstitutionDureeReglementaireConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.changements.ChangementReglementApplicableConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.changements.ChangementCorpsRegleDiviseur;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ChangementConvention2017APartirJanvier2018
  extends Changement
{
  private static final String NOM = "Convention Are 2017 a partir du 01/01/18";
  private static ChangementConvention2017APartirJanvier2018 instance = new ChangementConvention2017APartirJanvier2018();
  
  private ChangementConvention2017APartirJanvier2018()
  {
    try
    {
      Damj debutChangement = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de debut du 2eme changement convention 2017");
      setLibelle("Convention Are 2017 a partir du 01/01/18");
      setPeriodeApplication(new Periode(debutChangement, Damj.FIN_DES_TEMPS));
      initialiserCollectionChangementsCorpsRegle();
      ajouterChangementCorpsRegle("ConstitutionDureeReglementaire", ChangementConstitutionDureeReglementaireConvention2017.getInstance());
      ajouterChangementCorpsRegle("CalculAffiliationJoursTravailles", ChangementCalculAffiliationJoursTravailles.getInstance());
      ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementConvention2017.getInstance());
      ajouterChangementCorpsRegle("ConstitutionReglementApplicable", ChangementReglementApplicableConvention2017.getInstance());
      ajouterChangementCorpsRegle("ConstitutionSjrCalculDiviseur", ChangementCorpsRegleDiviseur.getInstance());
      ajouterChangementCorpsRegle("PeriodeSuspendueNonAssimilable", ChangementPeriodesSuspenduesNonAssimilablesApres2018.getInstance());
    }
    catch (CoucheLogiqueException e)
    {
      throw new ApplicativeRuntimeException(e.getCode(), e);
    }
  }
  
  public static ChangementConvention2017APartirJanvier2018 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConvention2017APartirJanvier2018
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
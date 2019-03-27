package fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p06;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementCalculAffiliationJoursTravailles;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementPeriodesSuspenduesNonAssimilablesAvant2018;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementConvention2017ClauseSauvegarde;
import fr.pe.cali.reglementaire.regles.assurance.cep.sjr.diviseur.changements.ChangementCorpsRegleDiviseur;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ChangementConvention2017
  extends Changement
{
  private static final String NOM = "Convention Are 2017";
  private static ChangementConvention2017 instance = new ChangementConvention2017();
  
  private ChangementConvention2017()
  {
    setLibelle("Convention Are 2017");
    Damj dateDebut = Parametres.getProduit(73).getPeriodeValidite().getDebut();
    Damj dateFin = null;
    try
    {
      dateFin = GestionnaireDateApplication.getInstance().recupererDateApplication("Date de debut du 2eme changement convention 2017").veille();
    }
    catch (CoucheLogiqueException e) {}
    setPeriodeApplication(new Periode(dateDebut, dateFin));
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("CalculAffiliationJoursTravailles", ChangementCalculAffiliationJoursTravailles.getInstance());
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementConvention2017ClauseSauvegarde.getInstance());
    ajouterChangementCorpsRegle("ConstitutionSjrCalculDiviseur", ChangementCorpsRegleDiviseur.getInstance());
    ajouterChangementCorpsRegle("PeriodeSuspendueNonAssimilable", ChangementPeriodesSuspenduesNonAssimilablesAvant2018.getInstance());
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
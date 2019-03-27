package fr.pe.cali.reglementaire.decors.changements.assurance.ssp07.p05;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.changements.ChangementConditionBeneficeAutreProduitConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.changements.ChangementConstitutionDateLimiteAPS;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.changements.ChangementConstitutionDelaisReportsFps2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementAps2017
  extends Changement
{
  private static final String NOM = "Nouvelle convention APS 2017";
  private static ChangementAps2017 instance = new ChangementAps2017();
  
  private ChangementAps2017()
  {
    setLibelle("Nouvelle convention APS 2017");
    ProduitSpec produit = Parametres.getProduit(75);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("ConstitutionDelaisReports", ChangementConstitutionDelaisReportsFps2017.getInstance());
    ajouterChangementCorpsRegle("ConstitutionDateLimite", ChangementConstitutionDateLimiteAPS.getInstance());
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementConvention2017.getInstance());
    ajouterChangementCorpsRegle("conditionBeneficeAutreProduit", ChangementConditionBeneficeAutreProduitConvention2017.getInstance());
  }
  
  public static ChangementAps2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementAps2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
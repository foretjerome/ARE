package fr.pe.cali.reglementaire.decors.changements.assurance.fds12.p03;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.changements.ChangementConditionBeneficeAutreProduitConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.changements.ChangementConstitutionDateLimiteSpectacle2016;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.changements.ChangementConstitutionDelaisReportsAfd2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementAfd2017
  extends Changement
{
  private static final String NOM = "Nouvelle convention AFD 2017";
  private static ChangementAfd2017 instance = new ChangementAfd2017();
  
  private ChangementAfd2017()
  {
    setLibelle("Nouvelle convention AFD 2017");
    ProduitSpec produit = Parametres.getProduit(76);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("ConstitutionDelaisReports", ChangementConstitutionDelaisReportsAfd2017.getInstance());
    ajouterChangementCorpsRegle("ConstitutionDateLimite", ChangementConstitutionDateLimiteSpectacle2016.getInstance());
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementConvention2017.getInstance());
    ajouterChangementCorpsRegle("conditionBeneficeAutreProduit", ChangementConditionBeneficeAutreProduitConvention2017.getInstance());
  }
  
  public static ChangementAfd2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementAfd2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
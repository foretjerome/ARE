package fr.pe.cali.reglementaire.decors.changements.assurance.spe02;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.changements.ChangementConstitutionDateLimiteSpectacle2016;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.changements.ChangementConstitutionDelaisReportsSpectacle2016;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public final class ChangementSpectacle2016
  extends Changement
{
  private static final String NOM = "Nouvelle convention Spectacle 2016";
  private static ChangementSpectacle2016 instance = new ChangementSpectacle2016();
  
  private ChangementSpectacle2016()
  {
    setLibelle("Nouvelle convention Spectacle 2016");
    ProduitSpec produit = Parametres.getProduit(71);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("ConstitutionDelaisReports", ChangementConstitutionDelaisReportsSpectacle2016.getInstance());
    ajouterChangementCorpsRegle("ConstitutionDateLimite", ChangementConstitutionDateLimiteSpectacle2016.getInstance());
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
  }
  
  public static ChangementSpectacle2016 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementSpectacle2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.decors.changements.assurance.spe02.p06;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.changements.ChangementConstitutionDateLimiteSpectacle2016;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.changements.ChangementConstitutionDelaisReportsSpectacle2016;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementSpectacle2017
  extends Changement
{
  private static final String NOM = "Nouvelle convention Spectacle 2017";
  private static ChangementSpectacle2017 instance = new ChangementSpectacle2017();
  
  private ChangementSpectacle2017()
  {
    setLibelle("Nouvelle convention Spectacle 2017");
    ProduitSpec produit = Parametres.getProduit(74);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("ConstitutionDelaisReports", ChangementConstitutionDelaisReportsSpectacle2016.getInstance());
    ajouterChangementCorpsRegle("ConstitutionDateLimite", ChangementConstitutionDateLimiteSpectacle2016.getInstance());
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementConvention2017.getInstance());
  }
  
  public static ChangementSpectacle2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementSpectacle2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
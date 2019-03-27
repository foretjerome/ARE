package fr.pe.cali.reglementaire.decors.changements.assurance.spe02;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementSpectacle2014
  extends Changement
{
  private static final String NOM = "Convention Spectacle 2014";
  private static ChangementSpectacle2014 instance = new ChangementSpectacle2014();
  
  private ChangementSpectacle2014()
  {
    setLibelle("Convention Spectacle 2014");
    ProduitSpec produit = Parametres.getProduit(64);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
  }
  
  public static ChangementSpectacle2014 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementSpectacle2014
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
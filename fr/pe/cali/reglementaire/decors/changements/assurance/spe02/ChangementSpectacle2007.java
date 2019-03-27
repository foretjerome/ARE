package fr.pe.cali.reglementaire.decors.changements.assurance.spe02;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementSpectacle2007
  extends Changement
{
  private static final String NOM = "Convention Spectacle 2007";
  private static ChangementSpectacle2007 instance = new ChangementSpectacle2007();
  
  private ChangementSpectacle2007()
  {
    setLibelle("Convention Spectacle 2007");
    ProduitSpec produit = Parametres.getProduit(20);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
  }
  
  public static ChangementSpectacle2007 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementSpectacle2007
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
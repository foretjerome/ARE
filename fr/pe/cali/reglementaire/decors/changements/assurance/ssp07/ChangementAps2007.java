package fr.pe.cali.reglementaire.decors.changements.assurance.ssp07;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementAps2007
  extends Changement
{
  private static final String NOM = "Convention APS 2007";
  private static ChangementAps2007 instance = new ChangementAps2007();
  
  private ChangementAps2007()
  {
    setLibelle("Convention APS 2007");
    ProduitSpec produit = Parametres.getProduit(27);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
  }
  
  public static ChangementAps2007 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementAps2007
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
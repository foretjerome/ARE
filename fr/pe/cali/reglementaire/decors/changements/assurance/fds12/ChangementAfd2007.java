package fr.pe.cali.reglementaire.decors.changements.assurance.fds12;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementAfd2007
  extends Changement
{
  private static final String NOM = "Convention AFD 2007";
  private static ChangementAfd2007 instance = new ChangementAfd2007();
  
  private ChangementAfd2007()
  {
    setLibelle("Convention AFD 2007");
    ProduitSpec produit = Parametres.getProduit(29);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
  }
  
  public static ChangementAfd2007 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementAfd2007
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
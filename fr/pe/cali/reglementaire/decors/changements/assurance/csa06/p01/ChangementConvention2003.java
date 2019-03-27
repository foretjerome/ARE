package fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p01;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementPeriodesSuspenduesNonAssimilablesAvant2018;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementConvention2003
  extends Changement
{
  private static final String NOM = "Convention Are 2003";
  private static ChangementConvention2003 instance = new ChangementConvention2003();
  
  private ChangementConvention2003()
  {
    setLibelle("Convention Are 2003");
    ProduitSpec produit = Parametres.getProduit(8);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
    ajouterChangementCorpsRegle("PeriodeSuspendueNonAssimilable", ChangementPeriodesSuspenduesNonAssimilablesAvant2018.getInstance());
  }
  
  public static final ChangementConvention2003 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConvention2003
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
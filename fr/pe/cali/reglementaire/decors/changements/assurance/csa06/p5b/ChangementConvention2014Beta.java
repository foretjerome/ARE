package fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p5b;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementPeriodesSuspenduesNonAssimilablesAvant2018;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementConvention2014Beta
  extends Changement
{
  private static final String NOM = "Convention Are 2014 Beta";
  private static ChangementConvention2014Beta instance = new ChangementConvention2014Beta();
  
  private ChangementConvention2014Beta()
  {
    setLibelle("Convention Are 2014 Beta");
    ProduitSpec produit = Parametres.getProduit(63);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
    ajouterChangementCorpsRegle("PeriodeSuspendueNonAssimilable", ChangementPeriodesSuspenduesNonAssimilablesAvant2018.getInstance());
  }
  
  public static final ChangementConvention2014Beta getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConvention2014Beta
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
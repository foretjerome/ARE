package fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p05;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementPeriodesSuspenduesNonAssimilablesAvant2018;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementConvention2014
  extends Changement
{
  private static final String NOM = "Convention Are 2014";
  private static ChangementConvention2014 instance = new ChangementConvention2014();
  
  private ChangementConvention2014()
  {
    setLibelle("Convention Are 2014");
    ProduitSpec produit = Parametres.getProduit(61);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
    ajouterChangementCorpsRegle("PeriodeSuspendueNonAssimilable", ChangementPeriodesSuspenduesNonAssimilablesAvant2018.getInstance());
  }
  
  public static final ChangementConvention2014 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConvention2014
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p04;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementPeriodesSuspenduesNonAssimilablesAvant2018;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementConvention2011
  extends Changement
{
  private static final String NOM = "Convention Are 2011";
  private static ChangementConvention2011 instance = new ChangementConvention2011();
  
  private ChangementConvention2011()
  {
    setLibelle("Convention Are 2011");
    ProduitSpec produit = Parametres.getProduit(49);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
    ajouterChangementCorpsRegle("PeriodeSuspendueNonAssimilable", ChangementPeriodesSuspenduesNonAssimilablesAvant2018.getInstance());
  }
  
  public static final ChangementConvention2011 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConvention2011
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p04;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementPeriodesSuspenduesNonAssimilablesAvant2018;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.changements.ChangementReglementApplicableInitial;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementConvention2009
  extends Changement
{
  private static final String NOM = "Convention Are 2009";
  private static ChangementConvention2009 instance = new ChangementConvention2009();
  
  private ChangementConvention2009()
  {
    setLibelle("Convention Are 2009");
    ProduitSpec produit = Parametres.getProduit(31);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
    ajouterChangementCorpsRegle("ConstitutionReglementApplicable", ChangementReglementApplicableInitial.getInstance());
    ajouterChangementCorpsRegle("PeriodeSuspendueNonAssimilable", ChangementPeriodesSuspenduesNonAssimilablesAvant2018.getInstance());
  }
  
  public static final ChangementConvention2009 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConvention2009
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.decors.changements.assurance.cva10.p01;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.changements.ChangementPeriodesSuspenduesNonAssimilablesAvant2018;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.changements.ChangementAccesListeUniteReglementAvantConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.changements.ChangementReglementApplicableInitial;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ChangementInitial
  extends Changement
{
  private static final String NOM = "Changement Initial ASR DC";
  private static ChangementInitial instance = new ChangementInitial();
  
  private ChangementInitial()
  {
    setLibelle("Changement Initial ASR DC");
    ProduitSpec produit = Parametres.getProduit(36);
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("AccesListeUniteReglement", ChangementAccesListeUniteReglementAvantConvention2017.getInstance());
    ajouterChangementCorpsRegle("ConstitutionReglementApplicable", ChangementReglementApplicableInitial.getInstance());
    ajouterChangementCorpsRegle("PeriodeSuspendueNonAssimilable", ChangementPeriodesSuspenduesNonAssimilablesAvant2018.getInstance());
  }
  
  public static final ChangementInitial getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementInitial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
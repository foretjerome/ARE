package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.strategies;

import fr.unedic.cali.affectation.parametres.CriteresQualification;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.strategies.spec.StrategieCoordinationEuropeenneQualificationSpec;
import java.util.Collection;

public class StrategieCoordinationEuropeenneQualificationAvant
  implements StrategieCoordinationEuropeenneQualificationSpec
{
  public Reglement determineReglementPeriodeEnCoordinationEuropeenne(ActiviteSalarie activiteSalarie)
  {
    Reglement reglementPeriodeRetourne = null;
    
    boolean isCoordCEE = activiteSalarie.getCriteresQualification().isCoordinationCEE();
    if (isCoordCEE)
    {
      boolean activiteE301ArtisteQualifiableA10 = (activiteSalarie.getCollectionOrigineInformationPAS().contains(Integer.valueOf(10))) && (activiteSalarie.getCategorieEmploiParticulier() == 21);
      if (!activiteE301ArtisteQualifiableA10)
      {
        DecorReglementaire decor = activiteSalarie.getCriteresQualification().getDecor();
        ProduitSpec produitParDefaut = decor.getProduitParDefaut();
        if (produitParDefaut != null) {
          reglementPeriodeRetourne = Reglement.getInstance("RG", produitParDefaut);
        }
      }
    }
    return reglementPeriodeRetourne;
  }
}

/* Location:
 * Qualified Name:     StrategieCoordinationEuropeenneQualificationAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
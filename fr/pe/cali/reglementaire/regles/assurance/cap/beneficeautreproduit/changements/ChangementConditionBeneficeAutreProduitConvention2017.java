package fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.changements;

import fr.pe.cali.reglementaire.decors.changements.ChangementCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.impl.OutilConditionBeneficeAutreProduitFPS2017;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.impl.OutilConditionSatisfaite;

public class ChangementConditionBeneficeAutreProduitConvention2017
  extends ChangementCorpsRegle
{
  private static ChangementConditionBeneficeAutreProduitConvention2017 instance = new ChangementConditionBeneficeAutreProduitConvention2017();
  
  private ChangementConditionBeneficeAutreProduitConvention2017()
  {
    setNomCorpsRegle("conditionBeneficeAutreProduit");
    initialiserListeCorpsRegles();
    ajouterCorpsRegle(OutilConditionBeneficeAutreProduitFPS2017.getInstance());
    ajouterCorpsRegle(OutilConditionSatisfaite.getInstance());
  }
  
  public static ChangementConditionBeneficeAutreProduitConvention2017 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConditionBeneficeAutreProduitConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
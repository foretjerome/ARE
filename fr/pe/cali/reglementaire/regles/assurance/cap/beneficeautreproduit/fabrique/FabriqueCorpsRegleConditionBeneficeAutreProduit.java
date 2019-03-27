package fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.spec.IOutilConditionBeneficeAutreProduit;

public class FabriqueCorpsRegleConditionBeneficeAutreProduit
  extends FabriqueCorpsRegle
{
  private static FabriqueCorpsRegleConditionBeneficeAutreProduit instance;
  
  private FabriqueCorpsRegleConditionBeneficeAutreProduit()
  {
    setNomCorpsRegle("conditionBeneficeAutreProduit");
  }
  
  public static FabriqueCorpsRegleConditionBeneficeAutreProduit getInstance()
  {
    if (instance == null) {
      instance = new FabriqueCorpsRegleConditionBeneficeAutreProduit();
    }
    return instance;
  }
  
  public IOutilConditionBeneficeAutreProduit recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilConditionBeneficeAutreProduit)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueCorpsRegleConditionBeneficeAutreProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
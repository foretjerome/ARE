package fr.pe.cali.reglementaire.decors.changements.inr.ces06;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.changements.ChangementConditionBeneficiaireAAH;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ChangementConditionAAH
  extends Changement
{
  private static final String NOM = "ACCRE : Condition bénéficiaire AAH";
  private static Damj debutChangement = null;
  
  static
  {
    try
    {
      debutChangement = GestionnaireDateApplication.getInstance().recupererDateApplication("Date d'application du non cumul ASS et AAH");
    }
    catch (CoucheLogiqueException e) {}
  }
  
  private static Damj finChangement = Damj.FIN_DES_TEMPS;
  private static ChangementConditionAAH instance;
  
  private ChangementConditionAAH()
  {
    setLibelle("ACCRE : Condition bénéficiaire AAH");
    setPeriodeApplication(new Periode(debutChangement, finChangement));
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("conditionBeneficiaireAAH", ChangementConditionBeneficiaireAAH.getInstance());
  }
  
  public static ChangementConditionAAH getInstance()
  {
    if (instance == null) {
      instance = new ChangementConditionAAH();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementConditionAAH
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
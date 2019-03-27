package fr.pe.cali.reglementaire.decors.changements.solidarite.cpa02;

import fr.pe.cali.reglementaire.decors.changements.Changement;
import fr.pe.cali.reglementaire.regles.solidarite.cap.beneficiaireaah.changements.ChangementCorpsRegleInitial;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ChangementInitial
  extends Changement
{
  private static final String NOM = "Convention Solidarité CPA";
  private static Damj debutChangement = null;
  private static Damj finChangement = null;
  private static ChangementInitial instance;
  
  static
  {
    debutChangement = new Damj(2003, 1, 1);
    try
    {
      finChangement = GestionnaireDateApplication.getInstance().recupererDateApplication("Date d'application du non cumul ASS et AAH").veille();
    }
    catch (CoucheLogiqueException e) {}
  }
  
  private ChangementInitial()
  {
    setLibelle("Convention Solidarité CPA");
    setPeriodeApplication(new Periode(debutChangement, finChangement));
    initialiserCollectionChangementsCorpsRegle();
    ajouterChangementCorpsRegle("conditionBeneficiaireAAH", ChangementCorpsRegleInitial.getInstance());
  }
  
  public static ChangementInitial getInstance()
  {
    if (instance == null) {
      instance = new ChangementInitial();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     ChangementInitial
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
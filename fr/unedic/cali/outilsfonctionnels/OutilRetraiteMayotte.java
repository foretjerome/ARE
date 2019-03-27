package fr.unedic.cali.outilsfonctionnels;

import fr.pe.cali.reglementaire.parametres.retraite.ParametresRetraiteMayotte;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class OutilRetraiteMayotte
  extends OutilRetraite
{
  private static OutilRetraiteMayotte instance;
  
  public static OutilRetraiteMayotte getInstance()
  {
    if (instance == null) {
      instance = new OutilRetraiteMayotte();
    }
    return instance;
  }
  
  public Damj getDateMinDepartRetraite(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Damj dateMinRetraite = individu.getDateNaissance().deplacerVersAvant(ParametresRetraiteMayotte.getInstance().getAgeMinDepartRetraite(individu.getDateNaissance()));
    if (!dateMinRetraite.estLeDebutDuMois()) {
      dateMinRetraite = dateMinRetraite.getFinMois().lendemain();
    }
    return dateMinRetraite;
  }
}

/* Location:
 * Qualified Name:     OutilRetraiteMayotte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
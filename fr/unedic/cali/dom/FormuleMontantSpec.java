package fr.unedic.cali.dom;

import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public abstract interface FormuleMontantSpec
{
  public static final String CODE_FORMULE_MONTANT = "1";
  public static final String CODE_FORMULE_MONTANT_FORMATION = "2";
  public static final String CODE_FORMULE_MONTANT_DEUXIEME_TRANCHE = "3";
  public static final String CODE_FORMULE_MONTANT_DEUXIEME_TRANCHE_FORMATION = "4";
  public static final String CODE_FORMULE_MONTANT_TROISIEME_TRANCHE = "5";
  public static final String CODE_FORMULE_MONTANT_TROISIEME_TRANCHE_FORMATION = "6";
  public static final String CODE_FORMULE_MONTANT_COMPLEMENT = "1";
  public static final String CODE_FORMULE_MONTANT_REMPLACEMENT = "2";
  public static final int FORMULE_DROIT_PRINCPAL = 1;
  public static final int FORMULE_DROIT_ASSOCIE = 2;
  
  public abstract MontantBaseSpec calculer(ConstituantsIndemnisation paramConstituantsIndemnisation, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract void setFormuleMontantDroitAssocie(FormuleMontantSpec paramFormuleMontantSpec);
  
  public abstract void setFormuleMontantApplicable(int paramInt);
}

/* Location:
 * Qualified Name:     FormuleMontantSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
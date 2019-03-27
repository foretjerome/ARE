package fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.abstraite;

import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.ValidationReglementSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract class ValidationAnnexeAbstraite
  implements ValidationReglementSpec
{
  protected boolean testOrigineAe(Collection<Integer> origines, Damj dateConnaissanceInfo)
  {
    boolean resultat = false;
    GestionnaireDateApplication gestionnaire;
    try
    {
      gestionnaire = GestionnaireDateApplication.getInstance();
    }
    catch (CoucheLogiqueException ex)
    {
      throw new ApplicativeRuntimeException(ex.getCode(), ex);
    }
    Damj dateApplicationAeWeb = gestionnaire.recupererDateApplication("Date d'application du SM9 IN0989986");
    if (origines.contains(Integer.valueOf(1))) {
      resultat = true;
    } else if ((dateConnaissanceInfo != null) && (dateConnaissanceInfo.estApresOuCoincideAvec(dateApplicationAeWeb)) && (origines.contains(Integer.valueOf(2)))) {
      resultat = true;
    } else if (origines.contains(Integer.valueOf(39))) {
      resultat = true;
    }
    return resultat;
  }
}

/* Location:
 * Qualified Name:     ValidationAnnexeAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
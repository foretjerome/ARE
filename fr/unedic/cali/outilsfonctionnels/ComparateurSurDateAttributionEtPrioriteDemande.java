package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.util.temps.Damj;
import java.util.Comparator;
import java.util.List;

public class ComparateurSurDateAttributionEtPrioriteDemande
  implements Comparator
{
  public int compare(Object arg0, Object arg1)
  {
    DemandeSpec demande1;
    DemandeSpec demande1;
    if ((arg0 instanceof DecisionSpec)) {
      demande1 = ((DecisionSpec)arg0).getDemande();
    } else {
      demande1 = (DemandeSpec)arg0;
    }
    DemandeSpec demande2;
    DemandeSpec demande2;
    if ((arg1 instanceof DecisionSpec)) {
      demande2 = ((DecisionSpec)arg1).getDemande();
    } else {
      demande2 = (DemandeSpec)arg1;
    }
    Damj dateAttribution1 = null;
    Damj dateAttribution2 = null;
    if (!demande1.getListeDossiersExamen().isEmpty()) {
      dateAttribution1 = ((DossierExamenSpec)demande1.getListeDossiersExamen().get(0)).getDateAttribution();
    }
    if (!demande2.getListeDossiersExamen().isEmpty()) {
      dateAttribution2 = ((DossierExamenSpec)demande2.getListeDossiersExamen().get(0)).getDateAttribution();
    }
    if ((dateAttribution1 == null) || (dateAttribution2 == null)) {
      return 0;
    }
    int comparaison = dateAttribution1.compareTo(dateAttribution2);
    if (comparaison == 0)
    {
      Integer prioriteGamme1 = Integer.valueOf(demande1.getGamme().getPriorite());
      Integer prioriteGamme2 = Integer.valueOf(demande2.getGamme().getPriorite());
      
      comparaison = -prioriteGamme1.compareTo(prioriteGamme2);
    }
    if (comparaison == 0)
    {
      Integer prioriteERE1 = Integer.valueOf(demande1.getEvenementReferenceExamen().getPriorite());
      Integer prioriteERE2 = Integer.valueOf(demande2.getEvenementReferenceExamen().getPriorite());
      
      comparaison = -prioriteERE1.compareTo(prioriteERE2);
    }
    if (comparaison == 0)
    {
      Damj dateDepot1 = demande1.getDateDepot();
      Damj dateDepot2 = demande2.getDateDepot();
      if ((dateDepot1 != null) && (dateDepot2 != null)) {
        comparaison = dateDepot1.compareTo(dateDepot2);
      }
    }
    if (comparaison == 0)
    {
      Damj dateCreationDal1 = demande1.getFormulaire().getDateCreationDal();
      Damj dateCreationDal2 = demande2.getFormulaire().getDateCreationDal();
      if ((dateCreationDal1 != null) && (dateCreationDal2 != null)) {
        comparaison = dateCreationDal1.compareTo(dateCreationDal2);
      }
    }
    return comparaison;
  }
}

/* Location:
 * Qualified Name:     ComparateurSurDateAttributionEtPrioriteDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
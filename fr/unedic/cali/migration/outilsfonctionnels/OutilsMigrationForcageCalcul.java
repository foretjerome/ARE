package fr.unedic.cali.migration.outilsfonctionnels;

import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.temps.Chronologie;
import java.util.Collection;

public class OutilsMigrationForcageCalcul
{
  private static final int VALEUR_DEFAUT_NEUTRALISATION_SIGMA = 0;
  
  private static boolean estForcable(DemandeSpec p_demande)
  {
    boolean forcable = false;
    if (p_demande.getGamme().getNomUnique().equals("ASU")) {
      forcable = true;
    } else if (p_demande.getGamme().getNomUnique().equals("SOL")) {
      forcable = true;
    }
    return forcable;
  }
  
  private static int suppUtSiListSommeNull(CalendrierExecutionCalculSpec p_calendrierNCP)
  {
    int nbUTNCPValide = 0;
    if ((p_calendrierNCP instanceof CalendrierExecutionCalculPeriodique))
    {
      Chronologie chronoUT = ((CalendrierExecutionCalculPeriodique)p_calendrierNCP).getChronologieUnitesTraitements();
      chronoUT.iterer();
      while (chronoUT.encoreSuivant())
      {
        UniteTraitement utNCP = (UniteTraitement)chronoUT.elementSuivant();
        if ((utNCP.getCollectionSommes() != null) && (utNCP.getCollectionSommes().size() != 0)) {
          nbUTNCPValide++;
        } else {
          chronoUT.supprimer();
        }
      }
    }
    return nbUTNCPValide;
  }
  
  private static boolean estNbUtATester(AttributionSpec p_attribution)
  {
    boolean retour = true;
    if ((p_attribution.getDemande().getDossierAffectation().getProduit().getCode() == 9) && (OutilsMigration.estFigee(p_attribution.getDemande()))) {
      retour = false;
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     OutilsMigrationForcageCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurDecisionCroissante;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurDemandeCroissante;
import fr.unedic.cali.utilitaire.convertisseur.ConvertisseurDemandeDecision;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public class FiltreDecisionsSuivantesSurDecisions
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private Object objetSeuil = null;
  private boolean estObjetDate = false;
  private boolean estObjetDemande = false;
  
  public FiltreDecisionsSuivantesSurDecisions(Object objetSeuil)
  {
    this.objetSeuil = objetSeuil;
    if ((objetSeuil instanceof Damj)) {
      estObjetDate = true;
    } else if ((objetSeuil instanceof DemandeSpec)) {
      estObjetDemande = true;
    } else if (!(objetSeuil instanceof DecisionSpec)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_OBJET_TYPE_ATTENDUE", new Object[] { "DecisionSpec" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    boolean resultat = false;
    DecisionSpec decision = (DecisionSpec)temporel;
    if (estObjetDate)
    {
      resultat = decision.getDateEffetDecision().estApres((Damj)objetSeuil);
    }
    else if (estObjetDemande)
    {
      DemandeSpec demande = (DemandeSpec)objetSeuil;
      Chronologie chronologieDecision = ConvertisseurDemandeDecision.convertirDemandeEnDecisions(demande);
      boolean comparerSurDecision = false;
      if (!chronologieDecision.estVide())
      {
        DossierExamenSpec dossierExamen = (DossierExamenSpec)chronologieDecision.premierElement();
        if ((dossierExamen instanceof DecisionSpec))
        {
          objetSeuil = dossierExamen;
          estObjetDemande = false;
          comparerSurDecision = true;
        }
      }
      if (comparerSurDecision)
      {
        resultat = comparerDecision(decision);
      }
      else
      {
        ComparateurDemandeCroissante comparateur = new ComparateurDemandeCroissante();
        resultat = comparateur.compare(decision.getDemande(), demande) > 0;
      }
    }
    else
    {
      resultat = comparerDecision(decision);
    }
    return resultat;
  }
  
  private boolean comparerDecision(DecisionSpec decision)
  {
    ComparateurDecisionCroissante comparateur = new ComparateurDecisionCroissante();
    return comparateur.compare(decision, (DecisionSpec)objetSeuil) > 0;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreDecisionsSuivantesSurDecisions
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
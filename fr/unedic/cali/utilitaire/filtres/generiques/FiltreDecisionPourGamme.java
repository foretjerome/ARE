package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreDecisionPourGamme
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private String m_nomUnique;
  
  public FiltreDecisionPourGamme(String nomUniqueGamme)
  {
    if ((nomUniqueGamme == null) || ("".equals(nomUniqueGamme))) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "nom unique ligne" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_nomUnique = nomUniqueGamme;
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    DecisionSpec decision = (DecisionSpec)temporel;
    if ((decision.getDossierAffecte() != null) && (decision.getDossierAffecte().getProduit() != null)) {
      return m_nomUnique.equals(decision.getDossierAffecte().getProduit().getLigne().getGamme().getNomUnique());
    }
    return false;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreDecisionPourGamme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
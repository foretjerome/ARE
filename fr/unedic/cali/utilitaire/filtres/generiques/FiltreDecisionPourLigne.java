package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.LigneSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreDecisionPourLigne
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private String m_nomUnique;
  
  public FiltreDecisionPourLigne(String p_nomUniqueLigne)
  {
    if ((p_nomUniqueLigne == null) || ("".equals(p_nomUniqueLigne))) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "nom unique ligne" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_nomUnique = p_nomUniqueLigne;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    DecisionSpec decision = (DecisionSpec)p_temporel;
    if ((decision.getDossierAffecte() != null) && (decision.getDossierAffecte().getProduit() != null)) {
      return m_nomUnique.equals(decision.getDossierAffecte().getProduit().getLigne().getNomUnique());
    }
    return false;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreDecisionPourLigne
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
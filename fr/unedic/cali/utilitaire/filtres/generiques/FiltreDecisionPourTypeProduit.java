package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.ProduitAbstrait;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreDecisionPourTypeProduit
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private int m_typeProduit;
  
  public FiltreDecisionPourTypeProduit(int p_typeProduit)
  {
    if (p_typeProduit == 0) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "type produit" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_typeProduit = p_typeProduit;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    DecisionSpec decision = (DecisionSpec)p_temporel;
    if ((decision.getDossierAffecte() != null) && (decision.getDossierAffecte().getProduit() != null))
    {
      ProduitSpec produit = decision.getDossierAffecte().getProduit();
      if ((m_typeProduit != 0) && (m_typeProduit != -1)) {
        return ProduitAbstrait.estDuType(m_typeProduit, produit.getCode());
      }
    }
    return false;
  }
  
  public int getTypeElementManipule()
  {
    return 1;
  }
}

/* Location:
 * Qualified Name:     FiltreDecisionPourTypeProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
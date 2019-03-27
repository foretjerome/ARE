package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreDecisionPourProduit
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private int m_codeProduit;
  private String m_nomProduit;
  private int[] m_listeCodeProduit;
  
  public FiltreDecisionPourProduit(int p_codeProduit)
  {
    if (p_codeProduit == 0) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "code produit" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_codeProduit = p_codeProduit;
  }
  
  public FiltreDecisionPourProduit(int[] p_listeCodeProduit)
  {
    if (m_listeCodeProduit == null) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "liste code produit" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_listeCodeProduit = p_listeCodeProduit;
  }
  
  public FiltreDecisionPourProduit(String p_nomProduit)
  {
    if ("".equals(p_nomProduit)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "nom produit" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_nomProduit = p_nomProduit;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    DecisionSpec decision = (DecisionSpec)p_temporel;
    if ((decision.getDossierAffecte() != null) && (decision.getDossierAffecte().getProduit() != null))
    {
      ProduitSpec produit = decision.getDossierAffecte().getProduit();
      if (m_codeProduit != 0) {
        return m_codeProduit == produit.getCode();
      }
      if (m_nomProduit != null) {
        return m_nomProduit.equals(produit.getNom());
      }
      for (int i = 0; i < m_listeCodeProduit.length; i++) {
        if (m_listeCodeProduit[i] == produit.getCode()) {
          return true;
        }
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
 * Qualified Name:     FiltreDecisionPourProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
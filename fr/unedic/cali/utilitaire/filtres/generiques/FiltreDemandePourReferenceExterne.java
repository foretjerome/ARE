package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandePourReferenceExterne
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private boolean m_comparaisonChaine;
  private String m_referenceExterne;
  private int m_referenceExterneInt;
  
  public FiltreDemandePourReferenceExterne(String p_referenceExterne)
  {
    if ((p_referenceExterne == null) || ("".equals(p_referenceExterne))) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "reference externe" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
    m_referenceExterne = p_referenceExterne;
    m_comparaisonChaine = true;
  }
  
  public FiltreDemandePourReferenceExterne(int p_referenceExterne)
  {
    m_referenceExterneInt = p_referenceExterne;
    m_comparaisonChaine = false;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    if (m_comparaisonChaine)
    {
      String referenceExterne = ((DemandeSpec)p_temporel).getFormulaire().getReferenceExterne();
      return m_referenceExterne.equals(referenceExterne);
    }
    try
    {
      int referenceExterne = Integer.parseInt(((DemandeSpec)p_temporel).getFormulaire().getReferenceExterne());
      return m_referenceExterneInt == referenceExterne;
    }
    catch (NumberFormatException ex) {}
    return false;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandePourReferenceExterne
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
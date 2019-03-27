package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandePourNumeroGamme
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private int m_numeroGamme;
  
  public FiltreDemandePourNumeroGamme(int p_numeroGamme)
  {
    m_numeroGamme = p_numeroGamme;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    DemandeSpec demande = (DemandeSpec)p_temporel;
    return m_numeroGamme == demande.getNumeroGamme();
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandePourNumeroGamme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
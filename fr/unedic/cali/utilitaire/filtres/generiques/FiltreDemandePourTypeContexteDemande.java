package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandePourTypeContexteDemande
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private String m_typeContexteDemande;
  private int m_regroupementContexteDemande;
  
  public FiltreDemandePourTypeContexteDemande(String p_typeContexteDemande)
  {
    m_typeContexteDemande = p_typeContexteDemande;
  }
  
  public FiltreDemandePourTypeContexteDemande(int p_regroupementContexteDemande)
  {
    m_regroupementContexteDemande = p_regroupementContexteDemande;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    DemandeSpec demande = (DemandeSpec)p_temporel;
    if (m_typeContexteDemande != null) {
      retour = demande.estEnContexteDemande(m_typeContexteDemande);
    } else if (m_regroupementContexteDemande > 0) {
      retour = demande.estEnContexteDemande(m_regroupementContexteDemande);
    }
    return retour;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandePourTypeContexteDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
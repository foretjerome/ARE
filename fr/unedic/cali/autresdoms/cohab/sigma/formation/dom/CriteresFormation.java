package fr.unedic.cali.autresdoms.cohab.sigma.formation.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Criteres;
import fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec.CriteresFormationSpec;
import fr.unedic.util.temps.Damj;

public class CriteresFormation
  extends Criteres
  implements CriteresFormationSpec
{
  private String m_numeroAllocataire;
  private int m_identifiantActionFormation;
  private Damj m_dateRecherche;
  
  public int getIdentifiantActionFormation()
  {
    return m_identifiantActionFormation;
  }
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public void setIdentifiantActionFormation(int p_identifiant)
  {
    m_identifiantActionFormation = p_identifiant;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public Damj getDateRecherche()
  {
    return m_dateRecherche;
  }
  
  public void setDateRecherche(Damj p_dateRecherche)
  {
    m_dateRecherche = p_dateRecherche;
  }
  
  public String toString()
  {
    return "CriteresFormation [" + getNumeroAllocataire() + ", " + getIdentifiantActionFormation() + ", " + (getDateRecherche() == null ? null : getDateRecherche().formater()) + "]";
  }
}

/* Location:
 * Qualified Name:     CriteresFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
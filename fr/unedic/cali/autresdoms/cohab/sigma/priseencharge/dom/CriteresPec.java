package fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Criteres;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.spec.CriteresPecSpec;
import fr.unedic.util.temps.Damj;

public class CriteresPec
  extends Criteres
  implements CriteresPecSpec
{
  private String m_numeroAllocataire;
  private int m_identifiantPriseEnCharge;
  private Damj m_dateDeRecherche;
  private Damj m_dateDispense;
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public Damj getDateRecherche()
  {
    return m_dateDeRecherche;
  }
  
  public int getIdentifiantPriseEnCharge()
  {
    return m_identifiantPriseEnCharge;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public void setDateRecherche(Damj p_dateRecherche)
  {
    m_dateDeRecherche = p_dateRecherche;
  }
  
  public void setIdentifiantPriseEnCharge(int p_identifiantPriseEnCharge)
  {
    m_identifiantPriseEnCharge = p_identifiantPriseEnCharge;
  }
  
  public Damj getDateDispense()
  {
    return m_dateDispense;
  }
  
  public void setDateDispense(Damj p_dateDispense)
  {
    m_dateDispense = p_dateDispense;
  }
}

/* Location:
 * Qualified Name:     CriteresPec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
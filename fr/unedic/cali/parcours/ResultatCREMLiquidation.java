package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.cre.CRModificationDonnee;
import fr.unedic.cali.outilsfonctionnels.ArrayListCREM;
import fr.unedic.util.services.Resultat;

public class ResultatCREMLiquidation
  extends Resultat
{
  protected ArrayListCREM m_listeComparaisonCREMDecision = null;
  protected ArrayListCREM m_listeComparaisonCREMConstituant = null;
  protected CRModificationDonnee m_crem = null;
  
  public ResultatCREMLiquidation() {}
  
  public ResultatCREMLiquidation(int p_etat)
  {
    super(p_etat);
  }
  
  public ArrayListCREM getListeComparaisonCREMConstituant()
  {
    return m_listeComparaisonCREMConstituant;
  }
  
  public void setListeComparaisonCREMConstituant(ArrayListCREM p_listeComparaisonCREMConstituant)
  {
    m_listeComparaisonCREMConstituant = p_listeComparaisonCREMConstituant;
  }
  
  public ArrayListCREM getListeComparaisonCREMDecision()
  {
    return m_listeComparaisonCREMDecision;
  }
  
  public void setListeComparaisonCREMDecision(ArrayListCREM p_listeComparaisonCREMDecision)
  {
    m_listeComparaisonCREMDecision = p_listeComparaisonCREMDecision;
  }
  
  public CRModificationDonnee getCREM()
  {
    return m_crem;
  }
  
  public void setCREM(CRModificationDonnee p_crem)
  {
    m_crem = p_crem;
  }
}

/* Location:
 * Qualified Name:     ResultatCREMLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
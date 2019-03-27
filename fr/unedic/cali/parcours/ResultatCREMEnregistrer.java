package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.cre.CRModificationDonnee;
import fr.unedic.cali.outilsfonctionnels.ArrayListCREM;
import fr.unedic.util.services.Resultat;

public class ResultatCREMEnregistrer
  extends Resultat
{
  protected ArrayListCREM m_listeComparaisonCREMDonneesImposees = null;
  protected ArrayListCREM m_listeComparaisonCREMDecision = null;
  protected CRModificationDonnee m_crem = null;
  
  public ResultatCREMEnregistrer() {}
  
  public ResultatCREMEnregistrer(int p_etat)
  {
    super(p_etat);
  }
  
  public ArrayListCREM getListeComparaisonCREMDonneesImposees()
  {
    return m_listeComparaisonCREMDonneesImposees;
  }
  
  public void setListeComparaisonCREMDonneesImposees(ArrayListCREM p_listeComparaisonCREMDonneesImposees)
  {
    m_listeComparaisonCREMDonneesImposees = p_listeComparaisonCREMDonneesImposees;
  }
  
  public CRModificationDonnee getCREM()
  {
    return m_crem;
  }
  
  public void setCREM(CRModificationDonnee p_crem)
  {
    m_crem = p_crem;
  }
  
  public ArrayListCREM getListeComparaisonCREMDecision()
  {
    return m_listeComparaisonCREMDecision;
  }
  
  public void setListeComparaisonCREMDecision(ArrayListCREM p_listeComparaisonCREMDecision)
  {
    m_listeComparaisonCREMDecision = p_listeComparaisonCREMDecision;
  }
}

/* Location:
 * Qualified Name:     ResultatCREMEnregistrer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeComplementairesDeterminationSjrSpec;
import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeComportementSpec;
import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeDemandeDeterminationSjrSpec;
import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeDeterminationSjrSpec;
import fr.unedic.cali.dom.conteneurs.spec.DonneesEntreeProduitDeterminationSjrSpec;
import fr.unedic.cali.util.OutilDomToString;

public class DonneesEntreeDeterminationSjr
  implements DonneesEntreeDeterminationSjrSpec
{
  private DonneesEntreeComportementSpec m_donneesEntreeComportement;
  private DonneesEntreeProduitDeterminationSjrSpec m_donneesEntreeProduit;
  private DonneesEntreeDemandeDeterminationSjrSpec m_donneesEntreeDemande;
  private DonneesEntreeComplementairesDeterminationSjrSpec m_donneesEntreeComplementaires;
  
  public DonneesEntreeComportementSpec getDonneesEntreeComportement()
  {
    return m_donneesEntreeComportement;
  }
  
  public void setDonneesEntreeComportement(DonneesEntreeComportementSpec p_donneesEntreeComportement)
  {
    m_donneesEntreeComportement = p_donneesEntreeComportement;
  }
  
  public DonneesEntreeComplementairesDeterminationSjrSpec getDonneesEntreeComplementaires()
  {
    return m_donneesEntreeComplementaires;
  }
  
  public void setDonneesEntreeComplementaires(DonneesEntreeComplementairesDeterminationSjrSpec p_donneesEntreeComplementaires)
  {
    m_donneesEntreeComplementaires = p_donneesEntreeComplementaires;
  }
  
  public DonneesEntreeDemandeDeterminationSjrSpec getDonneesEntreeDemande()
  {
    return m_donneesEntreeDemande;
  }
  
  public void setDonneesEntreeDemande(DonneesEntreeDemandeDeterminationSjrSpec p_donneesEntreeDemande)
  {
    m_donneesEntreeDemande = p_donneesEntreeDemande;
  }
  
  public DonneesEntreeProduitDeterminationSjrSpec getDonneesEntreeProduit()
  {
    return m_donneesEntreeProduit;
  }
  
  public void setDonneesEntreeProduit(DonneesEntreeProduitDeterminationSjrSpec p_donneesEntreeProduit)
  {
    m_donneesEntreeProduit = p_donneesEntreeProduit;
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeDeterminationSjr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
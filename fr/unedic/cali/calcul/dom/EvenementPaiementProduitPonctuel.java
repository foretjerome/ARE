package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class EvenementPaiementProduitPonctuel
  implements ObjetMetierSpec
{
  private Damj m_dateDePaiement;
  private MontantBaseSpec m_montant;
  
  private EvenementPaiementProduitPonctuel() {}
  
  public EvenementPaiementProduitPonctuel(Damj p_dateDePaiement, MontantBaseSpec p_montant)
  {
    setDateDePaiement(p_dateDePaiement);
    setMontant(p_montant);
  }
  
  public Damj getDateDePaiement()
  {
    return m_dateDePaiement;
  }
  
  public MontantBaseSpec getMontant()
  {
    return m_montant;
  }
  
  public void setDateDePaiement(Damj p_dateDePaiement)
  {
    m_dateDePaiement = p_dateDePaiement;
  }
  
  public void setMontant(MontantBaseSpec p_montant)
  {
    m_montant = p_montant;
  }
  
  public String toString()
  {
    StringBuffer string = new StringBuffer();
    string.append("Evenememt Paiement Produit Ponctuel : " + getMontant() + " au " + getDateDePaiement() + "\n");
    return string.toString();
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementPaiementProduitPonctuel copie = new EvenementPaiementProduitPonctuel();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementPaiementProduitPonctuel copie = (EvenementPaiementProduitPonctuel)p_copie;
    m_dateDePaiement = getDateDePaiement();
    if (getMontant() != null) {
      m_montant = ((MontantBaseSpec)getMontant().copie());
    }
  }
}

/* Location:
 * Qualified Name:     EvenementPaiementProduitPonctuel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
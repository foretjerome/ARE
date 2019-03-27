package fr.unedic.cali.calcul.outilsfonctionnels.dom.prestationfinanciere;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.math.BigDecimal;

public class PrestationFinancierePonctuelle
  extends ObjetChronoPeriode
{
  private Damj m_dateDePaiement = null;
  private BigDecimal m_montant = null;
  
  public PrestationFinancierePonctuelle() {}
  
  public PrestationFinancierePonctuelle(Damj p_dateEvenement, BigDecimal p_montant)
  {
    m_dateDePaiement = p_dateEvenement;
    m_montant = p_montant;
  }
  
  public Damj getDateDePaiement()
  {
    return m_dateDePaiement;
  }
  
  public BigDecimal getMontant()
  {
    return m_montant;
  }
  
  public void setDateDePaiement(Damj p_dateDePaiement)
  {
    m_dateDePaiement = p_dateDePaiement;
  }
  
  public void setMontant(BigDecimal p_montant)
  {
    m_montant = p_montant;
  }
  
  public String toString()
  {
    StringBuffer aRetourner = new StringBuffer();
    aRetourner.append("PRESTATION FINANCIERE\n");
    aRetourner.append(" - Date de Paiement :           " + m_dateDePaiement + "\n");
    aRetourner.append(" - Montant Pris en Charge :     " + m_montant + "\n");
    return aRetourner.toString();
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     PrestationFinancierePonctuelle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
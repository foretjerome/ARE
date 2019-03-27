package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.cali.autresdoms.ga.dom.spec.RemunerationSpec;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class Prime
  extends ObjetChronoPeriode
  implements RemunerationSpec
{
  public static final int PRIME_NORMALE = 1;
  public static final int PRIME_EXCEPTIONNELLE = 2;
  public static final int PRIME_ICRS = 5;
  private Damj m_datePaie;
  private QuantiteEuro m_montantBrutBase;
  private QuantiteEuro m_montantSoumisAContribution;
  private BigDecimal m_tauxAbattementFraisProfessionnel;
  private boolean m_estPrimeExclue;
  private int m_typePrime;
  
  public Prime()
  {
    initInstance();
  }
  
  public Prime(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
    initInstance();
  }
  
  public Prime(Periode p_periode)
  {
    super(p_periode);
    initInstance();
  }
  
  private void initInstance()
  {
    m_tauxAbattementFraisProfessionnel = new BigDecimal("0");
  }
  
  public Damj getDatePaie()
  {
    return m_datePaie;
  }
  
  public QuantiteEuro getMontantBrutBase()
  {
    return m_montantBrutBase;
  }
  
  public QuantiteEuro getMontantSoumisAContribution()
  {
    return m_montantSoumisAContribution;
  }
  
  public BigDecimal getTauxAbattementFraisProfessionnel()
  {
    return m_tauxAbattementFraisProfessionnel;
  }
  
  public void setDatePaie(Damj p_datePaie)
  {
    m_datePaie = p_datePaie;
  }
  
  public void setMontantBrutBase(QuantiteEuro p_montantBrutBase)
  {
    m_montantBrutBase = p_montantBrutBase;
  }
  
  public void setMontantSoumisAContribution(QuantiteEuro p_montantSoumisAContribution)
  {
    m_montantSoumisAContribution = p_montantSoumisAContribution;
  }
  
  public void setTauxAbattementFraisProfessionnel(BigDecimal p_tauxAbattementFraisProfessionnel)
  {
    m_tauxAbattementFraisProfessionnel = p_tauxAbattementFraisProfessionnel;
  }
  
  public int getTypePrime()
  {
    return m_typePrime;
  }
  
  public void setTypePrime(int p_typePrime)
  {
    m_typePrime = p_typePrime;
  }
  
  public void calculerMontantSoumisContribution()
  {
    BigDecimal montant = getMontantBrutBase().getValeur();
    if ((getTauxAbattementFraisProfessionnel() != null) && (getTauxAbattementFraisProfessionnel().compareTo(new BigDecimal("0")) > 0)) {
      montant = montant.multiply(new BigDecimal("1").subtract(getTauxAbattementFraisProfessionnel()));
    }
    montant = Mathematiques.arrondiASup(montant, 2);
    
    setMontantSoumisAContribution(new QuantiteEuro(montant));
  }
  
  public String toString()
  {
    StringBuffer chaineRetour = new StringBuffer();
    chaineRetour.append(super.toString() + "\n");
    chaineRetour.append("Date Paie : " + m_datePaie + "\n");
    chaineRetour.append("Montant Brut de Base : " + m_montantBrutBase + "\n");
    chaineRetour.append("Montant Soumis à contribution : " + m_montantSoumisAContribution + "\n");
    chaineRetour.append("Taux Abattement Frais Professionnel : " + m_tauxAbattementFraisProfessionnel + "\n");
    return chaineRetour.toString();
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
  
  public boolean estPrimeExclue()
  {
    return m_estPrimeExclue;
  }
  
  public void setEstPrimeExclue(boolean p_estPrimeExclue)
  {
    m_estPrimeExclue = p_estPrimeExclue;
  }
}

/* Location:
 * Qualified Name:     Prime
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
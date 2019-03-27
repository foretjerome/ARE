package fr.unedic.cali.parametres;

import fr.unedic.cali.calcul.dom.EvenementCalculSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;
import java.math.BigDecimal;

public class EvenementParametrageTauxMontantNet
  extends ObjetChronoEvenementDebut
  implements EvenementCalculSpec
{
  private BigDecimal m_valeur;
  private boolean m_isNouveau;
  
  private EvenementParametrageTauxMontantNet() {}
  
  public EvenementParametrageTauxMontantNet(Damj p_dateEvenement)
  {
    super(p_dateEvenement);
  }
  
  public BigDecimal getVal()
  {
    return m_valeur;
  }
  
  public boolean isNouveauTauxConv()
  {
    return m_isNouveau;
  }
  
  public void setTauxConv(BigDecimal p_tauxConv)
  {
    m_valeur = p_tauxConv;
  }
  
  public void setNouveauTauxConv1(boolean p_taux)
  {
    m_isNouveau = p_taux;
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementParametrageTauxMontantNet copie = new EvenementParametrageTauxMontantNet();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementParametrageTauxMontantNet copie = (EvenementParametrageTauxMontantNet)p_copie;
    copie.setTauxConv(getVal());
  }
  
  public void repercuter(EvenementParametrageTauxMontantNet p_evtSource)
  {
    boolean memeDateEffet = getDateEffet().equals(p_evtSource.getDateEffet());
    BigDecimal val = m_valeur;
    if (val == null)
    {
      setTauxConv(p_evtSource.getVal());
      if (memeDateEffet) {
        setNouveauTauxConv1(p_evtSource.isNouveauTauxConv());
      }
    }
    else
    {
      setNouveauTauxConv1(true);
    }
  }
}

/* Location:
 * Qualified Name:     EvenementParametrageTauxMontantNet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
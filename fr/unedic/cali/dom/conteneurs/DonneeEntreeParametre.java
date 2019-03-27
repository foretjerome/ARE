package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.util.OutilDomToString;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;
import java.math.BigDecimal;

public class DonneeEntreeParametre
  extends ObjetChronoEvenementDebut
{
  private static final long serialVersionUID = -2714456518492566940L;
  private BigDecimal m_valeurParametre;
  
  public DonneeEntreeParametre(Damj p_dateParametre, BigDecimal p_valeurParametre)
  {
    super(p_dateParametre);
    m_valeurParametre = p_valeurParametre;
  }
  
  public BigDecimal getValeurParametre()
  {
    return m_valeurParametre;
  }
  
  public void setValeurParametre(BigDecimal p_valeurParametre)
  {
    m_valeurParametre = p_valeurParametre;
  }
  
  public String toString()
  {
    return OutilDomToString.toString(this);
  }
}

/* Location:
 * Qualified Name:     DonneeEntreeParametre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
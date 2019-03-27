package fr.unedic.cali.calcul.parametres;

import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesSmicHoraireMayotte
  extends AccesParametreIdemnisation
{
  public AccesSmicHoraireMayotte()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametreCalcul(new BigDecimal("7.46")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametreCalcul(new BigDecimal("7.37")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametreCalcul(new BigDecimal("7.30")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametreCalcul(new BigDecimal("7.26")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametreCalcul(new BigDecimal("7.11")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametreCalcul(new BigDecimal("6.96")));
    m_table.put(new DateAcces(new Damj(2012, 7, 1)), new ValeurParametreCalcul(new BigDecimal("6.83")));
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametreCalcul(new BigDecimal("6.69")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setSmicHoraireMayotte(((ValeurParametreCalcul)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesSmicHoraireMayotte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
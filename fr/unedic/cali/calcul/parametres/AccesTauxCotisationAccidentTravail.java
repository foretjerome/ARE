package fr.unedic.cali.calcul.parametres;

import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesTauxCotisationAccidentTravail
  extends AccesParametreIdemnisation
{
  public AccesTauxCotisationAccidentTravail()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.65")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.65")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.64")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.62")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.60")));
    m_table.put(new DateAcces(new Damj(2011, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.59")));
    m_table.put(new DateAcces(new Damj(2009, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.58")));
    m_table.put(new DateAcces(new Damj(2008, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.57")));
    m_table.put(new DateAcces(new Damj(2007, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.55")));
    m_table.put(new DateAcces(new Damj(2006, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.06")));
    m_table.put(new DateAcces(new Damj(2005, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.05")));
    m_table.put(new DateAcces(new Damj(2004, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.06")));
    m_table.put(new DateAcces(new Damj(2003, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.07")));
    m_table.put(new DateAcces(new Damj(2002, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.05")));
    m_table.put(new DateAcces(new Damj(2001, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.05641")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setTauxAccidentTravail(((ValeurParametreCalcul)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesTauxCotisationAccidentTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
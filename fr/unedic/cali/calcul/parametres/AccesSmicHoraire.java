package fr.unedic.cali.calcul.parametres;

import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesSmicHoraire
  extends AccesParametreIdemnisation
{
  public AccesSmicHoraire()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametreCalcul(new BigDecimal("9.88")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametreCalcul(new BigDecimal("9.76")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametreCalcul(new BigDecimal("9.67")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametreCalcul(new BigDecimal("9.61")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametreCalcul(new BigDecimal("9.53")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametreCalcul(new BigDecimal("9.43")));
    m_table.put(new DateAcces(new Damj(2012, 7, 1)), new ValeurParametreCalcul(new BigDecimal("9.40")));
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametreCalcul(new BigDecimal("9.22")));
    m_table.put(new DateAcces(new Damj(2011, 12, 1)), new ValeurParametreCalcul(new BigDecimal("9.19")));
    m_table.put(new DateAcces(new Damj(2011, 1, 1)), new ValeurParametreCalcul(new BigDecimal("9.00")));
    m_table.put(new DateAcces(new Damj(2010, 1, 1)), new ValeurParametreCalcul(new BigDecimal("8.86")));
    m_table.put(new DateAcces(new Damj(2009, 7, 1)), new ValeurParametreCalcul(new BigDecimal("8.82")));
    m_table.put(new DateAcces(new Damj(2008, 7, 1)), new ValeurParametreCalcul(new BigDecimal("8.71")));
    m_table.put(new DateAcces(new Damj(2008, 5, 1)), new ValeurParametreCalcul(new BigDecimal("8.63")));
    m_table.put(new DateAcces(new Damj(2007, 7, 1)), new ValeurParametreCalcul(new BigDecimal("8.44")));
    m_table.put(new DateAcces(new Damj(2006, 7, 1)), new ValeurParametreCalcul(new BigDecimal("8.27")));
    m_table.put(new DateAcces(new Damj(2005, 7, 1)), new ValeurParametreCalcul(new BigDecimal("8.03")));
    m_table.put(new DateAcces(new Damj(2004, 7, 1)), new ValeurParametreCalcul(new BigDecimal("7.61")));
    m_table.put(new DateAcces(new Damj(2003, 7, 1)), new ValeurParametreCalcul(new BigDecimal("7.19")));
    m_table.put(new DateAcces(new Damj(2002, 7, 1)), new ValeurParametreCalcul(new BigDecimal("6.83")));
    m_table.put(new DateAcces(new Damj(2001, 7, 1)), new ValeurParametreCalcul(new BigDecimal("6.67")));
    m_table.put(new DateAcces(new Damj(2000, 7, 1)), new ValeurParametreCalcul(new BigDecimal("6.41")));
    m_table.put(new DateAcces(new Damj(1999, 7, 1)), new ValeurParametreCalcul(new BigDecimal("6.21")));
    m_table.put(new DateAcces(new Damj(1998, 7, 1)), new ValeurParametreCalcul(new BigDecimal("6.13")));
    m_table.put(new DateAcces(new Damj(1997, 7, 1)), new ValeurParametreCalcul(new BigDecimal("6.01")));
    m_table.put(new DateAcces(new Damj(1996, 7, 1)), new ValeurParametreCalcul(new BigDecimal("5.78")));
    m_table.put(new DateAcces(new Damj(1996, 5, 1)), new ValeurParametreCalcul(new BigDecimal("5.75")));
    m_table.put(new DateAcces(new Damj(1995, 7, 1)), new ValeurParametreCalcul(new BigDecimal("5.64")));
    m_table.put(new DateAcces(new Damj(1994, 7, 1)), new ValeurParametreCalcul(new BigDecimal("5.42")));
    m_table.put(new DateAcces(new Damj(1993, 7, 1)), new ValeurParametreCalcul(new BigDecimal("5.31")));
    m_table.put(new DateAcces(new Damj(1992, 7, 1)), new ValeurParametreCalcul(new BigDecimal("5.19")));
    m_table.put(new DateAcces(new Damj(1992, 3, 1)), new ValeurParametreCalcul(new BigDecimal("5.08")));
    m_table.put(new DateAcces(new Damj(1990, 7, 1)), new ValeurParametreCalcul(new BigDecimal("4.77")));
    m_table.put(new DateAcces(new Damj(1990, 4, 1)), new ValeurParametreCalcul(new BigDecimal("4.65")));
    m_table.put(new DateAcces(new Damj(1989, 7, 1)), new ValeurParametreCalcul(new BigDecimal("4.56")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setSmicHoraire(((ValeurParametreCalcul)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesSmicHoraire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
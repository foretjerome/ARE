package fr.unedic.cali.parametres;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesSmicMensuelBase35h
  extends AccesParametreIndemnisation
{
  public AccesSmicMensuelBase35h()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametre(new BigDecimal("1498.47")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametre(new BigDecimal("1480.27")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametre(new BigDecimal("1466.62")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametre(new BigDecimal("1457.52")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametre(new BigDecimal("1445.38")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametre(new BigDecimal("1430.22")));
    m_table.put(new DateAcces(new Damj(2012, 7, 1)), new ValeurParametre(new BigDecimal("1425.67")));
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametre(new BigDecimal("1398.37")));
    m_table.put(new DateAcces(new Damj(2011, 12, 1)), new ValeurParametre(new BigDecimal("1393.82")));
    m_table.put(new DateAcces(new Damj(2011, 1, 1)), new ValeurParametre(new BigDecimal("1365.00")));
    m_table.put(new DateAcces(new Damj(2010, 1, 1)), new ValeurParametre(new BigDecimal("1343.77")));
    m_table.put(new DateAcces(new Damj(2009, 7, 1)), new ValeurParametre(new BigDecimal("1337.70")));
    m_table.put(new DateAcces(new Damj(2008, 7, 1)), new ValeurParametre(new BigDecimal("1321.02")));
    m_table.put(new DateAcces(new Damj(2008, 5, 1)), new ValeurParametre(new BigDecimal("1308.88")));
    m_table.put(new DateAcces(new Damj(2007, 7, 1)), new ValeurParametre(new BigDecimal("1280.07")));
    m_table.put(new DateAcces(new Damj(2006, 7, 1)), new ValeurParametre(new BigDecimal("1254.28")));
    m_table.put(new DateAcces(new Damj(2005, 7, 1)), new ValeurParametre(new BigDecimal("1217.88")));
    m_table.put(new DateAcces(new Damj(2004, 7, 1)), new ValeurParametre(new BigDecimal("1154.18")));
    m_table.put(new DateAcces(new Damj(2003, 7, 1)), new ValeurParametre(new BigDecimal("1090.48")));
    m_table.put(new DateAcces(new Damj(2002, 7, 1)), new ValeurParametre(new BigDecimal("1035.88")));
    m_table.put(new DateAcces(new Damj(2001, 7, 1)), new ValeurParametre(new BigDecimal("1011.62")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setSmicMensuelBase35h(((ValeurParametre)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesSmicMensuelBase35h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
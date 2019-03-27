package fr.unedic.cali.parametres;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesSmicJournalierBase35h
  extends AccesParametreIndemnisation
{
  public AccesSmicJournalierBase35h()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametre(new BigDecimal("49.40")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametre(new BigDecimal("48.80")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametre(new BigDecimal("48.35")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametre(new BigDecimal("48.05")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametre(new BigDecimal("47.65")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametre(new BigDecimal("47.15")));
    m_table.put(new DateAcces(new Damj(2012, 7, 1)), new ValeurParametre(new BigDecimal("47.00")));
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametre(new BigDecimal("46.10")));
    m_table.put(new DateAcces(new Damj(2011, 12, 1)), new ValeurParametre(new BigDecimal("45.95")));
    m_table.put(new DateAcces(new Damj(2011, 1, 1)), new ValeurParametre(new BigDecimal("45.00")));
    m_table.put(new DateAcces(new Damj(2010, 1, 1)), new ValeurParametre(new BigDecimal("44.30")));
    m_table.put(new DateAcces(new Damj(2009, 7, 1)), new ValeurParametre(new BigDecimal("44.10")));
    m_table.put(new DateAcces(new Damj(2008, 7, 1)), new ValeurParametre(new BigDecimal("43.55")));
    m_table.put(new DateAcces(new Damj(2008, 5, 1)), new ValeurParametre(new BigDecimal("43.15")));
    m_table.put(new DateAcces(new Damj(2007, 7, 1)), new ValeurParametre(new BigDecimal("42.20")));
    m_table.put(new DateAcces(new Damj(2006, 7, 1)), new ValeurParametre(new BigDecimal("41.35")));
    m_table.put(new DateAcces(new Damj(2005, 7, 1)), new ValeurParametre(new BigDecimal("40.15")));
    m_table.put(new DateAcces(new Damj(2004, 7, 1)), new ValeurParametre(new BigDecimal("38.05")));
    m_table.put(new DateAcces(new Damj(2003, 7, 1)), new ValeurParametre(new BigDecimal("35.95")));
    m_table.put(new DateAcces(new Damj(2002, 7, 1)), new ValeurParametre(new BigDecimal("34.15")));
    m_table.put(new DateAcces(new Damj(2001, 7, 1)), new ValeurParametre(new BigDecimal("33.35")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setSmicJournalierBase35h(((ValeurParametre)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesSmicJournalierBase35h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
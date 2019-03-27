package fr.unedic.cali.parametres;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesPlafondJournalierSecuriteSociale
  extends AccesParametreIndemnisation
{
  public AccesPlafondJournalierSecuriteSociale()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametre(new BigDecimal("108.85")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametre(new BigDecimal("107.47")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametre(new BigDecimal("105.80")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametre(new BigDecimal("104.22")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametre(new BigDecimal("102.87")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametre(new BigDecimal("101.46")));
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametre(new BigDecimal("99.65")));
    m_table.put(new DateAcces(new Damj(2011, 1, 1)), new ValeurParametre(new BigDecimal("96.85")));
    m_table.put(new DateAcces(new Damj(2010, 1, 1)), new ValeurParametre(new BigDecimal("94.85")));
    m_table.put(new DateAcces(new Damj(2009, 1, 1)), new ValeurParametre(new BigDecimal("93.99")));
    m_table.put(new DateAcces(new Damj(2008, 1, 1)), new ValeurParametre(new BigDecimal("91.17")));
    m_table.put(new DateAcces(new Damj(2007, 1, 1)), new ValeurParametre(new BigDecimal("88.18")));
    m_table.put(new DateAcces(new Damj(2006, 1, 1)), new ValeurParametre(new BigDecimal("85.12")));
    m_table.put(new DateAcces(new Damj(2005, 1, 1)), new ValeurParametre(new BigDecimal("82.72")));
    m_table.put(new DateAcces(new Damj(2004, 1, 1)), new ValeurParametre(new BigDecimal("81.40")));
    m_table.put(new DateAcces(new Damj(2003, 1, 1)), new ValeurParametre(new BigDecimal("79.96")));
    m_table.put(new DateAcces(new Damj(2002, 1, 1)), new ValeurParametre(new BigDecimal("77.33")));
    m_table.put(new DateAcces(new Damj(2001, 1, 1)), new ValeurParametre(new BigDecimal("74.94")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setPlafondJournalierSecuriteSociale(((ValeurParametre)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesPlafondJournalierSecuriteSociale
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
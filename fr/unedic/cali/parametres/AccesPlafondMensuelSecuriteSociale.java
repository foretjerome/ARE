package fr.unedic.cali.parametres;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesPlafondMensuelSecuriteSociale
  extends AccesParametreIndemnisation
{
  public AccesPlafondMensuelSecuriteSociale()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametre(new BigDecimal("3311")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametre(new BigDecimal("3269")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametre(new BigDecimal("3218")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametre(new BigDecimal("3170")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametre(new BigDecimal("3129")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametre(new BigDecimal("3086")));
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametre(new BigDecimal("3031")));
    m_table.put(new DateAcces(new Damj(2011, 1, 1)), new ValeurParametre(new BigDecimal("2946")));
    m_table.put(new DateAcces(new Damj(2010, 1, 1)), new ValeurParametre(new BigDecimal("2885")));
    m_table.put(new DateAcces(new Damj(2009, 1, 1)), new ValeurParametre(new BigDecimal("2859")));
    m_table.put(new DateAcces(new Damj(2008, 1, 1)), new ValeurParametre(new BigDecimal("2773")));
    m_table.put(new DateAcces(new Damj(2007, 1, 1)), new ValeurParametre(new BigDecimal("2682")));
    m_table.put(new DateAcces(new Damj(2006, 1, 1)), new ValeurParametre(new BigDecimal("2589")));
    m_table.put(new DateAcces(new Damj(2005, 1, 1)), new ValeurParametre(new BigDecimal("2516")));
    m_table.put(new DateAcces(new Damj(2004, 1, 1)), new ValeurParametre(new BigDecimal("2476")));
    m_table.put(new DateAcces(new Damj(2003, 1, 1)), new ValeurParametre(new BigDecimal("2432")));
    m_table.put(new DateAcces(new Damj(2002, 1, 1)), new ValeurParametre(new BigDecimal("2352")));
    m_table.put(new DateAcces(new Damj(2001, 1, 1)), new ValeurParametre(new BigDecimal("2279")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setPlafondMensuelSecuriteSociale(((ValeurParametre)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesPlafondMensuelSecuriteSociale
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
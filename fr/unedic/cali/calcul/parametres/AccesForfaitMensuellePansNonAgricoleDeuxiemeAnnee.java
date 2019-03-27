package fr.unedic.cali.calcul.parametres;

import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesForfaitMensuellePansNonAgricoleDeuxiemeAnnee
  extends AccesParametreIdemnisation
{
  public AccesForfaitMensuellePansNonAgricoleDeuxiemeAnnee()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(1900, 1, 1)), new ValeurParametreCalcul(new BigDecimal("782.25")));
    m_table.put(new DateAcces(new Damj(2005, 1, 1)), new ValeurParametreCalcul(new BigDecimal("795.58")));
    m_table.put(new DateAcces(new Damj(2006, 1, 1)), new ValeurParametreCalcul(new BigDecimal("813.08")));
    m_table.put(new DateAcces(new Damj(2007, 1, 1)), new ValeurParametreCalcul(new BigDecimal("827.67")));
    m_table.put(new DateAcces(new Damj(2008, 1, 1)), new ValeurParametreCalcul(new BigDecimal("841.75")));
    m_table.put(new DateAcces(new Damj(2009, 1, 1)), new ValeurParametreCalcul(new BigDecimal("850.17")));
    m_table.put(new DateAcces(new Damj(2010, 1, 1)), new ValeurParametreCalcul(new BigDecimal("875.67")));
    m_table.put(new DateAcces(new Damj(2011, 1, 1)), new ValeurParametreCalcul(new BigDecimal("875.67")));
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametreCalcul(new BigDecimal("888.83")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametreCalcul(new BigDecimal("897.75")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametreCalcul(new BigDecimal("844.83")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametreCalcul(new BigDecimal("855.90")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametreCalcul(new BigDecimal("868.86")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametreCalcul(new BigDecimal("882.63")));
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametreCalcul(new BigDecimal("893.97")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setForfaitMensuellePansNonAgricoleDeuxiemeAnnee(((ValeurParametreCalcul)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesForfaitMensuellePansNonAgricoleDeuxiemeAnnee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.calcul.parametres;

import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesForfaitMensuellePansAgricole
  extends AccesParametreIdemnisation
{
  public AccesForfaitMensuellePansAgricole()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(1900, 1, 1)), new ValeurParametreCalcul(new BigDecimal("599.17")));
    m_table.put(new DateAcces(new Damj(2005, 1, 1)), new ValeurParametreCalcul(new BigDecimal("634.17")));
    m_table.put(new DateAcces(new Damj(2006, 1, 1)), new ValeurParametreCalcul(new BigDecimal("669.17")));
    m_table.put(new DateAcces(new Damj(2007, 1, 1)), new ValeurParametreCalcul(new BigDecimal("689.17")));
    m_table.put(new DateAcces(new Damj(2008, 1, 1)), new ValeurParametreCalcul(new BigDecimal("703.33")));
    m_table.put(new DateAcces(new Damj(2009, 1, 1)), new ValeurParametreCalcul(new BigDecimal("725.83")));
    m_table.put(new DateAcces(new Damj(2010, 1, 1)), new ValeurParametreCalcul(new BigDecimal("738.33")));
    m_table.put(new DateAcces(new Damj(2011, 1, 1)), new ValeurParametreCalcul(new BigDecimal("750.00")));
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametreCalcul(new BigDecimal("768.33")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametreCalcul(new BigDecimal("785.83")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametreCalcul(new BigDecimal("476.50")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametreCalcul(new BigDecimal("480.50")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametreCalcul(new BigDecimal("483.50")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametreCalcul(new BigDecimal("488.00")));
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametreCalcul(new BigDecimal("494.00")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setForfaitMensuellePansAgricole(((ValeurParametreCalcul)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesForfaitMensuellePansAgricole
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
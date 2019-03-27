package fr.unedic.cali.calcul.parametres;

import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesForfaitMensuellePansNonAgricolePremiereAnnee
  extends AccesParametreIdemnisation
{
  public AccesForfaitMensuellePansNonAgricolePremiereAnnee()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(1900, 1, 1)), new ValeurParametreCalcul(new BigDecimal("521.50")));
    m_table.put(new DateAcces(new Damj(2005, 1, 1)), new ValeurParametreCalcul(new BigDecimal("530.41")));
    m_table.put(new DateAcces(new Damj(2006, 1, 1)), new ValeurParametreCalcul(new BigDecimal("542.08")));
    m_table.put(new DateAcces(new Damj(2007, 1, 1)), new ValeurParametreCalcul(new BigDecimal("551.83")));
    m_table.put(new DateAcces(new Damj(2008, 1, 1)), new ValeurParametreCalcul(new BigDecimal("561.17")));
    m_table.put(new DateAcces(new Damj(2009, 1, 1)), new ValeurParametreCalcul(new BigDecimal("566.75")));
    m_table.put(new DateAcces(new Damj(2010, 1, 1)), new ValeurParametreCalcul(new BigDecimal("583.83")));
    m_table.put(new DateAcces(new Damj(2011, 1, 1)), new ValeurParametreCalcul(new BigDecimal("583.83")));
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametreCalcul(new BigDecimal("592.58")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametreCalcul(new BigDecimal("598.50")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametreCalcul(new BigDecimal("594.51")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametreCalcul(new BigDecimal("602.30")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametreCalcul(new BigDecimal("611.42")));
    m_table.put(new DateAcces(new Damj(2017, 1, 1)), new ValeurParametreCalcul(new BigDecimal("621.11")));
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametreCalcul(new BigDecimal("629.09")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setForfaitMensuellePansNonAgricolePremiereAnnee(((ValeurParametreCalcul)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesForfaitMensuellePansNonAgricolePremiereAnnee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
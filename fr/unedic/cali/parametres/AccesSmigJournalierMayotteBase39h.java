package fr.unedic.cali.parametres;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesSmigJournalierMayotteBase39h
  extends AccesParametreIndemnisation
{
  public AccesSmigJournalierMayotteBase39h()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(2018, 1, 1)), new ValeurParametre(new BigDecimal("41.56")));
    m_table.put(new DateAcces(new Damj(2016, 1, 1)), new ValeurParametre(new BigDecimal("40.67")));
    m_table.put(new DateAcces(new Damj(2015, 1, 1)), new ValeurParametre(new BigDecimal("40.45")));
    m_table.put(new DateAcces(new Damj(2014, 1, 1)), new ValeurParametre(new BigDecimal("39.61")));
    m_table.put(new DateAcces(new Damj(2013, 1, 1)), new ValeurParametre(new BigDecimal("38.78")));
  }
  
  public void remplir(EvenementParametre p_evenement, DateAcces p_dateAcces)
  {
    p_evenement.setSmigJournalierMayotteBase39h(((ValeurParametre)m_table.get(p_dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesSmigJournalierMayotteBase39h
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
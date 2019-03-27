package fr.unedic.cali.calcul.parametres;

import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;

public class AccesTauxCotisationSocialeObligatoireSurSalaire
  extends AccesParametreIdemnisation
{
  public AccesTauxCotisationSocialeObligatoireSurSalaire()
  {
    initialiser();
  }
  
  protected void initialiser()
  {
    m_table.put(new DateAcces(new Damj(2012, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.2156")));
    m_table.put(new DateAcces(new Damj(2007, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.2146")));
    m_table.put(new DateAcces(new Damj(2006, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.2150")));
    m_table.put(new DateAcces(new Damj(2005, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.2136")));
    m_table.put(new DateAcces(new Damj(2003, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.2120")));
    m_table.put(new DateAcces(new Damj(2002, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.2090")));
    m_table.put(new DateAcces(new Damj(2001, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.2080")));
    m_table.put(new DateAcces(new Damj(2000, 1, 1)), new ValeurParametreCalcul(new BigDecimal("0.2101")));
  }
  
  public void remplir(EvenementParametre evenement, DateAcces dateAcces)
  {
    evenement.setTauxCotisationSocialeSalaire(((ValeurParametreCalcul)m_table.get(dateAcces)).getValeur());
  }
}

/* Location:
 * Qualified Name:     AccesTauxCotisationSocialeObligatoireSurSalaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
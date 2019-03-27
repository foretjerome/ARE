package fr.unedic.cali.util;

import fr.unedic.util.temps.Damj;

public class EvenementPeriode
  implements Comparable
{
  public static final int EVT_DEBUT = 1;
  public static final int EVT_FIN = 2;
  Damj m_date;
  int m_typeEvenement;
  
  public EvenementPeriode(Damj p_date, int p_typeEvenement)
  {
    m_date = p_date;
    m_typeEvenement = p_typeEvenement;
  }
  
  public Damj getDate()
  {
    return m_date;
  }
  
  public int getTypeEvenement()
  {
    return m_typeEvenement;
  }
  
  public int compareTo(Object p_evtb)
  {
    EvenementPeriode evtb = (EvenementPeriode)p_evtb;
    int resultat = m_date.compareTo(evtb.getDate());
    if ((resultat == 0) && (m_typeEvenement != evtb.getTypeEvenement())) {
      resultat = m_typeEvenement == 1 ? -1 : 1;
    }
    return resultat;
  }
  
  public String toString()
  {
    String str = m_typeEvenement == 1 ? "deb " : "fin ";
    return str.concat(m_date.toString());
  }
}

/* Location:
 * Qualified Name:     EvenementPeriode
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
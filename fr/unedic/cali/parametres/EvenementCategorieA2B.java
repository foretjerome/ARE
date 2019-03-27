package fr.unedic.cali.parametres;

import fr.unedic.cali.calcul.dom.EvenementCalculSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;
import java.math.BigDecimal;
import java.util.ArrayList;

public class EvenementCategorieA2B
  extends ObjetChronoEvenementDebut
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 1L;
  private static final int NB_CAT = 20;
  private ArrayList m_valeurs;
  private boolean[] m_isNouveau;
  
  public EvenementCategorieA2B()
  {
    m_valeurs = new ArrayList(20);
    m_isNouveau = new boolean[20];
    init();
  }
  
  public EvenementCategorieA2B(Damj p_dateEvenement)
  {
    super(p_dateEvenement);
    init();
  }
  
  public void init()
  {
    m_valeurs = new ArrayList(20);
    m_isNouveau = new boolean[20];
    for (int i = 0; i < 20; i++)
    {
      m_isNouveau[i] = false;
      m_valeurs.add(null);
    }
  }
  
  public ArrayList getValeurs()
  {
    return m_valeurs;
  }
  
  public BigDecimal getVal(int p_index)
  {
    return (BigDecimal)m_valeurs.get(p_index);
  }
  
  public boolean isNouveauCat(int p_index)
  {
    return m_isNouveau[p_index];
  }
  
  public void setCat(BigDecimal p_cat, int p_index)
  {
    m_valeurs.set(p_index, p_cat);
  }
  
  public void setNouveauCat1(boolean p_cat, int p_index)
  {
    m_isNouveau[p_index] = p_cat;
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementCategorieA2B copie = new EvenementCategorieA2B();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementCategorieA2B copie = (EvenementCategorieA2B)p_copie;
    for (int i = 0; i < 20; i++) {
      copie.setCat(getVal(i), i);
    }
  }
  
  public void repercuter(EvenementCategorieA2B p_evtSource)
  {
    boolean memeDateEffet = getDateEffet().equals(p_evtSource.getDateEffet());
    for (int i = 0; i < 20; i++)
    {
      BigDecimal val = (BigDecimal)m_valeurs.get(i);
      if (val == null)
      {
        setCat(p_evtSource.getVal(i), i);
        if (memeDateEffet) {
          setNouveauCat1(p_evtSource.isNouveauCat(i), i);
        }
      }
      else
      {
        setNouveauCat1(true, i);
      }
    }
  }
  
  public BigDecimal getSalaireA2B(int p_codeA2B)
  {
    switch (p_codeA2B)
    {
    case 90: 
      return (BigDecimal)m_valeurs.get(0);
    case 91: 
      return (BigDecimal)m_valeurs.get(1);
    case 92: 
      return (BigDecimal)m_valeurs.get(2);
    case 93: 
      return (BigDecimal)m_valeurs.get(3);
    case 94: 
      return (BigDecimal)m_valeurs.get(4);
    case 95: 
      return (BigDecimal)m_valeurs.get(5);
    case 96: 
      return (BigDecimal)m_valeurs.get(6);
    case 97: 
      return (BigDecimal)m_valeurs.get(7);
    case 98: 
      return (BigDecimal)m_valeurs.get(8);
    case 99: 
      return (BigDecimal)m_valeurs.get(9);
    case 100: 
      return (BigDecimal)m_valeurs.get(10);
    case 101: 
      return (BigDecimal)m_valeurs.get(11);
    case 102: 
      return (BigDecimal)m_valeurs.get(12);
    case 103: 
      return (BigDecimal)m_valeurs.get(13);
    case 104: 
      return (BigDecimal)m_valeurs.get(14);
    case 105: 
      return (BigDecimal)m_valeurs.get(15);
    case 106: 
      return (BigDecimal)m_valeurs.get(16);
    case 107: 
      return (BigDecimal)m_valeurs.get(17);
    case 108: 
      return (BigDecimal)m_valeurs.get(18);
    case 109: 
      return (BigDecimal)m_valeurs.get(19);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     EvenementCategorieA2B
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
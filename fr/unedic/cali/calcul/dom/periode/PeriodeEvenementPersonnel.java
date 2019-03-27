package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeEvenementPersonnel
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -8493866664183557026L;
  private int m_nature;
  private transient String m_libelle = null;
  
  protected PeriodeEvenementPersonnel() {}
  
  public PeriodeEvenementPersonnel(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public int getNature()
  {
    return m_nature;
  }
  
  public void setNature(int p_nature)
  {
    m_nature = p_nature;
  }
  
  public String getLibelle()
  {
    return m_libelle;
  }
  
  public void setLibelle(String p_libelle)
  {
    m_libelle = p_libelle;
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeEvenementPersonnel copie = new PeriodeEvenementPersonnel();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeEvenementPersonnel copie = (PeriodeEvenementPersonnel)p_copie;
    super.copieElements(copie);
    
    m_nature = getNature();
    m_libelle = getLibelle();
  }
}

/* Location:
 * Qualified Name:     PeriodeEvenementPersonnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
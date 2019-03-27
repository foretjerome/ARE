package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class PeriodeContrat
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = -1034272828267841544L;
  private int m_typeContratParticulier;
  private String m_identifiant;
  
  public String getIdentifiant()
  {
    return m_identifiant;
  }
  
  public void setIdentifiant(String p_identifiant)
  {
    m_identifiant = p_identifiant;
  }
  
  protected PeriodeContrat() {}
  
  public PeriodeContrat(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeContrat copie = new PeriodeContrat();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeContrat copie = (PeriodeContrat)p_copie;
    copie.setTypeContratParticulier(getTypeContratParticulier());
  }
  
  public int getTypeContratParticulier()
  {
    return m_typeContratParticulier;
  }
  
  public void setTypeContratParticulier(int p_typeContratParticulier)
  {
    m_typeContratParticulier = p_typeContratParticulier;
  }
}

/* Location:
 * Qualified Name:     PeriodeContrat
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class ObjetChronoRemplissage
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 7669154753348994628L;
  public static final int TYPE_NON_TRAITEE = 0;
  public static final int TYPE_SUSPENSIF = 1;
  public static final int TYPE_INDEMNISE = 2;
  public static final int TYPE_DECALAGE = 3;
  public static final int TYPE_NEUTRALISATION = 4;
  private int m_type = 0;
  
  public ObjetChronoRemplissage()
  {
    super(new Damj(), new Damj());
  }
  
  public ObjetChronoRemplissage(int p_type, Damj p_dateDebut, Damj p_dateFin)
  {
    m_type = p_type;
    setDateDebut(p_dateDebut);
    setDateFin(p_dateFin);
  }
  
  public int getType()
  {
    return m_type;
  }
  
  public void setType(int p_type)
  {
    m_type = p_type;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoRemplissage copie = new ObjetChronoRemplissage();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ObjetChronoRemplissage copie = (ObjetChronoRemplissage)p_copie;
    super.copieElements(copie);
    m_type = getType();
  }
}

/* Location:
 * Qualified Name:     ObjetChronoRemplissage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
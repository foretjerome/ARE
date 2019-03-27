package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;

public class Somme
  extends ObjetChronoPeriode
  implements ObjetMetierSpec
{
  private Quantite m_nbBase = null;
  private MontantBaseSpec m_montant = null;
  private Class m_classeQuantiteDroit = null;
  
  private Somme() {}
  
  public Somme(Damj p_dateDebut, Damj p_dateFin, Quantite p_nbBase, MontantBaseSpec p_montant, Class p_classeQuantiteDroit)
  {
    super(p_dateDebut, p_dateFin);
    setNbBase(p_nbBase);
    setMontant(p_montant);
    setClasseQuantiteDroit(p_classeQuantiteDroit);
  }
  
  public MontantBaseSpec getMontant()
  {
    return m_montant;
  }
  
  public Quantite getNbBase()
  {
    return m_nbBase;
  }
  
  public Class getClasseQuantiteDroit()
  {
    return m_classeQuantiteDroit;
  }
  
  public void setMontant(MontantBaseSpec p_montant)
  {
    m_montant = p_montant;
  }
  
  public void setNbBase(Quantite p_nbBase)
  {
    m_nbBase = p_nbBase;
  }
  
  public void setClasseQuantiteDroit(Class p_classeQuantiteDroit)
  {
    m_classeQuantiteDroit = p_classeQuantiteDroit;
  }
  
  protected Periode getPeriode()
  {
    return m_periode;
  }
  
  protected void setPeriode(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public ObjetMetierSpec copie()
  {
    Somme copie = new Somme();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    Somme copie = (Somme)p_copie;
    copie.setDateDebut(getDateDebut());
    copie.setDateFin(getDateFin());
    if (getMontant() != null) {
      m_montant = ((MontantBaseSpec)getMontant().copie());
    }
    m_nbBase = getNbBase();
    m_classeQuantiteDroit = getClasseQuantiteDroit();
  }
}

/* Location:
 * Qualified Name:     Somme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
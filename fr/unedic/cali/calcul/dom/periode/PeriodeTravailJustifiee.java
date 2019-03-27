package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public abstract class PeriodeTravailJustifiee
  extends PeriodeTravailTransient
{
  private Collection m_collectionPND;
  private Periode m_periodeOrigine;
  
  protected PeriodeTravailJustifiee()
  {
    m_collectionPND = new ArrayList();
  }
  
  public PeriodeTravailJustifiee(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
    m_collectionPND = new ArrayList();
  }
  
  public Collection getCollectionPND()
  {
    return m_collectionPND;
  }
  
  public void setCollectionPND(Collection p_collectionPND)
  {
    if (p_collectionPND != null)
    {
      Iterator iteratorPNDCourante = null;
      Iterator iteratorPNDParametre = null;
      PeriodeNonDeclaree elementPND = null;
      
      iteratorPNDCourante = getCollectionPND().iterator();
      while (iteratorPNDCourante.hasNext())
      {
        elementPND = (PeriodeNonDeclaree)iteratorPNDCourante.next();
        if (p_collectionPND.contains(elementPND)) {
          p_collectionPND.remove(elementPND);
        } else {
          iteratorPNDCourante.remove();
        }
      }
      iteratorPNDParametre = p_collectionPND.iterator();
      while (iteratorPNDParametre.hasNext()) {
        m_collectionPND.add(iteratorPNDParametre.next());
      }
    }
  }
  
  public void ajouterPND(PeriodeNonDeclaree p_periodeNonDeclaree)
  {
    m_collectionPND.add(p_periodeNonDeclaree);
  }
  
  public void supprimerPND(PeriodeNonDeclaree p_periodeNonDeclaree)
  {
    m_collectionPND.remove(p_periodeNonDeclaree);
  }
  
  public Periode getPeriodeOrigine()
  {
    return m_periodeOrigine;
  }
  
  public void setPeriodeOrigine(Periode p_periodeOrigine)
  {
    m_periodeOrigine = p_periodeOrigine;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeTravailJustifiee copie = (PeriodeTravailJustifiee)p_copie;
    
    super.copieElements(copie);
    
    m_periodeOrigine = getPeriodeOrigine();
    
    Iterator iterator = getCollectionPND().iterator();
    m_collectionPND = new ArrayList();
    while (iterator.hasNext())
    {
      ObjetMetierSpec element = (ObjetMetierSpec)iterator.next();
      if (element != null) {
        m_collectionPND.add(element.copie());
      }
    }
  }
}

/* Location:
 * Qualified Name:     PeriodeTravailJustifiee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
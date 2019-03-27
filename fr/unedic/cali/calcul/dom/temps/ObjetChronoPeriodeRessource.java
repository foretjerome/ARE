package fr.unedic.cali.calcul.dom.temps;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ObjetChronoPeriodeRessource
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private Quantite m_montantRessources = null;
  private Quantite m_montantRessourcesAnnuellesAllocataire = null;
  private Quantite m_montantRessourcesAnnuellesConjoint = null;
  protected transient boolean m_nouvellesRessourcesMontantDifferent = false;
  protected Periode m_periode;
  private int m_situationFamiliale = 1;
  
  private ObjetChronoPeriodeRessource() {}
  
  public ObjetChronoPeriodeRessource(Damj p_date)
  {
    super(p_date, p_date);
  }
  
  public Quantite getMontantRessources()
  {
    return m_montantRessources;
  }
  
  public void setMontantRessources(Quantite p_montantRessources)
  {
    m_montantRessources = p_montantRessources;
  }
  
  public Quantite getMontantRessourcesAnnuellesAllocataire()
  {
    return m_montantRessourcesAnnuellesAllocataire;
  }
  
  public void setMontantRessourcesAnnuellesAllocataire(Quantite p_montantRessourcesAnnuellesAllocataire)
  {
    m_montantRessourcesAnnuellesAllocataire = p_montantRessourcesAnnuellesAllocataire;
  }
  
  public Quantite getMontantRessourcesAnnuellesConjoint()
  {
    return m_montantRessourcesAnnuellesConjoint;
  }
  
  public void setMontantRessourcesAnnuellesConjoint(Quantite p_montantRessourcesAnnuellesConjoint)
  {
    m_montantRessourcesAnnuellesConjoint = p_montantRessourcesAnnuellesConjoint;
  }
  
  public ObjetMetierSpec copie()
  {
    ObjetChronoPeriodeRessource copie = new ObjetChronoPeriodeRessource();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ObjetChronoPeriodeRessource copie = (ObjetChronoPeriodeRessource)p_copie;
    super.copieElements(copie);
    copie.setMontantRessources(getMontantRessources());
    copie.setMontantRessourcesAnnuellesAllocataire(getMontantRessourcesAnnuellesAllocataire());
    copie.setMontantRessourcesAnnuellesConjoint(getMontantRessourcesAnnuellesConjoint());
  }
  
  public Periode getPeriode()
  {
    return m_periode;
  }
  
  public void setPeriode(Periode p_periode)
  {
    m_periode = p_periode;
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    Damj dateFin = getDateFin();
    if (p_dateDebut.estApres(dateFin)) {
      dateFin = p_dateDebut;
    }
    setPeriode(new Periode(p_dateDebut, dateFin));
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    Damj dateDebut = getDateDebut();
    if (p_dateFin.estAvant(dateDebut)) {
      dateDebut = p_dateFin;
    }
    setPeriode(new Periode(dateDebut, p_dateFin));
  }
  
  public boolean estNouvellesRessourcesMontantDifferent()
  {
    return m_nouvellesRessourcesMontantDifferent;
  }
  
  public void setNouvellesRessourcesMontantDifferent(boolean p_nouvellesRessourcesMontantDifferent)
  {
    m_nouvellesRessourcesMontantDifferent = p_nouvellesRessourcesMontantDifferent;
  }
  
  public int getSituationFamiliale()
  {
    return m_situationFamiliale;
  }
  
  public void setSituationFamiliale(int p_situationFamiliale)
  {
    m_situationFamiliale = p_situationFamiliale;
  }
}

/* Location:
 * Qualified Name:     ObjetChronoPeriodeRessource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
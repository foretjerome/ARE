package fr.unedic.cali.calcul.outilsfonctionnels.dom.prestationfinanciere;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;

public class Somme
  extends ObjetChronoPeriode
{
  private Quantite m_nbBase = null;
  private Quantite m_montant = null;
  
  public Somme(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public Somme(Damj p_dateDebut, Damj p_dateFin, Quantite p_nbBase, Quantite p_montant)
  {
    super(p_dateDebut, p_dateFin);
    m_nbBase = p_nbBase;
    m_montant = p_montant;
  }
  
  public Quantite getMontant()
  {
    return m_montant;
  }
  
  public Quantite getNbBase()
  {
    return m_nbBase;
  }
  
  public void setMontant(Quantite p_montant)
  {
    m_montant = p_montant;
  }
  
  public void setNbBase(Quantite p_nbBase)
  {
    m_nbBase = p_nbBase;
  }
  
  public String toString()
  {
    StringBuffer aRetourner = new StringBuffer("SOMME du ");
    aRetourner.append(getDateDebut());
    aRetourner.append(" au ");
    aRetourner.append(getDateFin() + "\n");
    aRetourner.append(" => ");
    aRetourner.append(getMontant());
    aRetourner.append(" (montant), ");
    aRetourner.append(getNbBase());
    aRetourner.append(" (nbBase)\n");
    
    return aRetourner.toString();
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     Somme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
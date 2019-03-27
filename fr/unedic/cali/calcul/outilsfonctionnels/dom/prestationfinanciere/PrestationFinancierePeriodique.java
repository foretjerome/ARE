package fr.unedic.cali.calcul.outilsfonctionnels.dom.prestationfinanciere;

import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class PrestationFinancierePeriodique
  extends ObjetChronoPeriode
{
  private Quantite m_quantiteIndemnisable;
  private Quantite m_quantiteIndemnisee;
  private Quantite m_quantiteNonIndemnisee;
  private QualificationPeriodes m_periodesQualifiees;
  private List m_listeSommes;
  private Damj m_premierJourIndemnise = null;
  private Damj m_dernierJourIndemnise = null;
  private Quantite m_creditDecalageInitial;
  private Quantite m_creditDecalagePNDS;
  private Collection m_collectionQuantiteDroit = null;
  
  public PrestationFinancierePeriodique() {}
  
  public PrestationFinancierePeriodique(Damj p_dateDebut, Damj p_dateFin, Quantite p_quantiteIndemnisable, Quantite p_quantiteIndemnisee, Quantite p_quantiteNonIndemnisee, List p_listeSommes, QualificationPeriodes p_periodesQualifiees, Collection p_collectionQuantiteDroit, Damj p_premierJourIndemnise, Damj p_dernierJourIndemnise, Quantite p_creditDecalageInitial)
  {
    setDateDebut(p_dateDebut);
    setDateFin(p_dateFin);
    m_quantiteIndemnisable = p_quantiteIndemnisable;
    m_quantiteIndemnisee = p_quantiteIndemnisee;
    m_quantiteNonIndemnisee = p_quantiteNonIndemnisee;
    m_listeSommes = p_listeSommes;
    m_periodesQualifiees = p_periodesQualifiees;
    m_collectionQuantiteDroit = p_collectionQuantiteDroit;
    m_dernierJourIndemnise = p_dernierJourIndemnise;
    m_premierJourIndemnise = p_premierJourIndemnise;
    if (p_creditDecalageInitial != null) {
      m_creditDecalageInitial = p_creditDecalageInitial;
    }
  }
  
  public Quantite getQuantiteIndemnisable()
  {
    return m_quantiteIndemnisable;
  }
  
  public Quantite getQuantiteIndemnisee()
  {
    return m_quantiteIndemnisee;
  }
  
  public Quantite getQuantiteNonIndemnisee()
  {
    return m_quantiteNonIndemnisee;
  }
  
  public List getChronologieSomme()
  {
    return m_listeSommes;
  }
  
  public Damj getDernierJourIndemnise()
  {
    return m_dernierJourIndemnise;
  }
  
  public Damj getPremierJourIndemnise()
  {
    return m_premierJourIndemnise;
  }
  
  public Quantite getCreditDecalage()
  {
    return m_creditDecalageInitial;
  }
  
  public Collection getCollectionQuantiteDroit()
  {
    return m_collectionQuantiteDroit;
  }
  
  public QualificationPeriodes getPeriodesQualifiees()
  {
    return m_periodesQualifiees;
  }
  
  public void setQuantiteIndemnisable(Quantite p_quantiteIndemnisable)
  {
    m_quantiteIndemnisable = p_quantiteIndemnisable;
  }
  
  public void setQuantiteIndemnisee(Quantite p_quantiteIndemnisee)
  {
    m_quantiteIndemnisee = p_quantiteIndemnisee;
  }
  
  public void setQuantiteNonIndemnisee(Quantite p_quantiteNonIndemnisee)
  {
    m_quantiteNonIndemnisee = p_quantiteNonIndemnisee;
  }
  
  public void setListeSommes(List p_listeSommes)
  {
    m_listeSommes = p_listeSommes;
  }
  
  public void setDernierJourIndemnise(Damj p_damj)
  {
    m_dernierJourIndemnise = p_damj;
  }
  
  public void setPremierJourIndemnise(Damj p_damj)
  {
    m_premierJourIndemnise = p_damj;
  }
  
  public void setCreditDecalage(Quantite p_creditDecalageInitial)
  {
    m_creditDecalageInitial = p_creditDecalageInitial;
  }
  
  public void setCollectionQuantiteDroit(Collection p_collectionQuantiteDroit)
  {
    m_collectionQuantiteDroit = p_collectionQuantiteDroit;
  }
  
  public void setPeriodesQualifiees(QualificationPeriodes p_periodes)
  {
    m_periodesQualifiees = p_periodes;
  }
  
  public String toString()
  {
    StringBuffer aRetourner = new StringBuffer();
    
    aRetourner.append("PRESTATION FINANCIERE du " + getDateDebut() + " au " + getDateFin() + "\n");
    if (m_premierJourIndemnise != null) {
      aRetourner.append(" - Premier Jour Indemnise :     " + m_premierJourIndemnise + "\n");
    }
    if (m_dernierJourIndemnise != null) {
      aRetourner.append(" - Dernier Jour Indemnise :     " + m_dernierJourIndemnise + "\n");
    }
    aRetourner.append(" - Quantite Indemnisable :      " + m_quantiteIndemnisable + "\n");
    aRetourner.append(" - Quantite Indemnisee :        " + m_quantiteIndemnisee + "\n");
    aRetourner.append(" - Quantite Non Indemnisee :    " + m_quantiteNonIndemnisee + "\n");
    if (m_creditDecalageInitial != null) {
      aRetourner.append(" - Credit de Decalage Initial : " + m_creditDecalageInitial + "\n");
    }
    if (m_creditDecalagePNDS != null) {
      aRetourner.append(" - Credit de Decalage PNDS :    " + m_creditDecalagePNDS + "\n");
    }
    aRetourner.append(" - Périodes Qualifiees :\n");
    aRetourner.append(m_periodesQualifiees);
    if (m_listeSommes != null)
    {
      aRetourner.append(" - Liste des Sommes :\n");
      Iterator iterator = m_listeSommes.iterator();
      while (iterator.hasNext()) {
        aRetourner.append("  " + iterator.next());
      }
    }
    if (m_collectionQuantiteDroit != null)
    {
      aRetourner.append(" - Liste des Quantite Droit :\n");
      Iterator iterator = m_collectionQuantiteDroit.iterator();
      while (iterator.hasNext())
      {
        QuantiteDroitSpec quantiteDroit = (QuantiteDroitSpec)iterator.next();
        aRetourner.append("  " + quantiteDroit.getClass().getName().substring(quantiteDroit.getClass().getName().lastIndexOf(".") + 1) + ", ");
        
        aRetourner.append(quantiteDroit.getQuantiteCourante() + "\n");
      }
    }
    return aRetourner.toString();
  }
  
  public Quantite getCreditDecalagePNDS()
  {
    return m_creditDecalagePNDS;
  }
  
  public void setCreditDecalagePNDS(Quantite p_creditDecalagePNDS)
  {
    m_creditDecalagePNDS = p_creditDecalagePNDS;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     PrestationFinancierePeriodique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
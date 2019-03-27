package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.Dom;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public class DomAvantPilotage
  implements Dom
{
  private AttributionSpec m_attributionAEtudier = null;
  private boolean m_executionPersistante = false;
  boolean m_avecPriseEnCompteEvenement;
  Damj m_dateAttribution;
  ProduitSpec m_produit;
  IndividuSpec m_individu;
  Collection m_delaisReport;
  Collection m_carences;
  Damj m_dateArretExecution;
  
  public DomAvantPilotage(AttributionSpec p_attributionAEtudier)
  {
    m_attributionAEtudier = p_attributionAEtudier;
  }
  
  public AttributionSpec getAttributionAEtudier()
  {
    return m_attributionAEtudier;
  }
  
  public void setAttributionAEtudier(AttributionSpec p_attribution)
  {
    m_attributionAEtudier = p_attribution;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public void setDateAttribution(Damj p_dateAttribution)
  {
    m_dateAttribution = p_dateAttribution;
  }
  
  public void setProduit(ProduitSpec p_produit)
  {
    m_produit = p_produit;
  }
  
  public void setDelaisReport(Collection p_delaisReport)
  {
    m_delaisReport = p_delaisReport;
  }
  
  public void setCarences(Collection p_carences)
  {
    m_carences = p_carences;
  }
  
  public Collection getCarences()
  {
    return m_carences;
  }
  
  public Damj getDateAttribution()
  {
    return m_dateAttribution;
  }
  
  public Collection getDelaisReport()
  {
    return m_delaisReport;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public ProduitSpec getProduit()
  {
    if (m_produit != null) {
      return m_produit;
    }
    return m_attributionAEtudier.getProduitExecution();
  }
  
  public Damj getDateArretExecution()
  {
    return m_dateArretExecution;
  }
  
  public void setDateArretExecution(Damj p_dateEtude)
  {
    m_dateArretExecution = p_dateEtude;
  }
  
  public boolean isAvecPriseEnCompteEvenement()
  {
    return m_avecPriseEnCompteEvenement;
  }
  
  public void setAvecPriseEnCompteEvenement(boolean p_avecPriseEnCompteEvenement)
  {
    m_avecPriseEnCompteEvenement = p_avecPriseEnCompteEvenement;
  }
  
  public boolean isExecutionPersistante()
  {
    return m_executionPersistante;
  }
  
  public void setExecutionPersistante(boolean p_executionPersistante)
  {
    m_executionPersistante = p_executionPersistante;
  }
}

/* Location:
 * Qualified Name:     DomAvantPilotage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
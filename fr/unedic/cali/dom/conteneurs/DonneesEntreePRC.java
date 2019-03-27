package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.affectation.ContexteDemandeSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.dom.affectation.ValidationProduitSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class DonneesEntreePRC
{
  private static final long serialVersionUID = 1L;
  private Damj m_dateFgd = null;
  private Damj m_dateDebut = null;
  private Damj m_dateFin = null;
  private int m_typeCoordinationEuropeenne = 0;
  private Damj m_termePrcSaisi = null;
  private ActiviteSalarie m_periodeActiviteSalarieFgd = null;
  private ActiviteSalarie m_periodeActiviteSalarieRa = null;
  private ValidationProduitSpec m_validationProduit = null;
  private Individu m_individu = null;
  private Reglement m_reglementApplicableCourant = null;
  private boolean m_coordCee;
  private Damj m_dateFgdOdPrecedente = null;
  private Quantite m_sjrForce = null;
  private List<ContexteDemandeSpec> m_contexteParticulier = null;
  
  public List<ContexteDemandeSpec> getContexteParticulier()
  {
    return m_contexteParticulier;
  }
  
  public void setContexteParticulier(List<ContexteDemandeSpec> p_contexteParticulier)
  {
    m_contexteParticulier = p_contexteParticulier;
  }
  
  public boolean isCoordCee()
  {
    return m_coordCee;
  }
  
  public void setCoordCee(boolean p_coordCee)
  {
    m_coordCee = p_coordCee;
  }
  
  public Damj getDateDebut()
  {
    return m_dateDebut;
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    m_dateDebut = p_dateDebut;
  }
  
  public Damj getDateFgd()
  {
    return m_dateFgd;
  }
  
  public void setDateFgd(Damj p_dateFgd)
  {
    m_dateFgd = p_dateFgd;
  }
  
  public Damj getDateFgdOdPrecedente()
  {
    return m_dateFgdOdPrecedente;
  }
  
  public void setDateFgdOdPrecedente(Damj p_dateFgdOdPrecedente)
  {
    m_dateFgdOdPrecedente = p_dateFgdOdPrecedente;
  }
  
  public Damj getDateFin()
  {
    return m_dateFin;
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    m_dateFin = p_dateFin;
  }
  
  public Individu getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(Individu p_individu)
  {
    m_individu = p_individu;
  }
  
  public ActiviteSalarie getPeriodeActiviteSalarieFgd()
  {
    return m_periodeActiviteSalarieFgd;
  }
  
  public void setPeriodeActiviteSalarieFgd(ActiviteSalarie p_periodeActiviteSalarieFgd)
  {
    m_periodeActiviteSalarieFgd = p_periodeActiviteSalarieFgd;
  }
  
  public Reglement getReglementApplicableCourant()
  {
    return m_reglementApplicableCourant;
  }
  
  public void setReglementApplicableCourant(Reglement p_reglementApplicableCourant)
  {
    m_reglementApplicableCourant = p_reglementApplicableCourant;
  }
  
  public Damj getTermePrcSaisi()
  {
    return m_termePrcSaisi;
  }
  
  public void setTermePrcSaisi(Damj p_termePrcSaisi)
  {
    m_termePrcSaisi = p_termePrcSaisi;
  }
  
  public int getTypeCoordinationEuropeenne()
  {
    return m_typeCoordinationEuropeenne;
  }
  
  public void setTypeCoordinationEuropeenne(int p_typeCoordinationEuropeenne)
  {
    m_typeCoordinationEuropeenne = p_typeCoordinationEuropeenne;
  }
  
  public ValidationProduitSpec getValidationProduit()
  {
    return m_validationProduit;
  }
  
  public void setValidationProduit(ValidationProduitSpec p_validationProduit)
  {
    m_validationProduit = p_validationProduit;
  }
  
  public ActiviteSalarie getPeriodeActiviteSalarieRa()
  {
    return m_periodeActiviteSalarieRa;
  }
  
  public void setPeriodeActiviteSalarieRa(ActiviteSalarie p_periodeActiviteSalarieRa)
  {
    m_periodeActiviteSalarieRa = p_periodeActiviteSalarieRa;
  }
  
  public Quantite getSjrForce()
  {
    return m_sjrForce;
  }
  
  public void setSjrForce(Quantite p_sjrForce)
  {
    m_sjrForce = p_sjrForce;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreePRC
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
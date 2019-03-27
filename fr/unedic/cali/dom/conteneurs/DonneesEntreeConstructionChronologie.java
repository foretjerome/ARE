package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.affectation.ContexteDemandeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;

public class DonneesEntreeConstructionChronologie
{
  private static final long serialVersionUID = 1L;
  private Damj m_dateFgd = null;
  private Damj m_dateFgdOdPrecedente = null;
  private Individu m_individu = null;
  private Damj m_dateExamen = null;
  private Damj m_dateDeclenchementExamen = null;
  private Reglement m_reglement = null;
  private boolean m_estUneDemandeRevision;
  private Periode m_periodePrc = null;
  private ActiviteSalarie m_activiteSalarie = null;
  private ProduitSpec m_produit = null;
  private List<ContexteDemandeSpec> m_listeContexteDemande = null;
  
  public List<ContexteDemandeSpec> getListeContexteDemande()
  {
    return m_listeContexteDemande;
  }
  
  public void setListeContexteDemande(List<ContexteDemandeSpec> p_listeContexteDemande)
  {
    m_listeContexteDemande = p_listeContexteDemande;
  }
  
  public Damj getDateDeclenchementExamen()
  {
    return m_dateDeclenchementExamen;
  }
  
  public void setDateDeclenchementExamen(Damj p_dateDeclenchementExamen)
  {
    m_dateDeclenchementExamen = p_dateDeclenchementExamen;
  }
  
  public Damj getDateExamen()
  {
    return m_dateExamen;
  }
  
  public void setDateExamen(Damj p_dateExamen)
  {
    m_dateExamen = p_dateExamen;
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
  
  public boolean isEstUneDemandeRevision()
  {
    return m_estUneDemandeRevision;
  }
  
  public void setEstUneDemandeRevision(boolean p_estUneDemandeRevision)
  {
    m_estUneDemandeRevision = p_estUneDemandeRevision;
  }
  
  public Individu getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(Individu p_individu)
  {
    m_individu = p_individu;
  }
  
  public Reglement getReglement()
  {
    return m_reglement;
  }
  
  public void setReglement(Reglement p_reglement)
  {
    m_reglement = p_reglement;
  }
  
  public Periode getPeriodePrc()
  {
    return m_periodePrc;
  }
  
  public void setPeriodePrc(Periode p_periodePrc)
  {
    m_periodePrc = p_periodePrc;
  }
  
  public ActiviteSalarie getActiviteSalarie()
  {
    return m_activiteSalarie;
  }
  
  public void setActiviteSalarie(ActiviteSalarie p_activiteSalarie)
  {
    m_activiteSalarie = p_activiteSalarie;
  }
  
  public ProduitSpec getProduit()
  {
    return m_produit;
  }
  
  public void setProduit(ProduitSpec p_produit)
  {
    m_produit = p_produit;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeConstructionChronologie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
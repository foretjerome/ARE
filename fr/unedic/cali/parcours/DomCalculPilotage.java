package fr.unedic.cali.parcours;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.util.List;

public class DomCalculPilotage
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu = null;
  private Damj m_dateDebutExecution = null;
  private Damj m_dateArretExecution = null;
  private Damj m_dateEtatDroit = null;
  private boolean m_executionDepuisPersistance = true;
  private boolean m_executionPersistante = false;
  private List m_listeAttributions = null;
  private AttributionSpec m_attributionAEtudier = null;
  private ComportementSpec m_comportement = null;
  private ContexteService m_contexteService;
  private boolean m_estAideDecoupe = false;
  
  public DomCalculPilotage()
  {
    this(null);
  }
  
  public DomCalculPilotage(List p_listeAttributions)
  {
    setListeAttributions(p_listeAttributions);
  }
  
  public AttributionSpec getAttributionAEtudier()
  {
    return m_attributionAEtudier;
  }
  
  public void setAttributionAEtudier(AttributionSpec p_attributionANotifier)
  {
    m_attributionAEtudier = p_attributionANotifier;
  }
  
  public Damj getDateDebutExecution()
  {
    return m_dateDebutExecution;
  }
  
  public void setDateDebutExecution(Damj p_date)
  {
    m_dateDebutExecution = p_date;
  }
  
  public Damj getDateArretExecution()
  {
    return m_dateArretExecution;
  }
  
  public void setDateArretExecution(Damj p_date)
  {
    m_dateArretExecution = p_date;
  }
  
  public Damj getDateEtatDroit()
  {
    return m_dateEtatDroit;
  }
  
  public void setDateEtatDroit(Damj p_date)
  {
    m_dateEtatDroit = p_date;
    setDateDebutExecution(p_date);
    setDateArretExecution(p_date);
  }
  
  public boolean isExecutionDepuisPersistance()
  {
    return m_executionDepuisPersistance;
  }
  
  public void setExecutionDepuisPersistance(boolean p_executionDepuisPersistance)
  {
    m_executionDepuisPersistance = p_executionDepuisPersistance;
  }
  
  public boolean isExecutionPersistante()
  {
    return m_executionPersistante;
  }
  
  public void setExecutionPersistante(boolean p_executionPersistante)
  {
    m_executionPersistante = p_executionPersistante;
  }
  
  public List getListeAttributions()
  {
    return m_listeAttributions;
  }
  
  public void setListeAttributions(List p_listeAttributions)
  {
    m_listeAttributions = p_listeAttributions;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public ComportementSpec getComportement()
  {
    return m_comportement;
  }
  
  public void setComportement(ComportementSpec p_comportement)
  {
    m_comportement = p_comportement;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public boolean isEstAideDecoupe()
  {
    return m_estAideDecoupe;
  }
  
  public void setEstAideDecoupe(boolean p_estAideDecoupe)
  {
    m_estAideDecoupe = p_estAideDecoupe;
  }
}

/* Location:
 * Qualified Name:     DomCalculPilotage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
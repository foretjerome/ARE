package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public class ResultatIndividuNcpDetailler
  extends Resultat
{
  private static final long serialVersionUID = 271544412937269923L;
  protected Damj m_dateDerniereExecCal;
  protected int m_heureDerniereExecCal;
  protected Damj m_dateDerniereDemCal;
  protected int m_heureDerniereDemCal;
  protected Damj m_dernierJourIndemnisable;
  protected Damj m_dateDepartRetraiteCalculee;
  protected String m_codeJustifRetraite;
  protected int m_etatDerniereExecution;
  protected String m_codeAnomalieCalcul;
  protected String m_donneeAnomalieCalcul;
  protected String m_contexteExecution;
  protected int m_nombreTrimestreRetraite;
  protected Damj m_dateDebutIneligibilite;
  protected Damj m_dateFinIneligibilite;
  protected Damj m_dateAtteinte3mois;
  protected String m_tsp;
  
  public static long getSerialVersionUID()
  {
    return 271544412937269923L;
  }
  
  public String getCodeAnomalieCalcul()
  {
    return m_codeAnomalieCalcul;
  }
  
  public void setCodeAnomalieCalcul(String p_codeAnomalieCalcul)
  {
    m_codeAnomalieCalcul = p_codeAnomalieCalcul;
  }
  
  public String getCodeJustifRetraite()
  {
    return m_codeJustifRetraite;
  }
  
  public void setCodeJustifRetraite(String p_codeJustifRetraite)
  {
    m_codeJustifRetraite = p_codeJustifRetraite;
  }
  
  public String getContexteExecution()
  {
    return m_contexteExecution;
  }
  
  public void setContexteExecution(String p_contexteExecution)
  {
    m_contexteExecution = p_contexteExecution;
  }
  
  public Damj getDateDepartRetraiteCalculee()
  {
    return m_dateDepartRetraiteCalculee;
  }
  
  public void setDateDepartRetraiteCalculee(Damj p_dateDepartRetraiteCalculee)
  {
    m_dateDepartRetraiteCalculee = p_dateDepartRetraiteCalculee;
  }
  
  public Damj getDateDerniereDemCal()
  {
    return m_dateDerniereDemCal;
  }
  
  public void setDateDerniereDemCal(Damj p_dateDerniereDemCal)
  {
    m_dateDerniereDemCal = p_dateDerniereDemCal;
  }
  
  public Damj getDateDerniereExecCal()
  {
    return m_dateDerniereExecCal;
  }
  
  public void setDateDerniereExecCal(Damj p_dateDerniereExecCal)
  {
    m_dateDerniereExecCal = p_dateDerniereExecCal;
  }
  
  public Damj getDernierJourIndemnisable()
  {
    return m_dernierJourIndemnisable;
  }
  
  public void setDernierJourIndemnisable(Damj p_dernierJourIndemnisable)
  {
    m_dernierJourIndemnisable = p_dernierJourIndemnisable;
  }
  
  public String getDonneeAnomalieCalcul()
  {
    return m_donneeAnomalieCalcul;
  }
  
  public void setDonneeAnomalieCalcul(String p_donneeAnomalieCalcul)
  {
    m_donneeAnomalieCalcul = p_donneeAnomalieCalcul;
  }
  
  public int getEtatDerniereExecution()
  {
    return m_etatDerniereExecution;
  }
  
  public void setEtatDerniereExecution(int p_etatDerniereExecution)
  {
    m_etatDerniereExecution = p_etatDerniereExecution;
  }
  
  public int getHeureDerniereDemCal()
  {
    return m_heureDerniereDemCal;
  }
  
  public void setHeureDerniereDemCal(int p_heureDerniereDemCal)
  {
    m_heureDerniereDemCal = p_heureDerniereDemCal;
  }
  
  public int getHeureDerniereExecCal()
  {
    return m_heureDerniereExecCal;
  }
  
  public void setHeureDerniereExecCal(int p_heureDerniereExecCal)
  {
    m_heureDerniereExecCal = p_heureDerniereExecCal;
  }
  
  public int getNombreTrimestreRetraite()
  {
    return m_nombreTrimestreRetraite;
  }
  
  public void setNombreTrimestreRetraite(int p_nombreTrimestreRetraite)
  {
    m_nombreTrimestreRetraite = p_nombreTrimestreRetraite;
  }
  
  public String getTsp()
  {
    return m_tsp;
  }
  
  public void setTsp(String p_tsp)
  {
    m_tsp = p_tsp;
  }
  
  public Damj getDateDebutIneligibilite()
  {
    return m_dateDebutIneligibilite;
  }
  
  public void setDateDebutIneligibilite(Damj dateDebutIneligibilite)
  {
    m_dateDebutIneligibilite = dateDebutIneligibilite;
  }
  
  public Damj getDateFinIneligibilite()
  {
    return m_dateFinIneligibilite;
  }
  
  public void setDateFinIneligibilite(Damj dateFinIneligibilite)
  {
    m_dateFinIneligibilite = dateFinIneligibilite;
  }
  
  public Damj getDateAtteinte3mois()
  {
    return m_dateAtteinte3mois;
  }
  
  public void setDateAtteinte3mois(Damj dateAtteinte3mois)
  {
    m_dateAtteinte3mois = dateAtteinte3mois;
  }
}

/* Location:
 * Qualified Name:     ResultatIndividuNcpDetailler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
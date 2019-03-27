package fr.unedic.cali.calcul.pbjc.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.pbjc.dom.pc.IndividuPbjcNcpPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class IndividuPbjcNcpGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_individuPbjcNcpPC;
  private Damj m_dateDerniereExecCal;
  private Damj m_dateDerniereDemCal;
  private Damj m_dernierJourIndemnisable;
  private Damj m_dateDepartRetraiteCalculee;
  private String m_codeJustifRetraite;
  private String m_codeAnomalieCalcul;
  private String m_donneeAnomalieCalcul;
  private String m_contexteExecution;
  private Damj m_dateAtteinteMoisNonPaye;
  private Damj m_dateDebutIneligibiliteAidesMob;
  private Damj m_dateFinIneligibiliteAidesMob;
  
  public IndividuPbjcNcpGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public IndividuPbjcNcpGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new IndividuPbjcNcpPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_individuPbjcNcpPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_individuPbjcNcpPC)
  {
    m_individuPbjcNcpPC = p_individuPbjcNcpPC;
  }
  
  protected Damj rawGetDateDerniereExecCal()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateDerniereExecCal();
  }
  
  public Damj getDateDerniereExecCal()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateDerniereExecCal();
  }
  
  public void setDateDerniereExecCal(Damj p_dateDerniereExecCal)
  {
    if ((m_dateDerniereExecCal == null) || (p_dateDerniereExecCal == null))
    {
      m_dateDerniereExecCal = p_dateDerniereExecCal;
      ((IndividuPbjcNcpPC)getPC()).setDateDerniereExecCal(p_dateDerniereExecCal);
    }
    else if ((m_dateDerniereExecCal != null) && (p_dateDerniereExecCal != null) && (!p_dateDerniereExecCal.equals(m_dateDerniereExecCal)))
    {
      m_dateDerniereExecCal = p_dateDerniereExecCal;
      ((IndividuPbjcNcpPC)getPC()).setDateDerniereExecCal(p_dateDerniereExecCal);
    }
  }
  
  protected int rawGetHeureDerniereExecCal()
  {
    return ((IndividuPbjcNcpPC)getPC()).getHeureDerniereExecCal();
  }
  
  public int getHeureDerniereExecCal()
  {
    return ((IndividuPbjcNcpPC)getPC()).getHeureDerniereExecCal();
  }
  
  public void setHeureDerniereExecCal(int p_heureDerniereExecCal)
  {
    ((IndividuPbjcNcpPC)getPC()).setHeureDerniereExecCal(p_heureDerniereExecCal);
  }
  
  protected Damj rawGetDateDerniereDemCal()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateDerniereDemCal();
  }
  
  public Damj getDateDerniereDemCal()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateDerniereDemCal();
  }
  
  public void setDateDerniereDemCal(Damj p_dateDerniereDemCal)
  {
    if ((m_dateDerniereDemCal == null) || (p_dateDerniereDemCal == null))
    {
      m_dateDerniereDemCal = p_dateDerniereDemCal;
      ((IndividuPbjcNcpPC)getPC()).setDateDerniereDemCal(p_dateDerniereDemCal);
    }
    else if ((m_dateDerniereDemCal != null) && (p_dateDerniereDemCal != null) && (!p_dateDerniereDemCal.equals(m_dateDerniereDemCal)))
    {
      m_dateDerniereDemCal = p_dateDerniereDemCal;
      ((IndividuPbjcNcpPC)getPC()).setDateDerniereDemCal(p_dateDerniereDemCal);
    }
  }
  
  protected int rawGetHeureDerniereDemCal()
  {
    return ((IndividuPbjcNcpPC)getPC()).getHeureDerniereDemCal();
  }
  
  public int getHeureDerniereDemCal()
  {
    return ((IndividuPbjcNcpPC)getPC()).getHeureDerniereDemCal();
  }
  
  public void setHeureDerniereDemCal(int p_heureDerniereDemCal)
  {
    ((IndividuPbjcNcpPC)getPC()).setHeureDerniereDemCal(p_heureDerniereDemCal);
  }
  
  protected Damj rawGetDernierJourIndemnisable()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDernierJourIndemnisable();
  }
  
  public Damj getDernierJourIndemnisable()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDernierJourIndemnisable();
  }
  
  public void setDernierJourIndemnisable(Damj p_dernierJourIndemnisable)
  {
    if ((m_dernierJourIndemnisable == null) || (p_dernierJourIndemnisable == null))
    {
      m_dernierJourIndemnisable = p_dernierJourIndemnisable;
      ((IndividuPbjcNcpPC)getPC()).setDernierJourIndemnisable(p_dernierJourIndemnisable);
    }
    else if ((m_dernierJourIndemnisable != null) && (p_dernierJourIndemnisable != null) && (!p_dernierJourIndemnisable.equals(m_dernierJourIndemnisable)))
    {
      m_dernierJourIndemnisable = p_dernierJourIndemnisable;
      ((IndividuPbjcNcpPC)getPC()).setDernierJourIndemnisable(p_dernierJourIndemnisable);
    }
  }
  
  protected Damj rawGetDateDepartRetraiteCalculee()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateDepartRetraiteCalculee();
  }
  
  public Damj getDateDepartRetraiteCalculee()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateDepartRetraiteCalculee();
  }
  
  public void setDateDepartRetraiteCalculee(Damj p_dateDepartRetraiteCalculee)
  {
    if ((m_dateDepartRetraiteCalculee == null) || (p_dateDepartRetraiteCalculee == null))
    {
      m_dateDepartRetraiteCalculee = p_dateDepartRetraiteCalculee;
      ((IndividuPbjcNcpPC)getPC()).setDateDepartRetraiteCalculee(p_dateDepartRetraiteCalculee);
    }
    else if ((m_dateDepartRetraiteCalculee != null) && (p_dateDepartRetraiteCalculee != null) && (!p_dateDepartRetraiteCalculee.equals(m_dateDepartRetraiteCalculee)))
    {
      m_dateDepartRetraiteCalculee = p_dateDepartRetraiteCalculee;
      ((IndividuPbjcNcpPC)getPC()).setDateDepartRetraiteCalculee(p_dateDepartRetraiteCalculee);
    }
  }
  
  protected String rawGetCodeJustifRetraite()
  {
    return ((IndividuPbjcNcpPC)getPC()).getCodeJustifRetraite();
  }
  
  public String getCodeJustifRetraite()
  {
    return ((IndividuPbjcNcpPC)getPC()).getCodeJustifRetraite();
  }
  
  public void setCodeJustifRetraite(String p_codeJustifRetraite)
  {
    if ((m_codeJustifRetraite == null) || (p_codeJustifRetraite == null))
    {
      m_codeJustifRetraite = p_codeJustifRetraite;
      ((IndividuPbjcNcpPC)getPC()).setCodeJustifRetraite(p_codeJustifRetraite);
    }
    else if ((m_codeJustifRetraite != null) && (p_codeJustifRetraite != null) && (!p_codeJustifRetraite.equals(m_codeJustifRetraite)))
    {
      m_codeJustifRetraite = p_codeJustifRetraite;
      ((IndividuPbjcNcpPC)getPC()).setCodeJustifRetraite(p_codeJustifRetraite);
    }
  }
  
  protected int rawGetEtatDerniereExecution()
  {
    return ((IndividuPbjcNcpPC)getPC()).getEtatDerniereExecution();
  }
  
  public int getEtatDerniereExecution()
  {
    return ((IndividuPbjcNcpPC)getPC()).getEtatDerniereExecution();
  }
  
  public void setEtatDerniereExecution(int p_etatDerniereExecution)
  {
    ((IndividuPbjcNcpPC)getPC()).setEtatDerniereExecution(p_etatDerniereExecution);
  }
  
  protected String rawGetCodeAnomalieCalcul()
  {
    return ((IndividuPbjcNcpPC)getPC()).getCodeAnomalieCalcul();
  }
  
  public String getCodeAnomalieCalcul()
  {
    return ((IndividuPbjcNcpPC)getPC()).getCodeAnomalieCalcul();
  }
  
  public void setCodeAnomalieCalcul(String p_codeAnomalieCalcul)
  {
    if ((m_codeAnomalieCalcul == null) || (p_codeAnomalieCalcul == null))
    {
      m_codeAnomalieCalcul = p_codeAnomalieCalcul;
      ((IndividuPbjcNcpPC)getPC()).setCodeAnomalieCalcul(p_codeAnomalieCalcul);
    }
    else if ((m_codeAnomalieCalcul != null) && (p_codeAnomalieCalcul != null) && (!p_codeAnomalieCalcul.equals(m_codeAnomalieCalcul)))
    {
      m_codeAnomalieCalcul = p_codeAnomalieCalcul;
      ((IndividuPbjcNcpPC)getPC()).setCodeAnomalieCalcul(p_codeAnomalieCalcul);
    }
  }
  
  protected String rawGetDonneeAnomalieCalcul()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDonneeAnomalieCalcul();
  }
  
  public String getDonneeAnomalieCalcul()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDonneeAnomalieCalcul();
  }
  
  public void setDonneeAnomalieCalcul(String p_donneeAnomalieCalcul)
  {
    if ((m_donneeAnomalieCalcul == null) || (p_donneeAnomalieCalcul == null))
    {
      m_donneeAnomalieCalcul = p_donneeAnomalieCalcul;
      ((IndividuPbjcNcpPC)getPC()).setDonneeAnomalieCalcul(p_donneeAnomalieCalcul);
    }
    else if ((m_donneeAnomalieCalcul != null) && (p_donneeAnomalieCalcul != null) && (!p_donneeAnomalieCalcul.equals(m_donneeAnomalieCalcul)))
    {
      m_donneeAnomalieCalcul = p_donneeAnomalieCalcul;
      ((IndividuPbjcNcpPC)getPC()).setDonneeAnomalieCalcul(p_donneeAnomalieCalcul);
    }
  }
  
  protected String rawGetContexteExecution()
  {
    return ((IndividuPbjcNcpPC)getPC()).getContexteExecution();
  }
  
  public String getContexteExecution()
  {
    return ((IndividuPbjcNcpPC)getPC()).getContexteExecution();
  }
  
  public void setContexteExecution(String p_contexteExecution)
  {
    if ((m_contexteExecution == null) || (p_contexteExecution == null))
    {
      m_contexteExecution = p_contexteExecution;
      ((IndividuPbjcNcpPC)getPC()).setContexteExecution(p_contexteExecution);
    }
    else if ((m_contexteExecution != null) && (p_contexteExecution != null) && (!p_contexteExecution.equals(m_contexteExecution)))
    {
      m_contexteExecution = p_contexteExecution;
      ((IndividuPbjcNcpPC)getPC()).setContexteExecution(p_contexteExecution);
    }
  }
  
  protected int rawGetNombreTrimestreRetraite()
  {
    return ((IndividuPbjcNcpPC)getPC()).getNombreTrimestreRetraite();
  }
  
  public int getNombreTrimestreRetraite()
  {
    return ((IndividuPbjcNcpPC)getPC()).getNombreTrimestreRetraite();
  }
  
  public void setNombreTrimestreRetraite(int p_nombreTrimestreRetraite)
  {
    ((IndividuPbjcNcpPC)getPC()).setNombreTrimestreRetraite(p_nombreTrimestreRetraite);
  }
  
  protected Damj rawGetDateAtteinteMoisNonPaye()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateAtteinteMoisNonPaye();
  }
  
  public Damj getDateAtteinteMoisNonPaye()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateAtteinteMoisNonPaye();
  }
  
  public void setDateAtteinteMoisNonPaye(Damj p_dateAtteinteMoisNonPaye)
  {
    if ((m_dateAtteinteMoisNonPaye == null) || (p_dateAtteinteMoisNonPaye == null))
    {
      m_dateAtteinteMoisNonPaye = p_dateAtteinteMoisNonPaye;
      ((IndividuPbjcNcpPC)getPC()).setDateAtteinteMoisNonPaye(p_dateAtteinteMoisNonPaye);
    }
    else if ((m_dateAtteinteMoisNonPaye != null) && (p_dateAtteinteMoisNonPaye != null) && (!p_dateAtteinteMoisNonPaye.equals(m_dateAtteinteMoisNonPaye)))
    {
      m_dateAtteinteMoisNonPaye = p_dateAtteinteMoisNonPaye;
      ((IndividuPbjcNcpPC)getPC()).setDateAtteinteMoisNonPaye(p_dateAtteinteMoisNonPaye);
    }
  }
  
  protected Damj rawGetDateDebutIneligibiliteAidesMob()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateDebutIneligibiliteAidesMob();
  }
  
  public Damj getDateDebutIneligibiliteAidesMob()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateDebutIneligibiliteAidesMob();
  }
  
  public void setDateDebutIneligibiliteAidesMob(Damj p_dateDebutIneligibiliteAidesMob)
  {
    if ((m_dateDebutIneligibiliteAidesMob == null) || (p_dateDebutIneligibiliteAidesMob == null))
    {
      m_dateDebutIneligibiliteAidesMob = p_dateDebutIneligibiliteAidesMob;
      ((IndividuPbjcNcpPC)getPC()).setDateDebutIneligibiliteAidesMob(p_dateDebutIneligibiliteAidesMob);
    }
    else if ((m_dateDebutIneligibiliteAidesMob != null) && (p_dateDebutIneligibiliteAidesMob != null) && (!p_dateDebutIneligibiliteAidesMob.equals(m_dateDebutIneligibiliteAidesMob)))
    {
      m_dateDebutIneligibiliteAidesMob = p_dateDebutIneligibiliteAidesMob;
      ((IndividuPbjcNcpPC)getPC()).setDateDebutIneligibiliteAidesMob(p_dateDebutIneligibiliteAidesMob);
    }
  }
  
  protected Damj rawGetDateFinIneligibiliteAidesMob()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateFinIneligibiliteAidesMob();
  }
  
  public Damj getDateFinIneligibiliteAidesMob()
  {
    return ((IndividuPbjcNcpPC)getPC()).getDateFinIneligibiliteAidesMob();
  }
  
  public void setDateFinIneligibiliteAidesMob(Damj p_dateFinIneligibiliteAidesMob)
  {
    if ((m_dateFinIneligibiliteAidesMob == null) || (p_dateFinIneligibiliteAidesMob == null))
    {
      m_dateFinIneligibiliteAidesMob = p_dateFinIneligibiliteAidesMob;
      ((IndividuPbjcNcpPC)getPC()).setDateFinIneligibiliteAidesMob(p_dateFinIneligibiliteAidesMob);
    }
    else if ((m_dateFinIneligibiliteAidesMob != null) && (p_dateFinIneligibiliteAidesMob != null) && (!p_dateFinIneligibiliteAidesMob.equals(m_dateFinIneligibiliteAidesMob)))
    {
      m_dateFinIneligibiliteAidesMob = p_dateFinIneligibiliteAidesMob;
      ((IndividuPbjcNcpPC)getPC()).setDateFinIneligibiliteAidesMob(p_dateFinIneligibiliteAidesMob);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     IndividuPbjcNcpGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
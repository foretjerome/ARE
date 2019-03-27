package fr.unedic.cali.autresdoms.ga.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.autresdoms.ga.dom.pc.ActiviteSalariePC;
import fr.unedic.cali.dom.PeriodeActiviteSalarieCali;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeCREM;
import fr.unedic.util.temps.Periode;

public abstract class ActiviteSalarieGen
  extends ObjetChronoPeriodeCREM
  implements DomGenSpec
{
  private String m_identifiant;
  private PeriodeActiviteSalarieCali m_periodeActiviteSalarieCali;
  
  public ActiviteSalarieGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public ActiviteSalarieGen() {}
  
  public ActiviteSalarieGen(Periode p_periode)
  {
    super(p_periode);
  }
  
  public ActiviteSalarieGen(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  protected DomPCSpec createPC()
  {
    return new ActiviteSalariePC();
  }
  
  protected String rawGetIdentifiant()
  {
    return ((ActiviteSalariePC)getPC()).getIdentifiant();
  }
  
  public String getIdentifiant()
  {
    return ((ActiviteSalariePC)getPC()).getIdentifiant();
  }
  
  public void setIdentifiant(String p_identifiant)
  {
    if ((m_identifiant == null) || (p_identifiant == null))
    {
      m_identifiant = p_identifiant;
      ((ActiviteSalariePC)getPC()).setIdentifiant(p_identifiant);
    }
    else if ((m_identifiant != null) && (p_identifiant != null) && (!p_identifiant.equals(m_identifiant)))
    {
      m_identifiant = p_identifiant;
      ((ActiviteSalariePC)getPC()).setIdentifiant(p_identifiant);
    }
  }
  
  public PeriodeActiviteSalarieCali getPeriodeActiviteSalarieCali()
  {
    if (m_periodeActiviteSalarieCali == null)
    {
      DomPCSpec periodeActiviteSalarieCaliPC = ((ActiviteSalariePC)getPC()).getPeriodeActiviteSalarieCali();
      if (periodeActiviteSalarieCaliPC != null) {
        m_periodeActiviteSalarieCali = ((PeriodeActiviteSalarieCali)periodeActiviteSalarieCaliPC.createOM());
      }
    }
    return m_periodeActiviteSalarieCali;
  }
  
  public void setPeriodeActiviteSalarieCali(PeriodeActiviteSalarieCali p_periodeActiviteSalarieCali)
  {
    if (p_periodeActiviteSalarieCali == null)
    {
      ((ActiviteSalariePC)getPC()).setPeriodeActiviteSalarieCali(null);
      m_periodeActiviteSalarieCali = p_periodeActiviteSalarieCali;
    }
    else if (!p_periodeActiviteSalarieCali.equals(m_periodeActiviteSalarieCali))
    {
      ((ActiviteSalariePC)getPC()).setPeriodeActiviteSalarieCali(p_periodeActiviteSalarieCali.getPC());
      m_periodeActiviteSalarieCali = p_periodeActiviteSalarieCali;
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
    
    Object periodeActiviteSalarieCali = getPeriodeActiviteSalarieCali();
    if ((periodeActiviteSalarieCali != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(periodeActiviteSalarieCali))) {
      DomManager.supprimer(getPeriodeActiviteSalarieCali(), p_contexteSuppression);
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     ActiviteSalarieGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
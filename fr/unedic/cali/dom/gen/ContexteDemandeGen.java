package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.affectation.ContexteDemandeSpec;
import fr.unedic.cali.dom.pc.ContexteDemandePC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class ContexteDemandeGen
  implements ContexteDemandeSpec, DomGenSpec
{
  protected transient DomPCSpec m_contexteDemandePC;
  private String m_typeContexteDemande;
  private String m_sousTypeContexteDemande;
  private Damj m_dateDebutJustifContexte;
  private Damj m_dateFinJustifContexte;
  private String m_identifiantPeriodeCaliJustifContexte;
  
  public ContexteDemandeGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public ContexteDemandeGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new ContexteDemandePC();
  }
  
  public DomPCSpec getPC()
  {
    return m_contexteDemandePC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_contexteDemandePC)
  {
    m_contexteDemandePC = p_contexteDemandePC;
  }
  
  protected String rawGetTypeContexteDemande()
  {
    return ((ContexteDemandePC)getPC()).getTypeContexteDemande();
  }
  
  public String getTypeContexteDemande()
  {
    return ((ContexteDemandePC)getPC()).getTypeContexteDemande();
  }
  
  public void setTypeContexteDemande(String p_typeContexteDemande)
  {
    if ((m_typeContexteDemande == null) || (p_typeContexteDemande == null))
    {
      m_typeContexteDemande = p_typeContexteDemande;
      ((ContexteDemandePC)getPC()).setTypeContexteDemande(p_typeContexteDemande);
    }
    else if ((m_typeContexteDemande != null) && (p_typeContexteDemande != null) && (!p_typeContexteDemande.equals(m_typeContexteDemande)))
    {
      m_typeContexteDemande = p_typeContexteDemande;
      ((ContexteDemandePC)getPC()).setTypeContexteDemande(p_typeContexteDemande);
    }
  }
  
  protected String rawGetSousTypeContexteDemande()
  {
    return ((ContexteDemandePC)getPC()).getSousTypeContexteDemande();
  }
  
  public String getSousTypeContexteDemande()
  {
    return ((ContexteDemandePC)getPC()).getSousTypeContexteDemande();
  }
  
  public void setSousTypeContexteDemande(String p_sousTypeContexteDemande)
  {
    if ((m_sousTypeContexteDemande == null) || (p_sousTypeContexteDemande == null))
    {
      m_sousTypeContexteDemande = p_sousTypeContexteDemande;
      ((ContexteDemandePC)getPC()).setSousTypeContexteDemande(p_sousTypeContexteDemande);
    }
    else if ((m_sousTypeContexteDemande != null) && (p_sousTypeContexteDemande != null) && (!p_sousTypeContexteDemande.equals(m_sousTypeContexteDemande)))
    {
      m_sousTypeContexteDemande = p_sousTypeContexteDemande;
      ((ContexteDemandePC)getPC()).setSousTypeContexteDemande(p_sousTypeContexteDemande);
    }
  }
  
  protected Damj rawGetDateDebutJustifContexte()
  {
    return ((ContexteDemandePC)getPC()).getDateDebutJustifContexte();
  }
  
  public Damj getDateDebutJustifContexte()
  {
    return ((ContexteDemandePC)getPC()).getDateDebutJustifContexte();
  }
  
  public void setDateDebutJustifContexte(Damj p_dateDebutJustifContexte)
  {
    if ((m_dateDebutJustifContexte == null) || (p_dateDebutJustifContexte == null))
    {
      m_dateDebutJustifContexte = p_dateDebutJustifContexte;
      ((ContexteDemandePC)getPC()).setDateDebutJustifContexte(p_dateDebutJustifContexte);
    }
    else if ((m_dateDebutJustifContexte != null) && (p_dateDebutJustifContexte != null) && (!p_dateDebutJustifContexte.equals(m_dateDebutJustifContexte)))
    {
      m_dateDebutJustifContexte = p_dateDebutJustifContexte;
      ((ContexteDemandePC)getPC()).setDateDebutJustifContexte(p_dateDebutJustifContexte);
    }
  }
  
  protected Damj rawGetDateFinJustifContexte()
  {
    return ((ContexteDemandePC)getPC()).getDateFinJustifContexte();
  }
  
  public Damj getDateFinJustifContexte()
  {
    return ((ContexteDemandePC)getPC()).getDateFinJustifContexte();
  }
  
  public void setDateFinJustifContexte(Damj p_dateFinJustifContexte)
  {
    if ((m_dateFinJustifContexte == null) || (p_dateFinJustifContexte == null))
    {
      m_dateFinJustifContexte = p_dateFinJustifContexte;
      ((ContexteDemandePC)getPC()).setDateFinJustifContexte(p_dateFinJustifContexte);
    }
    else if ((m_dateFinJustifContexte != null) && (p_dateFinJustifContexte != null) && (!p_dateFinJustifContexte.equals(m_dateFinJustifContexte)))
    {
      m_dateFinJustifContexte = p_dateFinJustifContexte;
      ((ContexteDemandePC)getPC()).setDateFinJustifContexte(p_dateFinJustifContexte);
    }
  }
  
  protected String rawGetIdentifiantPeriodeCaliJustifContexte()
  {
    return ((ContexteDemandePC)getPC()).getIdentifiantPeriodeCaliJustifContexte();
  }
  
  public String getIdentifiantPeriodeCaliJustifContexte()
  {
    return ((ContexteDemandePC)getPC()).getIdentifiantPeriodeCaliJustifContexte();
  }
  
  public void setIdentifiantPeriodeCaliJustifContexte(String p_identifiantPeriodeCaliJustifContexte)
  {
    if ((m_identifiantPeriodeCaliJustifContexte == null) || (p_identifiantPeriodeCaliJustifContexte == null))
    {
      m_identifiantPeriodeCaliJustifContexte = p_identifiantPeriodeCaliJustifContexte;
      ((ContexteDemandePC)getPC()).setIdentifiantPeriodeCaliJustifContexte(p_identifiantPeriodeCaliJustifContexte);
    }
    else if ((m_identifiantPeriodeCaliJustifContexte != null) && (p_identifiantPeriodeCaliJustifContexte != null) && (!p_identifiantPeriodeCaliJustifContexte.equals(m_identifiantPeriodeCaliJustifContexte)))
    {
      m_identifiantPeriodeCaliJustifContexte = p_identifiantPeriodeCaliJustifContexte;
      ((ContexteDemandePC)getPC()).setIdentifiantPeriodeCaliJustifContexte(p_identifiantPeriodeCaliJustifContexte);
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
 * Qualified Name:     ContexteDemandeGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
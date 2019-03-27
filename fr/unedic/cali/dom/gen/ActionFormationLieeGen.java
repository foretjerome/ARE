package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pc.ActionFormationLieePC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;

public abstract class ActionFormationLieeGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_actionFormationLieePC;
  private Damj m_dateDebut;
  private Damj m_dateFin;
  private Damj m_dateDebutPeriodeFormation;
  private Damj m_datePrescription;
  private String m_numeroConvention;
  private String m_statutFormation;
  private String m_identifiantConvention;
  private String m_affDerogatoire;
  private String m_typePlanFormation;
  private Quantite m_quantiteHebdomadaire;
  
  public ActionFormationLieeGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public ActionFormationLieeGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new ActionFormationLieePC();
  }
  
  public DomPCSpec getPC()
  {
    return m_actionFormationLieePC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_actionFormationLieePC)
  {
    m_actionFormationLieePC = p_actionFormationLieePC;
  }
  
  protected Damj rawGetDateDebut()
  {
    return ((ActionFormationLieePC)getPC()).getDateDebut();
  }
  
  public Damj getDateDebut()
  {
    return ((ActionFormationLieePC)getPC()).getDateDebut();
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    if ((m_dateDebut == null) || (p_dateDebut == null))
    {
      m_dateDebut = p_dateDebut;
      ((ActionFormationLieePC)getPC()).setDateDebut(p_dateDebut);
    }
    else if ((m_dateDebut != null) && (p_dateDebut != null) && (!p_dateDebut.equals(m_dateDebut)))
    {
      m_dateDebut = p_dateDebut;
      ((ActionFormationLieePC)getPC()).setDateDebut(p_dateDebut);
    }
  }
  
  protected Damj rawGetDateFin()
  {
    return ((ActionFormationLieePC)getPC()).getDateFin();
  }
  
  public Damj getDateFin()
  {
    return ((ActionFormationLieePC)getPC()).getDateFin();
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    if ((m_dateFin == null) || (p_dateFin == null))
    {
      m_dateFin = p_dateFin;
      ((ActionFormationLieePC)getPC()).setDateFin(p_dateFin);
    }
    else if ((m_dateFin != null) && (p_dateFin != null) && (!p_dateFin.equals(m_dateFin)))
    {
      m_dateFin = p_dateFin;
      ((ActionFormationLieePC)getPC()).setDateFin(p_dateFin);
    }
  }
  
  protected Damj rawGetDateDebutPeriodeFormation()
  {
    return ((ActionFormationLieePC)getPC()).getDateDebutPeriodeFormation();
  }
  
  public Damj getDateDebutPeriodeFormation()
  {
    return ((ActionFormationLieePC)getPC()).getDateDebutPeriodeFormation();
  }
  
  public void setDateDebutPeriodeFormation(Damj p_dateDebutPeriodeFormation)
  {
    if ((m_dateDebutPeriodeFormation == null) || (p_dateDebutPeriodeFormation == null))
    {
      m_dateDebutPeriodeFormation = p_dateDebutPeriodeFormation;
      ((ActionFormationLieePC)getPC()).setDateDebutPeriodeFormation(p_dateDebutPeriodeFormation);
    }
    else if ((m_dateDebutPeriodeFormation != null) && (p_dateDebutPeriodeFormation != null) && (!p_dateDebutPeriodeFormation.equals(m_dateDebutPeriodeFormation)))
    {
      m_dateDebutPeriodeFormation = p_dateDebutPeriodeFormation;
      ((ActionFormationLieePC)getPC()).setDateDebutPeriodeFormation(p_dateDebutPeriodeFormation);
    }
  }
  
  protected Damj rawGetDatePrescription()
  {
    return ((ActionFormationLieePC)getPC()).getDatePrescription();
  }
  
  public Damj getDatePrescription()
  {
    return ((ActionFormationLieePC)getPC()).getDatePrescription();
  }
  
  public void setDatePrescription(Damj p_datePrescription)
  {
    if ((m_datePrescription == null) || (p_datePrescription == null))
    {
      m_datePrescription = p_datePrescription;
      ((ActionFormationLieePC)getPC()).setDatePrescription(p_datePrescription);
    }
    else if ((m_datePrescription != null) && (p_datePrescription != null) && (!p_datePrescription.equals(m_datePrescription)))
    {
      m_datePrescription = p_datePrescription;
      ((ActionFormationLieePC)getPC()).setDatePrescription(p_datePrescription);
    }
  }
  
  protected String rawGetNumeroConvention()
  {
    return ((ActionFormationLieePC)getPC()).getNumeroConvention();
  }
  
  public String getNumeroConvention()
  {
    return ((ActionFormationLieePC)getPC()).getNumeroConvention();
  }
  
  public void setNumeroConvention(String p_numeroConvention)
  {
    if ((m_numeroConvention == null) || (p_numeroConvention == null))
    {
      m_numeroConvention = p_numeroConvention;
      ((ActionFormationLieePC)getPC()).setNumeroConvention(p_numeroConvention);
    }
    else if ((m_numeroConvention != null) && (p_numeroConvention != null) && (!p_numeroConvention.equals(m_numeroConvention)))
    {
      m_numeroConvention = p_numeroConvention;
      ((ActionFormationLieePC)getPC()).setNumeroConvention(p_numeroConvention);
    }
  }
  
  protected int rawGetTypeConvention()
  {
    return ((ActionFormationLieePC)getPC()).getTypeConvention();
  }
  
  public int getTypeConvention()
  {
    return ((ActionFormationLieePC)getPC()).getTypeConvention();
  }
  
  public void setTypeConvention(int p_typeConvention)
  {
    ((ActionFormationLieePC)getPC()).setTypeConvention(p_typeConvention);
  }
  
  protected String rawGetStatutFormation()
  {
    return ((ActionFormationLieePC)getPC()).getStatutFormation();
  }
  
  public String getStatutFormation()
  {
    return ((ActionFormationLieePC)getPC()).getStatutFormation();
  }
  
  public void setStatutFormation(String p_statutFormation)
  {
    if ((m_statutFormation == null) || (p_statutFormation == null))
    {
      m_statutFormation = p_statutFormation;
      ((ActionFormationLieePC)getPC()).setStatutFormation(p_statutFormation);
    }
    else if ((m_statutFormation != null) && (p_statutFormation != null) && (!p_statutFormation.equals(m_statutFormation)))
    {
      m_statutFormation = p_statutFormation;
      ((ActionFormationLieePC)getPC()).setStatutFormation(p_statutFormation);
    }
  }
  
  protected int rawGetTypePopulationRsa()
  {
    return ((ActionFormationLieePC)getPC()).getTypePopulationRsa();
  }
  
  public int getTypePopulationRsa()
  {
    return ((ActionFormationLieePC)getPC()).getTypePopulationRsa();
  }
  
  public void setTypePopulationRsa(int p_typePopulationRsa)
  {
    ((ActionFormationLieePC)getPC()).setTypePopulationRsa(p_typePopulationRsa);
  }
  
  protected String rawGetIdentifiantConvention()
  {
    return ((ActionFormationLieePC)getPC()).getIdentifiantConvention();
  }
  
  public String getIdentifiantConvention()
  {
    return ((ActionFormationLieePC)getPC()).getIdentifiantConvention();
  }
  
  public void setIdentifiantConvention(String p_identifiantConvention)
  {
    if ((m_identifiantConvention == null) || (p_identifiantConvention == null))
    {
      m_identifiantConvention = p_identifiantConvention;
      ((ActionFormationLieePC)getPC()).setIdentifiantConvention(p_identifiantConvention);
    }
    else if ((m_identifiantConvention != null) && (p_identifiantConvention != null) && (!p_identifiantConvention.equals(m_identifiantConvention)))
    {
      m_identifiantConvention = p_identifiantConvention;
      ((ActionFormationLieePC)getPC()).setIdentifiantConvention(p_identifiantConvention);
    }
  }
  
  protected String rawGetAffDerogatoire()
  {
    return ((ActionFormationLieePC)getPC()).getAffDerogatoire();
  }
  
  public String getAffDerogatoire()
  {
    return ((ActionFormationLieePC)getPC()).getAffDerogatoire();
  }
  
  public void setAffDerogatoire(String p_affDerogatoire)
  {
    if ((m_affDerogatoire == null) || (p_affDerogatoire == null))
    {
      m_affDerogatoire = p_affDerogatoire;
      ((ActionFormationLieePC)getPC()).setAffDerogatoire(p_affDerogatoire);
    }
    else if ((m_affDerogatoire != null) && (p_affDerogatoire != null) && (!p_affDerogatoire.equals(m_affDerogatoire)))
    {
      m_affDerogatoire = p_affDerogatoire;
      ((ActionFormationLieePC)getPC()).setAffDerogatoire(p_affDerogatoire);
    }
  }
  
  protected String rawGetTypePlanFormation()
  {
    return ((ActionFormationLieePC)getPC()).getTypePlanFormation();
  }
  
  public String getTypePlanFormation()
  {
    return ((ActionFormationLieePC)getPC()).getTypePlanFormation();
  }
  
  public void setTypePlanFormation(String p_typePlanFormation)
  {
    if ((m_typePlanFormation == null) || (p_typePlanFormation == null))
    {
      m_typePlanFormation = p_typePlanFormation;
      ((ActionFormationLieePC)getPC()).setTypePlanFormation(p_typePlanFormation);
    }
    else if ((m_typePlanFormation != null) && (p_typePlanFormation != null) && (!p_typePlanFormation.equals(m_typePlanFormation)))
    {
      m_typePlanFormation = p_typePlanFormation;
      ((ActionFormationLieePC)getPC()).setTypePlanFormation(p_typePlanFormation);
    }
  }
  
  protected Quantite rawGetQuantiteHebdomadaire()
  {
    return ((ActionFormationLieePC)getPC()).getQuantiteHebdomadaire();
  }
  
  public Quantite getQuantiteHebdomadaire()
  {
    return ((ActionFormationLieePC)getPC()).getQuantiteHebdomadaire();
  }
  
  public void setQuantiteHebdomadaire(Quantite p_quantiteHebdomadaire)
  {
    if ((m_quantiteHebdomadaire == null) || (p_quantiteHebdomadaire == null))
    {
      m_quantiteHebdomadaire = p_quantiteHebdomadaire;
      ((ActionFormationLieePC)getPC()).setQuantiteHebdomadaire(p_quantiteHebdomadaire);
    }
    else if ((m_quantiteHebdomadaire != null) && (p_quantiteHebdomadaire != null) && (!p_quantiteHebdomadaire.equals(m_quantiteHebdomadaire)))
    {
      m_quantiteHebdomadaire = p_quantiteHebdomadaire;
      ((ActionFormationLieePC)getPC()).setQuantiteHebdomadaire(p_quantiteHebdomadaire);
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
 * Qualified Name:     ActionFormationLieeGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
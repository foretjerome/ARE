package fr.unedic.cali.dom.pivot.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pivot.pc.PeriodeAffiliationPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class PeriodeAffiliationGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_periodeAffiliationPC;
  private String m_identifiantPeriode;
  private Damj m_dateDebut;
  private Damj m_dateFin;
  private String m_qualification;
  private String m_type;
  private String m_competenceFinanciere;
  private String m_competenceAdministrative;
  private Integer m_identifiantOD;
  private String m_referenceExterneDemande;
  
  public PeriodeAffiliationGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public PeriodeAffiliationGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new PeriodeAffiliationPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_periodeAffiliationPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_periodeAffiliationPC)
  {
    m_periodeAffiliationPC = p_periodeAffiliationPC;
  }
  
  protected String rawGetIdentifiantPeriode()
  {
    return ((PeriodeAffiliationPC)getPC()).getIdentifiantPeriode();
  }
  
  public String getIdentifiantPeriode()
  {
    return ((PeriodeAffiliationPC)getPC()).getIdentifiantPeriode();
  }
  
  public void setIdentifiantPeriode(String p_identifiantPeriode)
  {
    if ((m_identifiantPeriode == null) || (p_identifiantPeriode == null))
    {
      m_identifiantPeriode = p_identifiantPeriode;
      ((PeriodeAffiliationPC)getPC()).setIdentifiantPeriode(p_identifiantPeriode);
    }
    else if ((m_identifiantPeriode != null) && (p_identifiantPeriode != null) && (!p_identifiantPeriode.equals(m_identifiantPeriode)))
    {
      m_identifiantPeriode = p_identifiantPeriode;
      ((PeriodeAffiliationPC)getPC()).setIdentifiantPeriode(p_identifiantPeriode);
    }
  }
  
  protected Damj rawGetDateDebut()
  {
    return ((PeriodeAffiliationPC)getPC()).getDateDebut();
  }
  
  public Damj getDateDebut()
  {
    return ((PeriodeAffiliationPC)getPC()).getDateDebut();
  }
  
  public void setDateDebut(Damj p_dateDebut)
  {
    if ((m_dateDebut == null) || (p_dateDebut == null))
    {
      m_dateDebut = p_dateDebut;
      ((PeriodeAffiliationPC)getPC()).setDateDebut(p_dateDebut);
    }
    else if ((m_dateDebut != null) && (p_dateDebut != null) && (!p_dateDebut.equals(m_dateDebut)))
    {
      m_dateDebut = p_dateDebut;
      ((PeriodeAffiliationPC)getPC()).setDateDebut(p_dateDebut);
    }
  }
  
  protected Damj rawGetDateFin()
  {
    return ((PeriodeAffiliationPC)getPC()).getDateFin();
  }
  
  public Damj getDateFin()
  {
    return ((PeriodeAffiliationPC)getPC()).getDateFin();
  }
  
  public void setDateFin(Damj p_dateFin)
  {
    if ((m_dateFin == null) || (p_dateFin == null))
    {
      m_dateFin = p_dateFin;
      ((PeriodeAffiliationPC)getPC()).setDateFin(p_dateFin);
    }
    else if ((m_dateFin != null) && (p_dateFin != null) && (!p_dateFin.equals(m_dateFin)))
    {
      m_dateFin = p_dateFin;
      ((PeriodeAffiliationPC)getPC()).setDateFin(p_dateFin);
    }
  }
  
  protected String rawGetQualification()
  {
    return ((PeriodeAffiliationPC)getPC()).getQualification();
  }
  
  public String getQualification()
  {
    return ((PeriodeAffiliationPC)getPC()).getQualification();
  }
  
  public void setQualification(String p_qualification)
  {
    if ((m_qualification == null) || (p_qualification == null))
    {
      m_qualification = p_qualification;
      ((PeriodeAffiliationPC)getPC()).setQualification(p_qualification);
    }
    else if ((m_qualification != null) && (p_qualification != null) && (!p_qualification.equals(m_qualification)))
    {
      m_qualification = p_qualification;
      ((PeriodeAffiliationPC)getPC()).setQualification(p_qualification);
    }
  }
  
  protected String rawGetType()
  {
    return ((PeriodeAffiliationPC)getPC()).getType();
  }
  
  public String getType()
  {
    return ((PeriodeAffiliationPC)getPC()).getType();
  }
  
  public void setType(String p_type)
  {
    if ((m_type == null) || (p_type == null))
    {
      m_type = p_type;
      ((PeriodeAffiliationPC)getPC()).setType(p_type);
    }
    else if ((m_type != null) && (p_type != null) && (!p_type.equals(m_type)))
    {
      m_type = p_type;
      ((PeriodeAffiliationPC)getPC()).setType(p_type);
    }
  }
  
  protected String rawGetCompetenceFinanciere()
  {
    return ((PeriodeAffiliationPC)getPC()).getCompetenceFinanciere();
  }
  
  public String getCompetenceFinanciere()
  {
    return ((PeriodeAffiliationPC)getPC()).getCompetenceFinanciere();
  }
  
  public void setCompetenceFinanciere(String p_competenceFinanciere)
  {
    if ((m_competenceFinanciere == null) || (p_competenceFinanciere == null))
    {
      m_competenceFinanciere = p_competenceFinanciere;
      ((PeriodeAffiliationPC)getPC()).setCompetenceFinanciere(p_competenceFinanciere);
    }
    else if ((m_competenceFinanciere != null) && (p_competenceFinanciere != null) && (!p_competenceFinanciere.equals(m_competenceFinanciere)))
    {
      m_competenceFinanciere = p_competenceFinanciere;
      ((PeriodeAffiliationPC)getPC()).setCompetenceFinanciere(p_competenceFinanciere);
    }
  }
  
  protected String rawGetCompetenceAdministrative()
  {
    return ((PeriodeAffiliationPC)getPC()).getCompetenceAdministrative();
  }
  
  public String getCompetenceAdministrative()
  {
    return ((PeriodeAffiliationPC)getPC()).getCompetenceAdministrative();
  }
  
  public void setCompetenceAdministrative(String p_competenceAdministrative)
  {
    if ((m_competenceAdministrative == null) || (p_competenceAdministrative == null))
    {
      m_competenceAdministrative = p_competenceAdministrative;
      ((PeriodeAffiliationPC)getPC()).setCompetenceAdministrative(p_competenceAdministrative);
    }
    else if ((m_competenceAdministrative != null) && (p_competenceAdministrative != null) && (!p_competenceAdministrative.equals(m_competenceAdministrative)))
    {
      m_competenceAdministrative = p_competenceAdministrative;
      ((PeriodeAffiliationPC)getPC()).setCompetenceAdministrative(p_competenceAdministrative);
    }
  }
  
  protected Integer rawGetIdentifiantOD()
  {
    return ((PeriodeAffiliationPC)getPC()).getIdentifiantOD();
  }
  
  public Integer getIdentifiantOD()
  {
    return ((PeriodeAffiliationPC)getPC()).getIdentifiantOD();
  }
  
  public void setIdentifiantOD(Integer p_identifiantOD)
  {
    if ((m_identifiantOD == null) || (p_identifiantOD == null))
    {
      m_identifiantOD = p_identifiantOD;
      ((PeriodeAffiliationPC)getPC()).setIdentifiantOD(p_identifiantOD);
    }
    else if ((m_identifiantOD != null) && (p_identifiantOD != null) && (!p_identifiantOD.equals(m_identifiantOD)))
    {
      m_identifiantOD = p_identifiantOD;
      ((PeriodeAffiliationPC)getPC()).setIdentifiantOD(p_identifiantOD);
    }
  }
  
  protected String rawGetReferenceExterneDemande()
  {
    return ((PeriodeAffiliationPC)getPC()).getReferenceExterneDemande();
  }
  
  public String getReferenceExterneDemande()
  {
    return ((PeriodeAffiliationPC)getPC()).getReferenceExterneDemande();
  }
  
  public void setReferenceExterneDemande(String p_referenceExterneDemande)
  {
    if ((m_referenceExterneDemande == null) || (p_referenceExterneDemande == null))
    {
      m_referenceExterneDemande = p_referenceExterneDemande;
      ((PeriodeAffiliationPC)getPC()).setReferenceExterneDemande(p_referenceExterneDemande);
    }
    else if ((m_referenceExterneDemande != null) && (p_referenceExterneDemande != null) && (!p_referenceExterneDemande.equals(m_referenceExterneDemande)))
    {
      m_referenceExterneDemande = p_referenceExterneDemande;
      ((PeriodeAffiliationPC)getPC()).setReferenceExterneDemande(p_referenceExterneDemande);
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
 * Qualified Name:     PeriodeAffiliationGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
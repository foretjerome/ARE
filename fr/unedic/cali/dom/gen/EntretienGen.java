package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pc.EntretienPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;

public abstract class EntretienGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_entretienPC;
  private Damj m_dateCessationInscription;
  private Damj m_dateFinContrat;
  private Damj m_dateDebutPra;
  private Damj m_dateFinPra;
  private Quantite m_quantiteAffiliation;
  
  public EntretienGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public EntretienGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new EntretienPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_entretienPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_entretienPC)
  {
    m_entretienPC = p_entretienPC;
  }
  
  protected Damj rawGetDateCessationInscription()
  {
    return ((EntretienPC)getPC()).getDateCessationInscription();
  }
  
  public Damj getDateCessationInscription()
  {
    return ((EntretienPC)getPC()).getDateCessationInscription();
  }
  
  public void setDateCessationInscription(Damj p_dateCessationInscription)
  {
    if ((m_dateCessationInscription == null) || (p_dateCessationInscription == null))
    {
      m_dateCessationInscription = p_dateCessationInscription;
      ((EntretienPC)getPC()).setDateCessationInscription(p_dateCessationInscription);
    }
    else if ((m_dateCessationInscription != null) && (p_dateCessationInscription != null) && (!p_dateCessationInscription.equals(m_dateCessationInscription)))
    {
      m_dateCessationInscription = p_dateCessationInscription;
      ((EntretienPC)getPC()).setDateCessationInscription(p_dateCessationInscription);
    }
  }
  
  protected Damj rawGetDateFinContrat()
  {
    return ((EntretienPC)getPC()).getDateFinContrat();
  }
  
  public Damj getDateFinContrat()
  {
    return ((EntretienPC)getPC()).getDateFinContrat();
  }
  
  public void setDateFinContrat(Damj p_dateFinContrat)
  {
    if ((m_dateFinContrat == null) || (p_dateFinContrat == null))
    {
      m_dateFinContrat = p_dateFinContrat;
      ((EntretienPC)getPC()).setDateFinContrat(p_dateFinContrat);
    }
    else if ((m_dateFinContrat != null) && (p_dateFinContrat != null) && (!p_dateFinContrat.equals(m_dateFinContrat)))
    {
      m_dateFinContrat = p_dateFinContrat;
      ((EntretienPC)getPC()).setDateFinContrat(p_dateFinContrat);
    }
  }
  
  protected Damj rawGetDateDebutPra()
  {
    return ((EntretienPC)getPC()).getDateDebutPra();
  }
  
  public Damj getDateDebutPra()
  {
    return ((EntretienPC)getPC()).getDateDebutPra();
  }
  
  public void setDateDebutPra(Damj p_dateDebutPra)
  {
    if ((m_dateDebutPra == null) || (p_dateDebutPra == null))
    {
      m_dateDebutPra = p_dateDebutPra;
      ((EntretienPC)getPC()).setDateDebutPra(p_dateDebutPra);
    }
    else if ((m_dateDebutPra != null) && (p_dateDebutPra != null) && (!p_dateDebutPra.equals(m_dateDebutPra)))
    {
      m_dateDebutPra = p_dateDebutPra;
      ((EntretienPC)getPC()).setDateDebutPra(p_dateDebutPra);
    }
  }
  
  protected Damj rawGetDateFinPra()
  {
    return ((EntretienPC)getPC()).getDateFinPra();
  }
  
  public Damj getDateFinPra()
  {
    return ((EntretienPC)getPC()).getDateFinPra();
  }
  
  public void setDateFinPra(Damj p_dateFinPra)
  {
    if ((m_dateFinPra == null) || (p_dateFinPra == null))
    {
      m_dateFinPra = p_dateFinPra;
      ((EntretienPC)getPC()).setDateFinPra(p_dateFinPra);
    }
    else if ((m_dateFinPra != null) && (p_dateFinPra != null) && (!p_dateFinPra.equals(m_dateFinPra)))
    {
      m_dateFinPra = p_dateFinPra;
      ((EntretienPC)getPC()).setDateFinPra(p_dateFinPra);
    }
  }
  
  protected boolean rawIsAExerceActiviteSalarie()
  {
    return ((EntretienPC)getPC()).isAExerceActiviteSalarie();
  }
  
  public boolean isAExerceActiviteSalarie()
  {
    return ((EntretienPC)getPC()).isAExerceActiviteSalarie();
  }
  
  public void setAExerceActiviteSalarie(boolean p_aExerceActiviteSalarie)
  {
    ((EntretienPC)getPC()).setAExerceActiviteSalarie(p_aExerceActiviteSalarie);
  }
  
  protected boolean rawIsASuiviFormation()
  {
    return ((EntretienPC)getPC()).isASuiviFormation();
  }
  
  public boolean isASuiviFormation()
  {
    return ((EntretienPC)getPC()).isASuiviFormation();
  }
  
  public void setASuiviFormation(boolean p_aSuiviFormation)
  {
    ((EntretienPC)getPC()).setASuiviFormation(p_aSuiviFormation);
  }
  
  protected Quantite rawGetQuantiteAffiliation()
  {
    return ((EntretienPC)getPC()).getQuantiteAffiliation();
  }
  
  public Quantite getQuantiteAffiliation()
  {
    return ((EntretienPC)getPC()).getQuantiteAffiliation();
  }
  
  public void setQuantiteAffiliation(Quantite p_quantiteAffiliation)
  {
    if ((m_quantiteAffiliation == null) || (p_quantiteAffiliation == null))
    {
      m_quantiteAffiliation = p_quantiteAffiliation;
      ((EntretienPC)getPC()).setQuantiteAffiliation(p_quantiteAffiliation);
    }
    else if ((m_quantiteAffiliation != null) && (p_quantiteAffiliation != null) && (!p_quantiteAffiliation.equals(m_quantiteAffiliation)))
    {
      m_quantiteAffiliation = p_quantiteAffiliation;
      ((EntretienPC)getPC()).setQuantiteAffiliation(p_quantiteAffiliation);
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
 * Qualified Name:     EntretienGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
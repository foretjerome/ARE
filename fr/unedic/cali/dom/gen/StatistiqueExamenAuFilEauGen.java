package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pc.StatistiqueExamenAuFilEauPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class StatistiqueExamenAuFilEauGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_statistiqueExamenAuFilEauPC;
  private Damj m_dateEvenement;
  private Damj m_dateEvenementDeclencheur;
  private Damj m_datePremiereFctEtudiee;
  private Damj m_datePremiereFctEtudieeSansAffiSimplifiee;
  private Damj m_dateDerniereFctEtudiee;
  
  public StatistiqueExamenAuFilEauGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public StatistiqueExamenAuFilEauGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new StatistiqueExamenAuFilEauPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_statistiqueExamenAuFilEauPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_statistiqueExamenAuFilEauPC)
  {
    m_statistiqueExamenAuFilEauPC = p_statistiqueExamenAuFilEauPC;
  }
  
  protected Damj rawGetDateEvenement()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDateEvenement();
  }
  
  public Damj getDateEvenement()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDateEvenement();
  }
  
  public void setDateEvenement(Damj p_dateEvenement)
  {
    if ((m_dateEvenement == null) || (p_dateEvenement == null))
    {
      m_dateEvenement = p_dateEvenement;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDateEvenement(p_dateEvenement);
    }
    else if ((m_dateEvenement != null) && (p_dateEvenement != null) && (!p_dateEvenement.equals(m_dateEvenement)))
    {
      m_dateEvenement = p_dateEvenement;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDateEvenement(p_dateEvenement);
    }
  }
  
  protected Damj rawGetDateEvenementDeclencheur()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDateEvenementDeclencheur();
  }
  
  public Damj getDateEvenementDeclencheur()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDateEvenementDeclencheur();
  }
  
  public void setDateEvenementDeclencheur(Damj p_dateEvenementDeclencheur)
  {
    if ((m_dateEvenementDeclencheur == null) || (p_dateEvenementDeclencheur == null))
    {
      m_dateEvenementDeclencheur = p_dateEvenementDeclencheur;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDateEvenementDeclencheur(p_dateEvenementDeclencheur);
    }
    else if ((m_dateEvenementDeclencheur != null) && (p_dateEvenementDeclencheur != null) && (!p_dateEvenementDeclencheur.equals(m_dateEvenementDeclencheur)))
    {
      m_dateEvenementDeclencheur = p_dateEvenementDeclencheur;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDateEvenementDeclencheur(p_dateEvenementDeclencheur);
    }
  }
  
  protected int rawGetNatureDeclencheur()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getNatureDeclencheur();
  }
  
  public int getNatureDeclencheur()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getNatureDeclencheur();
  }
  
  public void setNatureDeclencheur(int p_natureDeclencheur)
  {
    ((StatistiqueExamenAuFilEauPC)getPC()).setNatureDeclencheur(p_natureDeclencheur);
  }
  
  protected Damj rawGetDatePremiereFctEtudiee()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDatePremiereFctEtudiee();
  }
  
  public Damj getDatePremiereFctEtudiee()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDatePremiereFctEtudiee();
  }
  
  public void setDatePremiereFctEtudiee(Damj p_datePremiereFctEtudiee)
  {
    if ((m_datePremiereFctEtudiee == null) || (p_datePremiereFctEtudiee == null))
    {
      m_datePremiereFctEtudiee = p_datePremiereFctEtudiee;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDatePremiereFctEtudiee(p_datePremiereFctEtudiee);
    }
    else if ((m_datePremiereFctEtudiee != null) && (p_datePremiereFctEtudiee != null) && (!p_datePremiereFctEtudiee.equals(m_datePremiereFctEtudiee)))
    {
      m_datePremiereFctEtudiee = p_datePremiereFctEtudiee;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDatePremiereFctEtudiee(p_datePremiereFctEtudiee);
    }
  }
  
  protected Damj rawGetDatePremiereFctEtudieeSansAffiSimplifiee()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDatePremiereFctEtudieeSansAffiSimplifiee();
  }
  
  public Damj getDatePremiereFctEtudieeSansAffiSimplifiee()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDatePremiereFctEtudieeSansAffiSimplifiee();
  }
  
  public void setDatePremiereFctEtudieeSansAffiSimplifiee(Damj p_datePremiereFctEtudieeSansAffiSimplifiee)
  {
    if ((m_datePremiereFctEtudieeSansAffiSimplifiee == null) || (p_datePremiereFctEtudieeSansAffiSimplifiee == null))
    {
      m_datePremiereFctEtudieeSansAffiSimplifiee = p_datePremiereFctEtudieeSansAffiSimplifiee;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDatePremiereFctEtudieeSansAffiSimplifiee(p_datePremiereFctEtudieeSansAffiSimplifiee);
    }
    else if ((m_datePremiereFctEtudieeSansAffiSimplifiee != null) && (p_datePremiereFctEtudieeSansAffiSimplifiee != null) && (!p_datePremiereFctEtudieeSansAffiSimplifiee.equals(m_datePremiereFctEtudieeSansAffiSimplifiee)))
    {
      m_datePremiereFctEtudieeSansAffiSimplifiee = p_datePremiereFctEtudieeSansAffiSimplifiee;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDatePremiereFctEtudieeSansAffiSimplifiee(p_datePremiereFctEtudieeSansAffiSimplifiee);
    }
  }
  
  protected Damj rawGetDateDerniereFctEtudiee()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDateDerniereFctEtudiee();
  }
  
  public Damj getDateDerniereFctEtudiee()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getDateDerniereFctEtudiee();
  }
  
  public void setDateDerniereFctEtudiee(Damj p_dateDerniereFctEtudiee)
  {
    if ((m_dateDerniereFctEtudiee == null) || (p_dateDerniereFctEtudiee == null))
    {
      m_dateDerniereFctEtudiee = p_dateDerniereFctEtudiee;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDateDerniereFctEtudiee(p_dateDerniereFctEtudiee);
    }
    else if ((m_dateDerniereFctEtudiee != null) && (p_dateDerniereFctEtudiee != null) && (!p_dateDerniereFctEtudiee.equals(m_dateDerniereFctEtudiee)))
    {
      m_dateDerniereFctEtudiee = p_dateDerniereFctEtudiee;
      ((StatistiqueExamenAuFilEauPC)getPC()).setDateDerniereFctEtudiee(p_dateDerniereFctEtudiee);
    }
  }
  
  protected int rawGetNombreTotalFctEtudiees()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getNombreTotalFctEtudiees();
  }
  
  public int getNombreTotalFctEtudiees()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getNombreTotalFctEtudiees();
  }
  
  public void setNombreTotalFctEtudiees(int p_nombreTotalFctEtudiees)
  {
    ((StatistiqueExamenAuFilEauPC)getPC()).setNombreTotalFctEtudiees(p_nombreTotalFctEtudiees);
  }
  
  protected int rawGetResultatExamen()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getResultatExamen();
  }
  
  public int getResultatExamen()
  {
    return ((StatistiqueExamenAuFilEauPC)getPC()).getResultatExamen();
  }
  
  public void setResultatExamen(int p_resultatExamen)
  {
    ((StatistiqueExamenAuFilEauPC)getPC()).setResultatExamen(p_resultatExamen);
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     StatistiqueExamenAuFilEauGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
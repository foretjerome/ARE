package fr.unedic.cali.calcul.pbjc.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.pbjc.dom.pc.DispositifNcpPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class DispositifNcpGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_dispositifNcpPC;
  private Damj m_dateDebutDispositif;
  private Damj m_dateFinDispositifAvant;
  private Damj m_dateFinDispositifApres;
  private String m_idTracker;
  
  public DispositifNcpGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public DispositifNcpGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new DispositifNcpPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_dispositifNcpPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_dispositifNcpPC)
  {
    m_dispositifNcpPC = p_dispositifNcpPC;
  }
  
  protected Damj rawGetDateDebutDispositif()
  {
    return ((DispositifNcpPC)getPC()).getDateDebutDispositif();
  }
  
  public Damj getDateDebutDispositif()
  {
    return ((DispositifNcpPC)getPC()).getDateDebutDispositif();
  }
  
  public void setDateDebutDispositif(Damj p_dateDebutDispositif)
  {
    if ((m_dateDebutDispositif == null) || (p_dateDebutDispositif == null))
    {
      m_dateDebutDispositif = p_dateDebutDispositif;
      ((DispositifNcpPC)getPC()).setDateDebutDispositif(p_dateDebutDispositif);
    }
    else if ((m_dateDebutDispositif != null) && (p_dateDebutDispositif != null) && (!p_dateDebutDispositif.equals(m_dateDebutDispositif)))
    {
      m_dateDebutDispositif = p_dateDebutDispositif;
      ((DispositifNcpPC)getPC()).setDateDebutDispositif(p_dateDebutDispositif);
    }
  }
  
  protected Damj rawGetDateFinDispositifAvant()
  {
    return ((DispositifNcpPC)getPC()).getDateFinDispositifAvant();
  }
  
  public Damj getDateFinDispositifAvant()
  {
    return ((DispositifNcpPC)getPC()).getDateFinDispositifAvant();
  }
  
  public void setDateFinDispositifAvant(Damj p_dateFinDispositifAvant)
  {
    if ((m_dateFinDispositifAvant == null) || (p_dateFinDispositifAvant == null))
    {
      m_dateFinDispositifAvant = p_dateFinDispositifAvant;
      ((DispositifNcpPC)getPC()).setDateFinDispositifAvant(p_dateFinDispositifAvant);
    }
    else if ((m_dateFinDispositifAvant != null) && (p_dateFinDispositifAvant != null) && (!p_dateFinDispositifAvant.equals(m_dateFinDispositifAvant)))
    {
      m_dateFinDispositifAvant = p_dateFinDispositifAvant;
      ((DispositifNcpPC)getPC()).setDateFinDispositifAvant(p_dateFinDispositifAvant);
    }
  }
  
  protected Damj rawGetDateFinDispositifApres()
  {
    return ((DispositifNcpPC)getPC()).getDateFinDispositifApres();
  }
  
  public Damj getDateFinDispositifApres()
  {
    return ((DispositifNcpPC)getPC()).getDateFinDispositifApres();
  }
  
  public void setDateFinDispositifApres(Damj p_dateFinDispositifApres)
  {
    if ((m_dateFinDispositifApres == null) || (p_dateFinDispositifApres == null))
    {
      m_dateFinDispositifApres = p_dateFinDispositifApres;
      ((DispositifNcpPC)getPC()).setDateFinDispositifApres(p_dateFinDispositifApres);
    }
    else if ((m_dateFinDispositifApres != null) && (p_dateFinDispositifApres != null) && (!p_dateFinDispositifApres.equals(m_dateFinDispositifApres)))
    {
      m_dateFinDispositifApres = p_dateFinDispositifApres;
      ((DispositifNcpPC)getPC()).setDateFinDispositifApres(p_dateFinDispositifApres);
    }
  }
  
  protected String rawGetIdTracker()
  {
    return ((DispositifNcpPC)getPC()).getIdTracker();
  }
  
  public String getIdTracker()
  {
    return ((DispositifNcpPC)getPC()).getIdTracker();
  }
  
  public void setIdTracker(String p_idTracker)
  {
    if ((m_idTracker == null) || (p_idTracker == null))
    {
      m_idTracker = p_idTracker;
      ((DispositifNcpPC)getPC()).setIdTracker(p_idTracker);
    }
    else if ((m_idTracker != null) && (p_idTracker != null) && (!p_idTracker.equals(m_idTracker)))
    {
      m_idTracker = p_idTracker;
      ((DispositifNcpPC)getPC()).setIdTracker(p_idTracker);
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
 * Qualified Name:     DispositifNcpGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
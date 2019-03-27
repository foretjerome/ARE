package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.calcul.dom.periode.gen.DsmTravailGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public class DsmTravail
  extends DsmTravailGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 8437288269207986537L;
  private transient String m_origineInfo;
  private transient int m_statutDSMTravail;
  private transient boolean m_estMigree;
  
  protected DsmTravail() {}
  
  public DsmTravail(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public DsmTravail(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  public DsmTravail(DsmTravail p_dsmTravail)
  {
    super(p_dsmTravail.getDateDebut(), p_dsmTravail.getDateFin());
    setGain(p_dsmTravail.getGain());
    setNombreHeures(p_dsmTravail.getNombreHeures());
    setCachets(p_dsmTravail.getCachets());
    setOrigineInfo(p_dsmTravail.getOrigineInfo());
    setIsJustifiee(p_dsmTravail.isJustifiee());
    setStatutDSMTravail(p_dsmTravail.getStatutDSMTravail());
  }
  
  public void setJustifiee(boolean p_isJustifiee)
  {
    super.setIsJustifiee(p_isJustifiee);
  }
  
  public boolean isJustifiee()
  {
    return super.isIsJustifiee();
  }
  
  public String getOrigineInfo()
  {
    return m_origineInfo;
  }
  
  public void setOrigineInfo(String p_origineInfo)
  {
    m_origineInfo = p_origineInfo;
  }
  
  public int getStatutDSMTravail()
  {
    return m_statutDSMTravail;
  }
  
  public void setStatutDSMTravail(int p_statutDSMTravail)
  {
    m_statutDSMTravail = p_statutDSMTravail;
  }
  
  public ObjetMetierSpec copie()
  {
    DsmTravail copie = new DsmTravail();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    DsmTravail copie = (DsmTravail)p_copie;
    
    super.copieElements(copie);
    m_origineInfo = getOrigineInfo();
    copie.setIsJustifiee(isJustifiee());
    m_statutDSMTravail = getStatutDSMTravail();
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public boolean estMigree()
  {
    return m_estMigree;
  }
  
  public void setEstMigree(boolean p_estMigree)
  {
    m_estMigree = p_estMigree;
  }
}

/* Location:
 * Qualified Name:     DsmTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
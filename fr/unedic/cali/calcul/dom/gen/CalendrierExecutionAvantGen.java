package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.EtatAuDernierJourAvant;
import fr.unedic.cali.calcul.dom.pc.CalendrierExecutionAvantPC;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeCREM;

public abstract class CalendrierExecutionAvantGen
  extends ObjetChronoPeriodeCREM
  implements DomGenSpec
{
  private EtatAuDernierJourAvant m_etatAuDernierJourAvant;
  private Damj m_dateDrv;
  
  public CalendrierExecutionAvantGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public CalendrierExecutionAvantGen() {}
  
  protected DomPCSpec createPC()
  {
    return new CalendrierExecutionAvantPC();
  }
  
  public EtatAuDernierJourAvant getEtatAuDernierJourAvant()
  {
    if (m_etatAuDernierJourAvant == null)
    {
      DomPCSpec etatAuDernierJourAvantPC = ((CalendrierExecutionAvantPC)getPC()).getEtatAuDernierJourAvant();
      if (etatAuDernierJourAvantPC != null) {
        m_etatAuDernierJourAvant = ((EtatAuDernierJourAvant)etatAuDernierJourAvantPC.createOM());
      }
    }
    return m_etatAuDernierJourAvant;
  }
  
  public void setEtatAuDernierJourAvant(EtatAuDernierJourAvant p_etatAuDernierJourAvant)
  {
    if (p_etatAuDernierJourAvant == null)
    {
      ((CalendrierExecutionAvantPC)getPC()).setEtatAuDernierJourAvant(null);
      m_etatAuDernierJourAvant = p_etatAuDernierJourAvant;
    }
    else if (!p_etatAuDernierJourAvant.equals(m_etatAuDernierJourAvant))
    {
      ((CalendrierExecutionAvantPC)getPC()).setEtatAuDernierJourAvant(p_etatAuDernierJourAvant.getPC());
      m_etatAuDernierJourAvant = p_etatAuDernierJourAvant;
    }
  }
  
  protected Damj rawGetDateDrv()
  {
    return ((CalendrierExecutionAvantPC)getPC()).getDateDrv();
  }
  
  public Damj getDateDrv()
  {
    return ((CalendrierExecutionAvantPC)getPC()).getDateDrv();
  }
  
  public void setDateDrv(Damj p_dateDrv)
  {
    if ((m_dateDrv == null) || (p_dateDrv == null))
    {
      m_dateDrv = p_dateDrv;
      ((CalendrierExecutionAvantPC)getPC()).setDateDrv(p_dateDrv);
    }
    else if ((m_dateDrv != null) && (p_dateDrv != null) && (!p_dateDrv.equals(m_dateDrv)))
    {
      m_dateDrv = p_dateDrv;
      ((CalendrierExecutionAvantPC)getPC()).setDateDrv(p_dateDrv);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
    
    Object etatAuDernierJourAvant = getEtatAuDernierJourAvant();
    if ((etatAuDernierJourAvant != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(etatAuDernierJourAvant))) {
      DomManager.supprimer(getEtatAuDernierJourAvant(), p_contexteSuppression);
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     CalendrierExecutionAvantGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.Entretien;
import fr.unedic.cali.dom.pc.PreInscriptionPC;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class PreInscriptionGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_preInscriptionPC;
  private Damj m_datePreInscription;
  public Entretien m_entretien = null;
  
  public PreInscriptionGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public PreInscriptionGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new PreInscriptionPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_preInscriptionPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_preInscriptionPC)
  {
    m_preInscriptionPC = p_preInscriptionPC;
  }
  
  protected Damj rawGetDatePreInscription()
  {
    return ((PreInscriptionPC)getPC()).getDatePreInscription();
  }
  
  public Damj getDatePreInscription()
  {
    return ((PreInscriptionPC)getPC()).getDatePreInscription();
  }
  
  public void setDatePreInscription(Damj p_datePreInscription)
  {
    if ((m_datePreInscription == null) || (p_datePreInscription == null))
    {
      m_datePreInscription = p_datePreInscription;
      ((PreInscriptionPC)getPC()).setDatePreInscription(p_datePreInscription);
    }
    else if ((m_datePreInscription != null) && (p_datePreInscription != null) && (!p_datePreInscription.equals(m_datePreInscription)))
    {
      m_datePreInscription = p_datePreInscription;
      ((PreInscriptionPC)getPC()).setDatePreInscription(p_datePreInscription);
    }
  }
  
  public Entretien getEntretien()
  {
    if (m_entretien == null)
    {
      DomPCSpec entretienPC = ((PreInscriptionPC)getPC()).getEntretien();
      if (entretienPC != null) {
        m_entretien = ((Entretien)entretienPC.createOM());
      }
    }
    return m_entretien;
  }
  
  public void setEntretien(Entretien p_entretien)
  {
    if (p_entretien == null)
    {
      ((PreInscriptionPC)getPC()).setEntretien(null);
      m_entretien = p_entretien;
    }
    else if (!p_entretien.equals(m_entretien))
    {
      ((PreInscriptionPC)getPC()).setEntretien(p_entretien.getPC());
      m_entretien = p_entretien;
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    Object entretien = getEntretien();
    if ((entretien != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(entretien))) {
      DomManager.supprimer(getEntretien(), p_contexteSuppression);
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     PreInscriptionGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
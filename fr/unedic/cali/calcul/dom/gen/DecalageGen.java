package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.DecalageDuree;
import fr.unedic.cali.calcul.dom.pc.DecalagePC;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public abstract class DecalageGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_decalagePC;
  private DecalageDuree m_decalageDuree;
  
  public DecalageGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public DecalageGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new DecalagePC();
  }
  
  public DomPCSpec getPC()
  {
    return m_decalagePC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_decalagePC)
  {
    m_decalagePC = p_decalagePC;
  }
  
  public DecalageDuree getDecalageDuree()
  {
    if (m_decalageDuree == null)
    {
      DomPCSpec decalageDureePC = ((DecalagePC)getPC()).getDecalageDuree();
      if (decalageDureePC != null) {
        m_decalageDuree = ((DecalageDuree)decalageDureePC.createOM());
      }
    }
    return m_decalageDuree;
  }
  
  public void setDecalageDuree(DecalageDuree p_decalageDuree)
  {
    if (p_decalageDuree == null)
    {
      ((DecalagePC)getPC()).setDecalageDuree(null);
      m_decalageDuree = p_decalageDuree;
    }
    else if (!p_decalageDuree.equals(m_decalageDuree))
    {
      ((DecalagePC)getPC()).setDecalageDuree(p_decalageDuree.getPC());
      m_decalageDuree = p_decalageDuree;
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    Object decalageDuree = getDecalageDuree();
    if ((decalageDuree != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(decalageDuree))) {
      DomManager.supprimer(getDecalageDuree(), p_contexteSuppression);
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     DecalageGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
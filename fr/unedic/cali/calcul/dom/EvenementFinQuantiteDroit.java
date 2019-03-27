package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.EvenementFinQuantiteDroitGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.QuantiteDroitSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class EvenementFinQuantiteDroit
  extends EvenementFinQuantiteDroitGen
  implements EvenementCalculSpec, ObjetPersistantSpec
{
  private static final long serialVersionUID = 1823028922649088883L;
  private transient boolean m_estCauseFinProduit = false;
  
  protected EvenementFinQuantiteDroit() {}
  
  public EvenementFinQuantiteDroit(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public EvenementFinQuantiteDroit(Damj p_dateEffet)
  {
    super(p_dateEffet);
  }
  
  public boolean estCauseFinProduit()
  {
    return m_estCauseFinProduit;
  }
  
  public void setEstCauseFinProduit(boolean p_estCauseFinProduit)
  {
    m_estCauseFinProduit = p_estCauseFinProduit;
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getQuantiteDroit());
  }
  
  public void jdoPreStore() {}
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementFinQuantiteDroit copie = (EvenementFinQuantiteDroit)p_copie;
    copie.setDateEvenement(getDateEvenement());
    
    m_estCauseFinProduit = estCauseFinProduit();
    if (getQuantiteDroit() != null) {
      copie.setQuantiteDroit((QuantiteDroitSpec)getQuantiteDroit().copie());
    }
  }
  
  public void setQuantiteDroit(QuantiteDroitSpec quantiteDroit)
  {
    DomManager.supprimer(super.getQuantiteDroit(), quantiteDroit);
    super.setQuantiteDroit(quantiteDroit);
  }
}

/* Location:
 * Qualified Name:     EvenementFinQuantiteDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
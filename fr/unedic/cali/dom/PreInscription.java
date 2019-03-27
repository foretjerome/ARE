package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.PreInscriptionGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class PreInscription
  extends PreInscriptionGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = -2002180519771458763L;
  
  public PreInscription(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public PreInscription() {}
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PreInscription copie = (PreInscription)p_copie;
    copie.setDatePreInscription(getDatePreInscription());
    if (getEntretien() != null)
    {
      Entretien entretien = new Entretien();
      getEntretien().copieElements(entretien);
      copie.setEntretien(entretien);
    }
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getEntretien());
  }
  
  public void setEntretien(Entretien entretien)
  {
    DomManager.supprimer(super.getEntretien(), entretien);
    super.setEntretien(entretien);
  }
  
  public ObjetMetierSpec copie()
  {
    PreInscription copie = new PreInscription();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     PreInscription
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
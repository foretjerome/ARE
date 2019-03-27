package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.DecalageDureeGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;

public class DecalageDuree
  extends DecalageDureeGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = -6975299335613298119L;
  
  public DecalageDuree() {}
  
  public DecalageDuree(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public ObjetMetierSpec copie()
  {
    DecalageDuree copie = new DecalageDuree();
    copieElements(copie);
    return copie;
  }
  
  public String toString()
  {
    StringBuffer string = new StringBuffer();
    if (getDecalageCourant() != null) {
      string.append("Decalage courant : " + getDecalageCourant().getValeur() + " " + getDecalageCourant().getUnite());
    }
    return string.toString();
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    DecalageDuree copie = (DecalageDuree)p_copie;
    copie.setDecalageCourant(getDecalageCourant());
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public void jdoPreStore() {}
}

/* Location:
 * Qualified Name:     DecalageDuree
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
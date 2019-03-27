package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.DecalageGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import java.math.BigDecimal;

public class Decalage
  extends DecalageGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 4583214851230583554L;
  private transient Unite uniteM = null;
  private transient Quantite decalageM = null;
  private transient Quantite decalagePndsM = null;
  private transient Quantite decalageSanctionsM = null;
  
  private Decalage() {}
  
  public Decalage(DomPCSpec pc)
  {
    super(pc);
  }
  
  public Decalage(Unite unite)
  {
    uniteM = unite;
  }
  
  public Quantite getCreditDecalage()
  {
    return decalageM;
  }
  
  public void setCreditDecalage(Quantite decalage)
  {
    decalageM = decalage;
  }
  
  public Quantite getCreditDecalageDuree()
  {
    if (super.getDecalageDuree() == null) {
      return null;
    }
    return super.getDecalageDuree().getDecalageCourant();
  }
  
  public void setCreditDecalageDuree(Quantite decalageDuree)
  {
    if ((decalageDuree != null) && (BigDecimal.ZERO.compareTo(decalageDuree.getValeur()) != 0))
    {
      if (super.getDecalageDuree() == null) {
        super.setDecalageDuree(new DecalageDuree());
      }
      super.getDecalageDuree().setDecalageCourant(decalageDuree);
    }
  }
  
  public Quantite getCreditDecalagePNDS()
  {
    return decalagePndsM;
  }
  
  public void setCreditDecalagePNDS(Quantite decalagePNDS)
  {
    decalagePndsM = decalagePNDS;
  }
  
  public Quantite getCreditDecalageSanctions()
  {
    return decalageSanctionsM;
  }
  
  public void setCreditDecalageSanctions(Quantite decalageSanctions)
  {
    decalageSanctionsM = decalageSanctions;
  }
  
  public Unite getUnite()
  {
    return uniteM;
  }
  
  public void setUnite(Unite unite)
  {
    uniteM = unite;
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    Decalage copie = new Decalage();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec om)
  {
    Decalage copie = (Decalage)om;
    
    copie.setUnite(getUnite());
    copie.setCreditDecalage(getCreditDecalage());
    copie.setCreditDecalageDuree(getCreditDecalageDuree());
    copie.setCreditDecalagePNDS(getCreditDecalagePNDS());
    copie.setCreditDecalageSanctions(getCreditDecalageSanctions());
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete()
  {
    DomManager.supprimer(super.getDecalageDuree());
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getDecalageDuree());
  }
  
  public void jdoPreStore() {}
  
  public void setDecalageDuree(DecalageDuree decalageDuree)
  {
    DomManager.supprimer(super.getDecalageDuree(), decalageDuree);
    super.setDecalageDuree(decalageDuree);
  }
}

/* Location:
 * Qualified Name:     Decalage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
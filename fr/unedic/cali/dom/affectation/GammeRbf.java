package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public class GammeRbf
  extends GammeAbstrait
  implements GammeRbfSpec
{
  private static final long serialVersionUID = -5852525359531271488L;
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.rbf.GammeRbfDelegue";
  private transient GammeDelegueSpec gammeDeleguee = null;
  private static GammeRbf instanceUnique;
  
  private GammeRbf()
  {
    ajouterLigne(LigneRbfHbt01.getInstancePourInitialisation());
    ajouterLigne(LigneRbfTpt02.getInstancePourInitialisation());
    ajouterLigne(LigneRbfRtn03.getInstancePourInitialisation());
    ajouterLigne(LigneRbfFpo04.getInstancePourInitialisation());
    ajouterLigne(LigneRbfMob07.getInstancePourInitialisation());
    ajouterLigne(LigneRbfAge08.getInstancePourInitialisation());
    ajouterLigne(LigneRbfAides.getInstancePourInitialisation());
    setNomUnique("RBF");
    setLibelle("Gamme Remboursement et prise en charge de frais");
  }
  
  public static GammeRbf getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new GammeRbf();
    }
    return instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new GammeRbf();
    }
    return instanceUnique;
  }
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (gammeDeleguee == null) {
      gammeDeleguee = creerGammeDelegue("fr.unedic.cali.rbf.GammeRbfDelegue");
    }
    return gammeDeleguee;
  }
  
  public int getPriorite()
  {
    return 10;
  }
  
  public void mettreEnReexamen(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    getGammeDelegue().mettreEnReexamen(demande);
  }
  
  public Collection getProduits(DemandeSpec demande)
  {
    return ((GammeRbfDelegueSpec)getGammeDelegue()).getProduits(demande);
  }
  
  public String getIdActionFormationLiee(DemandeSpec demande)
  {
    return ((GammeRbfDelegueSpec)getGammeDelegue()).getIdActionFormationLiee(demande);
  }
  
  public String getIdActiviteSalarieeLiee(DemandeSpec demande)
  {
    return ((GammeRbfDelegueSpec)getGammeDelegue()).getIdActiviteSalarieeLiee(demande);
  }
  
  public Damj getDateMinAttibutions(DemandeSpec demande)
  {
    return ((GammeRbfDelegueSpec)getGammeDelegue()).getDateMinAttibutions(demande);
  }
  
  public void initialiserDemandeAssociee(Individu individu, DemandeSpec demande)
  {
    getGammeDelegue().initialiserDemandeAssociee(individu, demande);
  }
  
  public Damj recupererDateDepotDemandeDepuisReferenceExt(String referenceExterne)
  {
    return ((GammeRbfDelegueSpec)getGammeDelegue()).recupererDateDepotDemandeDepuisReferenceExt(referenceExterne);
  }
  
  public void traitementPostValidation(DemandeSpec demande)
    throws ApplicativeException
  {
    ((GammeRbfDelegueSpec)getGammeDelegue()).traitementPostValidation(demande);
  }
}

/* Location:
 * Qualified Name:     GammeRbf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
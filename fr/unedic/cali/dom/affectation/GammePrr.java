package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.CoucheLogiqueException;

public class GammePrr
  extends GammeAbstrait
  implements GammePrrSpec
{
  private static final long serialVersionUID = 1358733952692913035L;
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.prr.GammePrrDelegue";
  private static GammeDelegueSpec s_gammeDeleguee;
  private static GammePrr s_instanceUnique;
  
  public static GammePrr getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammePrr();
    }
    return s_instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammePrr();
    }
    return s_instanceUnique;
  }
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (s_gammeDeleguee == null) {
      s_gammeDeleguee = creerGammeDelegue("fr.unedic.cali.prr.GammePrrDelegue");
    }
    return s_gammeDeleguee;
  }
  
  protected GammePrr()
  {
    ajouterLigne(LignePrrPrl02.getInstancePourInitialisation());
    ajouterLigne(LignePrrPlf03.getInstancePourInitialisation());
    setNomUnique("PRR");
    setLibelle("Gamme Préretraite");
  }
  
  public int getPriorite()
  {
    return 100;
  }
  
  public void initialiserDemandeAssociee(Individu p_individu, DemandeSpec p_demande) {}
  
  public void mettreEnReexamen(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {}
}

/* Location:
 * Qualified Name:     GammePrr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
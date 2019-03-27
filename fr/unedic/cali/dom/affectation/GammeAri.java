package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.CoucheLogiqueException;

public class GammeAri
  extends GammeAbstrait
  implements GammeAriSpec, FacadeLiquidationGammeAriSpec
{
  private static final long serialVersionUID = 1L;
  private static GammeAri s_instanceUnique;
  private static final String LIBELLE_GAMME = "Gamme ARI";
  private static GammeDelegueSpec s_gammeDeleguee;
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.ari.GammeAriDelegue";
  
  public static GammeAri getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeAri();
    }
    return s_instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeAri();
    }
    return s_instanceUnique;
  }
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (s_gammeDeleguee == null) {
      s_gammeDeleguee = creerGammeDelegue("fr.unedic.cali.ari.GammeAriDelegue");
    }
    return s_gammeDeleguee;
  }
  
  protected GammeAri()
  {
    setNomUnique("ARI");
    setLibelle("Gamme ARI");
  }
  
  public int getPriorite()
  {
    return 7;
  }
  
  public void initialiserDemandeAssociee(Individu p_individu, DemandeSpec p_demande)
  {
    getGammeDelegue().initialiserDemandeAssociee(p_individu, p_demande);
  }
  
  public void mettreEnReexamen(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    getGammeDelegue().mettreEnReexamen(p_demande);
  }
}

/* Location:
 * Qualified Name:     GammeAri
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
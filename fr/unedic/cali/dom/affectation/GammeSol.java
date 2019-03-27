package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class GammeSol
  extends GammeAbstrait
  implements GammeSolSpec
{
  private static final long serialVersionUID = 1L;
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.sol.GammeSolDelegue";
  private static GammeDelegueSpec s_gammeDeleguee;
  private static GammeSol s_instanceUnique;
  
  public static GammeSol getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeSol();
    }
    return s_instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeSol();
    }
    return s_instanceUnique;
  }
  
  private GammeSol()
  {
    ajouterLigne(LigneSolCge01.getInstancePourInitialisation());
    ajouterLigne(LigneSolCpa02.getInstancePourInitialisation());
    ajouterLigne(LigneSolAer05.getInstancePourInitialisation());
    ajouterLigne(LigneSolAta06.getInstancePourInitialisation());
    ajouterLigne(LigneSolSub09.getInstancePourInitialisation());
    setNomUnique("SOL");
    setLibelle("Gamme Solidarité");
  }
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (s_gammeDeleguee == null) {
      s_gammeDeleguee = creerGammeDelegue("fr.unedic.cali.sol.GammeSolDelegue");
    }
    return s_gammeDeleguee;
  }
  
  public int getPriorite()
  {
    return 9;
  }
  
  public void mettreEnReexamen(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    getGammeDelegue().mettreEnReexamen(p_demande);
  }
  
  public void initialiserDemandeAssociee(Individu p_individu, DemandeSpec p_demande)
  {
    getGammeDelegue().initialiserDemandeAssociee(p_individu, p_demande);
  }
  
  public Damj recupererDjiParEpuisementDroitSecteurPublic(DemandeSpec p_demande)
  {
    return ((GammeSolDelegueSpec)getGammeDelegue()).recupererDjiParEpuisementDroitSecteurPublic(p_demande);
  }
}

/* Location:
 * Qualified Name:     GammeSol
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.CoucheLogiqueException;

public class GammeInr
  extends GammeAbstrait
  implements GammeInrSpec
{
  private static final long serialVersionUID = 6983053279594615543L;
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.inr.GammeInrDelegue";
  private static GammeDelegueSpec s_gammeDeleguee;
  private static GammeInr s_instanceUnique;
  
  public static GammeInr getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeInr();
    }
    return s_instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeInr();
    }
    return s_instanceUnique;
  }
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (s_gammeDeleguee == null) {
      s_gammeDeleguee = creerGammeDelegue("fr.unedic.cali.inr.GammeInrDelegue");
    }
    return s_gammeDeleguee;
  }
  
  protected GammeInr()
  {
    ajouterLigne(LigneInrCes06.getInstancePourInitialisation());
    ajouterLigne(LigneInrPfm01.getInstancePourInitialisation());
    ajouterLigne(LigneInrRce04.getInstancePourInitialisation());
    ajouterLigne(LigneInrAdr03.getInstancePourInitialisation());
    ajouterLigne(LigneInrPar09.getInstancePourInitialisation());
    setNomUnique("INR");
    setLibelle("Gamme Incitation au Reclassement");
  }
  
  public int getPriorite()
  {
    return 8;
  }
  
  public void mettreEnReexamen(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    getGammeDelegue().mettreEnReexamen(p_demande);
  }
  
  public String getIdActiviteLiee(DemandeSpec p_demande)
  {
    return ((GammeInrDelegueSpec)getGammeDelegue()).getIdActiviteLiee(p_demande);
  }
  
  public void initialiserDemandeAssociee(Individu p_individu, DemandeSpec p_demande)
  {
    getGammeDelegue().initialiserDemandeAssociee(p_individu, p_demande);
  }
}

/* Location:
 * Qualified Name:     GammeInr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
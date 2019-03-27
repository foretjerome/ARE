package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.CoucheLogiqueException;

public class GammeFor
  extends GammeAbstrait
  implements GammeForSpec
{
  private static final long serialVersionUID = 1L;
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.form.GammeForDelegue";
  private static final String LIBELLE_GAMME = "Gamme Formation";
  private static GammeDelegueSpec s_gammeDeleguee;
  private static GammeFor s_instanceUnique;
  
  public static GammeFor getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeFor();
    }
    return s_instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeFor();
    }
    return s_instanceUnique;
  }
  
  private GammeFor()
  {
    ajouterLigne(LigneForAff03.getInstancePourInitialisation());
    ajouterLigne(LigneForRfp04.getInstancePourInitialisation());
    
    ajouterLigne(LigneForRps02.getInstancePourInitialisation());
    
    ajouterLigne(LigneForCsp05.getInstancePourInitialisation());
    setNomUnique("FOR");
    setLibelle("Gamme Formation");
  }
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (s_gammeDeleguee == null) {
      s_gammeDeleguee = creerGammeDelegue("fr.unedic.cali.form.GammeForDelegue");
    }
    return s_gammeDeleguee;
  }
  
  public int getPriorite()
  {
    return 11;
  }
  
  public void mettreEnReexamen(DemandeSpec p_demande)
    throws CoucheLogiqueException
  {
    getGammeDelegue().mettreEnReexamen(p_demande);
  }
  
  public String getIdActionFormationLiee(DemandeSpec p_demande)
  {
    return ((GammeForDelegueSpec)getGammeDelegue()).getIdActionFormationLiee(p_demande);
  }
  
  public void initialiserDemandeAssociee(Individu p_individu, DemandeSpec p_demande)
  {
    getGammeDelegue().initialiserDemandeAssociee(p_individu, p_demande);
  }
}

/* Location:
 * Qualified Name:     GammeFor
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
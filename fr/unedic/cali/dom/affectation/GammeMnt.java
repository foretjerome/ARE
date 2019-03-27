package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.ResultatTraitementPopulation;
import fr.unedic.util.services.CoucheLogiqueException;

public class GammeMnt
  extends GammeAbstrait
  implements FacadeLiquidationGammeMntSpec
{
  private static final long serialVersionUID = -8399108697954950335L;
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.asu.mnt.GammeMntDelegue";
  private static GammeDelegueSpec s_gammeDeleguee;
  private static GammeMnt s_instanceUnique;
  
  public static GammeMnt getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeMnt();
    }
    return s_instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeMnt();
    }
    return s_instanceUnique;
  }
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (s_gammeDeleguee == null) {
      s_gammeDeleguee = creerGammeDelegue("fr.unedic.cali.asu.mnt.GammeMntDelegue");
    }
    return s_gammeDeleguee;
  }
  
  protected GammeMnt()
  {
    ajouterLigne(LigneAsuMnt09.getInstancePourInitialisation());
    setNomUnique("ASU");
    setLibelle("Gamme Maintien");
  }
  
  public int getPriorite()
  {
    return 12;
  }
  
  public ResultatTraitementPopulation effectuerTraitementOccasionnel(CriteresTraitementPopulation p_criteres)
    throws ApplicativeException
  {
    return getGammeMntDelegue().effectuerTraitementOccasionnel(p_criteres);
  }
  
  public GammeMntDelegueSpec getGammeMntDelegue()
  {
    return (GammeMntDelegueSpec)getGammeDelegue();
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
  
  public ProduitSpec determinerProduitDemandeMaintenue(DemandeSpec p_demande)
  {
    return getGammeMntDelegue().determinerProduitDemandeMaintenue(p_demande);
  }
}

/* Location:
 * Qualified Name:     GammeMnt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
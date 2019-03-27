package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.util.services.CoucheLogiqueException;

public class GammeRet
  extends GammeAbstrait
  implements GammeRetSpec
{
  private static final long serialVersionUID = 1L;
  private static final String LIBELLE_GAMME = "Gamme RET";
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.ari.GammeAriDelegue";
  private static GammeDelegueSpec s_gammeDeleguee;
  private static GammeRet s_instanceUnique;
  
  public static GammeRet getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeRet();
    }
    return s_instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeRet();
    }
    return s_instanceUnique;
  }
  
  private GammeRet()
  {
    ajouterLigne(LigneRetAco01.getInstancePourInitialisation());
    setNomUnique("RET");
    setLibelle("Gamme RET");
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
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (s_gammeDeleguee == null) {
      s_gammeDeleguee = creerGammeDelegue("fr.unedic.cali.ari.GammeAriDelegue");
    }
    return s_gammeDeleguee;
  }
  
  public int getPriorite()
  {
    return 7;
  }
  
  public Class getClassGestionnaireErreur()
  {
    return null;
  }
  
  public void traitementPostValidation(DemandeSpec demande)
    throws ApplicativeException
  {}
}

/* Location:
 * Qualified Name:     GammeRet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Individu;

public class GammeDec
  extends GammeAbstrait
  implements GammeDecSpec
{
  private static final long serialVersionUID = 7414191163364709217L;
  private static GammeDec s_instanceUnique;
  private static final String LIBELLE_GAMME = "Gamme Décès";
  private static GammeDelegueSpec s_gammeDeleguee;
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.dec.GammeDecDelegue";
  
  public static GammeDec getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeDec();
    }
    return s_instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new GammeDec();
    }
    return s_instanceUnique;
  }
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (s_gammeDeleguee == null) {
      s_gammeDeleguee = creerGammeDelegue("fr.unedic.cali.dec.GammeDecDelegue");
    }
    return s_gammeDeleguee;
  }
  
  protected GammeDec()
  {
    ajouterLigne(LigneDecCge01.getInstancePourInitialisation());
    setNomUnique("DEC");
    setLibelle("Gamme Décès");
  }
  
  public int getPriorite()
  {
    return 7;
  }
  
  public void initialiserDemandeAssociee(Individu p_individu, DemandeSpec p_demande) {}
  
  public void mettreEnReexamen(DemandeSpec p_demande) {}
}

/* Location:
 * Qualified Name:     GammeDec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
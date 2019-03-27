package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ResultatOutilCalculFraisEngages;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class ProduitRbfMob07P01
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = 5869861214794023806L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.mob07.p01.ProduitDelegue";
  private static final String LIB_COURT = "MOB";
  private static final String LIB_LONG = "Aide à la mobilité";
  private static final Damj DEBUT = new Damj(2014, 1, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitRbfMob07P01 s_instanceUnique = null;
  
  public static ProduitRbfMob07P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfMob07P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfMob07P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitRbfMob07P01()
  {
    setLibelleCourt("MOB");
    setLibelleLong("Aide à la mobilité");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.mob07.p01.ProduitDelegue"));
    setCode(56);
    setNomUnique("RBF_MOB07_01");
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return getCode() == produit.getCode();
  }
  
  public ResultatOutilCalculFraisEngages calculerFraisEngagesInitial(AttributionSpec attribution)
    throws ApplicativeException
  {
    return ((ProduitRbfDelegueSpec)getProduitDelegue()).calculerFraisEngagesInitial(attribution);
  }
  
  public void initialiserFraisEngagesInitiaux(AttributionSpec attribution)
    throws ApplicativeException
  {
    ((ProduitRbfDelegueSpec)getProduitDelegue()).initialiserFraisEngagesInitiaux(attribution);
  }
  
  public void forcerMontantADesengager(AttributionSpec attribution, BigDecimal montantADesengager)
    throws ApplicativeException
  {
    ((ProduitRbfDelegueSpec)getProduitDelegue()).forcerMontantADesengager(attribution, montantADesengager);
  }
}

/* Location:
 * Qualified Name:     ProduitRbfMob07P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
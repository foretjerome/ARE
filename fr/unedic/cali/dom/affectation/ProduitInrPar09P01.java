package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class ProduitInrPar09P01
  extends ProduitInrAbstrait
  implements ProduitInrPar09P01Spec
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.inr.par09.p01.ProduitDelegue";
  private static final String LIB_COURT = "Prime CSP";
  private static final String LIB_LONG = "Prime au reclassement";
  private static final Damj DEBUT = new Damj(2015, 2, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitInrPar09P01 s_instanceUnique = null;
  
  public static ProduitInrPar09P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitInrPar09P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitInrPar09P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitInrPar09P01()
  {
    setLibelleCourt("Prime CSP");
    setLibelleLong("Prime au reclassement");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.inr.par09.p01.ProduitDelegue"));
    setCode(68);
    setNomUnique("INR_PAR09_01");
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return false;
  }
  
  public BigDecimal recupererMontantAsp(DemandeSpec demandePrime)
    throws ApplicativeException
  {
    ProduitInrPar09P01DelegueSpec produitDelegue = (ProduitInrPar09P01DelegueSpec)getProduitInrDelegue();
    if (getProduitInrDelegue() == null) {
      return null;
    }
    return produitDelegue.recupererMontantAsp(demandePrime);
  }
}

/* Location:
 * Qualified Name:     ProduitInrPar09P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
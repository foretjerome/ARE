package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitSolAta06P01
  extends ProduitSolAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.sol.ata06.p01.ProduitDelegue";
  private static final String LIB_COURT = "ATA06";
  private static final String LIB_LONG = "ATA 06";
  private static final Damj DEBUT = new Damj(2006, 11, 16);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitSolAta06P01 s_instanceUnique = null;
  
  public static ProduitSolAta06P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolAta06P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolAta06P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitSolAta06P01()
  {
    setLibelleCourt("ATA06");
    setLibelleLong("ATA 06");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.sol.ata06.p01.ProduitDelegue"));
    
    setCode(30);
    setNomUnique("SOL_ATA06_01");
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
}

/* Location:
 * Qualified Name:     ProduitSolAta06P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitSolAer05P01
  extends ProduitSolAbstrait
{
  private static final long serialVersionUID = 2211313140458128886L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.sol.aer05.p01.ProduitDelegue";
  private static final String LIB_COURT = "AER";
  private static final String LIB_LONG = "Produit AER";
  private static final Damj DEBUT = new Damj(2002, 4, 8);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  public static final Damj DATE_AER_2010 = new Damj(2010, 1, 1);
  private static ProduitSolAer05P01 s_instanceUnique = null;
  
  public static ProduitSolAer05P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolAer05P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitSolAer05P01();
    }
    return s_instanceUnique;
  }
  
  private ProduitSolAer05P01()
  {
    setLibelleCourt("AER");
    setLibelleLong("Produit AER");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.sol.aer05.p01.ProduitDelegue"));
    
    setCode(12);
    setNomUnique("SOL_AER05_01");
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
  
  public boolean estAer2010(DemandeSpec p_demande)
  {
    return (p_demande.getDateDepot() != null) && (p_demande.getDateDepot().estApresOuCoincideAvec(DATE_AER_2010));
  }
}

/* Location:
 * Qualified Name:     ProduitSolAer05P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
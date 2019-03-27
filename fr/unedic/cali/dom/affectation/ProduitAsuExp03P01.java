package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuExp03P01
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = -152428933025038380L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.exp03.p01.ProduitDelegue";
  private static final String LIB_COURT = "ARE EXPAT";
  private static final String LIB_LONG = "Allocation Expatriée";
  private static final int ANNEE_DEBUT_VALIDITE = 2009;
  private static final int MOIS_DEBUT_VALIDITE = 4;
  private static final int JOUR_DEBUT_VALIDITE = 1;
  private static final Damj DEBUT = new Damj(2009, 4, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitAsuExp03P01 s_instanceUnique = null;
  
  public static ProduitAsuExp03P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuExp03P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuExp03P01();
    }
    return s_instanceUnique;
  }
  
  protected ProduitAsuExp03P01()
  {
    setLibelleCourt("ARE EXPAT");
    setLibelleLong("Allocation Expatriée");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.exp03.p01.ProduitDelegue"));
    
    setCode(45);
    setNomUnique("ASU_EXP03_01");
    
    ajouterReglement(Reglement.getInstance("A9B", this));
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
  
  public boolean estUnProduitRevisable()
  {
    return true;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuExp03P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
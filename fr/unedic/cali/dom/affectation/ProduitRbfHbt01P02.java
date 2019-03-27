package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitRbfHbt01P02
  extends ProduitRbfAbstrait
{
  private static final long serialVersionUID = -4261642503876622811L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.rbf.hbt01.p02.ProduitDelegue";
  private static final String LIB_COURT = "AFAF-FH 09";
  private static final String LIB_LONG = "Aide aux frais d'hébergement";
  private static final Damj DEBUT = new Damj(2009, 1, 1);
  private static final Damj FIN = new Damj(2014, 6, 30);
  private static ProduitRbfHbt01P02 s_instanceUnique = null;
  
  public static ProduitRbfHbt01P02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfHbt01P02();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitRbfHbt01P02();
    }
    return s_instanceUnique;
  }
  
  private ProduitRbfHbt01P02()
  {
    setLibelleCourt("AFAF-FH 09");
    setLibelleLong("Aide aux frais d'hébergement");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.rbf.hbt01.p02.ProduitDelegue"));
    setCode(24);
    setNomUnique("RBF_HBT01_02");
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return getCode() == p_produit.getCode();
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
}

/* Location:
 * Qualified Name:     ProduitRbfHbt01P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
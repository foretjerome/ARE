package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCSR04P02
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.csr04.p02.ProduitDelegue";
  private static final String LIB_COURT = "Chômage sans RCT";
  private static final String LIB_LONG = "Produit chômage sans rupture de contrat";
  private static final int ANNEE_2009 = 2009;
  private static final int JUILLET = 4;
  private static final int JOUR_DEBUT = 1;
  private static final Damj DEBUT = new Damj(2009, 4, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitAsuCSR04P02 s_instanceUnique = null;
  
  public static ProduitAsuCSR04P02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCSR04P02();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCSR04P02();
    }
    return s_instanceUnique;
  }
  
  private ProduitAsuCSR04P02()
  {
    setLibelleCourt("Chômage sans RCT");
    setLibelleLong("Produit chômage sans rupture de contrat");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.csr04.p02.ProduitDelegue"));
    
    setCode(33);
    setNomUnique("ASU_CSR04_02");
    
    ajouterReglement(Reglement.getInstance("RG", this));
    ajouterReglement(Reglement.getInstance("A1", this));
    ajouterReglement(Reglement.getInstance("A2a", this));
    ajouterReglement(Reglement.getInstance("A2b", this));
    ajouterReglement(Reglement.getInstance("A9A", this));
    ajouterReglement(Reglement.getInstance("RGP", this));
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    return (getCode() == p_produit.getCode()) || (ProduitAsuCge01P04.getInstance().getCode() == p_produit.getCode());
  }
  
  public boolean equals(Object p_arg0)
  {
    if ((p_arg0 instanceof ProduitSpec)) {
      return estIdentiqueAuProduit((ProduitSpec)p_arg0);
    }
    return false;
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
 * Qualified Name:     ProduitAsuCSR04P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
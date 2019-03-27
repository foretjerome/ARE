package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCva10P01
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.cva10.p01.ProduitDelegue";
  private static final String LIB_COURT = "ASR 2009";
  private static final String LIB_LONG = "Allocation Spécifique de Reclassement de Droit Commun Réglementation 2009";
  private static final int ANNEE_2009 = 2009;
  private static final int AVRIL = 4;
  private static final int JOUR_DEBUT = 1;
  private static final Damj DEBUT = new Damj(2009, 4, 1);
  private static final Damj FIN = new Damj(2011, 8, 31);
  private static ProduitAsuCva10P01 s_instanceUnique = null;
  
  public static ProduitAsuCva10P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCva10P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCva10P01();
    }
    return s_instanceUnique;
  }
  
  public ProduitAsuCva10P01()
  {
    setLibelleCourt("ASR 2009");
    setLibelleLong("Allocation Spécifique de Reclassement de Droit Commun Réglementation 2009");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.cva10.p01.ProduitDelegue"));
    
    setCode(36);
    setNomUnique("ASU_CVA10_01");
    
    ajouterReglement(Reglement.getInstance("RG", this));
    ajouterReglement(Reglement.getInstance("OP", this));
    ajouterReglement(Reglement.getInstance("A1", this));
    ajouterReglement(Reglement.getInstance("A2a", this));
    ajouterReglement(Reglement.getInstance("A2b", this));
    ajouterReglement(Reglement.getInstance("A3", this));
    ajouterReglement(Reglement.getInstance("A4", this));
    ajouterReglement(Reglement.getInstance("A5", this));
    ajouterReglement(Reglement.getInstance("A9A", this));
    ajouterReglement(Reglement.getInstance("A9B", this));
    ajouterReglement(Reglement.getInstance("RGP", this));
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec p_produit)
  {
    int codeProduit = p_produit.getCode();
    return (codeProduit == getCode()) || (codeProduit == 31);
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estUnProduitRevisable()
  {
    return false;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCva10P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
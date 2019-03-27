package fr.unedic.cali.dom.affectation;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitAsuCaa14P01
  extends ProduitAsuAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.caa14.p01.ProduitDelegue";
  private static final String LIB_COURT = "ASR ARE 2009";
  private static final String LIB_LONG = "Allocation Spécifique de Reclassement ARE Réglementation 2009";
  private static final int ANNEE_2009 = 2009;
  private static final int AVRIL = 4;
  private static final int JOUR_DEBUT = 1;
  private static final Damj DEBUT = new Damj(2009, 4, 1);
  private static final Damj FIN = new Damj(2011, 8, 31);
  private static ProduitAsuCaa14P01 s_instanceUnique = null;
  
  public static ProduitAsuCaa14P01 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCaa14P01();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitAsuCaa14P01();
    }
    return s_instanceUnique;
  }
  
  public ProduitAsuCaa14P01()
  {
    setLibelleCourt("ASR ARE 2009");
    setLibelleLong("Allocation Spécifique de Reclassement ARE Réglementation 2009");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.caa14.p01.ProduitDelegue"));
    
    setCode(37);
    setNomUnique("ASU_CAA14_01");
    
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
    return true;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCaa14P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
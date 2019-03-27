package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;

public class ProduitAsuCva10P03
  extends ProduitSecurisationProfessionnelleAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.cva10.p03.ProduitDelegue";
  private static final String LIB_COURT = "ASP 2015";
  private static final String LIB_LONG = "Allocation de Sécurisation Professionnelle de Droit Commun Réglementation 2015";
  private static final Damj DEBUT = new Damj(2015, 2, 1);
  private static final Damj FIN = Damj.FIN_DES_TEMPS;
  private static ProduitAsuCva10P03 instanceUnique = null;
  
  public static ProduitAsuCva10P03 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCva10P03();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCva10P03();
    }
    return instanceUnique;
  }
  
  public ProduitAsuCva10P03()
  {
    setLibelleCourt("ASP 2015");
    setLibelleLong("Allocation de Sécurisation Professionnelle de Droit Commun Réglementation 2015");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.cva10.p03.ProduitDelegue"));
    
    setCode(67);
    setNomUnique("ASU_CVA10_03");
    
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
    
    List<ElementForcable> nouvelleListeElementsForcables = new ArrayList();
    nouvelleListeElementsForcables.add(ElementForcable.getInstance("STATUT_UT_FORCE", this));
    nouvelleListeElementsForcables.add(ElementForcable.getInstance("NEUTRALISE_FORCE", this));
    nouvelleListeElementsForcables.add(ElementForcable.getInstance("TYPE_NEUTRALISATION_FORCE", this));
    setListeElementsForcables(nouvelleListeElementsForcables);
  }
  
  public boolean estIdentiqueAuProduit(ProduitSpec produit)
  {
    return getCode() == produit.getCode();
  }
  
  public int getTypePaiement()
  {
    return 0;
  }
  
  public boolean estUnProduitRevisable()
  {
    return true;
  }
  
  public boolean estUnProduitGerantAllongementDispositif()
  {
    return true;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCva10P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.List;

public class ProduitAsuCaa14P02
  extends ProduitSecurisationProfessionnelleAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.asu.caa14.p02.ProduitDelegue";
  private static final String LIB_COURT = "ASP ARE 2011";
  private static final String LIB_LONG = "Allocation de Sécurisation Professionnelle ARE Réglementation 2011";
  private static final Damj DEBUT = new Damj(2011, 9, 1);
  private static final Damj FIN = new Damj(2015, 1, 31);
  private static ProduitAsuCaa14P02 instanceUnique = null;
  
  public static ProduitAsuCaa14P02 getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCaa14P02();
    }
    return instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new ProduitAsuCaa14P02();
    }
    return instanceUnique;
  }
  
  public ProduitAsuCaa14P02()
  {
    setLibelleCourt("ASP ARE 2011");
    setLibelleLong("Allocation de Sécurisation Professionnelle ARE Réglementation 2011");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.asu.caa14.p02.ProduitDelegue"));
    
    setCode(50);
    setNomUnique("ASU_CAA14_02");
    
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
    return false;
  }
  
  public boolean neDoitPasSanctionnerPndsPourCouvertureDv()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuCaa14P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.calcul.outilsfonctionnels.ElementForcable;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ProduitInrAdr03P02
  extends ProduitInrAbstrait
{
  private static final long serialVersionUID = 1L;
  private static final String PRODUIT_DELEGUE = "fr.unedic.cali.inr.adr03.p02.ProduitDelegue";
  private static final String LIB_COURT = "ADR 2009";
  private static final String LIB_LONG = "Aide Différentielle au Reclassement 2009";
  private static final Damj DEBUT = new Damj(2009, 4, 1);
  private static final Damj FIN = new Damj(2015, 3, 31);
  private static ProduitInrAdr03P02 s_instanceUnique = null;
  
  public static ProduitInrAdr03P02 getInstance()
  {
    
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitInrAdr03P02();
    }
    return s_instanceUnique;
  }
  
  protected static ProduitSpec getInstancePourInitialisation()
  {
    if (s_instanceUnique == null) {
      s_instanceUnique = new ProduitInrAdr03P02();
    }
    return s_instanceUnique;
  }
  
  protected ProduitInrAdr03P02()
  {
    setLibelleCourt("ADR 2009");
    setLibelleLong("Aide Différentielle au Reclassement 2009");
    setPeriodeValidite(new Periode(DEBUT, FIN));
    setProduitDelegue(creerProduitDelegue("fr.unedic.cali.inr.adr03.p02.ProduitDelegue"));
    setCode(38);
    setNomUnique("INR_ADR03_02");
    
    ajouterElementForcable(ElementForcable.getInstance("DEBLOCAGE_ATTEINTE_SEUIL_FORCE", this));
    ajouterElementForcable(ElementForcable.getInstance("DEBLOCAGE_VARIATION_REMUNERATION_FORCE", this));
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
 * Qualified Name:     ProduitInrAdr03P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
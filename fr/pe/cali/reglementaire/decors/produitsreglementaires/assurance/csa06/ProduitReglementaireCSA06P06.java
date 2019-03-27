package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06;

import fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p06.ChangementConvention2017;
import fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p06.ChangementConvention2017APartirJanvier2018;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCSA06P06
  extends ProduitReglementaire
{
  private static ProduitReglementaireCSA06P06 instance = new ProduitReglementaireCSA06P06();
  
  private ProduitReglementaireCSA06P06()
  {
    ProduitSpec produit = Parametres.getProduit(73);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2017.getInstance());
    ajouterChangement(ChangementConvention2017APartirJanvier2018.getInstance());
  }
  
  public static ProduitReglementaireCSA06P06 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCSA06P06
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
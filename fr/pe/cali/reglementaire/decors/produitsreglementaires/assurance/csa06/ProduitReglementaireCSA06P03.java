package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06;

import fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p03.ChangementConvention2009;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCSA06P03
  extends ProduitReglementaire
{
  private static ProduitReglementaireCSA06P03 instance = new ProduitReglementaireCSA06P03();
  
  private ProduitReglementaireCSA06P03()
  {
    ProduitSpec produit = Parametres.getProduit(32);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2009.getInstance());
  }
  
  public static ProduitReglementaireCSA06P03 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCSA06P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
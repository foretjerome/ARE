package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06;

import fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p04.ChangementConvention2011;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCSA06P04
  extends ProduitReglementaire
{
  private static ProduitReglementaireCSA06P04 instance = new ProduitReglementaireCSA06P04();
  
  private ProduitReglementaireCSA06P04()
  {
    ProduitSpec produit = Parametres.getProduit(49);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2011.getInstance());
  }
  
  public static ProduitReglementaireCSA06P04 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCSA06P04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
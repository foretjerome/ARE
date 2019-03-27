package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06;

import fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p5b.ChangementConvention2014Beta;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCSA06P5B
  extends ProduitReglementaire
{
  private static ProduitReglementaireCSA06P5B instance = new ProduitReglementaireCSA06P5B();
  
  private ProduitReglementaireCSA06P5B()
  {
    ProduitSpec produit = Parametres.getProduit(63);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2014Beta.getInstance());
  }
  
  public static ProduitReglementaireCSA06P5B getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCSA06P5B
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
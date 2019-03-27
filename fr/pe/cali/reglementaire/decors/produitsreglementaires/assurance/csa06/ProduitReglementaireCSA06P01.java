package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06;

import fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p01.ChangementConvention2003;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCSA06P01
  extends ProduitReglementaire
{
  private static ProduitReglementaireCSA06P01 instance = new ProduitReglementaireCSA06P01();
  
  private ProduitReglementaireCSA06P01()
  {
    ProduitSpec produit = Parametres.getProduit(8);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2003.getInstance());
  }
  
  public static ProduitReglementaireCSA06P01 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCSA06P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
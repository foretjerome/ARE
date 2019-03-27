package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.exp03.p01;

import fr.pe.cali.reglementaire.decors.changements.assurance.exp03.p01.ChangementConvention2009;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireEXP03P01
  extends ProduitReglementaire
{
  private static ProduitReglementaireEXP03P01 instance = new ProduitReglementaireEXP03P01();
  
  private ProduitReglementaireEXP03P01()
  {
    ProduitSpec produit = Parametres.getProduit(45);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2009.getInstance());
  }
  
  public static ProduitReglementaireEXP03P01 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireEXP03P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
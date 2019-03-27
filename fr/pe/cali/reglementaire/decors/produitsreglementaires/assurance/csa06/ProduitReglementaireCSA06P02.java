package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06;

import fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p02.ChangementConvention2006;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCSA06P02
  extends ProduitReglementaire
{
  private static ProduitReglementaireCSA06P02 instance = new ProduitReglementaireCSA06P02();
  
  private ProduitReglementaireCSA06P02()
  {
    ProduitSpec produit = Parametres.getProduit(14);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2006.getInstance());
  }
  
  public static ProduitReglementaireCSA06P02 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCSA06P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
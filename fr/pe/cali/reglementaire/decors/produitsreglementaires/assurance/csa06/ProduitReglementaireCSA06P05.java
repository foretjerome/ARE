package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.csa06;

import fr.pe.cali.reglementaire.decors.changements.assurance.csa06.p05.ChangementConvention2014;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCSA06P05
  extends ProduitReglementaire
{
  private static ProduitReglementaireCSA06P05 instance = new ProduitReglementaireCSA06P05();
  
  private ProduitReglementaireCSA06P05()
  {
    ProduitSpec produit = Parametres.getProduit(61);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2014.getInstance());
  }
  
  public static ProduitReglementaireCSA06P05 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCSA06P05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
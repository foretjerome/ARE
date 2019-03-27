package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.caa14;

import fr.pe.cali.reglementaire.decors.changements.assurance.caa14.p01.ChangementInitial;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCAA14P01
  extends ProduitReglementaire
{
  private static ProduitReglementaireCAA14P01 instance = new ProduitReglementaireCAA14P01();
  
  private ProduitReglementaireCAA14P01()
  {
    ProduitSpec produit = Parametres.getProduit(37);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementInitial.getInstance());
  }
  
  public static ProduitReglementaireCAA14P01 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCAA14P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
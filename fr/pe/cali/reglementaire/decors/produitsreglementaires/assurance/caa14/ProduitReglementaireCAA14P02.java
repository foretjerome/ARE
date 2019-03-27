package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.caa14;

import fr.pe.cali.reglementaire.decors.changements.assurance.caa14.p02.ChangementInitial;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCAA14P02
  extends ProduitReglementaire
{
  private static ProduitReglementaireCAA14P02 instance = new ProduitReglementaireCAA14P02();
  
  private ProduitReglementaireCAA14P02()
  {
    ProduitSpec produit = Parametres.getProduit(50);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementInitial.getInstance());
  }
  
  public static ProduitReglementaireCAA14P02 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCAA14P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
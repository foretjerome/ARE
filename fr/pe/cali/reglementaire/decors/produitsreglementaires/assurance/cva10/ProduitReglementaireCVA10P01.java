package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cva10;

import fr.pe.cali.reglementaire.decors.changements.assurance.cva10.p01.ChangementInitial;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCVA10P01
  extends ProduitReglementaire
{
  private static ProduitReglementaireCVA10P01 instance = new ProduitReglementaireCVA10P01();
  
  private ProduitReglementaireCVA10P01()
  {
    ProduitSpec produit = Parametres.getProduit(36);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementInitial.getInstance());
  }
  
  public static ProduitReglementaireCVA10P01 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCVA10P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
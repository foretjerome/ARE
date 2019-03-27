package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cve13;

import fr.pe.cali.reglementaire.decors.changements.assurance.cve13.p01.ChangementInitial;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCVE13P01
  extends ProduitReglementaire
{
  private static ProduitReglementaireCVE13P01 instance = new ProduitReglementaireCVE13P01();
  
  private ProduitReglementaireCVE13P01()
  {
    ProduitSpec produit = Parametres.getProduit(39);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementInitial.getInstance());
  }
  
  public static ProduitReglementaireCVE13P01 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCVE13P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
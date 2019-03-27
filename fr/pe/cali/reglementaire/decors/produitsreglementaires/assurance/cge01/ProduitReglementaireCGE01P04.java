package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01;

import fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p04.ChangementConvention2009;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCGE01P04
  extends ProduitReglementaire
{
  private static ProduitReglementaireCGE01P04 instance = new ProduitReglementaireCGE01P04();
  
  private ProduitReglementaireCGE01P04()
  {
    ProduitSpec produit = Parametres.getProduit(31);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2009.getInstance());
  }
  
  public static ProduitReglementaireCGE01P04 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCGE01P04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
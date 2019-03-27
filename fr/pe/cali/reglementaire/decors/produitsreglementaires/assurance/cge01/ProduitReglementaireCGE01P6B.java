package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01;

import fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p6b.ChangementConvention2014Beta;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCGE01P6B
  extends ProduitReglementaire
{
  private static ProduitReglementaireCGE01P6B instance = new ProduitReglementaireCGE01P6B();
  
  private ProduitReglementaireCGE01P6B()
  {
    ProduitSpec produit = Parametres.getProduit(62);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2014Beta.getInstance());
  }
  
  public static ProduitReglementaireCGE01P6B getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCGE01P6B
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
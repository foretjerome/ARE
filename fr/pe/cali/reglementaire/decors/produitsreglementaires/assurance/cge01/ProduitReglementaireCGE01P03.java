package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01;

import fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p03.ChangementConvention2006;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCGE01P03
  extends ProduitReglementaire
{
  private static ProduitReglementaireCGE01P03 instance = new ProduitReglementaireCGE01P03();
  
  private ProduitReglementaireCGE01P03()
  {
    ProduitSpec produit = Parametres.getProduit(13);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2006.getInstance());
  }
  
  public static ProduitReglementaireCGE01P03 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCGE01P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
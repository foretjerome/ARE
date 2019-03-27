package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01;

import fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p06.ChangementConvention2014;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCGE01P06
  extends ProduitReglementaire
{
  private static ProduitReglementaireCGE01P06 instance = new ProduitReglementaireCGE01P06();
  
  private ProduitReglementaireCGE01P06()
  {
    ProduitSpec produit = Parametres.getProduit(60);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2014.getInstance());
  }
  
  public static ProduitReglementaireCGE01P06 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCGE01P06
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
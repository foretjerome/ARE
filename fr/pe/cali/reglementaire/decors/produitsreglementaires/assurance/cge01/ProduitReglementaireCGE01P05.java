package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01;

import fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p05.ChangementConvention2011;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCGE01P05
  extends ProduitReglementaire
{
  private static ProduitReglementaireCGE01P05 instance = new ProduitReglementaireCGE01P05();
  
  private ProduitReglementaireCGE01P05()
  {
    ProduitSpec produit = Parametres.getProduit(48);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2011.getInstance());
  }
  
  public static ProduitReglementaireCGE01P05 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCGE01P05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
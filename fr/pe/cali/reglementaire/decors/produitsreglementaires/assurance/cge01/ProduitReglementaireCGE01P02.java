package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01;

import fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p02.ChangementConvention2003;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCGE01P02
  extends ProduitReglementaire
{
  private static ProduitReglementaireCGE01P02 instance = new ProduitReglementaireCGE01P02();
  
  private ProduitReglementaireCGE01P02()
  {
    ProduitSpec produit = Parametres.getProduit(1);
    setCodeProduit(produit.getNomUnique());
    setLibelleCourt(produit.getLibelleCourt());
    setLibelleLong(produit.getLibelleLong());
    setPeriodeApplication(produit.getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2003.getInstance());
  }
  
  public static ProduitReglementaireCGE01P02 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCGE01P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
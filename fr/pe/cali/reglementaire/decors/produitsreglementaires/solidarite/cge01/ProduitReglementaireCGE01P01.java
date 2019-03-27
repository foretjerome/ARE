package fr.pe.cali.reglementaire.decors.produitsreglementaires.solidarite.cge01;

import fr.pe.cali.reglementaire.decors.changements.solidarite.cge01.ChangementConditionAAH;
import fr.pe.cali.reglementaire.decors.changements.solidarite.cge01.ChangementInitial;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCGE01P01
  extends ProduitReglementaire
{
  private static ProduitReglementaireCGE01P01 instance;
  
  private ProduitReglementaireCGE01P01()
  {
    setCodeProduit("SOL_CGE01_01");
    setLibelleCourt(Parametres.getProduit(9).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(9).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(9).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementInitial.getInstance());
    ajouterChangement(ChangementConditionAAH.getInstance());
  }
  
  public static ProduitReglementaireCGE01P01 getInstance()
  {
    if (instance == null) {
      instance = new ProduitReglementaireCGE01P01();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCGE01P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
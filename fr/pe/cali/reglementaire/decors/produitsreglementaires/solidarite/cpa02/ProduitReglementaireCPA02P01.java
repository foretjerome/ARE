package fr.pe.cali.reglementaire.decors.produitsreglementaires.solidarite.cpa02;

import fr.pe.cali.reglementaire.decors.changements.solidarite.cpa02.ChangementConditionAAH;
import fr.pe.cali.reglementaire.decors.changements.solidarite.cpa02.ChangementInitial;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCPA02P01
  extends ProduitReglementaire
{
  private static ProduitReglementaireCPA02P01 instance;
  
  private ProduitReglementaireCPA02P01()
  {
    setCodeProduit("SOL_CPA02_01");
    setLibelleCourt(Parametres.getProduit(10).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(10).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(10).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementInitial.getInstance());
    ajouterChangement(ChangementConditionAAH.getInstance());
  }
  
  public static ProduitReglementaireCPA02P01 getInstance()
  {
    if (instance == null) {
      instance = new ProduitReglementaireCPA02P01();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCPA02P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
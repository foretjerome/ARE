package fr.pe.cali.reglementaire.decors.produitsreglementaires.inr.ces06;

import fr.pe.cali.reglementaire.decors.changements.inr.ces06.ChangementConditionAAH;
import fr.pe.cali.reglementaire.decors.changements.inr.ces06.ChangementInitial;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireCES06P01
  extends ProduitReglementaire
{
  private static ProduitReglementaireCES06P01 instance;
  
  private ProduitReglementaireCES06P01()
  {
    setCodeProduit("INR_CES06_01");
    setLibelleCourt(Parametres.getProduit(16).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(16).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(16).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementInitial.getInstance());
    ajouterChangement(ChangementConditionAAH.getInstance());
  }
  
  public static ProduitReglementaireCES06P01 getInstance()
  {
    if (instance == null) {
      instance = new ProduitReglementaireCES06P01();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCES06P01
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
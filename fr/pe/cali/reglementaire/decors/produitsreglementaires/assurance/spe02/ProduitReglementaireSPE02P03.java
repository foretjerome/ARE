package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.spe02;

import fr.pe.cali.reglementaire.decors.changements.assurance.spe02.ChangementSpectacle2007;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireSPE02P03
  extends ProduitReglementaire
{
  private static ProduitReglementaireSPE02P03 instance = new ProduitReglementaireSPE02P03();
  
  private ProduitReglementaireSPE02P03()
  {
    setCodeProduit("ASU_SPE02_03");
    setLibelleCourt(Parametres.getProduit(20).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(20).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(20).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementSpectacle2007.getInstance());
  }
  
  public static ProduitReglementaireSPE02P03 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireSPE02P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
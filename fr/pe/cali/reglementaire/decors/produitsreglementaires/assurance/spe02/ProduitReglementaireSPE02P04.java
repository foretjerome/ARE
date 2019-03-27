package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.spe02;

import fr.pe.cali.reglementaire.decors.changements.assurance.spe02.ChangementSpectacle2014;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireSPE02P04
  extends ProduitReglementaire
{
  private static ProduitReglementaireSPE02P04 instance = new ProduitReglementaireSPE02P04();
  
  private ProduitReglementaireSPE02P04()
  {
    setCodeProduit("ASU_SPE02_04");
    setLibelleCourt(Parametres.getProduit(64).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(64).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(64).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementSpectacle2014.getInstance());
  }
  
  public static ProduitReglementaireSPE02P04 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireSPE02P04
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
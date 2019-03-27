package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.spe02;

import fr.pe.cali.reglementaire.decors.changements.assurance.spe02.p06.ChangementSpectacle2017;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireSPE02P06
  extends ProduitReglementaire
{
  private static ProduitReglementaireSPE02P06 instance = new ProduitReglementaireSPE02P06();
  
  private ProduitReglementaireSPE02P06()
  {
    setCodeProduit("ASU_SPE02_06");
    setLibelleCourt(Parametres.getProduit(74).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(74).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(74).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementSpectacle2017.getInstance());
  }
  
  public static ProduitReglementaireSPE02P06 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireSPE02P06
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
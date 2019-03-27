package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.spe02;

import fr.pe.cali.reglementaire.decors.changements.assurance.spe02.ChangementSpectacle2016;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public final class ProduitReglementaireSPE02P05
  extends ProduitReglementaire
{
  private static ProduitReglementaireSPE02P05 instance = new ProduitReglementaireSPE02P05();
  
  private ProduitReglementaireSPE02P05()
  {
    setCodeProduit("ASU_SPE02_05");
    setLibelleCourt(Parametres.getProduit(71).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(71).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(71).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementSpectacle2016.getInstance());
  }
  
  public static ProduitReglementaireSPE02P05 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireSPE02P05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
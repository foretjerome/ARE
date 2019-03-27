package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.ssp07;

import fr.pe.cali.reglementaire.decors.changements.assurance.ssp07.p05.ChangementAps2017;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireSSP07P05
  extends ProduitReglementaire
{
  private static ProduitReglementaireSSP07P05 instance = new ProduitReglementaireSSP07P05();
  
  private ProduitReglementaireSSP07P05()
  {
    setCodeProduit("ASU_SSP07_05");
    setLibelleCourt(Parametres.getProduit(75).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(75).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(75).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementAps2017.getInstance());
  }
  
  public static ProduitReglementaireSSP07P05 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireSSP07P05
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
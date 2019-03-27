package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.ssp07;

import fr.pe.cali.reglementaire.decors.changements.assurance.ssp07.ChangementAps2007;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireSSP07P03
  extends ProduitReglementaire
{
  private static ProduitReglementaireSSP07P03 instance = new ProduitReglementaireSSP07P03();
  
  private ProduitReglementaireSSP07P03()
  {
    setCodeProduit("ASU_SSP07_03");
    setLibelleCourt(Parametres.getProduit(27).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(27).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(27).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementAps2007.getInstance());
  }
  
  public static ProduitReglementaireSSP07P03 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireSSP07P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
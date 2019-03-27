package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.cge01;

import fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p07.ChangementConvention2017;
import fr.pe.cali.reglementaire.decors.changements.assurance.cge01.p07.ChangementConvention2017APartirJanvier2018;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public final class ProduitReglementaireCGE01P07
  extends ProduitReglementaire
{
  private static ProduitReglementaireCGE01P07 instance = new ProduitReglementaireCGE01P07();
  
  private ProduitReglementaireCGE01P07()
  {
    setCodeProduit("ASU_CGE01_07");
    setLibelleCourt(Parametres.getProduit(72).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(72).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(72).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementConvention2017.getInstance());
    ajouterChangement(ChangementConvention2017APartirJanvier2018.getInstance());
  }
  
  public static ProduitReglementaireCGE01P07 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireCGE01P07
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
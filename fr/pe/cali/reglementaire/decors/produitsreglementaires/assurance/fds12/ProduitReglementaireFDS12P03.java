package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.fds12;

import fr.pe.cali.reglementaire.decors.changements.assurance.fds12.p03.ChangementAfd2017;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireFDS12P03
  extends ProduitReglementaire
{
  private static ProduitReglementaireFDS12P03 instance = new ProduitReglementaireFDS12P03();
  
  private ProduitReglementaireFDS12P03()
  {
    setCodeProduit("ASU_FDS12_03");
    setLibelleCourt(Parametres.getProduit(76).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(76).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(76).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementAfd2017.getInstance());
  }
  
  public static ProduitReglementaireFDS12P03 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireFDS12P03
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
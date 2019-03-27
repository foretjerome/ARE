package fr.pe.cali.reglementaire.decors.produitsreglementaires.assurance.fds12;

import fr.pe.cali.reglementaire.decors.changements.assurance.fds12.ChangementAfd2007;
import fr.pe.cali.reglementaire.decors.produitsreglementaires.ProduitReglementaire;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.dom.affectation.ProduitSpec;

public class ProduitReglementaireFDS12P02
  extends ProduitReglementaire
{
  private static ProduitReglementaireFDS12P02 instance = new ProduitReglementaireFDS12P02();
  
  private ProduitReglementaireFDS12P02()
  {
    setCodeProduit("ASU_FDS12_02");
    setLibelleCourt(Parametres.getProduit(29).getLibelleCourt());
    setLibelleLong(Parametres.getProduit(29).getLibelleLong());
    setPeriodeApplication(Parametres.getProduit(29).getPeriodeValidite());
    initialiserListeChangement();
    ajouterChangement(ChangementAfd2007.getInstance());
  }
  
  public static ProduitReglementaireFDS12P02 getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     ProduitReglementaireFDS12P02
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
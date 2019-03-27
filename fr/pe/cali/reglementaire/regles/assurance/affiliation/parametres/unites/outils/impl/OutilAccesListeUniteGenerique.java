package fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.impl;

import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.dom.DonneesEntreeListeUniteParReglement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.dom.ResultatListeUniteParReglement;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.spec.IOutilAccesListeUniteParReglement;
import fr.unedic.util.Unite;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class OutilAccesListeUniteGenerique
  implements IOutilAccesListeUniteParReglement
{
  protected Map<String, List<Unite>> parametres = new HashMap();
  
  public ResultatListeUniteParReglement determinerListeUnite(DonneesEntreeListeUniteParReglement donneesEntree)
  {
    ResultatListeUniteParReglement resultat = new ResultatListeUniteParReglement();
    resultat.setListeUnites((List)parametres.get(donneesEntree.getReglement()));
    return resultat;
  }
}

/* Location:
 * Qualified Name:     OutilAccesListeUniteGenerique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
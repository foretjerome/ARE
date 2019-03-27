package fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.fabrique;

import fr.pe.cali.reglementaire.decors.fabrique.FabriqueCorpsRegle;
import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.regles.assurance.affiliation.parametres.unites.outils.spec.IOutilAccesListeUniteParReglement;

public class FabriqueAccesListeUniteParReglement
  extends FabriqueCorpsRegle
{
  private static final FabriqueAccesListeUniteParReglement instance = new FabriqueAccesListeUniteParReglement();
  
  private FabriqueAccesListeUniteParReglement()
  {
    setNomCorpsRegle("AccesListeUniteReglement");
  }
  
  public static FabriqueAccesListeUniteParReglement getInstance()
  {
    return instance;
  }
  
  public IOutilAccesListeUniteParReglement recupererOutilCorpsRegle(CriteresFabriqueReglementaire criteres)
  {
    return (IOutilAccesListeUniteParReglement)super.recupererOutilCorpsRegle(criteres);
  }
}

/* Location:
 * Qualified Name:     FabriqueAccesListeUniteParReglement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
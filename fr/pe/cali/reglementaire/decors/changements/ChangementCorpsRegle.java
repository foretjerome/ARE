package fr.pe.cali.reglementaire.decors.changements;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.unedic.util.services.ApplicativeRuntimeException;
import java.util.ArrayList;
import java.util.List;

public abstract class ChangementCorpsRegle
{
  private String nomCorpsRegle;
  private List<IOutilCorpsRegle> listeCorpsRegles;
  
  public IOutilCorpsRegle recupererOutilReglementaire(CriteresFabriqueReglementaire criteres)
  {
    List<IOutilCorpsRegle> resultatRecherche = new ArrayList();
    for (IOutilCorpsRegle outilCourant : getListeOutilsReglementaires()) {
      if (outilCourant.estApplicablePourCriteres(criteres)) {
        resultatRecherche.add(outilCourant);
      }
    }
    if (resultatRecherche.isEmpty()) {
      leverExceptionAucunOutilReglementaireTrouve();
    }
    if (resultatRecherche.size() > 1) {
      leverExceptionPlusieursOutilsReglementairesTrouves();
    }
    return ((IOutilCorpsRegle)resultatRecherche.get(0)).creerNouvelleInstance();
  }
  
  protected String getNomCorpsRegle()
  {
    return nomCorpsRegle;
  }
  
  protected void setNomCorpsRegle(String nomCorpsRegle)
  {
    this.nomCorpsRegle = nomCorpsRegle;
  }
  
  protected void initialiserListeCorpsRegles()
  {
    listeCorpsRegles = new ArrayList();
  }
  
  protected void ajouterCorpsRegle(IOutilCorpsRegle corpsRegle)
  {
    listeCorpsRegles.add(corpsRegle);
  }
  
  private List<IOutilCorpsRegle> getListeOutilsReglementaires()
  {
    return listeCorpsRegles;
  }
  
  private void leverExceptionAucunOutilReglementaireTrouve()
  {
    throw new ApplicativeRuntimeException("");
  }
  
  private void leverExceptionPlusieursOutilsReglementairesTrouves()
  {
    throw new ApplicativeRuntimeException("");
  }
}

/* Location:
 * Qualified Name:     ChangementCorpsRegle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
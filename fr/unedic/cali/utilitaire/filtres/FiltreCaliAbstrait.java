package fr.unedic.cali.utilitaire.filtres;

import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.filtres.adaptateur.FiltreAdaptateurDecisionVersDemande;
import fr.unedic.cali.utilitaire.filtres.adaptateur.FiltreAdaptateurDemandeVersDecision;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Temporel;

public abstract class FiltreCaliAbstrait
  implements FiltreCaliSpec
{
  private static final long serialVersionUID = 1L;
  private FiltreCaliSpec filtreAdapte = null;
  
  public boolean accepter(Temporel temporel)
  {
    if (filtreAdapte == null) {
      filtreAdapte = calculerFiltreAdapte(temporel);
    }
    return filtreAdapte.accepterElement(temporel);
  }
  
  private FiltreCaliSpec calculerFiltreAdapte(Temporel temporel)
  {
    FiltreCaliSpec filtreAdapteTemp = null;
    int typeElementManipule = getTypeElementManipule();
    if ((typeElementManipule == -1) || (typeElementManipule == 3))
    {
      filtreAdapteTemp = this;
    }
    else
    {
      int typeObjetParametre = getTypeObjet(temporel);
      if (typeElementManipule == typeObjetParametre) {
        filtreAdapteTemp = this;
      } else if ((typeElementManipule == 1) && (typeObjetParametre == 2)) {
        filtreAdapteTemp = new FiltreAdaptateurDemandeVersDecision(this);
      } else if ((typeElementManipule == 2) && (typeObjetParametre == 1)) {
        filtreAdapteTemp = new FiltreAdaptateurDecisionVersDemande(this);
      } else if (filtreAdapteTemp == null) {
        try
        {
          GestionnaireErreur.getInstance().genererException("PR_CALI_UTILITAIRE_VALEUR_ATTENDUE", new Object[] { "filtre adapte" }, 3);
        }
        catch (CoucheLogiqueException ex) {}
      }
    }
    return filtreAdapteTemp;
  }
  
  private int getTypeObjet(Temporel temporel)
  {
    int retour = 0;
    if ((temporel instanceof DecisionSpec)) {
      retour = 1;
    } else if ((temporel instanceof DemandeSpec)) {
      retour = 2;
    }
    return retour;
  }
  
  public void initialiserCache()
  {
    filtreAdapte = null;
  }
}

/* Location:
 * Qualified Name:     FiltreCaliAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurDemandeCroissante;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandesPrecedentesSurDemandes
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private Object objetPlafond = null;
  private boolean estObjetDate = false;
  
  public FiltreDemandesPrecedentesSurDemandes(Object objetPlafond)
  {
    this.objetPlafond = objetPlafond;
    if ((objetPlafond instanceof Damj)) {
      estObjetDate = true;
    } else if (!(objetPlafond instanceof DemandeSpec)) {
      try
      {
        GestionnaireErreur.getInstance().genererException("PR_CALI_OBJET_TYPE_ATTENDUE", new Object[] { "DemandeSpec" }, 3);
      }
      catch (CoucheLogiqueException ex) {}
    }
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    DemandeSpec demandeCourante = (DemandeSpec)temporel;
    if (estObjetDate)
    {
      Damj demande = demandeCourante.getDateRecherche();
      return demande.estAvant((Damj)objetPlafond);
    }
    ComparateurDemandeCroissante comparateur = new ComparateurDemandeCroissante();
    return comparateur.compare(demandeCourante, (DemandeSpec)objetPlafond) < 0;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandesPrecedentesSurDemandes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
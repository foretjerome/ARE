package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.RevisionSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreRevisionAre14DV
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel temporel)
  {
    boolean retour = false;
    try
    {
      if ((!((DemandeSpec)temporel).getListeDossiersExamen().isEmpty()) && (((DemandeSpec)temporel).getListeDossiersExamen().get(0) != null))
      {
        DossierExamenSpec dossierExamen = (DossierExamenSpec)((DemandeSpec)temporel).getListeDossiersExamen().get(0);
        if ((dossierExamen instanceof RevisionSpec))
        {
          RevisionSpec revision = (RevisionSpec)dossierExamen;
          retour = revision.porteUnRejetDv();
        }
      }
    }
    catch (ClassCastException e)
    {
      return false;
    }
    return retour;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     FiltreRevisionAre14DV
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
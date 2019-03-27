package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.RevisionSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public class FiltreRevisionAre14
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private boolean selectionnerRevisionEnRejetDv = false;
  
  public FiltreRevisionAre14(boolean pSelectionnerRevisionEnRejetDv)
  {
    selectionnerRevisionEnRejetDv = pSelectionnerRevisionEnRejetDv;
  }
  
  public boolean accepterElement(Temporel p_temporel)
  {
    boolean retour = false;
    try
    {
      if ((!((DemandeSpec)p_temporel).getListeDossiersExamen().isEmpty()) && (((DemandeSpec)p_temporel).getListeDossiersExamen().get(0) != null))
      {
        DossierExamenSpec dossierExamen = (DossierExamenSpec)((DemandeSpec)p_temporel).getListeDossiersExamen().get(0);
        if (((dossierExamen instanceof RevisionSpec)) && (((RevisionSpec)dossierExamen).getType() == 2)) {
          if (selectionnerRevisionEnRejetDv)
          {
            retour = true;
          }
          else
          {
            RevisionSpec revision = (RevisionSpec)dossierExamen;
            retour = !revision.porteUnRejetDv();
          }
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
 * Qualified Name:     FiltreRevisionAre14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.outilsfonctionnels.filtres.demande;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandePourDateDepotApresDate
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private Damj dateLimiteRecherche;
  
  public FiltreDemandePourDateDepotApresDate(Damj dateLimiteRecherche)
  {
    this.dateLimiteRecherche = dateLimiteRecherche;
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    boolean resultat = false;
    if ((temporel instanceof DemandeSpec))
    {
      DemandeSpec demande = (DemandeSpec)temporel;
      resultat = demande.getDateDepot().estApresOuCoincideAvec(dateLimiteRecherche);
    }
    return resultat;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandePourDateDepotApresDate
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
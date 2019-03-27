package fr.unedic.cali.utilitaire.filtres.generiques;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.outilsfonctionnels.reexecution.OutilGestionnaireReexecution;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeSuivantesDateAbonnement
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  private Damj dateReexecution;
  private boolean rechercheDemandesAReliquiderInitiale;
  
  public FiltreDemandeSuivantesDateAbonnement(Damj dateReexecution, boolean rechercheDemandesAReliquiderInitiale)
  {
    this.dateReexecution = dateReexecution;
    this.rechercheDemandesAReliquiderInitiale = rechercheDemandesAReliquiderInitiale;
  }
  
  public int getTypeElementManipule()
  {
    return 2;
  }
  
  public boolean accepterElement(Temporel temporel)
  {
    DemandeSpec demande = (DemandeSpec)temporel;
    return OutilGestionnaireReexecution.getInstance().conditionDateFinAbonnementApresOuCoincide(dateReexecution, rechercheDemandesAReliquiderInitiale, demande, false);
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeSuivantesDateAbonnement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
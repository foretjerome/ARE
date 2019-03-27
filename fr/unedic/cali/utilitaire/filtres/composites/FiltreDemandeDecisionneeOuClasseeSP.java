package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.outilsfonctionnels.filtres.FiltreOu;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionneeSurDemande;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourClassement;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeDecisionneeOuClasseeSP
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreOu filtre = new FiltreOu();
    filtre.ajouterFiltre(new FiltreDecisionneeSurDemande());
    filtre.ajouterFiltre(new FiltreDemandePourClassement("SP"));
    return filtre.accepter(p_temporel);
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeDecisionneeOuClasseeSP
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
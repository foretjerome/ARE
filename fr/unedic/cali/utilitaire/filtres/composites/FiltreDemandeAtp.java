package fr.unedic.cali.utilitaire.filtres.composites;

import fr.unedic.cali.utilitaire.filtres.FiltreCaliAbstrait;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourERE;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreOU;
import fr.unedic.util.temps.Temporel;

public class FiltreDemandeAtp
  extends FiltreCaliAbstrait
{
  private static final long serialVersionUID = 1L;
  
  public boolean accepterElement(Temporel p_temporel)
  {
    FiltreOU filtreAntecedent = new FiltreOU();
    filtreAntecedent.ajouterFiltre(new FiltreDemandePourERE("ASU_18"));
    filtreAntecedent.ajouterFiltre(new FiltreDemandePourERE("ASU_20"));
    return filtreAntecedent.accepter(p_temporel);
  }
  
  public int getTypeElementManipule()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FiltreDemandeAtp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;

public class FiltreDateDeclenchementExamenApresOuCoincideDateEtInclusParPriorite
  extends FiltreDateDeclenchementExamenAvantOuCoincideDateEtInclusParPriorite
{
  public FiltreDateDeclenchementExamenApresOuCoincideDateEtInclusParPriorite(Damj p_dateSeuil, DemandeSpec p_demande, EvenementReferenceExamenSpec p_ere)
  {
    super(p_dateSeuil, p_demande, p_ere);
  }
  
  public FiltreDateDeclenchementExamenApresOuCoincideDateEtInclusParPriorite(Damj p_dateSeuil, DemandeSpec p_demande)
  {
    super(p_dateSeuil, p_demande);
  }
  
  public boolean accepter(Temporel p_temporel)
  {
    return !super.accepter(p_temporel);
  }
}

/* Location:
 * Qualified Name:     FiltreDateDeclenchementExamenApresOuCoincideDateEtInclusParPriorite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
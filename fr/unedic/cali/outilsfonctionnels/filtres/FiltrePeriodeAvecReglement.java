package fr.unedic.cali.outilsfonctionnels.filtres;

import fr.unedic.cali.dom.PeriodeActiviteSalarieCaliSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FiltrePeriodeAvecReglement
  implements FiltreTemporel
{
  private static final long serialVersionUID = 1L;
  private List<String> listeReglementAPrendreEnCompte;
  
  public FiltrePeriodeAvecReglement(List<?> listeReglementAPrendreEnCompte)
  {
    if (listeReglementAPrendreEnCompte != null)
    {
      Iterator<?> it = listeReglementAPrendreEnCompte.iterator();
      this.listeReglementAPrendreEnCompte = new ArrayList();
      while (it.hasNext()) {
        this.listeReglementAPrendreEnCompte.add(((Reglement)it.next()).getNomReglement());
      }
    }
  }
  
  public boolean accepter(Temporel temporel)
  {
    if (temporel.estType(PeriodeActiviteSalarieCaliSpec.class))
    {
      Reglement reglement = ((PeriodeActiviteSalarieCaliSpec)temporel).getReglement();
      if ((listeReglementAPrendreEnCompte != null) && (reglement != null)) {
        return listeReglementAPrendreEnCompte.contains(reglement.getNomReglement());
      }
      return false;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     FiltrePeriodeAvecReglement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
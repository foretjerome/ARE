package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.Indicateur;
import fr.unedic.cali.dom.IndicateursGeneriques;
import fr.unedic.cali.dom.IndividuSpec;
import java.util.Collection;
import java.util.List;

public class GestionIndicateurs
{
  public static IndicateursGeneriques creerIndicateurs(IndividuSpec p_individu, Collection p_listeDemandesModifiees)
  {
    IndicateursGeneriques listeIndicateurs = new IndicateursGeneriques();
    listeIndicateurs.getIndicateur("D12_DE_AVEC_OD");
    listeIndicateurs.getIndicateur("D12_DE_SANS_OD");
    listeIndicateurs.getIndicateur("D12_RECONDUCTION");
    listeIndicateurs.getIndicateur("D12_REMISE_EN_CAUSE");
    if (p_individu.getListeAttributionsExecutables().isEmpty()) {
      listeIndicateurs.getIndicateur("D12_DE_SANS_OD").incremente();
    } else {
      listeIndicateurs.getIndicateur("D12_DE_AVEC_OD").incremente();
    }
    if ((p_listeDemandesModifiees != null) && (!p_listeDemandesModifiees.isEmpty())) {
      listeIndicateurs.getIndicateur("D12_REMISE_EN_CAUSE").incremente();
    } else {
      listeIndicateurs.getIndicateur("D12_RECONDUCTION").incremente();
    }
    return listeIndicateurs;
  }
}

/* Location:
 * Qualified Name:     GestionIndicateurs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
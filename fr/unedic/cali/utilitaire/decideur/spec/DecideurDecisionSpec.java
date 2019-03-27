package fr.unedic.cali.utilitaire.decideur.spec;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import java.util.List;

public abstract interface DecideurDecisionSpec
{
  public abstract boolean decisionsIdentiques(DemandeSpec paramDemandeSpec1, DemandeSpec paramDemandeSpec2, List paramList, ComportementSpec paramComportementSpec);
  
  public abstract boolean ignorerElementComparaison(DemandeSpec paramDemandeSpec1, DemandeSpec paramDemandeSpec2, ElementComparaisonReexamen paramElementComparaisonReexamen);
  
  public abstract List getListeDecideursAppliques();
  
  public abstract String getLibelle();
}

/* Location:
 * Qualified Name:     DecideurDecisionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
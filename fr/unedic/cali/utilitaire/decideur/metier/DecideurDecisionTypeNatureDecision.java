package fr.unedic.cali.utilitaire.decideur.metier;

import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ElementComparaisonReexamen;
import fr.unedic.cali.dom.NaturesDecisions;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DecideurDecisionTypeNatureDecision
  implements DecideurDecisionSpec
{
  private final transient List<String> decisionsAvant;
  private final transient List<String> decisionsApres;
  
  public DecideurDecisionTypeNatureDecision(List<BigDecimal> decisionsAvant, List<BigDecimal> decisionsApres)
  {
    this.decisionsAvant = new ArrayList();
    this.decisionsApres = new ArrayList();
    
    alimenter(this.decisionsAvant, decisionsAvant);
    alimenter(this.decisionsApres, decisionsApres);
  }
  
  private void alimenter(List<String> libelles, List<BigDecimal> natures)
  {
    if ((natures != null) && (!natures.isEmpty()))
    {
      Iterator<BigDecimal> iterator = natures.iterator();
      while (iterator.hasNext())
      {
        BigDecimal nature = (BigDecimal)iterator.next();
        String libelle = (String)NaturesDecisions.s_libelleObjectifDecision.get(nature);
        if (libelle != null) {
          libelles.add(libelle);
        }
      }
    }
  }
  
  public boolean decisionsIdentiques(DemandeSpec demandeAvant, DemandeSpec demandeApres, List eltsComparaison, ComportementSpec comportement)
  {
    boolean retour = false;
    if ((eltsComparaison != null) && (!eltsComparaison.isEmpty()))
    {
      Iterator iterator = eltsComparaison.iterator();
      retour = true;
      while (iterator.hasNext())
      {
        ElementComparaisonReexamen eltComparaison = (ElementComparaisonReexamen)iterator.next();
        if (!accepterChangement(eltComparaison)) {
          retour = false;
        }
      }
    }
    if (retour) {
      comportement.setUtilise(true);
    }
    return retour;
  }
  
  private boolean accepterChangement(ElementComparaisonReexamen eltComparaison)
  {
    boolean retour = false;
    if ("Libellé Décision".equals(eltComparaison.getLibelleElement()))
    {
      String valeurAvant = (String)eltComparaison.getValeurAvantReexamen();
      String valeurApres = (String)eltComparaison.getValeurApresReexamen();
      if ((valeurAvant != null) && (valeurApres != null) && (decisionsAvant.contains(valeurAvant)) && (decisionsApres.contains(valeurApres))) {
        retour = true;
      }
    }
    return retour;
  }
  
  public String getLibelle()
  {
    return "La décisions sont identiques si on passe d'une decision A à une decision B";
  }
  
  public List getListeDecideursAppliques()
  {
    return null;
  }
  
  public boolean ignorerElementComparaison(DemandeSpec demandeAvant, DemandeSpec demandeApres, ElementComparaisonReexamen elementComparaison)
  {
    return accepterChangement(elementComparaison);
  }
}

/* Location:
 * Qualified Name:     DecideurDecisionTypeNatureDecision
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
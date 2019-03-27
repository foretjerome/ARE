package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.dom.EtatQuantiteDroitActive;
import fr.unedic.cali.dom.EtatQuantiteDroitEpuisee;
import fr.unedic.cali.dom.EtatQuantiteDroitInactive;
import fr.unedic.cali.dom.ImputationJour;
import fr.unedic.cali.dom.QuantiteDroit;
import fr.unedic.cali.dom.VisiteurQuantiteDroit;
import fr.unedic.util.Quantite;

public class SimulateurImputeurDureeConsommableAvant
  implements VisiteurQuantiteDroit
{
  private QuantiteDroit m_duree = null;
  private Quantite m_quantiteAImputer = null;
  
  public Object visiter(EtatQuantiteDroitActive p_dureeActive)
  {
    ImputationJour monImputation = new ImputationJour();
    monImputation.setQuantiteDroit(m_duree);
    
    monImputation.setImpute(true);
    monImputation.setResteAImputer(m_duree.getQuantiteCourante().getValeurEntiere() - m_quantiteAImputer.getValeurEntiere());
    return monImputation;
  }
  
  public Object visiter(EtatQuantiteDroitEpuisee p_duree)
  {
    ImputationJour monImputation = new ImputationJour();
    monImputation.setQuantiteDroit(m_duree);
    monImputation.setImpute(false);
    return monImputation;
  }
  
  public Object visiter(EtatQuantiteDroitInactive p_etat)
  {
    ImputationJour monImputation = new ImputationJour();
    monImputation.setQuantiteDroit(m_duree);
    monImputation.setImpute(false);
    return monImputation;
  }
  
  public SimulateurImputeurDureeConsommableAvant(QuantiteDroit p_duree, Quantite p_quantite)
  {
    m_duree = p_duree;
    m_quantiteAImputer = p_quantite;
  }
}

/* Location:
 * Qualified Name:     SimulateurImputeurDureeConsommableAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
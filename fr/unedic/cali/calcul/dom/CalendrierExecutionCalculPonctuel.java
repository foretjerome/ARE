package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.CalendrierExecutionCalculPonctuelGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class CalendrierExecutionCalculPonctuel
  extends CalendrierExecutionCalculPonctuelGen
{
  private static final long serialVersionUID = 7131263797196238514L;
  private transient EvenementPaiementProduitPonctuel m_evenementPaiementProduitPonctuel = null;
  
  public CalendrierExecutionCalculPonctuel() {}
  
  public CalendrierExecutionCalculPonctuel(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public void reinitialiserCalendrier(Damj p_date)
  {
    super.reinitialiserCalendrier(p_date);
    setEvenementPaiementProduitPonctuel(null);
  }
  
  public EvenementPaiementProduitPonctuel getEvenementPaiementProduitPonctuel()
  {
    return m_evenementPaiementProduitPonctuel;
  }
  
  public void setEvenementPaiementProduitPonctuel(EvenementPaiementProduitPonctuel p_evenementPaiementProduitPonctuel)
  {
    m_evenementPaiementProduitPonctuel = p_evenementPaiementProduitPonctuel;
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete()
  {
    super.jdoPreDelete();
  }
  
  public void marquerGraphePersistant() {}
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    CalendrierExecutionCalculPonctuel copie = (CalendrierExecutionCalculPonctuel)p_copie;
    
    super.copieElements(copie);
    
    m_evenementPaiementProduitPonctuel = getEvenementPaiementProduitPonctuel();
  }
}

/* Location:
 * Qualified Name:     CalendrierExecutionCalculPonctuel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
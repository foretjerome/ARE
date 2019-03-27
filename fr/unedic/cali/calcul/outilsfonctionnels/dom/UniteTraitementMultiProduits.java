package fr.unedic.cali.calcul.outilsfonctionnels.dom;

import fr.unedic.cali.calcul.dom.EvenementPaiementProduitPonctuel;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.UniteTraitementAvant;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.util.HashMap;
import java.util.Map;

public class UniteTraitementMultiProduits
  extends ObjetChronoPeriode
{
  private Map m_mapUTProduitsPerodiques;
  private Map m_mapEvtProduitsPonctuels;
  private Map m_mapUTAvantProduits;
  
  public UniteTraitementMultiProduits(Periode p_periode)
  {
    super(p_periode);
    m_mapUTProduitsPerodiques = new HashMap();
    m_mapEvtProduitsPonctuels = new HashMap();
    m_mapUTAvantProduits = new HashMap();
  }
  
  public void addUTProduitPeriodique(UniteTraitement p_ut, AttributionSpec p_attribution)
  {
    m_mapUTProduitsPerodiques.put(p_attribution, p_ut);
  }
  
  public Map getUTProduitsPeriodiques()
  {
    return m_mapUTProduitsPerodiques;
  }
  
  public void addEvtProduitPonctuel(EvenementPaiementProduitPonctuel p_evt, AttributionSpec p_attribution)
  {
    m_mapEvtProduitsPonctuels.put(p_attribution, p_evt);
  }
  
  public Map getEvtProduitsPonctuels()
  {
    return m_mapEvtProduitsPonctuels;
  }
  
  public void addUTAvantProduit(UniteTraitementAvant p_utAvant, AttributionSpec p_attribution)
  {
    m_mapUTAvantProduits.put(p_attribution, p_utAvant);
  }
  
  public Map getUTAvantProduits()
  {
    return m_mapUTAvantProduits;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     UniteTraitementMultiProduits
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
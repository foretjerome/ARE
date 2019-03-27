package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.outilsfonctionnels.reexecution.ResultatGestionnaireReexecutionSpec;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public class ResultatReexecutionManager
  implements ResultatGestionnaireReexecutionSpec
{
  private Individu m_individu;
  private Collection m_listeDemandes;
  private ResultatAppelLiquidation m_resultatLiquidation;
  private ResultatAppelCalcul m_resultatAppelComparaison;
  private boolean m_demandeEnReexamen = false;
  
  public Individu getIndividu()
  {
    if (m_individu == null) {
      m_individu = new Individu();
    }
    return m_individu;
  }
  
  public void setIndividu(Individu p_individu)
  {
    m_individu = p_individu;
  }
  
  public Collection getListeDemandes()
  {
    return m_listeDemandes;
  }
  
  public void setListeDemandes(Collection p_listeDemandes)
  {
    m_listeDemandes = p_listeDemandes;
  }
  
  public ResultatAppelCalcul getResultatAppelComparaison()
  {
    return m_resultatAppelComparaison;
  }
  
  public void setResultatAppelComparaison(ResultatAppelCalcul p_resultatAppelComparaison)
  {
    m_resultatAppelComparaison = p_resultatAppelComparaison;
  }
  
  public ResultatAppelLiquidation getResultatLiquidation()
  {
    return m_resultatLiquidation;
  }
  
  public void setResultatLiquidation(ResultatAppelLiquidation p_resultatLiquidation)
  {
    m_resultatLiquidation = p_resultatLiquidation;
  }
  
  public boolean isDemandeEnReexamen()
  {
    return m_demandeEnReexamen;
  }
  
  public void setDemandeEnReexamen(boolean p_demandeEnReexamen)
  {
    m_demandeEnReexamen = p_demandeEnReexamen;
  }
  
  public Collection getDemandesReliquidees()
  {
    return getListeDemandes();
  }
  
  public Individu getIndividuVisu()
  {
    return getIndividu();
  }
  
  public Collection getAttributionsReexecutees()
  {
    return null;
  }
  
  public Damj getDateReexecution()
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     ResultatReexecutionManager
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
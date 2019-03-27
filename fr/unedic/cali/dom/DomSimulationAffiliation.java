package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.parcours.DomCali;
import fr.unedic.cali.parcours.DomCaliOptimise;
import fr.unedic.cali.parcours.DomTraitementOccasionnel;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;

public class DomSimulationAffiliation
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec m_individu;
  private ContexteService m_contexteService;
  private Damj m_dateFgd;
  private Damj m_dateFct;
  private int m_typeCoordinationEuropeenne;
  private ActiviteSalarie m_activiteSalarie;
  private String m_periodefct;
  private Damj m_datepra;
  private DecorReglementaire m_decor;
  private ProduitAsuSpec m_produitAppelant;
  private String m_periodeFG;
  public static final int PAS_DE_COORDINATION_REGLEMENT_EUROPEENNE = 0;
  public static final int RESSORTISSANT_EUROPEEN = 1;
  public static final int NON_RESSORTISSANT_EUROPEEN = 2;
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public static ContexteService getContexteService(Contexte p_contexte)
  {
    return ((DomTraitementOccasionnel)p_contexte.getDonnees()).getContexteService();
  }
  
  public Damj getDateFgd()
  {
    return m_dateFgd;
  }
  
  public void setDateFgd(Damj p_date)
  {
    m_dateFgd = p_date;
  }
  
  public Damj getDateFct()
  {
    return m_dateFct;
  }
  
  public void setDateFct(Damj p_date)
  {
    m_dateFct = p_date;
  }
  
  public int getTypeCoordinationEuropeenne()
  {
    return m_typeCoordinationEuropeenne;
  }
  
  public void setTypeCoordinationEuropeenne(int p_typeCoordinationEuropeenne)
  {
    m_typeCoordinationEuropeenne = p_typeCoordinationEuropeenne;
  }
  
  public ActiviteSalarie getActivite()
  {
    return m_activiteSalarie;
  }
  
  public void setActivite(ActiviteSalarie p_activiteSalarie)
  {
    m_activiteSalarie = p_activiteSalarie;
  }
  
  public String getPeriodeFct()
  {
    return m_periodefct;
  }
  
  public void setPeriodeFct(String p_string)
  {
    m_periodefct = p_string;
  }
  
  public Damj getDatePra()
  {
    return m_datepra;
  }
  
  public void setDatePra(Damj p_date)
  {
    m_datepra = p_date;
  }
  
  public DecorReglementaire getDecor()
  {
    return m_decor;
  }
  
  public void setDecor(DecorReglementaire p_decor)
  {
    m_decor = p_decor;
  }
  
  public boolean isEstCoordCee()
  {
    boolean coordCee = false;
    switch (getTypeCoordinationEuropeenne())
    {
    case 1: 
    case 2: 
      coordCee = true;
      break;
    default: 
      coordCee = false;
    }
    return coordCee;
  }
  
  public ProduitAsuSpec getProduitAppelant()
  {
    return m_produitAppelant;
  }
  
  public void setProduitAppelant(ProduitAsuSpec p_produitAppelant)
  {
    m_produitAppelant = p_produitAppelant;
  }
  
  public String getPeriodeFG()
  {
    return m_periodeFG;
  }
  
  public void setPeriodeFG(String p_periodeFG)
  {
    m_periodeFG = p_periodeFG;
  }
}

/* Location:
 * Qualified Name:     DomSimulationAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
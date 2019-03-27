package fr.unedic.cali.parcours.population;

import fr.unedic.cali.autresdoms.d90.dom.Demande;
import java.util.HashMap;

public class ResultatComparaison
{
  public static final String ETAT_AUCUNE_DIFFERENCE = "M";
  public static final String ETAT_DIFFERENCE_LINCP_PEU_CRITIQUE = "N";
  public static final String ETAT_DIFFERENCE_LINCP_TRES_CRITIQUE = "O";
  public static final String ETAT_DIFFERENCE_CANCP_DELTA_PJI = "P";
  public static final String ETAT_DIFFERENCE_CANCP_DELTA_DJI = "D";
  public static final String ETAT_DIFFERENCE_CANCP_DELTA_MONTANT = "Q";
  public static final String ETAT_EN_REEXAMEN = "R";
  public static final String ETAT_EN_REEXAMEN_AVANT = "S";
  public static final String ETAT_EN_REEXAMEN_APRES = "T";
  public static final String ETAT_KO_TECHNIQUE = "K";
  public static final String ETAT_EXCLUS_REEXECUTE = "W";
  public static final String ETAT_EXCLUS_OK_AVANT_KO_APRES = "X";
  public static final String ETAT_EXCLUS_KO_AVANT_KO_APRES = "Y";
  public static final String ETAT_EXCLUS_KO_AVANT_OK_APRES = "Z";
  private boolean m_demandeDifferente = false;
  private boolean m_demandeEnReexamenApres = false;
  private boolean m_demandeEnReexamenAvant = false;
  private boolean m_deltaMontantDifferent = false;
  private HashMap m_elementsComparaisonDifferents = null;
  private boolean m_pjiDifferent = false;
  private boolean m_djiDifferent = false;
  private Demande m_demandeVisu;
  
  public ResultatComparaison()
  {
    m_elementsComparaisonDifferents = new HashMap();
  }
  
  public boolean isDeltaMontantDifferent()
  {
    return m_deltaMontantDifferent;
  }
  
  public void setDeltaMontantDifferent(boolean p_deltaMontantDifferent)
  {
    m_deltaMontantDifferent = p_deltaMontantDifferent;
  }
  
  public boolean isDemandeDifferente()
  {
    return m_demandeDifferente;
  }
  
  public void setDemandeDifferente(boolean p_demandeDifferente)
  {
    m_demandeDifferente = p_demandeDifferente;
  }
  
  public boolean isDemandeEnReexamen()
  {
    return (isDemandeEnReexamenAvant()) || (isDemandeEnReexamenApres());
  }
  
  public boolean isDemandeEnReexamenApres()
  {
    return m_demandeEnReexamenApres;
  }
  
  public void setDemandeEnReexamenApres(boolean p_demandeEnReexamenApres)
  {
    m_demandeEnReexamenApres = p_demandeEnReexamenApres;
  }
  
  public boolean isDemandeEnReexamenAvant()
  {
    return m_demandeEnReexamenAvant;
  }
  
  public void setDemandeEnReexamenAvant(boolean p_demandeEnReexamenAvant)
  {
    m_demandeEnReexamenAvant = p_demandeEnReexamenAvant;
  }
  
  public boolean isDjiDifferent()
  {
    return m_djiDifferent;
  }
  
  public void setDjiDifferent(boolean p_djiDifferent)
  {
    m_djiDifferent = p_djiDifferent;
  }
  
  public HashMap getElementsComparaisonDifferents()
  {
    return m_elementsComparaisonDifferents;
  }
  
  public void setElementsComparaisonDifferents(HashMap p_elementsComparaisonDifferents)
  {
    m_elementsComparaisonDifferents = p_elementsComparaisonDifferents;
  }
  
  public boolean isPjiDifferent()
  {
    return m_pjiDifferent;
  }
  
  public void setPjiDifferent(boolean p_pjiDifferent)
  {
    m_pjiDifferent = p_pjiDifferent;
  }
  
  public Demande getDemandeVisu()
  {
    return m_demandeVisu;
  }
  
  public void setDemandeVisu(Demande p_demandeVisu)
  {
    m_demandeVisu = p_demandeVisu;
  }
}

/* Location:
 * Qualified Name:     ResultatComparaison
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
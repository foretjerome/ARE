package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Dom;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DomEnregistrerIndividusOccasionnel
  implements Dom
{
  private String m_cxass;
  private String m_codePopulation;
  private BigDecimal m_cxala;
  private BigDecimal m_rapportId;
  private String m_commentaire;
  private String m_codeAntenne;
  private Damj m_dateTraitement;
  private int m_etat;
  private ArrayList<IndividuOccasionnel> m_listeIndividu;
  private ContexteService m_contexteService;
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService p_contexteService)
  {
    m_contexteService = p_contexteService;
  }
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
  public BigDecimal getCxala()
  {
    return m_cxala;
  }
  
  public void setCxala(BigDecimal p_cxala)
  {
    m_cxala = p_cxala;
  }
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public BigDecimal getRapportId()
  {
    return m_rapportId;
  }
  
  public void setRapportId(BigDecimal p_rapportId)
  {
    m_rapportId = p_rapportId;
  }
  
  public String getCommentaire()
  {
    return m_commentaire;
  }
  
  public void setCommentaire(String p_commentaire)
  {
    m_commentaire = p_commentaire;
  }
  
  public int getEtat()
  {
    return m_etat;
  }
  
  public void setEtat(int p_etat)
  {
    m_etat = p_etat;
  }
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
  
  public Damj getDateTraitement()
  {
    return m_dateTraitement;
  }
  
  public void setDateTraitement(Damj p_dateTraitement)
  {
    m_dateTraitement = p_dateTraitement;
  }
  
  public ArrayList<IndividuOccasionnel> getListeIndividu()
  {
    return m_listeIndividu;
  }
  
  public void setListeIndividu(ArrayList<IndividuOccasionnel> p_listeIndividu)
  {
    m_listeIndividu = p_listeIndividu;
  }
}

/* Location:
 * Qualified Name:     DomEnregistrerIndividusOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class RapportPourIHMVisu
{
  private String m_nomChaine = null;
  private Damj m_datePassage = null;
  private List m_listeIdRapport = null;
  private String m_modeOccas = null;
  
  public Damj getDatePassage()
  {
    return m_datePassage;
  }
  
  public void setDatePassage(Damj p_datePassage)
  {
    m_datePassage = p_datePassage;
  }
  
  public List getListeIdRapport()
  {
    return m_listeIdRapport;
  }
  
  public String getNomChaine()
  {
    return m_nomChaine;
  }
  
  public void setNomChaine(String p_nomChaine)
  {
    m_nomChaine = p_nomChaine;
  }
  
  public void ajouterIdRapport(BigDecimal p_idRapport)
  {
    if (m_listeIdRapport == null) {
      m_listeIdRapport = new ArrayList();
    }
    m_listeIdRapport.add(p_idRapport);
  }
  
  public String getModeOccas()
  {
    return m_modeOccas;
  }
  
  public void setModeOccas(String p_modeOccas)
  {
    m_modeOccas = p_modeOccas;
  }
}

/* Location:
 * Qualified Name:     RapportPourIHMVisu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
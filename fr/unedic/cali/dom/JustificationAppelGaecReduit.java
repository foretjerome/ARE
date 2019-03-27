package fr.unedic.cali.dom;

import fr.unedic.util.temps.Damj;

public class JustificationAppelGaecReduit
{
  public static final String JUSTIFICATION_DATE_SANS_VALEUR = "Sans valeur";
  public static final String JUSTIFICATION_DATE_PRS = "Prs";
  public static final String JUSTIFICATION_DATE_PRC = "Prc";
  public static final String JUSTIFICATION_DATE_PRA = "Pra";
  public static final String JUSTIFICATION_DATE_FGD_OD_PRECEDENTE = "Fgd OD précédente";
  public static final String JUSTIFICATION_DATE_EXAMEN = "Date d'examen";
  public static final String JUSTIFICATION_DATE_MIN_DATE_ATTRIBUTION = "Min des dates d'attribution";
  public static final String JUSTIFICATION_DATE_EXAMEN_MOINS_CINQ_ANS = "Date d'examen -5 ans";
  private String m_justification = null;
  private Damj m_date = null;
  private String m_idDemande = null;
  
  public JustificationAppelGaecReduit(Damj p_date, String p_justification, String p_idDemande)
  {
    m_justification = p_justification;
    m_date = p_date;
    m_idDemande = p_idDemande;
  }
  
  public Damj getDate()
  {
    return m_date;
  }
  
  public String getJustification()
  {
    return m_justification;
  }
  
  public String getIdDemande()
  {
    return m_idDemande;
  }
}

/* Location:
 * Qualified Name:     JustificationAppelGaecReduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
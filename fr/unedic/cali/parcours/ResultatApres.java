package fr.unedic.cali.parcours;

import fr.unedic.util.Quantite;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;

public class ResultatApres
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  private boolean m_reliquatValide = false;
  private int m_etatAttribution = 0;
  private Damj m_dateEtatAttribution = null;
  private int m_contexteExamen;
  private Quantite m_reliquatDureeIndemnisation = null;
  private Quantite m_quantiteFormation = null;
  private Quantite m_quantiteAide = null;
  private String m_typeAide = null;
  private Quantite m_quantiteJourImputationDonneesForcees = null;
  private Quantite m_quantiteReliquatRenouvellement = null;
  
  public boolean isReliquatValide()
  {
    return m_reliquatValide;
  }
  
  public void setReliquatValide(boolean p_reliquatValide)
  {
    m_reliquatValide = p_reliquatValide;
  }
  
  public int getEtatAttribution()
  {
    return m_etatAttribution;
  }
  
  public void setEtatAttribution(int p_etatAttribution)
  {
    m_etatAttribution = p_etatAttribution;
  }
  
  public Damj getDateEtatAttribution()
  {
    return m_dateEtatAttribution;
  }
  
  public void setDateEtatAttribution(Damj p_dateEtatAttribution)
  {
    m_dateEtatAttribution = p_dateEtatAttribution;
  }
  
  public void setContexteExamen(int p_contexteExamen)
  {
    m_contexteExamen = p_contexteExamen;
  }
  
  public int getContexteExamen()
  {
    return m_contexteExamen;
  }
  
  public Quantite getReliquatDureeIndemnisation()
  {
    return m_reliquatDureeIndemnisation;
  }
  
  public void setReliquatDureeIndemnisation(Quantite p_reliquatDureeIndemnisation)
  {
    m_reliquatDureeIndemnisation = p_reliquatDureeIndemnisation;
  }
  
  public Quantite getQuantiteFormation()
  {
    return m_quantiteFormation;
  }
  
  public void setQuantiteFormation(Quantite p_quantiteFormation)
  {
    m_quantiteFormation = p_quantiteFormation;
  }
  
  public Quantite getQuantiteAide()
  {
    return m_quantiteAide;
  }
  
  public void setQuantiteAide(Quantite p_quantiteAide)
  {
    m_quantiteAide = p_quantiteAide;
  }
  
  public Quantite getQuantiteJourImputationDonneesForcees()
  {
    return m_quantiteJourImputationDonneesForcees;
  }
  
  public void setQuantiteJourImputationDonneesForcees(Quantite p_quantiteJourImputationDonneesForcees)
  {
    m_quantiteJourImputationDonneesForcees = p_quantiteJourImputationDonneesForcees;
  }
  
  public Quantite getQuantiteReliquatRenouvellement()
  {
    return m_quantiteReliquatRenouvellement;
  }
  
  public void setQuantiteReliquatRenouvellement(Quantite p_quantiteReliquatRenouvellement)
  {
    m_quantiteReliquatRenouvellement = p_quantiteReliquatRenouvellement;
  }
  
  public String getTypeAide()
  {
    return m_typeAide;
  }
  
  public void setTypeAide(String p_typeAide)
  {
    m_typeAide = p_typeAide;
  }
}

/* Location:
 * Qualified Name:     ResultatApres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.autresdoms.ga.services;

import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class Abonnement
{
  public static final Periode PERIODE_ABONNEMENT = new Periode(Damj.NUIT_DES_TEMPS, Damj.FIN_DES_TEMPS);
  private String m_numeroAllocataire;
  private String m_identifiantAbonnement;
  private String m_domaineSouscripteur;
  private String m_origineSouscripteur;
  private Periode m_periodeAbonnement;
  
  public Abonnement()
  {
    setDomaineSouscripteur("CALI");
    setOrigineSouscripteur("LIQ");
    setPeriodeAbonnement(PERIODE_ABONNEMENT);
  }
  
  public Periode getPeriodeAbonnement()
  {
    return m_periodeAbonnement;
  }
  
  public String getDomaineSouscripteur()
  {
    return m_domaineSouscripteur;
  }
  
  public String getIdentifiantAbonnement()
  {
    return m_identifiantAbonnement;
  }
  
  public String getNumeroAllocataire()
  {
    return m_numeroAllocataire;
  }
  
  public String getOrigineSouscripteur()
  {
    return m_origineSouscripteur;
  }
  
  public void setPeriodeAbonnement(Periode p_periode)
  {
    m_periodeAbonnement = p_periode;
  }
  
  public void setDomaineSouscripteur(String p_domaine)
  {
    m_domaineSouscripteur = p_domaine;
  }
  
  public void setIdentifiantAbonnement(String p_identifiantOrigineAbonnement)
  {
    m_identifiantAbonnement = p_identifiantOrigineAbonnement;
  }
  
  public void setNumeroAllocataire(String p_numeroAllocataire)
  {
    m_numeroAllocataire = p_numeroAllocataire;
  }
  
  public void setOrigineSouscripteur(String p_origineAbonnement)
  {
    m_origineSouscripteur = p_origineAbonnement;
  }
  
  public Abonnement copie()
  {
    Abonnement copie = new Abonnement();
    copieElements(copie);
    return copie;
  }
  
  private void copieElements(Abonnement p_copie)
  {
    p_copie.setNumeroAllocataire(getNumeroAllocataire());
    p_copie.setIdentifiantAbonnement(getIdentifiantAbonnement());
    p_copie.setDomaineSouscripteur(getDomaineSouscripteur());
    p_copie.setOrigineSouscripteur(getOrigineSouscripteur());
    p_copie.setPeriodeAbonnement(getPeriodeAbonnement());
  }
}

/* Location:
 * Qualified Name:     Abonnement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
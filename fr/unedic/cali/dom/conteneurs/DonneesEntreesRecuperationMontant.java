package fr.unedic.cali.dom.conteneurs;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.Competences;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeAsuSpec;
import fr.unedic.cali.dom.conteneurs.spec.ConteneurDonneesEntreeSpec;
import fr.unedic.cali.outilsfonctionnels.TracesBouchon;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;

public class DonneesEntreesRecuperationMontant
  implements ConteneurDonneesEntreeSpec
{
  private Damj m_dateCalculMontant = null;
  private IndividuSpec m_individu = null;
  private Competences m_competences = null;
  private DonneesCalculMontantSpectacle m_donneesCalculMontantSpectacle = null;
  private DonneesCalculMontant m_donneesCalculMontant = null;
  private DonneesCalculMontantAsp m_donneesCalculMontantAsp = null;
  private DonneesCalculMontantRfp m_donneesCalculMontantRfp = null;
  private DonneesEntreesRecuperationMontant m_donneesEntreesRecuperationMontantDroitAssocie = null;
  private Damj m_dateAttribution = null;
  private DureeCalendaire m_ageALaDateCalcul = null;
  
  public DonneesEntreesRecuperationMontant() {}
  
  public DonneesEntreesRecuperationMontant(AttributionSpec p_attribution, Damj p_dateCalculMontant)
  {
    TracesBouchon.ecrireTrace("Reprendre l'appel à cette méthode car l'attribution n'est plus utilisée");
    GammeAsuSpec gamme = (GammeAsuSpec)p_attribution.getGamme();
    DonneesEntreesRecuperationMontant donneesEntrees = gamme.mapperDonneesEntreesRecuperationMontant(p_attribution);
    copieElements(donneesEntrees);
    setDateCalculMontant(p_dateCalculMontant);
  }
  
  public Damj getDateCalculMontant()
  {
    return m_dateCalculMontant;
  }
  
  public void setDateCalculMontant(Damj p_dateCalculMontant)
  {
    m_dateCalculMontant = p_dateCalculMontant;
  }
  
  public IndividuSpec getIndividu()
  {
    return m_individu;
  }
  
  public void setIndividu(IndividuSpec p_individu)
  {
    m_individu = p_individu;
  }
  
  public Competences getCompetences()
  {
    return m_competences;
  }
  
  public void setCompetences(Competences p_competences)
  {
    m_competences = p_competences;
  }
  
  public DonneesCalculMontant getDonneesCalculMontant()
  {
    if (m_donneesCalculMontant == null) {
      m_donneesCalculMontant = new DonneesCalculMontant();
    }
    return m_donneesCalculMontant;
  }
  
  public void setDonneesCalculMontant(DonneesCalculMontant p_donneesCalculMontant)
  {
    m_donneesCalculMontant = p_donneesCalculMontant;
  }
  
  public DonneesCalculMontantAsp getDonneesCalculMontantAsp()
  {
    if (m_donneesCalculMontantAsp == null) {
      m_donneesCalculMontantAsp = new DonneesCalculMontantAsp();
    }
    return m_donneesCalculMontantAsp;
  }
  
  public void setDonneesCalculMontantAsp(DonneesCalculMontantAsp p_donneesCalculMontantAsp)
  {
    m_donneesCalculMontantAsp = p_donneesCalculMontantAsp;
  }
  
  public DonneesCalculMontantSpectacle getDonneesCalculMontantSpectacle()
  {
    if (m_donneesCalculMontantSpectacle == null) {
      m_donneesCalculMontantSpectacle = new DonneesCalculMontantSpectacle();
    }
    return m_donneesCalculMontantSpectacle;
  }
  
  public void setDonneesCalculMontantSpectacle(DonneesCalculMontantSpectacle p_donneesCalculMontantSpectacle)
  {
    m_donneesCalculMontantSpectacle = p_donneesCalculMontantSpectacle;
  }
  
  public DonneesEntreesRecuperationMontant getDonneesEntreesRecuperationMontantDroitAssocie()
  {
    return m_donneesEntreesRecuperationMontantDroitAssocie;
  }
  
  public void setDonneesEntreesRecuperationMontantDroitAssocie(DonneesEntreesRecuperationMontant p_donneesEntreesRecuperationMontantDroitAssocie)
  {
    m_donneesEntreesRecuperationMontantDroitAssocie = p_donneesEntreesRecuperationMontantDroitAssocie;
  }
  
  public Damj getDateAttribution()
  {
    return m_dateAttribution;
  }
  
  public void setDateAttribution(Damj p_dateAttribution)
  {
    m_dateAttribution = p_dateAttribution;
  }
  
  public DonneesEntreesRecuperationMontant copie()
  {
    DonneesEntreesRecuperationMontant copie = new DonneesEntreesRecuperationMontant();
    copie.copieElements(this);
    return copie;
  }
  
  private void copieElements(DonneesEntreesRecuperationMontant p_donneesEntreesRecuperationMontant)
  {
    if (p_donneesEntreesRecuperationMontant.getCompetences() != null)
    {
      Competences copie = new Competences();
      copie.setCompetenceAdministrative(p_donneesEntreesRecuperationMontant.getCompetences().getCompetenceAdministrative());
      copie.setCompetenceFinanciere(p_donneesEntreesRecuperationMontant.getCompetences().getCompetenceFinanciere());
      copie.setConventionGestion(p_donneesEntreesRecuperationMontant.getCompetences().getConventionGestion());
      copie.setEstPCRCForce(p_donneesEntreesRecuperationMontant.getCompetences().isEstPCRCForce());
      setCompetences(copie);
    }
    setDateAttribution(p_donneesEntreesRecuperationMontant.getDateAttribution());
    setDateCalculMontant(p_donneesEntreesRecuperationMontant.getDateCalculMontant());
    setDonneesCalculMontant(p_donneesEntreesRecuperationMontant.getDonneesCalculMontant().copie());
    setDonneesCalculMontantAsp(p_donneesEntreesRecuperationMontant.getDonneesCalculMontantAsp().copie());
    setDonneesCalculMontantSpectacle(p_donneesEntreesRecuperationMontant.getDonneesCalculMontantSpectacle().copie());
    setDonneesCalculMontantRfp(p_donneesEntreesRecuperationMontant.getDonneesCalculMontantRfp().copie());
    if (p_donneesEntreesRecuperationMontant.getDonneesEntreesRecuperationMontantDroitAssocie() != null) {
      setDonneesEntreesRecuperationMontantDroitAssocie(p_donneesEntreesRecuperationMontant.getDonneesEntreesRecuperationMontantDroitAssocie().copie());
    }
    setIndividu(p_donneesEntreesRecuperationMontant.getIndividu());
  }
  
  public DonneesCalculMontantRfp getDonneesCalculMontantRfp()
  {
    if (m_donneesCalculMontantRfp == null) {
      m_donneesCalculMontantRfp = new DonneesCalculMontantRfp();
    }
    return m_donneesCalculMontantRfp;
  }
  
  public void setDonneesCalculMontantRfp(DonneesCalculMontantRfp p_donneesCalculMontantRfp)
  {
    m_donneesCalculMontantRfp = p_donneesCalculMontantRfp;
  }
  
  public DureeCalendaire getAgeFinMoisDateAttribution()
  {
    return m_ageALaDateCalcul;
  }
  
  public void setAgeALaDateCalcul(DureeCalendaire p_ageALaDateCalcul)
  {
    m_ageALaDateCalcul = p_ageALaDateCalcul;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreesRecuperationMontant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
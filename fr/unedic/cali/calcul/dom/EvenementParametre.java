package fr.unedic.cali.calcul.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;
import java.math.BigDecimal;

public class EvenementParametre
  extends ObjetChronoEvenementDebut
  implements EvenementCalculSpec
{
  private static final long serialVersionUID = 1L;
  private BigDecimal m_forfaitMensuellePansNonAgricolePremiereAnnee;
  private boolean m_nouveauForfaitMensuellePansNonAgricolePremiereAnnee = false;
  private BigDecimal m_forfaitMensuellePansNonAgricoleDeuxiemeAnnee;
  private boolean m_nouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee = false;
  private BigDecimal m_forfaitMensuellePansAgricole;
  private boolean m_nouveauForfaitMensuellePansAgricole = false;
  private BigDecimal m_smicHoraire;
  private boolean m_nouveauSmicHoraire = false;
  private BigDecimal m_tauxAccidentTravail;
  private boolean m_nouveauTauxAccidentTravail = false;
  private BigDecimal m_tauxCotisationSocialeSalaire;
  private boolean m_nouveauCotisationSocialeSalaire = false;
  private BigDecimal m_smicHoraireMayotte;
  private boolean m_nouveauSmicHoraireMayotte = false;
  
  private EvenementParametre() {}
  
  public EvenementParametre(Damj p_dateEvenement)
  {
    super(p_dateEvenement);
  }
  
  public void repercuter(EvenementParametre p_evtSource)
  {
    boolean memeDateEffet = getDateEffet().equals(p_evtSource.getDateEffet());
    if (m_forfaitMensuellePansNonAgricolePremiereAnnee == null)
    {
      m_forfaitMensuellePansNonAgricolePremiereAnnee = p_evtSource.getForfaitMensuellePansNonAgricolePremiereAnnee();
      if (memeDateEffet) {
        m_nouveauForfaitMensuellePansNonAgricolePremiereAnnee = p_evtSource.isNouveauForfaitMensuellePansNonAgricolePremiereAnnee();
      }
    }
    else
    {
      m_nouveauForfaitMensuellePansNonAgricolePremiereAnnee = true;
    }
    if (m_forfaitMensuellePansNonAgricoleDeuxiemeAnnee == null)
    {
      m_forfaitMensuellePansNonAgricoleDeuxiemeAnnee = p_evtSource.getForfaitMensuellePansNonAgricoleDeuxiemeAnnee();
      if (memeDateEffet) {
        m_nouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee = p_evtSource.isNouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee();
      }
    }
    else
    {
      m_nouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee = true;
    }
    if (m_forfaitMensuellePansAgricole == null)
    {
      m_forfaitMensuellePansAgricole = p_evtSource.getForfaitMensuellePansAgricole();
      if (memeDateEffet) {
        m_nouveauForfaitMensuellePansAgricole = p_evtSource.isNouveauForfaitMensuellePansAgricole();
      }
    }
    else
    {
      m_nouveauForfaitMensuellePansAgricole = true;
    }
    if (m_smicHoraire == null)
    {
      m_smicHoraire = p_evtSource.getSmicHoraire();
      if (memeDateEffet) {
        m_nouveauSmicHoraire = p_evtSource.isNouveauSmicHoraire();
      }
    }
    else
    {
      m_nouveauSmicHoraire = true;
    }
    if (m_tauxAccidentTravail == null)
    {
      m_tauxAccidentTravail = p_evtSource.getTauxAccidentTravail();
      if (memeDateEffet) {
        m_nouveauTauxAccidentTravail = p_evtSource.isNouveauTauxAccidentTravail();
      }
    }
    if (m_tauxCotisationSocialeSalaire == null)
    {
      m_tauxCotisationSocialeSalaire = p_evtSource.getTauxCotisationSocialeSalaire();
      if (memeDateEffet) {
        m_nouveauCotisationSocialeSalaire = p_evtSource.isNouveauCotisationSocialeSalaire();
      }
    }
    if (m_smicHoraireMayotte == null)
    {
      m_smicHoraireMayotte = p_evtSource.getSmicHoraireMayotte();
      if (memeDateEffet) {
        m_nouveauSmicHoraireMayotte = p_evtSource.isNouveauSmicHoraireMayotte();
      }
    }
    else
    {
      m_nouveauSmicHoraireMayotte = true;
    }
  }
  
  public BigDecimal getForfaitMensuellePansNonAgricolePremiereAnnee()
  {
    return m_forfaitMensuellePansNonAgricolePremiereAnnee;
  }
  
  public void setForfaitMensuellePansNonAgricolePremiereAnnee(BigDecimal p_forfaitMensuellePansNonAgricolePremiereAnnee)
  {
    m_forfaitMensuellePansNonAgricolePremiereAnnee = p_forfaitMensuellePansNonAgricolePremiereAnnee;
  }
  
  public BigDecimal getForfaitMensuellePansAgricole()
  {
    return m_forfaitMensuellePansAgricole;
  }
  
  public void setForfaitMensuellePansAgricole(BigDecimal p_forfaitMensuellePansAgricole)
  {
    m_forfaitMensuellePansAgricole = p_forfaitMensuellePansAgricole;
  }
  
  public BigDecimal getForfaitMensuellePansNonAgricoleDeuxiemeAnnee()
  {
    return m_forfaitMensuellePansNonAgricoleDeuxiemeAnnee;
  }
  
  public void setForfaitMensuellePansNonAgricoleDeuxiemeAnnee(BigDecimal p_forfaitMensuellePansNonAgricoleDeuxiemeAnnee)
  {
    m_forfaitMensuellePansNonAgricoleDeuxiemeAnnee = p_forfaitMensuellePansNonAgricoleDeuxiemeAnnee;
  }
  
  public boolean isNouveauForfaitMensuellePansAgricole()
  {
    return m_nouveauForfaitMensuellePansAgricole;
  }
  
  public void setNouveauForfaitMensuellePansAgricole(boolean p_nouveauForfaitMensuellePansAgricole)
  {
    m_nouveauForfaitMensuellePansAgricole = p_nouveauForfaitMensuellePansAgricole;
  }
  
  public boolean isNouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee()
  {
    return m_nouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee;
  }
  
  public void setNouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee(boolean p_nouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee)
  {
    m_nouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee = p_nouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee;
  }
  
  public boolean isNouveauForfaitMensuellePansNonAgricolePremiereAnnee()
  {
    return m_nouveauForfaitMensuellePansNonAgricolePremiereAnnee;
  }
  
  public void setNouveauForfaitMensuellePansNonAgricolePremiereAnnee(boolean p_nouveauForfaitMensuellePansNonAgricolePremiereAnnee)
  {
    m_nouveauForfaitMensuellePansNonAgricolePremiereAnnee = p_nouveauForfaitMensuellePansNonAgricolePremiereAnnee;
  }
  
  public boolean isNouveauSmicHoraire()
  {
    return m_nouveauSmicHoraire;
  }
  
  public void setNouveauSmicHoraire(boolean p_nouveauSmicHoraire)
  {
    m_nouveauSmicHoraire = p_nouveauSmicHoraire;
  }
  
  public BigDecimal getSmicHoraire()
  {
    return m_smicHoraire;
  }
  
  public void setSmicHoraire(BigDecimal p_smicHoraire)
  {
    m_smicHoraire = p_smicHoraire;
  }
  
  public boolean isNouveauTauxAccidentTravail()
  {
    return m_nouveauTauxAccidentTravail;
  }
  
  public void setNouveauTauxAccidentTravail(boolean p_nouveauTauxAccidentTravail)
  {
    m_nouveauTauxAccidentTravail = p_nouveauTauxAccidentTravail;
  }
  
  public BigDecimal getTauxAccidentTravail()
  {
    return m_tauxAccidentTravail;
  }
  
  public void setTauxAccidentTravail(BigDecimal p_tauxAccidentTravail)
  {
    m_tauxAccidentTravail = p_tauxAccidentTravail;
  }
  
  public boolean isNouveauSmicHoraireMayotte()
  {
    return m_nouveauSmicHoraireMayotte;
  }
  
  public void setNouveauSmicHoraireMayotte(boolean p_nouveauSmicHoraireMayotte)
  {
    m_nouveauSmicHoraireMayotte = p_nouveauSmicHoraireMayotte;
  }
  
  public BigDecimal getSmicHoraireMayotte()
  {
    return m_smicHoraireMayotte;
  }
  
  public void setSmicHoraireMayotte(BigDecimal p_smicHoraireMayotte)
  {
    m_smicHoraireMayotte = p_smicHoraireMayotte;
  }
  
  public ObjetMetierSpec copie()
  {
    EvenementParametre copie = new EvenementParametre();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    EvenementParametre copie = (EvenementParametre)p_copie;
    copie.setDateEvenement(getDateEvenement());
    
    m_forfaitMensuellePansAgricole = getForfaitMensuellePansAgricole();
    m_nouveauForfaitMensuellePansAgricole = isNouveauForfaitMensuellePansAgricole();
    m_forfaitMensuellePansNonAgricolePremiereAnnee = getForfaitMensuellePansNonAgricolePremiereAnnee();
    m_nouveauForfaitMensuellePansNonAgricolePremiereAnnee = isNouveauForfaitMensuellePansNonAgricolePremiereAnnee();
    m_forfaitMensuellePansNonAgricoleDeuxiemeAnnee = getForfaitMensuellePansNonAgricoleDeuxiemeAnnee();
    m_nouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee = isNouveauForfaitMensuellePansNonAgricoleDeuxiemeAnnee();
    m_tauxAccidentTravail = getTauxAccidentTravail();
    m_nouveauTauxAccidentTravail = isNouveauTauxAccidentTravail();
    m_tauxCotisationSocialeSalaire = getTauxCotisationSocialeSalaire();
    m_nouveauCotisationSocialeSalaire = isNouveauCotisationSocialeSalaire();
    m_smicHoraireMayotte = getSmicHoraireMayotte();
    m_nouveauSmicHoraireMayotte = isNouveauSmicHoraireMayotte();
  }
  
  public boolean isNouveauCotisationSocialeSalaire()
  {
    return m_nouveauCotisationSocialeSalaire;
  }
  
  public void setNouveauCotisationSocialeSalaire(boolean p_nouveauCotisationSocialeSalaire)
  {
    m_nouveauCotisationSocialeSalaire = p_nouveauCotisationSocialeSalaire;
  }
  
  public BigDecimal getTauxCotisationSocialeSalaire()
  {
    return m_tauxCotisationSocialeSalaire;
  }
  
  public void setTauxCotisationSocialeSalaire(BigDecimal p_tauxCotisationSocialeSalaire)
  {
    m_tauxCotisationSocialeSalaire = p_tauxCotisationSocialeSalaire;
  }
}

/* Location:
 * Qualified Name:     EvenementParametre
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
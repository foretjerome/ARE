package fr.unedic.cali.parcours;

import fr.unedic.cali.calcul.dom.CalendrierExecutionAvantSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;

public class ResultatAvant
  extends Resultat
{
  private static final long serialVersionUID = 1L;
  public static final int SANCTIONNE = 9;
  private transient AttributionSpec m_attribution = null;
  private Damj m_pji = null;
  private List m_listeCarencesEffectives = null;
  private boolean estPresenceFranchise = false;
  private Quantite reliquatFranchiseSalaire = null;
  private Quantite reliquatFranchiseCP = null;
  private Periode periodeApplicationFranchiseCP = null;
  private Periode periodeApplicationFranchiseSalaire = null;
  private boolean m_differeEntame = false;
  private transient Damj m_premierJourAvant = null;
  private transient Damj m_dernierJourAvant = null;
  private transient Periode periodePECEvenementReducteur = null;
  private transient CalendrierExecutionAvantSpec m_calendrierExecutionAvantCalcul = null;
  
  public ResultatAvant(Damj p_pji, List p_listeCarencesEffectives, boolean p_differeEntame)
  {
    m_pji = p_pji;
    m_listeCarencesEffectives = p_listeCarencesEffectives;
    m_differeEntame = p_differeEntame;
  }
  
  public Damj getPji()
  {
    return m_pji;
  }
  
  public void setPji(Damj p_pji)
  {
    m_pji = p_pji;
  }
  
  public List getListeCarencesEffectives()
  {
    return m_listeCarencesEffectives;
  }
  
  public void setListeCarencesEffectives(List p_listeCarencesEffectives)
  {
    m_listeCarencesEffectives = p_listeCarencesEffectives;
  }
  
  public boolean isDiffereEntame()
  {
    return m_differeEntame;
  }
  
  public void setDiffereEntame(boolean p_differeConsomme)
  {
    m_differeEntame = p_differeConsomme;
  }
  
  public Damj getDernierJourAvant()
  {
    return m_dernierJourAvant;
  }
  
  public void setDernierJourAvant(Damj p_dernierJourAvant)
  {
    m_dernierJourAvant = p_dernierJourAvant;
  }
  
  public Damj getPremierJourAvant()
  {
    return m_premierJourAvant;
  }
  
  public void setPremierJourAvant(Damj p_premierJourAvant)
  {
    m_premierJourAvant = p_premierJourAvant;
  }
  
  public CalendrierExecutionAvantSpec getCalendrierExecutionAvantCalcul()
  {
    return m_calendrierExecutionAvantCalcul;
  }
  
  public void setCalendrierExecutionAvantCalcul(CalendrierExecutionAvantSpec p_calendrierExecutionAvantCalcul)
  {
    m_calendrierExecutionAvantCalcul = p_calendrierExecutionAvantCalcul;
  }
  
  public final void setAttribution(AttributionSpec p_attribution)
  {
    m_attribution = p_attribution;
  }
  
  public final AttributionSpec getAttribution()
  {
    return m_attribution;
  }
  
  public void setPeriodePECEvenementReducteur(Periode periodePECEvenementReducteur)
  {
    this.periodePECEvenementReducteur = periodePECEvenementReducteur;
  }
  
  public Periode getPeriodePECEvenementReducteur()
  {
    return periodePECEvenementReducteur;
  }
  
  public boolean estPresenceFranchise()
  {
    return estPresenceFranchise;
  }
  
  public void setEstPresenceFranchise(boolean estPresenceFranchise)
  {
    this.estPresenceFranchise = estPresenceFranchise;
  }
  
  public Quantite getReliquatFranchiseSalaire()
  {
    return reliquatFranchiseSalaire;
  }
  
  public void setReliquatFranchiseSalaire(Quantite reliquatFranchiseSalaire)
  {
    this.reliquatFranchiseSalaire = reliquatFranchiseSalaire;
  }
  
  public Quantite getReliquatFranchiseCP()
  {
    return reliquatFranchiseCP;
  }
  
  public void setReliquatFranchiseCP(Quantite reliquatFranchiseCP)
  {
    this.reliquatFranchiseCP = reliquatFranchiseCP;
  }
  
  public Periode getPeriodeApplicationFranchiseCP()
  {
    return periodeApplicationFranchiseCP;
  }
  
  public void setPeriodeApplicationFranchiseCP(Periode periodeApplicationFranchiseCP)
  {
    this.periodeApplicationFranchiseCP = periodeApplicationFranchiseCP;
  }
  
  public Periode getPeriodeApplicationFranchiseSalaire()
  {
    return periodeApplicationFranchiseSalaire;
  }
  
  public void setPeriodeApplicationFranchiseSalaire(Periode periodeApplicationFranchiseSalaire)
  {
    this.periodeApplicationFranchiseSalaire = periodeApplicationFranchiseSalaire;
  }
}

/* Location:
 * Qualified Name:     ResultatAvant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cohabitation.sigma.migration.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class DecisionMigreeSolV1
  extends DecisionMigreeV1
{
  private BigDecimal m_codeRejet;
  private boolean m_estDispense;
  private BigDecimal m_dureeIndemnisationMaximale;
  private BigDecimal m_montantRessourcesJournalieresCouple;
  private BigDecimal m_montantRessourcesJournalieresIndividuel;
  private BigDecimal m_dureeEffectiveRenouvellement;
  private BigDecimal m_ressourceMensuelle;
  private BigDecimal m_montantBrut;
  private BigDecimal m_qteActiviteAcquise;
  private String m_uniteActiviteAcquise;
  private BigDecimal m_cumulMoisActiviteReduite;
  private BigDecimal m_cumulHeuresActiviteReduite;
  private Damj m_dateFinPRR;
  private BigDecimal m_categorieDemandeur;
  private BigDecimal m_nombreEnfant;
  
  public int getCodeRejet()
  {
    if (m_codeRejet != null) {
      return m_codeRejet.intValue();
    }
    return -1;
  }
  
  public void setCodeRejet(BigDecimal p_codeRejet)
  {
    m_codeRejet = p_codeRejet;
  }
  
  public Quantite getDureeEffectiveRenouvellement()
  {
    if (m_dureeEffectiveRenouvellement != null) {
      return new QuantiteJour(m_dureeEffectiveRenouvellement);
    }
    return null;
  }
  
  public void setDureeEffectiveRenouvellement(BigDecimal p_dureeEffectiveRenouvellement)
  {
    m_dureeEffectiveRenouvellement = p_dureeEffectiveRenouvellement;
  }
  
  public Quantite getDureeIndemnisationMaximale()
  {
    if (m_dureeIndemnisationMaximale != null) {
      return new QuantiteJour(m_dureeIndemnisationMaximale);
    }
    return null;
  }
  
  public void setDureeIndemnisationMaximale(BigDecimal p_dureeIndemnisationMaximale)
  {
    m_dureeIndemnisationMaximale = p_dureeIndemnisationMaximale;
  }
  
  public boolean estDispense()
  {
    return m_estDispense;
  }
  
  public void setEstDispense(boolean p_estDispense)
  {
    m_estDispense = p_estDispense;
  }
  
  public QuantiteEuro getMontantRessourcesJournalieresCouple()
  {
    if (m_montantRessourcesJournalieresCouple != null) {
      return new QuantiteEuro(m_montantRessourcesJournalieresCouple);
    }
    return null;
  }
  
  public void setMontantRessourcesJournalieresCouple(BigDecimal p_montantRessourcesJournalieresCouple)
  {
    m_montantRessourcesJournalieresCouple = p_montantRessourcesJournalieresCouple;
  }
  
  public QuantiteEuro getMontantRessourcesJournalieresIndividuel()
  {
    if (m_montantRessourcesJournalieresIndividuel != null) {
      return new QuantiteEuro(m_montantRessourcesJournalieresIndividuel);
    }
    return null;
  }
  
  public void setMontantRessourcesJournalieresIndividuel(BigDecimal p_montantRessourcesJournalieresIndividuel)
  {
    m_montantRessourcesJournalieresIndividuel = p_montantRessourcesJournalieresIndividuel;
  }
  
  public Quantite getRessourceMensuelle()
  {
    if (m_ressourceMensuelle != null) {
      return new QuantiteEuro(m_ressourceMensuelle);
    }
    return null;
  }
  
  public void setRessourceMensuelle(BigDecimal p_ressourceMensuelle)
  {
    m_ressourceMensuelle = p_ressourceMensuelle;
  }
  
  public BigDecimal getCumulHeuresActiviteReduite()
  {
    return m_cumulHeuresActiviteReduite;
  }
  
  public void setCumulHeuresActiviteReduite(BigDecimal p_cumulHeuresActiviteReduite)
  {
    m_cumulHeuresActiviteReduite = p_cumulHeuresActiviteReduite;
  }
  
  public BigDecimal getCumulMoisActiviteReduite()
  {
    return m_cumulMoisActiviteReduite;
  }
  
  public void setCumulMoisActiviteReduite(BigDecimal p_cumulMoisActiviteReduite)
  {
    m_cumulMoisActiviteReduite = p_cumulMoisActiviteReduite;
  }
  
  public BigDecimal getMontantBrut()
  {
    return m_montantBrut;
  }
  
  public void setMontantBrut(BigDecimal p_montantBrut)
  {
    m_montantBrut = p_montantBrut;
  }
  
  public BigDecimal getQteActiviteAcquise()
  {
    return m_qteActiviteAcquise;
  }
  
  public void setQteActiviteAcquise(BigDecimal p_qteActiviteAcquise)
  {
    m_qteActiviteAcquise = p_qteActiviteAcquise;
  }
  
  public Damj getDateFinPRR()
  {
    return m_dateFinPRR;
  }
  
  public void setDateFinPRR(Damj p_dateFinPRR)
  {
    m_dateFinPRR = p_dateFinPRR;
  }
  
  public String getUniteActiviteAcquise()
  {
    return m_uniteActiviteAcquise;
  }
  
  public void setUniteActiviteAcquise(String p_uniteActiviteAcquise)
  {
    m_uniteActiviteAcquise = p_uniteActiviteAcquise;
  }
  
  public BigDecimal getCategorieDemandeur()
  {
    return m_categorieDemandeur;
  }
  
  public void setCategorieDemandeur(BigDecimal p_categorieDemandeur)
  {
    m_categorieDemandeur = p_categorieDemandeur;
  }
  
  public BigDecimal getNombreEnfant()
  {
    return m_nombreEnfant;
  }
  
  public void setNombreEnfant(BigDecimal p_nombreEnfant)
  {
    m_nombreEnfant = p_nombreEnfant;
  }
}

/* Location:
 * Qualified Name:     DecisionMigreeSolV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
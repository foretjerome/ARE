package fr.unedic.cali.parcours;

import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class DomGestionForcage
  extends DomCaliOptimise
  implements DomCali
{
  private IndividuSpec individu;
  private String idDemande;
  private Damj m_dateEffetUT;
  private int m_statutForce;
  private String m_cumulARForce;
  private QuantiteJour m_creditDecalageForce;
  private QuantiteJour m_creditDecalagePNDSForce;
  private String m_repriseMemeEmployeur;
  private String m_commissionParitaire;
  private Damj m_dateDebPeriodeValiditeCP;
  private Damj m_dateFinPeriodeValiditeCP;
  private String m_estNeutralisee;
  private String m_typeNeutralisation;
  private String desactiverPASSS;
  private String estDemandeMigree;
  private String m_deblocageSeuil;
  private String m_deblocageVariationRemuneration;
  private BigDecimal m_montantNetRevenusActiviteReprise;
  private ContexteService m_contexteService;
  private String motifDV;
  private String ignorerAEDV;
  private String leverBlocageMandatement;
  
  public IndividuSpec getIndividu()
  {
    return individu;
  }
  
  public void setIndividu(IndividuSpec individu)
  {
    this.individu = individu;
  }
  
  public QuantiteJour getCreditDecalageForce()
  {
    return m_creditDecalageForce;
  }
  
  public QuantiteJour getCreditDecalagePNDSForce()
  {
    return m_creditDecalagePNDSForce;
  }
  
  public Damj getDateEffetUT()
  {
    return m_dateEffetUT;
  }
  
  public int getStatutForce()
  {
    return m_statutForce;
  }
  
  public void setCreditDecalageForce(QuantiteJour creditDecalageForce)
  {
    m_creditDecalageForce = creditDecalageForce;
  }
  
  public void setCreditDecalagePNDSForce(QuantiteJour creditDecalagePNDSForce)
  {
    m_creditDecalagePNDSForce = creditDecalagePNDSForce;
  }
  
  public void setDateEffetUT(Damj dateEffetUT)
  {
    m_dateEffetUT = dateEffetUT;
  }
  
  public void setStatutForce(int statutForce)
  {
    m_statutForce = statutForce;
  }
  
  public String getRepriseMemeEmployeur()
  {
    return m_repriseMemeEmployeur;
  }
  
  public void setRepriseMemeEmployeur(String repriseMemeEmployeur)
  {
    m_repriseMemeEmployeur = repriseMemeEmployeur;
  }
  
  public String getCommissionParitaire()
  {
    return m_commissionParitaire;
  }
  
  public void setCommissionParitaire(String commissionParitaire)
  {
    m_commissionParitaire = commissionParitaire;
  }
  
  public Damj getDateDebPeriodeValiditeCP()
  {
    return m_dateDebPeriodeValiditeCP;
  }
  
  public void setDateDebPeriodeValiditeCP(Damj dateDebPeriodeValiditeCP)
  {
    m_dateDebPeriodeValiditeCP = dateDebPeriodeValiditeCP;
  }
  
  public Damj getDateFinPeriodeValiditeCP()
  {
    return m_dateFinPeriodeValiditeCP;
  }
  
  public void setDateFinPeriodeValiditeCP(Damj dateFinPeriodeValiditeCP)
  {
    m_dateFinPeriodeValiditeCP = dateFinPeriodeValiditeCP;
  }
  
  public String getEstNeutralisee()
  {
    return m_estNeutralisee;
  }
  
  public void setEstNeutralisee(String estNeutralisee)
  {
    m_estNeutralisee = estNeutralisee;
  }
  
  public String getTypeNeutralisation()
  {
    return m_typeNeutralisation;
  }
  
  public void setTypeNeutralisation(String typeNeutralisation)
  {
    m_typeNeutralisation = typeNeutralisation;
  }
  
  public ContexteService getContexteService()
  {
    return m_contexteService;
  }
  
  public void setContexteService(ContexteService contexteService)
  {
    m_contexteService = contexteService;
  }
  
  public String getIdDemande()
  {
    return idDemande;
  }
  
  public void setIdDemande(String idDemande)
  {
    this.idDemande = idDemande;
  }
  
  public String getDeblocageSeuil()
  {
    return m_deblocageSeuil;
  }
  
  public void setDeblocageSeuil(String deblocageSeuil)
  {
    m_deblocageSeuil = deblocageSeuil;
  }
  
  public String getDeblocageVariationRemuneration()
  {
    return m_deblocageVariationRemuneration;
  }
  
  public void setDeblocageVariationRemuneration(String deblocageVariationRemuneration)
  {
    m_deblocageVariationRemuneration = deblocageVariationRemuneration;
  }
  
  public BigDecimal getMontantNetRevenusActiviteReprise()
  {
    return m_montantNetRevenusActiviteReprise;
  }
  
  public void setMontantNetRevenusActiviteReprise(BigDecimal montantNetRevenusActiviteReprise)
  {
    m_montantNetRevenusActiviteReprise = montantNetRevenusActiviteReprise;
  }
  
  public String getCumulARForce()
  {
    return m_cumulARForce;
  }
  
  public void setCumulARForce(String cumulARForce)
  {
    m_cumulARForce = cumulARForce;
  }
  
  public String estDesactiverPASSS()
  {
    return desactiverPASSS;
  }
  
  public void setDesactiverPASSS(String desactiverPASSS)
  {
    this.desactiverPASSS = desactiverPASSS;
  }
  
  public String estDemandeMigree()
  {
    return estDemandeMigree;
  }
  
  public void setEstDemandeMigree(String estDemandeMigree)
  {
    this.estDemandeMigree = estDemandeMigree;
  }
  
  public String getMotifDV()
  {
    return motifDV;
  }
  
  public void setMotifDV(String motifDV)
  {
    this.motifDV = motifDV;
  }
  
  public String getIgnorerAEDV()
  {
    return ignorerAEDV;
  }
  
  public void setIgnorerAEDV(String ignorerAEDV)
  {
    this.ignorerAEDV = ignorerAEDV;
  }
  
  public String getLeverBlocageMandatement()
  {
    return leverBlocageMandatement;
  }
  
  public void setLeverBlocageMandatement(String leverBlocageDV)
  {
    leverBlocageMandatement = leverBlocageDV;
  }
}

/* Location:
 * Qualified Name:     DomGestionForcage
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
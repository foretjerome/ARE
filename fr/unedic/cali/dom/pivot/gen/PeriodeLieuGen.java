package fr.unedic.cali.dom.pivot.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pivot.pc.PeriodeLieuPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class PeriodeLieuGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_periodeLieuPC;
  private Damj m_dateDebutPeriode;
  private String m_typeFrais;
  private Damj m_dateFinPeriode;
  private String m_lieuFormation;
  private String m_priseEnComptePlafondMajore;
  private BigDecimal m_montantUnitaireAR;
  private BigDecimal m_montantUnitaireNuit;
  private BigDecimal m_montantUnitaireRepas;
  private BigDecimal m_montantNuite;
  private String m_codeProduit;
  
  public PeriodeLieuGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public PeriodeLieuGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new PeriodeLieuPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_periodeLieuPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_periodeLieuPC)
  {
    m_periodeLieuPC = p_periodeLieuPC;
  }
  
  protected int rawGetIdentifiantPlanFormation()
  {
    return ((PeriodeLieuPC)getPC()).getIdentifiantPlanFormation();
  }
  
  public int getIdentifiantPlanFormation()
  {
    return ((PeriodeLieuPC)getPC()).getIdentifiantPlanFormation();
  }
  
  public void setIdentifiantPlanFormation(int p_identifiantPlanFormation)
  {
    ((PeriodeLieuPC)getPC()).setIdentifiantPlanFormation(p_identifiantPlanFormation);
  }
  
  protected int rawGetIdPeriodeFormation()
  {
    return ((PeriodeLieuPC)getPC()).getIdPeriodeFormation();
  }
  
  public int getIdPeriodeFormation()
  {
    return ((PeriodeLieuPC)getPC()).getIdPeriodeFormation();
  }
  
  public void setIdPeriodeFormation(int p_idPeriodeFormation)
  {
    ((PeriodeLieuPC)getPC()).setIdPeriodeFormation(p_idPeriodeFormation);
  }
  
  protected Damj rawGetDateDebutPeriode()
  {
    return ((PeriodeLieuPC)getPC()).getDateDebutPeriode();
  }
  
  public Damj getDateDebutPeriode()
  {
    return ((PeriodeLieuPC)getPC()).getDateDebutPeriode();
  }
  
  public void setDateDebutPeriode(Damj p_dateDebutPeriode)
  {
    if ((m_dateDebutPeriode == null) || (p_dateDebutPeriode == null))
    {
      m_dateDebutPeriode = p_dateDebutPeriode;
      ((PeriodeLieuPC)getPC()).setDateDebutPeriode(p_dateDebutPeriode);
    }
    else if ((m_dateDebutPeriode != null) && (p_dateDebutPeriode != null) && (!p_dateDebutPeriode.equals(m_dateDebutPeriode)))
    {
      m_dateDebutPeriode = p_dateDebutPeriode;
      ((PeriodeLieuPC)getPC()).setDateDebutPeriode(p_dateDebutPeriode);
    }
  }
  
  protected String rawGetTypeFrais()
  {
    return ((PeriodeLieuPC)getPC()).getTypeFrais();
  }
  
  public String getTypeFrais()
  {
    return ((PeriodeLieuPC)getPC()).getTypeFrais();
  }
  
  public void setTypeFrais(String p_typeFrais)
  {
    if ((m_typeFrais == null) || (p_typeFrais == null))
    {
      m_typeFrais = p_typeFrais;
      ((PeriodeLieuPC)getPC()).setTypeFrais(p_typeFrais);
    }
    else if ((m_typeFrais != null) && (p_typeFrais != null) && (!p_typeFrais.equals(m_typeFrais)))
    {
      m_typeFrais = p_typeFrais;
      ((PeriodeLieuPC)getPC()).setTypeFrais(p_typeFrais);
    }
  }
  
  protected Damj rawGetDateFinPeriode()
  {
    return ((PeriodeLieuPC)getPC()).getDateFinPeriode();
  }
  
  public Damj getDateFinPeriode()
  {
    return ((PeriodeLieuPC)getPC()).getDateFinPeriode();
  }
  
  public void setDateFinPeriode(Damj p_dateFinPeriode)
  {
    if ((m_dateFinPeriode == null) || (p_dateFinPeriode == null))
    {
      m_dateFinPeriode = p_dateFinPeriode;
      ((PeriodeLieuPC)getPC()).setDateFinPeriode(p_dateFinPeriode);
    }
    else if ((m_dateFinPeriode != null) && (p_dateFinPeriode != null) && (!p_dateFinPeriode.equals(m_dateFinPeriode)))
    {
      m_dateFinPeriode = p_dateFinPeriode;
      ((PeriodeLieuPC)getPC()).setDateFinPeriode(p_dateFinPeriode);
    }
  }
  
  protected String rawGetLieuFormation()
  {
    return ((PeriodeLieuPC)getPC()).getLieuFormation();
  }
  
  public String getLieuFormation()
  {
    return ((PeriodeLieuPC)getPC()).getLieuFormation();
  }
  
  public void setLieuFormation(String p_lieuFormation)
  {
    if ((m_lieuFormation == null) || (p_lieuFormation == null))
    {
      m_lieuFormation = p_lieuFormation;
      ((PeriodeLieuPC)getPC()).setLieuFormation(p_lieuFormation);
    }
    else if ((m_lieuFormation != null) && (p_lieuFormation != null) && (!p_lieuFormation.equals(m_lieuFormation)))
    {
      m_lieuFormation = p_lieuFormation;
      ((PeriodeLieuPC)getPC()).setLieuFormation(p_lieuFormation);
    }
  }
  
  protected int rawGetNbJoursPresenceStage()
  {
    return ((PeriodeLieuPC)getPC()).getNbJoursPresenceStage();
  }
  
  public int getNbJoursPresenceStage()
  {
    return ((PeriodeLieuPC)getPC()).getNbJoursPresenceStage();
  }
  
  public void setNbJoursPresenceStage(int p_nbJoursPresenceStage)
  {
    ((PeriodeLieuPC)getPC()).setNbJoursPresenceStage(p_nbJoursPresenceStage);
  }
  
  protected String rawGetPriseEnComptePlafondMajore()
  {
    return ((PeriodeLieuPC)getPC()).getPriseEnComptePlafondMajore();
  }
  
  public String getPriseEnComptePlafondMajore()
  {
    return ((PeriodeLieuPC)getPC()).getPriseEnComptePlafondMajore();
  }
  
  public void setPriseEnComptePlafondMajore(String p_priseEnComptePlafondMajore)
  {
    if ((m_priseEnComptePlafondMajore == null) || (p_priseEnComptePlafondMajore == null))
    {
      m_priseEnComptePlafondMajore = p_priseEnComptePlafondMajore;
      ((PeriodeLieuPC)getPC()).setPriseEnComptePlafondMajore(p_priseEnComptePlafondMajore);
    }
    else if ((m_priseEnComptePlafondMajore != null) && (p_priseEnComptePlafondMajore != null) && (!p_priseEnComptePlafondMajore.equals(m_priseEnComptePlafondMajore)))
    {
      m_priseEnComptePlafondMajore = p_priseEnComptePlafondMajore;
      ((PeriodeLieuPC)getPC()).setPriseEnComptePlafondMajore(p_priseEnComptePlafondMajore);
    }
  }
  
  protected int rawGetNbAR()
  {
    return ((PeriodeLieuPC)getPC()).getNbAR();
  }
  
  public int getNbAR()
  {
    return ((PeriodeLieuPC)getPC()).getNbAR();
  }
  
  public void setNbAR(int p_nbAR)
  {
    ((PeriodeLieuPC)getPC()).setNbAR(p_nbAR);
  }
  
  protected BigDecimal rawGetMontantUnitaireAR()
  {
    return ((PeriodeLieuPC)getPC()).getMontantUnitaireAR();
  }
  
  public BigDecimal getMontantUnitaireAR()
  {
    return ((PeriodeLieuPC)getPC()).getMontantUnitaireAR();
  }
  
  public void setMontantUnitaireAR(BigDecimal p_montantUnitaireAR)
  {
    if ((m_montantUnitaireAR == null) || (p_montantUnitaireAR == null))
    {
      m_montantUnitaireAR = p_montantUnitaireAR;
      ((PeriodeLieuPC)getPC()).setMontantUnitaireAR(p_montantUnitaireAR);
    }
    else if ((m_montantUnitaireAR != null) && (p_montantUnitaireAR != null) && (!p_montantUnitaireAR.equals(m_montantUnitaireAR)))
    {
      m_montantUnitaireAR = p_montantUnitaireAR;
      ((PeriodeLieuPC)getPC()).setMontantUnitaireAR(p_montantUnitaireAR);
    }
  }
  
  protected BigDecimal rawGetMontantUnitaireNuit()
  {
    return ((PeriodeLieuPC)getPC()).getMontantUnitaireNuit();
  }
  
  public BigDecimal getMontantUnitaireNuit()
  {
    return ((PeriodeLieuPC)getPC()).getMontantUnitaireNuit();
  }
  
  public void setMontantUnitaireNuit(BigDecimal p_montantUnitaireNuit)
  {
    if ((m_montantUnitaireNuit == null) || (p_montantUnitaireNuit == null))
    {
      m_montantUnitaireNuit = p_montantUnitaireNuit;
      ((PeriodeLieuPC)getPC()).setMontantUnitaireNuit(p_montantUnitaireNuit);
    }
    else if ((m_montantUnitaireNuit != null) && (p_montantUnitaireNuit != null) && (!p_montantUnitaireNuit.equals(m_montantUnitaireNuit)))
    {
      m_montantUnitaireNuit = p_montantUnitaireNuit;
      ((PeriodeLieuPC)getPC()).setMontantUnitaireNuit(p_montantUnitaireNuit);
    }
  }
  
  protected int rawGetNbNuits()
  {
    return ((PeriodeLieuPC)getPC()).getNbNuits();
  }
  
  public int getNbNuits()
  {
    return ((PeriodeLieuPC)getPC()).getNbNuits();
  }
  
  public void setNbNuits(int p_nbNuits)
  {
    ((PeriodeLieuPC)getPC()).setNbNuits(p_nbNuits);
  }
  
  protected BigDecimal rawGetMontantUnitaireRepas()
  {
    return ((PeriodeLieuPC)getPC()).getMontantUnitaireRepas();
  }
  
  public BigDecimal getMontantUnitaireRepas()
  {
    return ((PeriodeLieuPC)getPC()).getMontantUnitaireRepas();
  }
  
  public void setMontantUnitaireRepas(BigDecimal p_montantUnitaireRepas)
  {
    if ((m_montantUnitaireRepas == null) || (p_montantUnitaireRepas == null))
    {
      m_montantUnitaireRepas = p_montantUnitaireRepas;
      ((PeriodeLieuPC)getPC()).setMontantUnitaireRepas(p_montantUnitaireRepas);
    }
    else if ((m_montantUnitaireRepas != null) && (p_montantUnitaireRepas != null) && (!p_montantUnitaireRepas.equals(m_montantUnitaireRepas)))
    {
      m_montantUnitaireRepas = p_montantUnitaireRepas;
      ((PeriodeLieuPC)getPC()).setMontantUnitaireRepas(p_montantUnitaireRepas);
    }
  }
  
  protected int rawGetNbRepas()
  {
    return ((PeriodeLieuPC)getPC()).getNbRepas();
  }
  
  public int getNbRepas()
  {
    return ((PeriodeLieuPC)getPC()).getNbRepas();
  }
  
  public void setNbRepas(int p_nbRepas)
  {
    ((PeriodeLieuPC)getPC()).setNbRepas(p_nbRepas);
  }
  
  protected int rawGetHebergementChargeStagiaire()
  {
    return ((PeriodeLieuPC)getPC()).getHebergementChargeStagiaire();
  }
  
  public int getHebergementChargeStagiaire()
  {
    return ((PeriodeLieuPC)getPC()).getHebergementChargeStagiaire();
  }
  
  public void setHebergementChargeStagiaire(int p_hebergementChargeStagiaire)
  {
    ((PeriodeLieuPC)getPC()).setHebergementChargeStagiaire(p_hebergementChargeStagiaire);
  }
  
  protected BigDecimal rawGetMontantNuite()
  {
    return ((PeriodeLieuPC)getPC()).getMontantNuite();
  }
  
  public BigDecimal getMontantNuite()
  {
    return ((PeriodeLieuPC)getPC()).getMontantNuite();
  }
  
  public void setMontantNuite(BigDecimal p_montantNuite)
  {
    if ((m_montantNuite == null) || (p_montantNuite == null))
    {
      m_montantNuite = p_montantNuite;
      ((PeriodeLieuPC)getPC()).setMontantNuite(p_montantNuite);
    }
    else if ((m_montantNuite != null) && (p_montantNuite != null) && (!p_montantNuite.equals(m_montantNuite)))
    {
      m_montantNuite = p_montantNuite;
      ((PeriodeLieuPC)getPC()).setMontantNuite(p_montantNuite);
    }
  }
  
  protected int rawGetNombreKmAR()
  {
    return ((PeriodeLieuPC)getPC()).getNombreKmAR();
  }
  
  public int getNombreKmAR()
  {
    return ((PeriodeLieuPC)getPC()).getNombreKmAR();
  }
  
  public void setNombreKmAR(int p_nombreKmAR)
  {
    ((PeriodeLieuPC)getPC()).setNombreKmAR(p_nombreKmAR);
  }
  
  protected String rawGetCodeProduit()
  {
    return ((PeriodeLieuPC)getPC()).getCodeProduit();
  }
  
  public String getCodeProduit()
  {
    return ((PeriodeLieuPC)getPC()).getCodeProduit();
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    if ((m_codeProduit == null) || (p_codeProduit == null))
    {
      m_codeProduit = p_codeProduit;
      ((PeriodeLieuPC)getPC()).setCodeProduit(p_codeProduit);
    }
    else if ((m_codeProduit != null) && (p_codeProduit != null) && (!p_codeProduit.equals(m_codeProduit)))
    {
      m_codeProduit = p_codeProduit;
      ((PeriodeLieuPC)getPC()).setCodeProduit(p_codeProduit);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     PeriodeLieuGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
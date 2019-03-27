package fr.unedic.cali.calcul.pbjc.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.pbjc.dom.pc.DroitPbjcNcpPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class DroitPbjcNcpGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_droitPbjcNcpPC;
  private Damj m_dateEffetMaintien;
  private Damj m_dateEffetExclusionDef;
  private Damj m_dateFinDeDroit;
  private Damj m_dateEffetPjiMaintienEESSI;
  private Damj m_dateEffetIdeMaintienEESSI;
  private Damj m_dateEffetDjiMaintienEESSI;
  private BigDecimal m_anneeAffectation;
  private Damj m_dateFinCSP;
  private Damj m_dateDebutDroit;
  private BigDecimal m_montantBrutOd;
  private BigDecimal m_montantPrecompteOd;
  private Integer m_franchiseCPinit;
  private Integer m_reliquatFranchiseCP;
  private Integer m_franchiseSalaireInit;
  private Integer m_reliquatFranchiseSalaire;
  private Integer m_sommeReliquatPlafonee;
  
  public DroitPbjcNcpGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public DroitPbjcNcpGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new DroitPbjcNcpPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_droitPbjcNcpPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_droitPbjcNcpPC)
  {
    m_droitPbjcNcpPC = p_droitPbjcNcpPC;
  }
  
  protected int rawGetIdentOuvertureDroit()
  {
    return ((DroitPbjcNcpPC)getPC()).getIdentOuvertureDroit();
  }
  
  public int getIdentOuvertureDroit()
  {
    return ((DroitPbjcNcpPC)getPC()).getIdentOuvertureDroit();
  }
  
  public void setIdentOuvertureDroit(int p_identOuvertureDroit)
  {
    ((DroitPbjcNcpPC)getPC()).setIdentOuvertureDroit(p_identOuvertureDroit);
  }
  
  protected Damj rawGetDateEffetMaintien()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetMaintien();
  }
  
  public Damj getDateEffetMaintien()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetMaintien();
  }
  
  public void setDateEffetMaintien(Damj p_dateEffetMaintien)
  {
    if ((m_dateEffetMaintien == null) || (p_dateEffetMaintien == null))
    {
      m_dateEffetMaintien = p_dateEffetMaintien;
      ((DroitPbjcNcpPC)getPC()).setDateEffetMaintien(p_dateEffetMaintien);
    }
    else if ((m_dateEffetMaintien != null) && (p_dateEffetMaintien != null) && (!p_dateEffetMaintien.equals(m_dateEffetMaintien)))
    {
      m_dateEffetMaintien = p_dateEffetMaintien;
      ((DroitPbjcNcpPC)getPC()).setDateEffetMaintien(p_dateEffetMaintien);
    }
  }
  
  protected Damj rawGetDateEffetExclusionDef()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetExclusionDef();
  }
  
  public Damj getDateEffetExclusionDef()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetExclusionDef();
  }
  
  public void setDateEffetExclusionDef(Damj p_dateEffetExclusionDef)
  {
    if ((m_dateEffetExclusionDef == null) || (p_dateEffetExclusionDef == null))
    {
      m_dateEffetExclusionDef = p_dateEffetExclusionDef;
      ((DroitPbjcNcpPC)getPC()).setDateEffetExclusionDef(p_dateEffetExclusionDef);
    }
    else if ((m_dateEffetExclusionDef != null) && (p_dateEffetExclusionDef != null) && (!p_dateEffetExclusionDef.equals(m_dateEffetExclusionDef)))
    {
      m_dateEffetExclusionDef = p_dateEffetExclusionDef;
      ((DroitPbjcNcpPC)getPC()).setDateEffetExclusionDef(p_dateEffetExclusionDef);
    }
  }
  
  protected Damj rawGetDateFinDeDroit()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateFinDeDroit();
  }
  
  public Damj getDateFinDeDroit()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateFinDeDroit();
  }
  
  public void setDateFinDeDroit(Damj p_dateFinDeDroit)
  {
    if ((m_dateFinDeDroit == null) || (p_dateFinDeDroit == null))
    {
      m_dateFinDeDroit = p_dateFinDeDroit;
      ((DroitPbjcNcpPC)getPC()).setDateFinDeDroit(p_dateFinDeDroit);
    }
    else if ((m_dateFinDeDroit != null) && (p_dateFinDeDroit != null) && (!p_dateFinDeDroit.equals(m_dateFinDeDroit)))
    {
      m_dateFinDeDroit = p_dateFinDeDroit;
      ((DroitPbjcNcpPC)getPC()).setDateFinDeDroit(p_dateFinDeDroit);
    }
  }
  
  protected Damj rawGetDateEffetPjiMaintienEESSI()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetPjiMaintienEESSI();
  }
  
  public Damj getDateEffetPjiMaintienEESSI()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetPjiMaintienEESSI();
  }
  
  public void setDateEffetPjiMaintienEESSI(Damj p_dateEffetPjiMaintienEESSI)
  {
    if ((m_dateEffetPjiMaintienEESSI == null) || (p_dateEffetPjiMaintienEESSI == null))
    {
      m_dateEffetPjiMaintienEESSI = p_dateEffetPjiMaintienEESSI;
      ((DroitPbjcNcpPC)getPC()).setDateEffetPjiMaintienEESSI(p_dateEffetPjiMaintienEESSI);
    }
    else if ((m_dateEffetPjiMaintienEESSI != null) && (p_dateEffetPjiMaintienEESSI != null) && (!p_dateEffetPjiMaintienEESSI.equals(m_dateEffetPjiMaintienEESSI)))
    {
      m_dateEffetPjiMaintienEESSI = p_dateEffetPjiMaintienEESSI;
      ((DroitPbjcNcpPC)getPC()).setDateEffetPjiMaintienEESSI(p_dateEffetPjiMaintienEESSI);
    }
  }
  
  protected Damj rawGetDateEffetIdeMaintienEESSI()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetIdeMaintienEESSI();
  }
  
  public Damj getDateEffetIdeMaintienEESSI()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetIdeMaintienEESSI();
  }
  
  public void setDateEffetIdeMaintienEESSI(Damj p_dateEffetIdeMaintienEESSI)
  {
    if ((m_dateEffetIdeMaintienEESSI == null) || (p_dateEffetIdeMaintienEESSI == null))
    {
      m_dateEffetIdeMaintienEESSI = p_dateEffetIdeMaintienEESSI;
      ((DroitPbjcNcpPC)getPC()).setDateEffetIdeMaintienEESSI(p_dateEffetIdeMaintienEESSI);
    }
    else if ((m_dateEffetIdeMaintienEESSI != null) && (p_dateEffetIdeMaintienEESSI != null) && (!p_dateEffetIdeMaintienEESSI.equals(m_dateEffetIdeMaintienEESSI)))
    {
      m_dateEffetIdeMaintienEESSI = p_dateEffetIdeMaintienEESSI;
      ((DroitPbjcNcpPC)getPC()).setDateEffetIdeMaintienEESSI(p_dateEffetIdeMaintienEESSI);
    }
  }
  
  protected Damj rawGetDateEffetDjiMaintienEESSI()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetDjiMaintienEESSI();
  }
  
  public Damj getDateEffetDjiMaintienEESSI()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateEffetDjiMaintienEESSI();
  }
  
  public void setDateEffetDjiMaintienEESSI(Damj p_dateEffetDjiMaintienEESSI)
  {
    if ((m_dateEffetDjiMaintienEESSI == null) || (p_dateEffetDjiMaintienEESSI == null))
    {
      m_dateEffetDjiMaintienEESSI = p_dateEffetDjiMaintienEESSI;
      ((DroitPbjcNcpPC)getPC()).setDateEffetDjiMaintienEESSI(p_dateEffetDjiMaintienEESSI);
    }
    else if ((m_dateEffetDjiMaintienEESSI != null) && (p_dateEffetDjiMaintienEESSI != null) && (!p_dateEffetDjiMaintienEESSI.equals(m_dateEffetDjiMaintienEESSI)))
    {
      m_dateEffetDjiMaintienEESSI = p_dateEffetDjiMaintienEESSI;
      ((DroitPbjcNcpPC)getPC()).setDateEffetDjiMaintienEESSI(p_dateEffetDjiMaintienEESSI);
    }
  }
  
  protected boolean rawIsIndicateurMaintienEESSI()
  {
    return ((DroitPbjcNcpPC)getPC()).isIndicateurMaintienEESSI();
  }
  
  public boolean isIndicateurMaintienEESSI()
  {
    return ((DroitPbjcNcpPC)getPC()).isIndicateurMaintienEESSI();
  }
  
  public void setIndicateurMaintienEESSI(boolean p_indicateurMaintienEESSI)
  {
    ((DroitPbjcNcpPC)getPC()).setIndicateurMaintienEESSI(p_indicateurMaintienEESSI);
  }
  
  protected BigDecimal rawGetAnneeAffectation()
  {
    return ((DroitPbjcNcpPC)getPC()).getAnneeAffectation();
  }
  
  public BigDecimal getAnneeAffectation()
  {
    return ((DroitPbjcNcpPC)getPC()).getAnneeAffectation();
  }
  
  public void setAnneeAffectation(BigDecimal p_anneeAffectation)
  {
    if ((m_anneeAffectation == null) || (p_anneeAffectation == null))
    {
      m_anneeAffectation = p_anneeAffectation;
      ((DroitPbjcNcpPC)getPC()).setAnneeAffectation(p_anneeAffectation);
    }
    else if ((m_anneeAffectation != null) && (p_anneeAffectation != null) && (!p_anneeAffectation.equals(m_anneeAffectation)))
    {
      m_anneeAffectation = p_anneeAffectation;
      ((DroitPbjcNcpPC)getPC()).setAnneeAffectation(p_anneeAffectation);
    }
  }
  
  protected Damj rawGetDateFinCSP()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateFinCSP();
  }
  
  public Damj getDateFinCSP()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateFinCSP();
  }
  
  public void setDateFinCSP(Damj p_dateFinCSP)
  {
    if ((m_dateFinCSP == null) || (p_dateFinCSP == null))
    {
      m_dateFinCSP = p_dateFinCSP;
      ((DroitPbjcNcpPC)getPC()).setDateFinCSP(p_dateFinCSP);
    }
    else if ((m_dateFinCSP != null) && (p_dateFinCSP != null) && (!p_dateFinCSP.equals(m_dateFinCSP)))
    {
      m_dateFinCSP = p_dateFinCSP;
      ((DroitPbjcNcpPC)getPC()).setDateFinCSP(p_dateFinCSP);
    }
  }
  
  protected Damj rawGetDateDebutDroit()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateDebutDroit();
  }
  
  public Damj getDateDebutDroit()
  {
    return ((DroitPbjcNcpPC)getPC()).getDateDebutDroit();
  }
  
  public void setDateDebutDroit(Damj p_dateDebutDroit)
  {
    if ((m_dateDebutDroit == null) || (p_dateDebutDroit == null))
    {
      m_dateDebutDroit = p_dateDebutDroit;
      ((DroitPbjcNcpPC)getPC()).setDateDebutDroit(p_dateDebutDroit);
    }
    else if ((m_dateDebutDroit != null) && (p_dateDebutDroit != null) && (!p_dateDebutDroit.equals(m_dateDebutDroit)))
    {
      m_dateDebutDroit = p_dateDebutDroit;
      ((DroitPbjcNcpPC)getPC()).setDateDebutDroit(p_dateDebutDroit);
    }
  }
  
  protected BigDecimal rawGetMontantBrutOd()
  {
    return ((DroitPbjcNcpPC)getPC()).getMontantBrutOd();
  }
  
  public BigDecimal getMontantBrutOd()
  {
    return ((DroitPbjcNcpPC)getPC()).getMontantBrutOd();
  }
  
  public void setMontantBrutOd(BigDecimal p_montantBrutOd)
  {
    if ((m_montantBrutOd == null) || (p_montantBrutOd == null))
    {
      m_montantBrutOd = p_montantBrutOd;
      ((DroitPbjcNcpPC)getPC()).setMontantBrutOd(p_montantBrutOd);
    }
    else if ((m_montantBrutOd != null) && (p_montantBrutOd != null) && (!p_montantBrutOd.equals(m_montantBrutOd)))
    {
      m_montantBrutOd = p_montantBrutOd;
      ((DroitPbjcNcpPC)getPC()).setMontantBrutOd(p_montantBrutOd);
    }
  }
  
  protected BigDecimal rawGetMontantPrecompteOd()
  {
    return ((DroitPbjcNcpPC)getPC()).getMontantPrecompteOd();
  }
  
  public BigDecimal getMontantPrecompteOd()
  {
    return ((DroitPbjcNcpPC)getPC()).getMontantPrecompteOd();
  }
  
  public void setMontantPrecompteOd(BigDecimal p_montantPrecompteOd)
  {
    if ((m_montantPrecompteOd == null) || (p_montantPrecompteOd == null))
    {
      m_montantPrecompteOd = p_montantPrecompteOd;
      ((DroitPbjcNcpPC)getPC()).setMontantPrecompteOd(p_montantPrecompteOd);
    }
    else if ((m_montantPrecompteOd != null) && (p_montantPrecompteOd != null) && (!p_montantPrecompteOd.equals(m_montantPrecompteOd)))
    {
      m_montantPrecompteOd = p_montantPrecompteOd;
      ((DroitPbjcNcpPC)getPC()).setMontantPrecompteOd(p_montantPrecompteOd);
    }
  }
  
  protected Integer rawGetFranchiseCPinit()
  {
    return ((DroitPbjcNcpPC)getPC()).getFranchiseCPinit();
  }
  
  public Integer getFranchiseCPinit()
  {
    return ((DroitPbjcNcpPC)getPC()).getFranchiseCPinit();
  }
  
  public void setFranchiseCPinit(Integer p_franchiseCPinit)
  {
    if ((m_franchiseCPinit == null) || (p_franchiseCPinit == null))
    {
      m_franchiseCPinit = p_franchiseCPinit;
      ((DroitPbjcNcpPC)getPC()).setFranchiseCPinit(p_franchiseCPinit);
    }
    else if ((m_franchiseCPinit != null) && (p_franchiseCPinit != null) && (!p_franchiseCPinit.equals(m_franchiseCPinit)))
    {
      m_franchiseCPinit = p_franchiseCPinit;
      ((DroitPbjcNcpPC)getPC()).setFranchiseCPinit(p_franchiseCPinit);
    }
  }
  
  protected Integer rawGetReliquatFranchiseCP()
  {
    return ((DroitPbjcNcpPC)getPC()).getReliquatFranchiseCP();
  }
  
  public Integer getReliquatFranchiseCP()
  {
    return ((DroitPbjcNcpPC)getPC()).getReliquatFranchiseCP();
  }
  
  public void setReliquatFranchiseCP(Integer p_reliquatFranchiseCP)
  {
    if ((m_reliquatFranchiseCP == null) || (p_reliquatFranchiseCP == null))
    {
      m_reliquatFranchiseCP = p_reliquatFranchiseCP;
      ((DroitPbjcNcpPC)getPC()).setReliquatFranchiseCP(p_reliquatFranchiseCP);
    }
    else if ((m_reliquatFranchiseCP != null) && (p_reliquatFranchiseCP != null) && (!p_reliquatFranchiseCP.equals(m_reliquatFranchiseCP)))
    {
      m_reliquatFranchiseCP = p_reliquatFranchiseCP;
      ((DroitPbjcNcpPC)getPC()).setReliquatFranchiseCP(p_reliquatFranchiseCP);
    }
  }
  
  protected Integer rawGetFranchiseSalaireInit()
  {
    return ((DroitPbjcNcpPC)getPC()).getFranchiseSalaireInit();
  }
  
  public Integer getFranchiseSalaireInit()
  {
    return ((DroitPbjcNcpPC)getPC()).getFranchiseSalaireInit();
  }
  
  public void setFranchiseSalaireInit(Integer p_franchiseSalaireInit)
  {
    if ((m_franchiseSalaireInit == null) || (p_franchiseSalaireInit == null))
    {
      m_franchiseSalaireInit = p_franchiseSalaireInit;
      ((DroitPbjcNcpPC)getPC()).setFranchiseSalaireInit(p_franchiseSalaireInit);
    }
    else if ((m_franchiseSalaireInit != null) && (p_franchiseSalaireInit != null) && (!p_franchiseSalaireInit.equals(m_franchiseSalaireInit)))
    {
      m_franchiseSalaireInit = p_franchiseSalaireInit;
      ((DroitPbjcNcpPC)getPC()).setFranchiseSalaireInit(p_franchiseSalaireInit);
    }
  }
  
  protected Integer rawGetReliquatFranchiseSalaire()
  {
    return ((DroitPbjcNcpPC)getPC()).getReliquatFranchiseSalaire();
  }
  
  public Integer getReliquatFranchiseSalaire()
  {
    return ((DroitPbjcNcpPC)getPC()).getReliquatFranchiseSalaire();
  }
  
  public void setReliquatFranchiseSalaire(Integer p_reliquatFranchiseSalaire)
  {
    if ((m_reliquatFranchiseSalaire == null) || (p_reliquatFranchiseSalaire == null))
    {
      m_reliquatFranchiseSalaire = p_reliquatFranchiseSalaire;
      ((DroitPbjcNcpPC)getPC()).setReliquatFranchiseSalaire(p_reliquatFranchiseSalaire);
    }
    else if ((m_reliquatFranchiseSalaire != null) && (p_reliquatFranchiseSalaire != null) && (!p_reliquatFranchiseSalaire.equals(m_reliquatFranchiseSalaire)))
    {
      m_reliquatFranchiseSalaire = p_reliquatFranchiseSalaire;
      ((DroitPbjcNcpPC)getPC()).setReliquatFranchiseSalaire(p_reliquatFranchiseSalaire);
    }
  }
  
  protected Integer rawGetSommeReliquatPlafonee()
  {
    return ((DroitPbjcNcpPC)getPC()).getSommeReliquatPlafonee();
  }
  
  public Integer getSommeReliquatPlafonee()
  {
    return ((DroitPbjcNcpPC)getPC()).getSommeReliquatPlafonee();
  }
  
  public void setSommeReliquatPlafonee(Integer p_sommeReliquatPlafonee)
  {
    if ((m_sommeReliquatPlafonee == null) || (p_sommeReliquatPlafonee == null))
    {
      m_sommeReliquatPlafonee = p_sommeReliquatPlafonee;
      ((DroitPbjcNcpPC)getPC()).setSommeReliquatPlafonee(p_sommeReliquatPlafonee);
    }
    else if ((m_sommeReliquatPlafonee != null) && (p_sommeReliquatPlafonee != null) && (!p_sommeReliquatPlafonee.equals(m_sommeReliquatPlafonee)))
    {
      m_sommeReliquatPlafonee = p_sommeReliquatPlafonee;
      ((DroitPbjcNcpPC)getPC()).setSommeReliquatPlafonee(p_sommeReliquatPlafonee);
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
 * Qualified Name:     DroitPbjcNcpGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
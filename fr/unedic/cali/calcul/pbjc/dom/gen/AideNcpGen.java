package fr.unedic.cali.calcul.pbjc.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.pbjc.dom.pc.AideNcpPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeAbstraite;
import java.math.BigDecimal;

public abstract class AideNcpGen
  extends ObjetChronoPeriodeAbstraite
  implements DomGenSpec
{
  protected transient DomPCSpec m_aideNcpPC;
  private String m_codeProduit;
  private Damj m_dateVersementAide;
  private Damj m_dateDebutAide;
  private Damj m_dateFinAide;
  private String m_codeNatureAide;
  private String m_codeSousProduit1;
  private String m_codeNatureDerogatoireSousProduit1;
  private BigDecimal m_montantUnitaireAide1;
  private BigDecimal m_montantTotalAide1;
  private String m_codeSousProduit2;
  private String m_codeNatureDerogatoireSousProduit2;
  private BigDecimal m_montantUnitaireAide2;
  private BigDecimal m_montantTotalAide2;
  private String m_codeSousProduit3;
  private String m_codeSousProduit4;
  private String m_codeNatureDerogatoireSousProduit3;
  private String m_codeNatureDerogatoireSousProduit4;
  private BigDecimal m_montantUnitaireAide3;
  private BigDecimal m_montantUnitaireAide4;
  private BigDecimal m_montantTotalAide3;
  private BigDecimal m_montantTotalAide4;
  private String m_referenceExterne;
  private String m_typePopulation1;
  private String m_typePopulation2;
  private String m_typePopulation3;
  private String m_typePopulation4;
  private String m_typePopulation5;
  private String m_sousTypePopulation1;
  private String m_sousTypePopulation2;
  private String m_sousTypePopulation3;
  private String m_sousTypePopulation4;
  private String m_sousTypePopulation5;
  private String m_statutPrestation1;
  private String m_statutPrestation2;
  private String m_statutPrestation3;
  private String m_statutPrestation4;
  private String m_statutPrestation5;
  private String m_codeSousProduit;
  
  public AideNcpGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public AideNcpGen()
  {
    setPC(createPC());
  }
  
  public AideNcpGen(Damj p_debut, Damj p_fin)
  {
    super(p_debut, p_fin);
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new AideNcpPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_aideNcpPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_aideNcpPC)
  {
    m_aideNcpPC = p_aideNcpPC;
  }
  
  protected String rawGetCodeProduit()
  {
    return ((AideNcpPC)getPC()).getCodeProduit();
  }
  
  public String getCodeProduit()
  {
    return ((AideNcpPC)getPC()).getCodeProduit();
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    if ((m_codeProduit == null) || (p_codeProduit == null))
    {
      m_codeProduit = p_codeProduit;
      ((AideNcpPC)getPC()).setCodeProduit(p_codeProduit);
    }
    else if ((m_codeProduit != null) && (p_codeProduit != null) && (!p_codeProduit.equals(m_codeProduit)))
    {
      m_codeProduit = p_codeProduit;
      ((AideNcpPC)getPC()).setCodeProduit(p_codeProduit);
    }
  }
  
  protected Damj rawGetDateVersementAide()
  {
    return ((AideNcpPC)getPC()).getDateVersementAide();
  }
  
  public Damj getDateVersementAide()
  {
    return ((AideNcpPC)getPC()).getDateVersementAide();
  }
  
  public void setDateVersementAide(Damj p_dateVersementAide)
  {
    if ((m_dateVersementAide == null) || (p_dateVersementAide == null))
    {
      m_dateVersementAide = p_dateVersementAide;
      ((AideNcpPC)getPC()).setDateVersementAide(p_dateVersementAide);
    }
    else if ((m_dateVersementAide != null) && (p_dateVersementAide != null) && (!p_dateVersementAide.equals(m_dateVersementAide)))
    {
      m_dateVersementAide = p_dateVersementAide;
      ((AideNcpPC)getPC()).setDateVersementAide(p_dateVersementAide);
    }
  }
  
  protected Damj rawGetDateDebutAide()
  {
    return ((AideNcpPC)getPC()).getDateDebutAide();
  }
  
  public Damj getDateDebutAide()
  {
    return ((AideNcpPC)getPC()).getDateDebutAide();
  }
  
  public void setDateDebutAide(Damj p_dateDebutAide)
  {
    if ((m_dateDebutAide == null) || (p_dateDebutAide == null))
    {
      m_dateDebutAide = p_dateDebutAide;
      ((AideNcpPC)getPC()).setDateDebutAide(p_dateDebutAide);
    }
    else if ((m_dateDebutAide != null) && (p_dateDebutAide != null) && (!p_dateDebutAide.equals(m_dateDebutAide)))
    {
      m_dateDebutAide = p_dateDebutAide;
      ((AideNcpPC)getPC()).setDateDebutAide(p_dateDebutAide);
    }
  }
  
  protected Damj rawGetDateFinAide()
  {
    return ((AideNcpPC)getPC()).getDateFinAide();
  }
  
  public Damj getDateFinAide()
  {
    return ((AideNcpPC)getPC()).getDateFinAide();
  }
  
  public void setDateFinAide(Damj p_dateFinAide)
  {
    if ((m_dateFinAide == null) || (p_dateFinAide == null))
    {
      m_dateFinAide = p_dateFinAide;
      ((AideNcpPC)getPC()).setDateFinAide(p_dateFinAide);
    }
    else if ((m_dateFinAide != null) && (p_dateFinAide != null) && (!p_dateFinAide.equals(m_dateFinAide)))
    {
      m_dateFinAide = p_dateFinAide;
      ((AideNcpPC)getPC()).setDateFinAide(p_dateFinAide);
    }
  }
  
  protected String rawGetCodeNatureAide()
  {
    return ((AideNcpPC)getPC()).getCodeNatureAide();
  }
  
  public String getCodeNatureAide()
  {
    return ((AideNcpPC)getPC()).getCodeNatureAide();
  }
  
  public void setCodeNatureAide(String p_codeNatureAide)
  {
    if ((m_codeNatureAide == null) || (p_codeNatureAide == null))
    {
      m_codeNatureAide = p_codeNatureAide;
      ((AideNcpPC)getPC()).setCodeNatureAide(p_codeNatureAide);
    }
    else if ((m_codeNatureAide != null) && (p_codeNatureAide != null) && (!p_codeNatureAide.equals(m_codeNatureAide)))
    {
      m_codeNatureAide = p_codeNatureAide;
      ((AideNcpPC)getPC()).setCodeNatureAide(p_codeNatureAide);
    }
  }
  
  protected int rawGetSiecleAnneeAffectationDecision()
  {
    return ((AideNcpPC)getPC()).getSiecleAnneeAffectationDecision();
  }
  
  public int getSiecleAnneeAffectationDecision()
  {
    return ((AideNcpPC)getPC()).getSiecleAnneeAffectationDecision();
  }
  
  public void setSiecleAnneeAffectationDecision(int p_siecleAnneeAffectationDecision)
  {
    ((AideNcpPC)getPC()).setSiecleAnneeAffectationDecision(p_siecleAnneeAffectationDecision);
  }
  
  protected String rawGetCodeSousProduit1()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit1();
  }
  
  public String getCodeSousProduit1()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit1();
  }
  
  public void setCodeSousProduit1(String p_codeSousProduit1)
  {
    if ((m_codeSousProduit1 == null) || (p_codeSousProduit1 == null))
    {
      m_codeSousProduit1 = p_codeSousProduit1;
      ((AideNcpPC)getPC()).setCodeSousProduit1(p_codeSousProduit1);
    }
    else if ((m_codeSousProduit1 != null) && (p_codeSousProduit1 != null) && (!p_codeSousProduit1.equals(m_codeSousProduit1)))
    {
      m_codeSousProduit1 = p_codeSousProduit1;
      ((AideNcpPC)getPC()).setCodeSousProduit1(p_codeSousProduit1);
    }
  }
  
  protected String rawGetCodeNatureDerogatoireSousProduit1()
  {
    return ((AideNcpPC)getPC()).getCodeNatureDerogatoireSousProduit1();
  }
  
  public String getCodeNatureDerogatoireSousProduit1()
  {
    return ((AideNcpPC)getPC()).getCodeNatureDerogatoireSousProduit1();
  }
  
  public void setCodeNatureDerogatoireSousProduit1(String p_codeNatureDerogatoireSousProduit1)
  {
    if ((m_codeNatureDerogatoireSousProduit1 == null) || (p_codeNatureDerogatoireSousProduit1 == null))
    {
      m_codeNatureDerogatoireSousProduit1 = p_codeNatureDerogatoireSousProduit1;
      ((AideNcpPC)getPC()).setCodeNatureDerogatoireSousProduit1(p_codeNatureDerogatoireSousProduit1);
    }
    else if ((m_codeNatureDerogatoireSousProduit1 != null) && (p_codeNatureDerogatoireSousProduit1 != null) && (!p_codeNatureDerogatoireSousProduit1.equals(m_codeNatureDerogatoireSousProduit1)))
    {
      m_codeNatureDerogatoireSousProduit1 = p_codeNatureDerogatoireSousProduit1;
      ((AideNcpPC)getPC()).setCodeNatureDerogatoireSousProduit1(p_codeNatureDerogatoireSousProduit1);
    }
  }
  
  protected int rawGetNbAidesIndemniseesPeriode1()
  {
    return ((AideNcpPC)getPC()).getNbAidesIndemniseesPeriode1();
  }
  
  public int getNbAidesIndemniseesPeriode1()
  {
    return ((AideNcpPC)getPC()).getNbAidesIndemniseesPeriode1();
  }
  
  public void setNbAidesIndemniseesPeriode1(int p_nbAidesIndemniseesPeriode1)
  {
    ((AideNcpPC)getPC()).setNbAidesIndemniseesPeriode1(p_nbAidesIndemniseesPeriode1);
  }
  
  protected BigDecimal rawGetMontantUnitaireAide1()
  {
    return ((AideNcpPC)getPC()).getMontantUnitaireAide1();
  }
  
  public BigDecimal getMontantUnitaireAide1()
  {
    return ((AideNcpPC)getPC()).getMontantUnitaireAide1();
  }
  
  public void setMontantUnitaireAide1(BigDecimal p_montantUnitaireAide1)
  {
    if ((m_montantUnitaireAide1 == null) || (p_montantUnitaireAide1 == null))
    {
      m_montantUnitaireAide1 = p_montantUnitaireAide1;
      ((AideNcpPC)getPC()).setMontantUnitaireAide1(p_montantUnitaireAide1);
    }
    else if ((m_montantUnitaireAide1 != null) && (p_montantUnitaireAide1 != null) && (!p_montantUnitaireAide1.equals(m_montantUnitaireAide1)))
    {
      m_montantUnitaireAide1 = p_montantUnitaireAide1;
      ((AideNcpPC)getPC()).setMontantUnitaireAide1(p_montantUnitaireAide1);
    }
  }
  
  protected BigDecimal rawGetMontantTotalAide1()
  {
    return ((AideNcpPC)getPC()).getMontantTotalAide1();
  }
  
  public BigDecimal getMontantTotalAide1()
  {
    return ((AideNcpPC)getPC()).getMontantTotalAide1();
  }
  
  public void setMontantTotalAide1(BigDecimal p_montantTotalAide1)
  {
    if ((m_montantTotalAide1 == null) || (p_montantTotalAide1 == null))
    {
      m_montantTotalAide1 = p_montantTotalAide1;
      ((AideNcpPC)getPC()).setMontantTotalAide1(p_montantTotalAide1);
    }
    else if ((m_montantTotalAide1 != null) && (p_montantTotalAide1 != null) && (!p_montantTotalAide1.equals(m_montantTotalAide1)))
    {
      m_montantTotalAide1 = p_montantTotalAide1;
      ((AideNcpPC)getPC()).setMontantTotalAide1(p_montantTotalAide1);
    }
  }
  
  protected String rawGetCodeSousProduit2()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit2();
  }
  
  public String getCodeSousProduit2()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit2();
  }
  
  public void setCodeSousProduit2(String p_codeSousProduit2)
  {
    if ((m_codeSousProduit2 == null) || (p_codeSousProduit2 == null))
    {
      m_codeSousProduit2 = p_codeSousProduit2;
      ((AideNcpPC)getPC()).setCodeSousProduit2(p_codeSousProduit2);
    }
    else if ((m_codeSousProduit2 != null) && (p_codeSousProduit2 != null) && (!p_codeSousProduit2.equals(m_codeSousProduit2)))
    {
      m_codeSousProduit2 = p_codeSousProduit2;
      ((AideNcpPC)getPC()).setCodeSousProduit2(p_codeSousProduit2);
    }
  }
  
  protected String rawGetCodeNatureDerogatoireSousProduit2()
  {
    return ((AideNcpPC)getPC()).getCodeNatureDerogatoireSousProduit2();
  }
  
  public String getCodeNatureDerogatoireSousProduit2()
  {
    return ((AideNcpPC)getPC()).getCodeNatureDerogatoireSousProduit2();
  }
  
  public void setCodeNatureDerogatoireSousProduit2(String p_codeNatureDerogatoireSousProduit2)
  {
    if ((m_codeNatureDerogatoireSousProduit2 == null) || (p_codeNatureDerogatoireSousProduit2 == null))
    {
      m_codeNatureDerogatoireSousProduit2 = p_codeNatureDerogatoireSousProduit2;
      ((AideNcpPC)getPC()).setCodeNatureDerogatoireSousProduit2(p_codeNatureDerogatoireSousProduit2);
    }
    else if ((m_codeNatureDerogatoireSousProduit2 != null) && (p_codeNatureDerogatoireSousProduit2 != null) && (!p_codeNatureDerogatoireSousProduit2.equals(m_codeNatureDerogatoireSousProduit2)))
    {
      m_codeNatureDerogatoireSousProduit2 = p_codeNatureDerogatoireSousProduit2;
      ((AideNcpPC)getPC()).setCodeNatureDerogatoireSousProduit2(p_codeNatureDerogatoireSousProduit2);
    }
  }
  
  protected int rawGetNbAidesIndemniseesPeriode2()
  {
    return ((AideNcpPC)getPC()).getNbAidesIndemniseesPeriode2();
  }
  
  public int getNbAidesIndemniseesPeriode2()
  {
    return ((AideNcpPC)getPC()).getNbAidesIndemniseesPeriode2();
  }
  
  public void setNbAidesIndemniseesPeriode2(int p_nbAidesIndemniseesPeriode2)
  {
    ((AideNcpPC)getPC()).setNbAidesIndemniseesPeriode2(p_nbAidesIndemniseesPeriode2);
  }
  
  protected BigDecimal rawGetMontantUnitaireAide2()
  {
    return ((AideNcpPC)getPC()).getMontantUnitaireAide2();
  }
  
  public BigDecimal getMontantUnitaireAide2()
  {
    return ((AideNcpPC)getPC()).getMontantUnitaireAide2();
  }
  
  public void setMontantUnitaireAide2(BigDecimal p_montantUnitaireAide2)
  {
    if ((m_montantUnitaireAide2 == null) || (p_montantUnitaireAide2 == null))
    {
      m_montantUnitaireAide2 = p_montantUnitaireAide2;
      ((AideNcpPC)getPC()).setMontantUnitaireAide2(p_montantUnitaireAide2);
    }
    else if ((m_montantUnitaireAide2 != null) && (p_montantUnitaireAide2 != null) && (!p_montantUnitaireAide2.equals(m_montantUnitaireAide2)))
    {
      m_montantUnitaireAide2 = p_montantUnitaireAide2;
      ((AideNcpPC)getPC()).setMontantUnitaireAide2(p_montantUnitaireAide2);
    }
  }
  
  protected BigDecimal rawGetMontantTotalAide2()
  {
    return ((AideNcpPC)getPC()).getMontantTotalAide2();
  }
  
  public BigDecimal getMontantTotalAide2()
  {
    return ((AideNcpPC)getPC()).getMontantTotalAide2();
  }
  
  public void setMontantTotalAide2(BigDecimal p_montantTotalAide2)
  {
    if ((m_montantTotalAide2 == null) || (p_montantTotalAide2 == null))
    {
      m_montantTotalAide2 = p_montantTotalAide2;
      ((AideNcpPC)getPC()).setMontantTotalAide2(p_montantTotalAide2);
    }
    else if ((m_montantTotalAide2 != null) && (p_montantTotalAide2 != null) && (!p_montantTotalAide2.equals(m_montantTotalAide2)))
    {
      m_montantTotalAide2 = p_montantTotalAide2;
      ((AideNcpPC)getPC()).setMontantTotalAide2(p_montantTotalAide2);
    }
  }
  
  protected String rawGetCodeSousProduit3()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit3();
  }
  
  public String getCodeSousProduit3()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit3();
  }
  
  public void setCodeSousProduit3(String p_codeSousProduit3)
  {
    if ((m_codeSousProduit3 == null) || (p_codeSousProduit3 == null))
    {
      m_codeSousProduit3 = p_codeSousProduit3;
      ((AideNcpPC)getPC()).setCodeSousProduit3(p_codeSousProduit3);
    }
    else if ((m_codeSousProduit3 != null) && (p_codeSousProduit3 != null) && (!p_codeSousProduit3.equals(m_codeSousProduit3)))
    {
      m_codeSousProduit3 = p_codeSousProduit3;
      ((AideNcpPC)getPC()).setCodeSousProduit3(p_codeSousProduit3);
    }
  }
  
  protected String rawGetCodeSousProduit4()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit4();
  }
  
  public String getCodeSousProduit4()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit4();
  }
  
  public void setCodeSousProduit4(String p_codeSousProduit4)
  {
    if ((m_codeSousProduit4 == null) || (p_codeSousProduit4 == null))
    {
      m_codeSousProduit4 = p_codeSousProduit4;
      ((AideNcpPC)getPC()).setCodeSousProduit4(p_codeSousProduit4);
    }
    else if ((m_codeSousProduit4 != null) && (p_codeSousProduit4 != null) && (!p_codeSousProduit4.equals(m_codeSousProduit4)))
    {
      m_codeSousProduit4 = p_codeSousProduit4;
      ((AideNcpPC)getPC()).setCodeSousProduit4(p_codeSousProduit4);
    }
  }
  
  protected String rawGetCodeNatureDerogatoireSousProduit3()
  {
    return ((AideNcpPC)getPC()).getCodeNatureDerogatoireSousProduit3();
  }
  
  public String getCodeNatureDerogatoireSousProduit3()
  {
    return ((AideNcpPC)getPC()).getCodeNatureDerogatoireSousProduit3();
  }
  
  public void setCodeNatureDerogatoireSousProduit3(String p_codeNatureDerogatoireSousProduit3)
  {
    if ((m_codeNatureDerogatoireSousProduit3 == null) || (p_codeNatureDerogatoireSousProduit3 == null))
    {
      m_codeNatureDerogatoireSousProduit3 = p_codeNatureDerogatoireSousProduit3;
      ((AideNcpPC)getPC()).setCodeNatureDerogatoireSousProduit3(p_codeNatureDerogatoireSousProduit3);
    }
    else if ((m_codeNatureDerogatoireSousProduit3 != null) && (p_codeNatureDerogatoireSousProduit3 != null) && (!p_codeNatureDerogatoireSousProduit3.equals(m_codeNatureDerogatoireSousProduit3)))
    {
      m_codeNatureDerogatoireSousProduit3 = p_codeNatureDerogatoireSousProduit3;
      ((AideNcpPC)getPC()).setCodeNatureDerogatoireSousProduit3(p_codeNatureDerogatoireSousProduit3);
    }
  }
  
  protected String rawGetCodeNatureDerogatoireSousProduit4()
  {
    return ((AideNcpPC)getPC()).getCodeNatureDerogatoireSousProduit4();
  }
  
  public String getCodeNatureDerogatoireSousProduit4()
  {
    return ((AideNcpPC)getPC()).getCodeNatureDerogatoireSousProduit4();
  }
  
  public void setCodeNatureDerogatoireSousProduit4(String p_codeNatureDerogatoireSousProduit4)
  {
    if ((m_codeNatureDerogatoireSousProduit4 == null) || (p_codeNatureDerogatoireSousProduit4 == null))
    {
      m_codeNatureDerogatoireSousProduit4 = p_codeNatureDerogatoireSousProduit4;
      ((AideNcpPC)getPC()).setCodeNatureDerogatoireSousProduit4(p_codeNatureDerogatoireSousProduit4);
    }
    else if ((m_codeNatureDerogatoireSousProduit4 != null) && (p_codeNatureDerogatoireSousProduit4 != null) && (!p_codeNatureDerogatoireSousProduit4.equals(m_codeNatureDerogatoireSousProduit4)))
    {
      m_codeNatureDerogatoireSousProduit4 = p_codeNatureDerogatoireSousProduit4;
      ((AideNcpPC)getPC()).setCodeNatureDerogatoireSousProduit4(p_codeNatureDerogatoireSousProduit4);
    }
  }
  
  protected int rawGetNbAidesIndemniseesPeriode3()
  {
    return ((AideNcpPC)getPC()).getNbAidesIndemniseesPeriode3();
  }
  
  public int getNbAidesIndemniseesPeriode3()
  {
    return ((AideNcpPC)getPC()).getNbAidesIndemniseesPeriode3();
  }
  
  public void setNbAidesIndemniseesPeriode3(int p_nbAidesIndemniseesPeriode3)
  {
    ((AideNcpPC)getPC()).setNbAidesIndemniseesPeriode3(p_nbAidesIndemniseesPeriode3);
  }
  
  protected int rawGetNbAidesIndemniseesPeriode4()
  {
    return ((AideNcpPC)getPC()).getNbAidesIndemniseesPeriode4();
  }
  
  public int getNbAidesIndemniseesPeriode4()
  {
    return ((AideNcpPC)getPC()).getNbAidesIndemniseesPeriode4();
  }
  
  public void setNbAidesIndemniseesPeriode4(int p_nbAidesIndemniseesPeriode4)
  {
    ((AideNcpPC)getPC()).setNbAidesIndemniseesPeriode4(p_nbAidesIndemniseesPeriode4);
  }
  
  protected BigDecimal rawGetMontantUnitaireAide3()
  {
    return ((AideNcpPC)getPC()).getMontantUnitaireAide3();
  }
  
  public BigDecimal getMontantUnitaireAide3()
  {
    return ((AideNcpPC)getPC()).getMontantUnitaireAide3();
  }
  
  public void setMontantUnitaireAide3(BigDecimal p_montantUnitaireAide3)
  {
    if ((m_montantUnitaireAide3 == null) || (p_montantUnitaireAide3 == null))
    {
      m_montantUnitaireAide3 = p_montantUnitaireAide3;
      ((AideNcpPC)getPC()).setMontantUnitaireAide3(p_montantUnitaireAide3);
    }
    else if ((m_montantUnitaireAide3 != null) && (p_montantUnitaireAide3 != null) && (!p_montantUnitaireAide3.equals(m_montantUnitaireAide3)))
    {
      m_montantUnitaireAide3 = p_montantUnitaireAide3;
      ((AideNcpPC)getPC()).setMontantUnitaireAide3(p_montantUnitaireAide3);
    }
  }
  
  protected BigDecimal rawGetMontantUnitaireAide4()
  {
    return ((AideNcpPC)getPC()).getMontantUnitaireAide4();
  }
  
  public BigDecimal getMontantUnitaireAide4()
  {
    return ((AideNcpPC)getPC()).getMontantUnitaireAide4();
  }
  
  public void setMontantUnitaireAide4(BigDecimal p_montantUnitaireAide4)
  {
    if ((m_montantUnitaireAide4 == null) || (p_montantUnitaireAide4 == null))
    {
      m_montantUnitaireAide4 = p_montantUnitaireAide4;
      ((AideNcpPC)getPC()).setMontantUnitaireAide4(p_montantUnitaireAide4);
    }
    else if ((m_montantUnitaireAide4 != null) && (p_montantUnitaireAide4 != null) && (!p_montantUnitaireAide4.equals(m_montantUnitaireAide4)))
    {
      m_montantUnitaireAide4 = p_montantUnitaireAide4;
      ((AideNcpPC)getPC()).setMontantUnitaireAide4(p_montantUnitaireAide4);
    }
  }
  
  protected BigDecimal rawGetMontantTotalAide3()
  {
    return ((AideNcpPC)getPC()).getMontantTotalAide3();
  }
  
  public BigDecimal getMontantTotalAide3()
  {
    return ((AideNcpPC)getPC()).getMontantTotalAide3();
  }
  
  public void setMontantTotalAide3(BigDecimal p_montantTotalAide3)
  {
    if ((m_montantTotalAide3 == null) || (p_montantTotalAide3 == null))
    {
      m_montantTotalAide3 = p_montantTotalAide3;
      ((AideNcpPC)getPC()).setMontantTotalAide3(p_montantTotalAide3);
    }
    else if ((m_montantTotalAide3 != null) && (p_montantTotalAide3 != null) && (!p_montantTotalAide3.equals(m_montantTotalAide3)))
    {
      m_montantTotalAide3 = p_montantTotalAide3;
      ((AideNcpPC)getPC()).setMontantTotalAide3(p_montantTotalAide3);
    }
  }
  
  protected BigDecimal rawGetMontantTotalAide4()
  {
    return ((AideNcpPC)getPC()).getMontantTotalAide4();
  }
  
  public BigDecimal getMontantTotalAide4()
  {
    return ((AideNcpPC)getPC()).getMontantTotalAide4();
  }
  
  public void setMontantTotalAide4(BigDecimal p_montantTotalAide4)
  {
    if ((m_montantTotalAide4 == null) || (p_montantTotalAide4 == null))
    {
      m_montantTotalAide4 = p_montantTotalAide4;
      ((AideNcpPC)getPC()).setMontantTotalAide4(p_montantTotalAide4);
    }
    else if ((m_montantTotalAide4 != null) && (p_montantTotalAide4 != null) && (!p_montantTotalAide4.equals(m_montantTotalAide4)))
    {
      m_montantTotalAide4 = p_montantTotalAide4;
      ((AideNcpPC)getPC()).setMontantTotalAide4(p_montantTotalAide4);
    }
  }
  
  protected String rawGetReferenceExterne()
  {
    return ((AideNcpPC)getPC()).getReferenceExterne();
  }
  
  public String getReferenceExterne()
  {
    return ((AideNcpPC)getPC()).getReferenceExterne();
  }
  
  public void setReferenceExterne(String p_referenceExterne)
  {
    if ((m_referenceExterne == null) || (p_referenceExterne == null))
    {
      m_referenceExterne = p_referenceExterne;
      ((AideNcpPC)getPC()).setReferenceExterne(p_referenceExterne);
    }
    else if ((m_referenceExterne != null) && (p_referenceExterne != null) && (!p_referenceExterne.equals(m_referenceExterne)))
    {
      m_referenceExterne = p_referenceExterne;
      ((AideNcpPC)getPC()).setReferenceExterne(p_referenceExterne);
    }
  }
  
  protected String rawGetTypePopulation1()
  {
    return ((AideNcpPC)getPC()).getTypePopulation1();
  }
  
  public String getTypePopulation1()
  {
    return ((AideNcpPC)getPC()).getTypePopulation1();
  }
  
  public void setTypePopulation1(String p_typePopulation1)
  {
    if ((m_typePopulation1 == null) || (p_typePopulation1 == null))
    {
      m_typePopulation1 = p_typePopulation1;
      ((AideNcpPC)getPC()).setTypePopulation1(p_typePopulation1);
    }
    else if ((m_typePopulation1 != null) && (p_typePopulation1 != null) && (!p_typePopulation1.equals(m_typePopulation1)))
    {
      m_typePopulation1 = p_typePopulation1;
      ((AideNcpPC)getPC()).setTypePopulation1(p_typePopulation1);
    }
  }
  
  protected String rawGetTypePopulation2()
  {
    return ((AideNcpPC)getPC()).getTypePopulation2();
  }
  
  public String getTypePopulation2()
  {
    return ((AideNcpPC)getPC()).getTypePopulation2();
  }
  
  public void setTypePopulation2(String p_typePopulation2)
  {
    if ((m_typePopulation2 == null) || (p_typePopulation2 == null))
    {
      m_typePopulation2 = p_typePopulation2;
      ((AideNcpPC)getPC()).setTypePopulation2(p_typePopulation2);
    }
    else if ((m_typePopulation2 != null) && (p_typePopulation2 != null) && (!p_typePopulation2.equals(m_typePopulation2)))
    {
      m_typePopulation2 = p_typePopulation2;
      ((AideNcpPC)getPC()).setTypePopulation2(p_typePopulation2);
    }
  }
  
  protected String rawGetTypePopulation3()
  {
    return ((AideNcpPC)getPC()).getTypePopulation3();
  }
  
  public String getTypePopulation3()
  {
    return ((AideNcpPC)getPC()).getTypePopulation3();
  }
  
  public void setTypePopulation3(String p_typePopulation3)
  {
    if ((m_typePopulation3 == null) || (p_typePopulation3 == null))
    {
      m_typePopulation3 = p_typePopulation3;
      ((AideNcpPC)getPC()).setTypePopulation3(p_typePopulation3);
    }
    else if ((m_typePopulation3 != null) && (p_typePopulation3 != null) && (!p_typePopulation3.equals(m_typePopulation3)))
    {
      m_typePopulation3 = p_typePopulation3;
      ((AideNcpPC)getPC()).setTypePopulation3(p_typePopulation3);
    }
  }
  
  protected String rawGetTypePopulation4()
  {
    return ((AideNcpPC)getPC()).getTypePopulation4();
  }
  
  public String getTypePopulation4()
  {
    return ((AideNcpPC)getPC()).getTypePopulation4();
  }
  
  public void setTypePopulation4(String p_typePopulation4)
  {
    if ((m_typePopulation4 == null) || (p_typePopulation4 == null))
    {
      m_typePopulation4 = p_typePopulation4;
      ((AideNcpPC)getPC()).setTypePopulation4(p_typePopulation4);
    }
    else if ((m_typePopulation4 != null) && (p_typePopulation4 != null) && (!p_typePopulation4.equals(m_typePopulation4)))
    {
      m_typePopulation4 = p_typePopulation4;
      ((AideNcpPC)getPC()).setTypePopulation4(p_typePopulation4);
    }
  }
  
  protected String rawGetTypePopulation5()
  {
    return ((AideNcpPC)getPC()).getTypePopulation5();
  }
  
  public String getTypePopulation5()
  {
    return ((AideNcpPC)getPC()).getTypePopulation5();
  }
  
  public void setTypePopulation5(String p_typePopulation5)
  {
    if ((m_typePopulation5 == null) || (p_typePopulation5 == null))
    {
      m_typePopulation5 = p_typePopulation5;
      ((AideNcpPC)getPC()).setTypePopulation5(p_typePopulation5);
    }
    else if ((m_typePopulation5 != null) && (p_typePopulation5 != null) && (!p_typePopulation5.equals(m_typePopulation5)))
    {
      m_typePopulation5 = p_typePopulation5;
      ((AideNcpPC)getPC()).setTypePopulation5(p_typePopulation5);
    }
  }
  
  protected String rawGetSousTypePopulation1()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation1();
  }
  
  public String getSousTypePopulation1()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation1();
  }
  
  public void setSousTypePopulation1(String p_sousTypePopulation1)
  {
    if ((m_sousTypePopulation1 == null) || (p_sousTypePopulation1 == null))
    {
      m_sousTypePopulation1 = p_sousTypePopulation1;
      ((AideNcpPC)getPC()).setSousTypePopulation1(p_sousTypePopulation1);
    }
    else if ((m_sousTypePopulation1 != null) && (p_sousTypePopulation1 != null) && (!p_sousTypePopulation1.equals(m_sousTypePopulation1)))
    {
      m_sousTypePopulation1 = p_sousTypePopulation1;
      ((AideNcpPC)getPC()).setSousTypePopulation1(p_sousTypePopulation1);
    }
  }
  
  protected String rawGetSousTypePopulation2()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation2();
  }
  
  public String getSousTypePopulation2()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation2();
  }
  
  public void setSousTypePopulation2(String p_sousTypePopulation2)
  {
    if ((m_sousTypePopulation2 == null) || (p_sousTypePopulation2 == null))
    {
      m_sousTypePopulation2 = p_sousTypePopulation2;
      ((AideNcpPC)getPC()).setSousTypePopulation2(p_sousTypePopulation2);
    }
    else if ((m_sousTypePopulation2 != null) && (p_sousTypePopulation2 != null) && (!p_sousTypePopulation2.equals(m_sousTypePopulation2)))
    {
      m_sousTypePopulation2 = p_sousTypePopulation2;
      ((AideNcpPC)getPC()).setSousTypePopulation2(p_sousTypePopulation2);
    }
  }
  
  protected String rawGetSousTypePopulation3()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation3();
  }
  
  public String getSousTypePopulation3()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation3();
  }
  
  public void setSousTypePopulation3(String p_sousTypePopulation3)
  {
    if ((m_sousTypePopulation3 == null) || (p_sousTypePopulation3 == null))
    {
      m_sousTypePopulation3 = p_sousTypePopulation3;
      ((AideNcpPC)getPC()).setSousTypePopulation3(p_sousTypePopulation3);
    }
    else if ((m_sousTypePopulation3 != null) && (p_sousTypePopulation3 != null) && (!p_sousTypePopulation3.equals(m_sousTypePopulation3)))
    {
      m_sousTypePopulation3 = p_sousTypePopulation3;
      ((AideNcpPC)getPC()).setSousTypePopulation3(p_sousTypePopulation3);
    }
  }
  
  protected String rawGetSousTypePopulation4()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation4();
  }
  
  public String getSousTypePopulation4()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation4();
  }
  
  public void setSousTypePopulation4(String p_sousTypePopulation4)
  {
    if ((m_sousTypePopulation4 == null) || (p_sousTypePopulation4 == null))
    {
      m_sousTypePopulation4 = p_sousTypePopulation4;
      ((AideNcpPC)getPC()).setSousTypePopulation4(p_sousTypePopulation4);
    }
    else if ((m_sousTypePopulation4 != null) && (p_sousTypePopulation4 != null) && (!p_sousTypePopulation4.equals(m_sousTypePopulation4)))
    {
      m_sousTypePopulation4 = p_sousTypePopulation4;
      ((AideNcpPC)getPC()).setSousTypePopulation4(p_sousTypePopulation4);
    }
  }
  
  protected String rawGetSousTypePopulation5()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation5();
  }
  
  public String getSousTypePopulation5()
  {
    return ((AideNcpPC)getPC()).getSousTypePopulation5();
  }
  
  public void setSousTypePopulation5(String p_sousTypePopulation5)
  {
    if ((m_sousTypePopulation5 == null) || (p_sousTypePopulation5 == null))
    {
      m_sousTypePopulation5 = p_sousTypePopulation5;
      ((AideNcpPC)getPC()).setSousTypePopulation5(p_sousTypePopulation5);
    }
    else if ((m_sousTypePopulation5 != null) && (p_sousTypePopulation5 != null) && (!p_sousTypePopulation5.equals(m_sousTypePopulation5)))
    {
      m_sousTypePopulation5 = p_sousTypePopulation5;
      ((AideNcpPC)getPC()).setSousTypePopulation5(p_sousTypePopulation5);
    }
  }
  
  protected String rawGetStatutPrestation1()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation1();
  }
  
  public String getStatutPrestation1()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation1();
  }
  
  public void setStatutPrestation1(String p_statutPrestation1)
  {
    if ((m_statutPrestation1 == null) || (p_statutPrestation1 == null))
    {
      m_statutPrestation1 = p_statutPrestation1;
      ((AideNcpPC)getPC()).setStatutPrestation1(p_statutPrestation1);
    }
    else if ((m_statutPrestation1 != null) && (p_statutPrestation1 != null) && (!p_statutPrestation1.equals(m_statutPrestation1)))
    {
      m_statutPrestation1 = p_statutPrestation1;
      ((AideNcpPC)getPC()).setStatutPrestation1(p_statutPrestation1);
    }
  }
  
  protected String rawGetStatutPrestation2()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation2();
  }
  
  public String getStatutPrestation2()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation2();
  }
  
  public void setStatutPrestation2(String p_statutPrestation2)
  {
    if ((m_statutPrestation2 == null) || (p_statutPrestation2 == null))
    {
      m_statutPrestation2 = p_statutPrestation2;
      ((AideNcpPC)getPC()).setStatutPrestation2(p_statutPrestation2);
    }
    else if ((m_statutPrestation2 != null) && (p_statutPrestation2 != null) && (!p_statutPrestation2.equals(m_statutPrestation2)))
    {
      m_statutPrestation2 = p_statutPrestation2;
      ((AideNcpPC)getPC()).setStatutPrestation2(p_statutPrestation2);
    }
  }
  
  protected String rawGetStatutPrestation3()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation3();
  }
  
  public String getStatutPrestation3()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation3();
  }
  
  public void setStatutPrestation3(String p_statutPrestation3)
  {
    if ((m_statutPrestation3 == null) || (p_statutPrestation3 == null))
    {
      m_statutPrestation3 = p_statutPrestation3;
      ((AideNcpPC)getPC()).setStatutPrestation3(p_statutPrestation3);
    }
    else if ((m_statutPrestation3 != null) && (p_statutPrestation3 != null) && (!p_statutPrestation3.equals(m_statutPrestation3)))
    {
      m_statutPrestation3 = p_statutPrestation3;
      ((AideNcpPC)getPC()).setStatutPrestation3(p_statutPrestation3);
    }
  }
  
  protected String rawGetStatutPrestation4()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation4();
  }
  
  public String getStatutPrestation4()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation4();
  }
  
  public void setStatutPrestation4(String p_statutPrestation4)
  {
    if ((m_statutPrestation4 == null) || (p_statutPrestation4 == null))
    {
      m_statutPrestation4 = p_statutPrestation4;
      ((AideNcpPC)getPC()).setStatutPrestation4(p_statutPrestation4);
    }
    else if ((m_statutPrestation4 != null) && (p_statutPrestation4 != null) && (!p_statutPrestation4.equals(m_statutPrestation4)))
    {
      m_statutPrestation4 = p_statutPrestation4;
      ((AideNcpPC)getPC()).setStatutPrestation4(p_statutPrestation4);
    }
  }
  
  protected String rawGetStatutPrestation5()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation5();
  }
  
  public String getStatutPrestation5()
  {
    return ((AideNcpPC)getPC()).getStatutPrestation5();
  }
  
  public void setStatutPrestation5(String p_statutPrestation5)
  {
    if ((m_statutPrestation5 == null) || (p_statutPrestation5 == null))
    {
      m_statutPrestation5 = p_statutPrestation5;
      ((AideNcpPC)getPC()).setStatutPrestation5(p_statutPrestation5);
    }
    else if ((m_statutPrestation5 != null) && (p_statutPrestation5 != null) && (!p_statutPrestation5.equals(m_statutPrestation5)))
    {
      m_statutPrestation5 = p_statutPrestation5;
      ((AideNcpPC)getPC()).setStatutPrestation5(p_statutPrestation5);
    }
  }
  
  protected int rawGetIdPlanFormation()
  {
    return ((AideNcpPC)getPC()).getIdPlanFormation();
  }
  
  public int getIdPlanFormation()
  {
    return ((AideNcpPC)getPC()).getIdPlanFormation();
  }
  
  public void setIdPlanFormation(int p_idPlanFormation)
  {
    ((AideNcpPC)getPC()).setIdPlanFormation(p_idPlanFormation);
  }
  
  protected int rawGetIdStageFormation()
  {
    return ((AideNcpPC)getPC()).getIdStageFormation();
  }
  
  public int getIdStageFormation()
  {
    return ((AideNcpPC)getPC()).getIdStageFormation();
  }
  
  public void setIdStageFormation(int p_idStageFormation)
  {
    ((AideNcpPC)getPC()).setIdStageFormation(p_idStageFormation);
  }
  
  protected int rawGetComplementTypeMontant1()
  {
    return ((AideNcpPC)getPC()).getComplementTypeMontant1();
  }
  
  public int getComplementTypeMontant1()
  {
    return ((AideNcpPC)getPC()).getComplementTypeMontant1();
  }
  
  public void setComplementTypeMontant1(int p_complementTypeMontant1)
  {
    ((AideNcpPC)getPC()).setComplementTypeMontant1(p_complementTypeMontant1);
  }
  
  protected int rawGetComplementTypeMontant2()
  {
    return ((AideNcpPC)getPC()).getComplementTypeMontant2();
  }
  
  public int getComplementTypeMontant2()
  {
    return ((AideNcpPC)getPC()).getComplementTypeMontant2();
  }
  
  public void setComplementTypeMontant2(int p_complementTypeMontant2)
  {
    ((AideNcpPC)getPC()).setComplementTypeMontant2(p_complementTypeMontant2);
  }
  
  protected int rawGetComplementTypeMontant3()
  {
    return ((AideNcpPC)getPC()).getComplementTypeMontant3();
  }
  
  public int getComplementTypeMontant3()
  {
    return ((AideNcpPC)getPC()).getComplementTypeMontant3();
  }
  
  public void setComplementTypeMontant3(int p_complementTypeMontant3)
  {
    ((AideNcpPC)getPC()).setComplementTypeMontant3(p_complementTypeMontant3);
  }
  
  protected int rawGetComplementTypeMontant4()
  {
    return ((AideNcpPC)getPC()).getComplementTypeMontant4();
  }
  
  public int getComplementTypeMontant4()
  {
    return ((AideNcpPC)getPC()).getComplementTypeMontant4();
  }
  
  public void setComplementTypeMontant4(int p_complementTypeMontant4)
  {
    ((AideNcpPC)getPC()).setComplementTypeMontant4(p_complementTypeMontant4);
  }
  
  protected String rawGetCodeSousProduit()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit();
  }
  
  public String getCodeSousProduit()
  {
    return ((AideNcpPC)getPC()).getCodeSousProduit();
  }
  
  public void setCodeSousProduit(String p_codeSousProduit)
  {
    if ((m_codeSousProduit == null) || (p_codeSousProduit == null))
    {
      m_codeSousProduit = p_codeSousProduit;
      ((AideNcpPC)getPC()).setCodeSousProduit(p_codeSousProduit);
    }
    else if ((m_codeSousProduit != null) && (p_codeSousProduit != null) && (!p_codeSousProduit.equals(m_codeSousProduit)))
    {
      m_codeSousProduit = p_codeSousProduit;
      ((AideNcpPC)getPC()).setCodeSousProduit(p_codeSousProduit);
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
 * Qualified Name:     AideNcpGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
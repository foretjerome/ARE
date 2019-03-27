package fr.unedic.cali.calcul.pbjc.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.pbjc.dom.pc.PrimePbjcNcpPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class PrimePbjcNcpGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_primePbjcNcpPC;
  private String m_codeProduit;
  private Damj m_dateEffet;
  private BigDecimal m_montant;
  private BigDecimal m_complementMontant1;
  private BigDecimal m_complementMontant2;
  private String m_codePays;
  private String m_typePopulation1;
  private String m_sousTypePopulation1;
  private String m_statutPrestation1;
  private String m_typePopulation2;
  private String m_sousTypePopulation2;
  private String m_statutPrestation2;
  private String m_typePopulation3;
  private String m_sousTypePopulation3;
  private String m_statutPrestation3;
  private String m_typePopulation4;
  private String m_sousTypePopulation4;
  private String m_statutPrestation4;
  private String m_typePopulation5;
  private String m_sousTypePopulation5;
  private String m_statutPrestation5;
  private String m_codeSousProduit;
  private String m_tiers;
  
  public PrimePbjcNcpGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public PrimePbjcNcpGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new PrimePbjcNcpPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_primePbjcNcpPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_primePbjcNcpPC)
  {
    m_primePbjcNcpPC = p_primePbjcNcpPC;
  }
  
  protected String rawGetCodeProduit()
  {
    return ((PrimePbjcNcpPC)getPC()).getCodeProduit();
  }
  
  public String getCodeProduit()
  {
    return ((PrimePbjcNcpPC)getPC()).getCodeProduit();
  }
  
  public void setCodeProduit(String p_codeProduit)
  {
    if ((m_codeProduit == null) || (p_codeProduit == null))
    {
      m_codeProduit = p_codeProduit;
      ((PrimePbjcNcpPC)getPC()).setCodeProduit(p_codeProduit);
    }
    else if ((m_codeProduit != null) && (p_codeProduit != null) && (!p_codeProduit.equals(m_codeProduit)))
    {
      m_codeProduit = p_codeProduit;
      ((PrimePbjcNcpPC)getPC()).setCodeProduit(p_codeProduit);
    }
  }
  
  protected Damj rawGetDateEffet()
  {
    return ((PrimePbjcNcpPC)getPC()).getDateEffet();
  }
  
  public Damj getDateEffet()
  {
    return ((PrimePbjcNcpPC)getPC()).getDateEffet();
  }
  
  public void setDateEffet(Damj p_dateEffet)
  {
    if ((m_dateEffet == null) || (p_dateEffet == null))
    {
      m_dateEffet = p_dateEffet;
      ((PrimePbjcNcpPC)getPC()).setDateEffet(p_dateEffet);
    }
    else if ((m_dateEffet != null) && (p_dateEffet != null) && (!p_dateEffet.equals(m_dateEffet)))
    {
      m_dateEffet = p_dateEffet;
      ((PrimePbjcNcpPC)getPC()).setDateEffet(p_dateEffet);
    }
  }
  
  protected BigDecimal rawGetMontant()
  {
    return ((PrimePbjcNcpPC)getPC()).getMontant();
  }
  
  public BigDecimal getMontant()
  {
    return ((PrimePbjcNcpPC)getPC()).getMontant();
  }
  
  public void setMontant(BigDecimal p_montant)
  {
    if ((m_montant == null) || (p_montant == null))
    {
      m_montant = p_montant;
      ((PrimePbjcNcpPC)getPC()).setMontant(p_montant);
    }
    else if ((m_montant != null) && (p_montant != null) && (!p_montant.equals(m_montant)))
    {
      m_montant = p_montant;
      ((PrimePbjcNcpPC)getPC()).setMontant(p_montant);
    }
  }
  
  protected BigDecimal rawGetComplementMontant1()
  {
    return ((PrimePbjcNcpPC)getPC()).getComplementMontant1();
  }
  
  public BigDecimal getComplementMontant1()
  {
    return ((PrimePbjcNcpPC)getPC()).getComplementMontant1();
  }
  
  public void setComplementMontant1(BigDecimal p_complementMontant1)
  {
    if ((m_complementMontant1 == null) || (p_complementMontant1 == null))
    {
      m_complementMontant1 = p_complementMontant1;
      ((PrimePbjcNcpPC)getPC()).setComplementMontant1(p_complementMontant1);
    }
    else if ((m_complementMontant1 != null) && (p_complementMontant1 != null) && (!p_complementMontant1.equals(m_complementMontant1)))
    {
      m_complementMontant1 = p_complementMontant1;
      ((PrimePbjcNcpPC)getPC()).setComplementMontant1(p_complementMontant1);
    }
  }
  
  protected BigDecimal rawGetComplementMontant2()
  {
    return ((PrimePbjcNcpPC)getPC()).getComplementMontant2();
  }
  
  public BigDecimal getComplementMontant2()
  {
    return ((PrimePbjcNcpPC)getPC()).getComplementMontant2();
  }
  
  public void setComplementMontant2(BigDecimal p_complementMontant2)
  {
    if ((m_complementMontant2 == null) || (p_complementMontant2 == null))
    {
      m_complementMontant2 = p_complementMontant2;
      ((PrimePbjcNcpPC)getPC()).setComplementMontant2(p_complementMontant2);
    }
    else if ((m_complementMontant2 != null) && (p_complementMontant2 != null) && (!p_complementMontant2.equals(m_complementMontant2)))
    {
      m_complementMontant2 = p_complementMontant2;
      ((PrimePbjcNcpPC)getPC()).setComplementMontant2(p_complementMontant2);
    }
  }
  
  protected int rawGetNbJoursReliquatARE()
  {
    return ((PrimePbjcNcpPC)getPC()).getNbJoursReliquatARE();
  }
  
  public int getNbJoursReliquatARE()
  {
    return ((PrimePbjcNcpPC)getPC()).getNbJoursReliquatARE();
  }
  
  public void setNbJoursReliquatARE(int p_nbJoursReliquatARE)
  {
    ((PrimePbjcNcpPC)getPC()).setNbJoursReliquatARE(p_nbJoursReliquatARE);
  }
  
  protected int rawGetOdOrigine()
  {
    return ((PrimePbjcNcpPC)getPC()).getOdOrigine();
  }
  
  public int getOdOrigine()
  {
    return ((PrimePbjcNcpPC)getPC()).getOdOrigine();
  }
  
  public void setOdOrigine(int p_odOrigine)
  {
    ((PrimePbjcNcpPC)getPC()).setOdOrigine(p_odOrigine);
  }
  
  protected int rawGetNumeroOrdre()
  {
    return ((PrimePbjcNcpPC)getPC()).getNumeroOrdre();
  }
  
  public int getNumeroOrdre()
  {
    return ((PrimePbjcNcpPC)getPC()).getNumeroOrdre();
  }
  
  public void setNumeroOrdre(int p_numeroOrdre)
  {
    ((PrimePbjcNcpPC)getPC()).setNumeroOrdre(p_numeroOrdre);
  }
  
  protected String rawGetCodePays()
  {
    return ((PrimePbjcNcpPC)getPC()).getCodePays();
  }
  
  public String getCodePays()
  {
    return ((PrimePbjcNcpPC)getPC()).getCodePays();
  }
  
  public void setCodePays(String p_codePays)
  {
    if ((m_codePays == null) || (p_codePays == null))
    {
      m_codePays = p_codePays;
      ((PrimePbjcNcpPC)getPC()).setCodePays(p_codePays);
    }
    else if ((m_codePays != null) && (p_codePays != null) && (!p_codePays.equals(m_codePays)))
    {
      m_codePays = p_codePays;
      ((PrimePbjcNcpPC)getPC()).setCodePays(p_codePays);
    }
  }
  
  protected String rawGetTypePopulation1()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation1();
  }
  
  public String getTypePopulation1()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation1();
  }
  
  public void setTypePopulation1(String p_typePopulation1)
  {
    if ((m_typePopulation1 == null) || (p_typePopulation1 == null))
    {
      m_typePopulation1 = p_typePopulation1;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation1(p_typePopulation1);
    }
    else if ((m_typePopulation1 != null) && (p_typePopulation1 != null) && (!p_typePopulation1.equals(m_typePopulation1)))
    {
      m_typePopulation1 = p_typePopulation1;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation1(p_typePopulation1);
    }
  }
  
  protected String rawGetSousTypePopulation1()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation1();
  }
  
  public String getSousTypePopulation1()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation1();
  }
  
  public void setSousTypePopulation1(String p_sousTypePopulation1)
  {
    if ((m_sousTypePopulation1 == null) || (p_sousTypePopulation1 == null))
    {
      m_sousTypePopulation1 = p_sousTypePopulation1;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation1(p_sousTypePopulation1);
    }
    else if ((m_sousTypePopulation1 != null) && (p_sousTypePopulation1 != null) && (!p_sousTypePopulation1.equals(m_sousTypePopulation1)))
    {
      m_sousTypePopulation1 = p_sousTypePopulation1;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation1(p_sousTypePopulation1);
    }
  }
  
  protected String rawGetStatutPrestation1()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation1();
  }
  
  public String getStatutPrestation1()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation1();
  }
  
  public void setStatutPrestation1(String p_statutPrestation1)
  {
    if ((m_statutPrestation1 == null) || (p_statutPrestation1 == null))
    {
      m_statutPrestation1 = p_statutPrestation1;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation1(p_statutPrestation1);
    }
    else if ((m_statutPrestation1 != null) && (p_statutPrestation1 != null) && (!p_statutPrestation1.equals(m_statutPrestation1)))
    {
      m_statutPrestation1 = p_statutPrestation1;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation1(p_statutPrestation1);
    }
  }
  
  protected String rawGetTypePopulation2()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation2();
  }
  
  public String getTypePopulation2()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation2();
  }
  
  public void setTypePopulation2(String p_typePopulation2)
  {
    if ((m_typePopulation2 == null) || (p_typePopulation2 == null))
    {
      m_typePopulation2 = p_typePopulation2;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation2(p_typePopulation2);
    }
    else if ((m_typePopulation2 != null) && (p_typePopulation2 != null) && (!p_typePopulation2.equals(m_typePopulation2)))
    {
      m_typePopulation2 = p_typePopulation2;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation2(p_typePopulation2);
    }
  }
  
  protected String rawGetSousTypePopulation2()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation2();
  }
  
  public String getSousTypePopulation2()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation2();
  }
  
  public void setSousTypePopulation2(String p_sousTypePopulation2)
  {
    if ((m_sousTypePopulation2 == null) || (p_sousTypePopulation2 == null))
    {
      m_sousTypePopulation2 = p_sousTypePopulation2;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation2(p_sousTypePopulation2);
    }
    else if ((m_sousTypePopulation2 != null) && (p_sousTypePopulation2 != null) && (!p_sousTypePopulation2.equals(m_sousTypePopulation2)))
    {
      m_sousTypePopulation2 = p_sousTypePopulation2;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation2(p_sousTypePopulation2);
    }
  }
  
  protected String rawGetStatutPrestation2()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation2();
  }
  
  public String getStatutPrestation2()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation2();
  }
  
  public void setStatutPrestation2(String p_statutPrestation2)
  {
    if ((m_statutPrestation2 == null) || (p_statutPrestation2 == null))
    {
      m_statutPrestation2 = p_statutPrestation2;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation2(p_statutPrestation2);
    }
    else if ((m_statutPrestation2 != null) && (p_statutPrestation2 != null) && (!p_statutPrestation2.equals(m_statutPrestation2)))
    {
      m_statutPrestation2 = p_statutPrestation2;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation2(p_statutPrestation2);
    }
  }
  
  protected String rawGetTypePopulation3()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation3();
  }
  
  public String getTypePopulation3()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation3();
  }
  
  public void setTypePopulation3(String p_typePopulation3)
  {
    if ((m_typePopulation3 == null) || (p_typePopulation3 == null))
    {
      m_typePopulation3 = p_typePopulation3;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation3(p_typePopulation3);
    }
    else if ((m_typePopulation3 != null) && (p_typePopulation3 != null) && (!p_typePopulation3.equals(m_typePopulation3)))
    {
      m_typePopulation3 = p_typePopulation3;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation3(p_typePopulation3);
    }
  }
  
  protected String rawGetSousTypePopulation3()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation3();
  }
  
  public String getSousTypePopulation3()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation3();
  }
  
  public void setSousTypePopulation3(String p_sousTypePopulation3)
  {
    if ((m_sousTypePopulation3 == null) || (p_sousTypePopulation3 == null))
    {
      m_sousTypePopulation3 = p_sousTypePopulation3;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation3(p_sousTypePopulation3);
    }
    else if ((m_sousTypePopulation3 != null) && (p_sousTypePopulation3 != null) && (!p_sousTypePopulation3.equals(m_sousTypePopulation3)))
    {
      m_sousTypePopulation3 = p_sousTypePopulation3;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation3(p_sousTypePopulation3);
    }
  }
  
  protected String rawGetStatutPrestation3()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation3();
  }
  
  public String getStatutPrestation3()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation3();
  }
  
  public void setStatutPrestation3(String p_statutPrestation3)
  {
    if ((m_statutPrestation3 == null) || (p_statutPrestation3 == null))
    {
      m_statutPrestation3 = p_statutPrestation3;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation3(p_statutPrestation3);
    }
    else if ((m_statutPrestation3 != null) && (p_statutPrestation3 != null) && (!p_statutPrestation3.equals(m_statutPrestation3)))
    {
      m_statutPrestation3 = p_statutPrestation3;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation3(p_statutPrestation3);
    }
  }
  
  protected String rawGetTypePopulation4()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation4();
  }
  
  public String getTypePopulation4()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation4();
  }
  
  public void setTypePopulation4(String p_typePopulation4)
  {
    if ((m_typePopulation4 == null) || (p_typePopulation4 == null))
    {
      m_typePopulation4 = p_typePopulation4;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation4(p_typePopulation4);
    }
    else if ((m_typePopulation4 != null) && (p_typePopulation4 != null) && (!p_typePopulation4.equals(m_typePopulation4)))
    {
      m_typePopulation4 = p_typePopulation4;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation4(p_typePopulation4);
    }
  }
  
  protected String rawGetSousTypePopulation4()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation4();
  }
  
  public String getSousTypePopulation4()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation4();
  }
  
  public void setSousTypePopulation4(String p_sousTypePopulation4)
  {
    if ((m_sousTypePopulation4 == null) || (p_sousTypePopulation4 == null))
    {
      m_sousTypePopulation4 = p_sousTypePopulation4;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation4(p_sousTypePopulation4);
    }
    else if ((m_sousTypePopulation4 != null) && (p_sousTypePopulation4 != null) && (!p_sousTypePopulation4.equals(m_sousTypePopulation4)))
    {
      m_sousTypePopulation4 = p_sousTypePopulation4;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation4(p_sousTypePopulation4);
    }
  }
  
  protected String rawGetStatutPrestation4()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation4();
  }
  
  public String getStatutPrestation4()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation4();
  }
  
  public void setStatutPrestation4(String p_statutPrestation4)
  {
    if ((m_statutPrestation4 == null) || (p_statutPrestation4 == null))
    {
      m_statutPrestation4 = p_statutPrestation4;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation4(p_statutPrestation4);
    }
    else if ((m_statutPrestation4 != null) && (p_statutPrestation4 != null) && (!p_statutPrestation4.equals(m_statutPrestation4)))
    {
      m_statutPrestation4 = p_statutPrestation4;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation4(p_statutPrestation4);
    }
  }
  
  protected String rawGetTypePopulation5()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation5();
  }
  
  public String getTypePopulation5()
  {
    return ((PrimePbjcNcpPC)getPC()).getTypePopulation5();
  }
  
  public void setTypePopulation5(String p_typePopulation5)
  {
    if ((m_typePopulation5 == null) || (p_typePopulation5 == null))
    {
      m_typePopulation5 = p_typePopulation5;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation5(p_typePopulation5);
    }
    else if ((m_typePopulation5 != null) && (p_typePopulation5 != null) && (!p_typePopulation5.equals(m_typePopulation5)))
    {
      m_typePopulation5 = p_typePopulation5;
      ((PrimePbjcNcpPC)getPC()).setTypePopulation5(p_typePopulation5);
    }
  }
  
  protected String rawGetSousTypePopulation5()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation5();
  }
  
  public String getSousTypePopulation5()
  {
    return ((PrimePbjcNcpPC)getPC()).getSousTypePopulation5();
  }
  
  public void setSousTypePopulation5(String p_sousTypePopulation5)
  {
    if ((m_sousTypePopulation5 == null) || (p_sousTypePopulation5 == null))
    {
      m_sousTypePopulation5 = p_sousTypePopulation5;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation5(p_sousTypePopulation5);
    }
    else if ((m_sousTypePopulation5 != null) && (p_sousTypePopulation5 != null) && (!p_sousTypePopulation5.equals(m_sousTypePopulation5)))
    {
      m_sousTypePopulation5 = p_sousTypePopulation5;
      ((PrimePbjcNcpPC)getPC()).setSousTypePopulation5(p_sousTypePopulation5);
    }
  }
  
  protected String rawGetStatutPrestation5()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation5();
  }
  
  public String getStatutPrestation5()
  {
    return ((PrimePbjcNcpPC)getPC()).getStatutPrestation5();
  }
  
  public void setStatutPrestation5(String p_statutPrestation5)
  {
    if ((m_statutPrestation5 == null) || (p_statutPrestation5 == null))
    {
      m_statutPrestation5 = p_statutPrestation5;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation5(p_statutPrestation5);
    }
    else if ((m_statutPrestation5 != null) && (p_statutPrestation5 != null) && (!p_statutPrestation5.equals(m_statutPrestation5)))
    {
      m_statutPrestation5 = p_statutPrestation5;
      ((PrimePbjcNcpPC)getPC()).setStatutPrestation5(p_statutPrestation5);
    }
  }
  
  protected String rawGetCodeSousProduit()
  {
    return ((PrimePbjcNcpPC)getPC()).getCodeSousProduit();
  }
  
  public String getCodeSousProduit()
  {
    return ((PrimePbjcNcpPC)getPC()).getCodeSousProduit();
  }
  
  public void setCodeSousProduit(String p_codeSousProduit)
  {
    if ((m_codeSousProduit == null) || (p_codeSousProduit == null))
    {
      m_codeSousProduit = p_codeSousProduit;
      ((PrimePbjcNcpPC)getPC()).setCodeSousProduit(p_codeSousProduit);
    }
    else if ((m_codeSousProduit != null) && (p_codeSousProduit != null) && (!p_codeSousProduit.equals(m_codeSousProduit)))
    {
      m_codeSousProduit = p_codeSousProduit;
      ((PrimePbjcNcpPC)getPC()).setCodeSousProduit(p_codeSousProduit);
    }
  }
  
  protected String rawGetTiers()
  {
    return ((PrimePbjcNcpPC)getPC()).getTiers();
  }
  
  public String getTiers()
  {
    return ((PrimePbjcNcpPC)getPC()).getTiers();
  }
  
  public void setTiers(String p_tiers)
  {
    if ((m_tiers == null) || (p_tiers == null))
    {
      m_tiers = p_tiers;
      ((PrimePbjcNcpPC)getPC()).setTiers(p_tiers);
    }
    else if ((m_tiers != null) && (p_tiers != null) && (!p_tiers.equals(m_tiers)))
    {
      m_tiers = p_tiers;
      ((PrimePbjcNcpPC)getPC()).setTiers(p_tiers);
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
 * Qualified Name:     PrimePbjcNcpGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.pivot.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.dom.pivot.pc.AidesNcpPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract class AidesNcpGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_aidesNcpPC;
  private String m_identifiantBanalise1;
  private String m_identifiantBanalise2;
  private String m_identifiantBanalise3;
  private Damj m_dateBanalisee1;
  private Damj m_dateBanalisee2;
  private Damj m_dateBanalisee3;
  private Damj m_dateBanalisee4;
  private Damj m_dateBanalisee5;
  private String m_libelleBanalise1;
  private String m_libelleBanalise2;
  private String m_libelleBanalise3;
  private String m_libelleBanalise4;
  private String m_libelleBanalise5;
  private BigDecimal m_nbJoursBanalise1;
  private BigDecimal m_nbJoursBanalise2;
  private BigDecimal m_nbJoursBanalise3;
  private BigDecimal m_capitalBanalise1;
  private BigDecimal m_capitalBanalise2;
  private BigDecimal m_capitalBanalise3;
  
  public AidesNcpGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public AidesNcpGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new AidesNcpPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_aidesNcpPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_aidesNcpPC)
  {
    m_aidesNcpPC = p_aidesNcpPC;
  }
  
  protected String rawGetIdentifiantBanalise1()
  {
    return ((AidesNcpPC)getPC()).getIdentifiantBanalise1();
  }
  
  public String getIdentifiantBanalise1()
  {
    return ((AidesNcpPC)getPC()).getIdentifiantBanalise1();
  }
  
  public void setIdentifiantBanalise1(String p_identifiantBanalise1)
  {
    if ((m_identifiantBanalise1 == null) || (p_identifiantBanalise1 == null))
    {
      m_identifiantBanalise1 = p_identifiantBanalise1;
      ((AidesNcpPC)getPC()).setIdentifiantBanalise1(p_identifiantBanalise1);
    }
    else if ((m_identifiantBanalise1 != null) && (p_identifiantBanalise1 != null) && (!p_identifiantBanalise1.equals(m_identifiantBanalise1)))
    {
      m_identifiantBanalise1 = p_identifiantBanalise1;
      ((AidesNcpPC)getPC()).setIdentifiantBanalise1(p_identifiantBanalise1);
    }
  }
  
  protected String rawGetIdentifiantBanalise2()
  {
    return ((AidesNcpPC)getPC()).getIdentifiantBanalise2();
  }
  
  public String getIdentifiantBanalise2()
  {
    return ((AidesNcpPC)getPC()).getIdentifiantBanalise2();
  }
  
  public void setIdentifiantBanalise2(String p_identifiantBanalise2)
  {
    if ((m_identifiantBanalise2 == null) || (p_identifiantBanalise2 == null))
    {
      m_identifiantBanalise2 = p_identifiantBanalise2;
      ((AidesNcpPC)getPC()).setIdentifiantBanalise2(p_identifiantBanalise2);
    }
    else if ((m_identifiantBanalise2 != null) && (p_identifiantBanalise2 != null) && (!p_identifiantBanalise2.equals(m_identifiantBanalise2)))
    {
      m_identifiantBanalise2 = p_identifiantBanalise2;
      ((AidesNcpPC)getPC()).setIdentifiantBanalise2(p_identifiantBanalise2);
    }
  }
  
  protected String rawGetIdentifiantBanalise3()
  {
    return ((AidesNcpPC)getPC()).getIdentifiantBanalise3();
  }
  
  public String getIdentifiantBanalise3()
  {
    return ((AidesNcpPC)getPC()).getIdentifiantBanalise3();
  }
  
  public void setIdentifiantBanalise3(String p_identifiantBanalise3)
  {
    if ((m_identifiantBanalise3 == null) || (p_identifiantBanalise3 == null))
    {
      m_identifiantBanalise3 = p_identifiantBanalise3;
      ((AidesNcpPC)getPC()).setIdentifiantBanalise3(p_identifiantBanalise3);
    }
    else if ((m_identifiantBanalise3 != null) && (p_identifiantBanalise3 != null) && (!p_identifiantBanalise3.equals(m_identifiantBanalise3)))
    {
      m_identifiantBanalise3 = p_identifiantBanalise3;
      ((AidesNcpPC)getPC()).setIdentifiantBanalise3(p_identifiantBanalise3);
    }
  }
  
  protected Damj rawGetDateBanalisee1()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee1();
  }
  
  public Damj getDateBanalisee1()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee1();
  }
  
  public void setDateBanalisee1(Damj p_dateBanalisee1)
  {
    if ((m_dateBanalisee1 == null) || (p_dateBanalisee1 == null))
    {
      m_dateBanalisee1 = p_dateBanalisee1;
      ((AidesNcpPC)getPC()).setDateBanalisee1(p_dateBanalisee1);
    }
    else if ((m_dateBanalisee1 != null) && (p_dateBanalisee1 != null) && (!p_dateBanalisee1.equals(m_dateBanalisee1)))
    {
      m_dateBanalisee1 = p_dateBanalisee1;
      ((AidesNcpPC)getPC()).setDateBanalisee1(p_dateBanalisee1);
    }
  }
  
  protected Damj rawGetDateBanalisee2()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee2();
  }
  
  public Damj getDateBanalisee2()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee2();
  }
  
  public void setDateBanalisee2(Damj p_dateBanalisee2)
  {
    if ((m_dateBanalisee2 == null) || (p_dateBanalisee2 == null))
    {
      m_dateBanalisee2 = p_dateBanalisee2;
      ((AidesNcpPC)getPC()).setDateBanalisee2(p_dateBanalisee2);
    }
    else if ((m_dateBanalisee2 != null) && (p_dateBanalisee2 != null) && (!p_dateBanalisee2.equals(m_dateBanalisee2)))
    {
      m_dateBanalisee2 = p_dateBanalisee2;
      ((AidesNcpPC)getPC()).setDateBanalisee2(p_dateBanalisee2);
    }
  }
  
  protected Damj rawGetDateBanalisee3()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee3();
  }
  
  public Damj getDateBanalisee3()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee3();
  }
  
  public void setDateBanalisee3(Damj p_dateBanalisee3)
  {
    if ((m_dateBanalisee3 == null) || (p_dateBanalisee3 == null))
    {
      m_dateBanalisee3 = p_dateBanalisee3;
      ((AidesNcpPC)getPC()).setDateBanalisee3(p_dateBanalisee3);
    }
    else if ((m_dateBanalisee3 != null) && (p_dateBanalisee3 != null) && (!p_dateBanalisee3.equals(m_dateBanalisee3)))
    {
      m_dateBanalisee3 = p_dateBanalisee3;
      ((AidesNcpPC)getPC()).setDateBanalisee3(p_dateBanalisee3);
    }
  }
  
  protected Damj rawGetDateBanalisee4()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee4();
  }
  
  public Damj getDateBanalisee4()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee4();
  }
  
  public void setDateBanalisee4(Damj p_dateBanalisee4)
  {
    if ((m_dateBanalisee4 == null) || (p_dateBanalisee4 == null))
    {
      m_dateBanalisee4 = p_dateBanalisee4;
      ((AidesNcpPC)getPC()).setDateBanalisee4(p_dateBanalisee4);
    }
    else if ((m_dateBanalisee4 != null) && (p_dateBanalisee4 != null) && (!p_dateBanalisee4.equals(m_dateBanalisee4)))
    {
      m_dateBanalisee4 = p_dateBanalisee4;
      ((AidesNcpPC)getPC()).setDateBanalisee4(p_dateBanalisee4);
    }
  }
  
  protected Damj rawGetDateBanalisee5()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee5();
  }
  
  public Damj getDateBanalisee5()
  {
    return ((AidesNcpPC)getPC()).getDateBanalisee5();
  }
  
  public void setDateBanalisee5(Damj p_dateBanalisee5)
  {
    if ((m_dateBanalisee5 == null) || (p_dateBanalisee5 == null))
    {
      m_dateBanalisee5 = p_dateBanalisee5;
      ((AidesNcpPC)getPC()).setDateBanalisee5(p_dateBanalisee5);
    }
    else if ((m_dateBanalisee5 != null) && (p_dateBanalisee5 != null) && (!p_dateBanalisee5.equals(m_dateBanalisee5)))
    {
      m_dateBanalisee5 = p_dateBanalisee5;
      ((AidesNcpPC)getPC()).setDateBanalisee5(p_dateBanalisee5);
    }
  }
  
  protected String rawGetLibelleBanalise1()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise1();
  }
  
  public String getLibelleBanalise1()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise1();
  }
  
  public void setLibelleBanalise1(String p_libelleBanalise1)
  {
    if ((m_libelleBanalise1 == null) || (p_libelleBanalise1 == null))
    {
      m_libelleBanalise1 = p_libelleBanalise1;
      ((AidesNcpPC)getPC()).setLibelleBanalise1(p_libelleBanalise1);
    }
    else if ((m_libelleBanalise1 != null) && (p_libelleBanalise1 != null) && (!p_libelleBanalise1.equals(m_libelleBanalise1)))
    {
      m_libelleBanalise1 = p_libelleBanalise1;
      ((AidesNcpPC)getPC()).setLibelleBanalise1(p_libelleBanalise1);
    }
  }
  
  protected String rawGetLibelleBanalise2()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise2();
  }
  
  public String getLibelleBanalise2()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise2();
  }
  
  public void setLibelleBanalise2(String p_libelleBanalise2)
  {
    if ((m_libelleBanalise2 == null) || (p_libelleBanalise2 == null))
    {
      m_libelleBanalise2 = p_libelleBanalise2;
      ((AidesNcpPC)getPC()).setLibelleBanalise2(p_libelleBanalise2);
    }
    else if ((m_libelleBanalise2 != null) && (p_libelleBanalise2 != null) && (!p_libelleBanalise2.equals(m_libelleBanalise2)))
    {
      m_libelleBanalise2 = p_libelleBanalise2;
      ((AidesNcpPC)getPC()).setLibelleBanalise2(p_libelleBanalise2);
    }
  }
  
  protected String rawGetLibelleBanalise3()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise3();
  }
  
  public String getLibelleBanalise3()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise3();
  }
  
  public void setLibelleBanalise3(String p_libelleBanalise3)
  {
    if ((m_libelleBanalise3 == null) || (p_libelleBanalise3 == null))
    {
      m_libelleBanalise3 = p_libelleBanalise3;
      ((AidesNcpPC)getPC()).setLibelleBanalise3(p_libelleBanalise3);
    }
    else if ((m_libelleBanalise3 != null) && (p_libelleBanalise3 != null) && (!p_libelleBanalise3.equals(m_libelleBanalise3)))
    {
      m_libelleBanalise3 = p_libelleBanalise3;
      ((AidesNcpPC)getPC()).setLibelleBanalise3(p_libelleBanalise3);
    }
  }
  
  protected String rawGetLibelleBanalise4()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise4();
  }
  
  public String getLibelleBanalise4()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise4();
  }
  
  public void setLibelleBanalise4(String p_libelleBanalise4)
  {
    if ((m_libelleBanalise4 == null) || (p_libelleBanalise4 == null))
    {
      m_libelleBanalise4 = p_libelleBanalise4;
      ((AidesNcpPC)getPC()).setLibelleBanalise4(p_libelleBanalise4);
    }
    else if ((m_libelleBanalise4 != null) && (p_libelleBanalise4 != null) && (!p_libelleBanalise4.equals(m_libelleBanalise4)))
    {
      m_libelleBanalise4 = p_libelleBanalise4;
      ((AidesNcpPC)getPC()).setLibelleBanalise4(p_libelleBanalise4);
    }
  }
  
  protected String rawGetLibelleBanalise5()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise5();
  }
  
  public String getLibelleBanalise5()
  {
    return ((AidesNcpPC)getPC()).getLibelleBanalise5();
  }
  
  public void setLibelleBanalise5(String p_libelleBanalise5)
  {
    if ((m_libelleBanalise5 == null) || (p_libelleBanalise5 == null))
    {
      m_libelleBanalise5 = p_libelleBanalise5;
      ((AidesNcpPC)getPC()).setLibelleBanalise5(p_libelleBanalise5);
    }
    else if ((m_libelleBanalise5 != null) && (p_libelleBanalise5 != null) && (!p_libelleBanalise5.equals(m_libelleBanalise5)))
    {
      m_libelleBanalise5 = p_libelleBanalise5;
      ((AidesNcpPC)getPC()).setLibelleBanalise5(p_libelleBanalise5);
    }
  }
  
  protected BigDecimal rawGetNbJoursBanalise1()
  {
    return ((AidesNcpPC)getPC()).getNbJoursBanalise1();
  }
  
  public BigDecimal getNbJoursBanalise1()
  {
    return ((AidesNcpPC)getPC()).getNbJoursBanalise1();
  }
  
  public void setNbJoursBanalise1(BigDecimal p_nbJoursBanalise1)
  {
    if ((m_nbJoursBanalise1 == null) || (p_nbJoursBanalise1 == null))
    {
      m_nbJoursBanalise1 = p_nbJoursBanalise1;
      ((AidesNcpPC)getPC()).setNbJoursBanalise1(p_nbJoursBanalise1);
    }
    else if ((m_nbJoursBanalise1 != null) && (p_nbJoursBanalise1 != null) && (!p_nbJoursBanalise1.equals(m_nbJoursBanalise1)))
    {
      m_nbJoursBanalise1 = p_nbJoursBanalise1;
      ((AidesNcpPC)getPC()).setNbJoursBanalise1(p_nbJoursBanalise1);
    }
  }
  
  protected BigDecimal rawGetNbJoursBanalise2()
  {
    return ((AidesNcpPC)getPC()).getNbJoursBanalise2();
  }
  
  public BigDecimal getNbJoursBanalise2()
  {
    return ((AidesNcpPC)getPC()).getNbJoursBanalise2();
  }
  
  public void setNbJoursBanalise2(BigDecimal p_nbJoursBanalise2)
  {
    if ((m_nbJoursBanalise2 == null) || (p_nbJoursBanalise2 == null))
    {
      m_nbJoursBanalise2 = p_nbJoursBanalise2;
      ((AidesNcpPC)getPC()).setNbJoursBanalise2(p_nbJoursBanalise2);
    }
    else if ((m_nbJoursBanalise2 != null) && (p_nbJoursBanalise2 != null) && (!p_nbJoursBanalise2.equals(m_nbJoursBanalise2)))
    {
      m_nbJoursBanalise2 = p_nbJoursBanalise2;
      ((AidesNcpPC)getPC()).setNbJoursBanalise2(p_nbJoursBanalise2);
    }
  }
  
  protected BigDecimal rawGetNbJoursBanalise3()
  {
    return ((AidesNcpPC)getPC()).getNbJoursBanalise3();
  }
  
  public BigDecimal getNbJoursBanalise3()
  {
    return ((AidesNcpPC)getPC()).getNbJoursBanalise3();
  }
  
  public void setNbJoursBanalise3(BigDecimal p_nbJoursBanalise3)
  {
    if ((m_nbJoursBanalise3 == null) || (p_nbJoursBanalise3 == null))
    {
      m_nbJoursBanalise3 = p_nbJoursBanalise3;
      ((AidesNcpPC)getPC()).setNbJoursBanalise3(p_nbJoursBanalise3);
    }
    else if ((m_nbJoursBanalise3 != null) && (p_nbJoursBanalise3 != null) && (!p_nbJoursBanalise3.equals(m_nbJoursBanalise3)))
    {
      m_nbJoursBanalise3 = p_nbJoursBanalise3;
      ((AidesNcpPC)getPC()).setNbJoursBanalise3(p_nbJoursBanalise3);
    }
  }
  
  protected BigDecimal rawGetCapitalBanalise1()
  {
    return ((AidesNcpPC)getPC()).getCapitalBanalise1();
  }
  
  public BigDecimal getCapitalBanalise1()
  {
    return ((AidesNcpPC)getPC()).getCapitalBanalise1();
  }
  
  public void setCapitalBanalise1(BigDecimal p_capitalBanalise1)
  {
    if ((m_capitalBanalise1 == null) || (p_capitalBanalise1 == null))
    {
      m_capitalBanalise1 = p_capitalBanalise1;
      ((AidesNcpPC)getPC()).setCapitalBanalise1(p_capitalBanalise1);
    }
    else if ((m_capitalBanalise1 != null) && (p_capitalBanalise1 != null) && (!p_capitalBanalise1.equals(m_capitalBanalise1)))
    {
      m_capitalBanalise1 = p_capitalBanalise1;
      ((AidesNcpPC)getPC()).setCapitalBanalise1(p_capitalBanalise1);
    }
  }
  
  protected BigDecimal rawGetCapitalBanalise2()
  {
    return ((AidesNcpPC)getPC()).getCapitalBanalise2();
  }
  
  public BigDecimal getCapitalBanalise2()
  {
    return ((AidesNcpPC)getPC()).getCapitalBanalise2();
  }
  
  public void setCapitalBanalise2(BigDecimal p_capitalBanalise2)
  {
    if ((m_capitalBanalise2 == null) || (p_capitalBanalise2 == null))
    {
      m_capitalBanalise2 = p_capitalBanalise2;
      ((AidesNcpPC)getPC()).setCapitalBanalise2(p_capitalBanalise2);
    }
    else if ((m_capitalBanalise2 != null) && (p_capitalBanalise2 != null) && (!p_capitalBanalise2.equals(m_capitalBanalise2)))
    {
      m_capitalBanalise2 = p_capitalBanalise2;
      ((AidesNcpPC)getPC()).setCapitalBanalise2(p_capitalBanalise2);
    }
  }
  
  protected BigDecimal rawGetCapitalBanalise3()
  {
    return ((AidesNcpPC)getPC()).getCapitalBanalise3();
  }
  
  public BigDecimal getCapitalBanalise3()
  {
    return ((AidesNcpPC)getPC()).getCapitalBanalise3();
  }
  
  public void setCapitalBanalise3(BigDecimal p_capitalBanalise3)
  {
    if ((m_capitalBanalise3 == null) || (p_capitalBanalise3 == null))
    {
      m_capitalBanalise3 = p_capitalBanalise3;
      ((AidesNcpPC)getPC()).setCapitalBanalise3(p_capitalBanalise3);
    }
    else if ((m_capitalBanalise3 != null) && (p_capitalBanalise3 != null) && (!p_capitalBanalise3.equals(m_capitalBanalise3)))
    {
      m_capitalBanalise3 = p_capitalBanalise3;
      ((AidesNcpPC)getPC()).setCapitalBanalise3(p_capitalBanalise3);
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
 * Qualified Name:     AidesNcpGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
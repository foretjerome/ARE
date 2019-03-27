package fr.unedic.cali.dom.occasionnel;

import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.List;

public class DomLirePopulationsListe
{
  private String m_cxass;
  private BigDecimal m_fonctRappId;
  private String m_codePopulation;
  private String m_reexamDecMig;
  private boolean m_reexecDecMig;
  private String m_typeMandatement;
  private boolean m_appliPremDec;
  private String m_libPopulation;
  private String m_codeAntenne;
  private BigDecimal m_nbDeTraites;
  private BigDecimal m_deltaMontantBrutNegatif;
  private BigDecimal m_deltaMontantBrutPositif;
  private BigDecimal m_deltaMontantBrutZero;
  private BigDecimal m_nbReexamen;
  private BigDecimal m_nbReexecutes;
  private BigDecimal m_nbDeEcartes;
  private BigDecimal m_nbDeltaMtTranche1;
  private BigDecimal m_nbDeltaMtTranche2;
  private BigDecimal m_nbDeltaMtTranche3;
  private BigDecimal m_nbDeltaMtTranche4;
  private BigDecimal m_nbDeltaMtTranche5;
  private BigDecimal m_nbDeltaMtTranche6;
  private BigDecimal m_nbDeltaMtTranche7;
  private BigDecimal m_nbDeltaMtTranche8;
  private BigDecimal m_sommeDeltaMtPos;
  private BigDecimal m_sommeDeltaMtNeg;
  private BigDecimal m_deltaMontantBrutCadt;
  private BigDecimal m_deltaMontantBrutCrc;
  private BigDecimal m_deltaMontantBrutFinancement;
  private List m_listeEltCompare;
  private Damj m_datePassage;
  private String m_consigne1;
  private String m_consigne2;
  private String m_consigne3;
  private Damj m_dateTraitement;
  
  public Damj getDatePassage()
  {
    return m_datePassage;
  }
  
  public void setDatePassage(Damj p_datePassage)
  {
    m_datePassage = p_datePassage;
  }
  
  public String getCodePopulation()
  {
    return m_codePopulation;
  }
  
  public void setCodePopulation(String p_codePopulation)
  {
    m_codePopulation = p_codePopulation;
  }
  
  public String getCxass()
  {
    return m_cxass;
  }
  
  public void setCxass(String p_cxass)
  {
    m_cxass = p_cxass;
  }
  
  public BigDecimal getDeltaMontantBrutNegatif()
  {
    return m_deltaMontantBrutNegatif;
  }
  
  public void setDeltaMontantBrutNegatif(BigDecimal p_deltaMontantBrutNegatif)
  {
    m_deltaMontantBrutNegatif = p_deltaMontantBrutNegatif;
  }
  
  public BigDecimal getFonctRappId()
  {
    return m_fonctRappId;
  }
  
  public void setFonctRappId(BigDecimal p_fonctRappId)
  {
    m_fonctRappId = p_fonctRappId;
  }
  
  public String getLibPopulation()
  {
    return m_libPopulation;
  }
  
  public void setLibPopulation(String p_libPopulation)
  {
    m_libPopulation = p_libPopulation;
  }
  
  public List getListeEltCompare()
  {
    return m_listeEltCompare;
  }
  
  public void setListeEltCompare(List p_listeEltCompare)
  {
    m_listeEltCompare = p_listeEltCompare;
  }
  
  public BigDecimal getNbDeTraites()
  {
    return m_nbDeTraites;
  }
  
  public void setNbDeTraites(BigDecimal p_nbDeTraites)
  {
    m_nbDeTraites = p_nbDeTraites;
  }
  
  public BigDecimal getNbReexecutes()
  {
    return m_nbReexecutes;
  }
  
  public void setNbReexecutes(BigDecimal p_nbReexecutes)
  {
    m_nbReexecutes = p_nbReexecutes;
  }
  
  public BigDecimal getNbReexamen()
  {
    return m_nbReexamen;
  }
  
  public void setNbReexamen(BigDecimal p_nbReexamen)
  {
    m_nbReexamen = p_nbReexamen;
  }
  
  public String getReexamDecMig()
  {
    return m_reexamDecMig;
  }
  
  public void setReexamDecMig(String p_reexamDecMig)
  {
    m_reexamDecMig = p_reexamDecMig;
  }
  
  public String getTypeMandatement()
  {
    return m_typeMandatement;
  }
  
  public void setTypeMandatement(String p_typeMandatement)
  {
    m_typeMandatement = p_typeMandatement;
  }
  
  public boolean isAppliPremDec()
  {
    return m_appliPremDec;
  }
  
  public void setAppliPremDec(boolean p_appliPremDec)
  {
    m_appliPremDec = p_appliPremDec;
  }
  
  public void setReexecDecMig(boolean p_reexecDecMig)
  {
    m_reexecDecMig = p_reexecDecMig;
  }
  
  public boolean isReexecDecMig()
  {
    return m_reexecDecMig;
  }
  
  public BigDecimal getDeltaMontantBrutPositif()
  {
    return m_deltaMontantBrutPositif;
  }
  
  public void setDeltaMontantBrutPositif(BigDecimal p_deltaMontantBrutPositif)
  {
    m_deltaMontantBrutPositif = p_deltaMontantBrutPositif;
  }
  
  public BigDecimal getDeltaMontantBrutZero()
  {
    BigDecimal retour = m_nbReexecutes;
    if (retour != null)
    {
      if (m_deltaMontantBrutNegatif != null) {
        retour = retour.subtract(m_deltaMontantBrutNegatif);
      }
      if (m_deltaMontantBrutPositif != null) {
        retour = retour.subtract(m_deltaMontantBrutPositif);
      }
    }
    else
    {
      retour = new BigDecimal(0);
    }
    return retour;
  }
  
  public void setDeltaMontantBrutZero(BigDecimal p_deltaMontantBrutZero)
  {
    m_deltaMontantBrutZero = p_deltaMontantBrutZero;
  }
  
  public BigDecimal getNbDeEcartes()
  {
    return m_nbDeEcartes;
  }
  
  public void setNbDeEcartes(BigDecimal p_nbDeEcartes)
  {
    m_nbDeEcartes = p_nbDeEcartes;
  }
  
  public String getCodeAntenne()
  {
    return m_codeAntenne;
  }
  
  public void setCodeAntenne(String p_codeAntenne)
  {
    m_codeAntenne = p_codeAntenne;
  }
  
  public BigDecimal getNbDeltaMtTranche1()
  {
    return m_nbDeltaMtTranche1;
  }
  
  public void setNbDeltaMtTranche1(BigDecimal p_nbDeltaMtTranche1)
  {
    m_nbDeltaMtTranche1 = p_nbDeltaMtTranche1;
  }
  
  public BigDecimal getNbDeltaMtTranche2()
  {
    return m_nbDeltaMtTranche2;
  }
  
  public void setNbDeltaMtTranche2(BigDecimal p_nbDeltaMtTranche2)
  {
    m_nbDeltaMtTranche2 = p_nbDeltaMtTranche2;
  }
  
  public BigDecimal getNbDeltaMtTranche3()
  {
    return m_nbDeltaMtTranche3;
  }
  
  public void setNbDeltaMtTranche3(BigDecimal p_nbDeltaMtTranche3)
  {
    m_nbDeltaMtTranche3 = p_nbDeltaMtTranche3;
  }
  
  public BigDecimal getNbDeltaMtTranche4()
  {
    return m_nbDeltaMtTranche4;
  }
  
  public void setNbDeltaMtTranche4(BigDecimal p_nbDeltaMtTranche4)
  {
    m_nbDeltaMtTranche4 = p_nbDeltaMtTranche4;
  }
  
  public BigDecimal getNbDeltaMtTranche5()
  {
    return m_nbDeltaMtTranche5;
  }
  
  public void setNbDeltaMtTranche5(BigDecimal p_nbDeltaMtTranche5)
  {
    m_nbDeltaMtTranche5 = p_nbDeltaMtTranche5;
  }
  
  public BigDecimal getNbDeltaMtTranche6()
  {
    return m_nbDeltaMtTranche6;
  }
  
  public void setNbDeltaMtTranche6(BigDecimal p_nbDeltaMtTranche6)
  {
    m_nbDeltaMtTranche6 = p_nbDeltaMtTranche6;
  }
  
  public BigDecimal getNbDeltaMtTranche7()
  {
    return m_nbDeltaMtTranche7;
  }
  
  public void setNbDeltaMtTranche7(BigDecimal p_nbDeltaMtTranche7)
  {
    m_nbDeltaMtTranche7 = p_nbDeltaMtTranche7;
  }
  
  public BigDecimal getNbDeltaMtTranche8()
  {
    return m_nbDeltaMtTranche8;
  }
  
  public void setNbDeltaMtTranche8(BigDecimal p_nbDeltaMtTranche8)
  {
    m_nbDeltaMtTranche8 = p_nbDeltaMtTranche8;
  }
  
  public BigDecimal getSommeDeltaMtNeg()
  {
    return m_sommeDeltaMtNeg;
  }
  
  public void setSommeDeltaMtNeg(BigDecimal p_sommeDeltaMtNeg)
  {
    m_sommeDeltaMtNeg = p_sommeDeltaMtNeg;
  }
  
  public BigDecimal getSommeDeltaMtPos()
  {
    return m_sommeDeltaMtPos;
  }
  
  public void setSommeDeltaMtPos(BigDecimal p_sommeDeltaMtPos)
  {
    m_sommeDeltaMtPos = p_sommeDeltaMtPos;
  }
  
  public BigDecimal getDeltaMontantBrutCrc()
  {
    return m_deltaMontantBrutCrc;
  }
  
  public void setDeltaMontantBrutCrc(BigDecimal p_deltaMontantBrutCrc)
  {
    m_deltaMontantBrutCrc = p_deltaMontantBrutCrc;
  }
  
  public BigDecimal getDeltaMontantBrutCadt()
  {
    return m_deltaMontantBrutCadt;
  }
  
  public void setDeltaMontantBrutCadt(BigDecimal p_deltaMontantBrutCadt)
  {
    m_deltaMontantBrutCadt = p_deltaMontantBrutCadt;
  }
  
  public BigDecimal getDeltaMontantBrutFinancement()
  {
    return m_deltaMontantBrutFinancement;
  }
  
  public void setDeltaMontantBrutFinancement(BigDecimal p_deltaMontantBrutFinancement)
  {
    m_deltaMontantBrutFinancement = p_deltaMontantBrutFinancement;
  }
  
  public String getConsigne1()
  {
    return m_consigne1;
  }
  
  public void setConsigne1(String p_consigne1)
  {
    m_consigne1 = p_consigne1;
  }
  
  public String getConsigne2()
  {
    return m_consigne2;
  }
  
  public void setConsigne2(String p_consigne2)
  {
    m_consigne2 = p_consigne2;
  }
  
  public String getConsigne3()
  {
    return m_consigne3;
  }
  
  public void setConsigne3(String p_consigne3)
  {
    m_consigne3 = p_consigne3;
  }
  
  public Damj getDateTraitement()
  {
    return m_dateTraitement;
  }
  
  public void setDateTraitement(Damj p_dateTraitement)
  {
    m_dateTraitement = p_dateTraitement;
  }
}

/* Location:
 * Qualified Name:     DomLirePopulationsListe
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
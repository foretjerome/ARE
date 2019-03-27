package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.pc.EtatAuDernierJourAvantPC;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Periode;

public abstract class EtatAuDernierJourAvantGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_etatAuDernierJourAvantPC;
  private Integer m_reliquatPMC;
  private Integer m_reliquatICCP;
  private Integer m_reliquatISLR;
  private Integer m_reliquatDelaiAttente;
  private Periode m_periodeApplicationPMC;
  private Periode m_periodeApplicationICCP;
  private Periode m_periodeApplicationISLR;
  private Periode m_periodeApplicationDelaiAttente;
  private Integer m_dureeInitialePMC;
  private Integer m_dureeInitialeICCP;
  private Integer m_dureeInitialeISLR;
  private Integer m_dureeInitialeDelaiAttente;
  private Periode m_periodePECEvenementReducteur;
  private Integer m_reliquatCP;
  private Integer m_reliquatSalaire;
  private Integer m_dureeInitialeCP;
  private Integer m_dureeInitialeSalaire;
  private Periode m_periodeApplicationCP;
  private Periode m_periodeApplicationSalaire;
  
  public EtatAuDernierJourAvantGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public EtatAuDernierJourAvantGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new EtatAuDernierJourAvantPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_etatAuDernierJourAvantPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_etatAuDernierJourAvantPC)
  {
    m_etatAuDernierJourAvantPC = p_etatAuDernierJourAvantPC;
  }
  
  protected Integer rawGetReliquatPMC()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatPMC();
  }
  
  public Integer getReliquatPMC()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatPMC();
  }
  
  public void setReliquatPMC(Integer p_reliquatPMC)
  {
    if ((m_reliquatPMC == null) || (p_reliquatPMC == null))
    {
      m_reliquatPMC = p_reliquatPMC;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatPMC(p_reliquatPMC);
    }
    else if ((m_reliquatPMC != null) && (p_reliquatPMC != null) && (!p_reliquatPMC.equals(m_reliquatPMC)))
    {
      m_reliquatPMC = p_reliquatPMC;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatPMC(p_reliquatPMC);
    }
  }
  
  protected Integer rawGetReliquatICCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatICCP();
  }
  
  public Integer getReliquatICCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatICCP();
  }
  
  public void setReliquatICCP(Integer p_reliquatICCP)
  {
    if ((m_reliquatICCP == null) || (p_reliquatICCP == null))
    {
      m_reliquatICCP = p_reliquatICCP;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatICCP(p_reliquatICCP);
    }
    else if ((m_reliquatICCP != null) && (p_reliquatICCP != null) && (!p_reliquatICCP.equals(m_reliquatICCP)))
    {
      m_reliquatICCP = p_reliquatICCP;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatICCP(p_reliquatICCP);
    }
  }
  
  protected Integer rawGetReliquatISLR()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatISLR();
  }
  
  public Integer getReliquatISLR()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatISLR();
  }
  
  public void setReliquatISLR(Integer p_reliquatISLR)
  {
    if ((m_reliquatISLR == null) || (p_reliquatISLR == null))
    {
      m_reliquatISLR = p_reliquatISLR;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatISLR(p_reliquatISLR);
    }
    else if ((m_reliquatISLR != null) && (p_reliquatISLR != null) && (!p_reliquatISLR.equals(m_reliquatISLR)))
    {
      m_reliquatISLR = p_reliquatISLR;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatISLR(p_reliquatISLR);
    }
  }
  
  protected Integer rawGetReliquatDelaiAttente()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatDelaiAttente();
  }
  
  public Integer getReliquatDelaiAttente()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatDelaiAttente();
  }
  
  public void setReliquatDelaiAttente(Integer p_reliquatDelaiAttente)
  {
    if ((m_reliquatDelaiAttente == null) || (p_reliquatDelaiAttente == null))
    {
      m_reliquatDelaiAttente = p_reliquatDelaiAttente;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatDelaiAttente(p_reliquatDelaiAttente);
    }
    else if ((m_reliquatDelaiAttente != null) && (p_reliquatDelaiAttente != null) && (!p_reliquatDelaiAttente.equals(m_reliquatDelaiAttente)))
    {
      m_reliquatDelaiAttente = p_reliquatDelaiAttente;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatDelaiAttente(p_reliquatDelaiAttente);
    }
  }
  
  protected boolean rawIsDelaiAttenteEntame()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).isDelaiAttenteEntame();
  }
  
  public boolean isDelaiAttenteEntame()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).isDelaiAttenteEntame();
  }
  
  public void setDelaiAttenteEntame(boolean p_delaiAttenteEntame)
  {
    ((EtatAuDernierJourAvantPC)getPC()).setDelaiAttenteEntame(p_delaiAttenteEntame);
  }
  
  protected int rawGetEtat()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getEtat();
  }
  
  public int getEtat()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getEtat();
  }
  
  public void setEtat(int p_etat)
  {
    ((EtatAuDernierJourAvantPC)getPC()).setEtat(p_etat);
  }
  
  protected Periode rawGetPeriodeApplicationPMC()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationPMC();
  }
  
  public Periode getPeriodeApplicationPMC()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationPMC();
  }
  
  public void setPeriodeApplicationPMC(Periode p_periodeApplicationPMC)
  {
    if ((m_periodeApplicationPMC == null) || (p_periodeApplicationPMC == null))
    {
      m_periodeApplicationPMC = p_periodeApplicationPMC;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationPMC(p_periodeApplicationPMC);
    }
    else if ((m_periodeApplicationPMC != null) && (p_periodeApplicationPMC != null) && (!p_periodeApplicationPMC.equals(m_periodeApplicationPMC)))
    {
      m_periodeApplicationPMC = p_periodeApplicationPMC;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationPMC(p_periodeApplicationPMC);
    }
  }
  
  protected Periode rawGetPeriodeApplicationICCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationICCP();
  }
  
  public Periode getPeriodeApplicationICCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationICCP();
  }
  
  public void setPeriodeApplicationICCP(Periode p_periodeApplicationICCP)
  {
    if ((m_periodeApplicationICCP == null) || (p_periodeApplicationICCP == null))
    {
      m_periodeApplicationICCP = p_periodeApplicationICCP;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationICCP(p_periodeApplicationICCP);
    }
    else if ((m_periodeApplicationICCP != null) && (p_periodeApplicationICCP != null) && (!p_periodeApplicationICCP.equals(m_periodeApplicationICCP)))
    {
      m_periodeApplicationICCP = p_periodeApplicationICCP;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationICCP(p_periodeApplicationICCP);
    }
  }
  
  protected Periode rawGetPeriodeApplicationISLR()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationISLR();
  }
  
  public Periode getPeriodeApplicationISLR()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationISLR();
  }
  
  public void setPeriodeApplicationISLR(Periode p_periodeApplicationISLR)
  {
    if ((m_periodeApplicationISLR == null) || (p_periodeApplicationISLR == null))
    {
      m_periodeApplicationISLR = p_periodeApplicationISLR;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationISLR(p_periodeApplicationISLR);
    }
    else if ((m_periodeApplicationISLR != null) && (p_periodeApplicationISLR != null) && (!p_periodeApplicationISLR.equals(m_periodeApplicationISLR)))
    {
      m_periodeApplicationISLR = p_periodeApplicationISLR;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationISLR(p_periodeApplicationISLR);
    }
  }
  
  protected Periode rawGetPeriodeApplicationDelaiAttente()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationDelaiAttente();
  }
  
  public Periode getPeriodeApplicationDelaiAttente()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationDelaiAttente();
  }
  
  public void setPeriodeApplicationDelaiAttente(Periode p_periodeApplicationDelaiAttente)
  {
    if ((m_periodeApplicationDelaiAttente == null) || (p_periodeApplicationDelaiAttente == null))
    {
      m_periodeApplicationDelaiAttente = p_periodeApplicationDelaiAttente;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationDelaiAttente(p_periodeApplicationDelaiAttente);
    }
    else if ((m_periodeApplicationDelaiAttente != null) && (p_periodeApplicationDelaiAttente != null) && (!p_periodeApplicationDelaiAttente.equals(m_periodeApplicationDelaiAttente)))
    {
      m_periodeApplicationDelaiAttente = p_periodeApplicationDelaiAttente;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationDelaiAttente(p_periodeApplicationDelaiAttente);
    }
  }
  
  protected Integer rawGetDureeInitialePMC()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialePMC();
  }
  
  public Integer getDureeInitialePMC()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialePMC();
  }
  
  public void setDureeInitialePMC(Integer p_dureeInitialePMC)
  {
    if ((m_dureeInitialePMC == null) || (p_dureeInitialePMC == null))
    {
      m_dureeInitialePMC = p_dureeInitialePMC;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialePMC(p_dureeInitialePMC);
    }
    else if ((m_dureeInitialePMC != null) && (p_dureeInitialePMC != null) && (!p_dureeInitialePMC.equals(m_dureeInitialePMC)))
    {
      m_dureeInitialePMC = p_dureeInitialePMC;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialePMC(p_dureeInitialePMC);
    }
  }
  
  protected Integer rawGetDureeInitialeICCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeICCP();
  }
  
  public Integer getDureeInitialeICCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeICCP();
  }
  
  public void setDureeInitialeICCP(Integer p_dureeInitialeICCP)
  {
    if ((m_dureeInitialeICCP == null) || (p_dureeInitialeICCP == null))
    {
      m_dureeInitialeICCP = p_dureeInitialeICCP;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeICCP(p_dureeInitialeICCP);
    }
    else if ((m_dureeInitialeICCP != null) && (p_dureeInitialeICCP != null) && (!p_dureeInitialeICCP.equals(m_dureeInitialeICCP)))
    {
      m_dureeInitialeICCP = p_dureeInitialeICCP;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeICCP(p_dureeInitialeICCP);
    }
  }
  
  protected Integer rawGetDureeInitialeISLR()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeISLR();
  }
  
  public Integer getDureeInitialeISLR()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeISLR();
  }
  
  public void setDureeInitialeISLR(Integer p_dureeInitialeISLR)
  {
    if ((m_dureeInitialeISLR == null) || (p_dureeInitialeISLR == null))
    {
      m_dureeInitialeISLR = p_dureeInitialeISLR;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeISLR(p_dureeInitialeISLR);
    }
    else if ((m_dureeInitialeISLR != null) && (p_dureeInitialeISLR != null) && (!p_dureeInitialeISLR.equals(m_dureeInitialeISLR)))
    {
      m_dureeInitialeISLR = p_dureeInitialeISLR;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeISLR(p_dureeInitialeISLR);
    }
  }
  
  protected Integer rawGetDureeInitialeDelaiAttente()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeDelaiAttente();
  }
  
  public Integer getDureeInitialeDelaiAttente()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeDelaiAttente();
  }
  
  public void setDureeInitialeDelaiAttente(Integer p_dureeInitialeDelaiAttente)
  {
    if ((m_dureeInitialeDelaiAttente == null) || (p_dureeInitialeDelaiAttente == null))
    {
      m_dureeInitialeDelaiAttente = p_dureeInitialeDelaiAttente;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeDelaiAttente(p_dureeInitialeDelaiAttente);
    }
    else if ((m_dureeInitialeDelaiAttente != null) && (p_dureeInitialeDelaiAttente != null) && (!p_dureeInitialeDelaiAttente.equals(m_dureeInitialeDelaiAttente)))
    {
      m_dureeInitialeDelaiAttente = p_dureeInitialeDelaiAttente;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeDelaiAttente(p_dureeInitialeDelaiAttente);
    }
  }
  
  protected Periode rawGetPeriodePECEvenementReducteur()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodePECEvenementReducteur();
  }
  
  public Periode getPeriodePECEvenementReducteur()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodePECEvenementReducteur();
  }
  
  public void setPeriodePECEvenementReducteur(Periode p_periodePECEvenementReducteur)
  {
    if ((m_periodePECEvenementReducteur == null) || (p_periodePECEvenementReducteur == null))
    {
      m_periodePECEvenementReducteur = p_periodePECEvenementReducteur;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodePECEvenementReducteur(p_periodePECEvenementReducteur);
    }
    else if ((m_periodePECEvenementReducteur != null) && (p_periodePECEvenementReducteur != null) && (!p_periodePECEvenementReducteur.equals(m_periodePECEvenementReducteur)))
    {
      m_periodePECEvenementReducteur = p_periodePECEvenementReducteur;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodePECEvenementReducteur(p_periodePECEvenementReducteur);
    }
  }
  
  protected Integer rawGetReliquatCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatCP();
  }
  
  public Integer getReliquatCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatCP();
  }
  
  public void setReliquatCP(Integer p_reliquatCP)
  {
    if ((m_reliquatCP == null) || (p_reliquatCP == null))
    {
      m_reliquatCP = p_reliquatCP;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatCP(p_reliquatCP);
    }
    else if ((m_reliquatCP != null) && (p_reliquatCP != null) && (!p_reliquatCP.equals(m_reliquatCP)))
    {
      m_reliquatCP = p_reliquatCP;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatCP(p_reliquatCP);
    }
  }
  
  protected Integer rawGetReliquatSalaire()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatSalaire();
  }
  
  public Integer getReliquatSalaire()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getReliquatSalaire();
  }
  
  public void setReliquatSalaire(Integer p_reliquatSalaire)
  {
    if ((m_reliquatSalaire == null) || (p_reliquatSalaire == null))
    {
      m_reliquatSalaire = p_reliquatSalaire;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatSalaire(p_reliquatSalaire);
    }
    else if ((m_reliquatSalaire != null) && (p_reliquatSalaire != null) && (!p_reliquatSalaire.equals(m_reliquatSalaire)))
    {
      m_reliquatSalaire = p_reliquatSalaire;
      ((EtatAuDernierJourAvantPC)getPC()).setReliquatSalaire(p_reliquatSalaire);
    }
  }
  
  protected Integer rawGetDureeInitialeCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeCP();
  }
  
  public Integer getDureeInitialeCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeCP();
  }
  
  public void setDureeInitialeCP(Integer p_dureeInitialeCP)
  {
    if ((m_dureeInitialeCP == null) || (p_dureeInitialeCP == null))
    {
      m_dureeInitialeCP = p_dureeInitialeCP;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeCP(p_dureeInitialeCP);
    }
    else if ((m_dureeInitialeCP != null) && (p_dureeInitialeCP != null) && (!p_dureeInitialeCP.equals(m_dureeInitialeCP)))
    {
      m_dureeInitialeCP = p_dureeInitialeCP;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeCP(p_dureeInitialeCP);
    }
  }
  
  protected Integer rawGetDureeInitialeSalaire()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeSalaire();
  }
  
  public Integer getDureeInitialeSalaire()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getDureeInitialeSalaire();
  }
  
  public void setDureeInitialeSalaire(Integer p_dureeInitialeSalaire)
  {
    if ((m_dureeInitialeSalaire == null) || (p_dureeInitialeSalaire == null))
    {
      m_dureeInitialeSalaire = p_dureeInitialeSalaire;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeSalaire(p_dureeInitialeSalaire);
    }
    else if ((m_dureeInitialeSalaire != null) && (p_dureeInitialeSalaire != null) && (!p_dureeInitialeSalaire.equals(m_dureeInitialeSalaire)))
    {
      m_dureeInitialeSalaire = p_dureeInitialeSalaire;
      ((EtatAuDernierJourAvantPC)getPC()).setDureeInitialeSalaire(p_dureeInitialeSalaire);
    }
  }
  
  protected Periode rawGetPeriodeApplicationCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationCP();
  }
  
  public Periode getPeriodeApplicationCP()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationCP();
  }
  
  public void setPeriodeApplicationCP(Periode p_periodeApplicationCP)
  {
    if ((m_periodeApplicationCP == null) || (p_periodeApplicationCP == null))
    {
      m_periodeApplicationCP = p_periodeApplicationCP;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationCP(p_periodeApplicationCP);
    }
    else if ((m_periodeApplicationCP != null) && (p_periodeApplicationCP != null) && (!p_periodeApplicationCP.equals(m_periodeApplicationCP)))
    {
      m_periodeApplicationCP = p_periodeApplicationCP;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationCP(p_periodeApplicationCP);
    }
  }
  
  protected Periode rawGetPeriodeApplicationSalaire()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationSalaire();
  }
  
  public Periode getPeriodeApplicationSalaire()
  {
    return ((EtatAuDernierJourAvantPC)getPC()).getPeriodeApplicationSalaire();
  }
  
  public void setPeriodeApplicationSalaire(Periode p_periodeApplicationSalaire)
  {
    if ((m_periodeApplicationSalaire == null) || (p_periodeApplicationSalaire == null))
    {
      m_periodeApplicationSalaire = p_periodeApplicationSalaire;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationSalaire(p_periodeApplicationSalaire);
    }
    else if ((m_periodeApplicationSalaire != null) && (p_periodeApplicationSalaire != null) && (!p_periodeApplicationSalaire.equals(m_periodeApplicationSalaire)))
    {
      m_periodeApplicationSalaire = p_periodeApplicationSalaire;
      ((EtatAuDernierJourAvantPC)getPC()).setPeriodeApplicationSalaire(p_periodeApplicationSalaire);
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
 * Qualified Name:     EtatAuDernierJourAvantGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.pc.EtatAuDjiPC;
import fr.unedic.cali.dom.MontantBaseAbstrait;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public abstract class EtatAuDjiGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_etatAuDjiPC;
  private MontantBaseAbstrait m_montant;
  private Periode m_periodePECEvenementReducteur;
  private Damj m_dateEpuisementDuree;
  private BigDecimal m_montantAidePaye;
  private BigDecimal m_montantAidePayeDerog;
  private Integer m_reliquatFCP;
  private Integer m_reliquatFS;
  private Integer m_reportReliquatFCP;
  private Integer m_reportReliquatFS;
  private Integer m_reliquatDA;
  private Periode m_periodeDA;
  private Integer m_reliquatMaxFCP;
  private Integer m_reliquatMaxFS;
  
  public EtatAuDjiGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public EtatAuDjiGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new EtatAuDjiPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_etatAuDjiPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_etatAuDjiPC)
  {
    m_etatAuDjiPC = p_etatAuDjiPC;
  }
  
  public MontantBaseAbstrait getMontant()
  {
    if (m_montant == null)
    {
      DomPCSpec montantPC = ((EtatAuDjiPC)getPC()).getMontant();
      if (montantPC != null) {
        m_montant = ((MontantBaseAbstrait)montantPC.createOM());
      }
    }
    return m_montant;
  }
  
  public void setMontant(MontantBaseAbstrait p_montant)
  {
    if (p_montant == null)
    {
      ((EtatAuDjiPC)getPC()).setMontant(null);
      m_montant = p_montant;
    }
    else if (!p_montant.equals(m_montant))
    {
      ((EtatAuDjiPC)getPC()).setMontant(p_montant.getPC());
      m_montant = p_montant;
    }
  }
  
  protected boolean rawIsEstFigee()
  {
    return ((EtatAuDjiPC)getPC()).isEstFigee();
  }
  
  public boolean isEstFigee()
  {
    return ((EtatAuDjiPC)getPC()).isEstFigee();
  }
  
  public void setEstFigee(boolean p_estFigee)
  {
    ((EtatAuDjiPC)getPC()).setEstFigee(p_estFigee);
  }
  
  protected Periode rawGetPeriodePECEvenementReducteur()
  {
    return ((EtatAuDjiPC)getPC()).getPeriodePECEvenementReducteur();
  }
  
  public Periode getPeriodePECEvenementReducteur()
  {
    return ((EtatAuDjiPC)getPC()).getPeriodePECEvenementReducteur();
  }
  
  public void setPeriodePECEvenementReducteur(Periode p_periodePECEvenementReducteur)
  {
    if ((m_periodePECEvenementReducteur == null) || (p_periodePECEvenementReducteur == null))
    {
      m_periodePECEvenementReducteur = p_periodePECEvenementReducteur;
      ((EtatAuDjiPC)getPC()).setPeriodePECEvenementReducteur(p_periodePECEvenementReducteur);
    }
    else if ((m_periodePECEvenementReducteur != null) && (p_periodePECEvenementReducteur != null) && (!p_periodePECEvenementReducteur.equals(m_periodePECEvenementReducteur)))
    {
      m_periodePECEvenementReducteur = p_periodePECEvenementReducteur;
      ((EtatAuDjiPC)getPC()).setPeriodePECEvenementReducteur(p_periodePECEvenementReducteur);
    }
  }
  
  protected int rawGetCumulJoursIndemnise()
  {
    return ((EtatAuDjiPC)getPC()).getCumulJoursIndemnise();
  }
  
  public int getCumulJoursIndemnise()
  {
    return ((EtatAuDjiPC)getPC()).getCumulJoursIndemnise();
  }
  
  public void setCumulJoursIndemnise(int p_cumulJoursIndemnise)
  {
    ((EtatAuDjiPC)getPC()).setCumulJoursIndemnise(p_cumulJoursIndemnise);
  }
  
  protected int rawGetCumulMoisnonIndemnise()
  {
    return ((EtatAuDjiPC)getPC()).getCumulMoisnonIndemnise();
  }
  
  public int getCumulMoisnonIndemnise()
  {
    return ((EtatAuDjiPC)getPC()).getCumulMoisnonIndemnise();
  }
  
  public void setCumulMoisnonIndemnise(int p_cumulMoisnonIndemnise)
  {
    ((EtatAuDjiPC)getPC()).setCumulMoisnonIndemnise(p_cumulMoisnonIndemnise);
  }
  
  protected int rawGetCumulNbJourAct()
  {
    return ((EtatAuDjiPC)getPC()).getCumulNbJourAct();
  }
  
  public int getCumulNbJourAct()
  {
    return ((EtatAuDjiPC)getPC()).getCumulNbJourAct();
  }
  
  public void setCumulNbJourAct(int p_cumulNbJourAct)
  {
    ((EtatAuDjiPC)getPC()).setCumulNbJourAct(p_cumulNbJourAct);
  }
  
  protected Damj rawGetDateEpuisementDuree()
  {
    return ((EtatAuDjiPC)getPC()).getDateEpuisementDuree();
  }
  
  public Damj getDateEpuisementDuree()
  {
    return ((EtatAuDjiPC)getPC()).getDateEpuisementDuree();
  }
  
  public void setDateEpuisementDuree(Damj p_dateEpuisementDuree)
  {
    if ((m_dateEpuisementDuree == null) || (p_dateEpuisementDuree == null))
    {
      m_dateEpuisementDuree = p_dateEpuisementDuree;
      ((EtatAuDjiPC)getPC()).setDateEpuisementDuree(p_dateEpuisementDuree);
    }
    else if ((m_dateEpuisementDuree != null) && (p_dateEpuisementDuree != null) && (!p_dateEpuisementDuree.equals(m_dateEpuisementDuree)))
    {
      m_dateEpuisementDuree = p_dateEpuisementDuree;
      ((EtatAuDjiPC)getPC()).setDateEpuisementDuree(p_dateEpuisementDuree);
    }
  }
  
  protected BigDecimal rawGetMontantAidePaye()
  {
    return ((EtatAuDjiPC)getPC()).getMontantAidePaye();
  }
  
  public BigDecimal getMontantAidePaye()
  {
    return ((EtatAuDjiPC)getPC()).getMontantAidePaye();
  }
  
  public void setMontantAidePaye(BigDecimal p_montantAidePaye)
  {
    if ((m_montantAidePaye == null) || (p_montantAidePaye == null))
    {
      m_montantAidePaye = p_montantAidePaye;
      ((EtatAuDjiPC)getPC()).setMontantAidePaye(p_montantAidePaye);
    }
    else if ((m_montantAidePaye != null) && (p_montantAidePaye != null) && (!p_montantAidePaye.equals(m_montantAidePaye)))
    {
      m_montantAidePaye = p_montantAidePaye;
      ((EtatAuDjiPC)getPC()).setMontantAidePaye(p_montantAidePaye);
    }
  }
  
  protected BigDecimal rawGetMontantAidePayeDerog()
  {
    return ((EtatAuDjiPC)getPC()).getMontantAidePayeDerog();
  }
  
  public BigDecimal getMontantAidePayeDerog()
  {
    return ((EtatAuDjiPC)getPC()).getMontantAidePayeDerog();
  }
  
  public void setMontantAidePayeDerog(BigDecimal p_montantAidePayeDerog)
  {
    if ((m_montantAidePayeDerog == null) || (p_montantAidePayeDerog == null))
    {
      m_montantAidePayeDerog = p_montantAidePayeDerog;
      ((EtatAuDjiPC)getPC()).setMontantAidePayeDerog(p_montantAidePayeDerog);
    }
    else if ((m_montantAidePayeDerog != null) && (p_montantAidePayeDerog != null) && (!p_montantAidePayeDerog.equals(m_montantAidePayeDerog)))
    {
      m_montantAidePayeDerog = p_montantAidePayeDerog;
      ((EtatAuDjiPC)getPC()).setMontantAidePayeDerog(p_montantAidePayeDerog);
    }
  }
  
  protected Integer rawGetReliquatFCP()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatFCP();
  }
  
  public Integer getReliquatFCP()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatFCP();
  }
  
  public void setReliquatFCP(Integer p_reliquatFCP)
  {
    if ((m_reliquatFCP == null) || (p_reliquatFCP == null))
    {
      m_reliquatFCP = p_reliquatFCP;
      ((EtatAuDjiPC)getPC()).setReliquatFCP(p_reliquatFCP);
    }
    else if ((m_reliquatFCP != null) && (p_reliquatFCP != null) && (!p_reliquatFCP.equals(m_reliquatFCP)))
    {
      m_reliquatFCP = p_reliquatFCP;
      ((EtatAuDjiPC)getPC()).setReliquatFCP(p_reliquatFCP);
    }
  }
  
  protected Integer rawGetReliquatFS()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatFS();
  }
  
  public Integer getReliquatFS()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatFS();
  }
  
  public void setReliquatFS(Integer p_reliquatFS)
  {
    if ((m_reliquatFS == null) || (p_reliquatFS == null))
    {
      m_reliquatFS = p_reliquatFS;
      ((EtatAuDjiPC)getPC()).setReliquatFS(p_reliquatFS);
    }
    else if ((m_reliquatFS != null) && (p_reliquatFS != null) && (!p_reliquatFS.equals(m_reliquatFS)))
    {
      m_reliquatFS = p_reliquatFS;
      ((EtatAuDjiPC)getPC()).setReliquatFS(p_reliquatFS);
    }
  }
  
  protected Integer rawGetReportReliquatFCP()
  {
    return ((EtatAuDjiPC)getPC()).getReportRlqFCP();
  }
  
  public Integer getReportReliquatFCP()
  {
    return ((EtatAuDjiPC)getPC()).getReportRlqFCP();
  }
  
  public void setReportReliquatFCP(Integer p_reportReliquatFCP)
  {
    if ((m_reportReliquatFCP == null) || (p_reportReliquatFCP == null))
    {
      m_reportReliquatFCP = p_reportReliquatFCP;
      ((EtatAuDjiPC)getPC()).setReportRlqFCP(p_reportReliquatFCP);
    }
    else if ((m_reportReliquatFCP != null) && (p_reportReliquatFCP != null) && (!p_reportReliquatFCP.equals(m_reportReliquatFCP)))
    {
      m_reportReliquatFCP = p_reportReliquatFCP;
      ((EtatAuDjiPC)getPC()).setReportRlqFCP(p_reportReliquatFCP);
    }
  }
  
  protected Integer rawGetReportReliquatFS()
  {
    return ((EtatAuDjiPC)getPC()).getReportRlqFS();
  }
  
  public Integer getReportReliquatFS()
  {
    return ((EtatAuDjiPC)getPC()).getReportRlqFS();
  }
  
  public void setReportReliquatFS(Integer p_reportReliquatFS)
  {
    if ((m_reportReliquatFS == null) || (p_reportReliquatFS == null))
    {
      m_reportReliquatFS = p_reportReliquatFS;
      ((EtatAuDjiPC)getPC()).setReportRlqFS(p_reportReliquatFS);
    }
    else if ((m_reportReliquatFS != null) && (p_reportReliquatFS != null) && (!p_reportReliquatFS.equals(m_reportReliquatFS)))
    {
      m_reportReliquatFS = p_reportReliquatFS;
      ((EtatAuDjiPC)getPC()).setReportRlqFS(p_reportReliquatFS);
    }
  }
  
  protected Integer rawGetReliquatDA()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatDA();
  }
  
  public Integer getReliquatDA()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatDA();
  }
  
  public void setReliquatDA(Integer p_reliquatDA)
  {
    if ((m_reliquatDA == null) || (p_reliquatDA == null))
    {
      m_reliquatDA = p_reliquatDA;
      ((EtatAuDjiPC)getPC()).setReliquatDA(p_reliquatDA);
    }
    else if ((m_reliquatDA != null) && (p_reliquatDA != null) && (!p_reliquatDA.equals(m_reliquatDA)))
    {
      m_reliquatDA = p_reliquatDA;
      ((EtatAuDjiPC)getPC()).setReliquatDA(p_reliquatDA);
    }
  }
  
  protected Periode rawGetPeriodeDA()
  {
    return ((EtatAuDjiPC)getPC()).getPeriodeDA();
  }
  
  public Periode getPeriodeDA()
  {
    return ((EtatAuDjiPC)getPC()).getPeriodeDA();
  }
  
  public void setPeriodeDA(Periode p_periodeDA)
  {
    if ((m_periodeDA == null) || (p_periodeDA == null))
    {
      m_periodeDA = p_periodeDA;
      ((EtatAuDjiPC)getPC()).setPeriodeDA(p_periodeDA);
    }
    else if ((m_periodeDA != null) && (p_periodeDA != null) && (!p_periodeDA.equals(m_periodeDA)))
    {
      m_periodeDA = p_periodeDA;
      ((EtatAuDjiPC)getPC()).setPeriodeDA(p_periodeDA);
    }
  }
  
  protected Integer rawGetReliquatMaxFCP()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatMaxFCP();
  }
  
  public Integer getReliquatMaxFCP()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatMaxFCP();
  }
  
  public void setReliquatMaxFCP(Integer p_reliquatMaxFCP)
  {
    if ((m_reliquatMaxFCP == null) || (p_reliquatMaxFCP == null))
    {
      m_reliquatMaxFCP = p_reliquatMaxFCP;
      ((EtatAuDjiPC)getPC()).setReliquatMaxFCP(p_reliquatMaxFCP);
    }
    else if ((m_reliquatMaxFCP != null) && (p_reliquatMaxFCP != null) && (!p_reliquatMaxFCP.equals(m_reliquatMaxFCP)))
    {
      m_reliquatMaxFCP = p_reliquatMaxFCP;
      ((EtatAuDjiPC)getPC()).setReliquatMaxFCP(p_reliquatMaxFCP);
    }
  }
  
  protected Integer rawGetReliquatMaxFS()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatMaxFS();
  }
  
  public Integer getReliquatMaxFS()
  {
    return ((EtatAuDjiPC)getPC()).getReliquatMaxFS();
  }
  
  public void setReliquatMaxFS(Integer p_reliquatMaxFS)
  {
    if ((m_reliquatMaxFS == null) || (p_reliquatMaxFS == null))
    {
      m_reliquatMaxFS = p_reliquatMaxFS;
      ((EtatAuDjiPC)getPC()).setReliquatMaxFS(p_reliquatMaxFS);
    }
    else if ((m_reliquatMaxFS != null) && (p_reliquatMaxFS != null) && (!p_reliquatMaxFS.equals(m_reliquatMaxFS)))
    {
      m_reliquatMaxFS = p_reliquatMaxFS;
      ((EtatAuDjiPC)getPC()).setReliquatMaxFS(p_reliquatMaxFS);
    }
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    Object montant = getMontant();
    if ((montant != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(montant))) {
      DomManager.supprimer(getMontant(), p_contexteSuppression);
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     EtatAuDjiGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
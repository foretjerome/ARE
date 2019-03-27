package fr.unedic.cali.dom;

import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnChargeSansFiltre;
import fr.unedic.cali.dom.gen.FormulaireAbstraitGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.OutilTrace;
import fr.unedic.cali.outilsfonctionnels.OutillagePEC;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.lang.reflect.Method;

public abstract class FormulaireAbstrait
  extends FormulaireAbstraitGen
  implements FormulaireSpec
{
  private transient boolean m_isDalNonRecevable;
  private transient Damj m_dateCreationDal;
  private transient String m_nomProduit;
  private transient String m_nomLigne;
  private transient String m_nomGamme;
  private transient String m_numeroSuivi;
  private transient boolean m_estEnvoiDalEffectue;
  private transient String m_motifEnvoi;
  
  public FormulaireAbstrait() {}
  
  public FormulaireAbstrait(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void setDateDepot(Damj p_dateDepot)
  {
    setDateEvenement(p_dateDepot);
  }
  
  public Damj getDateDepot()
  {
    return getDateEvenement();
  }
  
  public String getMotifEnvoi()
  {
    Class pcClass = getPC().getClass();
    Method getMotifEnvoi = null;
    try
    {
      getMotifEnvoi = pcClass.getMethod("getMotifEnvoi", new Class[0]);
    }
    catch (NoSuchMethodException e)
    {
      try
      {
        getMotifEnvoi = pcClass.getMethod("getMotifEnvoiFormulaireAsu", new Class[0]);
      }
      catch (NoSuchMethodException e2)
      {
        OutilTrace.ecrireTrace(Niveau.ERROR, new Object[] { "Le PC semble n'être ni un DemandePC ni un FormulaireAbstraitPC" }, e);
      }
    }
    String motifEnvoi = null;
    if (getMotifEnvoi != null) {
      try
      {
        motifEnvoi = (String)getMotifEnvoi.invoke(getPC(), new Object[0]);
      }
      catch (Exception e)
      {
        OutilTrace.ecrireTrace(Niveau.ERROR, new Object[] { "Erreur lors de l'invocation de la méthode ", getMotifEnvoi.getName(), " sur un objet de type ", pcClass.getName() }, e);
      }
    }
    return motifEnvoi;
  }
  
  public void setMotifEnvoi(String p_motifEnvoi)
  {
    if ((m_motifEnvoi == null) || (p_motifEnvoi == null))
    {
      m_motifEnvoi = p_motifEnvoi;
      setMotifEnvoiDansPC(p_motifEnvoi);
    }
    else if (!p_motifEnvoi.equals(m_motifEnvoi))
    {
      m_motifEnvoi = p_motifEnvoi;
      setMotifEnvoiDansPC(p_motifEnvoi);
    }
  }
  
  private void setMotifEnvoiDansPC(String p_motifEnvoi)
  {
    Class pcClass = getPC().getClass();
    Method setMotifEnvoi = null;
    try
    {
      setMotifEnvoi = pcClass.getMethod("setMotifEnvoi", new Class[] { String.class });
    }
    catch (NoSuchMethodException e)
    {
      try
      {
        setMotifEnvoi = pcClass.getMethod("setMotifEnvoiFormulaireAsu", new Class[] { String.class });
      }
      catch (NoSuchMethodException e1)
      {
        OutilTrace.ecrireTrace(Niveau.ERROR, new Object[] { "Le PC semble n'être ni un DemandePC ni un FormulaireAbstraitPC" }, e);
      }
    }
    if (setMotifEnvoi != null) {
      try
      {
        setMotifEnvoi.invoke(getPC(), new Object[] { p_motifEnvoi });
      }
      catch (Exception e)
      {
        StringBuffer message = new StringBuffer();
        message.append(setMotifEnvoi.getName());
        message.append(" sur un objet de type ");
        message.append(pcClass.getName());
        message.append(" avec le paramètre ");
        message.append(p_motifEnvoi);
        OutilTrace.ecrireTrace(Niveau.ERROR, new Object[] { "Erreur lors de l'invocation de la méthode ", setMotifEnvoi.getName(), " sur un objet de type ", pcClass.getName(), " avec le paramètre ", p_motifEnvoi }, e);
      }
    }
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreStore() {}
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    FormulaireAbstrait copie = (FormulaireAbstrait)p_copie;
    copie.setDateCreationDal(getDateCreationDal());
    copie.setMotifEnvoi(getMotifEnvoi());
    copie.setNomGamme(getNomGamme());
    copie.setNomLigne(getNomLigne());
    copie.setNomProduit(getNomProduit());
    copie.setNumeroSuivi(getNumeroSuivi());
    copie.setEstEnvoiDalEffectue(estEnvoiDalEffectue());
  }
  
  public void miseAjour(FormulaireAbstrait p_formulaire)
  {
    setEstEnvoiDalEffectue(p_formulaire.estEnvoiDalEffectue());
    if ((estEnvoiDalEffectue()) && ("S".equalsIgnoreCase(getDemande().getModeLiquidation()))) {
      getDemande().setModeLiquidation("C");
    }
    if (p_formulaire.getDateDepot() != null)
    {
      if (getDateDepot() != null)
      {
        if (p_formulaire.getDateDepot().compareTo(getDateDepot()) != 0) {
          setDateDepot(p_formulaire.getDateDepot());
        }
      }
      else {
        setDateDepot(p_formulaire.getDateDepot());
      }
    }
    else if (!"S".equalsIgnoreCase(getDemande().getModeLiquidation()))
    {
      setDalNonRecevable(true);
    }
    else
    {
      ObjetChronoPeriodePriseEnChargeSansFiltre periodePEC = OutillagePEC.getPeriodePEC(getDemande().getDemandeur(), getIdPec());
      if (periodePEC != null) {
        setDateDepot(periodePEC.getDateDebut());
      }
    }
    setDateCreationDal(p_formulaire.getDateCreationDal());
    setMotifEnvoi(p_formulaire.getMotifEnvoi());
    setNomGamme(p_formulaire.getNomGamme());
    setNomLigne(p_formulaire.getNomLigne());
    setNomProduit(p_formulaire.getNomProduit());
    setNumeroSuivi(p_formulaire.getNumeroSuivi());
  }
  
  public boolean estDalNonRecevable()
  {
    return m_isDalNonRecevable;
  }
  
  public void setDalNonRecevable(boolean p_isDalNonRecevable)
  {
    m_isDalNonRecevable = p_isDalNonRecevable;
  }
  
  public Damj getDateCreationDal()
  {
    return m_dateCreationDal;
  }
  
  public void setDateCreationDal(Damj p_dateCreationDal)
  {
    m_dateCreationDal = p_dateCreationDal;
  }
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public String getNomGamme()
  {
    return m_nomGamme;
  }
  
  public void setNomGamme(String p_nomGamme)
  {
    m_nomGamme = p_nomGamme;
  }
  
  public String getNomLigne()
  {
    return m_nomLigne;
  }
  
  public void setNomLigne(String p_nomLigne)
  {
    m_nomLigne = p_nomLigne;
  }
  
  public String getNomProduit()
  {
    return m_nomProduit;
  }
  
  public void setNomProduit(String p_nomProduit)
  {
    m_nomProduit = p_nomProduit;
  }
  
  public String getNumeroSuivi()
  {
    return m_numeroSuivi;
  }
  
  public void setNumeroSuivi(String p_numeroSuivi)
  {
    m_numeroSuivi = p_numeroSuivi;
  }
  
  public boolean estEnvoiDalEffectue()
  {
    return m_estEnvoiDalEffectue;
  }
  
  public void setEstEnvoiDalEffectue(boolean p_estEnvoiDalEffectue)
  {
    m_estEnvoiDalEffectue = p_estEnvoiDalEffectue;
  }
  
  protected boolean controlerFormulaire(FormulaireSpec p_formulaire)
  {
    boolean controlerFormulaire = true;
    if (getDemande().getDemandeur().getContexteExecution() == 1) {
      controlerFormulaire = false;
    } else if (p_formulaire == null) {
      try
      {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_CALI_FORMULAIRE_V1_NUL", new Object[] { getReferenceExterne() });
      }
      catch (CoucheLogiqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_CALI_FORMULAIRE_V1_NUL", e);
      }
    } else if (!p_formulaire.estType(getClass())) {
      try
      {
        GestionnaireErreur.getInstance().genererException("HG_PR_CALI_FORM_V1_INCOHERENT_AVEC_FORM_V2", new Object[] { getReferenceExterne() }, 3);
      }
      catch (CoucheLogiqueException e)
      {
        throw new ApplicativeRuntimeException("HG_PR_CALI_FORM_V1_INCOHERENT_AVEC_FORM_V2", e);
      }
    }
    return controlerFormulaire;
  }
  
  public int getReferenceExterneDemandeLiee()
  {
    return -1;
  }
}

/* Location:
 * Qualified Name:     FormulaireAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
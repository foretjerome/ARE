package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.calcul.dom.pc.ConstituantsIndemnisationPC;
import fr.unedic.cali.dom.CapitalIndemnisationAbstrait;
import fr.unedic.cali.dom.DureeDetectionMaintienAbstraite;
import fr.unedic.cali.dom.DureeFinancementAbstraite;
import fr.unedic.cali.dom.DureeIndemnisationAbstraite;
import fr.unedic.cali.dom.DureeNonIndemnisable;
import fr.unedic.cali.dom.DureeProlongationAbstraite;
import fr.unedic.cali.dom.DureeRenouvellementAbstraite;
import fr.unedic.cali.dom.RemboursementFraisIndemnisationAbstrait;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class ConstituantsIndemnisationGen
  implements DomGenSpec
{
  protected transient DomPCSpec m_constituantsIndemnisationPC;
  private String m_codeFormuleMontant = null;
  private DureeIndemnisationAbstraite m_dureeIndemnisation = null;
  private DureeRenouvellementAbstraite m_dureeRenouvellement = null;
  private DureeDetectionMaintienAbstraite m_dureeDetectionMaintien = null;
  private RemboursementFraisIndemnisationAbstrait m_fraisRemboursementIndemnisation = null;
  private DureeProlongationAbstraite m_dureeProlongation = null;
  private Quantite m_montantServi;
  public CapitalIndemnisationAbstrait m_capitalIndemnisation = null;
  public DureeFinancementAbstraite m_dureeFinancement = null;
  private Quantite m_montantIndemNonDerog;
  private Quantite m_montantIndemDerog;
  private Integer m_rangTranche;
  private Damj m_dateFinDispositifCSP;
  public Collection m_listeDureeNonIndemnisables;
  
  public ConstituantsIndemnisationGen(DomPCSpec p_pc)
  {
    setPC(p_pc);
  }
  
  public ConstituantsIndemnisationGen()
  {
    setPC(createPC());
  }
  
  protected DomPCSpec createPC()
  {
    return new ConstituantsIndemnisationPC();
  }
  
  public DomPCSpec getPC()
  {
    return m_constituantsIndemnisationPC;
  }
  
  public Object getGenericPC()
  {
    return getPC();
  }
  
  public void setPC(DomPCSpec p_constituantsIndemnisationPC)
  {
    m_constituantsIndemnisationPC = p_constituantsIndemnisationPC;
  }
  
  protected String rawGetCodeFormuleMontant()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getCodeFormuleMontant();
  }
  
  public String getCodeFormuleMontant()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getCodeFormuleMontant();
  }
  
  public void setCodeFormuleMontant(String p_codeFormuleMontant)
  {
    if ((m_codeFormuleMontant == null) || (p_codeFormuleMontant == null))
    {
      m_codeFormuleMontant = p_codeFormuleMontant;
      ((ConstituantsIndemnisationPC)getPC()).setCodeFormuleMontant(p_codeFormuleMontant);
    }
    else if ((m_codeFormuleMontant != null) && (p_codeFormuleMontant != null) && (!p_codeFormuleMontant.equals(m_codeFormuleMontant)))
    {
      m_codeFormuleMontant = p_codeFormuleMontant;
      ((ConstituantsIndemnisationPC)getPC()).setCodeFormuleMontant(p_codeFormuleMontant);
    }
  }
  
  public DureeIndemnisationAbstraite getDureeIndemnisation()
  {
    if (m_dureeIndemnisation == null)
    {
      DomPCSpec dureeIndemnisationPC = ((ConstituantsIndemnisationPC)getPC()).getDureeIndemnisation();
      if (dureeIndemnisationPC != null) {
        m_dureeIndemnisation = ((DureeIndemnisationAbstraite)dureeIndemnisationPC.createOM());
      }
    }
    return m_dureeIndemnisation;
  }
  
  public void setDureeIndemnisation(DureeIndemnisationAbstraite p_dureeIndemnisation)
  {
    if (p_dureeIndemnisation == null)
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeIndemnisation(null);
      m_dureeIndemnisation = p_dureeIndemnisation;
    }
    else if (!p_dureeIndemnisation.equals(m_dureeIndemnisation))
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeIndemnisation(p_dureeIndemnisation.getPC());
      m_dureeIndemnisation = p_dureeIndemnisation;
    }
  }
  
  public DureeRenouvellementAbstraite getDureeRenouvellement()
  {
    if (m_dureeRenouvellement == null)
    {
      DomPCSpec dureeRenouvellementPC = ((ConstituantsIndemnisationPC)getPC()).getDureeRenouvellement();
      if (dureeRenouvellementPC != null) {
        m_dureeRenouvellement = ((DureeRenouvellementAbstraite)dureeRenouvellementPC.createOM());
      }
    }
    return m_dureeRenouvellement;
  }
  
  public void setDureeRenouvellement(DureeRenouvellementAbstraite p_dureeRenouvellement)
  {
    if (p_dureeRenouvellement == null)
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeRenouvellement(null);
      m_dureeRenouvellement = p_dureeRenouvellement;
    }
    else if (!p_dureeRenouvellement.equals(m_dureeRenouvellement))
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeRenouvellement(p_dureeRenouvellement.getPC());
      m_dureeRenouvellement = p_dureeRenouvellement;
    }
  }
  
  public DureeDetectionMaintienAbstraite getDureeDetectionMaintien()
  {
    if (m_dureeDetectionMaintien == null)
    {
      DomPCSpec dureeDetectionMaintienPC = ((ConstituantsIndemnisationPC)getPC()).getDureeDetectionMaintien();
      if (dureeDetectionMaintienPC != null) {
        m_dureeDetectionMaintien = ((DureeDetectionMaintienAbstraite)dureeDetectionMaintienPC.createOM());
      }
    }
    return m_dureeDetectionMaintien;
  }
  
  public void setDureeDetectionMaintien(DureeDetectionMaintienAbstraite p_dureeDetectionMaintien)
  {
    if (p_dureeDetectionMaintien == null)
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeDetectionMaintien(null);
      m_dureeDetectionMaintien = p_dureeDetectionMaintien;
    }
    else if (!p_dureeDetectionMaintien.equals(m_dureeDetectionMaintien))
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeDetectionMaintien(p_dureeDetectionMaintien.getPC());
      m_dureeDetectionMaintien = p_dureeDetectionMaintien;
    }
  }
  
  public RemboursementFraisIndemnisationAbstrait getFraisRemboursementIndemnisation()
  {
    if (m_fraisRemboursementIndemnisation == null)
    {
      DomPCSpec fraisRemboursementIndemnisationPC = ((ConstituantsIndemnisationPC)getPC()).getFraisRemboursementIndemnisation();
      if (fraisRemboursementIndemnisationPC != null) {
        m_fraisRemboursementIndemnisation = ((RemboursementFraisIndemnisationAbstrait)fraisRemboursementIndemnisationPC.createOM());
      }
    }
    return m_fraisRemboursementIndemnisation;
  }
  
  public void setFraisRemboursementIndemnisation(RemboursementFraisIndemnisationAbstrait p_fraisRemboursementIndemnisation)
  {
    if (p_fraisRemboursementIndemnisation == null)
    {
      ((ConstituantsIndemnisationPC)getPC()).setFraisRemboursementIndemnisation(null);
      m_fraisRemboursementIndemnisation = p_fraisRemboursementIndemnisation;
    }
    else if (!p_fraisRemboursementIndemnisation.equals(m_fraisRemboursementIndemnisation))
    {
      ((ConstituantsIndemnisationPC)getPC()).setFraisRemboursementIndemnisation(p_fraisRemboursementIndemnisation.getPC());
      m_fraisRemboursementIndemnisation = p_fraisRemboursementIndemnisation;
    }
  }
  
  public DureeProlongationAbstraite getDureeProlongation()
  {
    if (m_dureeProlongation == null)
    {
      DomPCSpec dureeProlongationPC = ((ConstituantsIndemnisationPC)getPC()).getDureeProlongation();
      if (dureeProlongationPC != null) {
        m_dureeProlongation = ((DureeProlongationAbstraite)dureeProlongationPC.createOM());
      }
    }
    return m_dureeProlongation;
  }
  
  public void setDureeProlongation(DureeProlongationAbstraite p_dureeProlongation)
  {
    if (p_dureeProlongation == null)
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeProlongation(null);
      m_dureeProlongation = p_dureeProlongation;
    }
    else if (!p_dureeProlongation.equals(m_dureeProlongation))
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeProlongation(p_dureeProlongation.getPC());
      m_dureeProlongation = p_dureeProlongation;
    }
  }
  
  protected Quantite rawGetMontantServi()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getMontantServi();
  }
  
  public Quantite getMontantServi()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getMontantServi();
  }
  
  public void setMontantServi(Quantite p_montantServi)
  {
    if ((m_montantServi == null) || (p_montantServi == null))
    {
      m_montantServi = p_montantServi;
      ((ConstituantsIndemnisationPC)getPC()).setMontantServi(p_montantServi);
    }
    else if ((m_montantServi != null) && (p_montantServi != null) && (!p_montantServi.equals(m_montantServi)))
    {
      m_montantServi = p_montantServi;
      ((ConstituantsIndemnisationPC)getPC()).setMontantServi(p_montantServi);
    }
  }
  
  public CapitalIndemnisationAbstrait getCapitalIndemnisation()
  {
    if (m_capitalIndemnisation == null)
    {
      DomPCSpec capitalIndemnisationPC = ((ConstituantsIndemnisationPC)getPC()).getCapitalIndemnisation();
      if (capitalIndemnisationPC != null) {
        m_capitalIndemnisation = ((CapitalIndemnisationAbstrait)capitalIndemnisationPC.createOM());
      }
    }
    return m_capitalIndemnisation;
  }
  
  public void setCapitalIndemnisation(CapitalIndemnisationAbstrait p_capitalIndemnisation)
  {
    if (p_capitalIndemnisation == null)
    {
      ((ConstituantsIndemnisationPC)getPC()).setCapitalIndemnisation(null);
      m_capitalIndemnisation = p_capitalIndemnisation;
    }
    else if (!p_capitalIndemnisation.equals(m_capitalIndemnisation))
    {
      ((ConstituantsIndemnisationPC)getPC()).setCapitalIndemnisation(p_capitalIndemnisation.getPC());
      m_capitalIndemnisation = p_capitalIndemnisation;
    }
  }
  
  public DureeFinancementAbstraite getDureeFinancement()
  {
    if (m_dureeFinancement == null)
    {
      DomPCSpec dureeFinancementPC = ((ConstituantsIndemnisationPC)getPC()).getDureeFinancement();
      if (dureeFinancementPC != null) {
        m_dureeFinancement = ((DureeFinancementAbstraite)dureeFinancementPC.createOM());
      }
    }
    return m_dureeFinancement;
  }
  
  public void setDureeFinancement(DureeFinancementAbstraite p_dureeFinancement)
  {
    if (p_dureeFinancement == null)
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeFinancement(null);
      m_dureeFinancement = p_dureeFinancement;
    }
    else if (!p_dureeFinancement.equals(m_dureeFinancement))
    {
      ((ConstituantsIndemnisationPC)getPC()).setDureeFinancement(p_dureeFinancement.getPC());
      m_dureeFinancement = p_dureeFinancement;
    }
  }
  
  protected Quantite rawGetMontantIndemNonDerog()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getMontantIndemNonDerog();
  }
  
  public Quantite getMontantIndemNonDerog()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getMontantIndemNonDerog();
  }
  
  public void setMontantIndemNonDerog(Quantite p_montantIndemNonDerog)
  {
    if ((m_montantIndemNonDerog == null) || (p_montantIndemNonDerog == null))
    {
      m_montantIndemNonDerog = p_montantIndemNonDerog;
      ((ConstituantsIndemnisationPC)getPC()).setMontantIndemNonDerog(p_montantIndemNonDerog);
    }
    else if ((m_montantIndemNonDerog != null) && (p_montantIndemNonDerog != null) && (!p_montantIndemNonDerog.equals(m_montantIndemNonDerog)))
    {
      m_montantIndemNonDerog = p_montantIndemNonDerog;
      ((ConstituantsIndemnisationPC)getPC()).setMontantIndemNonDerog(p_montantIndemNonDerog);
    }
  }
  
  protected Quantite rawGetMontantIndemDerog()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getMontantIndemDerog();
  }
  
  public Quantite getMontantIndemDerog()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getMontantIndemDerog();
  }
  
  public void setMontantIndemDerog(Quantite p_montantIndemDerog)
  {
    if ((m_montantIndemDerog == null) || (p_montantIndemDerog == null))
    {
      m_montantIndemDerog = p_montantIndemDerog;
      ((ConstituantsIndemnisationPC)getPC()).setMontantIndemDerog(p_montantIndemDerog);
    }
    else if ((m_montantIndemDerog != null) && (p_montantIndemDerog != null) && (!p_montantIndemDerog.equals(m_montantIndemDerog)))
    {
      m_montantIndemDerog = p_montantIndemDerog;
      ((ConstituantsIndemnisationPC)getPC()).setMontantIndemDerog(p_montantIndemDerog);
    }
  }
  
  protected Integer rawGetRangTranche()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getRangTranche();
  }
  
  public Integer getRangTranche()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getRangTranche();
  }
  
  public void setRangTranche(Integer p_rangTranche)
  {
    if ((m_rangTranche == null) || (p_rangTranche == null))
    {
      m_rangTranche = p_rangTranche;
      ((ConstituantsIndemnisationPC)getPC()).setRangTranche(p_rangTranche);
    }
    else if ((m_rangTranche != null) && (p_rangTranche != null) && (!p_rangTranche.equals(m_rangTranche)))
    {
      m_rangTranche = p_rangTranche;
      ((ConstituantsIndemnisationPC)getPC()).setRangTranche(p_rangTranche);
    }
  }
  
  protected Damj rawGetDateFinDispositifCSP()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getDateFinDispositifCSP();
  }
  
  public Damj getDateFinDispositifCSP()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getDateFinDispositifCSP();
  }
  
  public void setDateFinDispositifCSP(Damj p_dateFinDispositifCSP)
  {
    if ((m_dateFinDispositifCSP == null) || (p_dateFinDispositifCSP == null))
    {
      m_dateFinDispositifCSP = p_dateFinDispositifCSP;
      ((ConstituantsIndemnisationPC)getPC()).setDateFinDispositifCSP(p_dateFinDispositifCSP);
    }
    else if ((m_dateFinDispositifCSP != null) && (p_dateFinDispositifCSP != null) && (!p_dateFinDispositifCSP.equals(m_dateFinDispositifCSP)))
    {
      m_dateFinDispositifCSP = p_dateFinDispositifCSP;
      ((ConstituantsIndemnisationPC)getPC()).setDateFinDispositifCSP(p_dateFinDispositifCSP);
    }
  }
  
  protected int rawGetCumulTotalAllongementAREF()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getCumulTotalAllongementAREF();
  }
  
  public int getCumulTotalAllongementAREF()
  {
    return ((ConstituantsIndemnisationPC)getPC()).getCumulTotalAllongementAREF();
  }
  
  public void setCumulTotalAllongementAREF(int p_cumulTotalAllongementAREF)
  {
    ((ConstituantsIndemnisationPC)getPC()).setCumulTotalAllongementAREF(p_cumulTotalAllongementAREF);
  }
  
  private final Collection getCollectionModifiableListeDureeNonIndemnisables()
  {
    Iterator itCollectionPC;
    if (m_listeDureeNonIndemnisables == null)
    {
      m_listeDureeNonIndemnisables = new ArrayList();
      for (itCollectionPC = ((ConstituantsIndemnisationPC)getPC()).getCollectionListeDureeNonIndemnisables().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_listeDureeNonIndemnisables.add(currentOM);
      }
    }
    return m_listeDureeNonIndemnisables;
  }
  
  public Collection getCollectionListeDureeNonIndemnisables()
  {
    return Collections.unmodifiableCollection(getCollectionModifiableListeDureeNonIndemnisables());
  }
  
  public List getListListeDureeNonIndemnisables()
  {
    return Collections.unmodifiableList((List)getCollectionModifiableListeDureeNonIndemnisables());
  }
  
  public void remplacerCollectionListeDureeNonIndemnisables(Collection p_collectionACopier)
  {
    clearCollectionListeDureeNonIndemnisables();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      DureeNonIndemnisable objet = (DureeNonIndemnisable)i.next();
      ajouterListeDureeNonIndemnisables(objet);
    }
  }
  
  public void supprimerSousCollectionListeDureeNonIndemnisables(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      DureeNonIndemnisable objet = (DureeNonIndemnisable)i.next();
      supprimerListeDureeNonIndemnisables(objet);
    }
  }
  
  public void ajouterListeDureeNonIndemnisables(DureeNonIndemnisable p_dureeNonIndemnisables)
    throws NullPointerException
  {
    if (p_dureeNonIndemnisables == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_dureeNonIndemnisables ne devrait pas être nul.", p_dureeNonIndemnisables);
    }
    getCollectionModifiableListeDureeNonIndemnisables().add(p_dureeNonIndemnisables);
    ((ConstituantsIndemnisationPC)getPC()).ajouterListeDureeNonIndemnisables(p_dureeNonIndemnisables.getPC());
  }
  
  public void supprimerListeDureeNonIndemnisables(DureeNonIndemnisable p_dureeNonIndemnisables)
    throws NullPointerException
  {
    if (p_dureeNonIndemnisables == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_dureeNonIndemnisables ne devrait pas être nul.", p_dureeNonIndemnisables);
    }
    getCollectionModifiableListeDureeNonIndemnisables().remove(p_dureeNonIndemnisables);
    ((ConstituantsIndemnisationPC)getPC()).supprimerListeDureeNonIndemnisables(p_dureeNonIndemnisables.getPC());
  }
  
  public void recopierCollectionListeDureeNonIndemnisablesVers(ObjetMetierSpec p_copie)
  {
    ConstituantsIndemnisationGen copie = (ConstituantsIndemnisationGen)p_copie;
    Collection listeACopier = getCollectionListeDureeNonIndemnisables();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterListeDureeNonIndemnisables((DureeNonIndemnisable)objet);
    }
  }
  
  public void clearCollectionListeDureeNonIndemnisables()
  {
    getCollectionModifiableListeDureeNonIndemnisables().clear();
    ((ConstituantsIndemnisationPC)getPC()).getCollectionListeDureeNonIndemnisables().clear();
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    Object dureeIndemnisation = getDureeIndemnisation();
    if ((dureeIndemnisation != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(dureeIndemnisation))) {
      DomManager.supprimer(getDureeIndemnisation(), p_contexteSuppression);
    }
    Object dureeRenouvellement = getDureeRenouvellement();
    if ((dureeRenouvellement != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(dureeRenouvellement))) {
      DomManager.supprimer(getDureeRenouvellement(), p_contexteSuppression);
    }
    Object dureeDetectionMaintien = getDureeDetectionMaintien();
    if ((dureeDetectionMaintien != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(dureeDetectionMaintien))) {
      DomManager.supprimer(getDureeDetectionMaintien(), p_contexteSuppression);
    }
    Object fraisRemboursementIndemnisation = getFraisRemboursementIndemnisation();
    if ((fraisRemboursementIndemnisation != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(fraisRemboursementIndemnisation))) {
      DomManager.supprimer(getFraisRemboursementIndemnisation(), p_contexteSuppression);
    }
    Object dureeProlongation = getDureeProlongation();
    if ((dureeProlongation != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(dureeProlongation))) {
      DomManager.supprimer(getDureeProlongation(), p_contexteSuppression);
    }
    Object capitalIndemnisation = getCapitalIndemnisation();
    if ((capitalIndemnisation != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(capitalIndemnisation))) {
      DomManager.supprimer(getCapitalIndemnisation(), p_contexteSuppression);
    }
    Object dureeFinancement = getDureeFinancement();
    if ((dureeFinancement != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(dureeFinancement))) {
      DomManager.supprimer(getDureeFinancement(), p_contexteSuppression);
    }
    for (Iterator iter = getCollectionListeDureeNonIndemnisables().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie) {}
}

/* Location:
 * Qualified Name:     ConstituantsIndemnisationGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
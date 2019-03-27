package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.Decalage;
import fr.unedic.cali.calcul.dom.EvenementFinQuantiteDroit;
import fr.unedic.cali.calcul.dom.pc.UniteTraitementPC;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.ObjetChronoPeriodeCREM;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class UniteTraitementGen
  extends ObjetChronoPeriodeCREM
  implements DomGenSpec
{
  private ConstituantsCalculActiviteReduiteSpec m_constituantsCalculActiviteReduiteEnFinUT;
  private ConstituantsIndemnisation m_constituantsIndemnisationEnFinUT;
  private Decalage m_decalageEnFinUT;
  private String m_typeConstituantsCalculActiviteReduiteFinUT;
  private Collection m_collectionFinQuantiteDroit;
  
  public UniteTraitementGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public UniteTraitementGen() {}
  
  public UniteTraitementGen(Periode p_periode)
  {
    super(p_periode);
  }
  
  protected abstract DomPCSpec createPC();
  
  protected int rawGetNbJoursFormationEnFinDUT()
  {
    return ((UniteTraitementPC)getPC()).getNbJoursFormationEnFinDUT();
  }
  
  public int getNbJoursFormationEnFinDUT()
  {
    return ((UniteTraitementPC)getPC()).getNbJoursFormationEnFinDUT();
  }
  
  public void setNbJoursFormationEnFinDUT(int p_nbJoursFormationEnFinDUT)
  {
    ((UniteTraitementPC)getPC()).setNbJoursFormationEnFinDUT(p_nbJoursFormationEnFinDUT);
  }
  
  public ConstituantsCalculActiviteReduiteSpec getConstituantsCalculActiviteReduiteEnFinUT()
  {
    if (m_constituantsCalculActiviteReduiteEnFinUT == null)
    {
      DomPCSpec constituantsCalculActiviteReduiteEnFinUTPC = ((UniteTraitementPC)getPC()).getConstituantsCalculActiviteReduiteEnFinUT();
      if (constituantsCalculActiviteReduiteEnFinUTPC != null) {
        m_constituantsCalculActiviteReduiteEnFinUT = ((ConstituantsCalculActiviteReduiteSpec)constituantsCalculActiviteReduiteEnFinUTPC.createOM());
      }
    }
    return m_constituantsCalculActiviteReduiteEnFinUT;
  }
  
  public void setConstituantsCalculActiviteReduiteEnFinUT(ConstituantsCalculActiviteReduiteSpec p_constituantsCalculActiviteReduiteEnFinUT)
  {
    if (p_constituantsCalculActiviteReduiteEnFinUT == null)
    {
      ((UniteTraitementPC)getPC()).setConstituantsCalculActiviteReduiteEnFinUT(null);
      m_constituantsCalculActiviteReduiteEnFinUT = p_constituantsCalculActiviteReduiteEnFinUT;
    }
    else if (!p_constituantsCalculActiviteReduiteEnFinUT.equals(m_constituantsCalculActiviteReduiteEnFinUT))
    {
      ((UniteTraitementPC)getPC()).setConstituantsCalculActiviteReduiteEnFinUT(((DomGenSpec)p_constituantsCalculActiviteReduiteEnFinUT).getPC());
      m_constituantsCalculActiviteReduiteEnFinUT = p_constituantsCalculActiviteReduiteEnFinUT;
    }
  }
  
  public ConstituantsIndemnisation getConstituantsIndemnisationEnFinUT()
  {
    if (m_constituantsIndemnisationEnFinUT == null)
    {
      DomPCSpec constituantsIndemnisationEnFinUTPC = ((UniteTraitementPC)getPC()).getConstituantsIndemnisationEnFinUT();
      if (constituantsIndemnisationEnFinUTPC != null) {
        m_constituantsIndemnisationEnFinUT = ((ConstituantsIndemnisation)constituantsIndemnisationEnFinUTPC.createOM());
      }
    }
    return m_constituantsIndemnisationEnFinUT;
  }
  
  public void setConstituantsIndemnisationEnFinUT(ConstituantsIndemnisation p_constituantsIndemnisationEnFinUT)
  {
    if (p_constituantsIndemnisationEnFinUT == null)
    {
      ((UniteTraitementPC)getPC()).setConstituantsIndemnisationEnFinUT(null);
      m_constituantsIndemnisationEnFinUT = p_constituantsIndemnisationEnFinUT;
    }
    else if (!p_constituantsIndemnisationEnFinUT.equals(m_constituantsIndemnisationEnFinUT))
    {
      ((UniteTraitementPC)getPC()).setConstituantsIndemnisationEnFinUT(p_constituantsIndemnisationEnFinUT.getPC());
      m_constituantsIndemnisationEnFinUT = p_constituantsIndemnisationEnFinUT;
    }
  }
  
  public Decalage getDecalageEnFinUT()
  {
    if (m_decalageEnFinUT == null)
    {
      DomPCSpec decalageEnFinUTPC = ((UniteTraitementPC)getPC()).getDecalageEnFinUT();
      if (decalageEnFinUTPC != null) {
        m_decalageEnFinUT = ((Decalage)decalageEnFinUTPC.createOM());
      }
    }
    return m_decalageEnFinUT;
  }
  
  public void setDecalageEnFinUT(Decalage p_decalageEnFinUT)
  {
    if (p_decalageEnFinUT == null)
    {
      ((UniteTraitementPC)getPC()).setDecalageEnFinUT(null);
      m_decalageEnFinUT = p_decalageEnFinUT;
    }
    else if (!p_decalageEnFinUT.equals(m_decalageEnFinUT))
    {
      ((UniteTraitementPC)getPC()).setDecalageEnFinUT(p_decalageEnFinUT.getPC());
      m_decalageEnFinUT = p_decalageEnFinUT;
    }
  }
  
  protected boolean rawIsEstFigee()
  {
    return ((UniteTraitementPC)getPC()).isEstFigee();
  }
  
  public boolean isEstFigee()
  {
    return ((UniteTraitementPC)getPC()).isEstFigee();
  }
  
  public void setEstFigee(boolean p_estFigee)
  {
    ((UniteTraitementPC)getPC()).setEstFigee(p_estFigee);
  }
  
  protected int rawGetCumulJoursIndemnise()
  {
    return ((UniteTraitementPC)getPC()).getCumulJoursIndemnise();
  }
  
  public int getCumulJoursIndemnise()
  {
    return ((UniteTraitementPC)getPC()).getCumulJoursIndemnise();
  }
  
  public void setCumulJoursIndemnise(int p_cumulJoursIndemnise)
  {
    ((UniteTraitementPC)getPC()).setCumulJoursIndemnise(p_cumulJoursIndemnise);
  }
  
  protected boolean rawIsEstCumulJoursIndemnise()
  {
    return ((UniteTraitementPC)getPC()).isEstCumulJoursIndemnise();
  }
  
  public boolean isEstCumulJoursIndemnise()
  {
    return ((UniteTraitementPC)getPC()).isEstCumulJoursIndemnise();
  }
  
  public void setEstCumulJoursIndemnise(boolean p_estCumulJoursIndemnise)
  {
    ((UniteTraitementPC)getPC()).setEstCumulJoursIndemnise(p_estCumulJoursIndemnise);
  }
  
  protected int rawGetNbMoisIndemniseAsu()
  {
    return ((UniteTraitementPC)getPC()).getNbMoisIndemniseAsu();
  }
  
  public int getNbMoisIndemniseAsu()
  {
    return ((UniteTraitementPC)getPC()).getNbMoisIndemniseAsu();
  }
  
  public void setNbMoisIndemniseAsu(int p_nbMoisIndemniseAsu)
  {
    ((UniteTraitementPC)getPC()).setNbMoisIndemniseAsu(p_nbMoisIndemniseAsu);
  }
  
  protected boolean rawIsEstNbMoisIndemniseAsu()
  {
    return ((UniteTraitementPC)getPC()).isEstNbMoisIndemniseAsu();
  }
  
  public boolean isEstNbMoisIndemniseAsu()
  {
    return ((UniteTraitementPC)getPC()).isEstNbMoisIndemniseAsu();
  }
  
  public void setEstNbMoisIndemniseAsu(boolean p_estNbMoisIndemniseAsu)
  {
    ((UniteTraitementPC)getPC()).setEstNbMoisIndemniseAsu(p_estNbMoisIndemniseAsu);
  }
  
  protected String rawGetTypeConstituantsCalculActiviteReduiteFinUT()
  {
    return ((UniteTraitementPC)getPC()).getTypeConstituantsCalculActiviteReduiteFinUT();
  }
  
  public String getTypeConstituantsCalculActiviteReduiteFinUT()
  {
    return ((UniteTraitementPC)getPC()).getTypeConstituantsCalculActiviteReduiteFinUT();
  }
  
  public void setTypeConstituantsCalculActiviteReduiteFinUT(String p_typeConstituantsCalculActiviteReduiteFinUT)
  {
    if ((m_typeConstituantsCalculActiviteReduiteFinUT == null) || (p_typeConstituantsCalculActiviteReduiteFinUT == null))
    {
      m_typeConstituantsCalculActiviteReduiteFinUT = p_typeConstituantsCalculActiviteReduiteFinUT;
      ((UniteTraitementPC)getPC()).setTypeConstituantsCalculActiviteReduiteFinUT(p_typeConstituantsCalculActiviteReduiteFinUT);
    }
    else if ((m_typeConstituantsCalculActiviteReduiteFinUT != null) && (p_typeConstituantsCalculActiviteReduiteFinUT != null) && (!p_typeConstituantsCalculActiviteReduiteFinUT.equals(m_typeConstituantsCalculActiviteReduiteFinUT)))
    {
      m_typeConstituantsCalculActiviteReduiteFinUT = p_typeConstituantsCalculActiviteReduiteFinUT;
      ((UniteTraitementPC)getPC()).setTypeConstituantsCalculActiviteReduiteFinUT(p_typeConstituantsCalculActiviteReduiteFinUT);
    }
  }
  
  protected int rawGetCumulNbJourAct()
  {
    return ((UniteTraitementPC)getPC()).getCumulNbJourAct();
  }
  
  public int getCumulNbJourAct()
  {
    return ((UniteTraitementPC)getPC()).getCumulNbJourAct();
  }
  
  public void setCumulNbJourAct(int p_cumulNbJourAct)
  {
    ((UniteTraitementPC)getPC()).setCumulNbJourAct(p_cumulNbJourAct);
  }
  
  private final Collection getCollectionModifiableEvenementFinQuantiteDroit()
  {
    Iterator itCollectionPC;
    if (m_collectionFinQuantiteDroit == null)
    {
      m_collectionFinQuantiteDroit = new ArrayList();
      for (itCollectionPC = ((UniteTraitementPC)getPC()).getCollectionEvenementFinQuantiteDroit().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_collectionFinQuantiteDroit.add(currentOM);
      }
    }
    return m_collectionFinQuantiteDroit;
  }
  
  public Collection getCollectionEvenementFinQuantiteDroit()
  {
    return Collections.unmodifiableCollection(getCollectionModifiableEvenementFinQuantiteDroit());
  }
  
  public List getListEvenementFinQuantiteDroit()
  {
    return Collections.unmodifiableList((List)getCollectionModifiableEvenementFinQuantiteDroit());
  }
  
  public void remplacerCollectionEvenementFinQuantiteDroit(Collection p_collectionACopier)
  {
    clearCollectionEvenementFinQuantiteDroit();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      EvenementFinQuantiteDroit objet = (EvenementFinQuantiteDroit)i.next();
      ajouterEvenementFinQuantiteDroit(objet);
    }
  }
  
  public void supprimerSousCollectionEvenementFinQuantiteDroit(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      EvenementFinQuantiteDroit objet = (EvenementFinQuantiteDroit)i.next();
      supprimerEvenementFinQuantiteDroit(objet);
    }
  }
  
  public void ajouterEvenementFinQuantiteDroit(EvenementFinQuantiteDroit p_finQuantiteDroit)
    throws NullPointerException
  {
    if (p_finQuantiteDroit == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_finQuantiteDroit ne devrait pas être nul.", p_finQuantiteDroit);
    }
    getCollectionModifiableEvenementFinQuantiteDroit().add(p_finQuantiteDroit);
    ((UniteTraitementPC)getPC()).ajouterEvenementFinQuantiteDroit(p_finQuantiteDroit.getPC());
  }
  
  public void supprimerEvenementFinQuantiteDroit(EvenementFinQuantiteDroit p_finQuantiteDroit)
    throws NullPointerException
  {
    if (p_finQuantiteDroit == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_finQuantiteDroit ne devrait pas être nul.", p_finQuantiteDroit);
    }
    getCollectionModifiableEvenementFinQuantiteDroit().remove(p_finQuantiteDroit);
    ((UniteTraitementPC)getPC()).supprimerEvenementFinQuantiteDroit(p_finQuantiteDroit.getPC());
  }
  
  public void recopierCollectionEvenementFinQuantiteDroitVers(ObjetMetierSpec p_copie)
  {
    UniteTraitementGen copie = (UniteTraitementGen)p_copie;
    Collection listeACopier = getCollectionEvenementFinQuantiteDroit();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterEvenementFinQuantiteDroit((EvenementFinQuantiteDroit)objet);
    }
  }
  
  public void clearCollectionEvenementFinQuantiteDroit()
  {
    getCollectionModifiableEvenementFinQuantiteDroit().clear();
    ((UniteTraitementPC)getPC()).getCollectionEvenementFinQuantiteDroit().clear();
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
    
    Object constituantsCalculActiviteReduiteEnFinUT = getConstituantsCalculActiviteReduiteEnFinUT();
    if ((constituantsCalculActiviteReduiteEnFinUT != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(constituantsCalculActiviteReduiteEnFinUT))) {
      DomManager.supprimer(getConstituantsCalculActiviteReduiteEnFinUT(), p_contexteSuppression);
    }
    Object constituantsIndemnisationEnFinUT = getConstituantsIndemnisationEnFinUT();
    if ((constituantsIndemnisationEnFinUT != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(constituantsIndemnisationEnFinUT))) {
      DomManager.supprimer(getConstituantsIndemnisationEnFinUT(), p_contexteSuppression);
    }
    Object decalageEnFinUT = getDecalageEnFinUT();
    if ((decalageEnFinUT != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(decalageEnFinUT))) {
      DomManager.supprimer(getDecalageEnFinUT(), p_contexteSuppression);
    }
    for (Iterator iter = getCollectionEvenementFinQuantiteDroit().iterator(); iter.hasNext();)
    {
      DomGenSpec item = (DomGenSpec)iter.next();
      if ((item != null) && (!p_contexteSuppression.isAlreadyEnlistedForDeletion(item))) {
        DomManager.supprimer(item, p_contexteSuppression);
      }
    }
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     UniteTraitementGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
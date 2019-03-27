package fr.unedic.cali.calcul.dom.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalcul;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.pc.CalendrierExecutionCalculPeriodiquePC;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class CalendrierExecutionCalculPeriodiqueGen
  extends CalendrierExecutionCalcul
  implements DomGenSpec
{
  private Collection m_listChronologieUnitesTraitements;
  
  public CalendrierExecutionCalculPeriodiqueGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public CalendrierExecutionCalculPeriodiqueGen() {}
  
  protected abstract DomPCSpec createPC();
  
  private final Collection getCollectionModifiableUniteTraitement()
  {
    Iterator itCollectionPC;
    if (m_listChronologieUnitesTraitements == null)
    {
      m_listChronologieUnitesTraitements = new ArrayList();
      for (itCollectionPC = ((CalendrierExecutionCalculPeriodiquePC)getPC()).getCollectionUniteTraitement().iterator(); itCollectionPC.hasNext();)
      {
        DomPCSpec currentPC = (DomPCSpec)itCollectionPC.next();
        Object currentOM = currentPC.createOM();
        m_listChronologieUnitesTraitements.add(currentOM);
      }
    }
    return m_listChronologieUnitesTraitements;
  }
  
  public Collection getCollectionUniteTraitement()
  {
    return Collections.unmodifiableCollection(getCollectionModifiableUniteTraitement());
  }
  
  public List getListUniteTraitement()
  {
    return Collections.unmodifiableList((List)getCollectionModifiableUniteTraitement());
  }
  
  public void remplacerCollectionUniteTraitement(Collection p_collectionACopier)
  {
    clearCollectionUniteTraitement();
    for (Iterator i = p_collectionACopier.iterator(); i.hasNext();)
    {
      UniteTraitement objet = (UniteTraitement)i.next();
      ajouterUniteTraitement(objet);
    }
  }
  
  public void supprimerSousCollectionUniteTraitement(Collection p_collectionASupprimer)
  {
    for (Iterator i = p_collectionASupprimer.iterator(); i.hasNext();)
    {
      UniteTraitement objet = (UniteTraitement)i.next();
      supprimerUniteTraitement(objet);
    }
  }
  
  public void ajouterUniteTraitement(UniteTraitement p_ut)
    throws NullPointerException
  {
    if (p_ut == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_ut ne devrait pas être nul.", p_ut);
    }
    getCollectionModifiableUniteTraitement().add(p_ut);
    ((CalendrierExecutionCalculPeriodiquePC)getPC()).ajouterUniteTraitement(p_ut.getPC());
  }
  
  public void supprimerUniteTraitement(UniteTraitement p_ut)
    throws NullPointerException
  {
    if (p_ut == null) {
      ExceptionUtil.assertInternalNotNull("Le paramètre p_ut ne devrait pas être nul.", p_ut);
    }
    getCollectionModifiableUniteTraitement().remove(p_ut);
    ((CalendrierExecutionCalculPeriodiquePC)getPC()).supprimerUniteTraitement(p_ut.getPC());
  }
  
  public void recopierCollectionUniteTraitementVers(ObjetMetierSpec p_copie)
  {
    CalendrierExecutionCalculPeriodiqueGen copie = (CalendrierExecutionCalculPeriodiqueGen)p_copie;
    Collection listeACopier = getCollectionUniteTraitement();
    for (Iterator i = listeACopier.iterator(); i.hasNext();)
    {
      ObjetMetierSpec objet = ((ObjetMetierSpec)i.next()).copie();
      copie.ajouterUniteTraitement((UniteTraitement)objet);
    }
  }
  
  public void clearCollectionUniteTraitement()
  {
    getCollectionModifiableUniteTraitement().clear();
    ((CalendrierExecutionCalculPeriodiquePC)getPC()).getCollectionUniteTraitement().clear();
  }
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
    for (Iterator iter = getCollectionUniteTraitement().iterator(); iter.hasNext();)
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
 * Qualified Name:     CalendrierExecutionCalculPeriodiqueGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
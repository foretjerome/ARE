package fr.unedic.cali.dom;

import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.util.ObjetMetierSpec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class ConditionsAttributionAbstrait
  implements ConditionsAttributionSpec
{
  public boolean estSatisfait()
  {
    for (Iterator iter = getListeConditionsAttribution().iterator(); iter.hasNext();)
    {
      ElementDroitSpec droit = (ElementDroitSpec)iter.next();
      if ((droit == null) || (!droit.estSatisfait())) {
        return false;
      }
    }
    return true;
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreStore() {}
  
  public void copieElements(ObjetMetierSpec p_copie) {}
  
  public List getListeConditionsNonSatisfaites()
  {
    List listeResultat = new ArrayList();
    
    Iterator iterListeCap = getListeConditionsAttribution().iterator();
    while (iterListeCap.hasNext())
    {
      ConditionAttributionSpec cap = (ConditionAttributionSpec)iterListeCap.next();
      if ((cap != null) && (!cap.estSatisfait())) {
        listeResultat.add(cap);
      }
    }
    return listeResultat;
  }
  
  public List getListeConditionsSatisfaites()
  {
    List listeResultat = new ArrayList();
    
    Iterator iterListeCap = getListeConditionsAttribution().iterator();
    while (iterListeCap.hasNext())
    {
      ConditionAttributionSpec cap = (ConditionAttributionSpec)iterListeCap.next();
      if ((cap != null) && (cap.estSatisfait())) {
        listeResultat.add(cap);
      }
    }
    return listeResultat;
  }
  
  public List getListeCodeMotifEchec()
  {
    List listeResultat = new ArrayList();
    
    Iterator iterListeCap = getListeConditionsNonSatisfaites().iterator();
    while (iterListeCap.hasNext())
    {
      ConditionAttributionSpec cap = (ConditionAttributionSpec)iterListeCap.next();
      listeResultat.add(Integer.valueOf(cap.getCodeMotifEchec()));
    }
    return listeResultat;
  }
}

/* Location:
 * Qualified Name:     ConditionsAttributionAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.pivot;

import fr.unedic.cali.autresdoms.d90.dom.EcartBasePivotEchange;
import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.gen.DemandePivotGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import xcalia.lido.api.LiDOHelper;

public class DemandePivot
  extends DemandePivotGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = -8984993208770160927L;
  protected transient Date m_tspElementPourEcartsBase = null;
  
  public DemandePivot() {}
  
  public DemandePivot(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public void setAttribution(Attribution attribution)
  {
    DomManager.supprimer(super.getAttribution(), attribution);
    super.setAttribution(attribution);
  }
  
  public void setDecision(Decision decision)
  {
    DomManager.supprimer(super.getDecision(), decision);
    super.setDecision(decision);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete()
  {
    DomManager.supprimerAbsolument(super.getAttribution());
    DomManager.supprimerAbsolument(super.getDecision());
    DomManager.supprimerAbsolument(super.getAides());
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getAttribution());
    DomManager.persisterEnProfondeur(super.getDecision());
    DomManager.persisterEnProfondeur(super.getAides());
    DomManager.persisterEnProfondeur(super.getAidesNcp());
  }
  
  public void jdoPreStore() {}
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    DemandePivot copie = new DemandePivot();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    DemandePivot copie = (DemandePivot)p_copie;
    if (getAttribution() != null) {
      copie.setAttribution((Attribution)getAttribution().copie());
    }
    if (getDecision() != null) {
      copie.setDecision((Decision)getDecision().copie());
    }
    if (getAides() != null) {
      copie.setAides((Aides)getAides().copie());
    }
    if (getTspElementPourEcartsBases() != null)
    {
      copie.setTspElementPourEcartsBases(getTspElementPourEcartsBases());
    }
    else
    {
      Date dateTimestampAvant = (Date)LiDOHelper.getSyntheticValue(getPC(), "{version}");
      if (dateTimestampAvant != null) {
        copie.setTspElementPourEcartsBases(dateTimestampAvant);
      }
    }
  }
  
  public void setAides(Aides aides)
  {
    DomManager.supprimer(super.getAides(), aides);
    super.setAides(aides);
  }
  
  public Collection getListeMethodesAExclurePourComparaison()
  {
    Collection listeMethodesAExclure = new ArrayList();
    listeMethodesAExclure.add("getAides");
    listeMethodesAExclure.add("getAttribution");
    listeMethodesAExclure.add("getDecision");
    listeMethodesAExclure.add("getAidesNcp");
    return listeMethodesAExclure;
  }
  
  public Map recupererParametresEcartsBases()
  {
    Map parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Demande Pivot");
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    parametresEcartsBases.put("cleFonctionnelle", getIdentifiant());
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec p_elementAComparer)
  {
    DemandePivot elementAComparer = (DemandePivot)p_elementAComparer;
    return getIdentifiant().equals(elementAComparer.getIdentifiant());
  }
  
  public Collection comparer(ElementBasePivotEchangeComparableSpec p_elementAComparer)
    throws CoucheLogiqueException
  {
    DemandePivot demandeAComparer = (DemandePivot)p_elementAComparer;
    Collection listeEcartsBases = OutilComparaison.comparer(this, p_elementAComparer);
    
    listeEcartsBases.addAll(comparer(getDecision(), demandeAComparer.getDecision()));
    listeEcartsBases.addAll(comparer(getAttribution(), demandeAComparer.getAttribution()));
    listeEcartsBases.addAll(comparer(getAides(), demandeAComparer.getAides()));
    return listeEcartsBases;
  }
  
  private Collection comparer(ElementBasePivotEchangeComparableSpec p_premierElement, ElementBasePivotEchangeComparableSpec p_deuxiemeElement)
    throws CoucheLogiqueException
  {
    Collection listeEcartsBases = new ArrayList();
    Map parametresEcartBase = new HashMap();
    if ((p_premierElement != null) && (p_deuxiemeElement != null))
    {
      listeEcartsBases.addAll(p_premierElement.comparer(p_deuxiemeElement));
    }
    else if (p_premierElement != null)
    {
      parametresEcartBase = p_premierElement.recupererParametresEcartsBases();
      EcartBasePivotEchange ecartBase = new EcartBasePivotEchange(parametresEcartBase, "MANQUANT");
      listeEcartsBases.add(ecartBase);
    }
    else if (p_deuxiemeElement != null)
    {
      parametresEcartBase = p_deuxiemeElement.recupererParametresEcartsBases();
      EcartBasePivotEchange ecartBase = new EcartBasePivotEchange(parametresEcartBase, "NOUVEAU");
      listeEcartsBases.add(ecartBase);
    }
    return listeEcartsBases;
  }
  
  public Date getTspElementPourEcartsBases()
  {
    return m_tspElementPourEcartsBase;
  }
  
  public void setTspElementPourEcartsBases(Date p_tspElementPourEcartBase)
  {
    m_tspElementPourEcartsBase = p_tspElementPourEcartBase;
  }
  
  public void setAidesNcp(AidesNcp aidesNcp)
  {
    DomManager.supprimer(super.getAidesNcp(), aidesNcp);
    super.setAidesNcp(aidesNcp);
  }
}

/* Location:
 * Qualified Name:     DemandePivot
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
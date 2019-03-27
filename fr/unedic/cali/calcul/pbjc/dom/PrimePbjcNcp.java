package fr.unedic.cali.calcul.pbjc.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.calcul.pbjc.dom.gen.PrimePbjcNcpGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import xcalia.lido.api.LiDOHelper;

public class PrimePbjcNcp
  extends PrimePbjcNcpGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec, Comparable<PrimePbjcNcp>
{
  private static final long serialVersionUID = 4668889743604763559L;
  protected transient Date m_tspElementPourEcartsBase = null;
  
  public PrimePbjcNcp() {}
  
  public PrimePbjcNcp(DomPCSpec pc)
  {
    super(pc);
  }
  
  public void setType(String codeProduit)
  {
    super.setCodeProduit(codeProduit);
  }
  
  public String toString()
  {
    StringBuffer bufferARetourner = new StringBuffer();
    bufferARetourner.append("\n");
    bufferARetourner.append("--------------------------------\n");
    bufferARetourner.append("Prime PBJC du " + getDateEffet() + "\n");
    bufferARetourner.append("Code produit            : " + getCodeProduit() + "\n");
    bufferARetourner.append("Montant                 : " + getMontant() + "\n");
    bufferARetourner.append("Complément Montant 1    : " + getComplementMontant1() + "\n");
    bufferARetourner.append("Complément Montant 2    : " + getComplementMontant2() + "\n");
    bufferARetourner.append("Nbre jours reliquat ARE : " + getNbJoursReliquatARE() + "\n");
    bufferARetourner.append("Od origine              : " + getOdOrigine() + "\n");
    bufferARetourner.append("Numéro d'ordre          : " + getNumeroOrdre() + "\n");
    bufferARetourner.append("Code sous produit       : " + getCodeSousProduit() + "\n");
    bufferARetourner.append("Code Pays               : " + getCodePays() + "\n");
    bufferARetourner.append("typePopulation1         : " + getTypePopulation1() + "\n");
    bufferARetourner.append("sousTypePopulation1     : " + getSousTypePopulation1() + "\n");
    bufferARetourner.append("statutPrestation1       : " + getStatutPrestation1() + "\n");
    bufferARetourner.append("typePopulation2         : " + getTypePopulation2() + "\n");
    bufferARetourner.append("sousTypePopulation2     : " + getSousTypePopulation2() + "\n");
    bufferARetourner.append("statutPrestation2       : " + getStatutPrestation2() + "\n");
    bufferARetourner.append("typePopulation3         : " + getTypePopulation3() + "\n");
    bufferARetourner.append("sousTypePopulation3     : " + getSousTypePopulation3() + "\n");
    bufferARetourner.append("statutPrestation3       : " + getStatutPrestation3() + "\n");
    bufferARetourner.append("typePopulation4         : " + getTypePopulation4() + "\n");
    bufferARetourner.append("sousTypePopulation4     : " + getSousTypePopulation4() + "\n");
    bufferARetourner.append("statutPrestation4       : " + getStatutPrestation4() + "\n");
    bufferARetourner.append("typePopulation5         : " + getTypePopulation5() + "\n");
    bufferARetourner.append("sousTypePopulation5     : " + getSousTypePopulation5() + "\n");
    bufferARetourner.append("statutPrestation5       : " + getStatutPrestation5() + "\n");
    bufferARetourner.append("--------------------------------\n");
    
    return bufferARetourner.toString();
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public ObjetMetierSpec copie()
  {
    PrimePbjcNcp copie = new PrimePbjcNcp();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    PrimePbjcNcp copie = (PrimePbjcNcp)pcopie;
    copie.setDateEffet(getDateEffet());
    copie.setMontant(getMontant());
    copie.setType(getCodeProduit());
    copie.setComplementMontant1(getComplementMontant1());
    copie.setComplementMontant2(getComplementMontant2());
    copie.setNbJoursReliquatARE(getNbJoursReliquatARE());
    copie.setOdOrigine(getOdOrigine());
    copie.setNumeroOrdre(getNumeroOrdre());
    copie.setCodeSousProduit(getCodeSousProduit());
    copie.setCodePays(getCodePays());
    copie.setTypePopulation1(getTypePopulation1());
    copie.setSousTypePopulation1(getSousTypePopulation1());
    copie.setStatutPrestation1(getStatutPrestation1());
    copie.setTypePopulation2(getTypePopulation2());
    copie.setSousTypePopulation2(getSousTypePopulation2());
    copie.setStatutPrestation2(getStatutPrestation2());
    copie.setTypePopulation3(getTypePopulation3());
    copie.setSousTypePopulation3(getSousTypePopulation3());
    copie.setStatutPrestation3(getStatutPrestation3());
    copie.setTypePopulation4(getTypePopulation4());
    copie.setSousTypePopulation4(getSousTypePopulation4());
    copie.setStatutPrestation4(getStatutPrestation4());
    copie.setTypePopulation5(getTypePopulation5());
    copie.setSousTypePopulation5(getSousTypePopulation5());
    copie.setStatutPrestation5(getStatutPrestation5());
    copie.setTiers(getTiers());
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
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void ajouterTypeSousTypePopulation(String type, String sousType)
  {
    if (super.getTypePopulation1() == null)
    {
      super.setTypePopulation1(type);
      super.setSousTypePopulation1(sousType);
    }
    else if (super.getTypePopulation2() == null)
    {
      super.setTypePopulation2(type);
      super.setSousTypePopulation2(sousType);
    }
    else if (super.getTypePopulation3() == null)
    {
      super.setTypePopulation3(type);
      super.setSousTypePopulation3(sousType);
    }
    else if (super.getTypePopulation4() == null)
    {
      super.setTypePopulation4(type);
      super.setSousTypePopulation4(sousType);
    }
    else if (super.getTypePopulation5() == null)
    {
      super.setTypePopulation5(type);
      super.setSousTypePopulation5(sousType);
    }
  }
  
  public boolean contientTypeSousTypePopulation(String type, String sousType)
  {
    if (verificationTypeSousTypePopulation(type, sousType, super.getTypePopulation1(), super.getSousTypePopulation1())) {
      return true;
    }
    if (verificationTypeSousTypePopulation(type, sousType, super.getTypePopulation2(), super.getSousTypePopulation2())) {
      return true;
    }
    if (verificationTypeSousTypePopulation(type, sousType, super.getTypePopulation3(), super.getSousTypePopulation3())) {
      return true;
    }
    if (verificationTypeSousTypePopulation(type, sousType, super.getTypePopulation4(), super.getSousTypePopulation4())) {
      return true;
    }
    if (verificationTypeSousTypePopulation(type, sousType, super.getTypePopulation5(), super.getSousTypePopulation5())) {
      return true;
    }
    return false;
  }
  
  private boolean verificationTypeSousTypePopulation(String type, String sousType, String superType, String superSousType)
  {
    return (type.equals(superType)) && (sousType.equals(superSousType));
  }
  
  public Collection getListeMethodesAExclurePourComparaison()
  {
    return new ArrayList();
  }
  
  public Map recupererParametresEcartsBases()
  {
    Map parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Prime");
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    String cleFonctionnelle = getDateEffet().formater();
    parametresEcartsBases.put("cleFonctionnelle", cleFonctionnelle);
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec elmntAComparer)
  {
    PrimePbjcNcp elementAComparer = (PrimePbjcNcp)elmntAComparer;
    return getDateEffet().coincideAvec(elementAComparer.getDateEffet());
  }
  
  public Collection comparer(ElementBasePivotEchangeComparableSpec elementAComparer)
    throws CoucheLogiqueException
  {
    return OutilComparaison.comparer(this, elementAComparer);
  }
  
  public Date getTspElementPourEcartsBases()
  {
    return m_tspElementPourEcartsBase;
  }
  
  public void setTspElementPourEcartsBases(Date tspElementPourEcartBase)
  {
    m_tspElementPourEcartsBase = tspElementPourEcartBase;
  }
  
  public int compareTo(PrimePbjcNcp o)
  {
    return getDateEffet().compareTo(o.getDateEffet());
  }
}

/* Location:
 * Qualified Name:     PrimePbjcNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
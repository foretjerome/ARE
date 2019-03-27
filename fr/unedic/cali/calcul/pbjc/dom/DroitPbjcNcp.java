package fr.unedic.cali.calcul.pbjc.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.calcul.pbjc.dom.gen.DroitPbjcNcpGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import xcalia.lido.api.LiDOHelper;

public class DroitPbjcNcp
  extends DroitPbjcNcpGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = -8072619727052700261L;
  protected transient Date m_tspElementPourEcartsBase = null;
  
  private DroitPbjcNcp() {}
  
  public DroitPbjcNcp(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public DroitPbjcNcp(int p_identOuvertureDroit)
  {
    super.setIdentOuvertureDroit(p_identOuvertureDroit);
  }
  
  public String toString()
  {
    StringBuffer string = new StringBuffer();
    string.append("Droit NCP :\n");
    string.append(" - identifiant ouverture droit   : " + super.getIdentOuvertureDroit() + "\n");
    string.append(" - date effet maintien           : " + super.getDateEffetMaintien() + "\n");
    string.append(" - date effet exclusion def      : " + super.getDateEffetExclusionDef() + "\n");
    string.append(" - date de fin de droit          : " + super.getDateFinDeDroit() + "\n");
    string.append(" - annee d'affectation           : " + super.getAnneeAffectation() + "\n");
    string.append(" - date effet PJI Maintien EESSI : " + super.getDateEffetPjiMaintienEESSI() + "\n");
    string.append(" - date effet IDE Maintien EESSI : " + super.getDateEffetIdeMaintienEESSI() + "\n");
    string.append(" - date effet DJI Maintien EESSI : " + super.getDateEffetDjiMaintienEESSI() + "\n");
    string.append(" - Indicateur Maintien EESSI     : " + super.isIndicateurMaintienEESSI() + "\n");
    string.append(" - Date de debut du droit     : " + super.getDateDebutDroit() + "\n");
    string.append(" - Montant brut à l'OD     : " + super.getMontantBrutOd() + "\n");
    string.append(" - Montant CRC     : " + super.getMontantPrecompteOd() + "\n");
    string.append(" - Franchise CP initiale : " + super.getFranchiseCPinit() + "\n");
    string.append(" - Franchise salaire initiale : " + super.getFranchiseSalaireInit() + "\n");
    string.append(" - Reliquat franchise cp     : " + super.getReliquatFranchiseCP() + "\n");
    string.append(" - Reliquat franchise salaire : " + super.getReliquatFranchiseSalaire() + "\n");
    string.append(" - Somme des reliquat plafonne : " + super.getSommeReliquatPlafonee() + "\n");
    return string.toString();
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public ObjetMetierSpec copie()
  {
    DroitPbjcNcp copie = new DroitPbjcNcp();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    DroitPbjcNcp copie = (DroitPbjcNcp)p_copie;
    copie.setIdentOuvertureDroit(getIdentOuvertureDroit());
    copie.setDateEffetMaintien(getDateEffetMaintien());
    copie.setDateEffetExclusionDef(getDateEffetExclusionDef());
    copie.setDateFinDeDroit(getDateFinDeDroit());
    copie.setAnneeAffectation(getAnneeAffectation());
    
    copie.setDateEffetPjiMaintienEESSI(getDateEffetPjiMaintienEESSI());
    copie.setDateEffetIdeMaintienEESSI(getDateEffetIdeMaintienEESSI());
    copie.setDateEffetDjiMaintienEESSI(getDateEffetDjiMaintienEESSI());
    copie.setIndicateurMaintienEESSI(isIndicateurMaintienEESSI());
    copie.setDateFinCSP(getDateFinCSP());
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
    copie.setDateDebutDroit(getDateDebutDroit());
    copie.setMontantBrutOd(getMontantBrutOd());
    copie.setMontantPrecompteOd(getMontantPrecompteOd());
    copie.setFranchiseCPinit(getFranchiseCPinit());
    copie.setFranchiseSalaireInit(getFranchiseSalaireInit());
    copie.setReliquatFranchiseCP(getReliquatFranchiseCP());
    copie.setReliquatFranchiseSalaire(getReliquatFranchiseSalaire());
    copie.setSommeReliquatPlafonee(getSommeReliquatPlafonee());
  }
  
  public Collection getListeMethodesAExclurePourComparaison()
  {
    Collection listeMethodesAExclure = new ArrayList();
    listeMethodesAExclure.add("getDateFinDeDroit");
    return listeMethodesAExclure;
  }
  
  public Map recupererParametresEcartsBases()
  {
    Map parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Droit");
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    String cleFonctionnelle = Integer.valueOf(getIdentOuvertureDroit()).toString();
    parametresEcartsBases.put("cleFonctionnelle", cleFonctionnelle);
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec p_elementAComparer)
  {
    DroitPbjcNcp elementAComparer = (DroitPbjcNcp)p_elementAComparer;
    return getIdentOuvertureDroit() == elementAComparer.getIdentOuvertureDroit();
  }
  
  public Collection comparer(ElementBasePivotEchangeComparableSpec p_elementAComparer)
    throws CoucheLogiqueException
  {
    return OutilComparaison.comparer(this, p_elementAComparer);
  }
  
  public Date getTspElementPourEcartsBases()
  {
    return m_tspElementPourEcartsBase;
  }
  
  public void setTspElementPourEcartsBases(Date p_tspElementPourEcartBase)
  {
    m_tspElementPourEcartsBase = p_tspElementPourEcartBase;
  }
}

/* Location:
 * Qualified Name:     DroitPbjcNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
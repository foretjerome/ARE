package fr.unedic.cali.calcul.pbjc.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.calcul.pbjc.dom.gen.IndividuPbjcNcpGen;
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

public class IndividuPbjcNcp
  extends IndividuPbjcNcpGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = 5970059229631100402L;
  protected transient Date m_tspElementPourEcartsBase = null;
  
  public IndividuPbjcNcp() {}
  
  public IndividuPbjcNcp(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public boolean isAnomalieBloquant()
  {
    boolean estBloquant = false;
    if (("M01".equals(getCodeAnomalieCalcul())) || ("M02".equals(getCodeAnomalieCalcul())) || ("M03".equals(getCodeAnomalieCalcul())) || ("M04".equals(getCodeAnomalieCalcul())) || ("M05".equals(getCodeAnomalieCalcul())) || ("M06".equals(getCodeAnomalieCalcul())) || ("M07".equals(getCodeAnomalieCalcul())) || ("M08".equals(getCodeAnomalieCalcul())) || ("M09".equals(getCodeAnomalieCalcul())) || ("M10".equals(getCodeAnomalieCalcul())) || ("M11".equals(getCodeAnomalieCalcul()))) {
      estBloquant = true;
    }
    return estBloquant;
  }
  
  public String toString()
  {
    StringBuffer string = new StringBuffer();
    string.append("Individu NCP :\n");
    string.append(" - date derniere execution            : " + super.getDateDerniereExecCal() + "\n");
    string.append(" - heure derniere execution           : " + super.getHeureDerniereExecCal() + "\n");
    string.append(" - date derniere demande execution    : " + super.getDateDerniereDemCal() + "\n");
    string.append(" - heure derniere demande execution   : " + super.getHeureDerniereDemCal() + "\n");
    string.append(" - dernier jour indemnisable          : " + super.getDernierJourIndemnisable() + "\n");
    string.append(" - date depart retraite calculee      : " + super.getDateDepartRetraiteCalculee() + "\n");
    string.append(" - code de justification retraite     : " + super.getCodeJustifRetraite() + "\n");
    string.append(" - etat de la derniere execution      : " + super.getEtatDerniereExecution() + "\n");
    string.append(" - code anomalie calcul               : " + super.getCodeAnomalieCalcul() + "\n");
    string.append(" - donnee anomalie calcul             : " + super.getDonneeAnomalieCalcul() + "\n");
    string.append(" - contexte execution                 : " + super.getContexteExecution() + "\n");
    string.append(" - nombre de trimestre de retraite    : " + super.getNombreTrimestreRetraite() + "\n");
    string.append(" - date atteinte de mois non payes    : " + super.getDateAtteinteMoisNonPaye() + "\n");
    string.append(" - date debut ineligibilite aides mobilite : " + super.getDateDebutIneligibiliteAidesMob() + "\n");
    string.append(" - date fin ineligibilite aides mobilite : " + super.getDateFinIneligibiliteAidesMob() + "\n");
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
    IndividuPbjcNcp copie = new IndividuPbjcNcp();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    IndividuPbjcNcp copie = (IndividuPbjcNcp)p_copie;
    copie.setDateDerniereExecCal(getDateDerniereExecCal());
    copie.setHeureDerniereExecCal(getHeureDerniereExecCal());
    copie.setDateDerniereDemCal(getDateDerniereDemCal());
    copie.setHeureDerniereDemCal(getHeureDerniereDemCal());
    copie.setDernierJourIndemnisable(getDernierJourIndemnisable());
    copie.setDateDepartRetraiteCalculee(getDateDepartRetraiteCalculee());
    copie.setCodeJustifRetraite(getCodeJustifRetraite());
    copie.setEtatDerniereExecution(getEtatDerniereExecution());
    copie.setCodeAnomalieCalcul(getCodeAnomalieCalcul());
    copie.setDonneeAnomalieCalcul(getDonneeAnomalieCalcul());
    copie.setContexteExecution(getContexteExecution());
    copie.setNombreTrimestreRetraite(getNombreTrimestreRetraite());
    copie.setDateAtteinteMoisNonPaye(getDateAtteinteMoisNonPaye());
    copie.setDateDebutIneligibiliteAidesMob(getDateDebutIneligibiliteAidesMob());
    copie.setDateFinIneligibiliteAidesMob(getDateFinIneligibiliteAidesMob());
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
  
  public Collection getListeMethodesAExclurePourComparaison()
  {
    Collection listeMethodesAExclure = new ArrayList();
    listeMethodesAExclure.add("getHeureDerniereExecCal");
    listeMethodesAExclure.add("getDateDerniereExecCal");
    listeMethodesAExclure.add("getContexteExecution");
    return listeMethodesAExclure;
  }
  
  public Map recupererParametresEcartsBases()
  {
    Map parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Individu");
    parametresEcartsBases.put("cleFonctionnelle", getIdentifiant());
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec p_elementAComparer)
  {
    return true;
  }
  
  public Collection comparer(ElementBasePivotEchangeComparableSpec p_elementAComparer)
    throws CoucheLogiqueException
  {
    Collection listeEcartsBases = OutilComparaison.comparer(this, p_elementAComparer);
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
}

/* Location:
 * Qualified Name:     IndividuPbjcNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
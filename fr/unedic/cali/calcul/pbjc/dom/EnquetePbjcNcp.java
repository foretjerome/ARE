package fr.unedic.cali.calcul.pbjc.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.calcul.pbjc.dom.gen.EnquetePbjcNcpGen;
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

public class EnquetePbjcNcp
  extends EnquetePbjcNcpGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = -4265323744691326525L;
  protected transient Date m_tspElementPourEcartsBase = null;
  
  private EnquetePbjcNcp() {}
  
  public EnquetePbjcNcp(DomPCSpec pc)
  {
    super(pc);
  }
  
  public EnquetePbjcNcp(int identOuvertureDroit)
  {
    super.setIdentOuvertureDroit(identOuvertureDroit);
  }
  
  public String toString()
  {
    StringBuffer string = new StringBuffer();
    string.append("Enquete NCP pour l'individu :\n");
    string.append(" - identifiant ouverture droit  : " + super.getIdentOuvertureDroit() + "\n");
    string.append(" - date situation suivi         : " + super.getDateSituationSuivi() + "\n");
    string.append(" - type de situation de suivi   : " + super.getTypeSituationSuivi() + "\n");
    string.append(" - code produit                 : " + super.getCodeProduit() + "\n");
    string.append(" - code sous produit            : " + super.getCodeSousProduit() + "\n");
    string.append(" - rang situation               : " + super.getDateSituationSuivi() + "\n");
    string.append(" - identifiant reprise porteuse : " + super.getDateSituationSuivi() + "\n");
    if (super.isSituationAEmettre()) {
      string.append(" - situation a emettre         : Oui\n");
    } else {
      string.append(" - situation a emettre         : Non\n");
    }
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
    EnquetePbjcNcp copie = new EnquetePbjcNcp();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    EnquetePbjcNcp copie = (EnquetePbjcNcp)pcopie;
    copie.setIdentOuvertureDroit(getIdentOuvertureDroit());
    copie.setDateSituationSuivi(getDateSituationSuivi());
    copie.setTypeSituationSuivi(getTypeSituationSuivi());
    copie.setCodeProduit(getCodeProduit());
    copie.setCodeSousProduit(getCodeSousProduit());
    copie.setRangSituation(getRangSituation());
    copie.setIdentReprisePorteuse(getIdentReprisePorteuse());
    copie.setSituationAEmettre(isSituationAEmettre());
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
    return new ArrayList();
  }
  
  public Map recupererParametresEcartsBases()
  {
    Map parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Enquete");
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    StringBuffer cleFonctionnelle = new StringBuffer();
    cleFonctionnelle.append(getDateSituationSuivi().formater()).append(" ");
    cleFonctionnelle.append(getTypeSituationSuivi()).append(" ");
    cleFonctionnelle.append(getRangSituation()).append(" ");
    cleFonctionnelle.append(getIdentOuvertureDroit());
    parametresEcartsBases.put("cleFonctionnelle", cleFonctionnelle.toString());
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec pelementAComparer)
  {
    EnquetePbjcNcp elementAComparer = (EnquetePbjcNcp)pelementAComparer;
    return (getDateSituationSuivi().coincideAvec(elementAComparer.getDateSituationSuivi())) && (getTypeSituationSuivi() == elementAComparer.getTypeSituationSuivi()) && (getRangSituation() == elementAComparer.getRangSituation()) && (getIdentOuvertureDroit() == elementAComparer.getIdentOuvertureDroit());
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
}

/* Location:
 * Qualified Name:     EnquetePbjcNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
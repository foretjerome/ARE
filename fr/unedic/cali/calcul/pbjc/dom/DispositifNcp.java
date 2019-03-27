package fr.unedic.cali.calcul.pbjc.dom;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.calcul.pbjc.dom.gen.DispositifNcpGen;
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

public class DispositifNcp
  extends DispositifNcpGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = 1L;
  private transient Date tspElementPourEcartsBase = null;
  private transient boolean estModifie = false;
  
  public DispositifNcp() {}
  
  public DispositifNcp(DomPCSpec pc)
  {
    super(pc);
  }
  
  public ObjetMetierSpec copie()
  {
    DispositifNcp copie = new DispositifNcp();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    DispositifNcp copie = (DispositifNcp)pcopie;
    copie.setDateDebutDispositif(getDateDebutDispositif());
    copie.setDateFinDispositifAvant(getDateFinDispositifAvant());
    copie.setDateFinDispositifApres(getDateFinDispositifApres());
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
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public Collection<?> comparer(ElementBasePivotEchangeComparableSpec elementAComparer)
    throws CoucheLogiqueException
  {
    return OutilComparaison.comparer(this, elementAComparer);
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec elementAComparer)
    throws ApplicativeException
  {
    return true;
  }
  
  public Collection<?> getListeMethodesAExclurePourComparaison()
  {
    return new ArrayList();
  }
  
  public Map<?, ?> recupererParametresEcartsBases()
  {
    Map parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "Dispositif");
    parametresEcartsBases.put("cleFonctionnelle", getIdentifiant());
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public Date getTspElementPourEcartsBases()
  {
    return tspElementPourEcartsBase;
  }
  
  public void setTspElementPourEcartsBases(Date tspElementPourEcartBase)
  {
    tspElementPourEcartsBase = tspElementPourEcartBase;
  }
  
  public boolean isEstModifie()
  {
    return estModifie;
  }
  
  public void setEstModifie(boolean estModifie)
  {
    this.estModifie = estModifie;
  }
}

/* Location:
 * Qualified Name:     DispositifNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.pivot;

import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.gen.PeriodeLieuGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class PeriodeLieu
  extends PeriodeLieuGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = -1012259950657103488L;
  
  public PeriodeLieu() {}
  
  public PeriodeLieu(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeLieu copiePL = new PeriodeLieu();
    copieElements(copiePL);
    return copiePL;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeLieu copiePL = (PeriodeLieu)p_copie;
    copiePL.setDateDebutPeriode(getDateDebutPeriode());
    copiePL.setDateFinPeriode(getDateFinPeriode());
    copiePL.setIdentifiantPlanFormation(getIdentifiantPlanFormation());
    copiePL.setIdPeriodeFormation(getIdPeriodeFormation());
    copiePL.setLieuFormation(getLieuFormation());
    copiePL.setMontantUnitaireNuit(getMontantUnitaireNuit());
    copiePL.setMontantUnitaireRepas(getMontantUnitaireRepas());
    copiePL.setNbAR(getNbAR());
    copiePL.setNbJoursPresenceStage(getNbJoursPresenceStage());
    copiePL.setNbNuits(getNbNuits());
    copiePL.setNbRepas(getNbRepas());
    copiePL.setMontantNuite(getMontantNuite());
    copiePL.setHebergementChargeStagiaire(getHebergementChargeStagiaire());
    copiePL.setCodeProduit(getCodeProduit());
  }
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
}

/* Location:
 * Qualified Name:     PeriodeLieu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.pivot;

import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pivot.gen.PeriodeAffiliationGen;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class PeriodeAffiliation
  extends PeriodeAffiliationGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 1L;
  
  public PeriodeAffiliation() {}
  
  public PeriodeAffiliation(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeAffiliation copiePA = new PeriodeAffiliation();
    copieElements(copiePA);
    return copiePA;
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    PeriodeAffiliation copiePA = (PeriodeAffiliation)p_copie;
    copiePA.setIdentifiantPeriode(getIdentifiantPeriode());
    copiePA.setDateDebut(getDateDebut());
    copiePA.setDateFin(getDateFin());
    copiePA.setQualification(getQualification());
    copiePA.setType(getType());
    copiePA.setCompetenceFinanciere(getCompetenceFinanciere());
    copiePA.setCompetenceAdministrative(getCompetenceAdministrative());
    copiePA.setIdentifiantOD(getIdentifiantOD());
    copiePA.setReferenceExterneDemande(getReferenceExterneDemande());
  }
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
}

/* Location:
 * Qualified Name:     PeriodeAffiliation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom;

import fr.unedic.cali.dom.gen.ActionFormationLieeGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;

public class ActionFormationLiee
  extends ActionFormationLieeGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 6278145390007364348L;
  
  public ActionFormationLiee(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public ActionFormationLiee() {}
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    ActionFormationLiee copie = (ActionFormationLiee)p_copie;
    copie.setAffDerogatoire(getAffDerogatoire());
    copie.setDateDebut(getDateDebut());
    copie.setDateDebutPeriodeFormation(getDateDebutPeriodeFormation());
    copie.setDateFin(getDateFin());
    copie.setDatePrescription(getDatePrescription());
    copie.setIdentifiantConvention(getIdentifiantConvention());
    copie.setNumeroConvention(getNumeroConvention());
    copie.setQuantiteHebdomadaire(getQuantiteHebdomadaire());
    copie.setStatutFormation(getStatutFormation());
    copie.setTypeConvention(getTypeConvention());
    copie.setTypePlanFormation(getTypePlanFormation());
    copie.setTypePopulationRsa(getTypePopulationRsa());
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public ObjetMetierSpec copie()
  {
    ActionFormationLiee copie = new ActionFormationLiee();
    copieElements(copie);
    return copie;
  }
}

/* Location:
 * Qualified Name:     ActionFormationLiee
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
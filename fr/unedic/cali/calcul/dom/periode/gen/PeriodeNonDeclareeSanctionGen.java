package fr.unedic.cali.calcul.dom.periode.gen;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.cali.calcul.dom.periode.PeriodeTravailCREM;
import fr.unedic.transverse.dom.ContexteSuppressionEnProfondeur;
import fr.unedic.transverse.dom.spec.DomGenSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;

public abstract class PeriodeNonDeclareeSanctionGen
  extends PeriodeTravailCREM
  implements DomGenSpec
{
  public PeriodeNonDeclareeSanctionGen(DomPCSpec p_pc)
  {
    super(p_pc);
  }
  
  public PeriodeNonDeclareeSanctionGen() {}
  
  public PeriodeNonDeclareeSanctionGen(Damj p_dateDebut, Damj p_dateFin)
  {
    super(p_dateDebut, p_dateFin);
  }
  
  protected abstract DomPCSpec createPC();
  
  public void supprimerEnProfondeur(ContexteSuppressionEnProfondeur p_contexteSuppression)
    throws TechniqueException
  {
    p_contexteSuppression.addElementEnCoursDeSuppression(this);
    
    super.supprimerEnProfondeur(p_contexteSuppression);
  }
  
  public void copieElements(ObjetMetierSpec p_copie)
  {
    super.copieElements(p_copie);
  }
}

/* Location:
 * Qualified Name:     PeriodeNonDeclareeSanctionGen
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.StructureInSpec;
import fr.unedic.util.services.CritereSpec;
import java.util.Date;

public abstract interface CriteresChaineLiaisonSpec
  extends CritereSpec, StructureInSpec
{
  public abstract Date getDateEvenement();
  
  public abstract void setDateEvenement(Date paramDate);
}

/* Location:
 * Qualified Name:     CriteresChaineLiaisonSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
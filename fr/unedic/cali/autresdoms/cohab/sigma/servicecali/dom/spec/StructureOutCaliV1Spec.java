package fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.StructureOutDemandeV1;
import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.StructureOutDecisionSuivi;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.StructureOutBlocageActu;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.StructureOutIndividuV1;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.Pension;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.StructureOutPecV1;

public abstract interface StructureOutCaliV1Spec
{
  public abstract StructureOutIndividuV1 getStructureIndividuV1();
  
  public abstract void setStructureIndividuV1(StructureOutIndividuV1 paramStructureOutIndividuV1);
  
  public abstract StructureOutBlocageActu getStructureOutEvtActualisation();
  
  public abstract void setStructureOutEvtActualisation(StructureOutBlocageActu paramStructureOutBlocageActu);
  
  public abstract StructureOutPecV1 getStructureOutPec();
  
  public abstract void setStructureOutPec(StructureOutPecV1 paramStructureOutPecV1);
  
  public abstract StructureOutDecisionSuivi getStructureOutDetectionSuivi();
  
  public abstract void setStructureOutDetectionSuivi(StructureOutDecisionSuivi paramStructureOutDecisionSuivi);
  
  public abstract Pension getStructureOutPension();
  
  public abstract void setStructureOutPension(Pension paramPension);
  
  public abstract StructureOutDemandeV1 getStructureOutDemandeDAL();
  
  public abstract void setStructureOutDemandeDAL(StructureOutDemandeV1 paramStructureOutDemandeV1);
  
  public abstract StructureOutDemandeV1 getStructureOutDemandeRNV();
  
  public abstract void setStructureOutDemandeRNV(StructureOutDemandeV1 paramStructureOutDemandeV1);
}

/* Location:
 * Qualified Name:     StructureOutCaliV1Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
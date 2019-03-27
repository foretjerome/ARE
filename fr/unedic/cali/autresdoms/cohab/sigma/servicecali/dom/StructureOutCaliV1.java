package fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom;

import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.StructureOutDemandeV1;
import fr.unedic.cali.autresdoms.cohab.sigma.detectionsuivi.dom.StructureOutDecisionSuivi;
import fr.unedic.cali.autresdoms.cohab.sigma.evtactualisation.dom.StructureOutBlocageActu;
import fr.unedic.cali.autresdoms.cohab.sigma.individu.dom.StructureOutIndividuV1;
import fr.unedic.cali.autresdoms.cohab.sigma.listeperiodeaah.dom.StructureOutListePeriodeAAH;
import fr.unedic.cali.autresdoms.cohab.sigma.listeressource.dom.StructureOutListeRessourcesV1;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.Pension;
import fr.unedic.cali.autresdoms.cohab.sigma.priseencharge.dom.StructureOutPecV1;
import fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.spec.StructureOutCaliV1Spec;

public class StructureOutCaliV1
  implements StructureOutCaliV1Spec
{
  private StructureOutPecV1 structureOutPec;
  private StructureOutBlocageActu structureOutEvtActualisation;
  private StructureOutIndividuV1 structureOutIndividuV1;
  private StructureOutDecisionSuivi structureOutDecisionSuivi;
  private Pension structureOutPension;
  private StructureOutDemandeV1 structureOutDemandeDAL;
  private StructureOutDemandeV1 structureOutDemandeRNV;
  private StructureOutListeRessourcesV1 structureOutListeRessourcesV1;
  private StructureOutListePeriodeAAH structureOutListePeriodeAAH;
  
  public StructureOutCaliV1()
  {
    structureOutPec = new StructureOutPecV1();
    structureOutEvtActualisation = new StructureOutBlocageActu();
    structureOutIndividuV1 = new StructureOutIndividuV1();
    structureOutDecisionSuivi = new StructureOutDecisionSuivi();
    structureOutPension = new Pension();
    structureOutDemandeDAL = new StructureOutDemandeV1();
    structureOutDemandeRNV = new StructureOutDemandeV1();
    structureOutListeRessourcesV1 = new StructureOutListeRessourcesV1();
    structureOutListePeriodeAAH = new StructureOutListePeriodeAAH();
  }
  
  public StructureOutIndividuV1 getStructureIndividuV1()
  {
    return structureOutIndividuV1;
  }
  
  public void setStructureIndividuV1(StructureOutIndividuV1 p_structureIndividuV1)
  {
    structureOutIndividuV1 = p_structureIndividuV1;
  }
  
  public StructureOutBlocageActu getStructureOutEvtActualisation()
  {
    return structureOutEvtActualisation;
  }
  
  public void setStructureOutEvtActualisation(StructureOutBlocageActu p_structureOutEvtActualisation)
  {
    structureOutEvtActualisation = p_structureOutEvtActualisation;
  }
  
  public StructureOutPecV1 getStructureOutPec()
  {
    return structureOutPec;
  }
  
  public void setStructureOutPec(StructureOutPecV1 p_structureOutPec)
  {
    structureOutPec = p_structureOutPec;
  }
  
  public StructureOutDecisionSuivi getStructureOutDetectionSuivi()
  {
    return structureOutDecisionSuivi;
  }
  
  public void setStructureOutDetectionSuivi(StructureOutDecisionSuivi p_structureOutDecisionSuivi)
  {
    structureOutDecisionSuivi = p_structureOutDecisionSuivi;
  }
  
  public Pension getStructureOutPension()
  {
    return structureOutPension;
  }
  
  public void setStructureOutPension(Pension p_structureOutPension)
  {
    structureOutPension = p_structureOutPension;
  }
  
  public StructureOutDemandeV1 getStructureOutDemandeDAL()
  {
    return structureOutDemandeDAL;
  }
  
  public void setStructureOutDemandeDAL(StructureOutDemandeV1 p_structureOutDemandeDAL)
  {
    structureOutDemandeDAL = p_structureOutDemandeDAL;
  }
  
  public StructureOutDemandeV1 getStructureOutDemandeRNV()
  {
    return structureOutDemandeRNV;
  }
  
  public void setStructureOutDemandeRNV(StructureOutDemandeV1 p_structureOutDemandeRNV)
  {
    structureOutDemandeRNV = p_structureOutDemandeRNV;
  }
  
  public StructureOutListeRessourcesV1 getStructureOutListeRessourcesV1()
  {
    return structureOutListeRessourcesV1;
  }
  
  public void setStructureOutListeRessourcesV1(StructureOutListeRessourcesV1 outListeRessourcesV1)
  {
    structureOutListeRessourcesV1 = outListeRessourcesV1;
  }
  
  public StructureOutListePeriodeAAH getStructureOutListePeriodeAAH()
  {
    return structureOutListePeriodeAAH;
  }
  
  public void setStructureOutListePeriodeAAH(StructureOutListePeriodeAAH outListePeriodeAAH)
  {
    structureOutListePeriodeAAH = outListePeriodeAAH;
  }
}

/* Location:
 * Qualified Name:     StructureOutCaliV1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
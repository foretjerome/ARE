package fr.unedic.cali.autresdoms.d12i.dom;

import fr.pe.d12dal.service.es.dal.RetourLireDALCALI;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d12i.mapping.MapperInstruction;
import fr.unedic.cali.autresdoms.d12i.services.AppelServicesInstruction;
import fr.unedic.cali.dom.IndividuChargementSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import java.util.Map;

public class IndividuImplPersistant
  extends IndividuInstructionAbstrait
{
  public IndividuImplPersistant(IndividuIdSpec individuIdSpec)
  {
    super(individuIdSpec);
    setEstModifiable(false);
    setEstCharge(false);
  }
  
  public IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException
  {
    throw new UnsupportedOperationException("on ne doit plus charger Instruction complétement");
  }
  
  public DemandeInstruction getDemandeInstruction(String referenceExterne)
  {
    DemandeInstruction demandeInstruction = (DemandeInstruction)demandesInstruction.get(referenceExterne);
    if (demandeInstruction == null)
    {
      RetourLireDALCALI retourLireDALCALI = AppelServicesInstruction.lireDemandesInstructionNPDE(getIndividuId().getIndividu(), referenceExterne);
      Map<String, DemandeInstruction> listeDemandes = MapperInstruction.mapperListeDonneesDALetNPDE(retourLireDALCALI);
      demandeInstruction = (DemandeInstruction)listeDemandes.get(referenceExterne);
      demandesInstruction.put(referenceExterne, demandeInstruction);
    }
    return demandeInstruction;
  }
}

/* Location:
 * Qualified Name:     IndividuImplPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
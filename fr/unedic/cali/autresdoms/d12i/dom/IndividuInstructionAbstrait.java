package fr.unedic.cali.autresdoms.d12i.dom;

import fr.unedic.cali.autresdoms.d12i.dom.spec.IndividuInstructionSpec;
import fr.unedic.cali.dom.IndividuChargementSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import java.util.HashMap;
import java.util.Map;

public abstract class IndividuInstructionAbstrait
  implements IndividuInstructionSpec, IndividuChargementSpec
{
  private static final String NOM_INDIVIDU = "INSTRUCTION";
  private IndividuIdSpec identifiant = null;
  private boolean estCharge = true;
  private boolean estModifiable = false;
  protected Map<String, DemandeInstruction> demandesInstruction = null;
  
  public IndividuInstructionAbstrait()
  {
    demandesInstruction = new HashMap();
  }
  
  public IndividuInstructionAbstrait(IndividuIdSpec individuIdSpec)
  {
    setIndividuId(individuIdSpec);
    demandesInstruction = new HashMap();
  }
  
  public IndividuIdSpec getIndividuId()
  {
    return identifiant;
  }
  
  public void setIndividuId(IndividuIdSpec identifiant)
  {
    this.identifiant = identifiant;
  }
  
  public boolean estCharge()
  {
    return estCharge;
  }
  
  public void setEstCharge(boolean estCharge)
  {
    this.estCharge = estCharge;
  }
  
  public String getNomIndividu()
  {
    return "INSTRUCTION";
  }
  
  public boolean estModifiable()
  {
    return estModifiable;
  }
  
  public void setEstModifiable(boolean modifiable)
  {
    estModifiable = modifiable;
  }
  
  public void ajouterDonneesDAL(String refEx, DemandeInstruction donnees)
  {
    demandesInstruction.put(refEx, donnees);
  }
  
  public String toString()
  {
    StringBuilder chaineRetour = new StringBuilder();
    
    chaineRetour.append("Individu :" + getIndividuId() + "\n");
    chaineRetour.append("Demande : \n" + demandesInstruction);
    
    return chaineRetour.toString();
  }
}

/* Location:
 * Qualified Name:     IndividuInstructionAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.autresdoms.cohab.sigma.ressource.dom.spec;

import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.temps.Damj;

public abstract interface StructureOutRessourcesV1Spec
{
  public abstract String getIdentifiantDemande();
  
  public abstract void setIdentifiantDemande(String paramString);
  
  public abstract String getCodeSituationFamiliale();
  
  public abstract void setCodeSituationFamiliale(String paramString);
  
  public abstract QuantiteEuro getMontant();
  
  public abstract void setMontant(QuantiteEuro paramQuantiteEuro);
  
  public abstract String getCodeCertification();
  
  public abstract void setCodeCertification(String paramString);
  
  public abstract int getRang();
  
  public abstract void setRang(int paramInt);
  
  public abstract String getOrigine();
  
  public abstract void setOrigine(String paramString);
  
  public abstract Damj getDateEffet();
  
  public abstract void setDateEffet(Damj paramDamj);
  
  public abstract QuantiteEuro getRessourcesAllocataire();
  
  public abstract void setRessourcesAllocataire(QuantiteEuro paramQuantiteEuro);
  
  public abstract QuantiteEuro getRessourcesConjoint();
  
  public abstract void setRessourcesConjoint(QuantiteEuro paramQuantiteEuro);
  
  public abstract void setDateReference(Damj paramDamj);
  
  public abstract Damj getDateReference();
}

/* Location:
 * Qualified Name:     StructureOutRessourcesV1Spec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
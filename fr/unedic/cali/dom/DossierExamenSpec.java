package fr.unedic.cali.dom;

import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.util.List;

public abstract interface DossierExamenSpec
  extends ObjetPersistantSpec, Temporel
{
  public abstract DemandeSpec getDemande();
  
  public abstract DossierAffectationSpec getDossierAffecte();
  
  public abstract void setDossierAffecte(DossierAffectationSpec paramDossierAffectationSpec);
  
  public abstract DossierExamenSpec changerEtat(int paramInt)
    throws CoucheLogiqueException;
  
  public abstract Damj getDateAttribution();
  
  public abstract List getListConditionsAttribution();
  
  public abstract String getIdentifiant();
}

/* Location:
 * Qualified Name:     DossierExamenSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
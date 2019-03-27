package fr.unedic.cali.autresdoms.cohab.sigma.servicecali.dom.spec;

import fr.unedic.cali.autresdoms.cohab.sigma.dom.Spec.CriteresSpec;
import fr.unedic.util.temps.Damj;

public abstract interface CriteresCaliSpec
  extends CriteresSpec
{
  public abstract int getIdentifiantPriseEnCharge();
  
  public abstract void setIdentifiantPriseEnCharge(int paramInt);
  
  public abstract Damj getDateRecherchePec();
  
  public abstract void setDateRecherchePec(Damj paramDamj);
  
  public abstract Damj getDateDebutEvtActualisation();
  
  public abstract void setDateDebutEvtActualisation(Damj paramDamj);
  
  public abstract Damj getDateFinEvtActualisation();
  
  public abstract void setDateFinEvtActualisation(Damj paramDamj);
  
  public abstract int getIdentifiantActionFormation();
  
  public abstract void setIdentifiantActionFormation(int paramInt);
  
  public abstract Damj getDateRechercheFormation();
  
  public abstract void setDateRechercheFormation(Damj paramDamj);
  
  public abstract String getNumeroAllocataire();
  
  public abstract void setNumeroAllocataire(String paramString);
  
  public abstract String getIdentifiantDemande();
  
  public abstract void setIdentifiantDemande(String paramString);
  
  public abstract void setTypeSegment(String paramString);
  
  public abstract String getTypeSegmentV1();
  
  public abstract String getTypeDemande();
  
  public abstract String getIdentifiantRecherche();
  
  public abstract void setTypeDemande(String paramString);
  
  public abstract void setIdentifiantRecherche(String paramString);
}

/* Location:
 * Qualified Name:     CriteresCaliSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.periode.PeriodeNonDeclareeSanction;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract interface CalendrierExecutionCalculSpec
  extends ObjetPersistantSpec
{
  public static final int ETAT_ATTRIBUTION_AVANT_EXECUTION = 1;
  public static final int ETAT_ATTRIBUTION_PENDANT_EXECUTION = 2;
  public static final int ETAT_ATTRIBUTION_APRES_EXECUTION = 3;
  public static final int ETAT_ATTRIBUTION_ABANDONNEE = 4;
  public static final int ETAT_ATTRIBUTION_ARRETEE = 5;
  public static final int ETAT_ATTRIBUTION_DROIT_ETEINT = 6;
  
  public abstract int getEtatAttribution();
  
  public abstract void setEtatAttribution(int paramInt);
  
  public abstract Damj getPremierJourIndemnisable();
  
  public abstract void setPremierJourIndemnisable(Damj paramDamj);
  
  public abstract Damj getDernierJourIndemnisable();
  
  public abstract void setDernierJourIndemnisable(Damj paramDamj);
  
  public abstract void reinitialiserCalendrier(Damj paramDamj);
  
  public abstract Damj getDernierJourIndemnisablePourSuivi();
  
  public abstract void setDernierJourIndemnisablePourSuivi(Damj paramDamj);
  
  public abstract Collection getListePNDS();
  
  public abstract void remplacerCollectionDNJ(Collection paramCollection);
  
  public abstract Collection getListeDNJ();
  
  public abstract void remplacerCollectionPNDS(Collection paramCollection);
  
  public abstract void ajouterListeDNJ(Collection paramCollection);
  
  public abstract void ajouterListePNDS(PeriodeNonDeclareeSanction paramPeriodeNonDeclareeSanction);
  
  public abstract EtatAuDji getEtatAuDJI();
  
  public abstract void setEtatAuDJI(EtatAuDji paramEtatAuDji);
  
  public abstract Damj getDateFinDispositifCSP();
  
  public abstract Damj getDateEpuisementDuree();
  
  public abstract Damj getDateDrv();
  
  public abstract CalendrierExecutionCalculPeriodique dupliquerEtatAuDji();
}

/* Location:
 * Qualified Name:     CalendrierExecutionCalculSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
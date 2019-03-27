package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;

public abstract interface ResultatExecutionCalculSpec
{
  public static final int ETAT_SANS_OBJET = 0;
  public static final int ETAT_ETEINT = 1;
  public static final int ETAT_EPUISE = 2;
  public static final int ETAT_RELIQUAT = 3;
  public static final int ETAT_DECHU = 4;
  
  public abstract Damj getPji();
  
  public abstract boolean isDiffereEntame();
  
  public abstract void setDiffereEntame(boolean paramBoolean);
  
  public abstract List getListeCarencesEffectives();
  
  public abstract void setListeCarencesEffectives(List paramList);
  
  public abstract Quantite getReliquatDureeIndemnisation();
  
  public abstract Quantite getReliquatDureeProlongation();
  
  public abstract Damj getDernierJourIndemnisable();
  
  public abstract boolean isCalendrierNul();
  
  public abstract Damj recupererDJIParEpuisement(AttributionSpec paramAttributionSpec)
    throws ApplicativeException;
  
  public abstract Quantite getCapitalVerse();
  
  public abstract Periode determinerPeriodePriseEnCompteActiviteReduite();
  
  public abstract AttributionSpec getAttributionEtudiee();
  
  public abstract void setAttributionEtudiee(AttributionSpec paramAttributionSpec);
  
  public abstract int getNbJourFormation();
  
  public abstract MontantBaseSpec getMontant();
  
  public abstract int getEtatAttribution();
  
  public abstract void setEtatAttribution(int paramInt);
  
  public abstract Damj getDateEtatAttribution();
  
  public abstract boolean isReliquatPresent();
  
  public abstract boolean isEnAttenteRenouvellement();
  
  public abstract boolean isResultatAvantNul();
  
  public abstract boolean isResultatPendantNul();
  
  public abstract int getEtatResultatAvant();
  
  public abstract int getEtatResultatPendant();
  
  public abstract Damj getPremierJourAvant();
  
  public abstract Quantite getReliquatAREAvecMaintien();
  
  public abstract Quantite getReliquatDureeRenouvellement();
  
  public abstract int getContexteExamen();
  
  public abstract int getCumulJourIndemnise();
  
  public abstract Quantite getQuantiteFormation();
  
  public abstract Quantite getQuantiteAide();
  
  public abstract Quantite getQuantiteJourImputationDonneesForcees();
  
  public abstract Quantite getQuantiteReliquatRenouvellement();
  
  public abstract String getTypeAide();
  
  public abstract Quantite getCapitalADR();
  
  public abstract int getCumulMoisActiviteReduite();
  
  public abstract Damj recupererDateEpuisementDuree(AttributionSpec paramAttributionSpec)
    throws CoucheLogiqueException;
  
  public abstract Damj recupererDateFinDispositifCSP()
    throws CoucheLogiqueException;
  
  public abstract FormuleMontantSpec recupererFormuleMontant()
    throws CoucheLogiqueException;
  
  public abstract Quantite getReliquatFranchiseCP();
  
  public abstract Quantite getReliquatFranchiseSalaire();
  
  public abstract Quantite getReliquatDelaiAttente();
  
  public abstract Periode getPeriodeApplicationDelaiAttente();
  
  public abstract Periode getPeriodeApplicationFranchisesCP();
  
  public abstract Periode getPeriodeApplicationFranchisesSalaire();
}

/* Location:
 * Qualified Name:     ResultatExecutionCalculSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
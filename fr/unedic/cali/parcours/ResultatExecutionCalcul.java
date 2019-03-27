package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalcul;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.FormuleMontantSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.List;

public class ResultatExecutionCalcul
  extends Resultat
  implements ResultatExecutionCalculSpec
{
  private static final long serialVersionUID = 4531265686853876698L;
  private ResultatAvant resultatAvant;
  private ResultatDeterminationEtatDroitProduit resultatPendant;
  private ResultatApres resultatApres;
  private static final int SANS_ANTECEDENT = 1;
  
  private ResultatAvant getResultatAvant()
  {
    return resultatAvant;
  }
  
  public void setResultatAvant(ResultatAvant resultatAvant)
  {
    this.resultatAvant = resultatAvant;
  }
  
  private ResultatDeterminationEtatDroitProduit getResultatPendant()
  {
    return resultatPendant;
  }
  
  public void setResultatPendant(ResultatDeterminationEtatDroitProduit resultatPendant)
  {
    this.resultatPendant = resultatPendant;
  }
  
  private ResultatApres getResultatApres()
  {
    return resultatApres;
  }
  
  public void setResultatApres(ResultatApres resultatApres)
  {
    this.resultatApres = resultatApres;
  }
  
  public Damj getPji()
  {
    return getResultatAvant().getPji();
  }
  
  public boolean isDiffereEntame()
  {
    return getResultatAvant().isDiffereEntame();
  }
  
  public void setDiffereEntame(boolean differeEntame)
  {
    getResultatAvant().setDiffereEntame(differeEntame);
  }
  
  public List getListeCarencesEffectives()
  {
    if (getResultatAvant() == null) {
      return null;
    }
    return getResultatAvant().getListeCarencesEffectives();
  }
  
  public void setListeCarencesEffectives(List listeCarencesEffectives)
  {
    if (getResultatAvant() == null) {
      setResultatAvant(new ResultatAvant(null, listeCarencesEffectives, false));
    } else {
      getResultatAvant().setListeCarencesEffectives(listeCarencesEffectives);
    }
  }
  
  public Quantite getReliquatDureeIndemnisation()
  {
    Quantite reliquatDureeIndemnisation = null;
    if (getResultatApres() != null) {
      reliquatDureeIndemnisation = getResultatApres().getReliquatDureeIndemnisation();
    } else if (getResultatPendant() != null) {
      reliquatDureeIndemnisation = getResultatPendant().getReliquatDureeIndemnisation();
    }
    return reliquatDureeIndemnisation;
  }
  
  public Damj getDernierJourIndemnisable()
  {
    if ((getResultatPendant() == null) || (getResultatPendant().getEtat() == 1) || (getResultatPendant().getCalendrierExecutionCalcul() == null)) {
      return null;
    }
    return getResultatPendant().getCalendrierExecutionCalcul().getDernierJourIndemnisable();
  }
  
  public boolean isCalendrierNul()
  {
    return (getResultatPendant() == null) || (getResultatPendant().getCalendrierExecutionCalcul() == null);
  }
  
  public Damj recupererDJIParEpuisement(AttributionSpec attribution)
    throws ApplicativeException
  {
    Damj djiParEpuisement = null;
    if (attribution.getCalendrierExecutionCalcul() != null)
    {
      if ((attribution.getCalendrierExecutionCalcul() != null) && ((attribution.getCalendrierExecutionCalcul() instanceof CalendrierExecutionCalculPeriodique)) && (((CalendrierExecutionCalculPeriodique)attribution.getCalendrierExecutionCalcul()).getDateEpuisementDuree() != null)) {
        djiParEpuisement = ((CalendrierExecutionCalculPeriodique)attribution.getCalendrierExecutionCalcul()).getDateEpuisementDuree();
      } else if (((getResultatApres() != null) && (getResultatApres().getEtatAttribution() == 2)) || ((getResultatPendant() != null) && (getResultatPendant().getEtatAttribution() == 2))) {
        djiParEpuisement = attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable();
      }
    }
    else {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_CALENDRIER_NON_EXISTANT", new Object[] { attribution.getDateAttribution() });
    }
    return djiParEpuisement;
  }
  
  public Quantite getCapitalVerse()
  {
    if ((getResultatPendant() == null) || (getResultatPendant().getEtat() == 1)) {
      return null;
    }
    return getResultatPendant().getCapitalVerse();
  }
  
  public Periode determinerPeriodePriseEnCompteActiviteReduite()
  {
    Periode periodePriseEnCompte = null;
    if ((getResultatAvant() != null) && (getResultatAvant().getEtat() != 0))
    {
      periodePriseEnCompte = getResultatAvant().getPeriodePECEvenementReducteur();
    }
    else if ((getResultatAvant() != null) && (getResultatPendant() != null) && (getResultatAvant().getEtat() == 0) && (getResultatPendant().getEtat() == 0))
    {
      periodePriseEnCompte = getResultatPendant().getPeriodePriseEnCompteEvtsReducteurs();
      if (getResultatAvant().getPeriodePECEvenementReducteur() != null) {
        periodePriseEnCompte.setDebut(getResultatAvant().getPeriodePECEvenementReducteur().getDebut());
      }
    }
    return periodePriseEnCompte;
  }
  
  public int getNbJourFormation()
  {
    if ((getResultatPendant() == null) || (getResultatPendant().getEtat() == 1)) {
      return 0;
    }
    return getResultatPendant().getNbJourFormation();
  }
  
  public MontantBaseSpec getMontant()
  {
    if ((getResultatPendant() == null) || (getResultatPendant().getEtat() == 1)) {
      return null;
    }
    return getResultatPendant().getMontant();
  }
  
  public int getEtatAttribution()
  {
    if ((getResultatPendant() == null) || (getResultatPendant().getEtat() == 1)) {
      return 0;
    }
    if (getResultatApres() != null) {
      return getResultatApres().getEtatAttribution();
    }
    return getResultatPendant().getEtatAttribution();
  }
  
  public void setEtatAttribution(int etatAttribution)
  {
    if (getResultatPendant() == null) {
      setResultatPendant(new ResultatDeterminationEtatDroitProduit());
    }
    getResultatPendant().setEtatAttribution(etatAttribution);
  }
  
  public Damj getDateEtatAttribution()
  {
    if (getResultatApres() != null) {
      return getResultatApres().getDateEtatAttribution();
    }
    if ((getResultatAvant() != null) && ((getResultatAvant().getEtat() == 1) || (getResultatAvant().getEtat() == 9))) {
      return getResultatAvant().getDernierJourAvant();
    }
    return getResultatPendant().getDernierJourIndemnisable();
  }
  
  public AttributionSpec getAttributionEtudiee()
  {
    if (getResultatPendant() == null) {
      return null;
    }
    return getResultatPendant().getAttribution();
  }
  
  public void setAttributionEtudiee(AttributionSpec attribution)
  {
    if (getResultatPendant() == null) {
      setResultatPendant(new ResultatDeterminationEtatDroitProduit());
    }
    getResultatPendant().setAttribution(attribution);
  }
  
  public boolean isReliquatPresent()
  {
    return (getResultatAvant() != null) && (getResultatPendant().getEtatAttribution() == 3);
  }
  
  public boolean isEnAttenteRenouvellement()
  {
    return (getResultatPendant() != null) && (getResultatPendant().isEstEnAttenteRenouvellement());
  }
  
  public boolean isResultatAvantNul()
  {
    return getResultatAvant() == null;
  }
  
  public boolean isResultatPendantNul()
  {
    return getResultatPendant() == null;
  }
  
  public int getEtatResultatAvant()
  {
    int etatAvant = 0;
    if (getResultatAvant() != null) {
      etatAvant = getResultatAvant().getEtat();
    }
    return etatAvant;
  }
  
  public int getEtatResultatPendant()
  {
    int etatPendant = 0;
    if (getResultatPendant() != null) {
      etatPendant = getResultatPendant().getEtat();
    }
    return etatPendant;
  }
  
  public Damj getPremierJourAvant()
  {
    Damj premierJourAvant = null;
    if (getResultatAvant() != null) {
      premierJourAvant = getResultatAvant().getPremierJourAvant();
    }
    return premierJourAvant;
  }
  
  public Quantite getReliquatAREAvecMaintien()
  {
    Quantite reliquatAREAvecMaintien = null;
    if (getResultatApres() != null) {
      reliquatAREAvecMaintien = getResultatApres().getReliquatDureeIndemnisation();
    } else if (getResultatPendant() != null) {
      reliquatAREAvecMaintien = getResultatPendant().getReliquatAREAvecMaintien();
    }
    return reliquatAREAvecMaintien;
  }
  
  public Quantite getReliquatDureeRenouvellement()
  {
    Quantite reliquatDureeRenouvellement = null;
    if (getResultatPendant() != null) {
      reliquatDureeRenouvellement = getResultatPendant().getReliquatDureeRenouvellement();
    }
    return reliquatDureeRenouvellement;
  }
  
  public int getContexteExamen()
  {
    int contexteRetour = 1;
    if (getResultatApres() != null) {
      contexteRetour = getResultatApres().getContexteExamen();
    }
    return contexteRetour;
  }
  
  public int getCumulJourIndemnise()
  {
    int cumulJourServi = 0;
    if (getResultatPendant() != null) {
      cumulJourServi = getResultatPendant().getCumulJourIndemnise();
    }
    return cumulJourServi;
  }
  
  public Quantite getQuantiteFormation()
  {
    Quantite quantiteFormation = null;
    if (getResultatApres() != null) {
      quantiteFormation = getResultatApres().getQuantiteFormation();
    }
    return quantiteFormation;
  }
  
  public Quantite getQuantiteAide()
  {
    Quantite quantiteAide = null;
    if (getResultatApres() != null) {
      quantiteAide = getResultatApres().getQuantiteAide();
    }
    return quantiteAide;
  }
  
  public Quantite getQuantiteJourImputationDonneesForcees()
  {
    Quantite quantiteJourImputationDonneesForcees = null;
    if (getResultatApres() != null) {
      quantiteJourImputationDonneesForcees = getResultatApres().getQuantiteJourImputationDonneesForcees();
    }
    return quantiteJourImputationDonneesForcees;
  }
  
  public Quantite getQuantiteReliquatRenouvellement()
  {
    Quantite quantiteReliquatRenouvellement = null;
    if (getResultatApres() != null) {
      quantiteReliquatRenouvellement = getResultatApres().getQuantiteReliquatRenouvellement();
    }
    return quantiteReliquatRenouvellement;
  }
  
  public String getTypeAide()
  {
    String typeAide = null;
    if (getResultatApres() != null) {
      typeAide = getResultatApres().getTypeAide();
    }
    return typeAide;
  }
  
  public Quantite getReliquatDureeProlongation()
  {
    Quantite reliquatProlongation = null;
    if (getResultatPendant() != null) {
      reliquatProlongation = getResultatPendant().getReliquatProlongation();
    }
    return reliquatProlongation;
  }
  
  public Quantite getCapitalADR()
  {
    if ((getResultatPendant() == null) || (getResultatPendant().getEtat() == 1)) {
      return null;
    }
    return getResultatPendant().getCapitalADR();
  }
  
  public int getCumulMoisActiviteReduite()
  {
    if ((getResultatPendant() == null) || (getResultatPendant().getEtat() == 1)) {
      return 0;
    }
    return getResultatPendant().getCumulMoisActiviteReduite();
  }
  
  public Quantite getMontantIndemNonDerogatoire()
  {
    if ((getResultatPendant() == null) || (getResultatPendant().getEtat() == 1)) {
      return new QuantiteEuro("0");
    }
    return getResultatPendant().getMontantIndemNonDerog();
  }
  
  public Quantite getMontantIndemDerogatoire()
  {
    if ((getResultatPendant() == null) || (getResultatPendant().getEtat() == 1)) {
      return new QuantiteEuro("0");
    }
    return getResultatPendant().getMontantIndemDerog();
  }
  
  public Damj recupererDateEpuisementDuree(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    return null;
  }
  
  public Damj recupererDateFinDispositifCSP()
    throws CoucheLogiqueException
  {
    Damj dateFinCSP = null;
    if ((getResultatPendant() != null) && (getResultatPendant().getCalendrierExecutionCalcul() != null)) {
      dateFinCSP = ((CalendrierExecutionCalcul)getResultatPendant().getCalendrierExecutionCalcul()).getDateFinDispositifCSP();
    } else if (getResultatPendant() != null) {
      dateFinCSP = ((AttributionAssuranceSpec)getResultatPendant().getAttribution()).getDateLimiteIndemnisation();
    }
    return dateFinCSP;
  }
  
  public FormuleMontantSpec recupererFormuleMontant()
    throws CoucheLogiqueException
  {
    return getResultatPendant().getFormuleMontant();
  }
  
  public Quantite getReliquatFranchiseCP()
  {
    if (getResultatAvant().getReliquatFranchiseCP() != null) {
      return getResultatAvant().getReliquatFranchiseCP();
    }
    return getResultatPendant().getReliquatFranchiseCP();
  }
  
  public Quantite getReliquatFranchiseSalaire()
  {
    if (getResultatAvant().getReliquatFranchiseSalaire() != null) {
      return getResultatAvant().getReliquatFranchiseSalaire();
    }
    return getResultatPendant().getReliquatFranchiseSalaire();
  }
  
  public Periode getPeriodeApplicationFranchisesCP()
  {
    if (getResultatAvant().getPeriodeApplicationFranchiseCP() != null) {
      return getResultatAvant().getPeriodeApplicationFranchiseCP();
    }
    return null;
  }
  
  public Periode getPeriodeApplicationFranchisesSalaire()
  {
    if (getResultatAvant().getPeriodeApplicationFranchiseSalaire() != null) {
      return getResultatAvant().getPeriodeApplicationFranchiseSalaire();
    }
    return null;
  }
  
  public Quantite getReliquatDelaiAttente()
  {
    return getResultatPendant().getReliquatDelaiAttente();
  }
  
  public Periode getPeriodeApplicationDelaiAttente()
  {
    return getResultatPendant().getPeriodeApplicationDelaiAttente();
  }
}

/* Location:
 * Qualified Name:     ResultatExecutionCalcul
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ComportementExamenFilEauSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DomSimulationAffiliation;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.conteneurs.DonneesEntreeConstructionChronologie;
import fr.unedic.cali.dom.conteneurs.DonneesEntreePRC;
import fr.unedic.cali.dom.conteneurs.DonneesEntreesRecuperationMontant;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.ResultatTraitementPopulation;
import fr.unedic.cali.utilitaire.decideur.spec.DecideurDecisionSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;

public abstract interface FacadeLiquidationGammeAsuSpec
  extends FacadeLiquidationGammeSpec
{
  public abstract boolean estImputeeSurArce(DemandeSpec paramDemandeSpec);
  
  public abstract ArrayList getCatA2BParam();
  
  public abstract void positionnerCriteresQualifSurPas(DemandeSpec paramDemandeSpec, IndividuSpec paramIndividuSpec, TravailSpec paramTravailSpec)
    throws CoucheLogiqueException;
  
  public abstract Resultat executerExamenFilEau(IndividuSpec paramIndividuSpec, ComportementExamenFilEauSpec paramComportementExamenFilEauSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract Resultat executerSimulationAffiliation(DomSimulationAffiliation paramDomSimulationAffiliation)
    throws ApplicativeException;
  
  public abstract ResultatTraitementPopulation effectuerTraitementOccasionnel(CriteresTraitementPopulation paramCriteresTraitementPopulation)
    throws ApplicativeException;
  
  public abstract Damj getDateFaitGenerateurOdPrecedente(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateFaitGenerateurOdPrecedenteSaufAfd(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateFaitGenerateurOdPrecedenteSaufAfdEtAps(DemandeSpec paramDemandeSpec);
  
  public abstract Damj getDateEffetMaintien(AttributionSpec paramAttributionSpec);
  
  public abstract int definirStatutUt(AttributionSpec paramAttributionSpec, ChronologiePeriodes paramChronologiePeriodes, int paramInt, boolean paramBoolean, UniteTraitement paramUniteTraitement, ArretProduitAvecRaison paramArretProduitAvecRaison, FacadeCalculProduitSpec paramFacadeCalculProduitSpec)
    throws CoucheLogiqueException;
  
  public abstract boolean estDemandeFinDroitAsrAtp(DemandeSpec paramDemandeSpec);
  
  public abstract boolean estDemandeFinDroitAre(DemandeSpec paramDemandeSpec);
  
  public abstract boolean estUnDroitSecteurPublic(DemandeSpec paramDemandeSpec);
  
  public abstract boolean estFinancementPartage(DemandeSpec paramDemandeSpec);
  
  public abstract Periode determinerPrc(DonneesEntreePRC paramDonneesEntreePRC)
    throws ApplicativeException;
  
  public abstract Chronologie determinerChronoActiviteSalariePrc(DonneesEntreeConstructionChronologie paramDonneesEntreeConstructionChronologie)
    throws ApplicativeException;
  
  public abstract Chronologie determinerChronoActiviteInappartenancePrc(DonneesEntreeConstructionChronologie paramDonneesEntreeConstructionChronologie)
    throws ApplicativeException;
  
  public abstract Chronologie determinerChronoPeriodeDeductiblePrc(DonneesEntreeConstructionChronologie paramDonneesEntreeConstructionChronologie)
    throws ApplicativeException;
  
  public abstract Chronologie getChronologieCatA2BParam();
  
  public abstract boolean notifierAttributionPourEESSI(DemandeSpec paramDemandeSpec);
  
  public abstract DecideurDecisionSpec determinerDecideursPourComportement(String paramString);
  
  public abstract FiltreCaliSpec retournerFiltreAttributionGammeAsuProduit();
  
  public abstract DonneesEntreesRecuperationMontant mapperDonneesEntreesRecuperationMontant(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal recupereParametresAllocationMinimaleAre(Damj paramDamj);
  
  public abstract Damj calculerPointDepartCSP(DemandeSpec paramDemandeSpec);
  
  public abstract boolean detecterAssSuiteDecheance(DemandeSpec paramDemandeSpec);
  
  public abstract boolean detecterRepriseAssSuiteReinscription(DemandeSpec paramDemandeSpec);
  
  public abstract EvenementReferenceExamenSpec recupererEvenementReferenceExamen(String paramString);
  
  public abstract void setDateDepotOrigine(DemandeSpec paramDemandeSpec, Damj paramDamj);
}

/* Location:
 * Qualified Name:     FacadeLiquidationGammeAsuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
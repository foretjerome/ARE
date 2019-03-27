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
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.conteneurs.DonneesEntreeConstructionChronologie;
import fr.unedic.cali.dom.conteneurs.DonneesEntreePRC;
import fr.unedic.cali.dom.conteneurs.DonneesEntreesRecuperationMontant;
import fr.unedic.cali.parcours.DomLiquidationDemande;
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
import java.util.Iterator;
import java.util.List;

public class GammeAsu
  extends GammeAbstrait
  implements GammeAsuSpec
{
  private static final long serialVersionUID = 8298572529744093206L;
  private static final String GAMME_DELEGUEE = "fr.unedic.cali.asu.GammeAsuDelegue";
  private static GammeDelegueSpec gammeDeleguee;
  private static GammeAsu instanceUnique;
  
  public GammeAsu()
  {
    ajouterLigne(LigneAsuCge01.getInstancePourInitialisation());
    ajouterLigne(LigneAsuSpe02.getInstancePourInitialisation());
    ajouterLigne(LigneAsuExp03.getInstancePourInitialisation());
    ajouterLigne(LigneAsuCsa06.getInstancePourInitialisation());
    ajouterLigne(LigneAsuCSR04.getInstancePourInitialisation());
    ajouterLigne(LigneAsuSsp07.getInstancePourInitialisation());
    ajouterLigne(LigneAsuFds12.getInstancePourInitialisation());
    ajouterLigne(LigneAsuCaa14.getInstancePourInitialisation());
    ajouterLigne(LigneAsuCva10.getInstancePourInitialisation());
    ajouterLigne(LigneAsuCve13.getInstancePourInitialisation());
    ajouterLigne(LigneAsuEur05.getInstancePourInitialisation());
    ajouterLigne(LigneAsuDdm16.getInstancePourInitialisation());
    ajouterLigne(LigneAsuMay17.getInstancePourInitialisation());
    setNomUnique("ASU");
    setLibelle("Gamme Assurance");
  }
  
  public static GammeAsu getInstance()
  {
    
    if (instanceUnique == null) {
      instanceUnique = new GammeAsu();
    }
    return instanceUnique;
  }
  
  protected static GammeSpec getInstancePourInitialisation()
  {
    if (instanceUnique == null) {
      instanceUnique = new GammeAsu();
    }
    return instanceUnique;
  }
  
  public GammeDelegueSpec getGammeDelegue()
  {
    if (gammeDeleguee == null) {
      gammeDeleguee = creerGammeDelegue("fr.unedic.cali.asu.GammeAsuDelegue");
    }
    return gammeDeleguee;
  }
  
  public List getReglements(Damj date)
  {
    List listeReglements = new ArrayList();
    for (Iterator listeProduits = getProduitsActifs(date).iterator(); listeProduits.hasNext();)
    {
      ProduitAsuSpec produit = (ProduitAsuSpec)listeProduits.next();
      for (reglementsProduits = produit.getListeReglements().iterator(); reglementsProduits.hasNext();) {
        listeReglements.add(reglementsProduits.next());
      }
    }
    Iterator reglementsProduits;
    return listeReglements;
  }
  
  public int getPriorite()
  {
    return 12;
  }
  
  private GammeAsuDelegueSpec getGammeAsuDelegue()
  {
    return (GammeAsuDelegueSpec)getGammeDelegue();
  }
  
  public boolean estImputeeSurArce(DemandeSpec demande)
  {
    return getGammeAsuDelegue().estImputeeSurArce(demande);
  }
  
  public ArrayList getCatA2BParam()
  {
    return getGammeAsuDelegue().getCatA2BParam();
  }
  
  public void positionnerCriteresQualifSurPas(DemandeSpec demande, IndividuSpec individu, TravailSpec dernierSinistre)
    throws CoucheLogiqueException
  {
    getGammeAsuDelegue().positionnerCriteresQualifSurPas(demande, individu, dernierSinistre);
  }
  
  public void controlerInvestigationFrauduleuse(DomLiquidationDemande dom)
  {
    getGammeAsuDelegue().controlerInvestigationFrauduleuse(dom);
  }
  
  public Resultat executerExamenFilEau(IndividuSpec individu, ComportementExamenFilEauSpec comportement, Damj dateEvenement)
    throws ApplicativeException
  {
    return getGammeAsuDelegue().executerExamenFilEau(individu, comportement, dateEvenement);
  }
  
  public Resultat executerSimulationAffiliation(DomSimulationAffiliation domSimulationAffiliation)
    throws ApplicativeException
  {
    return getGammeAsuDelegue().executerSimulationAffiliation(domSimulationAffiliation);
  }
  
  public void mettreEnReexamen(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    getGammeAsuDelegue().mettreEnReexamen(demande);
  }
  
  public Damj getDateFaitGenerateurOdPrecedente(DemandeSpec demande)
  {
    return getGammeAsuDelegue().getDateFaitGenerateurOdPrecedente(demande);
  }
  
  public Damj getDateFaitGenerateurOdPrecedenteSaufAfd(DemandeSpec demande)
  {
    return getGammeAsuDelegue().getDateFaitGenerateurOdPrecedenteSaufAfd(demande);
  }
  
  public Damj getDateFaitGenerateurOdPrecedenteSaufAfdEtAps(DemandeSpec demande)
  {
    return getGammeAsuDelegue().getDateFaitGenerateurOdPrecedenteSaufAfdEtAps(demande);
  }
  
  public Damj getDateEffetMaintien(AttributionSpec attribution)
  {
    return getGammeAsuDelegue().getDateEffetMaintien(attribution);
  }
  
  public void initialiserDemandeAssociee(Individu individu, DemandeSpec demande)
  {
    getGammeAsuDelegue().initialiserDemandeAssociee(individu, demande);
  }
  
  public int definirStatutUt(AttributionSpec attribution, ChronologiePeriodes periodesDecalantes, int nbPPA, boolean contientFormation, UniteTraitement ut, ArretProduitAvecRaison arretProduitAvecRaison, FacadeCalculProduitSpec facadeCalculProduit)
    throws CoucheLogiqueException
  {
    return 0;
  }
  
  public boolean estDemandeFinDroitAre(DemandeSpec demande)
  {
    return getGammeAsuDelegue().estDemandeFinDroitAre(demande);
  }
  
  public boolean estDemandeFinDroitAsrAtp(DemandeSpec demande)
  {
    return getGammeAsuDelegue().estDemandeFinDroitAsrAtp(demande);
  }
  
  public boolean estUnDroitSecteurPublic(DemandeSpec demande)
  {
    return getGammeAsuDelegue().estUnDroitSecteurPublic(demande);
  }
  
  public boolean estFinancementPartage(DemandeSpec demande)
  {
    return getGammeAsuDelegue().estFinancementPartage(demande);
  }
  
  public Periode determinerPrc(DonneesEntreePRC donneesEntreePRC)
    throws ApplicativeException
  {
    return getGammeAsuDelegue().determinerPrc(donneesEntreePRC);
  }
  
  public Chronologie determinerChronoActiviteInappartenancePrc(DonneesEntreeConstructionChronologie donneesEntree)
    throws ApplicativeException
  {
    return getGammeAsuDelegue().determinerChronoActiviteInappartenancePrc(donneesEntree);
  }
  
  public Chronologie determinerChronoActiviteSalariePrc(DonneesEntreeConstructionChronologie donneesEntree)
    throws ApplicativeException
  {
    return getGammeAsuDelegue().determinerChronoActiviteSalariePrc(donneesEntree);
  }
  
  public Chronologie determinerChronoPeriodeDeductiblePrc(DonneesEntreeConstructionChronologie donneesEntree)
    throws ApplicativeException
  {
    return getGammeAsuDelegue().determinerChronoPeriodeDeductiblePrc(donneesEntree);
  }
  
  public Chronologie getChronologieCatA2BParam()
  {
    return getGammeAsuDelegue().getChronologieCatA2BParam();
  }
  
  public boolean notifierAttributionPourEESSI(DemandeSpec demande)
  {
    return getGammeAsuDelegue().notifierAttributionPourEESSI(demande);
  }
  
  public DecideurDecisionSpec determinerDecideursPourComportement(String codeComportement)
  {
    return getGammeAsuDelegue().determinerDecideursPourComportement(codeComportement);
  }
  
  public FiltreCaliSpec retournerFiltreAttributionGammeAsuProduit()
  {
    return getGammeAsuDelegue().retournerFiltreAttributionGammeAsuProduit();
  }
  
  public DonneesEntreesRecuperationMontant mapperDonneesEntreesRecuperationMontant(AttributionSpec attribution)
  {
    return getGammeAsuDelegue().mapperDonneesEntreesRecuperationMontant(attribution);
  }
  
  public BigDecimal recupereParametresAllocationMinimaleAre(Damj dateAccesParametre)
  {
    return getGammeAsuDelegue().recupereParametresAllocationMinimaleAre(dateAccesParametre);
  }
  
  public Damj calculerPointDepartCSP(DemandeSpec demande)
  {
    return getGammeAsuDelegue().calculerPointDepartCSP(demande);
  }
  
  public boolean detecterAssSuiteDecheance(DemandeSpec demande)
  {
    return getGammeAsuDelegue().detecterAssSuiteDecheance(demande);
  }
  
  public boolean detecterRepriseAssSuiteReinscription(DemandeSpec demande)
  {
    return getGammeAsuDelegue().detecterRepriseAssSuiteReinscription(demande);
  }
  
  public EvenementReferenceExamenSpec recupererEvenementReferenceExamen(String typeExamen)
  {
    return getGammeAsuDelegue().recupererEvenementReferenceExamen(typeExamen);
  }
  
  public boolean controlerPrescription(FormulaireSpec formulaire)
  {
    return getGammeAsuDelegue().controlerPrescription(formulaire);
  }
  
  public void setDateDepotOrigine(DemandeSpec demande, Damj dateDepot)
  {
    getGammeAsuDelegue().setDateDepotOrigine(demande, dateDepot);
  }
}

/* Location:
 * Qualified Name:     GammeAsu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
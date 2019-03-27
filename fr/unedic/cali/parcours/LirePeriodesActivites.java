package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.mapping.LireListePeriodeResultat;
import fr.unedic.cali.autresdoms.ga.services.AppelServicesGaec;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeInr;
import fr.unedic.cali.dom.affectation.GammeRbf;
import fr.unedic.cali.dom.affectation.ProduitAsuSpec;
import fr.unedic.cali.outilsfonctionnels.ComparateurTemporelSurDateDebutDecroissante;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalarie;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDateDebutPosterieurDate;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionStandardAssurance;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourERE;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import java.util.ArrayList;
import java.util.Collection;

public class LirePeriodesActivites
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatLirePeriodesActivites resultat = new ResultatLirePeriodesActivites();
    
    IndividuSpec individu = getIndividu(contexte);
    
    LireListePeriodeResultat resultatGaec = AppelServicesGaec.lireListePeriode(individu.getIndividuId());
    
    String idDemande = ((DomLirePeriodesActivites)contexte.getDonnees()).getIdDemande();
    DemandeSpec demande = individu.rechercherDemande(idDemande);
    Damj dateDebutRecherche = ((DomLirePeriodesActivites)contexte.getDonnees()).getDateDebutRecherche();
    
    Collection activites = filtrerResultatGaec(resultatGaec, individu, demande, dateDebutRecherche);
    
    Collection activitesLiees = determinerPeriodesActivitesLiees(individu, demande);
    
    resultat.setCollectionPeriodesActivites(activites);
    resultat.setTablePeriodesActivitesLiees(activitesLiees);
    
    return resultat;
  }
  
  private Collection filtrerResultatGaec(LireListePeriodeResultat resultat, IndividuSpec individu, DemandeSpec demande, Damj dateDebutRecherche)
  {
    Chronologie chronologie = resultat.getChronoPeriodesPasseProfessionnel().copier(new FiltreActiviteSalarie());
    
    chronologie.setComparateur(new ComparateurTemporelSurDateDebutDecroissante());
    
    FiltreTemporel filtre = filtrerEnFonctionTypeDemande(individu, demande, dateDebutRecherche);
    if (filtre != null) {
      chronologie = chronologie.copier(filtre);
    }
    return chronologie.mapperVersCollection();
  }
  
  private FiltreTemporel filtrerEnFonctionTypeDemande(IndividuSpec individu, DemandeSpec demande, Damj dateDebutRecherche)
  {
    FiltreTemporel filtre = null;
    if ("INR_03".equals(demande.getEvenementReferenceExamen().getTypeExamen()))
    {
      AttributionSpec attributionArePrecedente = (AttributionSpec)OutilRecherche.rechercherDecisionPrecedente(individu.getChronoDemandeAssurance(), demande.getDateDepot().lendemain(), new FiltreAttributionStandardAssurance(false, true, false, false, demande));
      
      Damj dateFGD = Damj.NUIT_DES_TEMPS;
      if (attributionArePrecedente != null) {
        dateFGD = ((ProduitAsuSpec)attributionArePrecedente.getDossierAffecte().getProduit()).getDateFaitGenerateurAttributionMaitre(attributionArePrecedente);
      }
      Damj dateMax = dateFGD;
      if (dateDebutRecherche != null) {
        dateMax = Damj.max(dateMax, dateDebutRecherche);
      }
      filtre = new FiltreDateDebutPosterieurDate(dateMax);
    }
    return filtre;
  }
  
  private Collection determinerPeriodesActivitesLiees(IndividuSpec individu, DemandeSpec demande)
  {
    Collection activitesLiees = new ArrayList();
    
    FiltreDemandePourERE filtre = new FiltreDemandePourERE(demande.getEvenementReferenceExamen().getTypeExamen());
    
    Chronologie demandes = OutilRecherche.rechercherDemandesPrecedentes(individu.getChronoDemandes(), Damj.FIN_DES_TEMPS, filtre);
    
    demandes.iterer();
    while (demandes.encoreSuivant())
    {
      DemandeSpec demandeCourante = (DemandeSpec)demandes.elementSuivant();
      
      String idDemandeCourante = demandeCourante.getIdentifiant();
      if (!idDemandeCourante.equals(demande.getIdentifiant()))
      {
        String idActiviteLiee = recupererIdentifiantActiviteLiee(demandeCourante);
        if ((idActiviteLiee != null) && (!idActiviteLiee.trim().equals(""))) {
          activitesLiees.add(idActiviteLiee.trim());
        }
      }
    }
    return activitesLiees;
  }
  
  private String recupererIdentifiantActiviteLiee(DemandeSpec demande)
  {
    String activiteLiee = null;
    if (("INR_03".equals(demande.getEvenementReferenceExamen().getTypeExamen())) || ("INR_04".equals(demande.getEvenementReferenceExamen().getTypeExamen()))) {
      activiteLiee = GammeInr.getInstance().getIdActiviteLiee(demande);
    } else if (("RBF_03".equals(demande.getEvenementReferenceExamen().getTypeExamen())) || ("RBF_04".equals(demande.getEvenementReferenceExamen().getTypeExamen()))) {
      activiteLiee = GammeRbf.getInstance().getIdActiviteSalarieeLiee(demande);
    }
    return activiteLiee;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null)
    {
      Collection typePeriodesGaec = new ArrayList();
      ajouterSiNouveau("9", typePeriodesGaec);
      
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(1);
      individu.getDonneesChargementGaec().getAgregatGaec().setTypePeriodesGaec(typePeriodesGaec);
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    AppelGaecReduit gaecReduit = individu.getDonneesChargementGaec().getAppelGaecReduit();
    
    controlerModeAppel(gaecReduit, 1);
    
    controlerTypePeriode(gaecReduit.getTypePeriodes(), "9");
  }
}

/* Location:
 * Qualified Name:     LirePeriodesActivites
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.calcul.FacadeCalculProduitFactory;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalcul;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.PeriodeEvenementBloquant;
import fr.unedic.cali.calcul.dom.periode.PeriodeExclusionDefinitiveDDTE;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalcul;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeRetraite;
import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.cali.calcul.pbjc.dom.DroitPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.EnquetePbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.RenouvellementSpec;
import fr.unedic.cali.dom.RepriseSpec;
import fr.unedic.cali.dom.Retraite;
import fr.unedic.cali.dom.affectation.GammeAsuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.persistance.util.ContextePersistance;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.GestionAnomalies;
import fr.unedic.cali.outilsfonctionnels.OutilRetraite;
import fr.unedic.cali.parcours.ContexteParcoursCalcul;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourNatureDecision;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourTypeContexteDemande;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandesSuivantesSurDemandes;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreReexamenSurDemande;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreValideeSurDecision;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Heure;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class GestionSuivi
{
  private static final int MULTIPLICATEUR_HEURE = 10000;
  private static final int MULTIPLICATEUR_MINUTE = 100;
  
  public static void nettoyerEnquetePbjcNcp(Damj date, IndividuSpec individu)
  {
    if (ContexteParcoursCalcul.estPersistant())
    {
      List enquetes = null;
      Iterator iterateur = null;
      EnquetePbjcNcp enquetePbjcNcp = null;
      ArrayList<EnquetePbjcNcp> listeEnqueteASuppr = new ArrayList();
      
      enquetes = individu.getListEnquetesPbjcNcp();
      if (enquetes != null)
      {
        iterateur = enquetes.iterator();
        while (iterateur.hasNext())
        {
          enquetePbjcNcp = (EnquetePbjcNcp)iterateur.next();
          if ((enquetePbjcNcp.getDateSituationSuivi().estApresOuCoincideAvec(date)) && 
            (enquetePbjcNcp.getTypeSituationSuivi() != 3))
          {
            DomManager.supprimer(enquetePbjcNcp);
            listeEnqueteASuppr.add(enquetePbjcNcp);
          }
        }
        if (!listeEnqueteASuppr.isEmpty())
        {
          Iterator ite = listeEnqueteASuppr.iterator();
          while (ite.hasNext()) {
            enquetes.remove((EnquetePbjcNcp)ite.next());
          }
        }
      }
    }
  }
  
  public static void nettoyerIndividuPbjcNcp(IndividuSpec individu, Damj date)
    throws CoucheLogiqueException
  {
    IndividuPbjcNcp individuPbjcNcp = null;
    Damj ddjin = null;
    Damj dat3m = null;
    Damj ddaid = null;
    Damj dfaid = null;
    if (ContextePersistance.isPersistant())
    {
      individuPbjcNcp = individu.getIndividuPbjcNcp();
      if (individuPbjcNcp != null)
      {
        ddjin = individuPbjcNcp.getDernierJourIndemnisable();
        if ((ddjin == null) || (ddjin.estApresOuCoincideAvec(date))) {
          individuPbjcNcp.setDernierJourIndemnisable(OutilRetraite.getInstance().determinerRetraite(individu).getDate());
        }
        dat3m = individuPbjcNcp.getDateAtteinteMoisNonPaye();
        if ((dat3m != null) && (dat3m.estApresOuCoincideAvec(date))) {
          individuPbjcNcp.setDateAtteinteMoisNonPaye(null);
        }
        ddaid = individuPbjcNcp.getDateDebutIneligibiliteAidesMob();
        dfaid = individuPbjcNcp.getDateFinIneligibiliteAidesMob();
        if (((ddaid != null) && (ddaid.estApresOuCoincideAvec(date))) || ((dfaid != null) && (dfaid.estApresOuCoincideAvec(date))))
        {
          individuPbjcNcp.setDateDebutIneligibiliteAidesMob(null);
          individuPbjcNcp.setDateFinIneligibiliteAidesMob(null);
        }
        GestionAnomalies.supprimeAnomalie(date, individu);
      }
    }
  }
  
  public static void enregistrerEnquetePbjcNcp(AttributionSpec attribution, Damj date, int type, int rang, boolean aEmettre, String codeCategorie, FacadeCalculProduitSpec facadeCalculProduit, ConstituantsIndemnisation constituantsIndemnisation)
  {
    if ((attribution.getDemandeur().getDateBlocageIndemnisation() == null) || (date.estAvant(attribution.getDemandeur().getDateBlocageIndemnisation()))) {
      if ((ContexteParcoursCalcul.estPersistant()) && (facadeCalculProduit.enregistrerEnquetePBJCNCP()))
      {
        EnquetePbjcNcp enquetePbjcNcp = null;
        EnquetePbjcNcp enquetePbjcNcpPersistant = null;
        
        enquetePbjcNcp = creerEnquetePbjcNcp(attribution, date, type, rang, aEmettre, codeCategorie, facadeCalculProduit);
        if ((enquetePbjcNcp != null) && (enquetePbjcNcp.getTypeSituationSuivi() != 0) && 
          (OutilsMaintienEuropeenEessiHorsGamme.estProductionEnquetePendantMaintienEuropeen(type, attribution.getDemandeur(), date))) {
          if ((type == 3) || (type == 1) || (type == 2))
          {
            enquetePbjcNcpPersistant = retourneEnqueteRetraiteEnPersistance(attribution.getDemandeur().getListEnquetesPbjcNcp(), enquetePbjcNcp.getTypeSituationSuivi(), enquetePbjcNcp.getRangSituation());
            if (enquetePbjcNcpPersistant == null) {
              attribution.getDemandeur().getListEnquetesPbjcNcp().add(enquetePbjcNcp);
            }
          }
          else
          {
            enquetePbjcNcpPersistant = retourneEnqueteEnPersistance(attribution.getDemandeur().getListEnquetesPbjcNcp(), enquetePbjcNcp.getIdentOuvertureDroit(), enquetePbjcNcp.getTypeSituationSuivi(), enquetePbjcNcp.getRangSituation());
            if (enquetePbjcNcpPersistant != null)
            {
              DomManager.supprimer(enquetePbjcNcpPersistant);
              attribution.getDemandeur().getListEnquetesPbjcNcp().remove(enquetePbjcNcpPersistant);
            }
            attribution.getDemandeur().getListEnquetesPbjcNcp().add(enquetePbjcNcp);
          }
        }
      }
    }
  }
  
  public static void enregistrerEnquetePbjcNcpSurAvant(AttributionSpec attribution, Damj date, int type, int rang, boolean aEmettre, String codeCategorie)
  {
    if (((attribution.getDemandeur().getDateBlocageIndemnisation() == null) || (date.estAvant(attribution.getDemandeur().getDateBlocageIndemnisation()))) && (ContexteParcoursCalcul.estPersistant()))
    {
      EnquetePbjcNcp enquetePbjcNcp = null;
      EnquetePbjcNcp enquetePbjcNcpPersistant = null;
      
      enquetePbjcNcp = creerEnquetePbjcNcpPourAvant(attribution, date, type, rang, aEmettre, codeCategorie);
      if ((enquetePbjcNcp != null) && (enquetePbjcNcp.getTypeSituationSuivi() != 0))
      {
        enquetePbjcNcpPersistant = retourneEnqueteEnPersistance(attribution.getDemandeur().getListEnquetesPbjcNcp(), enquetePbjcNcp.getIdentOuvertureDroit(), enquetePbjcNcp.getTypeSituationSuivi(), enquetePbjcNcp.getRangSituation());
        if (enquetePbjcNcpPersistant != null)
        {
          DomManager.supprimer(enquetePbjcNcpPersistant);
          attribution.getDemandeur().getListEnquetesPbjcNcp().remove(enquetePbjcNcpPersistant);
        }
        attribution.getDemandeur().getListEnquetesPbjcNcp().add(enquetePbjcNcp);
      }
    }
  }
  
  public static void nettoyerDroitPbjcNcp(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    FacadeCalculProduitSpec facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
    if ((ContexteParcoursCalcul.estPersistant()) && (facadeCalculProduit.enregistrerDroitPBJCNCP(attribution)) && (!(attribution instanceof RepriseSpec)) && (!(attribution instanceof RenouvellementSpec)))
    {
      DroitPbjcNcp droitPbjcNcp = recupererDroitPbjcNcp(attribution.getDemandeur().getListDroitsPbjcsNcp(), Integer.valueOf(attribution.getRsod()).intValue());
      if (droitPbjcNcp != null)
      {
        DomManager.supprimer(droitPbjcNcp);
        attribution.getDemandeur().getListDroitsPbjcsNcp().remove(droitPbjcNcp);
      }
    }
  }
  
  public static void enregistrerDroitPbjcNcp(AttributionSpec attribution, Damj dateFinDroitTheorique, FacadeCalculProduitSpec facadeCalculProduit, CalendrierExecutionCalculSpec calendrierExecutionCalcul)
    throws CoucheLogiqueException
  {
    if ((ContexteParcoursCalcul.estPersistant()) && (facadeCalculProduit.enregistrerDroitPBJCNCP(attribution)))
    {
      DroitPbjcNcp droitPbjcNcp = null;
      attribution.getDemandeur().setDateDebutGenerationDroits(dateFinDroitTheorique);
      
      droitPbjcNcp = new DroitPbjcNcp(Integer.valueOf(attribution.getRsod()).intValue());
      droitPbjcNcp.setDateFinDeDroit(dateFinDroitTheorique);
      if ((attribution.getGamme() instanceof GammeAsuSpec))
      {
        Damj dateEffetMaintien = ((GammeAsuSpec)attribution.getGamme()).getDateEffetMaintien(attribution);
        if (dateEffetMaintien != null) {
          droitPbjcNcp.setDateEffetMaintien(dateEffetMaintien);
        }
      }
      droitPbjcNcp.setDateEffetPjiMaintienEESSI(facadeCalculProduit.getPjiMaintienEuropeenDuDroit(attribution));
      droitPbjcNcp.setDateEffetIdeMaintienEESSI(facadeCalculProduit.getIdeMaintienEuropeenDuDroit(attribution));
      droitPbjcNcp.setDateEffetDjiMaintienEESSI(facadeCalculProduit.getDjiMaintienEuropeenDuDroit(attribution));
      if (facadeCalculProduit.getPjiMaintienEuropeenDuDroit(attribution) != null) {
        droitPbjcNcp.setIndicateurMaintienEESSI(true);
      }
      if ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique))
      {
        CalendrierExecutionCalculPeriodique calendrierCalcul = (CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul;
        if (calendrierCalcul.getDateFinDispositifCSP() != null) {
          droitPbjcNcp.setDateFinCSP(calendrierCalcul.getDateFinDispositifCSP());
        }
      }
      droitPbjcNcp.setDateEffetExclusionDef(recupererDateExclusionDefinitiveDDTE(calendrierExecutionCalcul));
      
      droitPbjcNcp.setAnneeAffectation(facadeCalculProduit.recupererAnneeAffectation(attribution));
      
      facadeCalculProduit.alimenterDonneesSpectacle(attribution, calendrierExecutionCalcul, droitPbjcNcp);
      
      List droits = null;
      Iterator iterateur = null;
      DroitPbjcNcp droitPbjcNcpAnterieur = null;
      
      droits = attribution.getDemandeur().getListDroitsPbjcsNcp();
      if (droits != null)
      {
        iterateur = droits.iterator();
        while (iterateur.hasNext())
        {
          droitPbjcNcpAnterieur = (DroitPbjcNcp)iterateur.next();
          if ((droitPbjcNcpAnterieur.getIdentOuvertureDroit() < droitPbjcNcp.getIdentOuvertureDroit()) && (droitPbjcNcpAnterieur.getDateFinDeDroit() != null) && (droitPbjcNcpAnterieur.getDateFinDeDroit().estApres(attribution.getDateAttribution()))) {
            droitPbjcNcpAnterieur.setDateFinDeDroit(null);
          }
        }
      }
      if (droitPbjcNcp != null)
      {
        DroitPbjcNcp droitPbjcNcpPersistant = recupererDroitPbjcNcp(droits, droitPbjcNcp.getIdentOuvertureDroit());
        if (droitPbjcNcpPersistant != null)
        {
          DomManager.supprimer(droitPbjcNcpPersistant);
          droits.remove(droitPbjcNcpPersistant);
        }
        droits.add(droitPbjcNcp);
      }
    }
  }
  
  public static void nettoyerDispositifNcp(AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    FacadeCalculProduitSpec facadeCalculProduit = FacadeCalculProduitFactory.getInstance().getInstanceGestionnaireCalculProduit(attribution.getProduitExecution());
    if ((estDispositifEnregistre(facadeCalculProduit, attribution)) && (attribution.getDemande().estEnContexteDemande("AREENTRCSP")))
    {
      Damj dateDebutDispositif = recupererDateDebutDispositif(attribution);
      DispositifNcp dispositifPbjcNcp = recupererDispositifNcp(attribution.getDemandeur().getCollectionDispositifNcp(), dateDebutDispositif);
      if (dispositifPbjcNcp != null)
      {
        DomManager.supprimer(dispositifPbjcNcp);
        attribution.getDemandeur().getCollectionDispositifNcp().remove(dispositifPbjcNcp);
      }
    }
  }
  
  private static Damj recupererDateDebutDispositif(AttributionSpec attribution)
  {
    return ((GammeAsuSpec)attribution.getGamme()).calculerPointDepartCSP(attribution.getDemande());
  }
  
  public static Damj recupererDateDebutDispositif(AttributionSpec attribution, FacadeCalculProduitSpec facadeCalculProduit)
    throws CoucheLogiqueException
  {
    Damj dateDebutDispositifs = null;
    if (estDispositifEnregistre(facadeCalculProduit, attribution)) {
      dateDebutDispositifs = recupererDateDebutAttribution(attribution);
    }
    return dateDebutDispositifs;
  }
  
  private static Damj recupererDateDebutAttribution(AttributionSpec attribution)
  {
    Damj dateDebut;
    Damj dateDebut;
    if (attribution.getDemande().estEnContexteDemande("AREENTRCSP"))
    {
      dateDebut = ((GammeAsuSpec)attribution.getGamme()).calculerPointDepartCSP(attribution.getDemande());
    }
    else
    {
      DemandeSpec demandePrecedente = OutilRecherche.rechercherDemandePrecedente(attribution.getDemande().getChronologieDemandesAssuranceSansCourante(), attribution.getDemande(), new FiltreDemandePourTypeContexteDemande("AREENTRCSP"));
      
      dateDebut = ((GammeAsuSpec)attribution.getGamme()).calculerPointDepartCSP(demandePrecedente);
    }
    return dateDebut;
  }
  
  public static void enregistrerDispositifNcp(Map<Damj, AttributionSpec> attributionsAAllonger)
    throws CoucheLogiqueException
  {
    for (Map.Entry<Damj, AttributionSpec> elementListe : attributionsAAllonger.entrySet())
    {
      Damj dateDebutDispositif = (Damj)elementListe.getKey();
      AttributionSpec attribution = (AttributionSpec)elementListe.getValue();
      
      DispositifNcp dispositifPbjcNcp = recupererDispositifNcp(attribution.getDemandeur().getCollectionDispositifNcp(), dateDebutDispositif);
      CalendrierExecutionCalculPeriodique calendrier = (CalendrierExecutionCalculPeriodique)attribution.getCalendrierExecutionCalcul();
      if (dispositifPbjcNcp != null)
      {
        if (!dispositifPbjcNcp.getDateFinDispositifApres().coincideAvec(calendrier.getDateFinDispositifCSP()))
        {
          dispositifPbjcNcp.setDateFinDispositifAvant(dispositifPbjcNcp.getDateFinDispositifApres());
          if (calendrier.getDateFinDispositifCSP() != null) {
            dispositifPbjcNcp.setDateFinDispositifApres(calendrier.getDateFinDispositifCSP());
          }
          dispositifPbjcNcp.setEstModifie(true);
        }
      }
      else
      {
        dispositifPbjcNcp = new DispositifNcp();
        
        Damj dateDebut = recupererDateDebutAttribution(attribution);
        
        Damj dateFinTheorique = ((AttributionAssuranceSpec)attribution).getDateLimiteIndemnisation();
        Damj dateFinEffective = calendrier.getDateFinDispositifCSP();
        if (!dateFinTheorique.coincideAvec(dateFinEffective)) {
          dispositifPbjcNcp.setEstModifie(true);
        }
        dispositifPbjcNcp.setDateDebutDispositif(dateDebut);
        dispositifPbjcNcp.setDateFinDispositifAvant(dateFinTheorique);
        dispositifPbjcNcp.setDateFinDispositifApres(dateFinEffective);
        attribution.getDemandeur().getCollectionDispositifNcp().add(dispositifPbjcNcp);
      }
    }
  }
  
  private static boolean estDispositifEnregistre(FacadeCalculProduitSpec facadeCalculProduit, AttributionSpec attribution)
    throws CoucheLogiqueException
  {
    return (ContexteParcoursCalcul.estPersistant()) && (facadeCalculProduit.enregistrerDispositifPBJCNCP(attribution)) && (attribution.getDemande().getNumeroGamme() == 1);
  }
  
  public static void enregistrerIndividuPbjcNcp(IndividuSpec individu, Damj dernierJourIndemnisablePourSuivi, ComportementSpec comportement, Periode periodeIneligibilite)
    throws CoucheLogiqueException
  {
    if (ContexteParcoursCalcul.estPersistant())
    {
      IndividuPbjcNcp individuPbjcNcp = null;
      IndividuPbjcNcp individuPbjcNcpPersistant = null;
      Damj retraite = null;
      
      individuPbjcNcpPersistant = individu.getIndividuPbjcNcp();
      if (individuPbjcNcpPersistant != null)
      {
        individuPbjcNcpPersistant.setCodeJustifRetraite("C");
        retraite = OutillagePeriodes.genererPeriodeRetraite(individu).getDateDebut();
        individuPbjcNcpPersistant.setDateDepartRetraiteCalculee(retraite);
        if (dernierJourIndemnisablePourSuivi != null) {
          individuPbjcNcpPersistant.setDernierJourIndemnisable(dernierJourIndemnisablePourSuivi);
        } else {
          individuPbjcNcpPersistant.setDernierJourIndemnisable(retraite);
        }
        individuPbjcNcpPersistant.setDateDebutIneligibiliteAidesMob(periodeIneligibilite != null ? periodeIneligibilite.getDebut() : null);
        individuPbjcNcpPersistant.setDateFinIneligibiliteAidesMob(periodeIneligibilite != null ? periodeIneligibilite.getFin() : null);
        
        individuPbjcNcpPersistant.setNombreTrimestreRetraite(OutilRetraite.getInstance().getNbTrimestresRequis(individu));
        
        Date dateDuJour = new Date(System.currentTimeMillis());
        individuPbjcNcpPersistant.setDateDerniereExecCal(Damj.dateVersDamj(dateDuJour));
        Heure lheure = Heure.valueOf(dateDuJour);
        individuPbjcNcpPersistant.setHeureDerniereExecCal(lheure.getHeures() * 10000 + lheure.getMinutes() * 100 + lheure.getSecondes());
        if ((individu.getContexteService() != null) && (individu.getContexteService().getCodeActivite() != null) && ((individu.getContexteService().getCodeActivite().equals("GRCA")) || (individu.getContexteService().getCodeActivite().equals("GRC5")) || (individu.getContexteService().getCodeActivite().equals("GRGA"))))
        {
          if ((individu.getContexteService() != null) && (individu.getContexteService().getSrcCodeDomaine().equals("DPS")))
          {
            if (comportement.getTypeMandatement().equals("1")) {
              individuPbjcNcpPersistant.setContexteExecution("A");
            } else if (comportement.getTypeMandatement().equals("2")) {
              individuPbjcNcpPersistant.setContexteExecution("B");
            }
          }
          else {
            individuPbjcNcpPersistant.setContexteExecution(comportement.getTypeMandatement());
          }
        }
        else {
          individuPbjcNcpPersistant.setContexteExecution(" ");
        }
      }
      else
      {
        individuPbjcNcp = new IndividuPbjcNcp();
        individuPbjcNcp.setCodeJustifRetraite("C");
        retraite = OutillagePeriodes.genererPeriodeRetraite(individu).getDateDebut();
        individuPbjcNcp.setDateDepartRetraiteCalculee(retraite);
        if (dernierJourIndemnisablePourSuivi != null) {
          individuPbjcNcp.setDernierJourIndemnisable(dernierJourIndemnisablePourSuivi);
        } else {
          individuPbjcNcp.setDernierJourIndemnisable(retraite);
        }
        individuPbjcNcp.setDateDebutIneligibiliteAidesMob(periodeIneligibilite != null ? periodeIneligibilite.getDebut() : null);
        individuPbjcNcp.setDateFinIneligibiliteAidesMob(periodeIneligibilite != null ? periodeIneligibilite.getFin() : null);
        
        individuPbjcNcp.setNombreTrimestreRetraite(individu.getTrimestreRetraite().getNombreTrimestre().intValue());
        
        Date dateDuJour = new Date(System.currentTimeMillis());
        individuPbjcNcp.setDateDerniereExecCal(Damj.dateVersDamj(dateDuJour));
        Heure lheure = Heure.valueOf(dateDuJour);
        individuPbjcNcp.setHeureDerniereExecCal(lheure.getHeures() * 10000 + lheure.getMinutes() * 100 + lheure.getSecondes());
        if ((individu.getContexteService() != null) && (individu.getContexteService().getCodeActivite() != null) && ((individu.getContexteService().getCodeActivite().equals("GRCA")) || (individu.getContexteService().getCodeActivite().equals("GRC5"))))
        {
          if ((individu.getContexteService() != null) && (individu.getContexteService().getSrcCodeDomaine().equals("DPS")))
          {
            if (comportement.getTypeMandatement().equals("1")) {
              individuPbjcNcpPersistant.setContexteExecution("A");
            } else if (comportement.getTypeMandatement().equals("2")) {
              individuPbjcNcpPersistant.setContexteExecution("B");
            }
          }
          else {
            individuPbjcNcpPersistant.setContexteExecution(comportement.getTypeMandatement());
          }
        }
        else {
          individuPbjcNcp.setContexteExecution(" ");
        }
        individu.setIndividuPbjcNcp(individuPbjcNcp);
      }
    }
  }
  
  public static void positionnerDJIPourSuivi(AttributionSpec attribution, Damj djiPourSuivi)
  {
    CalendrierExecutionCalcul calendrier = (CalendrierExecutionCalcul)attribution.getCalendrierExecutionCalcul();
    if (calendrier != null) {
      calendrier.setDernierJourIndemnisablePourSuivi(djiPourSuivi);
    }
  }
  
  public static EnquetePbjcNcp creerEnquetePbjcNcp(AttributionSpec attribution, Damj date, int type, int rang, boolean aEmettre, String codeSousProduit, FacadeCalculProduitSpec facadeCalculProduit)
  {
    EnquetePbjcNcp enquetePbjcNcp = new EnquetePbjcNcp(Integer.valueOf(facadeCalculProduit.recupererRsodPourSuivi(attribution)).intValue());
    enquetePbjcNcp.setDateSituationSuivi(date);
    enquetePbjcNcp.setCodeProduit(attribution.getProduitExecution().getNom());
    enquetePbjcNcp.setTypeSituationSuivi(type);
    enquetePbjcNcp.setRangSituation(rang);
    enquetePbjcNcp.setSituationAEmettre(aEmettre);
    enquetePbjcNcp.setSituationParticuliere(attribution.getSituationParticuliere());
    enquetePbjcNcp.setCodeSousProduit(codeSousProduit);
    return enquetePbjcNcp;
  }
  
  public static EnquetePbjcNcp creerEnquetePbjcNcpPourAvant(AttributionSpec attribution, Damj date, int type, int rang, boolean aEmettre, String codeSousProduit)
  {
    EnquetePbjcNcp enquetePbjcNcp = new EnquetePbjcNcp(Integer.valueOf(attribution.getRsod()).intValue());
    enquetePbjcNcp.setDateSituationSuivi(date);
    enquetePbjcNcp.setCodeProduit(attribution.getProduitExecution().getNom());
    enquetePbjcNcp.setTypeSituationSuivi(type);
    enquetePbjcNcp.setRangSituation(rang);
    enquetePbjcNcp.setSituationAEmettre(aEmettre);
    enquetePbjcNcp.setSituationParticuliere(attribution.getSituationParticuliere());
    enquetePbjcNcp.setCodeSousProduit(codeSousProduit);
    return enquetePbjcNcp;
  }
  
  public static Damj recupererDateFinDroitTheorique(AttributionSpec attributionCourante, CalendrierExecutionCalculSpec calendrierExecutionCalcul, FacadeCalculProduitSpec facadeCalculProduit)
    throws CoucheLogiqueException
  {
    return facadeCalculProduit.recupererDateFinDroitTheorique(calendrierExecutionCalcul, attributionCourante);
  }
  
  public static void nettoyerDroitPbjcNcp(Damj date, IndividuSpec individu)
  {
    if (ContexteParcoursCalcul.estPersistant())
    {
      List droits = null;
      List<DroitPbjcNcp> listeDroitsASuppr = new ArrayList();
      Iterator iterateur = null;
      DroitPbjcNcp droitPbjcNcp = null;
      droits = individu.getListDroitsPbjcsNcp();
      if (droits != null)
      {
        iterateur = droits.iterator();
        while (iterateur.hasNext())
        {
          droitPbjcNcp = (DroitPbjcNcp)iterateur.next();
          if ((date.coincideAvec(Damj.NUIT_DES_TEMPS)) || (droitPbjcNcp.getDateFinDeDroit().estApresOuCoincideAvec(date)))
          {
            DomManager.supprimer(droitPbjcNcp);
            listeDroitsASuppr.add(droitPbjcNcp);
          }
        }
        if (!listeDroitsASuppr.isEmpty())
        {
          Iterator ite = listeDroitsASuppr.iterator();
          while (ite.hasNext()) {
            droits.remove((DroitPbjcNcp)ite.next());
          }
        }
      }
    }
  }
  
  public static Damj determinerDDJIQ(Damj dateRetraite, Damj minDDJINProduit, Damj maxDJIProduit, ChronologiePeriodes chronologiePeriodesEvtActualisation)
  {
    Damj ddjiq = null;
    Damj dateEvtActualisationBloquant = Damj.FIN_DES_TEMPS;
    if ((chronologiePeriodesEvtActualisation != null) && (!chronologiePeriodesEvtActualisation.estVide()))
    {
      chronologiePeriodesEvtActualisation.iterer();
      while (chronologiePeriodesEvtActualisation.encoreSuivant())
      {
        ObjetChronoPeriodeCalcul periodeEvtActualisation = (ObjetChronoPeriodeCalcul)chronologiePeriodesEvtActualisation.elementSuivant();
        if ((periodeEvtActualisation instanceof PeriodeEvenementBloquant)) {
          dateEvtActualisationBloquant = Damj.min(dateEvtActualisationBloquant, periodeEvtActualisation.getDateDebut());
        }
      }
    }
    ddjiq = Damj.max(maxDJIProduit, dateRetraite);
    ddjiq = Damj.min(ddjiq, dateEvtActualisationBloquant);
    ddjiq = Damj.min(ddjiq, minDDJINProduit);
    return ddjiq;
  }
  
  public static DroitPbjcNcp recupererDroitPbjcNcp(List listeDroit, int identOuvertureDroit)
  {
    DroitPbjcNcp droitPbjcNcp = null;
    if (listeDroit != null)
    {
      Iterator iterator = listeDroit.iterator();
      while ((iterator.hasNext()) && (droitPbjcNcp == null))
      {
        droitPbjcNcp = (DroitPbjcNcp)iterator.next();
        if (droitPbjcNcp.getIdentOuvertureDroit() != identOuvertureDroit) {
          droitPbjcNcp = null;
        }
      }
    }
    return droitPbjcNcp;
  }
  
  private static DispositifNcp recupererDispositifNcp(Collection<DispositifNcp> listeDispositif, Damj dateDebutAttribution)
  {
    DispositifNcp dispositifNcp = null;
    if (listeDispositif != null)
    {
      Iterator<DispositifNcp> iterator = listeDispositif.iterator();
      while ((iterator.hasNext()) && (dispositifNcp == null))
      {
        DispositifNcp dispositifCourrant = (DispositifNcp)iterator.next();
        if (dispositifCourrant.getDateDebutDispositif().coincideAvec(dateDebutAttribution))
        {
          dispositifNcp = dispositifCourrant;
          break;
        }
      }
    }
    return dispositifNcp;
  }
  
  public static EnquetePbjcNcp retourneEnqueteEnPersistance(List listeEnquetes, int idOuvertureDroit, int typeSituationSuivi, int rangSituation)
  {
    EnquetePbjcNcp enquetePbjcNcp = null;
    if (listeEnquetes != null)
    {
      Iterator ite = listeEnquetes.iterator();
      while ((ite.hasNext()) && (enquetePbjcNcp == null))
      {
        enquetePbjcNcp = (EnquetePbjcNcp)ite.next();
        if ((enquetePbjcNcp.getIdentOuvertureDroit() != idOuvertureDroit) || (enquetePbjcNcp.getTypeSituationSuivi() != typeSituationSuivi) || (enquetePbjcNcp.getRangSituation() != rangSituation)) {
          enquetePbjcNcp = null;
        }
      }
    }
    return enquetePbjcNcp;
  }
  
  private static EnquetePbjcNcp retourneEnqueteRetraiteEnPersistance(List<EnquetePbjcNcp> listeEnquetes, int typeSituationSuivi, int rangSituation)
  {
    EnquetePbjcNcp enquetePbjcNcp = null;
    if (listeEnquetes != null)
    {
      Iterator<EnquetePbjcNcp> ite = listeEnquetes.iterator();
      while ((ite.hasNext()) && (enquetePbjcNcp == null))
      {
        enquetePbjcNcp = (EnquetePbjcNcp)ite.next();
        if ((enquetePbjcNcp.getTypeSituationSuivi() != typeSituationSuivi) || (enquetePbjcNcp.getRangSituation() != rangSituation)) {
          enquetePbjcNcp = null;
        }
      }
    }
    return enquetePbjcNcp;
  }
  
  public static EnquetePbjcNcp retourneEnqueteEnPersistance(List<EnquetePbjcNcp> listeEnquetes, int idOuvertureDroit, int typeSituationSuivi)
  {
    EnquetePbjcNcp enquetePbjcNcp = null;
    if (listeEnquetes != null)
    {
      Iterator<EnquetePbjcNcp> ite = listeEnquetes.iterator();
      while ((ite.hasNext()) && (enquetePbjcNcp == null))
      {
        enquetePbjcNcp = (EnquetePbjcNcp)ite.next();
        if ((enquetePbjcNcp.getIdentOuvertureDroit() != idOuvertureDroit) || (enquetePbjcNcp.getTypeSituationSuivi() != typeSituationSuivi)) {
          enquetePbjcNcp = null;
        }
      }
    }
    return enquetePbjcNcp;
  }
  
  public static int determinerRangMaxEnquete(List<EnquetePbjcNcp> listeEnquetes, int idOuvertureDroit, int typeSituationSuivi)
  {
    int rangMax = -1;
    List<EnquetePbjcNcp> listeEnquete = retourneListeEnqueteDeMemeTypeSituation(listeEnquetes, idOuvertureDroit, typeSituationSuivi);
    Iterator<EnquetePbjcNcp> ite = listeEnquete.iterator();
    while (ite.hasNext())
    {
      EnquetePbjcNcp enquete = (EnquetePbjcNcp)ite.next();
      if (enquete.getRangSituation() > rangMax) {
        rangMax = enquete.getRangSituation();
      }
    }
    return rangMax;
  }
  
  private static List<EnquetePbjcNcp> retourneListeEnqueteDeMemeTypeSituation(List<EnquetePbjcNcp> listeEnquetes, int idOuvertureDroit, int typeSituationSuivi)
  {
    ArrayList<EnquetePbjcNcp> listeEnquetePbjcNcp = new ArrayList();
    EnquetePbjcNcp enquetePbjcNcp = null;
    if (listeEnquetes != null)
    {
      Iterator<EnquetePbjcNcp> ite = listeEnquetes.iterator();
      while (ite.hasNext())
      {
        enquetePbjcNcp = (EnquetePbjcNcp)ite.next();
        if ((enquetePbjcNcp.getIdentOuvertureDroit() == idOuvertureDroit) && (enquetePbjcNcp.getTypeSituationSuivi() == typeSituationSuivi)) {
          listeEnquetePbjcNcp.add(enquetePbjcNcp);
        }
      }
    }
    return listeEnquetePbjcNcp;
  }
  
  private static Damj recupererDateExclusionDefinitiveDDTE(CalendrierExecutionCalculSpec calendrierExecutionCalcul)
  {
    Damj date = null;
    if ((calendrierExecutionCalcul != null) && ((calendrierExecutionCalcul instanceof CalendrierExecutionCalculPeriodique)) && (!((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements().estVide()))
    {
      ArretProduitAvecRaison arretProduitAvecRaison = ((UniteTraitement)((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement()).getArretProduitAvecRaison();
      if (arretProduitAvecRaison != null) {
        for (Object o : arretProduitAvecRaison.getPeriodesInterruptivesDefinitives()) {
          if (((o instanceof PeriodeExclusionDefinitiveDDTE)) && (((PeriodeExclusionDefinitiveDDTE)o).getCodeSanction().equals("EX"))) {
            date = ((PeriodeExclusionDefinitiveDDTE)o).getDateDebut();
          }
        }
      }
    }
    return date;
  }
  
  public static int determinerRangEnqueteDRV(AttributionSpec attribution, ObjetChronoPeriode objetChronoPeriode)
  {
    FiltreET filtresPoursuites = new FiltreET();
    filtresPoursuites.ajouterFiltre(new FiltreNegation(new FiltreReexamenSurDemande()));
    filtresPoursuites.ajouterFiltre(new FiltreValideeSurDecision());
    filtresPoursuites.ajouterFiltre(new FiltreDecisionPourNatureDecision(49));
    filtresPoursuites.ajouterFiltre(new FiltreDemandesSuivantesSurDemandes(attribution.getDateAttribution()));
    
    Chronologie listePoursuites = OutilRecherche.rechercherDecisionsPrecedentes(attribution.getDemandeur().getChronoDemandeAssurance(), objetChronoPeriode.getDateDebut(), filtresPoursuites);
    
    int rangMaxEnquete = determinerRangMaxEnquete(attribution.getDemandeur().getListEnquetesPbjcNcp(), Integer.parseInt(attribution.getRsod()), 39);
    
    int nombrePoursuite = 0;
    if (listePoursuites != null) {
      nombrePoursuite = listePoursuites.getTaille();
    }
    return rangMaxEnquete + nombrePoursuite + 1;
  }
}

/* Location:
 * Qualified Name:     GestionSuivi
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
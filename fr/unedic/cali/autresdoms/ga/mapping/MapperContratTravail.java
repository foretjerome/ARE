package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.CompteurIndexPASContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.InformationPeriodeGlobale;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeGaec;
import fr.unedic.cali.autresdoms.ga.dom.spec.ConstantesContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.cali.autresdoms.ga.outilsfonctionnels.OutilsDecoupagePeriodes;
import fr.unedic.cali.fabriques.FabriqueStrategiePECCACIRMAetCUI;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategiePECCACIRMAetCUISpec;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.EvenementPersonnelComplet;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeEvenementPersonnnel;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeIndemnites;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeIntensitesTravailHeures;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeMetiers;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeOrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePrimes;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeQuantiteTravail;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeSalaires;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeSalairesMensuelsBase;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.OrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RCTDom;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public final class MapperContratTravail
{
  public static ChronologiePeriodes mapper(PeriodeActivite periodeActiviteGa)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes listePeriodeActiviteSalarieeCali = new ChronologiePeriodes();
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContratTravail contratTravailGa = periodeActiviteGa.getContratTravail();
    ChampsPeriodeActivite champsPeriodeActivite = periodeActiviteGa.getChampsPeriodeActivite();
    ActiviteSalarie activite = null;
    
    CompteurIndexPASContratTravail compteurIndex = new CompteurIndexPASContratTravail(champsPeriodeActivite.getIdPeriodeActivite());
    
    ListeMetiers listeMetiers = contratTravailGa.getListeMetiers();
    if ((listeMetiers == null) || (listeMetiers.getNbListMetier() == 0)) {
      return listePeriodeActiviteSalarieeCali;
    }
    if (estAeBrouillon(periodeActiviteGa)) {
      mapperAeBrouillon(periodeActiviteGa, listePeriodeActiviteSalarieeCali);
    } else if (OutilsDecoupagePeriodes.contientPeriodesADecouper(periodeActiviteGa)) {
      activite = mapperContratAvecDecoupageSuspension(periodeActiviteGa, listePeriodeActiviteSalarieeCali, activite, compteurIndex);
    } else {
      activite = mapperListeMetiersSurContratTravail(creerContratTravail(periodeActiviteGa), listeMetiers, periodeActiviteGa, contratTravailGa, listePeriodeActiviteSalarieeCali, null, null, compteurIndex, champsPeriodeActivite.getDateDebut(), champsPeriodeActivite.getDateFin(), recupereDateNotifLicenciement(periodeActiviteGa));
    }
    if (activite != null)
    {
      ListePrimes listePrimes = contratTravailGa.getListePrimes();
      MapperPrime.repartir(listePeriodeActiviteSalarieeCali, listePrimes);
      
      ListeIndemnites listeIndemnites = contratTravailGa.getListeIndemnites();
      MapperIndemnite.ajouter(activite.getPeriodeActiviteSalarieGaec(), listeIndemnites);
    }
    return listePeriodeActiviteSalarieeCali;
  }
  
  private static ActiviteSalarie mapperContratAvecDecoupageSuspension(PeriodeActivite periodeActiviteGa, ChronologiePeriodes listePeriodeActiviteSalarieeCali, ActiviteSalarie activite, CompteurIndexPASContratTravail compteurIndex)
    throws CoucheLogiqueException
  {
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContratTravail contratTravailGa = periodeActiviteGa.getContratTravail();
    ListeMetiers listeMetiers = contratTravailGa.getListeMetiers();
    
    Damj dateEtudeDuContrat = periodeActiviteGa.getChampsPeriodeActivite().getDateDebut();
    
    fr.unedic.cali.autresdoms.ga.dom.ContratTravail contratTravailCali = OutilsDecoupagePeriodes.redefinirProchainContratCali(periodeActiviteGa, creerContratTravail(periodeActiviteGa), dateEtudeDuContrat);
    
    fr.unedic.cali.autresdoms.ga.dom.ContratTravail dernierContratCaliCree = null;
    Damj dateFinContratPrecedent = null;
    while (contratTravailCali != null)
    {
      Damj dateDebutContratTravail = null;
      if (dateFinContratPrecedent != null) {
        dateDebutContratTravail = dateFinContratPrecedent.lendemain();
      }
      Damj dateFinContratTravail = contratTravailCali.getDateRuptureContratTravail();
      if (estDernierContratMappe(contratTravailCali)) {
        dateFinContratTravail = periodeActiviteGa.getChampsPeriodeActivite().getDateFin();
      }
      activite = mapperListeMetiersSurContratTravail(contratTravailCali, listeMetiers, periodeActiviteGa, contratTravailGa, listePeriodeActiviteSalarieeCali, dateDebutContratTravail, dateFinContratTravail, compteurIndex, periodeActiviteGa.getChampsPeriodeActivite().getDateDebut(), periodeActiviteGa.getChampsPeriodeActivite().getDateFin(), recupereDateNotifLicenciement(periodeActiviteGa));
      
      dernierContratCaliCree = contratTravailCali;
      if (!estDernierContratMappe(contratTravailCali))
      {
        dateEtudeDuContrat = contratTravailCali.getDateRuptureContratTravail().lendemain();
        
        dateFinContratPrecedent = contratTravailCali.getDateRuptureContratTravail();
        
        contratTravailCali = OutilsDecoupagePeriodes.redefinirProchainContratCali(periodeActiviteGa, creerContratTravail(periodeActiviteGa), dateEtudeDuContrat);
      }
      else
      {
        contratTravailCali = null;
      }
    }
    dernierContratCaliCree.setEstDernierContratCaliCreePourDecoupage(true);
    return activite;
  }
  
  private static Damj recupereDateNotifLicenciement(PeriodeActivite periodeActiviteGa)
  {
    Damj retour = null;
    if ((periodeActiviteGa.getContratTravail() != null) && (periodeActiviteGa.getContratTravail().getRCTDom() != null)) {
      retour = periodeActiviteGa.getContratTravail().getRCTDom().getDateNotifLicenciement();
    }
    return retour;
  }
  
  private static boolean estDernierContratMappe(fr.unedic.cali.autresdoms.ga.dom.ContratTravail contratTravailCali)
  {
    return contratTravailCali.estDernierContratCaliCreePourDecoupage();
  }
  
  private static ActiviteSalarie mapperListeMetiersSurContratTravail(fr.unedic.cali.autresdoms.ga.dom.ContratTravail contratTravailCali, ListeMetiers listeMetiers, PeriodeActivite periodeActiviteGa, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContratTravail contratTravailGa, ChronologiePeriodes listePeriodeActiviteSalarieeCali, Damj dateDebutPeriode, Damj dateFinPeriode, CompteurIndexPASContratTravail compteurIndex, Damj dateDebutPeriodeGlobale, Damj dateFinPeriodeGlobale, Damj dateRuptureduContrat)
    throws CoucheLogiqueException
  {
    boolean initialiserSansQuantiteTravail = (contratTravailCali.estSuspensionDecoupee()) && (contratTravailCali.getContextesDecoupage() != null) && (contratTravailCali.getContextesDecoupage().contains("MVS"));
    
    PeriodeActiviteSalarie periodeActiviteSalarieGaec = null;
    ActiviteSalarie activite = null;
    int nbMetiers = listeMetiers.getNbListMetier();
    for (int i = 0; i < nbMetiers; i++)
    {
      fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier metierGa = listeMetiers.getListeMetiers(i);
      Damj dateDebutPeriodePourCreationMetier = dateDebutPeriode == null ? dateDebutPeriodeGlobale : dateDebutPeriode;
      Damj dateFinPeriodePourCreationMetier = dateFinPeriode == null ? dateFinPeriodeGlobale : dateFinPeriode;
      if (((dateFinPeriodePourCreationMetier == null) || (metierGa.getDateDebMetier() == null) || (metierGa.getDateDebMetier().estAvantOuCoincideAvec(dateFinPeriodePourCreationMetier))) && ((metierGa.getDateFinMetier() == null) || (dateDebutPeriodePourCreationMetier == null) || (metierGa.getDateFinMetier().estApresOuCoincideAvec(dateDebutPeriodePourCreationMetier))))
      {
        metierGa = creerMetier(metierGa, dateDebutPeriodePourCreationMetier, dateFinPeriodePourCreationMetier);
        if ((metierGa.getChampApplication() != null) && ((2 == Integer.parseInt(metierGa.getChampApplication())) || ("4".equals(periodeActiviteGa.getContratTravail().getEtudeMandataire()))))
        {
          PeriodeGaec periodeActiviteCali = MapperPans.mapperPasEnPans(periodeActiviteGa, metierGa);
          if (periodeActiviteCali != null) {
            listePeriodeActiviteSalarieeCali.ajouter(periodeActiviteCali);
          }
        }
        else
        {
          periodeActiviteSalarieGaec = creerPeriodeActiviteSalarie(initialiserSansQuantiteTravail, contratTravailGa, metierGa, periodeActiviteGa, dateDebutPeriode, dateFinPeriode);
          if (periodeActiviteSalarieGaec != null)
          {
            boolean enConflit = BooleanGa.valueOf(periodeActiviteGa.getChampsPeriodeActivite().getBEnConflit());
            periodeActiviteSalarieGaec.setEnConflit(enConflit);
            if (nbMetiers == 1) {
              periodeActiviteSalarieGaec.setIdentifiant(compteurIndex.getProchainIndexPAS());
            }
            periodeActiviteSalarieGaec.setContratTravail(contratTravailCali);
            
            activite = new ActiviteSalarie(periodeActiviteSalarieGaec);
            InformationPeriodeGlobale informationPeriodeGlobale = activite.getInformationPeriodeGlobale();
            informationPeriodeGlobale.setDateDebutPeriode(dateDebutPeriodeGlobale);
            informationPeriodeGlobale.setDateFinPeriode(dateFinPeriodeGlobale);
            informationPeriodeGlobale.setDateRuptureContratTravail(dateRuptureduContrat);
            if (nbMetiers > 1) {
              activite.getContrat().ajouterContexteDecoupage("METIER");
            }
            if ((activite.getDateFin() != null) && (activite.getDateFin().equals(periodeActiviteGa.getChampsPeriodeActivite().getDateFin()))) {
              activite.setEstUneFct(true);
            }
            listePeriodeActiviteSalarieeCali.ajouter(activite);
          }
        }
      }
    }
    if (nbMetiers > 1)
    {
      listePeriodeActiviteSalarieeCali.trier();
      ListIterator it = listePeriodeActiviteSalarieeCali.iterer();
      while (it.hasNext())
      {
        Object actSal = it.next();
        if ((actSal instanceof ActiviteSalarie))
        {
          ((ActiviteSalarie)actSal).getPeriodeActiviteSalarieGaec().setIdentifiant(compteurIndex.getProchainIndexPAS());
          ((ActiviteSalarie)actSal).setIdentifiant(((ActiviteSalarie)actSal).getPeriodeActiviteSalarieGaec().getIdentifiant());
        }
      }
    }
    return activite;
  }
  
  private static fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier creerMetier(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier metier, Damj dateDebutPeriode, Damj dateFinPeriode)
  {
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier metierCourant = metier;
    if (((metierCourant.getDateDebMetier() != null) && (dateDebutPeriode != null) && (!metierCourant.getDateDebMetier().coincideAvec(dateDebutPeriode))) || ((metierCourant.getDateFinMetier() == null) && (dateFinPeriode != null)) || ((metierCourant.getDateFinMetier() != null) && (dateFinPeriode == null)) || ((metierCourant.getDateFinMetier() != null) && (dateFinPeriode != null) && (!metierCourant.getDateFinMetier().coincideAvec(dateFinPeriode))))
    {
      metierCourant = fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier.getInstance();
      metierCourant.setChampApplication(metier.getChampApplication());
      metierCourant.setCodeCatEmploiParticulier(metier.getCodeCatEmploiParticulier());
      metierCourant.setCodeEmploiTenu(metier.getCodeEmploiTenu());
      metierCourant.setCodeEtat(metier.getCodeEtat());
      metierCourant.setContratTypeParticulier(metier.getContratTypeParticulier());
      if ((metier.getDateDebMetier() == null) && (dateDebutPeriode != null)) {
        metierCourant.setDateDebMetier(dateDebutPeriode);
      } else if (dateDebutPeriode == null) {
        metierCourant.setDateDebMetier(metier.getDateDebMetier());
      } else {
        metierCourant.setDateDebMetier(Damj.max(dateDebutPeriode, metier.getDateDebMetier()));
      }
      if ((metier.getDateFinMetier() == null) && (dateFinPeriode != null)) {
        metierCourant.setDateFinMetier(dateFinPeriode);
      } else if (dateFinPeriode == null) {
        metierCourant.setDateFinMetier(metier.getDateFinMetier());
      } else {
        metierCourant.setDateFinMetier(Damj.min(dateFinPeriode, metier.getDateFinMetier()));
      }
      metierCourant.setEmploiEttDmm(metier.getEmploiEttDmm());
      metierCourant.setIdentifiant(metier.getIdentifiant());
      metierCourant.setIdMetier(metier.getIdMetier());
      metierCourant.setListeEmploi(metier.getListeEmploi());
      metierCourant.setListeRegimeRetraite(metier.getListeRegimeRetraite());
    }
    return metierCourant;
  }
  
  private static Damj definirDateDebutPeriode(Damj dateDebutContrat, Damj dateDebutMetier)
  {
    if (dateDebutContrat == null) {
      return dateDebutMetier;
    }
    if (dateDebutMetier == null) {
      return dateDebutContrat;
    }
    return Damj.max(dateDebutContrat, dateDebutMetier);
  }
  
  private static Damj definirDateFinPeriode(Damj dateFinContrat, Damj dateFinMetier)
  {
    if (dateFinContrat == null) {
      return dateFinMetier;
    }
    if (dateFinMetier == null) {
      return dateFinContrat;
    }
    return Damj.min(dateFinContrat, dateFinMetier);
  }
  
  private static PeriodeActiviteSalarie creerPeriodeActiviteSalarie(boolean initialiserSansQuantiteTravail, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContratTravail contratTravailGa, fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier metierGa, PeriodeActivite periodeActiviteGa, Damj dateDebutDeContrat, Damj dateFinDeContrat)
    throws CoucheLogiqueException
  {
    if ((dateDebutDeContrat != null) && (dateFinDeContrat != null))
    {
      Periode periodeContrat = new Periode(dateDebutDeContrat, dateFinDeContrat);
      Periode periodeMetier = FabriquePeriode.creer(metierGa.getDateDebMetier(), metierGa.getDateFinMetier());
      if (!periodeMetier.chevauche(periodeContrat)) {
        return null;
      }
    }
    Damj dateDebutPeriode = definirDateDebutPeriode(dateDebutDeContrat, metierGa.getDateDebMetier());
    Damj dateFinPeriode = definirDateFinPeriode(dateFinDeContrat, metierGa.getDateFinMetier());
    
    Periode periode = FabriquePeriode.creer(dateDebutPeriode, dateFinPeriode);
    
    fr.unedic.cali.autresdoms.ga.dom.Metier metierCali = MapperMetier.mapper(metierGa);
    PeriodeActiviteSalarie pasGaec = new PeriodeActiviteSalarie(periode);
    pasGaec.setMetier(metierCali);
    
    pasGaec.setEstPeriodeMayotte(MapperMetier.estChampApplicationMayotte(metierGa));
    
    pasGaec.setEntreprise(new Entreprise());
    
    RCTDom rct = contratTravailGa.getRCTDom();
    Damj dateFinPourCtp = null;
    if (rct != null) {
      dateFinPourCtp = rct.getDateEngagementProcedure();
    }
    if (dateFinPourCtp == null) {
      dateFinPourCtp = pasGaec.getDateFin();
    }
    MapperEntreprise.mapper(pasGaec.getEntreprise(), contratTravailGa.getEntreprise(), dateFinPourCtp);
    
    ListeIntensitesTravailHeures listeIntensites = contratTravailGa.getListeIntensitesTravailHeures();
    MapperIntensite.ajouter(pasGaec, listeIntensites);
    
    ListeSalairesMensuelsBase listeSalairesMensuelsBase = contratTravailGa.getListeSalairesMensuelsBase();
    MapperSalaireMensuelBase.ajouter(pasGaec, listeSalairesMensuelsBase);
    
    ListeQuantiteTravail listeQuantiteTravail = contratTravailGa.getListeQuantiteTravail();
    MapperQuantiteTravail.ajouter(pasGaec, listeQuantiteTravail, initialiserSansQuantiteTravail);
    
    ListeSalaires listeSalaires = contratTravailGa.getListeSalaires();
    MapperSalaire.ajouterActiviteSalarie(pasGaec, listeSalaires, periodeActiviteGa);
    
    boolean estAvecPmvs = false;
    ListeEvenementPersonnnel listeEvenementPersonnnel = contratTravailGa.getListeEvenementPersonnnel();
    if ((listeEvenementPersonnnel != null) && (listeEvenementPersonnnel.getNbListEvenementPersonnelComplet() > 0)) {
      for (int i = 0; i < listeEvenementPersonnnel.getNbListEvenementPersonnelComplet(); i++)
      {
        EvenementPersonnelComplet evt = listeEvenementPersonnnel.getListeEvenementPersonnnel(i);
        String contexteDecoupage = OutilsDecoupagePeriodes.recupererContexteDecoupagePourEvenementGaec(evt);
        if ("MVS".equals(contexteDecoupage)) {
          estAvecPmvs = true;
        }
        IncidentSpec incident = MapperEvenementPersonnel.mapperEvenementPersonnelInterne(evt.getEvenementPersonnel(), evt.getChampsPeriodeActivite());
        if ((incident != null) && (incident.getPeriode().chevauche(pasGaec.getPeriode())))
        {
          Periode periodeIncidentARetenir = incident.getPeriode().periodeIntersection(pasGaec.getPeriode());
          incident.setDateDebut(periodeIncidentARetenir.getDebut());
          incident.setDateFin(periodeIncidentARetenir.getFin());
          pasGaec.ajouterIncident(incident);
        }
      }
    }
    if (estAvecPmvs) {
      pasGaec.ajouterOrigineInformationPAS(1, 1);
    }
    boolean horsChampsSpectacle = BooleanGa.valueOf(contratTravailGa.getHorsChampsA8A10());
    pasGaec.setHorsChampsSpectacle(horsChampsSpectacle);
    
    boolean derogation = BooleanGa.valueOf(contratTravailGa.getDerogationPlafondMensuel());
    pasGaec.setDerogationPlafondMensuel(derogation);
    
    ListeOrigineInformation listeOrigineInfo = periodeActiviteGa.getChampsPeriodeActivite().getListeOrigineInformation();
    pasGaec.setIncomplete(periodeActiviteGa.getChampsPeriodeActivite().getIncomplete());
    boolean estIncomplet = false;
    boolean estBrouillon = false;
    boolean estAEDAConfirmer = false;
    if (periodeActiviteGa.getChampsPeriodeActivite().getIncomplete() != null)
    {
      if (periodeActiviteGa.getChampsPeriodeActivite().getIncomplete().equals(ConstantesContratTravail.INCOMPLETE)) {
        estIncomplet = true;
      }
      if (periodeActiviteGa.getChampsPeriodeActivite().getIncomplete().equals(ConstantesContratTravail.BROUILLON)) {
        estBrouillon = true;
      }
    }
    if ((periodeActiviteGa.getChampsPeriodeActivite().getAConfirmer() != null) && (periodeActiviteGa.getChampsPeriodeActivite().getAConfirmer().equals(ConstantesContratTravail.AED_A_CONFIRMER))) {
      estAEDAConfirmer = true;
    }
    Collection<Integer> listeOrigineIncomplete = new ArrayList();
    listeOrigineIncomplete.add(Integer.valueOf(4));
    listeOrigineIncomplete.add(Integer.valueOf(1));
    listeOrigineIncomplete.add(Integer.valueOf(2));
    listeOrigineIncomplete.add(Integer.valueOf(9));
    listeOrigineIncomplete.add(Integer.valueOf(71));
    listeOrigineIncomplete.add(Integer.valueOf(10));
    listeOrigineIncomplete.add(Integer.valueOf(5));
    listeOrigineIncomplete.add(Integer.valueOf(6));
    listeOrigineIncomplete.add(Integer.valueOf(74));
    listeOrigineIncomplete.add(Integer.valueOf(38));
    listeOrigineIncomplete.add(Integer.valueOf(37));
    listeOrigineIncomplete.add(Integer.valueOf(36));
    listeOrigineIncomplete.add(Integer.valueOf(35));
    
    Collection<Integer> listeOrigineBrouillon = new ArrayList();
    listeOrigineBrouillon.add(Integer.valueOf(4));
    listeOrigineBrouillon.add(Integer.valueOf(1));
    listeOrigineBrouillon.add(Integer.valueOf(2));
    listeOrigineBrouillon.add(Integer.valueOf(37));
    listeOrigineIncomplete.add(Integer.valueOf(37));
    listeOrigineIncomplete.add(Integer.valueOf(36));
    listeOrigineIncomplete.add(Integer.valueOf(35));
    if ((listeOrigineInfo != null) && (listeOrigineInfo.getNbListOrigineInformation() > 0))
    {
      for (int i = 0; i < listeOrigineInfo.getNbListOrigineInformation(); i++)
      {
        BigDecimal code = listeOrigineInfo.getListeOrigineInformation(i).getCodeOrigineInformation();
        if (code != null)
        {
          int valeurCode = code.intValue();
          if ((estIncomplet) && (listeOrigineIncomplete.contains(Integer.valueOf(valeurCode)))) {
            mapperAttestationEmployeurIncomplete(pasGaec, periodeActiviteGa);
          } else if ((estBrouillon) && (listeOrigineBrouillon.contains(Integer.valueOf(valeurCode)))) {
            mapperAttestationEmployeurBrouillon(pasGaec);
          } else if (estAEDAConfirmer) {
            mapperAttestationEmployeurDematerialiseAConfirmer(pasGaec, periodeActiviteGa);
          } else {
            switch (valeurCode)
            {
            case 11: 
              pasGaec.ajouterOrigineInformationPAS(valeurCode, 3);
              break;
            case 110: 
              pasGaec.ajouterOrigineInformationPAS(valeurCode, 2);
              break;
            case 3: 
              pasGaec.ajouterOrigineInformationPAS(valeurCode, 4);
              break;
            case 18: 
            case 35: 
              mapperPasDna(pasGaec, periodeActiviteGa);
              break;
            case 19: 
            case 36: 
              pasGaec.ajouterOrigineInformationPAS(3, 4);
              
              break;
            case 31: 
            case 37: 
            case 54: 
            case 55: 
              pasGaec.ajouterOrigineInformationPAS(1, 1);
              
              break;
            case 1: 
            case 2: 
            case 4: 
            case 5: 
            case 6: 
            case 9: 
            case 10: 
            case 71: 
            case 74: 
              pasGaec.ajouterOrigineInformationPAS(valeurCode, 1);
              break;
            case 12: 
            case 15: 
              pasGaec.ajouterOrigineInformationPAS(valeurCode, 5);
              break;
            case 38: 
              pasGaec.ajouterOrigineInformationPAS(10, 1);
              
              break;
            default: 
              pasGaec.ajouterOrigineInformationPAS(valeurCode, 0);
            }
          }
        }
        else
        {
          if (Log.isTraceActive(MapperContratTravail.class, Niveau.DEBUG)) {
            Log.ecritTrace(Niveau.DEBUG, MapperContratTravail.class, "creerPeriodeActiviteSalarie", "Contrat de travail Gaec sans origine d'information");
          }
          GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_MAPPING_GA_ORIGINE_CT_UNDEF");
        }
      }
    }
    else
    {
      if (Log.isTraceActive(MapperContratTravail.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, MapperContratTravail.class, "creerPeriodeActiviteSalarie", "Contrat de travail Gaec sans origine d'information");
      }
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_MAPPING_GA_ORIGINE_CT_UNDEF");
    }
    definitionEtatAtteste(pasGaec);
    
    boolean contratRemunereBaseSmic = BooleanGa.valueOf(contratTravailGa.getIndicateurRemunerationSMIC());
    pasGaec.setContratRemunereBaseSmic(contratRemunereBaseSmic);
    
    MapperQuantiteTravail.completerQuantiteTravail(pasGaec);
    
    return pasGaec;
  }
  
  private static void mapperAttestationEmployeurIncomplete(PeriodeActiviteSalarie pas, PeriodeActivite pasGa)
  {
    if (pasGa.getChampsPeriodeActivite().getDateFin() != null) {
      pas.ajouterOrigineInformationPAS(11, 3);
    } else {
      pas.ajouterOrigineInformationPAS(3, 4);
    }
    ListeSalaires listeSalaires = pasGa.getContratTravail().getListeSalaires();
    if ((listeSalaires != null) && (listeSalaires.getNbListSalaire() > 0)) {
      pas.ajouterOrigineInformationPAS(12, 5);
    }
  }
  
  private static void mapperAttestationEmployeurBrouillon(PeriodeActiviteSalarie pas)
  {
    pas.ajouterOrigineInformationPAS(11, 3);
  }
  
  private static void mapperAttestationEmployeurDematerialiseAConfirmer(PeriodeActiviteSalarie pas, PeriodeActivite pasGa)
  {
    pas.ajouterOrigineInformationPAS(3, 4);
    
    ListeSalaires listeSalaires = pasGa.getContratTravail().getListeSalaires();
    if ((listeSalaires != null) && (listeSalaires.getNbListSalaire() > 0)) {
      pas.ajouterOrigineInformationPAS(12, 5);
    }
  }
  
  private static void mapperPasDna(PeriodeActiviteSalarie pas, PeriodeActivite pasGa)
  {
    pas.ajouterOrigineInformationPAS(3, 4);
    
    ListeSalaires listeSalaires = pasGa.getContratTravail().getListeSalaires();
    if ((listeSalaires != null) && (listeSalaires.getNbListSalaire() > 0)) {
      pas.ajouterOrigineInformationPAS(12, 5);
    }
  }
  
  public static void definitionEtatAtteste(PeriodeActiviteSalarie pasMappee)
  {
    boolean estAtteste = false;
    
    Collection<Integer> ensembleOriginesAttestees = new ArrayList();
    ensembleOriginesAttestees.add(Integer.valueOf(1));
    ensembleOriginesAttestees.add(Integer.valueOf(4));
    ensembleOriginesAttestees.add(Integer.valueOf(9));
    ensembleOriginesAttestees.add(Integer.valueOf(5));
    ensembleOriginesAttestees.add(Integer.valueOf(71));
    ensembleOriginesAttestees.add(Integer.valueOf(10));
    ensembleOriginesAttestees.add(Integer.valueOf(74));
    ensembleOriginesAttestees.add(Integer.valueOf(6));
    ensembleOriginesAttestees.add(Integer.valueOf(31));
    ensembleOriginesAttestees.add(Integer.valueOf(33));
    ensembleOriginesAttestees.add(Integer.valueOf(34));
    ensembleOriginesAttestees.add(Integer.valueOf(56));
    ensembleOriginesAttestees.add(Integer.valueOf(39));
    
    ensembleOriginesAttestees.add(Integer.valueOf(2));
    if (pasMappee.getIncomplete() != null)
    {
      if (!pasMappee.getIncomplete().equals(ConstantesContratTravail.INCOMPLETE))
      {
        Iterator<Integer> iter = ensembleOriginesAttestees.iterator();
        while (iter.hasNext())
        {
          estAtteste = pasMappee.getCollectionOrigineInformationPAS().contains((Integer)iter.next());
          if (estAtteste) {
            break;
          }
        }
      }
    }
    else
    {
      Iterator<Integer> iter = ensembleOriginesAttestees.iterator();
      while (iter.hasNext())
      {
        estAtteste = pasMappee.getCollectionOrigineInformationPAS().contains((Integer)iter.next());
        if (estAtteste) {
          break;
        }
      }
    }
    pasMappee.setEstAtteste(estAtteste);
  }
  
  private static fr.unedic.cali.autresdoms.ga.dom.ContratTravail creerContratTravail(PeriodeActivite periodeActiviteGa)
  {
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContratTravail contratTravailGa = periodeActiviteGa.getContratTravail();
    fr.unedic.cali.autresdoms.ga.dom.ContratTravail contratTravailCali = new fr.unedic.cali.autresdoms.ga.dom.ContratTravail();
    
    contratTravailCali.setStatutParticulier(CodeGa.valueOf(contratTravailGa.getCodeStatutParticulierContrat()));
    
    contratTravailCali.setNature(CodeGa.valueOf(contratTravailGa.getCodeNature()));
    
    contratTravailCali.setNiveauQualification(CodeGa.valueOf(contratTravailGa.getCodeNiveauQualif()));
    
    contratTravailCali.setDerogationPlafondMensuel(BooleanGa.valueOf(contratTravailGa.getDerogationPlafondMensuel()));
    
    contratTravailCali.setLicenceAEM(BooleanGa.valueOf(contratTravailGa.getIndicateurLicenceSpec()));
    contratTravailCali.setLabelAEM(BooleanGa.valueOf(contratTravailGa.getIndicateurLabelPrestaService()));
    contratTravailCali.setCCSAEM(BooleanGa.valueOf(contratTravailGa.getIndicateurAffiCaisseCongesSpec()));
    contratTravailCali.setOrganisateurOccasionnelSpectacle(BooleanGa.valueOf(contratTravailGa.getIndicateurOrganisateurOccasionnelSpectacle()));
    if (contratTravailGa.getDjtp() != null) {
      contratTravailCali.setDernierJourTravaillePaye(contratTravailGa.getDjtp());
    } else {
      contratTravailCali.setDernierJourTravaillePaye(periodeActiviteGa.getChampsPeriodeActivite().getDateFin());
    }
    contratTravailCali.setPays(CodeGa.valueOf(contratTravailGa.getPays()));
    
    boolean transactionEffective = BooleanGa.valueOfTransactionEffective(contratTravailGa.getTransactionEnCours());
    contratTravailCali.setTransactionEffective(transactionEffective);
    
    boolean transactionEnCours = BooleanGa.valueOfTransactionEnCours(contratTravailGa.getTransactionEnCours());
    contratTravailCali.setTransactionEnCours(transactionEnCours);
    
    contratTravailCali.setDateInitialeFCD(contratTravailGa.getDateInitialeFCD());
    
    contratTravailCali.setPohf(CodeGa.valueOf(contratTravailGa.getActiviteHorsFrance()));
    
    contratTravailCali.setLienParenteAvecChefEntreprise(BooleanGa.valueOfLienParente(contratTravailGa.getLienDeParente()));
    
    RCTDom rct = contratTravailGa.getRCTDom();
    if (rct != null) {
      MapperRctDom.mapper(contratTravailCali, rct);
    }
    BigDecimal nbreJoursCongesPris = contratTravailGa.getNbreJoursCongesPris();
    if (nbreJoursCongesPris != null) {
      contratTravailCali.setNbreJoursCongesPris(nbreJoursCongesPris.intValue());
    }
    if (periodeActiviteGa.getChampsPeriodeActivite().getStatutFrauduleux() != null) {
      contratTravailCali.setInvestigationFrauduleuse(Integer.parseInt(periodeActiviteGa.getChampsPeriodeActivite().getStatutFrauduleux()));
    } else {
      contratTravailCali.setInvestigationFrauduleuse(0);
    }
    contratTravailCali.setNumeroConventionGestion(contratTravailGa.getNumeroConventionPE());
    contratTravailCali.setCodeAffectation(contratTravailGa.getCodeAffectation());
    if (periodeActiviteGa.getChampsPeriodeActivite() != null) {
      contratTravailCali.setIdExterneEmployeurPublic(periodeActiviteGa.getChampsPeriodeActivite().getIdExterne());
    }
    if ((periodeActiviteGa.getChampsPeriodeActivite() != null) && (periodeActiviteGa.getChampsPeriodeActivite().getAncienneteCSP() != null)) {
      contratTravailCali.setAncienneteCSP(periodeActiviteGa.getChampsPeriodeActivite().getAncienneteCSP());
    }
    contratTravailCali.setEtudeMandataire(recupererEtudeMandataire(contratTravailGa));
    
    contratTravailCali.setRessortissant(contratTravailGa.getRessortissant());
    
    contratTravailCali.setIdccEmployeur(contratTravailGa.getIdccE());
    contratTravailCali.setIdccPrestataire(contratTravailGa.getIdccP());
    
    return contratTravailCali;
  }
  
  protected static String recupererEtudeMandataire(fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContratTravail contratTravailGa)
  {
    String etudeMandataire = contratTravailGa.getEtudeMandataire();
    if ("5".equals(etudeMandataire)) {
      etudeMandataire = "1";
    }
    return etudeMandataire;
  }
  
  private static boolean estAeBrouillon(PeriodeActivite periodeActiviteGa)
  {
    if (periodeActiviteGa.getChampsPeriodeActivite().getIncomplete().equals(ConstantesContratTravail.BROUILLON))
    {
      ListeOrigineInformation listeOrigineInfo = periodeActiviteGa.getChampsPeriodeActivite().getListeOrigineInformation();
      if ((listeOrigineInfo != null) && (listeOrigineInfo.getNbListOrigineInformation() > 0)) {
        for (int i = 0; i < listeOrigineInfo.getNbListOrigineInformation(); i++)
        {
          BigDecimal code = listeOrigineInfo.getListeOrigineInformation(i).getCodeOrigineInformation();
          if ((code != null) && (code.intValue() == 1)) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private static void mapperAeBrouillon(PeriodeActivite periodeActiviteGa, ChronologiePeriodes listePeriodeActiviteSalarieeCali)
    throws CoucheLogiqueException
  {
    fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContratTravail contratTravailGa = periodeActiviteGa.getContratTravail();
    ListeMetiers listeMetiers = contratTravailGa.getListeMetiers();
    fr.unedic.cali.autresdoms.ga.dom.ContratTravail contratTravailCali = new fr.unedic.cali.autresdoms.ga.dom.ContratTravail();
    
    PeriodeActiviteSalarie pasGaec = null;
    ActiviteSalarie activite = null;
    for (int i = 0; i < listeMetiers.getNbListMetier(); i++)
    {
      fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier metierGa = listeMetiers.getListeMetiers(i);
      
      Periode periode = FabriquePeriode.creer(metierGa.getDateDebMetier(), metierGa.getDateFinMetier());
      
      pasGaec = new PeriodeActiviteSalarie(periode);
      
      pasGaec.setIncomplete(periodeActiviteGa.getChampsPeriodeActivite().getIncomplete());
      
      mapperAttestationEmployeurBrouillon(pasGaec);
      
      fr.unedic.cali.autresdoms.ga.dom.Metier metierCali = new fr.unedic.cali.autresdoms.ga.dom.Metier();
      metierCali.setCategorieEmploiParticulier(CodeGa.valueOf(metierGa.getCodeCatEmploiParticulier()));
      metierCali.setContratTypeParticulier(CodeGa.valueOf(metierGa.getContratTypeParticulier()));
      if ((metierCali.getContratTypeParticulier() == 22) || (metierCali.getContratTypeParticulier() == 21))
      {
        CritereStrategie critereCACIRMA = new CritereStrategie();
        critereCACIRMA.setDatePivot(metierGa.getDateDebMetier());
        StrategiePECCACIRMAetCUISpec strategieCACIRMA = (StrategiePECCACIRMAetCUISpec)FabriqueStrategiePECCACIRMAetCUI.getInstance().getStrategie(critereCACIRMA);
        
        metierCali.setContratTypeParticulier(strategieCACIRMA.mapperTypeContratParticulier(metierCali.getContratTypeParticulier()));
      }
      String codeEmploi = metierGa.getCodeEmploiTenu();
      metierCali.setCodeEmploi(CodeGa.valueOf(codeEmploi));
      String champApplication = metierGa.getChampApplication();
      int codeChampApplication = CodeGa.valueOf(champApplication);
      metierCali.setChampApplication(codeChampApplication);
      pasGaec.setMetier(metierCali);
      
      pasGaec.setEntreprise(new Entreprise());
      
      RCTDom rct = contratTravailGa.getRCTDom();
      Damj dateFinPourCtp = null;
      if (rct != null) {
        dateFinPourCtp = rct.getDateEngagementProcedure();
      }
      if (dateFinPourCtp == null) {
        dateFinPourCtp = pasGaec.getDateFin();
      }
      MapperEntreprise.mapper(pasGaec.getEntreprise(), contratTravailGa.getEntreprise(), dateFinPourCtp);
      if (rct != null) {
        MapperRctDom.mapper(contratTravailCali, rct);
      }
      String strIdent = periodeActiviteGa.getChampsPeriodeActivite().getIdPeriodeActivite() + "-" + i;
      pasGaec.setIdentifiant(strIdent);
      pasGaec.setContratTravail(contratTravailCali);
      
      activite = new ActiviteSalarie(pasGaec);
      if (activite.getDateFin().coincideAvec(periodeActiviteGa.getChampsPeriodeActivite().getDateFin())) {
        activite.setEstUneFct(true);
      }
      listePeriodeActiviteSalarieeCali.ajouter(activite);
    }
  }
}

/* Location:
 * Qualified Name:     MapperContratTravail
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
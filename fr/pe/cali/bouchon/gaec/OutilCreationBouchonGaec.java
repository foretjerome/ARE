package fr.pe.cali.bouchon.gaec;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.BulletinSalaire;
import fr.unedic.cali.autresdoms.ga.dom.ChequeEmploiService;
import fr.unedic.cali.autresdoms.ga.dom.ContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.DeclareMaladie;
import fr.unedic.cali.autresdoms.ga.dom.DeclareTravail;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.Indemnite;
import fr.unedic.cali.autresdoms.ga.dom.IndividuGaecAbstrait;
import fr.unedic.cali.autresdoms.ga.dom.Metier;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePonctuelle;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeEtatNonProfessionnel;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnelIndemnisable;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeFormation;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeFormationAssimilable;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeIndemnisationCaf;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeIntensite;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.autresdoms.ga.dom.Preavis;
import fr.unedic.cali.autresdoms.ga.dom.RevenuPans;
import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.cali.autresdoms.ga.dom.spec.ConstantesContratTravail;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.autresdoms.ga.mapping.MapperContratTravail;
import fr.unedic.cali.autresdoms.ga.mapping.MapperPans;
import fr.unedic.cali.dom.PeriodeActiviteSalarieCali;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePeriodeEmploiPANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeRevenuPANSPeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PANSPeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeEmploiPANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RevenuPANSPeriodique;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.QuantiteJoursOuvrables;
import fr.unedic.util.QuantiteMonnaie;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.UniteDuree;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

public class OutilCreationBouchonGaec
{
  private static OutilCreationBouchonGaec instance = null;
  public static final int TYPE_PERIODE_GA_AUCUN = 0;
  public static final int TYPE_PERIODE_GA_PRIVE = 1;
  public static final int TYPE_PERIODE_GA_PUBLIC_AUTO_ASSURANCE = 3;
  public static final int TYPE_PERIODE_GA_PUBLIC_CONVENTION_GESTION = 4;
  public static final int TYPE_PERIODE_GA_PRIVE_ENSEIGNEMENT = 8;
  protected static final BigDecimal DOUZE = new BigDecimal(12);
  protected static final BigDecimal NB_JOURS_MOIS = new BigDecimal(30);
  protected static final int NB_JOURS_AN = 365;
  
  public static OutilCreationBouchonGaec getInstance()
  {
    if (instance == null) {
      instance = new OutilCreationBouchonGaec();
    }
    return instance;
  }
  
  public ActiviteSalarie creerActiviteSalariee(String idPeriode, Periode periode, String reglement, BigDecimal salaire, int motifDepart)
    throws CoucheLogiqueException
  {
    return creerActiviteSalarieeTypeeChampApplication(idPeriode, periode, reglement, salaire, motifDepart, 0);
  }
  
  public ActiviteSalarie creerActiviteSalarieeTypeeChampApplication(String idPeriode, Periode periode, String reglement, BigDecimal salaire, int motifDepart, int typePeriodeGaec)
    throws CoucheLogiqueException
  {
    return creerActiviteSalarieeTypeeChampApplicationAvecOrigineInformation(idPeriode, periode, reglement, salaire, motifDepart, typePeriodeGaec, 1);
  }
  
  public ActiviteSalarie creerActiviteSalarieeTypeeChampApplicationAvecOrigineInformation(String idPeriode, Periode periode, String reglement, BigDecimal salaire, int motifDepart, int typePeriodeGaec, int origineInformation)
    throws CoucheLogiqueException
  {
    PeriodeActiviteSalarie pasGa = instancierPeriodeGaec(periode, typePeriodeGaec);
    ActiviteSalarie periodeActiviteSalarie = new ActiviteSalarie(pasGa);
    periodeActiviteSalarie.setIdentifiant(idPeriode);
    if (salaire != null) {
      creerListeSalaires(periodeActiviteSalarie, salaire, reglement);
    }
    periodeActiviteSalarie = ajouterContratTravail(periodeActiviteSalarie, periode.getFin());
    
    periodeActiviteSalarie.setCodeMotifFin(motifDepart);
    
    ajouterOrigineInformationPrincipalePas(periodeActiviteSalarie, origineInformation);
    
    configurerPOHF(periodeActiviteSalarie, 0);
    if (reglement != null) {
      periodeActiviteSalarie = qualifierPeriodeActiviteSalarie(periodeActiviteSalarie, reglement);
    }
    MapperContratTravail.definitionEtatAtteste(pasGa);
    
    periodeActiviteSalarie.getPeriodeActiviteSalarieGaec().setIncomplete(ConstantesContratTravail.COMPLETE);
    
    periodeActiviteSalarie.getPeriodeActiviteSalarieGaec().setIdentifiant(idPeriode);
    periodeActiviteSalarie.setEstUneFct(true);
    return periodeActiviteSalarie;
  }
  
  public void configurerPOHF(ActiviteSalarie pas, int pohf)
  {
    pas.getContrat().setPohf(pohf);
  }
  
  private PeriodeActiviteSalarie instancierPeriodeGaec(Periode periode, int typePeriodeGaec)
  {
    PeriodeActiviteSalarie pasGa = new PeriodeActiviteSalarie(periode);
    pasGa.setIncomplete(ConstantesContratTravail.COMPLETE);
    pasGa.getMetier().setChampApplication(typePeriodeGaec);
    
    return pasGa;
  }
  
  public ActiviteSalarie creerActiviteSalariee(String idPeriode, Periode periode, String reglement, BigDecimal salaire, int motifDepart, int constanteOrigineInformation)
    throws CoucheLogiqueException
  {
    return creerActiviteSalarieeTypeeChampApplicationAvecOrigineInformation(idPeriode, periode, reglement, salaire, motifDepart, 0, constanteOrigineInformation);
  }
  
  public void configurerPaysTravail(ActiviteSalarie periodeActiviteSalarie, int pays)
  {
    periodeActiviteSalarie.getContrat().setPays(pays);
  }
  
  public void configurerSecteurActivite(ActiviteSalarie periodeActiviteSalarie, int secteurActivite)
  {
    periodeActiviteSalarie.setSecteurActivite(secteurActivite);
  }
  
  public ActiviteSalarie ajouterPeriodeTravail(ActiviteSalarie periodeActiviteSalarie, Periode periodeTravail, QuantiteEuro salaire, Damj datePaie, String reglement)
  {
    if (salaire != null)
    {
      Salaire periodeSalaire = new Salaire(periodeTravail);
      
      periodeSalaire.setMontantBrutBase(salaire);
      periodeSalaire.setDatePaie(datePaie);
      if ((reglement.equals("A8")) || (reglement.equals("A10"))) {
        periodeSalaire.setNombreJoursTravailles(BigDecimal.valueOf(periodeTravail.getDuree()));
      }
      if (reglement.equals("A3")) {
        periodeSalaire.calculerMontantSoumisContributionRaA3();
      } else {
        periodeSalaire.calculerMontantSoumisContribution();
      }
      periodeActiviteSalarie.ajouterSalaire(periodeSalaire);
    }
    return periodeActiviteSalarie;
  }
  
  public void creerListeSalaires(ActiviteSalarie periodeActiviteSalarie, BigDecimal salaireAnnuel, String reglement)
  {
    BigDecimal salaireMensuel = calculerSalaireMensuel(periodeActiviteSalarie.getPeriode(), salaireAnnuel);
    
    ArrayList<?> listePeriodesSalaireMensuelles = periodeActiviteSalarie.getPeriode().decouperEnMoisCivils();
    for (int i = 0; i < listePeriodesSalaireMensuelles.size(); i++)
    {
      Periode periodeSalaireCourante = (Periode)listePeriodesSalaireMensuelles.get(i);
      BigDecimal valeurSalaireCourant;
      if ((!periodeSalaireCourante.getDebut().estLeDebutDuMois()) || (!periodeSalaireCourante.getFin().estLaFinDuMois()))
      {
        Periode moisCivilEntier = new Periode(periodeSalaireCourante.getDebut().getDebutMois(), periodeSalaireCourante.getDebut().getFinMois());
        
        BigDecimal nominateur1 = new BigDecimal(String.valueOf(periodeSalaireCourante.getDuree()));
        BigDecimal nominateur2 = salaireMensuel;
        BigDecimal denominateur = new BigDecimal(String.valueOf(moisCivilEntier.getDuree()));
        BigDecimal valeurSalaireCourant = Mathematiques.proratiser(nominateur1, nominateur2, denominateur);
        valeurSalaireCourant = Mathematiques.arrondiASup(valeurSalaireCourant, 2);
      }
      else
      {
        valeurSalaireCourant = salaireMensuel;
      }
      ajouterPeriodeTravail(periodeActiviteSalarie, periodeSalaireCourante, new QuantiteEuro(valeurSalaireCourant), reglement);
    }
  }
  
  private BigDecimal calculerSalaireMensuel(Periode periodeSalaireAnnuelleGlobale, BigDecimal salaireAnnuel)
  {
    BigDecimal salaireMensuel = BigDecimal.ZERO;
    if (salaireAnnuel != null) {
      if ((periodeSalaireAnnuelleGlobale != null) && (periodeSalaireAnnuelleGlobale.getDuree() < 365))
      {
        salaireMensuel = Mathematiques.diviseParDefaut(salaireAnnuel, new BigDecimal(periodeSalaireAnnuelleGlobale.getDuree()));
        if (periodeSalaireAnnuelleGlobale.getDuree() > NB_JOURS_MOIS.intValue()) {
          salaireMensuel = salaireMensuel.multiply(NB_JOURS_MOIS);
        } else {
          salaireMensuel = salaireAnnuel;
        }
      }
      else
      {
        salaireMensuel = Mathematiques.diviseParDefaut(salaireAnnuel, DOUZE);
      }
    }
    return salaireMensuel;
  }
  
  public ActiviteSalarie ajouterPeriodeTravail(ActiviteSalarie periodeActiviteSalarie, Periode periodeTravail, QuantiteEuro salaire, String reglement)
  {
    return ajouterPeriodeTravail(periodeActiviteSalarie, periodeTravail, salaire, periodeTravail.getFin(), reglement);
  }
  
  public ActiviteSalarie qualifierPeriodeActiviteSalarie(ActiviteSalarie periodeActiviteSalarie, String reglement)
    throws CoucheLogiqueException
  {
    periodeActiviteSalarie.setPeriodeActiviteSalarieCali(new PeriodeActiviteSalarieCali());
    
    configurerPASenFonctionReglement(periodeActiviteSalarie, reglement);
    if (periodeActiviteSalarie.getCollectionOrigineInformationPAS().isEmpty()) {
      ajouterOrigineInformationPrincipalePas(periodeActiviteSalarie, 1);
    }
    return periodeActiviteSalarie;
  }
  
  private void configurerPASenFonctionReglement(ActiviteSalarie periodeActiviteSalarie, String reglement)
  {
    if (reglement.equals("A1"))
    {
      configurerContrat(periodeActiviteSalarie, 1, 36);
      configurerPOHF(periodeActiviteSalarie, 0);
    }
    else if (reglement.equals("OP"))
    {
      configurerCodeMetier(periodeActiviteSalarie, 40);
    }
    else if (reglement.equals("A2a"))
    {
      periodeActiviteSalarie.getMetier().setChampApplication(1);
      configurerContrat(periodeActiviteSalarie, 1, 37);
      configurerPOHF(periodeActiviteSalarie, 0);
    }
    else if (reglement.equals("A2b"))
    {
      periodeActiviteSalarie.getMetier().setChampApplication(1);
      configurerContrat(periodeActiviteSalarie, 1, 38);
      configurerPOHF(periodeActiviteSalarie, 0);
    }
    else if (reglement.equals("A3"))
    {
      configurerContrat(periodeActiviteSalarie, 2, 27);
      configurerPOHF(periodeActiviteSalarie, 0);
    }
    else if (reglement.equals("A4"))
    {
      configurerContrat(periodeActiviteSalarie, 2, 34);
      configurerPOHF(periodeActiviteSalarie, 0);
    }
    else if (reglement.equals("A5"))
    {
      configurerContrat(periodeActiviteSalarie, 1, 45);
      configurerPOHF(periodeActiviteSalarie, 0);
    }
    else if (reglement.equals("A8"))
    {
      configurerContrat(periodeActiviteSalarie, 2, 44);
      
      periodeActiviteSalarie.ajouterOrigineInformationPAS(4, 0);
      
      periodeActiviteSalarie.getEntreprise().setCodeNAF("921D");
      
      periodeActiviteSalarie.getEntreprise().setSiren("123456789");
      
      HashSet set = new HashSet();
      set.add(Integer.valueOf(5));
      periodeActiviteSalarie.getMetier().setListeCategoriesEmploiSpe(set);
      configurerPOHF(periodeActiviteSalarie, 0);
    }
    else if (reglement.equals("A10"))
    {
      configurerContrat(periodeActiviteSalarie, 2, 21);
      
      periodeActiviteSalarie.ajouterOrigineInformationPAS(4, 0);
      configurerPOHF(periodeActiviteSalarie, 0);
    }
    else if (reglement.equals("RG"))
    {
      configurerContrat(periodeActiviteSalarie, 1, 50);
      configurerPOHF(periodeActiviteSalarie, 0);
    }
    else if (reglement.equals("RGP"))
    {
      configurerContrat(periodeActiviteSalarie, 1, 50);
      configurerPOHF(periodeActiviteSalarie, 8);
    }
    else if (reglement.equals("A9A"))
    {
      configurerContrat(periodeActiviteSalarie, 1, 50);
      configurerPOHF(periodeActiviteSalarie, 2);
    }
    else if (reglement.equals("A9B"))
    {
      configurerContrat(periodeActiviteSalarie, 1, 50);
      configurerPOHF(periodeActiviteSalarie, 10);
    }
  }
  
  public ActiviteSalarie ajouterContratTravail(ActiviteSalarie periodeActiviteSalarie, Damj dernierJourPaye)
  {
    ContratTravail contrat = new ContratTravail();
    Entreprise entreprise = new Entreprise();
    contrat.setPays(1);
    contrat.setDateRuptureContratTravail(dernierJourPaye);
    
    periodeActiviteSalarie.setContrat(contrat);
    periodeActiviteSalarie.setDernierJourTravaillePaye(dernierJourPaye);
    periodeActiviteSalarie.getPeriodeActiviteSalarieGaec().setEntreprise(entreprise);
    
    entreprise.setLibelleEntreprise("ma petite entreprise");
    
    entreprise.setCodeNAF("123A");
    
    entreprise.setSiren("123456789");
    
    entreprise.setIdentifiantBNE("1234556789");
    entreprise.setNumeroAffiliation("12345678");
    return periodeActiviteSalarie;
  }
  
  public void configurerCodeNaf(ActiviteSalarie periodeActiviteSalarie, String codeNaf)
  {
    periodeActiviteSalarie.getEntreprise().setCodeNAF(codeNaf);
  }
  
  public void configurerCodeMetier(ActiviteSalarie periodeActiviteSalarie, int codeEmploi)
  {
    periodeActiviteSalarie.getMetier().setCodeEmploi(codeEmploi);
  }
  
  public void ajouterIccp(ActiviteSalarie pas, BigDecimal qteIccp)
  {
    pas.setQuantiteEuroIccp(new QuantiteEuro(qteIccp.toString()));
  }
  
  public void ajouterIccpNbJour(ActiviteSalarie pas, BigDecimal nbJour)
  {
    pas.setQuantiteJourIccp(new QuantiteJoursOuvrables(nbJour));
  }
  
  public void ajouterOrigineInformationPrincipalePas(ActiviteSalarie pas, int constanteOrigineInformationPas)
  {
    switch (constanteOrigineInformationPas)
    {
    case 11: 
      pas.ajouterOrigineInformationPAS(constanteOrigineInformationPas, 3);
      break;
    case 3: 
      pas.ajouterOrigineInformationPAS(constanteOrigineInformationPas, 4);
      break;
    case 1: 
    case 4: 
    case 5: 
    case 6: 
    case 9: 
    case 10: 
    case 71: 
    case 74: 
      pas.ajouterOrigineInformationPAS(constanteOrigineInformationPas, 1);
      break;
    case 12: 
    case 15: 
      pas.ajouterOrigineInformationPAS(constanteOrigineInformationPas, 5);
      break;
    default: 
      pas.ajouterOrigineInformationPAS(constanteOrigineInformationPas, 0);
    }
    MapperContratTravail.definitionEtatAtteste(pas.getPeriodeActiviteSalarieGaec());
  }
  
  public void suppressionOriginesInformationPrincipalesPas(ActiviteSalarie pas)
  {
    Map<Integer, Collection<Integer>> hashmapOriginesInformationPAS = pas.getCollectionOrigineInformationPASAvecPriorite();
    hashmapOriginesInformationPAS.clear();
    Collection<Integer> collectionOriginesInformationPasCertifTravail = new ArrayList();
    Collection<Integer> collectionOriginesInformationPasContratTravail = new ArrayList();
    Collection<Integer> collectionOriginesInformationPasAeEquiv = new ArrayList();
    Collection<Integer> collectionOriginesInformationPasAutres = new ArrayList();
    Collection<Integer> collectionOriginesInformationPasBs = new ArrayList();
    hashmapOriginesInformationPAS.put(Integer.valueOf(3), collectionOriginesInformationPasCertifTravail);
    
    hashmapOriginesInformationPAS.put(Integer.valueOf(4), collectionOriginesInformationPasContratTravail);
    
    hashmapOriginesInformationPAS.put(Integer.valueOf(1), collectionOriginesInformationPasAeEquiv);
    hashmapOriginesInformationPAS.put(Integer.valueOf(0), collectionOriginesInformationPasAutres);
    hashmapOriginesInformationPAS.put(Integer.valueOf(5), collectionOriginesInformationPasBs);
  }
  
  public void configurerContrat(ActiviteSalarie pas, int natureContrat, int categorieEmploiParticulier)
  {
    ContratTravail contrat = pas.getContrat();
    contrat.setNature(natureContrat);
    Metier metier = pas.getMetier();
    metier.setCategorieEmploiParticulier(categorieEmploiParticulier);
  }
  
  public void configurerTypeContrat(ActiviteSalarie pas, int typeParticulierContrat)
  {
    Metier metier = pas.getMetier();
    metier.setContratTypeParticulier(typeParticulierContrat);
  }
  
  public void configurerContexteDV(ActiviteSalarie pas, int contexteDV)
  {
    pas.getContrat().setContexteDemission(contexteDV);
  }
  
  public void ajouterIndemniteIslr(ActiviteSalarie pas, QuantiteMonnaie qte)
  {
    ArrayList listeIndemnites = new ArrayList();
    Indemnite total = new Indemnite();
    total.setMontant(qte);
    total.setTypeIndemnite(5);
    Indemnite legaleLicenciement = new Indemnite();
    legaleLicenciement.setMontant(new QuantiteEuro("0"));
    legaleLicenciement.setTypeIndemnite(101);
    Indemnite islr = new Indemnite();
    islr.setMontant(qte);
    islr.setTypeIndemnite(102);
    listeIndemnites.add(total);
    listeIndemnites.add(legaleLicenciement);
    listeIndemnites.add(islr);
    pas.setListeIndemnites(listeIndemnites);
  }
  
  public ActiviteSalarie creerActiviteSalarieeAvecAffiliationParDefaut(String idPeriode, Periode periode, String reglement, BigDecimal salaire, int motifDepart)
    throws CoucheLogiqueException
  {
    return creerActiviteSalarieeAvecAffiliationParDefautTypeeChampApplication(idPeriode, periode, reglement, salaire, motifDepart, 1);
  }
  
  public ActiviteSalarie creerActiviteSalarieeAvecAffiliationParDefautTypeeChampApplication(String idPeriode, Periode periode, String reglement, BigDecimal salaire, int motifDepart, int typePeriodeGa)
    throws CoucheLogiqueException
  {
    ActiviteSalarie pas = creerActiviteSalarieeTypeeChampApplication(idPeriode, periode, reglement, salaire, motifDepart, typePeriodeGa);
    
    pas.setEstUneFct(true);
    pas.getEntreprise().setEstEmployeurAdherantATitreIrrevocable(true);
    
    PeriodeMesureActivite periodeMesureActivite = new PeriodeMesureActivite(periode);
    if (reglement != null)
    {
      if ((reglement.equals("A4")) || (reglement.equals("A8")) || (reglement.equals("A10")) || (reglement.equals("A5")))
      {
        periodeMesureActivite.ajouterQuantiteAffiliation(new Quantite(new BigDecimal(periode.getDuree()).multiply(new BigDecimal("5")), UniteAffiliation.HEURE_TRAVAIL));
      }
      else if (reglement.equals("A3"))
      {
        periodeMesureActivite.ajouterQuantiteAffiliation(new Quantite(new BigDecimal(periode.getDuree()), UniteAffiliation.VACATION));
      }
      else if (reglement.equals("A2a"))
      {
        periodeMesureActivite.ajouterQuantiteAffiliation(new Quantite(new BigDecimal(periode.getDuree()), UniteAffiliation.EMBARQUEMENT_ADMINISTRATIF));
      }
      else
      {
        periodeMesureActivite.ajouterQuantiteAffiliation(new Quantite(new BigDecimal(periode.getDuree()), UniteAffiliation.JOUR));
        periodeMesureActivite.ajouterQuantiteAffiliation(new Quantite(new BigDecimal(periode.getDuree()).multiply(new BigDecimal("5")), UniteAffiliation.HEURE_TRAVAIL));
      }
    }
    else {
      periodeMesureActivite.ajouterQuantiteAffiliation(new Quantite(new BigDecimal(periode.getDuree()), UniteAffiliation.JOUR));
    }
    pas.ajouterPeriodeMesureActivite(periodeMesureActivite);
    
    Chronologie chrono = new ChronologiePeriodes();
    chrono.ajouter(periodeMesureActivite);
    pas.getPeriodeActiviteSalarieGaec().setListePeriodesMesureActivite(chrono);
    
    BigDecimal intensite = new BigDecimal("35");
    ajouterPeriodeIntensite(pas, pas.getDateDebut(), pas.getDateFin(), 1, intensite, intensite);
    
    return pas;
  }
  
  public BulletinSalaire creerBulletinSalaire(String idPeriode, Damj dateDebut, Damj dateFin, QuantiteEuro salaire)
  {
    Periode periode = new Periode(dateDebut, dateFin);
    BulletinSalaire bs = new BulletinSalaire(periode);
    
    Salaire periodeSalaire = new Salaire(periode);
    periodeSalaire.setMontantSoumisAContribution(salaire);
    periodeSalaire.setDatePaie(dateFin);
    bs.ajouterSalaire(periodeSalaire);
    bs.setIdentifiant(idPeriode);
    bs.setListeInformationOrigine(new ArrayList());
    return bs;
  }
  
  public ChequeEmploiService creerChequeEmploiService(String idPeriode, Damj dateDebut, Damj dateFin, QuantiteEuro salaire)
  {
    Periode periode = new Periode(dateDebut, dateFin);
    ChequeEmploiService ces = new ChequeEmploiService(periode);
    
    Salaire periodeSalaire = new Salaire(periode);
    periodeSalaire.setMontantSoumisAContribution(salaire);
    periodeSalaire.setDatePaie(dateFin);
    ces.ajouterSalaire(periodeSalaire);
    ces.setIdentifiant(idPeriode);
    return ces;
  }
  
  public void ajouterPeriodeMesureActivite(ActiviteSalarie pas, Damj dateDebut, Damj dateFin, int intensiteAffiliation, Unite unite)
  {
    PeriodeMesureActivite periodeMesureActivite = new PeriodeMesureActivite(dateDebut, dateFin);
    periodeMesureActivite.ajouterQuantiteAffiliation(new Quantite(intensiteAffiliation, unite));
    pas.ajouterPeriodeMesureActivite(periodeMesureActivite);
  }
  
  public void ajouterPeriodeMesureActivite(ActiviteSalarie pas, Damj dateDebut, Damj dateFin, BigDecimal intensiteAffiliation, Unite unite)
  {
    PeriodeMesureActivite periodeMesureActivite = new PeriodeMesureActivite(dateDebut, dateFin);
    periodeMesureActivite.ajouterQuantiteAffiliation(new Quantite(intensiteAffiliation, unite));
    pas.ajouterPeriodeMesureActivite(periodeMesureActivite);
  }
  
  public void ajouterPeriodeIntensite(ActiviteSalarie pas, Damj dateDebut, Damj dateFin, int uniteIntensite, BigDecimal horaireSalarie, BigDecimal horaireEntreprise)
  {
    Periode periode = new Periode(dateDebut, dateFin);
    PeriodeIntensite periodeIntensite = new PeriodeIntensite(periode);
    periodeIntensite.setHorairesSalarie(horaireSalarie);
    periodeIntensite.setHorairesEntreprise(horaireEntreprise);
    periodeIntensite.setUniteHoraire(uniteIntensite);
    pas.ajouterPeriodeIntensite(periodeIntensite);
  }
  
  public void configurerContratTravail(ActiviteSalarie periodeActiviteSalarieSpec, int motifRupture, int natureContrat, Damj dateRuptureContrat, Damj dateInitialeFinCdd, boolean isTransactionEnCours, BigDecimal valeurMontantTransaction)
  {
    ContratTravail contrat;
    ContratTravail contrat;
    if (periodeActiviteSalarieSpec.getContrat() != null) {
      contrat = periodeActiviteSalarieSpec.getContrat();
    } else {
      contrat = new ContratTravail();
    }
    if (valeurMontantTransaction != null)
    {
      periodeActiviteSalarieSpec.setQuantiteEuroIndemniteTransactionnelle(new QuantiteEuro(valeurMontantTransaction));
      contrat.setTransactionEffective(true);
    }
    contrat.setCodeMotifFin(motifRupture);
    contrat.setNature(natureContrat);
    contrat.setDateRuptureContratTravail(dateRuptureContrat);
    contrat.setDateInitialeFCD(dateInitialeFinCdd);
    contrat.setTransactionEnCours(isTransactionEnCours);
    periodeActiviteSalarieSpec.setContrat(contrat);
  }
  
  public void configurerPreavis(ActiviteSalarie periodeActiviteSalarieSpec, Periode periodePreavisEffectuePaye, Periode preavisNonEffectuePaye, Periode preavisNonEffectueNonPaye, boolean actionPrudhomale, boolean engagementRemboursement)
  {
    ContratTravail contrat;
    ContratTravail contrat;
    if (periodeActiviteSalarieSpec.getContrat() != null)
    {
      contrat = periodeActiviteSalarieSpec.getContrat();
    }
    else
    {
      contrat = new ContratTravail();
      periodeActiviteSalarieSpec.setContrat(contrat);
    }
    Preavis preavis;
    Preavis preavis;
    if (periodeActiviteSalarieSpec.getContrat().getPreavis() != null) {
      preavis = periodeActiviteSalarieSpec.getContrat().getPreavis();
    } else {
      preavis = new Preavis();
    }
    preavis.setPeriodeEffectuee(periodePreavisEffectuePaye);
    preavis.setPeriodeNonEffectueePayee(preavisNonEffectuePaye);
    preavis.setPeriodeNonEffectueeNonPayee(preavisNonEffectueNonPaye);
    preavis.setActionPrudhommale(actionPrudhomale);
    preavis.setEngagementRemboursement(engagementRemboursement);
    contrat.setPreavis(preavis);
  }
  
  public void configurerSiren(ActiviteSalarie periodeActiviteSalarieSpec, String siren)
  {
    periodeActiviteSalarieSpec.getEntreprise().setSiren(siren);
  }
  
  public PeriodeFormationAssimilable creerPeriodeFormationAssimilable(String idPeriode, Damj dateDebutFormation, Damj dateFinFormation, int dureeTotale, int origineRemuneration)
  {
    PeriodeFormationAssimilable pef = new PeriodeFormationAssimilable(dateDebutFormation, dateFinFormation);
    pef.setDureeTotale(new Quantite(dureeTotale, UniteDuree.HEURE));
    pef.setNomOrganismeFormation("AFPA");
    pef.setOrigineRemuneration(origineRemuneration);
    pef.setIdentifiant(idPeriode);
    return pef;
  }
  
  public PeriodeFormation creerPeriodeFormationNonAssimilable(String idPeriode, Damj dateDebutFormation, Damj dateFinFormation, int dureeTotale, int origineRemuneration)
  {
    PeriodeFormation pef = new PeriodeFormation(dateDebutFormation, dateFinFormation);
    pef.setDureeTotale(new Quantite(dureeTotale, UniteDuree.HEURE));
    pef.setNomOrganismeFormation("AFPA");
    pef.setOrigineRemuneration(origineRemuneration);
    pef.setIdentifiant(idPeriode);
    return pef;
  }
  
  public PeriodeIndemnisationCaf creerPeriodeEvenementPersonnelCaf(String idPeriodeEvenement, Damj dateDebutEvenement, Damj dateFinEvenement, int nature)
  {
    PeriodeIndemnisationCaf pep = new PeriodeIndemnisationCaf(dateDebutEvenement, dateFinEvenement);
    
    pep.setIntensite(BigDecimal.ONE);
    pep.setNature(nature);
    pep.setIdentifiant(idPeriodeEvenement);
    return pep;
  }
  
  public PeriodeEvenementPersonnelIndemnisable creerPeriodeEvenementPersonnelSecu(String idPeriodeEvenement, Damj dateDebutEvenement, Damj dateFinEvenement, int nature)
  {
    PeriodeEvenementPersonnelIndemnisable pep = new PeriodeEvenementPersonnelIndemnisable(dateDebutEvenement, dateFinEvenement);
    pep.setTypePep(2);
    
    pep.setIntensite(BigDecimal.ONE);
    pep.setNature(nature);
    pep.setIdentifiant(idPeriodeEvenement);
    return pep;
  }
  
  public PeriodeEvenementPersonnel creerPeriodeEvenementPersonnelAutre(String idPeriodeEvenement, Damj dateDebutEvenement, Damj dateFinEvenement, int nature)
  {
    PeriodeEvenementPersonnel pep = new PeriodeEvenementPersonnel(dateDebutEvenement, dateFinEvenement);
    
    pep.setIntensite(BigDecimal.ONE);
    pep.setNature(nature);
    pep.setIdentifiant(idPeriodeEvenement);
    return pep;
  }
  
  public PeriodeEvenementPersonnel creerPeriodeEvenementPersonnelDisponibilite(String idPeriodeEvenement, Damj dateDebutEvenement, Damj dateFinEvenement, int nature, int statutFin)
  {
    PeriodeEvenementPersonnel pep = new PeriodeEvenementPersonnel(dateDebutEvenement, dateFinEvenement);
    
    pep.setIntensite(new BigDecimal("1"));
    pep.setNature(nature);
    pep.setIdentifiant(idPeriodeEvenement);
    pep.setStatutFin(statutFin);
    pep.setIdContratTravail("123456");
    return pep;
  }
  
  public PeriodeActiviteNonSalariePeriodique creerPeriodePansPeriodique(String idPeriodePans, Damj dateDebutPans, Damj dateFinPans, int nature, boolean etat, int motifRupture, boolean atteste)
    throws CoucheLogiqueException
  {
    ChampsPeriodeActivite champsPeriodeActivite = ChampsPeriodeActivite.getInstance();
    champsPeriodeActivite.setDateDebut(dateDebutPans);
    champsPeriodeActivite.setDateFin(dateFinPans);
    champsPeriodeActivite.setIdPeriodeActivite(idPeriodePans);
    
    ListePeriodeEmploiPANS listePeriodeEmploiPANS = ListePeriodeEmploiPANS.getInstance();
    
    PeriodeEmploiPANS periodeEmploi = PeriodeEmploiPANS.getInstance();
    listePeriodeEmploiPANS.addPeriodeEmploiPANS(periodeEmploi);
    periodeEmploi.setEmploi(String.valueOf(nature));
    periodeEmploi.setDateDebut(dateDebutPans);
    periodeEmploi.setDateFin(dateFinPans);
    
    ListeRevenuPANSPeriodique listeRevenuPansPeriodique = ListeRevenuPANSPeriodique.getInstance();
    periodeEmploi.setListeRevenuPANSPeriodique(listeRevenuPansPeriodique);
    
    RevenuPANSPeriodique revenuPansPeriodique = RevenuPANSPeriodique.getInstance();
    revenuPansPeriodique.setDateDebut(dateDebutPans);
    revenuPansPeriodique.setDateFin(dateFinPans);
    
    listeRevenuPansPeriodique.addRevenuPANSPeriodique(revenuPansPeriodique);
    if (etat) {
      periodeEmploi.setEtatProfessionnel("1");
    } else {
      periodeEmploi.setEtatProfessionnel("2");
    }
    PANSPeriodique pansPeriodique = PANSPeriodique.getInstance();
    pansPeriodique.setListePeriodeEmploiPANS(listePeriodeEmploiPANS);
    pansPeriodique.setMotifRupture(Integer.toString(motifRupture));
    
    PANS pans = PANS.getInstance();
    pans.setPANSPeriodique(pansPeriodique);
    pans.setNature(Integer.toString(nature));
    
    PeriodeActivite periodeActivite = PeriodeActivite.getInstance();
    periodeActivite.setChampsPeriodeActivite(champsPeriodeActivite);
    periodeActivite.setPANS(pans);
    
    PeriodeActiviteNonSalariePeriodique periode = MapperPans.mapperPans(periodeActivite);
    periode.setNatureActivite(nature);
    periode.setEtatProfessionnelGlobalPourAppletLiq(etat);
    periode.setMotifRupture(motifRupture);
    periode.setIdentifiant(idPeriodePans);
    periode.setEstAtteste(atteste);
    return periode;
  }
  
  public PeriodeActiviteNonSalariePeriodique creerPeriodePansPeriodiquePourACCRE(String idPeriodePans, Damj dateDebutPans, Damj dateFinPans, int nature, boolean etat, int motifRupture, int accordDDTEParametre, Damj dateAccordDDTE, int activiteEntreprise)
    throws CoucheLogiqueException
  {
    BigDecimal accordDDTE = new BigDecimal(accordDDTEParametre);
    
    ChampsPeriodeActivite champsPeriodeActivite = ChampsPeriodeActivite.getInstance();
    champsPeriodeActivite.setDateDebut(dateDebutPans);
    champsPeriodeActivite.setDateFin(dateFinPans);
    champsPeriodeActivite.setIdPeriodeActivite(idPeriodePans);
    
    ListePeriodeEmploiPANS listePeriodeEmploiPANS = ListePeriodeEmploiPANS.getInstance();
    
    PeriodeEmploiPANS periodeEmploi = PeriodeEmploiPANS.getInstance();
    listePeriodeEmploiPANS.addPeriodeEmploiPANS(periodeEmploi);
    periodeEmploi.setEmploi(String.valueOf(nature));
    periodeEmploi.setDateDebut(dateDebutPans);
    periodeEmploi.setDateFin(dateFinPans);
    
    ListeRevenuPANSPeriodique listeRevenuPansPeriodique = ListeRevenuPANSPeriodique.getInstance();
    periodeEmploi.setListeRevenuPANSPeriodique(listeRevenuPansPeriodique);
    
    RevenuPANSPeriodique revenuPansPeriodique = RevenuPANSPeriodique.getInstance();
    revenuPansPeriodique.setDateDebut(dateDebutPans);
    revenuPansPeriodique.setDateFin(dateFinPans);
    
    listeRevenuPansPeriodique.addRevenuPANSPeriodique(revenuPansPeriodique);
    if (etat) {
      periodeEmploi.setEtatProfessionnel("1");
    } else {
      periodeEmploi.setEtatProfessionnel("2");
    }
    PANSPeriodique pansPeriodique = PANSPeriodique.getInstance();
    pansPeriodique.setListePeriodeEmploiPANS(listePeriodeEmploiPANS);
    pansPeriodique.setMotifRupture(Integer.toString(motifRupture));
    pansPeriodique.setAccordACCRE(accordDDTE);
    pansPeriodique.setDateAccordACCRE(dateAccordDDTE);
    
    PANS pans = PANS.getInstance();
    pans.setPANSPeriodique(pansPeriodique);
    pans.setNature(Integer.toString(nature));
    
    PeriodeActivite periodeActivite = PeriodeActivite.getInstance();
    periodeActivite.setChampsPeriodeActivite(champsPeriodeActivite);
    periodeActivite.setPANS(pans);
    
    PeriodeActiviteNonSalariePeriodique periode = MapperPans.mapperPans(periodeActivite);
    periode.setActiviteEntreprise(activiteEntreprise);
    periode.setDateValidationPANS(dateAccordDDTE);
    periode.setActiviteEntreprise(activiteEntreprise);
    periode.setStatusDDTE(accordDDTEParametre);
    
    return periode;
  }
  
  public void ajouterSousPeriodeAPansPeriodique(PeriodeActiviteNonSalariePeriodique pans, Damj dateDebut, Damj dateFin, boolean etatProfessionnel)
  {
    PeriodeEtatNonProfessionnel sp = new PeriodeEtatNonProfessionnel(dateDebut, dateFin);
    sp.setEtatProfessionnel(etatProfessionnel);
    pans.ajouterPeriodeEtatNonProfessionnel(sp);
    
    pans.setEtatProfessionnelGlobalPourAppletLiq((pans.isEtatProfessionnelGlobalPourAppletLiq()) && (etatProfessionnel));
  }
  
  public PeriodeActiviteNonSalariePonctuelle creerPeriodePansPonctuelle(String idPeriodePans, Damj dateDebutPans, Damj dateFinPans, int nature, boolean etat)
  {
    PeriodeActiviteNonSalariePonctuelle pansPeriodique = new PeriodeActiviteNonSalariePonctuelle(dateDebutPans, dateFinPans);
    RevenuPans revenuPans = new RevenuPans(dateDebutPans, dateFinPans, new BigDecimal("150"));
    pansPeriodique.setRevenuPans(revenuPans);
    pansPeriodique.setNatureActivite(nature);
    pansPeriodique.setEtatProfessionnel(etat);
    pansPeriodique.setIdentifiant(idPeriodePans);
    return pansPeriodique;
  }
  
  public DeclareTravail creerPeriodeDeclareeTravail(String identifiant, Damj debut, Damj fin, BigDecimal nbHeures, BigDecimal qteEuros, String employeur)
  {
    DeclareTravail declareTravail = new DeclareTravail(debut, fin);
    declareTravail.setIdentifiant(identifiant);
    declareTravail.setEmployeur(employeur);
    declareTravail.setEstJustifie(false);
    declareTravail.setStatutDSMTravail(1);
    declareTravail.setQuantite(new Quantite(nbHeures, UniteDuree.HEURE));
    declareTravail.setMontant(new QuantiteEuro(qteEuros));
    declareTravail.setOrigineInfo(Integer.toString(62));
    declareTravail.setStatutDSMTravail(1);
    return declareTravail;
  }
  
  public DeclareMaladie creerPeriodeDeclareeMaladie(String identifiant, Damj debut, Damj fin)
  {
    DeclareMaladie declareMaladie = new DeclareMaladie(debut, fin);
    declareMaladie.setIdentifiant(identifiant);
    declareMaladie.setTypePeriodeDeclare(1);
    return declareMaladie;
  }
  
  public void modifierDatesPeriode(ActiviteSalarie periodeActiviteSalarie, Damj nouvelleDateDebut, Damj nouvelleDateFin)
  {
    if (nouvelleDateDebut != null) {
      periodeActiviteSalarie.setDateDebut(nouvelleDateDebut);
    }
    if (nouvelleDateFin != null) {
      periodeActiviteSalarie.setDateFin(nouvelleDateFin);
    }
  }
  
  public void ajouterPeriodeSurIndividuGaec(PeriodeGaecSpec periode, IndividuGaecAbstrait individu)
  {
    individu.ajouterPeriodePasseProfessionnel(periode);
  }
}

/* Location:
 * Qualified Name:     OutilCreationBouchonGaec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
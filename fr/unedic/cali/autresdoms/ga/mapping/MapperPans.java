package fr.unedic.cali.autresdoms.ga.mapping;

import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePonctuelle;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeAvecRevenu;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeEtatNonProfessionnel;
import fr.unedic.cali.autresdoms.ga.dom.PeriodePansAvecRevenu;
import fr.unedic.cali.autresdoms.ga.dom.PeriodePansSansRevenu;
import fr.unedic.cali.autresdoms.ga.dom.RevenuPans;
import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.cali.calcul.parametres.AccesForfaitMensuellePansAgricole;
import fr.unedic.cali.calcul.parametres.ParametresIndemnisation;
import fr.unedic.cali.fabriques.FabriqueStrategieInstallationForfaitPANS;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieInstallationForfaitPANSSpec;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ContratTravail;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeOrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePND;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListePeriodeEmploiPANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeRevenuPANSPeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ListeSalaires;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Metier;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.OrigineInformation;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PANSPeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PANSPonctuelle;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PND;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeEmploiPANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RevenuPANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.RevenuPANSPeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.Salaire;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class MapperPans
{
  private static final int DECEMBRE = 12;
  private static final int DERNIER_JOUR_DECEMBRE = 31;
  private static final Damj DATE_PIVOT_GENERATION_FORFAIT = new Damj(2010, 7, 1);
  
  public static PeriodeActiviteNonSalariePeriodique mapperPasEnPans(PeriodeActivite periodeActivite, Metier metierGa)
    throws CoucheLogiqueException
  {
    Damj dateDebutPeriode = metierGa.getDateDebMetier();
    Damj dateFinPeriode = metierGa.getDateFinMetier();
    
    PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalarie = new PeriodeActiviteNonSalariePeriodique(FabriquePeriode.creer(dateDebutPeriode, dateFinPeriode));
    
    periodeActiviteNonSalarie.setIdentifiant(periodeActivite.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    periodeActiviteNonSalarie.setOrigineInfo(String.valueOf(3));
    
    periodeActiviteNonSalarie.setEstAtteste(mapperEtatAtteste(Integer.parseInt(periodeActiviteNonSalarie.getOrigineInfo())));
    
    mappingPND(periodeActivite, periodeActiviteNonSalarie);
    
    Periode periodeRevenu = FabriquePeriode.creer(dateDebutPeriode, dateFinPeriode);
    Collection<PeriodeAvecRevenu> collectionRevenuPansCali = new ArrayList();
    
    ContratTravail contratTravail = periodeActivite.getContratTravail();
    ListeSalaires listeSalaires = contratTravail.getListeSalaires();
    mappingSalaire(periodeActiviteNonSalarie, collectionRevenuPansCali, listeSalaires);
    
    periodeActiviteNonSalarie.setCollectionPeriodeAvecRevenu(collectionRevenuPansCali);
    
    periodeActiviteNonSalarie.setMotifRupture(5);
    
    periodeActiviteNonSalarie.setEntreprise(new Entreprise());
    if (contratTravail.getEntreprise() != null) {
      MapperEntreprise.mapper(periodeActiviteNonSalarie.getEntreprise(), contratTravail.getEntreprise(), periodeActiviteNonSalarie.getDateFin());
    }
    PeriodeEtatNonProfessionnel sousPeriodeActiviteNonSalarieePeriodique = new PeriodeEtatNonProfessionnel(periodeRevenu.getDebut(), periodeRevenu.getFin());
    sousPeriodeActiviteNonSalarieePeriodique.setEtatProfessionnel(true);
    periodeActiviteNonSalarie.ajouterPeriodeEtatNonProfessionnel(sousPeriodeActiviteNonSalarieePeriodique);
    periodeActiviteNonSalarie.setEtatProfessionnelGlobalPourAppletLiq(true);
    
    periodeActiviteNonSalarie.setStatusDDTE(0);
    periodeActiviteNonSalarie.setDateValidationPANS(null);
    
    periodeActiviteNonSalarie.setEtudeMandataire(contratTravail.getEtudeMandataire());
    
    return periodeActiviteNonSalarie;
  }
  
  private static void mappingSalaire(PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalarie, Collection<PeriodeAvecRevenu> collectionRevenuPansCali, ListeSalaires listeSalaires)
  {
    if (listeSalaires != null) {
      for (int i = 0; i < listeSalaires.getNbListSalaire(); i++)
      {
        Salaire salaireGaec = listeSalaires.getListeSalaires(i);
        Periode periode = FabriquePeriode.creer(salaireGaec.getDateDeb(), salaireGaec.getDateFin());
        if (periode.chevauche(periodeActiviteNonSalarie.getPeriode()))
        {
          PeriodeAvecRevenu revenuPansCali = new PeriodeAvecRevenu(periode.getDebut(), periode.getFin());
          
          revenuPansCali.setNatureActivite(5);
          if (salaireGaec.getMontantSalaireBrut() != null) {
            revenuPansCali.setMontant(salaireGaec.getMontantSalaireBrut());
          } else {
            revenuPansCali.setMontant(BigDecimal.ZERO);
          }
          revenuPansCali.setTypeRevenu(3);
          collectionRevenuPansCali.add(revenuPansCali);
        }
      }
    }
  }
  
  public static PeriodeActiviteNonSalariePeriodique mapperPans(PeriodeActivite periodeActivite)
    throws CoucheLogiqueException
  {
    PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalarie = new PeriodeActiviteNonSalariePeriodique(FabriquePeriode.creer(periodeActivite.getChampsPeriodeActivite().getDateDebut(), periodeActivite.getChampsPeriodeActivite().getDateFin()));
    
    periodeActiviteNonSalarie.setIdentifiant(periodeActivite.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    periodeActiviteNonSalarie.setOrigineInfo(mapperOriginesInfo(periodeActivite.getChampsPeriodeActivite().getListeOrigineInformation()));
    
    mappingPND(periodeActivite, periodeActiviteNonSalarie);
    
    boolean estPro = false;
    estPro = mapperNouveauModele(periodeActivite, periodeActiviteNonSalarie);
    if (!estPro) {
      return null;
    }
    periodeActiviteNonSalarie.setMotifRupture(CodeGa.valueOf(periodeActivite.getPANS().getPANSPeriodique().getMotifRupture()));
    
    periodeActiviteNonSalarie.setEntreprise(new Entreprise());
    if (periodeActivite.getPANS().getPANSPeriodique().getEntreprise() != null) {
      MapperEntreprise.mapper(periodeActiviteNonSalarie.getEntreprise(), periodeActivite.getPANS().getPANSPeriodique().getEntreprise(), periodeActiviteNonSalarie.getDateFin());
    }
    if (periodeActivite.getPANS().getPANSPeriodique().getAccordACCRE() != null) {
      periodeActiviteNonSalarie.setStatusDDTE(periodeActivite.getPANS().getPANSPeriodique().getAccordACCRE().intValue());
    }
    periodeActiviteNonSalarie.setDateValidationPANS(periodeActivite.getPANS().getPANSPeriodique().getDateAccordACCRE());
    
    AccesForfaitMensuellePansAgricole paramForfait = new AccesForfaitMensuellePansAgricole();
    Damj derniereDateForfaitActive = paramForfait.getDerniereDateActive();
    
    CritereStrategie critereStrategie = new CritereStrategie();
    critereStrategie.setDatePivot(periodeActiviteNonSalarie.getDateDebut());
    StrategieInstallationForfaitPANSSpec strategie = (StrategieInstallationForfaitPANSSpec)FabriqueStrategieInstallationForfaitPANS.getInstance().getStrategie(critereStrategie);
    if ((periodeActiviteNonSalarie.getDateDebut().estAvant(DATE_PIVOT_GENERATION_FORFAIT)) && ((periodeActiviteNonSalarie.getCollectionPeriodeAvecRevenu().isEmpty()) || (aucunRevenuAvantLaMep18SI1(periodeActiviteNonSalarie))))
    {
      PeriodeAvecRevenu periodeAvecRevenu = new PeriodeAvecRevenu(periodeActiviteNonSalarie.getDateDebut(), strategie.getDateFinGenerationForfaitPans(periodeActiviteNonSalarie.getDateDebut(), periodeActiviteNonSalarie.getDateFin(), derniereDateForfaitActive.veille()));
      
      periodeAvecRevenu.setTypeRevenu(1);
      ChronologiePeriodes chronoPeriodeRevenu = new ChronologiePeriodes();
      chronoPeriodeRevenu.ajouter(periodeAvecRevenu);
      periodeActiviteNonSalarie.getCollectionPeriodeAvecRevenu().addAll(chronoPeriodeRevenu.mapperVersCollection());
    }
    Chronologie chronoAnneeCivilSansRevenu = strategie.recupererPeriodesSansRevenu(periodeActivite, periodeActiviteNonSalarie, derniereDateForfaitActive);
    periodeActiviteNonSalarie.getCollectionPeriodeAvecRevenu().addAll(chronoAnneeCivilSansRevenu.mapperVersCollection());
    
    creerForfaitSurPeriodeRevenu(periodeActiviteNonSalarie);
    
    mapperPansSurNatureRemuneration(periodeActivite, periodeActiviteNonSalarie);
    
    return periodeActiviteNonSalarie;
  }
  
  private static boolean aucunRevenuAvantLaMep18SI1(PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalarie)
    throws CoucheLogiqueException
  {
    Collection<?> collectionRevenu = periodeActiviteNonSalarie.getCollectionPeriodeAvecRevenu();
    boolean aucunRevenu = true;
    Iterator<?> it = collectionRevenu.iterator();
    while ((it.hasNext()) && (aucunRevenu))
    {
      PeriodeAvecRevenu periodeAvecRevenu = (PeriodeAvecRevenu)it.next();
      if (periodeAvecRevenu.getDateDebut().estAvant(GestionnaireDateApplication.getInstance().recupererDateApplication("Prise en compte des ANS mensuel et supra M"))) {
        aucunRevenu = false;
      }
    }
    return aucunRevenu;
  }
  
  private static void mappingPND(PeriodeActivite periodeActivite, PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalarie)
  {
    if ((periodeActivite.getChampsPeriodeActivite() != null) && (periodeActivite.getChampsPeriodeActivite().getListePND() != null) && (periodeActivite.getChampsPeriodeActivite().getListePND().getNbListPND() != 0))
    {
      ListePND listePND = periodeActivite.getChampsPeriodeActivite().getListePND();
      if (listePND != null)
      {
        Collection<Periode> collectionPND = new ArrayList();
        for (int i = 0; i < listePND.getNbListPND(); i++)
        {
          PND pndCourante = listePND.getListePND(i);
          collectionPND.add(new Periode(pndCourante.getDateDebut(), pndCourante.getDateFin()));
        }
        periodeActiviteNonSalarie.setCollectionPND(collectionPND);
      }
    }
  }
  
  private static boolean mapperNouveauModele(PeriodeActivite periodeActivite, PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalariePeriodique)
    throws CoucheLogiqueException
  {
    periodeActiviteNonSalariePeriodique.setEstAtteste(true);
    
    ListePeriodeEmploiPANS listPeriodeEmploiPans = periodeActivite.getPANS().getPANSPeriodique().getListePeriodeEmploiPANS();
    
    boolean contientEtatPro = false;
    if (listPeriodeEmploiPans != null) {
      for (int i = 0; i < listPeriodeEmploiPans.getNbListPeriodeEmploiPANS(); i++)
      {
        Collection<PeriodeAvecRevenu> collectionPeriodeAvecRevenu = new ArrayList();
        PeriodeEmploiPANS periodeEmploiCourant = listPeriodeEmploiPans.getListePeriodeEmploiPANS(i);
        ListeRevenuPANSPeriodique listRevenuPansperiodique = periodeEmploiCourant.getListeRevenuPANSPeriodique();
        mappingRevenuPansPeriodique(periodeEmploiCourant, collectionPeriodeAvecRevenu, listRevenuPansperiodique);
        if (BooleanGa.valueOfEtatProfessionnel(periodeEmploiCourant.getEtatProfessionnel())) {
          if ((periodeActiviteNonSalariePeriodique.getCollectionPeriodeAvecRevenu() != null) && (periodeActiviteNonSalariePeriodique.getCollectionPeriodeAvecRevenu().isEmpty())) {
            periodeActiviteNonSalariePeriodique.setCollectionPeriodeAvecRevenu(collectionPeriodeAvecRevenu);
          } else {
            periodeActiviteNonSalariePeriodique.getCollectionPeriodeAvecRevenu().addAll(collectionPeriodeAvecRevenu);
          }
        }
        String etat = periodeEmploiCourant.getEtatProfessionnel();
        boolean etatProCaliGlobal = true;
        boolean etatProCali = BooleanGa.valueOfEtatProfessionnel(etat);
        if (etatProCali) {
          contientEtatPro = true;
        }
        PeriodeEtatNonProfessionnel periodeEtat = new PeriodeEtatNonProfessionnel(periodeEmploiCourant.getDateDebut(), periodeEmploiCourant.getDateFin());
        
        periodeEtat.setEtatProfessionnel(etatProCali);
        periodeActiviteNonSalariePeriodique.ajouterPeriodeEtatNonProfessionnel(periodeEtat);
        etatProCaliGlobal &= etatProCali;
        
        periodeActiviteNonSalariePeriodique.setEtatProfessionnelGlobalPourAppletLiq(etatProCaliGlobal);
      }
    }
    return contientEtatPro;
  }
  
  private static void mappingRevenuPansPeriodique(PeriodeEmploiPANS periodeEmploiCourant, Collection<PeriodeAvecRevenu> collectionPeriodeAvecRevenu, ListeRevenuPANSPeriodique listRevenuPansperiodique)
    throws CoucheLogiqueException
  {
    if (listRevenuPansperiodique != null)
    {
      for (int y = 0; y < listRevenuPansperiodique.getNbListRevenuPANSPeriodique(); y++)
      {
        RevenuPANSPeriodique revenuPansPeriodique = listRevenuPansperiodique.getListeRevenuPANSPeriodique(y);
        PeriodeAvecRevenu periodeAvecRevenu = new PeriodeAvecRevenu(revenuPansPeriodique.getDateDebut(), revenuPansPeriodique.getDateFin());
        
        periodeAvecRevenu.setNatureActivite(Integer.parseInt(periodeEmploiCourant.getEmploi()));
        if (revenuPansPeriodique.getMontantJustifie() != null)
        {
          periodeAvecRevenu.setMontant(revenuPansPeriodique.getMontantJustifie());
          periodeAvecRevenu.setTypeRevenu(0);
        }
        else if (revenuPansPeriodique.getMontantDeclare() != null)
        {
          periodeAvecRevenu.setMontant(revenuPansPeriodique.getMontantDeclare());
          periodeAvecRevenu.setTypeRevenu(2);
        }
        else
        {
          periodeAvecRevenu.setMontant(BigDecimal.ZERO);
          periodeAvecRevenu.setTypeRevenu(1);
        }
        collectionPeriodeAvecRevenu.add(periodeAvecRevenu);
      }
    }
    else if ((Integer.parseInt(periodeEmploiCourant.getNatureRemuneration()) == 8) || (Integer.parseInt(periodeEmploiCourant.getNatureRemuneration()) == 4))
    {
      AccesForfaitMensuellePansAgricole paramForfait = new AccesForfaitMensuellePansAgricole();
      Damj derniereDateForfaitActive = paramForfait.getDerniereDateActive();
      CritereStrategie critereStrategie = new CritereStrategie();
      critereStrategie.setDatePivot(periodeEmploiCourant.getDateDebut());
      StrategieInstallationForfaitPANSSpec strategie = (StrategieInstallationForfaitPANSSpec)FabriqueStrategieInstallationForfaitPANS.getInstance().getStrategie(critereStrategie);
      
      Damj dateFin = strategie.getDateFinGenerationForfaitPans(periodeEmploiCourant.getDateDebut(), periodeEmploiCourant.getDateFin(), derniereDateForfaitActive.veille());
      PeriodeAvecRevenu periodeAvecRevenu = new PeriodeAvecRevenu(periodeEmploiCourant.getDateDebut(), dateFin);
      if (periodeEmploiCourant.getEmploi() != null) {
        periodeAvecRevenu.setNatureActivite(Integer.parseInt(periodeEmploiCourant.getEmploi()));
      }
      periodeAvecRevenu.setMontant(BigDecimal.ZERO);
      periodeAvecRevenu.setTypeRevenu(0);
      collectionPeriodeAvecRevenu.add(periodeAvecRevenu);
    }
  }
  
  public static void creerForfaitSurPeriodeRevenu(PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalariePeriodique)
    throws CoucheLogiqueException
  {
    Collection<?> collectionPeriodeAvecRevenu = periodeActiviteNonSalariePeriodique.getCollectionPeriodeAvecRevenu();
    Iterator<?> ite = collectionPeriodeAvecRevenu.iterator();
    Collection<PeriodeAvecRevenu> periodesAvecRevenuMensuelDeLAnneeAAjouter = new ArrayList();
    while (ite.hasNext())
    {
      PeriodeAvecRevenu periodeAvecRevenu = (PeriodeAvecRevenu)ite.next();
      if (periodeAvecRevenu.getTypeRevenu() == 1)
      {
        Damj dateDebut = periodeAvecRevenu.getDateDebut();
        Damj dateFin = periodeAvecRevenu.getDateFin();
        Damj dateDebutPeriodeForfaitMensuel = dateDebut;
        Damj dateFinPeriodeForfaitMensuel = null;
        BigDecimal gain = null;
        while (dateDebutPeriodeForfaitMensuel.estAvantOuCoincideAvec(dateFin))
        {
          dateFinPeriodeForfaitMensuel = dateDebutPeriodeForfaitMensuel.getFinMois().estAvantOuCoincideAvec(dateFin) ? dateDebutPeriodeForfaitMensuel.getFinMois() : dateFin;
          
          PeriodeAvecRevenu periodeAvecRevenuMensuel = new PeriodeAvecRevenu(dateDebutPeriodeForfaitMensuel, dateFinPeriodeForfaitMensuel);
          periodeAvecRevenuMensuel.setNatureActivite(periodeAvecRevenu.getNatureActivite());
          if (estSurPeriodePro(periodeAvecRevenuMensuel, periodeActiviteNonSalariePeriodique))
          {
            periodeAvecRevenuMensuel.setTypeRevenu(1);
            
            BigDecimal forfait = calculerForfait(periodeAvecRevenuMensuel.getDateDebut(), periodeActiviteNonSalariePeriodique, periodeActiviteNonSalariePeriodique.getDateDebut(), periodeAvecRevenuMensuel, periodesAvecRevenuMensuelDeLAnneeAAjouter);
            if (periodeAvecRevenuMensuel.getPeriode().getDuree() < dateDebutPeriodeForfaitMensuel.getDebutMois().joursEntre(dateDebutPeriodeForfaitMensuel.getFinMois()) + 1) {
              gain = Mathematiques.proratiser(forfait, new BigDecimal(Integer.toString(periodeAvecRevenuMensuel.getPeriode().getDuree())), new BigDecimal(Integer.toString(dateDebut.getDebutMois().joursEntre(dateDebut.getFinMois()) + 1)));
            } else {
              gain = forfait;
            }
            periodeAvecRevenuMensuel.setMontant(gain);
            periodesAvecRevenuMensuelDeLAnneeAAjouter.add(periodeAvecRevenuMensuel);
          }
          if (!dateFinPeriodeForfaitMensuel.coincideAvec(periodeAvecRevenuMensuel.getDateFin())) {
            dateDebutPeriodeForfaitMensuel = periodeAvecRevenuMensuel.getDateFin().lendemain();
          } else {
            dateDebutPeriodeForfaitMensuel = dateDebutPeriodeForfaitMensuel.getDebutMoisSuivant();
          }
        }
        ite.remove();
      }
    }
    if (!periodesAvecRevenuMensuelDeLAnneeAAjouter.isEmpty()) {
      periodeActiviteNonSalariePeriodique.getCollectionPeriodeAvecRevenu().addAll(periodesAvecRevenuMensuelDeLAnneeAAjouter);
    }
  }
  
  public static PeriodeActiviteNonSalariePonctuelle mapperPansNonInstallee(PeriodeActivite periodeActivite)
  {
    PeriodeActiviteNonSalariePonctuelle periodeActiviteNonSalarie = new PeriodeActiviteNonSalariePonctuelle(periodeActivite.getChampsPeriodeActivite().getDateDebut(), periodeActivite.getChampsPeriodeActivite().getDateFin());
    
    periodeActiviteNonSalarie.setIdentifiant(periodeActivite.getChampsPeriodeActivite().getIdPeriodeActivite());
    
    boolean etatProfessionnel = BooleanGa.valueOfEtatProfessionnel(periodeActivite.getPANS().getPANSPonctuelle().getEtatProfessionnel());
    if (!etatProfessionnel) {
      return null;
    }
    periodeActiviteNonSalarie.setEtatProfessionnel(etatProfessionnel);
    
    periodeActiviteNonSalarie.setOrigineInfo(mapperOriginesInfo(periodeActivite.getChampsPeriodeActivite().getListeOrigineInformation()));
    if (periodeActiviteNonSalarie.getOrigineInfo() != null) {
      periodeActiviteNonSalarie.setEstAtteste(mapperEtatAttestePansPonctuelles(Integer.valueOf(periodeActiviteNonSalarie.getOrigineInfo()).intValue()));
    }
    RevenuPans revenuPans = new RevenuPans(periodeActivite.getPANS().getPANSPonctuelle().getRevenuPANS().getDatePaiement(), periodeActivite.getPANS().getPANSPonctuelle().getRevenuPANS().getDatePaiement(), periodeActivite.getPANS().getPANSPonctuelle().getRevenuPANS().getMontant());
    
    periodeActiviteNonSalarie.setRevenuPans(revenuPans);
    return periodeActiviteNonSalarie;
  }
  
  private static String mapperOriginesInfo(ListeOrigineInformation listeOrginesInfoGa)
  {
    String origineInformation = null;
    if (listeOrginesInfoGa != null)
    {
      BigDecimal origineInfo = listeOrginesInfoGa.getListeOrigineInformation(0).getCodeOrigineInformation();
      if (origineInfo != null) {
        origineInformation = origineInfo.toString();
      }
    }
    return origineInformation;
  }
  
  private static boolean mapperEtatAtteste(int origineInfo)
  {
    switch (origineInfo)
    {
    case 3: 
    case 75: 
    case 76: 
    case 77: 
    case 78: 
    case 79: 
      return true;
    }
    return false;
  }
  
  private static boolean mapperEtatAttestePansPonctuelles(int origineInfo)
  {
    switch (origineInfo)
    {
    case 76: 
    case 80: 
    case 81: 
    case 82: 
    case 83: 
      return true;
    }
    return false;
  }
  
  private static BigDecimal calculerForfait(Damj date, PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalariePeriodique, Damj dateDebutPans, PeriodeAvecRevenu periodeAvecRevenuMensuel, Collection<PeriodeAvecRevenu> periodesAvecRevenuMensuelDeLAnneeAAjouter)
  {
    BigDecimal forfait = null;
    
    PeriodeAvecRevenu periodeAvecRevenuPrecedent = new PeriodeAvecRevenu(determinerPeriodeAnneeCivilePrecedantDate(periodeActiviteNonSalariePeriodique, date));
    periodeAvecRevenuPrecedent.setMontant(recupererMontantTotal(periodesAvecRevenuMensuelDeLAnneeAAjouter, periodeActiviteNonSalariePeriodique, periodeAvecRevenuPrecedent.getPeriode()));
    if ((periodeAvecRevenuMensuel.getNatureActivite() == 13) || (periodeAvecRevenuMensuel.getNatureActivite() == 21) || (periodeAvecRevenuMensuel.getNatureActivite() == 23))
    {
      forfait = ParametresIndemnisation.getParametresIndemnisation().getElementActif(date).getForfaitMensuellePansAgricole();
      if ((date.estApresOuCoincideAvec(dateDebutPans.getDateAnniversaire(new DureeCalendaire(1, 0, 0)))) && (periodeAvecRevenuPrecedent != null) && (periodeAvecRevenuPrecedent.getMontant() != null) && (periodeAvecRevenuPrecedent.getMontant().compareTo(BigDecimal.ZERO) != 0))
      {
        BigDecimal revenuPrecedentAuMois = periodeAvecRevenuPrecedent.getMontant().divide(periodeAvecRevenuPrecedent.getNbMois(), 4);
        forfait = forfait.divide(new BigDecimal("2"), 4).add(revenuPrecedentAuMois.divide(new BigDecimal("2"), 4));
      }
    }
    else if ((periodeAvecRevenuPrecedent == null) || (date.estAvant(dateDebutPans.getDateAnniversaire(new DureeCalendaire(1, 0, 0)))))
    {
      forfait = ParametresIndemnisation.getParametresIndemnisation().getElementActif(date).getForfaitMensuellePansNonAgricolePremiereAnnee();
    }
    else
    {
      forfait = ParametresIndemnisation.getParametresIndemnisation().getElementActif(date).getForfaitMensuellePansNonAgricoleDeuxiemeAnnee();
    }
    return forfait;
  }
  
  private static BigDecimal recupererMontantTotal(Collection<PeriodeAvecRevenu> periodesAvecRevenuMensuelDeLAnneeAAjouter, PeriodeActiviteNonSalariePeriodique pans, Periode periodeReference)
  {
    BigDecimal cumulRemuneration = BigDecimal.ZERO;
    Collection<?> collectionRevenuAnnualise = pans.getCollectionPeriodeAvecRevenu();
    Iterator<?> it = collectionRevenuAnnualise.iterator();
    while (it.hasNext())
    {
      PeriodeAvecRevenu periodeAvecRevenu = (PeriodeAvecRevenu)it.next();
      if ((periodeAvecRevenu.getDateDebut().getAnnee() == periodeReference.getDebut().getAnnee()) && (periodeAvecRevenu.getMontant() != null)) {
        cumulRemuneration = cumulRemuneration.add(periodeAvecRevenu.getMontant());
      }
    }
    if (cumulRemuneration.compareTo(BigDecimal.ZERO) == 0)
    {
      it = periodesAvecRevenuMensuelDeLAnneeAAjouter.iterator();
      while (it.hasNext())
      {
        PeriodeAvecRevenu periodeAvecRevenu = (PeriodeAvecRevenu)it.next();
        if ((periodeAvecRevenu.getDateDebut().getAnnee() == periodeReference.getDebut().getAnnee()) && (periodeAvecRevenu.getMontant() != null)) {
          cumulRemuneration = cumulRemuneration.add(periodeAvecRevenu.getMontant());
        }
      }
    }
    return cumulRemuneration;
  }
  
  private static Periode determinerPeriodeAnneeCivilePrecedantDate(PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalariePeriodique, Damj date)
  {
    int anneeCivile = date.getAnnee() - 1;
    Damj dateDeDebut = periodeActiviteNonSalariePeriodique.getDateDebut();
    if (dateDeDebut.getAnnee() != anneeCivile) {
      dateDeDebut = new Damj(anneeCivile, 1, 1);
    }
    return new Periode(dateDeDebut, new Damj(anneeCivile, 12, 31));
  }
  
  private static boolean estSurPeriodePro(PeriodeAvecRevenu periodeAvecRevenu, PeriodeActiviteNonSalariePeriodique periodeActivite)
  {
    PeriodeEtatNonProfessionnel periodeEtatNonProfessionnel = null;
    Iterator itePeriodeEtat = periodeActivite.getCollectionPeriodeEtatNonProfessionnel().iterator();
    while (itePeriodeEtat.hasNext())
    {
      periodeEtatNonProfessionnel = (PeriodeEtatNonProfessionnel)itePeriodeEtat.next();
      if ((periodeAvecRevenu.getDateDebut().estContenueDans(new Periode(periodeEtatNonProfessionnel.getDateDebut(), periodeEtatNonProfessionnel.getDateFin()))) && (periodeAvecRevenu.getDateFin().estContenueDans(new Periode(periodeEtatNonProfessionnel.getDateDebut(), periodeEtatNonProfessionnel.getDateFin())))) {
        return periodeEtatNonProfessionnel.isEtatProfessionnel();
      }
      if ((periodeAvecRevenu.getDateDebut().estContenueDans(new Periode(periodeEtatNonProfessionnel.getDateDebut(), periodeEtatNonProfessionnel.getDateFin()))) && (periodeEtatNonProfessionnel.isEtatProfessionnel()))
      {
        periodeAvecRevenu.setDateFin(periodeEtatNonProfessionnel.getDateFin());
        return true;
      }
      if ((periodeAvecRevenu.getDateFin().estContenueDans(new Periode(periodeEtatNonProfessionnel.getDateDebut(), periodeEtatNonProfessionnel.getDateFin()))) && (periodeEtatNonProfessionnel.isEtatProfessionnel()))
      {
        periodeAvecRevenu.setDateDebut(periodeEtatNonProfessionnel.getDateDebut());
        return true;
      }
    }
    return false;
  }
  
  public static void mapperPansSurNatureRemuneration(PeriodeActivite periodeActivite, PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalariePeriodique)
    throws CoucheLogiqueException
  {
    ListePeriodeEmploiPANS listPeriodeEmploiPans = periodeActivite.getPANS().getPANSPeriodique().getListePeriodeEmploiPANS();
    if (listPeriodeEmploiPans != null) {
      for (int i = 0; i < listPeriodeEmploiPans.getNbListPeriodeEmploiPANS(); i++)
      {
        PeriodeEmploiPANS periodeEmploiCourant = listPeriodeEmploiPans.getListePeriodeEmploiPANS(i);
        if ((BooleanGa.valueOfEtatProfessionnel(periodeEmploiCourant.getEtatProfessionnel())) && (periodeEmploiCourant.getNatureRemuneration() != null)) {
          if (contientUneNatureRemunerationAPrendreEnCompte(Integer.parseInt(periodeEmploiCourant.getNatureRemuneration())))
          {
            ListeRevenuPANSPeriodique listRevenuPeriodeEmploi = periodeEmploiCourant.getListeRevenuPANSPeriodique();
            mappingPans(periodeActiviteNonSalariePeriodique, listRevenuPeriodeEmploi, periodeEmploiCourant);
          }
          else if ((Integer.parseInt(periodeEmploiCourant.getNatureRemuneration()) == 4) && (periodeEmploiCourant.getDateFin() != null) && (periodeEmploiCourant.getDateFin().estApres(GestionnaireDateApplication.getInstance().recupererDateApplication("Prise en compte des ANS mensuel et supra M"))))
          {
            Damj dateDebutPeriodePans = null;
            dateDebutPeriodePans = Damj.max(periodeEmploiCourant.getDateDebut(), GestionnaireDateApplication.getInstance().recupererDateApplication("Prise en compte des ANS mensuel et supra M"));
            
            PeriodePansSansRevenu periodePansSansRevenu = new PeriodePansSansRevenu(dateDebutPeriodePans, periodeEmploiCourant.getDateFin());
            periodeActiviteNonSalariePeriodique.getCollectionPeriodePansSansRevenu().add(periodePansSansRevenu);
          }
        }
      }
    }
  }
  
  private static boolean contientUneNatureRemunerationAPrendreEnCompte(int natureRemuneration)
  {
    return (natureRemuneration != 8) && (natureRemuneration != 4);
  }
  
  private static void mappingPans(PeriodeActiviteNonSalariePeriodique periodeActiviteNonSalariePeriodique, ListeRevenuPANSPeriodique listeRevenuPeriodeEmploi, PeriodeEmploiPANS periodeEmploiCourant)
    throws CoucheLogiqueException
  {
    if (listeRevenuPeriodeEmploi != null) {
      for (int y = 0; y < listeRevenuPeriodeEmploi.getNbListRevenuPANSPeriodique(); y++)
      {
        RevenuPANSPeriodique revenuPansPeriodique = listeRevenuPeriodeEmploi.getListeRevenuPANSPeriodique(y);
        if (revenuPansPeriodique.getDateDebut().estApresOuCoincideAvec(GestionnaireDateApplication.getInstance().recupererDateApplication("Prise en compte des ANS mensuel et supra M")))
        {
          PeriodePansAvecRevenu periodePansAvecRevenu = new PeriodePansAvecRevenu(revenuPansPeriodique.getDateDebut(), revenuPansPeriodique.getDateFin());
          if (revenuPansPeriodique.getMontantJustifie() != null) {
            periodePansAvecRevenu.setMontant(revenuPansPeriodique.getMontantJustifie());
          }
          periodePansAvecRevenu.setDateEcheance(revenuPansPeriodique.getEcheance());
          if (revenuPansPeriodique.getPeriodicite() != null) {
            periodePansAvecRevenu.setPeriodicite(revenuPansPeriodique.getPeriodicite().intValue());
          }
          if (periodeEmploiCourant.getNatureRemuneration() != null) {
            periodePansAvecRevenu.setNatureRemuneration(Integer.parseInt(periodeEmploiCourant.getNatureRemuneration()));
          }
          periodeActiviteNonSalariePeriodique.getCollectionPeriodePansAvecRevenu().add(periodePansAvecRevenu);
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     MapperPans
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
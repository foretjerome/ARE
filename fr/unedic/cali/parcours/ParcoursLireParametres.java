package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.parametres.AccesForfaitMensuellePansAgricole;
import fr.unedic.cali.calcul.parametres.AccesForfaitMensuellePansNonAgricoleDeuxiemeAnnee;
import fr.unedic.cali.calcul.parametres.AccesForfaitMensuellePansNonAgricolePremiereAnnee;
import fr.unedic.cali.calcul.parametres.AccesSmicHoraire;
import fr.unedic.cali.calcul.parametres.AccesSmicHoraireMayotte;
import fr.unedic.cali.calcul.parametres.AccesTauxCotisationAccidentTravail;
import fr.unedic.cali.calcul.parametres.AccesTauxCotisationSocialeObligatoireSurSalaire;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DomLireParametres;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.cali.dom.affectation.GammePrr;
import fr.unedic.cali.dom.affectation.ProduitAsuFds12P02;
import fr.unedic.cali.dom.affectation.ProduitAsuSpe02P03;
import fr.unedic.cali.dom.affectation.ProduitForAff03P03;
import fr.unedic.cali.dom.affectation.ProduitForRfp04P01;
import fr.unedic.cali.dom.affectation.ProduitForRps02P01;
import fr.unedic.cali.dom.affectation.ProduitInrPfm01P01;
import fr.unedic.cali.dom.affectation.ProduitRbfHbt01P01;
import fr.unedic.cali.dom.affectation.ProduitRbfHbt01P02;
import fr.unedic.cali.dom.affectation.ProduitRbfRtn03P02;
import fr.unedic.cali.dom.affectation.ProduitRbfTpt02P02;
import fr.unedic.cali.dom.affectation.ProduitSolAer05P01;
import fr.unedic.cali.dom.affectation.ProduitSolAta06P01;
import fr.unedic.cali.dom.affectation.ProduitSolCge01P01;
import fr.unedic.cali.dom.affectation.ProduitSolSub09P01;
import fr.unedic.cali.parametres.ParametresIndemnisation;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieStandard;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;

public class ParcoursLireParametres
  extends ParcoursServiceAbstrait
{
  private static final String DATE = "Date";
  private static final String FORF_MENSU_PANS_AGRI = "forfMensuPansAgri";
  private static final String FORF_PANS_NON_AGRI_DEUX = "forfaitPansNonAgriDeux";
  private static final String FORF_PANS_NON_AGRI_PREM = "forfaitMensuPansNonAgriPrem";
  private static final String TX_COTIS_ACC_TRAVAIL = "txCotisAccTravail";
  private static final String SMIC_HORAIRE = "smicHoraire";
  private static final String PLAFOND_JOURNALIER_SECURITE_SOCIALE = "plafondJournalierSecuriteSociale";
  private static final String TX_COTIS_SOCIALE_SALAIRE = "txCotisSocialeSalaire";
  private static final String SMIC_HORAIRE_MAYOTTE = "smicHoraireMayotte";
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    ResultatLireParametres resultat = new ResultatLireParametres();
    resultat.setEtat(1);
    
    DomLireParametres domLireParametres = (DomLireParametres)p_contexte.getDonnees();
    
    GammeAsu gammeAsu = GammeAsu.getInstance();
    ArrayList listeGroupe1 = gammeAsu.getParametres();
    domLireParametres.setListeGroupe1(listeGroupe1);
    domLireParametres.setListeParametresAREMayotte(listeGroupe1);
    
    ArrayList listeGroupe2 = getParametres();
    domLireParametres.setListeGroupe2(listeGroupe2);
    
    ArrayList listeGroupe3 = gammeAsu.getCatA2BParam();
    domLireParametres.setListeGroupe3(listeGroupe3);
    
    ProduitSolAer05P01 produitAer05 = ProduitSolAer05P01.getInstance();
    ArrayList listeGroupe4 = produitAer05.getParametres();
    domLireParametres.setListeGroupe4(listeGroupe4);
    
    ProduitSolCge01P01 produitCge01P01 = ProduitSolCge01P01.getInstance();
    ArrayList listeGroupe5 = produitCge01P01.getParametres();
    domLireParametres.setListeGroupe5(listeGroupe5);
    domLireParametres.setListeParametresASSMayotte(listeGroupe5);
    
    ProduitAsuSpe02P03 produitAsuSpe02P03 = ProduitAsuSpe02P03.getInstance();
    ArrayList listeGroupe6 = produitAsuSpe02P03.getParametres();
    domLireParametres.setListeGroupe6(listeGroupe6);
    
    ProduitAsuFds12P02 produitAsuFds12P02 = ProduitAsuFds12P02.getInstance();
    ArrayList listeParamAFD = produitAsuFds12P02.getParametres();
    domLireParametres.setListeGroupe7(listeParamAFD);
    
    ProduitSolAta06P01 produitSolAta06P01 = ProduitSolAta06P01.getInstance();
    ArrayList listeGroupe8 = produitSolAta06P01.getParametres();
    domLireParametres.setListeGroupe8(listeGroupe8);
    
    ProduitRbfHbt01P01 produitRbfHbt01P01 = ProduitRbfHbt01P01.getInstance();
    ArrayList listeGroupe9 = produitRbfHbt01P01.getParametres();
    domLireParametres.setListeGroupe9(listeGroupe9);
    
    ProduitForRfp04P01 produitForRFP04P01 = ProduitForRfp04P01.getInstance();
    ArrayList listeGroupe101112 = produitForRFP04P01.getParametres();
    domLireParametres.setListeGroupe101112(listeGroupe101112);
    
    ProduitRbfHbt01P02 produitRbfHbt01P02 = ProduitRbfHbt01P02.getInstance();
    ArrayList listeGroupe13 = produitRbfHbt01P02.getParametres();
    domLireParametres.setListeGroupe13(listeGroupe13);
    
    ProduitSolSub09P01 produitSub09P01 = ProduitSolSub09P01.getInstance();
    ArrayList listeGroupe15 = produitSub09P01.getParametres();
    domLireParametres.setListeGroupe15(listeGroupe15);
    
    ProduitForRps02P01 produitForRps02p02 = ProduitForRps02P01.getInstance();
    ArrayList listeGroupeMontantITIH = produitForRps02p02.getParametres();
    domLireParametres.setListeGroupeMontantITIH(listeGroupeMontantITIH);
    
    GammePrr gammePrr = GammePrr.getInstance();
    ArrayList listeGroupeGammePreretraite = gammePrr.getParametres();
    domLireParametres.setListeGroupeGammePreretraite(listeGroupeGammePreretraite);
    
    ProduitForAff03P03 produitForAff03P03 = ProduitForAff03P03.getInstance();
    ArrayList listeParametresRFF = produitForAff03P03.getParametres();
    domLireParametres.setListeParametresRFF(listeParametresRFF);
    
    ProduitRbfHbt01P02 produitRbfHbt01P02May = ProduitRbfHbt01P02.getInstance();
    ArrayList listeRbfHbt01P02May = produitRbfHbt01P02May.getParametres();
    ProduitRbfTpt02P02 produitRbfTpt02P02May = ProduitRbfTpt02P02.getInstance();
    ArrayList listeRbfTpt02P02May = produitRbfTpt02P02May.getParametres();
    listeRbfHbt01P02May.addAll(listeRbfTpt02P02May);
    ProduitRbfRtn03P02 produitRbfRtn03P02May = ProduitRbfRtn03P02.getInstance();
    ArrayList listeRbfRtn03P02May = produitRbfRtn03P02May.getParametres();
    listeRbfHbt01P02May.addAll(listeRbfRtn03P02May);
    domLireParametres.setListeParametresAFAFMayotte(listeRbfHbt01P02May);
    
    ProduitInrPfm01P01 produitInrPfm01P01 = ProduitInrPfm01P01.getInstance();
    ArrayList listePfm = produitInrPfm01P01.getParametres();
    domLireParametres.setListeParametresPfm(listePfm);
    
    resultat.setDomLireParametres(domLireParametres);
    return resultat;
  }
  
  private void ajouterChrono(ChronologieStandard p_horsGammeC, ChronologieStandard p_chrono)
  {
    p_chrono.iterer();
    while (p_chrono.encoreSuivant())
    {
      fr.unedic.cali.calcul.dom.EvenementParametre evtPf = (fr.unedic.cali.calcul.dom.EvenementParametre)p_chrono.elementSuivant();
      ajouterEvenement(p_horsGammeC, evtPf);
    }
  }
  
  private void ajouterEvenement(ChronologieStandard p_horsGammeC, fr.unedic.cali.calcul.dom.EvenementParametre p_evtParam)
  {
    Damj damjParam = p_evtParam.getDateEffet();
    boolean trouve = false;
    p_horsGammeC.iterer();
    while ((p_horsGammeC.encoreSuivant()) && (trouve != true))
    {
      fr.unedic.cali.calcul.dom.EvenementParametre evtAsu = (fr.unedic.cali.calcul.dom.EvenementParametre)p_horsGammeC.elementSuivant();
      Damj damjAsu = evtAsu.getDateEffet();
      if (damjParam.equals(damjAsu))
      {
        evtAsu.repercuter(p_evtParam);
        trouve = true;
      }
    }
    if (!trouve) {
      p_horsGammeC.ajouter(p_evtParam);
    }
  }
  
  private ArrayList retourneArrayList(ChronologieStandard p_horsGammeC)
  {
    ArrayList resultat = new ArrayList();
    
    p_horsGammeC.iterer();
    while (p_horsGammeC.encoreSuivant())
    {
      fr.unedic.cali.calcul.dom.EvenementParametre evtHorsGamme = (fr.unedic.cali.calcul.dom.EvenementParametre)p_horsGammeC.elementSuivant();
      Damj damjHorsGamme = evtHorsGamme.getDateEffet();
      Hashtable params = new Hashtable();
      
      params.put("Date", damjHorsGamme);
      BigDecimal pansAgri = evtHorsGamme.getForfaitMensuellePansAgricole();
      BigDecimal pansNonAgriDeux = evtHorsGamme.getForfaitMensuellePansNonAgricoleDeuxiemeAnnee();
      BigDecimal pansNonAgriPrem = evtHorsGamme.getForfaitMensuellePansNonAgricolePremiereAnnee();
      BigDecimal txCotisAccTravail = evtHorsGamme.getTauxAccidentTravail();
      BigDecimal smicHoraire = evtHorsGamme.getSmicHoraire();
      BigDecimal txCotisAccSalaire = evtHorsGamme.getTauxCotisationSocialeSalaire();
      BigDecimal smicHoraireMayotte = evtHorsGamme.getSmicHoraireMayotte();
      if (pansAgri != null) {
        params.put("forfMensuPansAgri", pansAgri);
      }
      if (pansNonAgriDeux != null) {
        params.put("forfaitPansNonAgriDeux", pansNonAgriDeux);
      }
      if (pansNonAgriPrem != null) {
        params.put("forfaitMensuPansNonAgriPrem", pansNonAgriPrem);
      }
      if (txCotisAccTravail != null) {
        params.put("txCotisAccTravail", txCotisAccTravail);
      }
      if (smicHoraire != null) {
        params.put("smicHoraire", smicHoraire);
      }
      if (txCotisAccSalaire != null) {
        params.put("txCotisSocialeSalaire", txCotisAccSalaire);
      }
      if (smicHoraireMayotte != null) {
        params.put("smicHoraireMayotte", smicHoraireMayotte);
      }
      resultat.add(params);
    }
    return resultat;
  }
  
  public ArrayList getParametres()
  {
    AccesForfaitMensuellePansAgricole forfMensuPansAgriP = new AccesForfaitMensuellePansAgricole();
    AccesForfaitMensuellePansNonAgricoleDeuxiemeAnnee forfaitPansNonAgriDeuxP = new AccesForfaitMensuellePansNonAgricoleDeuxiemeAnnee();
    AccesForfaitMensuellePansNonAgricolePremiereAnnee forfaitMensuPansNonAgriPremP = new AccesForfaitMensuellePansNonAgricolePremiereAnnee();
    AccesTauxCotisationAccidentTravail accTravail = new AccesTauxCotisationAccidentTravail();
    AccesSmicHoraire smic = new AccesSmicHoraire();
    AccesTauxCotisationSocialeObligatoireSurSalaire accSalaire = new AccesTauxCotisationSocialeObligatoireSurSalaire();
    AccesSmicHoraireMayotte smicMayotte = new AccesSmicHoraireMayotte();
    
    ChronologieStandard forfMensuPansAgriC = forfMensuPansAgriP.getChronoValeursParametre();
    ChronologieStandard forfaitPansNonAgriDeuxC = forfaitPansNonAgriDeuxP.getChronoValeursParametre();
    ChronologieStandard forfaitMensuPansNonAgriPremC = forfaitMensuPansNonAgriPremP.getChronoValeursParametre();
    ChronologieStandard accTravailC = accTravail.getChronoValeursParametre();
    ChronologieStandard smicC = smic.getChronoValeursParametre();
    ChronologieStandard accSalaireC = accSalaire.getChronoValeursParametre();
    ChronologieStandard smicMayotteC = smicMayotte.getChronoValeursParametre();
    
    ChronologieStandard horsGammeC = (ChronologieStandard)forfMensuPansAgriC.copier();
    
    ajouterChrono(horsGammeC, forfaitPansNonAgriDeuxC);
    ajouterChrono(horsGammeC, forfaitMensuPansNonAgriPremC);
    ajouterChrono(horsGammeC, accTravailC);
    ajouterChrono(horsGammeC, smicC);
    ajouterChrono(horsGammeC, accSalaireC);
    ajouterChrono(horsGammeC, smicMayotteC);
    
    ArrayList listeParam = retourneArrayList(horsGammeC);
    
    Chronologie chronoPlafond = ParametresIndemnisation.getParametresIndemnisation().getChronoEvenementsParametre();
    chronoPlafond.iterer();
    while (chronoPlafond.encoreSuivant())
    {
      fr.unedic.cali.parametres.EvenementParametre evenementParametre = (fr.unedic.cali.parametres.EvenementParametre)chronoPlafond.elementSuivant();
      int i = 0;
      boolean bTrouve = false;
      while ((i < listeParam.size()) && (!bTrouve))
      {
        Hashtable params = (Hashtable)listeParam.get(i);
        Damj dateParam = (Damj)params.get("Date");
        if (dateParam.coincideAvec(evenementParametre.getDateDebut()))
        {
          bTrouve = true;
          params.put("plafondJournalierSecuriteSociale", evenementParametre.getPlafondJournalierSecuriteSociale());
        }
        i++;
      }
      if (!bTrouve)
      {
        Hashtable paramAAjouter = new Hashtable();
        paramAAjouter.put("Date", evenementParametre.getDateDebut());
        paramAAjouter.put("plafondJournalierSecuriteSociale", evenementParametre.getPlafondJournalierSecuriteSociale());
        listeParam.add(paramAAjouter);
      }
    }
    return listeParam;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursLireParametres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
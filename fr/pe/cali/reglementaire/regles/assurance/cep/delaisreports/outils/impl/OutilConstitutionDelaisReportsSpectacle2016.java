package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.DetailJoursTravaillesJustificationFranchiseCP;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.DonneesEntreesDelaisReportsSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.EtatDifferePrecedent;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.JustificationFranchiseCP;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.MoisCivilJustificationFranchiseCP;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.ResultatDelaisReportsSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.spec.IOutilConstitutionDelaisReportsSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.spec.IOutilFonctionnelRechercheDiffere;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.Entreprise;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeMesureActivite;
import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalarie;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalarieAutreQueFormationCifCdd;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreNegation;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreOu;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeActiviteSalarieeE301;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeActiviteSalarieeHorsChamp;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeActiviteSalarieeMemeReglement;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodesAttestees;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodesSurFiltresExclusifs;
import fr.unedic.cali.utilitaire.filtres.objetChronoPeriode.FiltreObjetChronoPeriodeFinApresDate;
import fr.unedic.cali.utilitaire.filtres.objetChronoPeriode.FiltreObjetChronoPeriodeFinAvantDate;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.CalculDelais;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class OutilConstitutionDelaisReportsSpectacle2016
  implements IOutilConstitutionDelaisReportsSpectacle
{
  private static final int FEVRIER = 2;
  private static final int VINGT_NEUF = 29;
  private static final String NOM_OUTIL = "Franchise CP Spectacle 2016";
  private static final int SEUIL_FORFAIT_FRANCHISE_MENSUELLE = 24;
  private static final int FORFAIT_FRANCHISE_MENSUELLE_2_JOURS = 2;
  private static final int FORFAIT_FRANCHISE_MENSUELLE_3_JOURS = 3;
  private static final int MOIS_MAX_FRANCHISE_SALAIRE = 8;
  private static final int JOURS_MAX_FRANCHISE_SALAIRE = 31;
  private static final String FORMULE = "Min [(Nb j travaillés retenus PRA x 2,5 /24) ; 30]";
  private static final BigDecimal FORMULE_TAUX = BigDecimal.valueOf(2.5D);
  private static final BigDecimal FORMULE_DIVISEUR = BigDecimal.valueOf(24L);
  private static final int FORMULE_MAX = 30;
  private static final int DUREE_DELAI_ATTENTE = 7;
  private static final int DOUZE_MOIS = 12;
  private static final BigDecimal HEURES_PAR_JOUR_A8 = BigDecimal.valueOf(8L);
  private static final BigDecimal HEURES_PAR_JOUR_A10 = BigDecimal.valueOf(10L);
  private static final BigDecimal HEURES_PAR_CACHET = BigDecimal.valueOf(12L);
  
  public static OutilConstitutionDelaisReportsSpectacle2016 getInstance()
  {
    return new OutilConstitutionDelaisReportsSpectacle2016();
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    boolean estApplicable = true;
    if ((criteres != null) && (criteres.getListeContextesReglementaires() != null) && (criteres.getListeContextesReglementaires().contains("DateLimiteContexteEntreeClauseRattrapage"))) {
      estApplicable = false;
    }
    return estApplicable;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConstitutionDelaisReportsSpectacle2016();
  }
  
  public String getNomOutil()
  {
    return "Franchise CP Spectacle 2016";
  }
  
  public int calculerMensualisationFranchiseCP(int nombreJoursFranchiseCP)
  {
    int forfait = 2;
    if (nombreJoursFranchiseCP > 24) {
      forfait = 3;
    }
    return forfait;
  }
  
  public int calculerMensualisationFranchiseSalaire(int nombreJoursFranchiseSalaire, Damj dateAttribution, Damj dateLimiteIndemnisation)
  {
    int nombreMoisCivil = calculerMoisCivilsEntre(dateAttribution, dateLimiteIndemnisation);
    
    nombreMoisCivil = Math.min(nombreMoisCivil, 8);
    
    BigDecimal franchiseSalaireBD = BigDecimal.valueOf(nombreJoursFranchiseSalaire);
    BigDecimal moisCivilsBD = BigDecimal.valueOf(nombreMoisCivil);
    
    BigDecimal franchiseSalaireMensuelleBD = franchiseSalaireBD.divide(moisCivilsBD, 0);
    
    return Math.min(31, franchiseSalaireMensuelleBD.intValue());
  }
  
  public ResultatDelaisReportsSpectacle calculerFranchiseCP(DonneesEntreesDelaisReportsSpectacle donneesEntrees)
  {
    ResultatDelaisReportsSpectacle resultat = new ResultatDelaisReportsSpectacle();
    JustificationFranchiseCP justif = new JustificationFranchiseCP();
    resultat.setJustification(justif);
    Periode periodeCalculFranchiseCp = determinerPeriodeCalculFranchiseCp(donneesEntrees.getPra(), donneesEntrees.getDateDernierFgd());
    justif.setPeriodeCalculFranchiseCp(periodeCalculFranchiseCp);
    if (donneesEntrees.getNombreJoursTravaillesForces() != null)
    {
      int joursForces = donneesEntrees.getNombreJoursTravaillesForces().intValue();
      resultat.setNombreJoursFranchiseCP(calculerFranchiseCP(joursForces));
      justif.setNombreJoursTravaillesRetenusDansPra(joursForces);
    }
    else if ((periodeCalculFranchiseCp != null) && (donneesEntrees.getPasseProfessionnel() != null))
    {
      ArrayList<Periode> listeMoisCivils = periodeCalculFranchiseCp.decouperEnMoisCivils();
      Chronologie periodesParticipantes = recupererChronoPeriodesParticipantes(donneesEntrees.getPasseProfessionnel(), periodeCalculFranchiseCp);
      
      int franchiseCP = calculerFranchiseCP(listeMoisCivils, periodesParticipantes, justif);
      
      resultat.setNombreJoursFranchiseCP(franchiseCP);
    }
    return resultat;
  }
  
  protected int calculerMoisCivilsEntre(Damj debut, Damj fin)
  {
    int nombreMois = 0;
    if ((debut != null) && (fin != null) && (debut.estAvantOuCoincideAvec(fin)))
    {
      Periode periode = new Periode(debut, fin);
      nombreMois = periode.decouperEnMoisCivils().size();
    }
    return nombreMois;
  }
  
  protected Chronologie recupererChronoPeriodesParticipantes(Chronologie passeProfessionnel, Periode pra)
  {
    FiltrePeriodesSurFiltresExclusifs filtreOU = new FiltrePeriodesSurFiltresExclusifs();
    filtreOU.ajouterFiltre(new FiltreActiviteSalarie());
    filtreOU.ajouterFiltre(new FiltrePeriodesAttestees());
    filtreOU.ajouterFiltre(new FiltreNegation(new FiltreActiviteSalarieAutreQueFormationCifCdd()));
    filtreOU.ajouterFiltre(new FiltrePeriodeActiviteSalarieeE301());
    
    FiltresTemporel filtreET = new FiltresTemporel();
    filtreET.ajouterFiltre(new FiltreObjetChronoPeriodeFinApresDate(pra.getDebut().veille(), "MVS"));
    
    filtreET.ajouterFiltre(new FiltreObjetChronoPeriodeFinAvantDate(pra.getFin().lendemain(), "MVS"));
    
    FiltreOu filtreReglements = new FiltreOu();
    filtreReglements.ajouterFiltre(new FiltrePeriodeActiviteSalarieeMemeReglement("A10"));
    filtreReglements.ajouterFiltre(new FiltrePeriodeActiviteSalarieeMemeReglement("A8"));
    filtreET.ajouterFiltre(filtreReglements);
    filtreET.ajouterFiltre(new FiltreNegation(new FiltrePeriodeActiviteSalarieeHorsChamp()));
    
    FiltresTemporel filtrePourCalculAffiliationBase = new FiltresTemporel();
    filtrePourCalculAffiliationBase.ajouterFiltre(filtreOU);
    filtrePourCalculAffiliationBase.ajouterFiltre(filtreET);
    
    return passeProfessionnel.copier(filtrePourCalculAffiliationBase);
  }
  
  protected int calculerFranchiseCP(List<Periode> listeMoisCivils, Chronologie periodesParticipantes, JustificationFranchiseCP justif)
  {
    int joursTravailles = 0;
    
    justif.setListeMoisCivils(new ArrayList());
    
    initialiserQuantiteJoursSurSalaires(periodesParticipantes);
    for (Periode moisCivil : listeMoisCivils) {
      joursTravailles += calculerJoursTravailles(moisCivil, periodesParticipantes, justif);
    }
    justif.setNombreJoursTravaillesRetenusDansPra(joursTravailles);
    
    int franchiseCP = calculerFranchiseCP(joursTravailles);
    
    return franchiseCP;
  }
  
  private void initialiserQuantiteJoursSurSalaires(Chronologie periodesParticipantes)
  {
    ListIterator<ActiviteSalarie> it = periodesParticipantes.iterer();
    while (it.hasNext())
    {
      ActiviteSalarie activite = (ActiviteSalarie)it.next();
      Reglement reglement = activite.getReglement();
      Chronologie chronoPma = activite.getListePeriodesMesureActivite();
      
      ListIterator<Salaire> it2 = activite.getListeSalaires().iterer();
      while (it2.hasNext())
      {
        Salaire salaire = (Salaire)it2.next();
        initialiserQuantiteJoursSurSalaire(salaire, reglement, chronoPma);
      }
    }
  }
  
  private void initialiserQuantiteJoursSurSalaire(Salaire salaire, Reglement reglement, Chronologie chronoPma)
  {
    int joursTotalSalaire;
    int joursTotalSalaire;
    if (salaire.getNombreJoursTravailles() != null) {
      joursTotalSalaire = salaire.getNombreJoursTravailles().intValue();
    } else {
      joursTotalSalaire = convertirAffiliation(salaire, reglement, chronoPma);
    }
    int joursTotalRestant = joursTotalSalaire;
    
    ArrayList<Periode> liste = salaire.decouperEnMoisCivils();
    for (Periode periode : liste)
    {
      Damj debutMois = periode.getDebut().getDebutMois();
      BigDecimal travailSurMoisCivil;
      BigDecimal travailSurMoisCivil;
      if (salaire.getDateFin().estContenueDans(periode))
      {
        travailSurMoisCivil = BigDecimal.valueOf(joursTotalRestant);
      }
      else
      {
        BigDecimal joursTravaillesTotal = BigDecimal.valueOf(joursTotalSalaire);
        BigDecimal joursSurMoisCivil = BigDecimal.valueOf(salaire.getPeriode().inter(periode));
        BigDecimal joursPeriode = BigDecimal.valueOf(salaire.getDuree());
        
        travailSurMoisCivil = joursTravaillesTotal.multiply(joursSurMoisCivil).divide(joursPeriode, 4);
        joursTotalRestant -= travailSurMoisCivil.intValue();
      }
      salaire.getRepartitionJoursSurMoisCivils().put(debutMois, travailSurMoisCivil);
    }
  }
  
  private int convertirAffiliation(Salaire salaire, Reglement reglement, Chronologie chronoPma)
  {
    int retour = 0;
    
    PeriodeMesureActivite pma = getPMA(salaire, chronoPma);
    if (pma != null)
    {
      int nombreJourConverti = 0;
      
      Iterator<Quantite> it = pma.getListeQuantitesAffiliation().values().iterator();
      while (it.hasNext()) {
        nombreJourConverti += convertirAffiliation((Quantite)it.next(), reglement);
      }
      retour = nombreJourConverti;
    }
    return retour;
  }
  
  private int convertirAffiliation(Quantite quantite, Reglement reglement)
  {
    int retour = 0;
    if ((quantite != null) && (BigDecimal.ZERO.compareTo(quantite.getValeur()) != 0)) {
      if (quantite.getUnite().equals(Unite.get("heure de travail")))
      {
        if ("A8".equals(reglement.getNomReglement())) {
          retour = quantite.getValeur().divide(HEURES_PAR_JOUR_A8, 0).intValue();
        } else if ("A10".equals(reglement.getNomReglement())) {
          retour = quantite.getValeur().divide(HEURES_PAR_JOUR_A10, 0).intValue();
        }
      }
      else if (quantite.getUnite().equals(Unite.get("jour d'affiliation"))) {
        retour = quantite.getValeurEntiere();
      } else if ((quantite.getUnite().equals(Unite.get("cachet isole"))) || (quantite.getUnite().equals(Unite.get("cachet groupe")))) {
        if ("A8".equals(reglement.getNomReglement())) {
          retour = quantite.getValeur().multiply(HEURES_PAR_CACHET).divide(HEURES_PAR_JOUR_A8, 0).intValue();
        } else if ("A10".equals(reglement.getNomReglement())) {
          retour = quantite.getValeur().multiply(HEURES_PAR_CACHET).divide(HEURES_PAR_JOUR_A10, 0).intValue();
        }
      }
    }
    return retour;
  }
  
  private PeriodeMesureActivite getPMA(Salaire salaire, Chronologie chronoPma)
  {
    PeriodeMesureActivite pma = null;
    if (chronoPma != null)
    {
      ListIterator<PeriodeMesureActivite> it = chronoPma.iterer();
      while ((it.hasNext()) && (pma == null))
      {
        PeriodeMesureActivite pmaCourante = (PeriodeMesureActivite)it.next();
        if (pmaCourante.getPeriode().coincideAvec(salaire.getPeriode())) {
          pma = pmaCourante;
        }
      }
    }
    return pma;
  }
  
  protected int calculerFranchiseCP(int joursTravailles)
  {
    int franchiseCP = BigDecimal.valueOf(joursTravailles).multiply(FORMULE_TAUX).divide(FORMULE_DIVISEUR, 1).intValue();
    
    franchiseCP = Math.min(franchiseCP, 30);
    return franchiseCP;
  }
  
  private int calculerJoursTravailles(Periode moisCivil, Chronologie periodesParticipantes, JustificationFranchiseCP justif)
  {
    MoisCivilJustificationFranchiseCP justifMoisCivil = new MoisCivilJustificationFranchiseCP();
    justifMoisCivil.setMoisCivil(moisCivil);
    justifMoisCivil.setDetails(new ArrayList());
    justif.getListeMoisCivils().add(justifMoisCivil);
    justif.setFormuleUtilisee("Min [(Nb j travaillés retenus PRA x 2,5 /24) ; 30]");
    
    int nombreJoursMoisCivil = moisCivil.getDuree();
    int nombreJoursTravailles = 0;
    
    ListIterator<ActiviteSalarie> it = periodesParticipantes.iterer();
    while (it.hasNext())
    {
      ActiviteSalarie activite = (ActiviteSalarie)it.next();
      if (activite.chevauche(moisCivil)) {
        nombreJoursTravailles += calculerJoursTravailles(activite, justifMoisCivil);
      }
    }
    int nombreJoursTravaillesRetenus = Math.min(nombreJoursTravailles, nombreJoursMoisCivil);
    justifMoisCivil.setNombreJoursTravailles(nombreJoursTravailles);
    justifMoisCivil.setNombreJoursTravaillesRetenus(nombreJoursTravaillesRetenus);
    
    return nombreJoursTravaillesRetenus;
  }
  
  private int calculerJoursTravailles(ActiviteSalarie activite, MoisCivilJustificationFranchiseCP justifMoisCivil)
  {
    Chronologie listeSalaire = activite.getListeSalaires();
    int nombreJoursTravailles = 0;
    DetailJoursTravaillesJustificationFranchiseCP detail = null;
    Periode moisCivil = justifMoisCivil.getMoisCivil();
    
    ListIterator<Salaire> it = listeSalaire.iterer();
    while (it.hasNext())
    {
      Salaire salaire = (Salaire)it.next();
      if (salaire.chevauche(moisCivil))
      {
        if (detail == null)
        {
          detail = initialiserDetail(activite);
          justifMoisCivil.getDetails().add(detail);
        }
        nombreJoursTravailles += calculerJoursTravailles(salaire, moisCivil);
      }
    }
    if (detail != null) {
      detail.setNombresJoursTravaillesAttestes(nombreJoursTravailles);
    }
    return nombreJoursTravailles;
  }
  
  private DetailJoursTravaillesJustificationFranchiseCP initialiserDetail(ActiviteSalarie activite)
  {
    DetailJoursTravaillesJustificationFranchiseCP detail = new DetailJoursTravaillesJustificationFranchiseCP();
    detail.setRaisonSociale(activite.getEntreprise().getLibelleEntreprise());
    detail.setPeriodeContrat(activite.getPeriode());
    return detail;
  }
  
  private int calculerJoursTravailles(Salaire salaire, Periode moisCivil)
  {
    int joursSalaire = 0;
    
    Periode moisCivilTotal = new Periode();
    moisCivilTotal.setDebut(moisCivil.getDebut().getDebutMois());
    moisCivilTotal.setFin(moisCivil.getFin().getFinMois());
    
    BigDecimal joursReparti = (BigDecimal)salaire.getRepartitionJoursSurMoisCivils().get(moisCivilTotal.getDebut());
    if (joursReparti != null) {
      joursSalaire = ((BigDecimal)salaire.getRepartitionJoursSurMoisCivils().get(moisCivilTotal.getDebut())).intValue();
    }
    int joursTravailles = joursSalaire;
    
    Periode salaireSurMois = salaire.periodeIntersection(moisCivilTotal);
    if (!salaireSurMois.estContenueDans(moisCivil))
    {
      BigDecimal nbJPraMoisCivil = BigDecimal.valueOf(moisCivil.getDuree());
      BigDecimal nbMoisCivil = BigDecimal.valueOf(moisCivilTotal.getDuree());
      joursTravailles = BigDecimal.valueOf(joursSalaire).multiply(nbJPraMoisCivil).divide(nbMoisCivil, 1).intValue();
    }
    return joursTravailles;
  }
  
  public int calculerReliquatCarenceDiffere7Jours(int reliquatDiffere, Periode periodeApplication, Damj dateAttribution)
  {
    int reliquatARetourner = 0;
    switch (reliquatDiffere)
    {
    case 0: 
    case 7: 
      reliquatARetourner = reliquatDiffere;
      break;
    default: 
      int reliquat = reliquatDiffere - dateAttribution.veille().joursEntre(periodeApplication.getFin());
      if (reliquat > 0) {
        reliquatARetourner = reliquat;
      }
      break;
    }
    return reliquatARetourner;
  }
  
  public ResultatDelaisReportsSpectacle estDiffereApplicable(DonneesEntreesDelaisReportsSpectacle donneesEntree)
  {
    ResultatDelaisReportsSpectacle retour = new ResultatDelaisReportsSpectacle();
    boolean creerDiffere = true;
    
    IOutilFonctionnelRechercheDiffere outilFonctionnel = donneesEntree.getOutilRechercheDiffere();
    
    EtatDifferePrecedent etatDifferePrecedent = outilFonctionnel.rechercherEtatDifferePrecedent();
    if (etatDifferePrecedent.isDifferePrecedentEntame())
    {
      Damj dateDebutDifferePrecedent = etatDifferePrecedent.getPeriodeApplicationDiffere().getDebut();
      
      Damj termePeriode = donneesEntree.getDebutTheoriqueDelaiAttente();
      if ((termePeriode.getJour() == 29) && (termePeriode.getMois() == 2)) {
        termePeriode = termePeriode.veille();
      }
      DureeCalendaire duree12Mois = new DureeCalendaire(0, 12, 0);
      Periode periode12MoisSurOdCourante = CalculDelais.determinerDelai(termePeriode, duree12Mois);
      if (dateDebutDifferePrecedent.estApres(periode12MoisSurOdCourante.getDebut())) {
        creerDiffere = false;
      }
    }
    retour.setAppliquerDiffere(creerDiffere);
    retour.setDelaiAttentePrecedent(etatDifferePrecedent.getPeriodeApplicationDiffere());
    
    return retour;
  }
  
  protected Periode determinerPeriodeCalculFranchiseCp(Periode pra, Damj dateDernierFgd)
  {
    return pra;
  }
  
  public int calculerReliquatFranchise(int reliquatDiffere, Periode periodeApplication, Damj dateAttribution)
  {
    throw new UnsupportedOperationException("Cette méthode ne doit pas être appelée.");
  }
}

/* Location:
 * Qualified Name:     OutilConstitutionDelaisReportsSpectacle2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
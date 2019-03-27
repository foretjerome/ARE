package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.affectation.parametres.CriteresQualification;
import fr.unedic.cali.autresdoms.ga.dom.gen.ActiviteSalarieGen;
import fr.unedic.cali.autresdoms.ga.dom.spec.AppartenanceSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.RemunerationSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.SalarieSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.PeriodeActiviteSalarieCali;
import fr.unedic.cali.dom.PeriodeActiviteSalarieCaliSpec;
import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.cali.dom.affectation.QualificationPeriodeActiviteSalarie;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.cali.outilsfonctionnels.DeterminationRemuneration;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.QuantiteJourSpec;
import fr.unedic.util.Unite;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.NonConformiteException;
import fr.unedic.util.temps.ObjetChronoEvenementDebut;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ActiviteSalarie
  extends ActiviteSalarieGen
  implements PeriodeGaecSpec, TravailSpec, SalarieSpec, AppartenanceSpec, PeriodeActiviteSalarieCaliSpec
{
  private static final long serialVersionUID = -519819914056746552L;
  public static final int QUALIFIABILITE_INDETERMINEE = 0;
  public static final int QUALIFIABILITE_AUTOMATIQUE = 1;
  public static final int QUALIFIABILITE_AUCUNE = 3;
  private transient PeriodeActiviteSalarie periodeActiviteSalarieGaec;
  private transient Chronologie listePeriodesMesureActiviteQualifiee = new ChronologiePeriodes();
  private transient boolean presencePNDSDetectee;
  private transient boolean estUneFct = false;
  private transient List listePeriodeElementaire;
  private transient List listePeriodeAffiliationSupplementaire;
  private transient boolean estUneFctConcomittante = false;
  private transient InformationPeriodeGlobale informationPeriodeGlobale = new InformationPeriodeGlobale();
  private transient Reglement reglementForce = null;
  private Chronologie listePeriodesMesureActiviteForcee = null;
  private String incoherence = "";
  private boolean presenceMontantICCP = false;
  private boolean montantIccpProratise = false;
  
  public ActiviteSalarie()
  {
    super.setPeriodeActiviteSalarieCali(new PeriodeActiviteSalarieCali());
    
    super.getPeriodeActiviteSalarieCali().setPeriodeActiviteSalarie(this);
    
    periodeActiviteSalarieGaec = new PeriodeActiviteSalarie();
  }
  
  public ActiviteSalarie(DomPCSpec pc)
  {
    super(pc);
    
    super.getPeriodeActiviteSalarieCali().setPeriodeActiviteSalarie(this);
    periodeActiviteSalarieGaec = new PeriodeActiviteSalarie();
  }
  
  public ActiviteSalarie(PeriodeActiviteSalarie periodeGaecToAgregate)
  {
    periodeActiviteSalarieGaec = periodeGaecToAgregate;
    setIdentifiant(periodeActiviteSalarieGaec.getIdentifiant());
    for (Iterator<?> iterPMA = periodeGaecToAgregate.getListePeriodesMesureActivite().iterer(); iterPMA.hasNext();)
    {
      PeriodeMesureActivite pma = (PeriodeMesureActivite)iterPMA.next();
      ajouterPeriodeMesureActivite(pma);
    }
    super.setPeriodeActiviteSalarieCali(new PeriodeActiviteSalarieCali());
    
    super.getPeriodeActiviteSalarieCali().setPeriodeActiviteSalarie(this);
  }
  
  public ActiviteSalarie(Periode periode)
  {
    super(periode);
    super.setPeriodeActiviteSalarieCali(new PeriodeActiviteSalarieCali());
    
    super.getPeriodeActiviteSalarieCali().setPeriodeActiviteSalarie(this);
    periodeActiviteSalarieGaec = new PeriodeActiviteSalarie(periode);
  }
  
  public ActiviteSalarie(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    super.setPeriodeActiviteSalarieCali(new PeriodeActiviteSalarieCali());
    
    super.getPeriodeActiviteSalarieCali().setPeriodeActiviteSalarie(this);
    periodeActiviteSalarieGaec = new PeriodeActiviteSalarie(dateDebut, dateFin);
  }
  
  public void ajouterSalaire(RemunerationSpec salaire)
  {
    periodeActiviteSalarieGaec.ajouterSalaire(salaire);
  }
  
  public boolean estAtteste()
  {
    return periodeActiviteSalarieGaec.estAtteste();
  }
  
  public void setEstAtteste(boolean estAtteste)
  {
    periodeActiviteSalarieGaec.setEstAtteste(estAtteste);
  }
  
  public Periode getPeriode()
  {
    return periodeActiviteSalarieGaec.getPeriode();
  }
  
  public void ajouterIncident(IncidentSpec incident)
  {
    periodeActiviteSalarieGaec.ajouterIncident(incident);
  }
  
  public Chronologie getListePeriodesIncident()
  {
    return periodeActiviteSalarieGaec.getListePeriodesIncident();
  }
  
  public void setListePeriodesIncident(Chronologie listePeriodesIncident)
  {
    periodeActiviteSalarieGaec.setListePeriodesIncident(listePeriodesIncident);
  }
  
  public IndividuIdSpec getIdentifiantIndividu()
  {
    return periodeActiviteSalarieGaec.getIdentifiantIndividu();
  }
  
  public Collection<Indemnite> getListeIndemnites()
  {
    return periodeActiviteSalarieGaec.getListeIndemnites();
  }
  
  public void setIdentifiantIndividu(IndividuIdSpec idIndividu)
  {
    periodeActiviteSalarieGaec.setIdentifiantIndividu(idIndividu);
  }
  
  public int getDuree()
  {
    return periodeActiviteSalarieGaec.getDuree();
  }
  
  public boolean estSanctionne()
  {
    return periodeActiviteSalarieGaec.estSanctionne();
  }
  
  public boolean isDerogationPlafondMensuel()
  {
    return periodeActiviteSalarieGaec.isDerogationPlafondMensuel();
  }
  
  public void setDateDebut(Damj dateDebut)
  {
    periodeActiviteSalarieGaec.setDateDebut(dateDebut);
  }
  
  public void setDateFin(Damj dateFin)
  {
    periodeActiviteSalarieGaec.setDateFin(dateFin);
  }
  
  public Damj getDateDebut()
  {
    return periodeActiviteSalarieGaec.getDateDebut();
  }
  
  public Damj getDateEffet()
  {
    return periodeActiviteSalarieGaec.getDateEffet();
  }
  
  public Damj getDateFin()
  {
    return periodeActiviteSalarieGaec.getDateFin();
  }
  
  public ObjetChronoEvenementDebut getEvenementDebut()
  {
    return periodeActiviteSalarieGaec.getEvenementDebut();
  }
  
  public ContratTravail getContrat()
  {
    return periodeActiviteSalarieGaec.getContratTravail();
  }
  
  public Entreprise getEntreprise()
  {
    return periodeActiviteSalarieGaec.getEntreprise();
  }
  
  public int getCodeMotifFin()
  {
    if (getContrat() != null) {
      return getContrat().getCodeMotifFin();
    }
    return 50;
  }
  
  public void setCodeMotifFin(int codeMotifFin)
  {
    if (getContrat() != null) {
      getContrat().setCodeMotifFin(codeMotifFin);
    }
  }
  
  public String getMotifFin()
  {
    NumberFormat nf = NumberFormat.getNumberInstance();
    nf.setMinimumIntegerDigits(2);
    int codeMotifFin = getCodeMotifFin();
    return nf.format(codeMotifFin);
  }
  
  public boolean isRegimeAlsaceMoselle()
  {
    if ((getMetier() == null) || (getMetier().getListeRegimeRetraite() == null)) {
      return false;
    }
    List<?> listeRegimeRegimeRetraite = getMetier().getListeRegimeRetraite();
    for (Iterator<?> iter = listeRegimeRegimeRetraite.iterator(); iter.hasNext();)
    {
      RegimeRetraite regimeRetraite = (RegimeRetraite)iter.next();
      if (regimeRetraite.estAlsaceMoselle()) {
        return true;
      }
    }
    return false;
  }
  
  public void setListePeriodesMesureActivite(Chronologie listePeriodesMesureActivite)
  {
    listePeriodesMesureActiviteQualifiee = listePeriodesMesureActivite;
  }
  
  public Chronologie getListePeriodesMesureActivite()
  {
    if (listePeriodesMesureActiviteForcee != null) {
      return listePeriodesMesureActiviteForcee;
    }
    return listePeriodesMesureActiviteQualifiee;
  }
  
  public void ajouterPeriodeMesureActivite(PeriodeMesureActivite periodeMesureActivite)
  {
    if (periodeMesureActivite == null) {
      throw new IllegalArgumentException("L'argument PeriodeMesureActivite à ajouter est null.");
    }
    try
    {
      listePeriodesMesureActiviteQualifiee.ajouter(periodeMesureActivite);
      periodeMesureActivite.setPeriodeActiviteSalarie(this);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(PeriodeActiviteSalarie.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, PeriodeActiviteSalarie.class, "ajouterPeriodeMesureActivite", e);
      }
    }
  }
  
  public Chronologie getListePrimesNormales()
  {
    return periodeActiviteSalarieGaec.getListePrimesNormales();
  }
  
  public Chronologie getListePrimesNormalesExclues()
  {
    return periodeActiviteSalarieGaec.getListePrimesNormalesExclues();
  }
  
  public void ajouterSalaire(Salaire periodeSalaire)
  {
    periodeSalaire.setPeriodeActiviteSalarieGaec(periodeActiviteSalarieGaec);
    periodeActiviteSalarieGaec.ajouterSalaire(periodeSalaire);
  }
  
  public Chronologie getListeSalaires()
  {
    return periodeActiviteSalarieGaec.getListeSalaires();
  }
  
  public void setListeSalaires(Chronologie listeSalaires)
  {
    periodeActiviteSalarieGaec.setListeSalaires(listeSalaires);
  }
  
  public Chronologie getListePrimesExceptionnelles()
  {
    return periodeActiviteSalarieGaec.getListePrimesExceptionnelles();
  }
  
  public Chronologie getListePrimesExceptionnellesExclues()
  {
    return periodeActiviteSalarieGaec.getListePrimesExceptionnellesExclues();
  }
  
  public Chronologie getListePrimesICRS()
  {
    return periodeActiviteSalarieGaec.getListePrimesICRS();
  }
  
  public Chronologie getListePrimesICRSExclues()
  {
    return periodeActiviteSalarieGaec.getListePrimesICRSExclues();
  }
  
  public void ajouterPeriodeIntensite(PeriodeIntensite periodeIntensite)
  {
    periodeActiviteSalarieGaec.ajouterIntensite(periodeIntensite);
  }
  
  public Chronologie getListePeriodeIntensite()
  {
    return periodeActiviteSalarieGaec.getListePeriodeIntensite();
  }
  
  public void ajouterSalaireMensuelBase(SalaireMensuelBase salaireMensuelBase)
  {
    periodeActiviteSalarieGaec.ajouterSalaireMensuelBase(salaireMensuelBase);
  }
  
  public Chronologie getListeSalairesMensuelsBase()
  {
    return periodeActiviteSalarieGaec.getListeSalairesMensuelsBase();
  }
  
  public void setListePeriodeIntensite(Chronologie listePeriodeIntensite)
  {
    periodeActiviteSalarieGaec.setListePeriodeIntensite(listePeriodeIntensite);
  }
  
  public QuantiteEuro getQuantiteEuroIndemniteTransactionnelle()
  {
    return periodeActiviteSalarieGaec.getQuantiteEuroIndemniteTransactionnelle();
  }
  
  public void setQuantiteEuroIndemniteTransactionnelle(QuantiteEuro val)
  {
    periodeActiviteSalarieGaec.setQuantiteEuroIndemniteTransactionnelle(val);
  }
  
  public BigDecimal determinerNombreJoursAbsence(Periode periodeReference)
  {
    BigDecimal cumulNombreJoursAbsence = BigDecimal.ZERO;
    if (getListeSalaires() != null)
    {
      getListeSalaires().iterer();
      while (getListeSalaires().encoreSuivant())
      {
        Salaire periodeSalaireCourante = (Salaire)getListeSalaires().elementSuivant();
        
        cumulNombreJoursAbsence = cumulNombreJoursAbsence.add(periodeSalaireCourante.determinerNombreJoursAbsence(periodeReference));
      }
    }
    return cumulNombreJoursAbsence;
  }
  
  public Map<Unite, Quantite> determinerQuantitesAffiliation(Periode periodeReference)
  {
    BigDecimal cumulAffiliationJours = BigDecimal.ZERO;
    BigDecimal cumulAffiliationHeures = BigDecimal.ZERO;
    Unite uniteJour = Unite.get("jour d'affiliation");
    Unite uniteHeure = Unite.get("heure de travail");
    
    boolean proratiserSurPeriodeReference = false;
    
    BigDecimal nominateur1 = BigDecimal.ZERO;
    
    BigDecimal denominateur = BigDecimal.ZERO;
    if (periodeReference != null) {
      proratiserSurPeriodeReference = true;
    }
    if (getListePeriodesMesureActivite() != null)
    {
      getListePeriodesMesureActivite().iterer();
      while (getListePeriodesMesureActivite().encoreSuivant())
      {
        PeriodeMesureActivite periodeMesureActiviteCourante = (PeriodeMesureActivite)getListePeriodesMesureActivite().elementSuivant();
        if (proratiserSurPeriodeReference)
        {
          nominateur1 = new BigDecimal(String.valueOf(periodeMesureActiviteCourante.inter(periodeReference)));
          denominateur = new BigDecimal(String.valueOf(periodeMesureActiviteCourante.getDuree()));
        }
        if (periodeMesureActiviteCourante.getQuantiteAffiliation(uniteJour) != null)
        {
          BigDecimal affiliationJoursCourante = periodeMesureActiviteCourante.getQuantiteAffiliation(uniteJour).getValeur();
          if (proratiserSurPeriodeReference)
          {
            BigDecimal nominateur2 = affiliationJoursCourante;
            affiliationJoursCourante = Mathematiques.proratiser(nominateur1, nominateur2, denominateur);
          }
          cumulAffiliationJours = cumulAffiliationJours.add(affiliationJoursCourante);
        }
        if (periodeMesureActiviteCourante.getQuantiteAffiliation(uniteHeure) != null)
        {
          BigDecimal affiliationHeuresCourante = periodeMesureActiviteCourante.getQuantiteAffiliation(uniteHeure).getValeur();
          if (proratiserSurPeriodeReference)
          {
            BigDecimal nominateur2 = affiliationHeuresCourante;
            affiliationHeuresCourante = Mathematiques.proratiser(nominateur1, nominateur2, denominateur);
          }
          cumulAffiliationHeures = cumulAffiliationHeures.add(affiliationHeuresCourante);
        }
      }
    }
    Map<Unite, Quantite> tableQuantitesRetournee = new HashMap();
    tableQuantitesRetournee.put(uniteJour, new Quantite(cumulAffiliationJours, uniteJour));
    tableQuantitesRetournee.put(uniteHeure, new Quantite(cumulAffiliationHeures, uniteHeure));
    
    return tableQuantitesRetournee;
  }
  
  public Map<Unite, Quantite> determinerQuantitesAffiliationArrondie(Periode periodeReference)
  {
    Map<Unite, Quantite> tableQuantitesRetournee = new HashMap();
    Unite uniteJour = Unite.get("jour d'affiliation");
    Unite uniteHeure = Unite.get("heure de travail");
    
    Map<Unite, Quantite> tableQuantitesProratisees = determinerQuantitesAffiliation(periodeReference);
    BigDecimal cumulAffiliationJours = ((Quantite)tableQuantitesProratisees.get(uniteJour)).getValeur();
    BigDecimal cumulAffiliationHeures = ((Quantite)tableQuantitesProratisees.get(uniteHeure)).getValeur();
    
    cumulAffiliationJours = Mathematiques.arrondiASup(cumulAffiliationJours, 2);
    cumulAffiliationHeures = Mathematiques.arrondiASup(cumulAffiliationHeures, 2);
    tableQuantitesRetournee.put(uniteJour, new Quantite(cumulAffiliationJours, uniteJour));
    tableQuantitesRetournee.put(uniteHeure, new Quantite(cumulAffiliationHeures, uniteHeure));
    
    return tableQuantitesRetournee;
  }
  
  public Damj getDernierJourTravaillePaye()
  {
    if (getContrat() == null) {
      return null;
    }
    return getContrat().getDernierJourTravaillePaye();
  }
  
  public boolean isEngagementProcedureStrictementAvant(Damj date)
  {
    return periodeActiviteSalarieGaec.estEngagementProcedureStrictementAvant(date);
  }
  
  public void setDernierJourTravaillePaye(Damj dernierJourTravaillePaye)
  {
    if (getContrat() != null) {
      getContrat().setDernierJourTravaillePaye(dernierJourTravaillePaye);
    }
  }
  
  public void setDateEngagementProcedureLicenciement(Damj date)
  {
    periodeActiviteSalarieGaec.setDateEngagementProcedureLicenciement(date);
  }
  
  public Damj getDateEngagementProcedureLicenciement()
  {
    return periodeActiviteSalarieGaec.getDateEngagementProcedureLicenciement();
  }
  
  public Damj getDateRuptureContratTravail()
  {
    return periodeActiviteSalarieGaec.getDateRuptureContratTravail();
  }
  
  public String toString()
  {
    StringBuilder chaineRetour = new StringBuilder();
    chaineRetour.append(super.toString());
    chaineRetour.append("\n");
    chaineRetour.append("regimeAlsaceMoselle: " + isRegimeAlsaceMoselle() + "\n");
    chaineRetour.append("Date Engagement procédure: " + getDateEngagementProcedureLicenciement() + "\n");
    chaineRetour.append("motif fin: " + getMotifFin() + "\n");
    chaineRetour.append("dernier jour travaillé et payé: " + getDernierJourTravaillePaye() + "\n");
    chaineRetour.append("Détermination du nbre de jours d'absence --> " + determinerNombreJoursAbsence(null) + "\n");
    chaineRetour.append("Détermination de la rémunération (salaires et primes)--> ");
    BigDecimal remunerationActivite = DeterminationRemuneration.determinerRemunerationActiviteSalarie(this, null);
    chaineRetour.append(remunerationActivite);
    chaineRetour.append("\n");
    
    return chaineRetour.toString();
  }
  
  public void setContrat(ContratTravail contratTravail)
  {
    periodeActiviteSalarieGaec.setContratTravail(contratTravail);
  }
  
  public boolean isLicenciementEconomique()
  {
    if (getContrat() != null) {
      return getContrat().isLicenciementEconomique();
    }
    return false;
  }
  
  public QuantiteJourSpec getQuantiteJourIccp()
  {
    return periodeActiviteSalarieGaec.getQuantiteJourIccp();
  }
  
  public QuantiteEuro getQuantiteEuroIccp()
  {
    return periodeActiviteSalarieGaec.getQuantiteEuroIccp();
  }
  
  public QuantiteEuro getQuantiteEuroIslr()
  {
    return periodeActiviteSalarieGaec.getQuantiteEuroIslr();
  }
  
  public void setQuantiteJourIccp(QuantiteJourSpec quantiteJourIccp)
  {
    periodeActiviteSalarieGaec.setQuantiteJourIccp(quantiteJourIccp);
  }
  
  public void setQuantiteEuroIccp(QuantiteEuro quantiteEuroIccp)
  {
    periodeActiviteSalarieGaec.setQuantiteEuroIccp(quantiteEuroIccp);
  }
  
  public void setQuantiteEuroIslr(QuantiteEuro quantiteEuroIslr)
  {
    periodeActiviteSalarieGaec.setQuantiteEuroIslr(quantiteEuroIslr);
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getPeriodeActiviteSalarieCali());
  }
  
  public void setPeriodeActiviteSalarieCali(PeriodeActiviteSalarieCali periodeQualifiee)
  {
    DomManager.supprimer(super.getPeriodeActiviteSalarieCali(), periodeQualifiee);
    super.setPeriodeActiviteSalarieCali(periodeQualifiee);
    super.getPeriodeActiviteSalarieCali().setPeriodeActiviteSalarie(this);
  }
  
  public Reglement getReglement()
  {
    if (reglementForce != null) {
      return reglementForce;
    }
    return super.getPeriodeActiviteSalarieCali().getReglement();
  }
  
  public void ajouterQualification(QualificationPeriodeActiviteSalarie qualification)
  {
    super.getPeriodeActiviteSalarieCali().ajouterQualification(qualification);
  }
  
  public QualificationPeriodeActiviteSalarie getQualification(CriteresQualification criteresQualification)
  {
    return super.getPeriodeActiviteSalarieCali().getQualification(criteresQualification);
  }
  
  public void ajouterOrigineInformationPAS(int constante, int priorite)
  {
    getPeriodeActiviteSalarieGaec().ajouterOrigineInformationPAS(constante, priorite);
  }
  
  public int getOrigineInformation()
  {
    return periodeActiviteSalarieGaec.getOrigineInformation();
  }
  
  public Metier getMetier()
  {
    return periodeActiviteSalarieGaec.getMetier();
  }
  
  public void setMetier(Metier metier)
  {
    periodeActiviteSalarieGaec.setMetier(metier);
  }
  
  public int getCategorieEmploiParticulier()
  {
    return periodeActiviteSalarieGaec.getCategorieEmploiParticulier();
  }
  
  public int getContratTypeParticulier()
  {
    return periodeActiviteSalarieGaec.getContratTypeParticulier();
  }
  
  public int getChampApplication()
  {
    return periodeActiviteSalarieGaec.getChampApplication();
  }
  
  public int getChampApplicationRenseigne()
  {
    return periodeActiviteSalarieGaec.getChampApplicationRenseigne();
  }
  
  public void setListeIndemnites(Collection<Indemnite> collection)
  {
    periodeActiviteSalarieGaec.setListeIndemnites(collection);
  }
  
  protected void setPeriodeActiviteSalarieGaec(PeriodeActiviteSalarie pasGaec)
  {
    periodeActiviteSalarieGaec = pasGaec;
  }
  
  public PeriodeActiviteSalarie getPeriodeActiviteSalarieGaec()
  {
    return periodeActiviteSalarieGaec;
  }
  
  public boolean estTypePeriodeGaec(Class type)
  {
    return periodeActiviteSalarieGaec.estType(type);
  }
  
  public boolean estOrigineAeOuEquivalent()
  {
    Collection<Integer> origines = getCollectionOrigineInformationPAS();
    if (origines.contains(Integer.valueOf(1))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(71))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(4))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(5))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(10))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(74))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(9))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(6))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(33))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(34))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(56))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(39))) {
      return true;
    }
    if (origines.contains(Integer.valueOf(2))) {
      return true;
    }
    return false;
  }
  
  public boolean estFctPrincipale()
  {
    return super.getPeriodeActiviteSalarieCali().estFctPrincipale();
  }
  
  public boolean estLiquidable()
  {
    return super.getPeriodeActiviteSalarieCali().estLiquidable();
  }
  
  public void setEstFctPrincipale(boolean bool)
  {
    super.getPeriodeActiviteSalarieCali().setEstFctPrincipale(bool);
  }
  
  public void setEstLiquidable(boolean bool)
  {
    super.getPeriodeActiviteSalarieCali().setEstLiquidable(bool);
  }
  
  public void ajouterIndemnite(Indemnite indemnite)
  {
    periodeActiviteSalarieGaec.ajouterIndemnite(indemnite);
  }
  
  public DecorReglementaire getDecorCourant()
  {
    CriteresQualification criteresQualification = super.getPeriodeActiviteSalarieCali().getCriteresQualification();
    
    return criteresQualification != null ? criteresQualification.getDecor() : null;
  }
  
  public void setDecorCourant(DecorReglementaire decorCourant)
  {
    super.getPeriodeActiviteSalarieCali().getCriteresQualification().setDecor(decorCourant);
  }
  
  public CriteresQualification getCriteresQualification()
  {
    return super.getPeriodeActiviteSalarieCali().getCriteresQualification();
  }
  
  public void setCriteresQualification(CriteresQualification criteresQualification)
  {
    super.getPeriodeActiviteSalarieCali().setCriteresQualification(criteresQualification);
  }
  
  public boolean estQualifiable()
  {
    return super.getPeriodeActiviteSalarieCali().estQualifiable();
  }
  
  public boolean estEnConflit()
  {
    return periodeActiviteSalarieGaec.estEnConflit();
  }
  
  public void setEnConflit(boolean conflit)
  {
    periodeActiviteSalarieGaec.setEnConflit(conflit);
  }
  
  public ObjetMetierSpec copie()
  {
    ActiviteSalarie copie = new ActiviteSalarie();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec copieSpec)
  {
    ActiviteSalarie copie = (ActiviteSalarie)copieSpec;
    
    copie.setIdentifiant(getIdentifiant());
    copie.setPeriodeActiviteSalarieCali((PeriodeActiviteSalarieCali)getPeriodeActiviteSalarieCali().copie());
    copie.setPeriodeActiviteSalarieGaec(getPeriodeActiviteSalarieGaec());
    copie.setListePeriodesMesureActivite(getListePeriodesMesureActivite());
    copie.setEstUneFctConcomittante(estUneFctConcomittante());
    copie.setIncoherencePeriode(getIncoherencePeriode());
  }
  
  public boolean estLaMeme(ActiviteSalarie periode)
  {
    return getIdentifiant().equals(periode.getIdentifiant());
  }
  
  public Collection<Integer> getCollectionOrigineInformationPAS()
  {
    return periodeActiviteSalarieGaec.getCollectionOrigineInformationPAS();
  }
  
  public Map<Integer, Collection<Integer>> getCollectionOrigineInformationPASAvecPriorite()
  {
    return periodeActiviteSalarieGaec.getCollectionOrigineInformationPASAvecPriorite();
  }
  
  public int getCodeEmploiTenu()
  {
    return periodeActiviteSalarieGaec.getMetier().getCodeEmploi();
  }
  
  public String getSiren()
  {
    return periodeActiviteSalarieGaec.getEntreprise().getSiren();
  }
  
  public void setSiren(String siren)
  {
    periodeActiviteSalarieGaec.setSiren(siren);
  }
  
  public String getNumeroConventionGestion()
  {
    return periodeActiviteSalarieGaec.getNumeroConventionGestion();
  }
  
  public void setNumeroConventionGestion(String numeroConventionGestion)
  {
    periodeActiviteSalarieGaec.setNumeroConventionGestion(numeroConventionGestion);
  }
  
  public String getCodeAffectation()
  {
    return periodeActiviteSalarieGaec.getCodeAffectation();
  }
  
  public void setCodeAffectation(String codeAffectation)
  {
    periodeActiviteSalarieGaec.setCodeAffectation(codeAffectation);
  }
  
  public String getIdExterneEmployeurPublic()
  {
    return periodeActiviteSalarieGaec.getIdExterneEmployeurPublic();
  }
  
  public void setIdExterneEmployeurPublic(String idExterneEmployeurPublic)
  {
    periodeActiviteSalarieGaec.setIdExterneEmployeurPublic(idExterneEmployeurPublic);
  }
  
  public int getSecteurActivite()
  {
    return periodeActiviteSalarieGaec.getSecteurActivite();
  }
  
  public void setSecteurActivite(int secteur)
  {
    periodeActiviteSalarieGaec.setSecteurActivite(secteur);
  }
  
  public Hashtable getListeQuantitesAppartenance()
  {
    return periodeActiviteSalarieGaec.getListeQuantitesAppartenance();
  }
  
  public int getNatureAppartenance()
  {
    return periodeActiviteSalarieGaec.getNatureAppartenance();
  }
  
  public boolean produitAppartenance()
  {
    return periodeActiviteSalarieGaec.produitAppartenance();
  }
  
  public int getTypePeriode()
  {
    return periodeActiviteSalarieGaec.getTypePeriode();
  }
  
  public void setEntreprise(Entreprise entreprise)
  {
    periodeActiviteSalarieGaec.setEntreprise(entreprise);
  }
  
  public boolean estParticipantLiquidation()
  {
    return super.getPeriodeActiviteSalarieCali().estLiquidable();
  }
  
  public Damj getDateConnaissanceInfo()
  {
    return periodeActiviteSalarieGaec.getDateConnaissanceInfo();
  }
  
  public void setDateConnaissanceInfo(Damj date)
  {
    periodeActiviteSalarieGaec.setDateConnaissanceInfo(date);
  }
  
  public boolean estMigree()
  {
    return periodeActiviteSalarieGaec.estMigree();
  }
  
  public void setEstMigree(boolean estMigree)
  {
    periodeActiviteSalarieGaec.setEstMigree(estMigree);
  }
  
  public int getPrioriteStatut()
  {
    if (estAtteste()) {
      return 1;
    }
    return estQualifiable() ? 2 : 3;
  }
  
  public void copie(ActiviteSalarie copie)
  {
    copie.setIdentifiant(getIdentifiant());
    copie.setPeriodeActiviteSalarieCali(getPeriodeActiviteSalarieCali());
    copie.setPeriodeActiviteSalarieGaec(getPeriodeActiviteSalarieGaec());
    copie.setListePeriodesMesureActivite(getListePeriodesMesureActivite());
    copie.setPresencePNDSDetectee(isPresencePNDSDetectee());
  }
  
  public boolean estContratApprenti()
  {
    return periodeActiviteSalarieGaec.estContratApprenti();
  }
  
  public boolean estContratRemunereBaseSmic()
  {
    return periodeActiviteSalarieGaec.estContratRemunereBaseSmic();
  }
  
  public boolean isPresencePNDSDetectee()
  {
    return presencePNDSDetectee;
  }
  
  public void setPresencePNDSDetectee(boolean presencePNDSDetectee)
  {
    this.presencePNDSDetectee = presencePNDSDetectee;
  }
  
  public void ajouterPrime(Prime prime)
  {
    periodeActiviteSalarieGaec.ajouterPrime(prime);
  }
  
  public Chronologie getListePrimes()
  {
    return periodeActiviteSalarieGaec.getListePrimes();
  }
  
  public void setListePrimes(Chronologie listePrimes)
  {
    periodeActiviteSalarieGaec.setListePrimes(listePrimes);
  }
  
  public void ajouterPrimeExceptionnelle(Prime primeExceptionnelle)
  {
    primeExceptionnelle.setTypePrime(2);
    primeExceptionnelle.setEstPrimeExclue(false);
    periodeActiviteSalarieGaec.ajouterPrime(primeExceptionnelle);
  }
  
  public void ajouterPrimeICRS(Prime primeICRS)
  {
    primeICRS.setTypePrime(5);
    primeICRS.setEstPrimeExclue(false);
    periodeActiviteSalarieGaec.ajouterPrime(primeICRS);
  }
  
  public void ajouterPrimeNormale(Prime primeNormale)
  {
    primeNormale.setTypePrime(1);
    primeNormale.setEstPrimeExclue(false);
    periodeActiviteSalarieGaec.ajouterPrime(primeNormale);
  }
  
  public boolean estUneFct()
  {
    return estUneFct;
  }
  
  public void setEstUneFct(boolean estUneFct)
  {
    this.estUneFct = estUneFct;
  }
  
  public boolean estPndsSpectacleCharge()
  {
    return getPeriodeActiviteSalarieCali().estPndsSpectacleCharge();
  }
  
  public PeriodeNonDeclareeSanction getPndsSpectacle()
  {
    return getPeriodeActiviteSalarieCali().getPndsSpectacle();
  }
  
  public void setPndsSpectacle(PeriodeNonDeclareeSanction periodeNonDeclareeSanction)
  {
    getPeriodeActiviteSalarieCali().setPndsSpectacle(periodeNonDeclareeSanction);
  }
  
  public void setPndsSpectacleCharge(boolean pndsSpectacleCharge)
  {
    getPeriodeActiviteSalarieCali().setPndsSpectacleCharge(pndsSpectacleCharge);
  }
  
  public List getListePeriodeAffiliationSupplementaire()
  {
    return listePeriodeAffiliationSupplementaire;
  }
  
  public void setListePeriodeAffiliationSupplementaire(List listePeriodeAffiliationSupplementaire)
  {
    this.listePeriodeAffiliationSupplementaire = listePeriodeAffiliationSupplementaire;
  }
  
  public List getListePeriodeElementaire()
  {
    return listePeriodeElementaire;
  }
  
  public void setListePeriodeElementaire(List listePeriodeElementaire)
  {
    this.listePeriodeElementaire = listePeriodeElementaire;
  }
  
  public boolean estUneFctConcomittante()
  {
    return estUneFctConcomittante;
  }
  
  public void setEstUneFctConcomittante(boolean estUneFctConcomittante)
  {
    this.estUneFctConcomittante = estUneFctConcomittante;
  }
  
  public InformationPeriodeGlobale getInformationPeriodeGlobale()
  {
    return informationPeriodeGlobale;
  }
  
  public void setInformationPeriodeGlobale(InformationPeriodeGlobale informationPeriodeGlobale)
  {
    this.informationPeriodeGlobale = informationPeriodeGlobale;
  }
  
  public boolean isEstPeriodeMayotte()
  {
    return periodeActiviteSalarieGaec.isEstPeriodeMayotte();
  }
  
  public void setEstPeriodeMayotte(boolean estPeriodeMayotte)
  {
    periodeActiviteSalarieGaec.setEstPeriodeMayotte(estPeriodeMayotte);
  }
  
  public void initialiserReglementForce(Reglement reglement)
  {
    reglementForce = reglement;
  }
  
  public void supprimerReglementForce()
  {
    reglementForce = null;
  }
  
  public void ajouterPeriodeMesureActiviteForcee(PeriodeMesureActivite periodeMesureActivite)
  {
    if (periodeMesureActivite == null) {
      throw new IllegalArgumentException("L'argument PeriodeMesureActivite à ajouter est null.");
    }
    if (listePeriodesMesureActiviteForcee == null) {
      listePeriodesMesureActiviteForcee = new ChronologiePeriodes();
    }
    try
    {
      listePeriodesMesureActiviteForcee.ajouter(periodeMesureActivite);
      periodeMesureActivite.setPeriodeActiviteSalarie(this);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(PeriodeActiviteSalarie.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, PeriodeActiviteSalarie.class, "ajouterPeriodeMesureActiviteForcee", e);
      }
    }
  }
  
  public void supprimerPeriodesMesureActiviteForcees()
  {
    listePeriodesMesureActiviteForcee = null;
  }
  
  public String getIncoherencePeriode()
  {
    return incoherence;
  }
  
  public void setIncoherencePeriode(String incoherencePeriode)
  {
    incoherence = incoherencePeriode;
  }
  
  public void setPresenceMontantICCPAvantProratisation(boolean presenceMontantICCP)
  {
    this.presenceMontantICCP = presenceMontantICCP;
  }
  
  public boolean estPresenceMontantICCPAvantProratisation()
  {
    return presenceMontantICCP;
  }
  
  public void setMontantIccpProratise(boolean montantIccpProratise)
  {
    this.montantIccpProratise = montantIccpProratise;
  }
  
  public boolean estMontantIccpProratise()
  {
    return montantIccpProratise;
  }
}

/* Location:
 * Qualified Name:     ActiviteSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
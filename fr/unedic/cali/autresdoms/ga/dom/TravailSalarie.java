package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.spec.RemunerationSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.SalarieSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.TravailSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePrimesExceptionnelles;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePrimesExclues;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePrimesICRS;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePrimesNormales;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.QuantiteEuro;
import fr.unedic.util.QuantiteJourSpec;
import fr.unedic.util.QuantiteJoursCalendaires;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.NonConformiteException;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public abstract class TravailSalarie
  extends PeriodeGaec
  implements SalarieSpec, TravailSpec
{
  private static final long serialVersionUID = -7097758390659485086L;
  public static final int ORIGINE_CONTRAT_TRAVAIL = 1;
  public static final int ORIGINE_BULLETIN_SALAIRE = 2;
  public static final int ORIGINE_CHEQUE_EMPLOI_SERVICE = 3;
  private transient Entreprise entreprise;
  private Chronologie listeSalaires = new ChronologiePeriodes();
  private Chronologie listePeriodesMesureActivite = new ChronologiePeriodes();
  private Chronologie listePrimes = new ChronologieDebuts();
  private transient Collection<Indemnite> listeIndemnites = new ArrayList();
  private transient Metier metier;
  private boolean estAtteste;
  private boolean enConflit;
  private transient QuantiteJourSpec quantiteJourIccp;
  private QuantiteEuro quantiteEuroIccp;
  private QuantiteEuro quantiteEuroIslr;
  private BigDecimal nbHeuresDiff;
  private String codeCaisseProfessionnelle = null;
  private boolean iccpConservatoireCalculee = false;
  private QuantiteEuro quantiteEuroIndemniteTransactionnelle;
  private transient IndividuIdSpec identifiantIndividu = null;
  
  public TravailSalarie()
  {
    initInstance();
  }
  
  public TravailSalarie(Periode periode)
  {
    super(periode);
    initInstance();
  }
  
  public TravailSalarie(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    initInstance();
  }
  
  private void initInstance()
  {
    entreprise = new Entreprise();
    listeSalaires = new ChronologiePeriodes();
    metier = new Metier();
    estAtteste = false;
    enConflit = false;
    
    quantiteEuroIslr = new QuantiteEuro(new BigDecimal("0"));
    
    quantiteJourIccp = new QuantiteJoursCalendaires(new BigDecimal("0"));
  }
  
  public boolean estAtteste()
  {
    return estAtteste;
  }
  
  public void setEstAtteste(boolean estAtteste)
  {
    this.estAtteste = estAtteste;
  }
  
  public Chronologie getListeSalaires()
  {
    return listeSalaires;
  }
  
  public void ajouterSalaire(RemunerationSpec salaire)
  {
    if (salaire == null) {
      throw new IllegalArgumentException("L'argument PeriodeSalaire à ajouter est null.");
    }
    try
    {
      listeSalaires.ajouter(salaire);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(TravailSalarie.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, TravailSalarie.class, "ajouterPeriodeSalaire", e);
      }
    }
  }
  
  public void setListeSalaires(Chronologie listeSalaire)
  {
    listeSalaires = listeSalaire;
  }
  
  public Chronologie getListePeriodesMesureActivite()
  {
    return listePeriodesMesureActivite;
  }
  
  public void ajouterPeriodeMesureActivite(PeriodeMesureActivite periodeMesureActivite)
  {
    if (periodeMesureActivite == null) {
      throw new IllegalArgumentException("L'argument PeriodeMesureActivite à ajouter est null.");
    }
    try
    {
      listePeriodesMesureActivite.ajouter(periodeMesureActivite);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(TravailSalarie.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, TravailSalarie.class, "ajouterPeriodeMesureActivite", e);
      }
    }
  }
  
  public void setListePeriodesMesureActivite(Chronologie listePeriodesMesureActivite)
  {
    this.listePeriodesMesureActivite = listePeriodesMesureActivite;
  }
  
  public Chronologie getListePrimes()
  {
    return listePrimes;
  }
  
  public void ajouterPrime(Prime prime)
  {
    if (prime == null) {
      throw new IllegalArgumentException("L'argument PrimeExceptionnelle à ajouter est null.");
    }
    try
    {
      listePrimes.ajouter(prime);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(PeriodeActiviteSalarie.class, Niveau.DEBUG)) {
        Log.ecritTrace(Niveau.DEBUG, PeriodeActiviteSalarie.class, "ajouterPrime", e);
      }
    }
  }
  
  public void setListePrimes(Chronologie listePrimes)
  {
    this.listePrimes = listePrimes;
  }
  
  public Collection<Indemnite> getListeIndemnites()
  {
    return listeIndemnites;
  }
  
  public void ajouterIndemnite(Indemnite indemnite)
  {
    listeIndemnites.add(indemnite);
  }
  
  public void setListeIndemnites(Collection<Indemnite> listeIndemnites)
  {
    this.listeIndemnites = listeIndemnites;
  }
  
  public QuantiteEuro getQuantiteEuroIccp()
  {
    return quantiteEuroIccp;
  }
  
  public void setQuantiteEuroIccp(QuantiteEuro quantiteEuroIccp)
  {
    this.quantiteEuroIccp = quantiteEuroIccp;
  }
  
  public QuantiteEuro getQuantiteEuroIndemniteTransactionnelle()
  {
    return quantiteEuroIndemniteTransactionnelle;
  }
  
  public void setQuantiteEuroIndemniteTransactionnelle(QuantiteEuro quantiteEuroIndemniteTransactionnelle)
  {
    this.quantiteEuroIndemniteTransactionnelle = quantiteEuroIndemniteTransactionnelle;
  }
  
  public QuantiteEuro getQuantiteEuroIslr()
  {
    return quantiteEuroIslr;
  }
  
  public void setQuantiteEuroIslr(QuantiteEuro quantiteEuroIslr)
  {
    this.quantiteEuroIslr = quantiteEuroIslr;
  }
  
  public QuantiteJourSpec getQuantiteJourIccp()
  {
    return quantiteJourIccp;
  }
  
  public void setQuantiteJourIccp(QuantiteJourSpec quantiteJourIccp)
  {
    this.quantiteJourIccp = quantiteJourIccp;
  }
  
  public ObjetMetierSpec copie()
  {
    return null;
  }
  
  public void copieElements(ObjetMetierSpec copie) {}
  
  public Metier getMetier()
  {
    return metier;
  }
  
  public void setMetier(Metier metier)
  {
    this.metier = metier;
  }
  
  public Entreprise getEntreprise()
  {
    return entreprise;
  }
  
  public void setEntreprise(Entreprise entreprise)
  {
    this.entreprise = entreprise;
  }
  
  public IndividuIdSpec getIdentifiantIndividu()
  {
    return identifiantIndividu;
  }
  
  public void setIdentifiantIndividu(IndividuIdSpec identifiantIndividu)
  {
    this.identifiantIndividu = identifiantIndividu;
  }
  
  public boolean estEnConflit()
  {
    return enConflit;
  }
  
  public void setEnConflit(boolean enConflit)
  {
    this.enConflit = enConflit;
  }
  
  public boolean estParticipantLiquidation()
  {
    return true;
  }
  
  public int getTypePeriode()
  {
    return 30;
  }
  
  public abstract int getOrigineInformation();
  
  public BigDecimal getNbHeuresDiff()
  {
    return nbHeuresDiff;
  }
  
  public void setNbHeuresDiff(BigDecimal nbHeuresDiff)
  {
    this.nbHeuresDiff = nbHeuresDiff;
  }
  
  public Chronologie getListePrimesExceptionnellesExclues()
  {
    FiltrePrimesExceptionnelles filtreExceptionelles = new FiltrePrimesExceptionnelles();
    FiltrePrimesExclues filtreExclusion = new FiltrePrimesExclues(true);
    
    FiltresTemporel filtres = new FiltresTemporel();
    filtres.ajouterFiltre(filtreExceptionelles);
    filtres.ajouterFiltre(filtreExclusion);
    
    return getListePrimes().copier(filtres);
  }
  
  public Chronologie getListePrimesExceptionnelles()
  {
    FiltrePrimesExceptionnelles filtreExceptionelles = new FiltrePrimesExceptionnelles();
    FiltrePrimesExclues filtreExclusion = new FiltrePrimesExclues(false);
    
    FiltresTemporel filtres = new FiltresTemporel();
    filtres.ajouterFiltre(filtreExceptionelles);
    filtres.ajouterFiltre(filtreExclusion);
    
    return getListePrimes().copier(filtres);
  }
  
  public Chronologie getListePrimesNormales()
  {
    FiltrePrimesNormales filtreNormales = new FiltrePrimesNormales();
    FiltrePrimesExclues filtreExclusion = new FiltrePrimesExclues(false);
    
    FiltresTemporel filtres = new FiltresTemporel();
    filtres.ajouterFiltre(filtreNormales);
    filtres.ajouterFiltre(filtreExclusion);
    
    return getListePrimes().copier(filtres);
  }
  
  public Chronologie getListePrimesNormalesExclues()
  {
    FiltrePrimesNormales filtreNormales = new FiltrePrimesNormales();
    FiltrePrimesExclues filtreExclusion = new FiltrePrimesExclues(true);
    
    FiltresTemporel filtres = new FiltresTemporel();
    filtres.ajouterFiltre(filtreNormales);
    filtres.ajouterFiltre(filtreExclusion);
    
    return getListePrimes().copier(filtres);
  }
  
  public Chronologie getListePrimesICRS()
  {
    FiltrePrimesICRS filtreICRS = new FiltrePrimesICRS();
    FiltrePrimesExclues filtreExclusion = new FiltrePrimesExclues(false);
    
    FiltresTemporel filtres = new FiltresTemporel();
    filtres.ajouterFiltre(filtreICRS);
    filtres.ajouterFiltre(filtreExclusion);
    
    return getListePrimes().copier(filtres);
  }
  
  public Chronologie getListePrimesICRSExclues()
  {
    FiltrePrimesICRS filtreICRS = new FiltrePrimesICRS();
    FiltrePrimesExclues filtreExclusion = new FiltrePrimesExclues(true);
    
    FiltresTemporel filtres = new FiltresTemporel();
    filtres.ajouterFiltre(filtreICRS);
    filtres.ajouterFiltre(filtreExclusion);
    
    return getListePrimes().copier(filtres);
  }
  
  public String getCodeCaisseProfessionnelle()
  {
    return codeCaisseProfessionnelle;
  }
  
  public void setCodeCaisseProfessionnelle(String codeCaisseProfessionnelle)
  {
    this.codeCaisseProfessionnelle = codeCaisseProfessionnelle;
  }
  
  public boolean isIccpConservatoireCalculee()
  {
    return iccpConservatoireCalculee;
  }
  
  public void setIccpConservatoireCalculee(boolean iccpConservatoireCalculee)
  {
    this.iccpConservatoireCalculee = iccpConservatoireCalculee;
  }
}

/* Location:
 * Qualified Name:     TravailSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
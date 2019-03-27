package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.spec.AppartenanceSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.cali.autresdoms.ga.outilsfonctionnels.DeterminationSecteurActivite;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.NonConformiteException;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

public class PeriodeActiviteSalarie
  extends TravailSalarie
  implements AppartenanceSpec
{
  private static final long serialVersionUID = 8790817905907057385L;
  private static final int NOMBRE_DE_CONSTANTE_ORIGINE_INFO = 6;
  private static final int SECTEUR_ACTIVITE_A_DETERMINER = -1;
  private boolean derogationPlafondMensuel = false;
  private Chronologie listePeriodesIncident = new ChronologiePeriodes();
  private ContratTravail contratTravail;
  private Chronologie listePeriodeIntensite = new ChronologiePeriodes();
  private Chronologie listeSalairesMensuelsBase = new ChronologiePeriodes();
  private HashMap<Integer, Collection<Integer>> hashmapOriginesInformationPAS;
  private Collection<Integer> collectionOriginesInformationPasCertifTravail;
  private Collection<Integer> collectionOriginesInformationPasContratTravail;
  private Collection<Integer> collectionOriginesInformationDsn;
  private Collection<Integer> collectionOriginesInformationPasAeEquiv;
  private Collection<Integer> collectionOriginesInformationPasAutres;
  private Collection<Integer> collectionOriginesInformationPasBs;
  private boolean estSanctionne;
  private int secteurActivite;
  private BigDecimal incomplete;
  private boolean horsChampsSpectacle;
  private boolean contratRemunereBaseSmic;
  private transient boolean estPeriodeMayotte;
  
  public PeriodeActiviteSalarie()
  {
    initInstance();
  }
  
  public PeriodeActiviteSalarie(Periode periode)
  {
    super(periode);
    initInstance();
  }
  
  public PeriodeActiviteSalarie(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    initInstance();
  }
  
  private void initInstance()
  {
    contratTravail = new ContratTravail();
    
    hashmapOriginesInformationPAS = new HashMap(6);
    collectionOriginesInformationPasCertifTravail = new ArrayList();
    collectionOriginesInformationPasContratTravail = new ArrayList();
    collectionOriginesInformationPasAeEquiv = new ArrayList();
    collectionOriginesInformationPasAutres = new ArrayList();
    collectionOriginesInformationPasBs = new ArrayList();
    collectionOriginesInformationDsn = new ArrayList();
    
    hashmapOriginesInformationPAS.put(Integer.valueOf(3), collectionOriginesInformationPasCertifTravail);
    
    hashmapOriginesInformationPAS.put(Integer.valueOf(4), collectionOriginesInformationPasContratTravail);
    
    hashmapOriginesInformationPAS.put(Integer.valueOf(1), collectionOriginesInformationPasAeEquiv);
    
    hashmapOriginesInformationPAS.put(Integer.valueOf(0), collectionOriginesInformationPasAutres);
    
    hashmapOriginesInformationPAS.put(Integer.valueOf(5), collectionOriginesInformationPasBs);
    
    hashmapOriginesInformationPAS.put(Integer.valueOf(2), collectionOriginesInformationDsn);
    
    secteurActivite = -1;
  }
  
  public Collection<Integer> getCollectionOriginesInformationPasAeEquiv()
  {
    return collectionOriginesInformationPasAeEquiv;
  }
  
  public void setCollectionOriginesInformationPasAeEquiv(Collection<Integer> collectionOriginesInformationPasAeEqui)
  {
    collectionOriginesInformationPasAeEquiv = collectionOriginesInformationPasAeEqui;
  }
  
  public Collection<Integer> getCollectionOriginesInformationPasAutres()
  {
    return collectionOriginesInformationPasAutres;
  }
  
  public void setCollectionOriginesInformationPasAutres(Collection<Integer> pcollectionOriginesInformationPasAutres)
  {
    collectionOriginesInformationPasAutres = pcollectionOriginesInformationPasAutres;
  }
  
  public Collection<Integer> getCollectionOriginesInformationPasBs()
  {
    return collectionOriginesInformationPasBs;
  }
  
  public void setCollectionOriginesInformationPasBs(Collection<Integer> pcollectionOriginesInformationPasBs)
  {
    collectionOriginesInformationPasBs = pcollectionOriginesInformationPasBs;
  }
  
  public Collection<Integer> getCollectionOriginesInformationPasCertifTravail()
  {
    return collectionOriginesInformationPasCertifTravail;
  }
  
  public void setCollectionOriginesInformationPasCertifTravail(Collection<Integer> pcollectionOriginesInformationPasCertifTravail)
  {
    collectionOriginesInformationPasCertifTravail = pcollectionOriginesInformationPasCertifTravail;
  }
  
  public Collection<Integer> getCollectionOriginesInformationDsn()
  {
    return collectionOriginesInformationDsn;
  }
  
  public void setCollectionOriginesInformationDsn(Collection<Integer> pcollectionOriginesInformationDsn)
  {
    collectionOriginesInformationDsn = pcollectionOriginesInformationDsn;
  }
  
  public Collection<Integer> getCollectionOriginesInformationPasContratTravail()
  {
    return collectionOriginesInformationPasContratTravail;
  }
  
  public void setCollectionOriginesInformationPasContratTravail(Collection<Integer> pcollectionOriginesInformationPasContratTravail)
  {
    collectionOriginesInformationPasContratTravail = pcollectionOriginesInformationPasContratTravail;
  }
  
  public ContratTravail getContratTravail()
  {
    return contratTravail;
  }
  
  public void setContratTravail(ContratTravail pcontratTravail)
  {
    contratTravail = pcontratTravail;
  }
  
  public int getTypeEmploiParticulier()
  {
    if (getMetier() == null) {
      return 0;
    }
    return getMetier().getContratTypeParticulier();
  }
  
  public int getCategorieEmploiParticulier()
  {
    if (getMetier() == null) {
      return 0;
    }
    return getMetier().getCategorieEmploiParticulier();
  }
  
  public int getOrigineInformation()
  {
    return 1;
  }
  
  public Collection<Integer> getCollectionOrigineInformationPAS()
  {
    Collection<Integer> data = new ArrayList();
    Collection<Collection<Integer>> collectionDeCollections = hashmapOriginesInformationPAS.values();
    Iterator<Collection<Integer>> iter = collectionDeCollections.iterator();
    while (iter.hasNext())
    {
      Collection<Integer> set = (Collection)iter.next();
      data.addAll(set);
    }
    return data;
  }
  
  public HashMap<Integer, Collection<Integer>> getCollectionOrigineInformationPASAvecPriorite()
  {
    return hashmapOriginesInformationPAS;
  }
  
  public boolean isDerogationPlafondMensuel()
  {
    return derogationPlafondMensuel;
  }
  
  public void setDerogationPlafondMensuel(boolean derogation)
  {
    derogationPlafondMensuel = derogation;
  }
  
  public boolean estSanctionne()
  {
    return estSanctionne;
  }
  
  public void setEstSanctionne(boolean pestSanctionne)
  {
    estSanctionne = pestSanctionne;
  }
  
  public Chronologie getListePeriodeIntensite()
  {
    return listePeriodeIntensite;
  }
  
  public void setListePeriodeIntensite(Chronologie plistePeriodeIntensite)
  {
    listePeriodeIntensite = plistePeriodeIntensite;
  }
  
  public Chronologie getListePeriodesIncident()
  {
    return listePeriodesIncident;
  }
  
  public void setListePeriodesIncident(Chronologie plistePeriodesIncident)
  {
    listePeriodesIncident = plistePeriodesIncident;
  }
  
  public int getSecteurActivite()
  {
    if (secteurActivite == -1) {
      setSecteurActivite(DeterminationSecteurActivite.determiner(this));
    }
    return secteurActivite;
  }
  
  public void setSecteurActivite(int psecteurActivite)
  {
    secteurActivite = psecteurActivite;
  }
  
  public void ajouterIncident(IncidentSpec incident)
  {
    if (incident == null) {
      throw new IllegalArgumentException("L'argument PeriodeMesureActivite à ajouter est null.");
    }
    try
    {
      listePeriodesIncident.ajouter(incident);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(PeriodeActiviteSalarie.class, Niveau.ERROR)) {
        Log.ecritTrace(Niveau.ERROR, PeriodeActiviteSalarie.class, "ajouterPeriodeMesureActivite", e);
      }
    }
  }
  
  public void ajouterOrigineInformationPAS(int constante, int priorite)
  {
    Collection<Integer> coll = (Collection)hashmapOriginesInformationPAS.get(Integer.valueOf(priorite));
    coll.add(Integer.valueOf(constante));
  }
  
  public boolean ajouterIntensite(PeriodeIntensite periodeIntensite)
  {
    boolean ajoutOk = true;
    if (periodeIntensite == null) {
      throw new IllegalArgumentException("L'argument PeriodeIntensite à ajouter est null.");
    }
    try
    {
      listePeriodeIntensite.ajouter(periodeIntensite);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(PeriodeActiviteSalarie.class, Niveau.ERROR)) {
        Log.ecritTrace(Niveau.ERROR, PeriodeActiviteSalarie.class, "ajouterPeriodeIntensite", e);
      }
      ajoutOk = false;
    }
    return ajoutOk;
  }
  
  public void setSiren(String siren)
  {
    getEntreprise().setSiren(siren);
  }
  
  public String getNumeroConventionGestion()
  {
    return getContratTravail().getNumeroConventionGestion();
  }
  
  public void setNumeroConventionGestion(String numeroConventionGestion)
  {
    getContratTravail().setNumeroConventionGestion(numeroConventionGestion);
  }
  
  public String getCodeAffectation()
  {
    return getContratTravail().getCodeAffectation();
  }
  
  public void setCodeAffectation(String codeAffectation)
  {
    getContratTravail().setCodeAffectation(codeAffectation);
  }
  
  public String getIdExterneEmployeurPublic()
  {
    return getContratTravail().getIdExterneEmployeurPublic();
  }
  
  public void setIdExterneEmployeurPublic(String idExterneEmployeurPublic)
  {
    getContratTravail().setIdExterneEmployeurPublic(idExterneEmployeurPublic);
  }
  
  public void setDateEngagementProcedureLicenciement(Damj date)
  {
    getContratTravail().setDateEngagementProcedureLicenciement(date);
  }
  
  public Damj getDateEngagementProcedureLicenciement()
  {
    return getContratTravail().getDateEngagementProcedureLicenciement();
  }
  
  public Damj getDateRuptureContratTravail()
  {
    return getContratTravail().getDateRuptureContratTravail();
  }
  
  public int getContratTypeParticulier()
  {
    if (getMetier() == null) {
      return 0;
    }
    return getMetier().getContratTypeParticulier();
  }
  
  public int getChampApplication()
  {
    if (getMetier() == null) {
      return 0;
    }
    return getMetier().getChampApplication();
  }
  
  public int getChampApplicationRenseigne()
  {
    if (getMetier() == null) {
      return 0;
    }
    return getMetier().getChampApplicationRenseigne();
  }
  
  public boolean estContratApprenti()
  {
    return (getContratTypeParticulier() == 2) || (getContratTypeParticulier() == 1) || (getContratTypeParticulier() == 4);
  }
  
  public boolean estEngagementProcedureStrictementAvant(Damj date)
  {
    return getContratTravail().getDateEngagementProcedureLicenciement() != null ? getContratTravail().getDateEngagementProcedureLicenciement().estAvant(date) : false;
  }
  
  public PeriodeIntensite rechercherIntensite(Periode periode)
  {
    Chronologie listePeriodesIntensite = getListePeriodeIntensite();
    for (Iterator iter = listePeriodesIntensite.iterer(); iter.hasNext();)
    {
      PeriodeIntensite periodeIntensite = (PeriodeIntensite)iter.next();
      if (periodeIntensite.chevauche(periode)) {
        return periodeIntensite;
      }
    }
    return null;
  }
  
  public Hashtable getListeQuantitesAppartenance()
  {
    return new Hashtable();
  }
  
  public int getNatureAppartenance()
  {
    return 0;
  }
  
  public boolean produitAppartenance()
  {
    return true;
  }
  
  public int getTypePeriode()
  {
    int typePeriode = super.getTypePeriode();
    if (getMetier().getContratTypeParticulier() == 8) {
      typePeriode = 5;
    }
    return typePeriode;
  }
  
  public boolean estQualifiable()
  {
    return false;
  }
  
  public int getPrioriteStatut()
  {
    return 3;
  }
  
  public BigDecimal getIncomplete()
  {
    return incomplete;
  }
  
  public void setIncomplete(BigDecimal pincomplete)
  {
    incomplete = pincomplete;
  }
  
  public boolean isHorsChampsSpectacle()
  {
    return horsChampsSpectacle;
  }
  
  public void setHorsChampsSpectacle(boolean phorsChampsSpectacle)
  {
    horsChampsSpectacle = phorsChampsSpectacle;
  }
  
  public boolean estContratRemunereBaseSmic()
  {
    return contratRemunereBaseSmic;
  }
  
  public void setContratRemunereBaseSmic(boolean pcontratRemunereBaseSmic)
  {
    contratRemunereBaseSmic = pcontratRemunereBaseSmic;
  }
  
  public Chronologie getListeSalairesMensuelsBase()
  {
    return listeSalairesMensuelsBase;
  }
  
  public void setListeSalairesMensuelsBase(Chronologie plisteSalairesMensuelsBase)
  {
    listeSalairesMensuelsBase = plisteSalairesMensuelsBase;
  }
  
  public boolean ajouterSalaireMensuelBase(SalaireMensuelBase salaireMensuelBase)
  {
    boolean ajoutOk = true;
    if (salaireMensuelBase == null) {
      throw new IllegalArgumentException("L'argument SalaireMensuelBase à ajouter est null.");
    }
    try
    {
      listeSalairesMensuelsBase.ajouter(salaireMensuelBase);
    }
    catch (NonConformiteException e)
    {
      if (Log.isTraceActive(PeriodeActiviteSalarie.class, Niveau.ERROR)) {
        Log.ecritTrace(Niveau.ERROR, PeriodeActiviteSalarie.class, "ajouterSalaireMensuelBase", e);
      }
      ajoutOk = false;
    }
    return ajoutOk;
  }
  
  public boolean isEstPeriodeMayotte()
  {
    return estPeriodeMayotte;
  }
  
  public void setEstPeriodeMayotte(boolean pestPeriodeMayotte)
  {
    estPeriodeMayotte = pestPeriodeMayotte;
  }
}

/* Location:
 * Qualified Name:     PeriodeActiviteSalarie
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
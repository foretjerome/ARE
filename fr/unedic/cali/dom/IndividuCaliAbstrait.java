package fr.unedic.cali.dom;

import fr.pe.cali.crem.outils.CacheCrem;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.FiltreDebutPbjcApresDate;
import fr.unedic.cali.dom.pnds.CachePndsSpectacle;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.cali.outilsfonctionnels.ComparateurSurDateDeclenchementEtPrioriteDemande;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesAri;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesDec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesGammeAsu;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesGammeFor;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesGammeInr;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesGammeRbf;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesGammeSol;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesMaintiens;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesPrestation;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandesPrr;
import fr.unedic.cali.utilitaire.comparateurs.ComparateurNeutre;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class IndividuCaliAbstrait
  implements IndividuCaliSpec, IndividuChargementSpec
{
  private static final String NOM_INDIVIDU = "CALI";
  private IndividuIdSpec identifiant = null;
  private ChronologieDebuts chronoDemandes;
  private ChronologieDebuts chronoDemandesNonTriees;
  private IndicateursGeneriques indicateursGeneriques;
  private Collection listeLA2K;
  private boolean indicateurEnregistrerQualifPeriodes;
  private boolean estCharge = false;
  private boolean estModifiable = false;
  private boolean estDejaCree = false;
  private boolean estPndsActive = true;
  private Collection listeStatutDSM = null;
  private Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> listePNDS = null;
  private Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> listePndsVide = new HashMap();
  private ChronologiePeriodes chronoPBJCs;
  private ChronologiePeriodes chronoAIDEs;
  private ChronologiePeriodesGaec chronoPeriodesCalcul;
  private Collection collectionPrimes;
  private List listDroitsPbjcsNcp;
  private IndividuPbjcNcp individuPbjcNcp;
  private List listEnquetesPbjcNcp;
  private Damj dateDebutGenerationPbjcs = Damj.NUIT_DES_TEMPS;
  private Damj dateDebutGenerationPrimes = Damj.NUIT_DES_TEMPS;
  private Damj dateDebutGenerationDroits = Damj.NUIT_DES_TEMPS;
  private Damj dateDebutGenerationEnquete = Damj.NUIT_DES_TEMPS;
  private Damj dateDebutGenerationAides = Damj.NUIT_DES_TEMPS;
  private Damj dateDebutGenerationDispositif = Damj.NUIT_DES_TEMPS;
  private Collection<DispositifNcp> collectionDispositifs;
  private CachePndsSpectacle cachePndsSpectacle = null;
  private CacheCrem cacheCrem = null;
  
  public IndividuCaliAbstrait()
  {
    identifiant = new IndividuId();
  }
  
  public IndividuCaliAbstrait(IndividuIdSpec individu)
  {
    setIndividuId(individu);
  }
  
  public IndividuIdSpec getIndividuId()
  {
    return identifiant;
  }
  
  public void setIndividuId(IndividuIdSpec identifiant)
  {
    this.identifiant = identifiant;
  }
  
  protected ChronologieDebuts getChronoDemandesPrive()
  {
    if (chronoDemandes == null)
    {
      chronoDemandes = new ChronologieDebuts(new FiltreDemandesPrestation());
      chronoDemandes.setComparateur(new ComparateurSurDateDeclenchementEtPrioriteDemande());
      chronoDemandes.ajouter(getDemandes());
    }
    return chronoDemandes;
  }
  
  protected ChronologieDebuts getChronoDemandesNonTrieesPrive()
  {
    if (chronoDemandesNonTriees == null)
    {
      chronoDemandesNonTriees = new ChronologieDebuts(new FiltreDemandesPrestation());
      chronoDemandesNonTriees.setComparateur(new ComparateurNeutre());
      chronoDemandesNonTriees.ajouter(getDemandes());
    }
    return chronoDemandesNonTriees;
  }
  
  public void ajouterPeriodeActiviteSalariee(ActiviteSalarie periodeActivite)
  {
    ajouterActiviteSalarie(periodeActivite);
  }
  
  public abstract void ajouterActiviteSalarie(ActiviteSalarie paramActiviteSalarie);
  
  public boolean getIndicateurEnregistrerQualifPeriodes()
  {
    return indicateurEnregistrerQualifPeriodes;
  }
  
  public void setIndicateurEnregistrerQualifPeriodes(boolean val)
  {
    indicateurEnregistrerQualifPeriodes = val;
  }
  
  public IndicateursGeneriques getIndicateursGeneriques()
  {
    return indicateursGeneriques;
  }
  
  public Collection getListeLA2K()
  {
    if (listeLA2K == null) {
      listeLA2K = new ArrayList();
    }
    return listeLA2K;
  }
  
  public ChronologieDebuts getChronoDemandes()
  {
    return (ChronologieDebuts)getChronoDemandesPrive().copier();
  }
  
  public ChronologieDebuts getChronoDemandesNonTriees()
  {
    return (ChronologieDebuts)getChronoDemandesNonTrieesPrive().copier();
  }
  
  public ChronologieDebuts getChronoDemandeMaintien()
  {
    return (ChronologieDebuts)getChronoDemandes().copier(new FiltreDemandesMaintiens());
  }
  
  public ChronologieDebuts getChronoDemandeAssurance()
  {
    return (ChronologieDebuts)getChronoDemandes().copier(new FiltreDemandesGammeAsu());
  }
  
  public ChronologieDebuts getChronoDemandeFormation()
  {
    return (ChronologieDebuts)getChronoDemandes().copier(new FiltreDemandesGammeFor());
  }
  
  public ChronologieDebuts getChronoDemandeSolidarite()
  {
    return (ChronologieDebuts)getChronoDemandes().copier(new FiltreDemandesGammeSol());
  }
  
  public ChronologieDebuts getChronoDemandeRemboursementFrais()
  {
    return (ChronologieDebuts)getChronoDemandes().copier(new FiltreDemandesGammeRbf());
  }
  
  public ChronologieDebuts getChronoDemandeIncitationReclassement()
  {
    return (ChronologieDebuts)getChronoDemandes().copier(new FiltreDemandesGammeInr());
  }
  
  public ChronologieDebuts getChronoDemandeAri()
  {
    return (ChronologieDebuts)getChronoDemandes().copier(new FiltreDemandesAri());
  }
  
  public ChronologieDebuts getChronoDemandePreRetraite()
  {
    return (ChronologieDebuts)getChronoDemandes().copier(new FiltreDemandesPrr());
  }
  
  public ChronologieDebuts getChronoDemandeDeces()
  {
    return (ChronologieDebuts)getChronoDemandes().copier(new FiltreDemandesDec());
  }
  
  public DemandeSpec rechercherDemande(String identifiantDemande)
  {
    DemandeSpec demandeRecherchee = null;
    if (identifiantDemande != null)
    {
      Collection demandes = getDemandes();
      if ((demandes != null) && (!demandes.isEmpty()))
      {
        Iterator iteratorDemandes = demandes.iterator();
        while (iteratorDemandes.hasNext())
        {
          DemandeSpec demandeCourante = (DemandeSpec)iteratorDemandes.next();
          if (demandeCourante.getIdentifiant().equalsIgnoreCase(identifiantDemande)) {
            demandeRecherchee = demandeCourante;
          }
        }
      }
    }
    return demandeRecherchee;
  }
  
  public DemandeSpec rechercherDemande(String idDemande, String codeGamme)
  {
    return rechercherDemande(idDemande);
  }
  
  public boolean estCharge()
  {
    return estCharge;
  }
  
  public void setEstCharge(boolean estCharge)
  {
    this.estCharge = estCharge;
  }
  
  public boolean estModifiable()
  {
    return estModifiable;
  }
  
  public void setEstModifiable(boolean modifiable)
  {
    estModifiable = modifiable;
  }
  
  public boolean estDejaCree()
  {
    return estDejaCree;
  }
  
  public void setEstDejaCree(boolean estDejaCree)
  {
    this.estDejaCree = estDejaCree;
  }
  
  public String getNomIndividu()
  {
    return "CALI";
  }
  
  public String toString()
  {
    StringBuffer chaineRetour = new StringBuffer();
    
    chaineRetour.append("Individu :" + getIndividuId() + "\n");
    if (getChronoDemandesPrive() != null) {
      chaineRetour.append("   Chrono Demandes : " + getChronoDemandesPrive() + "\n");
    }
    if (getListePeriodesActiviteSalariee() != null) {
      chaineRetour.append("   Chrono Periodes Activités Salariées : " + getListePeriodesActiviteSalariee() + "\n");
    }
    return chaineRetour.toString();
  }
  
  public Collection getListeStatutDSM()
  {
    return listeStatutDSM;
  }
  
  public void setListeStatutDSM(Collection listeStatutDSM)
  {
    this.listeStatutDSM = listeStatutDSM;
  }
  
  public void setListePNDSIndividu(Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> listePNDS)
  {
    this.listePNDS = listePNDS;
  }
  
  public Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> getListePNDSIndividu()
  {
    Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> retour;
    Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> retour;
    if (estPndsActive) {
      retour = listePNDS;
    } else {
      retour = listePndsVide;
    }
    return retour;
  }
  
  public List getListEnquetesPbjcNcp()
  {
    if (listEnquetesPbjcNcp == null) {
      listEnquetesPbjcNcp = new ArrayList();
    }
    return listEnquetesPbjcNcp;
  }
  
  public void setListEnquetesPbjcNcp(List listEnquetesPbjcNcp)
  {
    this.listEnquetesPbjcNcp = listEnquetesPbjcNcp;
  }
  
  public IndividuPbjcNcp getIndividuPbjcNcp()
  {
    return individuPbjcNcp;
  }
  
  public void setIndividuPbjcNcp(IndividuPbjcNcp individuPbjcNcp)
  {
    this.individuPbjcNcp = individuPbjcNcp;
  }
  
  public List getListDroitsPbjcsNcp()
  {
    if (listDroitsPbjcsNcp == null) {
      listDroitsPbjcsNcp = new ArrayList();
    }
    return listDroitsPbjcsNcp;
  }
  
  public void setListDroitsPbjcsNcp(List listDroitsPbjcsNcp)
  {
    this.listDroitsPbjcsNcp = listDroitsPbjcsNcp;
  }
  
  public Collection getCollectionPrimes()
  {
    if (collectionPrimes == null) {
      collectionPrimes = new ArrayList();
    }
    return collectionPrimes;
  }
  
  public void setCollectionPrimes(Collection chronoPrimes)
  {
    collectionPrimes = chronoPrimes;
  }
  
  public ChronologiePeriodes getChronoPbjcs()
  {
    if (chronoPBJCs == null) {
      chronoPBJCs = new ChronologiePeriodes();
    }
    return chronoPBJCs;
  }
  
  public ChronologiePeriodes getChronoPbjcsADate(Damj date)
  {
    FiltreDebutPbjcApresDate filtreDebutPbjcApresDateDate = new FiltreDebutPbjcApresDate(date);
    return (ChronologiePeriodes)chronoPBJCs.copier(filtreDebutPbjcApresDateDate);
  }
  
  public void ajouterPbjc(PbjcNcp pbjc)
  {
    chronoPBJCs.ajouter(pbjc);
  }
  
  public void setChronoPbjc(ChronologiePeriodes chronoPbjc)
  {
    chronoPBJCs = chronoPbjc;
  }
  
  public Damj getDateDebutGenerationPbjcs()
  {
    return dateDebutGenerationPbjcs;
  }
  
  public void setDateDebutGenerationPbjcs(Damj dateDebutGenerationPbcjcs)
  {
    dateDebutGenerationPbjcs = dateDebutGenerationPbcjcs;
  }
  
  public Damj getDateDebutGenerationEnquete()
  {
    return dateDebutGenerationEnquete;
  }
  
  public void setDateDebutGenerationEnquete(Damj dateDebutGenerationEnquete)
  {
    this.dateDebutGenerationEnquete = dateDebutGenerationEnquete;
  }
  
  public Damj getDateDebutGenerationDroits()
  {
    return dateDebutGenerationDroits;
  }
  
  public void setDateDebutGenerationDroits(Damj dateDebutGenerationDroits)
  {
    this.dateDebutGenerationDroits = dateDebutGenerationDroits;
  }
  
  public Damj getDateDebutGenerationPrimes()
  {
    return dateDebutGenerationPrimes;
  }
  
  public void setDateDebutGenerationPrimes(Damj dateDebutGenerationPrimes)
  {
    this.dateDebutGenerationPrimes = dateDebutGenerationPrimes;
  }
  
  public ChronologiePeriodes getChronoAides()
  {
    if (chronoAIDEs == null) {
      chronoAIDEs = new ChronologiePeriodes();
    }
    return chronoAIDEs;
  }
  
  public void ajouterAide(AideNcp aide)
  {
    chronoAIDEs.ajouter(aide);
  }
  
  public void setChronoAide(ChronologiePeriodes chronoAide)
  {
    chronoAIDEs = chronoAide;
  }
  
  public ChronologiePeriodesGaec getChronoPeriodesCalcul()
  {
    if (chronoPeriodesCalcul == null) {
      chronoPeriodesCalcul = new ChronologiePeriodesGaec();
    }
    return chronoPeriodesCalcul;
  }
  
  public void setChronoPeriodesCalcul(ChronologiePeriodesGaec chronoPeriodesCalcul)
  {
    this.chronoPeriodesCalcul = chronoPeriodesCalcul;
  }
  
  public Damj getDateDebutGenerationAides()
  {
    return dateDebutGenerationAides;
  }
  
  public void setDateDebutGenerationAides(Damj date)
  {
    dateDebutGenerationAides = date;
  }
  
  public void desactiverPNDS()
  {
    estPndsActive = false;
  }
  
  public void activerPNDS()
  {
    estPndsActive = true;
  }
  
  public boolean estPndsActive()
  {
    return estPndsActive;
  }
  
  public void ajouterDispositifNcp(DispositifNcp dispositif)
  {
    collectionDispositifs.add(dispositif);
  }
  
  public Collection<DispositifNcp> getCollectionDispositifNcp()
  {
    return collectionDispositifs;
  }
  
  public Damj getdateDebutGenerationDispositif()
  {
    return dateDebutGenerationDispositif;
  }
  
  public void setCollectionDispositifNcp(Collection<DispositifNcp> collectionDispositifs)
  {
    this.collectionDispositifs = collectionDispositifs;
  }
  
  public void setDateDebutGenerationDispositifNcp(Damj dateDebut)
  {
    dateDebutGenerationDispositif = dateDebut;
  }
  
  public CachePndsSpectacle getCachePndsSpectacle()
  {
    if (cachePndsSpectacle == null) {
      cachePndsSpectacle = new CachePndsSpectacle();
    }
    return cachePndsSpectacle;
  }
  
  public CacheCrem getCacheCrem()
  {
    if (cacheCrem == null) {
      cacheCrem = new CacheCrem();
    }
    return cacheCrem;
  }
  
  public void setCacheCrem(CacheCrem cacheCrem)
  {
    this.cacheCrem = cacheCrem;
  }
}

/* Location:
 * Qualified Name:     IndividuCaliAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
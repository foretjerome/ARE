package fr.unedic.cali.calcul.outilsfonctionnels.dom;

import fr.unedic.cali.calcul.OutillageCalculADate;
import fr.unedic.cali.calcul.PostTraitementsHorsGamme;
import fr.unedic.cali.calcul.dom.ArretProduitAvecRaison;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.ConstituantsCalculActiviteReduiteSpec;
import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.EtatAuDji;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.SyntheseARsurUT;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeDispositifSpec;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeInterProduits;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilGestionPoursuite;
import fr.unedic.cali.calcul.outilsfonctionnels.filtres.FiltrePeriodeInterstage;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ContexteUT$ElementContexteUT
{
  private AttributionSpec m_attribution = null;
  private CalendrierExecutionCalculSpec m_calendrierExecutionCalcul = null;
  private UniteTraitement m_uniteTraitementPendant = null;
  
  public ContexteUT$ElementContexteUT(ContexteUT paramContexteUT, AttributionSpec p_attribution, CalendrierExecutionCalculSpec p_calendrierExecutionCalcul, Periode p_periodeUT)
  {
    m_attribution = p_attribution;
    m_calendrierExecutionCalcul = p_calendrierExecutionCalcul;
    
    m_uniteTraitementPendant = recupererDerniereUTCoincidantAvecPeriodeUT(p_attribution, p_calendrierExecutionCalcul, p_periodeUT);
  }
  
  private UniteTraitement recupererDerniereUTCoincidantAvecPeriodeUT(AttributionSpec p_attribution, CalendrierExecutionCalculSpec p_calendrierExecutionCalcul, Periode p_periodeUT)
  {
    UniteTraitement uniteTraitementPendant = null;
    if ((p_attribution.getProduit().getTypePaiement() == 0) && 
      (((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements() != null) && (((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().getTaille() != 0))
    {
      uniteTraitementPendant = (UniteTraitement)((CalendrierExecutionCalculPeriodique)p_calendrierExecutionCalcul).getChronologieUnitesTraitements().dernierElement();
      if (!uniteTraitementPendant.getPeriode().coincideAvec(p_periodeUT)) {
        uniteTraitementPendant = null;
      }
    }
    return uniteTraitementPendant;
  }
  
  public Damj getDateFinProduit()
  {
    Damj dateFinProduit = null;
    if (m_uniteTraitementPendant != null)
    {
      if (m_uniteTraitementPendant.isProduitATerminerApresUT()) {
        dateFinProduit = m_uniteTraitementPendant.getArretProduitAvecRaison().recupereLendemainDateArret().veille();
      }
    }
    else if (m_calendrierExecutionCalcul.getEtatAttribution() == 3) {
      dateFinProduit = m_calendrierExecutionCalcul.getDernierJourIndemnisable();
    }
    return dateFinProduit;
  }
  
  public boolean isFinDeProduit()
  {
    boolean finDeProduit = false;
    if (m_uniteTraitementPendant != null) {
      finDeProduit = m_uniteTraitementPendant.isProduitATerminerApresUT();
    }
    return finDeProduit;
  }
  
  public Collection getCollectionSommes()
  {
    Collection collectionSommes = null;
    if (m_uniteTraitementPendant != null) {
      collectionSommes = m_uniteTraitementPendant.getCollectionSommes();
    }
    return collectionSommes;
  }
  
  public ArretProduitAvecRaison getArretProduitAvecRaison()
  {
    ArretProduitAvecRaison arretProduitAvecRaison = null;
    if (m_uniteTraitementPendant != null) {
      arretProduitAvecRaison = m_uniteTraitementPendant.getArretProduitAvecRaison();
    }
    return arretProduitAvecRaison;
  }
  
  public Quantite getReliquatDecalage()
  {
    if (m_uniteTraitementPendant != null) {
      return m_uniteTraitementPendant.getCreditDecalageEnFinUT();
    }
    return null;
  }
  
  public Quantite getReliquatDecalageDuree()
  {
    if (m_uniteTraitementPendant != null) {
      return m_uniteTraitementPendant.getCreditDecalageDureeEnFinUT();
    }
    return null;
  }
  
  public boolean isUtEstNeutralisee()
  {
    boolean utEstNeutralisee = false;
    if (m_uniteTraitementPendant != null) {
      utEstNeutralisee = m_uniteTraitementPendant.isNeutralisee();
    }
    return utEstNeutralisee;
  }
  
  public int getTypeNeutralisation()
  {
    if (!isUtEstNeutralisee()) {
      return -1;
    }
    return m_uniteTraitementPendant.getTypeNeutralisation();
  }
  
  public int getStatut()
  {
    if (m_uniteTraitementPendant != null) {
      return m_uniteTraitementPendant.getStatut();
    }
    return -1;
  }
  
  public boolean isUtEstPlafonnee()
  {
    boolean utEstPlafonnee = false;
    if (m_uniteTraitementPendant != null) {
      utEstPlafonnee = m_uniteTraitementPendant.isPlafonnee();
    }
    return utEstPlafonnee;
  }
  
  public int getEtatAttribution()
  {
    return m_calendrierExecutionCalcul.getEtatAttribution();
  }
  
  private ObjetChronoPeriodeInterProduits getPeriodeInterProduitSurUT(int p_typeDateDebutPeriodeInterProduits)
    throws CoucheLogiqueException
  {
    ObjetChronoPeriodeInterProduits objetChronoPeriodeInterProduits = null;
    Damj dateDepart = null;
    switch (p_typeDateDebutPeriodeInterProduits)
    {
    case 1: 
      dateDepart = OutilGestionPoursuite.getInstance().recupererDateAttributionOuPjpSiPoursuite(m_attribution);
      objetChronoPeriodeInterProduits = new ObjetChronoPeriodeInterProduits(dateDepart, dateDepart, p_typeDateDebutPeriodeInterProduits, m_attribution);
      
      break;
    case 2: 
      dateDepart = OutilGestionPoursuite.getInstance().recupererPremierJourExecutableNcp(m_attribution);
      if (getDateFinProduit() != null) {
        objetChronoPeriodeInterProduits = new ObjetChronoPeriodeInterProduits(dateDepart, getDateFinProduit(), p_typeDateDebutPeriodeInterProduits, m_attribution);
      } else if ((getEtatAttribution() != 4) && (getEtatAttribution() != 6) && (dateDepart.estAvantOuCoincideAvec(ContexteUT.access$000(this$0).getFin()))) {
        objetChronoPeriodeInterProduits = new ObjetChronoPeriodeInterProduits(dateDepart, ContexteUT.access$000(this$0).getFin(), p_typeDateDebutPeriodeInterProduits, m_attribution);
      }
      break;
    default: 
      throw new CoucheLogiqueException("HG_PR_CALI_L_UT_TYPE_PER_INTER_PROD_INCONNU", "Type de période inter-produit inconnu", null);
    }
    return objetChronoPeriodeInterProduits;
  }
  
  private Collection getPeriodeIndemnisationProduit(int typePeriodeIndemnisation)
    throws CoucheLogiqueException
  {
    ObjetChronoPeriodeInterProduits objetChronoPeriodeInterProduits = null;
    List listePeriodesInterProduit = new ArrayList();
    Chronologie chronoPeriodesRFPE = null;
    if (m_uniteTraitementPendant != null)
    {
      Damj pji = m_attribution.getCalendrierExecutionCalcul().getPremierJourIndemnisable();
      Damj dji = m_attribution.getCalendrierExecutionCalcul().getDernierJourIndemnisable();
      
      Damj dateDebutIndemnisationSurUT = m_uniteTraitementPendant.getDateDebut();
      if (pji.estContenueDans(m_uniteTraitementPendant.getPeriode())) {
        dateDebutIndemnisationSurUT = pji;
      }
      Damj dateFinIndemnisationSurUT = m_uniteTraitementPendant.getDateFin();
      if (dji.estContenueDans(m_uniteTraitementPendant.getPeriode())) {
        dateFinIndemnisationSurUT = dji;
      }
      Chronologie chronoPeriodesSuspensivesInterStage = m_uniteTraitementPendant.getQualificationPeriodes().getPeriodesSuspensives().copier(new FiltrePeriodeInterstage());
      
      chronoPeriodesRFPE = OutillageCalculADate.boucheLesTrous((ChronologiePeriodes)chronoPeriodesSuspensivesInterStage, ObjetChronoPeriodeInterProduits.class, dateDebutIndemnisationSurUT, dateFinIndemnisationSurUT);
      
      chronoPeriodesRFPE.iterer();
      while (chronoPeriodesRFPE.encoreSuivant())
      {
        ObjetChronoPeriode laPeriode = (ObjetChronoPeriode)chronoPeriodesRFPE.elementSuivant();
        if ((laPeriode instanceof ObjetChronoPeriodeInterProduits))
        {
          objetChronoPeriodeInterProduits = (ObjetChronoPeriodeInterProduits)laPeriode;
          objetChronoPeriodeInterProduits.setAttribution(m_attribution);
          objetChronoPeriodeInterProduits.setTypePeriode(typePeriodeIndemnisation);
          objetChronoPeriodeInterProduits.setNomProduit(m_attribution.getProduitExecution().getNom());
          objetChronoPeriodeInterProduits.setGamme(m_attribution.getGamme().getNomUnique());
          listePeriodesInterProduit.add(objetChronoPeriodeInterProduits);
        }
      }
    }
    return listePeriodesInterProduit;
  }
  
  public Quantite getMontantAuDJI()
    throws CoucheLogiqueException
  {
    Quantite montantBrutAuDJI = null;
    MontantBaseSpec montant = PostTraitementsHorsGamme.recupererMontant(m_calendrierExecutionCalcul);
    if (montant != null) {
      montantBrutAuDJI = montant.getMontantBrut();
    }
    return montantBrutAuDJI;
  }
  
  public Quantite getCreditDecalageSurUT()
  {
    if (m_uniteTraitementPendant != null) {
      return m_uniteTraitementPendant.getCreditDecalage();
    }
    return null;
  }
  
  public Quantite getCreditDecalageDureeSurUT()
  {
    return m_uniteTraitementPendant.getCreditDecalageDuree();
  }
  
  public Quantite getCreditDecalagePNDSSurUT()
  {
    return m_uniteTraitementPendant.getCreditDecalagePNDS();
  }
  
  public Quantite getQuantiteIndemnisee()
  {
    if (m_uniteTraitementPendant != null) {
      return m_uniteTraitementPendant.getQuantiteIndemnisee();
    }
    return null;
  }
  
  public int getCumulMoisAREnFinUT()
  {
    return m_uniteTraitementPendant.getConstituantsCalculActiviteReduiteEnFinUT().getCumul();
  }
  
  public BigDecimal getCumulHeuresAREnFinUT()
  {
    return m_uniteTraitementPendant.getConstituantsCalculActiviteReduiteEnFinUT().getCumulHeuresAR();
  }
  
  public int getCumulMoisAREnDebutUT()
  {
    return m_uniteTraitementPendant.getConstituantsCalculActiviteReduiteEnDebutUT().getCumul();
  }
  
  public BigDecimal getCumulHeuresAREnDebutUT()
  {
    return m_uniteTraitementPendant.getConstituantsCalculActiviteReduiteEnDebutUT().getCumulHeuresAR();
  }
  
  public int getNbMoisInactivite()
  {
    return m_uniteTraitementPendant.getConstituantsCalculActiviteReduiteEnFinUT().getNbMoisInactivite();
  }
  
  public ObjetChronoPeriodeDispositifSpec getObjetChronoPeriodeDispositifADate(Damj date)
  {
    if (m_uniteTraitementPendant != null) {
      return m_uniteTraitementPendant.getConstituantsCalculActiviteReduiteEnFinUT().getObjetChronoPeriodeDispositifADate(date);
    }
    return null;
  }
  
  public SyntheseARsurUT getSyntheseARsurUT()
  {
    return m_uniteTraitementPendant.getSyntheseARsurUT();
  }
  
  public Collection getCollectionEvenements()
  {
    if (m_uniteTraitementPendant != null) {
      return m_uniteTraitementPendant.getCollectionEvenements();
    }
    return null;
  }
  
  public ConstituantsCalculActiviteReduiteSpec getConstituantCalculActiviteReduiteEnDebutUT()
  {
    return m_uniteTraitementPendant.getConstituantsCalculActiviteReduiteEnDebutUT();
  }
  
  public ConstituantsIndemnisation getConstituantConstituantIndemnisationEndebutUT()
  {
    if (m_uniteTraitementPendant != null) {
      return m_uniteTraitementPendant.getConstituantsIndemnisationEnDebutUT();
    }
    return null;
  }
  
  public void miseAjourCumulMoisNi(int p_cumulMoisNi)
  {
    if ((m_uniteTraitementPendant != null) && (m_uniteTraitementPendant.getConstituantsCalculActiviteReduiteEnFinUT() != null)) {
      m_uniteTraitementPendant.getConstituantsCalculActiviteReduiteEnFinUT().setCumulMoisNonIndemnise(p_cumulMoisNi);
    }
  }
  
  public Damj recupererDateTraitementARSurMoisDJI()
  {
    Damj dateFinTraitementAR = null;
    if ((m_calendrierExecutionCalcul.getEtatAuDJI() != null) && (m_calendrierExecutionCalcul.getEtatAuDJI().getPeriodePECEvenementReducteur() != null)) {
      dateFinTraitementAR = m_calendrierExecutionCalcul.getEtatAuDJI().getPeriodePECEvenementReducteur().getFin();
    }
    return dateFinTraitementAR;
  }
}

/* Location:
 * Qualified Name:     ContexteUT.ElementContexteUT
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
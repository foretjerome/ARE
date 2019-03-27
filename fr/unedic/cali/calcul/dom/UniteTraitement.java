package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.UniteTraitementGen;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoNonIndemnise;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.services.ApplicativeRuntimeException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class UniteTraitement
  extends UniteTraitementGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = -4532140652955114190L;
  public static final int STATUT_INEXISTANT = -1;
  public static final int STATUT_INDETERMINE = 1;
  public static final int STATUT_PROVISOIRE = 2;
  public static final int STATUT_DEFINITIF = 3;
  public static final int STATUT_ATTENTE_JUSTIFICATIF = 4;
  public static final int STATUT_PAIEMENT_PAR_AVANCE = 5;
  public static final int STATUT_ABSENCE_AU_POINTAGE = 6;
  public static final int STATUT_PP_FORMATION = 7;
  public static final int STATUT_ATTENTE_REGUL_PANS = 8;
  public static final int STATUT_ATTENTE_REGUL_PANS_PROVISOIRE = 10;
  public static final int STATUT_ATTENTE_REGUL_PANS_PAIEMENT_PAR_AVANCE = 9;
  public static final int RAISON_STATUT_INDETERMINE = 0;
  public static final int RAISON_STATUT_POP_EXCLUE = 1;
  public static final int RAISON_STATUT_ETAT_INDEM = 2;
  public static final int RAISON_STATUT_RECUP_PP = 3;
  public static final int NEUTRALISATION_HEURE = 0;
  public static final int NEUTRALISATION_GAIN = 1;
  public static final int NEUTRALISATION_GAIN_HEURE = 2;
  public static final int NEUTRALISATION_CUMUL = 3;
  public static final int NEUTRALISATION_ATTENTE_JUSTIFICATION = 4;
  public static final int NEUTRALISATION_PRESENCE_TRAVAIL = 5;
  public static final int NEUTRALISATION_REPRISE_AR_MEME_EMPLOYEUR = 6;
  public static final int NEUTRALISATION_CUMUL_ET_HEURE = 7;
  public static final int NEUTRALISATION_ABSENCE_AU_POINTAGE = 8;
  public static final int NEUTRALISATION_SANS_OBJET = 9;
  public static final int NEUTRALISATION_DSM_INCOMPLETE = 10;
  public static final int NEUTRALISATION_SEUIL_CUMUL_MOIS_NI = 11;
  public static final int NEUTRALISATION_PASSS = 12;
  public static final int NEUTRALISATION_SPECTACLE_SEUIL = 13;
  public static final int NEUTRALISATION_ATA_ET_ACTIVITE_REPRISE = 14;
  private transient boolean attribProduitATerminerApresUT = false;
  private transient int attribNbMoisIndemniseEnDebutDUT = 0;
  private transient int attribCumulJoursIndemniseEnDebutDUT = 0;
  private transient int attribNbJoursFormationEnDebutDUT = 0;
  private transient ConstituantsCalculActiviteReduiteSpec attribConstituantsCalculActiviteReduiteEnDebutUT = null;
  private transient ConstituantsIndemnisation attribConstituantsIndemnisationEnDebutUT = null;
  private transient Decalage attribDecalageEnDebutUT = null;
  private transient QualificationPeriodes attribQualificationPeriodes = null;
  private transient Collection attribCollectionSommes = null;
  private transient Collection attribCollectionEvenements = null;
  private transient ArretProduitAvecRaison attribArretProduitAvecRaison = null;
  private transient Quantite attribQuantiteIndemnisable = null;
  private transient Quantite attribQuantiteNonIndemnisee = null;
  private transient Quantite attribQuantiteIndemnisee = null;
  private transient Quantite attribQuantiteImputeeNonIndemnisee = null;
  private transient Quantite attribQuantitePlafonnee = null;
  private transient Unite uniteParDefautQuantites = null;
  private transient BigDecimal attribFractionnementUnite = null;
  private transient boolean attribAtteintePlafondContexteMobilite = false;
  private transient boolean attribPlafonnee = false;
  private transient Quantite attribPlafond = null;
  private transient boolean attribNeutralisee = false;
  private transient int attribNeutralisation;
  private transient int attribStatut = 1;
  private transient int attribRaisonStatut = 0;
  private transient boolean attribEstAttenteJustifFormation = false;
  private transient SyntheseARsurUT attribSyntheseARsurUT = null;
  private transient Collection attribListePNDs = null;
  private transient boolean attribAbsenceRetourUL961 = false;
  private transient boolean attribTopCoherenceTravailA8A10 = true;
  private transient BigDecimal attribNbNuiteesJustifiees = null;
  private transient int attribTypeForcage;
  private transient boolean attribRepriseMemeEmployeur = false;
  private transient BigDecimal attribMontantNetRevenusActiviteReprise = null;
  private transient boolean attribPresenceDnj = false;
  private transient BigDecimal attribCumulAllocEtSalaire = null;
  private transient ChronologiePeriodes attribChronoPeriodeDecalante = null;
  private transient ChronologiePeriodes attribListePeriodesAnalyse = new ChronologiePeriodes();
  private transient BigDecimal attribArePlafond = null;
  private transient BigDecimal attribAreRestante = null;
  private transient Damj dateEpuisementDuree = null;
  private transient List<ObjetChronoNonIndemnise> chronosNonIndemnisee = new ArrayList();
  private transient Quantite qteDureeAllongementAref = null;
  
  public Quantite getQteDureeAllongementAref()
  {
    return qteDureeAllongementAref;
  }
  
  public void setQteDureeAllongementAref(Quantite qteDureeAllongementAref)
  {
    this.qteDureeAllongementAref = qteDureeAllongementAref;
  }
  
  protected UniteTraitement() {}
  
  public UniteTraitement(DomPCSpec pc)
  {
    super(pc);
  }
  
  public UniteTraitement(Periode periode)
  {
    super(periode);
  }
  
  public Collection getCollectionSommes()
  {
    if (attribCollectionSommes == null) {
      attribCollectionSommes = new ArrayList();
    }
    return attribCollectionSommes;
  }
  
  public void ajouterSomme(Somme somme)
  {
    getCollectionSommes().add(somme);
  }
  
  public void supprimerSomme(Somme somme)
  {
    getCollectionSommes().remove(somme);
  }
  
  public ConstituantsCalculActiviteReduiteSpec getConstituantsCalculActiviteReduiteEnDebutUT()
  {
    return attribConstituantsCalculActiviteReduiteEnDebutUT;
  }
  
  public ConstituantsIndemnisation getConstituantsIndemnisationEnDebutUT()
  {
    return attribConstituantsIndemnisationEnDebutUT;
  }
  
  public int getNbJoursFormationEnDebutDUT()
  {
    return attribNbJoursFormationEnDebutDUT;
  }
  
  public void setNbJoursFormationEnDebutDUT(int nbJoursFormationEnDebutDUT)
  {
    attribNbJoursFormationEnDebutDUT = nbJoursFormationEnDebutDUT;
  }
  
  public boolean isNeutralisee()
  {
    return attribNeutralisee;
  }
  
  public boolean isProduitATerminerApresUT()
  {
    return attribProduitATerminerApresUT;
  }
  
  public boolean isAbsenceRetourUL961()
  {
    return attribAbsenceRetourUL961;
  }
  
  public void setAbsenceRetourUL961(boolean absenceRetourUL961)
  {
    attribAbsenceRetourUL961 = absenceRetourUL961;
  }
  
  public boolean isTopCoherenceTravailA8A10()
  {
    return attribTopCoherenceTravailA8A10;
  }
  
  public void setTopCoherenceTravailA8A10(String topCoherenceTravailA8A10)
  {
    if (topCoherenceTravailA8A10 != null)
    {
      attribTopCoherenceTravailA8A10 = true;
      if (topCoherenceTravailA8A10.equals("N")) {
        attribTopCoherenceTravailA8A10 = false;
      }
    }
  }
  
  public void setCollectionSommes(Collection collectionSommes)
  {
    Iterator iteratorSommeCourante = null;
    Iterator iteratorSommeParametre = null;
    Somme elementSomme = null;
    
    iteratorSommeCourante = getCollectionSommes().iterator();
    while (iteratorSommeCourante.hasNext())
    {
      elementSomme = (Somme)iteratorSommeCourante.next();
      if (collectionSommes.contains(elementSomme)) {
        collectionSommes.remove(elementSomme);
      } else {
        iteratorSommeCourante.remove();
      }
    }
    iteratorSommeParametre = collectionSommes.iterator();
    while (iteratorSommeParametre.hasNext()) {
      getCollectionSommes().add(iteratorSommeParametre.next());
    }
  }
  
  public void setConstituantsCalculActiviteReduiteEnDebutUT(ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduiteEnDebutUT)
  {
    attribConstituantsCalculActiviteReduiteEnDebutUT = constituantsCalculActiviteReduiteEnDebutUT;
  }
  
  public void setConstituantsCalculActiviteReduiteEnFinUT(ConstituantsCalculActiviteReduiteSpec constituantsCalculActiviteReduiteEnFinUT)
  {
    DomManager.supprimer(super.getConstituantsCalculActiviteReduiteEnFinUT(), constituantsCalculActiviteReduiteEnFinUT);
    super.setConstituantsCalculActiviteReduiteEnFinUT(constituantsCalculActiviteReduiteEnFinUT);
  }
  
  public void setConstituantsIndemnisationEnDebutUT(ConstituantsIndemnisation constituantsIndemnisationEnDebutUT)
  {
    attribConstituantsIndemnisationEnDebutUT = constituantsIndemnisationEnDebutUT;
  }
  
  public void setConstituantsIndemnisationEnFinUT(ConstituantsIndemnisation constituantsIndemnisationEnFinUT)
  {
    DomManager.supprimer(super.getConstituantsIndemnisationEnFinUT(), constituantsIndemnisationEnFinUT);
    super.setConstituantsIndemnisationEnFinUT(constituantsIndemnisationEnFinUT);
  }
  
  public void setNeutralisee(boolean neutralisee)
  {
    attribNeutralisee = neutralisee;
  }
  
  public void setProduitATerminerApresUT(boolean produitATerminerApresUT)
  {
    attribProduitATerminerApresUT = produitATerminerApresUT;
  }
  
  public String toString()
  {
    try
    {
      Iterator iterator = null;
      
      String aRetourner = "* Periode : " + super.toString() + "\n";
      
      aRetourner = aRetourner + getQualificationPeriodes();
      if (getCollectionSommes() != null)
      {
        iterator = getCollectionSommes().iterator();
        StringBuffer buf = new StringBuffer();
        while (iterator.hasNext()) {
          buf.append("* Sommes : " + iterator.next() + "\n");
        }
        aRetourner = aRetourner + buf.toString();
      }
      aRetourner = aRetourner + "* Constituants Calcul Activite Reduite en début d'UT : " + getConstituantsCalculActiviteReduiteEnDebutUT() + "\n";
      aRetourner = aRetourner + "* Constituants Calcul Activite Reduite en fin d'UT : " + getConstituantsCalculActiviteReduiteEnFinUT() + "\n";
      aRetourner = aRetourner + "* Constituants Indemnisation en début d'UT : " + getConstituantsIndemnisationEnDebutUT() + "\n";
      aRetourner = aRetourner + "* Constituants Indemnisation en fin d'UT : " + getConstituantsIndemnisationEnFinUT() + "\n";
      return aRetourner + "* Est neutralisé : " + isNeutralisee() + "\n";
    }
    catch (Exception ex)
    {
      String messageErreur = "UniteTraitement - Erreur lors de la lecture d'un objet persistant : ";
      return messageErreur + ex.getMessage();
    }
  }
  
  public QualificationPeriodes getQualificationPeriodes()
  {
    return attribQualificationPeriodes;
  }
  
  public void setQualificationPeriodes(QualificationPeriodes periodes)
  {
    attribQualificationPeriodes = periodes;
  }
  
  public Collection getCollectionEvenementsFinQuantiteDroit()
  {
    return super.getCollectionEvenementFinQuantiteDroit();
  }
  
  public void supprimerEvenementFinQuantiteDroit(EvenementFinQuantiteDroit evFinQ)
  {
    DomManager.supprimer(evFinQ);
    super.supprimerEvenementFinQuantiteDroit(evFinQ);
  }
  
  public void setCollectionEvenementsFinQuantiteDroit(Collection collectionFinQuantiteDroit)
  {
    Iterator iteratorQuantiteCourante = null;
    Iterator iteratorQuantiteParametre = null;
    EvenementFinQuantiteDroit element = null;
    
    Collection sousListeASupprimer = new ArrayList();
    iteratorQuantiteCourante = getCollectionEvenementsFinQuantiteDroit().iterator();
    while (iteratorQuantiteCourante.hasNext())
    {
      element = (EvenementFinQuantiteDroit)iteratorQuantiteCourante.next();
      if (collectionFinQuantiteDroit.contains(element))
      {
        DomManager.supprimer(element);
        collectionFinQuantiteDroit.remove(element);
      }
      else
      {
        sousListeASupprimer.add(element);
      }
    }
    super.supprimerSousCollectionEvenementFinQuantiteDroit(sousListeASupprimer);
    
    iteratorQuantiteParametre = collectionFinQuantiteDroit.iterator();
    while (iteratorQuantiteParametre.hasNext()) {
      super.ajouterEvenementFinQuantiteDroit((EvenementFinQuantiteDroit)iteratorQuantiteParametre.next());
    }
  }
  
  public ArretProduitAvecRaison getArretProduitAvecRaison()
  {
    return attribArretProduitAvecRaison;
  }
  
  public void setArretProduitAvecRaison(ArretProduitAvecRaison arretProduitAvecRaison)
  {
    attribArretProduitAvecRaison = arretProduitAvecRaison;
  }
  
  private Decalage getDecalageEnDebutUT()
  {
    if (attribDecalageEnDebutUT == null) {
      attribDecalageEnDebutUT = new Decalage(getUniteParDefautQuantites());
    }
    return attribDecalageEnDebutUT;
  }
  
  public Decalage getDecalageEnFinUT()
  {
    if (super.getDecalageEnFinUT() == null) {
      super.setDecalageEnFinUT(new Decalage(getUniteParDefautQuantites()));
    }
    return super.getDecalageEnFinUT();
  }
  
  public void setDecalageEnDebutUT(Decalage decalageEnDebutUT)
  {
    attribDecalageEnDebutUT = decalageEnDebutUT;
  }
  
  public Quantite getQuantiteIndemnisable()
  {
    if ((attribQuantiteIndemnisable == null) && (getUniteParDefautQuantites() != null)) {
      attribQuantiteIndemnisable = new Quantite(BigDecimal.ZERO, getUniteParDefautQuantites());
    }
    return attribQuantiteIndemnisable;
  }
  
  public Quantite getQuantiteIndemnisee()
  {
    if ((attribQuantiteIndemnisee == null) && (getUniteParDefautQuantites() != null)) {
      attribQuantiteIndemnisee = new Quantite(BigDecimal.ZERO, getUniteParDefautQuantites());
    }
    return attribQuantiteIndemnisee;
  }
  
  public Quantite getQuantiteNonIndemnisee()
  {
    if ((attribQuantiteNonIndemnisee == null) && (getUniteParDefautQuantites() != null)) {
      attribQuantiteNonIndemnisee = new Quantite(BigDecimal.ZERO, getUniteParDefautQuantites());
    }
    return attribQuantiteNonIndemnisee;
  }
  
  public Quantite getPlafond()
  {
    return attribPlafond;
  }
  
  public boolean isPlafonnee()
  {
    return attribPlafonnee;
  }
  
  public void setQuantiteIndemnisable(Quantite quantiteIndemnisable)
  {
    attribQuantiteIndemnisable = quantiteIndemnisable;
  }
  
  public void setQuantiteIndemnisee(Quantite quantiteIndemnisee)
  {
    attribQuantiteIndemnisee = quantiteIndemnisee;
  }
  
  public void setQuantiteNonIndemnisee(Quantite quantiteNonIndemnisee)
  {
    attribQuantiteNonIndemnisee = quantiteNonIndemnisee;
  }
  
  public void setPlafond(Quantite plafond)
  {
    attribPlafond = plafond;
    setPlafonnee(true);
  }
  
  public void setPlafonnee(boolean plafonnee)
  {
    attribPlafonnee = plafonnee;
  }
  
  public Unite getUniteParDefautQuantites()
  {
    return uniteParDefautQuantites;
  }
  
  public void setUniteParDefautQuantites(Unite unite)
  {
    uniteParDefautQuantites = unite;
  }
  
  public Collection getCollectionEvenements()
  {
    if (attribCollectionEvenements == null) {
      attribCollectionEvenements = new ArrayList();
    }
    return attribCollectionEvenements;
  }
  
  public void ajouterEvenement(EvenementCalculSpec ev)
  {
    getCollectionEvenements().add(ev);
  }
  
  public void supprimerEvenement(EvenementCalculSpec ev)
  {
    getCollectionEvenements().remove(ev);
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getConstituantsCalculActiviteReduiteEnFinUT());
    DomManager.persisterEnProfondeur(super.getConstituantsIndemnisationEnFinUT());
    DomManager.persisterEnProfondeur(super.getDecalageEnFinUT());
    DomManager.persisterEnProfondeur(super.getCollectionEvenementFinQuantiteDroit());
  }
  
  public void setDateDebut(Damj dateDebut)
  {
    Damj dateFin = getDateFin();
    if (dateDebut.estApres(dateFin)) {
      dateFin = dateDebut;
    }
    setPeriode(new Periode(dateDebut, dateFin));
  }
  
  public void setDateFin(Damj dateFin)
  {
    Damj dateDebut = getDateDebut();
    if (dateFin.estAvant(dateDebut)) {
      dateDebut = dateFin;
    }
    setPeriode(new Periode(dateDebut, dateFin));
  }
  
  public void setCollectionEvenements(Collection collectionEvenement)
  {
    Iterator iteratorEvenementCourant = null;
    Iterator iteratorEvenementParametre = null;
    EvenementCalculSpec element = null;
    
    iteratorEvenementCourant = getCollectionEvenements().iterator();
    while (iteratorEvenementCourant.hasNext())
    {
      element = (EvenementCalculSpec)iteratorEvenementCourant.next();
      if (collectionEvenement.contains(element)) {
        collectionEvenement.remove(element);
      } else {
        iteratorEvenementCourant.remove();
      }
    }
    iteratorEvenementParametre = collectionEvenement.iterator();
    while (iteratorEvenementParametre.hasNext()) {
      getCollectionEvenements().add(iteratorEvenementParametre.next());
    }
  }
  
  public void ajouterEvenements(Collection collectionEvenement)
  {
    getCollectionEvenements().addAll(collectionEvenement);
  }
  
  public void ajouterSommes(Collection collectionSomme)
  {
    getCollectionSommes().addAll(collectionSomme);
  }
  
  public void ajouterEvenementsFinQuantiteDroit(Collection collectionEvFinQ)
  {
    for (Iterator it = collectionEvFinQ.iterator(); it.hasNext();) {
      super.ajouterEvenementFinQuantiteDroit((EvenementFinQuantiteDroit)it.next());
    }
  }
  
  public int getStatut()
  {
    return attribStatut;
  }
  
  public void setStatut(int statut)
  {
    attribStatut = statut;
  }
  
  public int getTypeNeutralisation()
  {
    return attribNeutralisation;
  }
  
  public void setTypeNeutralisation(int neutralisation)
  {
    attribNeutralisation = neutralisation;
  }
  
  public Quantite getCreditDecalagePNDS()
  {
    Quantite retour = null;
    if (getDecalageEnDebutUT() != null) {
      retour = getDecalageEnDebutUT().getCreditDecalagePNDS();
    }
    return retour;
  }
  
  public void setCreditDecalagePNDS(Quantite quantiteDecalagePNDS)
  {
    getDecalageEnDebutUT().setCreditDecalagePNDS(quantiteDecalagePNDS);
  }
  
  public Quantite getCreditDecalage()
  {
    Quantite retour = null;
    if (getDecalageEnDebutUT() != null) {
      retour = getDecalageEnDebutUT().getCreditDecalage();
    }
    return retour;
  }
  
  public Quantite getCreditDecalageEnFinUT()
  {
    Quantite retour = null;
    if (getDecalageEnFinUT() != null) {
      retour = getDecalageEnFinUT().getCreditDecalage();
    }
    return retour;
  }
  
  public void setCreditDecalage(Quantite quantiteDecalage)
  {
    getDecalageEnDebutUT().setCreditDecalage(quantiteDecalage);
  }
  
  public void setCreditDecalageEnFinUT(Quantite quantiteDecalage)
  {
    getDecalageEnFinUT().setCreditDecalage(quantiteDecalage);
  }
  
  public Quantite getCreditDecalageDuree()
  {
    Quantite retour = null;
    if (getDecalageEnDebutUT() != null) {
      retour = getDecalageEnDebutUT().getCreditDecalageDuree();
    }
    return retour;
  }
  
  public Quantite getCreditDecalageDureeEnFinUT()
  {
    Quantite retour = null;
    if (getDecalageEnFinUT() != null) {
      retour = getDecalageEnFinUT().getCreditDecalageDuree();
    }
    return retour;
  }
  
  public void setCreditDecalageDuree(Quantite decalageDuree)
  {
    getDecalageEnDebutUT().setCreditDecalageDuree(decalageDuree);
  }
  
  public void setCreditDecalageDureeEnFinUT(Quantite decalageDuree)
  {
    getDecalageEnFinUT().setCreditDecalageDuree(decalageDuree);
  }
  
  public Quantite getCreditDecalageSanctions()
  {
    Quantite retour = null;
    if (getDecalageEnDebutUT() != null) {
      retour = getDecalageEnDebutUT().getCreditDecalageSanctions();
    }
    return retour;
  }
  
  public void setCreditDecalageSanctions(Quantite decalageSanctions)
  {
    getDecalageEnDebutUT().setCreditDecalageSanctions(decalageSanctions);
  }
  
  public void setFractionnementUnite(BigDecimal fractionnementUnite)
  {
    attribFractionnementUnite = fractionnementUnite;
  }
  
  public BigDecimal getFractionnementUnite()
  {
    if (attribFractionnementUnite == null) {
      attribFractionnementUnite = BigDecimal.ONE;
    }
    return attribFractionnementUnite;
  }
  
  public SyntheseARsurUT getSyntheseARsurUT()
  {
    if (attribSyntheseARsurUT == null) {
      attribSyntheseARsurUT = new SyntheseARsurUT();
    }
    return attribSyntheseARsurUT;
  }
  
  public void setSyntheseARsurUT(SyntheseARsurUT syntheseARsurUT)
  {
    attribSyntheseARsurUT = syntheseARsurUT;
  }
  
  public int getRaisonStatut()
  {
    return attribRaisonStatut;
  }
  
  public void setRaisonStatut(int raisonStatut)
  {
    attribRaisonStatut = raisonStatut;
  }
  
  public Collection getListePNDs()
  {
    return attribListePNDs;
  }
  
  public void setListePNDs(Collection listePNDs)
  {
    attribListePNDs = listePNDs;
  }
  
  public void copieElements(ObjetMetierSpec paramCopie)
  {
    UniteTraitement copie = (UniteTraitement)paramCopie;
    copie.setDateDebut(getDateDebut());
    copie.setDateFin(getDateFin());
    
    copie.setEstFigee(isEstFigee());
    copie.setCumulJoursIndemnise(getCumulJoursIndemnise());
    copie.setEstCumulJoursIndemnise(isEstCumulJoursIndemnise());
    
    attribProduitATerminerApresUT = isProduitATerminerApresUT();
    attribNeutralisee = isNeutralisee();
    attribPlafonnee = isPlafonnee();
    attribAbsenceRetourUL961 = isAbsenceRetourUL961();
    if (getConstituantsCalculActiviteReduiteEnDebutUT() != null) {
      attribConstituantsCalculActiviteReduiteEnDebutUT = ((ConstituantsCalculActiviteReduiteSpec)getConstituantsCalculActiviteReduiteEnDebutUT().copie());
    }
    if (getConstituantsCalculActiviteReduiteEnFinUT() != null) {
      copie.setConstituantsCalculActiviteReduiteEnFinUT((ConstituantsCalculActiviteReduiteSpec)getConstituantsCalculActiviteReduiteEnFinUT().copie());
    }
    if (getConstituantsIndemnisationEnDebutUT() != null) {
      attribConstituantsIndemnisationEnDebutUT = ((ConstituantsIndemnisation)getConstituantsIndemnisationEnDebutUT().copie());
    }
    if (getConstituantsIndemnisationEnFinUT() != null) {
      copie.setConstituantsIndemnisationEnFinUT((ConstituantsIndemnisation)getConstituantsIndemnisationEnFinUT().copie());
    }
    if (getQualificationPeriodes() != null) {
      attribQualificationPeriodes = ((QualificationPeriodes)getQualificationPeriodes().copie());
    }
    if (getArretProduitAvecRaison() != null) {
      attribArretProduitAvecRaison = ((ArretProduitAvecRaison)getArretProduitAvecRaison().copie());
    }
    if (getDecalageEnDebutUT() != null) {
      attribDecalageEnDebutUT = ((Decalage)getDecalageEnDebutUT().copie());
    }
    if (getDecalageEnFinUT() != null) {
      copie.setDecalageEnFinUT((Decalage)getDecalageEnFinUT().copie());
    }
    attribQuantiteIndemnisable = getQuantiteIndemnisable();
    attribQuantiteNonIndemnisee = getQuantiteNonIndemnisee();
    attribQuantiteIndemnisee = getQuantiteIndemnisee();
    uniteParDefautQuantites = getUniteParDefautQuantites();
    attribFractionnementUnite = getFractionnementUnite();
    attribPlafond = getPlafond();
    attribNeutralisation = getTypeNeutralisation();
    attribStatut = getStatut();
    attribSyntheseARsurUT = getSyntheseARsurUT();
    attribRaisonStatut = getRaisonStatut();
    attribPresenceDnj = isPresenceDnj();
    attribCumulAllocEtSalaire = getCumulAllocEtSalaire();
    attribQuantitePlafonnee = getQuantitePlafonnee();
    
    Iterator iterator = getCollectionSommes().iterator();
    attribCollectionSommes = new ArrayList();
    while (iterator.hasNext())
    {
      ObjetMetierSpec element = (ObjetMetierSpec)iterator.next();
      if (element != null) {
        attribCollectionSommes.add(element.copie());
      }
    }
    iterator = getCollectionEvenements().iterator();
    attribCollectionEvenements = new ArrayList();
    while (iterator.hasNext())
    {
      ObjetMetierSpec element = (ObjetMetierSpec)iterator.next();
      if (element != null) {
        attribCollectionEvenements.add(element.copie());
      }
    }
    copie.remplacerCollectionEvenementFinQuantiteDroit(getCollectionEvenementFinQuantiteDroit());
    attribListePNDs = new ArrayList();
    if (getListePNDs() != null)
    {
      iterator = getListePNDs().iterator();
      while (iterator.hasNext())
      {
        ObjetMetierSpec element = (ObjetMetierSpec)iterator.next();
        if (element != null) {
          attribListePNDs.add(element.copie());
        }
      }
    }
  }
  
  public BigDecimal getNbNuiteesJustifiees()
  {
    return attribNbNuiteesJustifiees;
  }
  
  public void setNbNuiteesJustifiees(BigDecimal nbNuiteesJustifiees)
  {
    attribNbNuiteesJustifiees = nbNuiteesJustifiees;
  }
  
  public void setTypeForcage(int typeForcage)
  {
    attribTypeForcage = typeForcage;
  }
  
  public int getTypeForcage()
  {
    return attribTypeForcage;
  }
  
  public boolean isRepriseMemeEmployeur()
  {
    return attribRepriseMemeEmployeur;
  }
  
  public void setRepriseMemeEmployeur(boolean repriseMemeEmployeur)
  {
    attribRepriseMemeEmployeur = repriseMemeEmployeur;
  }
  
  public boolean getEstAttenteJustifFormation()
  {
    return attribEstAttenteJustifFormation;
  }
  
  public void setEstAttenteJustifFormation(boolean estAttenteJustifFormation)
  {
    attribEstAttenteJustifFormation = estAttenteJustifFormation;
  }
  
  public Quantite getQuantiteImputeeNonIndemnisee()
  {
    if ((attribQuantiteImputeeNonIndemnisee == null) && (getUniteParDefautQuantites() != null)) {
      attribQuantiteImputeeNonIndemnisee = new Quantite(BigDecimal.ZERO, getUniteParDefautQuantites());
    }
    return attribQuantiteImputeeNonIndemnisee;
  }
  
  public void setQuantiteImputeeNonIndemnisee(Quantite quantiteImputeeNonIndemnisee)
  {
    attribQuantiteImputeeNonIndemnisee = quantiteImputeeNonIndemnisee;
  }
  
  public void setEstFigee(boolean estFigee)
  {
    if ((isEstFigee()) && (!estFigee)) {
      throw new ApplicativeRuntimeException("HG_PR_CALI_L_CALCUL_DJA_INCOHERENT_UT_FIGEE", "La date de fin de l'UT figée n'est pas cohérente, elle ne correspond pas au DJA", null);
    }
    super.setEstFigee(estFigee);
  }
  
  public int getCumulJoursIndemniseEnDebutDUT()
  {
    return attribCumulJoursIndemniseEnDebutDUT;
  }
  
  public void setCumulJoursIndemniseEnDebutDUT(int cumulJoursIndemniseEnDebutDUT)
  {
    attribCumulJoursIndemniseEnDebutDUT = cumulJoursIndemniseEnDebutDUT;
  }
  
  public int getNbMoisIndemniseEnDebutDUT()
  {
    return attribNbMoisIndemniseEnDebutDUT;
  }
  
  public void setNbMoisIndemniseEnDebutDUT(int nbMoisIndemniseEnDebutDUT)
  {
    attribNbMoisIndemniseEnDebutDUT = nbMoisIndemniseEnDebutDUT;
  }
  
  public BigDecimal getMontantNetRevenusActiviteReprise()
  {
    return attribMontantNetRevenusActiviteReprise;
  }
  
  public void setMontantNetRevenusActiviteReprise(BigDecimal montantNetRevenusActiviteReprise)
  {
    attribMontantNetRevenusActiviteReprise = montantNetRevenusActiviteReprise;
  }
  
  public boolean isPresenceDnj()
  {
    return attribPresenceDnj;
  }
  
  public void setPresenceDnj(boolean presenceDnj)
  {
    attribPresenceDnj = presenceDnj;
  }
  
  public boolean isAtteintePlafondContexteMobilite()
  {
    return attribAtteintePlafondContexteMobilite;
  }
  
  public void setAtteintePlafondContexteMobilite(boolean atteintePlafondContexteMobilite)
  {
    attribAtteintePlafondContexteMobilite = atteintePlafondContexteMobilite;
  }
  
  public void setQuantitePlafonnee(Quantite quantitePlafonnee)
  {
    attribQuantitePlafonnee = quantitePlafonnee;
  }
  
  public Quantite getQuantitePlafonnee()
  {
    if ((attribQuantitePlafonnee == null) && (getUniteParDefautQuantites() != null)) {
      attribQuantitePlafonnee = new Quantite(BigDecimal.ZERO, getUniteParDefautQuantites());
    }
    return attribQuantitePlafonnee;
  }
  
  public BigDecimal getCumulAllocEtSalaire()
  {
    if (attribCumulAllocEtSalaire == null) {
      attribCumulAllocEtSalaire = BigDecimal.ZERO;
    }
    return attribCumulAllocEtSalaire;
  }
  
  public void setCumulAllocEtSalaire(BigDecimal cumulAllocEtSalaire)
  {
    attribCumulAllocEtSalaire = cumulAllocEtSalaire;
  }
  
  public ChronologiePeriodes getChronoPeriodeDecalante()
  {
    if (attribChronoPeriodeDecalante == null)
    {
      attribChronoPeriodeDecalante = new ChronologiePeriodes();
      return attribChronoPeriodeDecalante;
    }
    return attribChronoPeriodeDecalante;
  }
  
  public void setChronoPeriodeDecalante(ChronologiePeriodes chronoPeriodeDecalante)
  {
    attribChronoPeriodeDecalante = chronoPeriodeDecalante;
  }
  
  public ChronologiePeriodes getListePeriodesAnalyse()
  {
    return attribListePeriodesAnalyse;
  }
  
  public void setListePeriodesAnalyse(ChronologiePeriodes listePeriodesAnalyse)
  {
    attribListePeriodesAnalyse = listePeriodesAnalyse;
  }
  
  public void ajouterPeriodesAnalyse(PeriodeAnalyseSpec periodeAnalyse)
  {
    getListePeriodesAnalyse().ajouter(periodeAnalyse);
  }
  
  public BigDecimal getArePlafond()
  {
    return attribArePlafond;
  }
  
  public void setArePlafond(BigDecimal arePlafond)
  {
    attribArePlafond = arePlafond;
  }
  
  public BigDecimal getAreRestante()
  {
    return attribAreRestante;
  }
  
  public void setAreRestante(BigDecimal areRestante)
  {
    attribAreRestante = areRestante;
  }
  
  public Damj getDateEpuisementDuree()
  {
    return dateEpuisementDuree;
  }
  
  public void setDateEpuisementDuree(Damj dateEpuisementDuree)
  {
    this.dateEpuisementDuree = dateEpuisementDuree;
  }
  
  public void setDecalageEnFinUT(Decalage decalageEnFinUT)
  {
    DomManager.supprimer(super.getDecalageEnFinUT(), decalageEnFinUT);
    super.setDecalageEnFinUT(decalageEnFinUT);
  }
  
  public void remplacerCollectionEvenementFinQuantiteDroit(Collection collectionACopier)
  {
    for (Iterator i = super.getCollectionEvenementFinQuantiteDroit().iterator(); i.hasNext();)
    {
      EvenementFinQuantiteDroit objet = (EvenementFinQuantiteDroit)i.next();
      DomManager.supprimer(objet);
    }
    super.remplacerCollectionEvenementFinQuantiteDroit(collectionACopier);
  }
  
  public void setChronosNonIndemnisee(List<ObjetChronoNonIndemnise> chronosNonIndemnisable)
  {
    chronosNonIndemnisee = chronosNonIndemnisable;
  }
  
  public void ajouterChronoNonIndemnisee(ObjetChronoNonIndemnise chronoNonIndemnisable)
  {
    chronosNonIndemnisee.add(chronoNonIndemnisable);
  }
  
  public List<ObjetChronoNonIndemnise> getChronosNonIndemnisee()
  {
    return chronosNonIndemnisee;
  }
}

/* Location:
 * Qualified Name:     UniteTraitement
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
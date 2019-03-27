package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.d12i.dom.DonneesNPDE;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.echange.Decision;
import fr.unedic.cali.dom.gen.DemandeAbstraiteGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourNumeroGamme;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.UtilitairesClasse;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public abstract class DemandeAbstraite
  extends DemandeAbstraiteGen
  implements DemandeSpec, ObjetPersistantSpec
{
  private static final long serialVersionUID = -5242218861185009967L;
  private transient IndividuSpec demandeur = null;
  private transient boolean estValide = true;
  private transient boolean estReexecutee = false;
  private transient boolean liquideeEnEtat = false;
  private transient boolean notifieeCourrier = false;
  private transient String codeMotifEchecPourSigma;
  private transient boolean estFormulaireCharge;
  private transient String codeMotifEchecPourSigmaSauvegarde;
  private transient boolean estDemandeLiquidee = false;
  private transient boolean topAppelContribution = false;
  private transient Decision decisionEchange = null;
  private transient DemandeSpec demandeEnEntreeService = null;
  private boolean liquidationManuelleEnTP = false;
  private String erreurNPDE = "cette méthode devra être redéfinie sur Demande niveau gamme quand NPDE ouvert à autre gamme";
  private transient Hashtable alertesNonBloquantes;
  private transient String codeAttente;
  private boolean decisionAuto = false;
  
  protected DemandeAbstraite() {}
  
  public DemandeAbstraite(DomPCSpec pc)
  {
    super(pc);
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    DemandeAbstraite copie = (DemandeAbstraite)pcopie;
    
    copie.setValide(estValide());
    copie.setLiquideeEnEtat(estLiquideeEnEtat());
    copie.setNotifieeCourrier(estNotifieeCourrier());
    copie.setCodeMotifEchecPourSigma(getCodeMotifEchecPourSigma());
    copie.setDemandeur(getDemandeur());
    copie.setTopAppelContribution(getTopAppelContribution());
    copie.setEstFormulaireCharge(estFormulaireCharge());
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public Damj getDateDepot()
  {
    if (getFormulaire() != null) {
      return getFormulaire().getDateDepot();
    }
    return null;
  }
  
  public Damj getDateFinAbonnement()
  {
    Damj dateFinAbonnement = getDateExamen();
    Damj dateAttribution = getDateAttribution();
    if ((dateAttribution != null) && (dateFinAbonnement != null)) {
      dateFinAbonnement = determinerDateFinAbonnementSurAttribution(dateFinAbonnement, dateAttribution);
    } else {
      dateFinAbonnement = getDateRecherche();
    }
    return dateFinAbonnement;
  }
  
  protected Damj determinerDateFinAbonnementSurAttribution(Damj dateExamen, Damj dateAttribution)
  {
    return Damj.max(dateExamen, dateAttribution);
  }
  
  public boolean estDecisionnee()
  {
    boolean demandeDecisionnee = false;
    Iterator<?> iterateurDossiersExamen = getListeDossiersExamen().iterator();
    while (iterateurDossiersExamen.hasNext())
    {
      DossierExamenSpec dossierExamen = (DossierExamenSpec)iterateurDossiersExamen.next();
      if ((dossierExamen instanceof DecisionSpec))
      {
        demandeDecisionnee = true;
      }
      else
      {
        demandeDecisionnee = false;
        break;
      }
    }
    return demandeDecisionnee;
  }
  
  public boolean estAdmissibleReexecution()
  {
    return estDecisionnee();
  }
  
  public boolean estValide()
  {
    return estValide;
  }
  
  public void setValide(boolean pestValide)
  {
    estValide = pestValide;
  }
  
  public boolean estEnReExamen()
  {
    return (!getListeMotifsReexamen().isEmpty()) || (getMotifReexamenPrincipal() != null);
  }
  
  public boolean estMigree()
  {
    return (getMigree() == 1) || (getMigree() == 2);
  }
  
  public boolean estMigreeEnSimplifiee()
  {
    return getMigree() == 2;
  }
  
  public boolean estReexaminable()
  {
    return !estNeutraliseeLiquidation();
  }
  
  public boolean estReexecutable()
  {
    return !estNeutraliseeCalcul();
  }
  
  public void definirDateValidation(Damj dateTraitement)
  {
    if (getDatePremiereValidation() == null)
    {
      setDatePremiereValidation(dateTraitement);
      setDateDerniereValidation(dateTraitement);
    }
    else
    {
      setDateDerniereValidation(dateTraitement);
    }
  }
  
  public boolean estReexecutee()
  {
    return estReexecutee;
  }
  
  public void setReexecutee(boolean estReexecutee)
  {
    this.estReexecutee = estReexecutee;
  }
  
  public Damj getDateDeclenchementExamen()
  {
    return getEvenementReferenceExamen().getDateDeclenchementExamen(this);
  }
  
  public Damj getDateExamen()
  {
    boolean estDemandeNonEnReexamen = (!estEnReExamen()) || (estDemandeLiquidee());
    boolean estDemandeDecisionnee = (estDecisionnee()) || (estDemandeLiquidee());
    if ((getEvenementReferenceExamen() != null) && (estDemandeNonEnReexamen) && (estDemandeDecisionnee)) {
      return getEvenementReferenceExamen().getDateExamen(this);
    }
    return null;
  }
  
  public boolean estLiquideeEnEtat()
  {
    return liquideeEnEtat;
  }
  
  public boolean estLiquideeAutomatiquement()
  {
    return false;
  }
  
  public boolean estNotifieeCourrier()
  {
    return notifieeCourrier;
  }
  
  public void setLiquideeEnEtat(boolean liquideeEnEtat)
  {
    this.liquideeEnEtat = liquideeEnEtat;
  }
  
  public void setNotifieeCourrier(boolean notifieeCourrier)
  {
    this.notifieeCourrier = notifieeCourrier;
  }
  
  public Damj getDateEvenement()
  {
    return getDateExamen();
  }
  
  public void setDateEvenement(Damj dateEvenement)
  {
    getEvenementReferenceExamen().setDateEvenement(dateEvenement);
  }
  
  public boolean estElementDebut()
  {
    return true;
  }
  
  public boolean estStrictementType(Class type)
  {
    return getClass().getName().equalsIgnoreCase(type.getName());
  }
  
  public boolean estType(Class type)
  {
    return type.isAssignableFrom(getClass());
  }
  
  public Damj getDateDebut()
  {
    return getDateEvenement();
  }
  
  public Damj getDateEffet()
  {
    return getDateEvenement();
  }
  
  public Damj getDateFin()
  {
    return getDateEvenement();
  }
  
  public int getPriorite()
  {
    return 0;
  }
  
  public int getTypeDateEffet()
  {
    return 0;
  }
  
  public String getTypeElement()
  {
    return UtilitairesClasse.getType(this);
  }
  
  public void setPriorite(int priorite) {}
  
  public String getCodeMotifEchecPourSigma()
  {
    if (codeMotifEchecPourSigma != null) {
      return codeMotifEchecPourSigma;
    }
    return "0";
  }
  
  public void setCodeMotifEchecPourSigma(String codeMotifEchecPourSigma)
  {
    this.codeMotifEchecPourSigma = codeMotifEchecPourSigma;
  }
  
  public boolean estFormulaireCharge()
  {
    return estFormulaireCharge;
  }
  
  public void setEstFormulaireCharge(boolean estFormulaireCharge)
  {
    this.estFormulaireCharge = estFormulaireCharge;
  }
  
  public Damj getDateRecherche()
  {
    Damj dateRecherche = getDateExamen();
    if (dateRecherche == null) {
      dateRecherche = getDateDeclenchementExamen();
    }
    return dateRecherche;
  }
  
  public String getCodeMotifEchecPourSigmaSauvegarde()
  {
    return codeMotifEchecPourSigmaSauvegarde;
  }
  
  public void setCodeMotifEchecPourSigmaSauvegarde(String codeMotifEchecPourSigmaAvantReexamen)
  {
    codeMotifEchecPourSigmaSauvegarde = codeMotifEchecPourSigmaAvantReexamen;
  }
  
  public boolean estDemandeLiquidee()
  {
    return estDemandeLiquidee;
  }
  
  public void setDemandeLiquidee(boolean demandeLiquidee)
  {
    estDemandeLiquidee = demandeLiquidee;
  }
  
  public Hashtable getAlertesNonBloquantes()
  {
    if (alertesNonBloquantes == null) {
      alertesNonBloquantes = new Hashtable();
    }
    return alertesNonBloquantes;
  }
  
  public void setAlertesNonBloquantes(Hashtable alertesNonBloquantes)
  {
    this.alertesNonBloquantes = alertesNonBloquantes;
  }
  
  public boolean estReexaminableAutomatiquement()
  {
    return !estMigree();
  }
  
  public IndividuSpec getDemandeur()
  {
    return demandeur;
  }
  
  public void setDemandeur(IndividuSpec demandeur)
  {
    this.demandeur = demandeur;
  }
  
  public boolean estCategorieParticuliere()
  {
    return false;
  }
  
  public int compareTo(DemandeSpec demande)
  {
    Damj dateDeclenchementExamen1 = getDateDeclenchementExamen();
    Damj dateDeclenchementExamen2 = demande.getDateDeclenchementExamen();
    if ((dateDeclenchementExamen1 == null) || (dateDeclenchementExamen2 == null)) {
      return 0;
    }
    int comparaison = dateDeclenchementExamen1.compareTo(dateDeclenchementExamen2);
    if (comparaison == 0) {
      comparaison = compareToPrioriteGamme(this, demande);
    }
    if (comparaison == 0) {
      comparaison = compareToPrioriteEre(this, demande);
    }
    if (comparaison == 0) {
      comparaison = compareToDateDepot(this, demande);
    }
    if (comparaison == 0) {
      comparaison = compareToDateCreationDal(this, demande);
    }
    if (comparaison == 0) {
      comparaison = compareToReferenceExterne(this, demande);
    }
    return comparaison;
  }
  
  private int compareToPrioriteGamme(DemandeSpec demande1, DemandeSpec demande2)
  {
    Integer prioriteGamme1 = Integer.valueOf(demande1.getGamme().getPriorite());
    Integer prioriteGamme2 = Integer.valueOf(demande2.getGamme().getPriorite());
    return prioriteGamme2.compareTo(prioriteGamme1);
  }
  
  private int compareToPrioriteEre(DemandeSpec demande1, DemandeSpec demande2)
  {
    Integer prioriteERE1 = Integer.valueOf(demande1.getEvenementReferenceExamen().getPriorite());
    Integer prioriteERE2 = Integer.valueOf(demande2.getEvenementReferenceExamen().getPriorite());
    return prioriteERE2.compareTo(prioriteERE1);
  }
  
  private int compareToReferenceExterne(DemandeSpec demande1, DemandeSpec demande2)
  {
    int comparaison = 0;
    String refExt1 = demande1.getFormulaire().getReferenceExterne();
    String refExt2 = demande2.getFormulaire().getReferenceExterne();
    if ((refExt1 != null) && (refExt2 != null)) {
      comparaison = refExt1.compareTo(refExt2);
    }
    return comparaison;
  }
  
  private int compareToDateCreationDal(DemandeSpec demande1, DemandeSpec demande2)
  {
    int comparaison = 0;
    Damj dateCreationDal1 = demande1.getFormulaire().getDateCreationDal();
    Damj dateCreationDal2 = demande2.getFormulaire().getDateCreationDal();
    if ((dateCreationDal1 != null) && (dateCreationDal2 != null)) {
      comparaison = dateCreationDal1.compareTo(dateCreationDal2);
    }
    return comparaison;
  }
  
  private int compareToDateDepot(DemandeSpec demande1, DemandeSpec demande2)
  {
    int comparaison = 0;
    Damj dateDepot1 = demande1.getDateDepot();
    Damj dateDepot2 = demande2.getDateDepot();
    if ((dateDepot1 != null) && (dateDepot2 != null)) {
      comparaison = dateDepot1.compareTo(dateDepot2);
    }
    return comparaison;
  }
  
  public boolean estUneDemandePrestation()
  {
    return true;
  }
  
  public void setTopAppelContribution(boolean topAppelContribution)
  {
    this.topAppelContribution = topAppelContribution;
  }
  
  public boolean getTopAppelContribution()
  {
    return topAppelContribution;
  }
  
  public Chronologie getChronologieDemandesSansCourante()
  {
    Chronologie chrono = getDemandeur().getChronoDemandesNonTriees();
    chrono.supprimer(this);
    return chrono;
  }
  
  public Chronologie getChronologieDemandesAssuranceSansCourante()
  {
    Chronologie chrono = getChronologieDemandesSansCourante();
    return chrono.copier(new FiltreDemandePourNumeroGamme(1));
  }
  
  public Chronologie getChronologieDemandesSolidariteSansCourante()
  {
    Chronologie chrono = getChronologieDemandesSansCourante();
    return chrono.copier(new FiltreDemandePourNumeroGamme(2));
  }
  
  public boolean estLiquidableOuReexecutable()
  {
    return true;
  }
  
  public Decision getDecisionEchange()
  {
    return decisionEchange;
  }
  
  public void setDecisionEchange(Decision decisionEchange)
  {
    this.decisionEchange = decisionEchange;
  }
  
  public DemandeSpec getDemandeEnEntreeService()
  {
    return demandeEnEntreeService;
  }
  
  public void setDemandeEnEntreeService(DemandeSpec demandeEnEntreeService)
  {
    this.demandeEnEntreeService = demandeEnEntreeService;
  }
  
  public String getCodeAttente()
  {
    return codeAttente;
  }
  
  public void setCodeAttente(String codeAttente)
  {
    this.codeAttente = codeAttente;
  }
  
  public boolean isLiquidationManuelleEnTP()
  {
    return liquidationManuelleEnTP;
  }
  
  public void setLiquidationManuelleEnTP(boolean liquidationManuelleEnTP)
  {
    this.liquidationManuelleEnTP = liquidationManuelleEnTP;
  }
  
  public boolean leverAlertePopup()
  {
    return liquidationManuelleEnTP;
  }
  
  public void marquerGraphePersistant() {}
  
  public DonneesNPDE getDonneesNPDE()
  {
    return null;
  }
  
  public DonneesSortieNPDESpec getDonneesSortieNPDE()
  {
    throw new UnsupportedOperationException(erreurNPDE);
  }
  
  public String getIdentifiantObjetMetier()
  {
    throw new UnsupportedOperationException(erreurNPDE);
  }
  
  public boolean isDemandeNPDE()
  {
    return false;
  }
  
  public boolean isDecisionAuto()
  {
    return decisionAuto;
  }
  
  public void setDecisionAuto(boolean decisionAuto)
  {
    this.decisionAuto = decisionAuto;
  }
}

/* Location:
 * Qualified Name:     DemandeAbstraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
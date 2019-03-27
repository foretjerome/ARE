package fr.unedic.cali.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.calcul.pbjc.dom.DispositifNcp;
import fr.unedic.cali.calcul.pbjc.dom.DroitPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.EnquetePbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PrimePbjcNcp;
import fr.unedic.cali.dom.gen.IndividuImplPersistantGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.OutilChronologie;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.NonConformiteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IndividuImplPersistant
  extends IndividuImplPersistantGen
  implements ObjetPersistantSpec
{
  private transient boolean investigationFraude;
  private static final long serialVersionUID = -2539014096454146859L;
  
  public IndividuImplPersistant()
  {
    super.setEstModifiable(true);
    super.setEstCharge(false);
  }
  
  public IndividuImplPersistant(DomPCSpec pc)
  {
    super(pc);
    
    super.setEstModifiable(true);
    super.setEstCharge(false);
  }
  
  public IndividuImplPersistant(IndividuIdSpec individuIdSpec)
  {
    super(individuIdSpec);
    
    super.setEstModifiable(true);
    super.setEstCharge(false);
  }
  
  public Collection getListePeriodesActiviteSalariee()
  {
    return getCollectionActiviteSalarie();
  }
  
  public Collection getDemandes()
  {
    return getCollectionDemande();
  }
  
  public IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException
  {
    IndividuImplPersistant individuCali = DomManager.getIndividuCali();
    ChronologiePeriodes chronoPbjcs = DomManager.getChronologiePbjcNcp();
    ChronologiePeriodes chronoAides = DomManager.getChronologieAideNcp();
    Collection collectionPrimes = DomManager.getCollectionPrimesPbjcNcp();
    List listeDroit = DomManager.getListDroitsPbjcNcp();
    IndividuPbjcNcp individuPbjcNcp = DomManager.getIndividuPbjcNcp();
    List listeEnquete = DomManager.getListeEnquetesPbjcNcp();
    Collection<DispositifNcp> collectionDiposisitif = DomManager.getCollectionDispositifNcp();
    if (individuCali == null)
    {
      super.setEstCharge(true);
      super.setEstDejaCree(false);
      return this;
    }
    individuCali.setEstCharge(true);
    individuCali.setEstDejaCree(true);
    individuCali.setChronoPbjc(chronoPbjcs);
    individuCali.setCollectionPrimes(collectionPrimes);
    individuCali.setListDroitsPbjcsNcp(listeDroit);
    individuCali.setIndividuPbjcNcp(individuPbjcNcp);
    individuCali.setListEnquetesPbjcNcp(listeEnquete);
    individuCali.setChronoAide(chronoAides);
    individuCali.setCollectionDispositifNcp(collectionDiposisitif);
    return individuCali;
  }
  
  public void ajouterDemande(DemandeSpec demande)
  {
    if (demande != null)
    {
      demande.setDemandeur(getIndividuId().getIndividu());
      try
      {
        getChronoDemandesPrive().ajouter(demande);
        getChronoDemandesNonTrieesPrive().ajouter(demande);
      }
      catch (NonConformiteException e)
      {
        if (Log.isTraceActive(IndividuImplPersistant.class, Niveau.DEBUG)) {
          Log.ecritTrace(Niveau.DEBUG, IndividuImplPersistant.class, "ajouterDemande", e);
        }
      }
      super.ajouterDemande(demande);
    }
  }
  
  public void supprimerDemande(DemandeSpec demande)
  {
    if (demande != null)
    {
      getChronoDemandesPrive().supprimer(demande);
      super.supprimerDemande(demande);
      DomManager.supprimer(demande);
    }
  }
  
  public void setChronoDemandes(ChronologieDebuts chronoDemandes)
  {
    for (Iterator iter = getDemandes().iterator(); iter.hasNext();)
    {
      DemandeSpec demande = (DemandeSpec)iter.next();
      
      DomManager.supprimer(demande);
    }
    super.clearCollectionDemande();
    if (chronoDemandes != null)
    {
      chronoDemandes.iterer();
      while (chronoDemandes.encoreSuivant()) {
        ajouterDemande((DemandeSpec)chronoDemandes.elementSuivant());
      }
    }
  }
  
  public void supprimerPeriodeActiviteSalariee(ActiviteSalarie periodeActivite)
  {
    super.supprimerActiviteSalarie(periodeActivite);
    
    DomManager.supprimer(periodeActivite);
  }
  
  public void remplacerCollectionActiviteSalarie(Collection collectionACopier)
  {
    Collection listeActiviteSalarie = getCollectionActiviteSalarie();
    Collection listeActiviteSalarieCopie = new ArrayList();
    Iterator iter = listeActiviteSalarie.iterator();
    while (iter.hasNext())
    {
      ActiviteSalarie periode = (ActiviteSalarie)iter.next();
      if (!recherchePeriodeParIdentifiant(collectionACopier, periode)) {
        listeActiviteSalarieCopie.add(periode.copie());
      }
    }
    for (Iterator i = getCollectionActiviteSalarie().iterator(); i.hasNext();)
    {
      ActiviteSalarie objet = (ActiviteSalarie)i.next();
      DomManager.supprimer(objet);
    }
    listeActiviteSalarieCopie.addAll(collectionACopier);
    
    super.remplacerCollectionActiviteSalarie(listeActiviteSalarieCopie);
  }
  
  public void remplacerCollectionDemande(Collection collectionACopier)
  {
    for (Iterator i = super.getCollectionDemande().iterator(); i.hasNext();)
    {
      DemandeSpec objet = (DemandeSpec)i.next();
      DomManager.supprimer(objet);
    }
    super.remplacerCollectionDemande(collectionACopier);
  }
  
  public void remplacerCollectionStatistiqueExamenAuFilEau(Collection collectionACopier)
  {
    for (Iterator i = super.getCollectionStatistiqueExamenAuFilEau().iterator(); i.hasNext();)
    {
      StatistiqueExamenAuFilEau objet = (StatistiqueExamenAuFilEau)i.next();
      DomManager.supprimer(objet);
    }
    super.remplacerCollectionStatistiqueExamenAuFilEau(collectionACopier);
  }
  
  public void remplacerCollectionPreInscription(Collection collectionACopier)
  {
    for (Iterator i = super.getCollectionPreInscription().iterator(); i.hasNext();)
    {
      PreInscription objet = (PreInscription)i.next();
      DomManager.supprimer(objet);
    }
    super.remplacerCollectionPreInscription(collectionACopier);
  }
  
  private boolean recherchePeriodeParIdentifiant(Collection collectionPeriodes, ActiviteSalarie periode)
  {
    boolean trouve = false;
    
    Iterator iter = collectionPeriodes.iterator();
    while (iter.hasNext())
    {
      PeriodeGaecSpec periodeGaec = (PeriodeGaecSpec)iter.next();
      if (periodeGaec.getIdentifiant().equals(periode.getIdentifiant()))
      {
        trouve = true;
        break;
      }
    }
    return trouve;
  }
  
  public void setListePeriodesActiviteSalariee(Collection collectionPeriodesActiviteSalariee)
  {
    ArrayList periodeAjout = new ArrayList();
    ArrayList periodeSupp = new ArrayList();
    
    Iterator iter = collectionPeriodesActiviteSalariee.iterator();
    while (iter.hasNext())
    {
      ActiviteSalarie periode = (ActiviteSalarie)iter.next();
      Chronologie chronoPeriodes = new ChronologiePeriodes();
      chronoPeriodes.ajouter(getListePeriodesActiviteSalariee());
      if (!OutilChronologie.recherchePeriodeParIdentifiant(chronoPeriodes, periode)) {
        periodeAjout.add(periode);
      }
    }
    Iterator iter2 = getListePeriodesActiviteSalariee().iterator();
    while (iter2.hasNext())
    {
      ActiviteSalarie periode = (ActiviteSalarie)iter2.next();
      Chronologie chronoPeriodes = new ChronologiePeriodes();
      chronoPeriodes.ajouter(collectionPeriodesActiviteSalariee);
      if (!OutilChronologie.recherchePeriodeParIdentifiant(chronoPeriodes, periode)) {
        periodeSupp.add(periode);
      }
    }
    iter2 = getListePeriodesActiviteSalariee().iterator();
    while ((iter2.hasNext()) && (periodeSupp.size() != 0) && (periodeAjout.size() != 0))
    {
      ActiviteSalarie periode = (ActiviteSalarie)iter2.next();
      if (periodeSupp.contains(periode))
      {
        if (periodeAjout.size() != 0)
        {
          ActiviteSalarie periodeCopier = (ActiviteSalarie)periodeAjout.get(0);
          
          periodeCopier.copie(periode);
          periodeAjout.remove(0);
        }
        periodeSupp.remove(periode);
      }
    }
    if (periodeSupp.size() != 0)
    {
      iter = periodeSupp.iterator();
      while (iter.hasNext())
      {
        ActiviteSalarie periode = (ActiviteSalarie)iter.next();
        iter.remove();
        supprimerPeriodeActiviteSalariee(periode);
      }
    }
    if (periodeAjout.size() != 0)
    {
      iter = periodeAjout.iterator();
      while (iter.hasNext())
      {
        ActiviteSalarie periode = (ActiviteSalarie)iter.next();
        ajouterPeriodeActiviteSalariee(periode);
      }
    }
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    IndividuImplPersistant copie = new IndividuImplPersistant(getIndividuId());
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    IndividuImplPersistant copie = (IndividuImplPersistant)pcopie;
    copie.setChronoDemandes(getChronoDemandes());
    copie.setListePeriodesActiviteSalariee(getListePeriodesActiviteSalariee());
    copie.setDateBlocageIndemnisationConflitGAEC(getDateBlocageIndemnisationConflitGAEC());
    copie.setCodeTransfert(getCodeTransfert());
    copie.setDateExecutionDifferee(getDateExecutionDifferee());
    
    copie.setCodeTransaction(getCodeTransaction());
    copie.setDomaineSrcFlux(getDomaineSrcFlux());
    copie.remplacerCollectionPreInscription(getCollectionPreInscription());
    copie.setAttributionsAfdFiliereCourte(getAttributionsAfdFiliereCourte());
    copie.setAttributionsAfdFiliereIntermediaire(getAttributionsAfdFiliereIntermediaire());
    copie.setAttributionsAfdFiliereLongue(getAttributionsAfdFiliereLongue());
    copie.setChronoPbjc(getChronoPbjcs());
    copie.setChronoAide(getChronoAides());
    copie.setCollectionPrimes(getCollectionPrimes());
    copie.setIndividuPbjcNcp(getIndividuPbjcNcp());
    copie.setListDroitsPbjcsNcp(getListDroitsPbjcsNcp());
    copie.setListEnquetesPbjcNcp(getListEnquetesPbjcNcp());
    copie.setEstArretReexecution(isEstArretReexecution());
    copie.setCollectionDispositifNcp(getCollectionDispositifNcp());
    copie.setEstNonExecutionReceptionFlux(isEstNonExecutionReceptionFlux());
    copie.setEstDesactEFE(isEstDesactEFE());
    copie.setDateLimiteReexecution(getDateLimiteReexecution());
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete()
  {
    DomManager.supprimer(getDemandes());
    DomManager.supprimer(getListePeriodesActiviteSalariee());
  }
  
  public void marquerGraphePersistant()
  {
    DomManager.persisterEnProfondeur(super.getCollectionDemande());
    DomManager.persisterEnProfondeur(super.getCollectionActiviteSalarie());
    DomManager.persisterEnProfondeur(super.getCollectionStatistiqueExamenAuFilEau());
    DomManager.persisterEnProfondeur(super.getCollectionPreInscription());
    
    enregistrerPbjcs(getChronoPbjcs(), getDateDebutGenerationPbjcs());
    enregistrerAides(getChronoAides(), getDateDebutGenerationAides());
    enregistrerPrimes(getCollectionPrimes(), getDateDebutGenerationPrimes());
    enregistrerDroits(getListDroitsPbjcsNcp());
    enregistrerEnquetes(getListEnquetesPbjcNcp(), getDateDebutGenerationEnquete());
    enregistrerDisositifs(getCollectionDispositifNcp(), getdateDebutGenerationDispositif());
    if (getIndividuPbjcNcp() != null) {
      DomManager.persisterEnProfondeur(getIndividuPbjcNcp());
    }
  }
  
  public void jdoPreStore() {}
  
  public ContexteService getContexteService()
  {
    return getIndividuId().getIndividu().getContexteService();
  }
  
  public boolean isInvestigationFraude()
  {
    return investigationFraude;
  }
  
  public void setInvestigationFraude(boolean investigationFraude)
  {
    this.investigationFraude = investigationFraude;
  }
  
  private void enregistrerPbjcs(ChronologiePeriodes chronoPbjcs, Damj dateDebutGenerationPbjcs)
  {
    if (chronoPbjcs != null)
    {
      Iterator itChronoPBJCS = chronoPbjcs.iterer();
      while (itChronoPBJCS.hasNext())
      {
        PbjcNcp pbjc = (PbjcNcp)itChronoPBJCS.next();
        if (pbjc.getDateDebut().estApresOuCoincideAvec(dateDebutGenerationPbjcs)) {
          DomManager.persisterEnProfondeur(pbjc);
        }
      }
    }
  }
  
  private void enregistrerAides(ChronologiePeriodes chronoAides, Damj dateDebutGenerationAides)
  {
    if (chronoAides != null)
    {
      Iterator itChronoAIDES = chronoAides.iterer();
      while (itChronoAIDES.hasNext())
      {
        AideNcp aide = (AideNcp)itChronoAIDES.next();
        if (aide.getDateDebut().estApresOuCoincideAvec(dateDebutGenerationAides)) {
          DomManager.persisterEnProfondeur(aide);
        }
      }
    }
  }
  
  private void enregistrerPrimes(Collection collectionPrimes, Damj dateDebutGenerationPrimes)
  {
    if (collectionPrimes != null)
    {
      Iterator iteCollectionPrime = collectionPrimes.iterator();
      while (iteCollectionPrime.hasNext())
      {
        PrimePbjcNcp primeNcp = (PrimePbjcNcp)iteCollectionPrime.next();
        if (primeNcp.getDateEffet().estApresOuCoincideAvec(dateDebutGenerationPrimes)) {
          DomManager.persisterEnProfondeur(primeNcp);
        }
      }
    }
  }
  
  private void enregistrerDisositifs(Collection<DispositifNcp> collectionDispositifNcp, Damj dateDebutGenerationDispositif)
  {
    if (collectionDispositifNcp != null)
    {
      Iterator<DispositifNcp> iteCollectionPrime = collectionDispositifNcp.iterator();
      while (iteCollectionPrime.hasNext())
      {
        DispositifNcp dispositifPbjcNcp = (DispositifNcp)iteCollectionPrime.next();
        if (dispositifPbjcNcp.getDateDebutDispositif().estApresOuCoincideAvec(dateDebutGenerationDispositif)) {
          DomManager.persisterEnProfondeur(dispositifPbjcNcp);
        }
      }
    }
  }
  
  private void enregistrerDroits(List listeDroits)
  {
    if (listeDroits != null)
    {
      Iterator iteListeDroit = listeDroits.iterator();
      while (iteListeDroit.hasNext())
      {
        DroitPbjcNcp droitNcp = (DroitPbjcNcp)iteListeDroit.next();
        DomManager.persisterEnProfondeur(droitNcp);
      }
    }
  }
  
  private void enregistrerEnquetes(List listeEnquetes, Damj dateDebutGenerationEnquetes)
  {
    if (listeEnquetes != null)
    {
      Iterator iteListeEnquetes = listeEnquetes.iterator();
      while (iteListeEnquetes.hasNext())
      {
        EnquetePbjcNcp enqueteNcp = (EnquetePbjcNcp)iteListeEnquetes.next();
        if (enqueteNcp.getDateSituationSuivi().estApresOuCoincideAvec(dateDebutGenerationEnquetes)) {
          DomManager.persisterEnProfondeur(enqueteNcp);
        }
      }
    }
  }
  
  public void supprimerPreInscription(PreInscription preInscription)
    throws NullPointerException
  {
    super.supprimerPreInscription(preInscription);
    DomManager.supprimer(preInscription);
  }
}

/* Location:
 * Qualified Name:     IndividuImplPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
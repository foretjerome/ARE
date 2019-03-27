package fr.unedic.cali.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.NonConformiteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IndividuImplNonPersistant
  extends IndividuCaliAbstrait
{
  private Collection collectionPeriodesActiviteSalariee;
  private Collection collectionDemandes;
  private Collection collectionStatistiqueExamenAuFilEau;
  private List collectionPreInscription;
  private Damj dateBlocageIndemnisationConflitGAEC;
  private Damj dateExecutionDifferee;
  private String codeTransaction;
  private String domaineSrcFlux;
  private int estMigree;
  private Damj dernierJourIndemnisableAreSpe;
  private String origineSaisieDernierJourIndemnisableAreSpe;
  private int attributionsAfdFiliereCourte;
  private int attributionsAfdFiliereIntermediaire;
  private int attributionsAfdFiliereLongue;
  private boolean estDesactEfe;
  private boolean nonExecutionDiffere;
  
  public IndividuImplNonPersistant()
  {
    setEstModifiable(true);
    setEstCharge(false);
    
    collectionPeriodesActiviteSalariee = new ArrayList();
    collectionDemandes = new ArrayList();
    collectionStatistiqueExamenAuFilEau = new ArrayList();
    attributionsAfdFiliereCourte = 0;
    attributionsAfdFiliereIntermediaire = 0;
    attributionsAfdFiliereLongue = 0;
  }
  
  public IndividuImplNonPersistant(IndividuIdSpec individuIdSpec)
  {
    super(individuIdSpec);
    
    setEstModifiable(true);
    setEstCharge(true);
    
    collectionPeriodesActiviteSalariee = new ArrayList();
    collectionDemandes = new ArrayList();
    collectionStatistiqueExamenAuFilEau = new ArrayList();
    collectionPreInscription = new ArrayList();
  }
  
  public IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException
  {
    return this;
  }
  
  public void setChronoDemandes(ChronologieDebuts chronoDemandes)
  {
    for (Iterator iter = getDemandes().iterator(); iter.hasNext();) {
      supprimerDemande((DemandeSpec)iter.next());
    }
    if (chronoDemandes != null)
    {
      chronoDemandes.iterer();
      while (chronoDemandes.encoreSuivant()) {
        ajouterDemande((DemandeSpec)chronoDemandes.elementSuivant());
      }
    }
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
        if (Log.isTraceActive(IndividuImplNonPersistant.class, Niveau.DEBUG)) {
          Log.ecritTrace(Niveau.DEBUG, IndividuImplNonPersistant.class, "ajouterDemande", e);
        }
      }
      getDemandes().add(demande);
    }
  }
  
  public void supprimerDemande(DemandeSpec demande)
  {
    if (demande != null)
    {
      getChronoDemandesPrive().supprimer(demande);
      
      getDemandes().remove(demande);
    }
  }
  
  public Collection getDemandes()
  {
    return collectionDemandes;
  }
  
  public void supprimerPeriodeActiviteSalariee(ActiviteSalarie periodeActivite)
  {
    getListePeriodesActiviteSalariee().remove(periodeActivite);
  }
  
  public void ajouterActiviteSalarie(ActiviteSalarie periodesActiviteSalariee)
  {
    getListePeriodesActiviteSalariee().add(periodesActiviteSalariee);
  }
  
  public Collection getListePeriodesActiviteSalariee()
  {
    return collectionPeriodesActiviteSalariee;
  }
  
  public void remplacerCollectionActiviteSalarie(Collection collectionACopier)
  {
    setListePeriodesActiviteSalariee(collectionACopier);
  }
  
  public void setListePeriodesActiviteSalariee(Collection listePeriodesActiviteSalariee)
  {
    for (Iterator iter = getListePeriodesActiviteSalariee().iterator(); iter.hasNext();)
    {
      iter.next();
      iter.remove();
    }
    Iterator iter;
    if (listePeriodesActiviteSalariee != null) {
      for (iter = listePeriodesActiviteSalariee.iterator(); iter.hasNext();) {
        ajouterPeriodeActiviteSalariee((ActiviteSalarie)iter.next());
      }
    }
  }
  
  public Damj getDateBlocageIndemnisationConflitGAEC()
  {
    return dateBlocageIndemnisationConflitGAEC;
  }
  
  public void setDateBlocageIndemnisationConflitGAEC(Damj dateBlocageIndemnisationConflitGAEC)
  {
    this.dateBlocageIndemnisationConflitGAEC = dateBlocageIndemnisationConflitGAEC;
  }
  
  public Damj getDateExecutionDifferee()
  {
    return dateExecutionDifferee;
  }
  
  public void setDateExecutionDifferee(Damj dateExecutionDifferee)
  {
    this.dateExecutionDifferee = dateExecutionDifferee;
  }
  
  public int getCodeTransfert()
  {
    return 0;
  }
  
  public int getEstMigree()
  {
    return estMigree;
  }
  
  public void setEstMigree(int estMigree)
  {
    this.estMigree = estMigree;
  }
  
  public void ajouterStatistiqueExamenAuFilEau(StatistiqueExamenAuFilEau statistiqueExamenAuFilEau)
  {
    if (statistiqueExamenAuFilEau != null) {
      getCollectionStatistiqueExamenAuFilEau().add(statistiqueExamenAuFilEau);
    }
  }
  
  public Collection getCollectionStatistiqueExamenAuFilEau()
  {
    return collectionStatistiqueExamenAuFilEau;
  }
  
  public void supprimerStatistiqueExamenAuFilEau(StatistiqueExamenAuFilEau statistiqueExamenAuFilEau)
  {
    if (statistiqueExamenAuFilEau != null) {
      getCollectionStatistiqueExamenAuFilEau().remove(statistiqueExamenAuFilEau);
    }
  }
  
  public String getCodeTransaction()
  {
    return codeTransaction;
  }
  
  public void setCodeTransaction(String codeTransaction)
  {
    this.codeTransaction = codeTransaction;
  }
  
  public String getDomaineSrcFlux()
  {
    return domaineSrcFlux;
  }
  
  public void setDomaineSrcFlux(String domaineSrcFlux)
  {
    this.domaineSrcFlux = domaineSrcFlux;
  }
  
  public boolean isForcageAppelGaecTotal()
  {
    return false;
  }
  
  public void setForcageAppelGaecTotal(boolean forcageAppelGaecTotal) {}
  
  public List getListPreInscription()
  {
    return collectionPreInscription;
  }
  
  public void ajouterPreInscription(PreInscription preInscription)
  {
    collectionPreInscription.add(preInscription);
  }
  
  public void supprimerPreInscription(PreInscription preInscription)
  {
    if (collectionPreInscription != null) {
      getListPreInscription().remove(preInscription);
    }
  }
  
  public int getAttributionsAfdFiliereCourte()
  {
    return attributionsAfdFiliereCourte;
  }
  
  public int getAttributionsAfdFiliereIntermediaire()
  {
    return attributionsAfdFiliereIntermediaire;
  }
  
  public int getAttributionsAfdFiliereLongue()
  {
    return attributionsAfdFiliereLongue;
  }
  
  public void setAttributionsAfdFiliereCourte(int nombreAttributions)
  {
    attributionsAfdFiliereCourte = nombreAttributions;
  }
  
  public void setAttributionsAfdFiliereIntermediaire(int nombreAttributions)
  {
    attributionsAfdFiliereIntermediaire = nombreAttributions;
  }
  
  public void setAttributionsAfdFiliereLongue(int nombreAttributions)
  {
    attributionsAfdFiliereLongue = nombreAttributions;
  }
  
  public Damj getDernierJourIndemnisableAreSpe()
  {
    return dernierJourIndemnisableAreSpe;
  }
  
  public void setDernierJourIndemnisableAreSpe(Damj dernierJourIndemnisableAreSpe)
  {
    this.dernierJourIndemnisableAreSpe = dernierJourIndemnisableAreSpe;
  }
  
  public String getOrigineSaisieDernierJourIndemnisableAreSpe()
  {
    return origineSaisieDernierJourIndemnisableAreSpe;
  }
  
  public void setOrigineSaisieDernierJourIndemnisableAreSpe(String origineSaisieDernierJourIndemnisableAreSpe)
  {
    this.origineSaisieDernierJourIndemnisableAreSpe = origineSaisieDernierJourIndemnisableAreSpe;
  }
  
  public boolean isEstArretReexecution()
  {
    return false;
  }
  
  public void setEstArretReexecution(boolean estArretReexecution) {}
  
  public boolean isEstDesactEFE()
  {
    return estDesactEfe;
  }
  
  public boolean isEstNonExecutionReceptionFlux()
  {
    return nonExecutionDiffere;
  }
  
  public void setEstDesactEFE(boolean estDesactEfe)
  {
    this.estDesactEfe = estDesactEfe;
  }
  
  public void setEstNonExecutionReceptionFlux(boolean nonExecution)
  {
    nonExecutionDiffere = nonExecution;
  }
}

/* Location:
 * Qualified Name:     IndividuImplNonPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.calcul.dom;

import fr.unedic.cali.calcul.dom.gen.CalendrierExecutionCalculPeriodiqueGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreFinApresOuCoincideAvecDate;
import fr.unedic.util.temps.ObjetChronoPeriode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class CalendrierExecutionCalculPeriodique
  extends CalendrierExecutionCalculPeriodiqueGen
{
  private static final long serialVersionUID = 1694423017578889110L;
  private transient Chronologie chronologieUnitesTraitements;
  
  public CalendrierExecutionCalculPeriodique() {}
  
  public CalendrierExecutionCalculPeriodique(DomPCSpec pc)
  {
    super(pc);
  }
  
  public void reinitialiserCalendrier(Damj date)
  {
    ObjetChronoPeriode objetPNDS = null;
    ChronologiePeriodes chronoGeneralPNDS = null;
    ChronologiePeriodes chronologiePNDSFiltre = null;
    ObjetChronoPeriode objetDNJ = null;
    ChronologiePeriodes chronoGeneralDNJ = null;
    ChronologiePeriodes chronologieDNJFiltre = null;
    
    chronoGeneralDNJ = new ChronologiePeriodes();
    chronoGeneralPNDS = new ChronologiePeriodes();
    
    super.reinitialiserCalendrier(date);
    if ((getDateEpuisementDuree() != null) && (getDateEpuisementDuree().estApresOuCoincideAvec(date))) {
      setDateEpuisementDuree(null);
    }
    if (getDateFinDispositifCSP() != null) {
      setDateFinDispositifCSP(null);
    }
    if ((getDateDrv() != null) && (getDateDrv().estApresOuCoincideAvec(date)))
    {
      setDateDrv(null);
      setDernierJourIndemnisablePourSuivi(null);
    }
    Iterator iterator = getChronologieUnitesTraitements().iterer();
    while (iterator.hasNext())
    {
      UniteTraitement ut = (UniteTraitement)iterator.next();
      if ((ut.getDateFin().estApresOuCoincideAvec(date)) && 
        (!ut.isEstFigee()))
      {
        iterator.remove();
        
        super.supprimerUniteTraitement(ut);
        DomManager.supprimer(ut);
      }
    }
    if (!getListePNDS().isEmpty())
    {
      Iterator iteratorPNDS = getListePNDS().iterator();
      while (iteratorPNDS.hasNext())
      {
        objetPNDS = (ObjetChronoPeriode)iteratorPNDS.next();
        chronoGeneralPNDS.ajouter(objetPNDS);
      }
      FiltreFinApresOuCoincideAvecDate filtre = new FiltreFinApresOuCoincideAvecDate(date);
      chronologiePNDSFiltre = (ChronologiePeriodes)chronoGeneralPNDS.copier(filtre);
      
      DomManager.supprimer(chronologiePNDSFiltre.mapperVersCollection());
    }
    if (!getListeDNJ().isEmpty())
    {
      Iterator iteratorDNJ = getListeDNJ().iterator();
      while (iteratorDNJ.hasNext())
      {
        objetDNJ = (ObjetChronoPeriode)iteratorDNJ.next();
        chronoGeneralDNJ.ajouter(objetDNJ);
      }
      FiltreFinApresOuCoincideAvecDate filtre = new FiltreFinApresOuCoincideAvecDate(date);
      chronologieDNJFiltre = (ChronologiePeriodes)chronoGeneralDNJ.copier(filtre);
      
      DomManager.supprimer(chronologieDNJFiltre.mapperVersCollection());
    }
    setEtatAuDJI(null);
  }
  
  public Chronologie getChronologieUnitesTraitements()
  {
    if (chronologieUnitesTraitements == null)
    {
      chronologieUnitesTraitements = new ChronologiePeriodes();
      chronologieUnitesTraitements.ajouter(super.getCollectionUniteTraitement());
    }
    return chronologieUnitesTraitements;
  }
  
  public UniteTraitement getUTFigee()
  {
    boolean estTrouve = false;
    UniteTraitement uniteTraitementFigee = null;
    
    Iterator iter = getListUniteTraitement().iterator();
    while ((iter.hasNext()) && (!estTrouve))
    {
      UniteTraitement uniteTraitement = (UniteTraitement)iter.next();
      if (uniteTraitement.isEstFigee())
      {
        uniteTraitementFigee = uniteTraitement;
        estTrouve = true;
      }
    }
    return uniteTraitementFigee;
  }
  
  public void ajouterUT(UniteTraitement ut)
  {
    if (ut != null)
    {
      getChronologieUnitesTraitements().ajouter(ut);
      super.ajouterUniteTraitement(ut);
    }
  }
  
  public void ajouterUTFigee(UniteTraitement ut)
    throws CoucheLogiqueException
  {
    if (ut != null)
    {
      if (getUTFigee() != null) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_ECHEC_AJOUTER_UT_FIGEE");
      }
      ut.setEstFigee(true);
      getChronologieUnitesTraitements().ajouter(ut);
      super.ajouterUniteTraitement(ut);
    }
  }
  
  public void supprimerUT(UniteTraitement ut)
    throws CoucheLogiqueException
  {
    if (ut != null)
    {
      if (ut.isEstFigee()) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_ECHEC_SUPPRIMER_UT_FIGEE");
      }
      getChronologieUnitesTraitements().supprimer(ut);
      super.supprimerUniteTraitement(ut);
      DomManager.supprimer(ut);
    }
  }
  
  public void setChronologieUnitesTraitements(Chronologie chronologieUnitesTraitements)
    throws CoucheLogiqueException
  {
    Chronologie chronologieExistante = getChronologieUnitesTraitements();
    
    chronologieUnitesTraitements.iterer();
    while (chronologieUnitesTraitements.encoreSuivant())
    {
      UniteTraitement ut = (UniteTraitement)chronologieUnitesTraitements.elementSuivant();
      if (!chronologieExistante.contientElement(ut)) {
        ajouterUT(ut);
      }
    }
    chronologieUnitesTraitements.iterer();
    while (chronologieExistante.encoreSuivant())
    {
      UniteTraitement ut = (UniteTraitement)chronologieExistante.elementSuivant();
      if (!chronologieUnitesTraitements.contientElement(ut)) {
        supprimerUT(ut);
      }
    }
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreStore() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete()
  {
    super.jdoPreDelete();
    DomManager.supprimer(super.getCollectionUniteTraitement());
  }
  
  public void marquerGraphePersistant()
  {
    super.marquerGraphePersistant();
    DomManager.persisterEnProfondeur(super.getCollectionUniteTraitement());
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    CalendrierExecutionCalculPeriodique copie = (CalendrierExecutionCalculPeriodique)pcopie;
    super.copieElements(copie);
    chronologieUnitesTraitements = getChronologieUnitesTraitements();
    copie.remplacerCollectionUniteTraitement(getCollectionUniteTraitement());
  }
  
  public void setDateDrv(Damj dateDrv) {}
  
  public Damj getDateDrv()
  {
    return null;
  }
  
  public Damj getDateEpuisementDuree()
  {
    return null;
  }
  
  public void setDateEpuisementDuree(Damj mdateEpuisementDuree) {}
  
  public void remplacerCollectionUniteTraitement(Collection collectionACopier)
  {
    for (Iterator i = super.getCollectionUniteTraitement().iterator(); i.hasNext();)
    {
      UniteTraitement objet = (UniteTraitement)i.next();
      DomManager.supprimer(objet);
    }
    super.remplacerCollectionUniteTraitement(collectionACopier);
  }
}

/* Location:
 * Qualified Name:     CalendrierExecutionCalculPeriodique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
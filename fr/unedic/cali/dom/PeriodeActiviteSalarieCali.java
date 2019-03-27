package fr.unedic.cali.dom;

import fr.unedic.cali.affectation.parametres.CriteresQualification;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.affectation.DecorReglementaire;
import fr.unedic.cali.dom.affectation.QualificationPeriodeActiviteSalarie;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.dom.affectation.outilsfonctionnels.qualification.QualificationAutomatiquePeriode;
import fr.unedic.cali.dom.gen.PeriodeActiviteSalarieCaliGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.cali.fabriques.FabriqueStrategieQualificationFonctionnaire;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.StrategieQualificationFonctionnaireSpec;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class PeriodeActiviteSalarieCali
  extends PeriodeActiviteSalarieCaliGen
  implements PeriodeActiviteSalarieCaliSpec
{
  private static final long serialVersionUID = -5020021041782841022L;
  private transient Hashtable listeQualification = new Hashtable();
  private transient DecorReglementaire decorCourant;
  private transient CriteresQualification criteresQualification;
  private transient ActiviteSalarie periodeActiviteSalarie;
  private transient int estQualifiable = 0;
  private transient boolean pndsSpectacleCharge;
  private transient PeriodeNonDeclareeSanction pndsSpectacle;
  
  public PeriodeActiviteSalarieCali() {}
  
  public PeriodeActiviteSalarieCali(DomPCSpec pc)
  {
    super(pc);
  }
  
  public void ajouterQualification(QualificationPeriodeActiviteSalarie qualification)
  {
    listeQualification.put(qualification.getCriteresQualification(), qualification);
  }
  
  private QualificationPeriodeActiviteSalarie getQualification()
  {
    return QualificationAutomatiquePeriode.qualifierTransientePeriode(getPeriodeActiviteSalarie());
  }
  
  public QualificationPeriodeActiviteSalarie getQualification(CriteresQualification critereQualif)
  {
    QualificationPeriodeActiviteSalarie qualificationPeriodeActiviteSalarie = null;
    
    CriteresQualification critereQualification = getCriteresQualification();
    if (critereQualification != null)
    {
      Object qualifObj = listeQualification.get(critereQualification);
      if (qualifObj != null)
      {
        qualificationPeriodeActiviteSalarie = (QualificationPeriodeActiviteSalarie)qualifObj;
      }
      else
      {
        qualificationPeriodeActiviteSalarie = getQualification();
        if (qualificationPeriodeActiviteSalarie != null) {
          ajouterQualification(qualificationPeriodeActiviteSalarie);
        }
      }
    }
    return qualificationPeriodeActiviteSalarie;
  }
  
  public void jdoPostLoad() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public void jdoPreStore() {}
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeActiviteSalarieCali copie = new PeriodeActiviteSalarieCali();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    PeriodeActiviteSalarieCali copie = (PeriodeActiviteSalarieCali)pcopie;
    
    Iterator it = getListeQualification().keySet().iterator();
    CriteresQualification cleCriteresQualification = null;
    QualificationPeriodeActiviteSalarie qualificationPeriodeActiviteSalarie = null;
    while (it.hasNext())
    {
      cleCriteresQualification = (CriteresQualification)it.next();
      
      qualificationPeriodeActiviteSalarie = (QualificationPeriodeActiviteSalarie)getListeQualification().get(cleCriteresQualification);
      
      copie.getListeQualification().put(cleCriteresQualification, new QualificationPeriodeActiviteSalarie(qualificationPeriodeActiviteSalarie.getReglement(), cleCriteresQualification));
    }
    copie.setDecorCourant(getDecorCourant());
    copie.setEstFctPrincipale(estFctPrincipale());
    copie.setEstLiquidable(estLiquidable());
    copie.setCriteresQualification(getCriteresQualification());
  }
  
  public ActiviteSalarie getPeriodeActiviteSalarie()
  {
    return periodeActiviteSalarie;
  }
  
  public void setPeriodeActiviteSalarie(ActiviteSalarie periodeActiviteSalarie)
  {
    this.periodeActiviteSalarie = periodeActiviteSalarie;
  }
  
  public Reglement getReglement()
  {
    Reglement reglementApplicable = null;
    
    QualificationPeriodeActiviteSalarie qualification = getQualification(getCriteresQualification());
    if (qualification != null) {
      reglementApplicable = qualification.getReglement();
    }
    return reglementApplicable;
  }
  
  public boolean estQualifiable()
  {
    if (estQualifiable == 0)
    {
      boolean qualifiable = estQualifiableAutomatiquement();
      if (qualifiable) {
        estQualifiable = 1;
      } else {
        estQualifiable = 3;
      }
    }
    return estQualifiable == 1;
  }
  
  public boolean estFctPrincipale()
  {
    return super.isEstFctPrincipale();
  }
  
  public boolean estLiquidable()
  {
    return super.isEstLiquidable();
  }
  
  private boolean estQualifiableAutomatiquement()
  {
    boolean qualifiable = false;
    
    qualifiable = getPeriodeActiviteSalarie().estOrigineAeOuEquivalent();
    if (!qualifiable)
    {
      Collection<Collection<Integer>> originesQualifiables = new ArrayList();
      Collection<Integer> origines = getPeriodeActiviteSalarie().getCollectionOrigineInformationPAS();
      Collection<Integer> premierJeu = new ArrayList();
      premierJeu.add(Integer.valueOf(12));
      premierJeu.add(Integer.valueOf(3));
      originesQualifiables.add(premierJeu);
      
      Collection<Integer> deuxiemeJeu = new ArrayList();
      deuxiemeJeu.add(Integer.valueOf(12));
      deuxiemeJeu.add(Integer.valueOf(11));
      originesQualifiables.add(deuxiemeJeu);
      
      Collection<Integer> troisiemeJeu = new ArrayList();
      troisiemeJeu.add(Integer.valueOf(15));
      troisiemeJeu.add(Integer.valueOf(3));
      originesQualifiables.add(troisiemeJeu);
      
      Collection<Integer> quatriemeJeu = new ArrayList();
      quatriemeJeu.add(Integer.valueOf(15));
      quatriemeJeu.add(Integer.valueOf(11));
      originesQualifiables.add(quatriemeJeu);
      
      Collection<Integer> cinquiemeJeu = new ArrayList();
      cinquiemeJeu.add(Integer.valueOf(110));
      originesQualifiables.add(cinquiemeJeu);
      
      qualifiable = estOriginePresenteDansListe(origines, originesQualifiables);
    }
    qualifiable &= getPeriodeActiviteSalarie().getChampApplication() != 2;
    if (getPeriodeActiviteSalarie().getChampApplication() == 8)
    {
      CritereStrategie critereStrategie = new CritereStrategie();
      if ((getCriteresQualification() != null) && (getCriteresQualification().getDateFinDernierSinistre() != null)) {
        critereStrategie.setDatePivot(getCriteresQualification().getDateFinDernierSinistre());
      } else {
        critereStrategie.setDatePivot(FabriqueStrategieQualificationFonctionnaire.DATE_PIVOT);
      }
      StrategieQualificationFonctionnaireSpec strategieQualificationfonctionnaire = (StrategieQualificationFonctionnaireSpec)FabriqueStrategieQualificationFonctionnaire.getInstance().getStrategie(critereStrategie);
      
      qualifiable &= strategieQualificationfonctionnaire.estQualifiable();
    }
    return qualifiable;
  }
  
  private boolean estOriginePresenteDansListe(Collection<Integer> origines, Collection<Collection<Integer>> liste)
  {
    boolean retour = false;
    
    Iterator<Collection<Integer>> it = liste.iterator();
    while ((it.hasNext()) && (!retour)) {
      retour = origines.containsAll((Collection)it.next());
    }
    return retour;
  }
  
  public DecorReglementaire getDecorCourant()
  {
    return decorCourant;
  }
  
  public void setDecorCourant(DecorReglementaire decorCourant)
  {
    this.decorCourant = decorCourant;
  }
  
  public boolean estElementDebut()
  {
    return getPeriodeActiviteSalarie().estElementDebut();
  }
  
  public boolean estStrictementType(Class type)
  {
    return getPeriodeActiviteSalarie().estStrictementType(type);
  }
  
  public boolean estType(Class type)
  {
    return getPeriodeActiviteSalarie().estType(type);
  }
  
  public Damj getDateDebut()
  {
    return getPeriodeActiviteSalarie().getDateDebut();
  }
  
  public Damj getDateEffet()
  {
    return getPeriodeActiviteSalarie().getDateEffet();
  }
  
  public Damj getDateFin()
  {
    return getPeriodeActiviteSalarie().getDateFin();
  }
  
  public int getPriorite()
  {
    return getPeriodeActiviteSalarie().getPriorite();
  }
  
  public int getTypeDateEffet()
  {
    return getPeriodeActiviteSalarie().getTypeDateEffet();
  }
  
  public String getTypeElement()
  {
    return getPeriodeActiviteSalarie().getTypeElement();
  }
  
  public void setPriorite(int priorite)
  {
    getPeriodeActiviteSalarie().setPriorite(priorite);
  }
  
  public CriteresQualification getCriteresQualification()
  {
    return criteresQualification;
  }
  
  public void setCriteresQualification(CriteresQualification criteresQualification)
  {
    this.criteresQualification = criteresQualification;
  }
  
  public Hashtable getListeQualification()
  {
    return listeQualification;
  }
  
  public void setListeQualification(Hashtable listeQualification)
  {
    this.listeQualification = listeQualification;
  }
  
  public boolean estPndsSpectacleCharge()
  {
    return pndsSpectacleCharge;
  }
  
  public PeriodeNonDeclareeSanction getPndsSpectacle()
  {
    return pndsSpectacle;
  }
  
  public void setPndsSpectacle(PeriodeNonDeclareeSanction periodeNonDeclareeSanction)
  {
    pndsSpectacle = periodeNonDeclareeSanction;
  }
  
  public void setPndsSpectacleCharge(boolean pndsSpectacleCharge)
  {
    this.pndsSpectacleCharge = pndsSpectacleCharge;
  }
}

/* Location:
 * Qualified Name:     PeriodeActiviteSalarieCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
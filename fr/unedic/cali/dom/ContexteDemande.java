package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.spec.IncidentSpec;
import fr.unedic.cali.dom.gen.ContexteDemandeGen;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;

public class ContexteDemande
  extends ContexteDemandeGen
  implements ObjetPersistantSpec
{
  private static final long serialVersionUID = 5439162989769927257L;
  private transient String idPremiereDemandeCsrDansSuspension;
  private transient ActiviteSalarie derniereAeCspVolontaire;
  private transient AttributionAssuranceSpec attributionAreAdhesionVolontaire;
  private transient AttributionAssuranceSpec attributionLieeAFinDeDroit;
  private transient Chronologie chronologiesAttributionPmvsEnCoursDansPra;
  private transient IncidentSpec periodeSuspensiveEnCours;
  
  public ContexteDemande(DomPCSpec pc)
  {
    super(pc);
  }
  
  public ContexteDemande() {}
  
  public void copieElements(ObjetMetierSpec copie)
  {
    ContexteDemande copieLocal = (ContexteDemande)copie;
    copieLocal.setTypeContexteDemande(getTypeContexteDemande());
    copieLocal.setSousTypeContexteDemande(getSousTypeContexteDemande());
    copieLocal.setDateDebutJustifContexte(getDateDebutJustifContexte());
    copieLocal.setDateFinJustifContexte(getDateFinJustifContexte());
    copieLocal.setIdentifiantPeriodeCaliJustifContexte(getIdentifiantPeriodeCaliJustifContexte());
    
    copieLocal.setIdPremiereDemandeCsrDansSuspension(getIdPremiereDemandeCsrDansSuspension());
    copieLocal.setDerniereAeCspVolontaire(getDerniereAeCspVolontaire());
    copieLocal.setChronologiesAttributionPmvsEnCoursDansPra(getChronologiesAttributionPmvsEnCoursDansPra());
    copieLocal.setPeriodeSuspensiveEnCours(getPeriodeSuspensiveEnCours());
  }
  
  public boolean isDemandeMayotte()
  {
    return ("SOLMAYOTTE".equalsIgnoreCase(getTypeContexteDemande())) || ("CPAMAYOTTE".equalsIgnoreCase(getTypeContexteDemande()));
  }
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public void marquerGraphePersistant() {}
  
  public ObjetMetierSpec copie()
  {
    ContexteDemande contexte = new ContexteDemande();
    copieElements(contexte);
    return contexte;
  }
  
  public ActiviteSalarie getDerniereAeCspVolontaire()
  {
    return derniereAeCspVolontaire;
  }
  
  public void setDerniereAeCspVolontaire(ActiviteSalarie derniereAeCspVolontaire)
  {
    this.derniereAeCspVolontaire = derniereAeCspVolontaire;
  }
  
  public boolean estContexteDerniereAeCspAdhesionVolontaireForceeAspAdhesionVolontaire()
  {
    return ("ADHVOLARE".equals(getTypeContexteDemande())) || ("ASPVOLSARE".equals(getTypeContexteDemande())) || ("FINASPVOLC".equals(getTypeContexteDemande()));
  }
  
  public boolean estContexteFinAsp()
  {
    return ("FINASP".equals(getTypeContexteDemande())) || ("FINASPVOL".equals(getTypeContexteDemande())) || ("FINASPVOLC".equals(getTypeContexteDemande()));
  }
  
  public AttributionAssuranceSpec getAttributionAreAdhesionVolontaire()
  {
    return attributionAreAdhesionVolontaire;
  }
  
  public void setAttributionAreAdhesionVolontaire(AttributionAssuranceSpec attributionAreAdhesionVolontaire)
  {
    this.attributionAreAdhesionVolontaire = attributionAreAdhesionVolontaire;
  }
  
  public AttributionAssuranceSpec getAttributionLieeAFinDeDroit()
  {
    return attributionLieeAFinDeDroit;
  }
  
  public void setAttributionLieeAFinDeDroit(AttributionAssuranceSpec attributionLieeAFinDeDroit)
  {
    this.attributionLieeAFinDeDroit = attributionLieeAFinDeDroit;
  }
  
  public String getIdPremiereDemandeCsrDansSuspension()
  {
    return idPremiereDemandeCsrDansSuspension;
  }
  
  public void setIdPremiereDemandeCsrDansSuspension(String idPremiereDemandeCsrDansSuspension)
  {
    this.idPremiereDemandeCsrDansSuspension = idPremiereDemandeCsrDansSuspension;
  }
  
  public IncidentSpec getPeriodeSuspensiveEnCours()
  {
    return periodeSuspensiveEnCours;
  }
  
  public void setPeriodeSuspensiveEnCours(IncidentSpec periodeSuspensiveEnCours)
  {
    this.periodeSuspensiveEnCours = periodeSuspensiveEnCours;
  }
  
  public Chronologie getChronologiesAttributionPmvsEnCoursDansPra()
  {
    return chronologiesAttributionPmvsEnCoursDansPra;
  }
  
  public void setChronologiesAttributionPmvsEnCoursDansPra(Chronologie chronologiesAttributionPmvsEnCoursDansPra)
  {
    this.chronologiesAttributionPmvsEnCoursDansPra = chronologiesAttributionPmvsEnCoursDansPra;
  }
  
  public Periode getPeriodeJustifContexte()
  {
    Periode periode = null;
    Damj dateDebutPeriode = getDateDebutJustifContexte();
    Damj dateFinPeriode = getDateFinJustifContexte();
    if ((dateDebutPeriode != null) && (dateFinPeriode != null)) {
      periode = new Periode(dateDebutPeriode, dateFinPeriode);
    }
    return periode;
  }
}

/* Location:
 * Qualified Name:     ContexteDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
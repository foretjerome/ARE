package fr.unedic.cali.calcul.dom.periode;

import fr.unedic.cali.autresdoms.ga.dom.PeriodeEvenementPersonnel;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeCalculTransient;
import fr.unedic.cali.parametres.GestionnaireDateApplication;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public class PeriodeDisponibilite
  extends ObjetChronoPeriodeCalculTransient
{
  private static final long serialVersionUID = 1L;
  private transient String libelle = null;
  private transient String type = null;
  private transient String idContratTravail = null;
  private transient int statut;
  private transient boolean estDebutPeriode;
  private transient boolean estFctPresente;
  private transient boolean estPeriodeEnCours;
  private transient boolean estSuiteRenouvellement;
  private transient boolean estSeulementSuspensif;
  private transient Damj dateDebutRenouvellement = Damj.FIN_DES_TEMPS;
  private transient Damj dateFCT;
  private BigDecimal intensite;
  public static final BigDecimal INTENSITE_TEMPS_PLEIN = new BigDecimal(1);
  
  protected PeriodeDisponibilite() {}
  
  public PeriodeDisponibilite(Damj date, boolean estDebutPeriode, PeriodeEvenementPersonnel periodeActivite)
  {
    super(date, date);
    this.estDebutPeriode = estDebutPeriode;
    statut = periodeActivite.getStatutFin();
    idContratTravail = periodeActivite.getIdContratTravail();
    estFctPresente = periodeActivite.estFctPresente();
    dateFCT = null;
    estPeriodeEnCours = false;
  }
  
  public PeriodeDisponibilite(PeriodeEvenementPersonnel periodeActivite)
    throws CoucheLogiqueException
  {
    super(Damj.max(periodeActivite.getDateDebut(), GestionnaireDateApplication.getInstance().recupererDateApplication("Périodes suspensives en cours")), periodeActivite.getDateFin());
    statut = periodeActivite.getStatutFin();
    idContratTravail = periodeActivite.getIdContratTravail();
    estFctPresente = periodeActivite.estFctPresente();
    dateFCT = null;
    estPeriodeEnCours = false;
  }
  
  public BigDecimal getIntensite()
  {
    return intensite;
  }
  
  public void setIntensite(BigDecimal intensite)
  {
    this.intensite = intensite;
  }
  
  public String getLibelle()
  {
    return libelle;
  }
  
  public void setLibelle(String libelle)
  {
    this.libelle = libelle;
  }
  
  public boolean estDebutPeriode()
  {
    return estDebutPeriode;
  }
  
  public void setEstDebutPeriode(boolean estDebutPeriode)
  {
    this.estDebutPeriode = estDebutPeriode;
  }
  
  public boolean doitSuspendreARE()
  {
    return (estSeulementSuspensif()) && (!estPeriodeEnCours()) && ((estRenouvellementVolontaire()) || (estRenouvellementInvolontaire()) || (estReintegration()) || (estRuptureVolontaireAvecFct()) || (estRuptureInVolontaireAvecFct()));
  }
  
  public boolean doitInterrompteARE()
  {
    if (estSeulementSuspensif()) {
      return false;
    }
    if ((estPeriodeEnCours()) && (estDebutPeriode())) {
      return false;
    }
    if ((!estPeriodeEnCours()) && (estDebutPeriode()) && ((estRenouvellementInvolontaireEnDebut()) || (estReintegrationEnDebut()))) {
      return false;
    }
    if ((!estPeriodeEnCours()) && (estDebutPeriode()) && (estFctPresente()) && ((estRuptureVolontaireEnDebut()) || (estRuptureInvolontaireEnDebut()))) {
      return false;
    }
    return ((estPeriodeEnCours()) && ((aucunStatut()) || (estRuptureVolontaire()) || (estRuptureInVolontaire()) || (estRenouvellementVolontaire()) || (estReintegration()))) || (estDebutPeriode()) || (aucunStatut()) || (estRuptureInVolontaire()) || (estRenouvellementVolontaire());
  }
  
  public boolean aucunStatut()
  {
    return getStatut() == 0;
  }
  
  public boolean aucunStatutEnDebut()
  {
    return (estDebutPeriode()) && (aucunStatut());
  }
  
  public boolean estRuptureInvolontaireEnDebut()
  {
    return (estDebutPeriode()) && (getStatut() == 4);
  }
  
  public boolean estRuptureVolontaireEnDebut()
  {
    return (estDebutPeriode()) && (getStatut() == 3);
  }
  
  public boolean estRenouvellementVolontaireEnDebut()
  {
    return (estDebutPeriode()) && (getStatut() == 1);
  }
  
  public boolean estRuptureVolontaire()
  {
    return (!estDebutPeriode()) && (!estFctPresente()) && (getStatut() == 3);
  }
  
  public boolean estRuptureInVolontaire()
  {
    return (!estDebutPeriode()) && (!estFctPresente()) && (getStatut() == 4);
  }
  
  public boolean estRuptureVolontaireAvecFct()
  {
    return (!estDebutPeriode()) && (estFctPresente()) && (getStatut() == 3);
  }
  
  public boolean estRuptureInVolontaireAvecFct()
  {
    return (!estDebutPeriode()) && (estFctPresente()) && (getStatut() == 4);
  }
  
  public boolean estRenouvellementVolontaire()
  {
    return (!estDebutPeriode()) && (getStatut() == 1);
  }
  
  public boolean estRenouvellementInvolontaireEnDebut()
  {
    return (estDebutPeriode()) && (getStatut() == 2);
  }
  
  public boolean estRenouvellementInvolontaire()
  {
    return (!estDebutPeriode()) && (getStatut() == 2);
  }
  
  public boolean estReintegrationEnDebut()
  {
    return (estDebutPeriode()) && (getStatut() == 5);
  }
  
  public boolean estReintegration()
  {
    return (!estDebutPeriode()) && (getStatut() == 5);
  }
  
  public boolean doitCreerEnquete()
  {
    return !estDebutPeriode();
  }
  
  public String getType()
  {
    return type;
  }
  
  public void setType(String type)
  {
    this.type = type;
  }
  
  public int getStatut()
  {
    return statut;
  }
  
  public void setStatut(int statut)
  {
    this.statut = statut;
  }
  
  public String getIdContratTravail()
  {
    return idContratTravail;
  }
  
  public void setIdContratTravail(String idContratTravail)
  {
    this.idContratTravail = idContratTravail;
  }
  
  public boolean estFctPresente()
  {
    return estFctPresente;
  }
  
  public void setEstFctPresente(boolean estFctPresente)
  {
    this.estFctPresente = estFctPresente;
  }
  
  public Damj getDateFCT()
  {
    return dateFCT;
  }
  
  public void setDateFCT(Damj dateFCT)
  {
    this.dateFCT = dateFCT;
  }
  
  public boolean estPeriodeEnCours()
  {
    return estPeriodeEnCours;
  }
  
  public void setEstPeriodeEnCours(boolean estPeriodeEnCours)
  {
    this.estPeriodeEnCours = estPeriodeEnCours;
  }
  
  public boolean estSuiteRenouvellement()
  {
    return estSuiteRenouvellement;
  }
  
  public void setEstSuiteRenouvellement(boolean estSuiteRenouvellement)
  {
    this.estSuiteRenouvellement = estSuiteRenouvellement;
  }
  
  public Damj getDateDebutRenouvellement()
  {
    return dateDebutRenouvellement;
  }
  
  public void setDateDebutRenouvellement(Damj dateDebutRenouvellement)
  {
    this.dateDebutRenouvellement = dateDebutRenouvellement;
  }
  
  public boolean estSeulementSuspensif()
  {
    return estSeulementSuspensif;
  }
  
  public void setEstSeulementSuspensif(boolean estSeulementSuspensif)
  {
    this.estSeulementSuspensif = estSeulementSuspensif;
  }
  
  public ObjetMetierSpec copie()
  {
    PeriodeDisponibilite copie = new PeriodeDisponibilite();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec copie)
  {
    PeriodeDisponibilite copiePeriodeDisponibilite = (PeriodeDisponibilite)copie;
    super.copieElements(copiePeriodeDisponibilite);
    
    copiePeriodeDisponibilite.setLibelle(getLibelle());
    copiePeriodeDisponibilite.setEstDebutPeriode(estDebutPeriode());
    copiePeriodeDisponibilite.setType(getType());
    copiePeriodeDisponibilite.setStatut(getStatut());
    copiePeriodeDisponibilite.setIdContratTravail(getIdContratTravail());
    copiePeriodeDisponibilite.setDateFCT(getDateFCT());
    copiePeriodeDisponibilite.setEstFctPresente(estFctPresente());
    copiePeriodeDisponibilite.setEstPeriodeEnCours(estPeriodeEnCours());
    copiePeriodeDisponibilite.setEstSuiteRenouvellement(estSuiteRenouvellement());
    copiePeriodeDisponibilite.setDateDebutRenouvellement(getDateDebutRenouvellement());
    copiePeriodeDisponibilite.setEstSeulementSuspensif(estSeulementSuspensif());
  }
}

/* Location:
 * Qualified Name:     PeriodeDisponibilite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
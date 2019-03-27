package fr.unedic.cali.dom;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeIntensite;
import fr.unedic.cali.autresdoms.ga.dom.spec.AppartenanceSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.Unite;
import fr.unedic.util.UniteAffiliation;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Hashtable;

public class PeriodeElementaire
  extends ObjetChronoPeriode
  implements AppartenanceSpec
{
  private static final long serialVersionUID = -7122784044879526804L;
  private Hashtable mListeQuantitesAppartenance = new Hashtable();
  private ActiviteSalarie mPeriodeActiviteOrigine;
  private PeriodeIntensite mIntensite;
  private boolean mEstSanctionne;
  private Reglement mReglementAppartenance;
  private boolean mEstPresenceSuspension;
  private Quantite mQuantiteHeuresActivite = new Quantite(BigDecimal.ZERO, UniteAffiliation.HEURE_TRAVAIL);
  private Quantite mQuantiteHeuresSuspension = new Quantite(BigDecimal.ZERO, UniteAffiliation.HEURE_TRAVAIL);
  
  public PeriodeElementaire(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    initialisationIntensite();
  }
  
  private void initialisationIntensite()
  {
    PeriodeIntensite intensite = new PeriodeIntensite(getPeriode());
    intensite.setHorairesEntreprise(PeriodeIntensite.TRENTE_CINQ_HEURES);
    intensite.setHorairesSalarie(PeriodeIntensite.TRENTE_CINQ_HEURES);
    setInstensite(intensite);
  }
  
  public Hashtable getListeQuantitesAppartenance()
  {
    return mListeQuantitesAppartenance;
  }
  
  public void ajouterQuantiteAffiliation(Quantite quantite)
  {
    if (quantite == null) {
      throw new IllegalArgumentException("La quantité à ajouter ne doit pas être null");
    }
    mListeQuantitesAppartenance.put(quantite.getUnite(), quantite);
  }
  
  public Quantite getQuantiteAffiliation(Unite unite)
  {
    Quantite quantiteAffiliation = (Quantite)mListeQuantitesAppartenance.get(unite);
    if ((UniteAffiliation.JOUR.equals(unite)) && (quantiteAffiliation == null)) {
      quantiteAffiliation = new Quantite(getDuree(), UniteAffiliation.JOUR);
    }
    return quantiteAffiliation;
  }
  
  public ActiviteSalarie getPeriodeActiviteOrigine()
  {
    return mPeriodeActiviteOrigine;
  }
  
  public void setPeriodeActiviteOrigine(ActiviteSalarie periodeActiviteOrigine)
  {
    mPeriodeActiviteOrigine = periodeActiviteOrigine;
  }
  
  public PeriodeIntensite getInstensite()
  {
    return mIntensite;
  }
  
  public void setInstensite(PeriodeIntensite instensite)
  {
    mIntensite = instensite;
  }
  
  public Reglement getReglementAppartenance()
  {
    return mReglementAppartenance;
  }
  
  public void setReglementAppartenance(Reglement reglementAppartenance)
  {
    mReglementAppartenance = reglementAppartenance;
  }
  
  public String toString()
  {
    StringBuffer sb = new StringBuffer();
    sb.append("PeriodeElementaire : \n");
    sb.append("\tdu : ");
    sb.append(getDateDebut());
    sb.append(" au : ");
    sb.append(getDateFin());
    sb.append("\n\tde ");
    sb.append(getDuree());
    sb.append(" jours \n");
    sb.append("\taffiliation : ");
    sb.append(mListeQuantitesAppartenance.toString());
    sb.append("\n");
    return sb.toString();
  }
  
  public boolean estSanctionne()
  {
    return mEstSanctionne;
  }
  
  public void setEstSanctionne(boolean estSanctionne)
  {
    mEstSanctionne = estSanctionne;
  }
  
  public Periode getPeriode()
  {
    return super.getPeriode();
  }
  
  public ObjetMetierSpec copie()
  {
    return this;
  }
  
  public boolean isDerogationPlafondMensuel()
  {
    return mPeriodeActiviteOrigine.isDerogationPlafondMensuel();
  }
  
  public int getNatureAppartenance()
  {
    return 0;
  }
  
  public boolean produitAppartenance()
  {
    return true;
  }
  
  public boolean estPresenceSuspension()
  {
    return mEstPresenceSuspension;
  }
  
  public void setEstPresenceSuspension(boolean estPresenceSuspension)
  {
    mEstPresenceSuspension = estPresenceSuspension;
  }
  
  public Quantite getQuantiteHeuresActivite()
  {
    return mQuantiteHeuresActivite;
  }
  
  public void setQuantiteHeuresActivite(Quantite quantiteHeuresActivite)
  {
    mQuantiteHeuresActivite = quantiteHeuresActivite;
  }
  
  public Quantite getQuantiteHeuresSuspension()
  {
    return mQuantiteHeuresSuspension;
  }
  
  public void setQuantiteHeuresSuspension(Quantite quantiteHeuresSuspension)
  {
    mQuantiteHeuresSuspension = quantiteHeuresSuspension;
  }
  
  public Quantite donnerQuantiteHeuresActiviteSelonPresenceSuspension()
  {
    if (mEstPresenceSuspension) {
      return mQuantiteHeuresActivite;
    }
    return getQuantiteAffiliation(UniteAffiliation.HEURE_TRAVAIL);
  }
}

/* Location:
 * Qualified Name:     PeriodeElementaire
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
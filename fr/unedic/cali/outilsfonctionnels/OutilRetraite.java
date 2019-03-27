package fr.unedic.cali.outilsfonctionnels;

import fr.pe.cali.reglementaire.parametres.retraite.ParametresRetraite;
import fr.unedic.cali.autresdoms.cohab.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.temps.ObjetChrono60AnsBlocageRetraite;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoPeriodeRetraite;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.Retraite;
import fr.unedic.cali.parametres.InfoRetraite;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;

@Deprecated
public class OutilRetraite
  implements OutilRetraiteSpec
{
  private static final int SOIXANTE_ANS = 60;
  private static OutilRetraite instance;
  
  public static OutilRetraite getInstance()
  {
    if (instance == null) {
      instance = new OutilRetraite();
    }
    return instance;
  }
  
  public boolean estNbTrimestresSaisiOuDateRetraiteForcee(IndividuSpec individu)
  {
    return (individu.getDateLiquidationRetraite() != null) || (individu.getDateRetraiteAnticipe() != null) || (estTrimestreSaisi(individu));
  }
  
  private boolean estTrimestreSaisi(IndividuSpec individu)
  {
    return (individu.getTrimestreRetraite() != null) && (individu.getTrimestreRetraite().getNombreTrimestre() != null) && (individu.getTrimestreRetraite().getNombreTrimestre().intValue() != 0);
  }
  
  private Damj determinerDateEffetTheoriqueTrimestreRetraite(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    DureeCalendaire ageMinDepartRetraite = ParametresRetraite.getInstance().getAgeMinDepartRetraite(individu.getDateNaissance());
    
    Damj dateNaissanceIndividu = individu.getDateNaissance();
    
    Damj dateAnniversaireAgeMinDepartRetraite = null;
    if (dateNaissanceIndividu != null) {
      dateAnniversaireAgeMinDepartRetraite = dateNaissanceIndividu.deplacerVersAvant(ageMinDepartRetraite);
    } else {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_DATE_NAISSANCE_NON_RENSEIGNEE");
    }
    if ((individu.getTrimestreRetraite() == null) || (individu.getTrimestreRetraite().getDateEffet() == null)) {
      return dateAnniversaireAgeMinDepartRetraite;
    }
    int nombreTrimestreRequis = getNbTrimestresRequis(individu);
    
    return determinerDateEffetTheoriqueTrimestreRequis(nombreTrimestreRequis, individu);
  }
  
  public int bornerDureeALaRetraite(IndividuSpec individu, Damj pointDeDepart, Quantite dureeQuantite, boolean bornerALaRetraite)
    throws CoucheLogiqueException
  {
    int duree = 0;
    int nombreJours = dureeQuantite.getValeurEntiere();
    if (nombreJours > 0)
    {
      Damj dateRetraiteTheorique = OutillagePeriodes.genererPeriodeRetraite(individu).getDateEffet();
      Damj dateRetraite;
      Damj dateRetraite;
      if ((individu.getTrimestreRetraite() != null) && (individu.getTrimestreRetraite().getDateEffet() != null)) {
        dateRetraite = Damj.max(individu.getTrimestreRetraite().getDateEffet(), dateRetraiteTheorique);
      } else {
        dateRetraite = dateRetraiteTheorique;
      }
      Damj dji = pointDeDepart.deplacerVersAvant(new DureeCalendaire(0, 0, nombreJours - 1));
      if (((nombreJours != 1) || (!dateRetraite.coincideAvec(dji))) && (bornerALaRetraite) && (dateRetraite.estAvantOuCoincideAvec(dji))) {
        dji = dateRetraite.veille();
      }
      if (dji.estAvant(pointDeDepart)) {
        GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CONTEXTE_PJI_THEORIQUE_APRES_RETRAITE", new Object[] { pointDeDepart });
      }
      duree = pointDeDepart.joursEntre(dji) + 1;
    }
    return duree;
  }
  
  public int determinerNombreTrimestreAcquis(IndividuSpec individu, Damj dateCalcul)
    throws CoucheLogiqueException
  {
    int nombreTrimestreAcquis = 0;
    if ((estTrimestreSaisi(individu)) && (individu.getTrimestreRetraite().getDateEffet() != null))
    {
      Damj dateValeurNombreTrimestre = individu.getTrimestreRetraite().getDateEffet();
      
      Periode periode = new Periode(dateValeurNombreTrimestre, dateCalcul);
      DureeCalendaire duree = periode.getDureeCalendaire();
      int nombreMoisEcoule = duree.getAnnees() * 12 + duree.getMois();
      if (dateValeurNombreTrimestre.estAvant(dateCalcul)) {
        nombreTrimestreAcquis = individu.getTrimestreRetraite().getNombreTrimestre().intValue() + (int)Math.floor(nombreMoisEcoule / 3.0D);
      } else {
        nombreTrimestreAcquis = individu.getTrimestreRetraite().getNombreTrimestre().intValue() - (int)Math.ceil(nombreMoisEcoule / 3.0D);
      }
    }
    return nombreTrimestreAcquis;
  }
  
  private Damj determinerDateEffetTheoriqueTrimestreRequis(int nombreTrimestreRequis, IndividuSpec individu)
    throws CoucheLogiqueException
  {
    DureeCalendaire ageMinDepartRetraite = ParametresRetraite.getInstance().getAgeMinDepartRetraite(individu.getDateNaissance());
    
    Damj dateEffetTheoriqueTrimestreRequis = null;
    
    Damj dateNaissanceIndividu = individu.getDateNaissance();
    
    Damj dateAnniversaireAgeMinDepartRetraite = dateNaissanceIndividu.deplacerVersAvant(ageMinDepartRetraite);
    
    int nombreTrimestreAquis = individu.getTrimestreRetraite().getNombreTrimestre().intValue();
    
    Damj dateValeurNombreTrimestre = individu.getTrimestreRetraite().getDateEffet();
    
    Damj datePrevisionnelleTrimestreRequis = determinerDateAtteinteTrimestres(nombreTrimestreAquis, nombreTrimestreRequis, dateValeurNombreTrimestre);
    if (datePrevisionnelleTrimestreRequis.estApres(dateAnniversaireAgeMinDepartRetraite))
    {
      if (!datePrevisionnelleTrimestreRequis.estLeDebutDuMois()) {
        return datePrevisionnelleTrimestreRequis.getDebutMoisSuivant();
      }
      return datePrevisionnelleTrimestreRequis;
    }
    if (datePrevisionnelleTrimestreRequis.estAvantOuCoincideAvec(dateNaissanceIndividu.deplacerVersAvant(ageMinDepartRetraite)))
    {
      if (!dateNaissanceIndividu.estLeDebutDuMois()) {
        return dateNaissanceIndividu.deplacerVersAvant(ageMinDepartRetraite).getDebutMoisSuivant();
      }
      return dateNaissanceIndividu.deplacerVersAvant(ageMinDepartRetraite);
    }
    return dateEffetTheoriqueTrimestreRequis;
  }
  
  public Retraite determinerRetraite(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Retraite retraite;
    Retraite retraite;
    if (individu.getDateRetraiteAnticipe() != null) {
      retraite = new Retraite(individu.getDateRetraiteAnticipe(), 2, individu.getMotifRetraiteAnticipe());
    } else {
      retraite = new Retraite(determinerDateEffetTheoriquePensionRetraite(individu), 1);
    }
    return retraite;
  }
  
  private Damj determinerDateEffetTheoriquePensionRetraite(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Damj premierJourRetraite;
    Damj premierJourRetraite;
    if (individu.getDateLiquidationRetraite() != null)
    {
      premierJourRetraite = individu.getDateLiquidationRetraite();
    }
    else
    {
      Damj dateEffetTheoriquePensionRetraite = determinerDateEffetTheoriqueTrimestreRetraite(individu);
      
      Damj anniversaireAgeMinDepartRetraite = individu.getDateNaissance().getDateAnniversaire(ParametresRetraite.getInstance().getAgeMinDepartRetraite(individu.getDateNaissance()));
      
      Damj anniversaireAgeMaxDepartRetraite = individu.getDateNaissance().getDateAnniversaire(ParametresRetraite.getInstance().getAgeMaxDepartRetraite(individu.getDateNaissance()));
      Damj ageNormalDepartRetraite;
      Damj ageNormalDepartRetraite;
      if (dateEffetTheoriquePensionRetraite.estAvant(anniversaireAgeMaxDepartRetraite)) {
        ageNormalDepartRetraite = dateEffetTheoriquePensionRetraite;
      } else {
        ageNormalDepartRetraite = anniversaireAgeMaxDepartRetraite;
      }
      if (ageNormalDepartRetraite.estAvant(anniversaireAgeMinDepartRetraite)) {
        ageNormalDepartRetraite = anniversaireAgeMinDepartRetraite;
      }
      Damj premierJourRetraite;
      if (ageNormalDepartRetraite.estLeDebutDuMois()) {
        premierJourRetraite = ageNormalDepartRetraite;
      } else {
        premierJourRetraite = ageNormalDepartRetraite.getFinMois().lendemain();
      }
    }
    return premierJourRetraite;
  }
  
  public Damj determinerDateAtteinteTrimestres(int nombreTrimestresAcquis, int nombreTrimestresRequis, Damj dateValeurNombreTrimestre)
  {
    Damj datePrevisionnelleTrimestreRequis;
    Damj datePrevisionnelleTrimestreRequis;
    if (nombreTrimestresAcquis >= nombreTrimestresRequis)
    {
      int nombreMoisCorrespondant = (nombreTrimestresAcquis - nombreTrimestresRequis) * 3;
      datePrevisionnelleTrimestreRequis = dateValeurNombreTrimestre.deplacerVersArriere(new DureeCalendaire(0, nombreMoisCorrespondant, 0));
    }
    else
    {
      int nombreMoisCorrespondant = (nombreTrimestresRequis - nombreTrimestresAcquis) * 3;
      datePrevisionnelleTrimestreRequis = dateValeurNombreTrimestre != null ? dateValeurNombreTrimestre.deplacerVersAvant(new DureeCalendaire(0, nombreMoisCorrespondant, 0)) : null;
    }
    return datePrevisionnelleTrimestreRequis;
  }
  
  public int getNbTrimestresRequis(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    InfoRetraite infoRetraite = ParametresRetraite.getInstance().trouverInfoRetraite(individu.getDateNaissance());
    int nbTrimestresRequis = infoRetraite.getNbTrimestreRequisApresPivot();
    if (infoRetraite.getDatePivot() != null)
    {
      int nbTrimestresAcquisADatePivot = determinerNombreTrimestreAcquis(individu, infoRetraite.getDatePivot());
      if (nbTrimestresAcquisADatePivot < infoRetraite.getNbTrimestrePivot()) {
        nbTrimestresRequis = infoRetraite.getNbTrimestreRequisAvantPivot();
      }
    }
    return nbTrimestresRequis;
  }
  
  public Damj getDateMaxDepartRetraite(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Damj dateMaxRetraite = individu.getDateNaissance().deplacerVersAvant(ParametresRetraite.getInstance().getAgeMaxDepartRetraite(individu.getDateNaissance()));
    if (!dateMaxRetraite.estLeDebutDuMois()) {
      dateMaxRetraite = dateMaxRetraite.getFinMois().lendemain();
    }
    return dateMaxRetraite;
  }
  
  public Damj getDateMinDepartRetraite(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Damj dateMinRetraite = individu.getDateNaissance().deplacerVersAvant(ParametresRetraite.getInstance().getAgeMinDepartRetraite(individu.getDateNaissance()));
    if (!dateMinRetraite.estLeDebutDuMois()) {
      dateMinRetraite = dateMinRetraite.getFinMois().lendemain();
    }
    return dateMinRetraite;
  }
  
  public String formaterAge(DureeCalendaire dureeCalendaire)
  {
    String resultat = dureeCalendaire.getAnnees() + " ans";
    if (dureeCalendaire.getMois() > 0) {
      resultat = resultat + " " + dureeCalendaire.getMois() + " mois";
    }
    return resultat;
  }
  
  public DureeCalendaire getAgeMaxDepartRetraite(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    return ParametresRetraite.getInstance().getAgeMaxDepartRetraite(individu.getDateNaissance());
  }
  
  public DureeCalendaire getAgeMinDepartRetraite(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    return ParametresRetraite.getInstance().getAgeMinDepartRetraite(individu.getDateNaissance());
  }
  
  public static ObjetChrono60AnsBlocageRetraite genererBlocageRetraite60Ans(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    Damj jour60Ans = individu.getDateNaissance().deplacerVersAvant(new DureeCalendaire(60, 0, 0));
    if (individu.getDateLiquidationRetraite() == null) {
      return new ObjetChrono60AnsBlocageRetraite(jour60Ans);
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     OutilRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
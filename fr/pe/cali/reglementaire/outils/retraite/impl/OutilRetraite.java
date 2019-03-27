package fr.pe.cali.reglementaire.outils.retraite.impl;

import fr.pe.cali.reglementaire.outils.retraite.spec.IOutilRetraite;
import fr.pe.cali.reglementaire.parametres.retraite.ParametresRetraite;
import fr.unedic.cali.autresdoms.cohab.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.cali.calcul.dom.temps.ObjetChrono60AnsBlocageRetraite;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.Retraite;
import fr.unedic.cali.outilsfonctionnels.GestionnaireErreur;
import fr.unedic.cali.parametres.InfoRetraite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;

public class OutilRetraite
  implements IOutilRetraite
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
  
  public boolean estNbTrimestresSaisiOuDateRetraiteForcee(Damj dateRetraiteLiquidation, Damj dateRetraiteAnticipee, TrimestreRetraiteSpec trimestres)
  {
    return (dateRetraiteLiquidation != null) || (dateRetraiteAnticipee != null) || (estTrimestreSaisi(trimestres));
  }
  
  private boolean estTrimestreSaisi(TrimestreRetraiteSpec trimestres)
  {
    return (trimestres != null) && (trimestres.getNombreTrimestre() != null) && (trimestres.getNombreTrimestre().intValue() != 0);
  }
  
  private Damj determinerDateEffetTheoriqueTrimestreRetraite(Damj dateNaissanceIndividu, TrimestreRetraiteSpec trimestres)
    throws CoucheLogiqueException
  {
    DureeCalendaire ageMinDepartRetraite = ParametresRetraite.getInstance().getAgeMinDepartRetraite(dateNaissanceIndividu);
    
    Damj dateAnniversaireAgeMinDepartRetraite = null;
    if (dateNaissanceIndividu != null) {
      dateAnniversaireAgeMinDepartRetraite = dateNaissanceIndividu.deplacerVersAvant(ageMinDepartRetraite);
    } else {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_CALCUL_DATE_NAISSANCE_NON_RENSEIGNEE");
    }
    if ((trimestres == null) || (trimestres.getDateEffet() == null)) {
      return dateAnniversaireAgeMinDepartRetraite;
    }
    int nombreTrimestreRequis = getNbTrimestresRequis(dateNaissanceIndividu, trimestres);
    
    return determinerDateEffetTheoriqueTrimestreRequis(nombreTrimestreRequis, dateNaissanceIndividu, trimestres);
  }
  
  public int determinerNombreTrimestreAcquis(TrimestreRetraiteSpec trimestres, Damj dateCalcul)
    throws CoucheLogiqueException
  {
    int nombreTrimestreAcquis = 0;
    if ((estTrimestreSaisi(trimestres)) && (trimestres.getDateEffet() != null))
    {
      Damj dateValeurNombreTrimestre = trimestres.getDateEffet();
      
      Periode periode = new Periode(dateValeurNombreTrimestre, dateCalcul);
      DureeCalendaire duree = periode.getDureeCalendaire();
      int nombreMoisEcoule = duree.getAnnees() * 12 + duree.getMois();
      if (dateValeurNombreTrimestre.estAvant(dateCalcul)) {
        nombreTrimestreAcquis = trimestres.getNombreTrimestre().intValue() + (int)Math.floor(nombreMoisEcoule / 3.0D);
      } else {
        nombreTrimestreAcquis = trimestres.getNombreTrimestre().intValue() - (int)Math.ceil(nombreMoisEcoule / 3.0D);
      }
    }
    return nombreTrimestreAcquis;
  }
  
  private Damj determinerDateEffetTheoriqueTrimestreRequis(int nombreTrimestreRequis, Damj dateNaissanceIndividu, TrimestreRetraiteSpec trimestres)
    throws CoucheLogiqueException
  {
    DureeCalendaire ageMinDepartRetraite = ParametresRetraite.getInstance().getAgeMinDepartRetraite(dateNaissanceIndividu);
    
    Damj dateEffetTheoriqueTrimestreRequis = null;
    
    Damj dateAnniversaireAgeMinDepartRetraite = dateNaissanceIndividu.deplacerVersAvant(ageMinDepartRetraite);
    
    int nombreTrimestreAquis = trimestres.getNombreTrimestre().intValue();
    
    Damj dateValeurNombreTrimestre = trimestres.getDateEffet();
    
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
  
  public Retraite determinerRetraite(Damj dateNaissance, TrimestreRetraiteSpec trimestres, Damj dateLiquidationRetraite, Damj dateRetraiteAnticipee, String motifRetraiteAnticipe)
    throws CoucheLogiqueException
  {
    Retraite retraite;
    Retraite retraite;
    if (dateRetraiteAnticipee != null) {
      retraite = new Retraite(dateRetraiteAnticipee, 2, motifRetraiteAnticipe);
    } else {
      retraite = new Retraite(determinerDateEffetTheoriquePensionRetraite(dateNaissance, trimestres, dateLiquidationRetraite), 1);
    }
    return retraite;
  }
  
  private Damj determinerDateEffetTheoriquePensionRetraite(Damj dateNaissance, TrimestreRetraiteSpec trimestres, Damj dateLiquidationRetraite)
    throws CoucheLogiqueException
  {
    Damj premierJourRetraite;
    Damj premierJourRetraite;
    if (dateLiquidationRetraite != null)
    {
      premierJourRetraite = dateLiquidationRetraite;
    }
    else
    {
      Damj dateEffetTheoriquePensionRetraite = determinerDateEffetTheoriqueTrimestreRetraite(dateNaissance, trimestres);
      
      Damj anniversaireAgeMinDepartRetraite = dateNaissance.getDateAnniversaire(ParametresRetraite.getInstance().getAgeMinDepartRetraite(dateNaissance));
      
      Damj anniversaireAgeMaxDepartRetraite = dateNaissance.getDateAnniversaire(ParametresRetraite.getInstance().getAgeMaxDepartRetraite(dateNaissance));
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
  
  public Damj determinerDateAtteinteTrimestres(TrimestreRetraiteSpec trimestres, int nbTrimestresRequis)
    throws CoucheLogiqueException
  {
    Damj dateEffetNombreTrimestresAcquis = trimestres.getDateEffet();
    int nombreTrimestresAcquis = trimestres.getNombreTrimestre().intValue();
    
    Damj dateObtentionNombreTrimestresRequis = determinerDateAtteinteTrimestres(nombreTrimestresAcquis, nbTrimestresRequis, dateEffetNombreTrimestresAcquis);
    if (dateObtentionNombreTrimestresRequis == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_SOL_CONTEXTE_OBTENTION_TRIMESTRES", new Object[] { String.valueOf(nbTrimestresRequis) });
    }
    return dateObtentionNombreTrimestresRequis;
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
  
  public int getNbTrimestresRequis(Damj dateNaissance, TrimestreRetraiteSpec trimestres)
    throws CoucheLogiqueException
  {
    InfoRetraite infoRetraite = ParametresRetraite.getInstance().trouverInfoRetraite(dateNaissance);
    int nbTrimestresRequis = infoRetraite.getNbTrimestreRequisApresPivot();
    if (infoRetraite.getDatePivot() != null)
    {
      int nbTrimestresAcquisADatePivot = determinerNombreTrimestreAcquis(trimestres, infoRetraite.getDatePivot());
      if (nbTrimestresAcquisADatePivot < infoRetraite.getNbTrimestrePivot()) {
        nbTrimestresRequis = infoRetraite.getNbTrimestreRequisAvantPivot();
      }
    }
    return nbTrimestresRequis;
  }
  
  public Damj getDateMaxDepartRetraite(Damj dateNaissance)
    throws CoucheLogiqueException
  {
    Damj dateMaxRetraite = dateNaissance.deplacerVersAvant(ParametresRetraite.getInstance().getAgeMaxDepartRetraite(dateNaissance));
    if (!dateMaxRetraite.estLeDebutDuMois()) {
      dateMaxRetraite = dateMaxRetraite.getFinMois().lendemain();
    }
    return dateMaxRetraite;
  }
  
  public Damj getDateMinDepartRetraite(Damj dateNaissance)
    throws CoucheLogiqueException
  {
    Damj dateMinRetraite = dateNaissance.deplacerVersAvant(ParametresRetraite.getInstance().getAgeMinDepartRetraite(dateNaissance));
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
  
  public DureeCalendaire getAgeMaxDepartRetraite(Damj dateNaissanceIndividu)
    throws CoucheLogiqueException
  {
    return ParametresRetraite.getInstance().getAgeMaxDepartRetraite(dateNaissanceIndividu);
  }
  
  public DureeCalendaire getAgeMinDepartRetraite(Damj dateNaissanceIndividu)
    throws CoucheLogiqueException
  {
    return ParametresRetraite.getInstance().getAgeMinDepartRetraite(dateNaissanceIndividu);
  }
  
  public static ObjetChrono60AnsBlocageRetraite genererBlocageRetraite60Ans(Damj dateNaissance, Damj dateLiquidationRetraite)
    throws CoucheLogiqueException
  {
    Damj jour60Ans = dateNaissance.deplacerVersAvant(new DureeCalendaire(60, 0, 0));
    if (dateLiquidationRetraite == null) {
      return new ObjetChrono60AnsBlocageRetraite(jour60Ans);
    }
    return null;
  }
  
  public Damj determinerDateAtteinteTrimestres(IndividuSpec individu, int nbTrimestresRequis)
    throws CoucheLogiqueException
  {
    Damj dateEffetNombreTrimestresAcquis = individu.getTrimestreRetraite().getDateEffet();
    int nombreTrimestresAcquis = individu.getTrimestreRetraite().getNombreTrimestre().intValue();
    
    Damj dateObtentionNombreTrimestresRequis = determinerDateAtteinteTrimestres(nombreTrimestresAcquis, nbTrimestresRequis, dateEffetNombreTrimestresAcquis);
    if (dateObtentionNombreTrimestresRequis == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_PR_CALI_L_SOL_CONTEXTE_OBTENTION_TRIMESTRES", new Object[] { String.valueOf(nbTrimestresRequis) });
    }
    return dateObtentionNombreTrimestresRequis;
  }
}

/* Location:
 * Qualified Name:     OutilRetraite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
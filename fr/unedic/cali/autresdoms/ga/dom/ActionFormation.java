package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.util.Quantite;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public class ActionFormation
  extends Formation
{
  private static final long serialVersionUID = 8685174032084465850L;
  public static final int TYPE_HOMOLOGUEE_PRIORITAIRE = 1;
  public static final int TYPE_HOMOLOGUEE_NON_PRIORITAIRE = 2;
  public static final int TYPE_CONVENTIONNEE = 3;
  public static final int TYPE_AFPE = 4;
  public static final int TYPE_EXCLU = 5;
  public static final int TYPE_NON_ELIGIBLE = 6;
  public static final int TYPE_AFPR = 7;
  public static final int TYPE_JEUNE = 8;
  public static final int TYPE_AIF = 9;
  public static final int TYPE_POE = 0;
  public static final int TYPE_BDC = 10;
  public static final int TYPE_CPF = 11;
  public static final int TYPE_41C_AIF = 12;
  public static final int TYPE_41C = 13;
  public static final int TYPE_41N = 14;
  public static final int TYPE_AIF_REFUS = 15;
  public static final int TYPE_AIF_REFUS_DE = 16;
  public static final String STATUT_VALIDE = "V";
  public static final String STATUT_ENREGISTRE = "E";
  public static final String STATUT_ANNULE = "A";
  public static final String AFF_DEROGATOIRE_VRAI = "O";
  public static final String AFF_DEROGATOIRE_FAUX = "N";
  public static final String AFF_DEROGATOIRE_INCONNU = "X";
  public static final int NON_BENEFICIAIRE_RSA = 0;
  public static final int BENEFICIAIRE_RSA_DROIT_COMMUN = 1;
  public static final int BENEFICIAIRE_RSA_DEROGATOIRE = 2;
  public static final String NUMERO_CONVENTION_40C = "40C";
  public static final String NUMERO_CONVENTION_41C = "41C";
  public static final String NUMERO_CONVENTION_40A = "40A";
  public static final int CATEGORIE_FINANCEMENT_02 = 2;
  public static final int CATEGORIE_FINANCEMENT_14 = 14;
  public static final int CATEGORIE_FINANCEMENT_15 = 15;
  public static final int CATEGORIE_FINANCEMENT_16 = 16;
  public static final int CATEGORIE_FINANCEMENT_17 = 17;
  public static final int CATEGORIE_FINANCEMENT_18 = 18;
  public static final int CATEGORIE_FINANCEMENT_19 = 19;
  public static final int CATEGORIE_FINANCEMENT_20 = 20;
  private String mNumeroConvention;
  private BigDecimal mCategorieFinancement;
  private String mLibelleLieu;
  private Quantite mQuantiteHoraireHebdo;
  private int mTypeConvention = 0;
  private String mIdentifiantConvention;
  private String mAffDerogatoire;
  private ChronologiePeriodes mListePeriodeFormation;
  private ChronologiePeriodes mListePeriodeAbsenceFormation;
  private String mTypePlanFormation;
  private BigDecimal mMontantPlafondPriseEnCharge = BigDecimal.ZERO;
  private BigDecimal mPourcentagePriseEnCharge = BigDecimal.ZERO;
  private String mIdDemandeRBFLiee;
  private String mStatut;
  private Damj mDatePrescription;
  private int mTypeBeneficiaireRSA = 0;
  private String mOrigineSaisieFormation;
  
  public ActionFormation()
  {
    mListePeriodeFormation = new ChronologiePeriodes();
    mListePeriodeAbsenceFormation = new ChronologiePeriodes();
  }
  
  public ActionFormation(Damj dateDebut, Damj dateFin)
  {
    super(dateDebut, dateFin);
    mListePeriodeFormation = new ChronologiePeriodes();
    mListePeriodeAbsenceFormation = new ChronologiePeriodes();
  }
  
  public ActionFormation(Periode periode)
  {
    super(periode);
    mListePeriodeFormation = new ChronologiePeriodes();
    mListePeriodeAbsenceFormation = new ChronologiePeriodes();
  }
  
  public boolean isAffDerogatoireVrai()
  {
    return mAffDerogatoire.equals("O");
  }
  
  public boolean isAffDerogatoireFaux()
  {
    return mAffDerogatoire.equals("N");
  }
  
  public boolean isAffDerogatoireInconnu()
  {
    return mAffDerogatoire.equals("X");
  }
  
  public String getLibelleLieu()
  {
    return mLibelleLieu;
  }
  
  public ChronologiePeriodes getListePeriodeFormation()
  {
    return mListePeriodeFormation;
  }
  
  public ChronologiePeriodes getListePeriodeAbsenceFormation()
  {
    return mListePeriodeAbsenceFormation;
  }
  
  public String getNumeroConvention()
  {
    return mNumeroConvention;
  }
  
  public Quantite getQuantiteHoraireHebdo()
  {
    return mQuantiteHoraireHebdo;
  }
  
  public int getTypeConvention()
  {
    return mTypeConvention;
  }
  
  public void setAffDerogatoire(String string)
  {
    mAffDerogatoire = string;
  }
  
  public void setLibelleLieu(String string)
  {
    mLibelleLieu = string;
  }
  
  public void setListePeriodeFormation(ChronologiePeriodes listePeriodeFormation)
  {
    if (listePeriodeFormation != null) {
      mListePeriodeFormation = listePeriodeFormation;
    }
  }
  
  public void ajouterPeriodeFormation(PeriodeFormation periodeFormation)
  {
    mListePeriodeFormation.ajouter(periodeFormation);
  }
  
  public void setListePeriodeAbsenceFormation(ChronologiePeriodes listePeriodeAbsenceFormation)
  {
    if (listePeriodeAbsenceFormation != null) {
      mListePeriodeAbsenceFormation = listePeriodeAbsenceFormation;
    }
  }
  
  public void ajouterPeriodeAbsenceFormation(PeriodeGaec periodeAbsenceFormation)
  {
    mListePeriodeAbsenceFormation.ajouter(periodeAbsenceFormation);
  }
  
  public void setNumeroConvention(String string)
  {
    mNumeroConvention = string;
  }
  
  public void setQuantiteHoraireHebdo(Quantite quantite)
  {
    mQuantiteHoraireHebdo = quantite;
  }
  
  public void setTypeConvention(int typeConvention)
  {
    mTypeConvention = typeConvention;
  }
  
  public boolean determineEstEffective()
  {
    boolean estEffective = false;
    if ((getListePeriodeFormation() != null) && (!getListePeriodeFormation().estVide()))
    {
      Iterator iter = getListePeriodeFormation().iterer();
      while ((!estEffective) && (iter.hasNext()))
      {
        PeriodeFormation pf = (PeriodeFormation)iter.next();
        estEffective = pf.getPeriodeEffective() != null;
      }
    }
    return estEffective;
  }
  
  public String getEtatAffDerogatoire()
  {
    return mAffDerogatoire;
  }
  
  public String getTypePlanFormation()
  {
    return mTypePlanFormation;
  }
  
  public void setTypePlanFormation(String typePlanFormation)
  {
    mTypePlanFormation = typePlanFormation;
  }
  
  public BigDecimal getMontantPlafondPriseEnCharge()
  {
    return mMontantPlafondPriseEnCharge;
  }
  
  public void setMontantPlafondPriseEnCharge(BigDecimal montantPlafondPriseEnCharge)
  {
    mMontantPlafondPriseEnCharge = montantPlafondPriseEnCharge;
  }
  
  public BigDecimal getPourcentagePriseEnCharge()
  {
    return mPourcentagePriseEnCharge;
  }
  
  public void setPourcentagePriseEnCharge(BigDecimal pourcentagePriseEnCharge)
  {
    mPourcentagePriseEnCharge = pourcentagePriseEnCharge;
  }
  
  public Damj getDateExamen()
  {
    Damj dateReexamen = null;
    if ((getListePeriodeFormation() == null) || (getListePeriodeFormation().estVide()))
    {
      dateReexamen = getDateDebut();
    }
    else
    {
      ChronologiePeriodes listePeriodesFormation = getListePeriodeFormation();
      PeriodeFormation periodeFormation = (PeriodeFormation)listePeriodesFormation.premierElement();
      if (periodeFormation.getPeriodeEffective() != null) {
        dateReexamen = periodeFormation.getPeriodeEffective().getDebut();
      } else if (periodeFormation.getPeriodePrevisionnnelle() != null) {
        dateReexamen = periodeFormation.getPeriodePrevisionnnelle().getDebut();
      }
    }
    return dateReexamen;
  }
  
  public PeriodeFormation getPeriodeFormation(ObjetChronoPeriode periodeLieu)
  {
    if ((getListePeriodeFormation() != null) && (!getListePeriodeFormation().estVide()))
    {
      Iterator iterPeriodeFormation = getListePeriodeFormation().mapperVersListe().iterator();
      while (iterPeriodeFormation.hasNext())
      {
        PeriodeFormation periodeFormation = (PeriodeFormation)iterPeriodeFormation.next();
        if ((periodeLieu.getDateDebut().estApresOuCoincideAvec(periodeFormation.getDateDebut())) && (periodeLieu.getDateFin().estAvantOuCoincideAvec(periodeFormation.getDateFin()))) {
          return periodeFormation;
        }
      }
    }
    return null;
  }
  
  public String getIdentifiantConvention()
  {
    return mIdentifiantConvention;
  }
  
  public void setIdentifiantConvention(String identifiantConvention)
  {
    mIdentifiantConvention = identifiantConvention;
  }
  
  public void setStatut(String statut)
  {
    mStatut = statut;
  }
  
  public String getStatut()
  {
    return mStatut;
  }
  
  public boolean estAnnulee()
  {
    return (mStatut != null) && (mStatut.equalsIgnoreCase("A"));
  }
  
  public Damj getDatePrescription()
  {
    return mDatePrescription;
  }
  
  public void setDatePrescription(Damj datePrescription)
  {
    mDatePrescription = datePrescription;
  }
  
  public int getTypeBeneficiaireRSA()
  {
    return mTypeBeneficiaireRSA;
  }
  
  public void setTypeBeneficiaireRSA(int typeBeneficiaireRSA)
  {
    mTypeBeneficiaireRSA = typeBeneficiaireRSA;
  }
  
  public Damj retrouverDateDebutFormation()
  {
    Damj dateDebutFormation;
    Damj dateDebutFormation;
    if (!determineEstEffective())
    {
      dateDebutFormation = getDateDebut();
    }
    else
    {
      PeriodeFormation pf = (PeriodeFormation)getListePeriodeFormation().premierElement();
      Damj dateDebutFormation;
      if ((pf.getPeriodeEffective() != null) && (pf.getPeriodeEffective().getDebut() != null)) {
        dateDebutFormation = pf.getPeriodeEffective().getDebut();
      } else {
        dateDebutFormation = pf.getPeriodePrevisionnnelle().getDebut();
      }
    }
    return dateDebutFormation;
  }
  
  public BigDecimal getCategorieFinancement()
  {
    return mCategorieFinancement;
  }
  
  public void setCategorieFinancement(BigDecimal categorieFinancement)
  {
    mCategorieFinancement = categorieFinancement;
  }
  
  public String getIdDemandeRBFLiee()
  {
    return mIdDemandeRBFLiee;
  }
  
  public void setIdDemandeRBFLiee(String idDemandeRBFLiee)
  {
    mIdDemandeRBFLiee = idDemandeRBFLiee;
  }
  
  public String getOrigineSaisieFormation()
  {
    return mOrigineSaisieFormation;
  }
  
  public void setOrigineSaisieFormation(String origineSaisieFormation)
  {
    mOrigineSaisieFormation = origineSaisieFormation;
  }
  
  public boolean estAisAutomatisee()
  {
    boolean estAisAutomatisee = false;
    if ("A".equals(getOrigineSaisieFormation())) {
      estAisAutomatisee = true;
    }
    return estAisAutomatisee;
  }
}

/* Location:
 * Qualified Name:     ActionFormation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.autresdoms.cohab.sigma.formation.dom.spec;

import fr.unedic.util.Quantite;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Temporel;
import java.math.BigDecimal;

public abstract interface ActionFormationSpec
  extends Temporel
{
  public static final String TYPE_CONVENTION_FORMATION_AFPE = "A";
  public static final String TYPE_CONVENTION_FORMATION_CONVENTIONNEE = "C";
  public static final String TYPE_CONVENTION_FORMATION_HOMOLOGUEE = "H";
  public static final String TYPE_CONVENTION_FORMATION_NON_HOMOLOGUEE = "N";
  public static final String TYPE_CONVENTION_FORMATION_HOMOLOGUEE_PRIORITAIRE = "P";
  public static final String TYPE_CONVENTION_FORMATION_NON_ELIGIBLE = "X";
  public static final String TYPE_CONVENTION_FORMATION_POE = "O";
  public static final String TYPE_CONVENTION_FORMATION_AIF = "A";
  public static final String AFF_DEROGATOIRE_DECISION_POSITIVE = "O";
  public static final String AFF_DEROGATOIRE_DECISION_NEGATIVE = "N";
  public static final String AFF_DEROGATOIRE_DECISION_INCONNUE = " ";
  public static final String TYPE_PLAN_FORMATION_ANPE = "1";
  public static final String TYPE_PLAN_FORMATION_TEMOIN = "2";
  public static final String TYPE_PLAN_FORMATION_AFR = "3";
  public static final String TYPE_PLAN_FORMATION_CFJ = "4";
  public static final String TYPE_PLAN_FORMATION_AFRE = "5";
  public static final String TYPE_PLAN_FORMATION_RSP = "6";
  public static final String TYPE_PLAN_FORMATION_AREF = "7";
  public static final String TYPE_PLAN_FORMATION_ASC = "8";
  public static final String TYPE_PLAN_FORMATION_FONDS_SOCIAUX = "9";
  public static final String MESURE_STAGE_MODULAIRE = "01";
  public static final String MESURE_STAGE_ACCES_EMPLOI = "02";
  public static final String MESURE_STAGE_FNE_CADRES = "04";
  public static final String MESURE_STAGE_JEUNES_12_25_ANS = "05";
  public static final String MESURE_STAGE_REINSERTION_PROFESSIONNEL = "07";
  public static final String MESURE_STAGE_INIT_VIE_PROFESSIONNELLE = "12";
  public static final String MESURE_STAGE_FNE_FEMMES_ISOLEES = "14";
  public static final String MESURE_CONTRAT_ORIENTATION = "20";
  public static final String MESURE_CONTRAT_ADAPTATION = "21";
  public static final String MESURE_CONTRAT_QUALIFICATION = "22";
  public static final String MESURE_CONTRAT_APPRENTISSAGE = "23";
  public static final String MESURE_CONTRAT_RETOUR_EMPLOI = "24";
  public static final String MESURE_CONTRAT_EMPLOI_SOLIDARITE = "26";
  public static final String MESURE_CONTRAT_LOCAL_ORIENTATION = "27";
  public static final String MESURE_AUTRES = "99";
  public static final int MOTIF_RUPTURE_NON_ACHEVEE = 1;
  public static final int MOTIF_RUPTURE_ABANDON_STAGE = 2;
  public static final int MOTIF_RUPTURE_AUTRE = 3;
  public static final String ETAT_FORMATION_VALIDEE = "V";
  public static final String ETAT_FORMATION_ENREGISTREE = "E";
  public static final String ETAT_FORMATION_ANNULEE = "A";
  public static final String TOP_BENEFICIAIRE_RSA_COMMUN = "C";
  public static final String TOP_BENEFICIAIRE_RSA_DEROGATOIRE = "D";
  public static final int NON_BENEFICIAIRE_RSA = 0;
  public static final int BENEFICIAIRE_RSA_DROIT_COMMUN = 1;
  public static final int BENEFICIAIRE_RSA_DEROGATOIRE = 2;
  
  public abstract String getAffDerogatoire();
  
  public abstract int getIdentifiantActionFormation();
  
  public abstract String getLibelleLieu();
  
  public abstract String getLibelleOrganisme();
  
  public abstract String getNumeroConvention();
  
  public abstract Quantite getQuantiteHoraireHebdo();
  
  public abstract Quantite getQuantiteHoraireTotal();
  
  public abstract String getTypeConvention();
  
  public abstract String getTypePlanFormation();
  
  public abstract void setTypePlanFormation(String paramString);
  
  public abstract void setAffDerogatoire(String paramString);
  
  public abstract void setIdentifiantActionFormation(int paramInt);
  
  public abstract void setLibelleLieu(String paramString);
  
  public abstract void setLibelleOrganisme(String paramString);
  
  public abstract void setNumeroConvention(String paramString);
  
  public abstract void setQuantiteHoraireHebdo(Quantite paramQuantite);
  
  public abstract void setQuantiteHoraireTotal(Quantite paramQuantite);
  
  public abstract void setTypeConvention(String paramString);
  
  public abstract Chronologie getCollectionPeriodesFormation();
  
  public abstract void ajouterPeriodeFormation(PeriodeFormationSpec paramPeriodeFormationSpec);
  
  public abstract String getTypeMesureEmploi();
  
  public abstract void setTypeMesureEmploi(String paramString);
  
  public abstract int getMotifRupture();
  
  public abstract void setMotifRupture(int paramInt);
  
  public abstract String getCodeTiersOrganisme();
  
  public abstract void setCodeTiersOrganisme(String paramString);
  
  public abstract int getFormacode();
  
  public abstract void setFormacode(int paramInt);
  
  public abstract String getIdentifiantConvention();
  
  public abstract void setIdentifiantConvention(String paramString);
  
  public abstract String getIntitule();
  
  public abstract void setIntitule(String paramString);
  
  public abstract String getLibelle();
  
  public abstract void setLibelle(String paramString);
  
  public abstract BigDecimal getPlafondConvention();
  
  public abstract void setPlafondConvention(BigDecimal paramBigDecimal);
  
  public abstract BigDecimal getPourcentageEngage();
  
  public abstract void setPourcentageEngage(BigDecimal paramBigDecimal);
  
  public abstract String getEtat();
  
  public abstract void setEtat(String paramString);
  
  public abstract void setDatePrescription(Damj paramDamj);
  
  public abstract Damj getDatePrescription();
  
  public abstract int getCategorieFinancement();
  
  public abstract void setCategorieFinancement(int paramInt);
  
  public abstract boolean isPresencePrescriptionFormation();
  
  public abstract void setPresencePrescriptionFormation(boolean paramBoolean);
}

/* Location:
 * Qualified Name:     ActionFormationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
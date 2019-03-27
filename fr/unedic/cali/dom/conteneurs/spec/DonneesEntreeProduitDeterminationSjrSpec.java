package fr.unedic.cali.dom.conteneurs.spec;

import fr.unedic.cali.dom.conteneurs.DonneeEntreeParametre;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;

public abstract interface DonneesEntreeProduitDeterminationSjrSpec
{
  public static final String NOM_PARAM_PLAFOND_MENSUEL_SR_SJR = "PLAFOND MENSUEL SR SJR";
  public static final String NOM_PARAM_PLAFOND_MENSUEL_SR_SJR_MAYOTTE = "PLAFOND MENSUEL SR SJR MAYOTTE";
  public static final String NOM_PARAM_SMIC_MENSUEL_BASE_35H = "SMIC MENSUEL BASE 35H";
  public static final String NOM_PARAM_SFJ_A2B_CAT = "SFJ A2B CATEGORIE ";
  public static final String NOM_PARAM_FACULTATIF_PLAFOND_JOURNALIER_SJR = "FACULTATIF PLAFOND JOURNALIER SJR";
  public static final String NOM_PARAM_FACULTATIF_PLAFOND_PRC_SR = "FACULTATIF PLAFOND PRC SR";
  public static final String NOM_PARAM_PLAFOND_JOURNALIER_SECURITE_SOCIALE = "PLAFOND JOURNALIER SECURITE SOCIALE";
  
  public abstract BigDecimal getParametrePlafondDiviseurPrc();
  
  public abstract void setParametrePlafondDiviseurPrc(BigDecimal paramBigDecimal);
  
  public abstract boolean ajouterParametre(String paramString, DonneeEntreeParametre paramDonneeEntreeParametre);
  
  public abstract DonneeEntreeParametre getParametreActif(String paramString, Damj paramDamj);
  
  public abstract void supprimerParametre(String paramString);
}

/* Location:
 * Qualified Name:     DonneesEntreeProduitDeterminationSjrSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
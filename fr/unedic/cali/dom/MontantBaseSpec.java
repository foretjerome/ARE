package fr.unedic.cali.dom;

import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import java.math.BigDecimal;

public abstract interface MontantBaseSpec
  extends ObjetMetierSpec, ObjetPersistantSpec
{
  public static final String TYPE_NORMAL = "NORMAL";
  public static final String TYPE_FORMATION_PREVISIONNELLE = "FORMATION PREVISIONNELLE";
  public static final String TYPE_FORMATION_EFFECTIVE = "FORMATION EFFECTIVE";
  
  public abstract Quantite getBase();
  
  public abstract Quantite getCotisationContribution();
  
  public abstract Quantite getCrc();
  
  public abstract Quantite getCrds();
  
  public abstract Quantite getCsg();
  
  public abstract Quantite getMini();
  
  public abstract Quantite getMontantBrut();
  
  public abstract Quantite getMontantNet();
  
  public abstract Quantite getPlafond();
  
  public abstract Quantite getPlancher();
  
  public abstract String getType();
  
  public abstract Quantite getMontantBrutSansPensionInvaliditeADeduire();
  
  public abstract Quantite getPensionInvaliditeADeduirePriseEnCompte();
  
  public abstract Quantite getMontantBrutSansAvantageVieillesseDeduit()
    throws CoucheLogiqueException;
  
  public abstract Quantite getMontantJournalierAvantageVieillesse();
  
  public abstract Quantite getMontantJournalierAvantageVieillesseDeduit();
  
  public abstract String getJustificationCalculMontant();
  
  public abstract boolean getAvecPrecompteCRC();
  
  public abstract BigDecimal getMontantPrecompte();
  
  public abstract Quantite getMontantPrecompteEffectif();
  
  public abstract BigDecimal getSjrNonReduit();
  
  public abstract BigDecimal getBaseCalculCrc();
  
  public abstract String getPositionExonerationCrc();
  
  public abstract BigDecimal getTauxCrc();
  
  public abstract void setMontantBrut(Quantite paramQuantite);
  
  public abstract void setType(String paramString);
  
  public abstract void setCrc(Quantite paramQuantite);
  
  public abstract void setAvecPrecompteCRC(boolean paramBoolean);
  
  public abstract void setJustificationCalculMontant(String paramString);
  
  public abstract Quantite getMiniFormation();
  
  public abstract BigDecimal getMontantFinancement();
  
  public abstract Quantite getCsgEstimee();
  
  public abstract Quantite getCrdsEstimee();
  
  public abstract Quantite getCcamEstimee(boolean paramBoolean);
  
  public abstract Quantite getMontantNetEstime(boolean paramBoolean);
  
  public abstract BigDecimal getMontantReduit();
}

/* Location:
 * Qualified Name:     MontantBaseSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ResultatActiviteReduite;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.SalaireJournalierSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.List;

public abstract interface ProduitAsuDelegueSpec
  extends ProduitDelegueSpec, FacadeLiquidationProduitAsuSpec
{
  public abstract void controlerContexteDonneesForcees(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void controlerContexteDonneesForceesPostLiquidation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract int getNombreJoursIndemnisationNecessairesMaintien();
  
  public abstract DureeCalendaire getAgeMinimumObtentionMaintien(DemandeSpec paramDemandeSpec);
  
  public abstract SalaireJournalierSpec getSalaireJournalier(AttributionSpec paramAttributionSpec, Damj paramDamj);
  
  public abstract Chronologie getListeActivitesConserveesAttributionAreLiee(AttributionSpec paramAttributionSpec);
  
  public abstract String getCodeSirenEmployeurFaitGenerateur(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal recupererSeuilMensuelHoraireActiviteReduite();
  
  public abstract int recupererNombreMoisCumulMaxActiviteReduite();
  
  public abstract int recupererNombreMoisCumulCourrierKC6F();
  
  public abstract int recupererNombreMoisIndemnisation(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract List recupererParametresPourLiquidationSimplifiee(Periode paramPeriode);
  
  public abstract BigDecimal recupererSeuilRemuneration(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws CoucheLogiqueException;
  
  public abstract boolean recupererLeverBornageRetraite(AttributionSpec paramAttributionSpec);
  
  public abstract ResultatActiviteReduite calculActiviteReduite(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, BigDecimal paramBigDecimal3, BigDecimal paramBigDecimal4, String paramString, Periode paramPeriode)
    throws CoucheLogiqueException;
  
  public abstract BigDecimal getCrcSimuActiviteReduite(BigDecimal paramBigDecimal1, BigDecimal paramBigDecimal2, Damj paramDamj);
  
  public abstract Resultat determinerContexteExamen(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract String recupererIdAeBatimentPourICCPConservatoire(AttributionSpec paramAttributionSpec);
}

/* Location:
 * Qualified Name:     ProduitAsuDelegueSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.List;

public abstract interface ProduitAsuSpec
  extends ProduitSpec, FacadeLiquidationProduitAsuSpec
{
  public abstract void controlerContexteDonneesForcees(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract void controlerContexteDonneesForceesPostLiquidation(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract DureeCalendaire getAgeMinimumObtentionMaintien(DemandeSpec paramDemandeSpec);
  
  public abstract String getCodeSirenEmployeurFaitGenerateur(AttributionSpec paramAttributionSpec);
  
  public abstract BigDecimal recupererSeuilMensuelHoraireActiviteReduite();
  
  public abstract int recupererNombreMoisCumulMaxActiviteReduite();
  
  public abstract int recupererNombreMoisCumulCourrierKC6F();
  
  public abstract int recupererNombreMoisIndemnisation(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract List recupererParametresPourLiquidationSimplifiee(Periode paramPeriode);
  
  public abstract BigDecimal recupererSeuilRemuneration(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract boolean recupererLeverBornageRetraite(AttributionSpec paramAttributionSpec);
  
  public abstract boolean estUnProduitRevisable();
  
  public abstract Resultat determinerContexteExamen(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract MontantBaseSpec calculerMontantAUneDate(AttributionSpec paramAttributionSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract boolean estUnProduitSansDuree();
  
  public abstract String recupererIdAeBatimentPourICCPConservatoire(AttributionSpec paramAttributionSpec);
  
  public abstract boolean neDoitPasSanctionnerPndsPourCouvertureDv();
}

/* Location:
 * Qualified Name:     ProduitAsuSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
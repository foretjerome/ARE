package fr.unedic.cali.autresdoms.ga.dom.spec;

import fr.unedic.cali.dom.IndividuDomaineSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract interface IndividuGaSpec
  extends IndividuDomaineSpec
{
  public abstract boolean ajouterPeriodePasseProfessionnel(PeriodeGaecSpec paramPeriodeGaecSpec)
    throws IllegalArgumentException;
  
  public abstract ChronologiePeriodes getChronoPeriodePasseProfessionnel();
  
  public abstract ChronologiePeriodes getChronoPeriodePasseProfessionnelSansFiltrageDNJ();
  
  public abstract ChronologiePeriodes getChronoPeriodePasseProfessionnelPourLiquidationSansFiltrageDNJ();
  
  public abstract void setChronoPeriodePasseProfessionnelSansFiltrageDNJ(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract ChronologiePeriodes getChronoPeriodePasseProfessionnelLiquidation();
  
  public abstract ChronologiePeriodes getChronoPeriodePasseProfessionnelEcartees();
  
  public abstract void setChronoPeriodePasseProfessionnelLiquidation(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract void enregistrerLA2K(IndividuSpec paramIndividuSpec, Damj paramDamj, ContexteService paramContexteService, int paramInt);
  
  public abstract Collection getActionsFormation();
  
  public abstract Collection getActionsFormationRps();
  
  public abstract Collection getActionFormationRpsRbf();
  
  public abstract void setChronoPeriodePasseProfessionnelLiquidationRevision(ChronologiePeriodes paramChronologiePeriodes);
  
  public abstract void activerChronoPasseProPourLiquidationRevision();
  
  public abstract void desactiverChronoPasseProPourLiquidationRevision();
  
  public abstract void reactiverChronoPasseProPourLiquidationRevision();
  
  public abstract void activerExclusionChronoPasseProPourLiquidationFCTRevision();
  
  public abstract void desactiverExclusionChronoPasseProPourLiquidationFCTRevision();
  
  public abstract void reactiverExclusionChronoPasseProPourLiquidationFCTRevision();
}

/* Location:
 * Qualified Name:     IndividuGaSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
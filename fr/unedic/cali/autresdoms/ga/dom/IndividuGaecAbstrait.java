package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.dom.spec.IndividuGaSpec;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.IndividuChargementSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActionsFormation;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActionsFormationRps;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract class IndividuGaecAbstrait
  implements IndividuGaSpec, IndividuChargementSpec
{
  private static final String NOM_INDIVIDU = "GAEC";
  private transient IndividuIdSpec identifiant = null;
  private transient ChronologiePeriodes chronoPeriodePasseProfessionnel;
  private transient ChronologiePeriodes chronoPeriodePasseProfessionnelLiquidation;
  private transient ChronologiePeriodes chronoPeriodePasseProfessionnelRevision;
  private transient ChronologiePeriodes chronoPeriodePasseProfessionnelEcartees;
  private transient boolean estCharge;
  private transient boolean estModifiable;
  private transient boolean etatActivationPasseProRevision;
  private transient boolean etatPrecedentActivationPasseProRevision;
  private transient boolean etatActivationExclusionFctRevision;
  private transient boolean etatPrecedentActivationExclusionFctRevision;
  private transient Collection<PeriodeGaec> actionsFormation;
  private transient Collection<PeriodeGaec> actionsFormationRps;
  private transient Collection<PeriodeGaec> actionsFormationRbfRps;
  
  public IndividuGaecAbstrait()
  {
    chronoPeriodePasseProfessionnel = new ChronologiePeriodes();
    chronoPeriodePasseProfessionnelLiquidation = new ChronologiePeriodes();
    chronoPeriodePasseProfessionnelEcartees = new ChronologiePeriodes();
    chronoPeriodePasseProfessionnelRevision = new ChronologiePeriodes();
  }
  
  public IndividuGaecAbstrait(IndividuIdSpec individuIdSpec)
  {
    setIndividuId(individuIdSpec);
    chronoPeriodePasseProfessionnel = new ChronologiePeriodes();
    chronoPeriodePasseProfessionnelLiquidation = new ChronologiePeriodes();
    chronoPeriodePasseProfessionnelEcartees = new ChronologiePeriodes();
    chronoPeriodePasseProfessionnelRevision = new ChronologiePeriodes();
  }
  
  public IndividuIdSpec getIndividuId()
  {
    return identifiant;
  }
  
  public void setIndividuId(IndividuIdSpec pIdentifiant)
  {
    identifiant = pIdentifiant;
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnel()
  {
    return getChronoPeriodePasseProfessionnelSansFiltrageDNJ();
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnelSansFiltrageDNJ()
  {
    return chronoPeriodePasseProfessionnel;
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnelPourLiquidationSansFiltrageDNJ()
  {
    ChronologiePeriodes chronoPeriode = chronoPeriodePasseProfessionnel;
    if (etatActivationPasseProRevision) {
      chronoPeriode = chronoPeriodePasseProfessionnelRevision;
    }
    return chronoPeriode;
  }
  
  public void setChronoPeriodePasseProfessionnelSansFiltrageDNJ(ChronologiePeriodes periodePasseProfessionnel)
  {
    chronoPeriodePasseProfessionnel = periodePasseProfessionnel;
    chronoPeriodePasseProfessionnelLiquidation = periodePasseProfessionnel;
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnelLiquidation()
  {
    if ((etatActivationPasseProRevision) || (etatActivationExclusionFctRevision)) {
      return chronoPeriodePasseProfessionnelRevision;
    }
    return chronoPeriodePasseProfessionnelLiquidation;
  }
  
  public void setChronoPeriodePasseProfessionnelLiquidation(ChronologiePeriodes periodePasseProfessionnelLiquidation)
  {
    chronoPeriodePasseProfessionnelLiquidation = periodePasseProfessionnelLiquidation;
  }
  
  public ChronologiePeriodes getChronoPeriodePasseProfessionnelEcartees()
  {
    return chronoPeriodePasseProfessionnelEcartees;
  }
  
  public void setChronoPeriodePasseProfessionnelEcartees(ChronologiePeriodes pChronoPeriodePasseProfessionnelEcartees)
  {
    chronoPeriodePasseProfessionnelEcartees = pChronoPeriodePasseProfessionnelEcartees;
  }
  
  public Collection getActionsFormation()
  {
    if (actionsFormation == null) {
      actionsFormation = getChronoPeriodePasseProfessionnelLiquidation().copier(new FiltreActionsFormation()).mapperVersCollection();
    }
    return actionsFormation;
  }
  
  public Collection getActionsFormationRps()
  {
    if (actionsFormationRps == null) {
      actionsFormationRps = getChronoPeriodePasseProfessionnelLiquidation().copier(new FiltreActionsFormationRps()).mapperVersCollection();
    }
    return actionsFormationRps;
  }
  
  public Collection<PeriodeGaec> getActionFormationRpsRbf()
  {
    if (actionsFormationRbfRps == null)
    {
      actionsFormationRbfRps = getChronoPeriodePasseProfessionnelLiquidation().copier(new FiltreActionsFormationRps()).mapperVersCollection();
      
      actionsFormationRbfRps.addAll(getChronoPeriodePasseProfessionnelLiquidation().copier(new FiltreActionsFormation()).mapperVersCollection());
    }
    return actionsFormationRbfRps;
  }
  
  public abstract void enregistrerLA2K(IndividuSpec paramIndividuSpec, Damj paramDamj, ContexteService paramContexteService, int paramInt);
  
  public boolean ajouterPeriodePasseProfessionnel(PeriodeGaecSpec periode)
    throws IllegalArgumentException
  {
    if (periode == null) {
      throw new IllegalArgumentException("Paramètre période passé professionnel null: ajoût de période passé professionnel sur l'individu [" + getIndividuId() + "] impossible.");
    }
    chronoPeriodePasseProfessionnel.ajouter(periode);
    chronoPeriodePasseProfessionnelLiquidation.ajouter(periode);
    
    return false;
  }
  
  public abstract IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException;
  
  public abstract IndividuChargementSpec charger(AppelGaecReduit paramAppelGaecReduit)
    throws ApplicativeException, TechniqueException;
  
  public boolean estCharge()
  {
    return estCharge;
  }
  
  public void setEstCharge(boolean pEstCharge)
  {
    estCharge = pEstCharge;
  }
  
  public boolean estModifiable()
  {
    return estModifiable;
  }
  
  public void setEstModifiable(boolean modifiable)
  {
    estModifiable = modifiable;
  }
  
  public String getNomIndividu()
  {
    return "GAEC";
  }
  
  public String toString()
  {
    StringBuffer chaineRetour = new StringBuffer();
    
    chaineRetour.append("Individu :" + getIndividuId() + "\n");
    chaineRetour.append("ACTIVITE : \n" + getChronoPeriodePasseProfessionnelLiquidation() + "\n");
    
    return chaineRetour.toString();
  }
  
  public void activerChronoPasseProPourLiquidationRevision()
  {
    etatActivationPasseProRevision = true;
  }
  
  public void desactiverChronoPasseProPourLiquidationRevision()
  {
    etatPrecedentActivationPasseProRevision = etatActivationPasseProRevision;
    etatActivationPasseProRevision = false;
  }
  
  public void reactiverChronoPasseProPourLiquidationRevision()
  {
    etatActivationPasseProRevision = etatPrecedentActivationPasseProRevision;
  }
  
  public void setChronoPeriodePasseProfessionnelLiquidationRevision(ChronologiePeriodes periodesPasseProfessionnel)
  {
    chronoPeriodePasseProfessionnelRevision = periodesPasseProfessionnel;
  }
  
  public void activerExclusionChronoPasseProPourLiquidationFCTRevision()
  {
    etatActivationExclusionFctRevision = true;
  }
  
  public void desactiverExclusionChronoPasseProPourLiquidationFCTRevision()
  {
    etatPrecedentActivationExclusionFctRevision = etatActivationExclusionFctRevision;
    etatActivationExclusionFctRevision = false;
  }
  
  public void reactiverExclusionChronoPasseProPourLiquidationFCTRevision()
  {
    etatActivationExclusionFctRevision = etatPrecedentActivationExclusionFctRevision;
  }
}

/* Location:
 * Qualified Name:     IndividuGaecAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.autresdoms.ga.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.mapping.LireListePeriodeResultat;
import fr.unedic.cali.autresdoms.ga.services.AppelServicesGaec;
import fr.unedic.cali.dom.AppelGaecReduit;
import fr.unedic.cali.dom.IndividuChargementSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;

public class IndividuImplPersistant
  extends IndividuGaecAbstrait
{
  public IndividuImplPersistant(IndividuIdSpec p_individuIdSpec)
  {
    super(p_individuIdSpec);
    setEstModifiable(false);
    setEstCharge(false);
  }
  
  public ContexteService getContexteService()
  {
    return getIndividuId().getIndividu().getContexteService();
  }
  
  public IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException
  {
    IndividuGaecAbstrait individu = this;
    
    LireListePeriodeResultat listePeriode = lireListePeriode();
    individu.setChronoPeriodePasseProfessionnelSansFiltrageDNJ(listePeriode.getChronoPeriodesPasseProfessionnel());
    individu.setChronoPeriodePasseProfessionnelEcartees(listePeriode.getChronoPeriodesPasseProfessionnelEcartees());
    
    setEstCharge(true);
    
    return this;
  }
  
  public IndividuChargementSpec charger(AppelGaecReduit p_appelGaecReduit)
    throws ApplicativeException, TechniqueException
  {
    if (p_appelGaecReduit.getModeAppel() != 0)
    {
      IndividuGaecAbstrait individu = this;
      
      LireListePeriodeResultat listePeriode = lireListePeriode(p_appelGaecReduit);
      individu.setChronoPeriodePasseProfessionnelSansFiltrageDNJ(listePeriode.getChronoPeriodesPasseProfessionnel());
      individu.setChronoPeriodePasseProfessionnelEcartees(listePeriode.getChronoPeriodesPasseProfessionnelEcartees());
      
      setEstCharge(true);
    }
    return this;
  }
  
  private LireListePeriodeResultat lireListePeriode(AppelGaecReduit p_appelGaecReduit)
    throws CoucheLogiqueException
  {
    return AppelServicesGaec.lireListePeriodeAppelGaecReduit(getIndividuId(), p_appelGaecReduit);
  }
  
  private LireListePeriodeResultat lireListePeriode()
    throws CoucheLogiqueException
  {
    return AppelServicesGaec.lireListePeriode(getIndividuId());
  }
  
  public void enregistrerLA2K(IndividuSpec p_individu, Damj p_dateDebutExecution, ContexteService p_contexteService, int p_contexteExecution)
  {
    AppelServicesGaec.enregistrerLA2K(p_individu, p_dateDebutExecution, p_contexteService, p_contexteExecution);
  }
}

/* Location:
 * Qualified Name:     IndividuImplPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
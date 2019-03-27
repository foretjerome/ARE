package fr.unedic.cali.autresdoms.cohab.dom;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.dom.periode.FinPeriodeAvantageVieillesse;
import fr.unedic.cali.calcul.dom.periode.FinPeriodePensionInvalidite;
import fr.unedic.cali.calcul.dom.periode.PeriodeAvantageVieillesse;
import fr.unedic.cali.calcul.dom.periode.PeriodePension;
import fr.unedic.cali.calcul.dom.periode.PeriodePensionInvalidite;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuChargementSpec;
import fr.unedic.cali.dom.IndividuIdSpec;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.ComparateurTemporelsSurDateDebut;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;

public class IndividuImplNonPersistant
  extends IndividuCohabAbstrait
{
  private static final int PAS_DE_DIX = 10;
  private boolean sansRebond = false;
  
  public IndividuImplNonPersistant(IndividuIdSpec individuIdSpec)
  {
    super(individuIdSpec);
    
    setEstModifiable(true);
    setEstCharge(true);
    
    setRsodDerniereOdSigmaNonMigree("0");
    setDemandesV1DAL(new ArrayList());
    setDemandesV1RNV(new ArrayList());
  }
  
  public IndividuChargementSpec charger()
    throws ApplicativeException, TechniqueException
  {
    return this;
  }
  
  public boolean ajouterPensionsInvaliditeEtAvantagesVieillesse(PeriodePension periode)
  {
    super.ajouterPensionsInvaliditeEtAvantagesVieillesse(periode);
    if ((periode != null) && (periode.getDateFin() != null) && (periode.getDateFin() != Damj.FIN_DES_TEMPS)) {
      if ((periode instanceof PeriodePensionInvalidite))
      {
        FinPeriodePensionInvalidite finPeriodePensionInvalidite = new FinPeriodePensionInvalidite(periode.getDateFin().lendemain());
        finPeriodePensionInvalidite.setQuantiteEuro(periode.getQuantiteEuro());
        chronoPensionsInvaliditeEtAvantagesVieillesse.ajouter(finPeriodePensionInvalidite);
      }
      else if ((periode instanceof PeriodeAvantageVieillesse))
      {
        FinPeriodeAvantageVieillesse finPeriodeAvantageVieillesse = new FinPeriodeAvantageVieillesse(periode.getDateFin().lendemain());
        finPeriodeAvantageVieillesse.setQuantiteEuro(periode.getQuantiteEuro());
        chronoPensionsInvaliditeEtAvantagesVieillesse.ajouter(finPeriodeAvantageVieillesse);
      }
    }
    return false;
  }
  
  public FormulaireSpec getFormulaire(fr.unedic.cali.dom.DemandeSpec demande)
  {
    return demande.getFormulaire();
  }
  
  public void setChronologiePecNonFusionneesFinCI(Chronologie chronologiePecNonFusionneesFinCI)
  {
    if (chronologiePecNonFusionneesFinCI != null)
    {
      int i = 0;
      chronologiePecNonFusionneesFinCI.setComparateur(new ComparateurTemporelsSurDateDebut());
      chronologiePecNonFusionneesFinCI.iterer();
      while (chronologiePecNonFusionneesFinCI.encoreSuivant())
      {
        i++;
        ObjetChronoPeriodePriseEnChargeSansFiltre pecCourante = (ObjetChronoPeriodePriseEnChargeSansFiltre)chronologiePecNonFusionneesFinCI.elementSuivant();
        
        pecCourante.setIdentifiantPec(i * 10);
      }
    }
    super.setChronologiePecNonFusionneesFinCI(chronologiePecNonFusionneesFinCI);
  }
  
  public void setChronologiePecFusionneesFinCI(Chronologie chronologiePecFusionneesFinCI)
  {
    if (chronologiePecFusionneesFinCI != null)
    {
      int i = 0;
      chronologiePecFusionneesFinCI.setComparateur(new ComparateurTemporelsSurDateDebut());
      chronologiePecFusionneesFinCI.iterer();
      while (chronologiePecFusionneesFinCI.encoreSuivant())
      {
        i++;
        ObjetChronoPeriodePriseEnCharge pecCourante = (ObjetChronoPeriodePriseEnCharge)chronologiePecFusionneesFinCI.elementSuivant();
        
        pecCourante.setIdentifiantPec(i * 10);
      }
    }
    super.setChronologiePecFusionneesFinCI(chronologiePecFusionneesFinCI);
  }
  
  public boolean isSansRebond()
  {
    return sansRebond;
  }
  
  public void setSansRebond(boolean sansRebond)
  {
    this.sansRebond = sansRebond;
  }
  
  public void ajouterDemandeV1(fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec demande, String typeDemande)
  {
    getDemandesV1(typeDemande).add(demande);
  }
}

/* Location:
 * Qualified Name:     IndividuImplNonPersistant
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
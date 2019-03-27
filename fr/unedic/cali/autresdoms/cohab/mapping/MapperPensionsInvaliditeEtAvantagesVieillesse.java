package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.AvantageVieillesse;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.PensionInvalidite;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.PensionSpec;
import fr.unedic.cali.calcul.dom.periode.FinPeriodeAvantageVieillesse;
import fr.unedic.cali.calcul.dom.periode.FinPeriodePensionInvalidite;
import fr.unedic.cali.calcul.dom.periode.PeriodeAvantageVieillesse;
import fr.unedic.cali.calcul.dom.periode.PeriodePensionInvalidite;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePensionInvaliditeDeductible;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MapperPensionsInvaliditeEtAvantagesVieillesse
{
  public static void mapper(IndividuCohabAbstrait individu, PensionSpec pensionsInvaliditeEtAvantagesVieillesse)
  {
    LireListePensionsInvaliditeEtAvantagesVieillesse resultatService = new LireListePensionsInvaliditeEtAvantagesVieillesse();
    
    ChronologiePeriodes chronoPI = new ChronologiePeriodes();
    
    Iterator iterateurCollecPI = pensionsInvaliditeEtAvantagesVieillesse.getListePensionInvalidite().iterator();
    while (iterateurCollecPI.hasNext())
    {
      PensionInvalidite pensionInvalidite = (PensionInvalidite)iterateurCollecPI.next();
      
      Damj dateFinPension = pensionInvalidite.getDateFin();
      if (dateFinPension == null) {
        dateFinPension = Damj.FIN_DES_TEMPS;
      }
      PeriodePensionInvalidite periodePensionInvalidite = new PeriodePensionInvalidite(pensionInvalidite.getDateDebut(), dateFinPension);
      periodePensionInvalidite.setCodeNature(pensionInvalidite.getCodeNature());
      periodePensionInvalidite.setQuantiteEuro(pensionInvalidite.getMontant());
      chronoPI.ajouter(periodePensionInvalidite);
    }
    Collection collectionPIFiltrees = chronoPI.copier(new FiltrePensionInvaliditeDeductible()).mapperVersCollection();
    Iterator iterPIFiltrees = collectionPIFiltrees.iterator();
    ChronologiePeriodes chronoPIRetournees = new ChronologiePeriodes();
    while (iterPIFiltrees.hasNext())
    {
      PeriodePensionInvalidite periodePension = (PeriodePensionInvalidite)iterPIFiltrees.next();
      if (periodePension.getDateFin().estAvant(Damj.FIN_DES_TEMPS))
      {
        FinPeriodePensionInvalidite finPeriodePensionInvalidite = new FinPeriodePensionInvalidite(periodePension.getDateFin().lendemain());
        
        finPeriodePensionInvalidite.setQuantiteEuro(periodePension.getQuantiteEuro());
        chronoPIRetournees.ajouter(finPeriodePensionInvalidite);
      }
      chronoPIRetournees.ajouter(periodePension);
    }
    resultatService.setChronoPensionsInvalidite(chronoPIRetournees);
    
    Iterator iterateurCollecAVPourDateDebut = pensionsInvaliditeEtAvantagesVieillesse.getListeAvantageVieillesse().iterator();
    Collection listDatesDebutPeriodes = new ArrayList();
    while (iterateurCollecAVPourDateDebut.hasNext())
    {
      AvantageVieillesse avantageVieillesse = (AvantageVieillesse)iterateurCollecAVPourDateDebut.next();
      listDatesDebutPeriodes.add(avantageVieillesse.getDateDebut());
    }
    Iterator iterateurCollecAV = pensionsInvaliditeEtAvantagesVieillesse.getListeAvantageVieillesse().iterator();
    while (iterateurCollecAV.hasNext())
    {
      AvantageVieillesse avantageVieillesse = (AvantageVieillesse)iterateurCollecAV.next();
      PeriodeAvantageVieillesse periodePensionAvantageVieillesse;
      if (avantageVieillesse.getDateFin() != null)
      {
        PeriodeAvantageVieillesse periodePensionAvantageVieillesse = new PeriodeAvantageVieillesse(avantageVieillesse.getDateDebut(), avantageVieillesse.getDateFin());
        
        periodePensionAvantageVieillesse.setPeriodeInitiale(new Periode(avantageVieillesse.getDateDebut(), avantageVieillesse.getDateFin()));
        
        Damj dateFinPeriodeAV = avantageVieillesse.getDateFin().lendemain();
        if (!listDatesDebutPeriodes.contains(dateFinPeriodeAV))
        {
          FinPeriodeAvantageVieillesse finPeriodePensionAvantageVieillesse = new FinPeriodeAvantageVieillesse(dateFinPeriodeAV);
          
          finPeriodePensionAvantageVieillesse.setQuantiteEuro(avantageVieillesse.getMontant());
          resultatService.ajouterPeriodeAvantagesVieillesse(finPeriodePensionAvantageVieillesse);
        }
      }
      else
      {
        periodePensionAvantageVieillesse = new PeriodeAvantageVieillesse(avantageVieillesse.getDateDebut(), Damj.FIN_DES_TEMPS);
        
        periodePensionAvantageVieillesse.setPeriodeInitiale(new Periode(avantageVieillesse.getDateDebut(), Damj.FIN_DES_TEMPS));
      }
      periodePensionAvantageVieillesse.setCodeNature(avantageVieillesse.getCodeNature());
      periodePensionAvantageVieillesse.setQuantiteEuro(avantageVieillesse.getMontant());
      resultatService.ajouterPeriodeAvantagesVieillesse(periodePensionAvantageVieillesse);
    }
    ChronologiePeriodes chronoPeriodesPensionsInvaliditeEtAvantagesVieillesse = new ChronologiePeriodes();
    chronoPeriodesPensionsInvaliditeEtAvantagesVieillesse.ajouter(resultatService.getChronoAvantagesVieillesse());
    chronoPeriodesPensionsInvaliditeEtAvantagesVieillesse.ajouter(resultatService.getChronoPensionsInvalidite());
    individu.setChronoPensionsInvaliditeEtAvantagesVieillesse(chronoPeriodesPensionsInvaliditeEtAvantagesVieillesse);
  }
}

/* Location:
 * Qualified Name:     MapperPensionsInvaliditeEtAvantagesVieillesse
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
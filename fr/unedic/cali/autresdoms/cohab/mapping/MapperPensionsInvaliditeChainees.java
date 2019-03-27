package fr.unedic.cali.autresdoms.cohab.mapping;

import fr.unedic.cali.autresdoms.cohab.dom.IndividuCohabAbstrait;
import fr.unedic.cali.autresdoms.cohab.dom.PeriodePensionInvaliditeChainee;
import fr.unedic.cali.autresdoms.cohab.dom.PeriodeSousPensionInvaliditeChainee;
import fr.unedic.cali.autresdoms.cohab.dom.spec.PeriodePensionInvaliditeChaineeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.PensionInvalidite;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.PensionInvaliditeSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.pension.dom.spec.PensionSpec;
import fr.unedic.cali.calcul.dom.periode.FinPeriodePensionInvaliditeChainee;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MapperPensionsInvaliditeChainees
{
  public static void mapper(IndividuCohabAbstrait individu, PensionSpec pensionsInvaliditeEtAvantagesVieillesse)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes listePIChainees = new ChronologiePeriodes();
    
    Iterator iterateurCollecPI = pensionsInvaliditeEtAvantagesVieillesse.getListePensionInvalidite().iterator();
    
    Collection listePensionsAAnalyser = new ArrayList();
    while (iterateurCollecPI.hasNext())
    {
      PensionInvaliditeSpec pensionInvalidite = (PensionInvaliditeSpec)iterateurCollecPI.next();
      listePensionsAAnalyser.add(pensionInvalidite);
    }
    iterateurCollecPI = listePensionsAAnalyser.iterator();
    
    Collection listePensionsASupprimer = new ArrayList();
    while (iterateurCollecPI.hasNext())
    {
      PensionInvaliditeSpec pensionInvalidite = (PensionInvalidite)iterateurCollecPI.next();
      if ("I".equals(pensionInvalidite.getEtat()))
      {
        Damj dateFinPension = pensionInvalidite.getDateFin();
        if (dateFinPension == null) {
          dateFinPension = Damj.FIN_DES_TEMPS;
        }
        PeriodePensionInvaliditeChainee periodePIChainee = new PeriodePensionInvaliditeChainee(pensionInvalidite.getDateDebut(), dateFinPension);
        periodePIChainee.setOrganismeFinanceur(pensionInvalidite.getOrganismeFinanceur());
        periodePIChainee.setStatut(0);
        
        brancherPension(pensionInvalidite, periodePIChainee);
        
        listePIChainees.ajouter(periodePIChainee);
        
        listePensionsASupprimer.add(pensionInvalidite);
      }
    }
    listePensionsAAnalyser.removeAll(listePensionsASupprimer);
    listePensionsASupprimer.clear();
    
    boolean branchementEffectue = true;
    while (branchementEffectue)
    {
      branchementEffectue = false;
      
      iterateurCollecPI = listePensionsAAnalyser.iterator();
      for (; iterateurCollecPI.hasNext(); goto 253)
      {
        PensionInvaliditeSpec pensionInvalidite = (PensionInvalidite)iterateurCollecPI.next();
        
        listePIChainees.iterer();
        while ((listePIChainees.encoreSuivant()) && (!branchementEffectue))
        {
          PeriodePensionInvaliditeChainee periodePIChainee = (PeriodePensionInvaliditeChainee)listePIChainees.elementSuivant();
          if (estUnePensionAChainer(pensionInvalidite, periodePIChainee))
          {
            brancherPension(pensionInvalidite, periodePIChainee);
            
            listePensionsASupprimer.add(pensionInvalidite);
            
            branchementEffectue = true;
          }
        }
      }
      listePensionsAAnalyser.removeAll(listePensionsASupprimer);
      listePensionsASupprimer.clear();
    }
    if (!listePensionsAAnalyser.isEmpty()) {
      throw new CoucheLogiqueException("PR_COJAC_L_CONTEXTE_BRANCHEMENT_IMPOSSIBLE_PI", "Contexte en erreur : Impossible de brancher une pension d'invalidité révisée");
    }
    ChronologiePeriodes chronoPeriodesPensionsInvaliditeChainees = new ChronologiePeriodes();
    chronoPeriodesPensionsInvaliditeChainees.ajouter(listePIChainees);
    individu.setChronoPensionsInvaliditeChainees(chronoPeriodesPensionsInvaliditeChainees);
  }
  
  private static boolean estUnePensionAChainer(PensionInvaliditeSpec pensionInvalidite, PeriodePensionInvaliditeChaineeSpec periodePIChainee)
  {
    return ("R".equals(pensionInvalidite.getEtat())) && (pensionInvalidite.getOrganismeFinanceur().equals(periodePIChainee.getOrganismeFinanceur())) && (pensionInvalidite.getDateDebut().coincideAvec(periodePIChainee.getDateFin().lendemain()));
  }
  
  private static void brancherPension(PensionInvaliditeSpec pensionInvalidite, PeriodePensionInvaliditeChainee periodePIChainee)
  {
    Damj dateFinPension = pensionInvalidite.getDateFin();
    PeriodeSousPensionInvaliditeChainee periodeSousPIChainee;
    if (dateFinPension != null)
    {
      PeriodeSousPensionInvaliditeChainee periodeSousPIChainee = new PeriodeSousPensionInvaliditeChainee(pensionInvalidite.getDateDebut(), pensionInvalidite.getDateFin());
      
      FinPeriodePensionInvaliditeChainee finPeriodePensionInvalidite = new FinPeriodePensionInvaliditeChainee(dateFinPension.lendemain());
      finPeriodePensionInvalidite.setQuantiteEuro(pensionInvalidite.getMontant());
      periodePIChainee.ajouterFinPeriodePensionInvalidite(finPeriodePensionInvalidite);
      finPeriodePensionInvalidite.setPeriodePensionGeneratrice(periodeSousPIChainee);
    }
    else
    {
      periodeSousPIChainee = new PeriodeSousPensionInvaliditeChainee(pensionInvalidite.getDateDebut(), Damj.FIN_DES_TEMPS);
    }
    periodeSousPIChainee.setCodeNature(pensionInvalidite.getCodeNature());
    periodeSousPIChainee.setMontant(pensionInvalidite.getMontant());
    periodeSousPIChainee.setEtat(pensionInvalidite.getEtat());
    periodePIChainee.ajouterPeriodeSousPensionInvalidite(periodeSousPIChainee);
    periodeSousPIChainee.setPensionParente(periodePIChainee);
    
    periodePIChainee.setDateFin(periodeSousPIChainee.getDateFin());
  }
}

/* Location:
 * Qualified Name:     MapperPensionsInvaliditeChainees
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
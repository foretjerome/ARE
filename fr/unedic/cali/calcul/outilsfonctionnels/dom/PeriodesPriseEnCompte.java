package fr.unedic.cali.calcul.outilsfonctionnels.dom;

import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PeriodesPriseEnCompte
{
  private Map periodesDePriseEnCompteParTypologie = new HashMap();
  
  public PeriodesPriseEnCompte(Periode periode)
    throws CoucheLogiqueException
  {
    initialiseMap(periode);
  }
  
  private void initialiseMap(Periode pperiode)
    throws CoucheLogiqueException
  {
    ObjetChronoPeriodeConcrete periode = new ObjetChronoPeriodeConcrete(pperiode.getDebut(), pperiode.getFin());
    ChronologiePeriodes chronologiePeriodes = null;
    
    chronologiePeriodes = new ChronologiePeriodes();
    chronologiePeriodes.ajouter(new ObjetChronoPeriodeConcrete(pperiode.getDebut(), pperiode.getFin().lendemain()));
    periodesDePriseEnCompteParTypologie.put(Integer.valueOf(1), chronologiePeriodes);
    
    chronologiePeriodes = new ChronologiePeriodes();
    chronologiePeriodes.ajouter((ObjetChronoPeriodeConcrete)periode.copie());
    periodesDePriseEnCompteParTypologie.put(Integer.valueOf(2), chronologiePeriodes);
    
    chronologiePeriodes = new ChronologiePeriodes();
    chronologiePeriodes.ajouter((ObjetChronoPeriodeConcrete)periode.copie());
    periodesDePriseEnCompteParTypologie.put(Integer.valueOf(5), chronologiePeriodes);
    
    chronologiePeriodes = new ChronologiePeriodes();
    chronologiePeriodes.ajouter((ObjetChronoPeriodeConcrete)periode.copie());
    periodesDePriseEnCompteParTypologie.put(Integer.valueOf(4), chronologiePeriodes);
    
    chronologiePeriodes = new ChronologiePeriodes();
    chronologiePeriodes.ajouter((ObjetChronoPeriodeConcrete)periode.copie());
    periodesDePriseEnCompteParTypologie.put(Integer.valueOf(3), chronologiePeriodes);
    
    chronologiePeriodes = new ChronologiePeriodes();
    chronologiePeriodes.ajouter((ObjetChronoPeriodeConcrete)periode.copie());
    periodesDePriseEnCompteParTypologie.put(Integer.valueOf(6), chronologiePeriodes);
    
    chronologiePeriodes = new ChronologiePeriodes();
    chronologiePeriodes.ajouter((ObjetChronoPeriodeConcrete)periode.copie());
    periodesDePriseEnCompteParTypologie.put(Integer.valueOf(7), chronologiePeriodes);
  }
  
  public ChronologiePeriodes getPeriodesParTypologie(int type)
  {
    return (ChronologiePeriodes)periodesDePriseEnCompteParTypologie.get(Integer.valueOf(type));
  }
  
  public void tronquePeriodesPriseEnCompteEnDebut(Damj date)
  {
    tronquePeriodesPriseEnCompteEnDebutHorsDecalantesEtGelantes(date);
    tronquePeriodeParTypologieEnDebut(date, 5);
    tronquePeriodeParTypologieEnDebut(date, 4);
  }
  
  public void tronquePeriodesPriseEnCompteEnDebutHorsDecalantesEtGelantes(Damj date)
  {
    tronquePeriodeParTypologieEnDebut(date, 1);
    tronquePeriodeParTypologieEnDebut(date, 2);
    tronquePeriodeParTypologieEnDebut(date, 3);
    tronquePeriodeParTypologieEnDebut(date, 6);
    tronquePeriodeParTypologieEnDebut(date, 7);
  }
  
  public void tronquePeriodesPriseEnCompteEnFin(Damj date)
  {
    tronquePeriodesPriseEnCompteEnFinHorsDecalantesEtGelantes(date);
    tronquePeriodeParTypologieEnFin(date, 5);
    tronquePeriodeParTypologieEnFin(date, 4);
  }
  
  public void tronquePeriodesPriseEnCompteEnFinHorsDecalantesEtGelantes(Damj date)
  {
    tronquePeriodeParTypologieEnFin(date, 1);
    tronquePeriodeParTypologieEnFin(date, 2);
    tronquePeriodeParTypologieEnFin(date, 3);
    tronquePeriodeParTypologieEnFin(date, 6);
    tronquePeriodeParTypologieEnFin(date, 7);
  }
  
  public void tronquePeriodesPriseEnCompteEnExcluantPeriode(Periode periode)
  {
    tronquePeriodesPriseEnCompteEnExcluantPeriodeHorsDecalantesEtGelantes(periode);
    tronquePeriodeParTypologieEnExcluantPeriodeStrictement(periode, 5);
    tronquePeriodeParTypologieEnExcluantPeriodeStrictement(periode, 4);
  }
  
  public void tronquePeriodesPriseEnCompteEnExcluantPeriodeHorsDecalantesEtGelantes(Periode periode)
  {
    tronquePeriodeParTypologieEnExcluantPeriodeStrictement(periode, 1);
    tronquePeriodeParTypologieEnExcluantPeriodeStrictement(periode, 2);
    tronquePeriodeParTypologieEnExcluantPeriodeStrictement(periode, 3);
    tronquePeriodeParTypologieEnExcluantPeriodeStrictement(periode, 6);
    tronquePeriodeParTypologieEnExcluantPeriodeStrictement(periode, 7);
  }
  
  public void tronquePeriodesPriseEnComptePeriodesDecalantesEtGelantes(Periode periode)
  {
    tronquePeriodeParTypologieEnExcluantPeriodeStrictement(periode, 5);
    tronquePeriodeParTypologieEnExcluantPeriodeStrictement(periode, 4);
  }
  
  public void tronquePeriodeParTypologieEnDebut(Damj date, int type)
  {
    ChronologiePeriodes chronologiePeriodesPriseEnCompte = getPeriodesParTypologie(type);
    Iterator iterator = chronologiePeriodesPriseEnCompte.iterer();
    while (iterator.hasNext())
    {
      ObjetChronoPeriodeConcrete periode = (ObjetChronoPeriodeConcrete)iterator.next();
      if (date.estApres(periode.getDateDebut())) {
        if (date.estAvantOuCoincideAvec(periode.getDateFin())) {
          periode.setDateDebut(date);
        } else {
          iterator.remove();
        }
      }
    }
  }
  
  public void tronquePeriodeParTypologieEnFin(Damj date, int type)
  {
    ChronologiePeriodes chronologiePeriodesPriseEnCompte = getPeriodesParTypologie(type);
    Iterator iterator = chronologiePeriodesPriseEnCompte.iterer();
    while (iterator.hasNext())
    {
      ObjetChronoPeriodeConcrete periode = (ObjetChronoPeriodeConcrete)iterator.next();
      if (date.estAvant(periode.getDateFin())) {
        if (date.estApresOuCoincideAvec(periode.getDateDebut())) {
          periode.setDateFin(date);
        } else {
          iterator.remove();
        }
      }
    }
  }
  
  public void tronquePeriodeParTypologieEnExcluantPeriode(Periode pperiode, int type)
  {
    ChronologiePeriodes chronologiePeriodesPriseEnCompte = getPeriodesParTypologie(type);
    ChronologiePeriodes nouvelleChronologiePeriodesPriseEnCompte = new ChronologiePeriodes();
    Iterator iterator = chronologiePeriodesPriseEnCompte.iterer();
    while (iterator.hasNext())
    {
      ObjetChronoPeriodeConcrete periode = (ObjetChronoPeriodeConcrete)iterator.next();
      if ((pperiode.getDebut().estApresOuCoincideAvec(periode.getDateDebut())) && (pperiode.getFin().estAvantOuCoincideAvec(periode.getDateFin())))
      {
        iterator.remove();
        nouvelleChronologiePeriodesPriseEnCompte.ajouter(new ObjetChronoPeriodeConcrete(periode.getDateDebut(), pperiode.getDebut()));
        nouvelleChronologiePeriodesPriseEnCompte.ajouter(new ObjetChronoPeriodeConcrete(pperiode.getFin(), periode.getDateFin()));
      }
      else if ((pperiode.getDebut().estAvant(periode.getDateDebut())) && (pperiode.getFin().estApres(periode.getDateFin())))
      {
        iterator.remove();
      }
      else
      {
        if (pperiode.getDebut().estApresOuCoincideAvec(periode.getDateDebut())) {
          periode.setDateFin(pperiode.getDebut());
        }
        if (pperiode.getFin().estAvantOuCoincideAvec(periode.getDateFin())) {
          periode.setDateDebut(pperiode.getFin());
        }
      }
    }
    chronologiePeriodesPriseEnCompte.ajouter(nouvelleChronologiePeriodesPriseEnCompte);
  }
  
  public void tronquePeriodeParTypologieEnExcluantPeriodeStrictement(Periode pperiode, int type)
  {
    ChronologiePeriodes chronologiePeriodesPriseEnCompte = getPeriodesParTypologie(type);
    ChronologiePeriodes nouvelleChronologiePeriodesPriseEnCompte = new ChronologiePeriodes();
    Iterator iterator = chronologiePeriodesPriseEnCompte.iterer();
    while (iterator.hasNext())
    {
      ObjetChronoPeriodeConcrete periode = (ObjetChronoPeriodeConcrete)iterator.next();
      if ((pperiode.getDebut().estApres(periode.getDateDebut())) && (pperiode.getFin().estAvant(periode.getDateFin())))
      {
        iterator.remove();
        nouvelleChronologiePeriodesPriseEnCompte.ajouter(new ObjetChronoPeriodeConcrete(periode.getDateDebut(), pperiode.getDebut().veille()));
        
        nouvelleChronologiePeriodesPriseEnCompte.ajouter(new ObjetChronoPeriodeConcrete(pperiode.getFin().lendemain(), periode.getDateFin()));
      }
      else if ((pperiode.getDebut().estAvantOuCoincideAvec(periode.getDateDebut())) && (pperiode.getFin().estApresOuCoincideAvec(periode.getDateFin())))
      {
        iterator.remove();
      }
      else
      {
        if (pperiode.getDebut().estApres(periode.getDateDebut())) {
          periode.setDateFin(pperiode.getDebut().veille());
        }
        if (pperiode.getFin().estAvant(periode.getDateFin())) {
          periode.setDateDebut(pperiode.getFin().lendemain());
        }
      }
    }
    chronologiePeriodesPriseEnCompte.ajouter(nouvelleChronologiePeriodesPriseEnCompte);
  }
  
  public String toString()
  {
    return periodesDePriseEnCompteParTypologie.toString();
  }
}

/* Location:
 * Qualified Name:     PeriodesPriseEnCompte
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
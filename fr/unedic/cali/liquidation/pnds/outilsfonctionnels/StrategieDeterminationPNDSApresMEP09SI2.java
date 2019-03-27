package fr.unedic.cali.liquidation.pnds.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.autresdoms.ga.dom.BulletinSalaire;
import fr.unedic.cali.autresdoms.ga.dom.Salaire;
import fr.unedic.cali.autresdoms.ga.dom.spec.PeriodeGaecSpec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.pnds.PeriodeNonDeclareeSanction;
import fr.unedic.cali.liquidation.pnds.StrategieDeterminationPNDSSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalarie;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreBulletinSalaireActiviteSalarie;
import fr.unedic.cali.outilsfonctionnels.strategies.CritereStrategie;
import fr.unedic.cali.outilsfonctionnels.strategies.fabriques.FabriqueDeterminationPeriodeIndemnisation;
import fr.unedic.cali.outilsfonctionnels.strategies.spec.StrategieDeterminationPeriodeIndemnisationSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreChevauchePeriode;
import fr.unedic.util.temps.FiltresTemporel;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.ObjetChronoPeriodeConcrete;
import fr.unedic.util.temps.Periode;
import fr.unedic.util.temps.Temporel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StrategieDeterminationPNDSApresMEP09SI2
  implements StrategieDeterminationPNDSSpec
{
  private static final String NOM = "StrategieDeterminationPNDSApresMEP09SI2";
  
  public void determinationPNDSPourIndividuSurPeriode(IndividuSpec individu, Damj dateDebut, Damj dateFin, ChronologiePeriodes chronoGaec, boolean priseEnCompteBS)
    throws CoucheLogiqueException
  {
    Damj dateExamen = dateFin;
    
    Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> tablePndsDetecteesRegleTroisJours = new HashMap();
    if (!Damj.FIN_DES_TEMPS.equals(dateDebut))
    {
      Damj debutPeriode = dateDebut;
      if (!debutPeriode.estLeDebutDuMois()) {
        debutPeriode = debutPeriode.getDebutMois();
      }
      Damj finPeriode = dateFin;
      if (!finPeriode.estLaFinDuMois()) {
        finPeriode = finPeriode.getFinMois();
      }
      Periode periodeDeterminationPNDS = determinationPeriodeRecherchePNDS(debutPeriode, finPeriode);
      
      ChronologiePeriodes chronoPassePro = chronoGaec;
      FiltresTemporel filtres = new FiltresTemporel();
      if (priseEnCompteBS) {
        filtres.ajouterFiltre(new FiltreBulletinSalaireActiviteSalarie());
      } else {
        filtres.ajouterFiltre(new FiltreActiviteSalarie());
      }
      filtres.ajouterFiltre(new FiltreChevauchePeriode(periodeDeterminationPNDS));
      
      Chronologie chronoActivitePourPNDS = chronoPassePro.copier(filtres);
      
      List<?> listeMoisCivils = periodeDeterminationPNDS.decouperEnMoisCivils();
      Iterator<?> itMoisCivils = listeMoisCivils.iterator();
      while (itMoisCivils.hasNext())
      {
        Periode moisCivil = (Periode)itMoisCivils.next();
        
        Collection listePNDSanctionneesSurMoisCivil = appliquerRegleDesTroisJoursSurMoisCivil(moisCivil, chronoActivitePourPNDS.copier(new FiltreChevauchePeriode(moisCivil)));
        if ((listePNDSanctionneesSurMoisCivil != null) && (!listePNDSanctionneesSurMoisCivil.isEmpty())) {
          mettreAJourTablePNDS(tablePndsDetecteesRegleTroisJours, listePNDSanctionneesSurMoisCivil);
        }
      }
      tablePndsDetecteesRegleTroisJours = appliquerRegleDeChevauchementDesAttributions(individu, tablePndsDetecteesRegleTroisJours, dateExamen);
    }
    individu.setListePNDSIndividu(tablePndsDetecteesRegleTroisJours);
  }
  
  protected Periode determinationPeriodeRecherchePNDS(Damj debutPeriode, Damj finPeriode)
    throws CoucheLogiqueException
  {
    return new Periode(debutPeriode, finPeriode);
  }
  
  protected Collection appliquerRegleDesTroisJoursSurMoisCivil(Periode moisCivil, Chronologie chronoPassePro)
  {
    ArrayList listePNDSSurMoisCivil = new ArrayList();
    
    ChronologiePeriodes listePNDToutesActiviteSalariee = new ChronologiePeriodes();
    chronoPassePro.iterer();
    while (chronoPassePro.encoreSuivant())
    {
      Temporel periodeActivite = chronoPassePro.elementSuivant();
      Chronologie chronoSalaires;
      Chronologie chronoSalaires;
      if ((periodeActivite instanceof BulletinSalaire)) {
        chronoSalaires = ((BulletinSalaire)periodeActivite).getListeSalaires().copier(new FiltreChevauchePeriode(moisCivil));
      } else {
        chronoSalaires = ((ActiviteSalarie)periodeActivite).getListeSalaires().copier(new FiltreChevauchePeriode(moisCivil));
      }
      ChronologiePeriodes listePNDSPourActiviteSalariee = new ChronologiePeriodes();
      chronoSalaires.iterer();
      while (chronoSalaires.encoreSuivant())
      {
        Salaire salaire = (Salaire)chronoSalaires.elementSuivant();
        Collection<?> listePND = salaire.getCollectionPND();
        
        Iterator<?> it = listePND.iterator();
        while (it.hasNext())
        {
          ObjetChronoPeriode pnd = (ObjetChronoPeriode)it.next();
          Periode pndASanctionne = pnd.periodeIntersection(moisCivil);
          if (pndASanctionne != null) {
            listePNDSPourActiviteSalariee.ajouterB(new ObjetChronoPeriodeConcrete(pndASanctionne));
          }
        }
      }
      if ((listePNDSPourActiviteSalariee != null) && (!listePNDSPourActiviteSalariee.estVide()))
      {
        listePNDToutesActiviteSalariee.ajouter(listePNDSPourActiviteSalariee);
        
        PeriodeNonDeclareeSanction pndsPourActivite = PeriodeNonDeclareeSanction.creerInstance(listePNDSPourActiviteSalariee);
        pndsPourActivite.setPeriodeActivite((PeriodeGaecSpec)periodeActivite);
        listePNDSSurMoisCivil.add(pndsPourActivite);
      }
    }
    if ((listePNDToutesActiviteSalariee != null) && (!listePNDToutesActiviteSalariee.estVide()))
    {
      listePNDToutesActiviteSalariee = gererChevauchementPND(listePNDToutesActiviteSalariee);
      appliquerRegleDesTroisJours(listePNDToutesActiviteSalariee, listePNDSSurMoisCivil);
    }
    return listePNDSSurMoisCivil;
  }
  
  protected ChronologiePeriodes gererChevauchementPND(ChronologiePeriodes listePNDToutesActiviteSalariee)
  {
    return listePNDToutesActiviteSalariee;
  }
  
  protected void appliquerRegleDesTroisJours(ChronologiePeriodes chronoPnd, Collection<?> listePNDSSurMoisCivil)
  {
    int dureeTotalPND = 0;
    if ((chronoPnd != null) && (!chronoPnd.estVide()))
    {
      chronoPnd.iterer();
      while (chronoPnd.encoreSuivant())
      {
        ObjetChronoPeriode pnd = (ObjetChronoPeriode)chronoPnd.elementSuivant();
        dureeTotalPND += pnd.getDuree();
      }
    }
    if (dureeTotalPND <= 3) {
      listePNDSSurMoisCivil.clear();
    }
  }
  
  protected void mettreAJourTablePNDS(Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> tablePNDS, Collection listePNDS)
  {
    if ((listePNDS != null) && (!listePNDS.isEmpty()))
    {
      Iterator<?> it = listePNDS.iterator();
      while (it.hasNext())
      {
        PeriodeNonDeclareeSanction pnds = (PeriodeNonDeclareeSanction)it.next();
        if (tablePNDS.containsKey(pnds.getPeriodeActivite()))
        {
          PeriodeNonDeclareeSanction pndDejaSanctionnee = (PeriodeNonDeclareeSanction)tablePNDS.get(pnds.getPeriodeActivite());
          ChronologiePeriodes chronoPNDS = pndDejaSanctionnee.getChronoPeriodePNDS();
          chronoPNDS.ajouter(pnds.getChronoPeriodePNDS());
          pndDejaSanctionnee.fusionnerChevauchementPeriode();
        }
        else
        {
          tablePNDS.put(pnds.getPeriodeActivite(), pnds);
        }
      }
    }
  }
  
  protected Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> appliquerRegleDeChevauchementDesAttributions(IndividuSpec individu, Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> tablePnds, Damj dateExamen)
    throws CoucheLogiqueException
  {
    Map<PeriodeGaecSpec, PeriodeNonDeclareeSanction> tablePndsSanctionnees = new HashMap();
    if ((tablePnds != null) && (!tablePnds.isEmpty()))
    {
      Collection<?> listePNDS = tablePnds.values();
      if ((listePNDS != null) && (!listePNDS.isEmpty()))
      {
        Iterator<?> it = listePNDS.iterator();
        while (it.hasNext())
        {
          PeriodeNonDeclareeSanction pndsASanctionner = (PeriodeNonDeclareeSanction)it.next();
          PeriodeGaecSpec activite = pndsASanctionner.getPeriodeActivite();
          List<?> listAttributions;
          List<?> listAttributions;
          if ((activite instanceof BulletinSalaire)) {
            listAttributions = individu.getListeAttributionsChevauchantPeriode(((BulletinSalaire)activite).getPeriode(), dateExamen);
          } else {
            listAttributions = individu.getListeAttributionsChevauchantPeriode(((ActiviteSalarie)activite).getPeriode(), dateExamen);
          }
          if ((listAttributions != null) && (!listAttributions.isEmpty()))
          {
            ChronologiePeriodes chronoPndsFiltree = filtrerPNDSAvecAttributions(pndsASanctionner, listAttributions, dateExamen);
            if (!chronoPndsFiltree.estVide())
            {
              PeriodeNonDeclareeSanction pnds = PeriodeNonDeclareeSanction.creerInstance(chronoPndsFiltree);
              pnds.setPeriodeActivite(activite);
              
              tablePndsSanctionnees.put(activite, pnds);
            }
          }
        }
      }
    }
    return tablePndsSanctionnees;
  }
  
  private ChronologiePeriodes filtrerPNDSAvecAttributions(PeriodeNonDeclareeSanction pnds, List<?> listeAttributions, Damj dateExamen)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronoPndsChevauchantAttribution = new ChronologiePeriodes();
    
    Iterator<?> it = listeAttributions.iterator();
    while (it.hasNext())
    {
      AttributionSpec attributionCourante = (AttributionSpec)it.next();
      if ((attributionCourante.estValidee()) && ((attributionCourante.getGamme().getNomUnique().equals("ASU")) || (attributionCourante.getGamme().getNomUnique().equals("SOL")) || (attributionCourante.getGamme().getNomUnique().equals("FOR"))))
      {
        CritereStrategie criteres = new CritereStrategie();
        criteres.setDatePivot(dateExamen);
        StrategieDeterminationPeriodeIndemnisationSpec strategie = (StrategieDeterminationPeriodeIndemnisationSpec)FabriqueDeterminationPeriodeIndemnisation.getInstance().getStrategie(criteres);
        
        Periode periodeAttribution = strategie.recupererPeriodeIndemnisation(attributionCourante);
        if (periodeAttribution != null)
        {
          ChronologiePeriodes chronoPnds = pnds.getChronoPeriodePNDS();
          chronoPnds.iterer();
          if (periodeAttribution.getDebut().estAvant(dateExamen)) {
            while (chronoPnds.encoreSuivant())
            {
              ObjetChronoPeriode objetChronoPnds = (ObjetChronoPeriode)chronoPnds.elementSuivant();
              if ((objetChronoPnds.chevauche(periodeAttribution)) && (!chronoPndsChevauchantAttribution.contientElement(objetChronoPnds))) {
                chronoPndsChevauchantAttribution.ajouterB(objetChronoPnds);
              }
            }
          }
        }
      }
    }
    return chronoPndsChevauchantAttribution;
  }
  
  public String getNomStrategie()
  {
    return "StrategieDeterminationPNDSApresMEP09SI2";
  }
  
  public Collection determinationPNDSPourCalcul(ChronologiePeriodes chronoPeriodeTravail, IndividuSpec individu)
  {
    return null;
  }
}

/* Location:
 * Qualified Name:     StrategieDeterminationPNDSApresMEP09SI2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
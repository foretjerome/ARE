package fr.unedic.cali.parcours;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeActiviteNonSalariePeriodique;
import fr.unedic.cali.autresdoms.ga.dom.PeriodeAvecRevenu;
import fr.unedic.cali.autresdoms.ga.mapping.LireListePeriodeResultat;
import fr.unedic.cali.autresdoms.ga.mapping.MapperPans;
import fr.unedic.cali.autresdoms.ga.mapping.MapperPeriodesCalcul;
import fr.unedic.cali.autresdoms.ga.services.AppelServicesGaec;
import fr.unedic.cali.calcul.dom.periode.Pans;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.ComparerPANSCalcul;
import fr.unedic.cali.dom.ComparerPANSCali;
import fr.unedic.cali.dom.ComparerPANSCaliDetail;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltrePeriodeActiviteNonSalarieePeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.ChampsPeriodeActivite;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PANS;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PANSPeriodique;
import fr.unedic.gestionactivite.donnees.gestionactivite.service.vls.PeriodeActivite;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.ComparateurTemporelsSurDateDebut;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ParcoursLireComparaisonPANS
  extends ParcoursServiceAbstrait
{
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null)
    {
      Collection typePeriodesGaec = new ArrayList();
      ajouterSiNouveau("17", typePeriodesGaec);
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(1);
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {}
  
  protected Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatLireComparaisonPANS resultat = new ResultatLireComparaisonPANS();
    
    IndividuSpec individu = getIndividu(contexte);
    
    DomLireComparaisonPANS domLire = (DomLireComparaisonPANS)contexte.getDonnees();
    if (domLire.isComparerCali()) {
      try
      {
        executerComparerPANSCali(resultat, individu);
      }
      catch (TechniqueException ex) {}
    } else {
      try
      {
        executerComparerPANSCalcul(resultat, individu);
      }
      catch (TechniqueException ex) {}
    }
    return resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 0;
  }
  
  private void executerComparerPANSCalcul(ResultatLireComparaisonPANS resultat, IndividuSpec individu)
    throws ApplicativeException, TechniqueException
  {
    if (individu != null)
    {
      List comparerPANSAvantCalcul = new ArrayList();
      
      alimenterAgregatGaec((Individu)individu, null);
      
      LireListePeriodeResultat resultatGaec = AppelServicesGaec.lireListePeriode(individu.getIndividuId());
      
      ChronologiePeriodes passeProPANS = (ChronologiePeriodes)resultatGaec.getChronoPeriodesPasseProfessionnel().copier(new FiltrePeriodeActiviteNonSalarieePeriodique());
      
      ChronologiePeriodes periodesMappeesAvant = MapperPeriodesCalcul.mapper(passeProPANS, individu, null);
      periodesMappeesAvant.setComparateur(new ComparateurTemporelsSurDateDebut());
      
      periodesMappeesAvant.iterer();
      while (periodesMappeesAvant.encoreSuivant())
      {
        Pans pans = (Pans)periodesMappeesAvant.elementSuivant();
        ComparerPANSCalcul comparerPANSCalcul = new ComparerPANSCalcul();
        comparerPANSCalcul.setAvantApres(0);
        comparerPANSCalcul.setDateDebut(pans.getDateDebut());
        comparerPANSCalcul.setDateFin(pans.getDateFin());
        comparerPANSCalcul.setGain(pans.getGain());
        comparerPANSCalcul.setIdentifiant(pans.getIdentifiant());
        comparerPANSCalcul.setTypeRevenu(Pans.LIB_TYPE_REVENU.get(Integer.valueOf(pans.getTypeRevenu())).toString());
        comparerPANSAvantCalcul.add(comparerPANSCalcul);
      }
      List comparerPANSApresCalcul = new ArrayList();
      alimenterAgregatGaec((Individu)individu, null);
      resultatGaec = AppelServicesGaec.lireListePeriode(individu.getIndividuId());
      passeProPANS = (ChronologiePeriodes)resultatGaec.getChronoPeriodesPasseProfessionnel().copier(new FiltrePeriodeActiviteNonSalarieePeriodique());
      
      ChronologiePeriodes periodesMappeesApres = MapperPeriodesCalcul.mapper(passeProPANS, individu, null);
      periodesMappeesApres.setComparateur(new ComparateurTemporelsSurDateDebut());
      
      periodesMappeesApres.iterer();
      while (periodesMappeesApres.encoreSuivant())
      {
        Pans pans = (Pans)periodesMappeesApres.elementSuivant();
        ComparerPANSCalcul comparerPANSCalcul = new ComparerPANSCalcul();
        comparerPANSCalcul.setAvantApres(1);
        comparerPANSCalcul.setDateDebut(pans.getDateDebut());
        comparerPANSCalcul.setDateFin(pans.getDateFin());
        comparerPANSCalcul.setGain(pans.getGain());
        comparerPANSCalcul.setIdentifiant(pans.getIdentifiant());
        comparerPANSCalcul.setTypeRevenu(Pans.LIB_TYPE_REVENU.get(Integer.valueOf(pans.getTypeRevenu())).toString());
        comparerPANSApresCalcul.add(comparerPANSCalcul);
      }
      resultat.setListeAvantCalcul(comparerPANSAvantCalcul);
      resultat.setListeApresCalcul(comparerPANSApresCalcul);
      
      List pansCalculFusion = fusionnerListesAvantApresCalcul(comparerPANSAvantCalcul, comparerPANSApresCalcul);
      resultat.setListeCalcul(pansCalculFusion);
    }
  }
  
  private List fusionnerListesAvantApresCalcul(List listeAvant, List listeApres)
  {
    List listeFusion = new ArrayList();
    
    ComparerPANSCalcul pansAvant = null;
    ComparerPANSCalcul pansApres = null;
    int cptAvant = 0;
    int cptApres = 0;
    for (int i = 0; i < listeAvant.size() + listeApres.size(); i++)
    {
      if ((cptAvant == listeAvant.size()) && (cptApres == listeApres.size())) {
        break;
      }
      pansAvant = cptAvant < listeAvant.size() ? (ComparerPANSCalcul)listeAvant.get(cptAvant) : null;
      pansApres = cptApres < listeApres.size() ? (ComparerPANSCalcul)listeApres.get(cptApres) : null;
      
      ComparerPANSCalcul pans = new ComparerPANSCalcul();
      if ((pansAvant != null) && (pansApres != null) && (pansAvant.getDateDebut().coincideAvec(pansApres.getDateDebut())) && (pansAvant.getDateFin().coincideAvec(pansApres.getDateFin())))
      {
        pans.setIdentifiant(pansAvant.getIdentifiant());
        pans.setDateDebut(pansAvant.getDateDebut());
        pans.setDateFin(pansAvant.getDateFin());
        pans.setGain(pansAvant.getGain());
        pans.setTypeRevenu(pansAvant.getTypeRevenu());
        pans.setGainApres(pansApres.getGain());
        pans.setTypeRevenuApres(pansApres.getTypeRevenu());
        pans.setEcart((pans.getGain().compareTo(pans.getGainApres()) != 0) || (!pans.getTypeRevenu().equals(pans.getTypeRevenuApres())));
        cptAvant++;
        cptApres++;
      }
      else if ((pansApres == null) || ((pansAvant != null) && (pansAvant.getDateDebut().estAvant(pansApres.getDateDebut()))))
      {
        pans.setIdentifiant(pansAvant.getIdentifiant());
        pans.setDateDebut(pansAvant.getDateDebut());
        pans.setDateFin(pansAvant.getDateFin());
        pans.setGain(pansAvant.getGain());
        pans.setTypeRevenu(pansAvant.getTypeRevenu());
        pans.setGainApres(null);
        pans.setTypeRevenuApres(null);
        pans.setEcart(true);
        cptAvant++;
      }
      else
      {
        pans.setIdentifiant(pansApres.getIdentifiant());
        pans.setDateDebut(pansApres.getDateDebut());
        pans.setDateFin(pansApres.getDateFin());
        pans.setGain(null);
        pans.setTypeRevenu(null);
        pans.setGainApres(pansApres.getGain());
        pans.setTypeRevenuApres(pansApres.getTypeRevenu());
        pans.setEcart(true);
        cptApres++;
      }
      listeFusion.add(pans);
    }
    return listeFusion;
  }
  
  private void executerComparerPANSCali(ResultatLireComparaisonPANS resultat, IndividuSpec individu)
    throws ApplicativeException, TechniqueException
  {
    if (individu != null)
    {
      List comparerPANSAvantCali = new ArrayList();
      
      alimenterAgregatGaec((Individu)individu, null);
      
      LireListePeriodeResultat resultatGaec = AppelServicesGaec.lireListePeriode(individu.getIndividuId());
      ChronologiePeriodes periodesMappeesAvant = (ChronologiePeriodes)resultatGaec.getChronoPeriodesPasseProfessionnel().copier(new FiltrePeriodeActiviteNonSalarieePeriodique());
      
      periodesMappeesAvant.setComparateur(new ComparateurTemporelsSurDateDebut());
      
      periodesMappeesAvant.iterer();
      while (periodesMappeesAvant.encoreSuivant())
      {
        PeriodeActiviteNonSalariePeriodique pans = (PeriodeActiviteNonSalariePeriodique)periodesMappeesAvant.elementSuivant();
        ComparerPANSCali comparerPANSCali = new ComparerPANSCali();
        comparerPANSCali.setAvantApres(0);
        comparerPANSCali.setDateDebut(pans.getDateDebut());
        comparerPANSCali.setDateFin(pans.getDateFin());
        comparerPANSCali.setIdentifiant(pans.getIdentifiant());
        List listeComparerPANSCaliDetail = new ArrayList();
        for (Iterator iter = pans.getCollectionPeriodeAvecRevenu().iterator(); iter.hasNext();)
        {
          PeriodeAvecRevenu periodeAvecRevenu = (PeriodeAvecRevenu)iter.next();
          ComparerPANSCaliDetail comparerPANSCaliDetail = new ComparerPANSCaliDetail();
          comparerPANSCaliDetail.setDateDebut(periodeAvecRevenu.getDateDebut());
          comparerPANSCaliDetail.setDateFin(periodeAvecRevenu.getDateFin());
          comparerPANSCaliDetail.setMontant(periodeAvecRevenu.getMontant());
          comparerPANSCaliDetail.setTypeRevenu(Pans.LIB_TYPE_REVENU.get(Integer.valueOf(periodeAvecRevenu.getTypeRevenu())).toString());
          listeComparerPANSCaliDetail.add(comparerPANSCaliDetail);
        }
        Collections.sort(listeComparerPANSCaliDetail, new ComparateurTemporelsSurDateDebut());
        comparerPANSCali.setListePeriodeAvecRevenu(listeComparerPANSCaliDetail);
        comparerPANSCali.setIdentifiant(pans.getIdentifiant());
        comparerPANSAvantCali.add(comparerPANSCali);
      }
      List comparerPANSApresCali = new ArrayList();
      alimenterAgregatGaec((Individu)individu, null);
      
      resultatGaec = AppelServicesGaec.lireListePeriode(individu.getIndividuId());
      ChronologiePeriodes periodesMappeesApres = (ChronologiePeriodes)resultatGaec.getChronoPeriodesPasseProfessionnel().copier(new FiltrePeriodeActiviteNonSalarieePeriodique());
      
      periodesMappeesApres.setComparateur(new ComparateurTemporelsSurDateDebut());
      
      periodesMappeesApres.iterer();
      while (periodesMappeesApres.encoreSuivant())
      {
        PeriodeActiviteNonSalariePeriodique pans = (PeriodeActiviteNonSalariePeriodique)periodesMappeesApres.elementSuivant();
        ComparerPANSCali comparerPANSCali = new ComparerPANSCali();
        comparerPANSCali.setAvantApres(1);
        comparerPANSCali.setDateDebut(pans.getDateDebut());
        comparerPANSCali.setDateFin(pans.getDateFin());
        comparerPANSCali.setIdentifiant(pans.getIdentifiant());
        List listeComparerPANSCaliDetail = new ArrayList();
        for (Iterator iter = pans.getCollectionPeriodeAvecRevenu().iterator(); iter.hasNext();)
        {
          PeriodeAvecRevenu periodeAvecRevenu = (PeriodeAvecRevenu)iter.next();
          ComparerPANSCaliDetail comparerPANSCaliDetail = new ComparerPANSCaliDetail();
          comparerPANSCaliDetail.setDateDebut(periodeAvecRevenu.getDateDebut());
          comparerPANSCaliDetail.setDateFin(periodeAvecRevenu.getDateFin());
          comparerPANSCaliDetail.setMontant(periodeAvecRevenu.getMontant());
          comparerPANSCaliDetail.setTypeRevenu(Pans.LIB_TYPE_REVENU.get(Integer.valueOf(periodeAvecRevenu.getTypeRevenu())).toString());
          listeComparerPANSCaliDetail.add(comparerPANSCaliDetail);
        }
        Collections.sort(listeComparerPANSCaliDetail, new ComparateurTemporelsSurDateDebut());
        comparerPANSCali.setListePeriodeAvecRevenu(listeComparerPANSCaliDetail);
        comparerPANSApresCali.add(comparerPANSCali);
      }
      resultat.setListeAvantCali(comparerPANSAvantCali);
      resultat.setListeApresCali(comparerPANSApresCali);
      
      List pansCaliFusion = fusionnerListesAvantApresCali(comparerPANSAvantCali, comparerPANSApresCali);
      resultat.setListeCali(pansCaliFusion);
    }
  }
  
  private List fusionnerListesAvantApresCali(List listeAvant, List listeApres)
  {
    List listeFusion = new ArrayList();
    ComparerPANSCali pansAvant = null;
    ComparerPANSCali pansApres = null;
    
    int cptAvant = 0;
    int cptApres = 0;
    for (int i = 0; i < listeAvant.size() + listeApres.size(); i++)
    {
      if ((cptAvant == listeAvant.size()) && (cptApres == listeApres.size())) {
        break;
      }
      pansAvant = cptAvant < listeAvant.size() ? (ComparerPANSCali)listeAvant.get(cptAvant) : null;
      pansApres = cptApres < listeApres.size() ? (ComparerPANSCali)listeApres.get(cptApres) : null;
      
      ComparerPANSCali pans = new ComparerPANSCali();
      if ((pansAvant != null) && (pansApres != null) && (pansAvant.getDateDebut().coincideAvec(pansApres.getDateDebut())) && (pansAvant.getDateFin().coincideAvec(pansApres.getDateFin())))
      {
        pans.setIdentifiant(pansAvant.getIdentifiant());
        pans.setDateDebut(pansAvant.getDateDebut());
        pans.setDateFin(pansAvant.getDateFin());
        pans.setEcart(false);
        if ((pansAvant.getListePeriodeAvecRevenu() != null) && (pansApres.getListePeriodeAvecRevenu() != null)) {
          pans.setListePeriodeAvecRevenu(fusionnerListesAvantApresCaliDetail(pansAvant.getListePeriodeAvecRevenu(), pansApres.getListePeriodeAvecRevenu(), pans));
        }
        cptAvant++;
        cptApres++;
      }
      else if ((pansApres == null) || ((pansAvant != null) && (pansAvant.getDateDebut().estAvant(pansApres.getDateDebut()))))
      {
        pans.setIdentifiant(pansAvant.getIdentifiant());
        pans.setDateDebut(pansAvant.getDateDebut());
        pans.setDateFin(pansAvant.getDateFin());
        pans.setEcart(true);
        Iterator iter;
        if (pansAvant.getListePeriodeAvecRevenu() != null)
        {
          pans.setListePeriodeAvecRevenu(pansAvant.getListePeriodeAvecRevenu());
          for (iter = pans.getListePeriodeAvecRevenu().iterator(); iter.hasNext();)
          {
            ComparerPANSCaliDetail pansDetail = (ComparerPANSCaliDetail)iter.next();
            pansDetail.setEcart(true);
          }
        }
        cptAvant++;
      }
      else
      {
        pans.setIdentifiant(pansApres.getIdentifiant());
        pans.setDateDebut(pansApres.getDateDebut());
        pans.setDateFin(pansApres.getDateFin());
        pans.setEcart(true);
        if (pansApres.getListePeriodeAvecRevenu() != null)
        {
          List listePansDetail = new ArrayList();
          for (Iterator iter = pansApres.getListePeriodeAvecRevenu().iterator(); iter.hasNext();)
          {
            ComparerPANSCaliDetail pansDetailApres = (ComparerPANSCaliDetail)iter.next();
            ComparerPANSCaliDetail pansDetail = new ComparerPANSCaliDetail();
            pansDetail.setIdentifiant(pansDetailApres.getIdentifiant());
            pansDetail.setDateDebut(pansDetailApres.getDateDebut());
            pansDetail.setDateFin(pansDetailApres.getDateFin());
            pansDetail.setMontant(null);
            pansDetail.setTypeRevenu(null);
            pansDetail.setMontantApres(pansDetailApres.getMontant());
            pansDetail.setTypeRevenuApres(pansDetailApres.getTypeRevenu());
            pansDetail.setEcart(true);
            listePansDetail.add(pansDetail);
          }
          pans.setListePeriodeAvecRevenu(listePansDetail);
        }
        cptApres++;
      }
      listeFusion.add(pans);
    }
    return listeFusion;
  }
  
  private List fusionnerListesAvantApresCaliDetail(List listeAvant, List listeApres, ComparerPANSCali pans)
  {
    List listeDetailFusion = new ArrayList();
    ComparerPANSCaliDetail pansDetailAvant = null;
    ComparerPANSCaliDetail pansDetailApres = null;
    
    int cptDetailAvant = 0;
    int cptDetailApres = 0;
    for (int j = 0; j < listeAvant.size() + listeApres.size(); j++)
    {
      if ((cptDetailAvant == listeAvant.size()) && (cptDetailApres == listeApres.size())) {
        break;
      }
      pansDetailAvant = cptDetailAvant < listeAvant.size() ? (ComparerPANSCaliDetail)listeAvant.get(cptDetailAvant) : null;
      pansDetailApres = cptDetailApres < listeApres.size() ? (ComparerPANSCaliDetail)listeApres.get(cptDetailApres) : null;
      
      ComparerPANSCaliDetail pansDetail = new ComparerPANSCaliDetail();
      if ((pansDetailAvant != null) && (pansDetailApres != null) && (pansDetailAvant.getDateDebut().coincideAvec(pansDetailApres.getDateDebut())) && (pansDetailAvant.getDateFin().coincideAvec(pansDetailApres.getDateFin())))
      {
        pansDetail.setIdentifiant(pansDetailAvant.getIdentifiant());
        pansDetail.setDateDebut(pansDetailAvant.getDateDebut());
        pansDetail.setDateFin(pansDetailAvant.getDateFin());
        pansDetail.setMontant(pansDetailAvant.getMontant());
        pansDetail.setTypeRevenu(pansDetailAvant.getTypeRevenu());
        pansDetail.setMontantApres(pansDetailApres.getMontant());
        pansDetail.setTypeRevenuApres(pansDetailApres.getTypeRevenu());
        pansDetail.setEcart(false);
        if ((pansDetail.getMontant().compareTo(pansDetail.getMontantApres()) != 0) || (!pansDetail.getTypeRevenu().equals(pansDetail.getTypeRevenuApres())))
        {
          pansDetail.setEcart(true);
          pans.setEcart(true);
        }
        cptDetailAvant++;
        cptDetailApres++;
      }
      else if ((pansDetailApres == null) || ((pansDetailAvant != null) && (pansDetailAvant.getDateDebut().estAvant(pansDetailApres.getDateDebut()))))
      {
        pansDetail.setIdentifiant(pansDetailAvant.getIdentifiant());
        pansDetail.setDateDebut(pansDetailAvant.getDateDebut());
        pansDetail.setDateFin(pansDetailAvant.getDateFin());
        pansDetail.setMontant(pansDetailAvant.getMontant());
        pansDetail.setTypeRevenu(pansDetailAvant.getTypeRevenu());
        pansDetail.setMontantApres(null);
        pansDetail.setTypeRevenuApres(null);
        pansDetail.setEcart(true);
        pans.setEcart(true);
        cptDetailAvant++;
      }
      else
      {
        pansDetail.setIdentifiant(pansDetailApres.getIdentifiant());
        pansDetail.setDateDebut(pansDetailApres.getDateDebut());
        pansDetail.setDateFin(pansDetailApres.getDateFin());
        pansDetail.setMontant(null);
        pansDetail.setTypeRevenu(null);
        pansDetail.setMontantApres(pansDetailApres.getMontant());
        pansDetail.setTypeRevenuApres(pansDetailApres.getTypeRevenu());
        pansDetail.setEcart(true);
        pans.setEcart(true);
        cptDetailApres++;
      }
      listeDetailFusion.add(pansDetail);
    }
    return listeDetailFusion;
  }
  
  private static PeriodeActiviteNonSalariePeriodique creerPeriodeActiviteNonSalariee(Damj dateDebut, Damj dateFin, Collection revenuAnnuel, int natureActivite)
    throws CoucheLogiqueException
  {
    ChampsPeriodeActivite champsPeriodeActivite = ChampsPeriodeActivite.getInstance();
    champsPeriodeActivite.setDateDebut(dateDebut);
    champsPeriodeActivite.setDateFin(dateFin);
    champsPeriodeActivite.setIdentifiant(Integer.valueOf(new Random().nextInt()).toString());
    
    Iterator ite = revenuAnnuel.iterator();
    
    PANSPeriodique pansPeriodique = PANSPeriodique.getInstance();
    pansPeriodique.setGenerationPANS(new BigDecimal(0));
    
    PANS pans = PANS.getInstance();
    pans.setPANSPeriodique(pansPeriodique);
    pans.setNature(Integer.toString(natureActivite));
    
    PeriodeActivite periodeActivite = PeriodeActivite.getInstance();
    periodeActivite.setChampsPeriodeActivite(champsPeriodeActivite);
    periodeActivite.setPANS(pans);
    
    PeriodeActiviteNonSalariePeriodique periode = MapperPans.mapperPans(periodeActivite);
    periode.setNatureActivite(natureActivite);
    periode.setIdentifiant(Integer.valueOf(new Random().nextInt()).toString());
    periode.setEtatProfessionnelGlobalPourAppletLiq(false);
    
    return periode;
  }
}

/* Location:
 * Qualified Name:     ParcoursLireComparaisonPANS
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.calcul.outilsfonctionnels;

import fr.unedic.cali.autresdoms.ga.services.LA2K;
import fr.unedic.cali.calcul.FacadeCalculProduitPeriodiqueSpec;
import fr.unedic.cali.calcul.FacadeCalculProduitSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculPeriodique;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.Somme;
import fr.unedic.cali.calcul.dom.SyntheseARsurUT;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyse;
import fr.unedic.cali.calcul.outilsfonctionnels.filtres.FiltrePeriodeTravailCalculDeclaree;
import fr.unedic.cali.calcul.outilsfonctionnels.filtres.FiltrePeriodeTravailCalculJustifiee;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.MontantBaseSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

public class GestionLA2K
{
  private static final BigDecimal ZERO = new BigDecimal("0");
  private static final BigDecimal DECALAGE_FORCE_NULL = new BigDecimal("99");
  private static final String OUI = "O";
  private static final String NON = "N";
  private static final BigDecimal PLAFONNEMENT_LA2K = new BigDecimal("99999.99");
  private static final BigDecimal PLAFONNEMENT_HEURES_AR = new BigDecimal("999");
  
  public static void enrichirCollectionPeriodesActiviteReduite(AttributionSpec attribution, CalendrierExecutionCalculSpec calendrierExecutionCalcul, FacadeCalculProduitSpec facadeCalculProduit, Collection listeLA2K, Damj dateDebutExecution)
    throws CoucheLogiqueException
  {
    if (((facadeCalculProduit instanceof FacadeCalculProduitPeriodiqueSpec)) && (((FacadeCalculProduitPeriodiqueSpec)facadeCalculProduit).alimenterLA2K()))
    {
      ChronologiePeriodes chronoUTs = (ChronologiePeriodes)((CalendrierExecutionCalculPeriodique)calendrierExecutionCalcul).getChronologieUnitesTraitements();
      
      UniteTraitement uniteTraitement = null;
      LA2K la2k = null;
      Iterator it = chronoUTs.iterer();
      while (it.hasNext())
      {
        uniteTraitement = (UniteTraitement)it.next();
        if ((dateDebutExecution == null) || (dateDebutExecution.estContenueDans(uniteTraitement.getPeriode())) || (uniteTraitement.getDateDebut().estApresOuCoincideAvec(dateDebutExecution)))
        {
          la2k = creerLA2K(attribution, uniteTraitement, dateDebutExecution);
          
          SyntheseARsurUT syntheseARsurUT = uniteTraitement.getSyntheseARsurUT();
          if ((syntheseARsurUT.getCumulJourDeTravailAR() != null) || (la2k.getCodeMemeEmployeur() != 0) || (uniteTraitement.isPresenceDnj()) || (uniteTraitement.getStatut() == 4)) {
            ajouterOuFusionnerPeriodeActiviteReduite(listeLA2K, la2k);
          }
        }
      }
    }
  }
  
  private static void ajouterOuFusionnerPeriodeActiviteReduite(Collection listeLA2K, LA2K la2k)
  {
    LA2K la2kCourante = null;
    
    boolean fusionFaite = false;
    
    Iterator i = listeLA2K.iterator();
    while ((i.hasNext()) && (!fusionFaite))
    {
      la2kCourante = (LA2K)i.next();
      if ((la2kCourante.getMois() == la2k.getMois()) && (la2kCourante.getAnnee() == la2k.getAnnee()))
      {
        la2kCourante.setDateDebutExecution(la2k.getDateDebutExecution());
        
        la2kCourante.setNbHeure(la2kCourante.getNbHeure().add(la2k.getNbHeure()).min(PLAFONNEMENT_HEURES_AR));
        
        la2kCourante.setSalaireBrut(la2kCourante.getSalaireBrut().add(la2k.getSalaireBrut()).min(PLAFONNEMENT_LA2K));
        if ((la2kCourante.getCodeMemeEmployeur() == 0) && (la2k.getCodeMemeEmployeur() == 1)) {
          la2kCourante.setCodeMemeEmployeur(1);
        }
        la2kCourante.setNbJrDecForce(la2kCourante.getNbJrDecForce().add(la2k.getNbJrDecForce()).min(DECALAGE_FORCE_NULL));
        
        BigDecimal nbJoursDuMois = new BigDecimal(Damj.getNbJoursMois(la2kCourante.getMois(), la2kCourante.getAnnee()));
        la2kCourante.setNbJrTravailCumul(nbJoursDuMois.min(la2kCourante.getNbJrTravailCumul().add(la2k.getNbJrTravailCumul())));
        
        la2kCourante.setCompletude(la2k.getCompletude());
        if ((la2kCourante.getSanctionPND() == 0) && (la2k.getSanctionPND() == 1)) {
          la2kCourante.setSanctionPND(1);
        }
        la2kCourante.setInfoTravailDSM(la2k.getInfoTravailDSM());
        
        la2kCourante.setSalaireBrutPND(la2kCourante.getSalaireBrutPND().add(la2k.getSalaireBrutPND()).min(PLAFONNEMENT_LA2K));
        
        la2kCourante.setSalaireBrutJustifie(la2kCourante.getSalaireBrutJustifie().add(la2k.getSalaireBrutJustifie()).min(PLAFONNEMENT_LA2K));
        
        la2kCourante.setNbHeureJustifie(la2kCourante.getNbHeureJustifie().add(la2k.getNbHeureJustifie()).min(PLAFONNEMENT_HEURES_AR));
        
        la2kCourante.setNbJrDecCalcul(la2kCourante.getNbJrDecCalcul().add(la2k.getNbJrDecCalcul().min(new BigDecimal(Damj.getNbJoursMois(la2k.getMois(), la2k.getAnnee())))));
        if ((la2kCourante.getValResultJustPND().compareTo(ZERO) > 0) && (la2k.getValResultJustPND().compareTo(ZERO) > 0)) {
          la2kCourante.setValResultJustPND(la2k.getValResultJustPND());
        }
        la2kCourante.setNbJrSanctionPND(la2kCourante.getNbJrSanctionPND().add(la2k.getNbJrSanctionPND()));
        
        la2kCourante.setCodePopulation(la2k.getCodePopulation());
        if (la2kCourante.getPresenceDnj().compareTo("N") == 0) {
          la2kCourante.setPresenceDnj(la2k.getPresenceDnj());
        }
        fusionFaite = true;
      }
    }
    if (!fusionFaite) {
      listeLA2K.add(la2k);
    }
  }
  
  private static LA2K creerLA2K(AttributionSpec attribution, UniteTraitement uniteTraitement, Damj dateDebutExecution)
  {
    LA2K la2k = new LA2K();
    
    la2k.setDateDebutExecution(dateDebutExecution);
    
    SyntheseARsurUT syntheseARsurUT = uniteTraitement.getSyntheseARsurUT();
    if (syntheseARsurUT != null)
    {
      if (syntheseARsurUT.getTotalHeureUtilisePourDecalage() != null) {
        la2k.setNbHeure(syntheseARsurUT.getTotalHeureUtilisePourDecalage().getValeur().min(PLAFONNEMENT_HEURES_AR));
      } else {
        la2k.setNbHeure(ZERO);
      }
      if (syntheseARsurUT.getTotalGainUtilisePourDecalage() != null) {
        la2k.setSalaireBrut(syntheseARsurUT.getTotalGainUtilisePourDecalage().getValeur().min(PLAFONNEMENT_LA2K));
      } else {
        la2k.setSalaireBrut(ZERO);
      }
      if (uniteTraitement.getTypeNeutralisation() == 6) {
        la2k.setCodeMemeEmployeur(1);
      } else {
        la2k.setCodeMemeEmployeur(0);
      }
      if (syntheseARsurUT.getQuantiteDecalageForcee() != null) {
        la2k.setNbJrDecForce(syntheseARsurUT.getQuantiteDecalageForcee().getValeur());
      } else {
        la2k.setNbJrDecForce(DECALAGE_FORCE_NULL);
      }
      if (syntheseARsurUT.getCumulJourDeTravailAR() != null)
      {
        BigDecimal nbJoursDuMois = new BigDecimal(Damj.getNbJoursMois(uniteTraitement.getDateDebut().getMois(), uniteTraitement.getDateDebut().getAnnee()));
        la2k.setNbJrTravailCumul(syntheseARsurUT.getCumulJourDeTravailAR().getValeur().min(nbJoursDuMois));
      }
      else
      {
        la2k.setNbJrTravailCumul(ZERO);
      }
      int statutUt = uniteTraitement.getStatut();
      switch (statutUt)
      {
      case 1: 
      case 6: 
        la2k.setCompletude(" ");
        break;
      case 2: 
      case 5: 
      case 7: 
        la2k.setCompletude("H");
        break;
      case 3: 
        la2k.setCompletude("C");
        break;
      case 4: 
        if (uniteTraitement.getEstAttenteJustifFormation()) {
          la2k.setCompletude("Z");
        } else {
          la2k.setCompletude("Y");
        }
        break;
      default: 
        la2k.setCompletude(" ");
      }
      if (uniteTraitement.getCreditDecalagePNDS() != null) {
        la2k.setSanctionPND(1);
      } else {
        la2k.setSanctionPND(0);
      }
      if (!uniteTraitement.getQualificationPeriodes().getPeriodesDecalantes().copier(new FiltrePeriodeTravailCalculJustifiee()).estVide()) {
        la2k.setInfoTravailDSM("J");
      } else if (!uniteTraitement.getQualificationPeriodes().getPeriodesDecalantes().copier(new FiltrePeriodeTravailCalculDeclaree()).estVide()) {
        la2k.setInfoTravailDSM("D");
      } else {
        la2k.setInfoTravailDSM(" ");
      }
      if (syntheseARsurUT.getCumulGainPNDS() != null) {
        la2k.setSalaireBrutPND(syntheseARsurUT.getCumulGainPNDS().getValeur().min(PLAFONNEMENT_LA2K));
      } else {
        la2k.setSalaireBrutPND(ZERO);
      }
      if (syntheseARsurUT.getTotalGainActiviteReduiteJustifie() != null) {
        la2k.setSalaireBrutJustifie(syntheseARsurUT.getTotalGainActiviteReduiteJustifie().getValeur().min(PLAFONNEMENT_LA2K));
      } else {
        la2k.setSalaireBrutJustifie(ZERO);
      }
      if (syntheseARsurUT.getTotalNbHeureActiviteReduiteJustifie() != null) {
        la2k.setNbHeureJustifie(syntheseARsurUT.getTotalNbHeureActiviteReduiteJustifie().getValeur().min(PLAFONNEMENT_HEURES_AR));
      } else {
        la2k.setNbHeureJustifie(ZERO);
      }
      if (syntheseARsurUT.getTotalGainActiviteReprise() != null) {
        la2k.setSalaireBrutReprise(syntheseARsurUT.getTotalGainActiviteReprise().getValeur().min(PLAFONNEMENT_LA2K));
      } else {
        la2k.setSalaireBrutReprise(ZERO);
      }
      if (syntheseARsurUT.getTotalNbHeureActiviteReprise() != null) {
        la2k.setNbHeureReprise(syntheseARsurUT.getTotalNbHeureActiviteReprise().getValeur().min(PLAFONNEMENT_HEURES_AR));
      } else {
        la2k.setNbHeureReprise(ZERO);
      }
      if (syntheseARsurUT.getEstForfaitPans() != null) {
        la2k.setEstForfaitPans(syntheseARsurUT.getEstForfaitPans());
      }
      if (syntheseARsurUT.getMontantPANS() != null) {
        la2k.setMontantPANS(syntheseARsurUT.getMontantPANS());
      }
    }
    BigDecimal creditDecalagePa = new BigDecimal("0");
    boolean contientDecalageSurPa = false;
    Iterator<PeriodeAnalyse> ite = uniteTraitement.getListePeriodesAnalyse().iterer();
    while (ite.hasNext())
    {
      PeriodeAnalyse pa = (PeriodeAnalyse)ite.next();
      if (pa.getQuantiteDecalee() != null)
      {
        creditDecalagePa = creditDecalagePa.add(pa.getQuantiteDecalee().getValeur());
        contientDecalageSurPa = true;
      }
    }
    if (uniteTraitement.getCreditDecalage() != null) {
      la2k.setNbJrDecCalcul(uniteTraitement.getCreditDecalage().getValeur().min(new BigDecimal(Damj.getNbJoursMois(uniteTraitement.getDateDebut().getMois(), uniteTraitement.getDateDebut().getAnnee()))));
    } else if (contientDecalageSurPa) {
      la2k.setNbJrDecCalcul(creditDecalagePa.min(new BigDecimal(Damj.getNbJoursMois(uniteTraitement.getDateDebut().getMois(), uniteTraitement.getDateDebut().getAnnee()))));
    } else {
      la2k.setNbJrDecCalcul(ZERO);
    }
    if ((uniteTraitement.getCreditDecalagePNDS() != null) && (uniteTraitement.getCollectionSommes() != null) && (!uniteTraitement.getCollectionSommes().isEmpty()))
    {
      Iterator itSom = uniteTraitement.getCollectionSommes().iterator();
      Somme somme = (Somme)itSom.next();
      
      la2k.setValResultJustPND(somme.getMontant().getMontantBrut().getValeur());
    }
    else
    {
      la2k.setValResultJustPND(ZERO);
    }
    if (uniteTraitement.getCreditDecalagePNDS() != null) {
      la2k.setNbJrSanctionPND(uniteTraitement.getCreditDecalagePNDS().getValeur());
    } else {
      la2k.setNbJrSanctionPND(ZERO);
    }
    la2k.setAnnee(uniteTraitement.getDateDebut().getAnnee());
    la2k.setMois(uniteTraitement.getDateDebut().getMois());
    
    la2k.setCodePopulation(attribution.getDemandeur().determinerPopulationIndividu(uniteTraitement.getDateDebut()));
    if ((uniteTraitement.isPresenceDnj()) && ((attribution.getDemandeur().getDernierJourAtteste() == null) || (attribution.getDemandeur().getDernierJourAtteste().estApresOuCoincideAvec(uniteTraitement.getDateFin())))) {
      la2k.setPresenceDnj("O");
    } else {
      la2k.setPresenceDnj("N");
    }
    return la2k;
  }
}

/* Location:
 * Qualified Name:     GestionLA2K
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
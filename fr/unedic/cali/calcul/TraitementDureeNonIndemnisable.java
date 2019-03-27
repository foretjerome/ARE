package fr.unedic.cali.calcul;

import fr.unedic.cali.calcul.dom.ConstituantsIndemnisation;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.QuantiteNonIndemnises;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoRemplissage;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.PeriodeAnalyseSpec;
import fr.unedic.cali.calcul.outilsfonctionnels.proratisation.PeriodeProratisationFactory;
import fr.unedic.cali.dom.DureeNonIndemnisable;
import fr.unedic.cali.dom.ElementBaseIndemnisationSpec;
import fr.unedic.cali.dom.EtatQuantiteDroit;
import fr.unedic.util.Quantite;
import fr.unedic.util.QuantiteJour;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

public final class TraitementDureeNonIndemnisable
{
  private static final int TYPEDA = 1;
  private static final int TYPEFCP = 2;
  private static final int TYPEFS = 3;
  private static final int TYPEREFCP = 4;
  private static final int TYPEREFS = 5;
  
  public static void traitementDesDureesNonIndemnisees(QualificationPeriodes qualificationPeriodes, List<DureeNonIndemnisable> listeDureeNI, PeriodeAnalyseSpec pa, Quantite quantiteImputableSurLaPA, QuantiteNonIndemnises qteNonIndemnise, Damj debutDA, boolean estClauseRattrapage)
    throws CoucheLogiqueException
  {
    Quantite quantiteRestante = quantiteImputableSurLaPA;
    if (qteNonIndemnise.getDateDebut() == null) {
      qteNonIndemnise.setDateDebut(pa.getDateDebut());
    }
    if ((!listeDureeNI.isEmpty()) && (quantiteRestante.getValeur().compareTo(BigDecimal.ZERO) != 0))
    {
      DureeNonIndemnisable delaiAttente = recupererDureeNonIndemnisable(listeDureeNI, "DA");
      DureeNonIndemnisable franchiseCP = recupererDureeNonIndemnisable(listeDureeNI, "FCP");
      DureeNonIndemnisable franchiseS = recupererDureeNonIndemnisable(listeDureeNI, "FS");
      if ((delaiAttente != null) && (delaiAttente.getQuantiteCourante().getValeurEntiere() > 0) && (debutDA != null))
      {
        Quantite reliquatDA = delaiAttente.getQuantiteCourante();
        Damj finDA = null;
        if (reliquatDA.getValeurEntiere() == 1) {
          finDA = Damj.min(pa.getDateFin(), debutDA);
        } else if (reliquatDA.getValeurEntiere() > 1) {
          finDA = Damj.min(pa.getDateFin(), debutDA.deplacerVersAvant(new DureeCalendaire(0, 0, reliquatDA.getValeurEntiere() - 1)));
        }
        Periode periodeDA = new Periode(debutDA, finDA);
        
        ChronologiePeriodes chronoPeriodeDAdecoupe = PeriodeProratisationFactory.decoupeEtProratiseParDefaut(qualificationPeriodes.getPeriodesSuspensives(), periodeDA);
        
        ChronologiePeriodes chronoPeriodeNonSuspensive = OutillageCalculADate.retourneLesTrous(chronoPeriodeDAdecoupe, ObjetChronoRemplissage.class, periodeDA.getDebut(), periodeDA.getFin());
        
        int qteDAReporter = 0;
        chronoPeriodeNonSuspensive.iterer();
        while (chronoPeriodeNonSuspensive.encoreSuivant())
        {
          ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)chronoPeriodeNonSuspensive.elementSuivant();
          qteDAReporter += objetChronoPeriode.getDuree();
        }
        delaiAttente.imputerQuantite(new QuantiteJour(BigDecimal.valueOf(periodeDA.getDuree())));
        qteNonIndemnise.setQuantiteDelaiAttente(qteNonIndemnise.getQuantiteDelaiAttente() + periodeDA.getDuree());
        
        pa.setQuantiteNonIndemnisee(pa.getQuantiteNonIndemnisee().ajouter(new Quantite(qteDAReporter, quantiteRestante.getUnite())));
        quantiteRestante = pa.getQuantiteIndemnisable().soustraire(pa.getQuantiteNonIndemnisee());
      }
      quantiteRestante = mettreAjourFranchise(franchiseCP, quantiteRestante, qteNonIndemnise, pa, 2);
      
      quantiteRestante = mettreAjourFranchise(franchiseS, quantiteRestante, qteNonIndemnise, pa, 3);
      
      quantiteRestante = mettreAjourReliquatFranchise(franchiseCP, quantiteRestante, qteNonIndemnise, pa, 4, estClauseRattrapage);
      
      mettreAjourReliquatFranchise(franchiseS, quantiteRestante, qteNonIndemnise, pa, 5, estClauseRattrapage);
    }
  }
  
  public static int traitementDelaiAttenteEnDebutDeMois(QuantiteNonIndemnises qteNI, List<DureeNonIndemnisable> listeDureeNi, PeriodeAnalyseSpec pa)
  {
    int quantiteDAImputeePA = 0;
    if (!listeDureeNi.isEmpty())
    {
      DureeNonIndemnisable delaiAttente = recupererDureeNonIndemnisable(listeDureeNi, "DA");
      if ((franchiseActive(delaiAttente)) && (delaiAttente.getQuantiteCourante().compareTo(new QuantiteJour(new BigDecimal("7"))) != 0))
      {
        Quantite quantiteRestante = pa.getQuantiteIndemnisable();
        if (pa.getDateDebut().estLeDebutDuMois()) {
          qteNI.setDaTraiteEnDebutUT(true);
        }
        if (quantiteRestante.getValeur().compareTo(delaiAttente.getQuantiteCourante().getValeur()) < 0)
        {
          delaiAttente.imputerQuantite(quantiteRestante);
          miseAJourQuantiteNonIndemniseEtPA(qteNI, pa, 1, quantiteRestante);
          quantiteDAImputeePA = quantiteRestante.getValeurEntiere();
        }
        else
        {
          miseAJourQuantiteNonIndemniseEtPA(qteNI, pa, 1, delaiAttente.getQuantiteCourante());
          quantiteDAImputeePA = delaiAttente.getQuantiteCourante().getValeurEntiere();
          delaiAttente.imputerQuantite(delaiAttente.getQuantiteCourante());
        }
      }
    }
    return quantiteDAImputeePA;
  }
  
  private static Quantite mettreAjourFranchise(DureeNonIndemnisable franchise, Quantite quantiteRestante, QuantiteNonIndemnises qteNonIndemnise, PeriodeAnalyseSpec pa, int type)
  {
    Quantite qteRestanteAImputerSurLaPA = quantiteRestante;
    if (franchiseActive(franchise))
    {
      BigDecimal qteAConsAuMax = franchise.getQuantiteCourante().getValeur().min(franchise.getRythmeConsomation().getValeur());
      qteAConsAuMax = franchise.getReliquatMaxMois().getValeur().min(qteAConsAuMax);
      if ((qteRestanteAImputerSurLaPA.getValeur().compareTo(BigDecimal.ZERO) != 0) && (qteAConsAuMax.compareTo(BigDecimal.ZERO) != 0))
      {
        if (qteRestanteAImputerSurLaPA.getValeur().compareTo(qteAConsAuMax) < 0)
        {
          franchise.imputerQuantite(qteRestanteAImputerSurLaPA);
          franchise.setReliquatMaxMois(franchise.getReliquatMaxMois().soustraire(qteRestanteAImputerSurLaPA));
          qteRestanteAImputerSurLaPA = miseAJourQuantiteNonIndemniseEtPA(qteNonIndemnise, pa, type, qteRestanteAImputerSurLaPA);
        }
        else
        {
          franchise.imputerQuantite(new QuantiteJour(qteAConsAuMax));
          franchise.setReliquatMaxMois(new QuantiteJour(BigDecimal.ZERO));
          
          qteRestanteAImputerSurLaPA = miseAJourQuantiteNonIndemniseEtPA(qteNonIndemnise, pa, type, new QuantiteJour(qteAConsAuMax));
        }
      }
      else {
        franchise.setReliquatMaxMois(new QuantiteJour(qteAConsAuMax));
      }
    }
    return qteRestanteAImputerSurLaPA;
  }
  
  private static Quantite mettreAjourReliquatFranchise(DureeNonIndemnisable franchise, Quantite quantiteRestante, QuantiteNonIndemnises qteNonIndemnise, PeriodeAnalyseSpec pa, int type, boolean estClauseRattrapage)
  {
    Quantite qteRestante = quantiteRestante;
    if ((franchise != null) && (qteRestante.getValeur().compareTo(BigDecimal.ZERO) != 0) && (verifierEtatReliquatFranchise(franchise)) && (!estClauseRattrapage))
    {
      Quantite qtReportAImputer = franchise.getQuantiteCourante().min(franchise.getReliquat());
      qtReportAImputer = quantiteRestante.min(qtReportAImputer);
      franchise.imputerQuantite(qtReportAImputer);
      if (franchise.getEtatQuantiteDroit().getEtat() == 2) {
        franchise.setReliquat(null);
      } else {
        franchise.setReliquat(franchise.getReliquat().soustraire(qtReportAImputer));
      }
      qteRestante = miseAJourQuantiteNonIndemniseEtPA(qteNonIndemnise, pa, type, qtReportAImputer);
    }
    return qteRestante;
  }
  
  private static boolean verifierEtatReliquatFranchise(DureeNonIndemnisable franchise)
  {
    return (franchise.getEtat() == 1) && (franchise.getReliquat() != null) && (franchise.getReliquat().getValeur().compareTo(BigDecimal.ZERO) > 0);
  }
  
  public static DureeNonIndemnisable recupererDureeNonIndemnisable(List<DureeNonIndemnisable> listeDureeNonIdemnisable, String type)
  {
    Iterator<DureeNonIndemnisable> ite = listeDureeNonIdemnisable.iterator();
    DureeNonIndemnisable dureeNonIndemnisable = null;
    while (ite.hasNext())
    {
      DureeNonIndemnisable duree = (DureeNonIndemnisable)ite.next();
      if (duree.getType().equals(type)) {
        dureeNonIndemnisable = duree;
      }
    }
    return dureeNonIndemnisable;
  }
  
  private static Quantite miseAJourQuantiteNonIndemniseEtPA(QuantiteNonIndemnises qteNISurPA, PeriodeAnalyseSpec pa, int type, Quantite quantite)
  {
    switch (type)
    {
    case 1: 
      qteNISurPA.setQuantiteDelaiAttente(qteNISurPA.getQuantiteDelaiAttente() + quantite.getValeurEntiere());
      break;
    case 2: 
      qteNISurPA.setQuantiteFranchiseCP(qteNISurPA.getQuantiteFranchiseCP() + quantite.getValeurEntiere());
      break;
    case 3: 
      qteNISurPA.setQuantiteFranchiseSalaire(qteNISurPA.getQuantiteFranchiseSalaire() + quantite.getValeurEntiere());
      break;
    case 4: 
      qteNISurPA.setQuantiteReportCP(qteNISurPA.getQuantiteReportCP() + quantite.getValeurEntiere());
      break;
    case 5: 
      qteNISurPA.setQuantiteReportSalaire(qteNISurPA.getQuantiteReportSalaire() + quantite.getValeurEntiere());
      break;
    }
    pa.setQuantiteNonIndemnisee(pa.getQuantiteNonIndemnisee().ajouter(quantite));
    return pa.getQuantiteIndemnisable().soustraire(pa.getQuantiteNonIndemnisee());
  }
  
  public static void miseAJourReliquatMaxSurMoisEnDebutDeMois(List<DureeNonIndemnisable> listeDureeNonIdemnisable)
  {
    Iterator<DureeNonIndemnisable> ite = listeDureeNonIdemnisable.iterator();
    while (ite.hasNext())
    {
      DureeNonIndemnisable duree = (DureeNonIndemnisable)ite.next();
      if (duree.getReliquatMaxMois() == null) {
        duree.setReliquatMaxMois(duree.getRythmeConsomation());
      }
    }
  }
  
  public static void miseAJourReliquatMaxEnFinDeMois(List<DureeNonIndemnisable> listeDureeNonIdemnisable, boolean clauseRattrapage)
  {
    Iterator<DureeNonIndemnisable> ite = listeDureeNonIdemnisable.iterator();
    while (ite.hasNext())
    {
      DureeNonIndemnisable duree = (DureeNonIndemnisable)ite.next();
      if ((!duree.getType().equals("DA")) && (duree.getEtat() == 1))
      {
        if (!clauseRattrapage) {
          if (duree.getReliquat() != null) {
            duree.setReliquat(duree.getReliquat().ajouter(duree.getReliquatMaxMois()));
          } else {
            duree.setReliquat(duree.getReliquatMaxMois());
          }
        }
        duree.setQuantiteRestanteAConsommeSurMois(duree.getReliquatMaxMois().min(duree.getQuantiteCourante()));
        duree.setReliquatMaxMois(null);
      }
    }
  }
  
  public static void miseAJourReliquatFranchiseSurMoisNeutralise(ConstituantsIndemnisation constituantsIndemnisation)
  {
    List<DureeNonIndemnisable> listeDureeNonIdemnisable = constituantsIndemnisation.getListListeDureeNonIndemnisables();
    if (!listeDureeNonIdemnisable.isEmpty())
    {
      DureeNonIndemnisable franchiseCP = recupererDureeNonIndemnisable(listeDureeNonIdemnisable, "FCP");
      DureeNonIndemnisable franchiseS = recupererDureeNonIndemnisable(listeDureeNonIdemnisable, "FS");
      if (!constituantsIndemnisation.getElementBaseIndemnisationCourant().isClauseRattrapage())
      {
        if (franchiseActive(franchiseCP)) {
          if (franchiseCP.getReliquat() != null) {
            franchiseCP.setReliquat(franchiseCP.getReliquat().ajouter(franchiseCP.getRythmeConsomation()));
          } else {
            franchiseCP.setReliquat(franchiseCP.getRythmeConsomation());
          }
        }
        if (franchiseActive(franchiseS)) {
          if (franchiseS.getReliquat() != null) {
            franchiseS.setReliquat(franchiseS.getReliquat().ajouter(franchiseS.getRythmeConsomation()));
          } else {
            franchiseS.setReliquat(franchiseS.getRythmeConsomation());
          }
        }
      }
      else
      {
        if (franchiseCP != null) {
          franchiseCP.imputerQuantite(franchiseCP.getRythmeConsomation());
        }
        if (franchiseS != null) {
          franchiseS.imputerQuantite(franchiseS.getRythmeConsomation());
        }
      }
    }
  }
  
  private static boolean franchiseActive(DureeNonIndemnisable franchise)
  {
    boolean franchiseActive = false;
    if ((franchise != null) && (franchise.getEtat() == 1)) {
      franchiseActive = true;
    }
    return franchiseActive;
  }
}

/* Location:
 * Qualified Name:     TraitementDureeNonIndemnisable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
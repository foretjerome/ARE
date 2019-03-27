package fr.unedic.cali.calcul.pbjc.outilsfonctionnels;

import fr.unedic.cali.calcul.dom.EvenementParametre;
import fr.unedic.cali.calcul.dom.QualificationPeriodes;
import fr.unedic.cali.calcul.dom.UniteTraitement;
import fr.unedic.cali.calcul.dom.periode.ActionFormation;
import fr.unedic.cali.calcul.dom.periode.PeriodeFormation;
import fr.unedic.cali.calcul.dom.periode.PeriodeInterStageFormation;
import fr.unedic.cali.calcul.dom.temps.ObjetChronoNonIndemnise;
import fr.unedic.cali.calcul.parametres.ParametresIndemnisation;
import fr.unedic.cali.calcul.pbjc.FacadePBJCProduitSpec;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.Mathematiques;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.ObjetChronoPeriode;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class GenerateurPBJCsNonIndemnisable
{
  public static ChronologiePeriodes traiterPeriodesNonIndemnisable(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, UniteTraitement ut, String naturePBJCParDefaut)
    throws CoucheLogiqueException
  {
    ChronologiePeriodes chronologieARetourner = new ChronologiePeriodes();
    if (!ut.getChronosNonIndemnisee().isEmpty())
    {
      Iterator<ObjetChronoNonIndemnise> it = ut.getChronosNonIndemnisee().iterator();
      while (it.hasNext())
      {
        ObjetChronoNonIndemnise periode = (ObjetChronoNonIndemnise)it.next();
        Periode periodeNiInitiale = (Periode)periode.getPeriode().copie();
        
        List<Damj> datesRuptureFormation = getDateRuptureFormation(ut, periode.getPeriode());
        if (datesRuptureFormation.isEmpty())
        {
          PbjcNcp pbjcNcp = creerPbjcNiveauPeriodeNonIndemnisable(facadePBJCProduit, attribution, ut, naturePBJCParDefaut, periode, periodeNiInitiale);
          chronologieARetourner.ajouter(pbjcNcp);
        }
        else
        {
          Damj dateDebut = periode.getPeriode().getDebut();
          Iterator<Damj> iteratorDatesDecoupage = datesRuptureFormation.iterator();
          while (iteratorDatesDecoupage.hasNext())
          {
            Damj date = (Damj)iteratorDatesDecoupage.next();
            
            periode.getPeriode().setDebut(dateDebut);
            periode.getPeriode().setFin(date.veille());
            
            PbjcNcp pbjcNcp = creerPbjcNiveauPeriodeNonIndemnisable(facadePBJCProduit, attribution, ut, naturePBJCParDefaut, periode, periodeNiInitiale);
            chronologieARetourner.ajouter(pbjcNcp);
            dateDebut = periode.getDateFin().lendemain();
          }
          periode.getPeriode().setDebut(dateDebut);
          periode.getPeriode().setFin(periodeNiInitiale.getFin());
          PbjcNcp pbjcNcp = creerPbjcNiveauPeriodeNonIndemnisable(facadePBJCProduit, attribution, ut, naturePBJCParDefaut, periode, periodeNiInitiale);
          chronologieARetourner.ajouter(pbjcNcp);
        }
      }
    }
    return chronologieARetourner;
  }
  
  private static PbjcNcp creerPbjcNiveauPeriodeNonIndemnisable(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, UniteTraitement ut, String naturePBJCParDefaut, ObjetChronoNonIndemnise objetChronoNonIndemnise, Periode periodeNiInitiale)
    throws CoucheLogiqueException
  {
    PbjcNcp pbjcNcp = new PbjcNcp(objetChronoNonIndemnise.getDateDebut(), objetChronoNonIndemnise.getDateFin());
    
    pbjcNcp.setProduit(attribution.getProduitExecution().getNom());
    
    pbjcNcp.setEtatAdministratifOd("1");
    
    valorisationPbjcNonIndemnise(facadePBJCProduit, attribution, objetChronoNonIndemnise, pbjcNcp, periodeNiInitiale);
    
    pbjcNcp.setNbJoursImputes(0);
    pbjcNcp.setQualificationPeriode(1);
    
    pbjcNcp.setRegimeApplicable(facadePBJCProduit.retournerReglementApplicable(attribution));
    
    pbjcNcp.setStatutPaiement(ut.getStatut());
    
    pbjcNcp.setNaturePBJC(naturePBJCParDefaut);
    
    facadePBJCProduit.positionnerReferencesOuvertureDroit(pbjcNcp, attribution);
    
    facadePBJCProduit.positionnerActiviteReduite(pbjcNcp, ut.getConstituantsCalculActiviteReduiteEnFinUT());
    
    facadePBJCProduit.positionnerInfoConventionGestion(pbjcNcp, attribution);
    if (naturePBJCParDefaut.equals("AB")) {
      pbjcNcp.ajouterComplementDeJustification("HD");
    }
    facadePBJCProduit.positionnerCategorieAttribution(pbjcNcp, attribution, ut);
    
    pbjcNcp.setNbJoursAREF(ut.getNbJoursFormationEnDebutDUT());
    
    valorisationDonneeCGF(ut, pbjcNcp);
    
    return pbjcNcp;
  }
  
  private static void valorisationDonneeCGF(UniteTraitement ut, PbjcNcp pbjcNcp)
  {
    PeriodeFormation periodeFormationCalcul = positionnementDonneesFormation(ut, pbjcNcp);
    
    positionnementDonneesActionFormation(ut, pbjcNcp);
    if ((periodeFormationCalcul != null) && (periodeFormationCalcul.getPeriodeEffectiveInitiale() != null)) {
      ajouterGroupeMontantCGF(pbjcNcp, periodeFormationCalcul);
    }
  }
  
  private static PeriodeFormation positionnementDonneesFormation(UniteTraitement ut, PbjcNcp pbjcNcp)
  {
    PeriodeFormation periodeFormationCalcul = null;
    
    ChronologiePeriodes periodes = ut.getQualificationPeriodes().getPeriodesSegmentantes();
    periodes.iterer();
    while (periodes.encoreSuivant())
    {
      ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)periodes.elementSuivant();
      if ((objetChronoPeriode instanceof PeriodeFormation))
      {
        if (objetChronoPeriode.getDateDebut().equals(pbjcNcp.getDateDebut())) {
          if (((PeriodeFormation)objetChronoPeriode).getIdentifiantPeriodeFormation() == 1) {
            pbjcNcp.ajouterComplementDeJustification("BF");
          } else {
            pbjcNcp.ajouterComplementDeJustification("BA");
          }
        }
        if (objetChronoPeriode.getDateFin().equals(pbjcNcp.getDateFin()))
        {
          pbjcNcp.ajouterComplementDeJustification("TH");
          pbjcNcp.ajouterComplementDeJustification("TD");
          pbjcNcp.setCodeRadiationLendemainPeriode("31");
        }
        if (pbjcNcp.chevauche(new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin())))
        {
          periodeFormationCalcul = (PeriodeFormation)objetChronoPeriode;
          pbjcNcp.setIdStageFormation(periodeFormationCalcul.getIdentifiantPeriodeFormation());
          pbjcNcp.setTypeMesurePourLEmploi(periodeFormationCalcul.getTypeMesureEmploi());
        }
      }
      else if (((objetChronoPeriode instanceof PeriodeInterStageFormation)) && (objetChronoPeriode.getDateDebut().veille().equals(pbjcNcp.getDateFin())))
      {
        pbjcNcp.ajouterComplementDeJustification("TH");
        pbjcNcp.ajouterComplementDeJustification("TD");
      }
    }
    return periodeFormationCalcul;
  }
  
  private static void positionnementDonneesActionFormation(UniteTraitement ut, PbjcNcp pbjcNcp)
  {
    ChronologiePeriodes periodes = ut.getQualificationPeriodes().getPeriodesNonQualifiees();
    periodes.iterer();
    while (periodes.encoreSuivant())
    {
      ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)periodes.elementSuivant();
      if (((objetChronoPeriode instanceof ActionFormation)) && (pbjcNcp.chevauche(new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin()))))
      {
        pbjcNcp.setIdPlanFormation(((ActionFormation)objetChronoPeriode).getIdentifiantActionFormation());
        
        pbjcNcp.setTypeDePlan(((ActionFormation)objetChronoPeriode).getTypePlan());
      }
    }
  }
  
  private static void ajouterGroupeMontantCGF(PbjcNcp pbjcNcp, PeriodeFormation periodeFormationCalcul)
  {
    BigDecimal nbHeuresTotal = periodeFormationCalcul.getActionFormation().getQuantiteHoraireTotal().getValeur();
    BigDecimal nbDuree = periodeFormationCalcul.getActionFormation().getNbJourPeriodeFormation().getValeur();
    BigDecimal nbHeuresStageParJour = Mathematiques.diviseASup(nbHeuresTotal, nbDuree, 2);
    
    EvenementParametre evenementParametre = ParametresIndemnisation.getParametresIndemnisation().getElementActif(pbjcNcp.getDateDebut());
    BigDecimal tauxCotisationAccidentTravail = evenementParametre.getTauxAccidentTravail();
    if ((nbHeuresStageParJour != null) && (tauxCotisationAccidentTravail != null)) {
      pbjcNcp.ajouterGroupeMontants("CADT", 1, BigDecimal.ZERO, nbHeuresStageParJour, tauxCotisationAccidentTravail, Mathematiques.arrondiASup(nbHeuresStageParJour.multiply(tauxCotisationAccidentTravail), 2), "");
    }
  }
  
  private static void valorisationPbjcNonIndemnise(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, ObjetChronoNonIndemnise objetChronoNonIndemnise, PbjcNcp pbjcNcp, Periode periodeNiInitiale)
  {
    if (objetChronoNonIndemnise.getType().equals("DA")) {
      justificatifsPourDelaiAttente(objetChronoNonIndemnise, pbjcNcp, periodeNiInitiale);
    } else if ((objetChronoNonIndemnise.getType().equals("DECALAGE")) || (objetChronoNonIndemnise.getType().equals("PLAFOND"))) {
      justificatifsPourDecalage(objetChronoNonIndemnise, pbjcNcp);
    } else if ((objetChronoNonIndemnise.getType().equals("FCP")) || (objetChronoNonIndemnise.getType().equals("FCPR"))) {
      justificatifsPourFranchiseCP(objetChronoNonIndemnise, pbjcNcp, periodeNiInitiale);
    } else if ((objetChronoNonIndemnise.getType().equals("FS")) || (objetChronoNonIndemnise.getType().equals("FSR"))) {
      justificatifsPourFranchiseSalaire(facadePBJCProduit, attribution, objetChronoNonIndemnise, pbjcNcp, periodeNiInitiale);
    }
  }
  
  private static void justificatifsPourDecalage(ObjetChronoNonIndemnise objetChronoNonIndemnise, PbjcNcp pbjcNcp)
  {
    pbjcNcp.setEtatReglementaireOd("1");
    pbjcNcp.setNbJoursDecalage(objetChronoNonIndemnise.getDuree());
  }
  
  private static void justificatifsPourFranchiseSalaire(FacadePBJCProduitSpec facadePBJCProduit, AttributionSpec attribution, ObjetChronoNonIndemnise objetChronoNonIndemnise, PbjcNcp pbjcNcp, Periode periodeNiInitiale)
  {
    String reglement = facadePBJCProduit.retournerReglementApplicable(attribution);
    if (reglement.equalsIgnoreCase("A8")) {
      pbjcNcp.setTypeCarence("8F");
    } else if (reglement.equalsIgnoreCase("A10")) {
      pbjcNcp.setTypeCarence("10");
    }
    pbjcNcp.setEtatReglementaireOd("3");
    if (estOuverturePbjc(objetChronoNonIndemnise, periodeNiInitiale)) {
      pbjcNcp.ajouterComplementDeJustification("AH");
    }
    if (estFermeturePbjc(objetChronoNonIndemnise, periodeNiInitiale)) {
      pbjcNcp.ajouterComplementDeJustification("MH");
    }
  }
  
  private static void justificatifsPourFranchiseCP(ObjetChronoNonIndemnise objetChronoNonIndemnise, PbjcNcp pbjcNcp, Periode periodeNiInitiale)
  {
    pbjcNcp.setTypeCarence("FC");
    pbjcNcp.setEtatReglementaireOd("3");
    if (estOuverturePbjc(objetChronoNonIndemnise, periodeNiInitiale)) {
      pbjcNcp.ajouterComplementDeJustification("AM");
    }
    if (estFermeturePbjc(objetChronoNonIndemnise, periodeNiInitiale)) {
      pbjcNcp.ajouterComplementDeJustification("MM");
    }
  }
  
  private static void justificatifsPourDelaiAttente(ObjetChronoNonIndemnise objetChronoNonIndemnise, PbjcNcp pbjcNcp, Periode periodeNiInitiale)
  {
    pbjcNcp.setEtatReglementaireOd("9");
    if (estOuverturePbjc(objetChronoNonIndemnise, periodeNiInitiale)) {
      pbjcNcp.ajouterComplementDeJustification("AF");
    }
    if (estFermeturePbjc(objetChronoNonIndemnise, periodeNiInitiale)) {
      pbjcNcp.ajouterComplementDeJustification("MF");
    }
  }
  
  private static boolean estFermeturePbjc(ObjetChronoNonIndemnise objetChronoNonIndemnise, Periode periodeNiInitiale)
  {
    return periodeNiInitiale.getFin().coincideAvec(objetChronoNonIndemnise.getDateFin());
  }
  
  private static boolean estOuverturePbjc(ObjetChronoNonIndemnise objetChronoNonIndemnise, Periode periodeNiInitiale)
  {
    return periodeNiInitiale.getDebut().coincideAvec(objetChronoNonIndemnise.getDateDebut());
  }
  
  private static List<Damj> getDateRuptureFormation(UniteTraitement ut, Periode periodeNI)
    throws CoucheLogiqueException
  {
    List<Damj> datesRuptureFormation = new ArrayList();
    List<Damj> datesRupture = new ArrayList();
    
    PeriodeFormation periodeFormationCalcul = null;
    
    ChronologiePeriodes periodes = ut.getQualificationPeriodes().getPeriodesSegmentantes();
    periodes.iterer();
    while (periodes.encoreSuivant())
    {
      ObjetChronoPeriode objetChronoPeriode = (ObjetChronoPeriode)periodes.elementSuivant();
      if (((objetChronoPeriode instanceof PeriodeFormation)) && (periodeNI.chevauche(new Periode(objetChronoPeriode.getDateDebut(), objetChronoPeriode.getDateFin())))) {
        periodeFormationCalcul = (PeriodeFormation)objetChronoPeriode;
      }
    }
    if (periodeFormationCalcul != null)
    {
      if ((periodeFormationCalcul.getPeriodeEffectiveInitiale() != null) && (periodeFormationCalcul.getPeriodeEffectiveInitiale().chevauche(periodeNI)))
      {
        if (periodeFormationCalcul.getPeriodeEffectiveInitiale().getDebut().estContenueDans(periodeNI)) {
          datesRuptureFormation.add(periodeFormationCalcul.getDateDebut());
        }
        if (periodeFormationCalcul.getPeriodeEffectiveInitiale().getFin().estContenueDans(periodeNI)) {
          datesRuptureFormation.add(periodeFormationCalcul.getDateFin().lendemain());
        }
      }
      Iterator<Damj> iterateurDates = datesRuptureFormation.iterator();
      while (iterateurDates.hasNext())
      {
        Damj dateFormation = (Damj)iterateurDates.next();
        if ((dateFormation.estApres(periodeNI.getDebut())) && (dateFormation.estAvantOuCoincideAvec(periodeNI.getFin())) && (!datesRupture.contains(dateFormation))) {
          datesRupture.add(dateFormation);
        }
      }
    }
    return datesRupture;
  }
}

/* Location:
 * Qualified Name:     GenerateurPBJCsNonIndemnisable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
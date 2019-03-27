package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.DeltaMontantMensuel;
import fr.unedic.cali.autresdoms.d90.dom.Demande;
import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.calcul.dom.CalendrierExecutionCalculSpec;
import fr.unedic.cali.calcul.outilsfonctionnels.OutilComparaisonBaseEchange;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.outilsfonctionnels.ComparateurMontants;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.AppelLiquidation;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class OutilJustificationReexecution
{
  private ChronologiePeriodes chronoPBJCsAvant = null;
  private Collection collectionPrimesAvant = new ArrayList();
  private ChronologiePeriodes chronoAidesAvant = null;
  private Collection collectionEnquetesAvant = new ArrayList();
  private Collection collectionDispositifAvant = new ArrayList();
  private Collection collectionDroitsAvant = new ArrayList();
  private IndividuPbjcNcp individuAvant = null;
  private Map mapPji = new HashMap();
  private Map mapDji = new HashMap();
  private static List<Integer> listeNatureDecisions = new ArrayList();
  
  static
  {
    listeNatureDecisions.add(Integer.valueOf(16));
    listeNatureDecisions.add(Integer.valueOf(28));
    listeNatureDecisions.add(Integer.valueOf(19));
    listeNatureDecisions.add(Integer.valueOf(29));
    listeNatureDecisions.add(Integer.valueOf(18));
    listeNatureDecisions.add(Integer.valueOf(17));
    listeNatureDecisions.add(Integer.valueOf(20));
    listeNatureDecisions.add(Integer.valueOf(25));
    listeNatureDecisions.add(Integer.valueOf(49));
    listeNatureDecisions.add(Integer.valueOf(50));
  }
  
  private BigDecimal calculerDelta(Damj p_dateAvant, Damj p_dateApres)
  {
    if ((p_dateAvant != null) && (p_dateApres != null)) {
      return new BigDecimal(p_dateApres.joursEntre(p_dateAvant));
    }
    return null;
  }
  
  public void preTraitementBaseVisu(IndividuSpec p_individu, ComportementSpec p_comportement)
  {
    Iterator iter;
    if ((p_comportement != null) && (p_comportement.isEcrireEnBaseVisu()))
    {
      chronoPBJCsAvant = OutilComparaisonBaseEchange.getPbjcsApresDate(Damj.NUIT_DES_TEMPS, p_individu);
      collectionPrimesAvant = OutilComparaisonBaseEchange.getPrimesApresDate(Damj.NUIT_DES_TEMPS, p_individu);
      chronoAidesAvant = OutilComparaisonBaseEchange.getAidesApresDate(Damj.NUIT_DES_TEMPS, p_individu);
      if (p_comportement.isComparerBasesPivotsEchanges())
      {
        collectionEnquetesAvant = OutilComparaisonBaseEchange.getListeEnquetes(p_individu);
        collectionDroitsAvant = OutilComparaisonBaseEchange.getListeDroits(p_individu);
        individuAvant = OutilComparaisonBaseEchange.getIndividu(p_individu);
        collectionDispositifAvant = OutilComparaisonBaseEchange.getListeDispositif(p_individu);
      }
      Collection listeAttributionsExecutables = p_individu.getListeAttributionsExecutables();
      for (iter = listeAttributionsExecutables.iterator(); iter.hasNext();)
      {
        AttributionSpec attribution = (AttributionSpec)iter.next();
        CalendrierExecutionCalculSpec calendrierExecutionCalcul = attribution.getCalendrierExecutionCalcul();
        if ((calendrierExecutionCalcul != null) && (!"INR_PFM01_01".equals(attribution.getProduit().getNomUnique())))
        {
          mapPji.put(attribution.getDemande(), calendrierExecutionCalcul.getPremierJourIndemnisable());
          mapDji.put(attribution.getDemande(), calendrierExecutionCalcul.getDernierJourIndemnisable());
        }
      }
    }
  }
  
  public void postTraitementBaseVisuCalcul(IndividuSpec p_individu, ComportementSpec p_comportement, ResultatGestionnaireReexecutionSpec p_resultat)
    throws ApplicativeException
  {
    if ((p_comportement != null) && (p_comportement.isEcrireEnBaseVisu()))
    {
      Individu individuVisu = p_resultat.getIndividuVisu();
      if (!p_resultat.isDemandeEnReexamen())
      {
        Collection attributionsReexecutees = p_resultat.getAttributionsReexecutees();
        
        ChronologiePeriodes chronoPBJCsApres = OutilComparaisonBaseEchange.getPbjcsApresDate(Damj.NUIT_DES_TEMPS, p_individu);
        Collection collectionPrimesApres = OutilComparaisonBaseEchange.getPrimesApresDate(Damj.NUIT_DES_TEMPS, p_individu);
        ChronologiePeriodes chronoAidesApres = OutilComparaisonBaseEchange.getAidesApresDate(Damj.NUIT_DES_TEMPS, p_individu);
        if ((p_individu.getDernierJourAtteste() != null) && (p_individu.getDernierJourAtteste().estApresOuCoincideAvec(p_resultat.getDateReexecution())))
        {
          Collection deltasMontantsMensuels = ComparateurMontants.comparerPBJCsPrimesEtAides(chronoPBJCsAvant, chronoPBJCsApres, collectionPrimesAvant, collectionPrimesApres, chronoAidesAvant, chronoAidesApres, p_resultat.getDateReexecution(), p_individu.getDernierJourAtteste());
          
          individuVisu.setListeDeltasMontantsMensuels(deltasMontantsMensuels);
          
          BigDecimal montantIndemnise = BigDecimal.ZERO;
          Iterator iterateurDeltasMontants = deltasMontantsMensuels.iterator();
          while (iterateurDeltasMontants.hasNext())
          {
            DeltaMontantMensuel deltaMontantMensuel = (DeltaMontantMensuel)iterateurDeltasMontants.next();
            montantIndemnise = montantIndemnise.add(deltaMontantMensuel.getMontantIndemniseApres()).subtract(deltaMontantMensuel.getMontantIndemniseAvant());
          }
          individuVisu.setDeltaMontantBrut(montantIndemnise);
        }
        if (p_comportement.isComparerBasesPivotsEchanges())
        {
          Collection collectionEnquetesApres = OutilComparaisonBaseEchange.getListeEnquetes(p_individu);
          Collection collectionDispositifApres = OutilComparaisonBaseEchange.getListeDispositif(p_individu);
          Collection collectionDroitsApres = OutilComparaisonBaseEchange.getListeDroits(p_individu);
          IndividuPbjcNcp individuApres = OutilComparaisonBaseEchange.getIndividu(p_individu);
          
          Collection listeEcartsBases = OutilComparaisonBaseEchange.comparerElements(chronoPBJCsAvant.mapperVersCollection(), chronoPBJCsApres.mapperVersCollection());
          listeEcartsBases.addAll(OutilComparaisonBaseEchange.comparerElements(collectionPrimesAvant, collectionPrimesApres));
          listeEcartsBases.addAll(OutilComparaisonBaseEchange.comparerElements(collectionDispositifAvant, collectionDispositifApres));
          listeEcartsBases.addAll(OutilComparaisonBaseEchange.comparerElements(chronoAidesAvant.mapperVersCollection(), chronoAidesApres.mapperVersCollection()));
          listeEcartsBases.addAll(OutilComparaisonBaseEchange.comparerElements(collectionEnquetesAvant, collectionEnquetesApres));
          listeEcartsBases.addAll(OutilComparaisonBaseEchange.comparerElements(collectionDroitsAvant, collectionDroitsApres));
          if (individuAvant != null) {
            listeEcartsBases.addAll(OutilComparaisonBaseEchange.comparerElements(new LinkedList(Arrays.asList(new IndividuPbjcNcp[] { individuAvant })), new LinkedList(Arrays.asList(new IndividuPbjcNcp[] { individuApres }))));
          }
          individuVisu.setListeEcartsBases(listeEcartsBases);
        }
        if (attributionsReexecutees != null)
        {
          Iterator iter = attributionsReexecutees.iterator();
          while (iter.hasNext())
          {
            AttributionSpec attributionsReexecutee = (AttributionSpec)iter.next();
            if (attributionsReexecutee != null)
            {
              DemandeSpec demande = attributionsReexecutee.getDemande();
              if (demande != null)
              {
                if ((demande.getDemandeur() != null) && (demande.getDemandeur().getDernierJourAtteste() != null)) {
                  individuVisu.setDja(demande.getDemandeur().getDernierJourAtteste());
                }
                Demande demandeVisu = individuVisu.getDemande(demande.getIdentifiant());
                if (demandeVisu == null)
                {
                  demandeVisu = new Demande();
                  AppelLiquidation.alimenterDemandeVisu(demandeVisu, demande, p_comportement);
                  
                  demandeVisu.setEstImpacte(true);
                  demandeVisu.setEtatReexamen("O");
                  demandeVisu.setEstMigree(demande.estMigree());
                  demandeVisu.setEstFigee(demande.estNeutraliseeCalcul());
                  demandeVisu.setEstNeutralisee(demande.estNeutraliseeLiquidation());
                  individuVisu.ajouterDemande(demandeVisu);
                }
                Damj pjiAvant = null;
                Damj djiAvant = null;
                Damj pjiApres = null;
                Damj djiApres = null;
                CalendrierExecutionCalculSpec calendrierExecutionCalcul = attributionsReexecutee.getCalendrierExecutionCalcul();
                if ((calendrierExecutionCalcul != null) && (!"INR_PFM01_01".equals(attributionsReexecutee.getProduit().getNomUnique())))
                {
                  pjiAvant = (Damj)mapPji.get(attributionsReexecutee.getDemande());
                  djiAvant = (Damj)mapDji.get(attributionsReexecutee.getDemande());
                  pjiApres = calendrierExecutionCalcul.getPremierJourIndemnisable();
                  djiApres = calendrierExecutionCalcul.getDernierJourIndemnisable();
                }
                BigDecimal deltaPji = calculerDelta(pjiAvant, pjiApres);
                BigDecimal deltaDji = calculerDelta(djiAvant, djiApres);
                
                demandeVisu.setDeltaPJI(deltaPji);
                demandeVisu.setDeltaDJI(deltaDji);
                demandeVisu.setPjiAvant(pjiAvant);
                demandeVisu.setPjiApres(pjiApres);
                demandeVisu.setDjiAvant(djiAvant);
                demandeVisu.setDjiApres(djiApres);
                
                demandeVisu.setEstReexecutee(true);
              }
            }
          }
        }
      }
    }
  }
  
  public void postTraitementBaseVisuLiquidation(ComportementSpec p_comportement, ResultatGestionnaireReexecutionSpec p_resultat)
    throws ApplicativeException
  {
    ResultatGestionnaireReexecution resultatGestionnaireReexecution;
    Individu individuVisu;
    Iterator iter;
    if ((p_comportement != null) && (p_comportement.isEcrireEnBaseVisu()))
    {
      resultatGestionnaireReexecution = (ResultatGestionnaireReexecution)p_resultat;
      
      individuVisu = new Individu();
      individuVisu.setDateReexecution(resultatGestionnaireReexecution.getDateReexecution());
      resultatGestionnaireReexecution.setIndividuVisu(individuVisu);
      
      Collection demandesReliquidees = p_resultat.getDemandesReliquidees();
      for (iter = demandesReliquidees.iterator(); iter.hasNext();)
      {
        DemandeSpec demande = (DemandeSpec)iter.next();
        Demande demandeVisu = new Demande();
        
        List listeElementComparaison = (List)resultatGestionnaireReexecution.getResultatLiquidationSurDemande().get(demande);
        if (demande.estEnReExamen()) {
          demandeVisu.setEtatReexamen("R");
        } else if ((listeElementComparaison == null) || (listeElementComparaison.isEmpty())) {
          demandeVisu.setEtatReexamen("V");
        } else {
          demandeVisu.setEtatReexamen("E");
        }
        demandeVisu.setElementsComparaisonReexamen(listeElementComparaison);
        
        alimenterDemandeVisu(demandeVisu, demande, p_comportement);
        individuVisu.ajouterDemande(demandeVisu);
        if (demande.estEnReExamen()) {
          break;
        }
      }
    }
  }
  
  public void postTraitementBaseVisuEtat(ComportementSpec p_comportement, ResultatGestionnaireReexecutionSpec p_resultat)
    throws ApplicativeException
  {
    if ((p_comportement != null) && (p_comportement.isEcrireEnBaseVisu()))
    {
      Individu individuVisu = p_resultat.getIndividuVisu();
      if ((!p_resultat.isDemandeEnReexamen()) && ((individuVisu.getDeltaMontantBrut() == null) || (individuVisu.getDeltaMontantBrut().compareTo(BigDecimal.ZERO) == 0))) {
        individuVisu.setEtatTraitement(Individu.ETAT_TRAITEMENT_INDIVIDU_SANSOBJET);
      }
    }
  }
  
  private static String definirLibelleGamme(DemandeSpec p_demande)
  {
    String libelleGamme = null;
    if ((p_demande != null) && (p_demande.getGamme() != null)) {
      libelleGamme = p_demande.getGamme().getNomUnique();
    }
    return libelleGamme;
  }
  
  private static DossierExamenSpec recupereDossierExamen(DemandeSpec p_demande)
  {
    DossierExamenSpec dossierExamen = null;
    
    List listeDossierExamen = p_demande.getListeDossiersExamen();
    if ((listeDossierExamen != null) && (!listeDossierExamen.isEmpty())) {
      dossierExamen = (DossierExamenSpec)listeDossierExamen.iterator().next();
    }
    return dossierExamen;
  }
  
  private static boolean estDecisionRejeteeOuPoursuiteIndemnisation(int natureDecision)
  {
    return listeNatureDecisions.contains(Integer.valueOf(natureDecision));
  }
  
  private static void alimenterDemandeVisu(Demande demandeVisu, DemandeSpec demande, ComportementSpec comportement)
  {
    if ((comportement != null) && (comportement.isEcrireEnBaseVisu()))
    {
      demandeVisu.setIdDemande(demande.getIdentifiant());
      demandeVisu.setEstdecisionnee(demande.estDecisionnee());
      demandeVisu.setEstImpacte(true);
      demandeVisu.setTypeDemande(demande.getEvenementReferenceExamen().getTypeExamen());
      
      demandeVisu.setEstMigree(demande.estMigree());
      demandeVisu.setEstFigee(demande.estNeutraliseeCalcul());
      demandeVisu.setEstNeutralisee(demande.estNeutraliseeLiquidation());
      if (demande.estDecisionnee()) {
        alimenterDemandeVisuDecision(demandeVisu, demande);
      } else {
        demandeVisu.setDateAttribution(demande.getDateRecherche());
      }
    }
  }
  
  private static void alimenterDemandeVisuDecision(Demande demandeVisu, DemandeSpec demande)
  {
    String gamme = definirLibelleGamme(demande);
    boolean estDeTypeRbf = StringUtils.equals(gamme, "RBF");
    
    boolean estDeTypeMaintien = StringUtils.equals(demande.getEvenementReferenceExamen().getTypeExamen(), "ASU_06");
    
    DossierExamenSpec dossierExamen = null;
    if (estDeTypeRbf)
    {
      dossierExamen = recupereDossierExamen(demande);
      if (dossierExamen != null) {
        demandeVisu.setTypeDecision(((DecisionSpec)dossierExamen).getNatureDecision());
      }
    }
    else if (estDeTypeMaintien)
    {
      dossierExamen = recupereDossierExamen(demande);
      demandeVisu.setCodeProduit(15);
      if (dossierExamen != null) {
        demandeVisu.setTypeDecision(((DecisionSpec)dossierExamen).getNatureDecision());
      }
    }
    else
    {
      demandeVisu.setCodeProduit(demande.getDossierAffectation().getProduit().getCode());
      demandeVisu.setTypeDecision(((DecisionSpec)demande.getDossierAffectation().getDossierExamen()).getNatureDecision());
    }
    if (!estDecisionRejeteeOuPoursuiteIndemnisation(demandeVisu.getTypeDecision()))
    {
      if ((!estDeTypeRbf) && (!estDeTypeMaintien)) {
        demandeVisu.setDateAttribution(demande.getDossierAffectation().getDossierExamen().getDateAttribution());
      } else if ((dossierExamen != null) && (dossierExamen.getDateAttribution() != null)) {
        demandeVisu.setDateAttribution(dossierExamen.getDateAttribution());
      } else {
        demandeVisu.setDateAttribution(demande.getDateRecherche());
      }
    }
    else {
      demandeVisu.setDateAttribution(demande.getDateRecherche());
    }
  }
}

/* Location:
 * Qualified Name:     OutilJustificationReexecution
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
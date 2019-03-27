package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.calcul.pbjc.cons.ConstantesPBJC;
import fr.unedic.cali.calcul.pbjc.dom.IndividuPbjcNcp;
import fr.unedic.cali.calcul.pbjc.dom.PbjcNcp;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.cali.dom.spec.ConstantesCategorieTableEchange;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologiePeriodes;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import xcalia.lido.api.LiDOHelper;

public class ParcoursPbjcDetailler
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatPbjcDetailler resultatPbjcDetailler = new ResultatPbjcDetailler();
    
    IndividuPbjcNcp individuPbjcNcp = DomManager.getIndividuPbjcNcp();
    resultatPbjcDetailler.setDateDepartRetraiteCalculee(individuPbjcNcp.getDateDepartRetraiteCalculee());
    resultatPbjcDetailler.setDernierJourIndemnisable(individuPbjcNcp.getDernierJourIndemnisable());
    resultatPbjcDetailler.setAnomalieBloquant(individuPbjcNcp.isAnomalieBloquant());
    resultatPbjcDetailler.setCodeAnomalieCalcul(individuPbjcNcp.getCodeAnomalieCalcul());
    resultatPbjcDetailler.setDonneeAnomalieCalcul(individuPbjcNcp.getDonneeAnomalieCalcul());
    
    DomPbjcDetailler domPbjcDetailler = (DomPbjcDetailler)contexte.getDonnees();
    int offsetOriginal = Integer.parseInt(domPbjcDetailler.getOffset().toString());
    int offset = offsetOriginal;
    ChronologiePeriodes chronologiePeriodes = DomManager.getChronologiePbjcNcp();
    
    resultatPbjcDetailler.setEtat(1);
    
    chronologiePeriodes.iterer();
    if (offsetOriginal < 0) {
      while (chronologiePeriodes.encoreSuivant()) {
        chronologiePeriodes.elementSuivant();
      }
    }
    while (((offsetOriginal >= 0) && (chronologiePeriodes.encoreSuivant())) || ((offsetOriginal < 0) && (chronologiePeriodes.encorePrecedent())))
    {
      PbjcNcp pbjcNcp = (PbjcNcp)(offsetOriginal >= 0 ? chronologiePeriodes.elementSuivant() : chronologiePeriodes.elementPrecedent());
      if (((offsetOriginal == 0) && (pbjcNcp.getDateDebutPbjc().equals(domPbjcDetailler.getDateDebut()))) || ((offsetOriginal != 0) && (offset == 0)))
      {
        resultatPbjcDetailler.setDateDebut(pbjcNcp.getDateDebutPbjc());
        resultatPbjcDetailler.setDateFin(pbjcNcp.getDateFinPbjc());
        
        resultatPbjcDetailler.setRefOdPjcPremierFaitGenerateur(pbjcNcp.getRefOdPjcPremierFaitGenerateur());
        resultatPbjcDetailler.setRefOdPjcFaitGenerateurOrigine(pbjcNcp.getRefOdPjcFaitGenerateurOrigine());
        resultatPbjcDetailler.setIdentifiantReprise(pbjcNcp.getIdentifiantReprise());
        resultatPbjcDetailler.setNbJoursImputes(pbjcNcp.getNbJoursImputes());
        resultatPbjcDetailler.setNbJoursDecalage(pbjcNcp.getNbJoursDecalage());
        resultatPbjcDetailler.setNaturePBJC(pbjcNcp.getNaturePBJC());
        resultatPbjcDetailler.setNaturePbjcLibelle((String)ConstantesPBJC.LIB_NATURE.get(pbjcNcp.getNaturePBJC()));
        resultatPbjcDetailler.setReliquatDureeMax(pbjcNcp.getReliquatDureeMax());
        resultatPbjcDetailler.setReliquatDureeReglementaire(pbjcNcp.getReliquatDureeReglementaire());
        
        resultatPbjcDetailler.setEtatAdministratifOd(pbjcNcp.getEtatAdministratifOd());
        resultatPbjcDetailler.setEtatAdministratifOdLibelle((String)ConstantesPBJC.LIB_ETAT_ADMINISTRATIF.get(pbjcNcp.getEtatAdministratifOd()));
        resultatPbjcDetailler.setEtatReglementaireOd(pbjcNcp.getEtatReglementaireOd());
        resultatPbjcDetailler.setEtatReglementaireOdLibelle((String)ConstantesPBJC.LIB_ETAT_REGLEMENTAIRE.get(pbjcNcp.getEtatReglementaireOd()));
        
        resultatPbjcDetailler.setProduit(pbjcNcp.getProduit());
        resultatPbjcDetailler.setTypeCarence(pbjcNcp.getTypeCarence());
        
        resultatPbjcDetailler.setCategorieAttribution(pbjcNcp.getCategorie());
        resultatPbjcDetailler.setCategorieAttributionLibelle((String)ConstantesCategorieTableEchange.LIB_CATEGORIE_ATTRIBUTION.get(pbjcNcp.getProduit() + pbjcNcp.getCategorie()));
        
        resultatPbjcDetailler.setJustificationCalculMontant(pbjcNcp.getJustificationCalculMontant());
        resultatPbjcDetailler.setJustificationCalculMontantLibelle((String)ConstantesPBJC.LIB_JUSTIFICATION_MONTANT.get(pbjcNcp.getJustificationCalculMontant()));
        resultatPbjcDetailler.setMontantBrutJournalier(pbjcNcp.getResultatCalcul1());
        BigDecimal totalBrutJournalier = new BigDecimal(0);
        if ((pbjcNcp.getResultatCalcul1() != null) && (!"PCRC".equals(pbjcNcp.getCodeTypeMontant1()))) {
          totalBrutJournalier = totalBrutJournalier.add(pbjcNcp.getResultatCalcul1());
        }
        if ((pbjcNcp.getResultatCalcul2() != null) && (!"PCRC".equals(pbjcNcp.getCodeTypeMontant2()))) {
          totalBrutJournalier = totalBrutJournalier.add(pbjcNcp.getResultatCalcul2());
        }
        if ((pbjcNcp.getResultatCalcul3() != null) && (!"PCRC".equals(pbjcNcp.getCodeTypeMontant3()))) {
          totalBrutJournalier = totalBrutJournalier.add(pbjcNcp.getResultatCalcul3());
        }
        if ((pbjcNcp.getResultatCalcul4() != null) && (!"PCRC".equals(pbjcNcp.getCodeTypeMontant4()))) {
          totalBrutJournalier = totalBrutJournalier.add(pbjcNcp.getResultatCalcul4());
        }
        if ((pbjcNcp.getResultatCalcul5() != null) && (!"PCRC".equals(pbjcNcp.getCodeTypeMontant5()))) {
          totalBrutJournalier = totalBrutJournalier.add(pbjcNcp.getResultatCalcul5());
        }
        if ((pbjcNcp.getResultatCalcul6() != null) && (!"PCRC".equals(pbjcNcp.getCodeTypeMontant6()))) {
          totalBrutJournalier = totalBrutJournalier.add(pbjcNcp.getResultatCalcul6());
        }
        if ((pbjcNcp.getResultatCalcul7() != null) && (!"PCRC".equals(pbjcNcp.getCodeTypeMontant7()))) {
          totalBrutJournalier = totalBrutJournalier.add(pbjcNcp.getResultatCalcul7());
        }
        resultatPbjcDetailler.setTotalBrutJournalier(totalBrutJournalier);
        
        resultatPbjcDetailler.setStatutPaiement(pbjcNcp.getStatutPaiement());
        resultatPbjcDetailler.setStatutPaiementLibelle((String)ConstantesPBJC.LIB_STATUT_PAIEMENT.get(Integer.valueOf(pbjcNcp.getStatutPaiement())));
        resultatPbjcDetailler.setCodeMotifNonPaiement(pbjcNcp.getCodeMotifNonPaiement());
        resultatPbjcDetailler.setCodeMotifNonPaiementLibelle((String)ConstantesPBJC.LIB_CODE_MOTIF_DE_NON_PAIEMENT.get(pbjcNcp.getCodeMotifNonPaiement()));
        
        resultatPbjcDetailler.setMontantRessourceMensuel(pbjcNcp.getMontantRessourceMensuel());
        resultatPbjcDetailler.setMontantPensionInvalidite(pbjcNcp.getMontantPensionInvalidite());
        resultatPbjcDetailler.setMontantSalaireRevalorisePlafonne(pbjcNcp.getMontantSalaireRevalorisePlafonne());
        resultatPbjcDetailler.setCoefAvantageVieillesse(pbjcNcp.getCoefAvantageVieillesse());
        resultatPbjcDetailler.setMontantCumuleRevaloriseAV(pbjcNcp.getMontantCumuleRevaloriseAV());
        
        resultatPbjcDetailler.setCodeEtatPND(pbjcNcp.getCodeEtatPND());
        resultatPbjcDetailler.setMontantBaseJustificatifPND(pbjcNcp.getMontantBaseJustificatifPND());
        
        resultatPbjcDetailler.setNbMoisActiviteReduite(pbjcNcp.getNbMoisActiviteReduite());
        resultatPbjcDetailler.setCumulHeureActRed(pbjcNcp.getCumulHeureActRed());
        
        resultatPbjcDetailler.setTypeDispositif((String)ConstantesPBJC.LIB_TYPE_DISPOSITIF.get(pbjcNcp.getTypeDispositif()));
        
        resultatPbjcDetailler.setPresencePNDS(pbjcNcp.isPresencePnds());
        resultatPbjcDetailler.setMontantContMensuelEmploiRepris(pbjcNcp.getMontantContMensuelEmploiRepris());
        resultatPbjcDetailler.setExcedentsRemunerationMois(pbjcNcp.getExcedentsRemunerationMois());
        
        resultatPbjcDetailler.setRangProlongation(pbjcNcp.getRangProlongation());
        
        resultatPbjcDetailler.setMontantSjc(pbjcNcp.getMontantSjc());
        resultatPbjcDetailler.setCoefTempsPartiel(pbjcNcp.getCoefficientTempsPartiel());
        
        resultatPbjcDetailler.setSituationParticuliere(pbjcNcp.getSituationParticuliere());
        resultatPbjcDetailler.setSituationParticuliereLibelle((String)ConstantesPBJC.LIB_SITUATION_PARTICULIERE.get(pbjcNcp.getSituationParticuliere()));
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        resultatPbjcDetailler.setTsp(sdf.format((Date)LiDOHelper.getSyntheticValue(pbjcNcp.getPC(), "{version}")));
        
        resultatPbjcDetailler.setComplementDeJustification0(pbjcNcp.getComplementDeJustification0());
        resultatPbjcDetailler.setComplementDeJustification0Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification0()));
        
        resultatPbjcDetailler.setComplementDeJustification1(pbjcNcp.getComplementDeJustification1());
        resultatPbjcDetailler.setComplementDeJustification1Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification1()));
        
        resultatPbjcDetailler.setComplementDeJustification2(pbjcNcp.getComplementDeJustification2());
        resultatPbjcDetailler.setComplementDeJustification2Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification2()));
        
        resultatPbjcDetailler.setComplementDeJustification3(pbjcNcp.getComplementDeJustification3());
        resultatPbjcDetailler.setComplementDeJustification3Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification3()));
        
        resultatPbjcDetailler.setComplementDeJustification4(pbjcNcp.getComplementDeJustification4());
        resultatPbjcDetailler.setComplementDeJustification4Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification4()));
        
        resultatPbjcDetailler.setComplementDeJustification5(pbjcNcp.getComplementDeJustification5());
        resultatPbjcDetailler.setComplementDeJustification5Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification5()));
        
        resultatPbjcDetailler.setComplementDeJustification6(pbjcNcp.getComplementDeJustification6());
        resultatPbjcDetailler.setComplementDeJustification6Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification6()));
        
        resultatPbjcDetailler.setComplementDeJustification7(pbjcNcp.getComplementDeJustification7());
        resultatPbjcDetailler.setComplementDeJustification7Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification7()));
        
        resultatPbjcDetailler.setComplementDeJustification8(pbjcNcp.getComplementDeJustification8());
        resultatPbjcDetailler.setComplementDeJustification8Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification8()));
        
        resultatPbjcDetailler.setComplementDeJustification9(pbjcNcp.getComplementDeJustification9());
        resultatPbjcDetailler.setComplementDeJustification9Libelle((String)ConstantesPBJC.LIB_JUSTIFICATION.get(pbjcNcp.getComplementDeJustification9()));
        
        resultatPbjcDetailler.setCodeTypeMontant1(pbjcNcp.getCodeTypeMontant1());
        resultatPbjcDetailler.setComplementTypeMontant1(pbjcNcp.getComplementTypeMontant1());
        resultatPbjcDetailler.setComplementTypeMontant1Libelle((String)ConstantesPBJC.LIB_COMPLEMENT_TYPE_MONTANT.get(Integer.valueOf(pbjcNcp.getComplementTypeMontant1())));
        resultatPbjcDetailler.setAssiette1(pbjcNcp.getAssiette1());
        resultatPbjcDetailler.setBaseDeCalcul1(pbjcNcp.getBaseDeCalcul1());
        resultatPbjcDetailler.setTaux1(pbjcNcp.getTaux1());
        resultatPbjcDetailler.setResultatCalcul1(pbjcNcp.getResultatCalcul1());
        resultatPbjcDetailler.setPositionExoneration1(pbjcNcp.getPositionExoneration1());
        resultatPbjcDetailler.setPositionExoneration1Libelle((String)ConstantesPBJC.LIB_POSITION_EXONERATION.get(pbjcNcp.getPositionExoneration1()));
        
        resultatPbjcDetailler.setCodeTypeMontant2(pbjcNcp.getCodeTypeMontant2());
        resultatPbjcDetailler.setComplementTypeMontant2(pbjcNcp.getComplementTypeMontant2());
        resultatPbjcDetailler.setComplementTypeMontant2Libelle((String)ConstantesPBJC.LIB_COMPLEMENT_TYPE_MONTANT.get(Integer.valueOf(pbjcNcp.getComplementTypeMontant2())));
        resultatPbjcDetailler.setAssiette2(pbjcNcp.getAssiette2());
        resultatPbjcDetailler.setBaseDeCalcul2(pbjcNcp.getBaseDeCalcul2());
        resultatPbjcDetailler.setTaux2(pbjcNcp.getTaux2());
        resultatPbjcDetailler.setResultatCalcul2(pbjcNcp.getResultatCalcul2());
        resultatPbjcDetailler.setPositionExoneration2(pbjcNcp.getPositionExoneration2());
        resultatPbjcDetailler.setPositionExoneration2Libelle((String)ConstantesPBJC.LIB_POSITION_EXONERATION.get(pbjcNcp.getPositionExoneration2()));
        
        resultatPbjcDetailler.setCodeTypeMontant3(pbjcNcp.getCodeTypeMontant3());
        resultatPbjcDetailler.setComplementTypeMontant3(pbjcNcp.getComplementTypeMontant3());
        resultatPbjcDetailler.setComplementTypeMontant3Libelle((String)ConstantesPBJC.LIB_COMPLEMENT_TYPE_MONTANT.get(Integer.valueOf(pbjcNcp.getComplementTypeMontant3())));
        resultatPbjcDetailler.setAssiette3(pbjcNcp.getAssiette3());
        resultatPbjcDetailler.setBaseDeCalcul3(pbjcNcp.getBaseDeCalcul3());
        resultatPbjcDetailler.setTaux3(pbjcNcp.getTaux3());
        resultatPbjcDetailler.setResultatCalcul3(pbjcNcp.getResultatCalcul3());
        resultatPbjcDetailler.setPositionExoneration3(pbjcNcp.getPositionExoneration3());
        resultatPbjcDetailler.setPositionExoneration3Libelle((String)ConstantesPBJC.LIB_POSITION_EXONERATION.get(pbjcNcp.getPositionExoneration3()));
        
        resultatPbjcDetailler.setCodeTypeMontant4(pbjcNcp.getCodeTypeMontant4());
        resultatPbjcDetailler.setComplementTypeMontant4(pbjcNcp.getComplementTypeMontant4());
        resultatPbjcDetailler.setComplementTypeMontant4Libelle((String)ConstantesPBJC.LIB_COMPLEMENT_TYPE_MONTANT.get(Integer.valueOf(pbjcNcp.getComplementTypeMontant4())));
        resultatPbjcDetailler.setAssiette4(pbjcNcp.getAssiette4());
        resultatPbjcDetailler.setBaseDeCalcul4(pbjcNcp.getBaseDeCalcul4());
        resultatPbjcDetailler.setTaux4(pbjcNcp.getTaux4());
        resultatPbjcDetailler.setResultatCalcul4(pbjcNcp.getResultatCalcul4());
        resultatPbjcDetailler.setPositionExoneration4(pbjcNcp.getPositionExoneration4());
        resultatPbjcDetailler.setPositionExoneration4Libelle((String)ConstantesPBJC.LIB_POSITION_EXONERATION.get(pbjcNcp.getPositionExoneration4()));
        
        resultatPbjcDetailler.setCodeTypeMontant5(pbjcNcp.getCodeTypeMontant5());
        resultatPbjcDetailler.setComplementTypeMontant5(pbjcNcp.getComplementTypeMontant5());
        resultatPbjcDetailler.setComplementTypeMontant5Libelle((String)ConstantesPBJC.LIB_COMPLEMENT_TYPE_MONTANT.get(Integer.valueOf(pbjcNcp.getComplementTypeMontant5())));
        resultatPbjcDetailler.setAssiette5(pbjcNcp.getAssiette5());
        resultatPbjcDetailler.setBaseDeCalcul5(pbjcNcp.getBaseDeCalcul5());
        resultatPbjcDetailler.setTaux5(pbjcNcp.getTaux5());
        resultatPbjcDetailler.setResultatCalcul5(pbjcNcp.getResultatCalcul5());
        resultatPbjcDetailler.setPositionExoneration5(pbjcNcp.getPositionExoneration5());
        resultatPbjcDetailler.setPositionExoneration5Libelle((String)ConstantesPBJC.LIB_POSITION_EXONERATION.get(pbjcNcp.getPositionExoneration5()));
        
        resultatPbjcDetailler.setCodeTypeMontant6(pbjcNcp.getCodeTypeMontant6());
        resultatPbjcDetailler.setComplementTypeMontant6(pbjcNcp.getComplementTypeMontant6());
        resultatPbjcDetailler.setComplementTypeMontant6Libelle((String)ConstantesPBJC.LIB_COMPLEMENT_TYPE_MONTANT.get(Integer.valueOf(pbjcNcp.getComplementTypeMontant6())));
        resultatPbjcDetailler.setAssiette6(pbjcNcp.getAssiette6());
        resultatPbjcDetailler.setBaseDeCalcul6(pbjcNcp.getBaseDeCalcul6());
        resultatPbjcDetailler.setTaux6(pbjcNcp.getTaux6());
        resultatPbjcDetailler.setResultatCalcul6(pbjcNcp.getResultatCalcul6());
        resultatPbjcDetailler.setPositionExoneration6(pbjcNcp.getPositionExoneration6());
        resultatPbjcDetailler.setPositionExoneration6Libelle((String)ConstantesPBJC.LIB_POSITION_EXONERATION.get(pbjcNcp.getPositionExoneration6()));
        
        resultatPbjcDetailler.setCodeTypeMontant7(pbjcNcp.getCodeTypeMontant7());
        resultatPbjcDetailler.setComplementTypeMontant7(pbjcNcp.getComplementTypeMontant7());
        resultatPbjcDetailler.setComplementTypeMontant7Libelle((String)ConstantesPBJC.LIB_COMPLEMENT_TYPE_MONTANT.get(Integer.valueOf(pbjcNcp.getComplementTypeMontant7())));
        resultatPbjcDetailler.setAssiette7(pbjcNcp.getAssiette7());
        resultatPbjcDetailler.setBaseDeCalcul7(pbjcNcp.getBaseDeCalcul7());
        resultatPbjcDetailler.setTaux7(pbjcNcp.getTaux7());
        resultatPbjcDetailler.setResultatCalcul7(pbjcNcp.getResultatCalcul7());
        resultatPbjcDetailler.setPositionExoneration7(pbjcNcp.getPositionExoneration7());
        resultatPbjcDetailler.setPositionExoneration7Libelle((String)ConstantesPBJC.LIB_POSITION_EXONERATION.get(pbjcNcp.getPositionExoneration7()));
        
        resultatPbjcDetailler.setCodePays(pbjcNcp.getCodePays());
        resultatPbjcDetailler.setLibellePays((String)ConstantesPBJC.LIB_PAYS.get(pbjcNcp.getCodePays()));
        resultatPbjcDetailler.setCodeTypePopulation1(pbjcNcp.getTypePopulation1());
        resultatPbjcDetailler.setLibelleTypePopulation1((String)ConstantesPBJC.LIB_TYPE_POPULATION.get(pbjcNcp.getTypePopulation1()));
        resultatPbjcDetailler.setCodeTypePopulation2(pbjcNcp.getTypePopulation2());
        resultatPbjcDetailler.setLibelleTypePopulation2((String)ConstantesPBJC.LIB_TYPE_POPULATION.get(pbjcNcp.getTypePopulation2()));
        resultatPbjcDetailler.setCodeTypePopulation3(pbjcNcp.getTypePopulation3());
        resultatPbjcDetailler.setLibelleTypePopulation3((String)ConstantesPBJC.LIB_TYPE_POPULATION.get(pbjcNcp.getTypePopulation3()));
        resultatPbjcDetailler.setCodeTypePopulation4(pbjcNcp.getTypePopulation4());
        resultatPbjcDetailler.setLibelleTypePopulation4((String)ConstantesPBJC.LIB_TYPE_POPULATION.get(pbjcNcp.getTypePopulation4()));
        resultatPbjcDetailler.setCodeTypePopulation5(pbjcNcp.getTypePopulation5());
        resultatPbjcDetailler.setLibelleTypePopulation5((String)ConstantesPBJC.LIB_TYPE_POPULATION.get(pbjcNcp.getTypePopulation5()));
        resultatPbjcDetailler.setCodeSousTypePopulation1(pbjcNcp.getSousTypePopulation1());
        resultatPbjcDetailler.setLibelleSousTypePopulation1((String)ConstantesPBJC.LIB_SOUS_TYPE_POPULATION.get(pbjcNcp.getSousTypePopulation1()));
        resultatPbjcDetailler.setCodeSousTypePopulation2(pbjcNcp.getSousTypePopulation2());
        resultatPbjcDetailler.setLibelleSousTypePopulation2((String)ConstantesPBJC.LIB_SOUS_TYPE_POPULATION.get(pbjcNcp.getSousTypePopulation2()));
        resultatPbjcDetailler.setCodeSousTypePopulation3(pbjcNcp.getSousTypePopulation3());
        resultatPbjcDetailler.setLibelleSousTypePopulation3((String)ConstantesPBJC.LIB_SOUS_TYPE_POPULATION.get(pbjcNcp.getSousTypePopulation3()));
        resultatPbjcDetailler.setCodeSousTypePopulation4(pbjcNcp.getSousTypePopulation4());
        resultatPbjcDetailler.setLibelleSousTypePopulation4((String)ConstantesPBJC.LIB_SOUS_TYPE_POPULATION.get(pbjcNcp.getSousTypePopulation4()));
        resultatPbjcDetailler.setCodeSousTypePopulation5(pbjcNcp.getSousTypePopulation5());
        resultatPbjcDetailler.setLibelleSousTypePopulation5((String)ConstantesPBJC.LIB_SOUS_TYPE_POPULATION.get(pbjcNcp.getSousTypePopulation5()));
        resultatPbjcDetailler.setCodeStatut1(pbjcNcp.getStatutPrestation1());
        resultatPbjcDetailler.setLibelleStatut1((String)ConstantesPBJC.LIB_STATUT.get(pbjcNcp.getStatutPrestation1()));
        resultatPbjcDetailler.setCodeStatut2(pbjcNcp.getStatutPrestation2());
        resultatPbjcDetailler.setLibelleStatut2((String)ConstantesPBJC.LIB_STATUT.get(pbjcNcp.getStatutPrestation2()));
        resultatPbjcDetailler.setCodeStatut3(pbjcNcp.getStatutPrestation3());
        resultatPbjcDetailler.setLibelleStatut3((String)ConstantesPBJC.LIB_STATUT.get(pbjcNcp.getStatutPrestation3()));
        resultatPbjcDetailler.setCodeStatut4(pbjcNcp.getStatutPrestation4());
        resultatPbjcDetailler.setLibelleStatut4((String)ConstantesPBJC.LIB_STATUT.get(pbjcNcp.getStatutPrestation4()));
        resultatPbjcDetailler.setCodeStatut5(pbjcNcp.getStatutPrestation5());
        resultatPbjcDetailler.setLibelleStatut5((String)ConstantesPBJC.LIB_STATUT.get(pbjcNcp.getStatutPrestation5()));
        resultatPbjcDetailler.setCumulAllongementPlan(new BigDecimal(pbjcNcp.getCumulAllongementPlan()));
        resultatPbjcDetailler.setReliquatAllongementAref(new BigDecimal(pbjcNcp.getReliquatAllongementAREF()));
        resultatPbjcDetailler.setNbJourAllongementAref(new BigDecimal(pbjcNcp.getNbJoursAllongementAREF()));
        
        resultatPbjcDetailler.setEtat(0);
        break;
      }
      if (((pbjcNcp.getDateDebutPbjc().equals(domPbjcDetailler.getDateDebut())) && (offsetOriginal != 0)) || ((offsetOriginal != 0) && (offsetOriginal != offset) && (offset != 0))) {
        offset += (offsetOriginal > 0 ? -1 : 1);
      }
    }
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ParcoursPbjcDetailler ********\n");
    }
    return resultatPbjcDetailler;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursPbjcDetailler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
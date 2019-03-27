package fr.unedic.cali.calcul.pbjc.dom;

import fr.unedic.cali.autresdoms.d90.dom.spec.ElementBasePivotEchangeComparableSpec;
import fr.unedic.cali.autresdoms.d90.outilsfonctionnels.OutilComparaison;
import fr.unedic.cali.calcul.pbjc.cons.ConstantesPBJC;
import fr.unedic.cali.calcul.pbjc.dom.gen.PbjcNcpGen;
import fr.unedic.cali.dom.ObjetPersistantSpec;
import fr.unedic.cali.dom.persistance.util.DomManager;
import fr.unedic.transverse.dom.spec.DomPCSpec;
import fr.unedic.util.ObjetMetierSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import xcalia.lido.api.LiDOHelper;

public class PbjcNcp
  extends PbjcNcpGen
  implements ObjetPersistantSpec, ElementBasePivotEchangeComparableSpec
{
  private static final long serialVersionUID = -495804750605351569L;
  public static final int TYPE_PERIODE_SUSPENSIVE = 1;
  public static final int TYPE_PERIODE_MONTANT_NULL = 2;
  public static final int TYPE_PERIODE_A_SUPPRIMER = 3;
  public static final int TYPE_PERIODE_SUSPENSIVE_AVEC_IMPUTATION = 4;
  public static final int TYPE_PERIODE_NON_SUSPENSIVE_AVEC_IMPUTATION = 5;
  public static final int TYPE_PERIODE_SUSPENSIVE_AVEC_IMPUTATION_A_DATE = 6;
  private transient boolean periodeRessourcesSuperieuresPlafond = false;
  private transient int qualificationPeriode = 0;
  private transient String etatIndemnisation;
  protected transient Periode periode;
  protected transient Date tspElementPourEcartsBase = null;
  
  protected Periode getPeriode()
  {
    return periode;
  }
  
  protected void setPeriode(Periode pperiode)
  {
    periode = pperiode;
  }
  
  private PbjcNcp() {}
  
  public PbjcNcp(DomPCSpec pc)
  {
    super(pc);
  }
  
  public PbjcNcp(Damj debut, Damj fin)
  {
    super(debut, fin);
    etatIndemnisation = "PENDANT";
  }
  
  public void ajouterComplementDeJustification(String complementDeJustification)
  {
    if (!contientComplementDeJustification(complementDeJustification)) {
      if (super.getComplementDeJustification0() == null) {
        super.setComplementDeJustification0(complementDeJustification);
      } else if (super.getComplementDeJustification1() == null) {
        super.setComplementDeJustification1(complementDeJustification);
      } else if (super.getComplementDeJustification2() == null) {
        super.setComplementDeJustification2(complementDeJustification);
      } else if (super.getComplementDeJustification3() == null) {
        super.setComplementDeJustification3(complementDeJustification);
      } else if (super.getComplementDeJustification4() == null) {
        super.setComplementDeJustification4(complementDeJustification);
      } else if (super.getComplementDeJustification5() == null) {
        super.setComplementDeJustification5(complementDeJustification);
      } else if (super.getComplementDeJustification6() == null) {
        super.setComplementDeJustification6(complementDeJustification);
      } else if (super.getComplementDeJustification7() == null) {
        super.setComplementDeJustification7(complementDeJustification);
      } else if (super.getComplementDeJustification8() == null) {
        super.setComplementDeJustification8(complementDeJustification);
      } else if (super.getComplementDeJustification9() == null) {
        super.setComplementDeJustification9(complementDeJustification);
      }
    }
  }
  
  public void supprimerJustificationsOuverture()
  {
    Map mapJustifOuvertureSansMontantReduit = new HashMap();
    mapJustifOuvertureSansMontantReduit.putAll(ConstantesPBJC.LIB_JUSTIFICATION_OUVERTURE);
    mapJustifOuvertureSansMontantReduit.remove("EU");
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification0())) {
      super.setComplementDeJustification0(null);
    }
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification1())) {
      super.setComplementDeJustification1(null);
    }
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification2())) {
      super.setComplementDeJustification2(null);
    }
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification3())) {
      super.setComplementDeJustification3(null);
    }
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification4())) {
      super.setComplementDeJustification4(null);
    }
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification5())) {
      super.setComplementDeJustification5(null);
    }
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification6())) {
      super.setComplementDeJustification6(null);
    }
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification7())) {
      super.setComplementDeJustification7(null);
    }
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification8())) {
      super.setComplementDeJustification8(null);
    }
    if (mapJustifOuvertureSansMontantReduit.containsKey(super.getComplementDeJustification9())) {
      super.setComplementDeJustification9(null);
    }
  }
  
  public void supprimerJustificationsFermeture()
  {
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification0())) {
      super.setComplementDeJustification0(null);
    }
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification1())) {
      super.setComplementDeJustification1(null);
    }
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification2())) {
      super.setComplementDeJustification2(null);
    }
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification3())) {
      super.setComplementDeJustification3(null);
    }
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification4())) {
      super.setComplementDeJustification4(null);
    }
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification5())) {
      super.setComplementDeJustification5(null);
    }
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification6())) {
      super.setComplementDeJustification6(null);
    }
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification7())) {
      super.setComplementDeJustification7(null);
    }
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification8())) {
      super.setComplementDeJustification8(null);
    }
    if (ConstantesPBJC.LIB_JUSTIFICATION_FERMETURE.containsKey(super.getComplementDeJustification9())) {
      super.setComplementDeJustification9(null);
    }
  }
  
  public boolean contientComplementDeJustification(String complementDeJustification)
  {
    if (complementDeJustification.equals(super.getComplementDeJustification0())) {
      return true;
    }
    if (complementDeJustification.equals(super.getComplementDeJustification1())) {
      return true;
    }
    if (complementDeJustification.equals(super.getComplementDeJustification2())) {
      return true;
    }
    if (complementDeJustification.equals(super.getComplementDeJustification3())) {
      return true;
    }
    if (complementDeJustification.equals(super.getComplementDeJustification4())) {
      return true;
    }
    if (complementDeJustification.equals(super.getComplementDeJustification5())) {
      return true;
    }
    if (complementDeJustification.equals(super.getComplementDeJustification6())) {
      return true;
    }
    if (complementDeJustification.equals(super.getComplementDeJustification7())) {
      return true;
    }
    if (complementDeJustification.equals(super.getComplementDeJustification8())) {
      return true;
    }
    if (complementDeJustification.equals(super.getComplementDeJustification9())) {
      return true;
    }
    return false;
  }
  
  public void supprimeComplementDeJustification(String complementDeJustification)
  {
    if (complementDeJustification.equals(super.getComplementDeJustification0())) {
      super.setComplementDeJustification0(null);
    }
    if (complementDeJustification.equals(super.getComplementDeJustification1())) {
      super.setComplementDeJustification1(null);
    }
    if (complementDeJustification.equals(super.getComplementDeJustification2())) {
      super.setComplementDeJustification2(null);
    }
    if (complementDeJustification.equals(super.getComplementDeJustification3())) {
      super.setComplementDeJustification3(null);
    }
    if (complementDeJustification.equals(super.getComplementDeJustification4())) {
      super.setComplementDeJustification4(null);
    }
    if (complementDeJustification.equals(super.getComplementDeJustification5())) {
      super.setComplementDeJustification5(null);
    }
    if (complementDeJustification.equals(super.getComplementDeJustification6())) {
      super.setComplementDeJustification6(null);
    }
    if (complementDeJustification.equals(super.getComplementDeJustification7())) {
      super.setComplementDeJustification7(null);
    }
    if (complementDeJustification.equals(super.getComplementDeJustification8())) {
      super.setComplementDeJustification8(null);
    }
    if (complementDeJustification.equals(super.getComplementDeJustification9())) {
      super.setComplementDeJustification9(null);
    }
  }
  
  public void ajouterGroupeMontants(String codeTypeMontant, int complementTypeMontant, BigDecimal assiette, BigDecimal baseDeCalcul, BigDecimal taux, BigDecimal resultatCalcul, String positionExoneration)
  {
    if (super.getCodeTypeMontant1() == null)
    {
      super.setCodeTypeMontant1(codeTypeMontant);
      super.setComplementTypeMontant1(complementTypeMontant);
      super.setAssiette1(assiette);
      super.setBaseDeCalcul1(baseDeCalcul);
      super.setTaux1(taux);
      super.setResultatCalcul1(resultatCalcul);
      super.setPositionExoneration1(positionExoneration);
    }
    else if (super.getCodeTypeMontant2() == null)
    {
      super.setCodeTypeMontant2(codeTypeMontant);
      super.setComplementTypeMontant2(complementTypeMontant);
      super.setAssiette2(assiette);
      super.setBaseDeCalcul2(baseDeCalcul);
      super.setTaux2(taux);
      super.setResultatCalcul2(resultatCalcul);
      super.setPositionExoneration2(positionExoneration);
    }
    else if (super.getCodeTypeMontant3() == null)
    {
      super.setCodeTypeMontant3(codeTypeMontant);
      super.setComplementTypeMontant3(complementTypeMontant);
      super.setAssiette3(assiette);
      super.setBaseDeCalcul3(baseDeCalcul);
      super.setTaux3(taux);
      super.setResultatCalcul3(resultatCalcul);
      super.setPositionExoneration3(positionExoneration);
    }
    else if (super.getCodeTypeMontant4() == null)
    {
      super.setCodeTypeMontant4(codeTypeMontant);
      super.setComplementTypeMontant4(complementTypeMontant);
      super.setAssiette4(assiette);
      super.setBaseDeCalcul4(baseDeCalcul);
      super.setTaux4(taux);
      super.setResultatCalcul4(resultatCalcul);
      super.setPositionExoneration4(positionExoneration);
    }
    else if (super.getCodeTypeMontant5() == null)
    {
      super.setCodeTypeMontant5(codeTypeMontant);
      super.setComplementTypeMontant5(complementTypeMontant);
      super.setAssiette5(assiette);
      super.setBaseDeCalcul5(baseDeCalcul);
      super.setTaux5(taux);
      super.setResultatCalcul5(resultatCalcul);
      super.setPositionExoneration5(positionExoneration);
    }
    else if (super.getCodeTypeMontant6() == null)
    {
      super.setCodeTypeMontant6(codeTypeMontant);
      super.setComplementTypeMontant6(complementTypeMontant);
      super.setAssiette6(assiette);
      super.setBaseDeCalcul6(baseDeCalcul);
      super.setTaux6(taux);
      super.setResultatCalcul6(resultatCalcul);
      super.setPositionExoneration6(positionExoneration);
    }
    else if (super.getCodeTypeMontant7() == null)
    {
      super.setCodeTypeMontant7(codeTypeMontant);
      super.setComplementTypeMontant7(complementTypeMontant);
      super.setAssiette7(assiette);
      super.setBaseDeCalcul7(baseDeCalcul);
      super.setTaux7(taux);
      super.setResultatCalcul7(resultatCalcul);
      super.setPositionExoneration7(positionExoneration);
    }
  }
  
  public int getQualificationPeriode()
  {
    return qualificationPeriode;
  }
  
  public void setQualificationPeriode(int pqualificationPeriode)
  {
    qualificationPeriode = pqualificationPeriode;
  }
  
  public String getEtatIndemnisation()
  {
    return etatIndemnisation;
  }
  
  public void setEtatIndemnisation(String petatExecution)
  {
    etatIndemnisation = petatExecution;
  }
  
  public void setDateDebutPbjcsTrans(Damj dateDebut)
  {
    setDateDebut(dateDebut);
    super.setDateDebutPbjc(periode.getDebut());
    super.setDateFinPbjc(periode.getFin());
  }
  
  public void setDateDebutTrans(Damj dateDebut)
  {
    setDateDebut(dateDebut);
  }
  
  public void setDateFinTrans(Damj dateFin)
  {
    setDateFin(dateFin);
  }
  
  public void setDateFinPbjcsTrans(Damj dateFin)
  {
    setDateFin(dateFin);
    super.setDateDebutPbjc(periode.getDebut());
    super.setDateFinPbjc(periode.getFin());
  }
  
  public String toString()
  {
    StringBuffer bufferARetourner = new StringBuffer();
    bufferARetourner.append("PBJC " + (String)ConstantesPBJC.LIB_NATURE.get(super.getNaturePBJC()) + " : du " + getDateDebut() + " au " + getDateFin() + "\n");
    bufferARetourner.append(" - Ref od origine :                          " + super.getRefOdPjcPremierFaitGenerateur() + "\n");
    bufferARetourner.append(" - Ref od courante :                         " + super.getRefOdPjcFaitGenerateurOrigine() + "\n");
    bufferARetourner.append(" - Id reprise eventuelle :                   " + super.getIdentifiantReprise() + "\n");
    bufferARetourner.append(" - Ref base calcul montant :                 " + super.getRefBaseCalculMontantBrut() + "\n");
    bufferARetourner.append(" - Catégorie Attribution :                   " + super.getCategorie() + "\n");
    bufferARetourner.append(" - Code produit :                            " + super.getProduit() + "\n");
    bufferARetourner.append(" - Etat reglementaire :                      " + (String)ConstantesPBJC.LIB_ETAT_REGLEMENTAIRE.get(super.getEtatReglementaireOd()) + "\n");
    
    bufferARetourner.append(" - Etat administratif :                      " + (String)ConstantesPBJC.LIB_ETAT_ADMINISTRATIF.get(super.getEtatAdministratifOd()) + "\n");
    
    bufferARetourner.append(" - Rang de la prolongation :                 " + super.getRangProlongation() + "\n");
    bufferARetourner.append(" - Code radiation :                          " + super.getCodeRadiationLendemainPeriode() + "\n");
    bufferARetourner.append(" - Nb jours imputes :                        " + super.getNbJoursImputes() + "\n");
    bufferARetourner.append(" - Nb jours decalage :                       " + super.getNbJoursDecalage() + "\n");
    bufferARetourner.append(" - Cumul courant en debut :                  " + super.getCumulCourant() + "\n");
    bufferARetourner.append(" - Reliquat duree max :                      " + super.getReliquatDureeMax() + "\n");
    bufferARetourner.append(" - Reliquat duree reglementaire :            " + super.getReliquatDureeReglementaire() + "\n");
    bufferARetourner.append(" - Réglement applicable :                    " + (String)ConstantesPBJC.LIB_REGLEMENT_APPLICABLE.get(super.getRegimeApplicable()) + "\n");
    if (super.getJustificationCalculMontant() == null) {
      bufferARetourner.append(" - Justif du calcul du montant :             - (CALCUL PAR DEFAUT)\n");
    } else {
      bufferARetourner.append(" - Justif du calcul du montant :             " + (String)ConstantesPBJC.LIB_JUSTIFICATION_MONTANT.get(super.getJustificationCalculMontant()) + "\n");
    }
    if (getEtatIndemnisation().equals("AVANT")) {
      bufferARetourner.append(" - Type de la carence :                      " + (String)ConstantesPBJC.LIB_CARENCES.get(super.getTypeCarence()) + "\n");
    }
    bufferARetourner.append(" - SJR Revalorise Plafonne Reduit :          " + super.getMontantSalaireRevalorisePlafonne() + "\n");
    bufferARetourner.append(" - SJC                            :          " + super.getMontantSjc() + "\n");
    bufferARetourner.append(" - Coefficient temps partiel      :          " + super.getCoefficientTempsPartiel() + "\n");
    bufferARetourner.append(" - Montant ressource mensuelle    :          " + super.getMontantRessourceMensuel() + "\n");
    bufferARetourner.append(" - Rang actualisation ressources  :          " + super.getRangActualisationRessources() + "\n");
    bufferARetourner.append(" - Perception des ressources      :          " + super.getMoisPerceptionRessources() + "/" + super.getAnneePerceptionRessources() + "\n");
    
    bufferARetourner.append(" - Coeff av vieillesse :                     " + super.getCoefAvantageVieillesse() + "\n");
    bufferARetourner.append(" - Montant cumule revalorise av vieillesse : " + super.getMontantCumuleRevaloriseAV() + "\n");
    bufferARetourner.append(" - Id plan formation :                       " + super.getIdPlanFormation() + "\n");
    bufferARetourner.append(" - Type de plan :                            " + super.getTypeDePlan() + "\n");
    bufferARetourner.append(" - Id stage formation :                      " + super.getIdStageFormation() + "\n");
    bufferARetourner.append(" - Type mesure pour emploi :                 " + super.getTypeMesurePourLEmploi() + "\n");
    bufferARetourner.append(" - Code etat PND :                           " + super.getCodeEtatPND() + "\n");
    bufferARetourner.append(" - Montant base just PND :                   " + super.getMontantBaseJustificatifPND() + "\n");
    bufferARetourner.append(" - Statut du paiement :                      " + (String)ConstantesPBJC.LIB_STATUT_PAIEMENT.get(Integer.valueOf(super.getStatutPaiement())) + "\n");
    
    bufferARetourner.append(" - Montant pension invalidite :              " + super.getMontantPensionInvalidite() + "\n");
    bufferARetourner.append(" - Interr. par pension invalidite :          " + super.getInterrupIndemParPensionInvalidite() + "\n");
    bufferARetourner.append(" - Plafonnement FTH :                        " + super.isPlafonnementFTHR() + "\n");
    bufferARetourner.append(" - Prise en charge AERC :                    " + super.isPriseEnChargeAERC() + "\n");
    bufferARetourner.append(" - Code motif de non paiement :              " + (String)ConstantesPBJC.LIB_CODE_MOTIF_DE_NON_PAIEMENT.get(super.getCodeMotifNonPaiement()) + "\n");
    
    bufferARetourner.append(" - Date debut interruption par ressource :   " + super.getDateDebutInterrupRess() + "\n");
    bufferARetourner.append(" - Nombre de mois en activite reduite :      " + super.getNbMoisActiviteReduite() + "\n");
    bufferARetourner.append(" - Cumul d'heures d'activite reduite :       " + super.getCumulHeureActRed() + "\n");
    bufferARetourner.append(" - Nombre de mois en paiement provisoire :   " + super.getNbMoisPaiementProvis() + "\n");
    bufferARetourner.append(" - ALE Individu :                            " + super.getAleIndividu() + "\n");
    bufferARetourner.append(" - Tx Sanction :                             " + super.getTxSanction() + "\n");
    bufferARetourner.append(" - Application Convention Emploi Jeune :     " + super.isTopApplicationCRC() + "\n");
    bufferARetourner.append(" - Plafonnement Reliquat Droit par Date :    " + super.isTopPlafonnementDureeDroitParDate() + "\n");
    bufferARetourner.append(" - Nombre de jours en AREF :                 " + super.getNbJoursAREF() + "\n");
    bufferARetourner.append(" - Situation Particulière :                  " + super.getSituationParticuliere() + "\n");
    bufferARetourner.append(" - Catégorie :                               " + super.getCategorie() + "\n");
    bufferARetourner.append(" - Type dispositif :                         " + super.getTypeDispositif() + "\n");
    bufferARetourner.append(" - Code Pays :                               " + super.getCodePays() + "\n");
    bufferARetourner.append(" - Type Population 1 :                       " + super.getTypePopulation1() + "\n");
    bufferARetourner.append(" - Sous type Population 1 :                  " + super.getSousTypePopulation1() + "\n");
    bufferARetourner.append(" - Statut Prestation 1 :                     " + super.getStatutPrestation1() + "\n");
    bufferARetourner.append(" - Type Population 2 :                       " + super.getTypePopulation2() + "\n");
    bufferARetourner.append(" - Sous type Population 2 :                  " + super.getSousTypePopulation2() + "\n");
    bufferARetourner.append(" - Statut Prestation 2 :                     " + super.getStatutPrestation2() + "\n");
    bufferARetourner.append(" - Type Population 3 :                       " + super.getTypePopulation3() + "\n");
    bufferARetourner.append(" - Sous type Population 3 :                  " + super.getSousTypePopulation3() + "\n");
    bufferARetourner.append(" - Statut Prestation 3 :                     " + super.getStatutPrestation3() + "\n");
    bufferARetourner.append(" - Type Population 4 :                       " + super.getTypePopulation4() + "\n");
    bufferARetourner.append(" - Sous type Population 4 :                  " + super.getSousTypePopulation4() + "\n");
    bufferARetourner.append(" - Statut Prestation 4 :                     " + super.getStatutPrestation4() + "\n");
    bufferARetourner.append(" - Type Population 5 :                       " + super.getTypePopulation5() + "\n");
    bufferARetourner.append(" - Sous type Population 5 :                  " + super.getSousTypePopulation5() + "\n");
    bufferARetourner.append(" - Statut Prestation 5 :                     " + super.getStatutPrestation5() + "\n");
    
    afficherComplementsJustification(bufferARetourner);
    
    afficherGroupesMontant(bufferARetourner);
    return bufferARetourner.toString();
  }
  
  private void afficherComplementsJustification(StringBuffer bufferARetourner)
  {
    bufferARetourner.append(" - Justification en Ouverture / Fermeture\n");
    afficherComplementJustification(super.getComplementDeJustification0(), bufferARetourner);
    afficherComplementJustification(super.getComplementDeJustification1(), bufferARetourner);
    afficherComplementJustification(super.getComplementDeJustification2(), bufferARetourner);
    afficherComplementJustification(super.getComplementDeJustification3(), bufferARetourner);
    afficherComplementJustification(super.getComplementDeJustification4(), bufferARetourner);
    afficherComplementJustification(super.getComplementDeJustification5(), bufferARetourner);
    afficherComplementJustification(super.getComplementDeJustification6(), bufferARetourner);
    afficherComplementJustification(super.getComplementDeJustification7(), bufferARetourner);
    afficherComplementJustification(super.getComplementDeJustification8(), bufferARetourner);
    afficherComplementJustification(super.getComplementDeJustification9(), bufferARetourner);
  }
  
  private void afficherComplementJustification(String complementJustification, StringBuffer bufferARetourner)
  {
    if (complementJustification != null) {
      bufferARetourner.append("    - Justification :                         " + complementJustification + " (" + (String)ConstantesPBJC.LIB_JUSTIFICATION.get(complementJustification) + ")\n");
    }
  }
  
  private void afficherGroupesMontant(StringBuffer buffer)
  {
    afficherGroupeMontant(super.getCodeTypeMontant1(), super.getComplementTypeMontant1(), super.getAssiette1(), super.getBaseDeCalcul1(), super.getTaux1(), super.getResultatCalcul1(), super.getPositionExoneration1(), buffer);
    
    afficherGroupeMontant(super.getCodeTypeMontant2(), super.getComplementTypeMontant2(), super.getAssiette2(), super.getBaseDeCalcul2(), super.getTaux2(), super.getResultatCalcul2(), super.getPositionExoneration2(), buffer);
    
    afficherGroupeMontant(super.getCodeTypeMontant3(), super.getComplementTypeMontant3(), super.getAssiette3(), super.getBaseDeCalcul3(), super.getTaux3(), super.getResultatCalcul3(), super.getPositionExoneration3(), buffer);
    
    afficherGroupeMontant(super.getCodeTypeMontant4(), super.getComplementTypeMontant4(), super.getAssiette4(), super.getBaseDeCalcul4(), super.getTaux4(), super.getResultatCalcul4(), super.getPositionExoneration4(), buffer);
    
    afficherGroupeMontant(super.getCodeTypeMontant5(), super.getComplementTypeMontant5(), super.getAssiette5(), super.getBaseDeCalcul5(), super.getTaux5(), super.getResultatCalcul5(), super.getPositionExoneration5(), buffer);
    
    afficherGroupeMontant(super.getCodeTypeMontant6(), super.getComplementTypeMontant6(), super.getAssiette6(), super.getBaseDeCalcul6(), super.getTaux6(), super.getResultatCalcul6(), super.getPositionExoneration6(), buffer);
    
    afficherGroupeMontant(super.getCodeTypeMontant7(), super.getComplementTypeMontant7(), super.getAssiette7(), super.getBaseDeCalcul7(), super.getTaux7(), super.getResultatCalcul7(), super.getPositionExoneration7(), buffer);
  }
  
  public void afficherGroupeMontant(String codeTypeMontant, int complementTypeMontant, BigDecimal assiette, BigDecimal baseDeCalcul, BigDecimal taux, BigDecimal resultatCalcul, String positionExoneration, StringBuffer buffer)
  {
    if (codeTypeMontant != null)
    {
      buffer.append(" - Groupe du Montant :\n");
      buffer.append("   - Code Type montant :       " + codeTypeMontant + "\n");
      buffer.append("   - Complement Type montant : " + complementTypeMontant + " (" + (String)ConstantesPBJC.LIB_COMPLEMENT_TYPE_MONTANT.get(Integer.valueOf(complementTypeMontant)) + ")\n");
      if (codeTypeMontant.equals("PCRC")) {
        buffer.append("   - Assiette :                " + assiette + "\n");
      } else {
        buffer.append("   - Assiette :                 -\n");
      }
      buffer.append("   - Base du calcul :          " + baseDeCalcul + "\n");
      buffer.append("   - Taux :                    " + taux + "\n");
      buffer.append("   - Resultat :                " + resultatCalcul + "\n");
      if (codeTypeMontant.equals("PCRC")) {
        buffer.append("   - Exoneration :             " + positionExoneration + " (" + (String)ConstantesPBJC.LIB_POSITION_EXONERATION.get(positionExoneration) + ")\n");
      } else {
        buffer.append("   - Exoneration :              -\n");
      }
    }
  }
  
  public void jdoPostLoad()
  {
    super.setDateDebut(super.getDateDebutPbjc());
    super.setDateFin(super.getDateFinPbjc());
  }
  
  public void jdoPreStore() {}
  
  public void jdoPreClear() {}
  
  public void jdoPreDelete() {}
  
  public void marquerGraphePersistant() {}
  
  public String getIdentifiant()
  {
    return DomManager.getIdentifiant(this);
  }
  
  public ObjetMetierSpec copie()
  {
    PbjcNcp copie = new PbjcNcp();
    copieElements(copie);
    return copie;
  }
  
  public void copieElements(ObjetMetierSpec pcopie)
  {
    PbjcNcp copie = (PbjcNcp)pcopie;
    copie.setQualificationPeriode(getQualificationPeriode());
    
    Damj dateDebut = getDateDebutPbjc();
    Damj dateFin = getDateFinPbjc();
    copie.setDateDebutPbjcsTrans(getDateDebut());
    copie.setDateFinPbjcsTrans(getDateFin());
    if (dateDebut != null) {
      copie.setDateDebutPbjc(dateDebut);
    }
    if (dateFin != null) {
      copie.setDateFinPbjc(dateFin);
    }
    copie.setRefOdPjcPremierFaitGenerateur(getRefOdPjcPremierFaitGenerateur());
    copie.setRefOdPjcFaitGenerateurOrigine(getRefOdPjcFaitGenerateurOrigine());
    copie.setIdentifiantReprise(getIdentifiantReprise());
    copie.setRefBaseCalculMontantBrut(getRefBaseCalculMontantBrut());
    copie.setProduit(getProduit());
    copie.setEtatReglementaireOd(getEtatReglementaireOd());
    copie.setEtatAdministratifOd(getEtatAdministratifOd());
    copie.setRangProlongation(getRangProlongation());
    copie.setNaturePBJC(getNaturePBJC());
    copie.setCodeRadiationLendemainPeriode(getCodeRadiationLendemainPeriode());
    copie.setNbJoursImputes(getNbJoursImputes());
    copie.setNbJoursDecalage(getNbJoursDecalage());
    copie.setCumulCourant(getCumulCourant());
    copie.setReliquatDureeMax(getReliquatDureeMax());
    copie.setReliquatDureeReglementaire(getReliquatDureeReglementaire());
    copie.setJustificationCalculMontant(getJustificationCalculMontant());
    copie.setRegimeApplicable(getRegimeApplicable());
    copie.setTypeCarence(getTypeCarence());
    copie.setMontantSalaireRevalorisePlafonne(getMontantSalaireRevalorisePlafonne());
    copie.setMontantSjc(getMontantSjc());
    copie.setCoefficientTempsPartiel(getCoefficientTempsPartiel());
    copie.setMontantRessourceMensuel(getMontantRessourceMensuel());
    copie.setRangActualisationRessources(getRangActualisationRessources());
    copie.setAnneePerceptionRessources(getAnneePerceptionRessources());
    copie.setMoisPerceptionRessources(getMoisPerceptionRessources());
    copie.setCoefAvantageVieillesse(getCoefAvantageVieillesse());
    copie.setMontantCumuleRevaloriseAV(getMontantCumuleRevaloriseAV());
    copie.setIdPlanFormation(getIdPlanFormation());
    copie.setTypeDePlan(getTypeDePlan());
    copie.setIdStageFormation(getIdStageFormation());
    copie.setTypeMesurePourLEmploi(getTypeMesurePourLEmploi());
    copie.setCodeEtatPND(getCodeEtatPND());
    copie.setMontantBaseJustificatifPND(getMontantBaseJustificatifPND());
    copie.setStatutPaiement(getStatutPaiement());
    copie.setMontantPensionInvalidite(getMontantPensionInvalidite());
    copie.setInterrupIndemParPensionInvalidite(getInterrupIndemParPensionInvalidite());
    copie.setPlafonnementFTHR(isPlafonnementFTHR());
    copie.setPriseEnChargeAERC(isPriseEnChargeAERC());
    copie.setCodeMotifNonPaiement(getCodeMotifNonPaiement());
    copie.setDateDebutInterrupRess(getDateDebutInterrupRess());
    copie.setNbMoisActiviteReduite(getNbMoisActiviteReduite());
    copie.setCumulHeureActRed(getCumulHeureActRed());
    copie.setNbMoisPaiementProvis(getNbMoisPaiementProvis());
    copie.setAleIndividu(getAleIndividu());
    copie.setTxSanction(getTxSanction());
    copie.setComplementDeJustification0(getComplementDeJustification0());
    copie.setComplementDeJustification1(getComplementDeJustification1());
    copie.setComplementDeJustification2(getComplementDeJustification2());
    copie.setComplementDeJustification3(getComplementDeJustification3());
    copie.setComplementDeJustification4(getComplementDeJustification4());
    copie.setComplementDeJustification5(getComplementDeJustification5());
    copie.setComplementDeJustification6(getComplementDeJustification6());
    copie.setComplementDeJustification7(getComplementDeJustification7());
    copie.setComplementDeJustification8(getComplementDeJustification8());
    copie.setComplementDeJustification9(getComplementDeJustification9());
    copie.setCodeTypeMontant1(getCodeTypeMontant1());
    copie.setComplementTypeMontant1(getComplementTypeMontant1());
    copie.setAssiette1(getAssiette1());
    copie.setBaseDeCalcul1(getBaseDeCalcul1());
    copie.setTaux1(getTaux1());
    copie.setResultatCalcul1(getResultatCalcul1());
    copie.setPositionExoneration1(getPositionExoneration1());
    copie.setCodeTypeMontant2(getCodeTypeMontant2());
    copie.setComplementTypeMontant2(getComplementTypeMontant2());
    copie.setAssiette2(getAssiette2());
    copie.setBaseDeCalcul2(getBaseDeCalcul2());
    copie.setTaux2(getTaux2());
    copie.setResultatCalcul2(getResultatCalcul2());
    copie.setPositionExoneration2(getPositionExoneration2());
    copie.setCodeTypeMontant3(getCodeTypeMontant3());
    copie.setComplementTypeMontant3(getComplementTypeMontant3());
    copie.setAssiette3(getAssiette3());
    copie.setBaseDeCalcul3(getBaseDeCalcul3());
    copie.setTaux3(getTaux3());
    copie.setResultatCalcul3(getResultatCalcul3());
    copie.setPositionExoneration3(getPositionExoneration3());
    copie.setCodeTypeMontant4(getCodeTypeMontant4());
    copie.setComplementTypeMontant4(getComplementTypeMontant4());
    copie.setAssiette4(getAssiette4());
    copie.setBaseDeCalcul4(getBaseDeCalcul4());
    copie.setTaux4(getTaux4());
    copie.setResultatCalcul4(getResultatCalcul4());
    copie.setPositionExoneration4(getPositionExoneration4());
    copie.setCodeTypeMontant5(getCodeTypeMontant5());
    copie.setComplementTypeMontant5(getComplementTypeMontant5());
    copie.setAssiette5(getAssiette5());
    copie.setBaseDeCalcul5(getBaseDeCalcul5());
    copie.setTaux5(getTaux5());
    copie.setResultatCalcul5(getResultatCalcul5());
    copie.setPositionExoneration5(getPositionExoneration5());
    copie.setCodeTypeMontant6(getCodeTypeMontant6());
    copie.setComplementTypeMontant6(getComplementTypeMontant6());
    copie.setAssiette6(getAssiette6());
    copie.setBaseDeCalcul6(getBaseDeCalcul6());
    copie.setTaux6(getTaux6());
    copie.setResultatCalcul6(getResultatCalcul6());
    copie.setPositionExoneration6(getPositionExoneration6());
    copie.setCodeTypeMontant7(getCodeTypeMontant7());
    copie.setComplementTypeMontant7(getComplementTypeMontant7());
    copie.setAssiette7(getAssiette7());
    copie.setBaseDeCalcul7(getBaseDeCalcul7());
    copie.setTaux7(getTaux7());
    copie.setResultatCalcul7(getResultatCalcul7());
    copie.setPositionExoneration7(getPositionExoneration7());
    copie.setEtatIndemnisation(getEtatIndemnisation());
    copie.setTxSanction(getTxSanction());
    copie.setTopApplicationCRC(isTopApplicationCRC());
    copie.setTopPlafonnementDureeDroitParDate(isTopPlafonnementDureeDroitParDate());
    copie.setNbJoursAREF(getNbJoursAREF());
    copie.setCategorie(getCategorie());
    copie.setSituationParticuliere(getSituationParticuliere());
    copie.setTypeDispositif(getTypeDispositif());
    copie.setCodePays(getCodePays());
    copie.setTypePopulation1(getTypePopulation1());
    copie.setSousTypePopulation1(getSousTypePopulation1());
    copie.setStatutPrestation1(getStatutPrestation1());
    copie.setTypePopulation2(getTypePopulation2());
    copie.setSousTypePopulation2(getSousTypePopulation2());
    copie.setStatutPrestation2(getStatutPrestation2());
    copie.setTypePopulation3(getTypePopulation3());
    copie.setSousTypePopulation3(getSousTypePopulation3());
    copie.setStatutPrestation3(getStatutPrestation3());
    copie.setTypePopulation4(getTypePopulation4());
    copie.setSousTypePopulation4(getSousTypePopulation4());
    copie.setStatutPrestation4(getStatutPrestation4());
    copie.setTypePopulation5(getTypePopulation5());
    copie.setSousTypePopulation5(getSousTypePopulation5());
    copie.setStatutPrestation5(getStatutPrestation5());
    copie.setPresencePnds(isPresencePnds());
    copie.setMontantContMensuelEmploiRepris(getMontantContMensuelEmploiRepris());
    copie.setExcedentsRemunerationMois(getExcedentsRemunerationMois());
    copie.setReliquatAllongementAREF(getReliquatAllongementAREF());
    copie.setCumulAllongementPlan(getCumulAllongementPlan());
    copie.setNbJoursAllongementAREF(getNbJoursAllongementAREF());
    if (getTspElementPourEcartsBases() != null)
    {
      copie.setTspElementPourEcartsBases(getTspElementPourEcartsBases());
    }
    else
    {
      Date dateTimestampAvant = (Date)LiDOHelper.getSyntheticValue(getPC(), "{version}");
      if (dateTimestampAvant != null) {
        copie.setTspElementPourEcartsBases(dateTimestampAvant);
      }
    }
  }
  
  public boolean estEnAref()
  {
    return super.getComplementTypeMontant1() == 1;
  }
  
  public void setNbMoisActiviteReduite(int nbMoisActiviteReduite)
  {
    int nbMoisAInserer = nbMoisActiviteReduite;
    if (nbMoisAInserer > 99) {
      nbMoisAInserer = 99;
    }
    super.setNbMoisActiviteReduite(nbMoisAInserer);
  }
  
  public void setCumulHeureActRed(int nbHeureActiviteReduite)
  {
    int nbHeureAInserer = nbHeureActiviteReduite;
    if (nbHeureAInserer > 9999) {
      nbHeureAInserer = 9999;
    }
    super.setCumulHeureActRed(nbHeureAInserer);
  }
  
  public boolean estPeriodeRessourcesSuperieuresPlafond()
  {
    return periodeRessourcesSuperieuresPlafond;
  }
  
  public void setPeriodeRessourcesSuperieuresPlafond(boolean pperiodeRessourcesSuperieuresPlafond)
  {
    periodeRessourcesSuperieuresPlafond = pperiodeRessourcesSuperieuresPlafond;
  }
  
  public void ajouterTypeSousTypePopulation(String type, String sousType)
  {
    if (!contientTypeSousTypePopulation(type, sousType)) {
      if (super.getTypePopulation1() == null)
      {
        super.setTypePopulation1(type);
        super.setSousTypePopulation1(sousType);
      }
      else if (super.getTypePopulation2() == null)
      {
        super.setTypePopulation2(type);
        super.setSousTypePopulation2(sousType);
      }
      else if (super.getTypePopulation3() == null)
      {
        super.setTypePopulation3(type);
        super.setSousTypePopulation3(sousType);
      }
      else if (super.getTypePopulation4() == null)
      {
        super.setTypePopulation4(type);
        super.setSousTypePopulation4(sousType);
      }
      else if (super.getTypePopulation5() == null)
      {
        super.setTypePopulation5(type);
        super.setSousTypePopulation5(sousType);
      }
    }
  }
  
  public boolean contientTypeSousTypePopulation(String type, String sousType)
  {
    if ((type != null) && (sousType != null))
    {
      if ((type.equals(super.getTypePopulation1())) && (sousType.equals(super.getSousTypePopulation1()))) {
        return true;
      }
      if ((type.equals(super.getTypePopulation2())) && (sousType.equals(super.getSousTypePopulation2()))) {
        return true;
      }
      if ((type.equals(super.getTypePopulation3())) && (sousType.equals(super.getSousTypePopulation3()))) {
        return true;
      }
      if ((type.equals(super.getTypePopulation4())) && (sousType.equals(super.getSousTypePopulation4()))) {
        return true;
      }
      if ((type.equals(super.getTypePopulation5())) && (sousType.equals(super.getSousTypePopulation5()))) {
        return true;
      }
    }
    else if (type != null)
    {
      if ((type.equals(super.getTypePopulation1())) && (super.getSousTypePopulation1() == null)) {
        return true;
      }
      if ((type.equals(super.getTypePopulation2())) && (super.getSousTypePopulation2() == null)) {
        return true;
      }
      if ((type.equals(super.getTypePopulation3())) && (super.getSousTypePopulation3() == null)) {
        return true;
      }
      if ((type.equals(super.getTypePopulation4())) && (super.getSousTypePopulation4() == null)) {
        return true;
      }
      if ((type.equals(super.getTypePopulation5())) && (super.getSousTypePopulation5() == null)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean contientGroupeDuMontant(String produit)
  {
    if (produit.equals(getCodeTypeMontant1())) {
      return true;
    }
    if (produit.equals(getCodeTypeMontant2())) {
      return true;
    }
    if (produit.equals(getCodeTypeMontant3())) {
      return true;
    }
    if (produit.equals(getCodeTypeMontant4())) {
      return true;
    }
    if (produit.equals(getCodeTypeMontant5())) {
      return true;
    }
    if (produit.equals(getCodeTypeMontant6())) {
      return true;
    }
    if (produit.equals(getCodeTypeMontant7())) {
      return true;
    }
    return false;
  }
  
  public Collection getListeMethodesAExclurePourComparaison()
  {
    Collection listeMethodesAExclure = new ArrayList();
    listeMethodesAExclure.add("getEvenementDebut");
    listeMethodesAExclure.add("getEvenemetFin");
    listeMethodesAExclure.add("estType");
    listeMethodesAExclure.add("estStrictementType");
    listeMethodesAExclure.add("getEtatIndemnisation");
    listeMethodesAExclure.add("getQualificationPeriode");
    listeMethodesAExclure.add("getEtatIndemnisation");
    listeMethodesAExclure.add("getIdentifiantReprise");
    return listeMethodesAExclure;
  }
  
  public Map recupererParametresEcartsBases()
  {
    Map parametresEcartsBases = new HashMap();
    parametresEcartsBases.put("attributType", "PBJC");
    parametresEcartsBases.put("cleTechnique", getIdentifiant());
    String cleFonctionnelle = getDateDebut().formater() + " -- " + getDateFin().formater();
    parametresEcartsBases.put("cleFonctionnelle", cleFonctionnelle);
    parametresEcartsBases.put("timestampAvant", getTspElementPourEcartsBases());
    return parametresEcartsBases;
  }
  
  public boolean estComparableAvec(ElementBasePivotEchangeComparableSpec pelementAComparer)
  {
    PbjcNcp elementAComparer = (PbjcNcp)pelementAComparer;
    return (getDateDebut().coincideAvec(elementAComparer.getDateDebut())) && (getDateFin().coincideAvec(elementAComparer.getDateFin()));
  }
  
  public Collection comparer(ElementBasePivotEchangeComparableSpec pelementAComparer)
    throws CoucheLogiqueException
  {
    Collection listeEcartsBases = OutilComparaison.comparer(this, pelementAComparer);
    return listeEcartsBases;
  }
  
  public Date getTspElementPourEcartsBases()
  {
    return tspElementPourEcartsBase;
  }
  
  public void setTspElementPourEcartsBases(Date ptspElementPourEcartBase)
  {
    tspElementPourEcartsBase = ptspElementPourEcartBase;
  }
}

/* Location:
 * Qualified Name:     PbjcNcp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
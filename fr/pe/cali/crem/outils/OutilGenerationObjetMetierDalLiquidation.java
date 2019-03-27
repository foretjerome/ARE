package fr.pe.cali.crem.outils;

import fr.pe.cali.crem.dom.MetaDonneeCrem;
import fr.pe.cali.crem.dom.ObjetMetierCrem;
import fr.pe.cali.crem.dom.impl.DonneesFonctionnellesDalLiquidation;
import fr.unedic.cali.autresdoms.d12i.dom.DonneesNPDE;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesSortieNPDESpec;
import fr.unedic.cali.dom.affectation.GammeAsu;
import fr.unedic.util.services.ContexteService;
import java.sql.Timestamp;
import java.util.List;

public class OutilGenerationObjetMetierDalLiquidation
  extends OutilGenerationObjetMetier
{
  private static OutilGenerationObjetMetierDalLiquidation instance;
  
  public static synchronized OutilGenerationObjetMetierDalLiquidation getInstance()
  {
    if (instance == null) {
      instance = new OutilGenerationObjetMetierDalLiquidation();
    }
    return instance;
  }
  
  protected boolean verifierDemandeEligible(DemandeSpec demande)
  {
    boolean demandeEligible = false;
    
    boolean estDemandeAssurance = demande.getGamme() instanceof GammeAsu;
    if (estDemandeAssurance)
    {
      boolean estDemandeNPDE = demande.isDemandeNPDE();
      boolean estDemandeWebKO = false;
      if (demande.getDonneesNPDE() != null) {
        estDemandeWebKO = demande.getDonneesNPDE().isDemandeWebKO();
      }
      demandeEligible = (estDemandeNPDE) || (estDemandeWebKO);
    }
    return demandeEligible;
  }
  
  protected boolean estEligibleSuppression(DemandeSpec demande)
  {
    return false;
  }
  
  protected void alimenterDonneesDemandePourCREMSpecifiques(ObjetMetierCrem objetMetier, DemandeSpec demande)
  {
    objetMetier.setIdentifiant(demande.getIdentifiantObjetMetier());
    objetMetier.setType("DAL_Liquidation");
    objetMetier.setCodeEvenementMetier("liquidation");
  }
  
  protected void alimenterMetaDonneesSpecifiques(ObjetMetierCrem objetMetier, DemandeSpec demande)
  {
    objetMetier.setCinquiemeMetaDonnee(new MetaDonneeCrem("ID_DAL", demande.getDonneesNPDE().getIdentifiantDemandeInstruction()));
  }
  
  protected void alimenterDonneesFonctionnelles(ObjetMetierCrem objetMetier, ContexteService contexteService, DemandeSpec demande)
  {
    DonneesFonctionnellesDalLiquidation donnees = new DonneesFonctionnellesDalLiquidation();
    
    donnees.setCodePE(contexteService.getAssedicAllocataire());
    donnees.setRsin(contexteService.getRsin());
    donnees.setCxala(String.valueOf(contexteService.getCxala()));
    donnees.setIdentifiantObjetMetierCali(demande.getIdentifiantObjetMetier());
    donnees.setIdentifiantObjetMetierPere(demande.getDonneesNPDE().getIdentifiantDemandeInstruction());
    donnees.setHorodatage(objetMetier.getDateCreation().toString());
    donnees.setCodeAntenneDE(contexteService.getCodeAntenne());
    donnees.setTopDalWebKO(formaterBoolean(demande.getDonneesNPDE().isDemandeWebKO()));
    donnees.setTopDecisionAuto(formaterBoolean(demande.isDecisionAuto()));
    if (estModeTP(contexteService)) {
      donnees.setCodeAgent(contexteService.getSrcCodeAgent());
    }
    if (demande.estDecisionnee())
    {
      DecisionSpec decision = (DecisionSpec)demande.getListeDossiersExamen().get(0);
      donnees.setMotifDecision(String.valueOf(decision.getNatureDecision()));
      donnees.setTopBlocage(formaterBoolean(false));
    }
    else
    {
      gererClassementSansSuite(donnees, demande);
      gererBlocageEtIneligibilite(donnees, demande);
      gererClassementSecteurPublic(donnees, demande);
    }
    objetMetier.setDonneesFonctionnelles(donnees);
  }
  
  private String formaterBoolean(boolean valeur)
  {
    String texteBoolean = "FALSE";
    if (valeur) {
      texteBoolean = "TRUE";
    }
    return texteBoolean;
  }
  
  private void gererClassementSansSuite(DonneesFonctionnellesDalLiquidation donneesFonctionnelles, DemandeSpec demande)
  {
    if ((demande.getClassementAdministratif() != null) && ("SS".equals(demande.getClassementAdministratif().getTypeClassement()))) {
      donneesFonctionnelles.setTopClassementSansSuite(formaterBoolean(true));
    }
  }
  
  private void gererClassementSecteurPublic(DonneesFonctionnellesDalLiquidation donneesFonctionnelles, DemandeSpec demande)
  {
    if ((demande.getClassementAdministratif() != null) && ("SP".equals(demande.getClassementAdministratif().getTypeClassement())))
    {
      donneesFonctionnelles.setMotifDecision(String.valueOf(10));
      donneesFonctionnelles.setTopBlocage(formaterBoolean(false));
    }
  }
  
  private void gererBlocageEtIneligibilite(DonneesFonctionnellesDalLiquidation donneesFonctionnelles, DemandeSpec demande)
  {
    if (demande.getCodeAttente() != null)
    {
      donneesFonctionnelles.setMotifIneligibilite(demande.getCodeAttente());
      donneesFonctionnelles.setTopBlocage(formaterBoolean(true));
    }
    else
    {
      donneesFonctionnelles.setTopBlocage(formaterBoolean(demande.getDonneesSortieNPDE().getMotifEchecTraitempent() != null));
    }
  }
  
  protected ObjetMetierCrem recupererAncienCremDansCache(String cremId, CacheCrem cacheCrem)
  {
    return cacheCrem.recupererCremDal(cremId);
  }
}

/* Location:
 * Qualified Name:     OutilGenerationObjetMetierDalLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
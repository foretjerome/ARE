package fr.unedic.cali.autresdoms.cohab.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.parcours.DomReceptionFluxAR1E5A;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec;
import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeFor;
import fr.unedic.cali.dom.affectation.GammeRbf;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.dom.affectation.Parametres;
import fr.unedic.cali.parcours.DomCreationFormulaires;
import fr.unedic.cali.parcours.ResultatCreationFormulaires;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.temps.Chronologie;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Iterator;

public class FabriqueFormulairesCali
{
  public static Collection<FormulaireSpec> creerFormulairesNcp(Collection p_listeDemandesCojac, IndividuSpec p_allocataire, ContexteService p_contexteService)
    throws ApplicativeException
  {
    Collection listeNouveauxFormulairesCali = null;
    
    Parcours parcoursFabricationFormulairesCali = null;
    Contexte contexte = null;
    DomCreationFormulaires dom = null;
    
    contexte = new Contexte();
    dom = new DomCreationFormulaires();
    dom.setNumeroAllocataire(p_allocataire.getNumeroAllocataire());
    dom.setIndividu(p_allocataire);
    dom.setCollectionDemandesCojac(p_listeDemandesCojac);
    dom.setContexteService(p_contexteService);
    dom.setActionFormation(null);
    contexte.setDonnees(dom);
    
    Iterator iterDemandesCojac = p_listeDemandesCojac.iterator();
    if (iterDemandesCojac.hasNext())
    {
      DemandeSpec demandeCojac = (DemandeSpec)iterDemandesCojac.next();
      if (Log.isTraceActive(FabriqueFormulairesCali.class, Niveau.INFO))
      {
        StringBuffer sb = new StringBuffer();
        sb.append("Demande cojac lue : ");
        sb.append("date demande : ");
        sb.append(demandeCojac.getDateDemande());
        sb.append("- date dépot : ");
        sb.append(demandeCojac.getDateDepot());
        sb.append("- état liquidable : ");
        sb.append(demandeCojac.getEtatLiquidable());
        sb.append("- gamme : ");
        sb.append(demandeCojac.getGamme());
        sb.append("- ID demande : ");
        sb.append(demandeCojac.getIdentifiantDemande());
        sb.append("- ID formation : ");
        sb.append(demandeCojac.getIdentifiantFormation());
        sb.append("- ID PEC : ");
        sb.append(demandeCojac.getIdentifiantPec());
        sb.append("- ligne : ");
        sb.append(demandeCojac.getLigne());
        sb.append("- présence AE : ");
        sb.append(demandeCojac.getPresenceAE());
        sb.append("- produit : ");
        sb.append(demandeCojac.getProduit());
        sb.append("- Refus FNE : ");
        sb.append(demandeCojac.getRefusFNE());
        sb.append("- Type examen : ");
        sb.append(demandeCojac.getTypeExamen());
        
        Log.ecritTrace(Niveau.INFO, FabriqueFormulairesCali.class, "creerFormulairesNcp", sb.toString());
      }
      String gamme = demandeCojac.getGamme();
      
      parcoursFabricationFormulairesCali = Parametres.getGamme(gamme).getParcoursCreationFormulaire();
      
      ResultatCreationFormulaires resultat = (ResultatCreationFormulaires)parcoursFabricationFormulairesCali.demarrer(contexte);
      listeNouveauxFormulairesCali = resultat.getCollectionFormulairesCali();
    }
    return listeNouveauxFormulairesCali;
  }
  
  public static Collection creerFormulairesNcp(ActionFormation p_actionFormation, IndividuSpec p_allocataire, ContexteService p_contexteService)
    throws ApplicativeException
  {
    Collection listeNouveauxFormulairesCali = null;
    
    Parcours parcoursFabricationFormulairesCali = null;
    Contexte contexte = null;
    DomCreationFormulaires dom = null;
    
    contexte = new Contexte();
    dom = new DomCreationFormulaires();
    dom.setNumeroAllocataire(p_allocataire.getNumeroAllocataire());
    dom.setIndividu(p_allocataire);
    dom.setContexteService(p_contexteService);
    dom.setActionFormation(p_actionFormation);
    dom.setCollectionDemandesCojac(null);
    contexte.setDonnees(dom);
    
    parcoursFabricationFormulairesCali = GammeFor.getInstance().getParcoursCreationFormulaire();
    
    ResultatCreationFormulaires resultat = (ResultatCreationFormulaires)parcoursFabricationFormulairesCali.demarrer(contexte);
    listeNouveauxFormulairesCali = resultat.getCollectionFormulairesCali();
    
    return listeNouveauxFormulairesCali;
  }
  
  public static Collection creerFormulairesDAF(DomReceptionFluxAR1E5A p_dom, String p_numAllocataire)
    throws ApplicativeException
  {
    Collection listeNouveauxFormulairesCali = null;
    
    String idActionFormation = p_dom.getIdActionFormation();
    ActionFormation actionFormation = (ActionFormation)p_dom.getIndividu().rechercherPeriodePasseProfessionnel(idActionFormation);
    
    Parcours parcoursFabricationFormulairesCali = null;
    Contexte contexte = null;
    DomCreationFormulaires dom = null;
    ContexteService contexteService = p_dom.getContexteService();
    BigDecimal montantACharge = p_dom.getMontantACharge();
    BigDecimal montantGlobal = p_dom.getMontantGlobal();
    Chronologie chronoPeriodesLieux = p_dom.getChronologiePeriodesLieux();
    
    contexte = new Contexte();
    dom = new DomCreationFormulaires();
    dom.setContexteService(contexteService);
    dom.setIdActionFormation(idActionFormation);
    dom.setMontantGlobal(montantGlobal);
    dom.setMontantACharge(montantACharge);
    dom.setChronoPeriodesLieux(chronoPeriodesLieux);
    dom.setCollectionDemandesCojac(null);
    dom.setNumeroAllocataire(p_numAllocataire);
    dom.setActionFormation(actionFormation);
    contexte.setDonnees(dom);
    
    parcoursFabricationFormulairesCali = GammeRbf.getInstance().getParcoursCreationFormulaire();
    
    ResultatCreationFormulaires resultat = (ResultatCreationFormulaires)parcoursFabricationFormulairesCali.demarrer(contexte);
    listeNouveauxFormulairesCali = resultat.getCollectionFormulairesCali();
    
    return listeNouveauxFormulairesCali;
  }
}

/* Location:
 * Qualified Name:     FabriqueFormulairesCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
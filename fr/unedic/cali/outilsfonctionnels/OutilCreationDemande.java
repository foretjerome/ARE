package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.Demande;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormulaireAbstrait;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.GammeAbstrait;
import fr.unedic.cali.dom.affectation.GammeInr;
import fr.unedic.cali.dom.affectation.GammeSpec;
import fr.unedic.cali.fabriques.FabriqueGammes;
import fr.unedic.cali.fabriques.FabriqueIdentifiantDemandeCojac;
import fr.unedic.cali.parcours.DomCreationDemandePrestation;
import fr.unedic.cali.parcours.DomCreationFormulaires;
import fr.unedic.cali.parcours.ParcoursCali;
import fr.unedic.cali.parcours.ResultatCreationDemandePrestation;
import fr.unedic.cali.parcours.ResultatCreationFormulaires;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public final class OutilCreationDemande
  implements OutilFonctionnel
{
  public static DemandeSpec creerDemande(String typeDemande, Damj dateDeDepot, IndividuSpec individu, int idPec, ContexteService contexteService)
    throws ApplicativeException
  {
    Contexte contexte = new Contexte();
    
    GammeSpec gamme = FabriqueGammes.getInstance().getGamme(typeDemande);
    if (gamme == null) {
      gamme = alimenterGammePourDemandeV2Bouchonnees(typeDemande);
    }
    Demande demandeCojac = new Demande();
    demandeCojac.setDateDepot(dateDeDepot);
    demandeCojac.setIdentifiantDemande(FabriqueIdentifiantDemandeCojac.getInstance().getIdentifiantDemandeCojac(individu, typeDemande));
    demandeCojac.setTypeExamen(ConstructionCSOIA.getCSOIADepuisTypeExamen(typeDemande));
    
    String gammeRecupere = ConstructionCSOIA.getGammeDepuisTypeExamen(typeDemande);
    demandeCojac.setGamme(gammeRecupere);
    if (idPec != 0) {
      demandeCojac.setIdentifiantPec(idPec);
    }
    alimenterDemandeCojacPourDemandeV2Bouchonnees(demandeCojac, typeDemande, individu);
    
    DomCreationFormulaires domCreationFormulaire = new DomCreationFormulaires();
    domCreationFormulaire.setIndividu(individu);
    
    Collection collectionDemandesCojac = new ArrayList();
    collectionDemandesCojac.add(demandeCojac);
    
    domCreationFormulaire.setCollectionDemandesCojac(collectionDemandesCojac);
    
    contexte.setDonnees(domCreationFormulaire);
    
    Parcours parcoursFabricationFormulairesCali = gamme.getParcoursCreationFormulaire();
    ResultatCreationFormulaires resultatCreationFormulaire = (ResultatCreationFormulaires)parcoursFabricationFormulairesCali.demarrer(contexte);
    Collection listeNouveauxFormulairesNcp = resultatCreationFormulaire.getCollectionFormulairesCali();
    
    FormulaireAbstrait formulaire = (FormulaireAbstrait)listeNouveauxFormulairesNcp.iterator().next();
    
    DomCreationDemandePrestation domCreationDemande = new DomCreationDemandePrestation();
    domCreationDemande.setFormulaire(formulaire);
    domCreationDemande.setIndividu(individu);
    domCreationDemande.setContexteService(contexteService);
    contexte.setDonnees(domCreationDemande);
    
    ParcoursCali parcoursCreationDemande = formulaire.getGamme().getParcoursCreationDemande();
    ResultatCreationDemandePrestation resultatCreationDemandePrestation = (ResultatCreationDemandePrestation)parcoursCreationDemande.effectuerParcours(contexte);
    
    return resultatCreationDemandePrestation.getDemande();
  }
  
  private static void alimenterDemandeCojacPourDemandeV2Bouchonnees(Demande demandeCojac, String typeDemande, IndividuSpec individu)
  {
    TracesBouchon.ecrireTrace("A la fin de la version cette méthode doit être vide");
  }
  
  private static GammeSpec alimenterGammePourDemandeV2Bouchonnees(String typeDemande)
  {
    TracesBouchon.ecrireTrace("A la fin de la version cette méthode doit être vide");
    GammeAbstrait gamme = null;
    if (typeDemande.equals("INR_04")) {
      gamme = GammeInr.getInstance();
    }
    return gamme;
  }
}

/* Location:
 * Qualified Name:     OutilCreationDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
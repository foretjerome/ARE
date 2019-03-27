package fr.unedic.cali.migration;

import fr.unedic.cali.autresdoms.cohab.dom.DemandeMigreeEnErreur;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.Erreur;
import fr.unedic.cali.dom.NaturesDecisions;
import fr.unedic.cohabitation.sigma.migration.dom.ConstantesMigration;
import fr.unedic.cohabitation.sigma.migration.dom.DecisionMigreeV1;
import fr.unedic.cohabitation.sigma.migration.dom.DemandeMigreeV1;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public abstract class GrapheLiquidation
  implements GrapheLiquidationSpec
{
  protected Collection m_listeErreurs = new ArrayList();
  
  protected Collection getListeErreurs()
  {
    return m_listeErreurs;
  }
  
  public DemandeSpec migrerDemande(DemandeMigreeV1 p_demandeV1, DemandeMigreeEnErreur p_demandeMigreeEnErreur)
  {
    DemandeSpec demande = null;
    
    genererTitreDemande(p_demandeMigreeEnErreur, p_demandeV1);
    
    Collection listeMappeur = getListMappeur();
    Iterator itM = listeMappeur.iterator();
    while (itM.hasNext())
    {
      MapperDonneesSpec mappeurAEffectuer = (MapperDonneesSpec)itM.next();
      
      mappeurAEffectuer.mapper(p_demandeV1);
    }
    demande = construireGraphe(p_demandeV1);
    if (!getListeErreurs().isEmpty())
    {
      p_demandeMigreeEnErreur.getListeErreurs().addAll(getListeErreurs());
      return demande;
    }
    alimenterDonnees(p_demandeV1, demande);
    
    Collection listeControles = getListControle();
    Iterator itC = listeControles.iterator();
    
    Collection listeErreurs = new ArrayList();
    while (itC.hasNext())
    {
      ControlerDonneesSpec controleAEffectuer = (ControlerDonneesSpec)itC.next();
      
      listeErreurs = controleAEffectuer.controler(demande);
      
      p_demandeMigreeEnErreur.getListeErreurs().addAll(listeErreurs);
    }
    p_demandeMigreeEnErreur.getListeErreurs().addAll(getListeErreurs());
    
    return demande;
  }
  
  public void enregistrerDemande(DemandeMigreeV1 p_demandeV1, DemandeSpec p_demande, DemandeMigreeEnErreur p_demandeMigreeEnErreur)
  {
    alimenterDonneesForcage(p_demandeV1, p_demande);
    
    Collection listeRecalcule = getListRecalcule();
    Iterator itRecalcule = listeRecalcule.iterator();
    
    Collection listeErreurs = new ArrayList();
    while (itRecalcule.hasNext())
    {
      RecalculerDonneesSpec recalculAEffectuer = (RecalculerDonneesSpec)itRecalcule.next();
      
      listeErreurs = recalculAEffectuer.recalculer(p_demande);
      
      p_demandeMigreeEnErreur.getListeErreurs().addAll(listeErreurs);
    }
    p_demandeMigreeEnErreur.getListeErreurs().addAll(listeErreurs);
    
    Collection listeControles = getListControle();
    Iterator it = listeControles.iterator();
    
    listeErreurs = null;
    while (it.hasNext())
    {
      ControlerDonneesSpec controleAEffectuer = (ControlerDonneesSpec)it.next();
      
      listeErreurs = controleAEffectuer.controler(p_demande);
      
      p_demandeMigreeEnErreur.getListeErreurs().addAll(listeErreurs);
    }
    p_demandeMigreeEnErreur.getListeErreurs().addAll(getListeErreurs());
  }
  
  protected abstract String getTypeDemande();
  
  protected void genererTitreDemande(DemandeMigreeEnErreur p_demandeEnErreur, DemandeMigreeV1 p_demandeTemporaire)
  {
    String reference = p_demandeTemporaire.getReferenceExterne();
    String codeProduit = p_demandeTemporaire.getCodeProduit();
    if (reference != null) {
      p_demandeEnErreur.setReference(reference);
    } else {
      p_demandeEnErreur.setReference("NC");
    }
    p_demandeEnErreur.setCodeProduit(majCodeProduit(codeProduit));
    
    String du = "du ";
    
    ArrayList listDecision = (ArrayList)p_demandeTemporaire.getListeDecisions();
    
    Damj dateAttribution = ((DecisionMigreeV1)listDecision.get(0)).getDateAttribution();
    Damj dateExamen = p_demandeTemporaire.getDateExamen();
    Damj dateDepot = p_demandeTemporaire.getDateDepot();
    
    String titre = getTypeDemande();
    if (dateAttribution != null) {
      titre = titre + du + dateAttribution;
    } else if (dateExamen != null) {
      titre = titre + du + dateExamen;
    } else if (dateDepot != null) {
      titre = titre + du + dateDepot;
    }
    Object libelleNatureDecision = NaturesDecisions.s_libelleObjectifDecision.get(new BigDecimal(((DecisionMigreeV1)listDecision.get(0)).getNatureDecision()));
    if (libelleNatureDecision != null) {
      titre = titre + " : " + (String)libelleNatureDecision;
    }
    String classement = p_demandeTemporaire.getClassementAdministratif();
    if (classement != null) {
      titre = titre + " : Classement " + classement;
    }
    p_demandeEnErreur.setLibelle(titre);
    
    p_demandeEnErreur.ajouterErreur(new Erreur(1, "LIQ_HG_TITRE_DEMANDE", titre));
  }
  
  private String majCodeProduit(String p_codeProduit)
  {
    String codeProduit = null;
    if (p_codeProduit == null)
    {
      codeProduit = "0";
    }
    else
    {
      codeProduit = (String)ConstantesMigration.s_libelleCodeProduit.get(p_codeProduit);
      if (codeProduit == null) {
        codeProduit = "0";
      }
    }
    return codeProduit;
  }
  
  protected void alimenterTopMigree(DemandeMigreeV1 p_demandeV1, DemandeSpec p_demande)
  {
    p_demande.setMigree(1);
  }
  
  protected void alimenterTopNeutralisee(DemandeMigreeV1 p_demandeV1, DemandeSpec p_demande)
  {
    p_demande.setEstNeutraliseeLiquidation(true);
    
    p_demande.setEstDeneutralisable(!p_demandeV1.isEstNeutraliseeCalcul());
  }
  
  public abstract void postTraitementMigrerDemande(DemandeMigreeV1 paramDemandeMigreeV1, DemandeSpec paramDemandeSpec, DemandeMigreeEnErreur paramDemandeMigreeEnErreur)
    throws CoucheLogiqueException;
  
  protected abstract DemandeSpec construireGraphe(DemandeMigreeV1 paramDemandeMigreeV1);
  
  protected abstract void alimenterDonnees(DemandeMigreeV1 paramDemandeMigreeV1, DemandeSpec paramDemandeSpec);
  
  protected abstract void alimenterDonneesForcage(DemandeMigreeV1 paramDemandeMigreeV1, DemandeSpec paramDemandeSpec);
  
  protected abstract Collection getListRecalcule();
  
  protected abstract Collection getListControle();
  
  protected abstract Collection getListMappeur();
}

/* Location:
 * Qualified Name:     GrapheLiquidation
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
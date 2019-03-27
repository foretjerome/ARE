package fr.unedic.cali.dom.affectation;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.DonneesAuDJIMigration;
import fr.unedic.cali.dom.AttributionAssuranceSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.echange.Decision;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresExecutionPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.CriteresTraitementPopulation;
import fr.unedic.cali.occasionnel.outilsfonctionnels.ResultatTraitementPopulation;
import fr.unedic.cali.outilsfonctionnels.IOutilFonctionnelTraitementsErreurs;
import fr.unedic.cali.parcours.DomLiquidationDemande;
import fr.unedic.cali.parcours.ParcoursCali;
import fr.unedic.cali.parcours.ParcoursLiquidation;
import fr.unedic.cali.parcours.ResultatMigrationCalculProduit;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

public abstract class GammeAbstrait
  implements GammeSpec
{
  private static final long serialVersionUID = 1L;
  private List<LigneSpec> listeLignes = new ArrayList();
  private String libelle;
  private String nomUnique;
  
  public List<LigneSpec> getListeLignes()
  {
    return listeLignes;
  }
  
  public List<ProduitSpec> getProduitsActifs(Damj date)
  {
    List<ProduitSpec> produitsActifs = new ArrayList();
    Iterator<LigneSpec> listeLignes;
    if (date != null) {
      for (listeLignes = getListeLignes().iterator(); listeLignes.hasNext();)
      {
        LigneSpec ligne = (LigneSpec)listeLignes.next();
        ProduitSpec produit = ligne.getProduitActif(date);
        if (produit != null) {
          produitsActifs.add(produit);
        }
      }
    }
    return produitsActifs;
  }
  
  public void ajouterLigne(LigneSpec ligne)
  {
    if (ligne != null)
    {
      getListeLignes().add(ligne);
      if (ligne.getGamme() != this) {
        ligne.setGamme(this);
      }
    }
  }
  
  public void setListeLignes(List<LigneSpec> listeLignes)
  {
    if (listeLignes == null) {
      this.listeLignes = null;
    } else {
      for (int i = 0; i < listeLignes.size(); i++) {
        ajouterLigne((LigneSpec)listeLignes.get(i));
      }
    }
  }
  
  public String getLibelle()
  {
    return libelle;
  }
  
  public void setLibelle(String libelle)
  {
    this.libelle = libelle;
  }
  
  public ProduitSpec getProduit(String nom)
  {
    List<LigneSpec> listLignes = getListeLignes();
    for (int i = 0; i < listLignes.size(); i++)
    {
      List<ProduitSpec> listeProduits = ((LigneSpec)listLignes.get(i)).getListeProduits();
      for (int j = 0; j < listeProduits.size(); j++)
      {
        ProduitSpec produit = (ProduitSpec)listeProduits.get(j);
        if (produit.getNom().equalsIgnoreCase(nom)) {
          return produit;
        }
      }
    }
    return null;
  }
  
  public String getNomUnique()
  {
    return nomUnique;
  }
  
  public void setNomUnique(String nomUnique)
  {
    this.nomUnique = nomUnique;
  }
  
  public String toString()
  {
    return getNomUnique();
  }
  
  protected static GammeDelegueSpec creerGammeDelegue(String classeGamme)
  {
    GammeDelegueSpec gammeDelegue = null;
    try
    {
      gammeDelegue = (GammeDelegueSpec)Class.forName(classeGamme).newInstance();
    }
    catch (Exception e) {}
    return gammeDelegue;
  }
  
  public abstract GammeDelegueSpec getGammeDelegue();
  
  public ParcoursLiquidation getParcoursLiquidation(fr.unedic.cali.dom.DemandeSpec demande)
  {
    return getGammeDelegue().getParcoursLiquidation(demande);
  }
  
  public DomLiquidationDemande creerDomLiquidationDemande()
  {
    return getGammeDelegue().creerDomLiquidationDemande();
  }
  
  public ParcoursCali getParcoursCreationDemande()
  {
    return getGammeDelegue().getParcoursCreationDemande();
  }
  
  public Parcours getParcoursCreationFormulaire()
  {
    return getGammeDelegue().getParcoursCreationFormulaire();
  }
  
  public void enregistrerBasePivot(fr.unedic.cali.dom.DemandeSpec demande)
    throws ApplicativeException
  {
    getGammeDelegue().enregistrerBasePivot(demande);
  }
  
  public void enregistrerBasePivotAides(fr.unedic.cali.dom.DemandeSpec demande)
    throws ApplicativeException
  {
    getGammeDelegue().enregistrerBasePivotAides(demande);
  }
  
  public void alimenterBaseEchanges(fr.unedic.cali.dom.DemandeSpec demande, Decision decision)
    throws ApplicativeException
  {
    if (getGammeDelegue() != null) {
      getGammeDelegue().alimenterBaseEchanges(demande, decision);
    }
  }
  
  public Hashtable<String, String> recupererDonneesImposees(fr.unedic.cali.dom.DemandeSpec demande)
    throws CoucheLogiqueException
  {
    if (getGammeDelegue() != null) {
      return getGammeDelegue().recupererDonneesImposees(demande);
    }
    return null;
  }
  
  public Hashtable<String, String> getElementsDonneesImposeesVides()
    throws CoucheLogiqueException
  {
    if (getGammeDelegue() != null) {
      return getGammeDelegue().getElementsDonneesImposeesVides();
    }
    return null;
  }
  
  public Hashtable<String, String> getElementsConstituantVides()
    throws CoucheLogiqueException
  {
    if (getGammeDelegue() != null) {
      return getGammeDelegue().getElementsConstituantVides();
    }
    return null;
  }
  
  public Hashtable<String, String> recupererElementsDecision(fr.unedic.cali.dom.DemandeSpec demande)
    throws CoucheLogiqueException
  {
    if (getGammeDelegue() != null) {
      return getGammeDelegue().recupererElementsDecision(demande);
    }
    return null;
  }
  
  public Hashtable<String, String> getElementsDecisionVides()
    throws CoucheLogiqueException
  {
    if (getGammeDelegue() != null) {
      return getGammeDelegue().getElementsDecisionVides();
    }
    return null;
  }
  
  public FormulaireSpec creerFormulaire(fr.unedic.cali.autresdoms.cohab.sigma.demande.dom.spec.DemandeSpec demande)
  {
    return getGammeDelegue().creerFormulaire(demande);
  }
  
  public void stockerIdDecorSurDemande(fr.unedic.cali.dom.DemandeSpec demande, String idDecor)
  {
    getGammeDelegue().stockerIdDecorSurDemande(demande, idDecor);
  }
  
  public boolean contientAlerteNonBloquanteProvoquantRemiseEnCause(fr.unedic.cali.dom.DemandeSpec demande)
  {
    return getGammeDelegue().contientAlerteNonBloquanteProvoquantRemiseEnCause(demande);
  }
  
  public void alimenterDomResultatMigrationCalcul(ResultatMigrationCalculProduit resultatMigration, DonneesAuDJIMigration donneeAuDJI)
  {
    getGammeDelegue().alimenterDomResultatMigrationCalcul(resultatMigration, donneeAuDJI);
  }
  
  public boolean estDecisionRenoncement(fr.unedic.cali.dom.DemandeSpec demande)
  {
    return getGammeDelegue().estDecisionRenoncement(demande);
  }
  
  public void setTopRenoncementDecision(fr.unedic.cali.dom.DemandeSpec demande, boolean top)
  {
    getGammeDelegue().setTopRenoncementDecision(demande, top);
  }
  
  public void verifierPossibiliteAnnulerReexamen(fr.unedic.cali.dom.DemandeSpec demande)
    throws CoucheLogiqueException
  {
    getGammeDelegue().verifierPossibiliteAnnulerReexamen(demande);
  }
  
  public ArrayList getParametres()
  {
    return getGammeDelegue().getParametres();
  }
  
  public boolean estReexecutable(CriteresExecutionPopulation criteres)
  {
    return getGammeDelegue().estReexecutable(criteres);
  }
  
  public void controlerInvestigationFrauduleuse(DomLiquidationDemande dom)
  {
    getGammeDelegue().controlerInvestigationFrauduleuse(dom);
  }
  
  public void recalculerSurAnnulerReexamen(fr.unedic.cali.dom.DemandeSpec demande)
    throws CoucheLogiqueException
  {
    getGammeDelegue().recalculerSurAnnulerReexamen(demande);
  }
  
  public ResultatTraitementPopulation effectuerTraitementOccasionnel(CriteresTraitementPopulation criteres)
    throws ApplicativeException
  {
    return getGammeDelegue().effectuerTraitementOccasionnel(criteres);
  }
  
  public Class getClassGestionnaireErreur()
  {
    Class classeGestionnaire = null;
    GammeDelegueSpec gammeDelegue = getGammeDelegue();
    if (gammeDelegue != null) {
      classeGestionnaire = gammeDelegue.getClassGestionnaireErreur();
    }
    return classeGestionnaire;
  }
  
  public void traiterMiseEnReexamen(fr.unedic.cali.dom.DemandeSpec demande, List listeElementsComparaison)
  {
    getGammeDelegue().traiterMiseEnReexamen(demande, listeElementsComparaison);
  }
  
  public void controlerPresenceDemandeRevision(fr.unedic.cali.dom.DemandeSpec demandePrestationsCourante, AttributionAssuranceSpec attributionAssurancePrecedente)
    throws CoucheLogiqueException
  {
    getGammeDelegue().controlerPresenceDemandeRevision(demandePrestationsCourante, attributionAssurancePrecedente);
  }
  
  public void controlerPresenceDemandeRevisionPostLiquidation(fr.unedic.cali.dom.DemandeSpec demandePrestationsCourante, AttributionAssuranceSpec attributionAssurancePrecedente)
    throws CoucheLogiqueException
  {
    getGammeDelegue().controlerPresenceDemandeRevisionPostLiquidation(demandePrestationsCourante, attributionAssurancePrecedente);
  }
  
  public IOutilFonctionnelTraitementsErreurs getOutilFonctionnelTraitementErreurLiquidationAutomatique()
  {
    return getGammeDelegue().getOutilFonctionnelTraitementErreurLiquidationAutomatique();
  }
  
  public boolean controlerPrescription(FormulaireSpec formulaire)
  {
    return false;
  }
  
  public void traitementPostValidation(fr.unedic.cali.dom.DemandeSpec demande)
    throws ApplicativeException
  {
    getGammeDelegue().traitementPostValidation(demande);
  }
}

/* Location:
 * Qualified Name:     GammeAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ClassementAdministratif;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandeAspFinDroit;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandeAsrFinDeDroit;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreDemandeAtpFinDroit;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourClassement;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourERE;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandesPrecedentesSurDemandes;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreOuvertureDroitSurDecision;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.FiltreTemporel;
import fr.unedic.util.temps.FiltresTemporel;
import java.util.List;

public class OutilDroitAvecFinDroit
{
  public static boolean estUnProduitNecessitantFinDroit(ProduitSpec p_produit)
  {
    return (estUnProduitAsr(p_produit)) || (estUnProduitAtp(p_produit)) || (estUnProduitAsp(p_produit));
  }
  
  public static FiltreTemporel trouverFiltreFinDroitPourProduit(ProduitSpec p_produit)
  {
    if (estUnProduitAsr(p_produit)) {
      return new FiltreDemandeAsrFinDeDroit();
    }
    if (estUnProduitAtp(p_produit)) {
      return new FiltreDemandeAtpFinDroit();
    }
    if (estUnProduitAsp(p_produit)) {
      return new FiltreDemandeAspFinDroit();
    }
    return null;
  }
  
  public static String trouverTypeExamenPourProduit(ProduitSpec p_produit)
  {
    if (estUnProduitAsr(p_produit)) {
      return "ASU_16";
    }
    if (estUnProduitAtp(p_produit)) {
      return "ASU_18";
    }
    if (estUnProduitAsp(p_produit)) {
      return "ASU_24";
    }
    return null;
  }
  
  public static DemandeSpec rechercherDemandeFinDroitSuivantDemandeNecessitantFinDroit(DemandeSpec p_demandeDroit, DemandeSpec p_demandeFinDroitAExclure)
  {
    DemandeSpec demandeRetour = null;
    if ((p_demandeDroit != null) && (p_demandeDroit.getDossierAffectation() != null) && (estUnProduitNecessitantFinDroit(p_demandeDroit.getDossierAffectation().getProduit())))
    {
      Chronologie chronologieDemandes = p_demandeDroit.getDemandeur().getChronoDemandes();
      if (p_demandeFinDroitAExclure != null) {
        chronologieDemandes.supprimer(p_demandeFinDroitAExclure);
      }
      String typeExamenDemandeNecessitantFinDroit = trouverTypeExamenPourProduit(p_demandeDroit.getDossierAffectation().getProduit());
      
      FiltreET filtreEt = new FiltreET();
      filtreEt.ajouterFiltre(new FiltreDemandePourERE(typeExamenDemandeNecessitantFinDroit));
      filtreEt.ajouterFiltre(new FiltreNegation(new FiltreDemandePourClassement("SO")));
      filtreEt.ajouterFiltre(new FiltreOuvertureDroitSurDecision());
      
      DemandeSpec demandeNecessitantFinDroitSuivante = OutilRecherche.rechercherDemandeSuivante(chronologieDemandes, p_demandeDroit.getDateRecherche(), filtreEt);
      
      FiltresTemporel listeFiltres = new FiltresTemporel();
      FiltreTemporel filtreFinDroit = trouverFiltreFinDroitPourProduit(p_demandeDroit.getDossierAffectation().getProduit());
      
      listeFiltres.ajouterFiltre(filtreFinDroit);
      if (demandeNecessitantFinDroitSuivante != null) {
        listeFiltres.ajouterFiltre(new FiltreDemandesPrecedentesSurDemandes(demandeNecessitantFinDroitSuivante));
      }
      chronologieDemandes = chronologieDemandes.copier(listeFiltres);
      chronologieDemandes.iterer();
      for (; chronologieDemandes.encoreSuivant(); goto 314)
      {
        DemandeSpec demande = (DemandeSpec)chronologieDemandes.elementSuivant();
        if (((demande.getClassementAdministratif() == null) || ((demande.getClassementAdministratif() != null) && (!demande.getClassementAdministratif().estClassementValide()))) && (demande.getDateRecherche().estApresOuCoincideAvec(p_demandeDroit.getDateRecherche())))
        {
          if ((demande.getListeDossiersExamen() == null) || (demande.getListeDossiersExamen().isEmpty()) || (!demande.estDecisionnee())) {
            break;
          }
          demandeRetour = demande;
        }
      }
    }
    return demandeRetour;
  }
  
  public static boolean estUnProduitAsr(ProduitSpec p_produit)
  {
    boolean estUnProduitAsr = false;
    if (p_produit != null)
    {
      int codeProduit = p_produit.getCode();
      if ((codeProduit == 37) || (codeProduit == 36)) {
        estUnProduitAsr = true;
      }
    }
    return estUnProduitAsr;
  }
  
  public static boolean estUnProduitAtp(ProduitSpec p_produit)
  {
    boolean estUnProduitAtp = false;
    if (p_produit != null)
    {
      int codeProduit = p_produit.getCode();
      if (codeProduit == 39) {
        estUnProduitAtp = true;
      }
    }
    return estUnProduitAtp;
  }
  
  public static boolean estUnProduitAsp(ProduitSpec p_produit)
  {
    boolean estUnProduitAsp = false;
    if (p_produit != null)
    {
      int codeProduit = p_produit.getCode();
      if ((codeProduit == 50) || (codeProduit == 51)) {
        estUnProduitAsp = true;
      }
    }
    return estUnProduitAsp;
  }
  
  public static boolean estDeProduitAsp(DemandeSpec p_demande)
  {
    boolean estProduitAsp = false;
    if (p_demande.getDossierAffectation() != null)
    {
      ProduitSpec produit = p_demande.getDossierAffectation().getProduit();
      estProduitAsp = estUnProduitAsp(produit);
    }
    return estProduitAsp;
  }
  
  public static boolean estDeProduitAsp(AttributionSpec p_attribution)
  {
    boolean estProduitAsp = false;
    if (p_attribution != null) {
      estProduitAsp = estUnProduitAsp(p_attribution.getProduit());
    }
    return estProduitAsp;
  }
  
  public static boolean estDeProduitAtp(AttributionSpec p_attribution)
  {
    boolean estProduitAsp = false;
    if (p_attribution != null) {
      estProduitAsp = estUnProduitAtp(p_attribution.getProduit());
    }
    return estProduitAsp;
  }
  
  public static boolean estDeProduitAsr(AttributionSpec p_attribution)
  {
    boolean estProduitAsp = false;
    if (p_attribution != null) {
      estProduitAsp = estUnProduitAsr(p_attribution.getProduit());
    }
    return estProduitAsp;
  }
}

/* Location:
 * Qualified Name:     OutilDroitAvecFinDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
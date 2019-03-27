package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.RejetSpec;
import fr.unedic.cali.utilitaire.filtres.FiltreCaliSpec;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionAsp;
import fr.unedic.cali.utilitaire.filtres.composites.FiltreAttributionAsr;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreAttributionSurDecisions;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDecisionPourProduit;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreDemandePourERE;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreOuvertureDroitSurDecision;
import fr.unedic.cali.utilitaire.filtres.generiques.FiltreReexamenSurDemande;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreET;
import fr.unedic.cali.utilitaire.filtres.logiques.FiltreNegation;
import fr.unedic.cali.utilitaire.outils.OutilRecherche;

public class OutilFinDroit
{
  public static DemandeSpec rechercherDemandePrecedenteCorrespondante(DemandeSpec p_demande)
  {
    DemandeSpec retour = null;
    if (OutilDemande.estUneDemandeFinDroitAsr(p_demande))
    {
      FiltreET filtre = new FiltreET();
      filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
      filtre.ajouterFiltre(new FiltreAttributionAsr());
      filtre.ajouterFiltre(new FiltreNegation(new FiltreReexamenSurDemande()));
      retour = OutilRecherche.rechercherDemandePrecedente(p_demande.getChronologieDemandesSansCourante(), p_demande, filtre);
    }
    else if (OutilDemande.estUneDemandeFinDroitAtp(p_demande))
    {
      FiltreET filtre = new FiltreET();
      filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
      filtre.ajouterFiltre(new FiltreDecisionPourProduit(39));
      retour = OutilRecherche.rechercherDemandePrecedente(p_demande.getChronologieDemandesSansCourante(), p_demande, filtre);
    }
    else if (OutilDemande.estUneDemandeFinDroitAsp(p_demande))
    {
      FiltreET filtre = new FiltreET();
      filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
      filtre.ajouterFiltre(new FiltreAttributionAsp());
      retour = OutilRecherche.rechercherDemandePrecedente(p_demande.getChronologieDemandesSansCourante(), p_demande, filtre);
    }
    return retour;
  }
  
  public static DemandeSpec rechercherDemandeODPrecedenteCorrespondante(DemandeSpec p_demande)
  {
    DemandeSpec retour = null;
    if (OutilDemande.estUneDemandeFinDroitAsr(p_demande))
    {
      FiltreET filtre = new FiltreET();
      filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
      filtre.ajouterFiltre(new FiltreAttributionAsr());
      filtre.ajouterFiltre(new FiltreNegation(new FiltreReexamenSurDemande()));
      filtre.ajouterFiltre(new FiltreOuvertureDroitSurDecision());
      retour = OutilRecherche.rechercherDemandePrecedente(p_demande.getChronologieDemandesSansCourante(), p_demande, filtre);
    }
    else if (OutilDemande.estUneDemandeFinDroitAtp(p_demande))
    {
      FiltreET filtre = new FiltreET();
      filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
      filtre.ajouterFiltre(new FiltreDecisionPourProduit(39));
      filtre.ajouterFiltre(new FiltreOuvertureDroitSurDecision());
      retour = OutilRecherche.rechercherDemandePrecedente(p_demande.getChronologieDemandesSansCourante(), p_demande, filtre);
    }
    else if (OutilDemande.estUneDemandeFinDroitAsp(p_demande))
    {
      FiltreET filtre = new FiltreET();
      filtre.ajouterFiltre(new FiltreAttributionSurDecisions());
      filtre.ajouterFiltre(new FiltreAttributionAsp());
      filtre.ajouterFiltre(new FiltreOuvertureDroitSurDecision());
      retour = OutilRecherche.rechercherDemandePrecedente(p_demande.getChronologieDemandesSansCourante(), p_demande, filtre);
    }
    return retour;
  }
  
  public static AttributionSpec rechercherFinDroitSuivantAttribution(AttributionSpec p_attributionAssurance)
  {
    AttributionSpec attributionAssuranceEncours = null;
    DemandeSpec demande = p_attributionAssurance.getDemande();
    if (OutilDroitAvecFinDroit.estDeProduitAsr(p_attributionAssurance)) {
      attributionAssuranceEncours = rechercheFinDroitAsr(demande);
    } else if (OutilDroitAvecFinDroit.estDeProduitAtp(p_attributionAssurance)) {
      attributionAssuranceEncours = rechercheFinDroitAtp(demande);
    } else if (OutilDroitAvecFinDroit.estDeProduitAsp(p_attributionAssurance)) {
      attributionAssuranceEncours = rechercheFinDroitAsp(demande);
    }
    return attributionAssuranceEncours;
  }
  
  private static AttributionSpec rechercheFinDroitAsr(DemandeSpec p_demande)
  {
    AttributionSpec attributionAssuranceEncours = null;
    
    DemandeSpec demandeFinDroitAsr = OutilAsr.rechercherDemandeFinAsrSuivantDemandeAsr(p_demande);
    if ((demandeFinDroitAsr != null) && (demandeFinDroitAsr.getDossierAffectation() != null))
    {
      DossierExamenSpec finDroitAsr = demandeFinDroitAsr.getDossierAffectation().getDossierExamen();
      if ((finDroitAsr instanceof RejetSpec)) {
        attributionAssuranceEncours = null;
      } else {
        attributionAssuranceEncours = (AttributionSpec)finDroitAsr;
      }
    }
    return attributionAssuranceEncours;
  }
  
  private static AttributionSpec rechercheFinDroitAtp(DemandeSpec p_demande)
  {
    AttributionSpec attributionAssuranceEncours = null;
    
    DemandeSpec demandeFinDroitAtp = OutilAtp.rechercherDemandeFinAtpSuivantDemandeAtp(p_demande);
    if ((demandeFinDroitAtp != null) && (demandeFinDroitAtp.getDossierAffectation() != null))
    {
      DossierExamenSpec finDroitAtp = demandeFinDroitAtp.getDossierAffectation().getDossierExamen();
      if ((finDroitAtp instanceof RejetSpec)) {
        attributionAssuranceEncours = null;
      } else {
        attributionAssuranceEncours = (AttributionSpec)finDroitAtp;
      }
    }
    return attributionAssuranceEncours;
  }
  
  private static AttributionSpec rechercheFinDroitAsp(DemandeSpec p_demande)
  {
    AttributionSpec attributionAssuranceEncours = null;
    
    DemandeSpec demandeFinDroitAsp = OutilAsp.rechercherDemandeFinAspSuivantDemandeAsp(p_demande);
    if ((demandeFinDroitAsp != null) && (demandeFinDroitAsp.getDossierAffectation() != null))
    {
      DossierExamenSpec finDroitAsp = demandeFinDroitAsp.getDossierAffectation().getDossierExamen();
      if ((finDroitAsp instanceof RejetSpec)) {
        attributionAssuranceEncours = null;
      } else {
        attributionAssuranceEncours = (AttributionSpec)finDroitAsp;
      }
    }
    return attributionAssuranceEncours;
  }
  
  public static FiltreCaliSpec getFiltreFinDeDroit()
  {
    FiltreET filtreFinDroit = new FiltreET();
    filtreFinDroit.ajouterFiltre(new FiltreDemandePourERE("ASU_19"));
    filtreFinDroit.ajouterFiltre(new FiltreDemandePourERE("ASU_25"));
    filtreFinDroit.ajouterFiltre(new FiltreDemandePourERE("ASU_17"));
    
    return filtreFinDroit;
  }
  
  public static FiltreCaliSpec getFiltreExclureFinDeDroit()
  {
    FiltreET filtreExclureFinDroit = new FiltreET();
    filtreExclureFinDroit.ajouterFiltre(new FiltreNegation(new FiltreDemandePourERE("ASU_19")));
    filtreExclureFinDroit.ajouterFiltre(new FiltreNegation(new FiltreDemandePourERE("ASU_25")));
    filtreExclureFinDroit.ajouterFiltre(new FiltreNegation(new FiltreDemandePourERE("ASU_17")));
    
    return filtreExclureFinDroit;
  }
}

/* Location:
 * Qualified Name:     OutilFinDroit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
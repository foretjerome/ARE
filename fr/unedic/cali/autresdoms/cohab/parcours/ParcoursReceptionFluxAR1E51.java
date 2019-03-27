package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.outilsfonctionnels.CreationDemande;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.EvenementReferenceExamenSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursDiffererExecution;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.temps.Chronologie;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;

public class ParcoursReceptionFluxAR1E51
  extends ParcoursReceptionFluxV1Demandes
{
  protected Collection traiterFlux(Contexte contexte)
    throws ApplicativeException
  {
    String codeGamme = getDonnees(contexte).getCodeGamme();
    ContexteService contexteService = getDonnees(contexte).getContexteService();
    String idDemandeRecue = getDonnees(contexte).getReferenceExterneDemande();
    Individu individu = (Individu)getDonnees(contexte).getIndividu();
    
    Collection<FormulaireSpec> listeNouveauxFormulairesNcp = null;
    
    DemandeSpec demande = rechercherDemandeAssurance(idDemandeRecue, individu);
    if ((demande != null) && (estUneDemandeDeRechargement(demande)))
    {
      listeNouveauxFormulairesNcp = new ArrayList();
      listeNouveauxFormulairesNcp.add(demande.getFormulaire());
    }
    else
    {
      listeNouveauxFormulairesNcp = recupererOutilCreationFormulaire().creerFormulaires(codeGamme, contexteService, idDemandeRecue, individu);
    }
    return listeNouveauxFormulairesNcp;
  }
  
  private DemandeSpec rechercherDemandeAssurance(String referenceExterne, IndividuSpec individu)
  {
    DemandeSpec demandeRecherche = null;
    boolean demandeTrouve = false;
    Chronologie listeDemandeAssurance = individu.getChronoDemandeAssurance();
    if (!listeDemandeAssurance.estVide())
    {
      listeDemandeAssurance.iterer();
      do
      {
        DemandeSpec demandeAssuranceIndividu = (DemandeSpec)listeDemandeAssurance.elementSuivant();
        if (demandeAssuranceIndividu.getFormulaire().getReferenceExterne().equalsIgnoreCase(referenceExterne))
        {
          demandeRecherche = demandeAssuranceIndividu;
          demandeTrouve = true;
        }
      } while ((!demandeTrouve) && (listeDemandeAssurance.encoreSuivant()));
    }
    return demandeRecherche;
  }
  
  private boolean estUneDemandeDeRechargement(DemandeSpec pDemande)
  {
    return (pDemande.getEvenementReferenceExamen() != null) && ("ASU_29".equals(pDemande.getEvenementReferenceExamen().getTypeExamen()));
  }
  
  private DomReceptionFluxAR1E51 getDonnees(Contexte contexte)
  {
    return (DomReceptionFluxAR1E51)contexte.getDonnees();
  }
  
  protected Damj getDateReexamen(DemandeSpec demande)
  {
    return demande.getDateDeclenchementExamen();
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected int getModeChargementGaec(Individu individu)
  {
    int retour = 2;
    if (individu.isEstNonExecutionReceptionFlux()) {
      retour = 0;
    }
    return retour;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    if (individu != null) {
      individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(getModeChargementGaec(individu));
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), getModeChargementGaec(individu));
  }
  
  protected void reexecuterDossierAutomatique(DemandeSpec demande, String codeReexamen, boolean uneSeuleDemandeDecisionnee, Collection<DemandeSpec> demandesAvecAttentes, IndividuSpec individu, Contexte contexte)
    throws ApplicativeException
  {
    if (!individu.isEstNonExecutionReceptionFlux())
    {
      super.reexecuterDossierAutomatique(demande, codeReexamen, uneSeuleDemandeDecisionnee, demandesAvecAttentes, individu, contexte);
    }
    else
    {
      DomReceptionFluxAR1E51 dom = getDonnees(contexte);
      dom.setBesoinAlimentationReception(false);
      EvenementReexamen evtReexamen = new EvenementReexamen(getDateReexamen(demande), codeReexamen);
      dom.setDateExecutionDifferee(evtReexamen.getDateReexamen());
      
      Parcours parcoursDiffererExecution = new ParcoursDiffererExecution();
      parcoursDiffererExecution.effectuerParcours(contexte);
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursReceptionFluxAR1E51
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
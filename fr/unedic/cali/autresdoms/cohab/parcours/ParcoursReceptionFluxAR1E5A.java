package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.outilsfonctionnels.FabriqueFormulairesCali;
import fr.unedic.cali.autresdoms.ga.dom.ActionFormation;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ParcoursReceptionFluxAR1E5A
  extends ParcoursReceptionFluxV1Demandes
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    if (getIndividu(p_contexte) == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Allocataire absent du contexte, impossible de receptionner le flux", null);
    }
    if (((DomReceptionFluxAR1E5A)getDom(p_contexte)).getIdActionFormation() == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Allocataire absent du contexte, impossible de receptionner le flux", null);
    }
  }
  
  protected Collection traiterFlux(Contexte p_contexte)
    throws ApplicativeException
  {
    Collection listeNouveauxFormulairesAff = null;
    Collection listeNouveauxFormulairesDaf = null;
    Collection listeNouveauxFormulairesNcp = new ArrayList();
    
    String numeroAllocataire = getDonnees(p_contexte).getIndividu().getNumeroAllocataire();
    
    listeNouveauxFormulairesDaf = FabriqueFormulairesCali.creerFormulairesDAF(getDonnees(p_contexte), numeroAllocataire);
    Iterator itDaf = listeNouveauxFormulairesDaf.iterator();
    listeNouveauxFormulairesNcp.add(itDaf.next());
    
    String idActionFormation = getDonnees(p_contexte).getIdActionFormation();
    ActionFormation actionFormation = (ActionFormation)getDonnees(p_contexte).getIndividu().rechercherPeriodePasseProfessionnel(idActionFormation);
    ContexteService contexteService = getDonnees(p_contexte).getContexteService();
    listeNouveauxFormulairesAff = FabriqueFormulairesCali.creerFormulairesNcp(actionFormation, getIndividu(p_contexte), contexteService);
    Iterator itAff = listeNouveauxFormulairesAff.iterator();
    listeNouveauxFormulairesNcp.add(itAff.next());
    
    return listeNouveauxFormulairesNcp;
  }
  
  protected Damj getDateReexamen(DemandeSpec p_demande)
  {
    return p_demande.getDateDeclenchementExamen();
  }
  
  private DomReceptionFluxAR1E5A getDonnees(Contexte p_contexte)
  {
    return (DomReceptionFluxAR1E5A)p_contexte.getDonnees();
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    if (p_individu != null) {
      p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
    }
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
}

/* Location:
 * Qualified Name:     ParcoursReceptionFluxAR1E5A
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
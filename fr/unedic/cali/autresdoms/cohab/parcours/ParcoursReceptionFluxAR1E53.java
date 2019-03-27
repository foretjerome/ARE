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
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.temps.Damj;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ParcoursReceptionFluxAR1E53
  extends ParcoursReceptionFluxV1Demandes
{
  ActionFormation m_planFormation;
  
  protected Collection traiterFlux(Contexte p_contexte)
    throws ApplicativeException
  {
    Collection listeNouveauxFormulairesNcp = new ArrayList();
    
    String idPlanFormation = getDonnees(p_contexte).getIdPlanFormation();
    ContexteService contexteService = getDonnees(p_contexte).getContexteService();
    
    Collection listeActionsFormation = getDonnees(p_contexte).getIndividu().getActionsFormation();
    Iterator iter = listeActionsFormation.iterator();
    boolean bFound = false;
    while ((iter.hasNext()) && (!bFound))
    {
      ActionFormation actionFormation = (ActionFormation)iter.next();
      if (actionFormation.getIdentifiant().equals(idPlanFormation))
      {
        m_planFormation = actionFormation;
        bFound = true;
      }
    }
    listeNouveauxFormulairesNcp = FabriqueFormulairesCali.creerFormulairesNcp(m_planFormation, getIndividu(p_contexte), contexteService);
    
    return listeNouveauxFormulairesNcp;
  }
  
  protected Damj getDateReexamen(DemandeSpec p_demande)
  {
    return Damj.min(p_demande.getDateRecherche(), m_planFormation.getDateDebut());
  }
  
  private DomReceptionFluxAR1E53 getDonnees(Contexte p_contexte)
  {
    return (DomReceptionFluxAR1E53)p_contexte.getDonnees();
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
 * Qualified Name:     ParcoursReceptionFluxAR1E53
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
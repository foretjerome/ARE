package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.cohab.dom.ObjetChronoPeriodePriseEnCharge;
import fr.unedic.cali.calcul.OutillagePeriodes;
import fr.unedic.cali.calcul.dom.CalendrierExecutionAvant;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.RevisionSpec;
import fr.unedic.cali.dom.affectation.ProduitRbfSpec;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.outilsfonctionnels.AppelAvant;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParcoursDeterminerIndemnisationPrevisionnelle
  extends ParcoursCalculPilotage
  implements ParcoursService
{
  public ParcoursDeterminerIndemnisationPrevisionnelle()
  {
    setTypeDePostTraitement(2);
  }
  
  public void controlerContexte(Contexte contexte)
    throws ContexteException
  {
    if (getIndividu(contexte) == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "L'allocataire n'est pas renseigné ", null);
    }
  }
  
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    IndividuSpec individuCali = getIndividu(contexte);
    
    List<AttributionSpec> listeAttributions = individuCali.getListeAttributionsExecutables();
    listeAttributions = filtrerListeAttributionsRevisionHorsPEC(listeAttributions);
    
    DomCalculPilotage domCalcul = (DomCalculPilotage)contexte.getDonnees();
    domCalcul.setListeAttributions(listeAttributions);
    domCalcul.setExecutionDepuisPersistance(false);
    domCalcul.setAttributionAEtudier(null);
    domCalcul.setEstAideDecoupe(true);
    
    List<ResultatAvant> resultatsAvant = AppelAvant.executerAvant(listeAttributions);
    
    super.controlerContexte(contexte);
    
    ResultatPilotage resultat = (ResultatPilotage)super.demarrerParcours(contexte);
    for (ResultatAvant resultatAvant : resultatsAvant) {
      if ((resultatAvant.getCalendrierExecutionAvantCalcul() != null) && (((CalendrierExecutionAvant)resultatAvant.getCalendrierExecutionAvantCalcul()).getChronologieUnitesTraitements() != null) && (!((CalendrierExecutionAvant)resultatAvant.getCalendrierExecutionAvantCalcul()).getChronologieUnitesTraitements().estVide())) {
        if (resultat.getResultatDetaille(resultatAvant.getAttribution()) == null)
        {
          resultatAvant.getAttribution().setCalendrierExecutionCalcul(null);
          ResultatDetailleProduit resAttribution = new ResultatDetailleProduit();
          resAttribution.setEtat(0);
          resAttribution.setAttribution(resultatAvant.getAttribution());
          resAttribution.setCalendrierExecutionCalcul(null);
          resAttribution.setCalendrierExecutionAvantCalcul(resultatAvant.getCalendrierExecutionAvantCalcul());
          resultat.ajouteResultatDetaille(resAttribution);
        }
        else
        {
          ResultatDetailleProduit resAttribution = resultat.getResultatDetaille(resultatAvant.getAttribution());
          resAttribution.setCalendrierExecutionAvantCalcul(resultatAvant.getCalendrierExecutionAvantCalcul());
        }
      }
    }
    return resultat;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(2);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 2);
  }
  
  private static List<AttributionSpec> filtrerListeAttributionsRevisionHorsPEC(List<AttributionSpec> listeAttributions)
  {
    List<AttributionSpec> attributions = new ArrayList();
    
    Iterator it = listeAttributions.iterator();
    while (it.hasNext())
    {
      AttributionSpec attributionSpec = (AttributionSpec)it.next();
      if (!(attributionSpec instanceof RevisionSpec))
      {
        if (attributionSpec.getProduitExecution().getNom().equals("RBF_MOB07_01"))
        {
          ProduitRbfSpec produit = (ProduitRbfSpec)attributionSpec.getProduitExecution();
          attributions.addAll(produit.recupererListeAttributionsExecutables(attributionSpec));
        }
        else
        {
          attributions.add(attributionSpec);
        }
      }
      else
      {
        ObjetChronoPeriodePriseEnCharge periodePEC = OutillagePeriodes.recupererPeriodePECContenant(attributionSpec.getDemandeur(), attributionSpec.getDateAttribution());
        if ((periodePEC != null) && ((periodePEC.getTypePec() == null) || (periodePEC.getSousType() == null) || ((!periodePEC.estDeTypeAdr()) && (!periodePEC.estDeTypeArce())))) {
          attributions.add(attributionSpec);
        }
      }
    }
    return attributions;
  }
}

/* Location:
 * Qualified Name:     ParcoursDeterminerIndemnisationPrevisionnelle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
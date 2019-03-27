package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.outilsfonctionnels.dom.ResultatActiviteReduite;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DomSimulationCalculActiviteReduite;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.affectation.ProduitAsuAbstrait;
import fr.unedic.cali.dom.affectation.ProduitAsuDelegueSpec;
import fr.unedic.cali.outilsfonctionnels.OutilCalculEstimationCotisationsSociales;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.Periode;
import java.math.BigDecimal;

public class ParcoursSimulationCalculActiviteReduite
  extends ParcoursServiceAbstrait
{
  protected Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    ResultatSimulationCalculActiviteReduite resultat = new ResultatSimulationCalculActiviteReduite();
    resultat.setEtat(1);
    
    DomSimulationCalculActiviteReduite domSimCalcul = (DomSimulationCalculActiviteReduite)contexte.getDonnees();
    
    recupererResultatActiviteReduite(domSimCalcul);
    
    resultat.setEtat(0);
    resultat.setDomSimulationCalculActiviteReduite(domSimCalcul);
    
    return resultat;
  }
  
  private void recupererResultatActiviteReduite(DomSimulationCalculActiviteReduite domSimCalcul)
    throws CoucheLogiqueException
  {
    AttributionSpec attribution = domSimCalcul.getAttribution();
    ProduitAsuAbstrait produit = (ProduitAsuAbstrait)attribution.getProduit();
    ProduitAsuDelegueSpec produitDelegue = (ProduitAsuDelegueSpec)produit.getProduitDelegue();
    
    BigDecimal crc = produitDelegue.getCrcSimuActiviteReduite(domSimCalcul.getSjr(), domSimCalcul.getAllocationJournaliereInitiale(), domSimCalcul.getDateDebutPeriodeActiviteReduite());
    
    BigDecimal allocationJournalierBrute = domSimCalcul.getAllocationJournaliereInitiale();
    BigDecimal areBrute = allocationJournalierBrute.multiply(domSimCalcul.getNbJoursDansMois());
    
    ResultatActiviteReduite res = produitDelegue.calculActiviteReduite(allocationJournalierBrute, domSimCalcul.getRemunerationReprise(), areBrute, domSimCalcul.getSjr(), null, new Periode(domSimCalcul.getDateDebutPeriodeActiviteReduite().getDebutMois(), domSimCalcul.getDateDebutPeriodeActiviteReduite().getFinMois()));
    
    BigDecimal csg = OutilCalculEstimationCotisationsSociales.calculerCsg(domSimCalcul.getAllocationJournaliereInitiale(), crc);
    BigDecimal cdrs = OutilCalculEstimationCotisationsSociales.calculerCrds(domSimCalcul.getAllocationJournaliereInitiale(), crc, csg);
    
    domSimCalcul.setNbJoursAPayer(res.getQuantiteIndemnise());
    domSimCalcul.setNbJoursDecaler(domSimCalcul.getNbJoursDansMois().subtract(res.getQuantiteIndemnise()));
    domSimCalcul.setMontant(domSimCalcul.getAllocationJournaliereInitiale());
    domSimCalcul.setMontantCrc(crc);
    domSimCalcul.setMontantCsg(csg);
    domSimCalcul.setMontantCrds(cdrs);
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursSimulationCalculActiviteReduite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
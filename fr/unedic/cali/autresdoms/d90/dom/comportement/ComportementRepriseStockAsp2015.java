package fr.unedic.cali.autresdoms.d90.dom.comportement;

import fr.unedic.cali.dom.affectation.ProduitAsuCge01P02;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P03;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P04;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P05;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P06;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P07;
import fr.unedic.cali.dom.affectation.ProduitAsuCge01P6B;
import fr.unedic.cali.dom.affectation.ProduitAsuCsa06P01;
import fr.unedic.cali.dom.affectation.ProduitAsuCsa06P02;
import fr.unedic.cali.dom.affectation.ProduitAsuCsa06P03;
import fr.unedic.cali.dom.affectation.ProduitAsuCsa06P04;
import fr.unedic.cali.dom.affectation.ProduitAsuCsa06P05;
import fr.unedic.cali.dom.affectation.ProduitAsuCsa06P5B;
import fr.unedic.cali.dom.affectation.ProduitAsuCva10P02;
import fr.unedic.cali.dom.affectation.ProduitAsuCva10P03;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.utilitaire.decideur.logiques.DecideurDecisionVeto;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurDecisionProduitAttribution;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurDecisionTypeNatureDecision;
import fr.unedic.cali.utilitaire.decideur.metier.DecideurElementsAExclure;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ComportementRepriseStockAsp2015
  extends ComportementBatchDefaut
{
  private static final String IDENTIFIANT = "comportementRepriseStockAsp2015";
  private static final String LIBELLE = "Reconduction des reprises en novation et des ASP en ARE";
  
  public ComportementRepriseStockAsp2015()
  {
    initialiserVariableClasse();
    
    identifiantComportement = "comportementRepriseStockAsp2015";
    libelleComportement = "Reconduction des reprises en novation et des ASP en ARE";
    
    List<BigDecimal> decisionsAvant = new ArrayList();
    decisionsAvant.add(BigDecimal.valueOf(3L));
    decisionsAvant.add(BigDecimal.valueOf(46L));
    decisionsAvant.add(BigDecimal.valueOf(27L));
    decisionsAvant.add(BigDecimal.valueOf(14L));
    decisionsAvant.add(BigDecimal.valueOf(13L));
    decisionsAvant.add(BigDecimal.valueOf(34L));
    decisionsAvant.add(BigDecimal.valueOf(15L));
    decisionsAvant.add(BigDecimal.valueOf(10L));
    
    List<BigDecimal> decisionsApres = new ArrayList();
    decisionsApres.add(BigDecimal.valueOf(47L));
    decisionsApres.add(BigDecimal.valueOf(48L));
    
    DecideurDecisionTypeNatureDecision decideurNature = new DecideurDecisionTypeNatureDecision(decisionsAvant, decisionsApres);
    
    List<BigDecimal> decisionsAdmissionAvant = new ArrayList();
    decisionsAdmissionAvant.add(BigDecimal.valueOf(10L));
    
    List<BigDecimal> decisionsAdmissionApres = new ArrayList();
    decisionsAdmissionApres.add(BigDecimal.valueOf(12L));
    
    DecideurDecisionTypeNatureDecision decideurNatureAdmssion = new DecideurDecisionTypeNatureDecision(decisionsAdmissionAvant, decisionsAdmissionApres);
    
    List<ProduitSpec> produitsAvant = new ArrayList();
    produitsAvant.add(ProduitAsuCva10P02.getInstance());
    produitsAvant.add(ProduitAsuCva10P03.getInstance());
    
    List<ProduitSpec> produitsApres = new ArrayList();
    produitsApres.add(ProduitAsuCge01P02.getInstance());
    produitsApres.add(ProduitAsuCge01P03.getInstance());
    produitsApres.add(ProduitAsuCge01P04.getInstance());
    produitsApres.add(ProduitAsuCge01P05.getInstance());
    produitsApres.add(ProduitAsuCge01P06.getInstance());
    produitsApres.add(ProduitAsuCge01P07.getInstance());
    produitsApres.add(ProduitAsuCge01P6B.getInstance());
    produitsApres.add(ProduitAsuCsa06P01.getInstance());
    produitsApres.add(ProduitAsuCsa06P02.getInstance());
    produitsApres.add(ProduitAsuCsa06P03.getInstance());
    produitsApres.add(ProduitAsuCsa06P04.getInstance());
    produitsApres.add(ProduitAsuCsa06P05.getInstance());
    produitsApres.add(ProduitAsuCsa06P5B.getInstance());
    
    DecideurDecisionProduitAttribution decideurProduit = new DecideurDecisionProduitAttribution(produitsAvant, produitsApres);
    
    DecideurElementsAExclure eltsAExclure = new DecideurElementsAExclure();
    creerElementDroitAExclureOccasionnelLiquidation(eltsAExclure);
    
    DecideurDecisionVeto decideur = new DecideurDecisionVeto();
    
    decideur.ajouterDecideur(decideurNature);
    decideur.ajouterDecideur(decideurNatureAdmssion);
    decideur.ajouterDecideur(decideurProduit);
    decideur.ajouterDecideur(eltsAExclure);
    
    setDecideur(decideur);
  }
}

/* Location:
 * Qualified Name:     ComportementRepriseStockAsp2015
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
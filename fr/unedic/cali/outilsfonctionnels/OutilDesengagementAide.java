package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.calcul.pbjc.dom.AideNcp;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.BilanFinancierAidesMobilite;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.FormulaireSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.affectation.ProduitRbfSpec;
import fr.unedic.cali.dom.pivot.Aides;
import fr.unedic.cali.dom.pivot.DemandePivot;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.ChronologieDebuts;
import fr.unedic.util.temps.ChronologiePeriodes;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OutilDesengagementAide
  implements OutilFonctionnel
{
  private static OutilDesengagementAide instance;
  
  public static OutilDesengagementAide getInstance()
  {
    if (instance == null) {
      instance = new OutilDesengagementAide();
    }
    return instance;
  }
  
  public BilanFinancierAidesMobilite getResultBilanFinancierAidesMobilite(IndividuSpec individu, String referenceExterne)
    throws ApplicativeException
  {
    return new BilanFinancierAidesMobilite(getAttributionAidesMobilite(individu, referenceExterne), calculAideEngage(individu, referenceExterne), calculAidePayeTotal(individu, referenceExterne));
  }
  
  public BigDecimal calculSommeADesengager(IndividuSpec individu, String referenceExterne)
  {
    BigDecimal montantEngage = calculAideEngage(individu, referenceExterne);
    
    BigDecimal montantPaye = calculAidePayeTotal(individu, referenceExterne);
    
    return montantEngage.subtract(montantPaye);
  }
  
  public boolean estDesengagementPossible(IndividuSpec individu, String referenceExterne)
  {
    return calculSommeADesengager(individu, referenceExterne).signum() == 1;
  }
  
  public boolean estDesengagementPossible(BigDecimal difference)
  {
    return difference.signum() == 1;
  }
  
  public BigDecimal calculAidePayeTotal(IndividuSpec individu, String referenceExterne)
  {
    BigDecimal montantPaye = BigDecimal.ZERO;
    ChronologiePeriodes aides = individu.getChronoAides();
    
    aides.iterer();
    while (aides.encoreSuivant())
    {
      AideNcp aide = (AideNcp)aides.elementSuivant();
      if ((aide.getReferenceExterne() != null) && (aide.getReferenceExterne().equals(referenceExterne)))
      {
        if (aide.getMontantTotalAide1() != null) {
          montantPaye = montantPaye.add(aide.getMontantTotalAide1());
        }
        if (aide.getMontantTotalAide2() != null) {
          montantPaye = montantPaye.add(aide.getMontantTotalAide2());
        }
        if (aide.getMontantTotalAide3() != null) {
          montantPaye = montantPaye.add(aide.getMontantTotalAide3());
        }
        if (aide.getMontantTotalAide4() != null) {
          montantPaye = montantPaye.add(aide.getMontantTotalAide4());
        }
      }
    }
    return montantPaye;
  }
  
  public BigDecimal calculAideEngage(IndividuSpec individu, String referenceExterne)
  {
    BigDecimal montantEngage = BigDecimal.ZERO;
    ChronologieDebuts chronoRBF = individu.getChronoDemandeRemboursementFrais();
    ListIterator<?> it = chronoRBF.iterer();
    while (it.hasNext())
    {
      DemandeSpec demande = (DemandeSpec)it.next();
      if ((demande.getFormulaire().getReferenceExterne() != null) && (demande.getFormulaire().getReferenceExterne().equals(referenceExterne))) {
        montantEngage = calculEngage(demande);
      }
    }
    return montantEngage;
  }
  
  private BigDecimal calculEngage(DemandeSpec demande)
  {
    BigDecimal montantEngage = demande.getDemandePivot().getAides().getMontantTotalPaye();
    if ((demande.getDemandePivot().getAides().getMontantBonTransport() != null) && (BigDecimal.ZERO.compareTo(demande.getDemandePivot().getAides().getMontantBonTransport()) < 0)) {
      montantEngage = montantEngage.subtract(demande.getDemandePivot().getAides().getMontantBonTransport());
    }
    return montantEngage;
  }
  
  public AttributionSpec getAttributionAidesMobilite(IndividuSpec individu, String referenceExterne)
    throws ApplicativeException
  {
    List<AttributionSpec> listeAttributions = individu.getListeAttributionsExecutables();
    
    Iterator<AttributionSpec> it = listeAttributions.iterator();
    while (it.hasNext())
    {
      AttributionSpec attributionSpec = (AttributionSpec)it.next();
      String refExtern = attributionSpec.getDemande() != null ? attributionSpec.getDemande().getFormulaire().getReferenceExterne() : "";
      if ((refExtern != null) && (refExtern.equals(referenceExterne))) {
        return attributionSpec;
      }
    }
    return null;
  }
  
  public void forcerDesengagementSurDemandeAideMob(BilanFinancierAidesMobilite bilanFinancierAidesMobilite)
    throws ApplicativeException
  {
    ProduitRbfSpec produit = (ProduitRbfSpec)bilanFinancierAidesMobilite.getAttribution().getProduit();
    produit.forcerMontantADesengager(bilanFinancierAidesMobilite.getAttribution(), bilanFinancierAidesMobilite.getMontantADesengager());
  }
}

/* Location:
 * Qualified Name:     OutilDesengagementAide
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
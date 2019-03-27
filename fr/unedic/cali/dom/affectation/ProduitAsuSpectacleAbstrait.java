package fr.unedic.cali.dom.affectation;

import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.spec.ComportementAffiliationSpec;
import fr.unedic.cali.liquidation.outilsfonctionnels.spec.OutilCalculDiffereStandardSpec;
import fr.unedic.cali.liquidation.outilsfonctionnels.spec.OutilPeriodeElementaireSpectacleSpec;
import fr.unedic.cali.liquidation.outilsfonctionnels.spec.ParametresFormuleSpec;
import fr.unedic.util.Quantite;
import fr.unedic.util.services.PasAssezInformationException;
import java.math.BigDecimal;

public abstract class ProduitAsuSpectacleAbstrait
  extends ProduitAsuAbstrait
  implements ProduitAsuSpectacleSpec
{
  private static final long serialVersionUID = 1L;
  
  public OutilCalculDiffereStandardSpec getOutilCalculDiffereStandard()
  {
    if (getProduitDelegue() != null) {
      return ((ProduitAsuDelegueSpectacleSpec)getProduitDelegue()).getOutilCalculDiffereStandard();
    }
    return null;
  }
  
  public Quantite getDiffereStandard(DemandeSpec demande, BigDecimal remuneration)
    throws PasAssezInformationException
  {
    if (getProduitDelegue() != null) {
      return ((ProduitAsuDelegueSpectacleSpec)getProduitDelegue()).getDiffereStandard(demande, remuneration);
    }
    return null;
  }
  
  public ParametresFormuleSpec recupererParametresCarenceIndemnisationDiffereStandard()
  {
    if (getProduitDelegue() != null) {
      return ((ProduitAsuDelegueSpectacleSpec)getProduitDelegue()).recupererParametresCarenceIndemnisationDiffereStandard();
    }
    return null;
  }
  
  public ComportementAffiliationSpec getComportementAffiliation()
  {
    if (getProduitDelegue() != null) {
      return ((ProduitAsuDelegueSpectacleSpec)getProduitDelegue()).getComportementAffiliation();
    }
    return null;
  }
  
  public OutilPeriodeElementaireSpectacleSpec getOutilPeriodeElementaire()
  {
    if (getProduitDelegue() != null) {
      return ((ProduitAsuDelegueSpectacleSpec)getProduitDelegue()).getOutilPeriodeElementaire();
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     ProduitAsuSpectacleAbstrait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
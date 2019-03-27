package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.ClassementAdministratifSpec;
import fr.unedic.cali.dom.DecisionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.DossierAffectationSpec;
import fr.unedic.cali.dom.DossierExamenSpec;
import fr.unedic.cali.dom.NaturesDecisions;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Hashtable;

public final class CREMHorsGamme
{
  public static Hashtable<String, String> recupererElementsDecision(DemandeSpec demande)
    throws CoucheLogiqueException
  {
    Hashtable<String, String> elementDecision = getElementsDecisionVides();
    if (demande != null)
    {
      ClassementAdministratifSpec classement = demande.getClassementAdministratif();
      if (classement != null)
      {
        elementDecision.put("Nature Decision", "Classement " + classement.getTypeClassement());
      }
      else
      {
        DossierExamenSpec dossierExamen = demande.getDossierAffectation().getDossierExamen();
        if ((dossierExamen instanceof DecisionSpec))
        {
          int codeDecisionCourante = ((DecisionSpec)dossierExamen).getNatureDecision();
          String libelleNatureDecision = (String)NaturesDecisions.s_libelleObjectifDecision.get(new BigDecimal(codeDecisionCourante));
          if (libelleNatureDecision != null) {
            elementDecision.put("Nature Decision", libelleNatureDecision);
          }
        }
        DossierAffectationSpec dossierAffectation = demande.getDossierAffectation();
        
        ProduitSpec produitCourant = dossierAffectation.getProduit();
        if ((produitCourant != null) && (produitCourant.getLibelleLong() != null)) {
          elementDecision.put("Produit", produitCourant.getLibelleLong());
        }
      }
    }
    return elementDecision;
  }
  
  public static Hashtable<String, String> getElementsDecisionVides()
  {
    Hashtable<String, String> listeDecision = new Hashtable();
    
    listeDecision.put("Nature Decision", "");
    
    listeDecision.put("Produit", "");
    
    return listeDecision;
  }
  
  public static Damj getDateDecision(DemandeSpec demande)
  {
    DossierExamenSpec dossierExamen = null;
    try
    {
      if (demande.getDossierAffectation() != null) {
        dossierExamen = demande.getDossierAffectation().getDossierExamen();
      } else {
        return null;
      }
    }
    catch (UnsupportedOperationException ex)
    {
      return null;
    }
    if ((dossierExamen != null) && ((dossierExamen instanceof AttributionSpec))) {
      return dossierExamen.getDateAttribution();
    }
    return demande.getDateExamen();
  }
}

/* Location:
 * Qualified Name:     CREMHorsGamme
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;

public class GestionnaireReexecutionAvecJustification
  implements GestionnaireReexecutionSpec
{
  private GestionnaireReexecution sousGestionnaire;
  
  public GestionnaireReexecutionAvecJustification()
  {
    sousGestionnaire = new GestionnaireReexecution();
  }
  
  public ResultatGestionnaireReexecutionSpec executer(DemandeSpec demande, EvenementReexamen evenement)
    throws ApplicativeException
  {
    return getSousGestionnaire().executer(demande, evenement);
  }
  
  public ResultatGestionnaireReexecutionSpec executer(IndividuSpec individu, EvenementReexamen evenement)
    throws ApplicativeException
  {
    return getSousGestionnaire().executer(individu, evenement);
  }
  
  public ResultatGestionnaireReexecutionSpec executer(IndividuSpec individu, EvenementReexamen evenement, ComportementSpec comportement)
    throws ApplicativeException
  {
    OutilJustificationReexecution of = new OutilJustificationReexecution();
    of.preTraitementBaseVisu(individu, comportement);
    
    ResultatGestionnaireReexecutionSpec resultat = getSousGestionnaire().executer(individu, evenement, comportement);
    
    of.postTraitementBaseVisuLiquidation(comportement, resultat);
    of.postTraitementBaseVisuCalcul(individu, comportement, resultat);
    of.postTraitementBaseVisuEtat(comportement, resultat);
    
    return resultat;
  }
  
  public ResultatGestionnaireReexecutionSpec executerSurInstallationDemande(DemandeSpec demande, EvenementReexamen evenement)
    throws ApplicativeException
  {
    return getSousGestionnaire().executerSurInstallationDemande(demande, evenement);
  }
  
  public ResultatGestionnaireReexecutionSpec executerSurReexamenManuel(DemandeSpec demandeAReexaminer)
    throws ApplicativeException
  {
    return getSousGestionnaire().executerSurReexamenManuel(demandeAReexaminer);
  }
  
  public ResultatGestionnaireReexecutionSpec executerSurValidation(DemandeSpec demandeAValider)
    throws ApplicativeException
  {
    return getSousGestionnaire().executerSurValidation(demandeAValider);
  }
  
  private GestionnaireReexecutionSpec getSousGestionnaire()
  {
    return sousGestionnaire;
  }
}

/* Location:
 * Qualified Name:     GestionnaireReexecutionAvecJustification
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
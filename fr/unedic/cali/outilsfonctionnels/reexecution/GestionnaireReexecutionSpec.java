package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.spec.ComportementSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.EvenementReexamen;

public abstract interface GestionnaireReexecutionSpec
{
  public abstract ResultatGestionnaireReexecutionSpec executerSurValidation(DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public abstract ResultatGestionnaireReexecutionSpec executerSurInstallationDemande(DemandeSpec paramDemandeSpec, EvenementReexamen paramEvenementReexamen)
    throws ApplicativeException;
  
  public abstract ResultatGestionnaireReexecutionSpec executerSurReexamenManuel(DemandeSpec paramDemandeSpec)
    throws ApplicativeException;
  
  public abstract ResultatGestionnaireReexecutionSpec executer(DemandeSpec paramDemandeSpec, EvenementReexamen paramEvenementReexamen)
    throws ApplicativeException;
  
  public abstract ResultatGestionnaireReexecutionSpec executer(IndividuSpec paramIndividuSpec, EvenementReexamen paramEvenementReexamen)
    throws ApplicativeException;
  
  public abstract ResultatGestionnaireReexecutionSpec executer(IndividuSpec paramIndividuSpec, EvenementReexamen paramEvenementReexamen, ComportementSpec paramComportementSpec)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     GestionnaireReexecutionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
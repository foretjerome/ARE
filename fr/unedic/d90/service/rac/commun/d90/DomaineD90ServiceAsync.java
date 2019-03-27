package fr.unedic.d90.service.rac.commun.d90;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvenementAsynchrone;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvtDesengAide;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireODF;

public abstract interface DomaineD90ServiceAsync
{
  public abstract void ecrireEvenementAsynchrone(CriteresEcrireEvenementAsynchrone paramCriteresEcrireEvenementAsynchrone)
    throws ApplicativeException, TechniqueException;
  
  public abstract void ecrireEvtDesengAide(CriteresEcrireEvtDesengAide paramCriteresEcrireEvtDesengAide)
    throws ApplicativeException, TechniqueException;
  
  public abstract void ecrireODF(CriteresEcrireODF paramCriteresEcrireODF)
    throws ApplicativeException, TechniqueException;
}

/* Location:
 * Qualified Name:     DomaineD90ServiceAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
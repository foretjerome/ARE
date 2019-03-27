package fr.unedic.d90.service.rac.commun.d90;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvenementAsynchrone;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireEvtDesengAide;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireIndividu;
import fr.unedic.d90.donnees.d90.service.vls.CriteresEcrireODF;
import fr.unedic.d90.donnees.d90.service.vls.ResultatEcrireEvenementAsynchrone;
import fr.unedic.d90.donnees.d90.service.vls.ResultatEcrireEvtDesengAide;
import fr.unedic.d90.donnees.d90.service.vls.ResultatEcrireIndividu;
import fr.unedic.d90.donnees.d90.service.vls.ResultatEcrireODFOut;

public abstract interface InterfaceFacadeDomaineD90
{
  public abstract ResultatEcrireEvenementAsynchrone ecrireEvenementAsynchrone(CriteresEcrireEvenementAsynchrone paramCriteresEcrireEvenementAsynchrone)
    throws ApplicativeException, TechniqueException;
  
  public abstract ResultatEcrireEvtDesengAide ecrireEvtDesengAide(CriteresEcrireEvtDesengAide paramCriteresEcrireEvtDesengAide)
    throws ApplicativeException, TechniqueException;
  
  public abstract ResultatEcrireODFOut ecrireODF(CriteresEcrireODF paramCriteresEcrireODF)
    throws ApplicativeException, TechniqueException;
  
  public abstract ResultatEcrireIndividu ecrireIndividu(CriteresEcrireIndividu paramCriteresEcrireIndividu)
    throws ApplicativeException, TechniqueException;
}

/* Location:
 * Qualified Name:     InterfaceFacadeDomaineD90
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
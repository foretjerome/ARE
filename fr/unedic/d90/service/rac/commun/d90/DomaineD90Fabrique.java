package fr.unedic.d90.service.rac.commun.d90;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.contexte.Utilisateur;
import fr.unedic.archi.logique.deploiement.DomaineFabrique;

public abstract class DomaineD90Fabrique
  extends DomaineFabrique
{
  public static DomaineD90ServiceSync getDomaineD90ServiceSync()
    throws TechniqueException
  {
    DomaineD90ServiceSync domaineInstance = (DomaineD90ServiceSync)getCachedDomaineInstance(DomaineD90ServiceSync.class);
    DomaineD90ServiceSync retour;
    DomaineD90ServiceSync retour;
    if (domaineInstance == null) {
      retour = loadDomaineInstanceSync();
    } else {
      retour = domaineInstance;
    }
    return retour;
  }
  
  public static DomaineD90ServiceAsync getDomaineD90ServiceAsync()
    throws TechniqueException
  {
    DomaineD90ServiceAsync domaineInstance = (DomaineD90ServiceAsync)getCachedDomaineInstance(DomaineD90ServiceAsync.class);
    DomaineD90ServiceAsync retour;
    DomaineD90ServiceAsync retour;
    if (domaineInstance == null) {
      retour = loadDomaineInstanceAsync();
    } else {
      retour = domaineInstance;
    }
    return retour;
  }
  
  public static DomaineD90Flux getDomaineD90Flux(Utilisateur pUtilisateur, String pAssedic)
    throws TechniqueException
  {
    DomaineD90Flux domaineInstance = (DomaineD90Flux)getCachedDomaineInstance(DomaineD90Flux.class);
    _DomaineD90FluxImpl impl;
    _DomaineD90FluxImpl impl;
    if (domaineInstance == null)
    {
      DomaineD90Flux newDomaine = loadDomaineInstanceFlux(pUtilisateur, pAssedic);
      
      ExceptionUtil.assertInstanceOf("newDomaine", newDomaine, _DomaineD90FluxImpl.class);
      
      impl = (_DomaineD90FluxImpl)newDomaine;
    }
    else
    {
      ExceptionUtil.assertInstanceOf("domaineInstance", domaineInstance, _DomaineD90FluxImpl.class);
      impl = (_DomaineD90FluxImpl)domaineInstance;
    }
    impl.setCodeAssedic(pAssedic);
    impl.setUtilisateur(pUtilisateur);
    
    return impl;
  }
  
  public static DomaineD90Flux getDomaineD90Flux()
    throws TechniqueException
  {
    return getDomaineD90Flux(getCurrentUser(), getCurrentAssedic());
  }
  
  public static DomaineD90Flux getDomaineD90Flux(Utilisateur pUtilisateur)
    throws TechniqueException
  {
    return getDomaineD90Flux(pUtilisateur, getCurrentAssedic());
  }
  
  public static DomaineD90Flux getDomaineD90Flux(String pAssedic)
    throws TechniqueException
  {
    return getDomaineD90Flux(getCurrentUser(), pAssedic);
  }
  
  private static synchronized DomaineD90ServiceSync loadDomaineInstanceSync()
    throws TechniqueException
  {
    DomaineD90ServiceSync domaineInstance = (DomaineD90ServiceSync)getCachedDomaineInstance(DomaineD90ServiceSync.class);
    DomaineD90ServiceSync retour;
    DomaineD90ServiceSync retour;
    if (domaineInstance == null)
    {
      DomaineD90ServiceSyncImpl domaineImpl = new DomaineD90ServiceSyncImpl();
      retour = (DomaineD90ServiceSync)configureDomaineSyncImpl(DomaineD90ServiceSync.class, domaineImpl);
    }
    else
    {
      retour = domaineInstance;
    }
    return retour;
  }
  
  private static synchronized DomaineD90ServiceAsync loadDomaineInstanceAsync()
    throws TechniqueException
  {
    DomaineD90ServiceAsync domaineInstance = (DomaineD90ServiceAsync)getCachedDomaineInstance(DomaineD90ServiceAsync.class);
    DomaineD90ServiceAsync retour;
    DomaineD90ServiceAsync retour;
    if (domaineInstance == null)
    {
      DomaineD90ServiceAsyncImpl domaineImpl = new DomaineD90ServiceAsyncImpl();
      retour = (DomaineD90ServiceAsync)configureDomaineAsyncImpl(DomaineD90ServiceAsync.class, domaineImpl);
    }
    else
    {
      retour = domaineInstance;
    }
    return retour;
  }
  
  private static synchronized DomaineD90Flux loadDomaineInstanceFlux(Utilisateur pUser, String pAssedic)
    throws TechniqueException
  {
    DomaineD90Flux domaineInstance = (DomaineD90Flux)getCachedDomaineInstance(DomaineD90Flux.class, pUser, pAssedic);
    DomaineD90Flux retour;
    DomaineD90Flux retour;
    if (domaineInstance == null)
    {
      _DomaineD90FluxImpl domaineImpl = new _DomaineD90FluxImpl();
      retour = (DomaineD90Flux)configureDomaineFluxImpl(DomaineD90Flux.class, domaineImpl, pUser, pAssedic);
    }
    else
    {
      retour = domaineInstance;
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     DomaineD90Fabrique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
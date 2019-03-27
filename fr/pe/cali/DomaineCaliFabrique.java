package fr.pe.cali;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.contexte.Utilisateur;
import fr.unedic.archi.logique.deploiement.DomaineFabrique;

public abstract class DomaineCaliFabrique
  extends DomaineFabrique
{
  public static DomaineCaliServiceSync getDomaineCaliServiceSync()
    throws TechniqueException
  {
    DomaineCaliServiceSync domaineInstance = (DomaineCaliServiceSync)getCachedDomaineInstance(DomaineCaliServiceSync.class);
    DomaineCaliServiceSync retour;
    DomaineCaliServiceSync retour;
    if (domaineInstance == null) {
      retour = loadDomaineInstanceSync();
    } else {
      retour = domaineInstance;
    }
    return retour;
  }
  
  public static DomaineCaliServiceAsync getDomaineCaliServiceAsync()
    throws TechniqueException
  {
    DomaineCaliServiceAsync domaineInstance = (DomaineCaliServiceAsync)getCachedDomaineInstance(DomaineCaliServiceAsync.class);
    DomaineCaliServiceAsync retour;
    DomaineCaliServiceAsync retour;
    if (domaineInstance == null) {
      retour = loadDomaineInstanceAsync();
    } else {
      retour = domaineInstance;
    }
    return retour;
  }
  
  public static DomaineCaliFlux getDomaineCaliFlux(Utilisateur pUtilisateur, String pAssedic)
    throws TechniqueException
  {
    DomaineCaliFlux domaineInstance = (DomaineCaliFlux)getCachedDomaineInstance(DomaineCaliFlux.class);
    _DomaineCaliFluxImpl impl;
    _DomaineCaliFluxImpl impl;
    if (domaineInstance == null)
    {
      DomaineCaliFlux newDomaine = loadDomaineInstanceFlux(pUtilisateur, pAssedic);
      
      ExceptionUtil.assertInstanceOf("newDomaine", newDomaine, _DomaineCaliFluxImpl.class);
      
      impl = (_DomaineCaliFluxImpl)newDomaine;
    }
    else
    {
      ExceptionUtil.assertInstanceOf("domaineInstance", domaineInstance, _DomaineCaliFluxImpl.class);
      impl = (_DomaineCaliFluxImpl)domaineInstance;
    }
    impl.setCodeAssedic(pAssedic);
    impl.setUtilisateur(pUtilisateur);
    
    return impl;
  }
  
  public static DomaineCaliFlux getDomaineCaliFlux()
    throws TechniqueException
  {
    return getDomaineCaliFlux(getCurrentUser(), getCurrentAssedic());
  }
  
  public static DomaineCaliFlux getDomaineCaliFlux(Utilisateur pUtilisateur)
    throws TechniqueException
  {
    return getDomaineCaliFlux(pUtilisateur, getCurrentAssedic());
  }
  
  public static DomaineCaliFlux getDomaineCaliFlux(String pAssedic)
    throws TechniqueException
  {
    return getDomaineCaliFlux(getCurrentUser(), pAssedic);
  }
  
  private static synchronized DomaineCaliServiceSync loadDomaineInstanceSync()
    throws TechniqueException
  {
    DomaineCaliServiceSync domaineInstance = (DomaineCaliServiceSync)getCachedDomaineInstance(DomaineCaliServiceSync.class);
    DomaineCaliServiceSync retour;
    DomaineCaliServiceSync retour;
    if (domaineInstance == null)
    {
      DomaineCaliServiceSyncImpl domaineImpl = new DomaineCaliServiceSyncImpl();
      retour = (DomaineCaliServiceSync)configureDomaineSyncImpl(DomaineCaliServiceSync.class, domaineImpl);
    }
    else
    {
      retour = domaineInstance;
    }
    return retour;
  }
  
  private static synchronized DomaineCaliServiceAsync loadDomaineInstanceAsync()
    throws TechniqueException
  {
    DomaineCaliServiceAsync domaineInstance = (DomaineCaliServiceAsync)getCachedDomaineInstance(DomaineCaliServiceAsync.class);
    DomaineCaliServiceAsync retour;
    DomaineCaliServiceAsync retour;
    if (domaineInstance == null)
    {
      DomaineCaliServiceAsyncImpl domaineImpl = new DomaineCaliServiceAsyncImpl();
      retour = (DomaineCaliServiceAsync)configureDomaineAsyncImpl(DomaineCaliServiceAsync.class, domaineImpl);
    }
    else
    {
      retour = domaineInstance;
    }
    return retour;
  }
  
  private static synchronized DomaineCaliFlux loadDomaineInstanceFlux(Utilisateur pUser, String pAssedic)
    throws TechniqueException
  {
    DomaineCaliFlux domaineInstance = (DomaineCaliFlux)getCachedDomaineInstance(DomaineCaliFlux.class, pUser, pAssedic);
    DomaineCaliFlux retour;
    DomaineCaliFlux retour;
    if (domaineInstance == null)
    {
      _DomaineCaliFluxImpl domaineImpl = new _DomaineCaliFluxImpl();
      retour = (DomaineCaliFlux)configureDomaineFluxImpl(DomaineCaliFlux.class, domaineImpl, pUser, pAssedic);
    }
    else
    {
      retour = domaineInstance;
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     DomaineCaliFabrique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
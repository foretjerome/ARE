package fr.pe.d12dal;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.commun.lang.ExceptionUtil;
import fr.unedic.archi.logique.contexte.Utilisateur;
import fr.unedic.archi.logique.deploiement.DomaineFabrique;

public abstract class DomaineD12DALFabrique
  extends DomaineFabrique
{
  public static DomaineD12DALServiceSync getDomaineD12DALServiceSync()
    throws TechniqueException
  {
    DomaineD12DALServiceSync domaineInstance = (DomaineD12DALServiceSync)getCachedDomaineInstance(DomaineD12DALServiceSync.class);
    DomaineD12DALServiceSync retour;
    DomaineD12DALServiceSync retour;
    if (domaineInstance == null) {
      retour = loadDomaineInstanceSync();
    } else {
      retour = domaineInstance;
    }
    return retour;
  }
  
  public static DomaineD12DALServiceAsync getDomaineD12DALServiceAsync()
    throws TechniqueException
  {
    DomaineD12DALServiceAsync domaineInstance = (DomaineD12DALServiceAsync)getCachedDomaineInstance(DomaineD12DALServiceAsync.class);
    DomaineD12DALServiceAsync retour;
    DomaineD12DALServiceAsync retour;
    if (domaineInstance == null) {
      retour = loadDomaineInstanceAsync();
    } else {
      retour = domaineInstance;
    }
    return retour;
  }
  
  public static DomaineD12DALFlux getDomaineD12DALFlux(Utilisateur pUtilisateur, String pAssedic)
    throws TechniqueException
  {
    DomaineD12DALFlux domaineInstance = (DomaineD12DALFlux)getCachedDomaineInstance(DomaineD12DALFlux.class);
    _DomaineD12DALFluxImpl impl;
    _DomaineD12DALFluxImpl impl;
    if (domaineInstance == null)
    {
      DomaineD12DALFlux newDomaine = loadDomaineInstanceFlux(pUtilisateur, pAssedic);
      
      ExceptionUtil.assertInstanceOf("newDomaine", newDomaine, _DomaineD12DALFluxImpl.class);
      
      impl = (_DomaineD12DALFluxImpl)newDomaine;
    }
    else
    {
      ExceptionUtil.assertInstanceOf("domaineInstance", domaineInstance, _DomaineD12DALFluxImpl.class);
      impl = (_DomaineD12DALFluxImpl)domaineInstance;
    }
    impl.setCodeAssedic(pAssedic);
    impl.setUtilisateur(pUtilisateur);
    
    return impl;
  }
  
  public static DomaineD12DALFlux getDomaineD12DALFlux()
    throws TechniqueException
  {
    return getDomaineD12DALFlux(getCurrentUser(), getCurrentAssedic());
  }
  
  public static DomaineD12DALFlux getDomaineD12DALFlux(Utilisateur pUtilisateur)
    throws TechniqueException
  {
    return getDomaineD12DALFlux(pUtilisateur, getCurrentAssedic());
  }
  
  public static DomaineD12DALFlux getDomaineD12DALFlux(String pAssedic)
    throws TechniqueException
  {
    return getDomaineD12DALFlux(getCurrentUser(), pAssedic);
  }
  
  private static synchronized DomaineD12DALServiceSync loadDomaineInstanceSync()
    throws TechniqueException
  {
    DomaineD12DALServiceSync domaineInstance = (DomaineD12DALServiceSync)getCachedDomaineInstance(DomaineD12DALServiceSync.class);
    DomaineD12DALServiceSync retour;
    DomaineD12DALServiceSync retour;
    if (domaineInstance == null)
    {
      DomaineD12DALServiceSyncImpl domaineImpl = new DomaineD12DALServiceSyncImpl();
      retour = (DomaineD12DALServiceSync)configureDomaineSyncImpl(DomaineD12DALServiceSync.class, domaineImpl);
    }
    else
    {
      retour = domaineInstance;
    }
    return retour;
  }
  
  private static synchronized DomaineD12DALServiceAsync loadDomaineInstanceAsync()
    throws TechniqueException
  {
    DomaineD12DALServiceAsync domaineInstance = (DomaineD12DALServiceAsync)getCachedDomaineInstance(DomaineD12DALServiceAsync.class);
    DomaineD12DALServiceAsync retour;
    DomaineD12DALServiceAsync retour;
    if (domaineInstance == null)
    {
      DomaineD12DALServiceAsyncImpl domaineImpl = new DomaineD12DALServiceAsyncImpl();
      retour = (DomaineD12DALServiceAsync)configureDomaineAsyncImpl(DomaineD12DALServiceAsync.class, domaineImpl);
    }
    else
    {
      retour = domaineInstance;
    }
    return retour;
  }
  
  private static synchronized DomaineD12DALFlux loadDomaineInstanceFlux(Utilisateur pUser, String pAssedic)
    throws TechniqueException
  {
    DomaineD12DALFlux domaineInstance = (DomaineD12DALFlux)getCachedDomaineInstance(DomaineD12DALFlux.class, pUser, pAssedic);
    DomaineD12DALFlux retour;
    DomaineD12DALFlux retour;
    if (domaineInstance == null)
    {
      _DomaineD12DALFluxImpl domaineImpl = new _DomaineD12DALFluxImpl();
      retour = (DomaineD12DALFlux)configureDomaineFluxImpl(DomaineD12DALFlux.class, domaineImpl, pUser, pAssedic);
    }
    else
    {
      retour = domaineInstance;
    }
    return retour;
  }
}

/* Location:
 * Qualified Name:     DomaineD12DALFabrique
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali;

import fr.unedic.archi.logique.adaptateur.ServiceSignature;
import fr.unedic.archi.logique.deploiement.DomaineImpl;

public class DomaineCaliServiceSyncImpl
  extends DomaineImpl
  implements DomaineCaliServiceSync
{
  public DomaineCaliServiceSyncImpl()
  {
    super("fr.pe.cali", "Cali", new ServiceSignature[0]);
  }
}

/* Location:
 * Qualified Name:     DomaineCaliServiceSyncImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali;

import fr.unedic.archi.logique.adaptateur.ServiceSignature;
import fr.unedic.archi.logique.deploiement.DomaineImpl;

public class DomaineCaliServiceAsyncImpl
  extends DomaineImpl
  implements DomaineCaliServiceAsync
{
  public DomaineCaliServiceAsyncImpl()
  {
    super("fr.pe.cali", "Cali", new ServiceSignature[0]);
  }
}

/* Location:
 * Qualified Name:     DomaineCaliServiceAsyncImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
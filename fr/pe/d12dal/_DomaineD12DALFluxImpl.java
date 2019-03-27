package fr.pe.d12dal;

import fr.unedic.archi.logique.adaptateur.FluxSignature;
import fr.unedic.archi.logique.adaptateur.ServiceSignature;
import fr.unedic.archi.logique.deploiement.DomaineFluxImpl;

public class _DomaineD12DALFluxImpl
  extends DomaineFluxImpl
  implements DomaineD12DALFlux
{
  public _DomaineD12DALFluxImpl()
  {
    super("fr.pe.d12dal", "D12DAL", new ServiceSignature[0], new FluxSignature[0]);
  }
}

/* Location:
 * Qualified Name:     _DomaineD12DALFluxImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
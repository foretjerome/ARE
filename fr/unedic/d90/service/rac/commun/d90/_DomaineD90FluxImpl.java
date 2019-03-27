package fr.unedic.d90.service.rac.commun.d90;

import fr.unedic.archi.logique.adaptateur.FluxSignature;
import fr.unedic.archi.logique.adaptateur.ServiceSignature;
import fr.unedic.archi.logique.deploiement.DomaineFluxImpl;

public class _DomaineD90FluxImpl
  extends DomaineFluxImpl
  implements DomaineD90Flux
{
  public _DomaineD90FluxImpl()
  {
    super("fr.unedic.d90.service.rac.commun.d90", "D90", new ServiceSignature[0], new FluxSignature[0]);
  }
}

/* Location:
 * Qualified Name:     _DomaineD90FluxImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
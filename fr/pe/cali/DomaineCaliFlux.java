package fr.pe.cali;

import fr.pe.cali.logique.donnees.vls.CREM_IN;
import fr.pe.cali.logique.donnees.vls.FluxCaliIn;
import fr.pe.cali.logique.donnees.vls.FluxSillageIn;
import fr.pe.cali.logique.donnees.vls.Notification;
import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;

public abstract interface DomaineCaliFlux
{
  public abstract void J12CRE(CREM_IN paramCREM_IN)
    throws ApplicativeException, TechniqueException;
  
  public abstract void A12INVFRAUD(FluxSillageIn paramFluxSillageIn)
    throws ApplicativeException, TechniqueException;
  
  public abstract void NOTIFEPC(Notification paramNotification)
    throws ApplicativeException, TechniqueException;
  
  public abstract void A12INTEGRATION(FluxCaliIn paramFluxCaliIn)
    throws ApplicativeException, TechniqueException;
}

/* Location:
 * Qualified Name:     DomaineCaliFlux
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilFonctionnel;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.services.CoucheLogiqueException;

public abstract interface IOutilFonctionnelBeneficeAutreProduitAPS2017
  extends IOutilFonctionnel
{
  public abstract boolean estDemandePrecedenteRejetCra();
  
  public abstract boolean estEligibleCra()
    throws ApplicativeException;
  
  public abstract void gererSansRejetCraEtEligible()
    throws CoucheLogiqueException;
}

/* Location:
 * Qualified Name:     IOutilFonctionnelBeneficeAutreProduitAPS2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.dom.DonneesEntreeBeneficeAutreProduitConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.dom.DonneesSortieBeneficeAutreProduitConvention2017;
import fr.unedic.archi.logique.exception.ApplicativeException;

public abstract interface IOutilConditionBeneficeAutreProduit
  extends IOutilCorpsRegle
{
  public abstract DonneesSortieBeneficeAutreProduitConvention2017 verifierConditionBeneficeAutreProduit(DonneesEntreeBeneficeAutreProduitConvention2017 paramDonneesEntreeBeneficeAutreProduitConvention2017)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     IOutilConditionBeneficeAutreProduit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.dom;

import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.spec.IOutilFonctionnelBeneficeAutreProduitAPS2017;

public class DonneesEntreeBeneficeAutreProduitConvention2017
{
  IOutilFonctionnelBeneficeAutreProduitAPS2017 outilFonctionnel;
  Boolean leveeConditionBeneficeAutreProduitForcee;
  
  public IOutilFonctionnelBeneficeAutreProduitAPS2017 getOutilFonctionnel()
  {
    return outilFonctionnel;
  }
  
  public void setOutilFonctionnel(IOutilFonctionnelBeneficeAutreProduitAPS2017 outilFonctionnel)
  {
    this.outilFonctionnel = outilFonctionnel;
  }
  
  public Boolean isLeveeConditionBeneficeAutreProduitForcee()
  {
    return leveeConditionBeneficeAutreProduitForcee;
  }
  
  public void setLeveeConditionBeneficeAutreProduitForcee(Boolean leveeConditionBeneficeAutreProduitForcee)
  {
    this.leveeConditionBeneficeAutreProduitForcee = leveeConditionBeneficeAutreProduitForcee;
  }
}

/* Location:
 * Qualified Name:     DonneesEntreeBeneficeAutreProduitConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.dom.DonneesEntreeBeneficeAutreProduitConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.dom.DonneesSortieBeneficeAutreProduitConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.spec.IOutilConditionBeneficeAutreProduit;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.spec.IOutilFonctionnelBeneficeAutreProduitAPS2017;
import fr.unedic.archi.logique.exception.ApplicativeException;
import java.util.List;

public class OutilConditionBeneficeAutreProduitFPS2017
  implements IOutilConditionBeneficeAutreProduit
{
  private static OutilConditionBeneficeAutreProduitFPS2017 instance;
  private static final String NOM_OUTIL = OutilConditionBeneficeAutreProduitFPS2017.class.getPackage().getName() + " / " + OutilConditionBeneficeAutreProduitFPS2017.class.toString();
  
  public static OutilConditionBeneficeAutreProduitFPS2017 getInstance()
  {
    if (instance == null) {
      instance = new OutilConditionBeneficeAutreProduitFPS2017();
    }
    return instance;
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return (criteres.getListeContextesFonctionnels() != null) && ((criteres.getListeContextesFonctionnels().contains("examenApsSuiteAre")) || (criteres.getListeContextesFonctionnels().contains("examenAfdSuiteAre")));
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConditionBeneficeAutreProduitFPS2017();
  }
  
  public String getNomOutil()
  {
    return NOM_OUTIL;
  }
  
  public DonneesSortieBeneficeAutreProduitConvention2017 verifierConditionBeneficeAutreProduit(DonneesEntreeBeneficeAutreProduitConvention2017 donneesEntree)
    throws ApplicativeException
  {
    DonneesSortieBeneficeAutreProduitConvention2017 donneeSortie = new DonneesSortieBeneficeAutreProduitConvention2017();
    
    Boolean estLeveeConditionBeneficeAutreProduitForcee = donneesEntree.isLeveeConditionBeneficeAutreProduitForcee();
    if (estLeveeConditionBeneficeAutreProduitForcee != null)
    {
      donneeSortie.setSatisfait(estLeveeConditionBeneficeAutreProduitForcee.booleanValue());
    }
    else
    {
      IOutilFonctionnelBeneficeAutreProduitAPS2017 outil = donneesEntree.getOutilFonctionnel();
      boolean demandePrecedenteRejetCra = outil.estDemandePrecedenteRejetCra();
      boolean estEligibleCra = outil.estEligibleCra();
      if ((!demandePrecedenteRejetCra) && (estEligibleCra)) {
        outil.gererSansRejetCraEtEligible();
      } else {
        donneeSortie.setSatisfait((demandePrecedenteRejetCra) || (!estEligibleCra));
      }
    }
    return donneeSortie;
  }
}

/* Location:
 * Qualified Name:     OutilConditionBeneficeAutreProduitFPS2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
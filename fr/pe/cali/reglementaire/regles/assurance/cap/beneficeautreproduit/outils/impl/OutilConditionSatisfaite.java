package fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.dom.DonneesEntreeBeneficeAutreProduitConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.dom.DonneesSortieBeneficeAutreProduitConvention2017;
import fr.pe.cali.reglementaire.regles.assurance.cap.beneficeautreproduit.outils.spec.IOutilConditionBeneficeAutreProduit;
import java.util.List;

public class OutilConditionSatisfaite
  implements IOutilConditionBeneficeAutreProduit
{
  private static final String NOM_OUTIL = OutilConditionSatisfaite.class.getPackage().getName() + " / " + OutilConditionSatisfaite.class.toString();
  private static OutilConditionSatisfaite instance;
  
  public static OutilConditionSatisfaite getInstance()
  {
    if (instance == null) {
      instance = new OutilConditionSatisfaite();
    }
    return instance;
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return (criteres.getListeContextesFonctionnels() != null) && ((criteres.getListeContextesFonctionnels().contains("examenApsSuiteCraOuApsOuAfd")) || (criteres.getListeContextesFonctionnels().contains("examenAfdSuiteAps")));
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConditionSatisfaite();
  }
  
  public String getNomOutil()
  {
    return NOM_OUTIL;
  }
  
  public DonneesSortieBeneficeAutreProduitConvention2017 verifierConditionBeneficeAutreProduit(DonneesEntreeBeneficeAutreProduitConvention2017 donneesEntree)
  {
    DonneesSortieBeneficeAutreProduitConvention2017 donneeSortie = new DonneesSortieBeneficeAutreProduitConvention2017();
    if (donneesEntree.isLeveeConditionBeneficeAutreProduitForcee() != null) {
      donneeSortie.setSatisfait(donneesEntree.isLeveeConditionBeneficeAutreProduitForcee().booleanValue());
    } else {
      donneeSortie.setSatisfait(true);
    }
    return donneeSortie;
  }
}

/* Location:
 * Qualified Name:     OutilConditionSatisfaite
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom.DonneesEntreesRegleReglementApplicable;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.dom.ResultatRegleReglementApplicable;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.spec.IOutilCorpsRegleReglementApplicable;
import fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.spec.IOutilFonctionnelReglementApplicable;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.cali.dom.affectation.ProduitSpec;
import fr.unedic.cali.dom.affectation.Reglement;
import fr.unedic.cali.outilsfonctionnels.filtres.FiltreActiviteSalariePourCategorieParticuliere;
import fr.unedic.util.temps.Chronologie;
import java.util.List;

public class OutilReglementApplicableConvention2017
  implements IOutilCorpsRegleReglementApplicable
{
  private static final String NOM_OUTIL = "OutilReglementApplicableConvention2017";
  private static OutilReglementApplicableConvention2017 instance = new OutilReglementApplicableConvention2017();
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    return (criteres.getListeContextesReglementaires() == null) || (!criteres.getListeContextesReglementaires().contains("ReglementApplicableContexteAspSousJacent"));
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilReglementApplicableConvention2017();
  }
  
  public String getNomOutil()
  {
    return "OutilReglementApplicableConvention2017";
  }
  
  public static OutilReglementApplicableConvention2017 getInstance()
  {
    return instance;
  }
  
  public ResultatRegleReglementApplicable determinerReglementApplicable(DonneesEntreesRegleReglementApplicable donneesEntrees)
    throws ApplicativeException
  {
    ResultatRegleReglementApplicable resultat = new ResultatRegleReglementApplicable();
    Reglement reglementApplicable = donneesEntrees.getReglementValidationProduit();
    resultat.setReglementApplicable(reglementApplicable);
    if (donneesEntrees.isDroitInterimaireForcee()) {
      resultat.setDroitInterimaire(true);
    } else if ((!donneesEntrees.isAffiliationForcee()) && ("RG".equals(reglementApplicable.getNomReglement()))) {
      resultat.setDroitInterimaire(gererCasParticulierInterimaire(donneesEntrees));
    }
    return resultat;
  }
  
  protected boolean gererCasParticulierInterimaire(DonneesEntreesRegleReglementApplicable donneesEntrees)
    throws ApplicativeException
  {
    boolean estDroitInterimaire = false;
    Chronologie activitesInterimairesModifiees = modifierActiviteInterimaireAvantCalculAffiliation(donneesEntrees.getPasseProfessionnel(), donneesEntrees.getOutilFonctionnel(), donneesEntrees.getReglementValidationProduit().getProduit());
    if (!activitesInterimairesModifiees.estVide()) {
      estDroitInterimaire = donneesEntrees.getOutilFonctionnel().estProduitValiditeAvecActiviteRG5(donneesEntrees.getPasseProfessionnel());
    }
    modifierActiviteInterimaireApresCalculAffiliation(activitesInterimairesModifiees);
    return estDroitInterimaire;
  }
  
  protected Chronologie modifierActiviteInterimaireAvantCalculAffiliation(Chronologie passeProfessionnel, IOutilFonctionnelReglementApplicable outilFonctionnel, ProduitSpec produit)
  {
    Reglement reglementInterimaire = Reglement.getInstance("RG5", produit);
    
    Chronologie activitesInterimaires = passeProfessionnel.copier(new FiltreActiviteSalariePourCategorieParticuliere(34));
    
    activitesInterimaires.iterer();
    while (activitesInterimaires.encoreSuivant())
    {
      ActiviteSalarie activiteCourante = (ActiviteSalarie)activitesInterimaires.elementSuivant();
      if (outilFonctionnel.estActiviteRG5(activiteCourante))
      {
        activiteCourante.initialiserReglementForce(reglementInterimaire);
        activiteCourante.setListePeriodeElementaire(null);
      }
    }
    return activitesInterimaires;
  }
  
  protected void modifierActiviteInterimaireApresCalculAffiliation(Chronologie activites)
  {
    activites.iterer();
    while (activites.encoreSuivant())
    {
      ActiviteSalarie activiteCourante = (ActiviteSalarie)activites.elementSuivant();
      activiteCourante.supprimerReglementForce();
      activiteCourante.setListePeriodeElementaire(null);
    }
  }
}

/* Location:
 * Qualified Name:     OutilReglementApplicableConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.retraite.impl.OutilRetraite;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom.DonneesEntreeDateLimiteSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom.DonneesSortieDateLimiteSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom.JustificationDateLimiteDateLimite;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.spec.IOutilConstitutionDateLimiteSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.spec.IOutilFonctionnelDateLimiteSpectacle2016;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.Retraite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import java.util.List;

public final class OutilConstitutionDateLimiteEntreeClauseRattrapageSpectacle2016
  implements IOutilConstitutionDateLimiteSpectacle
{
  private static final String NOM_OUTIL = OutilConstitutionDateLimiteEntreeClauseRattrapageSpectacle2016.class.getPackage().getName() + " / " + OutilConstitutionDateLimiteEntreeClauseRattrapageSpectacle2016.class.toString();
  private static final DureeCalendaire SIX_MOIS = new DureeCalendaire(0, 6);
  
  public static OutilConstitutionDateLimiteEntreeClauseRattrapageSpectacle2016 getInstance()
  {
    return new OutilConstitutionDateLimiteEntreeClauseRattrapageSpectacle2016();
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConstitutionDateLimiteEntreeClauseRattrapageSpectacle2016();
  }
  
  public String getNomOutil()
  {
    return NOM_OUTIL;
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    boolean estApplicable = false;
    if ((criteres.getListeContextesReglementaires() != null) && (criteres.getListeContextesReglementaires().contains("DateLimiteContexteEntreeClauseRattrapage"))) {
      estApplicable = true;
    }
    return estApplicable;
  }
  
  public DonneesSortieDateLimiteSpectacle calculerDateLimiteIndemnisation(DonneesEntreeDateLimiteSpectacle donneesEntree)
    throws ApplicativeException
  {
    DonneesSortieDateLimiteSpectacle sortie = new DonneesSortieDateLimiteSpectacle();
    JustificationDateLimiteDateLimite justification = new JustificationDateLimiteDateLimite();
    justification.setContexteDateLimite("DATE_ANNIV");
    if (donneesEntree.getDateLimiteIndemnisationForcee() == null)
    {
      Damj dateADeplacer = donneesEntree.getOutilFonctionnel().getDateLimiteIndemnisationDroitPrecedent(donneesEntree.getDateExamen());
      justification.setDatePointDepart(dateADeplacer);
      
      DureeCalendaire dureeIndemnisation = SIX_MOIS;
      justification.setDureeUtilisee(dureeIndemnisation);
      Damj dateLimite = dateADeplacer.lendemain().deplacerVersAvant(dureeIndemnisation);
      if (!dateLimite.estLaFinDuMois()) {
        dateLimite = dateLimite.veille();
      }
      dateLimite = bornerDateRetraite(dateLimite, donneesEntree);
      sortie.setDateLimiteIndemnisation(dateLimite);
    }
    else
    {
      sortie.setDateLimiteIndemnisation(donneesEntree.getDateLimiteIndemnisationForcee());
    }
    sortie.setJustification(justification);
    
    return sortie;
  }
  
  protected Damj bornerDateRetraite(Damj dateLimite, DonneesEntreeDateLimiteSpectacle donneesEntree)
    throws CoucheLogiqueException
  {
    Damj resultat = dateLimite;
    OutilRetraite outilRetraite = OutilRetraite.getInstance();
    Retraite retraite = outilRetraite.determinerRetraite(donneesEntree.getDateNaissance(), donneesEntree.getTrimestreRetraite(), donneesEntree.getDateLiquidationRetraite(), donneesEntree.getDateRetraiteAnticipee(), donneesEntree.getMotifRetraiteAnticipee());
    
    Damj dateRetraite = retraite.getDate();
    if (dateRetraite.estAvant(dateLimite)) {
      resultat = dateRetraite.veille();
    }
    return resultat;
  }
}

/* Location:
 * Qualified Name:     OutilConstitutionDateLimiteEntreeClauseRattrapageSpectacle2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
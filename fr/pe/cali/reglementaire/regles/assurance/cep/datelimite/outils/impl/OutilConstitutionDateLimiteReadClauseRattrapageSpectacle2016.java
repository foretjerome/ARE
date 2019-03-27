package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.dates.OutilGestionDates;
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

public final class OutilConstitutionDateLimiteReadClauseRattrapageSpectacle2016
  implements IOutilConstitutionDateLimiteSpectacle
{
  private static final String NOM_OUTIL = OutilConstitutionDateLimiteReadClauseRattrapageSpectacle2016.class.getPackage().getName() + " / " + OutilConstitutionDateLimiteReadClauseRattrapageSpectacle2016.class.toString();
  private static final DureeCalendaire UN_AN = new DureeCalendaire(1);
  
  public static OutilConstitutionDateLimiteReadClauseRattrapageSpectacle2016 getInstance()
  {
    return new OutilConstitutionDateLimiteReadClauseRattrapageSpectacle2016();
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    boolean estApplicable = false;
    if ((criteres.getListeContextesReglementaires() != null) && (criteres.getListeContextesReglementaires().contains("DateLimiteContexteReadeSuiteClauseRattrapage"))) {
      estApplicable = true;
    }
    return estApplicable;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConstitutionDateLimiteReadClauseRattrapageSpectacle2016();
  }
  
  public String getNomOutil()
  {
    return NOM_OUTIL;
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
      dateADeplacer = OutilGestionDates.gererVingtNeufFevrier(dateADeplacer);
      
      DureeCalendaire dureeIndemnisation = UN_AN;
      justification.setDureeUtilisee(dureeIndemnisation);
      Damj dateLimite = dateADeplacer.deplacerVersAvant(dureeIndemnisation);
      
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
  
  private Damj bornerDateRetraite(Damj dateLimite, DonneesEntreeDateLimiteSpectacle donneesEntree)
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
 * Qualified Name:     OutilConstitutionDateLimiteReadClauseRattrapageSpectacle2016
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
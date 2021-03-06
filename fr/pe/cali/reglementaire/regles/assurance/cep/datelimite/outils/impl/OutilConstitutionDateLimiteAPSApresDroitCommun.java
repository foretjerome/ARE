package fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.impl;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;
import fr.pe.cali.reglementaire.outils.dates.OutilGestionDates;
import fr.pe.cali.reglementaire.outils.retraite.impl.OutilRetraite;
import fr.pe.cali.reglementaire.outils.spec.IOutilCorpsRegle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom.DonneesEntreeDateLimiteSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom.DonneesSortieDateLimiteSpectacle;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.dom.JustificationDateLimiteDateLimite;
import fr.pe.cali.reglementaire.regles.assurance.cep.datelimite.outils.spec.IOutilConstitutionDateLimiteSpectacle;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.Retraite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;
import java.util.List;

public class OutilConstitutionDateLimiteAPSApresDroitCommun
  implements IOutilConstitutionDateLimiteSpectacle
{
  private static final String NOM_OUTIL = OutilConstitutionDateLimiteAPSApresDroitCommun.class.getPackage().getName() + " / " + OutilConstitutionDateLimiteAPSApresDroitCommun.class.toString();
  private static final DureeCalendaire UN_AN = new DureeCalendaire(1);
  
  public static OutilConstitutionDateLimiteAPSApresDroitCommun getInstance()
  {
    return new OutilConstitutionDateLimiteAPSApresDroitCommun();
  }
  
  public boolean estApplicablePourCriteres(CriteresFabriqueReglementaire criteres)
  {
    boolean estApplicable = false;
    if ((criteres.getListeContextesReglementaires() == null) || (criteres.getListeContextesReglementaires().isEmpty()) || (!criteres.getListeContextesReglementaires().contains("DateLimiteAPSDFinCRA"))) {
      estApplicable = true;
    }
    return estApplicable;
  }
  
  public IOutilCorpsRegle creerNouvelleInstance()
  {
    return new OutilConstitutionDateLimiteAPSApresDroitCommun();
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
      Damj dateDepart = donneesEntree.getDateExamen();
      DureeCalendaire dureeIndemnisation = UN_AN;
      Damj dateADeplacer = OutilGestionDates.gererVingtNeufFevrier(dateDepart);
      Damj dateLimiteInd = dateADeplacer.deplacerVersAvant(dureeIndemnisation).veille();
      dateLimiteInd = bornerDateRetraite(dateLimiteInd, donneesEntree);
      
      sortie.setDateLimiteIndemnisation(dateLimiteInd);
      justification.setDatePointDepart(dateDepart);
      justification.setDureeUtilisee(dureeIndemnisation);
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
 * Qualified Name:     OutilConstitutionDateLimiteAPSApresDroitCommun
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
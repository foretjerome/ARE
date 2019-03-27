package fr.unedic.cali.autresdoms.cohab.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.outilsfonctionnels.AppelCalcul;
import fr.unedic.cali.parcours.AccesDonneesGaecException;
import fr.unedic.cali.parcours.ParcoursServiceAbstrait;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.Resultat;

public class ParcoursValidationMigration
  extends ParcoursServiceAbstrait
{
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {
    if (getIndividu(p_contexte) == null) {
      throw new ContexteException("HG_PR_CALI_L_ERR_CTX_ABS_DEMANDEUR", "Allocataire absent du contexte, impossible de migrer les demandes de l'individu", null);
    }
  }
  
  public Resultat demarrerParcours(Contexte p_contexte)
    throws ApplicativeException
  {
    Resultat resultat = new Resultat();
    
    IndividuSpec individuMigre = getIndividu(p_contexte);
    
    int typeValidation = getTypeValidation(p_contexte);
    switch (typeValidation)
    {
    case 0: 
      annulerMigration(individuMigre);
      break;
    case 1: 
      validerMigration(individuMigre);
      break;
    }
    resultat.setEtat(0);
    return resultat;
  }
  
  private void annulerMigration(IndividuSpec p_individuMigre)
  {
    p_individuMigre.supprimer();
  }
  
  private void validerMigration(IndividuSpec p_individuMigre)
    throws ApplicativeException
  {
    AppelCalcul.effectuerCalcul(p_individuMigre, p_individuMigre.getListeAttributionsExecutables(), null, null);
  }
  
  private int getTypeValidation(Contexte p_contexte)
  {
    return ((DomMigration)p_contexte.getDonnees()).getTypeValidation();
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu p_individu)
  {
    return 0;
  }
  
  protected void alimenterAgregatGaec(Individu p_individu, String p_idDemande)
  {
    p_individu.getDonneesChargementGaec().getAgregatGaec().setModeAppel(0);
  }
  
  protected void controlerPostTraitement(Individu p_individu)
    throws AccesDonneesGaecException
  {
    controlerModeAppel(p_individu.getDonneesChargementGaec().getAppelGaecReduit(), 0);
  }
}

/* Location:
 * Qualified Name:     ParcoursValidationMigration
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
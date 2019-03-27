package fr.unedic.cali.outilsfonctionnels;

import fr.unedic.cali.autresdoms.cohab.dom.spec.TrimestreRetraiteSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.cali.dom.ElementConditionAge;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.dom.Retraite;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.OutilFonctionnel;
import fr.unedic.util.temps.Damj;
import fr.unedic.util.temps.DureeCalendaire;

public abstract class OutilConditionAge
  implements OutilFonctionnel
{
  private OutilRetraite outilRetraite = OutilRetraite.getInstance();
  
  public ElementConditionAge verifierConditionAge(IndividuSpec individu, Damj dateEffet, DemandeSpec demande)
    throws CoucheLogiqueException
  {
    ElementConditionAge elementConditionAge = new ElementConditionAge();
    
    alimenterConditionAgeMaximum(elementConditionAge, individu, dateEffet);
    
    effectuerTraitementSpecifique(elementConditionAge, individu, dateEffet, demande);
    
    return elementConditionAge;
  }
  
  public void alimenterConditionAgeMaximum(ElementConditionAge elementConditionAge, IndividuSpec individu, Damj dateEffet)
    throws CoucheLogiqueException
  {
    DureeCalendaire ageMaxDepartRetraite = getOutilRetraite().getAgeMaxDepartRetraite(individu);
    DureeCalendaire ageMinDepartRetraite = getOutilRetraite().getAgeMinDepartRetraite(individu);
    
    Retraite retraite = getOutilRetraite().determinerRetraite(individu);
    Damj dateEffetTheoriquePensionRetraite = retraite.getDate();
    
    DureeCalendaire ageADateRetraite = individu.getAgeALaDate(dateEffetTheoriquePensionRetraite);
    DureeCalendaire ageADateEffet = individu.getAgeALaDate(dateEffet);
    
    elementConditionAge.setAgeMinDepartRetraite(ageMinDepartRetraite);
    elementConditionAge.setAgeMaxDepartRetraite(ageMaxDepartRetraite);
    elementConditionAge.setDateAtteinteRetraite(dateEffetTheoriquePensionRetraite);
    elementConditionAge.setAgeADateRetraite(ageADateRetraite);
    elementConditionAge.setAgeDemandeurEmploi(ageADateEffet);
    
    controlerDateNaissance(ageADateEffet);
    if (ageADateEffet.compareTo(ageMaxDepartRetraite) >= 0)
    {
      alimenterEchecAgeSuperieurAgeMaximum(elementConditionAge);
    }
    else if ((dateEffetTheoriquePensionRetraite.estAvantOuCoincideAvec(dateEffet)) || ((ageADateEffet.compareTo(ageMinDepartRetraite) >= 0) && (ageADateEffet.compareTo(ageMaxDepartRetraite) < 0)))
    {
      controleNbTrimestreSaisi(individu);
      alimenterTrimestres(elementConditionAge, individu);
      if (dateEffetTheoriquePensionRetraite.estAvantOuCoincideAvec(dateEffet)) {
        if (retraite.estTypeAnticipe()) {
          alimenterEchecDateRetraiteAnticipeeAtteinte(elementConditionAge);
        } else {
          alimenterEchecDateRetraiteAtteinte(elementConditionAge);
        }
      }
    }
    else
    {
      alimenterConditionSatisfaite(elementConditionAge);
    }
  }
  
  private void alimenterTrimestres(ElementConditionAge elementConditionAge, IndividuSpec individu)
  {
    if ((individu.getTrimestreRetraite() != null) && (individu.getTrimestreRetraite().getNombreTrimestre() != null))
    {
      int nombreTrimestreAquis = individu.getTrimestreRetraite().getNombreTrimestre().intValue();
      elementConditionAge.setNbTrimestre(nombreTrimestreAquis);
    }
  }
  
  public void controleNbTrimestreSaisi(IndividuSpec individu)
    throws CoucheLogiqueException
  {
    if (!outilRetraite.estNbTrimestresSaisiOuDateRetraiteForcee(individu))
    {
      String ageMax = outilRetraite.formaterAge(outilRetraite.getAgeMinDepartRetraite(individu));
      GestionnaireErreur.getInstance().genererException("HG_PR_CALI_L_ALERTE_A11MB6_ABSENCE_TRIMESTRES", new Object[] { ageMax }, 1);
    }
  }
  
  private void controlerDateNaissance(DureeCalendaire ageADateEffet)
    throws CoucheLogiqueException
  {
    if (ageADateEffet == null) {
      GestionnaireErreur.getInstance().genererCoucheLogiqueException("HG_SC_L_ES_ED_COD06_ABSENCE_AGE_DEMANDEUR_DOD");
    }
  }
  
  protected abstract void effectuerTraitementSpecifique(ElementConditionAge paramElementConditionAge, IndividuSpec paramIndividuSpec, Damj paramDamj, DemandeSpec paramDemandeSpec)
    throws CoucheLogiqueException;
  
  protected abstract void alimenterEchecAgeSuperieurAgeMaximum(ElementConditionAge paramElementConditionAge)
    throws CoucheLogiqueException;
  
  protected abstract void alimenterEchecDateRetraiteAtteinte(ElementConditionAge paramElementConditionAge)
    throws CoucheLogiqueException;
  
  protected abstract void alimenterEchecDateRetraiteAnticipeeAtteinte(ElementConditionAge paramElementConditionAge)
    throws CoucheLogiqueException;
  
  protected void alimenterConditionSatisfaite(ElementConditionAge elementConditionAge)
  {
    elementConditionAge.setEtat(0);
  }
  
  protected void alimenterConditionNonSatisfaite(ElementConditionAge elementConditionAge, int codeMotifEchec)
  {
    elementConditionAge.setEtat(1);
    elementConditionAge.setCodeMotifEchec(codeMotifEchec);
  }
  
  public OutilRetraite getOutilRetraite()
  {
    return outilRetraite;
  }
}

/* Location:
 * Qualified Name:     OutilConditionAge
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
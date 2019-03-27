package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.AgregatGaec;
import fr.unedic.cali.dom.DonneesChargementGaec;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.Chronologie;
import java.util.ArrayList;
import java.util.Collection;

public class ParcoursComSidListerAides
  extends ParcoursServiceAbstrait
{
  public Resultat demarrerParcours(Contexte contexte)
    throws ApplicativeException
  {
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Début Parcours ComSidListerAides ********\n");
    }
    ResultatComSidListerAides resultatComSidListerAides = new ResultatComSidListerAides();
    
    resultatComSidListerAides.setEtat(1);
    
    DomComSidListerAides domComSidListerAides = (DomComSidListerAides)contexte.getDonnees();
    IndividuSpec individu = domComSidListerAides.getIndividu();
    
    resultatComSidListerAides.setChronoDemandesAides(getDemandesAidesDe(individu));
    if (Log.isTraceActive(getClass(), Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, getClass(), "demarrer", "\t\t******** Fin Parcours ComSidListerAides ********\n");
    }
    resultatComSidListerAides.setEtat(0);
    
    return resultatComSidListerAides;
  }
  
  protected int getModeChargementDebrayageDossiersLourds(Individu individu)
  {
    return 2;
  }
  
  protected void alimenterAgregatGaec(Individu individu, String idDemande)
  {
    Collection typePeriodesGaec = new ArrayList();
    AgregatGaec agregat = individu.getDonneesChargementGaec().getAgregatGaec();
    int modeAppel = 0;
    modeAppel = Math.max(modeAppel, determinerModeAppelEtTypesPeriodes(individu, typePeriodesGaec));
    agregat.setModeAppel(modeAppel);
    if (modeAppel == 1) {
      agregat.setTypePeriodesGaec(typePeriodesGaec);
    }
  }
  
  protected void controlerPostTraitement(Individu individu)
    throws AccesDonneesGaecException
  {
    Collection typePeriodesGaecAttendu = new ArrayList();
    AgregatGaec agregat = individu.getDonneesChargementGaec().getAgregatGaec();
    int modeAppel = 0;
    
    modeAppel = Math.max(modeAppel, determinerModeAppelEtTypesPeriodes(individu, typePeriodesGaecAttendu));
    if (modeAppel == 1) {
      controlerTypesPeriodes(modeAppel, agregat.getTypePeriodesGaec(), typePeriodesGaecAttendu);
    }
    DonneesChargementGaec donneesChargementGaec = individu.getDonneesChargementGaec();
    controlerModeAppel(donneesChargementGaec.getAppelGaecReduit(), 1);
  }
  
  private Chronologie getDemandesAidesDe(IndividuSpec individu)
  {
    return individu.getChronoDemandes();
  }
}

/* Location:
 * Qualified Name:     ParcoursComSidListerAides
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
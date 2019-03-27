package fr.unedic.cali.parcours;

import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.CoucheLogiqueException;
import fr.unedic.util.services.Resultat;
import fr.unedic.util.temps.ChronologieDebuts;

public class LireSyntheseDemande
  extends RechercherDemandeParMultiCritere
{
  public Resultat demarrerParcours(Contexte p_contexte)
    throws CoucheLogiqueException
  {
    ResultatRechercherDemandeParMultiCritere resultatRechercherDemandeParMultiCritere = new ResultatRechercherDemandeParMultiCritere();
    
    resultatRechercherDemandeParMultiCritere.setEtat(1);
    if (Log.isTraceActive(LireSyntheseDemande.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, LireSyntheseDemande.class, "demarrer", "\t\t******** Début Parcours LireSyntheseDemande ********\n");
    }
    IndividuSpec individuCali = getIndividu(p_contexte);
    
    ChronologieDebuts chronoDemandes = new ChronologieDebuts();
    chronoDemandes.ajouter(individuCali.getChronoDemandes());
    resultatRechercherDemandeParMultiCritere.setChronoDemandes(chronoDemandes);
    resultatRechercherDemandeParMultiCritere.setEtat(0);
    if (Log.isTraceActive(LireSyntheseDemande.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, LireSyntheseDemande.class, "demarrer", "\t\t******** Résultat Parcours LireSyntheseDemande ********\n" + resultatRechercherDemandeParMultiCritere);
    }
    if (Log.isTraceActive(LireSyntheseDemande.class, Niveau.DEBUG)) {
      Log.ecritTrace(Niveau.DEBUG, LireSyntheseDemande.class, "demarrer", "\t\t******** Fin Parcours LireSyntheseDemande ********\n");
    }
    return resultatRechercherDemandeParMultiCritere;
  }
}

/* Location:
 * Qualified Name:     LireSyntheseDemande
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
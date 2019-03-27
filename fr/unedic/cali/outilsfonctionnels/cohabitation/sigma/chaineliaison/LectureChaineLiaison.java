package fr.unedic.cali.outilsfonctionnels.cohabitation.sigma.chaineliaison;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.spec.CriteresChaineLiaisonSpec;
import fr.unedic.cali.autresdoms.cohab.sigma.chaineliaison.dom.spec.ResultatChaineLiaisonSpec;

public class LectureChaineLiaison
{
  public ResultatChaineLiaisonSpec lireChaineLiaison(CriteresChaineLiaisonSpec criteres)
    throws ApplicativeException, TechniqueException
  {
    long startTime = System.currentTimeMillis();
    
    ResultatChaineLiaisonSpec resultat = getOutilFonctionnel().lireChaineLiaison(criteres);
    
    long endTime = System.currentTimeMillis();
    if (Log.isTraceActive(LectureChaineLiaison.class, Niveau.INFO)) {
      Log.ecritTrace(Niveau.INFO, LectureChaineLiaison.class, "invoqueService", "Temps d'execution du service " + LectureChaineLiaison.class.getName() + " = " + (endTime - startTime) + " ms");
    }
    return resultat;
  }
  
  public AppelV1ChaineLiaison getOutilFonctionnel()
  {
    return new AppelV1ChaineLiaison();
  }
}

/* Location:
 * Qualified Name:     LectureChaineLiaison
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
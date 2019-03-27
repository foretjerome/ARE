package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.archi.util.trace.Log;
import fr.unedic.archi.util.trace.Niveau;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.ContexteService;
import fr.unedic.util.services.Parcours;
import fr.unedic.util.services.Resultat;

public abstract class ParcoursCali
  extends Parcours
{
  public abstract Resultat demarrer(Contexte paramContexte)
    throws ApplicativeException;
  
  public void controlerContexte(Contexte p_contexte)
    throws ContexteException
  {}
  
  public IndividuSpec getIndividu(Contexte p_contexte)
  {
    DomCali domCali = (DomCali)p_contexte.getDonnees();
    return domCali.getIndividu();
  }
  
  public ContexteService getContexteService(Contexte p_contexte)
  {
    DomCali domCali = (DomCali)p_contexte.getDonnees();
    return domCali.getContexteService();
  }
  
  protected void ecrireTrace(Niveau p_niveau, String p_methode, String p_libelle)
  {
    if (Log.isTraceActive(getClass(), p_niveau)) {
      Log.ecritTrace(p_niveau, getClass(), p_methode, p_libelle);
    }
  }
}

/* Location:
 * Qualified Name:     ParcoursCali
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
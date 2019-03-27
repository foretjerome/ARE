package fr.unedic.cali.autresdoms.d90.dom.spec;

import fr.unedic.archi.commun.exception.TechniqueException;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.d90.dom.InfoReexecution;
import fr.unedic.cali.dom.Individu;
import fr.unedic.cali.dom.IndividuSpec;
import fr.unedic.cali.parcours.ParcoursPopulationSpec;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.temps.Damj;

public abstract interface PopulationSpec
{
  public static final Damj DATE_LIMITE_NON_REEXECUTION = new Damj(2014, 4, 1);
  public static final Damj DATE_LIMITE_NON_REEXECUTION_VNR = new Damj(2009, 4, 1);
  
  public abstract int getId();
  
  public abstract ComportementSpec getComportement();
  
  public abstract String getLibelle();
  
  public abstract InfoReexecution estAReexecuter(Contexte paramContexte)
    throws ApplicativeException;
  
  public abstract InfoReexecution estUnIndividuReexecutable(IndividuSpec paramIndividuSpec, Damj paramDamj)
    throws ApplicativeException;
  
  public abstract ParcoursPopulationSpec getParcours();
  
  public abstract void chargerIndividu(Individu paramIndividu)
    throws ApplicativeException, TechniqueException;
  
  public abstract boolean isEstAffichableIhmVisu();
}

/* Location:
 * Qualified Name:     PopulationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
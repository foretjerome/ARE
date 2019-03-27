package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.ContexteException;
import fr.unedic.util.services.Resultat;

public abstract interface ParcoursService
{
  public abstract void controlerContexte(Contexte paramContexte)
    throws ContexteException;
  
  public abstract Resultat demarrer(Contexte paramContexte)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     ParcoursService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
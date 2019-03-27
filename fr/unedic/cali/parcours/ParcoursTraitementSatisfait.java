package fr.unedic.cali.parcours;

import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.util.services.Contexte;
import fr.unedic.util.services.Resultat;

public class ParcoursTraitementSatisfait
  extends ParcoursCali
{
  public Resultat demarrer(Contexte p_contexte)
    throws ApplicativeException
  {
    return new Resultat(0);
  }
}

/* Location:
 * Qualified Name:     ParcoursTraitementSatisfait
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.occasionnel.outilsfonctionnels;

import fr.unedic.archi.logique.exception.ApplicativeException;

public abstract interface TraitementPopulationSpec
{
  public abstract ResultatTraitementPopulation effectuerTraitement(CriteresTraitementPopulation paramCriteresTraitementPopulation)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     TraitementPopulationSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
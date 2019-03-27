package fr.pe.cali.reglementaire.outils.spec;

import fr.pe.cali.reglementaire.dom.impl.CriteresFabriqueReglementaire;

public abstract interface IOutilCorpsRegle
{
  public abstract boolean estApplicablePourCriteres(CriteresFabriqueReglementaire paramCriteresFabriqueReglementaire);
  
  public abstract IOutilCorpsRegle creerNouvelleInstance();
  
  public abstract String getNomOutil();
}

/* Location:
 * Qualified Name:     IOutilCorpsRegle
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilFonctionnel;
import fr.pe.cali.reglementaire.regles.assurance.cep.delaisreports.dom.EtatDifferePrecedent;

public abstract interface IOutilFonctionnelRechercheDiffere
  extends IOutilFonctionnel
{
  public abstract EtatDifferePrecedent rechercherEtatDifferePrecedent();
}

/* Location:
 * Qualified Name:     IOutilFonctionnelRechercheDiffere
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
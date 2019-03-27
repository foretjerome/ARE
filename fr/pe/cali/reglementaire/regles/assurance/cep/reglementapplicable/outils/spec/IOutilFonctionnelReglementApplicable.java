package fr.pe.cali.reglementaire.regles.assurance.cep.reglementapplicable.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilFonctionnel;
import fr.unedic.archi.logique.exception.ApplicativeException;
import fr.unedic.cali.autresdoms.ga.dom.ActiviteSalarie;
import fr.unedic.util.temps.Chronologie;

public abstract interface IOutilFonctionnelReglementApplicable
  extends IOutilFonctionnel
{
  public abstract boolean estActiviteRG5(ActiviteSalarie paramActiviteSalarie);
  
  public abstract boolean estProduitValiditeAvecActiviteRG5(Chronologie paramChronologie)
    throws ApplicativeException;
}

/* Location:
 * Qualified Name:     IOutilFonctionnelReglementApplicable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
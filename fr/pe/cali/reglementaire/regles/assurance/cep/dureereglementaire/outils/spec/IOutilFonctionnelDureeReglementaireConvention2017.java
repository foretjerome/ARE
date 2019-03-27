package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.spec;

import fr.pe.cali.reglementaire.outils.spec.IOutilFonctionnel;
import java.math.BigDecimal;

public abstract interface IOutilFonctionnelDureeReglementaireConvention2017
  extends IOutilFonctionnel
{
  public abstract BigDecimal determinerDureeImputationFormationDroitCourant(BigDecimal paramBigDecimal);
}

/* Location:
 * Qualified Name:     IOutilFonctionnelDureeReglementaireConvention2017
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
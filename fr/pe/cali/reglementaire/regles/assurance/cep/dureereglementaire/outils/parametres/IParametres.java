package fr.pe.cali.reglementaire.regles.assurance.cep.dureereglementaire.outils.parametres;

import fr.unedic.util.UniteAffiliation;
import java.math.BigDecimal;
import java.util.List;

public abstract interface IParametres
{
  public abstract List<UniteAffiliation> getUnitesPourReglement(String paramString);
  
  public abstract BigDecimal getPlancher();
}

/* Location:
 * Qualified Name:     IParametres
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
package fr.unedic.cali.outilsfonctionnels.reexecution;

import fr.unedic.cali.autresdoms.d90.dom.Individu;
import fr.unedic.cali.dom.AttributionSpec;
import fr.unedic.cali.dom.DemandeSpec;
import fr.unedic.util.temps.Damj;
import java.util.Collection;

public abstract interface ResultatGestionnaireReexecutionSpec
{
  public abstract Collection<DemandeSpec> getDemandesReliquidees();
  
  public abstract Collection<AttributionSpec> getAttributionsReexecutees();
  
  public abstract Individu getIndividuVisu();
  
  public abstract Damj getDateReexecution();
  
  public abstract boolean isDemandeEnReexamen();
}

/* Location:
 * Qualified Name:     ResultatGestionnaireReexecutionSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
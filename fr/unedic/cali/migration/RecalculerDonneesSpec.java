package fr.unedic.cali.migration;

import fr.unedic.cali.dom.DemandeSpec;
import java.util.Collection;

public abstract interface RecalculerDonneesSpec
{
  public abstract Collection recalculer(DemandeSpec paramDemandeSpec);
}

/* Location:
 * Qualified Name:     RecalculerDonneesSpec
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
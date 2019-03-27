package fr.unedic.cali.occasionnel;

import fr.unedic.util.services.batch.ParcoursOccasionnelAbstrait;
import fr.unedic.util.services.batch.TBOccasionnelSpec;

public class ParcoursSelectionOccasionnel
  extends ParcoursOccasionnelAbstrait
{
  protected TBOccasionnelSpec creerTraitement(String p_nomTraitement)
  {
    return new TBSelectionOccasionnel();
  }
}

/* Location:
 * Qualified Name:     ParcoursSelectionOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
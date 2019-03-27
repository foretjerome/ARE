package fr.unedic.cali.occasionnel;

import fr.unedic.util.services.batch.ParcoursOccasionnelAbstrait;
import fr.unedic.util.services.batch.TBOccasionnelSpec;

public class ParcoursOccasionnel
  extends ParcoursOccasionnelAbstrait
{
  protected TBOccasionnelSpec creerTraitement(String p_nomTraitement)
  {
    TBOccasionnelSpec traitement = null;
    if (p_nomTraitement != null)
    {
      if (p_nomTraitement.equals("LiqCategorieEmploi")) {
        traitement = new TBCategorieEmploi();
      }
      if (p_nomTraitement.equals("SelectionTestProduction")) {
        traitement = new TBSelectionTestProduction();
      }
      if (p_nomTraitement.equals("SelectionCourrierDalAss")) {
        traitement = new TBCourrierDalAss();
      }
    }
    return traitement;
  }
}

/* Location:
 * Qualified Name:     ParcoursOccasionnel
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
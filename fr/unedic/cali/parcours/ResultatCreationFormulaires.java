package fr.unedic.cali.parcours;

import fr.unedic.util.services.Resultat;
import java.util.Collection;

public class ResultatCreationFormulaires
  extends Resultat
{
  private Collection m_collectionFormulairesCali;
  
  public Collection getCollectionFormulairesCali()
  {
    return m_collectionFormulairesCali;
  }
  
  public void setCollectionFormulairesCali(Collection p_collection)
  {
    m_collectionFormulairesCali = p_collection;
  }
}

/* Location:
 * Qualified Name:     ResultatCreationFormulaires
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
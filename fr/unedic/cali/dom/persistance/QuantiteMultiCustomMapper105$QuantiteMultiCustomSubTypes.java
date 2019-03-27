package fr.unedic.cali.dom.persistance;

import java.util.HashMap;
import java.util.Map;
import xcalia.lido.api.ds.CompositeTypeDefinition;

public class QuantiteMultiCustomMapper105$QuantiteMultiCustomSubTypes
  implements CompositeTypeDefinition
{
  public Map getStorageTypes()
  {
    Map types = new HashMap();
    types.put("{exists}", QuantiteMultiCustomMapper105.ExistsCustomDatabaseTypeDefinition.class);
    types.put("{valeur}", QuantiteMultiCustomMapper105.ValeurCustomDatabaseTypeDefinition.class);
    types.put("{unite}", QuantiteMultiCustomMapper105.UniteCustomDatabaseTypeDefinition.class);
    return types;
  }
}

/* Location:
 * Qualified Name:     QuantiteMultiCustomMapper105.QuantiteMultiCustomSubTypes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */
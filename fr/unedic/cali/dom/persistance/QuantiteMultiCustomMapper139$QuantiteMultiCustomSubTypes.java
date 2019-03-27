package fr.unedic.cali.dom.persistance;

import java.util.HashMap;
import java.util.Map;
import xcalia.lido.api.ds.CompositeTypeDefinition;

public class QuantiteMultiCustomMapper139$QuantiteMultiCustomSubTypes
  implements CompositeTypeDefinition
{
  public Map getStorageTypes()
  {
    Map types = new HashMap();
    types.put("{exists}", QuantiteMultiCustomMapper139.ExistsCustomDatabaseTypeDefinition.class);
    types.put("{valeur}", QuantiteMultiCustomMapper139.ValeurCustomDatabaseTypeDefinition.class);
    types.put("{unite}", QuantiteMultiCustomMapper139.UniteCustomDatabaseTypeDefinition.class);
    return types;
  }
}

/* Location:
 * Qualified Name:     QuantiteMultiCustomMapper139.QuantiteMultiCustomSubTypes
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */